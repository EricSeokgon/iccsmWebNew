

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_CHANGE_HISTORY
*  테이블 설명 :
*  테이블 PK   :  
*               CHANGE_SEQ  
*               TMP_REG_NUM
*  테이블 컬럼 :  
*               CHANGE_SEQ:VARCHAR2(20):  
*               CHANGE_DIV:VARCHAR2(20):  
*               RC_REGIST_NUM:VARCHAR2(20):  
*               REC_NUM:VARCHAR2(24):  
*               REC_ORGAN:VARCHAR2(20):  
*               SD_CODE:VARCHAR2(20):  
*               REC_PERIOD:VARCHAR2(20):  
*               MEMO:VARCHAR2(20):  
*               WRT_ID:VARCHAR2(16):  
*               UDP_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               TMP_REG_NUM:CHAR(18):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_CHANGE_HISTORYEntity extends ValueObject{

  
     private String CHANGE_SEQ;
  
     private String CHANGE_DIV;
  
     private String RC_REGIST_NUM;
  
     private String REC_NUM;
  
     private String REC_ORGAN;
  
     private String SD_CODE;
  
     private String REC_PERIOD;
  
     private String MEMO;
  
     private String WRT_ID;
  
     private String UDP_DT;
  
     private String INS_DT;
  
     private String TMP_REG_NUM;
  

//생성자를 만든다
    public PT_R_CHANGE_HISTORYEntity(){
    }
    
    
    public PT_R_CHANGE_HISTORYEntity(String CHANGE_SEQ,String TMP_REG_NUM ){
       this.setCHANGE_SEQ(CHANGE_SEQ);
       this.setTMP_REG_NUM(TMP_REG_NUM);
       
    }
      
    public PT_R_CHANGE_HISTORYEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CHANGE_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CHANGE_SEQ",value);
       
       value = ent.getByName("TMP_REG_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_REG_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CHANGE_SEQ =request.getParameter("CHANGE_SEQ");
		this.CHANGE_DIV =request.getParameter("CHANGE_DIV");
		this.RC_REGIST_NUM =request.getParameter("RC_REGIST_NUM");
		this.REC_NUM =request.getParameter("REC_NUM");
		this.REC_ORGAN =request.getParameter("REC_ORGAN");
		this.SD_CODE =request.getParameter("SD_CODE");
		this.REC_PERIOD =request.getParameter("REC_PERIOD");
		this.MEMO =request.getParameter("MEMO");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UDP_DT =request.getParameter("UDP_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.TMP_REG_NUM =request.getParameter("TMP_REG_NUM");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CHANGE_SEQ =KJFMi.dsGet(ds, arg_row, "CHANGE_SEQ");
		this.CHANGE_DIV =KJFMi.dsGet(ds, arg_row, "CHANGE_DIV");
		this.RC_REGIST_NUM =KJFMi.dsGet(ds, arg_row, "RC_REGIST_NUM");
		this.REC_NUM =KJFMi.dsGet(ds, arg_row, "REC_NUM");
		this.REC_ORGAN =KJFMi.dsGet(ds, arg_row, "REC_ORGAN");
		this.SD_CODE =KJFMi.dsGet(ds, arg_row, "SD_CODE");
		this.REC_PERIOD =KJFMi.dsGet(ds, arg_row, "REC_PERIOD");
		this.MEMO =KJFMi.dsGet(ds, arg_row, "MEMO");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UDP_DT =KJFMi.dsGet(ds, arg_row, "UDP_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.TMP_REG_NUM =KJFMi.dsGet(ds, arg_row, "TMP_REG_NUM");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCHANGE_SEQ(){
             return CHANGE_SEQ;
     };
  
     public String getCHANGE_DIV(){
             return CHANGE_DIV;
     };
  
     public String getRC_REGIST_NUM(){
             return RC_REGIST_NUM;
     };
  
     public String getREC_NUM(){
             return REC_NUM;
     };
  
     public String getREC_ORGAN(){
             return REC_ORGAN;
     };
  
     public String getSD_CODE(){
             return SD_CODE;
     };
  
     public String getREC_PERIOD(){
             return REC_PERIOD;
     };
  
     public String getMEMO(){
             return MEMO;
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
  
     public String getTMP_REG_NUM(){
             return TMP_REG_NUM;
     };
  

//Setter 함수를 만든다
  
     public void setCHANGE_SEQ(String CHANGE_SEQ){
            this.CHANGE_SEQ=CHANGE_SEQ;
     };
  
     public void setCHANGE_DIV(String CHANGE_DIV){
            this.CHANGE_DIV=CHANGE_DIV;
     };
  
     public void setRC_REGIST_NUM(String RC_REGIST_NUM){
            this.RC_REGIST_NUM=RC_REGIST_NUM;
     };
  
     public void setREC_NUM(String REC_NUM){
            this.REC_NUM=REC_NUM;
     };
  
     public void setREC_ORGAN(String REC_ORGAN){
            this.REC_ORGAN=REC_ORGAN;
     };
  
     public void setSD_CODE(String SD_CODE){
            this.SD_CODE=SD_CODE;
     };
  
     public void setREC_PERIOD(String REC_PERIOD){
            this.REC_PERIOD=REC_PERIOD;
     };
  
     public void setMEMO(String MEMO){
            this.MEMO=MEMO;
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
  
     public void setTMP_REG_NUM(String TMP_REG_NUM){
            this.TMP_REG_NUM=TMP_REG_NUM;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CHANGE_SEQ:"+ this.getCHANGE_SEQ()+"\n");
      
      strB.append("CHANGE_DIV:"+ this.getCHANGE_DIV()+"\n");
      
      strB.append("RC_REGIST_NUM:"+ this.getRC_REGIST_NUM()+"\n");
      
      strB.append("REC_NUM:"+ this.getREC_NUM()+"\n");
      
      strB.append("REC_ORGAN:"+ this.getREC_ORGAN()+"\n");
      
      strB.append("SD_CODE:"+ this.getSD_CODE()+"\n");
      
      strB.append("REC_PERIOD:"+ this.getREC_PERIOD()+"\n");
      
      strB.append("MEMO:"+ this.getMEMO()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UDP_DT:"+ this.getUDP_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("TMP_REG_NUM:"+ this.getTMP_REG_NUM()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_CHANGE_HISTORYHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_CHANGE_HISTORYHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_CHANGE_HISTORYHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_CHANGE_HISTORYHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_CHANGE_HISTORYHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCHANGE_SEQ();
       values[1]= this.getTMP_REG_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_CHANGE_HISTORYEntity();
  }

  public ValueObject getClone(){
         PT_R_CHANGE_HISTORYEntity newEnt = new PT_R_CHANGE_HISTORYEntity();
	 
          newEnt.setCHANGE_SEQ(this.getCHANGE_SEQ());
         
          newEnt.setCHANGE_DIV(this.getCHANGE_DIV());
         
          newEnt.setRC_REGIST_NUM(this.getRC_REGIST_NUM());
         
          newEnt.setREC_NUM(this.getREC_NUM());
         
          newEnt.setREC_ORGAN(this.getREC_ORGAN());
         
          newEnt.setSD_CODE(this.getSD_CODE());
         
          newEnt.setREC_PERIOD(this.getREC_PERIOD());
         
          newEnt.setMEMO(this.getMEMO());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUDP_DT(this.getUDP_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setTMP_REG_NUM(this.getTMP_REG_NUM());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_CHANGE_HISTORYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCHANGE_SEQ();
        
             case 2 :
                 return  this.getCHANGE_DIV();
        
             case 3 :
                 return  this.getRC_REGIST_NUM();
        
             case 4 :
                 return  this.getREC_NUM();
        
             case 5 :
                 return  this.getREC_ORGAN();
        
             case 6 :
                 return  this.getSD_CODE();
        
             case 7 :
                 return  this.getREC_PERIOD();
        
             case 8 :
                 return  this.getMEMO();
        
             case 9 :
                 return  this.getWRT_ID();
        
             case 10 :
                 return  this.getUDP_DT();
        
             case 11 :
                 return  this.getINS_DT();
        
             case 12 :
                 return  this.getTMP_REG_NUM();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_CHANGE_HISTORYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCHANGE_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCHANGE_DIV((String)value);
	            return;  
        
             case 3 :
                    this.setRC_REGIST_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setREC_NUM((String)value);
	            return;  
        
             case 5 :
                    this.setREC_ORGAN((String)value);
	            return;  
        
             case 6 :
                    this.setSD_CODE((String)value);
	            return;  
        
             case 7 :
                    this.setREC_PERIOD((String)value);
	            return;  
        
             case 8 :
                    this.setMEMO((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 10 :
                    this.setUDP_DT((String)value);
	            return;  
        
             case 11 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 12 :
                    this.setTMP_REG_NUM((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_CHANGE_HISTORYHelper.toXML(this);
  }
  
}
