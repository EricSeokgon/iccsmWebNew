

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REFER
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_REG_NUM
*  테이블 컬럼 :  
*               SD_CODE:VARCHAR2(4):  
*               SEQ:NUMBER(11):  
*               SGG_CODE:VARCHAR2(4):  
*               GUBUN:VARCHAR2(20):  
*               WRT_ID:VARCHAR2(16):  
*               UDP_DT:VARCHAR2(24):  
*               NAME_HANJA:VARCHAR2(20):  
*               INS_DT:VARCHAR2(24):  
*               SSN1:NUMBER(6):  
*               NOTE:VARCHAR2(128):  
*               ADDR:VARCHAR2(128):  
*               FAMILY_HEAD:VARCHAR2(20):  
*               SSN2:NUMBER(7):  
*               FAMILY_HEAD_RELATION:VARCHAR2(20):  
*               NAME_KOR:VARCHAR2(18):  
*               ORIGIN:VARCHAR2(128):  
*               TMP_REG_NUM:CHAR(18):  
*               ENTER_DATE:VARCHAR2(8):  
*               RETIRE_DATE:VARCHAR2(8):  
*               REFER_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_REFEREntity extends ValueObject{

  
     private String SD_CODE;
  
     private String SEQ;
  
     private String SGG_CODE;
  
     private String GUBUN;
  
     private String WRT_ID;
  
     private String UDP_DT;
  
     private String NAME_HANJA;
  
     private String INS_DT;
  
     private String SSN1;
  
     private String NOTE;
  
     private String ADDR;
  
     private String FAMILY_HEAD;
  
     private String SSN2;
  
     private String FAMILY_HEAD_RELATION;
  
     private String NAME_KOR;
  
     private String ORIGIN;
  
     private String TMP_REG_NUM;
  
     private String ENTER_DATE;
  
     private String RETIRE_DATE;
  
     private String REFER_YN;
  

//생성자를 만든다
    public PT_R_REFEREntity(){
    }
    
    
    public PT_R_REFEREntity(String SEQ,String TMP_REG_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_REG_NUM(TMP_REG_NUM);
       
    }
      
    public PT_R_REFEREntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
       value = ent.getByName("TMP_REG_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_REG_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SD_CODE =request.getParameter("SD_CODE");
		this.SEQ =request.getParameter("SEQ");
		this.SGG_CODE =request.getParameter("SGG_CODE");
		this.GUBUN =request.getParameter("GUBUN");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UDP_DT =request.getParameter("UDP_DT");
		this.NAME_HANJA =request.getParameter("NAME_HANJA");
		this.INS_DT =request.getParameter("INS_DT");
		this.SSN1 =request.getParameter("SSN1");
		this.NOTE =request.getParameter("NOTE");
		this.ADDR =request.getParameter("ADDR");
		this.FAMILY_HEAD =request.getParameter("FAMILY_HEAD");
		this.SSN2 =request.getParameter("SSN2");
		this.FAMILY_HEAD_RELATION =request.getParameter("FAMILY_HEAD_RELATION");
		this.NAME_KOR =request.getParameter("NAME_KOR");
		this.ORIGIN =request.getParameter("ORIGIN");
		this.TMP_REG_NUM =request.getParameter("TMP_REG_NUM");
		this.ENTER_DATE =request.getParameter("ENTER_DATE");
		this.RETIRE_DATE =request.getParameter("RETIRE_DATE");
		this.REFER_YN =request.getParameter("REFER_YN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SD_CODE =KJFMi.dsGet(ds, arg_row, "SD_CODE");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.SGG_CODE =KJFMi.dsGet(ds, arg_row, "SGG_CODE");
		this.GUBUN =KJFMi.dsGet(ds, arg_row, "GUBUN");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UDP_DT =KJFMi.dsGet(ds, arg_row, "UDP_DT");
		this.NAME_HANJA =KJFMi.dsGet(ds, arg_row, "NAME_HANJA");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.SSN1 =KJFMi.dsGet(ds, arg_row, "SSN1");
		this.NOTE =KJFMi.dsGet(ds, arg_row, "NOTE");
		this.ADDR =KJFMi.dsGet(ds, arg_row, "ADDR");
		this.FAMILY_HEAD =KJFMi.dsGet(ds, arg_row, "FAMILY_HEAD");
		this.SSN2 =KJFMi.dsGet(ds, arg_row, "SSN2");
		this.FAMILY_HEAD_RELATION =KJFMi.dsGet(ds, arg_row, "FAMILY_HEAD_RELATION");
		this.NAME_KOR =KJFMi.dsGet(ds, arg_row, "NAME_KOR");
		this.ORIGIN =KJFMi.dsGet(ds, arg_row, "ORIGIN");
		this.TMP_REG_NUM =KJFMi.dsGet(ds, arg_row, "TMP_REG_NUM");
		this.ENTER_DATE =KJFMi.dsGet(ds, arg_row, "ENTER_DATE");
		this.RETIRE_DATE =KJFMi.dsGet(ds, arg_row, "RETIRE_DATE");
		this.REFER_YN =KJFMi.dsGet(ds, arg_row, "REFER_YN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSD_CODE(){
             return SD_CODE;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getSGG_CODE(){
             return SGG_CODE;
     };
  
     public String getGUBUN(){
             return GUBUN;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUDP_DT(){
             return UDP_DT;
     };
  
     public String getNAME_HANJA(){
             return NAME_HANJA;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getSSN1(){
             return SSN1;
     };
  
     public String getNOTE(){
             return NOTE;
     };
  
     public String getADDR(){
             return ADDR;
     };
  
     public String getFAMILY_HEAD(){
             return FAMILY_HEAD;
     };
  
     public String getSSN2(){
             return SSN2;
     };
  
     public String getFAMILY_HEAD_RELATION(){
             return FAMILY_HEAD_RELATION;
     };
  
     public String getNAME_KOR(){
             return NAME_KOR;
     };
  
     public String getORIGIN(){
             return ORIGIN;
     };
  
     public String getTMP_REG_NUM(){
             return TMP_REG_NUM;
     };
  
     public String getENTER_DATE(){
             return ENTER_DATE;
     };
  
     public String getRETIRE_DATE(){
             return RETIRE_DATE;
     };
  
     public String getREFER_YN(){
             return REFER_YN;
     };
  

//Setter 함수를 만든다
  
     public void setSD_CODE(String SD_CODE){
            this.SD_CODE=SD_CODE;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setSGG_CODE(String SGG_CODE){
            this.SGG_CODE=SGG_CODE;
     };
  
     public void setGUBUN(String GUBUN){
            this.GUBUN=GUBUN;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUDP_DT(String UDP_DT){
            this.UDP_DT=UDP_DT;
     };
  
     public void setNAME_HANJA(String NAME_HANJA){
            this.NAME_HANJA=NAME_HANJA;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setSSN1(String SSN1){
            this.SSN1=SSN1;
     };
  
     public void setNOTE(String NOTE){
            this.NOTE=NOTE;
     };
  
     public void setADDR(String ADDR){
            this.ADDR=ADDR;
     };
  
     public void setFAMILY_HEAD(String FAMILY_HEAD){
            this.FAMILY_HEAD=FAMILY_HEAD;
     };
  
     public void setSSN2(String SSN2){
            this.SSN2=SSN2;
     };
  
     public void setFAMILY_HEAD_RELATION(String FAMILY_HEAD_RELATION){
            this.FAMILY_HEAD_RELATION=FAMILY_HEAD_RELATION;
     };
  
     public void setNAME_KOR(String NAME_KOR){
            this.NAME_KOR=NAME_KOR;
     };
  
     public void setORIGIN(String ORIGIN){
            this.ORIGIN=ORIGIN;
     };
  
     public void setTMP_REG_NUM(String TMP_REG_NUM){
            this.TMP_REG_NUM=TMP_REG_NUM;
     };
  
     public void setENTER_DATE(String ENTER_DATE){
            this.ENTER_DATE=ENTER_DATE;
     };
  
     public void setRETIRE_DATE(String RETIRE_DATE){
            this.RETIRE_DATE=RETIRE_DATE;
     };
  
     public void setREFER_YN(String REFER_YN){
            this.REFER_YN=REFER_YN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SD_CODE:"+ this.getSD_CODE()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("SGG_CODE:"+ this.getSGG_CODE()+"\n");
      
      strB.append("GUBUN:"+ this.getGUBUN()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UDP_DT:"+ this.getUDP_DT()+"\n");
      
      strB.append("NAME_HANJA:"+ this.getNAME_HANJA()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("SSN1:"+ this.getSSN1()+"\n");
      
      strB.append("NOTE:"+ this.getNOTE()+"\n");
      
      strB.append("ADDR:"+ this.getADDR()+"\n");
      
      strB.append("FAMILY_HEAD:"+ this.getFAMILY_HEAD()+"\n");
      
      strB.append("SSN2:"+ this.getSSN2()+"\n");
      
      strB.append("FAMILY_HEAD_RELATION:"+ this.getFAMILY_HEAD_RELATION()+"\n");
      
      strB.append("NAME_KOR:"+ this.getNAME_KOR()+"\n");
      
      strB.append("ORIGIN:"+ this.getORIGIN()+"\n");
      
      strB.append("TMP_REG_NUM:"+ this.getTMP_REG_NUM()+"\n");
      
      strB.append("ENTER_DATE:"+ this.getENTER_DATE()+"\n");
      
      strB.append("RETIRE_DATE:"+ this.getRETIRE_DATE()+"\n");
      
      strB.append("REFER_YN:"+ this.getREFER_YN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_REFERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_REFERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_REFERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_REFERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_REFERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_REG_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_REFEREntity();
  }

  public ValueObject getClone(){
         PT_R_REFEREntity newEnt = new PT_R_REFEREntity();
	 
          newEnt.setSD_CODE(this.getSD_CODE());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setSGG_CODE(this.getSGG_CODE());
         
          newEnt.setGUBUN(this.getGUBUN());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUDP_DT(this.getUDP_DT());
         
          newEnt.setNAME_HANJA(this.getNAME_HANJA());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setSSN1(this.getSSN1());
         
          newEnt.setNOTE(this.getNOTE());
         
          newEnt.setADDR(this.getADDR());
         
          newEnt.setFAMILY_HEAD(this.getFAMILY_HEAD());
         
          newEnt.setSSN2(this.getSSN2());
         
          newEnt.setFAMILY_HEAD_RELATION(this.getFAMILY_HEAD_RELATION());
         
          newEnt.setNAME_KOR(this.getNAME_KOR());
         
          newEnt.setORIGIN(this.getORIGIN());
         
          newEnt.setTMP_REG_NUM(this.getTMP_REG_NUM());
         
          newEnt.setENTER_DATE(this.getENTER_DATE());
         
          newEnt.setRETIRE_DATE(this.getRETIRE_DATE());
         
          newEnt.setREFER_YN(this.getREFER_YN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_REFERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSD_CODE();
        
             case 2 :
                 return  this.getSEQ();
        
             case 3 :
                 return  this.getSGG_CODE();
        
             case 4 :
                 return  this.getGUBUN();
        
             case 5 :
                 return  this.getWRT_ID();
        
             case 6 :
                 return  this.getUDP_DT();
        
             case 7 :
                 return  this.getNAME_HANJA();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getSSN1();
        
             case 10 :
                 return  this.getNOTE();
        
             case 11 :
                 return  this.getADDR();
        
             case 12 :
                 return  this.getFAMILY_HEAD();
        
             case 13 :
                 return  this.getSSN2();
        
             case 14 :
                 return  this.getFAMILY_HEAD_RELATION();
        
             case 15 :
                 return  this.getNAME_KOR();
        
             case 16 :
                 return  this.getORIGIN();
        
             case 17 :
                 return  this.getTMP_REG_NUM();
        
             case 18 :
                 return  this.getENTER_DATE();
        
             case 19 :
                 return  this.getRETIRE_DATE();
        
             case 20 :
                 return  this.getREFER_YN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_REFERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSD_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setSEQ((String)value);
	            return;  
        
             case 3 :
                    this.setSGG_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setGUBUN((String)value);
	            return;  
        
             case 5 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 6 :
                    this.setUDP_DT((String)value);
	            return;  
        
             case 7 :
                    this.setNAME_HANJA((String)value);
	            return;  
        
             case 8 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 9 :
                    this.setSSN1((String)value);
	            return;  
        
             case 10 :
                    this.setNOTE((String)value);
	            return;  
        
             case 11 :
                    this.setADDR((String)value);
	            return;  
        
             case 12 :
                    this.setFAMILY_HEAD((String)value);
	            return;  
        
             case 13 :
                    this.setSSN2((String)value);
	            return;  
        
             case 14 :
                    this.setFAMILY_HEAD_RELATION((String)value);
	            return;  
        
             case 15 :
                    this.setNAME_KOR((String)value);
	            return;  
        
             case 16 :
                    this.setORIGIN((String)value);
	            return;  
        
             case 17 :
                    this.setTMP_REG_NUM((String)value);
	            return;  
        
             case 18 :
                    this.setENTER_DATE((String)value);
	            return;  
        
             case 19 :
                    this.setRETIRE_DATE((String)value);
	            return;  
        
             case 20 :
                    this.setREFER_YN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_REFERHelper.toXML(this);
  }
  
}
