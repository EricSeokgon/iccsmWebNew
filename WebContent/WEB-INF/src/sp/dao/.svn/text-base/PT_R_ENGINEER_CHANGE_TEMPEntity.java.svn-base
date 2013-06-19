

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_CHANGE_TEMP
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               RECV_NUM:VARCHAR2(12):  
*               ENGINEER_NM:VARCHAR2(20):  
*               ENGINEER_SSN1:VARCHAR2(18):  
*               ENGINEER_SSN2:VARCHAR2(21):  
*               EMPL_YMD:VARCHAR2(8):  
*               RET_YMD:VARCHAR2(8):  
*               REMARK:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               TMP_FIELD:VARCHAR2(20):  
*               CARE_BOOK_VAL_START_DT:VARCHAR2(24):  
*               CARE_BOOK_VAL_END_DT:VARCHAR2(24):  
*               ISSUE_DT:VARCHAR2(24):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(30):  
*               CARE_BOOK_VAL_START_DT1:VARCHAR2(30):  
*               CARE_BOOK_VAL_START_DT2:VARCHAR2(30):  
*               ENG_PROC:VARCHAR2(2):  
*               ENG_TARGET:VARCHAR2(2):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_ENGINEER_CHANGE_TEMPEntity extends ValueObject{

  
     private String SEQ;
  
     private String TMP_WRT_NUM;
  
     private String RECV_NUM;
  
     private String ENGINEER_NM;
  
     private String ENGINEER_SSN1;
  
     private String ENGINEER_SSN2;
  
     private String EMPL_YMD;
  
     private String RET_YMD;
  
     private String REMARK;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String TMP_FIELD;
  
     private String CARE_BOOK_VAL_START_DT;
  
     private String CARE_BOOK_VAL_END_DT;
  
     private String ISSUE_DT;
  
     private String CARE_BOOK_ISSUE_NUM;
  
     private String CARE_BOOK_VAL_START_DT1;
  
     private String CARE_BOOK_VAL_START_DT2;
  
     private String ENG_PROC;
  
     private String ENG_TARGET;
  

//생성자를 만든다
    public PT_R_ENGINEER_CHANGE_TEMPEntity(){
    }
    
    
    public PT_R_ENGINEER_CHANGE_TEMPEntity(String RECV_NUM,String SEQ,String TMP_WRT_NUM ){
       this.setRECV_NUM(RECV_NUM);
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_ENGINEER_CHANGE_TEMPEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.ENGINEER_NM =request.getParameter("ENGINEER_NM");
		this.ENGINEER_SSN1 =request.getParameter("ENGINEER_SSN1");
		this.ENGINEER_SSN2 =request.getParameter("ENGINEER_SSN2");
		this.EMPL_YMD =request.getParameter("EMPL_YMD");
		this.RET_YMD =request.getParameter("RET_YMD");
		this.REMARK =request.getParameter("REMARK");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.TMP_FIELD =request.getParameter("TMP_FIELD");
		this.CARE_BOOK_VAL_START_DT =request.getParameter("CARE_BOOK_VAL_START_DT");
		this.CARE_BOOK_VAL_END_DT =request.getParameter("CARE_BOOK_VAL_END_DT");
		this.ISSUE_DT =request.getParameter("ISSUE_DT");
		this.CARE_BOOK_ISSUE_NUM =request.getParameter("CARE_BOOK_ISSUE_NUM");
		this.CARE_BOOK_VAL_START_DT1 =request.getParameter("CARE_BOOK_VAL_START_DT1");
		this.CARE_BOOK_VAL_START_DT2 =request.getParameter("CARE_BOOK_VAL_START_DT2");
		this.ENG_PROC =request.getParameter("ENG_PROC");
		this.ENG_TARGET =request.getParameter("ENG_TARGET");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.ENGINEER_NM =KJFMi.dsGet(ds, arg_row, "ENGINEER_NM");
		this.ENGINEER_SSN1 =KJFMi.dsGet(ds, arg_row, "ENGINEER_SSN1");
		this.ENGINEER_SSN2 =KJFMi.dsGet(ds, arg_row, "ENGINEER_SSN2");
		this.EMPL_YMD =KJFMi.dsGet(ds, arg_row, "EMPL_YMD");
		this.RET_YMD =KJFMi.dsGet(ds, arg_row, "RET_YMD");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.TMP_FIELD =KJFMi.dsGet(ds, arg_row, "TMP_FIELD");
		this.CARE_BOOK_VAL_START_DT =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_VAL_START_DT");
		this.CARE_BOOK_VAL_END_DT =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_VAL_END_DT");
		this.ISSUE_DT =KJFMi.dsGet(ds, arg_row, "ISSUE_DT");
		this.CARE_BOOK_ISSUE_NUM =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_ISSUE_NUM");
		this.CARE_BOOK_VAL_START_DT1 =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_VAL_START_DT1");
		this.CARE_BOOK_VAL_START_DT2 =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_VAL_START_DT2");
		this.ENG_PROC =KJFMi.dsGet(ds, arg_row, "ENG_PROC");
		this.ENG_TARGET =KJFMi.dsGet(ds, arg_row, "ENG_TARGET");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getENGINEER_NM(){
             return ENGINEER_NM;
     };
  
     public String getENGINEER_SSN1(){
             return ENGINEER_SSN1;
     };
  
     public String getENGINEER_SSN2(){
             return ENGINEER_SSN2;
     };
  
     public String getEMPL_YMD(){
             return EMPL_YMD;
     };
  
     public String getRET_YMD(){
             return RET_YMD;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getTMP_FIELD(){
             return TMP_FIELD;
     };
  
     public String getCARE_BOOK_VAL_START_DT(){
             return CARE_BOOK_VAL_START_DT;
     };
  
     public String getCARE_BOOK_VAL_END_DT(){
             return CARE_BOOK_VAL_END_DT;
     };
  
     public String getISSUE_DT(){
             return ISSUE_DT;
     };
  
     public String getCARE_BOOK_ISSUE_NUM(){
             return CARE_BOOK_ISSUE_NUM;
     };
  
     public String getCARE_BOOK_VAL_START_DT1(){
             return CARE_BOOK_VAL_START_DT1;
     };
  
     public String getCARE_BOOK_VAL_START_DT2(){
             return CARE_BOOK_VAL_START_DT2;
     };
  
     public String getENG_PROC(){
             return ENG_PROC;
     };
  
     public String getENG_TARGET(){
             return ENG_TARGET;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setENGINEER_NM(String ENGINEER_NM){
            this.ENGINEER_NM=ENGINEER_NM;
     };
  
     public void setENGINEER_SSN1(String ENGINEER_SSN1){
            this.ENGINEER_SSN1=ENGINEER_SSN1;
     };
  
     public void setENGINEER_SSN2(String ENGINEER_SSN2){
            this.ENGINEER_SSN2=ENGINEER_SSN2;
     };
  
     public void setEMPL_YMD(String EMPL_YMD){
            this.EMPL_YMD=EMPL_YMD;
     };
  
     public void setRET_YMD(String RET_YMD){
            this.RET_YMD=RET_YMD;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setTMP_FIELD(String TMP_FIELD){
            this.TMP_FIELD=TMP_FIELD;
     };
  
     public void setCARE_BOOK_VAL_START_DT(String CARE_BOOK_VAL_START_DT){
            this.CARE_BOOK_VAL_START_DT=CARE_BOOK_VAL_START_DT;
     };
  
     public void setCARE_BOOK_VAL_END_DT(String CARE_BOOK_VAL_END_DT){
            this.CARE_BOOK_VAL_END_DT=CARE_BOOK_VAL_END_DT;
     };
  
     public void setISSUE_DT(String ISSUE_DT){
            this.ISSUE_DT=ISSUE_DT;
     };
  
     public void setCARE_BOOK_ISSUE_NUM(String CARE_BOOK_ISSUE_NUM){
            this.CARE_BOOK_ISSUE_NUM=CARE_BOOK_ISSUE_NUM;
     };
  
     public void setCARE_BOOK_VAL_START_DT1(String CARE_BOOK_VAL_START_DT1){
            this.CARE_BOOK_VAL_START_DT1=CARE_BOOK_VAL_START_DT1;
     };
  
     public void setCARE_BOOK_VAL_START_DT2(String CARE_BOOK_VAL_START_DT2){
            this.CARE_BOOK_VAL_START_DT2=CARE_BOOK_VAL_START_DT2;
     };
  
     public void setENG_PROC(String ENG_PROC){
            this.ENG_PROC=ENG_PROC;
     };
  
     public void setENG_TARGET(String ENG_TARGET){
            this.ENG_TARGET=ENG_TARGET;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("ENGINEER_NM:"+ this.getENGINEER_NM()+"\n");
      
      strB.append("ENGINEER_SSN1:"+ this.getENGINEER_SSN1()+"\n");
      
      strB.append("ENGINEER_SSN2:"+ this.getENGINEER_SSN2()+"\n");
      
      strB.append("EMPL_YMD:"+ this.getEMPL_YMD()+"\n");
      
      strB.append("RET_YMD:"+ this.getRET_YMD()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("TMP_FIELD:"+ this.getTMP_FIELD()+"\n");
      
      strB.append("CARE_BOOK_VAL_START_DT:"+ this.getCARE_BOOK_VAL_START_DT()+"\n");
      
      strB.append("CARE_BOOK_VAL_END_DT:"+ this.getCARE_BOOK_VAL_END_DT()+"\n");
      
      strB.append("ISSUE_DT:"+ this.getISSUE_DT()+"\n");
      
      strB.append("CARE_BOOK_ISSUE_NUM:"+ this.getCARE_BOOK_ISSUE_NUM()+"\n");
      
      strB.append("CARE_BOOK_VAL_START_DT1:"+ this.getCARE_BOOK_VAL_START_DT1()+"\n");
      
      strB.append("CARE_BOOK_VAL_START_DT2:"+ this.getCARE_BOOK_VAL_START_DT2()+"\n");
      
      strB.append("ENG_PROC:"+ this.getENG_PROC()+"\n");
      
      strB.append("ENG_TARGET:"+ this.getENG_TARGET()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_ENGINEER_CHANGE_TEMPHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_ENGINEER_CHANGE_TEMPHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_ENGINEER_CHANGE_TEMPHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_ENGINEER_CHANGE_TEMPHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_ENGINEER_CHANGE_TEMPHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSEQ();
       values[2]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_ENGINEER_CHANGE_TEMPEntity();
  }

  public ValueObject getClone(){
         PT_R_ENGINEER_CHANGE_TEMPEntity newEnt = new PT_R_ENGINEER_CHANGE_TEMPEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setENGINEER_NM(this.getENGINEER_NM());
         
          newEnt.setENGINEER_SSN1(this.getENGINEER_SSN1());
         
          newEnt.setENGINEER_SSN2(this.getENGINEER_SSN2());
         
          newEnt.setEMPL_YMD(this.getEMPL_YMD());
         
          newEnt.setRET_YMD(this.getRET_YMD());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setTMP_FIELD(this.getTMP_FIELD());
         
          newEnt.setCARE_BOOK_VAL_START_DT(this.getCARE_BOOK_VAL_START_DT());
         
          newEnt.setCARE_BOOK_VAL_END_DT(this.getCARE_BOOK_VAL_END_DT());
         
          newEnt.setISSUE_DT(this.getISSUE_DT());
         
          newEnt.setCARE_BOOK_ISSUE_NUM(this.getCARE_BOOK_ISSUE_NUM());
         
          newEnt.setCARE_BOOK_VAL_START_DT1(this.getCARE_BOOK_VAL_START_DT1());
         
          newEnt.setCARE_BOOK_VAL_START_DT2(this.getCARE_BOOK_VAL_START_DT2());
         
          newEnt.setENG_PROC(this.getENG_PROC());
         
          newEnt.setENG_TARGET(this.getENG_TARGET());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_ENGINEER_CHANGE_TEMPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getRECV_NUM();
        
             case 4 :
                 return  this.getENGINEER_NM();
        
             case 5 :
                 return  this.getENGINEER_SSN1();
        
             case 6 :
                 return  this.getENGINEER_SSN2();
        
             case 7 :
                 return  this.getEMPL_YMD();
        
             case 8 :
                 return  this.getRET_YMD();
        
             case 9 :
                 return  this.getREMARK();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getUPD_DT();
        
             case 12 :
                 return  this.getINS_DT();
        
             case 13 :
                 return  this.getTMP_FIELD();
        
             case 14 :
                 return  this.getCARE_BOOK_VAL_START_DT();
        
             case 15 :
                 return  this.getCARE_BOOK_VAL_END_DT();
        
             case 16 :
                 return  this.getISSUE_DT();
        
             case 17 :
                 return  this.getCARE_BOOK_ISSUE_NUM();
        
             case 18 :
                 return  this.getCARE_BOOK_VAL_START_DT1();
        
             case 19 :
                 return  this.getCARE_BOOK_VAL_START_DT2();
        
             case 20 :
                 return  this.getENG_PROC();
        
             case 21 :
                 return  this.getENG_TARGET();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_ENGINEER_CHANGE_TEMPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setENGINEER_NM((String)value);
	            return;  
        
             case 5 :
                    this.setENGINEER_SSN1((String)value);
	            return;  
        
             case 6 :
                    this.setENGINEER_SSN2((String)value);
	            return;  
        
             case 7 :
                    this.setEMPL_YMD((String)value);
	            return;  
        
             case 8 :
                    this.setRET_YMD((String)value);
	            return;  
        
             case 9 :
                    this.setREMARK((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 11 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 12 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 13 :
                    this.setTMP_FIELD((String)value);
	            return;  
        
             case 14 :
                    this.setCARE_BOOK_VAL_START_DT((String)value);
	            return;  
        
             case 15 :
                    this.setCARE_BOOK_VAL_END_DT((String)value);
	            return;  
        
             case 16 :
                    this.setISSUE_DT((String)value);
	            return;  
        
             case 17 :
                    this.setCARE_BOOK_ISSUE_NUM((String)value);
	            return;  
        
             case 18 :
                    this.setCARE_BOOK_VAL_START_DT1((String)value);
	            return;  
        
             case 19 :
                    this.setCARE_BOOK_VAL_START_DT2((String)value);
	            return;  
        
             case 20 :
                    this.setENG_PROC((String)value);
	            return;  
        
             case 21 :
                    this.setENG_TARGET((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_ENGINEER_CHANGE_TEMPHelper.toXML(this);
  }
  
}
