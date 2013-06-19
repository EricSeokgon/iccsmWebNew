

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_PRIZE
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(20):  
*               YMD:VARCHAR2(20):  
*               ITEM:VARCHAR2(30):  
*               PAD_REST_TERM:VARCHAR2(30):  
*               BAS:VARCHAR2(30):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(30):  
*               ETC2:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_ENGINEER_M_PRIZEEntity extends ValueObject{

  
     private String SEQ;
  
     private String CARE_BOOK_ISSUE_NUM;
  
     private String YMD;
  
     private String ITEM;
  
     private String PAD_REST_TERM;
  
     private String BAS;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String WRT_DT;
  
     private String ETC1;
  
     private String ETC2;
  

//생성자를 만든다
    public PT_R_ENGINEER_M_PRIZEEntity(){
    }
    
    
    public PT_R_ENGINEER_M_PRIZEEntity(String CARE_BOOK_ISSUE_NUM,String SEQ ){
       this.setCARE_BOOK_ISSUE_NUM(CARE_BOOK_ISSUE_NUM);
       this.setSEQ(SEQ);
       
    }
      
    public PT_R_ENGINEER_M_PRIZEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CARE_BOOK_ISSUE_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CARE_BOOK_ISSUE_NUM",value);
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.CARE_BOOK_ISSUE_NUM =request.getParameter("CARE_BOOK_ISSUE_NUM");
		this.YMD =request.getParameter("YMD");
		this.ITEM =request.getParameter("ITEM");
		this.PAD_REST_TERM =request.getParameter("PAD_REST_TERM");
		this.BAS =request.getParameter("BAS");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_DT =request.getParameter("WRT_DT");
		this.ETC1 =request.getParameter("ETC1");
		this.ETC2 =request.getParameter("ETC2");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.CARE_BOOK_ISSUE_NUM =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_ISSUE_NUM");
		this.YMD =KJFMi.dsGet(ds, arg_row, "YMD");
		this.ITEM =KJFMi.dsGet(ds, arg_row, "ITEM");
		this.PAD_REST_TERM =KJFMi.dsGet(ds, arg_row, "PAD_REST_TERM");
		this.BAS =KJFMi.dsGet(ds, arg_row, "BAS");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.ETC1 =KJFMi.dsGet(ds, arg_row, "ETC1");
		this.ETC2 =KJFMi.dsGet(ds, arg_row, "ETC2");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getCARE_BOOK_ISSUE_NUM(){
             return CARE_BOOK_ISSUE_NUM;
     };
  
     public String getYMD(){
             return YMD;
     };
  
     public String getITEM(){
             return ITEM;
     };
  
     public String getPAD_REST_TERM(){
             return PAD_REST_TERM;
     };
  
     public String getBAS(){
             return BAS;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  
     public String getETC1(){
             return ETC1;
     };
  
     public String getETC2(){
             return ETC2;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setCARE_BOOK_ISSUE_NUM(String CARE_BOOK_ISSUE_NUM){
            this.CARE_BOOK_ISSUE_NUM=CARE_BOOK_ISSUE_NUM;
     };
  
     public void setYMD(String YMD){
            this.YMD=YMD;
     };
  
     public void setITEM(String ITEM){
            this.ITEM=ITEM;
     };
  
     public void setPAD_REST_TERM(String PAD_REST_TERM){
            this.PAD_REST_TERM=PAD_REST_TERM;
     };
  
     public void setBAS(String BAS){
            this.BAS=BAS;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
     public void setETC1(String ETC1){
            this.ETC1=ETC1;
     };
  
     public void setETC2(String ETC2){
            this.ETC2=ETC2;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("CARE_BOOK_ISSUE_NUM:"+ this.getCARE_BOOK_ISSUE_NUM()+"\n");
      
      strB.append("YMD:"+ this.getYMD()+"\n");
      
      strB.append("ITEM:"+ this.getITEM()+"\n");
      
      strB.append("PAD_REST_TERM:"+ this.getPAD_REST_TERM()+"\n");
      
      strB.append("BAS:"+ this.getBAS()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("ETC1:"+ this.getETC1()+"\n");
      
      strB.append("ETC2:"+ this.getETC2()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_ENGINEER_M_PRIZEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_ENGINEER_M_PRIZEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_ENGINEER_M_PRIZEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_ENGINEER_M_PRIZEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_ENGINEER_M_PRIZEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCARE_BOOK_ISSUE_NUM();
       values[1]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_ENGINEER_M_PRIZEEntity();
  }

  public ValueObject getClone(){
         PT_R_ENGINEER_M_PRIZEEntity newEnt = new PT_R_ENGINEER_M_PRIZEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setCARE_BOOK_ISSUE_NUM(this.getCARE_BOOK_ISSUE_NUM());
         
          newEnt.setYMD(this.getYMD());
         
          newEnt.setITEM(this.getITEM());
         
          newEnt.setPAD_REST_TERM(this.getPAD_REST_TERM());
         
          newEnt.setBAS(this.getBAS());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setETC1(this.getETC1());
         
          newEnt.setETC2(this.getETC2());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_ENGINEER_M_PRIZEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getCARE_BOOK_ISSUE_NUM();
        
             case 3 :
                 return  this.getYMD();
        
             case 4 :
                 return  this.getITEM();
        
             case 5 :
                 return  this.getPAD_REST_TERM();
        
             case 6 :
                 return  this.getBAS();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getWRT_DT();
        
             case 10 :
                 return  this.getETC1();
        
             case 11 :
                 return  this.getETC2();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_ENGINEER_M_PRIZEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCARE_BOOK_ISSUE_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setYMD((String)value);
	            return;  
        
             case 4 :
                    this.setITEM((String)value);
	            return;  
        
             case 5 :
                    this.setPAD_REST_TERM((String)value);
	            return;  
        
             case 6 :
                    this.setBAS((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 10 :
                    this.setETC1((String)value);
	            return;  
        
             case 11 :
                    this.setETC2((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_ENGINEER_M_PRIZEHelper.toXML(this);
  }
  
}
