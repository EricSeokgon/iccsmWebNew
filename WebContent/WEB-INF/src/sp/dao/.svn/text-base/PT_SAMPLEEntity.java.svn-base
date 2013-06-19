

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_SAMPLE
*  테이블 설명 :
*  테이블 PK   :  
*               REC_NUM  
*               REG_NUM
*  테이블 컬럼 :  
*               REC_NUM:VARCHAR2(32):  
*               REG_NUM:VARCHAR2(32):  
*               SC_CODE:VARCHAR2(2):  
*               SGG_CODE:VARCHAR2(2):  
*               REC_DATE:VARCHAR2(24):  
*               PRO_PERIOD:VARCHAR2(24):  
*               PRO_DUTY:VARCHAR2(16):  
*               PRO_REC_NUM:VARCHAR2(16):  
*               COMPANY_NM:VARCHAR2(32):  
*               APPLICANT:VARCHAR2(24):  
*               TEL:VARCHAR2(16):  
*               FAX:VARCHAR2(16):  
*               REMEMBRANCER:VARCHAR2(24):  
*               SSN1:NUMBER(6):  
*               SSN2:NUMBER(7):  
*               POST_CODE:VARCHAR2(8):  
*               ADDR:VARCHAR2(64):  
*               ADDR_ETC:VARCHAR2(64):  
*               PUBLIC_WORK:VARCHAR2(8):  
*               REP_NUM:VARCHAR2(32):  
*               REC_DUTY:VARCHAR2(24):  
*               REC_WRITE:VARCHAR2(16):  
*               REC_INS_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               UDP_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               NOTE:VARCHAR2(128):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_SAMPLEEntity extends ValueObject{

  
     private String REC_NUM;
  
     private String REG_NUM;
  
     private String SC_CODE;
  
     private String SGG_CODE;
  
     private String REC_DATE;
  
     private String PRO_PERIOD;
  
     private String PRO_DUTY;
  
     private String PRO_REC_NUM;
  
     private String COMPANY_NM;
  
     private String APPLICANT;
  
     private String TEL;
  
     private String FAX;
  
     private String REMEMBRANCER;
  
     private String SSN1;
  
     private String SSN2;
  
     private String POST_CODE;
  
     private String ADDR;
  
     private String ADDR_ETC;
  
     private String PUBLIC_WORK;
  
     private String REP_NUM;
  
     private String REC_DUTY;
  
     private String REC_WRITE;
  
     private String REC_INS_DT;
  
     private String WRT_ID;
  
     private String UDP_DT;
  
     private String INS_DT;
  
     private String NOTE;
  

//생성자를 만든다
    public PT_SAMPLEEntity(){
    }
    
    
    public PT_SAMPLEEntity(String REC_NUM,String REG_NUM ){
       this.setREC_NUM(REC_NUM);
       this.setREG_NUM(REG_NUM);
       
    }
      
    public PT_SAMPLEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("REC_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("REC_NUM",value);
       
       value = ent.getByName("REG_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("REG_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.REC_NUM =request.getParameter("REC_NUM");
		this.REG_NUM =request.getParameter("REG_NUM");
		this.SC_CODE =request.getParameter("SC_CODE");
		this.SGG_CODE =request.getParameter("SGG_CODE");
		this.REC_DATE =request.getParameter("REC_DATE");
		this.PRO_PERIOD =request.getParameter("PRO_PERIOD");
		this.PRO_DUTY =request.getParameter("PRO_DUTY");
		this.PRO_REC_NUM =request.getParameter("PRO_REC_NUM");
		this.COMPANY_NM =request.getParameter("COMPANY_NM");
		this.APPLICANT =request.getParameter("APPLICANT");
		this.TEL =request.getParameter("TEL");
		this.FAX =request.getParameter("FAX");
		this.REMEMBRANCER =request.getParameter("REMEMBRANCER");
		this.SSN1 =request.getParameter("SSN1");
		this.SSN2 =request.getParameter("SSN2");
		this.POST_CODE =request.getParameter("POST_CODE");
		this.ADDR =request.getParameter("ADDR");
		this.ADDR_ETC =request.getParameter("ADDR_ETC");
		this.PUBLIC_WORK =request.getParameter("PUBLIC_WORK");
		this.REP_NUM =request.getParameter("REP_NUM");
		this.REC_DUTY =request.getParameter("REC_DUTY");
		this.REC_WRITE =request.getParameter("REC_WRITE");
		this.REC_INS_DT =request.getParameter("REC_INS_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UDP_DT =request.getParameter("UDP_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.NOTE =request.getParameter("NOTE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.REC_NUM =KJFMi.dsGet(ds, arg_row, "REC_NUM");
		this.REG_NUM =KJFMi.dsGet(ds, arg_row, "REG_NUM");
		this.SC_CODE =KJFMi.dsGet(ds, arg_row, "SC_CODE");
		this.SGG_CODE =KJFMi.dsGet(ds, arg_row, "SGG_CODE");
		this.REC_DATE =KJFMi.dsGet(ds, arg_row, "REC_DATE");
		this.PRO_PERIOD =KJFMi.dsGet(ds, arg_row, "PRO_PERIOD");
		this.PRO_DUTY =KJFMi.dsGet(ds, arg_row, "PRO_DUTY");
		this.PRO_REC_NUM =KJFMi.dsGet(ds, arg_row, "PRO_REC_NUM");
		this.COMPANY_NM =KJFMi.dsGet(ds, arg_row, "COMPANY_NM");
		this.APPLICANT =KJFMi.dsGet(ds, arg_row, "APPLICANT");
		this.TEL =KJFMi.dsGet(ds, arg_row, "TEL");
		this.FAX =KJFMi.dsGet(ds, arg_row, "FAX");
		this.REMEMBRANCER =KJFMi.dsGet(ds, arg_row, "REMEMBRANCER");
		this.SSN1 =KJFMi.dsGet(ds, arg_row, "SSN1");
		this.SSN2 =KJFMi.dsGet(ds, arg_row, "SSN2");
		this.POST_CODE =KJFMi.dsGet(ds, arg_row, "POST_CODE");
		this.ADDR =KJFMi.dsGet(ds, arg_row, "ADDR");
		this.ADDR_ETC =KJFMi.dsGet(ds, arg_row, "ADDR_ETC");
		this.PUBLIC_WORK =KJFMi.dsGet(ds, arg_row, "PUBLIC_WORK");
		this.REP_NUM =KJFMi.dsGet(ds, arg_row, "REP_NUM");
		this.REC_DUTY =KJFMi.dsGet(ds, arg_row, "REC_DUTY");
		this.REC_WRITE =KJFMi.dsGet(ds, arg_row, "REC_WRITE");
		this.REC_INS_DT =KJFMi.dsGet(ds, arg_row, "REC_INS_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UDP_DT =KJFMi.dsGet(ds, arg_row, "UDP_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.NOTE =KJFMi.dsGet(ds, arg_row, "NOTE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getREC_NUM(){
             return REC_NUM;
     };
  
     public String getREG_NUM(){
             return REG_NUM;
     };
  
     public String getSC_CODE(){
             return SC_CODE;
     };
  
     public String getSGG_CODE(){
             return SGG_CODE;
     };
  
     public String getREC_DATE(){
             return REC_DATE;
     };
  
     public String getPRO_PERIOD(){
             return PRO_PERIOD;
     };
  
     public String getPRO_DUTY(){
             return PRO_DUTY;
     };
  
     public String getPRO_REC_NUM(){
             return PRO_REC_NUM;
     };
  
     public String getCOMPANY_NM(){
             return COMPANY_NM;
     };
  
     public String getAPPLICANT(){
             return APPLICANT;
     };
  
     public String getTEL(){
             return TEL;
     };
  
     public String getFAX(){
             return FAX;
     };
  
     public String getREMEMBRANCER(){
             return REMEMBRANCER;
     };
  
     public String getSSN1(){
             return SSN1;
     };
  
     public String getSSN2(){
             return SSN2;
     };
  
     public String getPOST_CODE(){
             return POST_CODE;
     };
  
     public String getADDR(){
             return ADDR;
     };
  
     public String getADDR_ETC(){
             return ADDR_ETC;
     };
  
     public String getPUBLIC_WORK(){
             return PUBLIC_WORK;
     };
  
     public String getREP_NUM(){
             return REP_NUM;
     };
  
     public String getREC_DUTY(){
             return REC_DUTY;
     };
  
     public String getREC_WRITE(){
             return REC_WRITE;
     };
  
     public String getREC_INS_DT(){
             return REC_INS_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUDP_DT(){
             return UDP_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getNOTE(){
             return NOTE;
     };
  

//Setter 함수를 만든다
  
     public void setREC_NUM(String REC_NUM){
            this.REC_NUM=REC_NUM;
     };
  
     public void setREG_NUM(String REG_NUM){
            this.REG_NUM=REG_NUM;
     };
  
     public void setSC_CODE(String SC_CODE){
            this.SC_CODE=SC_CODE;
     };
  
     public void setSGG_CODE(String SGG_CODE){
            this.SGG_CODE=SGG_CODE;
     };
  
     public void setREC_DATE(String REC_DATE){
            this.REC_DATE=REC_DATE;
     };
  
     public void setPRO_PERIOD(String PRO_PERIOD){
            this.PRO_PERIOD=PRO_PERIOD;
     };
  
     public void setPRO_DUTY(String PRO_DUTY){
            this.PRO_DUTY=PRO_DUTY;
     };
  
     public void setPRO_REC_NUM(String PRO_REC_NUM){
            this.PRO_REC_NUM=PRO_REC_NUM;
     };
  
     public void setCOMPANY_NM(String COMPANY_NM){
            this.COMPANY_NM=COMPANY_NM;
     };
  
     public void setAPPLICANT(String APPLICANT){
            this.APPLICANT=APPLICANT;
     };
  
     public void setTEL(String TEL){
            this.TEL=TEL;
     };
  
     public void setFAX(String FAX){
            this.FAX=FAX;
     };
  
     public void setREMEMBRANCER(String REMEMBRANCER){
            this.REMEMBRANCER=REMEMBRANCER;
     };
  
     public void setSSN1(String SSN1){
            this.SSN1=SSN1;
     };
  
     public void setSSN2(String SSN2){
            this.SSN2=SSN2;
     };
  
     public void setPOST_CODE(String POST_CODE){
            this.POST_CODE=POST_CODE;
     };
  
     public void setADDR(String ADDR){
            this.ADDR=ADDR;
     };
  
     public void setADDR_ETC(String ADDR_ETC){
            this.ADDR_ETC=ADDR_ETC;
     };
  
     public void setPUBLIC_WORK(String PUBLIC_WORK){
            this.PUBLIC_WORK=PUBLIC_WORK;
     };
  
     public void setREP_NUM(String REP_NUM){
            this.REP_NUM=REP_NUM;
     };
  
     public void setREC_DUTY(String REC_DUTY){
            this.REC_DUTY=REC_DUTY;
     };
  
     public void setREC_WRITE(String REC_WRITE){
            this.REC_WRITE=REC_WRITE;
     };
  
     public void setREC_INS_DT(String REC_INS_DT){
            this.REC_INS_DT=REC_INS_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUDP_DT(String UDP_DT){
            this.UDP_DT=UDP_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setNOTE(String NOTE){
            this.NOTE=NOTE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("REC_NUM:"+ this.getREC_NUM()+"\n");
      
      strB.append("REG_NUM:"+ this.getREG_NUM()+"\n");
      
      strB.append("SC_CODE:"+ this.getSC_CODE()+"\n");
      
      strB.append("SGG_CODE:"+ this.getSGG_CODE()+"\n");
      
      strB.append("REC_DATE:"+ this.getREC_DATE()+"\n");
      
      strB.append("PRO_PERIOD:"+ this.getPRO_PERIOD()+"\n");
      
      strB.append("PRO_DUTY:"+ this.getPRO_DUTY()+"\n");
      
      strB.append("PRO_REC_NUM:"+ this.getPRO_REC_NUM()+"\n");
      
      strB.append("COMPANY_NM:"+ this.getCOMPANY_NM()+"\n");
      
      strB.append("APPLICANT:"+ this.getAPPLICANT()+"\n");
      
      strB.append("TEL:"+ this.getTEL()+"\n");
      
      strB.append("FAX:"+ this.getFAX()+"\n");
      
      strB.append("REMEMBRANCER:"+ this.getREMEMBRANCER()+"\n");
      
      strB.append("SSN1:"+ this.getSSN1()+"\n");
      
      strB.append("SSN2:"+ this.getSSN2()+"\n");
      
      strB.append("POST_CODE:"+ this.getPOST_CODE()+"\n");
      
      strB.append("ADDR:"+ this.getADDR()+"\n");
      
      strB.append("ADDR_ETC:"+ this.getADDR_ETC()+"\n");
      
      strB.append("PUBLIC_WORK:"+ this.getPUBLIC_WORK()+"\n");
      
      strB.append("REP_NUM:"+ this.getREP_NUM()+"\n");
      
      strB.append("REC_DUTY:"+ this.getREC_DUTY()+"\n");
      
      strB.append("REC_WRITE:"+ this.getREC_WRITE()+"\n");
      
      strB.append("REC_INS_DT:"+ this.getREC_INS_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UDP_DT:"+ this.getUDP_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("NOTE:"+ this.getNOTE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_SAMPLEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_SAMPLEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_SAMPLEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_SAMPLEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_SAMPLEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getREC_NUM();
       values[1]= this.getREG_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_SAMPLEEntity();
  }

  public ValueObject getClone(){
         PT_SAMPLEEntity newEnt = new PT_SAMPLEEntity();
	 
          newEnt.setREC_NUM(this.getREC_NUM());
         
          newEnt.setREG_NUM(this.getREG_NUM());
         
          newEnt.setSC_CODE(this.getSC_CODE());
         
          newEnt.setSGG_CODE(this.getSGG_CODE());
         
          newEnt.setREC_DATE(this.getREC_DATE());
         
          newEnt.setPRO_PERIOD(this.getPRO_PERIOD());
         
          newEnt.setPRO_DUTY(this.getPRO_DUTY());
         
          newEnt.setPRO_REC_NUM(this.getPRO_REC_NUM());
         
          newEnt.setCOMPANY_NM(this.getCOMPANY_NM());
         
          newEnt.setAPPLICANT(this.getAPPLICANT());
         
          newEnt.setTEL(this.getTEL());
         
          newEnt.setFAX(this.getFAX());
         
          newEnt.setREMEMBRANCER(this.getREMEMBRANCER());
         
          newEnt.setSSN1(this.getSSN1());
         
          newEnt.setSSN2(this.getSSN2());
         
          newEnt.setPOST_CODE(this.getPOST_CODE());
         
          newEnt.setADDR(this.getADDR());
         
          newEnt.setADDR_ETC(this.getADDR_ETC());
         
          newEnt.setPUBLIC_WORK(this.getPUBLIC_WORK());
         
          newEnt.setREP_NUM(this.getREP_NUM());
         
          newEnt.setREC_DUTY(this.getREC_DUTY());
         
          newEnt.setREC_WRITE(this.getREC_WRITE());
         
          newEnt.setREC_INS_DT(this.getREC_INS_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUDP_DT(this.getUDP_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setNOTE(this.getNOTE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_SAMPLEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getREC_NUM();
        
             case 2 :
                 return  this.getREG_NUM();
        
             case 3 :
                 return  this.getSC_CODE();
        
             case 4 :
                 return  this.getSGG_CODE();
        
             case 5 :
                 return  this.getREC_DATE();
        
             case 6 :
                 return  this.getPRO_PERIOD();
        
             case 7 :
                 return  this.getPRO_DUTY();
        
             case 8 :
                 return  this.getPRO_REC_NUM();
        
             case 9 :
                 return  this.getCOMPANY_NM();
        
             case 10 :
                 return  this.getAPPLICANT();
        
             case 11 :
                 return  this.getTEL();
        
             case 12 :
                 return  this.getFAX();
        
             case 13 :
                 return  this.getREMEMBRANCER();
        
             case 14 :
                 return  this.getSSN1();
        
             case 15 :
                 return  this.getSSN2();
        
             case 16 :
                 return  this.getPOST_CODE();
        
             case 17 :
                 return  this.getADDR();
        
             case 18 :
                 return  this.getADDR_ETC();
        
             case 19 :
                 return  this.getPUBLIC_WORK();
        
             case 20 :
                 return  this.getREP_NUM();
        
             case 21 :
                 return  this.getREC_DUTY();
        
             case 22 :
                 return  this.getREC_WRITE();
        
             case 23 :
                 return  this.getREC_INS_DT();
        
             case 24 :
                 return  this.getWRT_ID();
        
             case 25 :
                 return  this.getUDP_DT();
        
             case 26 :
                 return  this.getINS_DT();
        
             case 27 :
                 return  this.getNOTE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_SAMPLEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setREC_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setREG_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setSC_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setSGG_CODE((String)value);
	            return;  
        
             case 5 :
                    this.setREC_DATE((String)value);
	            return;  
        
             case 6 :
                    this.setPRO_PERIOD((String)value);
	            return;  
        
             case 7 :
                    this.setPRO_DUTY((String)value);
	            return;  
        
             case 8 :
                    this.setPRO_REC_NUM((String)value);
	            return;  
        
             case 9 :
                    this.setCOMPANY_NM((String)value);
	            return;  
        
             case 10 :
                    this.setAPPLICANT((String)value);
	            return;  
        
             case 11 :
                    this.setTEL((String)value);
	            return;  
        
             case 12 :
                    this.setFAX((String)value);
	            return;  
        
             case 13 :
                    this.setREMEMBRANCER((String)value);
	            return;  
        
             case 14 :
                    this.setSSN1((String)value);
	            return;  
        
             case 15 :
                    this.setSSN2((String)value);
	            return;  
        
             case 16 :
                    this.setPOST_CODE((String)value);
	            return;  
        
             case 17 :
                    this.setADDR((String)value);
	            return;  
        
             case 18 :
                    this.setADDR_ETC((String)value);
	            return;  
        
             case 19 :
                    this.setPUBLIC_WORK((String)value);
	            return;  
        
             case 20 :
                    this.setREP_NUM((String)value);
	            return;  
        
             case 21 :
                    this.setREC_DUTY((String)value);
	            return;  
        
             case 22 :
                    this.setREC_WRITE((String)value);
	            return;  
        
             case 23 :
                    this.setREC_INS_DT((String)value);
	            return;  
        
             case 24 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 25 :
                    this.setUDP_DT((String)value);
	            return;  
        
             case 26 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 27 :
                    this.setNOTE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_SAMPLEHelper.toXML(this);
  }
  
}
