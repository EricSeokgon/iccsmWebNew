

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_FACSIMILE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               ADMI_NUM:NUMBER(10):  
*               ADMI_QTT:NUMBER(10):  
*               CIV_NUM:NUMBER(10):  
*               CIV_QTT:NUMBER(10):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_FACSIMILEEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String REMARK;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String ADMI_NUM;
  
     private String ADMI_QTT;
  
     private String CIV_NUM;
  
     private String CIV_QTT;
  

//생성자를 만든다
    public PT_C_RES_FACSIMILEEntity(){
    }
    
    
    public PT_C_RES_FACSIMILEEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_FACSIMILEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.ORG_NM =request.getParameter("ORG_NM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.REMARK =request.getParameter("REMARK");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.ADMI_NUM =request.getParameter("ADMI_NUM");
		this.ADMI_QTT =request.getParameter("ADMI_QTT");
		this.CIV_NUM =request.getParameter("CIV_NUM");
		this.CIV_QTT =request.getParameter("CIV_QTT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.ADMI_NUM =KJFMi.dsGet(ds, arg_row, "ADMI_NUM");
		this.ADMI_QTT =KJFMi.dsGet(ds, arg_row, "ADMI_QTT");
		this.CIV_NUM =KJFMi.dsGet(ds, arg_row, "CIV_NUM");
		this.CIV_QTT =KJFMi.dsGet(ds, arg_row, "CIV_QTT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getORG_NM(){
             return ORG_NM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getREMARK(){
             return REMARK;
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
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getADMI_NUM(){
             return ADMI_NUM;
     };
  
     public String getADMI_QTT(){
             return ADMI_QTT;
     };
  
     public String getCIV_NUM(){
             return CIV_NUM;
     };
  
     public String getCIV_QTT(){
             return CIV_QTT;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setORG_NM(String ORG_NM){
            this.ORG_NM=ORG_NM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
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
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setADMI_NUM(String ADMI_NUM){
            this.ADMI_NUM=ADMI_NUM;
     };
  
     public void setADMI_QTT(String ADMI_QTT){
            this.ADMI_QTT=ADMI_QTT;
     };
  
     public void setCIV_NUM(String CIV_NUM){
            this.CIV_NUM=CIV_NUM;
     };
  
     public void setCIV_QTT(String CIV_QTT){
            this.CIV_QTT=CIV_QTT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("ADMI_NUM:"+ this.getADMI_NUM()+"\n");
      
      strB.append("ADMI_QTT:"+ this.getADMI_QTT()+"\n");
      
      strB.append("CIV_NUM:"+ this.getCIV_NUM()+"\n");
      
      strB.append("CIV_QTT:"+ this.getCIV_QTT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_FACSIMILEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_FACSIMILEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_FACSIMILEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_FACSIMILEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_FACSIMILEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_FACSIMILEEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_FACSIMILEEntity newEnt = new PT_C_RES_FACSIMILEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setADMI_NUM(this.getADMI_NUM());
         
          newEnt.setADMI_QTT(this.getADMI_QTT());
         
          newEnt.setCIV_NUM(this.getCIV_NUM());
         
          newEnt.setCIV_QTT(this.getCIV_QTT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_FACSIMILEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getREMARK();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getSIGUNGU_CODE();
        
             case 9 :
                 return  this.getADMI_NUM();
        
             case 10 :
                 return  this.getADMI_QTT();
        
             case 11 :
                 return  this.getCIV_NUM();
        
             case 12 :
                 return  this.getCIV_QTT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_FACSIMILEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setORG_NM((String)value);
	            return;  
        
             case 3 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setREMARK((String)value);
	            return;  
        
             case 5 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 8 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 9 :
                    this.setADMI_NUM((String)value);
	            return;  
        
             case 10 :
                    this.setADMI_QTT((String)value);
	            return;  
        
             case 11 :
                    this.setCIV_NUM((String)value);
	            return;  
        
             case 12 :
                    this.setCIV_QTT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_FACSIMILEHelper.toXML(this);
  }
  
}
