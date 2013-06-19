

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_COMPANY_DIAGNOSTIC
*  테이블 설명 :
*  테이블 PK   :  
*               CHGBRE_SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               CHGBRE_SEQ:VARCHAR2(4):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DIAG_ORG_CODE:VARCHAR2(6):  
*               PAY_CAP:VARCHAR2(15):  
*               REA_CAP:VARCHAR2(15):  
*               TUP_AOM:VARCHAR2(15):  
*               TUP_CLASS_CODE:VARCHAR2(6):  
*               COMPANY_DIAG_CLASS_CODE:VARCHAR2(6):  
*               COMPANY_DIAG_BASDT:VARCHAR2(8):  
*               COMPANY_DIAG_ISSUEDT:VARCHAR2(8):  
*               DIAG_NM_NM:VARCHAR2(20):  
*               DIAG_NM_WRT_NUM:VARCHAR2(12):  
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

public class PT_R_COMPANY_DIAGNOSTICEntity extends ValueObject{

  
     private String CHGBRE_SEQ;
  
     private String TMP_WRT_NUM;
  
     private String DIAG_ORG_CODE;
  
     private String PAY_CAP;
  
     private String REA_CAP;
  
     private String TUP_AOM;
  
     private String TUP_CLASS_CODE;
  
     private String COMPANY_DIAG_CLASS_CODE;
  
     private String COMPANY_DIAG_BASDT;
  
     private String COMPANY_DIAG_ISSUEDT;
  
     private String DIAG_NM_NM;
  
     private String DIAG_NM_WRT_NUM;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_R_COMPANY_DIAGNOSTICEntity(){
    }
    
    
    public PT_R_COMPANY_DIAGNOSTICEntity(String CHGBRE_SEQ,String TMP_WRT_NUM ){
       this.setCHGBRE_SEQ(CHGBRE_SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_COMPANY_DIAGNOSTICEntity(ValueObject ent) throws Exception{
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
		this.DIAG_ORG_CODE =request.getParameter("DIAG_ORG_CODE");
		this.PAY_CAP =request.getParameter("PAY_CAP");
		this.REA_CAP =request.getParameter("REA_CAP");
		this.TUP_AOM =request.getParameter("TUP_AOM");
		this.TUP_CLASS_CODE =request.getParameter("TUP_CLASS_CODE");
		this.COMPANY_DIAG_CLASS_CODE =request.getParameter("COMPANY_DIAG_CLASS_CODE");
		this.COMPANY_DIAG_BASDT =request.getParameter("COMPANY_DIAG_BASDT");
		this.COMPANY_DIAG_ISSUEDT =request.getParameter("COMPANY_DIAG_ISSUEDT");
		this.DIAG_NM_NM =request.getParameter("DIAG_NM_NM");
		this.DIAG_NM_WRT_NUM =request.getParameter("DIAG_NM_WRT_NUM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DIAG_ORG_CODE =KJFMi.dsGet(ds, arg_row, "DIAG_ORG_CODE");
		this.PAY_CAP =KJFMi.dsGet(ds, arg_row, "PAY_CAP");
		this.REA_CAP =KJFMi.dsGet(ds, arg_row, "REA_CAP");
		this.TUP_AOM =KJFMi.dsGet(ds, arg_row, "TUP_AOM");
		this.TUP_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "TUP_CLASS_CODE");
		this.COMPANY_DIAG_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_CLASS_CODE");
		this.COMPANY_DIAG_BASDT =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_BASDT");
		this.COMPANY_DIAG_ISSUEDT =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_ISSUEDT");
		this.DIAG_NM_NM =KJFMi.dsGet(ds, arg_row, "DIAG_NM_NM");
		this.DIAG_NM_WRT_NUM =KJFMi.dsGet(ds, arg_row, "DIAG_NM_WRT_NUM");
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
  
     public String getDIAG_ORG_CODE(){
             return DIAG_ORG_CODE;
     };
  
     public String getPAY_CAP(){
             return PAY_CAP;
     };
  
     public String getREA_CAP(){
             return REA_CAP;
     };
  
     public String getTUP_AOM(){
             return TUP_AOM;
     };
  
     public String getTUP_CLASS_CODE(){
             return TUP_CLASS_CODE;
     };
  
     public String getCOMPANY_DIAG_CLASS_CODE(){
             return COMPANY_DIAG_CLASS_CODE;
     };
  
     public String getCOMPANY_DIAG_BASDT(){
             return COMPANY_DIAG_BASDT;
     };
  
     public String getCOMPANY_DIAG_ISSUEDT(){
             return COMPANY_DIAG_ISSUEDT;
     };
  
     public String getDIAG_NM_NM(){
             return DIAG_NM_NM;
     };
  
     public String getDIAG_NM_WRT_NUM(){
             return DIAG_NM_WRT_NUM;
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
  
     public void setDIAG_ORG_CODE(String DIAG_ORG_CODE){
            this.DIAG_ORG_CODE=DIAG_ORG_CODE;
     };
  
     public void setPAY_CAP(String PAY_CAP){
            this.PAY_CAP=PAY_CAP;
     };
  
     public void setREA_CAP(String REA_CAP){
            this.REA_CAP=REA_CAP;
     };
  
     public void setTUP_AOM(String TUP_AOM){
            this.TUP_AOM=TUP_AOM;
     };
  
     public void setTUP_CLASS_CODE(String TUP_CLASS_CODE){
            this.TUP_CLASS_CODE=TUP_CLASS_CODE;
     };
  
     public void setCOMPANY_DIAG_CLASS_CODE(String COMPANY_DIAG_CLASS_CODE){
            this.COMPANY_DIAG_CLASS_CODE=COMPANY_DIAG_CLASS_CODE;
     };
  
     public void setCOMPANY_DIAG_BASDT(String COMPANY_DIAG_BASDT){
            this.COMPANY_DIAG_BASDT=COMPANY_DIAG_BASDT;
     };
  
     public void setCOMPANY_DIAG_ISSUEDT(String COMPANY_DIAG_ISSUEDT){
            this.COMPANY_DIAG_ISSUEDT=COMPANY_DIAG_ISSUEDT;
     };
  
     public void setDIAG_NM_NM(String DIAG_NM_NM){
            this.DIAG_NM_NM=DIAG_NM_NM;
     };
  
     public void setDIAG_NM_WRT_NUM(String DIAG_NM_WRT_NUM){
            this.DIAG_NM_WRT_NUM=DIAG_NM_WRT_NUM;
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
      
      strB.append("DIAG_ORG_CODE:"+ this.getDIAG_ORG_CODE()+"\n");
      
      strB.append("PAY_CAP:"+ this.getPAY_CAP()+"\n");
      
      strB.append("REA_CAP:"+ this.getREA_CAP()+"\n");
      
      strB.append("TUP_AOM:"+ this.getTUP_AOM()+"\n");
      
      strB.append("TUP_CLASS_CODE:"+ this.getTUP_CLASS_CODE()+"\n");
      
      strB.append("COMPANY_DIAG_CLASS_CODE:"+ this.getCOMPANY_DIAG_CLASS_CODE()+"\n");
      
      strB.append("COMPANY_DIAG_BASDT:"+ this.getCOMPANY_DIAG_BASDT()+"\n");
      
      strB.append("COMPANY_DIAG_ISSUEDT:"+ this.getCOMPANY_DIAG_ISSUEDT()+"\n");
      
      strB.append("DIAG_NM_NM:"+ this.getDIAG_NM_NM()+"\n");
      
      strB.append("DIAG_NM_WRT_NUM:"+ this.getDIAG_NM_WRT_NUM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_COMPANY_DIAGNOSTICHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_COMPANY_DIAGNOSTICHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_COMPANY_DIAGNOSTICHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_COMPANY_DIAGNOSTICHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_COMPANY_DIAGNOSTICHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getCHGBRE_SEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_COMPANY_DIAGNOSTICEntity();
  }

  public ValueObject getClone(){
         PT_R_COMPANY_DIAGNOSTICEntity newEnt = new PT_R_COMPANY_DIAGNOSTICEntity();
	 
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDIAG_ORG_CODE(this.getDIAG_ORG_CODE());
         
          newEnt.setPAY_CAP(this.getPAY_CAP());
         
          newEnt.setREA_CAP(this.getREA_CAP());
         
          newEnt.setTUP_AOM(this.getTUP_AOM());
         
          newEnt.setTUP_CLASS_CODE(this.getTUP_CLASS_CODE());
         
          newEnt.setCOMPANY_DIAG_CLASS_CODE(this.getCOMPANY_DIAG_CLASS_CODE());
         
          newEnt.setCOMPANY_DIAG_BASDT(this.getCOMPANY_DIAG_BASDT());
         
          newEnt.setCOMPANY_DIAG_ISSUEDT(this.getCOMPANY_DIAG_ISSUEDT());
         
          newEnt.setDIAG_NM_NM(this.getDIAG_NM_NM());
         
          newEnt.setDIAG_NM_WRT_NUM(this.getDIAG_NM_WRT_NUM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_COMPANY_DIAGNOSTICHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCHGBRE_SEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getDIAG_ORG_CODE();
        
             case 4 :
                 return  this.getPAY_CAP();
        
             case 5 :
                 return  this.getREA_CAP();
        
             case 6 :
                 return  this.getTUP_AOM();
        
             case 7 :
                 return  this.getTUP_CLASS_CODE();
        
             case 8 :
                 return  this.getCOMPANY_DIAG_CLASS_CODE();
        
             case 9 :
                 return  this.getCOMPANY_DIAG_BASDT();
        
             case 10 :
                 return  this.getCOMPANY_DIAG_ISSUEDT();
        
             case 11 :
                 return  this.getDIAG_NM_NM();
        
             case 12 :
                 return  this.getDIAG_NM_WRT_NUM();
        
             case 13 :
                 return  this.getWRT_ID();
        
             case 14 :
                 return  this.getUPD_DT();
        
             case 15 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_COMPANY_DIAGNOSTICHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setDIAG_ORG_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setPAY_CAP((String)value);
	            return;  
        
             case 5 :
                    this.setREA_CAP((String)value);
	            return;  
        
             case 6 :
                    this.setTUP_AOM((String)value);
	            return;  
        
             case 7 :
                    this.setTUP_CLASS_CODE((String)value);
	            return;  
        
             case 8 :
                    this.setCOMPANY_DIAG_CLASS_CODE((String)value);
	            return;  
        
             case 9 :
                    this.setCOMPANY_DIAG_BASDT((String)value);
	            return;  
        
             case 10 :
                    this.setCOMPANY_DIAG_ISSUEDT((String)value);
	            return;  
        
             case 11 :
                    this.setDIAG_NM_NM((String)value);
	            return;  
        
             case 12 :
                    this.setDIAG_NM_WRT_NUM((String)value);
	            return;  
        
             case 13 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 14 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 15 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_COMPANY_DIAGNOSTICHelper.toXML(this);
  }
  
}
