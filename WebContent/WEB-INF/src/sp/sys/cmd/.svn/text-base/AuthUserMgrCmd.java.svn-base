package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.sys.SysWorker;

public class AuthUserMgrCmd implements KJFCommand {
    
	private String next;
	
    public AuthUserMgrCmd() {
    }
    
    public AuthUserMgrCmd(String next_url) {
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
    	//나중에 다시..확인
    	String sql = "SELECT USER_ID, USER_NAME   FROM PT_USER   ORDER BY USER_NAME";

		Vector v_code_group 	= new Vector();
		
		v_code_group = KJFSelectOPS.getSel(sql);
		request.setAttribute("v_user_id", v_code_group);  
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
	    ReportDAO    rDAO    = new ReportDAO();
	    
	    ReportEntity rEntity = null;
	    
	    String sql = "SELECT USER_ID, USER_NAME , CAPITAL  FROM PT_USER   ORDER BY  USER_NAME";
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);
        if(pm.getScUSER_ID() == null ){
		    rEntity = rDAO.select(sql);	       
		    pm.setScUSER_ID(rEntity.getValue(0, "USER_ID"));
        }
        
        /********************페이징 관련*****************************/
        //페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
             pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
       
        return pm;
    }//end checkPm
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
        SysWorker worker = new SysWorker();
        request.setAttribute("v_menuEntList", worker.getMenuEntList("0"));
        
        request.setAttribute("pm", pm); 
    }//end loadList
}
