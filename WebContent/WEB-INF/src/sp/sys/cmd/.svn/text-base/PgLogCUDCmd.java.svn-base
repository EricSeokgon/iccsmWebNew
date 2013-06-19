/**
 * 파일명   : ComCodeMgrCUDCmd.java 
 * 설명     : CUD cmd  
 * 이력사항
 * CH00     : 2006/09/26 양석환 최초작성 
 */

package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_SM_PROGRAM_LOGDAO;
import sp.dao.PT_SM_PROGRAM_LOGEntity;
import sp.uent.UserEnt;


public class PgLogCUDCmd implements KJFCommand {
	
	PT_SM_PROGRAM_LOGDAO    PT_SM_PROGRAM_LOGdao = new PT_SM_PROGRAM_LOGDAO();
	PT_SM_PROGRAM_LOGEntity PT_SM_PROGRAM_LOGent = new PT_SM_PROGRAM_LOGEntity();

	private String next;
	
    public PgLogCUDCmd() {
    }
    
    public PgLogCUDCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String mode = request.getParameter("mode");
    	PT_SM_PROGRAM_LOGent.setRequestOnlyString(request); 	// request 값들 자동 세팅
    	KJFLog.debug(PT_SM_PROGRAM_LOGent.toString()); 		// 세팅된 값들 확인
    	
    	if(mode.equals("C")) { 			// 입력
    		insertExe(request);
    	} else if (mode.equals("U")) { // 수정
    		updateExe(request);
    	} else if (mode.equals("D")) { // 삭제
    		deleteExe(request);
    	}
              
        return next;
    }

    /**
     * 입력
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{

    	ReportDAO rDAO 	= new ReportDAO();
    	UserEnt user = (UserEnt)request.getSession().getAttribute("user");
    	
    	String sql     	= "SELECT IFNULL(MAX(CAST(LOG_NUM AS UNSIGNED)),0)+1 MAXSEQ FROM PT_SM_PROGRAM_LOG  \n";
    	String SEQ     	= rDAO.select(sql).getValue(0,"MAXSEQ");
    	String date    	= KJFDate.datetimeOnly(KJFDate.getCurTime());
    	String pgID		= request.getParameter("titPgId");
    	String cmd		= request.getParameter("cmd");
    	String mode		= request.getParameter("mode");
    	String reqURI	= request.getRequestURI() + "?" + request.getQueryString();
    	String userData	= KJFUtil.reportParameters(request) ;   	
    	
    	String sql1     	= "SELECT USER_CODE FROM PT_USER WHERE USER_ID='" + user.getUSER_ID() + "'  \n";
    	String user_code    = rDAO.select(sql1).getValue(0,"USER_CODE");
    	
    	PT_SM_PROGRAM_LOGent.setLOG_NUM(SEQ);
    	PT_SM_PROGRAM_LOGent.setUSER_CODE(user_code);
    	PT_SM_PROGRAM_LOGent.setACCESS_TIME(date);	// 접속 시간.
    	PT_SM_PROGRAM_LOGent.setPROGRAM_ID(pgID);
    	PT_SM_PROGRAM_LOGent.setUSER_ACTION(cmd);	// 접속 IP.
    	PT_SM_PROGRAM_LOGent.setREQ_URI(reqURI);
    	PT_SM_PROGRAM_LOGent.setUSER_DATA(userData.trim());

    	PT_SM_PROGRAM_LOGdao.insert(PT_SM_PROGRAM_LOGent);
    	
    } 

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
    	
    	PT_SM_PROGRAM_LOGdao.update(PT_SM_PROGRAM_LOGent);        
       
    } 
    
    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{

    	String[] str	= request.getParameterValues("chk");
    	String[] value  = null;
    	
    	for(int i = 0; i < str.length; i++){
    		value = str[i].split(",");
    		PT_SM_PROGRAM_LOGent.setLOG_NUM(value[0]);
       		PT_SM_PROGRAM_LOGdao.delete(PT_SM_PROGRAM_LOGent);
    	}
    } 
    
}