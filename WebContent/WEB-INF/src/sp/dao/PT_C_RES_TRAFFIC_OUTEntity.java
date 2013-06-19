

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_TRAFFIC_OUT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               LINE_QTT:NUMBER(10):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               SIDO:NUMBER(10):  
*               POS:NUMBER(10):  
*               FINISH:NUMBER(10):  
*               TIME:NUMBER(10):  
*               TRAFFIC_ERL:NUMBER(10):  
*               TRAFFIC_LINE:NUMBER(10):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_TRAFFIC_OUTEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String LINE_QTT;
  
     private String REMARK;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String SIDO;
  
     private String POS;
  
     private String FINISH;
  
     private String TIME;
  
     private String TRAFFIC_ERL;
  
     private String TRAFFIC_LINE;
  

//생성자를 만든다
    public PT_C_RES_TRAFFIC_OUTEntity(){
    }
    
    
    public PT_C_RES_TRAFFIC_OUTEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_TRAFFIC_OUTEntity(ValueObject ent) throws Exception{
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
		this.LINE_QTT =request.getParameter("LINE_QTT");
		this.REMARK =request.getParameter("REMARK");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.SIDO =request.getParameter("SIDO");
		this.POS =request.getParameter("POS");
		this.FINISH =request.getParameter("FINISH");
		this.TIME =request.getParameter("TIME");
		this.TRAFFIC_ERL =request.getParameter("TRAFFIC_ERL");
		this.TRAFFIC_LINE =request.getParameter("TRAFFIC_LINE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.LINE_QTT =KJFMi.dsGet(ds, arg_row, "LINE_QTT");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.SIDO =KJFMi.dsGet(ds, arg_row, "SIDO");
		this.POS =KJFMi.dsGet(ds, arg_row, "POS");
		this.FINISH =KJFMi.dsGet(ds, arg_row, "FINISH");
		this.TIME =KJFMi.dsGet(ds, arg_row, "TIME");
		this.TRAFFIC_ERL =KJFMi.dsGet(ds, arg_row, "TRAFFIC_ERL");
		this.TRAFFIC_LINE =KJFMi.dsGet(ds, arg_row, "TRAFFIC_LINE");
				
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
  
     public String getLINE_QTT(){
             return LINE_QTT;
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
  
     public String getSIDO(){
             return SIDO;
     };
  
     public String getPOS(){
             return POS;
     };
  
     public String getFINISH(){
             return FINISH;
     };
  
     public String getTIME(){
             return TIME;
     };
  
     public String getTRAFFIC_ERL(){
             return TRAFFIC_ERL;
     };
  
     public String getTRAFFIC_LINE(){
             return TRAFFIC_LINE;
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
  
     public void setLINE_QTT(String LINE_QTT){
            this.LINE_QTT=LINE_QTT;
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
  
     public void setSIDO(String SIDO){
            this.SIDO=SIDO;
     };
  
     public void setPOS(String POS){
            this.POS=POS;
     };
  
     public void setFINISH(String FINISH){
            this.FINISH=FINISH;
     };
  
     public void setTIME(String TIME){
            this.TIME=TIME;
     };
  
     public void setTRAFFIC_ERL(String TRAFFIC_ERL){
            this.TRAFFIC_ERL=TRAFFIC_ERL;
     };
  
     public void setTRAFFIC_LINE(String TRAFFIC_LINE){
            this.TRAFFIC_LINE=TRAFFIC_LINE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("LINE_QTT:"+ this.getLINE_QTT()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("SIDO:"+ this.getSIDO()+"\n");
      
      strB.append("POS:"+ this.getPOS()+"\n");
      
      strB.append("FINISH:"+ this.getFINISH()+"\n");
      
      strB.append("TIME:"+ this.getTIME()+"\n");
      
      strB.append("TRAFFIC_ERL:"+ this.getTRAFFIC_ERL()+"\n");
      
      strB.append("TRAFFIC_LINE:"+ this.getTRAFFIC_LINE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_TRAFFIC_OUTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_TRAFFIC_OUTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_TRAFFIC_OUTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_TRAFFIC_OUTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_TRAFFIC_OUTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_TRAFFIC_OUTEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_TRAFFIC_OUTEntity newEnt = new PT_C_RES_TRAFFIC_OUTEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setLINE_QTT(this.getLINE_QTT());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setSIDO(this.getSIDO());
         
          newEnt.setPOS(this.getPOS());
         
          newEnt.setFINISH(this.getFINISH());
         
          newEnt.setTIME(this.getTIME());
         
          newEnt.setTRAFFIC_ERL(this.getTRAFFIC_ERL());
         
          newEnt.setTRAFFIC_LINE(this.getTRAFFIC_LINE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_TRAFFIC_OUTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getLINE_QTT();
        
             case 5 :
                 return  this.getREMARK();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getSIGUNGU_CODE();
        
             case 10 :
                 return  this.getSIDO();
        
             case 11 :
                 return  this.getPOS();
        
             case 12 :
                 return  this.getFINISH();
        
             case 13 :
                 return  this.getTIME();
        
             case 14 :
                 return  this.getTRAFFIC_ERL();
        
             case 15 :
                 return  this.getTRAFFIC_LINE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_TRAFFIC_OUTHelper.fieldMap.get(key);
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
                    this.setLINE_QTT((String)value);
	            return;  
        
             case 5 :
                    this.setREMARK((String)value);
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
                    this.setSIDO((String)value);
	            return;  
        
             case 11 :
                    this.setPOS((String)value);
	            return;  
        
             case 12 :
                    this.setFINISH((String)value);
	            return;  
        
             case 13 :
                    this.setTIME((String)value);
	            return;  
        
             case 14 :
                    this.setTRAFFIC_ERL((String)value);
	            return;  
        
             case 15 :
                    this.setTRAFFIC_LINE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_TRAFFIC_OUTHelper.toXML(this);
  }
  
}
