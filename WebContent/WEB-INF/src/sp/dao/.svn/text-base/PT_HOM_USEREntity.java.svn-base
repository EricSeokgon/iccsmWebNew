

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_HOM_USER
*  테이블 설명 :
*  테이블 PK   :  
*               USER_ID
*  테이블 컬럼 :  
*               USER_ID:VARCHAR2(16):  
*               USER_NAME:VARCHAR2(64):  
*               USER_PASSWD:VARCHAR2(64):  
*               USER_NAT_NUM1:VARCHAR2(16):  
*               USER_NAT_NUM2:VARCHAR2(50):  
*               USER_EMAIL:VARCHAR2(128):  
*               USER_ZIPCODE:VARCHAR2(8):  
*               USER_ADDR:VARCHAR2(128):  
*               USER_ADDR_ETC:VARCHAR2(128):  
*               USER_TEL:VARCHAR2(16):  
*               USER_MOBILE:VARCHAR2(16):  
*               USER_SEX:VARCHAR2(16):  
*               INP_SITE:VARCHAR2(50):  
*               SC_CD:VARCHAR2(4):  
*               SGG_CD:VARCHAR2(4):  
*               CAPITAL:VARCHAR2(2):  
*               BIGO:VARCHAR2(200):  
*               SMS_YN:VARCHAR2(2):  
*               NEWS_YN:VARCHAR2(2):  
*               USE_CODE:VARCHAR2(1):  
*               INS_DT:DATE:  
*               UPD_DT:DATE:
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_HOM_USEREntity extends ValueObject{

  
     private String USER_ID;
  
     private String USER_NAME;
  
     private String USER_PASSWD;
  
     private String USER_NAT_NUM1;
  
     private String USER_NAT_NUM2;
  
     private String USER_EMAIL;
  
     private String USER_ZIPCODE;
  
     private String USER_ADDR;
  
     private String USER_ADDR_ETC;
  
     private String USER_TEL;
  
     private String USER_MOBILE;
  
     private String USER_SEX;
  
     private String INP_SITE;
  
     private String SC_CD;
  
     private String SGG_CD;
  
     private String CAPITAL;
  
     private String BIGO;
  
     private String SMS_YN;
  
     private String NEWS_YN;
  
     private String USE_CODE;
  
     private Date INS_DT;
  
     private Date UPD_DT;
  

//생성자를 만든다
    public PT_HOM_USEREntity(){
    }
    
    
    public PT_HOM_USEREntity(String USER_ID ){
       this.setUSER_ID(USER_ID);
       
    }
      
    public PT_HOM_USEREntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("USER_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("USER_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.USER_ID =request.getParameter("USER_ID");
		this.USER_NAME =request.getParameter("USER_NAME");
		this.USER_PASSWD =request.getParameter("USER_PASSWD");
		this.USER_NAT_NUM1 =request.getParameter("USER_NAT_NUM1");
		this.USER_NAT_NUM2 =request.getParameter("USER_NAT_NUM2");
		this.USER_EMAIL =request.getParameter("USER_EMAIL");
		this.USER_ZIPCODE =request.getParameter("USER_ZIPCODE");
		this.USER_ADDR =request.getParameter("USER_ADDR");
		this.USER_ADDR_ETC =request.getParameter("USER_ADDR_ETC");
		this.USER_TEL =request.getParameter("USER_TEL");
		this.USER_MOBILE =request.getParameter("USER_MOBILE");
		this.USER_SEX =request.getParameter("USER_SEX");
		this.INP_SITE =request.getParameter("INP_SITE");
		this.SC_CD =request.getParameter("SC_CD");
		this.SGG_CD =request.getParameter("SGG_CD");
		this.CAPITAL =request.getParameter("CAPITAL");
		this.BIGO =request.getParameter("BIGO");
		this.SMS_YN =request.getParameter("SMS_YN");
		this.NEWS_YN =request.getParameter("NEWS_YN");
		this.USE_CODE =request.getParameter("USE_CODE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.USER_ID =KJFMi.dsGet(ds, arg_row, "USER_ID");
		this.USER_NAME =KJFMi.dsGet(ds, arg_row, "USER_NAME");
		this.USER_PASSWD =KJFMi.dsGet(ds, arg_row, "USER_PASSWD");
		this.USER_NAT_NUM1 =KJFMi.dsGet(ds, arg_row, "USER_NAT_NUM1");
		this.USER_NAT_NUM2 =KJFMi.dsGet(ds, arg_row, "USER_NAT_NUM2");
		this.USER_EMAIL =KJFMi.dsGet(ds, arg_row, "USER_EMAIL");
		this.USER_ZIPCODE =KJFMi.dsGet(ds, arg_row, "USER_ZIPCODE");
		this.USER_ADDR =KJFMi.dsGet(ds, arg_row, "USER_ADDR");
		this.USER_ADDR_ETC =KJFMi.dsGet(ds, arg_row, "USER_ADDR_ETC");
		this.USER_TEL =KJFMi.dsGet(ds, arg_row, "USER_TEL");
		this.USER_MOBILE =KJFMi.dsGet(ds, arg_row, "USER_MOBILE");
		this.USER_SEX =KJFMi.dsGet(ds, arg_row, "USER_SEX");
		this.INP_SITE =KJFMi.dsGet(ds, arg_row, "INP_SITE");
		this.SC_CD =KJFMi.dsGet(ds, arg_row, "SC_CD");
		this.SGG_CD =KJFMi.dsGet(ds, arg_row, "SGG_CD");
		this.CAPITAL =KJFMi.dsGet(ds, arg_row, "CAPITAL");
		this.BIGO =KJFMi.dsGet(ds, arg_row, "BIGO");
		this.SMS_YN =KJFMi.dsGet(ds, arg_row, "SMS_YN");
		this.NEWS_YN =KJFMi.dsGet(ds, arg_row, "NEWS_YN");
		this.USE_CODE =KJFMi.dsGet(ds, arg_row, "USE_CODE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getUSER_ID(){
             return USER_ID;
     };
  
     public String getUSER_NAME(){
             return USER_NAME;
     };
  
     public String getUSER_PASSWD(){
             return USER_PASSWD;
     };
  
     public String getUSER_NAT_NUM1(){
             return USER_NAT_NUM1;
     };
  
     public String getUSER_NAT_NUM2(){
             return USER_NAT_NUM2;
     };
  
     public String getUSER_EMAIL(){
             return USER_EMAIL;
     };
  
     public String getUSER_ZIPCODE(){
             return USER_ZIPCODE;
     };
  
     public String getUSER_ADDR(){
             return USER_ADDR;
     };
  
     public String getUSER_ADDR_ETC(){
             return USER_ADDR_ETC;
     };
  
     public String getUSER_TEL(){
             return USER_TEL;
     };
  
     public String getUSER_MOBILE(){
             return USER_MOBILE;
     };
  
     public String getUSER_SEX(){
             return USER_SEX;
     };
  
     public String getINP_SITE(){
             return INP_SITE;
     };
  
     public String getSC_CD(){
             return SC_CD;
     };
  
     public String getSGG_CD(){
             return SGG_CD;
     };
  
     public String getCAPITAL(){
             return CAPITAL;
     };
  
     public String getBIGO(){
             return BIGO;
     };
  
     public String getSMS_YN(){
             return SMS_YN;
     };
  
     public String getNEWS_YN(){
             return NEWS_YN;
     };
  
     public String getUSE_CODE(){
             return USE_CODE;
     };
  
     public Date getINS_DT(){
             return INS_DT;
     };
  
     public Date getUPD_DT(){
             return UPD_DT;
     };
  

//Setter 함수를 만든다
  
     public void setUSER_ID(String USER_ID){
            this.USER_ID=USER_ID;
     };
  
     public void setUSER_NAME(String USER_NAME){
            this.USER_NAME=USER_NAME;
     };
  
     public void setUSER_PASSWD(String USER_PASSWD){
            this.USER_PASSWD=USER_PASSWD;
     };
  
     public void setUSER_NAT_NUM1(String USER_NAT_NUM1){
            this.USER_NAT_NUM1=USER_NAT_NUM1;
     };
  
     public void setUSER_NAT_NUM2(String USER_NAT_NUM2){
            this.USER_NAT_NUM2=USER_NAT_NUM2;
     };
  
     public void setUSER_EMAIL(String USER_EMAIL){
            this.USER_EMAIL=USER_EMAIL;
     };
  
     public void setUSER_ZIPCODE(String USER_ZIPCODE){
            this.USER_ZIPCODE=USER_ZIPCODE;
     };
  
     public void setUSER_ADDR(String USER_ADDR){
            this.USER_ADDR=USER_ADDR;
     };
  
     public void setUSER_ADDR_ETC(String USER_ADDR_ETC){
            this.USER_ADDR_ETC=USER_ADDR_ETC;
     };
  
     public void setUSER_TEL(String USER_TEL){
            this.USER_TEL=USER_TEL;
     };
  
     public void setUSER_MOBILE(String USER_MOBILE){
            this.USER_MOBILE=USER_MOBILE;
     };
  
     public void setUSER_SEX(String USER_SEX){
            this.USER_SEX=USER_SEX;
     };
  
     public void setINP_SITE(String INP_SITE){
            this.INP_SITE=INP_SITE;
     };
  
     public void setSC_CD(String SC_CD){
            this.SC_CD=SC_CD;
     };
  
     public void setSGG_CD(String SGG_CD){
            this.SGG_CD=SGG_CD;
     };
  
     public void setCAPITAL(String CAPITAL){
            this.CAPITAL=CAPITAL;
     };
  
     public void setBIGO(String BIGO){
            this.BIGO=BIGO;
     };
  
     public void setSMS_YN(String SMS_YN){
            this.SMS_YN=SMS_YN;
     };
  
     public void setNEWS_YN(String NEWS_YN){
            this.NEWS_YN=NEWS_YN;
     };
  
     public void setUSE_CODE(String USE_CODE){
            this.USE_CODE=USE_CODE;
     };
  
     public void setINS_DT(Date INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(Date UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("USER_ID:"+ this.getUSER_ID()+"\n");
      
      strB.append("USER_NAME:"+ this.getUSER_NAME()+"\n");
      
      strB.append("USER_PASSWD:"+ this.getUSER_PASSWD()+"\n");
      
      strB.append("USER_NAT_NUM1:"+ this.getUSER_NAT_NUM1()+"\n");
      
      strB.append("USER_NAT_NUM2:"+ this.getUSER_NAT_NUM2()+"\n");
      
      strB.append("USER_EMAIL:"+ this.getUSER_EMAIL()+"\n");
      
      strB.append("USER_ZIPCODE:"+ this.getUSER_ZIPCODE()+"\n");
      
      strB.append("USER_ADDR:"+ this.getUSER_ADDR()+"\n");
      
      strB.append("USER_ADDR_ETC:"+ this.getUSER_ADDR_ETC()+"\n");
      
      strB.append("USER_TEL:"+ this.getUSER_TEL()+"\n");
      
      strB.append("USER_MOBILE:"+ this.getUSER_MOBILE()+"\n");
      
      strB.append("USER_SEX:"+ this.getUSER_SEX()+"\n");
      
      strB.append("INP_SITE:"+ this.getINP_SITE()+"\n");
      
      strB.append("SC_CD:"+ this.getSC_CD()+"\n");
      
      strB.append("SGG_CD:"+ this.getSGG_CD()+"\n");
      
      strB.append("CAPITAL:"+ this.getCAPITAL()+"\n");
      
      strB.append("BIGO:"+ this.getBIGO()+"\n");
      
      strB.append("SMS_YN:"+ this.getSMS_YN()+"\n");
      
      strB.append("NEWS_YN:"+ this.getNEWS_YN()+"\n");
      
      strB.append("USE_CODE:"+ this.getUSE_CODE()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_HOM_USERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_HOM_USERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_HOM_USERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_HOM_USERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_HOM_USERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getUSER_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_HOM_USEREntity();
  }

  public ValueObject getClone(){
         PT_HOM_USEREntity newEnt = new PT_HOM_USEREntity();
	 
          newEnt.setUSER_ID(this.getUSER_ID());
         
          newEnt.setUSER_NAME(this.getUSER_NAME());
         
          newEnt.setUSER_PASSWD(this.getUSER_PASSWD());
         
          newEnt.setUSER_NAT_NUM1(this.getUSER_NAT_NUM1());
         
          newEnt.setUSER_NAT_NUM2(this.getUSER_NAT_NUM2());
         
          newEnt.setUSER_EMAIL(this.getUSER_EMAIL());
         
          newEnt.setUSER_ZIPCODE(this.getUSER_ZIPCODE());
         
          newEnt.setUSER_ADDR(this.getUSER_ADDR());
         
          newEnt.setUSER_ADDR_ETC(this.getUSER_ADDR_ETC());
         
          newEnt.setUSER_TEL(this.getUSER_TEL());
         
          newEnt.setUSER_MOBILE(this.getUSER_MOBILE());
         
          newEnt.setUSER_SEX(this.getUSER_SEX());
         
          newEnt.setINP_SITE(this.getINP_SITE());
         
          newEnt.setSC_CD(this.getSC_CD());
         
          newEnt.setSGG_CD(this.getSGG_CD());
         
          newEnt.setCAPITAL(this.getCAPITAL());
         
          newEnt.setBIGO(this.getBIGO());
         
          newEnt.setSMS_YN(this.getSMS_YN());
         
          newEnt.setNEWS_YN(this.getNEWS_YN());
         
          newEnt.setUSE_CODE(this.getUSE_CODE());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_HOM_USERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUSER_ID();
        
             case 2 :
                 return  this.getUSER_NAME();
        
             case 3 :
                 return  this.getUSER_PASSWD();
        
             case 4 :
                 return  this.getUSER_NAT_NUM1();
        
             case 5 :
                 return  this.getUSER_NAT_NUM2();
        
             case 6 :
                 return  this.getUSER_EMAIL();
        
             case 7 :
                 return  this.getUSER_ZIPCODE();
        
             case 8 :
                 return  this.getUSER_ADDR();
        
             case 9 :
                 return  this.getUSER_ADDR_ETC();
        
             case 10 :
                 return  this.getUSER_TEL();
        
             case 11 :
                 return  this.getUSER_MOBILE();
        
             case 12 :
                 return  this.getUSER_SEX();
        
             case 13 :
                 return  this.getINP_SITE();
        
             case 14 :
                 return  this.getSC_CD();
        
             case 15 :
                 return  this.getSGG_CD();
        
             case 16 :
                 return  this.getCAPITAL();
        
             case 17 :
                 return  this.getBIGO();
        
             case 18 :
                 return  this.getSMS_YN();
        
             case 19 :
                 return  this.getNEWS_YN();
        
             case 20 :
                 return  this.getUSE_CODE();
        
             case 21 :
                 return  this.getINS_DT();
        
             case 22 :
                 return  this.getUPD_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_HOM_USERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setUSER_ID((String)value);
	            return;  
        
             case 2 :
                    this.setUSER_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setUSER_PASSWD((String)value);
	            return;  
        
             case 4 :
                    this.setUSER_NAT_NUM1((String)value);
	            return;  
        
             case 5 :
                    this.setUSER_NAT_NUM2((String)value);
	            return;  
        
             case 6 :
                    this.setUSER_EMAIL((String)value);
	            return;  
        
             case 7 :
                    this.setUSER_ZIPCODE((String)value);
	            return;  
        
             case 8 :
                    this.setUSER_ADDR((String)value);
	            return;  
        
             case 9 :
                    this.setUSER_ADDR_ETC((String)value);
	            return;  
        
             case 10 :
                    this.setUSER_TEL((String)value);
	            return;  
        
             case 11 :
                    this.setUSER_MOBILE((String)value);
	            return;  
        
             case 12 :
                    this.setUSER_SEX((String)value);
	            return;  
        
             case 13 :
                    this.setINP_SITE((String)value);
	            return;  
        
             case 14 :
                    this.setSC_CD((String)value);
	            return;  
        
             case 15 :
                    this.setSGG_CD((String)value);
	            return;  
        
             case 16 :
                    this.setCAPITAL((String)value);
	            return;  
        
             case 17 :
                    this.setBIGO((String)value);
	            return;  
        
             case 18 :
                    this.setSMS_YN((String)value);
	            return;  
        
             case 19 :
                    this.setNEWS_YN((String)value);
	            return;  
        
             case 20 :
                    this.setUSE_CODE((String)value);
	            return;  
        
             case 21 :
                    this.setINS_DT((Date)value);
	            return;  
        
             case 22 :
                    this.setUPD_DT((Date)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_HOM_USERHelper.toXML(this);
  }
  
}
