

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :P_S_MASTER
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_DT:VARCHAR2(8):  
*               INV_EXPC_DT:VARCHAR2(8):  
*               INV_DT:VARCHAR2(8):  
*               PROC_STE:VARCHAR2(6):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               MOT_STE:VARCHAR2(6):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class P_S_MASTEREntity extends ValueObject{

  
     private String WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String WRT_DT;
  
     private String INV_EXPC_DT;
  
     private String INV_DT;
  
     private String PROC_STE;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String MOT_STE;
  

//생성자를 만든다
    public P_S_MASTEREntity(){
    }
    
    
    public P_S_MASTEREntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public P_S_MASTEREntity(ValueObject ent) throws Exception{
       Object value = null; 
       
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
		this.WRT_DT =request.getParameter("WRT_DT");
		this.INV_EXPC_DT =request.getParameter("INV_EXPC_DT");
		this.INV_DT =request.getParameter("INV_DT");
		this.PROC_STE =request.getParameter("PROC_STE");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.MOT_STE =request.getParameter("MOT_STE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.INV_EXPC_DT =KJFMi.dsGet(ds, arg_row, "INV_EXPC_DT");
		this.INV_DT =KJFMi.dsGet(ds, arg_row, "INV_DT");
		this.PROC_STE =KJFMi.dsGet(ds, arg_row, "PROC_STE");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  
     public String getINV_EXPC_DT(){
             return INV_EXPC_DT;
     };
  
     public String getINV_DT(){
             return INV_DT;
     };
  
     public String getPROC_STE(){
             return PROC_STE;
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
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  

//Setter 함수를 만든다
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
     public void setINV_EXPC_DT(String INV_EXPC_DT){
            this.INV_EXPC_DT=INV_EXPC_DT;
     };
  
     public void setINV_DT(String INV_DT){
            this.INV_DT=INV_DT;
     };
  
     public void setPROC_STE(String PROC_STE){
            this.PROC_STE=PROC_STE;
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
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("INV_EXPC_DT:"+ this.getINV_EXPC_DT()+"\n");
      
      strB.append("INV_DT:"+ this.getINV_DT()+"\n");
      
      strB.append("PROC_STE:"+ this.getPROC_STE()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return P_S_MASTERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return P_S_MASTERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return P_S_MASTERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return P_S_MASTERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return P_S_MASTERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new P_S_MASTEREntity();
  }

  public ValueObject getClone(){
         P_S_MASTEREntity newEnt = new P_S_MASTEREntity();
	 
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setINV_EXPC_DT(this.getINV_EXPC_DT());
         
          newEnt.setINV_DT(this.getINV_DT());
         
          newEnt.setPROC_STE(this.getPROC_STE());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)P_S_MASTERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWRT_NUM();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getWRT_DT();
        
             case 4 :
                 return  this.getINV_EXPC_DT();
        
             case 5 :
                 return  this.getINV_DT();
        
             case 6 :
                 return  this.getPROC_STE();
        
             case 7 :
                 return  this.getINS_DT();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getWRT_ID();
        
             case 10 :
                 return  this.getMOT_STE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)P_S_MASTERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 4 :
                    this.setINV_EXPC_DT((String)value);
	            return;  
        
             case 5 :
                    this.setINV_DT((String)value);
	            return;  
        
             case 6 :
                    this.setPROC_STE((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 10 :
                    this.setMOT_STE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return P_S_MASTERHelper.toXML(this);
  }
  
}
