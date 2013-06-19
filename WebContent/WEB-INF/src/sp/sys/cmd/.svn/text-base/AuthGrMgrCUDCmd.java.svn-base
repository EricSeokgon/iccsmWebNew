package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_AUTH_GROUPDAO;
import sp.dao.PT_AUTH_GROUPEntity;
import sp.sys.SysParam;
import sp.sys.SysWorker;

public class AuthGrMgrCUDCmd implements KJFCommand {
	
	PT_AUTH_GROUPEntity  PT_AUTH_GROUPent = new PT_AUTH_GROUPEntity();
	PT_AUTH_GROUPDAO     PT_AUTH_GROUPdao = new PT_AUTH_GROUPDAO();

	private String next;
	
    public AuthGrMgrCUDCmd() {
    }
    
    public AuthGrMgrCUDCmd(String next_url) {
    	next = next_url; 
    }
	
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	String mode = request.getParameter("mode");
    	PT_AUTH_GROUPent.setRequestOnlyString(request); // request 값들 자동 세팅
    	KJFLog.debug(PT_AUTH_GROUPent.toString()); //세팅된 값들 확인
    	
    	if(mode.equals("C")) { //입력
    		insertExe(request);
    	} else if (mode.equals("U")) { //수정
    		updateExe(request);
    	} else if (mode.equals("D")) { //삭제
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
    	String sql     = "SELECT NVL(MAX(TO_NUMBER(AUTH_GROUP_CODE)),0)+1 MAXSEQ FROM PT_AUTH_GROUP  \n";
    	String AUTH_GROUP_CODE = rDAO.select(sql).getValue(0,"MAXSEQ");

    	PT_AUTH_GROUPent.setAUTH_GROUP_CODE(AUTH_GROUP_CODE);							// 권한그룹코드
    	PT_AUTH_GROUPent.setAUTH_GROUP_NAME(request.getParameter("AUTH_GROUP_NAME"));	// 권한그룹명
    	PT_AUTH_GROUPent.setORDER_SEQ(request.getParameter("ORDER_SEQ"));				// 정렬순서
    	PT_AUTH_GROUPent.setUSE_YN(request.getParameter("USE_YN"));						// 정렬순서
    	PT_AUTH_GROUPent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));								// 현재 시간.

    	PT_AUTH_GROUPdao.insert(PT_AUTH_GROUPent);
       
    } 
    

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
    	   	  	
    	PT_AUTH_GROUPdao.update(PT_AUTH_GROUPent);        
       
    } 
    
    
    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{
        
    	String[] str	= request.getParameterValues("chk");
    	
    	for(int i = 0; i < str.length; i++){
    		PT_AUTH_GROUPent.setAUTH_GROUP_CODE(str[i]);
    		PT_AUTH_GROUPdao.delete(PT_AUTH_GROUPent);
    	}

    } 

}
