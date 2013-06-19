

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_ONLY_LINE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               ITEM_NM:VARCHAR2(100):  
*               LINE_QTT:NUMBER(20):  
*               JOINT_CIR:VARCHAR2(50):  
*               JOINT_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               JOINT_ORG_NUM:VARCHAR2(20):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_ONLY_LINEEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String ITEM_NM;
  
     private String LINE_QTT;
  
     private String JOINT_CIR;
  
     private String JOINT_DT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String JOINT_ORG_NUM;
  

//생성자를 만든다
    public PT_C_RES_ONLY_LINEEntity(){
    }
    
    
    public PT_C_RES_ONLY_LINEEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_ONLY_LINEEntity(ValueObject ent) throws Exception{
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
		this.LINE_QTT =request.getParameter("LINE_QTT");
		this.JOINT_CIR =request.getParameter("JOINT_CIR");
		this.JOINT_DT =request.getParameter("JOINT_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.JOINT_ORG_NUM =request.getParameter("JOINT_ORG_NUM");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.ITEM_NM =KJFMi.dsGet(ds, arg_row, "ITEM_NM");
		this.LINE_QTT =KJFMi.dsGet(ds, arg_row, "LINE_QTT");
		this.JOINT_CIR =KJFMi.dsGet(ds, arg_row, "JOINT_CIR");
		this.JOINT_DT =KJFMi.dsGet(ds, arg_row, "JOINT_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.JOINT_ORG_NUM =KJFMi.dsGet(ds, arg_row, "JOINT_ORG_NUM");
				
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
  
     public String getLINE_QTT(){
             return LINE_QTT;
     };
  
     public String getJOINT_CIR(){
             return JOINT_CIR;
     };
  
     public String getJOINT_DT(){
             return JOINT_DT;
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
  
     public String getJOINT_ORG_NUM(){
             return JOINT_ORG_NUM;
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
  
     public void setLINE_QTT(String LINE_QTT){
            this.LINE_QTT=LINE_QTT;
     };
  
     public void setJOINT_CIR(String JOINT_CIR){
            this.JOINT_CIR=JOINT_CIR;
     };
  
     public void setJOINT_DT(String JOINT_DT){
            this.JOINT_DT=JOINT_DT;
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
  
     public void setJOINT_ORG_NUM(String JOINT_ORG_NUM){
            this.JOINT_ORG_NUM=JOINT_ORG_NUM;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("ITEM_NM:"+ this.getITEM_NM()+"\n");
      
      strB.append("LINE_QTT:"+ this.getLINE_QTT()+"\n");
      
      strB.append("JOINT_CIR:"+ this.getJOINT_CIR()+"\n");
      
      strB.append("JOINT_DT:"+ this.getJOINT_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("JOINT_ORG_NUM:"+ this.getJOINT_ORG_NUM()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_ONLY_LINEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_ONLY_LINEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_ONLY_LINEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_ONLY_LINEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_ONLY_LINEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_ONLY_LINEEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_ONLY_LINEEntity newEnt = new PT_C_RES_ONLY_LINEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setITEM_NM(this.getITEM_NM());
         
          newEnt.setLINE_QTT(this.getLINE_QTT());
         
          newEnt.setJOINT_CIR(this.getJOINT_CIR());
         
          newEnt.setJOINT_DT(this.getJOINT_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setJOINT_ORG_NUM(this.getJOINT_ORG_NUM());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_ONLY_LINEHelper.fieldMap.get(key);
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
                 return  this.getLINE_QTT();
        
             case 6 :
                 return  this.getJOINT_CIR();
        
             case 7 :
                 return  this.getJOINT_DT();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getSIGUNGU_CODE();
        
             case 12 :
                 return  this.getJOINT_ORG_NUM();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_ONLY_LINEHelper.fieldMap.get(key);
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
                    this.setLINE_QTT((String)value);
	            return;  
        
             case 6 :
                    this.setJOINT_CIR((String)value);
	            return;  
        
             case 7 :
                    this.setJOINT_DT((String)value);
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
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 12 :
                    this.setJOINT_ORG_NUM((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_ONLY_LINEHelper.toXML(this);
  }
  
}
