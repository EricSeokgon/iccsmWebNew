

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_FIXING_FLAG
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               FIR_COMMIT_DT:VARCHAR2(24):  
*               USE:VARCHAR2(50):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               WATT:VARCHAR2(12):  
*               RE_ST_QTT:NUMBER(10):  
*               MO_ST_QTT:NUMBER(10):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_FIXING_FLAGEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String FIR_COMMIT_DT;
  
     private String USE;
  
     private String REMARK;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String WATT;
  
     private String RE_ST_QTT;
  
     private String MO_ST_QTT;
  

//생성자를 만든다
    public PT_C_RES_FIXING_FLAGEntity(){
    }
    
    
    public PT_C_RES_FIXING_FLAGEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_FIXING_FLAGEntity(ValueObject ent) throws Exception{
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
		this.FIR_COMMIT_DT =request.getParameter("FIR_COMMIT_DT");
		this.USE =request.getParameter("USE");
		this.REMARK =request.getParameter("REMARK");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.WATT =request.getParameter("WATT");
		this.RE_ST_QTT =request.getParameter("RE_ST_QTT");
		this.MO_ST_QTT =request.getParameter("MO_ST_QTT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.FIR_COMMIT_DT =KJFMi.dsGet(ds, arg_row, "FIR_COMMIT_DT");
		this.USE =KJFMi.dsGet(ds, arg_row, "USE");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.WATT =KJFMi.dsGet(ds, arg_row, "WATT");
		this.RE_ST_QTT =KJFMi.dsGet(ds, arg_row, "RE_ST_QTT");
		this.MO_ST_QTT =KJFMi.dsGet(ds, arg_row, "MO_ST_QTT");
				
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
  
     public String getFIR_COMMIT_DT(){
             return FIR_COMMIT_DT;
     };
  
     public String getUSE(){
             return USE;
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
  
     public String getWATT(){
             return WATT;
     };
  
     public String getRE_ST_QTT(){
             return RE_ST_QTT;
     };
  
     public String getMO_ST_QTT(){
             return MO_ST_QTT;
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
  
     public void setFIR_COMMIT_DT(String FIR_COMMIT_DT){
            this.FIR_COMMIT_DT=FIR_COMMIT_DT;
     };
  
     public void setUSE(String USE){
            this.USE=USE;
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
  
     public void setWATT(String WATT){
            this.WATT=WATT;
     };
  
     public void setRE_ST_QTT(String RE_ST_QTT){
            this.RE_ST_QTT=RE_ST_QTT;
     };
  
     public void setMO_ST_QTT(String MO_ST_QTT){
            this.MO_ST_QTT=MO_ST_QTT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("FIR_COMMIT_DT:"+ this.getFIR_COMMIT_DT()+"\n");
      
      strB.append("USE:"+ this.getUSE()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("WATT:"+ this.getWATT()+"\n");
      
      strB.append("RE_ST_QTT:"+ this.getRE_ST_QTT()+"\n");
      
      strB.append("MO_ST_QTT:"+ this.getMO_ST_QTT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_FIXING_FLAGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_FIXING_FLAGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_FIXING_FLAGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_FIXING_FLAGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_FIXING_FLAGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_FIXING_FLAGEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_FIXING_FLAGEntity newEnt = new PT_C_RES_FIXING_FLAGEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setFIR_COMMIT_DT(this.getFIR_COMMIT_DT());
         
          newEnt.setUSE(this.getUSE());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setWATT(this.getWATT());
         
          newEnt.setRE_ST_QTT(this.getRE_ST_QTT());
         
          newEnt.setMO_ST_QTT(this.getMO_ST_QTT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_FIXING_FLAGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getFIR_COMMIT_DT();
        
             case 5 :
                 return  this.getUSE();
        
             case 6 :
                 return  this.getREMARK();
        
             case 7 :
                 return  this.getINS_DT();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getWRT_ID();
        
             case 10 :
                 return  this.getSIGUNGU_CODE();
        
             case 11 :
                 return  this.getWATT();
        
             case 12 :
                 return  this.getRE_ST_QTT();
        
             case 13 :
                 return  this.getMO_ST_QTT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_FIXING_FLAGHelper.fieldMap.get(key);
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
                    this.setFIR_COMMIT_DT((String)value);
	            return;  
        
             case 5 :
                    this.setUSE((String)value);
	            return;  
        
             case 6 :
                    this.setREMARK((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 10 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 11 :
                    this.setWATT((String)value);
	            return;  
        
             case 12 :
                    this.setRE_ST_QTT((String)value);
	            return;  
        
             case 13 :
                    this.setMO_ST_QTT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_FIXING_FLAGHelper.toXML(this);
  }
  
}
