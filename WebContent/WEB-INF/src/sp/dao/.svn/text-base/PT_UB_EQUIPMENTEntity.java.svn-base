

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_EQUIPMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(30):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(4):  
*               CIV_RECV_NUM:VARCHAR2(100):  
*               TYPE_PROC_NO_CA:VARCHAR2(50):  
*               TYPE_PROC_NM_CA:VARCHAR2(100):  
*               FREQUENCY_SCOPE_CA:VARCHAR2(20):  
*               WIRE_TYPE_CA:VARCHAR2(100):  
*               TYPE_PROC_NO_MA:VARCHAR2(50):  
*               TYPE_PROC_NM_MA:VARCHAR2(100):  
*               FREQUENCY_SCOPE_MA:VARCHAR2(20):  
*               WIRE_TYPE_MA:VARCHAR2(100):  
*               TYPE_PROC_NO_SMA:VARCHAR2(50):  
*               TYPE_PROC_NM_SMA:VARCHAR2(100):  
*               FREQUENCY_SCOPE_SMA:VARCHAR2(20):  
*               WIRE_TYPE_SMA:VARCHAR2(100):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_EQUIPMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  
     private String CIV_RECV_NUM;
  
     private String TYPE_PROC_NO_CA;
  
     private String TYPE_PROC_NM_CA;
  
     private String FREQUENCY_SCOPE_CA;
  
     private String WIRE_TYPE_CA;
  
     private String TYPE_PROC_NO_MA;
  
     private String TYPE_PROC_NM_MA;
  
     private String FREQUENCY_SCOPE_MA;
  
     private String WIRE_TYPE_MA;
  
     private String TYPE_PROC_NO_SMA;
  
     private String TYPE_PROC_NM_SMA;
  
     private String FREQUENCY_SCOPE_SMA;
  
     private String WIRE_TYPE_SMA;
  
     private String INS_DT;
  
     private String UPD_DT;
  

//생성자를 만든다
    public PT_UB_EQUIPMENTEntity(){
    }
    
    
    public PT_UB_EQUIPMENTEntity(String RECV_NUM,String SIDO_CODE,String SIGUNGU_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_UB_EQUIPMENTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
       value = ent.getByName("SIGUNGU_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIGUNGU_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.CIV_RECV_NUM =request.getParameter("CIV_RECV_NUM");
		this.TYPE_PROC_NO_CA =request.getParameter("TYPE_PROC_NO_CA");
		this.TYPE_PROC_NM_CA =request.getParameter("TYPE_PROC_NM_CA");
		this.FREQUENCY_SCOPE_CA =request.getParameter("FREQUENCY_SCOPE_CA");
		this.WIRE_TYPE_CA =request.getParameter("WIRE_TYPE_CA");
		this.TYPE_PROC_NO_MA =request.getParameter("TYPE_PROC_NO_MA");
		this.TYPE_PROC_NM_MA =request.getParameter("TYPE_PROC_NM_MA");
		this.FREQUENCY_SCOPE_MA =request.getParameter("FREQUENCY_SCOPE_MA");
		this.WIRE_TYPE_MA =request.getParameter("WIRE_TYPE_MA");
		this.TYPE_PROC_NO_SMA =request.getParameter("TYPE_PROC_NO_SMA");
		this.TYPE_PROC_NM_SMA =request.getParameter("TYPE_PROC_NM_SMA");
		this.FREQUENCY_SCOPE_SMA =request.getParameter("FREQUENCY_SCOPE_SMA");
		this.WIRE_TYPE_SMA =request.getParameter("WIRE_TYPE_SMA");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.CIV_RECV_NUM =KJFMi.dsGet(ds, arg_row, "CIV_RECV_NUM");
		this.TYPE_PROC_NO_CA =KJFMi.dsGet(ds, arg_row, "TYPE_PROC_NO_CA");
		this.TYPE_PROC_NM_CA =KJFMi.dsGet(ds, arg_row, "TYPE_PROC_NM_CA");
		this.FREQUENCY_SCOPE_CA =KJFMi.dsGet(ds, arg_row, "FREQUENCY_SCOPE_CA");
		this.WIRE_TYPE_CA =KJFMi.dsGet(ds, arg_row, "WIRE_TYPE_CA");
		this.TYPE_PROC_NO_MA =KJFMi.dsGet(ds, arg_row, "TYPE_PROC_NO_MA");
		this.TYPE_PROC_NM_MA =KJFMi.dsGet(ds, arg_row, "TYPE_PROC_NM_MA");
		this.FREQUENCY_SCOPE_MA =KJFMi.dsGet(ds, arg_row, "FREQUENCY_SCOPE_MA");
		this.WIRE_TYPE_MA =KJFMi.dsGet(ds, arg_row, "WIRE_TYPE_MA");
		this.TYPE_PROC_NO_SMA =KJFMi.dsGet(ds, arg_row, "TYPE_PROC_NO_SMA");
		this.TYPE_PROC_NM_SMA =KJFMi.dsGet(ds, arg_row, "TYPE_PROC_NM_SMA");
		this.FREQUENCY_SCOPE_SMA =KJFMi.dsGet(ds, arg_row, "FREQUENCY_SCOPE_SMA");
		this.WIRE_TYPE_SMA =KJFMi.dsGet(ds, arg_row, "WIRE_TYPE_SMA");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getCIV_RECV_NUM(){
             return CIV_RECV_NUM;
     };
  
     public String getTYPE_PROC_NO_CA(){
             return TYPE_PROC_NO_CA;
     };
  
     public String getTYPE_PROC_NM_CA(){
             return TYPE_PROC_NM_CA;
     };
  
     public String getFREQUENCY_SCOPE_CA(){
             return FREQUENCY_SCOPE_CA;
     };
  
     public String getWIRE_TYPE_CA(){
             return WIRE_TYPE_CA;
     };
  
     public String getTYPE_PROC_NO_MA(){
             return TYPE_PROC_NO_MA;
     };
  
     public String getTYPE_PROC_NM_MA(){
             return TYPE_PROC_NM_MA;
     };
  
     public String getFREQUENCY_SCOPE_MA(){
             return FREQUENCY_SCOPE_MA;
     };
  
     public String getWIRE_TYPE_MA(){
             return WIRE_TYPE_MA;
     };
  
     public String getTYPE_PROC_NO_SMA(){
             return TYPE_PROC_NO_SMA;
     };
  
     public String getTYPE_PROC_NM_SMA(){
             return TYPE_PROC_NM_SMA;
     };
  
     public String getFREQUENCY_SCOPE_SMA(){
             return FREQUENCY_SCOPE_SMA;
     };
  
     public String getWIRE_TYPE_SMA(){
             return WIRE_TYPE_SMA;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setCIV_RECV_NUM(String CIV_RECV_NUM){
            this.CIV_RECV_NUM=CIV_RECV_NUM;
     };
  
     public void setTYPE_PROC_NO_CA(String TYPE_PROC_NO_CA){
            this.TYPE_PROC_NO_CA=TYPE_PROC_NO_CA;
     };
  
     public void setTYPE_PROC_NM_CA(String TYPE_PROC_NM_CA){
            this.TYPE_PROC_NM_CA=TYPE_PROC_NM_CA;
     };
  
     public void setFREQUENCY_SCOPE_CA(String FREQUENCY_SCOPE_CA){
            this.FREQUENCY_SCOPE_CA=FREQUENCY_SCOPE_CA;
     };
  
     public void setWIRE_TYPE_CA(String WIRE_TYPE_CA){
            this.WIRE_TYPE_CA=WIRE_TYPE_CA;
     };
  
     public void setTYPE_PROC_NO_MA(String TYPE_PROC_NO_MA){
            this.TYPE_PROC_NO_MA=TYPE_PROC_NO_MA;
     };
  
     public void setTYPE_PROC_NM_MA(String TYPE_PROC_NM_MA){
            this.TYPE_PROC_NM_MA=TYPE_PROC_NM_MA;
     };
  
     public void setFREQUENCY_SCOPE_MA(String FREQUENCY_SCOPE_MA){
            this.FREQUENCY_SCOPE_MA=FREQUENCY_SCOPE_MA;
     };
  
     public void setWIRE_TYPE_MA(String WIRE_TYPE_MA){
            this.WIRE_TYPE_MA=WIRE_TYPE_MA;
     };
  
     public void setTYPE_PROC_NO_SMA(String TYPE_PROC_NO_SMA){
            this.TYPE_PROC_NO_SMA=TYPE_PROC_NO_SMA;
     };
  
     public void setTYPE_PROC_NM_SMA(String TYPE_PROC_NM_SMA){
            this.TYPE_PROC_NM_SMA=TYPE_PROC_NM_SMA;
     };
  
     public void setFREQUENCY_SCOPE_SMA(String FREQUENCY_SCOPE_SMA){
            this.FREQUENCY_SCOPE_SMA=FREQUENCY_SCOPE_SMA;
     };
  
     public void setWIRE_TYPE_SMA(String WIRE_TYPE_SMA){
            this.WIRE_TYPE_SMA=WIRE_TYPE_SMA;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("CIV_RECV_NUM:"+ this.getCIV_RECV_NUM()+"\n");
      
      strB.append("TYPE_PROC_NO_CA:"+ this.getTYPE_PROC_NO_CA()+"\n");
      
      strB.append("TYPE_PROC_NM_CA:"+ this.getTYPE_PROC_NM_CA()+"\n");
      
      strB.append("FREQUENCY_SCOPE_CA:"+ this.getFREQUENCY_SCOPE_CA()+"\n");
      
      strB.append("WIRE_TYPE_CA:"+ this.getWIRE_TYPE_CA()+"\n");
      
      strB.append("TYPE_PROC_NO_MA:"+ this.getTYPE_PROC_NO_MA()+"\n");
      
      strB.append("TYPE_PROC_NM_MA:"+ this.getTYPE_PROC_NM_MA()+"\n");
      
      strB.append("FREQUENCY_SCOPE_MA:"+ this.getFREQUENCY_SCOPE_MA()+"\n");
      
      strB.append("WIRE_TYPE_MA:"+ this.getWIRE_TYPE_MA()+"\n");
      
      strB.append("TYPE_PROC_NO_SMA:"+ this.getTYPE_PROC_NO_SMA()+"\n");
      
      strB.append("TYPE_PROC_NM_SMA:"+ this.getTYPE_PROC_NM_SMA()+"\n");
      
      strB.append("FREQUENCY_SCOPE_SMA:"+ this.getFREQUENCY_SCOPE_SMA()+"\n");
      
      strB.append("WIRE_TYPE_SMA:"+ this.getWIRE_TYPE_SMA()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_EQUIPMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_EQUIPMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_EQUIPMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_EQUIPMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_EQUIPMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       values[2]= this.getSIGUNGU_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_EQUIPMENTEntity();
  }

  public ValueObject getClone(){
         PT_UB_EQUIPMENTEntity newEnt = new PT_UB_EQUIPMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setCIV_RECV_NUM(this.getCIV_RECV_NUM());
         
          newEnt.setTYPE_PROC_NO_CA(this.getTYPE_PROC_NO_CA());
         
          newEnt.setTYPE_PROC_NM_CA(this.getTYPE_PROC_NM_CA());
         
          newEnt.setFREQUENCY_SCOPE_CA(this.getFREQUENCY_SCOPE_CA());
         
          newEnt.setWIRE_TYPE_CA(this.getWIRE_TYPE_CA());
         
          newEnt.setTYPE_PROC_NO_MA(this.getTYPE_PROC_NO_MA());
         
          newEnt.setTYPE_PROC_NM_MA(this.getTYPE_PROC_NM_MA());
         
          newEnt.setFREQUENCY_SCOPE_MA(this.getFREQUENCY_SCOPE_MA());
         
          newEnt.setWIRE_TYPE_MA(this.getWIRE_TYPE_MA());
         
          newEnt.setTYPE_PROC_NO_SMA(this.getTYPE_PROC_NO_SMA());
         
          newEnt.setTYPE_PROC_NM_SMA(this.getTYPE_PROC_NM_SMA());
         
          newEnt.setFREQUENCY_SCOPE_SMA(this.getFREQUENCY_SCOPE_SMA());
         
          newEnt.setWIRE_TYPE_SMA(this.getWIRE_TYPE_SMA());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_EQUIPMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSIDO_CODE();
        
             case 3 :
                 return  this.getSIGUNGU_CODE();
        
             case 4 :
                 return  this.getCIV_RECV_NUM();
        
             case 5 :
                 return  this.getTYPE_PROC_NO_CA();
        
             case 6 :
                 return  this.getTYPE_PROC_NM_CA();
        
             case 7 :
                 return  this.getFREQUENCY_SCOPE_CA();
        
             case 8 :
                 return  this.getWIRE_TYPE_CA();
        
             case 9 :
                 return  this.getTYPE_PROC_NO_MA();
        
             case 10 :
                 return  this.getTYPE_PROC_NM_MA();
        
             case 11 :
                 return  this.getFREQUENCY_SCOPE_MA();
        
             case 12 :
                 return  this.getWIRE_TYPE_MA();
        
             case 13 :
                 return  this.getTYPE_PROC_NO_SMA();
        
             case 14 :
                 return  this.getTYPE_PROC_NM_SMA();
        
             case 15 :
                 return  this.getFREQUENCY_SCOPE_SMA();
        
             case 16 :
                 return  this.getWIRE_TYPE_SMA();
        
             case 17 :
                 return  this.getINS_DT();
        
             case 18 :
                 return  this.getUPD_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_EQUIPMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setCIV_RECV_NUM((String)value);
	            return;  
        
             case 5 :
                    this.setTYPE_PROC_NO_CA((String)value);
	            return;  
        
             case 6 :
                    this.setTYPE_PROC_NM_CA((String)value);
	            return;  
        
             case 7 :
                    this.setFREQUENCY_SCOPE_CA((String)value);
	            return;  
        
             case 8 :
                    this.setWIRE_TYPE_CA((String)value);
	            return;  
        
             case 9 :
                    this.setTYPE_PROC_NO_MA((String)value);
	            return;  
        
             case 10 :
                    this.setTYPE_PROC_NM_MA((String)value);
	            return;  
        
             case 11 :
                    this.setFREQUENCY_SCOPE_MA((String)value);
	            return;  
        
             case 12 :
                    this.setWIRE_TYPE_MA((String)value);
	            return;  
        
             case 13 :
                    this.setTYPE_PROC_NO_SMA((String)value);
	            return;  
        
             case 14 :
                    this.setTYPE_PROC_NM_SMA((String)value);
	            return;  
        
             case 15 :
                    this.setFREQUENCY_SCOPE_SMA((String)value);
	            return;  
        
             case 16 :
                    this.setWIRE_TYPE_SMA((String)value);
	            return;  
        
             case 17 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 18 :
                    this.setUPD_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_EQUIPMENTHelper.toXML(this);
  }
  
}
