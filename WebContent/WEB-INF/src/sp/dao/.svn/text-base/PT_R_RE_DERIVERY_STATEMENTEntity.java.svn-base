

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_RE_DERIVERY_STATEMENT
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
*               REP:VARCHAR2(20):  
*               TEL_NUM:VARCHAR2(17):  
*               FAX_NUM:VARCHAR2(17):  
*               OFF_ADDR:VARCHAR2(200):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               MOT_STE:VARCHAR2(6):  
*               DEFI_STE:VARCHAR2(1):  
*               COI:VARCHAR2(1):  
*               WRTBOOK:VARCHAR2(1):  
*               APPL_CAUSE:VARCHAR2(256):  
*               TMP_WRT_NUM:VARCHAR2(32):  
*               DOC_CODE:VARCHAR2(50):  
*               SND_STE:VARCHAR2(4):  
*               SND_DT:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_RE_DERIVERY_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String COI_WRT_NUM;
  
     private String RECV_DT;
  
     private String OFFI_PART;
  
     private String OFFI_PART_REBO_WRT_NUM;
  
     private String NAME;
  
     private String WRT_NUM;
  
     private String REP;
  
     private String TEL_NUM;
  
     private String FAX_NUM;
  
     private String OFF_ADDR;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String MOT_STE;
  
     private String DEFI_STE;
  
     private String COI;
  
     private String WRTBOOK;
  
     private String APPL_CAUSE;
  
     private String TMP_WRT_NUM;
  
     private String DOC_CODE;
  
     private String SND_STE;
  
     private String SND_DT;
  

//생성자를 만든다
    public PT_R_RE_DERIVERY_STATEMENTEntity(){
    }
    
    
    public PT_R_RE_DERIVERY_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_RE_DERIVERY_STATEMENTEntity(ValueObject ent) throws Exception{
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
		this.REP =request.getParameter("REP");
		this.TEL_NUM =request.getParameter("TEL_NUM");
		this.FAX_NUM =request.getParameter("FAX_NUM");
		this.OFF_ADDR =request.getParameter("OFF_ADDR");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.DEFI_STE =request.getParameter("DEFI_STE");
		this.COI =request.getParameter("COI");
		this.WRTBOOK =request.getParameter("WRTBOOK");
		this.APPL_CAUSE =request.getParameter("APPL_CAUSE");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.DOC_CODE =request.getParameter("DOC_CODE");
		this.SND_STE =request.getParameter("SND_STE");
		this.SND_DT =request.getParameter("SND_DT");
		
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
		this.REP =KJFMi.dsGet(ds, arg_row, "REP");
		this.TEL_NUM =KJFMi.dsGet(ds, arg_row, "TEL_NUM");
		this.FAX_NUM =KJFMi.dsGet(ds, arg_row, "FAX_NUM");
		this.OFF_ADDR =KJFMi.dsGet(ds, arg_row, "OFF_ADDR");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.DEFI_STE =KJFMi.dsGet(ds, arg_row, "DEFI_STE");
		this.COI =KJFMi.dsGet(ds, arg_row, "COI");
		this.WRTBOOK =KJFMi.dsGet(ds, arg_row, "WRTBOOK");
		this.APPL_CAUSE =KJFMi.dsGet(ds, arg_row, "APPL_CAUSE");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DOC_CODE =KJFMi.dsGet(ds, arg_row, "DOC_CODE");
		this.SND_STE =KJFMi.dsGet(ds, arg_row, "SND_STE");
		this.SND_DT =KJFMi.dsGet(ds, arg_row, "SND_DT");
				
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
  
     public String getREP(){
             return REP;
     };
  
     public String getTEL_NUM(){
             return TEL_NUM;
     };
  
     public String getFAX_NUM(){
             return FAX_NUM;
     };
  
     public String getOFF_ADDR(){
             return OFF_ADDR;
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
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  
     public String getDEFI_STE(){
             return DEFI_STE;
     };
  
     public String getCOI(){
             return COI;
     };
  
     public String getWRTBOOK(){
             return WRTBOOK;
     };
  
     public String getAPPL_CAUSE(){
             return APPL_CAUSE;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getDOC_CODE(){
             return DOC_CODE;
     };
  
     public String getSND_STE(){
             return SND_STE;
     };
  
     public String getSND_DT(){
             return SND_DT;
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
  
     public void setREP(String REP){
            this.REP=REP;
     };
  
     public void setTEL_NUM(String TEL_NUM){
            this.TEL_NUM=TEL_NUM;
     };
  
     public void setFAX_NUM(String FAX_NUM){
            this.FAX_NUM=FAX_NUM;
     };
  
     public void setOFF_ADDR(String OFF_ADDR){
            this.OFF_ADDR=OFF_ADDR;
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
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
     public void setDEFI_STE(String DEFI_STE){
            this.DEFI_STE=DEFI_STE;
     };
  
     public void setCOI(String COI){
            this.COI=COI;
     };
  
     public void setWRTBOOK(String WRTBOOK){
            this.WRTBOOK=WRTBOOK;
     };
  
     public void setAPPL_CAUSE(String APPL_CAUSE){
            this.APPL_CAUSE=APPL_CAUSE;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setDOC_CODE(String DOC_CODE){
            this.DOC_CODE=DOC_CODE;
     };
  
     public void setSND_STE(String SND_STE){
            this.SND_STE=SND_STE;
     };
  
     public void setSND_DT(String SND_DT){
            this.SND_DT=SND_DT;
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
      
      strB.append("REP:"+ this.getREP()+"\n");
      
      strB.append("TEL_NUM:"+ this.getTEL_NUM()+"\n");
      
      strB.append("FAX_NUM:"+ this.getFAX_NUM()+"\n");
      
      strB.append("OFF_ADDR:"+ this.getOFF_ADDR()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("DEFI_STE:"+ this.getDEFI_STE()+"\n");
      
      strB.append("COI:"+ this.getCOI()+"\n");
      
      strB.append("WRTBOOK:"+ this.getWRTBOOK()+"\n");
      
      strB.append("APPL_CAUSE:"+ this.getAPPL_CAUSE()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("DOC_CODE:"+ this.getDOC_CODE()+"\n");
      
      strB.append("SND_STE:"+ this.getSND_STE()+"\n");
      
      strB.append("SND_DT:"+ this.getSND_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_RE_DERIVERY_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_RE_DERIVERY_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_RE_DERIVERY_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_RE_DERIVERY_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_RE_DERIVERY_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_RE_DERIVERY_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_RE_DERIVERY_STATEMENTEntity newEnt = new PT_R_RE_DERIVERY_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setOFFI_PART(this.getOFFI_PART());
         
          newEnt.setOFFI_PART_REBO_WRT_NUM(this.getOFFI_PART_REBO_WRT_NUM());
         
          newEnt.setNAME(this.getNAME());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setREP(this.getREP());
         
          newEnt.setTEL_NUM(this.getTEL_NUM());
         
          newEnt.setFAX_NUM(this.getFAX_NUM());
         
          newEnt.setOFF_ADDR(this.getOFF_ADDR());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setCOI(this.getCOI());
         
          newEnt.setWRTBOOK(this.getWRTBOOK());
         
          newEnt.setAPPL_CAUSE(this.getAPPL_CAUSE());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDOC_CODE(this.getDOC_CODE());
         
          newEnt.setSND_STE(this.getSND_STE());
         
          newEnt.setSND_DT(this.getSND_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_RE_DERIVERY_STATEMENTHelper.fieldMap.get(key);
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
                 return  this.getREP();
        
             case 10 :
                 return  this.getTEL_NUM();
        
             case 11 :
                 return  this.getFAX_NUM();
        
             case 12 :
                 return  this.getOFF_ADDR();
        
             case 13 :
                 return  this.getWRT_ID();
        
             case 14 :
                 return  this.getUPD_DT();
        
             case 15 :
                 return  this.getINS_DT();
        
             case 16 :
                 return  this.getMOT_STE();
        
             case 17 :
                 return  this.getDEFI_STE();
        
             case 18 :
                 return  this.getCOI();
        
             case 19 :
                 return  this.getWRTBOOK();
        
             case 20 :
                 return  this.getAPPL_CAUSE();
        
             case 21 :
                 return  this.getTMP_WRT_NUM();
        
             case 22 :
                 return  this.getDOC_CODE();
        
             case 23 :
                 return  this.getSND_STE();
        
             case 24 :
                 return  this.getSND_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_RE_DERIVERY_STATEMENTHelper.fieldMap.get(key);
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
                    this.setREP((String)value);
	            return;  
        
             case 10 :
                    this.setTEL_NUM((String)value);
	            return;  
        
             case 11 :
                    this.setFAX_NUM((String)value);
	            return;  
        
             case 12 :
                    this.setOFF_ADDR((String)value);
	            return;  
        
             case 13 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 14 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 15 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 16 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 17 :
                    this.setDEFI_STE((String)value);
	            return;  
        
             case 18 :
                    this.setCOI((String)value);
	            return;  
        
             case 19 :
                    this.setWRTBOOK((String)value);
	            return;  
        
             case 20 :
                    this.setAPPL_CAUSE((String)value);
	            return;  
        
             case 21 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 22 :
                    this.setDOC_CODE((String)value);
	            return;  
        
             case 23 :
                    this.setSND_STE((String)value);
	            return;  
        
             case 24 :
                    this.setSND_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_RE_DERIVERY_STATEMENTHelper.toXML(this);
  }
  
}
