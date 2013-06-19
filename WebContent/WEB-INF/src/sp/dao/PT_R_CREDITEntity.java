

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_CREDIT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               LICTAX_PAYAOM:VARCHAR2(12):  
*               LICTAX_PAY_CO_DT:VARCHAR2(8):  
*               HOS_CRE_AOM:VARCHAR2(12):  
*               HOS_CRE_PAY_CO_DT:VARCHAR2(8):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_CREDITEntity extends ValueObject{

  
     private String SEQ;
  
     private String TMP_WRT_NUM;
  
     private String LICTAX_PAYAOM;
  
     private String LICTAX_PAY_CO_DT;
  
     private String HOS_CRE_AOM;
  
     private String HOS_CRE_PAY_CO_DT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String WRT_DT;
  

//생성자를 만든다
    public PT_R_CREDITEntity(){
    }
    
    
    public PT_R_CREDITEntity(String SEQ,String TMP_WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_CREDITEntity(ValueObject ent) throws Exception{
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
		this.LICTAX_PAYAOM =request.getParameter("LICTAX_PAYAOM");
		this.LICTAX_PAY_CO_DT =request.getParameter("LICTAX_PAY_CO_DT");
		this.HOS_CRE_AOM =request.getParameter("HOS_CRE_AOM");
		this.HOS_CRE_PAY_CO_DT =request.getParameter("HOS_CRE_PAY_CO_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_DT =request.getParameter("WRT_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.LICTAX_PAYAOM =KJFMi.dsGet(ds, arg_row, "LICTAX_PAYAOM");
		this.LICTAX_PAY_CO_DT =KJFMi.dsGet(ds, arg_row, "LICTAX_PAY_CO_DT");
		this.HOS_CRE_AOM =KJFMi.dsGet(ds, arg_row, "HOS_CRE_AOM");
		this.HOS_CRE_PAY_CO_DT =KJFMi.dsGet(ds, arg_row, "HOS_CRE_PAY_CO_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getLICTAX_PAYAOM(){
             return LICTAX_PAYAOM;
     };
  
     public String getLICTAX_PAY_CO_DT(){
             return LICTAX_PAY_CO_DT;
     };
  
     public String getHOS_CRE_AOM(){
             return HOS_CRE_AOM;
     };
  
     public String getHOS_CRE_PAY_CO_DT(){
             return HOS_CRE_PAY_CO_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setLICTAX_PAYAOM(String LICTAX_PAYAOM){
            this.LICTAX_PAYAOM=LICTAX_PAYAOM;
     };
  
     public void setLICTAX_PAY_CO_DT(String LICTAX_PAY_CO_DT){
            this.LICTAX_PAY_CO_DT=LICTAX_PAY_CO_DT;
     };
  
     public void setHOS_CRE_AOM(String HOS_CRE_AOM){
            this.HOS_CRE_AOM=HOS_CRE_AOM;
     };
  
     public void setHOS_CRE_PAY_CO_DT(String HOS_CRE_PAY_CO_DT){
            this.HOS_CRE_PAY_CO_DT=HOS_CRE_PAY_CO_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("LICTAX_PAYAOM:"+ this.getLICTAX_PAYAOM()+"\n");
      
      strB.append("LICTAX_PAY_CO_DT:"+ this.getLICTAX_PAY_CO_DT()+"\n");
      
      strB.append("HOS_CRE_AOM:"+ this.getHOS_CRE_AOM()+"\n");
      
      strB.append("HOS_CRE_PAY_CO_DT:"+ this.getHOS_CRE_PAY_CO_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_CREDITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_CREDITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_CREDITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_CREDITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_CREDITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_CREDITEntity();
  }

  public ValueObject getClone(){
         PT_R_CREDITEntity newEnt = new PT_R_CREDITEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setLICTAX_PAYAOM(this.getLICTAX_PAYAOM());
         
          newEnt.setLICTAX_PAY_CO_DT(this.getLICTAX_PAY_CO_DT());
         
          newEnt.setHOS_CRE_AOM(this.getHOS_CRE_AOM());
         
          newEnt.setHOS_CRE_PAY_CO_DT(this.getHOS_CRE_PAY_CO_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_CREDITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getLICTAX_PAYAOM();
        
             case 4 :
                 return  this.getLICTAX_PAY_CO_DT();
        
             case 5 :
                 return  this.getHOS_CRE_AOM();
        
             case 6 :
                 return  this.getHOS_CRE_PAY_CO_DT();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getWRT_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_CREDITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setLICTAX_PAYAOM((String)value);
	            return;  
        
             case 4 :
                    this.setLICTAX_PAY_CO_DT((String)value);
	            return;  
        
             case 5 :
                    this.setHOS_CRE_AOM((String)value);
	            return;  
        
             case 6 :
                    this.setHOS_CRE_PAY_CO_DT((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_CREDITHelper.toXML(this);
  }
  
}
