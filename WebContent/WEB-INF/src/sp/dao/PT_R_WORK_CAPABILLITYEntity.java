

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_WORK_CAPABILLITY
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_REG_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               RC_REGIST_NUM:VARCHAR2(20):  
*               ASSESSMENT_DATE:VARCHAR2(20):  
*               ASSESSMENT_MONEY:VARCHAR2(20):  
*               ASSESSMENT_APPL_DATE:VARCHAR2(20):  
*               CONFIRM:VARCHAR2(20):  
*               TMP_REG_NUM:CHAR(18):  
*               WRT_ID:VARCHAR2(16):  
*               UDP_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_WORK_CAPABILLITYEntity extends ValueObject{

  
     private String SEQ;
  
     private String RC_REGIST_NUM;
  
     private String ASSESSMENT_DATE;
  
     private String ASSESSMENT_MONEY;
  
     private String ASSESSMENT_APPL_DATE;
  
     private String CONFIRM;
  
     private String TMP_REG_NUM;
  
     private String WRT_ID;
  
     private String UDP_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_R_WORK_CAPABILLITYEntity(){
    }
    
    
    public PT_R_WORK_CAPABILLITYEntity(String SEQ,String TMP_REG_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_REG_NUM(TMP_REG_NUM);
       
    }
      
    public PT_R_WORK_CAPABILLITYEntity(ValueObject ent) throws Exception{
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
		this.SEQ =request.getParameter("SEQ");
		this.RC_REGIST_NUM =request.getParameter("RC_REGIST_NUM");
		this.ASSESSMENT_DATE =request.getParameter("ASSESSMENT_DATE");
		this.ASSESSMENT_MONEY =request.getParameter("ASSESSMENT_MONEY");
		this.ASSESSMENT_APPL_DATE =request.getParameter("ASSESSMENT_APPL_DATE");
		this.CONFIRM =request.getParameter("CONFIRM");
		this.TMP_REG_NUM =request.getParameter("TMP_REG_NUM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UDP_DT =request.getParameter("UDP_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.RC_REGIST_NUM =KJFMi.dsGet(ds, arg_row, "RC_REGIST_NUM");
		this.ASSESSMENT_DATE =KJFMi.dsGet(ds, arg_row, "ASSESSMENT_DATE");
		this.ASSESSMENT_MONEY =KJFMi.dsGet(ds, arg_row, "ASSESSMENT_MONEY");
		this.ASSESSMENT_APPL_DATE =KJFMi.dsGet(ds, arg_row, "ASSESSMENT_APPL_DATE");
		this.CONFIRM =KJFMi.dsGet(ds, arg_row, "CONFIRM");
		this.TMP_REG_NUM =KJFMi.dsGet(ds, arg_row, "TMP_REG_NUM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UDP_DT =KJFMi.dsGet(ds, arg_row, "UDP_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getRC_REGIST_NUM(){
             return RC_REGIST_NUM;
     };
  
     public String getASSESSMENT_DATE(){
             return ASSESSMENT_DATE;
     };
  
     public String getASSESSMENT_MONEY(){
             return ASSESSMENT_MONEY;
     };
  
     public String getASSESSMENT_APPL_DATE(){
             return ASSESSMENT_APPL_DATE;
     };
  
     public String getCONFIRM(){
             return CONFIRM;
     };
  
     public String getTMP_REG_NUM(){
             return TMP_REG_NUM;
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
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setRC_REGIST_NUM(String RC_REGIST_NUM){
            this.RC_REGIST_NUM=RC_REGIST_NUM;
     };
  
     public void setASSESSMENT_DATE(String ASSESSMENT_DATE){
            this.ASSESSMENT_DATE=ASSESSMENT_DATE;
     };
  
     public void setASSESSMENT_MONEY(String ASSESSMENT_MONEY){
            this.ASSESSMENT_MONEY=ASSESSMENT_MONEY;
     };
  
     public void setASSESSMENT_APPL_DATE(String ASSESSMENT_APPL_DATE){
            this.ASSESSMENT_APPL_DATE=ASSESSMENT_APPL_DATE;
     };
  
     public void setCONFIRM(String CONFIRM){
            this.CONFIRM=CONFIRM;
     };
  
     public void setTMP_REG_NUM(String TMP_REG_NUM){
            this.TMP_REG_NUM=TMP_REG_NUM;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("RC_REGIST_NUM:"+ this.getRC_REGIST_NUM()+"\n");
      
      strB.append("ASSESSMENT_DATE:"+ this.getASSESSMENT_DATE()+"\n");
      
      strB.append("ASSESSMENT_MONEY:"+ this.getASSESSMENT_MONEY()+"\n");
      
      strB.append("ASSESSMENT_APPL_DATE:"+ this.getASSESSMENT_APPL_DATE()+"\n");
      
      strB.append("CONFIRM:"+ this.getCONFIRM()+"\n");
      
      strB.append("TMP_REG_NUM:"+ this.getTMP_REG_NUM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UDP_DT:"+ this.getUDP_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_WORK_CAPABILLITYHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_WORK_CAPABILLITYHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_WORK_CAPABILLITYHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_WORK_CAPABILLITYHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_WORK_CAPABILLITYHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_REG_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_WORK_CAPABILLITYEntity();
  }

  public ValueObject getClone(){
         PT_R_WORK_CAPABILLITYEntity newEnt = new PT_R_WORK_CAPABILLITYEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setRC_REGIST_NUM(this.getRC_REGIST_NUM());
         
          newEnt.setASSESSMENT_DATE(this.getASSESSMENT_DATE());
         
          newEnt.setASSESSMENT_MONEY(this.getASSESSMENT_MONEY());
         
          newEnt.setASSESSMENT_APPL_DATE(this.getASSESSMENT_APPL_DATE());
         
          newEnt.setCONFIRM(this.getCONFIRM());
         
          newEnt.setTMP_REG_NUM(this.getTMP_REG_NUM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUDP_DT(this.getUDP_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_WORK_CAPABILLITYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getRC_REGIST_NUM();
        
             case 3 :
                 return  this.getASSESSMENT_DATE();
        
             case 4 :
                 return  this.getASSESSMENT_MONEY();
        
             case 5 :
                 return  this.getASSESSMENT_APPL_DATE();
        
             case 6 :
                 return  this.getCONFIRM();
        
             case 7 :
                 return  this.getTMP_REG_NUM();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getUDP_DT();
        
             case 10 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_WORK_CAPABILLITYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setRC_REGIST_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setASSESSMENT_DATE((String)value);
	            return;  
        
             case 4 :
                    this.setASSESSMENT_MONEY((String)value);
	            return;  
        
             case 5 :
                    this.setASSESSMENT_APPL_DATE((String)value);
	            return;  
        
             case 6 :
                    this.setCONFIRM((String)value);
	            return;  
        
             case 7 :
                    this.setTMP_REG_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 9 :
                    this.setUDP_DT((String)value);
	            return;  
        
             case 10 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_WORK_CAPABILLITYHelper.toXML(this);
  }
  
}
