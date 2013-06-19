

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_CHANGE
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):  
*               DT:VARCHAR2(24):  
*               CHG_ITEM:VARCHAR2(10):  
*               CHG_ITEMS:VARCHAR2(20):  
*               CONFIRM:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(20):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_ENGINEER_M_CHANGEEntity extends ValueObject{

  
     private String SEQ;
  
     private String CARE_BOOK_ISSUE_NUM;
  
     private String DT;
  
     private String CHG_ITEM;
  
     private String CHG_ITEMS;
  
     private String CONFIRM;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String WRT_DT;
  
     private String ETC1;
  

//생성자를 만든다
    public PT_R_ENGINEER_M_CHANGEEntity(){
    }
    
    
    public PT_R_ENGINEER_M_CHANGEEntity(String CARE_BOOK_ISSUE_NUM,String SEQ ){
       this.setCARE_BOOK_ISSUE_NUM(CARE_BOOK_ISSUE_NUM);
       this.setSEQ(SEQ);
       
    }
      
    public PT_R_ENGINEER_M_CHANGEEntity(ValueObject ent) throws Exception{
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
		this.DT =request.getParameter("DT");
		this.CHG_ITEM =request.getParameter("CHG_ITEM");
		this.CHG_ITEMS =request.getParameter("CHG_ITEMS");
		this.CONFIRM =request.getParameter("CONFIRM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_DT =request.getParameter("WRT_DT");
		this.ETC1 =request.getParameter("ETC1");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.CARE_BOOK_ISSUE_NUM =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_ISSUE_NUM");
		this.DT =KJFMi.dsGet(ds, arg_row, "DT");
		this.CHG_ITEM =KJFMi.dsGet(ds, arg_row, "CHG_ITEM");
		this.CHG_ITEMS =KJFMi.dsGet(ds, arg_row, "CHG_ITEMS");
		this.CONFIRM =KJFMi.dsGet(ds, arg_row, "CONFIRM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.ETC1 =KJFMi.dsGet(ds, arg_row, "ETC1");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getCARE_BOOK_ISSUE_NUM(){
             return CARE_BOOK_ISSUE_NUM;
     };
  
     public String getDT(){
             return DT;
     };
  
     public String getCHG_ITEM(){
             return CHG_ITEM;
     };
  
     public String getCHG_ITEMS(){
             return CHG_ITEMS;
     };
  
     public String getCONFIRM(){
             return CONFIRM;
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
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setCARE_BOOK_ISSUE_NUM(String CARE_BOOK_ISSUE_NUM){
            this.CARE_BOOK_ISSUE_NUM=CARE_BOOK_ISSUE_NUM;
     };
  
     public void setDT(String DT){
            this.DT=DT;
     };
  
     public void setCHG_ITEM(String CHG_ITEM){
            this.CHG_ITEM=CHG_ITEM;
     };
  
     public void setCHG_ITEMS(String CHG_ITEMS){
            this.CHG_ITEMS=CHG_ITEMS;
     };
  
     public void setCONFIRM(String CONFIRM){
            this.CONFIRM=CONFIRM;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("CARE_BOOK_ISSUE_NUM:"+ this.getCARE_BOOK_ISSUE_NUM()+"\n");
      
      strB.append("DT:"+ this.getDT()+"\n");
      
      strB.append("CHG_ITEM:"+ this.getCHG_ITEM()+"\n");
      
      strB.append("CHG_ITEMS:"+ this.getCHG_ITEMS()+"\n");
      
      strB.append("CONFIRM:"+ this.getCONFIRM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("ETC1:"+ this.getETC1()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_ENGINEER_M_CHANGEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_ENGINEER_M_CHANGEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_ENGINEER_M_CHANGEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_ENGINEER_M_CHANGEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_ENGINEER_M_CHANGEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCARE_BOOK_ISSUE_NUM();
       values[1]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_ENGINEER_M_CHANGEEntity();
  }

  public ValueObject getClone(){
         PT_R_ENGINEER_M_CHANGEEntity newEnt = new PT_R_ENGINEER_M_CHANGEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setCARE_BOOK_ISSUE_NUM(this.getCARE_BOOK_ISSUE_NUM());
         
          newEnt.setDT(this.getDT());
         
          newEnt.setCHG_ITEM(this.getCHG_ITEM());
         
          newEnt.setCHG_ITEMS(this.getCHG_ITEMS());
         
          newEnt.setCONFIRM(this.getCONFIRM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setETC1(this.getETC1());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_ENGINEER_M_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getCARE_BOOK_ISSUE_NUM();
        
             case 3 :
                 return  this.getDT();
        
             case 4 :
                 return  this.getCHG_ITEM();
        
             case 5 :
                 return  this.getCHG_ITEMS();
        
             case 6 :
                 return  this.getCONFIRM();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getWRT_DT();
        
             case 10 :
                 return  this.getETC1();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_ENGINEER_M_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCARE_BOOK_ISSUE_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setDT((String)value);
	            return;  
        
             case 4 :
                    this.setCHG_ITEM((String)value);
	            return;  
        
             case 5 :
                    this.setCHG_ITEMS((String)value);
	            return;  
        
             case 6 :
                    this.setCONFIRM((String)value);
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
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_ENGINEER_M_CHANGEHelper.toXML(this);
  }
  
}
