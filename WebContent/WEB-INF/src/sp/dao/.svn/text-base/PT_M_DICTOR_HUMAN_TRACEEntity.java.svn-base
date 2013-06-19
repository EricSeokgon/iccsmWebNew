

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_DICTOR_HUMAN_TRACE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               OFFI_CODE:VARCHAR2(16):  
*               INVER_PART:VARCHAR2(50):  
*               INVER_POS:VARCHAR2(50):  
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

public class PT_M_DICTOR_HUMAN_TRACEEntity extends ValueObject{

  
     private String WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String OFFI_CODE;
  
     private String INVER_PART;
  
     private String INVER_POS;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SEQ;
  

//생성자를 만든다
    public PT_M_DICTOR_HUMAN_TRACEEntity(){
    }
    
    
    public PT_M_DICTOR_HUMAN_TRACEEntity(String SEQ,String TMP_WRT_NUM,String WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_DICTOR_HUMAN_TRACEEntity(ValueObject ent) throws Exception{
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
		this.OFFI_CODE =request.getParameter("OFFI_CODE");
		this.INVER_PART =request.getParameter("INVER_PART");
		this.INVER_POS =request.getParameter("INVER_POS");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SEQ =request.getParameter("SEQ");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.OFFI_CODE =KJFMi.dsGet(ds, arg_row, "OFFI_CODE");
		this.INVER_PART =KJFMi.dsGet(ds, arg_row, "INVER_PART");
		this.INVER_POS =KJFMi.dsGet(ds, arg_row, "INVER_POS");
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
  
     public String getOFFI_CODE(){
             return OFFI_CODE;
     };
  
     public String getINVER_PART(){
             return INVER_PART;
     };
  
     public String getINVER_POS(){
             return INVER_POS;
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
  
     public void setOFFI_CODE(String OFFI_CODE){
            this.OFFI_CODE=OFFI_CODE;
     };
  
     public void setINVER_PART(String INVER_PART){
            this.INVER_PART=INVER_PART;
     };
  
     public void setINVER_POS(String INVER_POS){
            this.INVER_POS=INVER_POS;
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
      
      strB.append("OFFI_CODE:"+ this.getOFFI_CODE()+"\n");
      
      strB.append("INVER_PART:"+ this.getINVER_PART()+"\n");
      
      strB.append("INVER_POS:"+ this.getINVER_POS()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_DICTOR_HUMAN_TRACEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_DICTOR_HUMAN_TRACEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_DICTOR_HUMAN_TRACEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_DICTOR_HUMAN_TRACEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_DICTOR_HUMAN_TRACEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       values[2]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_DICTOR_HUMAN_TRACEEntity();
  }

  public ValueObject getClone(){
         PT_M_DICTOR_HUMAN_TRACEEntity newEnt = new PT_M_DICTOR_HUMAN_TRACEEntity();
	 
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setOFFI_CODE(this.getOFFI_CODE());
         
          newEnt.setINVER_PART(this.getINVER_PART());
         
          newEnt.setINVER_POS(this.getINVER_POS());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSEQ(this.getSEQ());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_DICTOR_HUMAN_TRACEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWRT_NUM();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getOFFI_CODE();
        
             case 4 :
                 return  this.getINVER_PART();
        
             case 5 :
                 return  this.getINVER_POS();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getSEQ();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_DICTOR_HUMAN_TRACEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setOFFI_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setINVER_PART((String)value);
	            return;  
        
             case 5 :
                    this.setINVER_POS((String)value);
	            return;  
        
             case 6 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 7 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 9 :
                    this.setSEQ((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_DICTOR_HUMAN_TRACEHelper.toXML(this);
  }
  
}
