package sp.sys.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.ops.SuperToDB;

public class AuthUserWCmd extends SuperToDB  implements KJFCommand {

	private String next;
	
    public AuthUserWCmd() {
    }
    
    public AuthUserWCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

    	// 권한별 프로그램 및 사용자관리 임시테이블 데이터를 실제 사용테이블에 저장
    	setRealTable();
        return next;
        
    }
    
    /**
     * 권한별 프로그램관리 임시테이블 데이터를 실제 사용테이블에 저장
     * @param HttpServletRequest
     * @return
     */
    public void setRealTable() throws SQLException{

    	Connection        conn = null;
    	PreparedStatement ps   = null; 

    	String sql = null;

    	try {
    		conn = this.getConnection();
    		
   			sql = "DELETE FROM PT_AUTH_USER";
    		ps  = conn.prepareStatement(sql);
    		ps.executeUpdate();
    		
   			sql = "INSERT INTO PT_AUTH_USER VALUE(SELECT * FROM PT_AUTH_USER_TEMP)";
    		ps  = conn.prepareStatement(sql);
    		ps.executeUpdate();
    		
    	} catch (SQLException e) {
    		throw e;
			   
    	} finally {
    		if(ps!=null){
    			ps.close();
    		}
    		this.release(conn);
    	}
    }
}
