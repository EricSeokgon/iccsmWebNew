

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_CORRECT
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               CORRECT_ORDER_CONT:VARCHAR2(1024):  
*               CORRECT_ORDER_START_DT:VARCHAR2(8):  
*               CORRECT_ORDER_END_DT:VARCHAR2(8):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               DECISION_DATE:VARCHAR2(8):  
*               LIS_END_DATE:VARCHAR2(8):  
*               BEFORE_DISPO:VARCHAR2(1):  
*               OPINI_SUBMIT:VARCHAR2(1):  
*               OPINI_SUBMIT_DATE:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_CORRECTEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String CORRECT_ORDER_CONT;
  
     private String CORRECT_ORDER_START_DT;
  
     private String CORRECT_ORDER_END_DT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String DECISION_DATE;
  
     private String LIS_END_DATE;
  
     private String BEFORE_DISPO;
  
     private String OPINI_SUBMIT;
  
     private String OPINI_SUBMIT_DATE;
  

//생성자를 만든다
    public PT_M_CORRECTEntity(){
    }
    
    
    public PT_M_CORRECTEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_CORRECTEntity(ValueObject ent) throws Exception{
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
		this.CORRECT_ORDER_CONT =request.getParameter("CORRECT_ORDER_CONT");
		this.CORRECT_ORDER_START_DT =request.getParameter("CORRECT_ORDER_START_DT");
		this.CORRECT_ORDER_END_DT =request.getParameter("CORRECT_ORDER_END_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.DECISION_DATE =request.getParameter("DECISION_DATE");
		this.LIS_END_DATE =request.getParameter("LIS_END_DATE");
		this.BEFORE_DISPO =request.getParameter("BEFORE_DISPO");
		this.OPINI_SUBMIT =request.getParameter("OPINI_SUBMIT");
		this.OPINI_SUBMIT_DATE =request.getParameter("OPINI_SUBMIT_DATE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.CORRECT_ORDER_CONT =KJFMi.dsGet(ds, arg_row, "CORRECT_ORDER_CONT");
		this.CORRECT_ORDER_START_DT =KJFMi.dsGet(ds, arg_row, "CORRECT_ORDER_START_DT");
		this.CORRECT_ORDER_END_DT =KJFMi.dsGet(ds, arg_row, "CORRECT_ORDER_END_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.DECISION_DATE =KJFMi.dsGet(ds, arg_row, "DECISION_DATE");
		this.LIS_END_DATE =KJFMi.dsGet(ds, arg_row, "LIS_END_DATE");
		this.BEFORE_DISPO =KJFMi.dsGet(ds, arg_row, "BEFORE_DISPO");
		this.OPINI_SUBMIT =KJFMi.dsGet(ds, arg_row, "OPINI_SUBMIT");
		this.OPINI_SUBMIT_DATE =KJFMi.dsGet(ds, arg_row, "OPINI_SUBMIT_DATE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getCORRECT_ORDER_CONT(){
             return CORRECT_ORDER_CONT;
     };
  
     public String getCORRECT_ORDER_START_DT(){
             return CORRECT_ORDER_START_DT;
     };
  
     public String getCORRECT_ORDER_END_DT(){
             return CORRECT_ORDER_END_DT;
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
  
     public String getLIS_END_DATE(){
             return LIS_END_DATE;
     };
  
     public String getBEFORE_DISPO(){
             return BEFORE_DISPO;
     };
  
     public String getOPINI_SUBMIT(){
             return OPINI_SUBMIT;
     };
  
     public String getOPINI_SUBMIT_DATE(){
             return OPINI_SUBMIT_DATE;
     };
  

//Setter 함수를 만든다
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setCORRECT_ORDER_CONT(String CORRECT_ORDER_CONT){
            this.CORRECT_ORDER_CONT=CORRECT_ORDER_CONT;
     };
  
     public void setCORRECT_ORDER_START_DT(String CORRECT_ORDER_START_DT){
            this.CORRECT_ORDER_START_DT=CORRECT_ORDER_START_DT;
     };
  
     public void setCORRECT_ORDER_END_DT(String CORRECT_ORDER_END_DT){
            this.CORRECT_ORDER_END_DT=CORRECT_ORDER_END_DT;
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
  
     public void setLIS_END_DATE(String LIS_END_DATE){
            this.LIS_END_DATE=LIS_END_DATE;
     };
  
     public void setBEFORE_DISPO(String BEFORE_DISPO){
            this.BEFORE_DISPO=BEFORE_DISPO;
     };
  
     public void setOPINI_SUBMIT(String OPINI_SUBMIT){
            this.OPINI_SUBMIT=OPINI_SUBMIT;
     };
  
     public void setOPINI_SUBMIT_DATE(String OPINI_SUBMIT_DATE){
            this.OPINI_SUBMIT_DATE=OPINI_SUBMIT_DATE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("CORRECT_ORDER_CONT:"+ this.getCORRECT_ORDER_CONT()+"\n");
      
      strB.append("CORRECT_ORDER_START_DT:"+ this.getCORRECT_ORDER_START_DT()+"\n");
      
      strB.append("CORRECT_ORDER_END_DT:"+ this.getCORRECT_ORDER_END_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("DECISION_DATE:"+ this.getDECISION_DATE()+"\n");
      
      strB.append("LIS_END_DATE:"+ this.getLIS_END_DATE()+"\n");
      
      strB.append("BEFORE_DISPO:"+ this.getBEFORE_DISPO()+"\n");
      
      strB.append("OPINI_SUBMIT:"+ this.getOPINI_SUBMIT()+"\n");
      
      strB.append("OPINI_SUBMIT_DATE:"+ this.getOPINI_SUBMIT_DATE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_CORRECTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_CORRECTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_CORRECTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_CORRECTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_CORRECTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_CORRECTEntity();
  }

  public ValueObject getClone(){
         PT_M_CORRECTEntity newEnt = new PT_M_CORRECTEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setCORRECT_ORDER_CONT(this.getCORRECT_ORDER_CONT());
         
          newEnt.setCORRECT_ORDER_START_DT(this.getCORRECT_ORDER_START_DT());
         
          newEnt.setCORRECT_ORDER_END_DT(this.getCORRECT_ORDER_END_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setDECISION_DATE(this.getDECISION_DATE());
         
          newEnt.setLIS_END_DATE(this.getLIS_END_DATE());
         
          newEnt.setBEFORE_DISPO(this.getBEFORE_DISPO());
         
          newEnt.setOPINI_SUBMIT(this.getOPINI_SUBMIT());
         
          newEnt.setOPINI_SUBMIT_DATE(this.getOPINI_SUBMIT_DATE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_CORRECTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getCORRECT_ORDER_CONT();
        
             case 4 :
                 return  this.getCORRECT_ORDER_START_DT();
        
             case 5 :
                 return  this.getCORRECT_ORDER_END_DT();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getDECISION_DATE();
        
             case 10 :
                 return  this.getLIS_END_DATE();
        
             case 11 :
                 return  this.getBEFORE_DISPO();
        
             case 12 :
                 return  this.getOPINI_SUBMIT();
        
             case 13 :
                 return  this.getOPINI_SUBMIT_DATE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_CORRECTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setCORRECT_ORDER_CONT((String)value);
	            return;  
        
             case 4 :
                    this.setCORRECT_ORDER_START_DT((String)value);
	            return;  
        
             case 5 :
                    this.setCORRECT_ORDER_END_DT((String)value);
	            return;  
        
             case 6 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 7 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 9 :
                    this.setDECISION_DATE((String)value);
	            return;  
        
             case 10 :
                    this.setLIS_END_DATE((String)value);
	            return;  
        
             case 11 :
                    this.setBEFORE_DISPO((String)value);
	            return;  
        
             case 12 :
                    this.setOPINI_SUBMIT((String)value);
	            return;  
        
             case 13 :
                    this.setOPINI_SUBMIT_DATE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_CORRECTHelper.toXML(this);
  }
  
}
