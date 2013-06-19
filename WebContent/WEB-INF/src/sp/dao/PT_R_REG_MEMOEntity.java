

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REG_MEMO
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               MEMO_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               MEMO_SEQ:NUMBER(4):  
*               MEMO_CONT:VARCHAR2(512):  
*               WRT_DT:VARCHAR2(8):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               CHGBRE_SEQ:NUMBER(4):  
*               TMP_WRT_NUM:VARCHAR2(12):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_REG_MEMOEntity extends ValueObject{

  
     private String MEMO_SEQ;
  
     private String MEMO_CONT;
  
     private String WRT_DT;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  

//생성자를 만든다
    public PT_R_REG_MEMOEntity(){
    }
    
    
    public PT_R_REG_MEMOEntity(String CHGBRE_SEQ,String MEMO_SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setMEMO_SEQ(MEMO_SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_REG_MEMOEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CHGBRE_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CHGBRE_SEQ",value);
       
       value = ent.getByName("MEMO_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("MEMO_SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.MEMO_SEQ =request.getParameter("MEMO_SEQ");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.WRT_DT =request.getParameter("WRT_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.CHGBRE_SEQ =request.getParameter("CHGBRE_SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.MEMO_SEQ =KJFMi.dsGet(ds, arg_row, "MEMO_SEQ");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
				
    }    
    
//Getter 함수를 만든다
  
     public String getMEMO_SEQ(){
             return MEMO_SEQ;
     };
  
     public String getMEMO_CONT(){
             return MEMO_CONT;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  

//Setter 함수를 만든다
  
     public void setMEMO_SEQ(String MEMO_SEQ){
            this.MEMO_SEQ=MEMO_SEQ;
     };
  
     public void setMEMO_CONT(String MEMO_CONT){
            this.MEMO_CONT=MEMO_CONT;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("MEMO_SEQ:"+ this.getMEMO_SEQ()+"\n");
      
      strB.append("MEMO_CONT:"+ this.getMEMO_CONT()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_REG_MEMOHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_REG_MEMOHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_REG_MEMOHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_REG_MEMOHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_REG_MEMOHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getMEMO_SEQ();
       values[2]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_REG_MEMOEntity();
  }

  public ValueObject getClone(){
         PT_R_REG_MEMOEntity newEnt = new PT_R_REG_MEMOEntity();
	 
          newEnt.setMEMO_SEQ(this.getMEMO_SEQ());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_REG_MEMOHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getMEMO_SEQ();
        
             case 2 :
                 return  this.getMEMO_CONT();
        
             case 3 :
                 return  this.getWRT_DT();
        
             case 4 :
                 return  this.getUPD_DT();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getCHGBRE_SEQ();
        
             case 7 :
                 return  this.getTMP_WRT_NUM();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_REG_MEMOHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setMEMO_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 4 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 5 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 6 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 7 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_REG_MEMOHelper.toXML(this);
  }
  
}
