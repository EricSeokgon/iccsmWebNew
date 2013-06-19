

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_AUDI_DICTION
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               AUDI_SUBJ:VARCHAR2(50):  
*               AUDI_SUPINT_PART:VARCHAR2(50):  
*               AUDI_SUPINT_POS:VARCHAR2(50):  
*               AUDI_SUPINT_NM:VARCHAR2(20):  
*               AUDI_ATTEND_PERSON_NM:VARCHAR2(20):  
*               AUDI_ATTEND_PERSON_PART:VARCHAR2(50):  
*               AUDI_PER_ATTE_YN:VARCHAR2(1):  
*               AUDI_PER_NATTE_CAUSE:VARCHAR2(512):  
*               AUDI_OPN_YN:VARCHAR2(1):  
*               AUDI_NOPN_CAUSE:VARCHAR2(512):  
*               PER_STAT_CONT:VARCHAR2(1024):  
*               PER_PRES_EVID:VARCHAR2(512):  
*               EVID_INV_EVID:VARCHAR2(512):  
*               ETC:VARCHAR2(256):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               EVID_INV_POIN:VARCHAR2(1024):  
*               AUDI_ATTEND_PERSON_POS:VARCHAR2(50):  
*               AUDI_EXEC_DT:VARCHAR2(8):  
*               AUDI_EXEC_TIME:VARCHAR2(4):  
*               AUDI_EXEC_LOC:VARCHAR2(256):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_AUDI_DICTIONEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String AUDI_SUBJ;
  
     private String AUDI_SUPINT_PART;
  
     private String AUDI_SUPINT_POS;
  
     private String AUDI_SUPINT_NM;
  
     private String AUDI_ATTEND_PERSON_NM;
  
     private String AUDI_ATTEND_PERSON_PART;
  
     private String AUDI_PER_ATTE_YN;
  
     private String AUDI_PER_NATTE_CAUSE;
  
     private String AUDI_OPN_YN;
  
     private String AUDI_NOPN_CAUSE;
  
     private String PER_STAT_CONT;
  
     private String PER_PRES_EVID;
  
     private String EVID_INV_EVID;
  
     private String ETC;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String EVID_INV_POIN;
  
     private String AUDI_ATTEND_PERSON_POS;
  
     private String AUDI_EXEC_DT;
  
     private String AUDI_EXEC_TIME;
  
     private String AUDI_EXEC_LOC;
  

//생성자를 만든다
    public PT_M_AUDI_DICTIONEntity(){
    }
    
    
    public PT_M_AUDI_DICTIONEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_AUDI_DICTIONEntity(ValueObject ent) throws Exception{
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
		this.AUDI_SUPINT_PART =request.getParameter("AUDI_SUPINT_PART");
		this.AUDI_SUPINT_POS =request.getParameter("AUDI_SUPINT_POS");
		this.AUDI_SUPINT_NM =request.getParameter("AUDI_SUPINT_NM");
		this.AUDI_ATTEND_PERSON_NM =request.getParameter("AUDI_ATTEND_PERSON_NM");
		this.AUDI_ATTEND_PERSON_PART =request.getParameter("AUDI_ATTEND_PERSON_PART");
		this.AUDI_PER_ATTE_YN =request.getParameter("AUDI_PER_ATTE_YN");
		this.AUDI_PER_NATTE_CAUSE =request.getParameter("AUDI_PER_NATTE_CAUSE");
		this.AUDI_OPN_YN =request.getParameter("AUDI_OPN_YN");
		this.AUDI_NOPN_CAUSE =request.getParameter("AUDI_NOPN_CAUSE");
		this.PER_STAT_CONT =request.getParameter("PER_STAT_CONT");
		this.PER_PRES_EVID =request.getParameter("PER_PRES_EVID");
		this.EVID_INV_EVID =request.getParameter("EVID_INV_EVID");
		this.ETC =request.getParameter("ETC");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.EVID_INV_POIN =request.getParameter("EVID_INV_POIN");
		this.AUDI_ATTEND_PERSON_POS =request.getParameter("AUDI_ATTEND_PERSON_POS");
		this.AUDI_EXEC_DT =request.getParameter("AUDI_EXEC_DT");
		this.AUDI_EXEC_TIME =request.getParameter("AUDI_EXEC_TIME");
		this.AUDI_EXEC_LOC =request.getParameter("AUDI_EXEC_LOC");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.AUDI_SUBJ =KJFMi.dsGet(ds, arg_row, "AUDI_SUBJ");
		this.AUDI_SUPINT_PART =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_PART");
		this.AUDI_SUPINT_POS =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_POS");
		this.AUDI_SUPINT_NM =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_NM");
		this.AUDI_ATTEND_PERSON_NM =KJFMi.dsGet(ds, arg_row, "AUDI_ATTEND_PERSON_NM");
		this.AUDI_ATTEND_PERSON_PART =KJFMi.dsGet(ds, arg_row, "AUDI_ATTEND_PERSON_PART");
		this.AUDI_PER_ATTE_YN =KJFMi.dsGet(ds, arg_row, "AUDI_PER_ATTE_YN");
		this.AUDI_PER_NATTE_CAUSE =KJFMi.dsGet(ds, arg_row, "AUDI_PER_NATTE_CAUSE");
		this.AUDI_OPN_YN =KJFMi.dsGet(ds, arg_row, "AUDI_OPN_YN");
		this.AUDI_NOPN_CAUSE =KJFMi.dsGet(ds, arg_row, "AUDI_NOPN_CAUSE");
		this.PER_STAT_CONT =KJFMi.dsGet(ds, arg_row, "PER_STAT_CONT");
		this.PER_PRES_EVID =KJFMi.dsGet(ds, arg_row, "PER_PRES_EVID");
		this.EVID_INV_EVID =KJFMi.dsGet(ds, arg_row, "EVID_INV_EVID");
		this.ETC =KJFMi.dsGet(ds, arg_row, "ETC");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.EVID_INV_POIN =KJFMi.dsGet(ds, arg_row, "EVID_INV_POIN");
		this.AUDI_ATTEND_PERSON_POS =KJFMi.dsGet(ds, arg_row, "AUDI_ATTEND_PERSON_POS");
		this.AUDI_EXEC_DT =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_DT");
		this.AUDI_EXEC_TIME =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_TIME");
		this.AUDI_EXEC_LOC =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_LOC");
				
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
  
     public String getAUDI_SUPINT_PART(){
             return AUDI_SUPINT_PART;
     };
  
     public String getAUDI_SUPINT_POS(){
             return AUDI_SUPINT_POS;
     };
  
     public String getAUDI_SUPINT_NM(){
             return AUDI_SUPINT_NM;
     };
  
     public String getAUDI_ATTEND_PERSON_NM(){
             return AUDI_ATTEND_PERSON_NM;
     };
  
     public String getAUDI_ATTEND_PERSON_PART(){
             return AUDI_ATTEND_PERSON_PART;
     };
  
     public String getAUDI_PER_ATTE_YN(){
             return AUDI_PER_ATTE_YN;
     };
  
     public String getAUDI_PER_NATTE_CAUSE(){
             return AUDI_PER_NATTE_CAUSE;
     };
  
     public String getAUDI_OPN_YN(){
             return AUDI_OPN_YN;
     };
  
     public String getAUDI_NOPN_CAUSE(){
             return AUDI_NOPN_CAUSE;
     };
  
     public String getPER_STAT_CONT(){
             return PER_STAT_CONT;
     };
  
     public String getPER_PRES_EVID(){
             return PER_PRES_EVID;
     };
  
     public String getEVID_INV_EVID(){
             return EVID_INV_EVID;
     };
  
     public String getETC(){
             return ETC;
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
  
     public String getEVID_INV_POIN(){
             return EVID_INV_POIN;
     };
  
     public String getAUDI_ATTEND_PERSON_POS(){
             return AUDI_ATTEND_PERSON_POS;
     };
  
     public String getAUDI_EXEC_DT(){
             return AUDI_EXEC_DT;
     };
  
     public String getAUDI_EXEC_TIME(){
             return AUDI_EXEC_TIME;
     };
  
     public String getAUDI_EXEC_LOC(){
             return AUDI_EXEC_LOC;
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
  
     public void setAUDI_SUPINT_PART(String AUDI_SUPINT_PART){
            this.AUDI_SUPINT_PART=AUDI_SUPINT_PART;
     };
  
     public void setAUDI_SUPINT_POS(String AUDI_SUPINT_POS){
            this.AUDI_SUPINT_POS=AUDI_SUPINT_POS;
     };
  
     public void setAUDI_SUPINT_NM(String AUDI_SUPINT_NM){
            this.AUDI_SUPINT_NM=AUDI_SUPINT_NM;
     };
  
     public void setAUDI_ATTEND_PERSON_NM(String AUDI_ATTEND_PERSON_NM){
            this.AUDI_ATTEND_PERSON_NM=AUDI_ATTEND_PERSON_NM;
     };
  
     public void setAUDI_ATTEND_PERSON_PART(String AUDI_ATTEND_PERSON_PART){
            this.AUDI_ATTEND_PERSON_PART=AUDI_ATTEND_PERSON_PART;
     };
  
     public void setAUDI_PER_ATTE_YN(String AUDI_PER_ATTE_YN){
            this.AUDI_PER_ATTE_YN=AUDI_PER_ATTE_YN;
     };
  
     public void setAUDI_PER_NATTE_CAUSE(String AUDI_PER_NATTE_CAUSE){
            this.AUDI_PER_NATTE_CAUSE=AUDI_PER_NATTE_CAUSE;
     };
  
     public void setAUDI_OPN_YN(String AUDI_OPN_YN){
            this.AUDI_OPN_YN=AUDI_OPN_YN;
     };
  
     public void setAUDI_NOPN_CAUSE(String AUDI_NOPN_CAUSE){
            this.AUDI_NOPN_CAUSE=AUDI_NOPN_CAUSE;
     };
  
     public void setPER_STAT_CONT(String PER_STAT_CONT){
            this.PER_STAT_CONT=PER_STAT_CONT;
     };
  
     public void setPER_PRES_EVID(String PER_PRES_EVID){
            this.PER_PRES_EVID=PER_PRES_EVID;
     };
  
     public void setEVID_INV_EVID(String EVID_INV_EVID){
            this.EVID_INV_EVID=EVID_INV_EVID;
     };
  
     public void setETC(String ETC){
            this.ETC=ETC;
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
  
     public void setEVID_INV_POIN(String EVID_INV_POIN){
            this.EVID_INV_POIN=EVID_INV_POIN;
     };
  
     public void setAUDI_ATTEND_PERSON_POS(String AUDI_ATTEND_PERSON_POS){
            this.AUDI_ATTEND_PERSON_POS=AUDI_ATTEND_PERSON_POS;
     };
  
     public void setAUDI_EXEC_DT(String AUDI_EXEC_DT){
            this.AUDI_EXEC_DT=AUDI_EXEC_DT;
     };
  
     public void setAUDI_EXEC_TIME(String AUDI_EXEC_TIME){
            this.AUDI_EXEC_TIME=AUDI_EXEC_TIME;
     };
  
     public void setAUDI_EXEC_LOC(String AUDI_EXEC_LOC){
            this.AUDI_EXEC_LOC=AUDI_EXEC_LOC;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("AUDI_SUBJ:"+ this.getAUDI_SUBJ()+"\n");
      
      strB.append("AUDI_SUPINT_PART:"+ this.getAUDI_SUPINT_PART()+"\n");
      
      strB.append("AUDI_SUPINT_POS:"+ this.getAUDI_SUPINT_POS()+"\n");
      
      strB.append("AUDI_SUPINT_NM:"+ this.getAUDI_SUPINT_NM()+"\n");
      
      strB.append("AUDI_ATTEND_PERSON_NM:"+ this.getAUDI_ATTEND_PERSON_NM()+"\n");
      
      strB.append("AUDI_ATTEND_PERSON_PART:"+ this.getAUDI_ATTEND_PERSON_PART()+"\n");
      
      strB.append("AUDI_PER_ATTE_YN:"+ this.getAUDI_PER_ATTE_YN()+"\n");
      
      strB.append("AUDI_PER_NATTE_CAUSE:"+ this.getAUDI_PER_NATTE_CAUSE()+"\n");
      
      strB.append("AUDI_OPN_YN:"+ this.getAUDI_OPN_YN()+"\n");
      
      strB.append("AUDI_NOPN_CAUSE:"+ this.getAUDI_NOPN_CAUSE()+"\n");
      
      strB.append("PER_STAT_CONT:"+ this.getPER_STAT_CONT()+"\n");
      
      strB.append("PER_PRES_EVID:"+ this.getPER_PRES_EVID()+"\n");
      
      strB.append("EVID_INV_EVID:"+ this.getEVID_INV_EVID()+"\n");
      
      strB.append("ETC:"+ this.getETC()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("EVID_INV_POIN:"+ this.getEVID_INV_POIN()+"\n");
      
      strB.append("AUDI_ATTEND_PERSON_POS:"+ this.getAUDI_ATTEND_PERSON_POS()+"\n");
      
      strB.append("AUDI_EXEC_DT:"+ this.getAUDI_EXEC_DT()+"\n");
      
      strB.append("AUDI_EXEC_TIME:"+ this.getAUDI_EXEC_TIME()+"\n");
      
      strB.append("AUDI_EXEC_LOC:"+ this.getAUDI_EXEC_LOC()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_AUDI_DICTIONHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_AUDI_DICTIONHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_AUDI_DICTIONHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_AUDI_DICTIONHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_AUDI_DICTIONHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_AUDI_DICTIONEntity();
  }

  public ValueObject getClone(){
         PT_M_AUDI_DICTIONEntity newEnt = new PT_M_AUDI_DICTIONEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setAUDI_SUBJ(this.getAUDI_SUBJ());
         
          newEnt.setAUDI_SUPINT_PART(this.getAUDI_SUPINT_PART());
         
          newEnt.setAUDI_SUPINT_POS(this.getAUDI_SUPINT_POS());
         
          newEnt.setAUDI_SUPINT_NM(this.getAUDI_SUPINT_NM());
         
          newEnt.setAUDI_ATTEND_PERSON_NM(this.getAUDI_ATTEND_PERSON_NM());
         
          newEnt.setAUDI_ATTEND_PERSON_PART(this.getAUDI_ATTEND_PERSON_PART());
         
          newEnt.setAUDI_PER_ATTE_YN(this.getAUDI_PER_ATTE_YN());
         
          newEnt.setAUDI_PER_NATTE_CAUSE(this.getAUDI_PER_NATTE_CAUSE());
         
          newEnt.setAUDI_OPN_YN(this.getAUDI_OPN_YN());
         
          newEnt.setAUDI_NOPN_CAUSE(this.getAUDI_NOPN_CAUSE());
         
          newEnt.setPER_STAT_CONT(this.getPER_STAT_CONT());
         
          newEnt.setPER_PRES_EVID(this.getPER_PRES_EVID());
         
          newEnt.setEVID_INV_EVID(this.getEVID_INV_EVID());
         
          newEnt.setETC(this.getETC());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setEVID_INV_POIN(this.getEVID_INV_POIN());
         
          newEnt.setAUDI_ATTEND_PERSON_POS(this.getAUDI_ATTEND_PERSON_POS());
         
          newEnt.setAUDI_EXEC_DT(this.getAUDI_EXEC_DT());
         
          newEnt.setAUDI_EXEC_TIME(this.getAUDI_EXEC_TIME());
         
          newEnt.setAUDI_EXEC_LOC(this.getAUDI_EXEC_LOC());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_AUDI_DICTIONHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getAUDI_SUBJ();
        
             case 4 :
                 return  this.getAUDI_SUPINT_PART();
        
             case 5 :
                 return  this.getAUDI_SUPINT_POS();
        
             case 6 :
                 return  this.getAUDI_SUPINT_NM();
        
             case 7 :
                 return  this.getAUDI_ATTEND_PERSON_NM();
        
             case 8 :
                 return  this.getAUDI_ATTEND_PERSON_PART();
        
             case 9 :
                 return  this.getAUDI_PER_ATTE_YN();
        
             case 10 :
                 return  this.getAUDI_PER_NATTE_CAUSE();
        
             case 11 :
                 return  this.getAUDI_OPN_YN();
        
             case 12 :
                 return  this.getAUDI_NOPN_CAUSE();
        
             case 13 :
                 return  this.getPER_STAT_CONT();
        
             case 14 :
                 return  this.getPER_PRES_EVID();
        
             case 15 :
                 return  this.getEVID_INV_EVID();
        
             case 16 :
                 return  this.getETC();
        
             case 17 :
                 return  this.getINS_DT();
        
             case 18 :
                 return  this.getUPD_DT();
        
             case 19 :
                 return  this.getWRT_ID();
        
             case 20 :
                 return  this.getEVID_INV_POIN();
        
             case 21 :
                 return  this.getAUDI_ATTEND_PERSON_POS();
        
             case 22 :
                 return  this.getAUDI_EXEC_DT();
        
             case 23 :
                 return  this.getAUDI_EXEC_TIME();
        
             case 24 :
                 return  this.getAUDI_EXEC_LOC();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_AUDI_DICTIONHelper.fieldMap.get(key);
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
                    this.setAUDI_SUPINT_PART((String)value);
	            return;  
        
             case 5 :
                    this.setAUDI_SUPINT_POS((String)value);
	            return;  
        
             case 6 :
                    this.setAUDI_SUPINT_NM((String)value);
	            return;  
        
             case 7 :
                    this.setAUDI_ATTEND_PERSON_NM((String)value);
	            return;  
        
             case 8 :
                    this.setAUDI_ATTEND_PERSON_PART((String)value);
	            return;  
        
             case 9 :
                    this.setAUDI_PER_ATTE_YN((String)value);
	            return;  
        
             case 10 :
                    this.setAUDI_PER_NATTE_CAUSE((String)value);
	            return;  
        
             case 11 :
                    this.setAUDI_OPN_YN((String)value);
	            return;  
        
             case 12 :
                    this.setAUDI_NOPN_CAUSE((String)value);
	            return;  
        
             case 13 :
                    this.setPER_STAT_CONT((String)value);
	            return;  
        
             case 14 :
                    this.setPER_PRES_EVID((String)value);
	            return;  
        
             case 15 :
                    this.setEVID_INV_EVID((String)value);
	            return;  
        
             case 16 :
                    this.setETC((String)value);
	            return;  
        
             case 17 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 18 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 19 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 20 :
                    this.setEVID_INV_POIN((String)value);
	            return;  
        
             case 21 :
                    this.setAUDI_ATTEND_PERSON_POS((String)value);
	            return;  
        
             case 22 :
                    this.setAUDI_EXEC_DT((String)value);
	            return;  
        
             case 23 :
                    this.setAUDI_EXEC_TIME((String)value);
	            return;  
        
             case 24 :
                    this.setAUDI_EXEC_LOC((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_AUDI_DICTIONHelper.toXML(this);
  }
  
}
