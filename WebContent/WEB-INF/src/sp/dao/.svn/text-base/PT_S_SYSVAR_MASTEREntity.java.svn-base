

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_SYSVAR_MASTER
*  테이블 설명 :
*  테이블 PK   :  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               NEW_WRT:NUMBER(3):  
*               BAS_STA:NUMBER(3):  
*               AFF:NUMBER(3):  
*               ASSI_TRAN:NUMBER(3):  
*               USEBEF_INSP:NUMBER(3):  
*               CYTYSEAL:VARCHAR2(26):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SERVER_ADDR:VARCHAR2(100):  
*               SERVER_YN:VARCHAR2(1):  
*               SEND_SYS_ID:VARCHAR2(40):  
*               RECV_SYS_ID:VARCHAR2(40):  
*               CITYSEAL_USE_YN:CHAR(1):  
*               CITYSEAL_WIDTH:VARCHAR2(5):  
*               CITYSEAL_HEIGHT:VARCHAR2(5):  
*               GROUPWARE_MODULE_TYPE:VARCHAR2(20):  
*               ONLINE_CERT_USE_YN:CHAR(1):  
*               APPL_GUBUN:CHAR(1):  
*               WEEKCHK:VARCHAR2(2):  
*               INSTODAY:VARCHAR2(3):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_S_SYSVAR_MASTEREntity extends ValueObject{

  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  
     private String NEW_WRT;
  
     private String BAS_STA;
  
     private String AFF;
  
     private String ASSI_TRAN;
  
     private String USEBEF_INSP;
  
     private String CYTYSEAL;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String SERVER_ADDR;
  
     private String SERVER_YN;
  
     private String SEND_SYS_ID;
  
     private String RECV_SYS_ID;
  
     private String CITYSEAL_USE_YN;
  
     private String CITYSEAL_WIDTH;
  
     private String CITYSEAL_HEIGHT;
  
     private String GROUPWARE_MODULE_TYPE;
  
     private String ONLINE_CERT_USE_YN;
  
     private String APPL_GUBUN;
  
     private String WEEKCHK;
  
     private String INSTODAY;
  

//생성자를 만든다
    public PT_S_SYSVAR_MASTEREntity(){
    }
    
    
    public PT_S_SYSVAR_MASTEREntity(String SIDO_CODE,String SIGUNGU_CODE ){
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_S_SYSVAR_MASTEREntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
       value = ent.getByName("SIGUNGU_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIGUNGU_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.NEW_WRT =request.getParameter("NEW_WRT");
		this.BAS_STA =request.getParameter("BAS_STA");
		this.AFF =request.getParameter("AFF");
		this.ASSI_TRAN =request.getParameter("ASSI_TRAN");
		this.USEBEF_INSP =request.getParameter("USEBEF_INSP");
		this.CYTYSEAL =request.getParameter("CYTYSEAL");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.SERVER_ADDR =request.getParameter("SERVER_ADDR");
		this.SERVER_YN =request.getParameter("SERVER_YN");
		this.SEND_SYS_ID =request.getParameter("SEND_SYS_ID");
		this.RECV_SYS_ID =request.getParameter("RECV_SYS_ID");
		this.CITYSEAL_USE_YN =request.getParameter("CITYSEAL_USE_YN");
		this.CITYSEAL_WIDTH =request.getParameter("CITYSEAL_WIDTH");
		this.CITYSEAL_HEIGHT =request.getParameter("CITYSEAL_HEIGHT");
		this.GROUPWARE_MODULE_TYPE =request.getParameter("GROUPWARE_MODULE_TYPE");
		this.ONLINE_CERT_USE_YN =request.getParameter("ONLINE_CERT_USE_YN");
		this.APPL_GUBUN =request.getParameter("APPL_GUBUN");
		this.WEEKCHK =request.getParameter("WEEKCHK");
		this.INSTODAY =request.getParameter("INSTODAY");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.NEW_WRT =KJFMi.dsGet(ds, arg_row, "NEW_WRT");
		this.BAS_STA =KJFMi.dsGet(ds, arg_row, "BAS_STA");
		this.AFF =KJFMi.dsGet(ds, arg_row, "AFF");
		this.ASSI_TRAN =KJFMi.dsGet(ds, arg_row, "ASSI_TRAN");
		this.USEBEF_INSP =KJFMi.dsGet(ds, arg_row, "USEBEF_INSP");
		this.CYTYSEAL =KJFMi.dsGet(ds, arg_row, "CYTYSEAL");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.SERVER_ADDR =KJFMi.dsGet(ds, arg_row, "SERVER_ADDR");
		this.SERVER_YN =KJFMi.dsGet(ds, arg_row, "SERVER_YN");
		this.SEND_SYS_ID =KJFMi.dsGet(ds, arg_row, "SEND_SYS_ID");
		this.RECV_SYS_ID =KJFMi.dsGet(ds, arg_row, "RECV_SYS_ID");
		this.CITYSEAL_USE_YN =KJFMi.dsGet(ds, arg_row, "CITYSEAL_USE_YN");
		this.CITYSEAL_WIDTH =KJFMi.dsGet(ds, arg_row, "CITYSEAL_WIDTH");
		this.CITYSEAL_HEIGHT =KJFMi.dsGet(ds, arg_row, "CITYSEAL_HEIGHT");
		this.GROUPWARE_MODULE_TYPE =KJFMi.dsGet(ds, arg_row, "GROUPWARE_MODULE_TYPE");
		this.ONLINE_CERT_USE_YN =KJFMi.dsGet(ds, arg_row, "ONLINE_CERT_USE_YN");
		this.APPL_GUBUN =KJFMi.dsGet(ds, arg_row, "APPL_GUBUN");
		this.WEEKCHK =KJFMi.dsGet(ds, arg_row, "WEEKCHK");
		this.INSTODAY =KJFMi.dsGet(ds, arg_row, "INSTODAY");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getNEW_WRT(){
             return NEW_WRT;
     };
  
     public String getBAS_STA(){
             return BAS_STA;
     };
  
     public String getAFF(){
             return AFF;
     };
  
     public String getASSI_TRAN(){
             return ASSI_TRAN;
     };
  
     public String getUSEBEF_INSP(){
             return USEBEF_INSP;
     };
  
     public String getCYTYSEAL(){
             return CYTYSEAL;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getSERVER_ADDR(){
             return SERVER_ADDR;
     };
  
     public String getSERVER_YN(){
             return SERVER_YN;
     };
  
     public String getSEND_SYS_ID(){
             return SEND_SYS_ID;
     };
  
     public String getRECV_SYS_ID(){
             return RECV_SYS_ID;
     };
  
     public String getCITYSEAL_USE_YN(){
             return CITYSEAL_USE_YN;
     };
  
     public String getCITYSEAL_WIDTH(){
             return CITYSEAL_WIDTH;
     };
  
     public String getCITYSEAL_HEIGHT(){
             return CITYSEAL_HEIGHT;
     };
  
     public String getGROUPWARE_MODULE_TYPE(){
             return GROUPWARE_MODULE_TYPE;
     };
  
     public String getONLINE_CERT_USE_YN(){
             return ONLINE_CERT_USE_YN;
     };
  
     public String getAPPL_GUBUN(){
             return APPL_GUBUN;
     };
  
     public String getWEEKCHK(){
             return WEEKCHK;
     };
  
     public String getINSTODAY(){
             return INSTODAY;
     };
  

//Setter 함수를 만든다
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setNEW_WRT(String NEW_WRT){
            this.NEW_WRT=NEW_WRT;
     };
  
     public void setBAS_STA(String BAS_STA){
            this.BAS_STA=BAS_STA;
     };
  
     public void setAFF(String AFF){
            this.AFF=AFF;
     };
  
     public void setASSI_TRAN(String ASSI_TRAN){
            this.ASSI_TRAN=ASSI_TRAN;
     };
  
     public void setUSEBEF_INSP(String USEBEF_INSP){
            this.USEBEF_INSP=USEBEF_INSP;
     };
  
     public void setCYTYSEAL(String CYTYSEAL){
            this.CYTYSEAL=CYTYSEAL;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setSERVER_ADDR(String SERVER_ADDR){
            this.SERVER_ADDR=SERVER_ADDR;
     };
  
     public void setSERVER_YN(String SERVER_YN){
            this.SERVER_YN=SERVER_YN;
     };
  
     public void setSEND_SYS_ID(String SEND_SYS_ID){
            this.SEND_SYS_ID=SEND_SYS_ID;
     };
  
     public void setRECV_SYS_ID(String RECV_SYS_ID){
            this.RECV_SYS_ID=RECV_SYS_ID;
     };
  
     public void setCITYSEAL_USE_YN(String CITYSEAL_USE_YN){
            this.CITYSEAL_USE_YN=CITYSEAL_USE_YN;
     };
  
     public void setCITYSEAL_WIDTH(String CITYSEAL_WIDTH){
            this.CITYSEAL_WIDTH=CITYSEAL_WIDTH;
     };
  
     public void setCITYSEAL_HEIGHT(String CITYSEAL_HEIGHT){
            this.CITYSEAL_HEIGHT=CITYSEAL_HEIGHT;
     };
  
     public void setGROUPWARE_MODULE_TYPE(String GROUPWARE_MODULE_TYPE){
            this.GROUPWARE_MODULE_TYPE=GROUPWARE_MODULE_TYPE;
     };
  
     public void setONLINE_CERT_USE_YN(String ONLINE_CERT_USE_YN){
            this.ONLINE_CERT_USE_YN=ONLINE_CERT_USE_YN;
     };
  
     public void setAPPL_GUBUN(String APPL_GUBUN){
            this.APPL_GUBUN=APPL_GUBUN;
     };
  
     public void setWEEKCHK(String WEEKCHK){
            this.WEEKCHK=WEEKCHK;
     };
  
     public void setINSTODAY(String INSTODAY){
            this.INSTODAY=INSTODAY;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("NEW_WRT:"+ this.getNEW_WRT()+"\n");
      
      strB.append("BAS_STA:"+ this.getBAS_STA()+"\n");
      
      strB.append("AFF:"+ this.getAFF()+"\n");
      
      strB.append("ASSI_TRAN:"+ this.getASSI_TRAN()+"\n");
      
      strB.append("USEBEF_INSP:"+ this.getUSEBEF_INSP()+"\n");
      
      strB.append("CYTYSEAL:"+ this.getCYTYSEAL()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("SERVER_ADDR:"+ this.getSERVER_ADDR()+"\n");
      
      strB.append("SERVER_YN:"+ this.getSERVER_YN()+"\n");
      
      strB.append("SEND_SYS_ID:"+ this.getSEND_SYS_ID()+"\n");
      
      strB.append("RECV_SYS_ID:"+ this.getRECV_SYS_ID()+"\n");
      
      strB.append("CITYSEAL_USE_YN:"+ this.getCITYSEAL_USE_YN()+"\n");
      
      strB.append("CITYSEAL_WIDTH:"+ this.getCITYSEAL_WIDTH()+"\n");
      
      strB.append("CITYSEAL_HEIGHT:"+ this.getCITYSEAL_HEIGHT()+"\n");
      
      strB.append("GROUPWARE_MODULE_TYPE:"+ this.getGROUPWARE_MODULE_TYPE()+"\n");
      
      strB.append("ONLINE_CERT_USE_YN:"+ this.getONLINE_CERT_USE_YN()+"\n");
      
      strB.append("APPL_GUBUN:"+ this.getAPPL_GUBUN()+"\n");
      
      strB.append("WEEKCHK:"+ this.getWEEKCHK()+"\n");
      
      strB.append("INSTODAY:"+ this.getINSTODAY()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_S_SYSVAR_MASTERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_S_SYSVAR_MASTERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_S_SYSVAR_MASTERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_S_SYSVAR_MASTERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_S_SYSVAR_MASTERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSIDO_CODE();
       values[1]= this.getSIGUNGU_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_S_SYSVAR_MASTEREntity();
  }

  public ValueObject getClone(){
         PT_S_SYSVAR_MASTEREntity newEnt = new PT_S_SYSVAR_MASTEREntity();
	 
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setNEW_WRT(this.getNEW_WRT());
         
          newEnt.setBAS_STA(this.getBAS_STA());
         
          newEnt.setAFF(this.getAFF());
         
          newEnt.setASSI_TRAN(this.getASSI_TRAN());
         
          newEnt.setUSEBEF_INSP(this.getUSEBEF_INSP());
         
          newEnt.setCYTYSEAL(this.getCYTYSEAL());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setSERVER_ADDR(this.getSERVER_ADDR());
         
          newEnt.setSERVER_YN(this.getSERVER_YN());
         
          newEnt.setSEND_SYS_ID(this.getSEND_SYS_ID());
         
          newEnt.setRECV_SYS_ID(this.getRECV_SYS_ID());
         
          newEnt.setCITYSEAL_USE_YN(this.getCITYSEAL_USE_YN());
         
          newEnt.setCITYSEAL_WIDTH(this.getCITYSEAL_WIDTH());
         
          newEnt.setCITYSEAL_HEIGHT(this.getCITYSEAL_HEIGHT());
         
          newEnt.setGROUPWARE_MODULE_TYPE(this.getGROUPWARE_MODULE_TYPE());
         
          newEnt.setONLINE_CERT_USE_YN(this.getONLINE_CERT_USE_YN());
         
          newEnt.setAPPL_GUBUN(this.getAPPL_GUBUN());
         
          newEnt.setWEEKCHK(this.getWEEKCHK());
         
          newEnt.setINSTODAY(this.getINSTODAY());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_S_SYSVAR_MASTERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSIDO_CODE();
        
             case 2 :
                 return  this.getSIGUNGU_CODE();
        
             case 3 :
                 return  this.getNEW_WRT();
        
             case 4 :
                 return  this.getBAS_STA();
        
             case 5 :
                 return  this.getAFF();
        
             case 6 :
                 return  this.getASSI_TRAN();
        
             case 7 :
                 return  this.getUSEBEF_INSP();
        
             case 8 :
                 return  this.getCYTYSEAL();
        
             case 9 :
                 return  this.getWRT_ID();
        
             case 10 :
                 return  this.getINS_DT();
        
             case 11 :
                 return  this.getUPD_DT();
        
             case 12 :
                 return  this.getSERVER_ADDR();
        
             case 13 :
                 return  this.getSERVER_YN();
        
             case 14 :
                 return  this.getSEND_SYS_ID();
        
             case 15 :
                 return  this.getRECV_SYS_ID();
        
             case 16 :
                 return  this.getCITYSEAL_USE_YN();
        
             case 17 :
                 return  this.getCITYSEAL_WIDTH();
        
             case 18 :
                 return  this.getCITYSEAL_HEIGHT();
        
             case 19 :
                 return  this.getGROUPWARE_MODULE_TYPE();
        
             case 20 :
                 return  this.getONLINE_CERT_USE_YN();
        
             case 21 :
                 return  this.getAPPL_GUBUN();
        
             case 22 :
                 return  this.getWEEKCHK();
        
             case 23 :
                 return  this.getINSTODAY();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_S_SYSVAR_MASTERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setNEW_WRT((String)value);
	            return;  
        
             case 4 :
                    this.setBAS_STA((String)value);
	            return;  
        
             case 5 :
                    this.setAFF((String)value);
	            return;  
        
             case 6 :
                    this.setASSI_TRAN((String)value);
	            return;  
        
             case 7 :
                    this.setUSEBEF_INSP((String)value);
	            return;  
        
             case 8 :
                    this.setCYTYSEAL((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 10 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 11 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 12 :
                    this.setSERVER_ADDR((String)value);
	            return;  
        
             case 13 :
                    this.setSERVER_YN((String)value);
	            return;  
        
             case 14 :
                    this.setSEND_SYS_ID((String)value);
	            return;  
        
             case 15 :
                    this.setRECV_SYS_ID((String)value);
	            return;  
        
             case 16 :
                    this.setCITYSEAL_USE_YN((String)value);
	            return;  
        
             case 17 :
                    this.setCITYSEAL_WIDTH((String)value);
	            return;  
        
             case 18 :
                    this.setCITYSEAL_HEIGHT((String)value);
	            return;  
        
             case 19 :
                    this.setGROUPWARE_MODULE_TYPE((String)value);
	            return;  
        
             case 20 :
                    this.setONLINE_CERT_USE_YN((String)value);
	            return;  
        
             case 21 :
                    this.setAPPL_GUBUN((String)value);
	            return;  
        
             case 22 :
                    this.setWEEKCHK((String)value);
	            return;  
        
             case 23 :
                    this.setINSTODAY((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_S_SYSVAR_MASTERHelper.toXML(this);
  }
  
}
