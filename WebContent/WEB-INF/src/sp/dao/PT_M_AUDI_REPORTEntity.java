

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_AUDI_REPORT
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               AUDI_SUBJ:VARCHAR2(50):  
*               ADMI_DISPO_CAUSE:VARCHAR2(1024):  
*               ADMI_DISPO_CONT:VARCHAR2(6):  
*               AUDI_SUPINT_PART:VARCHAR2(50):  
*               AUDI_SUPINT_POS:VARCHAR2(50):  
*               AUDI_SUPINT_NM:VARCHAR2(20):  
*               AUDI_PER_NM:VARCHAR2(60):  
*               AUDI_PER_ADDR:VARCHAR2(200):  
*               LEG_BAS:VARCHAR2(6):  
*               AUDI_EXEC_ORG:VARCHAR2(40):  
*               AUDI_EXEC_PART:VARCHAR2(50):  
*               AUDI_EXEC_ADDR:VARCHAR2(100):  
*               AUDI_EXEC_DETAILADDR:VARCHAR2(100):  
*               AUDI_EXEC_DT:VARCHAR2(8):  
*               AUDI_EXEC_TIME:VARCHAR2(4):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_AUDI_REPORTEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String AUDI_SUBJ;
  
     private String ADMI_DISPO_CAUSE;
  
     private String ADMI_DISPO_CONT;
  
     private String AUDI_SUPINT_PART;
  
     private String AUDI_SUPINT_POS;
  
     private String AUDI_SUPINT_NM;
  
     private String AUDI_PER_NM;
  
     private String AUDI_PER_ADDR;
  
     private String LEG_BAS;
  
     private String AUDI_EXEC_ORG;
  
     private String AUDI_EXEC_PART;
  
     private String AUDI_EXEC_ADDR;
  
     private String AUDI_EXEC_DETAILADDR;
  
     private String AUDI_EXEC_DT;
  
     private String AUDI_EXEC_TIME;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  

//생성자를 만든다
    public PT_M_AUDI_REPORTEntity(){
    }
    
    
    public PT_M_AUDI_REPORTEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_AUDI_REPORTEntity(ValueObject ent) throws Exception{
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
		this.AUDI_SUBJ =request.getParameter("AUDI_SUBJ");
		this.ADMI_DISPO_CAUSE =request.getParameter("ADMI_DISPO_CAUSE");
		this.ADMI_DISPO_CONT =request.getParameter("ADMI_DISPO_CONT");
		this.AUDI_SUPINT_PART =request.getParameter("AUDI_SUPINT_PART");
		this.AUDI_SUPINT_POS =request.getParameter("AUDI_SUPINT_POS");
		this.AUDI_SUPINT_NM =request.getParameter("AUDI_SUPINT_NM");
		this.AUDI_PER_NM =request.getParameter("AUDI_PER_NM");
		this.AUDI_PER_ADDR =request.getParameter("AUDI_PER_ADDR");
		this.LEG_BAS =request.getParameter("LEG_BAS");
		this.AUDI_EXEC_ORG =request.getParameter("AUDI_EXEC_ORG");
		this.AUDI_EXEC_PART =request.getParameter("AUDI_EXEC_PART");
		this.AUDI_EXEC_ADDR =request.getParameter("AUDI_EXEC_ADDR");
		this.AUDI_EXEC_DETAILADDR =request.getParameter("AUDI_EXEC_DETAILADDR");
		this.AUDI_EXEC_DT =request.getParameter("AUDI_EXEC_DT");
		this.AUDI_EXEC_TIME =request.getParameter("AUDI_EXEC_TIME");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.AUDI_SUBJ =KJFMi.dsGet(ds, arg_row, "AUDI_SUBJ");
		this.ADMI_DISPO_CAUSE =KJFMi.dsGet(ds, arg_row, "ADMI_DISPO_CAUSE");
		this.ADMI_DISPO_CONT =KJFMi.dsGet(ds, arg_row, "ADMI_DISPO_CONT");
		this.AUDI_SUPINT_PART =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_PART");
		this.AUDI_SUPINT_POS =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_POS");
		this.AUDI_SUPINT_NM =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_NM");
		this.AUDI_PER_NM =KJFMi.dsGet(ds, arg_row, "AUDI_PER_NM");
		this.AUDI_PER_ADDR =KJFMi.dsGet(ds, arg_row, "AUDI_PER_ADDR");
		this.LEG_BAS =KJFMi.dsGet(ds, arg_row, "LEG_BAS");
		this.AUDI_EXEC_ORG =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_ORG");
		this.AUDI_EXEC_PART =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_PART");
		this.AUDI_EXEC_ADDR =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_ADDR");
		this.AUDI_EXEC_DETAILADDR =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_DETAILADDR");
		this.AUDI_EXEC_DT =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_DT");
		this.AUDI_EXEC_TIME =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_TIME");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getAUDI_SUBJ(){
             return AUDI_SUBJ;
     };
  
     public String getADMI_DISPO_CAUSE(){
             return ADMI_DISPO_CAUSE;
     };
  
     public String getADMI_DISPO_CONT(){
             return ADMI_DISPO_CONT;
     };
  
     public String getAUDI_SUPINT_PART(){
             return AUDI_SUPINT_PART;
     };
  
     public String getAUDI_SUPINT_POS(){
             return AUDI_SUPINT_POS;
     };
  
     public String getAUDI_SUPINT_NM(){
             return AUDI_SUPINT_NM;
     };
  
     public String getAUDI_PER_NM(){
             return AUDI_PER_NM;
     };
  
     public String getAUDI_PER_ADDR(){
             return AUDI_PER_ADDR;
     };
  
     public String getLEG_BAS(){
             return LEG_BAS;
     };
  
     public String getAUDI_EXEC_ORG(){
             return AUDI_EXEC_ORG;
     };
  
     public String getAUDI_EXEC_PART(){
             return AUDI_EXEC_PART;
     };
  
     public String getAUDI_EXEC_ADDR(){
             return AUDI_EXEC_ADDR;
     };
  
     public String getAUDI_EXEC_DETAILADDR(){
             return AUDI_EXEC_DETAILADDR;
     };
  
     public String getAUDI_EXEC_DT(){
             return AUDI_EXEC_DT;
     };
  
     public String getAUDI_EXEC_TIME(){
             return AUDI_EXEC_TIME;
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
  

//Setter 함수를 만든다
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setAUDI_SUBJ(String AUDI_SUBJ){
            this.AUDI_SUBJ=AUDI_SUBJ;
     };
  
     public void setADMI_DISPO_CAUSE(String ADMI_DISPO_CAUSE){
            this.ADMI_DISPO_CAUSE=ADMI_DISPO_CAUSE;
     };
  
     public void setADMI_DISPO_CONT(String ADMI_DISPO_CONT){
            this.ADMI_DISPO_CONT=ADMI_DISPO_CONT;
     };
  
     public void setAUDI_SUPINT_PART(String AUDI_SUPINT_PART){
            this.AUDI_SUPINT_PART=AUDI_SUPINT_PART;
     };
  
     public void setAUDI_SUPINT_POS(String AUDI_SUPINT_POS){
            this.AUDI_SUPINT_POS=AUDI_SUPINT_POS;
     };
  
     public void setAUDI_SUPINT_NM(String AUDI_SUPINT_NM){
            this.AUDI_SUPINT_NM=AUDI_SUPINT_NM;
     };
  
     public void setAUDI_PER_NM(String AUDI_PER_NM){
            this.AUDI_PER_NM=AUDI_PER_NM;
     };
  
     public void setAUDI_PER_ADDR(String AUDI_PER_ADDR){
            this.AUDI_PER_ADDR=AUDI_PER_ADDR;
     };
  
     public void setLEG_BAS(String LEG_BAS){
            this.LEG_BAS=LEG_BAS;
     };
  
     public void setAUDI_EXEC_ORG(String AUDI_EXEC_ORG){
            this.AUDI_EXEC_ORG=AUDI_EXEC_ORG;
     };
  
     public void setAUDI_EXEC_PART(String AUDI_EXEC_PART){
            this.AUDI_EXEC_PART=AUDI_EXEC_PART;
     };
  
     public void setAUDI_EXEC_ADDR(String AUDI_EXEC_ADDR){
            this.AUDI_EXEC_ADDR=AUDI_EXEC_ADDR;
     };
  
     public void setAUDI_EXEC_DETAILADDR(String AUDI_EXEC_DETAILADDR){
            this.AUDI_EXEC_DETAILADDR=AUDI_EXEC_DETAILADDR;
     };
  
     public void setAUDI_EXEC_DT(String AUDI_EXEC_DT){
            this.AUDI_EXEC_DT=AUDI_EXEC_DT;
     };
  
     public void setAUDI_EXEC_TIME(String AUDI_EXEC_TIME){
            this.AUDI_EXEC_TIME=AUDI_EXEC_TIME;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("AUDI_SUBJ:"+ this.getAUDI_SUBJ()+"\n");
      
      strB.append("ADMI_DISPO_CAUSE:"+ this.getADMI_DISPO_CAUSE()+"\n");
      
      strB.append("ADMI_DISPO_CONT:"+ this.getADMI_DISPO_CONT()+"\n");
      
      strB.append("AUDI_SUPINT_PART:"+ this.getAUDI_SUPINT_PART()+"\n");
      
      strB.append("AUDI_SUPINT_POS:"+ this.getAUDI_SUPINT_POS()+"\n");
      
      strB.append("AUDI_SUPINT_NM:"+ this.getAUDI_SUPINT_NM()+"\n");
      
      strB.append("AUDI_PER_NM:"+ this.getAUDI_PER_NM()+"\n");
      
      strB.append("AUDI_PER_ADDR:"+ this.getAUDI_PER_ADDR()+"\n");
      
      strB.append("LEG_BAS:"+ this.getLEG_BAS()+"\n");
      
      strB.append("AUDI_EXEC_ORG:"+ this.getAUDI_EXEC_ORG()+"\n");
      
      strB.append("AUDI_EXEC_PART:"+ this.getAUDI_EXEC_PART()+"\n");
      
      strB.append("AUDI_EXEC_ADDR:"+ this.getAUDI_EXEC_ADDR()+"\n");
      
      strB.append("AUDI_EXEC_DETAILADDR:"+ this.getAUDI_EXEC_DETAILADDR()+"\n");
      
      strB.append("AUDI_EXEC_DT:"+ this.getAUDI_EXEC_DT()+"\n");
      
      strB.append("AUDI_EXEC_TIME:"+ this.getAUDI_EXEC_TIME()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_AUDI_REPORTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_AUDI_REPORTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_AUDI_REPORTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_AUDI_REPORTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_AUDI_REPORTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_AUDI_REPORTEntity();
  }

  public ValueObject getClone(){
         PT_M_AUDI_REPORTEntity newEnt = new PT_M_AUDI_REPORTEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setAUDI_SUBJ(this.getAUDI_SUBJ());
         
          newEnt.setADMI_DISPO_CAUSE(this.getADMI_DISPO_CAUSE());
         
          newEnt.setADMI_DISPO_CONT(this.getADMI_DISPO_CONT());
         
          newEnt.setAUDI_SUPINT_PART(this.getAUDI_SUPINT_PART());
         
          newEnt.setAUDI_SUPINT_POS(this.getAUDI_SUPINT_POS());
         
          newEnt.setAUDI_SUPINT_NM(this.getAUDI_SUPINT_NM());
         
          newEnt.setAUDI_PER_NM(this.getAUDI_PER_NM());
         
          newEnt.setAUDI_PER_ADDR(this.getAUDI_PER_ADDR());
         
          newEnt.setLEG_BAS(this.getLEG_BAS());
         
          newEnt.setAUDI_EXEC_ORG(this.getAUDI_EXEC_ORG());
         
          newEnt.setAUDI_EXEC_PART(this.getAUDI_EXEC_PART());
         
          newEnt.setAUDI_EXEC_ADDR(this.getAUDI_EXEC_ADDR());
         
          newEnt.setAUDI_EXEC_DETAILADDR(this.getAUDI_EXEC_DETAILADDR());
         
          newEnt.setAUDI_EXEC_DT(this.getAUDI_EXEC_DT());
         
          newEnt.setAUDI_EXEC_TIME(this.getAUDI_EXEC_TIME());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_AUDI_REPORTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getAUDI_SUBJ();
        
             case 4 :
                 return  this.getADMI_DISPO_CAUSE();
        
             case 5 :
                 return  this.getADMI_DISPO_CONT();
        
             case 6 :
                 return  this.getAUDI_SUPINT_PART();
        
             case 7 :
                 return  this.getAUDI_SUPINT_POS();
        
             case 8 :
                 return  this.getAUDI_SUPINT_NM();
        
             case 9 :
                 return  this.getAUDI_PER_NM();
        
             case 10 :
                 return  this.getAUDI_PER_ADDR();
        
             case 11 :
                 return  this.getLEG_BAS();
        
             case 12 :
                 return  this.getAUDI_EXEC_ORG();
        
             case 13 :
                 return  this.getAUDI_EXEC_PART();
        
             case 14 :
                 return  this.getAUDI_EXEC_ADDR();
        
             case 15 :
                 return  this.getAUDI_EXEC_DETAILADDR();
        
             case 16 :
                 return  this.getAUDI_EXEC_DT();
        
             case 17 :
                 return  this.getAUDI_EXEC_TIME();
        
             case 18 :
                 return  this.getINS_DT();
        
             case 19 :
                 return  this.getUPD_DT();
        
             case 20 :
                 return  this.getWRT_ID();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_AUDI_REPORTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setAUDI_SUBJ((String)value);
	            return;  
        
             case 4 :
                    this.setADMI_DISPO_CAUSE((String)value);
	            return;  
        
             case 5 :
                    this.setADMI_DISPO_CONT((String)value);
	            return;  
        
             case 6 :
                    this.setAUDI_SUPINT_PART((String)value);
	            return;  
        
             case 7 :
                    this.setAUDI_SUPINT_POS((String)value);
	            return;  
        
             case 8 :
                    this.setAUDI_SUPINT_NM((String)value);
	            return;  
        
             case 9 :
                    this.setAUDI_PER_NM((String)value);
	            return;  
        
             case 10 :
                    this.setAUDI_PER_ADDR((String)value);
	            return;  
        
             case 11 :
                    this.setLEG_BAS((String)value);
	            return;  
        
             case 12 :
                    this.setAUDI_EXEC_ORG((String)value);
	            return;  
        
             case 13 :
                    this.setAUDI_EXEC_PART((String)value);
	            return;  
        
             case 14 :
                    this.setAUDI_EXEC_ADDR((String)value);
	            return;  
        
             case 15 :
                    this.setAUDI_EXEC_DETAILADDR((String)value);
	            return;  
        
             case 16 :
                    this.setAUDI_EXEC_DT((String)value);
	            return;  
        
             case 17 :
                    this.setAUDI_EXEC_TIME((String)value);
	            return;  
        
             case 18 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 19 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 20 :
                    this.setWRT_ID((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_AUDI_REPORTHelper.toXML(this);
  }
  
}
