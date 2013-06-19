package sp.util.sms;

import kjf.util.KJFDate;
import sp.dao.PT_SMS_LOGDAO;
import sp.dao.PT_SMS_LOGEntity;
import sp.util.sms.local.Busan;

public class SmsMd {
	
    private PT_SMS_LOGDAO    PT_SMS_LOGdao = new PT_SMS_LOGDAO();
    private PT_SMS_LOGEntity PT_SMS_LOGent = new PT_SMS_LOGEntity();
	
    public int SendMsg(String user_id, 
    		           String Local_cd, 
    		           String Area_cd, 
    		           String from_tel, 
    		           String to_tel, 
    		           String msg) throws Exception{
    	int result =0;
    	
    	if(Local_cd.equalsIgnoreCase("bsbs"))
    		//result = new Busan().SendMsg(from_tel, to_tel, msg);
    	//...이후 추가
    	
    	
    	Smslog( user_id, Local_cd, Area_cd,  from_tel,  to_tel,  msg, result+"");
	
    	return result;
    }
    
    
    public void Smslog(String user_id, 
    				  String Local_cd, 
    				  String Area_cd, 
    				  String from_tel, 
    				  String to_tel, 
    				  String msg,
    				  String result) throws Exception{
    	
    	PT_SMS_LOGent.setUSER_ID(user_id);
    	PT_SMS_LOGent.setLOCAL_CD(Local_cd);
    	PT_SMS_LOGent.setAREA_CD(Area_cd);
    	PT_SMS_LOGent.setFROM_TEL(from_tel);
    	PT_SMS_LOGent.setTO_TEL(to_tel);
    	PT_SMS_LOGent.setMSG(msg);
    	PT_SMS_LOGent.setRESULT(result);
    	PT_SMS_LOGent.setUPD_DT(KJFDate.getCurDatetime());
    	PT_SMS_LOGent.setINS_DT(KJFDate.getCurDatetime());
    	
    	PT_SMS_LOGdao.insert(PT_SMS_LOGent);

    	
    }    
    

}
