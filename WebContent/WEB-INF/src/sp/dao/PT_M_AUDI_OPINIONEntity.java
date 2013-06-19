

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_AUDI_OPINION
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               DISPO_CONT:VARCHAR2(1024):  
*               CHEF_OPIN:VARCHAR2(1024):  
*               ETC:VARCHAR2(1024):  
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

public class PT_M_AUDI_OPINIONEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String DISPO_CONT;
  
     private String CHEF_OPIN;
  
     private String ETC;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  

//생성자를 만든다
    public PT_M_AUDI_OPINIONEntity(){
    }
    
    
    public PT_M_AUDI_OPINIONEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_AUDI_OPINIONEntity(ValueObject ent) throws Exception{
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
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.DISPO_CONT =request.getParameter("DISPO_CONT");
		this.CHEF_OPIN =request.getParameter("CHEF_OPIN");
		this.ETC =request.getParameter("ETC");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.DISPO_CONT =KJFMi.dsGet(ds, arg_row, "DISPO_CONT");
		this.CHEF_OPIN =KJFMi.dsGet(ds, arg_row, "CHEF_OPIN");
		this.ETC =KJFMi.dsGet(ds, arg_row, "ETC");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getDISPO_CONT(){
             return DISPO_CONT;
     };
  
     public String getCHEF_OPIN(){
             return CHEF_OPIN;
     };
  
     public String getETC(){
             return ETC;
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
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setDISPO_CONT(String DISPO_CONT){
            this.DISPO_CONT=DISPO_CONT;
     };
  
     public void setCHEF_OPIN(String CHEF_OPIN){
            this.CHEF_OPIN=CHEF_OPIN;
     };
  
     public void setETC(String ETC){
            this.ETC=ETC;
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
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("DISPO_CONT:"+ this.getDISPO_CONT()+"\n");
      
      strB.append("CHEF_OPIN:"+ this.getCHEF_OPIN()+"\n");
      
      strB.append("ETC:"+ this.getETC()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_AUDI_OPINIONHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_AUDI_OPINIONHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_AUDI_OPINIONHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_AUDI_OPINIONHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_AUDI_OPINIONHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_AUDI_OPINIONEntity();
  }

  public ValueObject getClone(){
         PT_M_AUDI_OPINIONEntity newEnt = new PT_M_AUDI_OPINIONEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setDISPO_CONT(this.getDISPO_CONT());
         
          newEnt.setCHEF_OPIN(this.getCHEF_OPIN());
         
          newEnt.setETC(this.getETC());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_AUDI_OPINIONHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getDISPO_CONT();
        
             case 4 :
                 return  this.getCHEF_OPIN();
        
             case 5 :
                 return  this.getETC();
        
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
         Integer idx = (Integer)PT_M_AUDI_OPINIONHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setDISPO_CONT((String)value);
	            return;  
        
             case 4 :
                    this.setCHEF_OPIN((String)value);
	            return;  
        
             case 5 :
                    this.setETC((String)value);
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
         return PT_M_AUDI_OPINIONHelper.toXML(this);
  }
  
}
