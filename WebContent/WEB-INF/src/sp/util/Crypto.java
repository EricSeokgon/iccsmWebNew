package sp.util;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

public class Crypto {

	  //패스워드 입력
	   public static String Encrypt(String pass) throws Exception {
	    	String pwd;
		    
	    	ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity Entity     = null;
	        Entity =rDAO.select("select crypto.Encrypt('"+pass+"') PASS from dual");
	    	pwd =Entity.getValue(0,"PASS");
	        
	        return pwd;
		}
	   //패스워드 수정
	   public static String Upcrypt(String pass) throws Exception {
	    	String pwd;
		    
	    	ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity Entity     = null;
	        Entity =rDAO.select("select crypto.Decrypt('"+pass+"') PASS from dual");
	    	pwd =Entity.getValue(0,"PASS");
	        
	        return pwd;
		}
	   
	   //주민등록번호1 입력
	   public  static String Snocrypt(String SSN1) throws Exception {
		  
		    String sn1;
		    
	    	ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity Entity     = null;
	        Entity =rDAO.select("select crypto.Encrypt('"+SSN1+"') SSN1 from dual");
	    	sn1 =Entity.getValue(0,"SSN1");
	        
	        return sn1;
		}
	   //주민등록번호2 입력
	   public  static String Sntcrypt(String SSN2) throws Exception {
			  
		    String sn2;
		    
	    	ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity Entity     = null;
	        Entity =rDAO.select("select crypto.Encrypt('"+SSN2+"') SSN2 from dual");
	    	sn2 =Entity.getValue(0,"SSN2");
	        
	        return sn2;
		}
	  
	  /* public static String Snoupcrypt(String SSN1) throws Exception {
	    	String sn1;
		    
	    	ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity Entity     = null;
	        Entity =rDAO.select("select crypto.Decrypt('"+SSN1+"') SSN1 from dual");
	    	sn1 =Entity.getValue(0,"SSN1");
	        
	        return sn1;
		}
	   public static String Sntupcrypt(String SSN2) throws Exception {
	    	String sn2;
		    
	    	ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity Entity     = null;
	        Entity =rDAO.select("select crypto.Decrypt('"+SSN2+"') SSN2 from dual");
	    	sn2 =Entity.getValue(0,"SSN2");
	        
	        return sn2;
		}*/
}
