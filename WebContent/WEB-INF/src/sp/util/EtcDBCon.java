package sp.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EtcDBCon {
	
	protected static DataSource busanDB;
	//protected static DataSource seoulDB;
    //protected static DataSource gyeonggidoDB;
  //...이후 추가
	

	static{
		try{
			InitialContext ctx = new InitialContext(); 
			busanDB = (DataSource)ctx.lookup("busanDB");
			//seoulDB = (DataSource)ctx.lookup("seoulDB");
            //gyeonggidoDB = (DataSource)ctx.lookup("gyeonggidoDB");
            //...이후 추가

		}catch (NamingException e) {
			System.out.println(e);
		}
	}


	public static Connection getConnection(String dsNm) throws Exception{
		Connection con = null;
	
			if(dsNm.equals("busanDB")){
				con = busanDB.getConnection();
			}
//			}else if(dsNm.equals("seoulDB")){
//				con = seoulDB.getConnection();
//            }else if(dsNm.equals("gyeonggidoDB")){
//                con = gyeonggidoDB.getConnection();                
//			}
			//...이후 추가
		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {		
			if(rs != null) rs.close();
			close(con, pstmt);
	}

	public static void close(Connection con, PreparedStatement pstmt)throws Exception {

			if(pstmt != null) pstmt.close();
			if(con != null) con.close();

	}

	public static void close(Connection con, CallableStatement cs) throws Exception{
			if(cs != null) cs.close();
			if(con != null) con.close();

	}
}
