/**
 * 파일명   : BbsKCmd.java 
 * 설명     : BbsK  cmd  
 * 이력사항
 * CH00     :2006/05/27 김경덕 최초작성 
 */

package sp.sys.cmd;


import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.util.KJFDate;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;

public class ComCodeMgrPCmd implements KJFCommand {
	

	private String next;
	
    public ComCodeMgrPCmd() {
    }
    
    public ComCodeMgrPCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String cmd = KJFUtil.print(request.getParameter("cmd"));
    	
		//검색조건 설정및 체크
    	SysParam pm = checkPm(request, form);
        
        request.setAttribute("pm", pm);
    	
    	//검색조건 및 초기데이타 로드
        loadCondition(request);  
            
        
    	return next;
    }
    
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	String sql=" SELECT   P_CODE, CODE_NAME " +
		   " FROM     PT_COM_CODE     " +
		   " WHERE    CODE = '000'  " +
		   " ORDER BY P_CODE            ";

		Vector v_code_group = new Vector();
		
		v_code_group = KJFSelectOPS.getSel(sql, "%","   전체     ");		
		request.setAttribute("v_sc_code_group", v_code_group);  
       
    }//end loadCondition
    
    


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	SysParam pm = (SysParam)form;
    	
    		
    	//파라미터 디버깅

    	//KJFLog.debug(pm.toString(request));
 
        return pm;

    }//end checkPm
        
    
}