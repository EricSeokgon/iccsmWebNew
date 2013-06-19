package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.sys.SysWorker;
import kjf.action.KJFCommand;
import kjf.util.KJFLog;

public class AuthPgMgrLCmd implements KJFCommand {
	
	private String next;
	
    public AuthPgMgrLCmd() {
    }
    
    public AuthPgMgrLCmd(String next_url) {
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
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);
        
        SysWorker worker = new SysWorker();
        request.setAttribute("v_menuEntList", worker.getAuthPgMenuEntList(pm.getScAUTH_GROUP_CODE()));
        
    }//end loadList  

}
