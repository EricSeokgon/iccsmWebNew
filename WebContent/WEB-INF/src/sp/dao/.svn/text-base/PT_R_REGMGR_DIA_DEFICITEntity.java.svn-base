

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REGMGR_DIA_DEFICIT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_REG_NUM
*  테이블 컬럼 :  
*               TMP_REG_NUM:CHAR(18):  
*               SEQ:NUMBER(11):  
*               DEFICIT_CODE:VARCHAR2(6):  
*               DEFICIT_RESULT:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_REGMGR_DIA_DEFICITEntity extends ValueObject{

  
     private String TMP_REG_NUM;
  
     private String SEQ;
  
     private String DEFICIT_CODE;
  
     private String DEFICIT_RESULT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_R_REGMGR_DIA_DEFICITEntity(){
    }
    
    
    public PT_R_REGMGR_DIA_DEFICITEntity(String SEQ,String TMP_REG_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_REG_NUM(TMP_REG_NUM);
       
    }
      
    public PT_R_REGMGR_DIA_DEFICITEntity(ValueObject ent) throws Exception{
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
		this.TMP_REG_NUM =request.getParameter("TMP_REG_NUM");
		this.SEQ =request.getParameter("SEQ");
		this.DEFICIT_CODE =request.getParameter("DEFICIT_CODE");
		this.DEFICIT_RESULT =request.getParameter("DEFICIT_RESULT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_REG_NUM =KJFMi.dsGet(ds, arg_row, "TMP_REG_NUM");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.DEFICIT_CODE =KJFMi.dsGet(ds, arg_row, "DEFICIT_CODE");
		this.DEFICIT_RESULT =KJFMi.dsGet(ds, arg_row, "DEFICIT_RESULT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_REG_NUM(){
             return TMP_REG_NUM;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getDEFICIT_CODE(){
             return DEFICIT_CODE;
     };
  
     public String getDEFICIT_RESULT(){
             return DEFICIT_RESULT;
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
  

//Setter 함수를 만든다
  
     public void setTMP_REG_NUM(String TMP_REG_NUM){
            this.TMP_REG_NUM=TMP_REG_NUM;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setDEFICIT_CODE(String DEFICIT_CODE){
            this.DEFICIT_CODE=DEFICIT_CODE;
     };
  
     public void setDEFICIT_RESULT(String DEFICIT_RESULT){
            this.DEFICIT_RESULT=DEFICIT_RESULT;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_REG_NUM:"+ this.getTMP_REG_NUM()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("DEFICIT_CODE:"+ this.getDEFICIT_CODE()+"\n");
      
      strB.append("DEFICIT_RESULT:"+ this.getDEFICIT_RESULT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_REGMGR_DIA_DEFICITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_REGMGR_DIA_DEFICITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_REGMGR_DIA_DEFICITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_REGMGR_DIA_DEFICITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_REGMGR_DIA_DEFICITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_REG_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_REGMGR_DIA_DEFICITEntity();
  }

  public ValueObject getClone(){
         PT_R_REGMGR_DIA_DEFICITEntity newEnt = new PT_R_REGMGR_DIA_DEFICITEntity();
	 
          newEnt.setTMP_REG_NUM(this.getTMP_REG_NUM());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setDEFICIT_CODE(this.getDEFICIT_CODE());
         
          newEnt.setDEFICIT_RESULT(this.getDEFICIT_RESULT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_REGMGR_DIA_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_REG_NUM();
        
             case 2 :
                 return  this.getSEQ();
        
             case 3 :
                 return  this.getDEFICIT_CODE();
        
             case 4 :
                 return  this.getDEFICIT_RESULT();
        
             case 5 :
                 return  this.getWRT_ID();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_REGMGR_DIA_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_REG_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSEQ((String)value);
	            return;  
        
             case 3 :
                    this.setDEFICIT_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setDEFICIT_RESULT((String)value);
	            return;  
        
             case 5 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_REGMGR_DIA_DEFICITHelper.toXML(this);
  }
  
}
