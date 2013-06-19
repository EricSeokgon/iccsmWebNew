/**
 * ���ϸ�   : LoginWorker.java
 * ����	    : login ����� ���� �Լ��� ����
 * �̷»���
 * CH00     :
 *  1. 2006/06/05 ���� �����ۼ� 
 * 	2. 2006/10/25 ���ν� ���ӷα� ���� ���� 
 *      accessLogInsert(), accessLogUpdate() �߰�
 */

package sp.login;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.*;
import sp.dao.PT_SM_USER_LOGDAO;
import sp.dao.PT_SM_USER_LOGEntity;
import sp.uent.UserEnt;
import sp.util.DBFuncMaker;

import sp.dao.PT_HOM_USERDAO;
import sp.dao.PT_HOM_USEREntity;

public class LoginWorker{
	
	//====================================================================================================
		
    public boolean isInUserID(String strID) throws  Exception{
    	
    	KJFLog.log("isInUserID");
    	
        boolean result = false;

        ReportDAO rDAO = new ReportDAO();
        ReportEntity rEntity = null;

        String sql ="\n SELECT COUNT(*) CNT                             " +
            			"\n   FROM PT_HOM_USER                                  " +
            			"\n  WHERE USER_ID='"+strID+"'                      "+
            			"\n  AND USE_YN='Y'		                      " ;
        
         rEntity = rDAO.select(sql);
         
 		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
			result = true;	
		}
 		
		if((strID.equals(Config.props.get("SYS_ID")))){
			result=true;
		}
		
		KJFLog.log("=======");
		KJFLog.log(result+"");
		KJFLog.log("=======");
		 
        return result;

    }
    
    public boolean isInAdminID(String strID) throws  Exception{
    	
    	KJFLog.log("isInAdminID");
    	
        boolean result = false;

        ReportDAO rDAO = new ReportDAO();
        ReportEntity rEntity = null;

//        String sql ="\n SELECT COUNT(*) CNT                             " +
//            			"\n   FROM PT_USER                                  " +
//            			"\n  WHERE USER_ID='"+strID+"'                      " +
//            			"\n  AND USE_YN='Y'		                      " ;
        
        String sql ="\n SELECT COUNT(*) CNT                             " +
					"\n   FROM PT_MI_USER                                  " +
					"\n  WHERE OFFI_ID='"+strID+"'                      " +
					"\n  -- AND USE_YN='Y'		                      " ;

        
         rEntity = rDAO.select(sql);
         
 		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
			result = true;	
		}
 		
		if((strID.equals(Config.props.get("SYS_ID")))){
			result=true;
		}
		 
		KJFLog.log("=======");
		KJFLog.log(result+"");
		KJFLog.log("=======");
		
        return result;

    }
    
    //====================================================================================================
    
    public boolean isloginUser(String strID, String strPass ) throws  Exception{
    	
    	KJFLog.log("isloginUser");
    	
		boolean result = false;
	    ReportDAO rDAO = new ReportDAO();
	    ReportEntity rEntity = null;
		String sql =
	        "\n SELECT COUNT(*) CNT                     " +
	        "\n   FROM PT_HOM_USER                    " +
	        "\n  WHERE USER_ID='"+strID+"'           	" +
	        "\n    AND USER_PASSWD ='"+strPass+"' 		" +
			"\n  AND USE_YN='Y'		                      " ;	
		
		rEntity = rDAO.select(sql);
		
		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
			result = true;	
		}
		
		if((strID.equals(Config.props.get("SYS_ID"))&&strPass.equals(Config.props.get("SYS_PASS")))){
			result=true;
		}
		
		KJFLog.log("=======");
		KJFLog.log(result+"");
		KJFLog.log("=======");
	    
	    return result;
    }
    
    public boolean isloginAdmin(String strID, String strPass ) throws  Exception{
    	
    	KJFLog.log("isloginAdmin");
    	
		boolean result = false;
	    ReportDAO rDAO = new ReportDAO();
	    ReportEntity rEntity = null;
		String sql =
//	        "\n SELECT COUNT(*) CNT                     " +
//	        "\n   FROM PT_USER                              " +
//	        "\n  WHERE USER_ID='"+strID+"'           " +
//	        "\n    AND USER_PASSWD ='"+strPass+"' " ;		
	        "\n SELECT COUNT(*) CNT                     " +
	        "\n   FROM PT_MI_USER                              " +
	        "\n  WHERE OFFI_ID='"+strID+"'           " +
	        "\n    AND PASS ='"+strPass+"' " ;		
		
		rEntity = rDAO.select(sql);
		
		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
			result = true;	
		}
		
		if((strID.equals(Config.props.get("SYS_ID"))&&strPass.equals(Config.props.get("SYS_PASS")))){
			result=true;
		}
		
		KJFLog.log("=======");
		KJFLog.log(result+"");
		KJFLog.log("=======");
	    
	    return result;
    }
	
	//====================================================================================================
	
    /** 
     * ����� ��������
     * @param   String strID
     * @return   boolean
     */
     public ReportEntity loadUserFromDBAdmin(String user_id) throws Exception{

    	 KJFLog.log("loadUserFromDBAdmin");
    	 
         String selectSQL =

//        	 "SELECT              	  	\n"+	
//        	 "	USER_ID,         	  	\n"+	
//        	 "	USER_NAME,  	  		\n"+
//        	 "	USER_EMAIL,  	  		\n"+
//        	 "	USER_PASSWD,    	  		\n"+	
//        	 "	CAPITAL         	  	\n"+	
//        	 "FROM   PT_USER 	  		\n"+	
//        	 "WHERE 					\n"+	
//        	 "	 USER_ID ='"+user_id+"' \n";	

        	 "SELECT              	  	\n"+	
        	 "	OFFI_ID,         	  	\n"+	
        	 "	NM,  	  				\n"+
        	 "	E_MAIL,  	  			\n"+
        	 "	PASS,    	  			\n"+	
        	 "	HOME_GROUP,        	  	\n"+
        	 "	RECV_DIV        	  	\n"+
        	 "FROM   PT_MI_USER 	  	\n"+	
        	 "WHERE 					\n"+	
        	 "	 OFFI_ID ='"+user_id+"' \n";	

        	 
         ReportDAO    rDAO        = new ReportDAO();
         ReportEntity rEntity     = null;

         rEntity = rDAO.select(selectSQL);
         
 		KJFLog.log("=======");
		KJFLog.log(rEntity.getRowCnt()+"");
		KJFLog.log("=======");
         
         return rEntity;
     }     
    
    /** 
     * ����� ��������
     * @param   String strID
     * @return   boolean
     */
     public ReportEntity loadUserFromDBUser(String user_id) throws Exception{
    	 
    	 KJFLog.log("loadUserFromDBUser");
    	 
    	 //ȸ������ ���̵� ���� ����
    	 ReportDAO    uDAO        = new ReportDAO();
         ReportEntity uEntity     = null;
         //ReportEntity cEntity     = null;
    	 String select_id = "\n" +
    	 		"SELECT 			\n"+
    	 		"	MEM_ID, USER_NAME, USER_NAT_NUM	, BIGO,  CAPITAL	\n"+	
	        	"FROM PT_HOM_USER 	\n"+	
	        	"WHERE 1=1			\n"+	
	        	"		AND USER_ID ='"+user_id+"' \n";    	 
    	
         uEntity = uDAO.select(select_id);
         
//         String sql2 = "SELECT LEVELCODE FROM khma.PT_MEMBER	\n" +
//         		"	WHERE NAME = '"+uEntity.getValue(0,"USER_NAME")+"' AND SN = '"+uEntity.getValue(0,"USER_NAT_NUM")+"'";
//         cEntity = uDAO.select(sql2);
         
         //ȸ�� ����� ȸ���������� ������ �´�.
         String sql = "UPDATE PT_HOM_USER U \n " ;         
         
        	
	        
             	 
         String selectSQL ="\n"+
        	 "SELECT              	  		\n"+	
        	 "		USER_ID,         	  	\n"+	
        	 "		USER_NAME,  	  	\n"+
        	 "		USER_NICKNAME,  	  	\n"+
        	 "		USER_PASSWD,  	  	\n"+
        	 "		USER_EMAIL,  	  	\n"+
        	 "		USER_LEVEL,       	\n" +
        	 "		USER_MOBILE	,		\n"+
        	 "		MEM_ID,       	\n"+
        	 "		BIGO,       	\n"+
        	 "	    CAPITAL         	  	\n"+	
        	 "FROM PT_HOM_USER 	\n"+	
        	 "WHERE 1=1					\n"+	
        	 "		AND USER_ID ='"+user_id+"' \n";	

         ReportDAO    rDAO        = new ReportDAO();
         ReportEntity rEntity     = null;
         rEntity = rDAO.select(selectSQL);
         
  		KJFLog.log("=======");
		KJFLog.log(rEntity.getRowCnt()+"");
		KJFLog.log("=======");
		
         return rEntity;
     } 
     

     /** 
      * �α��� ���� ������Ʈ
      * @param   String strID
      * @return   void
      */
      public void updateLoginInfo(String user_id) throws Exception{
     	 
     	 KJFLog.log("updateLoginInfo");
     	 
          String updateSQL ="\n"+
         	 "UPDATE     PT_HOM_USER         	  		\n"+	
         	 "	SET	LOGIN_CNT = LOGIN_CNT+1,    	\n"+
         	 "		LAST_LOGIN_DT = "+DBFuncMaker.getCurrDateFunc()+"       	\n"+
         	 "WHERE USER_ID ='"+user_id+"' \n";	

          ReportDAO    rDAO        = new ReportDAO();
          //rDAO.execute(updateSQL);
      } 
      
       
     /**
 	* �α׾ƿ� ���μ���
 	* @param   String strID, String strPass
 	* @return   boolean
 	*/
 	public  void LogOutProcess(HttpServletRequest request, HttpServletResponse response ) throws  Exception{

         UserEnt user = (UserEnt)request.getSession().getAttribute("user");     
         
         if (user != null) {//�α����� �����̰�..������ �α����̸�...
         	
        	 if(user.getIsWhere().equals("admin")){
            	 /*�������ϰ�� ���� �ð� ����*/
              	accessLogUpdate(user.getUSER_ID(),user.getLogNum());
              	/*�������ϰ�� ���� �ð� ����*/ 
        	 }         	
         	request.getSession().invalidate();
         }
    
         //��Ű�� �Բ� �̿�..
//         if(Config.props.getBoolean("IS_USE_COOKIE") ){
//         	UsingCookieLogOut(response );
//         }
   
 	}
 	
	/**
	 * ����ð� ����
	 * @param user_id
	 * @param logNum
	 * @throws Exception
	 */
	private void accessLogUpdate(String user_id,String logNum)throws Exception{
		PT_SM_USER_LOGDAO    PT_SM_USER_LOGdao = new PT_SM_USER_LOGDAO();
		PT_SM_USER_LOGEntity PT_SM_USER_LOGent = new PT_SM_USER_LOGEntity();
		    	
		String date    		= KJFDate.datetimeOnly(KJFDate.getCurTime());
    	
		PT_SM_USER_LOGent.setLOG_NUM(logNum);		// �α� ��ȣ
    	PT_SM_USER_LOGent.setEND_TIME(date);		// ���� �ð�.
    	PT_SM_USER_LOGent.setUSER_ID(user_id);		// ����� ���̵�
    	
    	String[] field = {"END_TIME"};
    	PT_SM_USER_LOGdao.updateModifiedOnly(PT_SM_USER_LOGent,field);
    	
    }
     
	
	/**
	 * ���� �α� ����
	 * @param request
	 * @param user_id
	 * @return logNum �α� ��ȣ 
	 * @throws Exception
	 */
	private String accessLogInsert(HttpServletRequest request,String user_id)throws Exception{
		PT_SM_USER_LOGDAO    PT_SM_USER_LOGdao = new PT_SM_USER_LOGDAO();
		PT_SM_USER_LOGEntity PT_SM_USER_LOGent = new PT_SM_USER_LOGEntity();

    	ReportDAO rDAO = new ReportDAO();
    	
    	String sql     		= "SELECT NVL( MAX( LOG_NUM ), 0 ) + 1   MAXSEQ FROM PT_SM_USER_LOG  \n";
    	String SEQ     		= rDAO.select(sql).getValue(0,"MAXSEQ");
    	    	
    	String date    		= KJFDate.datetimeOnly(KJFDate.getCurTime());
    	String userIP  		= request.getRemoteAddr();
    	String userAgent	= request.getHeader("User-Agent")==null?"":request.getHeader("User-Agent");
    	
    	if(userAgent.length()>128) userAgent=KJFUtil.getTitleLimit(userAgent,120);
    	
    	PT_SM_USER_LOGent.setLOG_NUM(SEQ);			// �α� ��ȣ
    	PT_SM_USER_LOGent.setACCESS_TIME(date);		// ���� �ð�.
    	PT_SM_USER_LOGent.setACCESS_IP(userIP);		// ���� IP.
    	PT_SM_USER_LOGent.setUSER_ID(user_id);		// ����� ���̵�
    	PT_SM_USER_LOGent.setBROWSER(userAgent);	// ������ ����
    	

    	PT_SM_USER_LOGdao.insert(PT_SM_USER_LOGent);
    	
    	return SEQ;
    }
	
   public static  void checkSession(HttpServletRequest request) throws  Exception{
   	
       //���ǿ��� ����ڰ�ü�� ���Ѵ�.
   	UserEnt user = null;
   	user = (UserEnt) request.getSession().getAttribute("user");
   	
//   	if(!Config.props.getBoolean("IS_USE_COOKIE") ){
//       	
//   		String uri = request.getRequestURI();
//       	String cmd = uri.substring(uri.lastIndexOf("/")+1);
//       	cmd = cmd.substring(0, cmd.lastIndexOf("."));
//       	
//           if(user==null&&!cmd.equals("LoginAction")){
//           	//throw new LoginException(request, "�α����� ���ֽʽÿ�");
//           }
//   		
//   		return;
//
//   	}

       if (user != null) {
           return ;
       }

       //���� ����ڰ�ü�� ���ǿ��� ���Ҽ� ���ٸ�
       //��Ű�� �˻��Ѵ�.
       //��Ű���� ������� ���̵�(��ȣȭ��)�� ���Ҽ� ������ ����� ��ü��
       //�ٽ� ����� ������ �����ϴ�.

//       Cookie[] cookies = request.getCookies();
//       for (int x = 0; x < cookies.length; x++) {
//           if (cookies[x].getName().equals(COOKIE_LOGINED_NAME)) {
//           	
//           	String  cokieVal = cookies[x].getValue();
//           	System.out.print(cokieVal);
//           	if(!KJFUtil.isEmpty(cokieVal) && KJFUtil.print(cokieVal).trim().length() > 0 ){
//                   user = new UserEnt(KJFSec.decode(cokieVal));
//                   request.getSession().setAttribute("user",user);	            		
//           	}
//
//               return ;
//           }
//       }

       return;
   }
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // Cookie() �� ����ϱ� ���Ͽ�.. ����� ���� ����...
   //
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
//	public  void UsingCookie(HttpServletResponse response, UserEnt user ) throws  Exception{	
//		
//      Cookie cookie;
//
//
//      //���� ������ ���� ����.
//      String strLoginUser = KJFSec.encode( user.getUSER_ID());
//      
//      KJFLog.log(COOKIE_LOGINED_NAME + " id(" + user.getUSER_ID() +") = " + strLoginUser);
//
//      cookie = new Cookie( COOKIE_LOGINED_NAME, strLoginUser);
//
//
//      cookie.setPath("/");
//      cookie.setMaxAge( -1);
//      cookie.setVersion(0);
//      cookie.setSecure(false);		
//		
//		response.addCookie(cookie);
//		
//	}
	
	
//	public  void UsingCookieLogOut(HttpServletResponse response ) throws  Exception{	
//		
//
//      Cookie cookie = new Cookie(COOKIE_LOGINED_NAME, "");
//
//
//      cookie.setPath("/");
//      cookie.setMaxAge(0);
//      cookie.setVersion(0);
//      cookie.setSecure(false);	
//		
//		response.addCookie(cookie);
//		
//	}
     
     //��Ű�� ����Ǵ� ������� LoginUser�� ���ϴ� Ű��.
//     private static final String COOKIE_LOGINED_NAME = "login_in_serial_number";


    

}










