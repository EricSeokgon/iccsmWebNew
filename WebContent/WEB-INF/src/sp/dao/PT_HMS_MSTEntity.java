

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_HMS_MST
*  테이블 설명 :
*  테이블 PK   :  
*               MENU_ID
*  테이블 컬럼 :  
*               MENU_ID:VARCHAR2(32):  
*               L_MENU_CD:VARCHAR2(64):  
*               M_MENU_CD:VARCHAR2(64):  
*               S_MENU_CD:VARCHAR2(64):  
*               TITLE:VARCHAR2(32):  
*               URL:VARCHAR2(64):  
*               WRT_ID:VARCHAR2(16):  
*               WRT_NM:VARCHAR2(16):  
*               UDP_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_HMS_MSTEntity extends ValueObject{

  
     private String MENU_ID;
  
     private String L_MENU_CD;
  
     private String M_MENU_CD;
  
     private String S_MENU_CD;
  
     private String TITLE;
  
     private String URL;
  
     private String WRT_ID;
  
     private String WRT_NM;
  
     private String UDP_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_HMS_MSTEntity(){
    }
    
    
    public PT_HMS_MSTEntity(String MENU_ID ){
       this.setMENU_ID(MENU_ID);
       
    }
      
    public PT_HMS_MSTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("MENU_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("MENU_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.MENU_ID =request.getParameter("MENU_ID");
		this.L_MENU_CD =request.getParameter("L_MENU_CD");
		this.M_MENU_CD =request.getParameter("M_MENU_CD");
		this.S_MENU_CD =request.getParameter("S_MENU_CD");
		this.TITLE =request.getParameter("TITLE");
		this.URL =request.getParameter("URL");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.WRT_NM =request.getParameter("WRT_NM");
		this.UDP_DT =request.getParameter("UDP_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.MENU_ID =KJFMi.dsGet(ds, arg_row, "MENU_ID");
		this.L_MENU_CD =KJFMi.dsGet(ds, arg_row, "L_MENU_CD");
		this.M_MENU_CD =KJFMi.dsGet(ds, arg_row, "M_MENU_CD");
		this.S_MENU_CD =KJFMi.dsGet(ds, arg_row, "S_MENU_CD");
		this.TITLE =KJFMi.dsGet(ds, arg_row, "TITLE");
		this.URL =KJFMi.dsGet(ds, arg_row, "URL");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.WRT_NM =KJFMi.dsGet(ds, arg_row, "WRT_NM");
		this.UDP_DT =KJFMi.dsGet(ds, arg_row, "UDP_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getMENU_ID(){
             return MENU_ID;
     };
  
     public String getL_MENU_CD(){
             return L_MENU_CD;
     };
  
     public String getM_MENU_CD(){
             return M_MENU_CD;
     };
  
     public String getS_MENU_CD(){
             return S_MENU_CD;
     };
  
     public String getTITLE(){
             return TITLE;
     };
  
     public String getURL(){
             return URL;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getWRT_NM(){
             return WRT_NM;
     };
  
     public String getUDP_DT(){
             return UDP_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  

//Setter 함수를 만든다
  
     public void setMENU_ID(String MENU_ID){
            this.MENU_ID=MENU_ID;
     };
  
     public void setL_MENU_CD(String L_MENU_CD){
            this.L_MENU_CD=L_MENU_CD;
     };
  
     public void setM_MENU_CD(String M_MENU_CD){
            this.M_MENU_CD=M_MENU_CD;
     };
  
     public void setS_MENU_CD(String S_MENU_CD){
            this.S_MENU_CD=S_MENU_CD;
     };
  
     public void setTITLE(String TITLE){
            this.TITLE=TITLE;
     };
  
     public void setURL(String URL){
            this.URL=URL;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setWRT_NM(String WRT_NM){
            this.WRT_NM=WRT_NM;
     };
  
     public void setUDP_DT(String UDP_DT){
            this.UDP_DT=UDP_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("MENU_ID:"+ this.getMENU_ID()+"\n");
      
      strB.append("L_MENU_CD:"+ this.getL_MENU_CD()+"\n");
      
      strB.append("M_MENU_CD:"+ this.getM_MENU_CD()+"\n");
      
      strB.append("S_MENU_CD:"+ this.getS_MENU_CD()+"\n");
      
      strB.append("TITLE:"+ this.getTITLE()+"\n");
      
      strB.append("URL:"+ this.getURL()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("WRT_NM:"+ this.getWRT_NM()+"\n");
      
      strB.append("UDP_DT:"+ this.getUDP_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_HMS_MSTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_HMS_MSTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_HMS_MSTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_HMS_MSTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_HMS_MSTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getMENU_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_HMS_MSTEntity();
  }

  public ValueObject getClone(){
         PT_HMS_MSTEntity newEnt = new PT_HMS_MSTEntity();
	 
          newEnt.setMENU_ID(this.getMENU_ID());
         
          newEnt.setL_MENU_CD(this.getL_MENU_CD());
         
          newEnt.setM_MENU_CD(this.getM_MENU_CD());
         
          newEnt.setS_MENU_CD(this.getS_MENU_CD());
         
          newEnt.setTITLE(this.getTITLE());
         
          newEnt.setURL(this.getURL());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setWRT_NM(this.getWRT_NM());
         
          newEnt.setUDP_DT(this.getUDP_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_HMS_MSTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getMENU_ID();
        
             case 2 :
                 return  this.getL_MENU_CD();
        
             case 3 :
                 return  this.getM_MENU_CD();
        
             case 4 :
                 return  this.getS_MENU_CD();
        
             case 5 :
                 return  this.getTITLE();
        
             case 6 :
                 return  this.getURL();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getWRT_NM();
        
             case 9 :
                 return  this.getUDP_DT();
        
             case 10 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_HMS_MSTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setMENU_ID((String)value);
	            return;  
        
             case 2 :
                    this.setL_MENU_CD((String)value);
	            return;  
        
             case 3 :
                    this.setM_MENU_CD((String)value);
	            return;  
        
             case 4 :
                    this.setS_MENU_CD((String)value);
	            return;  
        
             case 5 :
                    this.setTITLE((String)value);
	            return;  
        
             case 6 :
                    this.setURL((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_NM((String)value);
	            return;  
        
             case 9 :
                    this.setUDP_DT((String)value);
	            return;  
        
             case 10 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_HMS_MSTHelper.toXML(this);
  }
  
}
