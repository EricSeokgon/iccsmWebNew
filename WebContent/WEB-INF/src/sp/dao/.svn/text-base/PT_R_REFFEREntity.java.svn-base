

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REFFER
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(3):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               SI_DO_CODE:VARCHAR2(4):  
*               SI_GUN_GU_CODE:VARCHAR2(4):  
*               POS_CLASS:VARCHAR2(6):  
*               ENT_DT:VARCHAR2(8):  
*               RET_DT:VARCHAR2(8):  
*               NM_KOR:VARCHAR2(20):  
*               NM_HAN:VARCHAR2(20):  
*               ORI:VARCHAR2(200):  
*               ADDR:VARCHAR2(200):  
*               SSN1:VARCHAR2(18):  
*               SSN2:VARCHAR2(21):  
*               HEFA:VARCHAR2(10):  
*               HEFA_RELA:VARCHAR2(10):  
*               REMARK:VARCHAR2(256):  
*               CHAR_REF_YN:VARCHAR2(2):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SEND_YN:VARCHAR2(1):  
*               FOREIGN_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_REFFEREntity extends ValueObject{

  
     private String SEQ;
  
     private String TMP_WRT_NUM;
  
     private String SI_DO_CODE;
  
     private String SI_GUN_GU_CODE;
  
     private String POS_CLASS;
  
     private String ENT_DT;
  
     private String RET_DT;
  
     private String NM_KOR;
  
     private String NM_HAN;
  
     private String ORI;
  
     private String ADDR;
  
     private String SSN1;
  
     private String SSN2;
  
     private String HEFA;
  
     private String HEFA_RELA;
  
     private String REMARK;
  
     private String CHAR_REF_YN;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String SEND_YN;
  
     private String FOREIGN_YN;
  

//생성자를 만든다
    public PT_R_REFFEREntity(){
    }
    
    
    public PT_R_REFFEREntity(String SEQ,String TMP_WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       
    }
      
    public PT_R_REFFEREntity(ValueObject ent) throws Exception{
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
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.SI_DO_CODE =request.getParameter("SI_DO_CODE");
		this.SI_GUN_GU_CODE =request.getParameter("SI_GUN_GU_CODE");
		this.POS_CLASS =request.getParameter("POS_CLASS");
		this.ENT_DT =request.getParameter("ENT_DT");
		this.RET_DT =request.getParameter("RET_DT");
		this.NM_KOR =request.getParameter("NM_KOR");
		this.NM_HAN =request.getParameter("NM_HAN");
		this.ORI =request.getParameter("ORI");
		this.ADDR =request.getParameter("ADDR");
		this.SSN1 =request.getParameter("SSN1");
		this.SSN2 =request.getParameter("SSN2");
		this.HEFA =request.getParameter("HEFA");
		this.HEFA_RELA =request.getParameter("HEFA_RELA");
		this.REMARK =request.getParameter("REMARK");
		this.CHAR_REF_YN =request.getParameter("CHAR_REF_YN");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.SEND_YN =request.getParameter("SEND_YN");
		this.FOREIGN_YN =request.getParameter("FOREIGN_YN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.SI_DO_CODE =KJFMi.dsGet(ds, arg_row, "SI_DO_CODE");
		this.SI_GUN_GU_CODE =KJFMi.dsGet(ds, arg_row, "SI_GUN_GU_CODE");
		this.POS_CLASS =KJFMi.dsGet(ds, arg_row, "POS_CLASS");
		this.ENT_DT =KJFMi.dsGet(ds, arg_row, "ENT_DT");
		this.RET_DT =KJFMi.dsGet(ds, arg_row, "RET_DT");
		this.NM_KOR =KJFMi.dsGet(ds, arg_row, "NM_KOR");
		this.NM_HAN =KJFMi.dsGet(ds, arg_row, "NM_HAN");
		this.ORI =KJFMi.dsGet(ds, arg_row, "ORI");
		this.ADDR =KJFMi.dsGet(ds, arg_row, "ADDR");
		this.SSN1 =KJFMi.dsGet(ds, arg_row, "SSN1");
		this.SSN2 =KJFMi.dsGet(ds, arg_row, "SSN2");
		this.HEFA =KJFMi.dsGet(ds, arg_row, "HEFA");
		this.HEFA_RELA =KJFMi.dsGet(ds, arg_row, "HEFA_RELA");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.CHAR_REF_YN =KJFMi.dsGet(ds, arg_row, "CHAR_REF_YN");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.SEND_YN =KJFMi.dsGet(ds, arg_row, "SEND_YN");
		this.FOREIGN_YN =KJFMi.dsGet(ds, arg_row, "FOREIGN_YN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getSI_DO_CODE(){
             return SI_DO_CODE;
     };
  
     public String getSI_GUN_GU_CODE(){
             return SI_GUN_GU_CODE;
     };
  
     public String getPOS_CLASS(){
             return POS_CLASS;
     };
  
     public String getENT_DT(){
             return ENT_DT;
     };
  
     public String getRET_DT(){
             return RET_DT;
     };
  
     public String getNM_KOR(){
             return NM_KOR;
     };
  
     public String getNM_HAN(){
             return NM_HAN;
     };
  
     public String getORI(){
             return ORI;
     };
  
     public String getADDR(){
             return ADDR;
     };
  
     public String getSSN1(){
             return SSN1;
     };
  
     public String getSSN2(){
             return SSN2;
     };
  
     public String getHEFA(){
             return HEFA;
     };
  
     public String getHEFA_RELA(){
             return HEFA_RELA;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getCHAR_REF_YN(){
             return CHAR_REF_YN;
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
  
     public String getSEND_YN(){
             return SEND_YN;
     };
  
     public String getFOREIGN_YN(){
             return FOREIGN_YN;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setSI_DO_CODE(String SI_DO_CODE){
            this.SI_DO_CODE=SI_DO_CODE;
     };
  
     public void setSI_GUN_GU_CODE(String SI_GUN_GU_CODE){
            this.SI_GUN_GU_CODE=SI_GUN_GU_CODE;
     };
  
     public void setPOS_CLASS(String POS_CLASS){
            this.POS_CLASS=POS_CLASS;
     };
  
     public void setENT_DT(String ENT_DT){
            this.ENT_DT=ENT_DT;
     };
  
     public void setRET_DT(String RET_DT){
            this.RET_DT=RET_DT;
     };
  
     public void setNM_KOR(String NM_KOR){
            this.NM_KOR=NM_KOR;
     };
  
     public void setNM_HAN(String NM_HAN){
            this.NM_HAN=NM_HAN;
     };
  
     public void setORI(String ORI){
            this.ORI=ORI;
     };
  
     public void setADDR(String ADDR){
            this.ADDR=ADDR;
     };
  
     public void setSSN1(String SSN1){
            this.SSN1=SSN1;
     };
  
     public void setSSN2(String SSN2){
            this.SSN2=SSN2;
     };
  
     public void setHEFA(String HEFA){
            this.HEFA=HEFA;
     };
  
     public void setHEFA_RELA(String HEFA_RELA){
            this.HEFA_RELA=HEFA_RELA;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setCHAR_REF_YN(String CHAR_REF_YN){
            this.CHAR_REF_YN=CHAR_REF_YN;
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
  
     public void setSEND_YN(String SEND_YN){
            this.SEND_YN=SEND_YN;
     };
  
     public void setFOREIGN_YN(String FOREIGN_YN){
            this.FOREIGN_YN=FOREIGN_YN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("SI_DO_CODE:"+ this.getSI_DO_CODE()+"\n");
      
      strB.append("SI_GUN_GU_CODE:"+ this.getSI_GUN_GU_CODE()+"\n");
      
      strB.append("POS_CLASS:"+ this.getPOS_CLASS()+"\n");
      
      strB.append("ENT_DT:"+ this.getENT_DT()+"\n");
      
      strB.append("RET_DT:"+ this.getRET_DT()+"\n");
      
      strB.append("NM_KOR:"+ this.getNM_KOR()+"\n");
      
      strB.append("NM_HAN:"+ this.getNM_HAN()+"\n");
      
      strB.append("ORI:"+ this.getORI()+"\n");
      
      strB.append("ADDR:"+ this.getADDR()+"\n");
      
      strB.append("SSN1:"+ this.getSSN1()+"\n");
      
      strB.append("SSN2:"+ this.getSSN2()+"\n");
      
      strB.append("HEFA:"+ this.getHEFA()+"\n");
      
      strB.append("HEFA_RELA:"+ this.getHEFA_RELA()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("CHAR_REF_YN:"+ this.getCHAR_REF_YN()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("SEND_YN:"+ this.getSEND_YN()+"\n");
      
      strB.append("FOREIGN_YN:"+ this.getFOREIGN_YN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_REFFERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_REFFERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_REFFERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_REFFERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_REFFERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_REFFEREntity();
  }

  public ValueObject getClone(){
         PT_R_REFFEREntity newEnt = new PT_R_REFFEREntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setSI_DO_CODE(this.getSI_DO_CODE());
         
          newEnt.setSI_GUN_GU_CODE(this.getSI_GUN_GU_CODE());
         
          newEnt.setPOS_CLASS(this.getPOS_CLASS());
         
          newEnt.setENT_DT(this.getENT_DT());
         
          newEnt.setRET_DT(this.getRET_DT());
         
          newEnt.setNM_KOR(this.getNM_KOR());
         
          newEnt.setNM_HAN(this.getNM_HAN());
         
          newEnt.setORI(this.getORI());
         
          newEnt.setADDR(this.getADDR());
         
          newEnt.setSSN1(this.getSSN1());
         
          newEnt.setSSN2(this.getSSN2());
         
          newEnt.setHEFA(this.getHEFA());
         
          newEnt.setHEFA_RELA(this.getHEFA_RELA());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setCHAR_REF_YN(this.getCHAR_REF_YN());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setSEND_YN(this.getSEND_YN());
         
          newEnt.setFOREIGN_YN(this.getFOREIGN_YN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_REFFERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getTMP_WRT_NUM();
        
             case 3 :
                 return  this.getSI_DO_CODE();
        
             case 4 :
                 return  this.getSI_GUN_GU_CODE();
        
             case 5 :
                 return  this.getPOS_CLASS();
        
             case 6 :
                 return  this.getENT_DT();
        
             case 7 :
                 return  this.getRET_DT();
        
             case 8 :
                 return  this.getNM_KOR();
        
             case 9 :
                 return  this.getNM_HAN();
        
             case 10 :
                 return  this.getORI();
        
             case 11 :
                 return  this.getADDR();
        
             case 12 :
                 return  this.getSSN1();
        
             case 13 :
                 return  this.getSSN2();
        
             case 14 :
                 return  this.getHEFA();
        
             case 15 :
                 return  this.getHEFA_RELA();
        
             case 16 :
                 return  this.getREMARK();
        
             case 17 :
                 return  this.getCHAR_REF_YN();
        
             case 18 :
                 return  this.getWRT_ID();
        
             case 19 :
                 return  this.getINS_DT();
        
             case 20 :
                 return  this.getUPD_DT();
        
             case 21 :
                 return  this.getSEND_YN();
        
             case 22 :
                 return  this.getFOREIGN_YN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_REFFERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setSI_DO_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setSI_GUN_GU_CODE((String)value);
	            return;  
        
             case 5 :
                    this.setPOS_CLASS((String)value);
	            return;  
        
             case 6 :
                    this.setENT_DT((String)value);
	            return;  
        
             case 7 :
                    this.setRET_DT((String)value);
	            return;  
        
             case 8 :
                    this.setNM_KOR((String)value);
	            return;  
        
             case 9 :
                    this.setNM_HAN((String)value);
	            return;  
        
             case 10 :
                    this.setORI((String)value);
	            return;  
        
             case 11 :
                    this.setADDR((String)value);
	            return;  
        
             case 12 :
                    this.setSSN1((String)value);
	            return;  
        
             case 13 :
                    this.setSSN2((String)value);
	            return;  
        
             case 14 :
                    this.setHEFA((String)value);
	            return;  
        
             case 15 :
                    this.setHEFA_RELA((String)value);
	            return;  
        
             case 16 :
                    this.setREMARK((String)value);
	            return;  
        
             case 17 :
                    this.setCHAR_REF_YN((String)value);
	            return;  
        
             case 18 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 19 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 20 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 21 :
                    this.setSEND_YN((String)value);
	            return;  
        
             case 22 :
                    this.setFOREIGN_YN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_REFFERHelper.toXML(this);
  }
  
}
