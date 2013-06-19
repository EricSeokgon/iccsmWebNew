/**
 * 파일명   : BbsControlCmd.java 
 * 설명     : 보드관리 cmd  
 * 이력사항
 * CH00     :2006/07/4 오두식 최초작성 
 */
package sp.user.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFSelect;
import kjf.util.KJFUtil;
import kjf.util.MsgException;
import sp.user.UserParam;


public class UserIDCheckCmd implements KJFCommand {

	private String next;
	
    public UserIDCheckCmd() {
    }
    
    public UserIDCheckCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        //검색조건 설정및 체크
        UserParam pm = checkPm(request, form);
        
        //리스트 로드
	    if(isUserID(request, pm)){
	    	request.setAttribute("isUserID","Y");
	    }else{
	    	request.setAttribute("isUserID","N");
	    }
	    request.setAttribute("pm", pm);
	    
        return next;
    }
    


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private UserParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	UserParam pm = (UserParam)form;
    	
    	pm.setScUSER_ID(request.getParameter("USER_ID"));


        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm


    
    
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, UserParam
     * @return
     */
    private boolean isUserID(HttpServletRequest request, UserParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String orderSQL 		 = "";
        boolean isRegistered		 = false; 				

        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                     									\n"+ 
        	"			count(*) as CNT      								\n";
 


        String fromSQL=
            "FROM                          									\n"+
            "    PT_USER							                  	\n";


        String whereSQL = "";

        
        if (KJFUtil.isEmpty(pm.getScUSER_ID()) ) {
            throw new MsgException("검색할 아이디를 입력해 주십시오.");
        }
        else{
        	whereSQL +=
        		"  WHERE USER_ID=LOWER('" + pm.getScUSER_ID() + "')" +
        		" OR USER_ID=UPPER('" + pm.getScUSER_ID() + "') \n";
        }
        

        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
        
        if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0)
        	isRegistered = true;

        return isRegistered;
    }//end loadList   
    
    
    
    


}