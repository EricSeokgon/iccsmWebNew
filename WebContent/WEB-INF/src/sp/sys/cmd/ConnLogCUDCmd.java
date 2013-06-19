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

import sp.dao.PT_SM_USER_LOGDAO;
import sp.dao.PT_SM_USER_LOGEntity;


public class ConnLogCUDCmd implements KJFCommand {
	
	PT_SM_USER_LOGDAO    PT_SM_USER_LOGdao = new PT_SM_USER_LOGDAO();
	PT_SM_USER_LOGEntity PT_SM_USER_LOGent = new PT_SM_USER_LOGEntity();

	private String next;
	
    public ConnLogCUDCmd() {
    }
    
    public ConnLogCUDCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String mode = request.getParameter("mode");
    	PT_SM_USER_LOGent.setRequestOnlyString(request); 	// request 값들 자동 세팅
    	KJFLog.debug(PT_SM_USER_LOGent.toString()); 		// 세팅된 값들 확인
    	
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

    	ReportDAO rDAO = new ReportDAO();
    	String sql     = "SELECT IFNULL(MAX(CAST(LOG_NUM AS UNSIGNED)),0)+1 MAXSEQ FROM PT_SM_USER_LOG  \n";
    	String SEQ     = rDAO.select(sql).getValue(0,"MAXSEQ");
    	String date    = KJFDate.datetimeOnly(KJFDate.getCurTime());
    	String userIP  = request.getRemoteAddr();
    	
    	PT_SM_USER_LOGent.setLOG_NUM(SEQ);
    	PT_SM_USER_LOGent.setACCESS_TIME(date);	// 접속 시간.
    	PT_SM_USER_LOGent.setACCESS_IP(userIP);	// 접속 IP.
    	PT_SM_USER_LOGent.setBROWSER((PT_SM_USER_LOGent.getBROWSER()).length()>128?KJFUtil.getTitleLimit(PT_SM_USER_LOGent.getBROWSER(),120):PT_SM_USER_LOGent.getBROWSER());
    	PT_SM_USER_LOGdao.insert(PT_SM_USER_LOGent);
    } 

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
    	
    	PT_SM_USER_LOGdao.update(PT_SM_USER_LOGent);        
       
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
    		PT_SM_USER_LOGent.setLOG_NUM(value[0]);
       		PT_SM_USER_LOGdao.delete(PT_SM_USER_LOGent);
    	}
    } 
    
}