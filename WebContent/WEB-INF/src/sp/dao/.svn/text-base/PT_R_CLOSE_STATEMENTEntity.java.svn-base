

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_CLOSE_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               RECV_DT:VARCHAR2(8):  
*               OFFI_PART:VARCHAR2(50):  
*               OFFI_PART_REBO_WRT_NUM:VARCHAR2(12):  
*               NAME:VARCHAR2(50):  
*               WRT_NUM:VARCHAR2(12):  
*               REP_NM_KOR:VARCHAR2(20):  
*               REP_NM_HAN:VARCHAR2(20):  
*               OFF_ADDR:VARCHAR2(200):  
*               TEL_NUM:VARCHAR2(17):  
*               C_COM_DT:VARCHAR2(8):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               C_COM_CAUSE:VARCHAR2(256):  
*               DEFI_STE:VARCHAR2(1):  
*               ADDR_ADDR:VARCHAR2(120):  
*               ADDR_POST_NUM:VARCHAR2(6):  
*               ADDR_DETAIL_ADDR:VARCHAR2(129):  
*               PROC_LIM:VARCHAR2(8):  
*               MEMO_CONT:VARCHAR2(256):  
*               MOT_STE:VARCHAR2(20):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DOC_CODE:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_CLOSE_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String COI_WRT_NUM;
  
     private String RECV_DT;
  
     private String OFFI_PART;
  
     private String OFFI_PART_REBO_WRT_NUM;
  
     private String NAME;
  
     private String WRT_NUM;
  
     private String REP_NM_KOR;
  
     private String REP_NM_HAN;
  
     private String OFF_ADDR;
  
     private String TEL_NUM;
  
     private String C_COM_DT;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String C_COM_CAUSE;
  
     private String DEFI_STE;
  
     private String ADDR_ADDR;
  
     private String ADDR_POST_NUM;
  
     private String ADDR_DETAIL_ADDR;
  
     private String PROC_LIM;
  
     private String MEMO_CONT;
  
     private String MOT_STE;
  
     private String TMP_WRT_NUM;
  
     private String DOC_CODE;
  

//생성자를 만든다
    public PT_R_CLOSE_STATEMENTEntity(){
    }
    
    
    public PT_R_CLOSE_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_CLOSE_STATEMENTEntity(ValueObject ent) throws Exception{
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
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		this.RECV_DT =request.getParameter("RECV_DT");
		this.OFFI_PART =request.getParameter("OFFI_PART");
		this.OFFI_PART_REBO_WRT_NUM =request.getParameter("OFFI_PART_REBO_WRT_NUM");
		this.NAME =request.getParameter("NAME");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.REP_NM_KOR =request.getParameter("REP_NM_KOR");
		this.REP_NM_HAN =request.getParameter("REP_NM_HAN");
		this.OFF_ADDR =request.getParameter("OFF_ADDR");
		this.TEL_NUM =request.getParameter("TEL_NUM");
		this.C_COM_DT =request.getParameter("C_COM_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.C_COM_CAUSE =request.getParameter("C_COM_CAUSE");
		this.DEFI_STE =request.getParameter("DEFI_STE");
		this.ADDR_ADDR =request.getParameter("ADDR_ADDR");
		this.ADDR_POST_NUM =request.getParameter("ADDR_POST_NUM");
		this.ADDR_DETAIL_ADDR =request.getParameter("ADDR_DETAIL_ADDR");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.DOC_CODE =request.getParameter("DOC_CODE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.OFFI_PART =KJFMi.dsGet(ds, arg_row, "OFFI_PART");
		this.OFFI_PART_REBO_WRT_NUM =KJFMi.dsGet(ds, arg_row, "OFFI_PART_REBO_WRT_NUM");
		this.NAME =KJFMi.dsGet(ds, arg_row, "NAME");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.REP_NM_KOR =KJFMi.dsGet(ds, arg_row, "REP_NM_KOR");
		this.REP_NM_HAN =KJFMi.dsGet(ds, arg_row, "REP_NM_HAN");
		this.OFF_ADDR =KJFMi.dsGet(ds, arg_row, "OFF_ADDR");
		this.TEL_NUM =KJFMi.dsGet(ds, arg_row, "TEL_NUM");
		this.C_COM_DT =KJFMi.dsGet(ds, arg_row, "C_COM_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.C_COM_CAUSE =KJFMi.dsGet(ds, arg_row, "C_COM_CAUSE");
		this.DEFI_STE =KJFMi.dsGet(ds, arg_row, "DEFI_STE");
		this.ADDR_ADDR =KJFMi.dsGet(ds, arg_row, "ADDR_ADDR");
		this.ADDR_POST_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_POST_NUM");
		this.ADDR_DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "ADDR_DETAIL_ADDR");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DOC_CODE =KJFMi.dsGet(ds, arg_row, "DOC_CODE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
     public String getRECV_DT(){
             return RECV_DT;
     };
  
     public String getOFFI_PART(){
             return OFFI_PART;
     };
  
     public String getOFFI_PART_REBO_WRT_NUM(){
             return OFFI_PART_REBO_WRT_NUM;
     };
  
     public String getNAME(){
             return NAME;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getREP_NM_KOR(){
             return REP_NM_KOR;
     };
  
     public String getREP_NM_HAN(){
             return REP_NM_HAN;
     };
  
     public String getOFF_ADDR(){
             return OFF_ADDR;
     };
  
     public String getTEL_NUM(){
             return TEL_NUM;
     };
  
     public String getC_COM_DT(){
             return C_COM_DT;
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
  
     public String getC_COM_CAUSE(){
             return C_COM_CAUSE;
     };
  
     public String getDEFI_STE(){
             return DEFI_STE;
     };
  
     public String getADDR_ADDR(){
             return ADDR_ADDR;
     };
  
     public String getADDR_POST_NUM(){
             return ADDR_POST_NUM;
     };
  
     public String getADDR_DETAIL_ADDR(){
             return ADDR_DETAIL_ADDR;
     };
  
     public String getPROC_LIM(){
             return PROC_LIM;
     };
  
     public String getMEMO_CONT(){
             return MEMO_CONT;
     };
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getDOC_CODE(){
             return DOC_CODE;
     };
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
     public void setRECV_DT(String RECV_DT){
            this.RECV_DT=RECV_DT;
     };
  
     public void setOFFI_PART(String OFFI_PART){
            this.OFFI_PART=OFFI_PART;
     };
  
     public void setOFFI_PART_REBO_WRT_NUM(String OFFI_PART_REBO_WRT_NUM){
            this.OFFI_PART_REBO_WRT_NUM=OFFI_PART_REBO_WRT_NUM;
     };
  
     public void setNAME(String NAME){
            this.NAME=NAME;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setREP_NM_KOR(String REP_NM_KOR){
            this.REP_NM_KOR=REP_NM_KOR;
     };
  
     public void setREP_NM_HAN(String REP_NM_HAN){
            this.REP_NM_HAN=REP_NM_HAN;
     };
  
     public void setOFF_ADDR(String OFF_ADDR){
            this.OFF_ADDR=OFF_ADDR;
     };
  
     public void setTEL_NUM(String TEL_NUM){
            this.TEL_NUM=TEL_NUM;
     };
  
     public void setC_COM_DT(String C_COM_DT){
            this.C_COM_DT=C_COM_DT;
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
  
     public void setC_COM_CAUSE(String C_COM_CAUSE){
            this.C_COM_CAUSE=C_COM_CAUSE;
     };
  
     public void setDEFI_STE(String DEFI_STE){
            this.DEFI_STE=DEFI_STE;
     };
  
     public void setADDR_ADDR(String ADDR_ADDR){
            this.ADDR_ADDR=ADDR_ADDR;
     };
  
     public void setADDR_POST_NUM(String ADDR_POST_NUM){
            this.ADDR_POST_NUM=ADDR_POST_NUM;
     };
  
     public void setADDR_DETAIL_ADDR(String ADDR_DETAIL_ADDR){
            this.ADDR_DETAIL_ADDR=ADDR_DETAIL_ADDR;
     };
  
     public void setPROC_LIM(String PROC_LIM){
            this.PROC_LIM=PROC_LIM;
     };
  
     public void setMEMO_CONT(String MEMO_CONT){
            this.MEMO_CONT=MEMO_CONT;
     };
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setDOC_CODE(String DOC_CODE){
            this.DOC_CODE=DOC_CODE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("OFFI_PART:"+ this.getOFFI_PART()+"\n");
      
      strB.append("OFFI_PART_REBO_WRT_NUM:"+ this.getOFFI_PART_REBO_WRT_NUM()+"\n");
      
      strB.append("NAME:"+ this.getNAME()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("REP_NM_KOR:"+ this.getREP_NM_KOR()+"\n");
      
      strB.append("REP_NM_HAN:"+ this.getREP_NM_HAN()+"\n");
      
      strB.append("OFF_ADDR:"+ this.getOFF_ADDR()+"\n");
      
      strB.append("TEL_NUM:"+ this.getTEL_NUM()+"\n");
      
      strB.append("C_COM_DT:"+ this.getC_COM_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("C_COM_CAUSE:"+ this.getC_COM_CAUSE()+"\n");
      
      strB.append("DEFI_STE:"+ this.getDEFI_STE()+"\n");
      
      strB.append("ADDR_ADDR:"+ this.getADDR_ADDR()+"\n");
      
      strB.append("ADDR_POST_NUM:"+ this.getADDR_POST_NUM()+"\n");
      
      strB.append("ADDR_DETAIL_ADDR:"+ this.getADDR_DETAIL_ADDR()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("MEMO_CONT:"+ this.getMEMO_CONT()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("DOC_CODE:"+ this.getDOC_CODE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_CLOSE_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_CLOSE_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_CLOSE_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_CLOSE_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_CLOSE_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_CLOSE_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_CLOSE_STATEMENTEntity newEnt = new PT_R_CLOSE_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setOFFI_PART(this.getOFFI_PART());
         
          newEnt.setOFFI_PART_REBO_WRT_NUM(this.getOFFI_PART_REBO_WRT_NUM());
         
          newEnt.setNAME(this.getNAME());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setREP_NM_KOR(this.getREP_NM_KOR());
         
          newEnt.setREP_NM_HAN(this.getREP_NM_HAN());
         
          newEnt.setOFF_ADDR(this.getOFF_ADDR());
         
          newEnt.setTEL_NUM(this.getTEL_NUM());
         
          newEnt.setC_COM_DT(this.getC_COM_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setC_COM_CAUSE(this.getC_COM_CAUSE());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setADDR_ADDR(this.getADDR_ADDR());
         
          newEnt.setADDR_POST_NUM(this.getADDR_POST_NUM());
         
          newEnt.setADDR_DETAIL_ADDR(this.getADDR_DETAIL_ADDR());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDOC_CODE(this.getDOC_CODE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_CLOSE_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSIDO_CODE();
        
             case 3 :
                 return  this.getCOI_WRT_NUM();
        
             case 4 :
                 return  this.getRECV_DT();
        
             case 5 :
                 return  this.getOFFI_PART();
        
             case 6 :
                 return  this.getOFFI_PART_REBO_WRT_NUM();
        
             case 7 :
                 return  this.getNAME();
        
             case 8 :
                 return  this.getWRT_NUM();
        
             case 9 :
                 return  this.getREP_NM_KOR();
        
             case 10 :
                 return  this.getREP_NM_HAN();
        
             case 11 :
                 return  this.getOFF_ADDR();
        
             case 12 :
                 return  this.getTEL_NUM();
        
             case 13 :
                 return  this.getC_COM_DT();
        
             case 14 :
                 return  this.getWRT_ID();
        
             case 15 :
                 return  this.getUPD_DT();
        
             case 16 :
                 return  this.getINS_DT();
        
             case 17 :
                 return  this.getC_COM_CAUSE();
        
             case 18 :
                 return  this.getDEFI_STE();
        
             case 19 :
                 return  this.getADDR_ADDR();
        
             case 20 :
                 return  this.getADDR_POST_NUM();
        
             case 21 :
                 return  this.getADDR_DETAIL_ADDR();
        
             case 22 :
                 return  this.getPROC_LIM();
        
             case 23 :
                 return  this.getMEMO_CONT();
        
             case 24 :
                 return  this.getMOT_STE();
        
             case 25 :
                 return  this.getTMP_WRT_NUM();
        
             case 26 :
                 return  this.getDOC_CODE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_CLOSE_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 5 :
                    this.setOFFI_PART((String)value);
	            return;  
        
             case 6 :
                    this.setOFFI_PART_REBO_WRT_NUM((String)value);
	            return;  
        
             case 7 :
                    this.setNAME((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 9 :
                    this.setREP_NM_KOR((String)value);
	            return;  
        
             case 10 :
                    this.setREP_NM_HAN((String)value);
	            return;  
        
             case 11 :
                    this.setOFF_ADDR((String)value);
	            return;  
        
             case 12 :
                    this.setTEL_NUM((String)value);
	            return;  
        
             case 13 :
                    this.setC_COM_DT((String)value);
	            return;  
        
             case 14 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 15 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 16 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 17 :
                    this.setC_COM_CAUSE((String)value);
	            return;  
        
             case 18 :
                    this.setDEFI_STE((String)value);
	            return;  
        
             case 19 :
                    this.setADDR_ADDR((String)value);
	            return;  
        
             case 20 :
                    this.setADDR_POST_NUM((String)value);
	            return;  
        
             case 21 :
                    this.setADDR_DETAIL_ADDR((String)value);
	            return;  
        
             case 22 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 23 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 24 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 25 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 26 :
                    this.setDOC_CODE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_CLOSE_STATEMENTHelper.toXML(this);
  }
  
}
