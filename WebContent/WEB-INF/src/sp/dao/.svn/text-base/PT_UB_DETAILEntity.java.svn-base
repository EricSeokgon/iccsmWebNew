

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_DETAIL
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               SIDO_CODE  
*               SIGUNGU_CODE  
*               SRL
*  테이블 컬럼 :  
*               DETAIL_CONT:VARCHAR2(100):  
*               ITEM_OUT:VARCHAR2(4):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SRL:NUMBER(4):  
*               SEQ:NUMBER(22):  
*               SIDO_CODE:VARCHAR2(5):  
*               RECV_NUM:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_DETAILEntity extends ValueObject{

  
     private String DETAIL_CONT;
  
     private String ITEM_OUT;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String SRL;
  
     private String SEQ;
  
     private String SIDO_CODE;
  
     private String RECV_NUM;
  
     private String SIGUNGU_CODE;
  

//생성자를 만든다
    public PT_UB_DETAILEntity(){
    }
    
    
    public PT_UB_DETAILEntity(String RECV_NUM,String SEQ,String SIDO_CODE,String SIGUNGU_CODE,String SRL ){
       this.setRECV_NUM(RECV_NUM);
       this.setSEQ(SEQ);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       this.setSRL(SRL);
       
    }
      
    public PT_UB_DETAILEntity(ValueObject ent) throws Exception{
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
       
       value = ent.getByName("SRL");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SRL",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.DETAIL_CONT =request.getParameter("DETAIL_CONT");
		this.ITEM_OUT =request.getParameter("ITEM_OUT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.SRL =request.getParameter("SRL");
		this.SEQ =request.getParameter("SEQ");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.DETAIL_CONT =KJFMi.dsGet(ds, arg_row, "DETAIL_CONT");
		this.ITEM_OUT =KJFMi.dsGet(ds, arg_row, "ITEM_OUT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.SRL =KJFMi.dsGet(ds, arg_row, "SRL");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getDETAIL_CONT(){
             return DETAIL_CONT;
     };
  
     public String getITEM_OUT(){
             return ITEM_OUT;
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
  
     public String getSRL(){
             return SRL;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  

//Setter 함수를 만든다
  
     public void setDETAIL_CONT(String DETAIL_CONT){
            this.DETAIL_CONT=DETAIL_CONT;
     };
  
     public void setITEM_OUT(String ITEM_OUT){
            this.ITEM_OUT=ITEM_OUT;
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
  
     public void setSRL(String SRL){
            this.SRL=SRL;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("DETAIL_CONT:"+ this.getDETAIL_CONT()+"\n");
      
      strB.append("ITEM_OUT:"+ this.getITEM_OUT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("SRL:"+ this.getSRL()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_DETAILHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_DETAILHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_DETAILHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_DETAILHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_DETAILHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[5];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSEQ();
       values[2]= this.getSIDO_CODE();
       values[3]= this.getSIGUNGU_CODE();
       values[4]= this.getSRL();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_DETAILEntity();
  }

  public ValueObject getClone(){
         PT_UB_DETAILEntity newEnt = new PT_UB_DETAILEntity();
	 
          newEnt.setDETAIL_CONT(this.getDETAIL_CONT());
         
          newEnt.setITEM_OUT(this.getITEM_OUT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setSRL(this.getSRL());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_DETAILHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getDETAIL_CONT();
        
             case 2 :
                 return  this.getITEM_OUT();
        
             case 3 :
                 return  this.getWRT_ID();
        
             case 4 :
                 return  this.getINS_DT();
        
             case 5 :
                 return  this.getUPD_DT();
        
             case 6 :
                 return  this.getSRL();
        
             case 7 :
                 return  this.getSEQ();
        
             case 8 :
                 return  this.getSIDO_CODE();
        
             case 9 :
                 return  this.getRECV_NUM();
        
             case 10 :
                 return  this.getSIGUNGU_CODE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_DETAILHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setDETAIL_CONT((String)value);
	            return;  
        
             case 2 :
                    this.setITEM_OUT((String)value);
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
                    this.setSRL((String)value);
	            return;  
        
             case 7 :
                    this.setSEQ((String)value);
	            return;  
        
             case 8 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 9 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 10 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_DETAILHelper.toXML(this);
  }
  
}
