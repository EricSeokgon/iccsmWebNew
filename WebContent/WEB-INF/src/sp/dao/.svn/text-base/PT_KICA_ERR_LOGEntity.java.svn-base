

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_KICA_ERR_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               U_D_FLAG:CHAR(1):  
*               YYYYMMDD:VARCHAR2(8):  
*               TRANSHOUR:VARCHAR2(2):  
*               FILENAME:VARCHAR2(60):  
*               ERRLOG:VARCHAR2(1000):  
*               RESULT_FLAG:CHAR(1):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_KICA_ERR_LOGEntity extends ValueObject{

  
     private String SEQ;
  
     private String U_D_FLAG;
  
     private String YYYYMMDD;
  
     private String TRANSHOUR;
  
     private String FILENAME;
  
     private String ERRLOG;
  
     private String RESULT_FLAG;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_KICA_ERR_LOGEntity(){
    }
    
    
    public PT_KICA_ERR_LOGEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_KICA_ERR_LOGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.U_D_FLAG =request.getParameter("U_D_FLAG");
		this.YYYYMMDD =request.getParameter("YYYYMMDD");
		this.TRANSHOUR =request.getParameter("TRANSHOUR");
		this.FILENAME =request.getParameter("FILENAME");
		this.ERRLOG =request.getParameter("ERRLOG");
		this.RESULT_FLAG =request.getParameter("RESULT_FLAG");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.U_D_FLAG =KJFMi.dsGet(ds, arg_row, "U_D_FLAG");
		this.YYYYMMDD =KJFMi.dsGet(ds, arg_row, "YYYYMMDD");
		this.TRANSHOUR =KJFMi.dsGet(ds, arg_row, "TRANSHOUR");
		this.FILENAME =KJFMi.dsGet(ds, arg_row, "FILENAME");
		this.ERRLOG =KJFMi.dsGet(ds, arg_row, "ERRLOG");
		this.RESULT_FLAG =KJFMi.dsGet(ds, arg_row, "RESULT_FLAG");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getU_D_FLAG(){
             return U_D_FLAG;
     };
  
     public String getYYYYMMDD(){
             return YYYYMMDD;
     };
  
     public String getTRANSHOUR(){
             return TRANSHOUR;
     };
  
     public String getFILENAME(){
             return FILENAME;
     };
  
     public String getERRLOG(){
             return ERRLOG;
     };
  
     public String getRESULT_FLAG(){
             return RESULT_FLAG;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setU_D_FLAG(String U_D_FLAG){
            this.U_D_FLAG=U_D_FLAG;
     };
  
     public void setYYYYMMDD(String YYYYMMDD){
            this.YYYYMMDD=YYYYMMDD;
     };
  
     public void setTRANSHOUR(String TRANSHOUR){
            this.TRANSHOUR=TRANSHOUR;
     };
  
     public void setFILENAME(String FILENAME){
            this.FILENAME=FILENAME;
     };
  
     public void setERRLOG(String ERRLOG){
            this.ERRLOG=ERRLOG;
     };
  
     public void setRESULT_FLAG(String RESULT_FLAG){
            this.RESULT_FLAG=RESULT_FLAG;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("U_D_FLAG:"+ this.getU_D_FLAG()+"\n");
      
      strB.append("YYYYMMDD:"+ this.getYYYYMMDD()+"\n");
      
      strB.append("TRANSHOUR:"+ this.getTRANSHOUR()+"\n");
      
      strB.append("FILENAME:"+ this.getFILENAME()+"\n");
      
      strB.append("ERRLOG:"+ this.getERRLOG()+"\n");
      
      strB.append("RESULT_FLAG:"+ this.getRESULT_FLAG()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_KICA_ERR_LOGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_KICA_ERR_LOGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_KICA_ERR_LOGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_KICA_ERR_LOGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_KICA_ERR_LOGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_KICA_ERR_LOGEntity();
  }

  public ValueObject getClone(){
         PT_KICA_ERR_LOGEntity newEnt = new PT_KICA_ERR_LOGEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setU_D_FLAG(this.getU_D_FLAG());
         
          newEnt.setYYYYMMDD(this.getYYYYMMDD());
         
          newEnt.setTRANSHOUR(this.getTRANSHOUR());
         
          newEnt.setFILENAME(this.getFILENAME());
         
          newEnt.setERRLOG(this.getERRLOG());
         
          newEnt.setRESULT_FLAG(this.getRESULT_FLAG());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_KICA_ERR_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getU_D_FLAG();
        
             case 3 :
                 return  this.getYYYYMMDD();
        
             case 4 :
                 return  this.getTRANSHOUR();
        
             case 5 :
                 return  this.getFILENAME();
        
             case 6 :
                 return  this.getERRLOG();
        
             case 7 :
                 return  this.getRESULT_FLAG();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_KICA_ERR_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setU_D_FLAG((String)value);
	            return;  
        
             case 3 :
                    this.setYYYYMMDD((String)value);
	            return;  
        
             case 4 :
                    this.setTRANSHOUR((String)value);
	            return;  
        
             case 5 :
                    this.setFILENAME((String)value);
	            return;  
        
             case 6 :
                    this.setERRLOG((String)value);
	            return;  
        
             case 7 :
                    this.setRESULT_FLAG((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_KICA_ERR_LOGHelper.toXML(this);
  }
  
}
