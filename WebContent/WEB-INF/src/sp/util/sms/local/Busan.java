package sp.util.sms.local;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sp.util.EtcDBCon;

public class Busan {
	

    public int SendMsg( String from_tel, String to_tel, String msg) throws Exception{
    	int result = 1;
        Connection con = null;

        PreparedStatement pstmt = null;


        try {
            con = EtcDBCon.getConnection("busanDB");
               
            String sql =
            	"Insert into sms_msg " +
                "(msgkey, ID, phone, callback, reqdate, msg, etc1, etc2, etc3, etc4 ) values " +
                " (sms_msg_seq.nextval, 'pktcorp', '"+to_tel+"', '"+from_tel+"', sysdate,  '"+msg+"', '교육신청', '6260508', '010000', '1')";
            	//pktcorp,교육신청..등은 sms관리업체에서 관리하기위한 필드이므로 변경하지 말것.
                        
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            
        } catch(SQLException e) {
        	result=0;
            throw new SQLException(e.getMessage());
        } finally {
            EtcDBCon.close(con, pstmt);
        }    	
 	
    	return result;
    }
}
