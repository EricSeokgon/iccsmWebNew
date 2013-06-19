

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_SUBSIDIARY_TEMP
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(3):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               RECV_NUM:VARCHAR2(20):  
*               SUB_WRT_NUM:VARCHAR2(50):  
*               SUB_CODE:VARCHAR2(6):  
*               SUB_PROC:VARCHAR2(2):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_SUBSIDIARY_TEMPEntity extends ValueObject{

  
     private String SEQ;
  
     private String TMP_WRT_NUM;
  
     private String RECV_NUM;
  
     private String SUB_WRT_NUM;
  
     private String SUB_CODE;
  
     private String SUB_PROC;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_R_SUBSIDIARY_TEMPEntity(){
    }
    
    
    public PT_R_SUBSIDIARY_TEMPEntity(String RECV_NUM,String SEQ,String TMP_WRT_NUM ){
       this.setRECV_NUM(RECV_NUM);
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_SUBSIDIARY_TEMPEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SUB_WRT_NUM =request.getParameter("SUB_WRT_NUM");
		this.SUB_CODE =request.getParameter("SUB_CODE");
		this.SUB_PROC =request.getParameter("SUB_PROC");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SUB_WRT_NUM =KJFMi.dsGet(ds, arg_row, "SUB_WRT_NUM");
		this.SUB_CODE =KJFMi.dsGet(ds, arg_row, "SUB_CODE");
		this.SUB_PROC =KJFMi.dsGet(ds, arg_row, "SUB_PROC");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSUB_WRT_NUM(){
             return SUB_WRT_NUM;
     };
  
     public String getSUB_CODE(){
             return SUB_CODE;
     };
  
     public String getSUB_PROC(){
             return SUB_PROC;
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
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSUB_WRT_NUM(String SUB_WRT_NUM){
            this.SUB_WRT_NUM=SUB_WRT_NUM;
     };
  
     public void setSUB_CODE(String SUB_CODE){
            this.SUB_CODE=SUB_CODE;
     };
  
     public void setSUB_PROC(String SUB_PROC){
            this.SUB_PROC=SUB_PROC;
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
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SUB_WRT_NUM:"+ this.getSUB_WRT_NUM()+"\n");
      
      strB.append("SUB_CODE:"+ this.getSUB_CODE()+"\n");
      
      strB.append("SUB_PROC:"+ this.getSUB_PROC()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_SUBSIDIARY_TEMPHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_SUBSIDIARY_TEMPHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_SUBSIDIARY_TEMPHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_SUBSIDIARY_TEMPHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_SUBSIDIARY_TEMPHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSEQ();
       values[2]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_SUBSIDIARY_TEMPEntity();
  }

  public ValueObject getClone(){
         PT_R_SUBSIDIARY_TEMPEntity newEnt = new PT_R_SUBSIDIARY_TEMPEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSUB_WRT_NUM(this.getSUB_WRT_NUM());
         
          newEnt.setSUB_CODE(this.getSUB_CODE());
         
          newEnt.setSUB_PROC(this.getSUB_PROC());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_SUBSIDIARY_TEMPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getRECV_NUM();
        
             case 4 :
                 return  this.getSUB_WRT_NUM();
        
             case 5 :
                 return  this.getSUB_CODE();
        
             case 6 :
                 return  this.getSUB_PROC();
        
             case 7 :
                 return  this.getWRT_ID();
        
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
         Integer idx = (Integer)PT_R_SUBSIDIARY_TEMPHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setSUB_WRT_NUM((String)value);
	            return;  
        
             case 5 :
                    this.setSUB_CODE((String)value);
	            return;  
        
             case 6 :
                    this.setSUB_PROC((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
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
         return PT_R_SUBSIDIARY_TEMPHelper.toXML(this);
  }
  
}
