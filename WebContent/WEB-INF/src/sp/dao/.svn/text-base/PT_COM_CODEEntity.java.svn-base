

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_COM_CODE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               CODE:VARCHAR2(32):  
*               P_CODE:VARCHAR2(32):  
*               CODE_NAME:VARCHAR2(128):  
*               ORDER_SEQ:NUMBER(13):  
*               USE_YN:VARCHAR2(1):  
*               BIGO:VARCHAR2(200):  
*               REG_DATE:VARCHAR2(20):  
*               MOD_DATE:VARCHAR2(20):  
*               P_CODE_NAME:VARCHAR2(128):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_COM_CODEEntity extends ValueObject{

  
     private String SEQ;
  
     private String CODE;
  
     private String P_CODE;
  
     private String CODE_NAME;
  
     private String ORDER_SEQ;
  
     private String USE_YN;
  
     private String BIGO;
  
     private String REG_DATE;
  
     private String MOD_DATE;
  
     private String P_CODE_NAME;
  

//생성자를 만든다
    public PT_COM_CODEEntity(){
    }
    
    
    public PT_COM_CODEEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_COM_CODEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.CODE =request.getParameter("CODE");
		this.P_CODE =request.getParameter("P_CODE");
		this.CODE_NAME =request.getParameter("CODE_NAME");
		this.ORDER_SEQ =request.getParameter("ORDER_SEQ");
		this.USE_YN =request.getParameter("USE_YN");
		this.BIGO =request.getParameter("BIGO");
		this.REG_DATE =request.getParameter("REG_DATE");
		this.MOD_DATE =request.getParameter("MOD_DATE");
		this.P_CODE_NAME =request.getParameter("P_CODE_NAME");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.CODE =KJFMi.dsGet(ds, arg_row, "CODE");
		this.P_CODE =KJFMi.dsGet(ds, arg_row, "P_CODE");
		this.CODE_NAME =KJFMi.dsGet(ds, arg_row, "CODE_NAME");
		this.ORDER_SEQ =KJFMi.dsGet(ds, arg_row, "ORDER_SEQ");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
		this.BIGO =KJFMi.dsGet(ds, arg_row, "BIGO");
		this.REG_DATE =KJFMi.dsGet(ds, arg_row, "REG_DATE");
		this.MOD_DATE =KJFMi.dsGet(ds, arg_row, "MOD_DATE");
		this.P_CODE_NAME =KJFMi.dsGet(ds, arg_row, "P_CODE_NAME");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getCODE(){
             return CODE;
     };
  
     public String getP_CODE(){
             return P_CODE;
     };
  
     public String getCODE_NAME(){
             return CODE_NAME;
     };
  
     public String getORDER_SEQ(){
             return ORDER_SEQ;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  
     public String getBIGO(){
             return BIGO;
     };
  
     public String getREG_DATE(){
             return REG_DATE;
     };
  
     public String getMOD_DATE(){
             return MOD_DATE;
     };
  
     public String getP_CODE_NAME(){
             return P_CODE_NAME;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setCODE(String CODE){
            this.CODE=CODE;
     };
  
     public void setP_CODE(String P_CODE){
            this.P_CODE=P_CODE;
     };
  
     public void setCODE_NAME(String CODE_NAME){
            this.CODE_NAME=CODE_NAME;
     };
  
     public void setORDER_SEQ(String ORDER_SEQ){
            this.ORDER_SEQ=ORDER_SEQ;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
     public void setBIGO(String BIGO){
            this.BIGO=BIGO;
     };
  
     public void setREG_DATE(String REG_DATE){
            this.REG_DATE=REG_DATE;
     };
  
     public void setMOD_DATE(String MOD_DATE){
            this.MOD_DATE=MOD_DATE;
     };
  
     public void setP_CODE_NAME(String P_CODE_NAME){
            this.P_CODE_NAME=P_CODE_NAME;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("CODE:"+ this.getCODE()+"\n");
      
      strB.append("P_CODE:"+ this.getP_CODE()+"\n");
      
      strB.append("CODE_NAME:"+ this.getCODE_NAME()+"\n");
      
      strB.append("ORDER_SEQ:"+ this.getORDER_SEQ()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      strB.append("BIGO:"+ this.getBIGO()+"\n");
      
      strB.append("REG_DATE:"+ this.getREG_DATE()+"\n");
      
      strB.append("MOD_DATE:"+ this.getMOD_DATE()+"\n");
      
      strB.append("P_CODE_NAME:"+ this.getP_CODE_NAME()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_COM_CODEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_COM_CODEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_COM_CODEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_COM_CODEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_COM_CODEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_COM_CODEEntity();
  }

  public ValueObject getClone(){
         PT_COM_CODEEntity newEnt = new PT_COM_CODEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setCODE(this.getCODE());
         
          newEnt.setP_CODE(this.getP_CODE());
         
          newEnt.setCODE_NAME(this.getCODE_NAME());
         
          newEnt.setORDER_SEQ(this.getORDER_SEQ());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
          newEnt.setBIGO(this.getBIGO());
         
          newEnt.setREG_DATE(this.getREG_DATE());
         
          newEnt.setMOD_DATE(this.getMOD_DATE());
         
          newEnt.setP_CODE_NAME(this.getP_CODE_NAME());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_COM_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getCODE();
        
             case 3 :
                 return  this.getP_CODE();
        
             case 4 :
                 return  this.getCODE_NAME();
        
             case 5 :
                 return  this.getORDER_SEQ();
        
             case 6 :
                 return  this.getUSE_YN();
        
             case 7 :
                 return  this.getBIGO();
        
             case 8 :
                 return  this.getREG_DATE();
        
             case 9 :
                 return  this.getMOD_DATE();
        
             case 10 :
                 return  this.getP_CODE_NAME();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_COM_CODEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCODE((String)value);
	            return;  
        
             case 3 :
                    this.setP_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setCODE_NAME((String)value);
	            return;  
        
             case 5 :
                    this.setORDER_SEQ((String)value);
	            return;  
        
             case 6 :
                    this.setUSE_YN((String)value);
	            return;  
        
             case 7 :
                    this.setBIGO((String)value);
	            return;  
        
             case 8 :
                    this.setREG_DATE((String)value);
	            return;  
        
             case 9 :
                    this.setMOD_DATE((String)value);
	            return;  
        
             case 10 :
                    this.setP_CODE_NAME((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_COM_CODEHelper.toXML(this);
  }
  
}
