package sp.uent;

import java.util.Vector;

import kjf.cfg.Config;
import kjf.ops.ReportEntity;
import kjf.util.*;
import sp.login.LoginWorker;
import sp.sys.SysWorker;


public class UserEnt {

    private String USER_ID;
    private String USER_NAME;
    private String USER_NICKNAME;
    private String USER_PASSWORD;
    
    private String SIDO_CODE;
    private String SIGUNGU_CODE;
    
    private String USER_GROUP;
    private String USER_LEVEL;
    private String USER_EMAIL;
    
    private String USER_TEL;
    private String USER_MOBILE;
    private String RECV_DIV;
    
    private String CAPITAL;
    private String LogNum;
    private String isWhere;
    private boolean isAdmin;
    
    //홈페이지 경우 주석 처리
    private Vector menuEntList; //사용자 메뉴

    public UserEnt()  {
    }
    
    public UserEnt(String strID) throws Exception {
        this(strID, "user");
    }

    public UserEnt(String strID, String type) throws Exception {
      
        
        ReportEntity rEntity= new ReportEntity();
        
        LoginWorker worker = new LoginWorker();
        
        if(type.equals("admin")){
            KJFLog.log("관리자 UserEnt 생성..");
            //관리자
            rEntity=worker.loadUserFromDBAdmin(strID);
            if (rEntity.getRowCnt() > 0) {

//                this.USER_ID                = rEntity.getValue(0,"USER_ID");                   
//                this.USER_NAME              = rEntity.getValue(0,"USER_NAME");
//                this.USER_NICKNAME          = "";
//                this.USER_PASSWORD          = rEntity.getValue(0,"USER_PASSWD");
//                this.USER_GROUP             = "hom_adm";
//                this.USER_EMAIL             = rEntity.getValue(0,"USER_EMAIL");
//                this.USER_LEVEL             = rEntity.getValue(0,"CAPITAL");
//                this.CAPITAL                = rEntity.getValue(0,"CAPITAL");

                this.USER_ID                = rEntity.getValue(0,"OFFI_ID");                   
                this.USER_NAME              = rEntity.getValue(0,"NM");
                this.USER_NICKNAME          = "";
                this.USER_PASSWORD          = rEntity.getValue(0,"PASS");
                this.USER_GROUP             = "hom_adm";
                this.USER_EMAIL             = rEntity.getValue(0,"E_MAIL");
                this.USER_LEVEL             = rEntity.getValue(0,"HOME_GROUP");
                this.CAPITAL                = rEntity.getValue(0,"HOME_GROUP");
                this.RECV_DIV               = rEntity.getValue(0,"RECV_DIV");

                
                this.isWhere                = "admin";
    
                SysWorker sysworker = new SysWorker();
                if(this.CAPITAL.equals("S") || this.CAPITAL.equals("A") ) this.isAdmin = true;
                this.menuEntList = sysworker.getUserMenuEntList(strID, USER_LEVEL); 
            }
            
        }else if(type.equals("user")){
    
            KJFLog.log("사용자 UserEnt 생성..");
            //사용자
            rEntity=worker.loadUserFromDBUser(strID);
            if (rEntity.getRowCnt() > 0) {
                this.USER_ID                = rEntity.getValue(0,"USER_ID");                   
                this.USER_NAME              = rEntity.getValue(0,"USER_NAME");  
                this.USER_TEL               = rEntity.getValue(0,"USER_TEL"); 
                this.USER_MOBILE            = rEntity.getValue(0,"USER_MOBILE");
                this.USER_EMAIL             = rEntity.getValue(0,"USER_EMAIL"); 
                this.USER_LEVEL             = rEntity.getValue(0,"CAPITAL");
                this.CAPITAL                = rEntity.getValue(0,"CAPITAL");
                this.isWhere = "user";
                KJFLog.log("USER_ID : "+USER_ID);
                KJFLog.log("USER_NAME : "+USER_NAME);
                KJFLog.log("USER_TEL : "+USER_TEL);
                KJFLog.log("USER_MOBILE : "+USER_MOBILE);
                KJFLog.log("USER_EMAIL : "+USER_EMAIL);
                KJFLog.log("USER_LEVEL : "+USER_LEVEL);
            }
            if(this.CAPITAL.equals("S") || this.CAPITAL.equals("A") ) this.isAdmin = true;
            //최신 로그인 정보를 업데이트 한다. 
            worker.updateLoginInfo(USER_ID);
        }

    
        //여기까지 왔는데 USER_ID == null 이라면.. pt_hom_user, pt_user 어디에서도 회원정보가 없다는 뜻이다...
        if (KJFUtil.isEmpty(USER_ID)){
            if(strID.equals(Config.props.get("SYS_ID"))){
                
                KJFLog.log("SYS_ID UserEnt 생성..");
                
                this.USER_ID        = strID;
                this.USER_NAME      = "시스템 관리자";
                this.USER_NICKNAME  = "시스템 관리자";
                this.USER_PASSWORD  = Config.props.get("SYS_PASS");
                this.USER_GROUP     = "sys_adm";
                this.USER_EMAIL     = rEntity.getValue(0,"USER_EMAIL");
                this.USER_LEVEL     = "S";

                this.CAPITAL = "S";
                this.isWhere = "admin";
                SysWorker sysworker = new SysWorker();
                this.menuEntList = sysworker.getUserMenuEntList(strID, CAPITAL);    
                
                KJFLog.log("USER_ID : "+USER_ID);
                KJFLog.log("PASSWORD : "+USER_PASSWORD);
                KJFLog.log("USER_NAME : "+USER_NAME);
                KJFLog.log("EMAIL : "+USER_EMAIL);
                KJFLog.log("CAPITAL : "+CAPITAL);
                KJFLog.log("isWhere : "+isWhere);
                if(this.CAPITAL.equals("S") || this.CAPITAL.equals("A") ) this.isAdmin = true;
                
            }
        }

        if (KJFUtil.isEmpty(USER_ID)){        
            throw new MsgException("입력하신 아이디가 존재하지 않거나 사용허가되지 않았습니다.");             
        }
        
        
        
        //======================================================
        

    }

    public String getIsWhere() {
        return isWhere;
    }

    public void setIsWhere(String isWhere) {
        this.isWhere = isWhere;
    }

    public String getLogNum() {
        return LogNum;
    }

    public void setLogNum(String logNum) {
        LogNum = logNum;
    }

    public Vector getMenuEntList() {
        return menuEntList;
    }

    public void setMenuEntList(Vector menuEntList) {
        this.menuEntList = menuEntList;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String user_email) {
        USER_EMAIL = user_email;
    }

    public String getUSER_GROUP() {
        return USER_GROUP;
    }

    public void setUSER_GROUP(String user_group) {
        USER_GROUP = user_group;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String user_id) {
        USER_ID = user_id;
    }

    public String getUSER_LEVEL() {
        return USER_LEVEL;
    }

    public void setUSER_LEVEL(String user_level) {
        USER_LEVEL = user_level;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String user_name) {
        USER_NAME = user_name;
    }

    public String getUSER_NICKNAME() {
        return USER_NICKNAME;
    }

    public void setUSER_NICKNAME(String user_nickname) {
        USER_NICKNAME = user_nickname;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String user_password) {
        USER_PASSWORD = user_password;
    }
    
    public String getSIDO_CODE() {
        return SIDO_CODE;
    }

    public void setSIDO_CODE(String sido_code) {
        SIDO_CODE = sido_code;
    }

    public String getSIGUNGU_CODE() {
        return SIGUNGU_CODE;
    }

    public void setSIGUNGU_CODE(String sigungu_code) {
        SIGUNGU_CODE = sigungu_code;
    }

    public String getCAPITAL() {
        return CAPITAL;
    }

    public void setCAPITAL(String capital) {
        CAPITAL = capital;
    }

    public String getUSER_TEL() {
        return USER_TEL;
    }

    public void setUSER_TEL(String user_tel) {
        USER_TEL = user_tel;
    }
    
    public String getUSER_MOBILE() {
        return USER_MOBILE;
    }

    public void setUSER_MOBILE(String user_mobile) {
        USER_MOBILE = user_mobile;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public String getRECV_DIV() {
		return RECV_DIV;
	}

	public void setRECV_DIV(String rECVDIV) {
		RECV_DIV = rECVDIV;
	}

}
