

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_DEFICIT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               SEQ:CHAR(18):  
*               DEFI_CODE:CHAR(18):  
*               DEFI_OUT:CHAR(18):  
*               INS_DT:CHAR(18):  
*               UPD_DT:CHAR(18):  
*               WRT_ID:CHAR(18):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_S_DEFICITEntity extends ValueObject{

  
     private String WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String SEQ;
  
     private String DEFI_CODE;
  
     private String DEFI_OUT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  

//생성자를 만든다
    public PT_S_DEFICITEntity(){
    }
    
    
    public PT_S_DEFICITEntity(String SEQ,String TMP_WRT_NUM,String WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_S_DEFICITEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
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
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.SEQ =request.getParameter("SEQ");
		this.DEFI_CODE =request.getParameter("DEFI_CODE");
		this.DEFI_OUT =request.getParameter("DEFI_OUT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.DEFI_CODE =KJFMi.dsGet(ds, arg_row, "DEFI_CODE");
		this.DEFI_OUT =KJFMi.dsGet(ds, arg_row, "DEFI_OUT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
				
    }    
    
//Getter 함수를 만든다
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getDEFI_CODE(){
             return DEFI_CODE;
     };
  
     public String getDEFI_OUT(){
             return DEFI_OUT;
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
  

//Setter 함수를 만든다
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setDEFI_CODE(String DEFI_CODE){
            this.DEFI_CODE=DEFI_CODE;
     };
  
     public void setDEFI_OUT(String DEFI_OUT){
            this.DEFI_OUT=DEFI_OUT;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("DEFI_CODE:"+ this.getDEFI_CODE()+"\n");
      
      strB.append("DEFI_OUT:"+ this.getDEFI_OUT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_S_DEFICITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_S_DEFICITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_S_DEFICITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_S_DEFICITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_S_DEFICITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       values[2]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_S_DEFICITEntity();
  }

  public ValueObject getClone(){
         PT_S_DEFICITEntity newEnt = new PT_S_DEFICITEntity();
	 
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setDEFI_CODE(this.getDEFI_CODE());
         
          newEnt.setDEFI_OUT(this.getDEFI_OUT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_S_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWRT_NUM();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getSEQ();
        
             case 4 :
                 return  this.getDEFI_CODE();
        
             case 5 :
                 return  this.getDEFI_OUT();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getWRT_ID();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_S_DEFICITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setSEQ((String)value);
	            return;  
        
             case 4 :
                    this.setDEFI_CODE((String)value);
	            return;  
        
             case 5 :
                    this.setDEFI_OUT((String)value);
	            return;  
        
             case 6 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 7 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_ID((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_S_DEFICITHelper.toXML(this);
  }
  
}
