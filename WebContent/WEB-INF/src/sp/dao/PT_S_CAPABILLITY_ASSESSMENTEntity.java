

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_CAPABILLITY_ASSESSMENT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):  
*               ADDR:VARCHAR2(200):  
*               QUAL_NUM:VARCHAR2(12):  
*               PAY:VARCHAR2(10):  
*               ARR_SPOT:VARCHAR2(200):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               SEQ:NUMBER(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_S_CAPABILLITY_ASSESSMENTEntity extends ValueObject{

  
     private String WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String CARE_BOOK_ISSUE_NUM;
  
     private String ADDR;
  
     private String QUAL_NUM;
  
     private String PAY;
  
     private String ARR_SPOT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SEQ;
  

//생성자를 만든다
    public PT_S_CAPABILLITY_ASSESSMENTEntity(){
    }
    
    
    public PT_S_CAPABILLITY_ASSESSMENTEntity(String SEQ,String TMP_WRT_NUM,String WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_S_CAPABILLITY_ASSESSMENTEntity(ValueObject ent) throws Exception{
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
		this.CARE_BOOK_ISSUE_NUM =request.getParameter("CARE_BOOK_ISSUE_NUM");
		this.ADDR =request.getParameter("ADDR");
		this.QUAL_NUM =request.getParameter("QUAL_NUM");
		this.PAY =request.getParameter("PAY");
		this.ARR_SPOT =request.getParameter("ARR_SPOT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SEQ =request.getParameter("SEQ");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.CARE_BOOK_ISSUE_NUM =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_ISSUE_NUM");
		this.ADDR =KJFMi.dsGet(ds, arg_row, "ADDR");
		this.QUAL_NUM =KJFMi.dsGet(ds, arg_row, "QUAL_NUM");
		this.PAY =KJFMi.dsGet(ds, arg_row, "PAY");
		this.ARR_SPOT =KJFMi.dsGet(ds, arg_row, "ARR_SPOT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
				
    }    
    
//Getter 함수를 만든다
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getCARE_BOOK_ISSUE_NUM(){
             return CARE_BOOK_ISSUE_NUM;
     };
  
     public String getADDR(){
             return ADDR;
     };
  
     public String getQUAL_NUM(){
             return QUAL_NUM;
     };
  
     public String getPAY(){
             return PAY;
     };
  
     public String getARR_SPOT(){
             return ARR_SPOT;
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
  
     public String getSEQ(){
             return SEQ;
     };
  

//Setter 함수를 만든다
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setCARE_BOOK_ISSUE_NUM(String CARE_BOOK_ISSUE_NUM){
            this.CARE_BOOK_ISSUE_NUM=CARE_BOOK_ISSUE_NUM;
     };
  
     public void setADDR(String ADDR){
            this.ADDR=ADDR;
     };
  
     public void setQUAL_NUM(String QUAL_NUM){
            this.QUAL_NUM=QUAL_NUM;
     };
  
     public void setPAY(String PAY){
            this.PAY=PAY;
     };
  
     public void setARR_SPOT(String ARR_SPOT){
            this.ARR_SPOT=ARR_SPOT;
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
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("CARE_BOOK_ISSUE_NUM:"+ this.getCARE_BOOK_ISSUE_NUM()+"\n");
      
      strB.append("ADDR:"+ this.getADDR()+"\n");
      
      strB.append("QUAL_NUM:"+ this.getQUAL_NUM()+"\n");
      
      strB.append("PAY:"+ this.getPAY()+"\n");
      
      strB.append("ARR_SPOT:"+ this.getARR_SPOT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_S_CAPABILLITY_ASSESSMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_S_CAPABILLITY_ASSESSMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_S_CAPABILLITY_ASSESSMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_S_CAPABILLITY_ASSESSMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_S_CAPABILLITY_ASSESSMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       values[2]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_S_CAPABILLITY_ASSESSMENTEntity();
  }

  public ValueObject getClone(){
         PT_S_CAPABILLITY_ASSESSMENTEntity newEnt = new PT_S_CAPABILLITY_ASSESSMENTEntity();
	 
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setCARE_BOOK_ISSUE_NUM(this.getCARE_BOOK_ISSUE_NUM());
         
          newEnt.setADDR(this.getADDR());
         
          newEnt.setQUAL_NUM(this.getQUAL_NUM());
         
          newEnt.setPAY(this.getPAY());
         
          newEnt.setARR_SPOT(this.getARR_SPOT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSEQ(this.getSEQ());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_S_CAPABILLITY_ASSESSMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWRT_NUM();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getCARE_BOOK_ISSUE_NUM();
        
             case 4 :
                 return  this.getADDR();
        
             case 5 :
                 return  this.getQUAL_NUM();
        
             case 6 :
                 return  this.getPAY();
        
             case 7 :
                 return  this.getARR_SPOT();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getSEQ();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_S_CAPABILLITY_ASSESSMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setCARE_BOOK_ISSUE_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setADDR((String)value);
	            return;  
        
             case 5 :
                    this.setQUAL_NUM((String)value);
	            return;  
        
             case 6 :
                    this.setPAY((String)value);
	            return;  
        
             case 7 :
                    this.setARR_SPOT((String)value);
	            return;  
        
             case 8 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 9 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 11 :
                    this.setSEQ((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_S_CAPABILLITY_ASSESSMENTHelper.toXML(this);
  }
  
}
