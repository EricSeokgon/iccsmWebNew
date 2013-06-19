

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_PROSECUTION
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               PRSEC_DT:VARCHAR2(8):  
*               PRSEC_CONT:VARCHAR2(1024):  
*               PRSEC_PERSON_ID:VARCHAR2(16):  
*               PRSEC_PART:VARCHAR2(100):  
*               PRSEC_PART_TELNUM:VARCHAR2(17):  
*               PRSEC_PART_OFFI:VARCHAR2(20):  
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

public class PT_M_PROSECUTIONEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String PRSEC_DT;
  
     private String PRSEC_CONT;
  
     private String PRSEC_PERSON_ID;
  
     private String PRSEC_PART;
  
     private String PRSEC_PART_TELNUM;
  
     private String PRSEC_PART_OFFI;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  

//생성자를 만든다
    public PT_M_PROSECUTIONEntity(){
    }
    
    
    public PT_M_PROSECUTIONEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_PROSECUTIONEntity(ValueObject ent) throws Exception{
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
		this.PRSEC_DT =request.getParameter("PRSEC_DT");
		this.PRSEC_CONT =request.getParameter("PRSEC_CONT");
		this.PRSEC_PERSON_ID =request.getParameter("PRSEC_PERSON_ID");
		this.PRSEC_PART =request.getParameter("PRSEC_PART");
		this.PRSEC_PART_TELNUM =request.getParameter("PRSEC_PART_TELNUM");
		this.PRSEC_PART_OFFI =request.getParameter("PRSEC_PART_OFFI");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.PRSEC_DT =KJFMi.dsGet(ds, arg_row, "PRSEC_DT");
		this.PRSEC_CONT =KJFMi.dsGet(ds, arg_row, "PRSEC_CONT");
		this.PRSEC_PERSON_ID =KJFMi.dsGet(ds, arg_row, "PRSEC_PERSON_ID");
		this.PRSEC_PART =KJFMi.dsGet(ds, arg_row, "PRSEC_PART");
		this.PRSEC_PART_TELNUM =KJFMi.dsGet(ds, arg_row, "PRSEC_PART_TELNUM");
		this.PRSEC_PART_OFFI =KJFMi.dsGet(ds, arg_row, "PRSEC_PART_OFFI");
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
  
     public String getPRSEC_DT(){
             return PRSEC_DT;
     };
  
     public String getPRSEC_CONT(){
             return PRSEC_CONT;
     };
  
     public String getPRSEC_PERSON_ID(){
             return PRSEC_PERSON_ID;
     };
  
     public String getPRSEC_PART(){
             return PRSEC_PART;
     };
  
     public String getPRSEC_PART_TELNUM(){
             return PRSEC_PART_TELNUM;
     };
  
     public String getPRSEC_PART_OFFI(){
             return PRSEC_PART_OFFI;
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
  
     public void setPRSEC_DT(String PRSEC_DT){
            this.PRSEC_DT=PRSEC_DT;
     };
  
     public void setPRSEC_CONT(String PRSEC_CONT){
            this.PRSEC_CONT=PRSEC_CONT;
     };
  
     public void setPRSEC_PERSON_ID(String PRSEC_PERSON_ID){
            this.PRSEC_PERSON_ID=PRSEC_PERSON_ID;
     };
  
     public void setPRSEC_PART(String PRSEC_PART){
            this.PRSEC_PART=PRSEC_PART;
     };
  
     public void setPRSEC_PART_TELNUM(String PRSEC_PART_TELNUM){
            this.PRSEC_PART_TELNUM=PRSEC_PART_TELNUM;
     };
  
     public void setPRSEC_PART_OFFI(String PRSEC_PART_OFFI){
            this.PRSEC_PART_OFFI=PRSEC_PART_OFFI;
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
      
      strB.append("PRSEC_DT:"+ this.getPRSEC_DT()+"\n");
      
      strB.append("PRSEC_CONT:"+ this.getPRSEC_CONT()+"\n");
      
      strB.append("PRSEC_PERSON_ID:"+ this.getPRSEC_PERSON_ID()+"\n");
      
      strB.append("PRSEC_PART:"+ this.getPRSEC_PART()+"\n");
      
      strB.append("PRSEC_PART_TELNUM:"+ this.getPRSEC_PART_TELNUM()+"\n");
      
      strB.append("PRSEC_PART_OFFI:"+ this.getPRSEC_PART_OFFI()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_PROSECUTIONHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_PROSECUTIONHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_PROSECUTIONHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_PROSECUTIONHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_PROSECUTIONHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_PROSECUTIONEntity();
  }

  public ValueObject getClone(){
         PT_M_PROSECUTIONEntity newEnt = new PT_M_PROSECUTIONEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setPRSEC_DT(this.getPRSEC_DT());
         
          newEnt.setPRSEC_CONT(this.getPRSEC_CONT());
         
          newEnt.setPRSEC_PERSON_ID(this.getPRSEC_PERSON_ID());
         
          newEnt.setPRSEC_PART(this.getPRSEC_PART());
         
          newEnt.setPRSEC_PART_TELNUM(this.getPRSEC_PART_TELNUM());
         
          newEnt.setPRSEC_PART_OFFI(this.getPRSEC_PART_OFFI());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_PROSECUTIONHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getPRSEC_DT();
        
             case 4 :
                 return  this.getPRSEC_CONT();
        
             case 5 :
                 return  this.getPRSEC_PERSON_ID();
        
             case 6 :
                 return  this.getPRSEC_PART();
        
             case 7 :
                 return  this.getPRSEC_PART_TELNUM();
        
             case 8 :
                 return  this.getPRSEC_PART_OFFI();
        
             case 9 :
                 return  this.getINS_DT();
        
             case 10 :
                 return  this.getUPD_DT();
        
             case 11 :
                 return  this.getWRT_ID();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_PROSECUTIONHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setPRSEC_DT((String)value);
	            return;  
        
             case 4 :
                    this.setPRSEC_CONT((String)value);
	            return;  
        
             case 5 :
                    this.setPRSEC_PERSON_ID((String)value);
	            return;  
        
             case 6 :
                    this.setPRSEC_PART((String)value);
	            return;  
        
             case 7 :
                    this.setPRSEC_PART_TELNUM((String)value);
	            return;  
        
             case 8 :
                    this.setPRSEC_PART_OFFI((String)value);
	            return;  
        
             case 9 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 10 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 11 :
                    this.setWRT_ID((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_PROSECUTIONHelper.toXML(this);
  }
  
}
