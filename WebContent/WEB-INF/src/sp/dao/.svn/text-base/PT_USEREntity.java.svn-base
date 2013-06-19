

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_USER
*  테이블 설명 :
*  테이블 PK   :  
*               USER_CODE
*  테이블 컬럼 :  
*               USER_CODE:VARCHAR2(10):  
*               USER_NAME:VARCHAR2(40):  
*               USER_ID:VARCHAR2(12):  
*               USER_PASSWD:VARCHAR2(12):  
*               USER_EMAIL:VARCHAR2(60):  
*               USER_TEL:VARCHAR2(14):  
*               USER_MOBILE:VARCHAR2(14):  
*               USER_NAT_NUM:VARCHAR2(14):  
*               POST:VARCHAR2(40):  
*               EMAIL:VARCHAR2(50):  
*               CAPITAL:VARCHAR2(20):  
*               USE_YN:VARCHAR2(1):  
*               REG_DATE:VARCHAR2(30):  
*               MOD_DATE:VARCHAR2(10):  
*               LAST_CONN:VARCHAR2(20):  
*               ORGANIZATION:VARCHAR2(40):  
*               POSITION:VARCHAR2(50):  
*               STAFF_SYSTEM:VARCHAR2(40):  
*               STAFF_LEVEL:VARCHAR2(40):  
*               USER_AUTH:VARCHAR2(20):  
*               USER_LEVEL:NUMBER(22):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_USEREntity extends ValueObject{

  
     private String USER_CODE;
  
     private String USER_NAME;
  
     private String USER_ID;
  
     private String USER_PASSWD;
  
     private String USER_EMAIL;
  
     private String USER_TEL;
  
     private String USER_MOBILE;
  
     private String USER_NAT_NUM;
  
     private String POST;
  
     private String EMAIL;
  
     private String CAPITAL;
  
     private String USE_YN;
  
     private String REG_DATE;
  
     private String MOD_DATE;
  
     private String LAST_CONN;
  
     private String ORGANIZATION;
  
     private String POSITION;
  
     private String STAFF_SYSTEM;
  
     private String STAFF_LEVEL;
  
     private String USER_AUTH;
  
     private String USER_LEVEL;
  

//생성자를 만든다
    public PT_USEREntity(){
    }
    
    
    public PT_USEREntity(String USER_CODE ){
       this.setUSER_CODE(USER_CODE);
       
    }
      
    public PT_USEREntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("USER_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("USER_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.USER_CODE =request.getParameter("USER_CODE");
		this.USER_NAME =request.getParameter("USER_NAME");
		this.USER_ID =request.getParameter("USER_ID");
		this.USER_PASSWD =request.getParameter("USER_PASSWD");
		this.USER_EMAIL =request.getParameter("USER_EMAIL");
		this.USER_TEL =request.getParameter("USER_TEL");
		this.USER_MOBILE =request.getParameter("USER_MOBILE");
		this.USER_NAT_NUM =request.getParameter("USER_NAT_NUM");
		this.POST =request.getParameter("POST");
		this.EMAIL =request.getParameter("EMAIL");
		this.CAPITAL =request.getParameter("CAPITAL");
		this.USE_YN =request.getParameter("USE_YN");
		this.REG_DATE =request.getParameter("REG_DATE");
		this.MOD_DATE =request.getParameter("MOD_DATE");
		this.LAST_CONN =request.getParameter("LAST_CONN");
		this.ORGANIZATION =request.getParameter("ORGANIZATION");
		this.POSITION =request.getParameter("POSITION");
		this.STAFF_SYSTEM =request.getParameter("STAFF_SYSTEM");
		this.STAFF_LEVEL =request.getParameter("STAFF_LEVEL");
		this.USER_AUTH =request.getParameter("USER_AUTH");
		this.USER_LEVEL =request.getParameter("USER_LEVEL");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.USER_CODE =KJFMi.dsGet(ds, arg_row, "USER_CODE");
		this.USER_NAME =KJFMi.dsGet(ds, arg_row, "USER_NAME");
		this.USER_ID =KJFMi.dsGet(ds, arg_row, "USER_ID");
		this.USER_PASSWD =KJFMi.dsGet(ds, arg_row, "USER_PASSWD");
		this.USER_EMAIL =KJFMi.dsGet(ds, arg_row, "USER_EMAIL");
		this.USER_TEL =KJFMi.dsGet(ds, arg_row, "USER_TEL");
		this.USER_MOBILE =KJFMi.dsGet(ds, arg_row, "USER_MOBILE");
		this.USER_NAT_NUM =KJFMi.dsGet(ds, arg_row, "USER_NAT_NUM");
		this.POST =KJFMi.dsGet(ds, arg_row, "POST");
		this.EMAIL =KJFMi.dsGet(ds, arg_row, "EMAIL");
		this.CAPITAL =KJFMi.dsGet(ds, arg_row, "CAPITAL");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
		this.REG_DATE =KJFMi.dsGet(ds, arg_row, "REG_DATE");
		this.MOD_DATE =KJFMi.dsGet(ds, arg_row, "MOD_DATE");
		this.LAST_CONN =KJFMi.dsGet(ds, arg_row, "LAST_CONN");
		this.ORGANIZATION =KJFMi.dsGet(ds, arg_row, "ORGANIZATION");
		this.POSITION =KJFMi.dsGet(ds, arg_row, "POSITION");
		this.STAFF_SYSTEM =KJFMi.dsGet(ds, arg_row, "STAFF_SYSTEM");
		this.STAFF_LEVEL =KJFMi.dsGet(ds, arg_row, "STAFF_LEVEL");
		this.USER_AUTH =KJFMi.dsGet(ds, arg_row, "USER_AUTH");
		this.USER_LEVEL =KJFMi.dsGet(ds, arg_row, "USER_LEVEL");
				
    }    
    
//Getter 함수를 만든다
  
     public String getUSER_CODE(){
             return USER_CODE;
     };
  
     public String getUSER_NAME(){
             return USER_NAME;
     };
  
     public String getUSER_ID(){
             return USER_ID;
     };
  
     public String getUSER_PASSWD(){
             return USER_PASSWD;
     };
  
     public String getUSER_EMAIL(){
             return USER_EMAIL;
     };
  
     public String getUSER_TEL(){
             return USER_TEL;
     };
  
     public String getUSER_MOBILE(){
             return USER_MOBILE;
     };
  
     public String getUSER_NAT_NUM(){
             return USER_NAT_NUM;
     };
  
     public String getPOST(){
             return POST;
     };
  
     public String getEMAIL(){
             return EMAIL;
     };
  
     public String getCAPITAL(){
             return CAPITAL;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  
     public String getREG_DATE(){
             return REG_DATE;
     };
  
     public String getMOD_DATE(){
             return MOD_DATE;
     };
  
     public String getLAST_CONN(){
             return LAST_CONN;
     };
  
     public String getORGANIZATION(){
             return ORGANIZATION;
     };
  
     public String getPOSITION(){
             return POSITION;
     };
  
     public String getSTAFF_SYSTEM(){
             return STAFF_SYSTEM;
     };
  
     public String getSTAFF_LEVEL(){
             return STAFF_LEVEL;
     };
  
     public String getUSER_AUTH(){
             return USER_AUTH;
     };
  
     public String getUSER_LEVEL(){
             return USER_LEVEL;
     };
  

//Setter 함수를 만든다
  
     public void setUSER_CODE(String USER_CODE){
            this.USER_CODE=USER_CODE;
     };
  
     public void setUSER_NAME(String USER_NAME){
            this.USER_NAME=USER_NAME;
     };
  
     public void setUSER_ID(String USER_ID){
            this.USER_ID=USER_ID;
     };
  
     public void setUSER_PASSWD(String USER_PASSWD){
            this.USER_PASSWD=USER_PASSWD;
     };
  
     public void setUSER_EMAIL(String USER_EMAIL){
            this.USER_EMAIL=USER_EMAIL;
     };
  
     public void setUSER_TEL(String USER_TEL){
            this.USER_TEL=USER_TEL;
     };
  
     public void setUSER_MOBILE(String USER_MOBILE){
            this.USER_MOBILE=USER_MOBILE;
     };
  
     public void setUSER_NAT_NUM(String USER_NAT_NUM){
            this.USER_NAT_NUM=USER_NAT_NUM;
     };
  
     public void setPOST(String POST){
            this.POST=POST;
     };
  
     public void setEMAIL(String EMAIL){
            this.EMAIL=EMAIL;
     };
  
     public void setCAPITAL(String CAPITAL){
            this.CAPITAL=CAPITAL;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
     public void setREG_DATE(String REG_DATE){
            this.REG_DATE=REG_DATE;
     };
  
     public void setMOD_DATE(String MOD_DATE){
            this.MOD_DATE=MOD_DATE;
     };
  
     public void setLAST_CONN(String LAST_CONN){
            this.LAST_CONN=LAST_CONN;
     };
  
     public void setORGANIZATION(String ORGANIZATION){
            this.ORGANIZATION=ORGANIZATION;
     };
  
     public void setPOSITION(String POSITION){
            this.POSITION=POSITION;
     };
  
     public void setSTAFF_SYSTEM(String STAFF_SYSTEM){
            this.STAFF_SYSTEM=STAFF_SYSTEM;
     };
  
     public void setSTAFF_LEVEL(String STAFF_LEVEL){
            this.STAFF_LEVEL=STAFF_LEVEL;
     };
  
     public void setUSER_AUTH(String USER_AUTH){
            this.USER_AUTH=USER_AUTH;
     };
  
     public void setUSER_LEVEL(String USER_LEVEL){
            this.USER_LEVEL=USER_LEVEL;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("USER_CODE:"+ this.getUSER_CODE()+"\n");
      
      strB.append("USER_NAME:"+ this.getUSER_NAME()+"\n");
      
      strB.append("USER_ID:"+ this.getUSER_ID()+"\n");
      
      strB.append("USER_PASSWD:"+ this.getUSER_PASSWD()+"\n");
      
      strB.append("USER_EMAIL:"+ this.getUSER_EMAIL()+"\n");
      
      strB.append("USER_TEL:"+ this.getUSER_TEL()+"\n");
      
      strB.append("USER_MOBILE:"+ this.getUSER_MOBILE()+"\n");
      
      strB.append("USER_NAT_NUM:"+ this.getUSER_NAT_NUM()+"\n");
      
      strB.append("POST:"+ this.getPOST()+"\n");
      
      strB.append("EMAIL:"+ this.getEMAIL()+"\n");
      
      strB.append("CAPITAL:"+ this.getCAPITAL()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      strB.append("REG_DATE:"+ this.getREG_DATE()+"\n");
      
      strB.append("MOD_DATE:"+ this.getMOD_DATE()+"\n");
      
      strB.append("LAST_CONN:"+ this.getLAST_CONN()+"\n");
      
      strB.append("ORGANIZATION:"+ this.getORGANIZATION()+"\n");
      
      strB.append("POSITION:"+ this.getPOSITION()+"\n");
      
      strB.append("STAFF_SYSTEM:"+ this.getSTAFF_SYSTEM()+"\n");
      
      strB.append("STAFF_LEVEL:"+ this.getSTAFF_LEVEL()+"\n");
      
      strB.append("USER_AUTH:"+ this.getUSER_AUTH()+"\n");
      
      strB.append("USER_LEVEL:"+ this.getUSER_LEVEL()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_USERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_USERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_USERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_USERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_USERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getUSER_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_USEREntity();
  }

  public ValueObject getClone(){
         PT_USEREntity newEnt = new PT_USEREntity();
	 
          newEnt.setUSER_CODE(this.getUSER_CODE());
         
          newEnt.setUSER_NAME(this.getUSER_NAME());
         
          newEnt.setUSER_ID(this.getUSER_ID());
         
          newEnt.setUSER_PASSWD(this.getUSER_PASSWD());
         
          newEnt.setUSER_EMAIL(this.getUSER_EMAIL());
         
          newEnt.setUSER_TEL(this.getUSER_TEL());
         
          newEnt.setUSER_MOBILE(this.getUSER_MOBILE());
         
          newEnt.setUSER_NAT_NUM(this.getUSER_NAT_NUM());
         
          newEnt.setPOST(this.getPOST());
         
          newEnt.setEMAIL(this.getEMAIL());
         
          newEnt.setCAPITAL(this.getCAPITAL());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
          newEnt.setREG_DATE(this.getREG_DATE());
         
          newEnt.setMOD_DATE(this.getMOD_DATE());
         
          newEnt.setLAST_CONN(this.getLAST_CONN());
         
          newEnt.setORGANIZATION(this.getORGANIZATION());
         
          newEnt.setPOSITION(this.getPOSITION());
         
          newEnt.setSTAFF_SYSTEM(this.getSTAFF_SYSTEM());
         
          newEnt.setSTAFF_LEVEL(this.getSTAFF_LEVEL());
         
          newEnt.setUSER_AUTH(this.getUSER_AUTH());
         
          newEnt.setUSER_LEVEL(this.getUSER_LEVEL());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_USERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUSER_CODE();
        
             case 2 :
                 return  this.getUSER_NAME();
        
             case 3 :
                 return  this.getUSER_ID();
        
             case 4 :
                 return  this.getUSER_PASSWD();
        
             case 5 :
                 return  this.getUSER_EMAIL();
        
             case 6 :
                 return  this.getUSER_TEL();
        
             case 7 :
                 return  this.getUSER_MOBILE();
        
             case 8 :
                 return  this.getUSER_NAT_NUM();
        
             case 9 :
                 return  this.getPOST();
        
             case 10 :
                 return  this.getEMAIL();
        
             case 11 :
                 return  this.getCAPITAL();
        
             case 12 :
                 return  this.getUSE_YN();
        
             case 13 :
                 return  this.getREG_DATE();
        
             case 14 :
                 return  this.getMOD_DATE();
        
             case 15 :
                 return  this.getLAST_CONN();
        
             case 16 :
                 return  this.getORGANIZATION();
        
             case 17 :
                 return  this.getPOSITION();
        
             case 18 :
                 return  this.getSTAFF_SYSTEM();
        
             case 19 :
                 return  this.getSTAFF_LEVEL();
        
             case 20 :
                 return  this.getUSER_AUTH();
        
             case 21 :
                 return  this.getUSER_LEVEL();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_USERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setUSER_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setUSER_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setUSER_ID((String)value);
	            return;  
        
             case 4 :
                    this.setUSER_PASSWD((String)value);
	            return;  
        
             case 5 :
                    this.setUSER_EMAIL((String)value);
	            return;  
        
             case 6 :
                    this.setUSER_TEL((String)value);
	            return;  
        
             case 7 :
                    this.setUSER_MOBILE((String)value);
	            return;  
        
             case 8 :
                    this.setUSER_NAT_NUM((String)value);
	            return;  
        
             case 9 :
                    this.setPOST((String)value);
	            return;  
        
             case 10 :
                    this.setEMAIL((String)value);
	            return;  
        
             case 11 :
                    this.setCAPITAL((String)value);
	            return;  
        
             case 12 :
                    this.setUSE_YN((String)value);
	            return;  
        
             case 13 :
                    this.setREG_DATE((String)value);
	            return;  
        
             case 14 :
                    this.setMOD_DATE((String)value);
	            return;  
        
             case 15 :
                    this.setLAST_CONN((String)value);
	            return;  
        
             case 16 :
                    this.setORGANIZATION((String)value);
	            return;  
        
             case 17 :
                    this.setPOSITION((String)value);
	            return;  
        
             case 18 :
                    this.setSTAFF_SYSTEM((String)value);
	            return;  
        
             case 19 :
                    this.setSTAFF_LEVEL((String)value);
	            return;  
        
             case 20 :
                    this.setUSER_AUTH((String)value);
	            return;  
        
             case 21 :
                    this.setUSER_LEVEL((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_USERHelper.toXML(this);
  }
  
}
