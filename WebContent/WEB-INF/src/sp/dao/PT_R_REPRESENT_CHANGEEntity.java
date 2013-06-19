

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REPRESENT_CHANGE
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:VARCHAR2(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               REP_SSN1:VARCHAR2(18):  
*               REP_SSN2:VARCHAR2(21):  
*               REP_NM_KOR:VARCHAR2(20):  
*               REP_NM_HAN:VARCHAR2(20):  
*               CHAR_REF_YN:VARCHAR2(1):  
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

public class PT_R_REPRESENT_CHANGEEntity extends ValueObject{

  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  
     private String REP_SSN1;
  
     private String REP_SSN2;
  
     private String REP_NM_KOR;
  
     private String REP_NM_HAN;
  
     private String CHAR_REF_YN;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_R_REPRESENT_CHANGEEntity(){
    }
    
    
    public PT_R_REPRESENT_CHANGEEntity(String CHGBRE_SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_REPRESENT_CHANGEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CHGBRE_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CHGBRE_SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CHGBRE_SEQ =request.getParameter("CHGBRE_SEQ");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.REP_SSN1 =request.getParameter("REP_SSN1");
		this.REP_SSN2 =request.getParameter("REP_SSN2");
		this.REP_NM_KOR =request.getParameter("REP_NM_KOR");
		this.REP_NM_HAN =request.getParameter("REP_NM_HAN");
		this.CHAR_REF_YN =request.getParameter("CHAR_REF_YN");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.REP_SSN1 =KJFMi.dsGet(ds, arg_row, "REP_SSN1");
		this.REP_SSN2 =KJFMi.dsGet(ds, arg_row, "REP_SSN2");
		this.REP_NM_KOR =KJFMi.dsGet(ds, arg_row, "REP_NM_KOR");
		this.REP_NM_HAN =KJFMi.dsGet(ds, arg_row, "REP_NM_HAN");
		this.CHAR_REF_YN =KJFMi.dsGet(ds, arg_row, "CHAR_REF_YN");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getREP_SSN1(){
             return REP_SSN1;
     };
  
     public String getREP_SSN2(){
             return REP_SSN2;
     };
  
     public String getREP_NM_KOR(){
             return REP_NM_KOR;
     };
  
     public String getREP_NM_HAN(){
             return REP_NM_HAN;
     };
  
     public String getCHAR_REF_YN(){
             return CHAR_REF_YN;
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
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setREP_SSN1(String REP_SSN1){
            this.REP_SSN1=REP_SSN1;
     };
  
     public void setREP_SSN2(String REP_SSN2){
            this.REP_SSN2=REP_SSN2;
     };
  
     public void setREP_NM_KOR(String REP_NM_KOR){
            this.REP_NM_KOR=REP_NM_KOR;
     };
  
     public void setREP_NM_HAN(String REP_NM_HAN){
            this.REP_NM_HAN=REP_NM_HAN;
     };
  
     public void setCHAR_REF_YN(String CHAR_REF_YN){
            this.CHAR_REF_YN=CHAR_REF_YN;
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
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("REP_SSN1:"+ this.getREP_SSN1()+"\n");
      
      strB.append("REP_SSN2:"+ this.getREP_SSN2()+"\n");
      
      strB.append("REP_NM_KOR:"+ this.getREP_NM_KOR()+"\n");
      
      strB.append("REP_NM_HAN:"+ this.getREP_NM_HAN()+"\n");
      
      strB.append("CHAR_REF_YN:"+ this.getCHAR_REF_YN()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_REPRESENT_CHANGEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_REPRESENT_CHANGEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_REPRESENT_CHANGEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_REPRESENT_CHANGEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_REPRESENT_CHANGEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_REPRESENT_CHANGEEntity();
  }

  public ValueObject getClone(){
         PT_R_REPRESENT_CHANGEEntity newEnt = new PT_R_REPRESENT_CHANGEEntity();
	 
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setREP_SSN1(this.getREP_SSN1());
         
          newEnt.setREP_SSN2(this.getREP_SSN2());
         
          newEnt.setREP_NM_KOR(this.getREP_NM_KOR());
         
          newEnt.setREP_NM_HAN(this.getREP_NM_HAN());
         
          newEnt.setCHAR_REF_YN(this.getCHAR_REF_YN());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_REPRESENT_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCHGBRE_SEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getREP_SSN1();
        
             case 4 :
                 return  this.getREP_SSN2();
        
             case 5 :
                 return  this.getREP_NM_KOR();
        
             case 6 :
                 return  this.getREP_NM_HAN();
        
             case 7 :
                 return  this.getCHAR_REF_YN();
        
             case 8 :
                 return  this.getWRT_ID();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_REPRESENT_CHANGEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setREP_SSN1((String)value);
	            return;  
        
             case 4 :
                    this.setREP_SSN2((String)value);
	            return;  
        
             case 5 :
                    this.setREP_NM_KOR((String)value);
	            return;  
        
             case 6 :
                    this.setREP_NM_HAN((String)value);
	            return;  
        
             case 7 :
                    this.setCHAR_REF_YN((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 9 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 10 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_REPRESENT_CHANGEHelper.toXML(this);
  }
  
}
