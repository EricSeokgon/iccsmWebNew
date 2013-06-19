

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_CONFIRM
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               VIOL_DT:VARCHAR2(8):  
*               VIOL_ITEM:VARCHAR2(512):  
*               VIOL_CONT:VARCHAR2(2048):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_S_CONFIRMEntity extends ValueObject{

  
     private String WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String VIOL_DT;
  
     private String VIOL_ITEM;
  
     private String VIOL_CONT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  

//생성자를 만든다
    public PT_S_CONFIRMEntity(){
    }
    
    
    public PT_S_CONFIRMEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_S_CONFIRMEntity(ValueObject ent) throws Exception{
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
		this.VIOL_DT =request.getParameter("VIOL_DT");
		this.VIOL_ITEM =request.getParameter("VIOL_ITEM");
		this.VIOL_CONT =request.getParameter("VIOL_CONT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.VIOL_DT =KJFMi.dsGet(ds, arg_row, "VIOL_DT");
		this.VIOL_ITEM =KJFMi.dsGet(ds, arg_row, "VIOL_ITEM");
		this.VIOL_CONT =KJFMi.dsGet(ds, arg_row, "VIOL_CONT");
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
  
     public String getVIOL_DT(){
             return VIOL_DT;
     };
  
     public String getVIOL_ITEM(){
             return VIOL_ITEM;
     };
  
     public String getVIOL_CONT(){
             return VIOL_CONT;
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
  
     public void setVIOL_DT(String VIOL_DT){
            this.VIOL_DT=VIOL_DT;
     };
  
     public void setVIOL_ITEM(String VIOL_ITEM){
            this.VIOL_ITEM=VIOL_ITEM;
     };
  
     public void setVIOL_CONT(String VIOL_CONT){
            this.VIOL_CONT=VIOL_CONT;
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
      
      strB.append("VIOL_DT:"+ this.getVIOL_DT()+"\n");
      
      strB.append("VIOL_ITEM:"+ this.getVIOL_ITEM()+"\n");
      
      strB.append("VIOL_CONT:"+ this.getVIOL_CONT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_S_CONFIRMHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_S_CONFIRMHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_S_CONFIRMHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_S_CONFIRMHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_S_CONFIRMHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_S_CONFIRMEntity();
  }

  public ValueObject getClone(){
         PT_S_CONFIRMEntity newEnt = new PT_S_CONFIRMEntity();
	 
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setVIOL_DT(this.getVIOL_DT());
         
          newEnt.setVIOL_ITEM(this.getVIOL_ITEM());
         
          newEnt.setVIOL_CONT(this.getVIOL_CONT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_S_CONFIRMHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWRT_NUM();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getVIOL_DT();
        
             case 4 :
                 return  this.getVIOL_ITEM();
        
             case 5 :
                 return  this.getVIOL_CONT();
        
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
         Integer idx = (Integer)PT_S_CONFIRMHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setVIOL_DT((String)value);
	            return;  
        
             case 4 :
                    this.setVIOL_ITEM((String)value);
	            return;  
        
             case 5 :
                    this.setVIOL_CONT((String)value);
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
         return PT_S_CONFIRMHelper.toXML(this);
  }
  
}
