/**
 * 파일명   : PgGrMgrCmd.java 
 * 설명     : 리스트 cmd  
 * 이력사항
 * CH00     :2006/05/27 김경덕 최초작성 
 */

package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import sp.sys.SysParam;
import sp.sys.SysWorker;

public class PgGrMgrCmd implements KJFCommand {


	private String next;
	
    public PgGrMgrCmd() {
    }
    
    public PgGrMgrCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	
        //검색조건 및 초기데이타 로드
        loadCondition(request);
        
        //검색조건 설정및 체크
        SysParam pm = checkPm(request, form);
        
        //리스트 로드
        loadList(request, pm);
        
        
        return next;
    }
    
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	
    	String sql="SELECT PG_GROUP_ID, GROUP_NAME " +
    			   " FROM   PT_PG_GROUP  ORDER BY GROUP_NAME";
    	
        Vector v_p_group_id 	= new Vector();
        v_p_group_id = KJFSelectOPS.getSel(sql, "0","상위메뉴 없음");
        request.setAttribute("v_p_group_id", v_p_group_id);        
       
    }//end loadCondition


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{

    	SysParam pm = (SysParam)form;

        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm

 
    
    
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
    	
    	
    	SysWorker worker =new SysWorker();
        //메뉴그룹가져옴
        Vector v_menuEntList = new Vector();
        v_menuEntList = worker.getMenuGrEntList("0");
        request.setAttribute("v_menuEntList", v_menuEntList);    	
        




    }//end loadList  
    
    
    
    


}