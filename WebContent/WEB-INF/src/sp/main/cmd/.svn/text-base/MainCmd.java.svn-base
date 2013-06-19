/**
 * 파일명   : BbsControlCmd.java 
 * 설명     : 보드관리 cmd  
 * 이력사항
 * CH00     :2006/07/4 오두식 최초작성 
 */
package sp.main.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFSelect;
import kjf.util.KJFUtil;
import kjf.util.MsgException;
import sp.main.MainParam;


public class MainCmd implements KJFCommand {


    public MainCmd() {
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        //검색조건 설정및 체크
        MainParam pm = checkPm(request, form);
        
        //리스트 로드
        loadSchedule(request,pm);
        
	    request.setAttribute("pm", pm);
	    
        return request.getParameter("cmd");
    }
    


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MainParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	MainParam pm = (MainParam)form;
    	

    	if(KJFUtil.isEmpty(pm.getScMonth())){
    		pm.setScMonth(KJFDate.getCurTime("yyyy-mm"));
    	}
        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm


    
    
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, MainParam
     * @return
     */
    private void loadSchedule(HttpServletRequest request, MainParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                     									\n"+ 
        	"			COUR_NAME||' ('||EDU_QUOTA||'명)' COUR_NAME,     			\n" +
        	"			DATE_FORMAT(DATE_FORMAT(ENTR_DATE,'%Y-%m-%d'),'%Y/%m/%d')||'~'||DATE_FORMAT(DATE_FORMAT(END_DATE,'%Y-%m-%d'),'%m/%d') PERIOD	\n";
 
        String fromSQL=
            "FROM                          									\n"+
            "    PT_EP_COUR_INFO							                  	\n";


        String whereSQL = "						\n " +
        		"WHERE 				\n" +
        		"			ENTR_DATE LIKE '" + pm.getScMonth() + "%'      \n";

               
        String orderSQL = "ORDER BY ENTR_DATE DESC		\n";			

        
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
        
        request.setAttribute("rEntity", rEntity);
    }//end loadList   
    
    
    
    


}