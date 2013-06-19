

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_REGIST_CANCEL
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               AUDI_EXEC_YN:VARCHAR2(1):  
*               AUDI_NONEXEC_CAUSE:VARCHAR2(512):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               DECISION_DATE:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_REGIST_CANCELEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String AUDI_EXEC_YN;
  
     private String AUDI_NONEXEC_CAUSE;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String DECISION_DATE;
  

//생성자를 만든다
    public PT_M_REGIST_CANCELEntity(){
    }
    
    
    public PT_M_REGIST_CANCELEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_REGIST_CANCELEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
       value = ent.getByName("WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.AUDI_EXEC_YN =request.getParameter("AUDI_EXEC_YN");
		this.AUDI_NONEXEC_CAUSE =request.getParameter("AUDI_NONEXEC_CAUSE");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.DECISION_DATE =request.getParameter("DECISION_DATE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.AUDI_EXEC_YN =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_YN");
		this.AUDI_NONEXEC_CAUSE =KJFMi.dsGet(ds, arg_row, "AUDI_NONEXEC_CAUSE");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.DECISION_DATE =KJFMi.dsGet(ds, arg_row, "DECISION_DATE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getAUDI_EXEC_YN(){
             return AUDI_EXEC_YN;
     };
  
     public String getAUDI_NONEXEC_CAUSE(){
             return AUDI_NONEXEC_CAUSE;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getDECISION_DATE(){
             return DECISION_DATE;
     };
  

//Setter 함수를 만든다
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setAUDI_EXEC_YN(String AUDI_EXEC_YN){
            this.AUDI_EXEC_YN=AUDI_EXEC_YN;
     };
  
     public void setAUDI_NONEXEC_CAUSE(String AUDI_NONEXEC_CAUSE){
            this.AUDI_NONEXEC_CAUSE=AUDI_NONEXEC_CAUSE;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setDECISION_DATE(String DECISION_DATE){
            this.DECISION_DATE=DECISION_DATE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("AUDI_EXEC_YN:"+ this.getAUDI_EXEC_YN()+"\n");
      
      strB.append("AUDI_NONEXEC_CAUSE:"+ this.getAUDI_NONEXEC_CAUSE()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("DECISION_DATE:"+ this.getDECISION_DATE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_REGIST_CANCELHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_REGIST_CANCELHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_REGIST_CANCELHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_REGIST_CANCELHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_REGIST_CANCELHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_REGIST_CANCELEntity();
  }

  public ValueObject getClone(){
         PT_M_REGIST_CANCELEntity newEnt = new PT_M_REGIST_CANCELEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setAUDI_EXEC_YN(this.getAUDI_EXEC_YN());
         
          newEnt.setAUDI_NONEXEC_CAUSE(this.getAUDI_NONEXEC_CAUSE());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setDECISION_DATE(this.getDECISION_DATE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_REGIST_CANCELHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getAUDI_EXEC_YN();
        
             case 4 :
                 return  this.getAUDI_NONEXEC_CAUSE();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getDECISION_DATE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_REGIST_CANCELHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setAUDI_EXEC_YN((String)value);
	            return;  
        
             case 4 :
                    this.setAUDI_NONEXEC_CAUSE((String)value);
	            return;  
        
             case 5 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 8 :
                    this.setDECISION_DATE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_REGIST_CANCELHelper.toXML(this);
  }
  
}
