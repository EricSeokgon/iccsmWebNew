

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_C_RES_NORMAL_LINE
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               ORG_NM:VARCHAR2(52):  
*               SIDO_CODE:VARCHAR2(5):  
*               NOR_TEL:NUMBER(10):  
*               DID:NUMBER(10):  
*               DOD_INSIDE:NUMBER(10):  
*               REMARK:VARCHAR2(125):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(12):  
*               SIGUNGU_CODE:VARCHAR2(5):  
*               DOD_SINGLE:NUMBER(10):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_C_RES_NORMAL_LINEEntity extends ValueObject{

  
     private String SEQ;
  
     private String ORG_NM;
  
     private String SIDO_CODE;
  
     private String NOR_TEL;
  
     private String DID;
  
     private String DOD_INSIDE;
  
     private String REMARK;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIGUNGU_CODE;
  
     private String DOD_SINGLE;
  

//생성자를 만든다
    public PT_C_RES_NORMAL_LINEEntity(){
    }
    
    
    public PT_C_RES_NORMAL_LINEEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_C_RES_NORMAL_LINEEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.ORG_NM =request.getParameter("ORG_NM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.NOR_TEL =request.getParameter("NOR_TEL");
		this.DID =request.getParameter("DID");
		this.DOD_INSIDE =request.getParameter("DOD_INSIDE");
		this.REMARK =request.getParameter("REMARK");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.DOD_SINGLE =request.getParameter("DOD_SINGLE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.ORG_NM =KJFMi.dsGet(ds, arg_row, "ORG_NM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.NOR_TEL =KJFMi.dsGet(ds, arg_row, "NOR_TEL");
		this.DID =KJFMi.dsGet(ds, arg_row, "DID");
		this.DOD_INSIDE =KJFMi.dsGet(ds, arg_row, "DOD_INSIDE");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.DOD_SINGLE =KJFMi.dsGet(ds, arg_row, "DOD_SINGLE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getORG_NM(){
             return ORG_NM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getNOR_TEL(){
             return NOR_TEL;
     };
  
     public String getDID(){
             return DID;
     };
  
     public String getDOD_INSIDE(){
             return DOD_INSIDE;
     };
  
     public String getREMARK(){
             return REMARK;
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
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getDOD_SINGLE(){
             return DOD_SINGLE;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setORG_NM(String ORG_NM){
            this.ORG_NM=ORG_NM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setNOR_TEL(String NOR_TEL){
            this.NOR_TEL=NOR_TEL;
     };
  
     public void setDID(String DID){
            this.DID=DID;
     };
  
     public void setDOD_INSIDE(String DOD_INSIDE){
            this.DOD_INSIDE=DOD_INSIDE;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
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
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setDOD_SINGLE(String DOD_SINGLE){
            this.DOD_SINGLE=DOD_SINGLE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("ORG_NM:"+ this.getORG_NM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("NOR_TEL:"+ this.getNOR_TEL()+"\n");
      
      strB.append("DID:"+ this.getDID()+"\n");
      
      strB.append("DOD_INSIDE:"+ this.getDOD_INSIDE()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("DOD_SINGLE:"+ this.getDOD_SINGLE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_C_RES_NORMAL_LINEHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_C_RES_NORMAL_LINEHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_C_RES_NORMAL_LINEHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_C_RES_NORMAL_LINEHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_C_RES_NORMAL_LINEHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_C_RES_NORMAL_LINEEntity();
  }

  public ValueObject getClone(){
         PT_C_RES_NORMAL_LINEEntity newEnt = new PT_C_RES_NORMAL_LINEEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setORG_NM(this.getORG_NM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setNOR_TEL(this.getNOR_TEL());
         
          newEnt.setDID(this.getDID());
         
          newEnt.setDOD_INSIDE(this.getDOD_INSIDE());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setDOD_SINGLE(this.getDOD_SINGLE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_C_RES_NORMAL_LINEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getORG_NM();
        
             case 3 :
                 return  this.getSIDO_CODE();
        
             case 4 :
                 return  this.getNOR_TEL();
        
             case 5 :
                 return  this.getDID();
        
             case 6 :
                 return  this.getDOD_INSIDE();
        
             case 7 :
                 return  this.getREMARK();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getSIGUNGU_CODE();
        
             case 12 :
                 return  this.getDOD_SINGLE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_C_RES_NORMAL_LINEHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setORG_NM((String)value);
	            return;  
        
             case 3 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setNOR_TEL((String)value);
	            return;  
        
             case 5 :
                    this.setDID((String)value);
	            return;  
        
             case 6 :
                    this.setDOD_INSIDE((String)value);
	            return;  
        
             case 7 :
                    this.setREMARK((String)value);
	            return;  
        
             case 8 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 9 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 11 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 12 :
                    this.setDOD_SINGLE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_C_RES_NORMAL_LINEHelper.toXML(this);
  }
  
}
