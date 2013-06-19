

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_S_WORK_ITEM
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WORKNM:VARCHAR2(200):  
*               SPOT_ADDR:VARCHAR2(200):  
*               CONT_WRT_YN:VARCHAR2(1):  
*               ENGINEER_ARR_NOTE:VARCHAR2(1):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(12):  
*               SPOT_TEL:VARCHAR2(17):  
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

public class PT_S_WORK_ITEMEntity extends ValueObject{

  
     private String WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String WORKNM;
  
     private String SPOT_ADDR;
  
     private String CONT_WRT_YN;
  
     private String ENGINEER_ARR_NOTE;
  
     private String CARE_BOOK_ISSUE_NUM;
  
     private String SPOT_TEL;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SEQ;
  

//생성자를 만든다
    public PT_S_WORK_ITEMEntity(){
    }
    
    
    public PT_S_WORK_ITEMEntity(String SEQ,String TMP_WRT_NUM,String WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_S_WORK_ITEMEntity(ValueObject ent) throws Exception{
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
		this.WORKNM =request.getParameter("WORKNM");
		this.SPOT_ADDR =request.getParameter("SPOT_ADDR");
		this.CONT_WRT_YN =request.getParameter("CONT_WRT_YN");
		this.ENGINEER_ARR_NOTE =request.getParameter("ENGINEER_ARR_NOTE");
		this.CARE_BOOK_ISSUE_NUM =request.getParameter("CARE_BOOK_ISSUE_NUM");
		this.SPOT_TEL =request.getParameter("SPOT_TEL");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SEQ =request.getParameter("SEQ");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WORKNM =KJFMi.dsGet(ds, arg_row, "WORKNM");
		this.SPOT_ADDR =KJFMi.dsGet(ds, arg_row, "SPOT_ADDR");
		this.CONT_WRT_YN =KJFMi.dsGet(ds, arg_row, "CONT_WRT_YN");
		this.ENGINEER_ARR_NOTE =KJFMi.dsGet(ds, arg_row, "ENGINEER_ARR_NOTE");
		this.CARE_BOOK_ISSUE_NUM =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_ISSUE_NUM");
		this.SPOT_TEL =KJFMi.dsGet(ds, arg_row, "SPOT_TEL");
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
  
     public String getWORKNM(){
             return WORKNM;
     };
  
     public String getSPOT_ADDR(){
             return SPOT_ADDR;
     };
  
     public String getCONT_WRT_YN(){
             return CONT_WRT_YN;
     };
  
     public String getENGINEER_ARR_NOTE(){
             return ENGINEER_ARR_NOTE;
     };
  
     public String getCARE_BOOK_ISSUE_NUM(){
             return CARE_BOOK_ISSUE_NUM;
     };
  
     public String getSPOT_TEL(){
             return SPOT_TEL;
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
  
     public void setWORKNM(String WORKNM){
            this.WORKNM=WORKNM;
     };
  
     public void setSPOT_ADDR(String SPOT_ADDR){
            this.SPOT_ADDR=SPOT_ADDR;
     };
  
     public void setCONT_WRT_YN(String CONT_WRT_YN){
            this.CONT_WRT_YN=CONT_WRT_YN;
     };
  
     public void setENGINEER_ARR_NOTE(String ENGINEER_ARR_NOTE){
            this.ENGINEER_ARR_NOTE=ENGINEER_ARR_NOTE;
     };
  
     public void setCARE_BOOK_ISSUE_NUM(String CARE_BOOK_ISSUE_NUM){
            this.CARE_BOOK_ISSUE_NUM=CARE_BOOK_ISSUE_NUM;
     };
  
     public void setSPOT_TEL(String SPOT_TEL){
            this.SPOT_TEL=SPOT_TEL;
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
      
      strB.append("WORKNM:"+ this.getWORKNM()+"\n");
      
      strB.append("SPOT_ADDR:"+ this.getSPOT_ADDR()+"\n");
      
      strB.append("CONT_WRT_YN:"+ this.getCONT_WRT_YN()+"\n");
      
      strB.append("ENGINEER_ARR_NOTE:"+ this.getENGINEER_ARR_NOTE()+"\n");
      
      strB.append("CARE_BOOK_ISSUE_NUM:"+ this.getCARE_BOOK_ISSUE_NUM()+"\n");
      
      strB.append("SPOT_TEL:"+ this.getSPOT_TEL()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_S_WORK_ITEMHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_S_WORK_ITEMHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_S_WORK_ITEMHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_S_WORK_ITEMHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_S_WORK_ITEMHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       values[2]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_S_WORK_ITEMEntity();
  }

  public ValueObject getClone(){
         PT_S_WORK_ITEMEntity newEnt = new PT_S_WORK_ITEMEntity();
	 
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWORKNM(this.getWORKNM());
         
          newEnt.setSPOT_ADDR(this.getSPOT_ADDR());
         
          newEnt.setCONT_WRT_YN(this.getCONT_WRT_YN());
         
          newEnt.setENGINEER_ARR_NOTE(this.getENGINEER_ARR_NOTE());
         
          newEnt.setCARE_BOOK_ISSUE_NUM(this.getCARE_BOOK_ISSUE_NUM());
         
          newEnt.setSPOT_TEL(this.getSPOT_TEL());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSEQ(this.getSEQ());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_S_WORK_ITEMHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWRT_NUM();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getWORKNM();
        
             case 4 :
                 return  this.getSPOT_ADDR();
        
             case 5 :
                 return  this.getCONT_WRT_YN();
        
             case 6 :
                 return  this.getENGINEER_ARR_NOTE();
        
             case 7 :
                 return  this.getCARE_BOOK_ISSUE_NUM();
        
             case 8 :
                 return  this.getSPOT_TEL();
        
             case 9 :
                 return  this.getINS_DT();
        
             case 10 :
                 return  this.getUPD_DT();
        
             case 11 :
                 return  this.getWRT_ID();
        
             case 12 :
                 return  this.getSEQ();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_S_WORK_ITEMHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setWORKNM((String)value);
	            return;  
        
             case 4 :
                    this.setSPOT_ADDR((String)value);
	            return;  
        
             case 5 :
                    this.setCONT_WRT_YN((String)value);
	            return;  
        
             case 6 :
                    this.setENGINEER_ARR_NOTE((String)value);
	            return;  
        
             case 7 :
                    this.setCARE_BOOK_ISSUE_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setSPOT_TEL((String)value);
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
        
             case 12 :
                    this.setSEQ((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_S_WORK_ITEMHelper.toXML(this);
  }
  
}
