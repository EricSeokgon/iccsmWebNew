package sp.user.cmd;

/**
 * 파일명   : BbsControlCmd.java 
 * 설명     : 보드관리 cmd  
 * 이력사항
 * CH00     :2006/07/4 오두식 최초작성 
 */

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


public class UserFindCmd implements KJFCommand {

	private String next;
	
    public UserFindCmd() {
    }
    
    public UserFindCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    
    	//    	회원이름, 주민번호 체크
    	
	    if(isUserber(request, form)){
	    	request.setAttribute("isUserber","Y");
	    }else{
	    	request.setAttribute("isUserber","N");
	    }
	    
        return next;
    }
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, UserParam
     * @return
     */
    private boolean isUserber(HttpServletRequest request, ActionForm form)throws Exception{
    	String user_name = request.getParameter("USER_NAME");
    	String user_nat_num = request.getParameter("USER_NAT_NUM");
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String orderSQL 		 = "";
        boolean isJoin			 = false; 				

        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                     									\n"+ 
        	"	USER_ID,													\n"+
        	"	USER_PASSWD													\n";
 
        String fromSQL=
            "FROM                          									\n"+
            "    PT_USER							                  	\n";

        String whereSQL = "";
        
        if (KJFUtil.isEmpty(user_name) || KJFUtil.isEmpty(user_nat_num)){
            throw new MsgException("검색할 아이디를 입력해 주십시오.");
        }else{
        	whereSQL +=
        		"  WHERE USER_NAME='" + user_name + "'" +
        		" AND USER_NAT_NUM='" + user_nat_num + "' \n";
        }
        
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
        
        if(!KJFUtil.isEmpty(rEntity.getValue(0,"USER_ID"))){
        	isJoin = true;
        	rEntity.setValue(0,"USER_ID",chgStr(rEntity.getValue(0,"USER_ID")));
        	rEntity.setValue(0,"USER_PASSWD",chgStr(rEntity.getValue(0,"USER_PASSWD")));
        	request.setAttribute("rEntity", rEntity);
        }

        return isJoin;
    }
    
    private String chgStr(String val){
    	String result = val.substring(0,2);
    	int val_size = val.length() - 2;
    	while(val_size > 0){
    		result = result + "*";
    		val_size--;
    	}
    	return result;
    }
}