

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_WORK_CAPABILITY
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               ASSE_DT:VARCHAR2(8):  
*               ASSE_AOM:VARCHAR2(15):  
*               APPL_TERM_START_DT:VARCHAR2(8):  
*               CONFIRM:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               APPL_TERM_END_DT:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_WORK_CAPABILITYEntity extends ValueObject{

  
     private String SEQ;
  
     private String TMP_WRT_NUM;
  
     private String COI_WRT_NUM;
  
     private String ASSE_DT;
  
     private String ASSE_AOM;
  
     private String APPL_TERM_START_DT;
  
     private String CONFIRM;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String APPL_TERM_END_DT;
  

//생성자를 만든다
    public PT_R_WORK_CAPABILITYEntity(){
    }
    
    
    public PT_R_WORK_CAPABILITYEntity(String SEQ,String TMP_WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_WORK_CAPABILITYEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		this.ASSE_DT =request.getParameter("ASSE_DT");
		this.ASSE_AOM =request.getParameter("ASSE_AOM");
		this.APPL_TERM_START_DT =request.getParameter("APPL_TERM_START_DT");
		this.CONFIRM =request.getParameter("CONFIRM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.APPL_TERM_END_DT =request.getParameter("APPL_TERM_END_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		this.ASSE_DT =KJFMi.dsGet(ds, arg_row, "ASSE_DT");
		this.ASSE_AOM =KJFMi.dsGet(ds, arg_row, "ASSE_AOM");
		this.APPL_TERM_START_DT =KJFMi.dsGet(ds, arg_row, "APPL_TERM_START_DT");
		this.CONFIRM =KJFMi.dsGet(ds, arg_row, "CONFIRM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.APPL_TERM_END_DT =KJFMi.dsGet(ds, arg_row, "APPL_TERM_END_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
     public String getASSE_DT(){
             return ASSE_DT;
     };
  
     public String getASSE_AOM(){
             return ASSE_AOM;
     };
  
     public String getAPPL_TERM_START_DT(){
             return APPL_TERM_START_DT;
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
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getAPPL_TERM_END_DT(){
             return APPL_TERM_END_DT;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
     public void setASSE_DT(String ASSE_DT){
            this.ASSE_DT=ASSE_DT;
     };
  
     public void setASSE_AOM(String ASSE_AOM){
            this.ASSE_AOM=ASSE_AOM;
     };
  
     public void setAPPL_TERM_START_DT(String APPL_TERM_START_DT){
            this.APPL_TERM_START_DT=APPL_TERM_START_DT;
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
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setAPPL_TERM_END_DT(String APPL_TERM_END_DT){
            this.APPL_TERM_END_DT=APPL_TERM_END_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
      strB.append("ASSE_DT:"+ this.getASSE_DT()+"\n");
      
      strB.append("ASSE_AOM:"+ this.getASSE_AOM()+"\n");
      
      strB.append("APPL_TERM_START_DT:"+ this.getAPPL_TERM_START_DT()+"\n");
      
      strB.append("CONFIRM:"+ this.getCONFIRM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("APPL_TERM_END_DT:"+ this.getAPPL_TERM_END_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_WORK_CAPABILITYHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_WORK_CAPABILITYHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_WORK_CAPABILITYHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_WORK_CAPABILITYHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_WORK_CAPABILITYHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_WORK_CAPABILITYEntity();
  }

  public ValueObject getClone(){
         PT_R_WORK_CAPABILITYEntity newEnt = new PT_R_WORK_CAPABILITYEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setASSE_DT(this.getASSE_DT());
         
          newEnt.setASSE_AOM(this.getASSE_AOM());
         
          newEnt.setAPPL_TERM_START_DT(this.getAPPL_TERM_START_DT());
         
          newEnt.setCONFIRM(this.getCONFIRM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setAPPL_TERM_END_DT(this.getAPPL_TERM_END_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_WORK_CAPABILITYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getCOI_WRT_NUM();
        
             case 4 :
                 return  this.getASSE_DT();
        
             case 5 :
                 return  this.getASSE_AOM();
        
             case 6 :
                 return  this.getAPPL_TERM_START_DT();
        
             case 7 :
                 return  this.getCONFIRM();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getINS_DT();
        
             case 11 :
                 return  this.getAPPL_TERM_END_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_WORK_CAPABILITYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setASSE_DT((String)value);
	            return;  
        
             case 5 :
                    this.setASSE_AOM((String)value);
	            return;  
        
             case 6 :
                    this.setAPPL_TERM_START_DT((String)value);
	            return;  
        
             case 7 :
                    this.setCONFIRM((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 9 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 10 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 11 :
                    this.setAPPL_TERM_END_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_WORK_CAPABILITYHelper.toXML(this);
  }
  
}
