

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_WORK_RESULTS
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(4):  
*               YEAR:VARCHAR2(4):  
*               WORK_ROM:VARCHAR2(15):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               TMP_WRT_NUM:VARCHAR2(12):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_WORK_RESULTSEntity extends ValueObject{

  
     private String SEQ;
  
     private String YEAR;
  
     private String WORK_ROM;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String TMP_WRT_NUM;
  

//생성자를 만든다
    public PT_R_WORK_RESULTSEntity(){
    }
    
    
    public PT_R_WORK_RESULTSEntity(String SEQ,String TMP_WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_WORK_RESULTSEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
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
		this.YEAR =request.getParameter("YEAR");
		this.WORK_ROM =request.getParameter("WORK_ROM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.YEAR =KJFMi.dsGet(ds, arg_row, "YEAR");
		this.WORK_ROM =KJFMi.dsGet(ds, arg_row, "WORK_ROM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getYEAR(){
             return YEAR;
     };
  
     public String getWORK_ROM(){
             return WORK_ROM;
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
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setYEAR(String YEAR){
            this.YEAR=YEAR;
     };
  
     public void setWORK_ROM(String WORK_ROM){
            this.WORK_ROM=WORK_ROM;
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
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("YEAR:"+ this.getYEAR()+"\n");
      
      strB.append("WORK_ROM:"+ this.getWORK_ROM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_WORK_RESULTSHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_WORK_RESULTSHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_WORK_RESULTSHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_WORK_RESULTSHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_WORK_RESULTSHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_WORK_RESULTSEntity();
  }

  public ValueObject getClone(){
         PT_R_WORK_RESULTSEntity newEnt = new PT_R_WORK_RESULTSEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setYEAR(this.getYEAR());
         
          newEnt.setWORK_ROM(this.getWORK_ROM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_WORK_RESULTSHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getYEAR();
        
             case 3 :
                 return  this.getWORK_ROM();
        
             case 4 :
                 return  this.getWRT_ID();
        
             case 5 :
                 return  this.getUPD_DT();
        
             case 6 :
                 return  this.getINS_DT();
        
             case 7 :
                 return  this.getTMP_WRT_NUM();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_WORK_RESULTSHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setYEAR((String)value);
	            return;  
        
             case 3 :
                    this.setWORK_ROM((String)value);
	            return;  
        
             case 4 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 5 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 6 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 7 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_WORK_RESULTSHelper.toXML(this);
  }
  
}
