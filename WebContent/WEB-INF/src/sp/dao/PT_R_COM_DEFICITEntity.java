

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_COM_DEFICIT
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               DEFI_CODE:VARCHAR2(6):  
*               DEFI_OUT:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               CHGBRE_SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DEFI_GROUP:VARCHAR2(6):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_COM_DEFICITEntity extends ValueObject{

  
     private String SEQ;
  
     private String DEFI_CODE;
  
     private String DEFI_OUT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  
     private String DEFI_GROUP;
  

//생성자를 만든다
    public PT_R_COM_DEFICITEntity(){
    }
    
    
    public PT_R_COM_DEFICITEntity(String CHGBRE_SEQ,String SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_COM_DEFICITEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CHGBRE_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CHGBRE_SEQ",value);
       
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
		this.DEFI_CODE =request.getParameter("DEFI_CODE");
		this.DEFI_OUT =request.getParameter("DEFI_OUT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.CHGBRE_SEQ =request.getParameter("CHGBRE_SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.DEFI_GROUP =request.getParameter("DEFI_GROUP");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.DEFI_CODE =KJFMi.dsGet(ds, arg_row, "DEFI_CODE");
		this.DEFI_OUT =KJFMi.dsGet(ds, arg_row, "DEFI_OUT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DEFI_GROUP =KJFMi.dsGet(ds, arg_row, "DEFI_GROUP");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getDEFI_CODE(){
             return DEFI_CODE;
     };
  
     public String getDEFI_OUT(){
             return DEFI_OUT;
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
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getDEFI_GROUP(){
             return DEFI_GROUP;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setDEFI_CODE(String DEFI_CODE){
            this.DEFI_CODE=DEFI_CODE;
     };
  
     public void setDEFI_OUT(String DEFI_OUT){
            this.DEFI_OUT=DEFI_OUT;
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
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setDEFI_GROUP(String DEFI_GROUP){
            this.DEFI_GROUP=DEFI_GROUP;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("DEFI_CODE:"+ this.getDEFI_CODE()+"\n");
      
      strB.append("DEFI_OUT:"+ this.getDEFI_OUT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("DEFI_GROUP:"+ this.getDEFI_GROUP()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_COM_DEFICITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_COM_DEFICITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_COM_DEFICITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_COM_DEFICITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_COM_DEFICITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getSEQ();
       values[2]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_COM_DEFICITEntity();
  }

  public ValueObject getClone(){
         PT_R_COM_DEFICITEntity newEnt = new PT_R_COM_DEFICITEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setDEFI_CODE(this.getDEFI_CODE());
         
          newEnt.setDEFI_OUT(this.getDEFI_OUT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDEFI_GROUP(this.getDEFI_GROUP());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_COM_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getDEFI_CODE();
        
             case 3 :
                 return  this.getDEFI_OUT();
        
             case 4 :
                 return  this.getWRT_ID();
        
             case 5 :
                 return  this.getUPD_DT();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getCHGBRE_SEQ();
        
             case 8 :
                 return  this.getTMP_WRT_NUM();
        
             case 9 :
                 return  this.getDEFI_GROUP();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_COM_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setDEFI_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setDEFI_OUT((String)value);
	            return;  
        
             case 4 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 5 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 6 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 7 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 8 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 9 :
                    this.setDEFI_GROUP((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_COM_DEFICITHelper.toXML(this);
  }
  
}
