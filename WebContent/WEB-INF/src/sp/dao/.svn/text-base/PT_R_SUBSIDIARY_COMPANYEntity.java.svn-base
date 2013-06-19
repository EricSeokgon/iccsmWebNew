

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_SUBSIDIARY_COMPANY
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               OTOB_COM_NUM:VARCHAR2(12):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               RECV_NUM:VARCHAR2(12):  
*               OTOB_COM_CODE:VARCHAR2(6):  
*               SIDO_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_SUBSIDIARY_COMPANYEntity extends ValueObject{

  
     private String SEQ;
  
     private String OTOB_COM_NUM;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String RECV_NUM;
  
     private String OTOB_COM_CODE;
  
     private String SIDO_CODE;
  

//생성자를 만든다
    public PT_R_SUBSIDIARY_COMPANYEntity(){
    }
    
    
    public PT_R_SUBSIDIARY_COMPANYEntity(String RECV_NUM,String SEQ ){
       this.setRECV_NUM(RECV_NUM);
       this.setSEQ(SEQ);
       
    }
      
    public PT_R_SUBSIDIARY_COMPANYEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.OTOB_COM_NUM =request.getParameter("OTOB_COM_NUM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.OTOB_COM_CODE =request.getParameter("OTOB_COM_CODE");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.OTOB_COM_NUM =KJFMi.dsGet(ds, arg_row, "OTOB_COM_NUM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.OTOB_COM_CODE =KJFMi.dsGet(ds, arg_row, "OTOB_COM_CODE");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getOTOB_COM_NUM(){
             return OTOB_COM_NUM;
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
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getOTOB_COM_CODE(){
             return OTOB_COM_CODE;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setOTOB_COM_NUM(String OTOB_COM_NUM){
            this.OTOB_COM_NUM=OTOB_COM_NUM;
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
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setOTOB_COM_CODE(String OTOB_COM_CODE){
            this.OTOB_COM_CODE=OTOB_COM_CODE;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("OTOB_COM_NUM:"+ this.getOTOB_COM_NUM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("OTOB_COM_CODE:"+ this.getOTOB_COM_CODE()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_SUBSIDIARY_COMPANYHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_SUBSIDIARY_COMPANYHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_SUBSIDIARY_COMPANYHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_SUBSIDIARY_COMPANYHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_SUBSIDIARY_COMPANYHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_SUBSIDIARY_COMPANYEntity();
  }

  public ValueObject getClone(){
         PT_R_SUBSIDIARY_COMPANYEntity newEnt = new PT_R_SUBSIDIARY_COMPANYEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setOTOB_COM_NUM(this.getOTOB_COM_NUM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setOTOB_COM_CODE(this.getOTOB_COM_CODE());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_SUBSIDIARY_COMPANYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getOTOB_COM_NUM();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getRECV_NUM();
        
             case 7 :
                 return  this.getOTOB_COM_CODE();
        
             case 8 :
                 return  this.getSIDO_CODE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_SUBSIDIARY_COMPANYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setOTOB_COM_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 5 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 6 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 7 :
                    this.setOTOB_COM_CODE((String)value);
	            return;  
        
             case 8 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_SUBSIDIARY_COMPANYHelper.toXML(this);
  }
  
}
