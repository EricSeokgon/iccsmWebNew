/**
 * 파일명   : UserMgrCUDCmd.java 
 * 설명     : CUD cmd  
 * 이력사항
 * CH00     :2006/07/15 오두식  최초작성 
 */
package sp.user.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_USERDAO;
import sp.dao.PT_USEREntity;


public class UserMgrCUDCmd implements KJFCommand {
	
	private PT_USERDAO  	PT_USERdao 		= new PT_USERDAO();
	private PT_USEREntity  	PT_USERent 		= new PT_USEREntity();

	private String next;
	
    public UserMgrCUDCmd() {
    }
    
    public UserMgrCUDCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	
    	String cmd = request.getParameter("cmd");
    	PT_USERent.setRequestOnlyString(request); // request 값들 자동 세팅
    	KJFLog.debug(PT_USERent.toString()); //세팅된 값들 확인
    	
    	if(cmd.equals("UserMgrC")) { //입력
    		insertExe(request);
    	} else if (cmd.equals("UserMgrU")) { //수정
    		updateExe(request);
    	} else if (cmd.equals("UserMgrD")) { //삭제
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
    	ReportEntity rEntity = null;
    	
    	//String sql = "SELECT IFNULL(MAX(CAST(USER_CODE AS UNSIGNED)),0)+1 AS USER_CODE FROM PT_USER";
        String sql = "SELECT NVL(MAX(USER_CODE),0)+1 AS USER_CODE FROM PT_USER";
    	rEntity = rDAO.select(sql);
       	
    	PT_USERent.setUSER_CODE(rEntity.getValue(0,"USER_CODE"));
    	PT_USERent.setREG_DATE(KJFDate.getCurTime("yyyy-MM-dd"));//현재 시간.
    	PT_USERent.setMOD_DATE(KJFDate.getCurTime("yyyy-MM-dd"));//수정 시간.
    	PT_USERdao.insert(PT_USERent);       
    } 
    

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
    	
    	PT_USERent.setMOD_DATE(KJFDate.getCurTime("yyyy-MM-dd"));//수정 시간. 
    	PT_USERent.setUSER_CODE(request.getParameter("USER_CODE"));
    	//String[] fields ={"USER_NAME","USER_PASSWD","USER_TEL","USER_EMAIL","USER_MOBILE","USER_NAT_NUM","USER_ZIPCODE","USER_ADDR","USER_ADDR_ETC","USER_UPD_DT","BIGO"};
    	PT_USERdao.update(PT_USERent);        
       
    } 
    
    
    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{
    	String[] str	= request.getParameterValues("chk");
    	for(int i = 0; i < str.length; i++){
    		PT_USERent.setUSER_CODE(str[i]);
    		PT_USERdao.delete(PT_USERent);
    	}    	
    } 
    
    
}