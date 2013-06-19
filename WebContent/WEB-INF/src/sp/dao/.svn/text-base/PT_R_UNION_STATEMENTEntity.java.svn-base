

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_UNION_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ASC_TMP_WRT_NUM:VARCHAR2(12):  
*               HANDED_TMP_WRT_NUM:VARCHAR2(12):  
*               MOT_STE:VARCHAR2(6):  
*               ESTA_TMP_WRT_NUM:VARCHAR2(12):  
*               ESTA_ADDR_TEL_NUM:VARCHAR2(17):  
*               ESTA_NAME:VARCHAR2(50):  
*               ESTA_REP_NM_KOR:VARCHAR2(20):  
*               ESTA_REP_NM_HAN:VARCHAR2(20):  
*               ESTA_MANA_NUM:VARCHAR2(13):  
*               ESTA_ADDR_ADDR:VARCHAR2(120):  
*               ESTA_ADDR_POST_NUM:VARCHAR2(6):  
*               ESTA_ADDR_DETAIL_ADDR:VARCHAR2(120):  
*               ESTA_WRT_NUM:VARCHAR2(12):  
*               DEFI_STE:VARCHAR2(1):  
*               PROC_LIM:VARCHAR2(8):  
*               PROC_TIME:VARCHAR2(6):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_TIME:VARCHAR2(6):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN:VARCHAR2(1):  
*               REGIST_YMD:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_UNION_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String ASC_TMP_WRT_NUM;
  
     private String HANDED_TMP_WRT_NUM;
  
     private String MOT_STE;
  
     private String ESTA_TMP_WRT_NUM;
  
     private String ESTA_ADDR_TEL_NUM;
  
     private String ESTA_NAME;
  
     private String ESTA_REP_NM_KOR;
  
     private String ESTA_REP_NM_HAN;
  
     private String ESTA_MANA_NUM;
  
     private String ESTA_ADDR_ADDR;
  
     private String ESTA_ADDR_POST_NUM;
  
     private String ESTA_ADDR_DETAIL_ADDR;
  
     private String ESTA_WRT_NUM;
  
     private String DEFI_STE;
  
     private String PROC_LIM;
  
     private String PROC_TIME;
  
     private String RECV_DT;
  
     private String RECV_TIME;
  
     private String BUSS_YMD;
  
     private String FOREIGN;
  
     private String REGIST_YMD;
  

//생성자를 만든다
    public PT_R_UNION_STATEMENTEntity(){
    }
    
    
    public PT_R_UNION_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_UNION_STATEMENTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.ASC_TMP_WRT_NUM =request.getParameter("ASC_TMP_WRT_NUM");
		this.HANDED_TMP_WRT_NUM =request.getParameter("HANDED_TMP_WRT_NUM");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.ESTA_TMP_WRT_NUM =request.getParameter("ESTA_TMP_WRT_NUM");
		this.ESTA_ADDR_TEL_NUM =request.getParameter("ESTA_ADDR_TEL_NUM");
		this.ESTA_NAME =request.getParameter("ESTA_NAME");
		this.ESTA_REP_NM_KOR =request.getParameter("ESTA_REP_NM_KOR");
		this.ESTA_REP_NM_HAN =request.getParameter("ESTA_REP_NM_HAN");
		this.ESTA_MANA_NUM =request.getParameter("ESTA_MANA_NUM");
		this.ESTA_ADDR_ADDR =request.getParameter("ESTA_ADDR_ADDR");
		this.ESTA_ADDR_POST_NUM =request.getParameter("ESTA_ADDR_POST_NUM");
		this.ESTA_ADDR_DETAIL_ADDR =request.getParameter("ESTA_ADDR_DETAIL_ADDR");
		this.ESTA_WRT_NUM =request.getParameter("ESTA_WRT_NUM");
		this.DEFI_STE =request.getParameter("DEFI_STE");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.PROC_TIME =request.getParameter("PROC_TIME");
		this.RECV_DT =request.getParameter("RECV_DT");
		this.RECV_TIME =request.getParameter("RECV_TIME");
		this.BUSS_YMD =request.getParameter("BUSS_YMD");
		this.FOREIGN =request.getParameter("FOREIGN");
		this.REGIST_YMD =request.getParameter("REGIST_YMD");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.ASC_TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "ASC_TMP_WRT_NUM");
		this.HANDED_TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "HANDED_TMP_WRT_NUM");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.ESTA_TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "ESTA_TMP_WRT_NUM");
		this.ESTA_ADDR_TEL_NUM =KJFMi.dsGet(ds, arg_row, "ESTA_ADDR_TEL_NUM");
		this.ESTA_NAME =KJFMi.dsGet(ds, arg_row, "ESTA_NAME");
		this.ESTA_REP_NM_KOR =KJFMi.dsGet(ds, arg_row, "ESTA_REP_NM_KOR");
		this.ESTA_REP_NM_HAN =KJFMi.dsGet(ds, arg_row, "ESTA_REP_NM_HAN");
		this.ESTA_MANA_NUM =KJFMi.dsGet(ds, arg_row, "ESTA_MANA_NUM");
		this.ESTA_ADDR_ADDR =KJFMi.dsGet(ds, arg_row, "ESTA_ADDR_ADDR");
		this.ESTA_ADDR_POST_NUM =KJFMi.dsGet(ds, arg_row, "ESTA_ADDR_POST_NUM");
		this.ESTA_ADDR_DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "ESTA_ADDR_DETAIL_ADDR");
		this.ESTA_WRT_NUM =KJFMi.dsGet(ds, arg_row, "ESTA_WRT_NUM");
		this.DEFI_STE =KJFMi.dsGet(ds, arg_row, "DEFI_STE");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.PROC_TIME =KJFMi.dsGet(ds, arg_row, "PROC_TIME");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.RECV_TIME =KJFMi.dsGet(ds, arg_row, "RECV_TIME");
		this.BUSS_YMD =KJFMi.dsGet(ds, arg_row, "BUSS_YMD");
		this.FOREIGN =KJFMi.dsGet(ds, arg_row, "FOREIGN");
		this.REGIST_YMD =KJFMi.dsGet(ds, arg_row, "REGIST_YMD");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
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
  
     public String getASC_TMP_WRT_NUM(){
             return ASC_TMP_WRT_NUM;
     };
  
     public String getHANDED_TMP_WRT_NUM(){
             return HANDED_TMP_WRT_NUM;
     };
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  
     public String getESTA_TMP_WRT_NUM(){
             return ESTA_TMP_WRT_NUM;
     };
  
     public String getESTA_ADDR_TEL_NUM(){
             return ESTA_ADDR_TEL_NUM;
     };
  
     public String getESTA_NAME(){
             return ESTA_NAME;
     };
  
     public String getESTA_REP_NM_KOR(){
             return ESTA_REP_NM_KOR;
     };
  
     public String getESTA_REP_NM_HAN(){
             return ESTA_REP_NM_HAN;
     };
  
     public String getESTA_MANA_NUM(){
             return ESTA_MANA_NUM;
     };
  
     public String getESTA_ADDR_ADDR(){
             return ESTA_ADDR_ADDR;
     };
  
     public String getESTA_ADDR_POST_NUM(){
             return ESTA_ADDR_POST_NUM;
     };
  
     public String getESTA_ADDR_DETAIL_ADDR(){
             return ESTA_ADDR_DETAIL_ADDR;
     };
  
     public String getESTA_WRT_NUM(){
             return ESTA_WRT_NUM;
     };
  
     public String getDEFI_STE(){
             return DEFI_STE;
     };
  
     public String getPROC_LIM(){
             return PROC_LIM;
     };
  
     public String getPROC_TIME(){
             return PROC_TIME;
     };
  
     public String getRECV_DT(){
             return RECV_DT;
     };
  
     public String getRECV_TIME(){
             return RECV_TIME;
     };
  
     public String getBUSS_YMD(){
             return BUSS_YMD;
     };
  
     public String getFOREIGN(){
             return FOREIGN;
     };
  
     public String getREGIST_YMD(){
             return REGIST_YMD;
     };
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
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
  
     public void setASC_TMP_WRT_NUM(String ASC_TMP_WRT_NUM){
            this.ASC_TMP_WRT_NUM=ASC_TMP_WRT_NUM;
     };
  
     public void setHANDED_TMP_WRT_NUM(String HANDED_TMP_WRT_NUM){
            this.HANDED_TMP_WRT_NUM=HANDED_TMP_WRT_NUM;
     };
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
     public void setESTA_TMP_WRT_NUM(String ESTA_TMP_WRT_NUM){
            this.ESTA_TMP_WRT_NUM=ESTA_TMP_WRT_NUM;
     };
  
     public void setESTA_ADDR_TEL_NUM(String ESTA_ADDR_TEL_NUM){
            this.ESTA_ADDR_TEL_NUM=ESTA_ADDR_TEL_NUM;
     };
  
     public void setESTA_NAME(String ESTA_NAME){
            this.ESTA_NAME=ESTA_NAME;
     };
  
     public void setESTA_REP_NM_KOR(String ESTA_REP_NM_KOR){
            this.ESTA_REP_NM_KOR=ESTA_REP_NM_KOR;
     };
  
     public void setESTA_REP_NM_HAN(String ESTA_REP_NM_HAN){
            this.ESTA_REP_NM_HAN=ESTA_REP_NM_HAN;
     };
  
     public void setESTA_MANA_NUM(String ESTA_MANA_NUM){
            this.ESTA_MANA_NUM=ESTA_MANA_NUM;
     };
  
     public void setESTA_ADDR_ADDR(String ESTA_ADDR_ADDR){
            this.ESTA_ADDR_ADDR=ESTA_ADDR_ADDR;
     };
  
     public void setESTA_ADDR_POST_NUM(String ESTA_ADDR_POST_NUM){
            this.ESTA_ADDR_POST_NUM=ESTA_ADDR_POST_NUM;
     };
  
     public void setESTA_ADDR_DETAIL_ADDR(String ESTA_ADDR_DETAIL_ADDR){
            this.ESTA_ADDR_DETAIL_ADDR=ESTA_ADDR_DETAIL_ADDR;
     };
  
     public void setESTA_WRT_NUM(String ESTA_WRT_NUM){
            this.ESTA_WRT_NUM=ESTA_WRT_NUM;
     };
  
     public void setDEFI_STE(String DEFI_STE){
            this.DEFI_STE=DEFI_STE;
     };
  
     public void setPROC_LIM(String PROC_LIM){
            this.PROC_LIM=PROC_LIM;
     };
  
     public void setPROC_TIME(String PROC_TIME){
            this.PROC_TIME=PROC_TIME;
     };
  
     public void setRECV_DT(String RECV_DT){
            this.RECV_DT=RECV_DT;
     };
  
     public void setRECV_TIME(String RECV_TIME){
            this.RECV_TIME=RECV_TIME;
     };
  
     public void setBUSS_YMD(String BUSS_YMD){
            this.BUSS_YMD=BUSS_YMD;
     };
  
     public void setFOREIGN(String FOREIGN){
            this.FOREIGN=FOREIGN;
     };
  
     public void setREGIST_YMD(String REGIST_YMD){
            this.REGIST_YMD=REGIST_YMD;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("ASC_TMP_WRT_NUM:"+ this.getASC_TMP_WRT_NUM()+"\n");
      
      strB.append("HANDED_TMP_WRT_NUM:"+ this.getHANDED_TMP_WRT_NUM()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("ESTA_TMP_WRT_NUM:"+ this.getESTA_TMP_WRT_NUM()+"\n");
      
      strB.append("ESTA_ADDR_TEL_NUM:"+ this.getESTA_ADDR_TEL_NUM()+"\n");
      
      strB.append("ESTA_NAME:"+ this.getESTA_NAME()+"\n");
      
      strB.append("ESTA_REP_NM_KOR:"+ this.getESTA_REP_NM_KOR()+"\n");
      
      strB.append("ESTA_REP_NM_HAN:"+ this.getESTA_REP_NM_HAN()+"\n");
      
      strB.append("ESTA_MANA_NUM:"+ this.getESTA_MANA_NUM()+"\n");
      
      strB.append("ESTA_ADDR_ADDR:"+ this.getESTA_ADDR_ADDR()+"\n");
      
      strB.append("ESTA_ADDR_POST_NUM:"+ this.getESTA_ADDR_POST_NUM()+"\n");
      
      strB.append("ESTA_ADDR_DETAIL_ADDR:"+ this.getESTA_ADDR_DETAIL_ADDR()+"\n");
      
      strB.append("ESTA_WRT_NUM:"+ this.getESTA_WRT_NUM()+"\n");
      
      strB.append("DEFI_STE:"+ this.getDEFI_STE()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("PROC_TIME:"+ this.getPROC_TIME()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("RECV_TIME:"+ this.getRECV_TIME()+"\n");
      
      strB.append("BUSS_YMD:"+ this.getBUSS_YMD()+"\n");
      
      strB.append("FOREIGN:"+ this.getFOREIGN()+"\n");
      
      strB.append("REGIST_YMD:"+ this.getREGIST_YMD()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_UNION_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_UNION_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_UNION_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_UNION_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_UNION_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_UNION_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_UNION_STATEMENTEntity newEnt = new PT_R_UNION_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setASC_TMP_WRT_NUM(this.getASC_TMP_WRT_NUM());
         
          newEnt.setHANDED_TMP_WRT_NUM(this.getHANDED_TMP_WRT_NUM());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setESTA_TMP_WRT_NUM(this.getESTA_TMP_WRT_NUM());
         
          newEnt.setESTA_ADDR_TEL_NUM(this.getESTA_ADDR_TEL_NUM());
         
          newEnt.setESTA_NAME(this.getESTA_NAME());
         
          newEnt.setESTA_REP_NM_KOR(this.getESTA_REP_NM_KOR());
         
          newEnt.setESTA_REP_NM_HAN(this.getESTA_REP_NM_HAN());
         
          newEnt.setESTA_MANA_NUM(this.getESTA_MANA_NUM());
         
          newEnt.setESTA_ADDR_ADDR(this.getESTA_ADDR_ADDR());
         
          newEnt.setESTA_ADDR_POST_NUM(this.getESTA_ADDR_POST_NUM());
         
          newEnt.setESTA_ADDR_DETAIL_ADDR(this.getESTA_ADDR_DETAIL_ADDR());
         
          newEnt.setESTA_WRT_NUM(this.getESTA_WRT_NUM());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setPROC_TIME(this.getPROC_TIME());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setRECV_TIME(this.getRECV_TIME());
         
          newEnt.setBUSS_YMD(this.getBUSS_YMD());
         
          newEnt.setFOREIGN(this.getFOREIGN());
         
          newEnt.setREGIST_YMD(this.getREGIST_YMD());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_UNION_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSIDO_CODE();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getASC_TMP_WRT_NUM();
        
             case 7 :
                 return  this.getHANDED_TMP_WRT_NUM();
        
             case 8 :
                 return  this.getMOT_STE();
        
             case 9 :
                 return  this.getESTA_TMP_WRT_NUM();
        
             case 10 :
                 return  this.getESTA_ADDR_TEL_NUM();
        
             case 11 :
                 return  this.getESTA_NAME();
        
             case 12 :
                 return  this.getESTA_REP_NM_KOR();
        
             case 13 :
                 return  this.getESTA_REP_NM_HAN();
        
             case 14 :
                 return  this.getESTA_MANA_NUM();
        
             case 15 :
                 return  this.getESTA_ADDR_ADDR();
        
             case 16 :
                 return  this.getESTA_ADDR_POST_NUM();
        
             case 17 :
                 return  this.getESTA_ADDR_DETAIL_ADDR();
        
             case 18 :
                 return  this.getESTA_WRT_NUM();
        
             case 19 :
                 return  this.getDEFI_STE();
        
             case 20 :
                 return  this.getPROC_LIM();
        
             case 21 :
                 return  this.getPROC_TIME();
        
             case 22 :
                 return  this.getRECV_DT();
        
             case 23 :
                 return  this.getRECV_TIME();
        
             case 24 :
                 return  this.getBUSS_YMD();
        
             case 25 :
                 return  this.getFOREIGN();
        
             case 26 :
                 return  this.getREGIST_YMD();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_UNION_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSIDO_CODE((String)value);
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
                    this.setASC_TMP_WRT_NUM((String)value);
	            return;  
        
             case 7 :
                    this.setHANDED_TMP_WRT_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 9 :
                    this.setESTA_TMP_WRT_NUM((String)value);
	            return;  
        
             case 10 :
                    this.setESTA_ADDR_TEL_NUM((String)value);
	            return;  
        
             case 11 :
                    this.setESTA_NAME((String)value);
	            return;  
        
             case 12 :
                    this.setESTA_REP_NM_KOR((String)value);
	            return;  
        
             case 13 :
                    this.setESTA_REP_NM_HAN((String)value);
	            return;  
        
             case 14 :
                    this.setESTA_MANA_NUM((String)value);
	            return;  
        
             case 15 :
                    this.setESTA_ADDR_ADDR((String)value);
	            return;  
        
             case 16 :
                    this.setESTA_ADDR_POST_NUM((String)value);
	            return;  
        
             case 17 :
                    this.setESTA_ADDR_DETAIL_ADDR((String)value);
	            return;  
        
             case 18 :
                    this.setESTA_WRT_NUM((String)value);
	            return;  
        
             case 19 :
                    this.setDEFI_STE((String)value);
	            return;  
        
             case 20 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 21 :
                    this.setPROC_TIME((String)value);
	            return;  
        
             case 22 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 23 :
                    this.setRECV_TIME((String)value);
	            return;  
        
             case 24 :
                    this.setBUSS_YMD((String)value);
	            return;  
        
             case 25 :
                    this.setFOREIGN((String)value);
	            return;  
        
             case 26 :
                    this.setREGIST_YMD((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_UNION_STATEMENTHelper.toXML(this);
  }
  
}
