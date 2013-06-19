

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SMS_LOG
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               USER_ID:VARCHAR2(12):  
*               LOCAL_CD:VARCHAR2(4):  
*               AREA_CD:VARCHAR2(5):  
*               FROM_TEL:VARCHAR2(14):  
*               TO_TEL:VARCHAR2(14):  
*               MSG:VARCHAR2(82):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               RESULT:CHAR(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_SMS_LOGEntity extends ValueObject{

  
     private String USER_ID;
  
     private String LOCAL_CD;
  
     private String AREA_CD;
  
     private String FROM_TEL;
  
     private String TO_TEL;
  
     private String MSG;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String RESULT;
  

//생성자를 만든다
    public PT_SMS_LOGEntity(){
    }
    
      
    public PT_SMS_LOGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.USER_ID =request.getParameter("USER_ID");
		this.LOCAL_CD =request.getParameter("LOCAL_CD");
		this.AREA_CD =request.getParameter("AREA_CD");
		this.FROM_TEL =request.getParameter("FROM_TEL");
		this.TO_TEL =request.getParameter("TO_TEL");
		this.MSG =request.getParameter("MSG");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.RESULT =request.getParameter("RESULT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.USER_ID =KJFMi.dsGet(ds, arg_row, "USER_ID");
		this.LOCAL_CD =KJFMi.dsGet(ds, arg_row, "LOCAL_CD");
		this.AREA_CD =KJFMi.dsGet(ds, arg_row, "AREA_CD");
		this.FROM_TEL =KJFMi.dsGet(ds, arg_row, "FROM_TEL");
		this.TO_TEL =KJFMi.dsGet(ds, arg_row, "TO_TEL");
		this.MSG =KJFMi.dsGet(ds, arg_row, "MSG");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.RESULT =KJFMi.dsGet(ds, arg_row, "RESULT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getUSER_ID(){
             return USER_ID;
     };
  
     public String getLOCAL_CD(){
             return LOCAL_CD;
     };
  
     public String getAREA_CD(){
             return AREA_CD;
     };
  
     public String getFROM_TEL(){
             return FROM_TEL;
     };
  
     public String getTO_TEL(){
             return TO_TEL;
     };
  
     public String getMSG(){
             return MSG;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getRESULT(){
             return RESULT;
     };
  

//Setter 함수를 만든다
  
     public void setUSER_ID(String USER_ID){
            this.USER_ID=USER_ID;
     };
  
     public void setLOCAL_CD(String LOCAL_CD){
            this.LOCAL_CD=LOCAL_CD;
     };
  
     public void setAREA_CD(String AREA_CD){
            this.AREA_CD=AREA_CD;
     };
  
     public void setFROM_TEL(String FROM_TEL){
            this.FROM_TEL=FROM_TEL;
     };
  
     public void setTO_TEL(String TO_TEL){
            this.TO_TEL=TO_TEL;
     };
  
     public void setMSG(String MSG){
            this.MSG=MSG;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setRESULT(String RESULT){
            this.RESULT=RESULT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("USER_ID:"+ this.getUSER_ID()+"\n");
      
      strB.append("LOCAL_CD:"+ this.getLOCAL_CD()+"\n");
      
      strB.append("AREA_CD:"+ this.getAREA_CD()+"\n");
      
      strB.append("FROM_TEL:"+ this.getFROM_TEL()+"\n");
      
      strB.append("TO_TEL:"+ this.getTO_TEL()+"\n");
      
      strB.append("MSG:"+ this.getMSG()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("RESULT:"+ this.getRESULT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_SMS_LOGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_SMS_LOGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_SMS_LOGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_SMS_LOGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_SMS_LOGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_SMS_LOGEntity();
  }

  public ValueObject getClone(){
         PT_SMS_LOGEntity newEnt = new PT_SMS_LOGEntity();
	 
          newEnt.setUSER_ID(this.getUSER_ID());
         
          newEnt.setLOCAL_CD(this.getLOCAL_CD());
         
          newEnt.setAREA_CD(this.getAREA_CD());
         
          newEnt.setFROM_TEL(this.getFROM_TEL());
         
          newEnt.setTO_TEL(this.getTO_TEL());
         
          newEnt.setMSG(this.getMSG());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setRESULT(this.getRESULT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_SMS_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUSER_ID();
        
             case 2 :
                 return  this.getLOCAL_CD();
        
             case 3 :
                 return  this.getAREA_CD();
        
             case 4 :
                 return  this.getFROM_TEL();
        
             case 5 :
                 return  this.getTO_TEL();
        
             case 6 :
                 return  this.getMSG();
        
             case 7 :
                 return  this.getINS_DT();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getRESULT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_SMS_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setUSER_ID((String)value);
	            return;  
        
             case 2 :
                    this.setLOCAL_CD((String)value);
	            return;  
        
             case 3 :
                    this.setAREA_CD((String)value);
	            return;  
        
             case 4 :
                    this.setFROM_TEL((String)value);
	            return;  
        
             case 5 :
                    this.setTO_TEL((String)value);
	            return;  
        
             case 6 :
                    this.setMSG((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setRESULT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_SMS_LOGHelper.toXML(this);
  }
  
}
