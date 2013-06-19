package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.sys.SysWorker;
import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;

public class AuthUserMgrLCmd implements KJFCommand {
	
	private String next;
	
    public AuthUserMgrLCmd() {
    }
    
    public AuthUserMgrLCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        //검색조건 설정및 체크
        SysParam pm = checkPm(request, form);
        //리스트 로드
        loadList(request, pm);
        
        return next;
    }
    
    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	SysParam pm = (SysParam)form;

        ReportDAO    rDAO    = new ReportDAO();        
        ReportEntity rEntity = null;
        
        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));
        
        if(pm.getScUSER_ID() != null ){
                String sql  = " SELECT  PT_B.AUTH_GROUP_CODE,PT_B.AUTH_GROUP_NAME \n"+
                                  "   FROM PT_USER PT_A, PT_AUTH_GROUP PT_B \n"+
                                  "   WHERE (PT_A.CAPITAL = PT_B.AUTH_GROUP_CODE ) AND USER_ID = '" + pm.getScUSER_ID()+ "'";
                rEntity = rDAO.select(sql);                
                pm.setScAUTH_GROUP_CODE(rEntity.getValue(0, "AUTH_GROUP_CODE"));
                pm.setScAUTH_GROUP_CODE_NAME(rEntity.getValue(0, "AUTH_GROUP_NAME"));                
        }
        
        return pm;
    }//end checkPm
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
        /****** 검색조건 초기값 ***********/
                
        request.setAttribute("pm", pm);
        
        SysWorker worker = new SysWorker();
        request.setAttribute("v_menuEntList", worker.getAuthUserMenuEntList(pm.getScUSER_ID()));
        
    }//end loadList 

}
