

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_KICA_TRANS_LOG
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(11):  
*               U_D_FLAG:CHAR(1):  
*               TABLE_NAME:VARCHAR2(60):  
*               LOG:VARCHAR2(2000):  
*               ERR_YN:CHAR(1):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_KICA_TRANS_LOGEntity extends ValueObject{

  
     private String SEQ;
  
     private String U_D_FLAG;
  
     private String TABLE_NAME;
  
     private String LOG;
  
     private String ERR_YN;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_KICA_TRANS_LOGEntity(){
    }
    
    
    public PT_KICA_TRANS_LOGEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_KICA_TRANS_LOGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.U_D_FLAG =request.getParameter("U_D_FLAG");
		this.TABLE_NAME =request.getParameter("TABLE_NAME");
		this.LOG =request.getParameter("LOG");
		this.ERR_YN =request.getParameter("ERR_YN");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.U_D_FLAG =KJFMi.dsGet(ds, arg_row, "U_D_FLAG");
		this.TABLE_NAME =KJFMi.dsGet(ds, arg_row, "TABLE_NAME");
		this.LOG =KJFMi.dsGet(ds, arg_row, "LOG");
		this.ERR_YN =KJFMi.dsGet(ds, arg_row, "ERR_YN");
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
  
     public String getTABLE_NAME(){
             return TABLE_NAME;
     };
  
     public String getLOG(){
             return LOG;
     };
  
     public String getERR_YN(){
             return ERR_YN;
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
  
     public void setTABLE_NAME(String TABLE_NAME){
            this.TABLE_NAME=TABLE_NAME;
     };
  
     public void setLOG(String LOG){
            this.LOG=LOG;
     };
  
     public void setERR_YN(String ERR_YN){
            this.ERR_YN=ERR_YN;
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
      
      strB.append("TABLE_NAME:"+ this.getTABLE_NAME()+"\n");
      
      strB.append("LOG:"+ this.getLOG()+"\n");
      
      strB.append("ERR_YN:"+ this.getERR_YN()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_KICA_TRANS_LOGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_KICA_TRANS_LOGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_KICA_TRANS_LOGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_KICA_TRANS_LOGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_KICA_TRANS_LOGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_KICA_TRANS_LOGEntity();
  }

  public ValueObject getClone(){
         PT_KICA_TRANS_LOGEntity newEnt = new PT_KICA_TRANS_LOGEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setU_D_FLAG(this.getU_D_FLAG());
         
          newEnt.setTABLE_NAME(this.getTABLE_NAME());
         
          newEnt.setLOG(this.getLOG());
         
          newEnt.setERR_YN(this.getERR_YN());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_KICA_TRANS_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getU_D_FLAG();
        
             case 3 :
                 return  this.getTABLE_NAME();
        
             case 4 :
                 return  this.getLOG();
        
             case 5 :
                 return  this.getERR_YN();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_KICA_TRANS_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setU_D_FLAG((String)value);
	            return;  
        
             case 3 :
                    this.setTABLE_NAME((String)value);
	            return;  
        
             case 4 :
                    this.setLOG((String)value);
	            return;  
        
             case 5 :
                    this.setERR_YN((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_KICA_TRANS_LOGHelper.toXML(this);
  }
  
}
