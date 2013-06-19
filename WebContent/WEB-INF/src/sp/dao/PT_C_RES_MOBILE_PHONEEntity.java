

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_MOBILE_PHONE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               SKT_QTT:NUMBER(10):  
*               SKT_AOM:NUMBER(20):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               KTF_QTT:NUMBER(10):  
*               KTF_AOM:NUMBER(20):  
*               LGT_QTT:NUMBER(10):  
*               LGT_AOM:NUMBER(20):  
*               QTT_010:NUMBER(10):  
*               AOM_010:NUMBER(20):  
*               WATT:VARCHAR2(12):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_MOBILE_PHONEEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String SKT_QTT;
  
     private String SKT_AOM;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String KTF_QTT;
  
     private String KTF_AOM;
  
     private String LGT_QTT;
  
     private String LGT_AOM;
  
     private String QTT_010;
  
     private String AOM_010;
  
     private String WATT;
  

//생성자를 만든다
    public PT_C_RES_MOBILE_PHONEEntity(){
    }
    
    
    public PT_C_RES_MOBILE_PHONEEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_MOBILE_PHONEEntity(ValueObject ent) throws Exception{
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
		this.SKT_QTT =request.getParameter("SKT_QTT");
		this.SKT_AOM =request.getParameter("SKT_AOM");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.KTF_QTT =request.getParameter("KTF_QTT");
		this.KTF_AOM =request.getParameter("KTF_AOM");
		this.LGT_QTT =request.getParameter("LGT_QTT");
		this.LGT_AOM =request.getParameter("LGT_AOM");
		this.QTT_010 =request.getParameter("QTT_010");
		this.AOM_010 =request.getParameter("AOM_010");
		this.WATT =request.getParameter("WATT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SKT_QTT =KJFMi.dsGet(ds, arg_row, "SKT_QTT");
		this.SKT_AOM =KJFMi.dsGet(ds, arg_row, "SKT_AOM");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.KTF_QTT =KJFMi.dsGet(ds, arg_row, "KTF_QTT");
		this.KTF_AOM =KJFMi.dsGet(ds, arg_row, "KTF_AOM");
		this.LGT_QTT =KJFMi.dsGet(ds, arg_row, "LGT_QTT");
		this.LGT_AOM =KJFMi.dsGet(ds, arg_row, "LGT_AOM");
		this.QTT_010 =KJFMi.dsGet(ds, arg_row, "QTT_010");
		this.AOM_010 =KJFMi.dsGet(ds, arg_row, "AOM_010");
		this.WATT =KJFMi.dsGet(ds, arg_row, "WATT");
				
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
  
     public String getSKT_QTT(){
             return SKT_QTT;
     };
  
     public String getSKT_AOM(){
             return SKT_AOM;
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
  
     public String getKTF_QTT(){
             return KTF_QTT;
     };
  
     public String getKTF_AOM(){
             return KTF_AOM;
     };
  
     public String getLGT_QTT(){
             return LGT_QTT;
     };
  
     public String getLGT_AOM(){
             return LGT_AOM;
     };
  
     public String getQTT_010(){
             return QTT_010;
     };
  
     public String getAOM_010(){
             return AOM_010;
     };
  
     public String getWATT(){
             return WATT;
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
  
     public void setSKT_QTT(String SKT_QTT){
            this.SKT_QTT=SKT_QTT;
     };
  
     public void setSKT_AOM(String SKT_AOM){
            this.SKT_AOM=SKT_AOM;
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
  
     public void setKTF_QTT(String KTF_QTT){
            this.KTF_QTT=KTF_QTT;
     };
  
     public void setKTF_AOM(String KTF_AOM){
            this.KTF_AOM=KTF_AOM;
     };
  
     public void setLGT_QTT(String LGT_QTT){
            this.LGT_QTT=LGT_QTT;
     };
  
     public void setLGT_AOM(String LGT_AOM){
            this.LGT_AOM=LGT_AOM;
     };
  
     public void setQTT_010(String QTT_010){
            this.QTT_010=QTT_010;
     };
  
     public void setAOM_010(String AOM_010){
            this.AOM_010=AOM_010;
     };
  
     public void setWATT(String WATT){
            this.WATT=WATT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SKT_QTT:"+ this.getSKT_QTT()+"\n");
      
      strB.append("SKT_AOM:"+ this.getSKT_AOM()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("KTF_QTT:"+ this.getKTF_QTT()+"\n");
      
      strB.append("KTF_AOM:"+ this.getKTF_AOM()+"\n");
      
      strB.append("LGT_QTT:"+ this.getLGT_QTT()+"\n");
      
      strB.append("LGT_AOM:"+ this.getLGT_AOM()+"\n");
      
      strB.append("QTT_010:"+ this.getQTT_010()+"\n");
      
      strB.append("AOM_010:"+ this.getAOM_010()+"\n");
      
      strB.append("WATT:"+ this.getWATT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_MOBILE_PHONEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_MOBILE_PHONEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_MOBILE_PHONEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_MOBILE_PHONEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_MOBILE_PHONEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_MOBILE_PHONEEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_MOBILE_PHONEEntity newEnt = new PT_C_RES_MOBILE_PHONEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSKT_QTT(this.getSKT_QTT());
         
          newEnt.setSKT_AOM(this.getSKT_AOM());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setKTF_QTT(this.getKTF_QTT());
         
          newEnt.setKTF_AOM(this.getKTF_AOM());
         
          newEnt.setLGT_QTT(this.getLGT_QTT());
         
          newEnt.setLGT_AOM(this.getLGT_AOM());
         
          newEnt.setQTT_010(this.getQTT_010());
         
          newEnt.setAOM_010(this.getAOM_010());
         
          newEnt.setWATT(this.getWATT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_MOBILE_PHONEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getSKT_QTT();
        
             case 5 :
                 return  this.getSKT_AOM();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getSIGUNGU_CODE();
        
             case 10 :
                 return  this.getKTF_QTT();
        
             case 11 :
                 return  this.getKTF_AOM();
        
             case 12 :
                 return  this.getLGT_QTT();
        
             case 13 :
                 return  this.getLGT_AOM();
        
             case 14 :
                 return  this.getQTT_010();
        
             case 15 :
                 return  this.getAOM_010();
        
             case 16 :
                 return  this.getWATT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_MOBILE_PHONEHelper.fieldMap.get(key);
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
                    this.setSKT_QTT((String)value);
	            return;  
        
             case 5 :
                    this.setSKT_AOM((String)value);
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
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 10 :
                    this.setKTF_QTT((String)value);
	            return;  
        
             case 11 :
                    this.setKTF_AOM((String)value);
	            return;  
        
             case 12 :
                    this.setLGT_QTT((String)value);
	            return;  
        
             case 13 :
                    this.setLGT_AOM((String)value);
	            return;  
        
             case 14 :
                    this.setQTT_010((String)value);
	            return;  
        
             case 15 :
                    this.setAOM_010((String)value);
	            return;  
        
             case 16 :
                    this.setWATT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_MOBILE_PHONEHelper.toXML(this);
  }
  
}
