

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_COM_FILES
*  테이블 설명 :
*  테이블 PK   :  
*               SYS_FILE_NAME
*  테이블 컬럼 :  
*               CT_ID:VARCHAR2(30):  
*               BOARD_SEQ:VARCHAR2(10):  
*               FILE_REAL_NAME:VARCHAR2(250):  
*               SYS_FILE_NAME:VARCHAR2(281):  
*               FILE_SIZE:VARCHAR2(20):  
*               UPD_DT:VARCHAR2(20):  
*               DOWN_HIT:NUMBER(22):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_BBS_COM_FILESEntity extends ValueObject{

  
     private String CT_ID;
  
     private String BOARD_SEQ;
  
     private String FILE_REAL_NAME;
  
     private String SYS_FILE_NAME;
  
     private String FILE_SIZE;
  
     private String UPD_DT;
  
     private String DOWN_HIT;
  

//생성자를 만든다
    public PT_BBS_COM_FILESEntity(){
    }
    
    
    public PT_BBS_COM_FILESEntity(String SYS_FILE_NAME ){
       this.setSYS_FILE_NAME(SYS_FILE_NAME);
       
    }
      
    public PT_BBS_COM_FILESEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SYS_FILE_NAME");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SYS_FILE_NAME",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CT_ID =request.getParameter("CT_ID");
		this.BOARD_SEQ =request.getParameter("BOARD_SEQ");
		this.FILE_REAL_NAME =request.getParameter("FILE_REAL_NAME");
		this.SYS_FILE_NAME =request.getParameter("SYS_FILE_NAME");
		this.FILE_SIZE =request.getParameter("FILE_SIZE");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.DOWN_HIT =request.getParameter("DOWN_HIT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CT_ID =KJFMi.dsGet(ds, arg_row, "CT_ID");
		this.BOARD_SEQ =KJFMi.dsGet(ds, arg_row, "BOARD_SEQ");
		this.FILE_REAL_NAME =KJFMi.dsGet(ds, arg_row, "FILE_REAL_NAME");
		this.SYS_FILE_NAME =KJFMi.dsGet(ds, arg_row, "SYS_FILE_NAME");
		this.FILE_SIZE =KJFMi.dsGet(ds, arg_row, "FILE_SIZE");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.DOWN_HIT =KJFMi.dsGet(ds, arg_row, "DOWN_HIT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCT_ID(){
             return CT_ID;
     };
  
     public String getBOARD_SEQ(){
             return BOARD_SEQ;
     };
  
     public String getFILE_REAL_NAME(){
             return FILE_REAL_NAME;
     };
  
     public String getSYS_FILE_NAME(){
             return SYS_FILE_NAME;
     };
  
     public String getFILE_SIZE(){
             return FILE_SIZE;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getDOWN_HIT(){
             return DOWN_HIT;
     };
  

//Setter 함수를 만든다
  
     public void setCT_ID(String CT_ID){
            this.CT_ID=CT_ID;
     };
  
     public void setBOARD_SEQ(String BOARD_SEQ){
            this.BOARD_SEQ=BOARD_SEQ;
     };
  
     public void setFILE_REAL_NAME(String FILE_REAL_NAME){
            this.FILE_REAL_NAME=FILE_REAL_NAME;
     };
  
     public void setSYS_FILE_NAME(String SYS_FILE_NAME){
            this.SYS_FILE_NAME=SYS_FILE_NAME;
     };
  
     public void setFILE_SIZE(String FILE_SIZE){
            this.FILE_SIZE=FILE_SIZE;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setDOWN_HIT(String DOWN_HIT){
            this.DOWN_HIT=DOWN_HIT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CT_ID:"+ this.getCT_ID()+"\n");
      
      strB.append("BOARD_SEQ:"+ this.getBOARD_SEQ()+"\n");
      
      strB.append("FILE_REAL_NAME:"+ this.getFILE_REAL_NAME()+"\n");
      
      strB.append("SYS_FILE_NAME:"+ this.getSYS_FILE_NAME()+"\n");
      
      strB.append("FILE_SIZE:"+ this.getFILE_SIZE()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("DOWN_HIT:"+ this.getDOWN_HIT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_BBS_COM_FILESHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_BBS_COM_FILESHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_BBS_COM_FILESHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_BBS_COM_FILESHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_BBS_COM_FILESHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSYS_FILE_NAME();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_BBS_COM_FILESEntity();
  }

  public ValueObject getClone(){
         PT_BBS_COM_FILESEntity newEnt = new PT_BBS_COM_FILESEntity();
	 
          newEnt.setCT_ID(this.getCT_ID());
         
          newEnt.setBOARD_SEQ(this.getBOARD_SEQ());
         
          newEnt.setFILE_REAL_NAME(this.getFILE_REAL_NAME());
         
          newEnt.setSYS_FILE_NAME(this.getSYS_FILE_NAME());
         
          newEnt.setFILE_SIZE(this.getFILE_SIZE());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setDOWN_HIT(this.getDOWN_HIT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_BBS_COM_FILESHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCT_ID();
        
             case 2 :
                 return  this.getBOARD_SEQ();
        
             case 3 :
                 return  this.getFILE_REAL_NAME();
        
             case 4 :
                 return  this.getSYS_FILE_NAME();
        
             case 5 :
                 return  this.getFILE_SIZE();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getDOWN_HIT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_BBS_COM_FILESHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCT_ID((String)value);
	            return;  
        
             case 2 :
                    this.setBOARD_SEQ((String)value);
	            return;  
        
             case 3 :
                    this.setFILE_REAL_NAME((String)value);
	            return;  
        
             case 4 :
                    this.setSYS_FILE_NAME((String)value);
	            return;  
        
             case 5 :
                    this.setFILE_SIZE((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setDOWN_HIT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_BBS_COM_FILESHelper.toXML(this);
  }
  
}
