

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_CHANGE_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_TIME:VARCHAR2(4):  
*               PROC_LIM:VARCHAR2(8):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               COV_DT:VARCHAR2(8):  
*               COM_NUM:VARCHAR2(13):  
*               DEFI_STE:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_CHANGE_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String RECV_DT;
  
     private String RECV_TIME;
  
     private String PROC_LIM;
  
     private String TMP_WRT_NUM;
  
     private String COV_DT;
  
     private String COM_NUM;
  
     private String DEFI_STE;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  

//생성자를 만든다
    public PT_R_CHANGE_STATEMENTEntity(){
    }
    
    
    public PT_R_CHANGE_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_CHANGE_STATEMENTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.RECV_DT =request.getParameter("RECV_DT");
		this.RECV_TIME =request.getParameter("RECV_TIME");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.COV_DT =request.getParameter("COV_DT");
		this.COM_NUM =request.getParameter("COM_NUM");
		this.DEFI_STE =request.getParameter("DEFI_STE");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.RECV_TIME =KJFMi.dsGet(ds, arg_row, "RECV_TIME");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.COV_DT =KJFMi.dsGet(ds, arg_row, "COV_DT");
		this.COM_NUM =KJFMi.dsGet(ds, arg_row, "COM_NUM");
		this.DEFI_STE =KJFMi.dsGet(ds, arg_row, "DEFI_STE");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getRECV_DT(){
             return RECV_DT;
     };
  
     public String getRECV_TIME(){
             return RECV_TIME;
     };
  
     public String getPROC_LIM(){
             return PROC_LIM;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getCOV_DT(){
             return COV_DT;
     };
  
     public String getCOM_NUM(){
             return COM_NUM;
     };
  
     public String getDEFI_STE(){
             return DEFI_STE;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setRECV_DT(String RECV_DT){
            this.RECV_DT=RECV_DT;
     };
  
     public void setRECV_TIME(String RECV_TIME){
            this.RECV_TIME=RECV_TIME;
     };
  
     public void setPROC_LIM(String PROC_LIM){
            this.PROC_LIM=PROC_LIM;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setCOV_DT(String COV_DT){
            this.COV_DT=COV_DT;
     };
  
     public void setCOM_NUM(String COM_NUM){
            this.COM_NUM=COM_NUM;
     };
  
     public void setDEFI_STE(String DEFI_STE){
            this.DEFI_STE=DEFI_STE;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("RECV_TIME:"+ this.getRECV_TIME()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("COV_DT:"+ this.getCOV_DT()+"\n");
      
      strB.append("COM_NUM:"+ this.getCOM_NUM()+"\n");
      
      strB.append("DEFI_STE:"+ this.getDEFI_STE()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_CHANGE_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_CHANGE_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_CHANGE_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_CHANGE_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_CHANGE_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_CHANGE_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_CHANGE_STATEMENTEntity newEnt = new PT_R_CHANGE_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setRECV_TIME(this.getRECV_TIME());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setCOV_DT(this.getCOV_DT());
         
          newEnt.setCOM_NUM(this.getCOM_NUM());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_CHANGE_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSIDO_CODE();
        
             case 3 :
                 return  this.getRECV_DT();
        
             case 4 :
                 return  this.getRECV_TIME();
        
             case 5 :
                 return  this.getPROC_LIM();
        
             case 6 :
                 return  this.getTMP_WRT_NUM();
        
             case 7 :
                 return  this.getCOV_DT();
        
             case 8 :
                 return  this.getCOM_NUM();
        
             case 9 :
                 return  this.getDEFI_STE();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getINS_DT();
        
             case 12 :
                 return  this.getUPD_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_CHANGE_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 4 :
                    this.setRECV_TIME((String)value);
	            return;  
        
             case 5 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 6 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 7 :
                    this.setCOV_DT((String)value);
	            return;  
        
             case 8 :
                    this.setCOM_NUM((String)value);
	            return;  
        
             case 9 :
                    this.setDEFI_STE((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 11 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 12 :
                    this.setUPD_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_CHANGE_STATEMENTHelper.toXML(this);
  }
  
}
