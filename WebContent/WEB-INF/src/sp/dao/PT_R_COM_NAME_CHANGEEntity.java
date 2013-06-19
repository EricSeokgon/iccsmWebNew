

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_COM_NAME_CHANGE
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:VARCHAR2(10):  
*               TMP_WRT_NUM:VARCHAR2(20):  
*               NAME_KOR:VARCHAR2(50):  
*               NAME_HAN:VARCHAR2(50):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(50):  
*               ETC2:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_COM_NAME_CHANGEEntity extends ValueObject{

  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  
     private String NAME_KOR;
  
     private String NAME_HAN;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String ETC1;
  
     private String ETC2;
  

//생성자를 만든다
    public PT_R_COM_NAME_CHANGEEntity(){
    }
    
    
    public PT_R_COM_NAME_CHANGEEntity(String CHGBRE_SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_COM_NAME_CHANGEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CHGBRE_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CHGBRE_SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CHGBRE_SEQ =request.getParameter("CHGBRE_SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.NAME_KOR =request.getParameter("NAME_KOR");
		this.NAME_HAN =request.getParameter("NAME_HAN");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.ETC1 =request.getParameter("ETC1");
		this.ETC2 =request.getParameter("ETC2");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.NAME_KOR =KJFMi.dsGet(ds, arg_row, "NAME_KOR");
		this.NAME_HAN =KJFMi.dsGet(ds, arg_row, "NAME_HAN");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.ETC1 =KJFMi.dsGet(ds, arg_row, "ETC1");
		this.ETC2 =KJFMi.dsGet(ds, arg_row, "ETC2");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getNAME_KOR(){
             return NAME_KOR;
     };
  
     public String getNAME_HAN(){
             return NAME_HAN;
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
  
     public String getETC1(){
             return ETC1;
     };
  
     public String getETC2(){
             return ETC2;
     };
  

//Setter 함수를 만든다
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setNAME_KOR(String NAME_KOR){
            this.NAME_KOR=NAME_KOR;
     };
  
     public void setNAME_HAN(String NAME_HAN){
            this.NAME_HAN=NAME_HAN;
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
  
     public void setETC1(String ETC1){
            this.ETC1=ETC1;
     };
  
     public void setETC2(String ETC2){
            this.ETC2=ETC2;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("NAME_KOR:"+ this.getNAME_KOR()+"\n");
      
      strB.append("NAME_HAN:"+ this.getNAME_HAN()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("ETC1:"+ this.getETC1()+"\n");
      
      strB.append("ETC2:"+ this.getETC2()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_COM_NAME_CHANGEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_COM_NAME_CHANGEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_COM_NAME_CHANGEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_COM_NAME_CHANGEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_COM_NAME_CHANGEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_COM_NAME_CHANGEEntity();
  }

  public ValueObject getClone(){
         PT_R_COM_NAME_CHANGEEntity newEnt = new PT_R_COM_NAME_CHANGEEntity();
	 
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setNAME_KOR(this.getNAME_KOR());
         
          newEnt.setNAME_HAN(this.getNAME_HAN());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setETC1(this.getETC1());
         
          newEnt.setETC2(this.getETC2());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_COM_NAME_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCHGBRE_SEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getNAME_KOR();
        
             case 4 :
                 return  this.getNAME_HAN();
        
             case 5 :
                 return  this.getWRT_ID();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getINS_DT();
        
             case 8 :
                 return  this.getETC1();
        
             case 9 :
                 return  this.getETC2();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_COM_NAME_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setNAME_KOR((String)value);
	            return;  
        
             case 4 :
                    this.setNAME_HAN((String)value);
	            return;  
        
             case 5 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 8 :
                    this.setETC1((String)value);
	            return;  
        
             case 9 :
                    this.setETC2((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_COM_NAME_CHANGEHelper.toXML(this);
  }
  
}
