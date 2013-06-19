

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_FILE
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               FILE_NM:VARCHAR2(100):  
*               FILE_SIZE:VARCHAR2(10):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SEQ:NUMBER(22):  
*               RECV_NUM:VARCHAR2(30):  
*               SIDO_CODE:VARCHAR2(5):  
*               SIGUNGU_CODE:VARCHAR2(4):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               SYS_FILE_NAME:VARCHAR2(281):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_FILEEntity extends ValueObject{

  
     private String FILE_NM;
  
     private String FILE_SIZE;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String SEQ;
  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  
     private String UPD_DT_OLD;
  
     private String BACKUP_TRANS_DT;
  
     private String SYS_FILE_NAME;
  

//생성자를 만든다
    public PT_UB_FILEEntity(){
    }
    
    
    public PT_UB_FILEEntity(String RECV_NUM,String SEQ,String SIDO_CODE,String SIGUNGU_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSEQ(SEQ);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_UB_FILEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
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
		this.FILE_NM =request.getParameter("FILE_NM");
		this.FILE_SIZE =request.getParameter("FILE_SIZE");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.SEQ =request.getParameter("SEQ");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.UPD_DT_OLD =request.getParameter("UPD_DT_OLD");
		this.BACKUP_TRANS_DT =request.getParameter("BACKUP_TRANS_DT");
		this.SYS_FILE_NAME =request.getParameter("SYS_FILE_NAME");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.FILE_NM =KJFMi.dsGet(ds, arg_row, "FILE_NM");
		this.FILE_SIZE =KJFMi.dsGet(ds, arg_row, "FILE_SIZE");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.UPD_DT_OLD =KJFMi.dsGet(ds, arg_row, "UPD_DT_OLD");
		this.BACKUP_TRANS_DT =KJFMi.dsGet(ds, arg_row, "BACKUP_TRANS_DT");
		this.SYS_FILE_NAME =KJFMi.dsGet(ds, arg_row, "SYS_FILE_NAME");
				
    }    
    
//Getter 함수를 만든다
  
     public String getFILE_NM(){
             return FILE_NM;
     };
  
     public String getFILE_SIZE(){
             return FILE_SIZE;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getUPD_DT_OLD(){
             return UPD_DT_OLD;
     };
  
     public String getBACKUP_TRANS_DT(){
             return BACKUP_TRANS_DT;
     };
  
     public String getSYS_FILE_NAME(){
             return SYS_FILE_NAME;
     };
  

//Setter 함수를 만든다
  
     public void setFILE_NM(String FILE_NM){
            this.FILE_NM=FILE_NM;
     };
  
     public void setFILE_SIZE(String FILE_SIZE){
            this.FILE_SIZE=FILE_SIZE;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setUPD_DT_OLD(String UPD_DT_OLD){
            this.UPD_DT_OLD=UPD_DT_OLD;
     };
  
     public void setBACKUP_TRANS_DT(String BACKUP_TRANS_DT){
            this.BACKUP_TRANS_DT=BACKUP_TRANS_DT;
     };
  
     public void setSYS_FILE_NAME(String SYS_FILE_NAME){
            this.SYS_FILE_NAME=SYS_FILE_NAME;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("FILE_NM:"+ this.getFILE_NM()+"\n");
      
      strB.append("FILE_SIZE:"+ this.getFILE_SIZE()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("UPD_DT_OLD:"+ this.getUPD_DT_OLD()+"\n");
      
      strB.append("BACKUP_TRANS_DT:"+ this.getBACKUP_TRANS_DT()+"\n");
      
      strB.append("SYS_FILE_NAME:"+ this.getSYS_FILE_NAME()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_FILEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_FILEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_FILEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_FILEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_FILEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[4];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSEQ();
       values[2]= this.getSIDO_CODE();
       values[3]= this.getSIGUNGU_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_FILEEntity();
  }

  public ValueObject getClone(){
         PT_UB_FILEEntity newEnt = new PT_UB_FILEEntity();
	 
          newEnt.setFILE_NM(this.getFILE_NM());
         
          newEnt.setFILE_SIZE(this.getFILE_SIZE());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setUPD_DT_OLD(this.getUPD_DT_OLD());
         
          newEnt.setBACKUP_TRANS_DT(this.getBACKUP_TRANS_DT());
         
          newEnt.setSYS_FILE_NAME(this.getSYS_FILE_NAME());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_FILEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getFILE_NM();
        
             case 2 :
                 return  this.getFILE_SIZE();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getINS_DT();
        
             case 5 :
                 return  this.getUPD_DT();
        
             case 6 :
                 return  this.getSEQ();
        
             case 7 :
                 return  this.getRECV_NUM();
        
             case 8 :
                 return  this.getSIDO_CODE();
        
             case 9 :
                 return  this.getSIGUNGU_CODE();
        
             case 10 :
                 return  this.getUPD_DT_OLD();
        
             case 11 :
                 return  this.getBACKUP_TRANS_DT();
        
             case 12 :
                 return  this.getSYS_FILE_NAME();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_FILEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setFILE_NM((String)value);
	            return;  
        
             case 2 :
                    this.setFILE_SIZE((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 4 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 5 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 6 :
                    this.setSEQ((String)value);
	            return;  
        
             case 7 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 9 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 10 :
                    this.setUPD_DT_OLD((String)value);
	            return;  
        
             case 11 :
                    this.setBACKUP_TRANS_DT((String)value);
	            return;  
        
             case 12 :
                    this.setSYS_FILE_NAME((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_FILEHelper.toXML(this);
  }
  
}
