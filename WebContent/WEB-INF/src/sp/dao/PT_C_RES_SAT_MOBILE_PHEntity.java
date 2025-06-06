

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_SAT_MOBILE_PH
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               ITEM_NM:VARCHAR2(100):  
*               QTT:NUMBER(10):  
*               LINE_AOM:NUMBER(20):  
*               PDT:VARCHAR2(50):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               INSTAL_DT:CHAR(18):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_SAT_MOBILE_PHEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String ITEM_NM;
  
     private String QTT;
  
     private String LINE_AOM;
  
     private String PDT;
  
     private String REMARK;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String INSTAL_DT;
  

//생성자를 만든다
    public PT_C_RES_SAT_MOBILE_PHEntity(){
    }
    
    
    public PT_C_RES_SAT_MOBILE_PHEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_SAT_MOBILE_PHEntity(ValueObject ent) throws Exception{
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
		this.ITEM_NM =request.getParameter("ITEM_NM");
		this.QTT =request.getParameter("QTT");
		this.LINE_AOM =request.getParameter("LINE_AOM");
		this.PDT =request.getParameter("PDT");
		this.REMARK =request.getParameter("REMARK");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.INSTAL_DT =request.getParameter("INSTAL_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.ITEM_NM =KJFMi.dsGet(ds, arg_row, "ITEM_NM");
		this.QTT =KJFMi.dsGet(ds, arg_row, "QTT");
		this.LINE_AOM =KJFMi.dsGet(ds, arg_row, "LINE_AOM");
		this.PDT =KJFMi.dsGet(ds, arg_row, "PDT");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.INSTAL_DT =KJFMi.dsGet(ds, arg_row, "INSTAL_DT");
				
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
  
     public String getITEM_NM(){
             return ITEM_NM;
     };
  
     public String getQTT(){
             return QTT;
     };
  
     public String getLINE_AOM(){
             return LINE_AOM;
     };
  
     public String getPDT(){
             return PDT;
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
  
     public String getINSTAL_DT(){
             return INSTAL_DT;
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
  
     public void setITEM_NM(String ITEM_NM){
            this.ITEM_NM=ITEM_NM;
     };
  
     public void setQTT(String QTT){
            this.QTT=QTT;
     };
  
     public void setLINE_AOM(String LINE_AOM){
            this.LINE_AOM=LINE_AOM;
     };
  
     public void setPDT(String PDT){
            this.PDT=PDT;
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
  
     public void setINSTAL_DT(String INSTAL_DT){
            this.INSTAL_DT=INSTAL_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("ITEM_NM:"+ this.getITEM_NM()+"\n");
      
      strB.append("QTT:"+ this.getQTT()+"\n");
      
      strB.append("LINE_AOM:"+ this.getLINE_AOM()+"\n");
      
      strB.append("PDT:"+ this.getPDT()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("INSTAL_DT:"+ this.getINSTAL_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_SAT_MOBILE_PHHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_SAT_MOBILE_PHHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_SAT_MOBILE_PHHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_SAT_MOBILE_PHHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_SAT_MOBILE_PHHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_SAT_MOBILE_PHEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_SAT_MOBILE_PHEntity newEnt = new PT_C_RES_SAT_MOBILE_PHEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setITEM_NM(this.getITEM_NM());
         
          newEnt.setQTT(this.getQTT());
         
          newEnt.setLINE_AOM(this.getLINE_AOM());
         
          newEnt.setPDT(this.getPDT());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setINSTAL_DT(this.getINSTAL_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_SAT_MOBILE_PHHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getITEM_NM();
        
             case 5 :
                 return  this.getQTT();
        
             case 6 :
                 return  this.getLINE_AOM();
        
             case 7 :
                 return  this.getPDT();
        
             case 8 :
                 return  this.getREMARK();
        
             case 9 :
                 return  this.getINS_DT();
        
             case 10 :
                 return  this.getUPD_DT();
        
             case 11 :
                 return  this.getWRT_ID();
        
             case 12 :
                 return  this.getSIGUNGU_CODE();
        
             case 13 :
                 return  this.getINSTAL_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_SAT_MOBILE_PHHelper.fieldMap.get(key);
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
                    this.setITEM_NM((String)value);
	            return;  
        
             case 5 :
                    this.setQTT((String)value);
	            return;  
        
             case 6 :
                    this.setLINE_AOM((String)value);
	            return;  
        
             case 7 :
                    this.setPDT((String)value);
	            return;  
        
             case 8 :
                    this.setREMARK((String)value);
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
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 13 :
                    this.setINSTAL_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_SAT_MOBILE_PHHelper.toXML(this);
  }
  
}
