

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ENGINEER_M_ACADEMIC
*  테이블 설명 :
*  테이블 PK   :  
*               CARE_BOOK_ISSUE_NUM  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(12):  
*               CARE_BOOK_ISSUE_NUM:VARCHAR2(15):  
*               SCHNM:VARCHAR2(50):  
*               SUBJ_MAJ:VARCHAR2(50):  
*               GRA_YMD:VARCHAR2(12):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_DT:VARCHAR2(24):  
*               ETC1:VARCHAR2(20):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_ENGINEER_M_ACADEMICEntity extends ValueObject{

  
     private String SEQ;
  
     private String CARE_BOOK_ISSUE_NUM;
  
     private String SCHNM;
  
     private String SUBJ_MAJ;
  
     private String GRA_YMD;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String WRT_DT;
  
     private String ETC1;
  

//생성자를 만든다
    public PT_R_ENGINEER_M_ACADEMICEntity(){
    }
    
    
    public PT_R_ENGINEER_M_ACADEMICEntity(String CARE_BOOK_ISSUE_NUM,String SEQ ){
       this.setCARE_BOOK_ISSUE_NUM(CARE_BOOK_ISSUE_NUM);
       this.setSEQ(SEQ);
       
    }
      
    public PT_R_ENGINEER_M_ACADEMICEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CARE_BOOK_ISSUE_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CARE_BOOK_ISSUE_NUM",value);
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.CARE_BOOK_ISSUE_NUM =request.getParameter("CARE_BOOK_ISSUE_NUM");
		this.SCHNM =request.getParameter("SCHNM");
		this.SUBJ_MAJ =request.getParameter("SUBJ_MAJ");
		this.GRA_YMD =request.getParameter("GRA_YMD");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_DT =request.getParameter("WRT_DT");
		this.ETC1 =request.getParameter("ETC1");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.CARE_BOOK_ISSUE_NUM =KJFMi.dsGet(ds, arg_row, "CARE_BOOK_ISSUE_NUM");
		this.SCHNM =KJFMi.dsGet(ds, arg_row, "SCHNM");
		this.SUBJ_MAJ =KJFMi.dsGet(ds, arg_row, "SUBJ_MAJ");
		this.GRA_YMD =KJFMi.dsGet(ds, arg_row, "GRA_YMD");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.ETC1 =KJFMi.dsGet(ds, arg_row, "ETC1");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getCARE_BOOK_ISSUE_NUM(){
             return CARE_BOOK_ISSUE_NUM;
     };
  
     public String getSCHNM(){
             return SCHNM;
     };
  
     public String getSUBJ_MAJ(){
             return SUBJ_MAJ;
     };
  
     public String getGRA_YMD(){
             return GRA_YMD;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  
     public String getETC1(){
             return ETC1;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setCARE_BOOK_ISSUE_NUM(String CARE_BOOK_ISSUE_NUM){
            this.CARE_BOOK_ISSUE_NUM=CARE_BOOK_ISSUE_NUM;
     };
  
     public void setSCHNM(String SCHNM){
            this.SCHNM=SCHNM;
     };
  
     public void setSUBJ_MAJ(String SUBJ_MAJ){
            this.SUBJ_MAJ=SUBJ_MAJ;
     };
  
     public void setGRA_YMD(String GRA_YMD){
            this.GRA_YMD=GRA_YMD;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
     public void setETC1(String ETC1){
            this.ETC1=ETC1;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("CARE_BOOK_ISSUE_NUM:"+ this.getCARE_BOOK_ISSUE_NUM()+"\n");
      
      strB.append("SCHNM:"+ this.getSCHNM()+"\n");
      
      strB.append("SUBJ_MAJ:"+ this.getSUBJ_MAJ()+"\n");
      
      strB.append("GRA_YMD:"+ this.getGRA_YMD()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("ETC1:"+ this.getETC1()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_ENGINEER_M_ACADEMICHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_ENGINEER_M_ACADEMICHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_ENGINEER_M_ACADEMICHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_ENGINEER_M_ACADEMICHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_ENGINEER_M_ACADEMICHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCARE_BOOK_ISSUE_NUM();
       values[1]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_ENGINEER_M_ACADEMICEntity();
  }

  public ValueObject getClone(){
         PT_R_ENGINEER_M_ACADEMICEntity newEnt = new PT_R_ENGINEER_M_ACADEMICEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setCARE_BOOK_ISSUE_NUM(this.getCARE_BOOK_ISSUE_NUM());
         
          newEnt.setSCHNM(this.getSCHNM());
         
          newEnt.setSUBJ_MAJ(this.getSUBJ_MAJ());
         
          newEnt.setGRA_YMD(this.getGRA_YMD());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setETC1(this.getETC1());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_ENGINEER_M_ACADEMICHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getCARE_BOOK_ISSUE_NUM();
        
             case 3 :
                 return  this.getSCHNM();
        
             case 4 :
                 return  this.getSUBJ_MAJ();
        
             case 5 :
                 return  this.getGRA_YMD();
        
             case 6 :
                 return  this.getWRT_ID();
        
             case 7 :
                 return  this.getUPD_DT();
        
             case 8 :
                 return  this.getWRT_DT();
        
             case 9 :
                 return  this.getETC1();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_ENGINEER_M_ACADEMICHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCARE_BOOK_ISSUE_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setSCHNM((String)value);
	            return;  
        
             case 4 :
                    this.setSUBJ_MAJ((String)value);
	            return;  
        
             case 5 :
                    this.setGRA_YMD((String)value);
	            return;  
        
             case 6 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 7 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 8 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 9 :
                    this.setETC1((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_ENGINEER_M_ACADEMICHelper.toXML(this);
  }
  
}
