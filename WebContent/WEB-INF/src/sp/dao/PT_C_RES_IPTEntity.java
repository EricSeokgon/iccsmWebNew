

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_IPT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               IPP_ITEM_NM:VARCHAR2(100):  
*               IPM_QTT:NUMBER(10):  
*               IPP_INSTAL_DT:VARCHAR2(12):  
*               IPP_ESTAB_AOM:NUMBER(20):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               IPP_PDT:VARCHAR2(100):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               IPM_PDT:VARCHAR2(100):  
*               IPM_ITEM_NM:VARCHAR2(100):  
*               IPM_ESTAB_AOM:NUMBER(20):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_IPTEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String IPP_ITEM_NM;
  
     private String IPM_QTT;
  
     private String IPP_INSTAL_DT;
  
     private String IPP_ESTAB_AOM;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String IPP_PDT;
  
     private String SIGUNGU_CODE;
  
     private String IPM_PDT;
  
     private String IPM_ITEM_NM;
  
     private String IPM_ESTAB_AOM;
  

//생성자를 만든다
    public PT_C_RES_IPTEntity(){
    }
    
    
    public PT_C_RES_IPTEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_IPTEntity(ValueObject ent) throws Exception{
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
		this.IPP_ITEM_NM =request.getParameter("IPP_ITEM_NM");
		this.IPM_QTT =request.getParameter("IPM_QTT");
		this.IPP_INSTAL_DT =request.getParameter("IPP_INSTAL_DT");
		this.IPP_ESTAB_AOM =request.getParameter("IPP_ESTAB_AOM");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.IPP_PDT =request.getParameter("IPP_PDT");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.IPM_PDT =request.getParameter("IPM_PDT");
		this.IPM_ITEM_NM =request.getParameter("IPM_ITEM_NM");
		this.IPM_ESTAB_AOM =request.getParameter("IPM_ESTAB_AOM");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.IPP_ITEM_NM =KJFMi.dsGet(ds, arg_row, "IPP_ITEM_NM");
		this.IPM_QTT =KJFMi.dsGet(ds, arg_row, "IPM_QTT");
		this.IPP_INSTAL_DT =KJFMi.dsGet(ds, arg_row, "IPP_INSTAL_DT");
		this.IPP_ESTAB_AOM =KJFMi.dsGet(ds, arg_row, "IPP_ESTAB_AOM");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.IPP_PDT =KJFMi.dsGet(ds, arg_row, "IPP_PDT");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.IPM_PDT =KJFMi.dsGet(ds, arg_row, "IPM_PDT");
		this.IPM_ITEM_NM =KJFMi.dsGet(ds, arg_row, "IPM_ITEM_NM");
		this.IPM_ESTAB_AOM =KJFMi.dsGet(ds, arg_row, "IPM_ESTAB_AOM");
				
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
  
     public String getIPP_ITEM_NM(){
             return IPP_ITEM_NM;
     };
  
     public String getIPM_QTT(){
             return IPM_QTT;
     };
  
     public String getIPP_INSTAL_DT(){
             return IPP_INSTAL_DT;
     };
  
     public String getIPP_ESTAB_AOM(){
             return IPP_ESTAB_AOM;
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
  
     public String getIPP_PDT(){
             return IPP_PDT;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getIPM_PDT(){
             return IPM_PDT;
     };
  
     public String getIPM_ITEM_NM(){
             return IPM_ITEM_NM;
     };
  
     public String getIPM_ESTAB_AOM(){
             return IPM_ESTAB_AOM;
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
  
     public void setIPP_ITEM_NM(String IPP_ITEM_NM){
            this.IPP_ITEM_NM=IPP_ITEM_NM;
     };
  
     public void setIPM_QTT(String IPM_QTT){
            this.IPM_QTT=IPM_QTT;
     };
  
     public void setIPP_INSTAL_DT(String IPP_INSTAL_DT){
            this.IPP_INSTAL_DT=IPP_INSTAL_DT;
     };
  
     public void setIPP_ESTAB_AOM(String IPP_ESTAB_AOM){
            this.IPP_ESTAB_AOM=IPP_ESTAB_AOM;
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
  
     public void setIPP_PDT(String IPP_PDT){
            this.IPP_PDT=IPP_PDT;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setIPM_PDT(String IPM_PDT){
            this.IPM_PDT=IPM_PDT;
     };
  
     public void setIPM_ITEM_NM(String IPM_ITEM_NM){
            this.IPM_ITEM_NM=IPM_ITEM_NM;
     };
  
     public void setIPM_ESTAB_AOM(String IPM_ESTAB_AOM){
            this.IPM_ESTAB_AOM=IPM_ESTAB_AOM;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("IPP_ITEM_NM:"+ this.getIPP_ITEM_NM()+"\n");
      
      strB.append("IPM_QTT:"+ this.getIPM_QTT()+"\n");
      
      strB.append("IPP_INSTAL_DT:"+ this.getIPP_INSTAL_DT()+"\n");
      
      strB.append("IPP_ESTAB_AOM:"+ this.getIPP_ESTAB_AOM()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("IPP_PDT:"+ this.getIPP_PDT()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("IPM_PDT:"+ this.getIPM_PDT()+"\n");
      
      strB.append("IPM_ITEM_NM:"+ this.getIPM_ITEM_NM()+"\n");
      
      strB.append("IPM_ESTAB_AOM:"+ this.getIPM_ESTAB_AOM()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_IPTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_IPTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_IPTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_IPTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_IPTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_IPTEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_IPTEntity newEnt = new PT_C_RES_IPTEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setIPP_ITEM_NM(this.getIPP_ITEM_NM());
         
          newEnt.setIPM_QTT(this.getIPM_QTT());
         
          newEnt.setIPP_INSTAL_DT(this.getIPP_INSTAL_DT());
         
          newEnt.setIPP_ESTAB_AOM(this.getIPP_ESTAB_AOM());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setIPP_PDT(this.getIPP_PDT());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setIPM_PDT(this.getIPM_PDT());
         
          newEnt.setIPM_ITEM_NM(this.getIPM_ITEM_NM());
         
          newEnt.setIPM_ESTAB_AOM(this.getIPM_ESTAB_AOM());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_IPTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getIPP_ITEM_NM();
        
             case 5 :
                 return  this.getIPM_QTT();
        
             case 6 :
                 return  this.getIPP_INSTAL_DT();
        
             case 7 :
                 return  this.getIPP_ESTAB_AOM();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getIPP_PDT();
        
             case 12 :
                 return  this.getSIGUNGU_CODE();
        
             case 13 :
                 return  this.getIPM_PDT();
        
             case 14 :
                 return  this.getIPM_ITEM_NM();
        
             case 15 :
                 return  this.getIPM_ESTAB_AOM();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_IPTHelper.fieldMap.get(key);
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
                    this.setIPP_ITEM_NM((String)value);
	            return;  
        
             case 5 :
                    this.setIPM_QTT((String)value);
	            return;  
        
             case 6 :
                    this.setIPP_INSTAL_DT((String)value);
	            return;  
        
             case 7 :
                    this.setIPP_ESTAB_AOM((String)value);
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
                    this.setIPP_PDT((String)value);
	            return;  
        
             case 12 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 13 :
                    this.setIPM_PDT((String)value);
	            return;  
        
             case 14 :
                    this.setIPM_ITEM_NM((String)value);
	            return;  
        
             case 15 :
                    this.setIPM_ESTAB_AOM((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_IPTHelper.toXML(this);
  }
  
}
