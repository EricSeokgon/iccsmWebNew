

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_NEGLIGENCE
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               OPIN_COLL_DT:VARCHAR2(8):  
*               OPIN_COLL_CONT:VARCHAR2(1024):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               NEFI:NUMBER(14):  
*               PAY_LIM:VARCHAR2(8):  
*               PAY_DT:VARCHAR2(8):  
*               PAY_YN:VARCHAR2(1):  
*               REMARK:VARCHAR2(512):  
*               DESION_DATE:VARCHAR2(8):  
*               LIS_END_DATE:VARCHAR2(8):  
*               OPINI_SUBMIT:VARCHAR2(1):  
*               BEFORE_DISPO:VARCHAR2(1):  
*               OPINI_SUBMIT_DATE:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_NEGLIGENCEEntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String OPIN_COLL_DT;
  
     private String OPIN_COLL_CONT;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String NEFI;
  
     private String PAY_LIM;
  
     private String PAY_DT;
  
     private String PAY_YN;
  
     private String REMARK;
  
     private String DESION_DATE;
  
     private String LIS_END_DATE;
  
     private String OPINI_SUBMIT;
  
     private String BEFORE_DISPO;
  
     private String OPINI_SUBMIT_DATE;
  

//생성자를 만든다
    public PT_M_NEGLIGENCEEntity(){
    }
    
    
    public PT_M_NEGLIGENCEEntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_NEGLIGENCEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
       value = ent.getByName("WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.OPIN_COLL_DT =request.getParameter("OPIN_COLL_DT");
		this.OPIN_COLL_CONT =request.getParameter("OPIN_COLL_CONT");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.NEFI =request.getParameter("NEFI");
		this.PAY_LIM =request.getParameter("PAY_LIM");
		this.PAY_DT =request.getParameter("PAY_DT");
		this.PAY_YN =request.getParameter("PAY_YN");
		this.REMARK =request.getParameter("REMARK");
		this.DESION_DATE =request.getParameter("DESION_DATE");
		this.LIS_END_DATE =request.getParameter("LIS_END_DATE");
		this.OPINI_SUBMIT =request.getParameter("OPINI_SUBMIT");
		this.BEFORE_DISPO =request.getParameter("BEFORE_DISPO");
		this.OPINI_SUBMIT_DATE =request.getParameter("OPINI_SUBMIT_DATE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.OPIN_COLL_DT =KJFMi.dsGet(ds, arg_row, "OPIN_COLL_DT");
		this.OPIN_COLL_CONT =KJFMi.dsGet(ds, arg_row, "OPIN_COLL_CONT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.NEFI =KJFMi.dsGet(ds, arg_row, "NEFI");
		this.PAY_LIM =KJFMi.dsGet(ds, arg_row, "PAY_LIM");
		this.PAY_DT =KJFMi.dsGet(ds, arg_row, "PAY_DT");
		this.PAY_YN =KJFMi.dsGet(ds, arg_row, "PAY_YN");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.DESION_DATE =KJFMi.dsGet(ds, arg_row, "DESION_DATE");
		this.LIS_END_DATE =KJFMi.dsGet(ds, arg_row, "LIS_END_DATE");
		this.OPINI_SUBMIT =KJFMi.dsGet(ds, arg_row, "OPINI_SUBMIT");
		this.BEFORE_DISPO =KJFMi.dsGet(ds, arg_row, "BEFORE_DISPO");
		this.OPINI_SUBMIT_DATE =KJFMi.dsGet(ds, arg_row, "OPINI_SUBMIT_DATE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getOPIN_COLL_DT(){
             return OPIN_COLL_DT;
     };
  
     public String getOPIN_COLL_CONT(){
             return OPIN_COLL_CONT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getNEFI(){
             return NEFI;
     };
  
     public String getPAY_LIM(){
             return PAY_LIM;
     };
  
     public String getPAY_DT(){
             return PAY_DT;
     };
  
     public String getPAY_YN(){
             return PAY_YN;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getDESION_DATE(){
             return DESION_DATE;
     };
  
     public String getLIS_END_DATE(){
             return LIS_END_DATE;
     };
  
     public String getOPINI_SUBMIT(){
             return OPINI_SUBMIT;
     };
  
     public String getBEFORE_DISPO(){
             return BEFORE_DISPO;
     };
  
     public String getOPINI_SUBMIT_DATE(){
             return OPINI_SUBMIT_DATE;
     };
  

//Setter 함수를 만든다
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setOPIN_COLL_DT(String OPIN_COLL_DT){
            this.OPIN_COLL_DT=OPIN_COLL_DT;
     };
  
     public void setOPIN_COLL_CONT(String OPIN_COLL_CONT){
            this.OPIN_COLL_CONT=OPIN_COLL_CONT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setNEFI(String NEFI){
            this.NEFI=NEFI;
     };
  
     public void setPAY_LIM(String PAY_LIM){
            this.PAY_LIM=PAY_LIM;
     };
  
     public void setPAY_DT(String PAY_DT){
            this.PAY_DT=PAY_DT;
     };
  
     public void setPAY_YN(String PAY_YN){
            this.PAY_YN=PAY_YN;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setDESION_DATE(String DESION_DATE){
            this.DESION_DATE=DESION_DATE;
     };
  
     public void setLIS_END_DATE(String LIS_END_DATE){
            this.LIS_END_DATE=LIS_END_DATE;
     };
  
     public void setOPINI_SUBMIT(String OPINI_SUBMIT){
            this.OPINI_SUBMIT=OPINI_SUBMIT;
     };
  
     public void setBEFORE_DISPO(String BEFORE_DISPO){
            this.BEFORE_DISPO=BEFORE_DISPO;
     };
  
     public void setOPINI_SUBMIT_DATE(String OPINI_SUBMIT_DATE){
            this.OPINI_SUBMIT_DATE=OPINI_SUBMIT_DATE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("OPIN_COLL_DT:"+ this.getOPIN_COLL_DT()+"\n");
      
      strB.append("OPIN_COLL_CONT:"+ this.getOPIN_COLL_CONT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("NEFI:"+ this.getNEFI()+"\n");
      
      strB.append("PAY_LIM:"+ this.getPAY_LIM()+"\n");
      
      strB.append("PAY_DT:"+ this.getPAY_DT()+"\n");
      
      strB.append("PAY_YN:"+ this.getPAY_YN()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("DESION_DATE:"+ this.getDESION_DATE()+"\n");
      
      strB.append("LIS_END_DATE:"+ this.getLIS_END_DATE()+"\n");
      
      strB.append("OPINI_SUBMIT:"+ this.getOPINI_SUBMIT()+"\n");
      
      strB.append("BEFORE_DISPO:"+ this.getBEFORE_DISPO()+"\n");
      
      strB.append("OPINI_SUBMIT_DATE:"+ this.getOPINI_SUBMIT_DATE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_NEGLIGENCEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_NEGLIGENCEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_NEGLIGENCEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_NEGLIGENCEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_NEGLIGENCEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_NEGLIGENCEEntity();
  }

  public ValueObject getClone(){
         PT_M_NEGLIGENCEEntity newEnt = new PT_M_NEGLIGENCEEntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setOPIN_COLL_DT(this.getOPIN_COLL_DT());
         
          newEnt.setOPIN_COLL_CONT(this.getOPIN_COLL_CONT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setNEFI(this.getNEFI());
         
          newEnt.setPAY_LIM(this.getPAY_LIM());
         
          newEnt.setPAY_DT(this.getPAY_DT());
         
          newEnt.setPAY_YN(this.getPAY_YN());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setDESION_DATE(this.getDESION_DATE());
         
          newEnt.setLIS_END_DATE(this.getLIS_END_DATE());
         
          newEnt.setOPINI_SUBMIT(this.getOPINI_SUBMIT());
         
          newEnt.setBEFORE_DISPO(this.getBEFORE_DISPO());
         
          newEnt.setOPINI_SUBMIT_DATE(this.getOPINI_SUBMIT_DATE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_NEGLIGENCEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getOPIN_COLL_DT();
        
             case 4 :
                 return  this.getOPIN_COLL_CONT();
        
             case 5 :
                 return  this.getINS_DT();
        
             case 6 :
                 return  this.getUPD_DT();
        
             case 7 :
                 return  this.getWRT_ID();
        
             case 8 :
                 return  this.getNEFI();
        
             case 9 :
                 return  this.getPAY_LIM();
        
             case 10 :
                 return  this.getPAY_DT();
        
             case 11 :
                 return  this.getPAY_YN();
        
             case 12 :
                 return  this.getREMARK();
        
             case 13 :
                 return  this.getDESION_DATE();
        
             case 14 :
                 return  this.getLIS_END_DATE();
        
             case 15 :
                 return  this.getOPINI_SUBMIT();
        
             case 16 :
                 return  this.getBEFORE_DISPO();
        
             case 17 :
                 return  this.getOPINI_SUBMIT_DATE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_NEGLIGENCEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setOPIN_COLL_DT((String)value);
	            return;  
        
             case 4 :
                    this.setOPIN_COLL_CONT((String)value);
	            return;  
        
             case 5 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 6 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 7 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 8 :
                    this.setNEFI((String)value);
	            return;  
        
             case 9 :
                    this.setPAY_LIM((String)value);
	            return;  
        
             case 10 :
                    this.setPAY_DT((String)value);
	            return;  
        
             case 11 :
                    this.setPAY_YN((String)value);
	            return;  
        
             case 12 :
                    this.setREMARK((String)value);
	            return;  
        
             case 13 :
                    this.setDESION_DATE((String)value);
	            return;  
        
             case 14 :
                    this.setLIS_END_DATE((String)value);
	            return;  
        
             case 15 :
                    this.setOPINI_SUBMIT((String)value);
	            return;  
        
             case 16 :
                    this.setBEFORE_DISPO((String)value);
	            return;  
        
             case 17 :
                    this.setOPINI_SUBMIT_DATE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_NEGLIGENCEHelper.toXML(this);
  }
  
}
