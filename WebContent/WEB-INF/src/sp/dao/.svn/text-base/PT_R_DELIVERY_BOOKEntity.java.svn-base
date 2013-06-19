

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_DELIVERY_BOOK
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DELI_CAUSE:VARCHAR2(256):  
*               DELI_YMD:VARCHAR2(8):  
*               REMARK:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               DELI_CLASS:VARCHAR2(6):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_DELIVERY_BOOKEntity extends ValueObject{

  
     private String SEQ;
  
     private String TMP_WRT_NUM;
  
     private String DELI_CAUSE;
  
     private String DELI_YMD;
  
     private String REMARK;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String DELI_CLASS;
  

//생성자를 만든다
    public PT_R_DELIVERY_BOOKEntity(){
    }
    
    
    public PT_R_DELIVERY_BOOKEntity(String SEQ,String TMP_WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_DELIVERY_BOOKEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
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
		this.DELI_CAUSE =request.getParameter("DELI_CAUSE");
		this.DELI_YMD =request.getParameter("DELI_YMD");
		this.REMARK =request.getParameter("REMARK");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.DELI_CLASS =request.getParameter("DELI_CLASS");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DELI_CAUSE =KJFMi.dsGet(ds, arg_row, "DELI_CAUSE");
		this.DELI_YMD =KJFMi.dsGet(ds, arg_row, "DELI_YMD");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.DELI_CLASS =KJFMi.dsGet(ds, arg_row, "DELI_CLASS");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getDELI_CAUSE(){
             return DELI_CAUSE;
     };
  
     public String getDELI_YMD(){
             return DELI_YMD;
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
  
     public String getDELI_CLASS(){
             return DELI_CLASS;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setDELI_CAUSE(String DELI_CAUSE){
            this.DELI_CAUSE=DELI_CAUSE;
     };
  
     public void setDELI_YMD(String DELI_YMD){
            this.DELI_YMD=DELI_YMD;
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
  
     public void setDELI_CLASS(String DELI_CLASS){
            this.DELI_CLASS=DELI_CLASS;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("DELI_CAUSE:"+ this.getDELI_CAUSE()+"\n");
      
      strB.append("DELI_YMD:"+ this.getDELI_YMD()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("DELI_CLASS:"+ this.getDELI_CLASS()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_DELIVERY_BOOKHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_DELIVERY_BOOKHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_DELIVERY_BOOKHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_DELIVERY_BOOKHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_DELIVERY_BOOKHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_DELIVERY_BOOKEntity();
  }

  public ValueObject getClone(){
         PT_R_DELIVERY_BOOKEntity newEnt = new PT_R_DELIVERY_BOOKEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDELI_CAUSE(this.getDELI_CAUSE());
         
          newEnt.setDELI_YMD(this.getDELI_YMD());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setDELI_CLASS(this.getDELI_CLASS());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_DELIVERY_BOOKHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getDELI_CAUSE();
        
             case 4 :
                 return  this.getDELI_YMD();
        
             case 5 :
                 return  this.getREMARK();
        
             case 6 :
                 return  this.getWRT_ID();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getDELI_CLASS();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_DELIVERY_BOOKHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setDELI_CAUSE((String)value);
	            return;  
        
             case 4 :
                    this.setDELI_YMD((String)value);
	            return;  
        
             case 5 :
                    this.setREMARK((String)value);
	            return;  
        
             case 6 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 7 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 8 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 9 :
                    this.setDELI_CLASS((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_DELIVERY_BOOKHelper.toXML(this);
  }
  
}
