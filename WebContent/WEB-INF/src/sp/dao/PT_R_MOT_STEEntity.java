

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_MOT_STE
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DETAILWORK1:VARCHAR2(1):  
*               DETAILWORK2:VARCHAR2(1):  
*               DETAILWORK3:VARCHAR2(1):  
*               DETAILWORK4:VARCHAR2(1):  
*               DETAILWORK5:VARCHAR2(1):  
*               DETAILWORK6:VARCHAR2(1):  
*               DETAILWORK7:VARCHAR2(1):  
*               DETAILWORK8:VARCHAR2(1):  
*               DETAILWORK9:VARCHAR2(1):  
*               DETAILWORK10:VARCHAR2(1):  
*               DETAILWORK11:VARCHAR2(1):  
*               DETAILWORK12:VARCHAR2(1):  
*               DETAILWORK13:VARCHAR2(1):  
*               DETAILWORK14:VARCHAR2(1):  
*               DETAILWORK15:VARCHAR2(1):  
*               DETAILWORK16:VARCHAR2(1):  
*               RECV_NUM:VARCHAR2(20):  
*               MOT_PROC:VARCHAR2(2):  
*               SIDO_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_MOT_STEEntity extends ValueObject{

  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  
     private String DETAILWORK1;
  
     private String DETAILWORK2;
  
     private String DETAILWORK3;
  
     private String DETAILWORK4;
  
     private String DETAILWORK5;
  
     private String DETAILWORK6;
  
     private String DETAILWORK7;
  
     private String DETAILWORK8;
  
     private String DETAILWORK9;
  
     private String DETAILWORK10;
  
     private String DETAILWORK11;
  
     private String DETAILWORK12;
  
     private String DETAILWORK13;
  
     private String DETAILWORK14;
  
     private String DETAILWORK15;
  
     private String DETAILWORK16;
  
     private String RECV_NUM;
  
     private String MOT_PROC;
  
     private String SIDO_CODE;
  

//생성자를 만든다
    public PT_R_MOT_STEEntity(){
    }
    
    
    public PT_R_MOT_STEEntity(String CHGBRE_SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_MOT_STEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CHGBRE_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CHGBRE_SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CHGBRE_SEQ =request.getParameter("CHGBRE_SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.DETAILWORK1 =request.getParameter("DETAILWORK1");
		this.DETAILWORK2 =request.getParameter("DETAILWORK2");
		this.DETAILWORK3 =request.getParameter("DETAILWORK3");
		this.DETAILWORK4 =request.getParameter("DETAILWORK4");
		this.DETAILWORK5 =request.getParameter("DETAILWORK5");
		this.DETAILWORK6 =request.getParameter("DETAILWORK6");
		this.DETAILWORK7 =request.getParameter("DETAILWORK7");
		this.DETAILWORK8 =request.getParameter("DETAILWORK8");
		this.DETAILWORK9 =request.getParameter("DETAILWORK9");
		this.DETAILWORK10 =request.getParameter("DETAILWORK10");
		this.DETAILWORK11 =request.getParameter("DETAILWORK11");
		this.DETAILWORK12 =request.getParameter("DETAILWORK12");
		this.DETAILWORK13 =request.getParameter("DETAILWORK13");
		this.DETAILWORK14 =request.getParameter("DETAILWORK14");
		this.DETAILWORK15 =request.getParameter("DETAILWORK15");
		this.DETAILWORK16 =request.getParameter("DETAILWORK16");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.MOT_PROC =request.getParameter("MOT_PROC");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DETAILWORK1 =KJFMi.dsGet(ds, arg_row, "DETAILWORK1");
		this.DETAILWORK2 =KJFMi.dsGet(ds, arg_row, "DETAILWORK2");
		this.DETAILWORK3 =KJFMi.dsGet(ds, arg_row, "DETAILWORK3");
		this.DETAILWORK4 =KJFMi.dsGet(ds, arg_row, "DETAILWORK4");
		this.DETAILWORK5 =KJFMi.dsGet(ds, arg_row, "DETAILWORK5");
		this.DETAILWORK6 =KJFMi.dsGet(ds, arg_row, "DETAILWORK6");
		this.DETAILWORK7 =KJFMi.dsGet(ds, arg_row, "DETAILWORK7");
		this.DETAILWORK8 =KJFMi.dsGet(ds, arg_row, "DETAILWORK8");
		this.DETAILWORK9 =KJFMi.dsGet(ds, arg_row, "DETAILWORK9");
		this.DETAILWORK10 =KJFMi.dsGet(ds, arg_row, "DETAILWORK10");
		this.DETAILWORK11 =KJFMi.dsGet(ds, arg_row, "DETAILWORK11");
		this.DETAILWORK12 =KJFMi.dsGet(ds, arg_row, "DETAILWORK12");
		this.DETAILWORK13 =KJFMi.dsGet(ds, arg_row, "DETAILWORK13");
		this.DETAILWORK14 =KJFMi.dsGet(ds, arg_row, "DETAILWORK14");
		this.DETAILWORK15 =KJFMi.dsGet(ds, arg_row, "DETAILWORK15");
		this.DETAILWORK16 =KJFMi.dsGet(ds, arg_row, "DETAILWORK16");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.MOT_PROC =KJFMi.dsGet(ds, arg_row, "MOT_PROC");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getDETAILWORK1(){
             return DETAILWORK1;
     };
  
     public String getDETAILWORK2(){
             return DETAILWORK2;
     };
  
     public String getDETAILWORK3(){
             return DETAILWORK3;
     };
  
     public String getDETAILWORK4(){
             return DETAILWORK4;
     };
  
     public String getDETAILWORK5(){
             return DETAILWORK5;
     };
  
     public String getDETAILWORK6(){
             return DETAILWORK6;
     };
  
     public String getDETAILWORK7(){
             return DETAILWORK7;
     };
  
     public String getDETAILWORK8(){
             return DETAILWORK8;
     };
  
     public String getDETAILWORK9(){
             return DETAILWORK9;
     };
  
     public String getDETAILWORK10(){
             return DETAILWORK10;
     };
  
     public String getDETAILWORK11(){
             return DETAILWORK11;
     };
  
     public String getDETAILWORK12(){
             return DETAILWORK12;
     };
  
     public String getDETAILWORK13(){
             return DETAILWORK13;
     };
  
     public String getDETAILWORK14(){
             return DETAILWORK14;
     };
  
     public String getDETAILWORK15(){
             return DETAILWORK15;
     };
  
     public String getDETAILWORK16(){
             return DETAILWORK16;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getMOT_PROC(){
             return MOT_PROC;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  

//Setter 함수를 만든다
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setDETAILWORK1(String DETAILWORK1){
            this.DETAILWORK1=DETAILWORK1;
     };
  
     public void setDETAILWORK2(String DETAILWORK2){
            this.DETAILWORK2=DETAILWORK2;
     };
  
     public void setDETAILWORK3(String DETAILWORK3){
            this.DETAILWORK3=DETAILWORK3;
     };
  
     public void setDETAILWORK4(String DETAILWORK4){
            this.DETAILWORK4=DETAILWORK4;
     };
  
     public void setDETAILWORK5(String DETAILWORK5){
            this.DETAILWORK5=DETAILWORK5;
     };
  
     public void setDETAILWORK6(String DETAILWORK6){
            this.DETAILWORK6=DETAILWORK6;
     };
  
     public void setDETAILWORK7(String DETAILWORK7){
            this.DETAILWORK7=DETAILWORK7;
     };
  
     public void setDETAILWORK8(String DETAILWORK8){
            this.DETAILWORK8=DETAILWORK8;
     };
  
     public void setDETAILWORK9(String DETAILWORK9){
            this.DETAILWORK9=DETAILWORK9;
     };
  
     public void setDETAILWORK10(String DETAILWORK10){
            this.DETAILWORK10=DETAILWORK10;
     };
  
     public void setDETAILWORK11(String DETAILWORK11){
            this.DETAILWORK11=DETAILWORK11;
     };
  
     public void setDETAILWORK12(String DETAILWORK12){
            this.DETAILWORK12=DETAILWORK12;
     };
  
     public void setDETAILWORK13(String DETAILWORK13){
            this.DETAILWORK13=DETAILWORK13;
     };
  
     public void setDETAILWORK14(String DETAILWORK14){
            this.DETAILWORK14=DETAILWORK14;
     };
  
     public void setDETAILWORK15(String DETAILWORK15){
            this.DETAILWORK15=DETAILWORK15;
     };
  
     public void setDETAILWORK16(String DETAILWORK16){
            this.DETAILWORK16=DETAILWORK16;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setMOT_PROC(String MOT_PROC){
            this.MOT_PROC=MOT_PROC;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("DETAILWORK1:"+ this.getDETAILWORK1()+"\n");
      
      strB.append("DETAILWORK2:"+ this.getDETAILWORK2()+"\n");
      
      strB.append("DETAILWORK3:"+ this.getDETAILWORK3()+"\n");
      
      strB.append("DETAILWORK4:"+ this.getDETAILWORK4()+"\n");
      
      strB.append("DETAILWORK5:"+ this.getDETAILWORK5()+"\n");
      
      strB.append("DETAILWORK6:"+ this.getDETAILWORK6()+"\n");
      
      strB.append("DETAILWORK7:"+ this.getDETAILWORK7()+"\n");
      
      strB.append("DETAILWORK8:"+ this.getDETAILWORK8()+"\n");
      
      strB.append("DETAILWORK9:"+ this.getDETAILWORK9()+"\n");
      
      strB.append("DETAILWORK10:"+ this.getDETAILWORK10()+"\n");
      
      strB.append("DETAILWORK11:"+ this.getDETAILWORK11()+"\n");
      
      strB.append("DETAILWORK12:"+ this.getDETAILWORK12()+"\n");
      
      strB.append("DETAILWORK13:"+ this.getDETAILWORK13()+"\n");
      
      strB.append("DETAILWORK14:"+ this.getDETAILWORK14()+"\n");
      
      strB.append("DETAILWORK15:"+ this.getDETAILWORK15()+"\n");
      
      strB.append("DETAILWORK16:"+ this.getDETAILWORK16()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("MOT_PROC:"+ this.getMOT_PROC()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_MOT_STEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_MOT_STEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_MOT_STEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_MOT_STEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_MOT_STEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_MOT_STEEntity();
  }

  public ValueObject getClone(){
         PT_R_MOT_STEEntity newEnt = new PT_R_MOT_STEEntity();
	 
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDETAILWORK1(this.getDETAILWORK1());
         
          newEnt.setDETAILWORK2(this.getDETAILWORK2());
         
          newEnt.setDETAILWORK3(this.getDETAILWORK3());
         
          newEnt.setDETAILWORK4(this.getDETAILWORK4());
         
          newEnt.setDETAILWORK5(this.getDETAILWORK5());
         
          newEnt.setDETAILWORK6(this.getDETAILWORK6());
         
          newEnt.setDETAILWORK7(this.getDETAILWORK7());
         
          newEnt.setDETAILWORK8(this.getDETAILWORK8());
         
          newEnt.setDETAILWORK9(this.getDETAILWORK9());
         
          newEnt.setDETAILWORK10(this.getDETAILWORK10());
         
          newEnt.setDETAILWORK11(this.getDETAILWORK11());
         
          newEnt.setDETAILWORK12(this.getDETAILWORK12());
         
          newEnt.setDETAILWORK13(this.getDETAILWORK13());
         
          newEnt.setDETAILWORK14(this.getDETAILWORK14());
         
          newEnt.setDETAILWORK15(this.getDETAILWORK15());
         
          newEnt.setDETAILWORK16(this.getDETAILWORK16());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setMOT_PROC(this.getMOT_PROC());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_MOT_STEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCHGBRE_SEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getDETAILWORK1();
        
             case 4 :
                 return  this.getDETAILWORK2();
        
             case 5 :
                 return  this.getDETAILWORK3();
        
             case 6 :
                 return  this.getDETAILWORK4();
        
             case 7 :
                 return  this.getDETAILWORK5();
        
             case 8 :
                 return  this.getDETAILWORK6();
        
             case 9 :
                 return  this.getDETAILWORK7();
        
             case 10 :
                 return  this.getDETAILWORK8();
        
             case 11 :
                 return  this.getDETAILWORK9();
        
             case 12 :
                 return  this.getDETAILWORK10();
        
             case 13 :
                 return  this.getDETAILWORK11();
        
             case 14 :
                 return  this.getDETAILWORK12();
        
             case 15 :
                 return  this.getDETAILWORK13();
        
             case 16 :
                 return  this.getDETAILWORK14();
        
             case 17 :
                 return  this.getDETAILWORK15();
        
             case 18 :
                 return  this.getDETAILWORK16();
        
             case 19 :
                 return  this.getRECV_NUM();
        
             case 20 :
                 return  this.getMOT_PROC();
        
             case 21 :
                 return  this.getSIDO_CODE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_MOT_STEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setDETAILWORK1((String)value);
	            return;  
        
             case 4 :
                    this.setDETAILWORK2((String)value);
	            return;  
        
             case 5 :
                    this.setDETAILWORK3((String)value);
	            return;  
        
             case 6 :
                    this.setDETAILWORK4((String)value);
	            return;  
        
             case 7 :
                    this.setDETAILWORK5((String)value);
	            return;  
        
             case 8 :
                    this.setDETAILWORK6((String)value);
	            return;  
        
             case 9 :
                    this.setDETAILWORK7((String)value);
	            return;  
        
             case 10 :
                    this.setDETAILWORK8((String)value);
	            return;  
        
             case 11 :
                    this.setDETAILWORK9((String)value);
	            return;  
        
             case 12 :
                    this.setDETAILWORK10((String)value);
	            return;  
        
             case 13 :
                    this.setDETAILWORK11((String)value);
	            return;  
        
             case 14 :
                    this.setDETAILWORK12((String)value);
	            return;  
        
             case 15 :
                    this.setDETAILWORK13((String)value);
	            return;  
        
             case 16 :
                    this.setDETAILWORK14((String)value);
	            return;  
        
             case 17 :
                    this.setDETAILWORK15((String)value);
	            return;  
        
             case 18 :
                    this.setDETAILWORK16((String)value);
	            return;  
        
             case 19 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 20 :
                    this.setMOT_PROC((String)value);
	            return;  
        
             case 21 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_MOT_STEHelper.toXML(this);
  }
  
}
