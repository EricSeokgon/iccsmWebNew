

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ADDRESS_CHANGE
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:VARCHAR2(10):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(3):  
*               POST_NUM:VARCHAR2(6):  
*               ADDR:VARCHAR2(100):  
*               DETAIL_ADDR:VARCHAR2(100):  
*               OFFICE_AREA:VARCHAR2(10):  
*               TEL_NUM:VARCHAR2(20):  
*               FAX_NUM:VARCHAR2(20):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(30):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_ADDRESS_CHANGEEntity extends ValueObject{

  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  
     private String SIDO_CODE;
  
     private String POST_NUM;
  
     private String ADDR;
  
     private String DETAIL_ADDR;
  
     private String OFFICE_AREA;
  
     private String TEL_NUM;
  
     private String FAX_NUM;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String ETC1;
  

//생성자를 만든다
    public PT_R_ADDRESS_CHANGEEntity(){
    }
    
    
    public PT_R_ADDRESS_CHANGEEntity(String CHGBRE_SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_ADDRESS_CHANGEEntity(ValueObject ent) throws Exception{
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
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.POST_NUM =request.getParameter("POST_NUM");
		this.ADDR =request.getParameter("ADDR");
		this.DETAIL_ADDR =request.getParameter("DETAIL_ADDR");
		this.OFFICE_AREA =request.getParameter("OFFICE_AREA");
		this.TEL_NUM =request.getParameter("TEL_NUM");
		this.FAX_NUM =request.getParameter("FAX_NUM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.ETC1 =request.getParameter("ETC1");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.POST_NUM =KJFMi.dsGet(ds, arg_row, "POST_NUM");
		this.ADDR =KJFMi.dsGet(ds, arg_row, "ADDR");
		this.DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "DETAIL_ADDR");
		this.OFFICE_AREA =KJFMi.dsGet(ds, arg_row, "OFFICE_AREA");
		this.TEL_NUM =KJFMi.dsGet(ds, arg_row, "TEL_NUM");
		this.FAX_NUM =KJFMi.dsGet(ds, arg_row, "FAX_NUM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.ETC1 =KJFMi.dsGet(ds, arg_row, "ETC1");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getPOST_NUM(){
             return POST_NUM;
     };
  
     public String getADDR(){
             return ADDR;
     };
  
     public String getDETAIL_ADDR(){
             return DETAIL_ADDR;
     };
  
     public String getOFFICE_AREA(){
             return OFFICE_AREA;
     };
  
     public String getTEL_NUM(){
             return TEL_NUM;
     };
  
     public String getFAX_NUM(){
             return FAX_NUM;
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
  

//Setter 함수를 만든다
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setPOST_NUM(String POST_NUM){
            this.POST_NUM=POST_NUM;
     };
  
     public void setADDR(String ADDR){
            this.ADDR=ADDR;
     };
  
     public void setDETAIL_ADDR(String DETAIL_ADDR){
            this.DETAIL_ADDR=DETAIL_ADDR;
     };
  
     public void setOFFICE_AREA(String OFFICE_AREA){
            this.OFFICE_AREA=OFFICE_AREA;
     };
  
     public void setTEL_NUM(String TEL_NUM){
            this.TEL_NUM=TEL_NUM;
     };
  
     public void setFAX_NUM(String FAX_NUM){
            this.FAX_NUM=FAX_NUM;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("POST_NUM:"+ this.getPOST_NUM()+"\n");
      
      strB.append("ADDR:"+ this.getADDR()+"\n");
      
      strB.append("DETAIL_ADDR:"+ this.getDETAIL_ADDR()+"\n");
      
      strB.append("OFFICE_AREA:"+ this.getOFFICE_AREA()+"\n");
      
      strB.append("TEL_NUM:"+ this.getTEL_NUM()+"\n");
      
      strB.append("FAX_NUM:"+ this.getFAX_NUM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("ETC1:"+ this.getETC1()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_ADDRESS_CHANGEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_ADDRESS_CHANGEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_ADDRESS_CHANGEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_ADDRESS_CHANGEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_ADDRESS_CHANGEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_ADDRESS_CHANGEEntity();
  }

  public ValueObject getClone(){
         PT_R_ADDRESS_CHANGEEntity newEnt = new PT_R_ADDRESS_CHANGEEntity();
	 
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setPOST_NUM(this.getPOST_NUM());
         
          newEnt.setADDR(this.getADDR());
         
          newEnt.setDETAIL_ADDR(this.getDETAIL_ADDR());
         
          newEnt.setOFFICE_AREA(this.getOFFICE_AREA());
         
          newEnt.setTEL_NUM(this.getTEL_NUM());
         
          newEnt.setFAX_NUM(this.getFAX_NUM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setETC1(this.getETC1());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_ADDRESS_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCHGBRE_SEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getPOST_NUM();
        
             case 5 :
                 return  this.getADDR();
        
             case 6 :
                 return  this.getDETAIL_ADDR();
        
             case 7 :
                 return  this.getOFFICE_AREA();
        
             case 8 :
                 return  this.getTEL_NUM();
        
             case 9 :
                 return  this.getFAX_NUM();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getUPD_DT();
        
             case 12 :
                 return  this.getINS_DT();
        
             case 13 :
                 return  this.getETC1();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_ADDRESS_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setPOST_NUM((String)value);
	            return;  
        
             case 5 :
                    this.setADDR((String)value);
	            return;  
        
             case 6 :
                    this.setDETAIL_ADDR((String)value);
	            return;  
        
             case 7 :
                    this.setOFFICE_AREA((String)value);
	            return;  
        
             case 8 :
                    this.setTEL_NUM((String)value);
	            return;  
        
             case 9 :
                    this.setFAX_NUM((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 11 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 12 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 13 :
                    this.setETC1((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_ADDRESS_CHANGEHelper.toXML(this);
  }
  
}
