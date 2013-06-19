

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_HMS_HISTORY
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               MENU_ID:VARCHAR2(32):  
*               VERSION:VARCHAR2(32):  
*               CONTENT:CLOB:  
*               USE_YN:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               WRT_NM:VARCHAR2(32):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_HMS_HISTORYEntity extends ValueObject{

  
     private String SEQ;
  
     private String MENU_ID;
  
     private String VERSION;
  
     private String CONTENT;
  
     private String USE_YN;
  
     private String WRT_ID;
  
     private String WRT_NM;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_HMS_HISTORYEntity(){
    }
    
    
    public PT_HMS_HISTORYEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_HMS_HISTORYEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.MENU_ID =request.getParameter("MENU_ID");
		this.VERSION =request.getParameter("VERSION");
		this.CONTENT =request.getParameter("CONTENT");
		this.USE_YN =request.getParameter("USE_YN");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.WRT_NM =request.getParameter("WRT_NM");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.MENU_ID =KJFMi.dsGet(ds, arg_row, "MENU_ID");
		this.VERSION =KJFMi.dsGet(ds, arg_row, "VERSION");
		this.CONTENT =KJFMi.dsGet(ds, arg_row, "CONTENT");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.WRT_NM =KJFMi.dsGet(ds, arg_row, "WRT_NM");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getMENU_ID(){
             return MENU_ID;
     };
  
     public String getVERSION(){
             return VERSION;
     };
  
     public String getCONTENT(){
             return CONTENT;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getWRT_NM(){
             return WRT_NM;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setMENU_ID(String MENU_ID){
            this.MENU_ID=MENU_ID;
     };
  
     public void setVERSION(String VERSION){
            this.VERSION=VERSION;
     };
  
     public void setCONTENT(String CONTENT){
            this.CONTENT=CONTENT;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setWRT_NM(String WRT_NM){
            this.WRT_NM=WRT_NM;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("MENU_ID:"+ this.getMENU_ID()+"\n");
      
      strB.append("VERSION:"+ this.getVERSION()+"\n");
      
      strB.append("CONTENT:"+ this.getCONTENT()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("WRT_NM:"+ this.getWRT_NM()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_HMS_HISTORYHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_HMS_HISTORYHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_HMS_HISTORYHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_HMS_HISTORYHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_HMS_HISTORYHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_HMS_HISTORYEntity();
  }

  public ValueObject getClone(){
         PT_HMS_HISTORYEntity newEnt = new PT_HMS_HISTORYEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setMENU_ID(this.getMENU_ID());
         
          newEnt.setVERSION(this.getVERSION());
         
          newEnt.setCONTENT(this.getCONTENT());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setWRT_NM(this.getWRT_NM());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_HMS_HISTORYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getMENU_ID();
        
             case 3 :
                 return  this.getVERSION();
        
             case 4 :
                 return  this.getCONTENT();
        
             case 5 :
                 return  this.getUSE_YN();
        
             case 6 :
                 return  this.getWRT_ID();
        
             case 7 :
                 return  this.getWRT_NM();
        
             case 8 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_HMS_HISTORYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setMENU_ID((String)value);
	            return;  
        
             case 3 :
                    this.setVERSION((String)value);
	            return;  
        
             case 4 :
                    this.setCONTENT((String)value);
	            return;  
        
             case 5 :
                    this.setUSE_YN((String)value);
	            return;  
        
             case 6 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_NM((String)value);
	            return;  
        
             case 8 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_HMS_HISTORYHelper.toXML(this);
  }
  
}
