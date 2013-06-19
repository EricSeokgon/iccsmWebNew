

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_MASTER
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               TMP_WRT_NUM  
*               WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               WRT_DT:VARCHAR2(8):  
*               REGR:VARCHAR2(16):  
*               VIOL_CONT_CODE:VARCHAR2(50):  
*               VIOL_DT:VARCHAR2(8):  
*               D_PER_CODE:VARCHAR2(6):  
*               DISPO_CONT:VARCHAR2(6):  
*               DISPO_CAUSE:VARCHAR2(512):  
*               DISPO_DT:VARCHAR2(8):  
*               MOT_STE:VARCHAR2(6):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(30):  
*               SIDO_CODE:VARCHAR2(4):  
*               REMARK:VARCHAR2(256):  
*               LEG_BAS:VARCHAR2(256):  
*               SND_STE:VARCHAR2(1):  
*               SND_DT:VARCHAR2(8):  
*               HOME_NOTE:VARCHAR2(8):  
*               NOTE_GUID_DT:VARCHAR2(8):  
*               OFFI_REPORT_DT:VARCHAR2(8):  
*               ASSO_GUILD_DT:VARCHAR2(8):  
*               RECV_NUM:VARCHAR2(24):  
*               DISPO_CONT2:VARCHAR2(50):  
*               BUSISUSP_START_DT:VARCHAR2(8):  
*               BUSISUSP_END_DT:VARCHAR2(8):  
*               DOC_CODE:VARCHAR2(50):  
*               PUNISHMENT_AGENCY:VARCHAR2(30):  
*               DISPO_CONT_NM:VARCHAR2(50):  
*               AT_RECV_NUM:VARCHAR2(12):  
*               MAST_PROC:VARCHAR2(8):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               WRT_DT:VARCHAR2(8):  
*               REGR:VARCHAR2(16):  
*               VIOL_CONT_CODE:VARCHAR2(50):  
*               VIOL_DT:VARCHAR2(8):  
*               D_PER_CODE:VARCHAR2(6):  
*               DISPO_CONT:VARCHAR2(6):  
*               DISPO_CAUSE:VARCHAR2(512):  
*               DISPO_DT:VARCHAR2(8):  
*               MOT_STE:VARCHAR2(6):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               SIDO_CODE:VARCHAR2(4):  
*               REMARK:VARCHAR2(256):  
*               LEG_BAS:VARCHAR2(256):  
*               SND_STE:VARCHAR2(1):  
*               SND_DT:VARCHAR2(8):  
*               HOME_NOTE:VARCHAR2(8):  
*               NOTE_GUID_DT:VARCHAR2(8):  
*               OFFI_REPORT_DT:VARCHAR2(8):  
*               ASSO_GUILD_DT:VARCHAR2(8):  
*               RECV_NUM:VARCHAR2(24):  
*               DISPO_CONT2:VARCHAR2(6):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_MASTEREntity extends ValueObject{

  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String WRT_DT;
  
     private String REGR;
  
     private String VIOL_CONT_CODE;
  
     private String VIOL_DT;
  
     private String D_PER_CODE;
  
     private String DISPO_CONT;
  
     private String DISPO_CAUSE;
  
     private String DISPO_DT;
  
     private String MOT_STE;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String SIDO_CODE;
  
     private String REMARK;
  
     private String LEG_BAS;
  
     private String SND_STE;
  
     private String SND_DT;
  
     private String HOME_NOTE;
  
     private String NOTE_GUID_DT;
  
     private String OFFI_REPORT_DT;
  
     private String ASSO_GUILD_DT;
  
     private String RECV_NUM;
  
     private String DISPO_CONT2;
  
     private String BUSISUSP_START_DT;
  
     private String BUSISUSP_END_DT;
  
     private String DOC_CODE;
  
     private String PUNISHMENT_AGENCY;
  
     private String DISPO_CONT_NM;
  
     private String AT_RECV_NUM;
  
     private String MAST_PROC;
  
     private String COI_WRT_NUM;
  
     
  

//생성자를 만든다
    public PT_M_MASTEREntity(){
    }
    
    
    public PT_M_MASTEREntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_MASTEREntity(ValueObject ent) throws Exception{
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
		this.WRT_DT =request.getParameter("WRT_DT");
		this.REGR =request.getParameter("REGR");
		this.VIOL_CONT_CODE =request.getParameter("VIOL_CONT_CODE");
		this.VIOL_DT =request.getParameter("VIOL_DT");
		this.D_PER_CODE =request.getParameter("D_PER_CODE");
		this.DISPO_CONT =request.getParameter("DISPO_CONT");
		this.DISPO_CAUSE =request.getParameter("DISPO_CAUSE");
		this.DISPO_DT =request.getParameter("DISPO_DT");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.REMARK =request.getParameter("REMARK");
		this.LEG_BAS =request.getParameter("LEG_BAS");
		this.SND_STE =request.getParameter("SND_STE");
		this.SND_DT =request.getParameter("SND_DT");
		this.HOME_NOTE =request.getParameter("HOME_NOTE");
		this.NOTE_GUID_DT =request.getParameter("NOTE_GUID_DT");
		this.OFFI_REPORT_DT =request.getParameter("OFFI_REPORT_DT");
		this.ASSO_GUILD_DT =request.getParameter("ASSO_GUILD_DT");
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.DISPO_CONT2 =request.getParameter("DISPO_CONT2");
		this.BUSISUSP_START_DT =request.getParameter("BUSISUSP_START_DT");
		this.BUSISUSP_END_DT =request.getParameter("BUSISUSP_END_DT");
		this.DOC_CODE =request.getParameter("DOC_CODE");
		this.PUNISHMENT_AGENCY =request.getParameter("PUNISHMENT_AGENCY");
		this.DISPO_CONT_NM =request.getParameter("DISPO_CONT_NM");
		this.AT_RECV_NUM =request.getParameter("AT_RECV_NUM");
		this.MAST_PROC =request.getParameter("MAST_PROC");
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.REGR =KJFMi.dsGet(ds, arg_row, "REGR");
		this.VIOL_CONT_CODE =KJFMi.dsGet(ds, arg_row, "VIOL_CONT_CODE");
		this.VIOL_DT =KJFMi.dsGet(ds, arg_row, "VIOL_DT");
		this.D_PER_CODE =KJFMi.dsGet(ds, arg_row, "D_PER_CODE");
		this.DISPO_CONT =KJFMi.dsGet(ds, arg_row, "DISPO_CONT");
		this.DISPO_CAUSE =KJFMi.dsGet(ds, arg_row, "DISPO_CAUSE");
		this.DISPO_DT =KJFMi.dsGet(ds, arg_row, "DISPO_DT");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.LEG_BAS =KJFMi.dsGet(ds, arg_row, "LEG_BAS");
		this.SND_STE =KJFMi.dsGet(ds, arg_row, "SND_STE");
		this.SND_DT =KJFMi.dsGet(ds, arg_row, "SND_DT");
		this.HOME_NOTE =KJFMi.dsGet(ds, arg_row, "HOME_NOTE");
		this.NOTE_GUID_DT =KJFMi.dsGet(ds, arg_row, "NOTE_GUID_DT");
		this.OFFI_REPORT_DT =KJFMi.dsGet(ds, arg_row, "OFFI_REPORT_DT");
		this.ASSO_GUILD_DT =KJFMi.dsGet(ds, arg_row, "ASSO_GUILD_DT");
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.DISPO_CONT2 =KJFMi.dsGet(ds, arg_row, "DISPO_CONT2");
		this.BUSISUSP_START_DT =KJFMi.dsGet(ds, arg_row, "BUSISUSP_START_DT");
		this.BUSISUSP_END_DT =KJFMi.dsGet(ds, arg_row, "BUSISUSP_END_DT");
		this.DOC_CODE =KJFMi.dsGet(ds, arg_row, "DOC_CODE");
		this.PUNISHMENT_AGENCY =KJFMi.dsGet(ds, arg_row, "PUNISHMENT_AGENCY");
		this.DISPO_CONT_NM =KJFMi.dsGet(ds, arg_row, "DISPO_CONT_NM");
		this.AT_RECV_NUM =KJFMi.dsGet(ds, arg_row, "AT_RECV_NUM");
		this.MAST_PROC =KJFMi.dsGet(ds, arg_row, "MAST_PROC");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		
				
    }    
    
//Getter 함수를 만든다
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  
     public String getREGR(){
             return REGR;
     };
  
     public String getVIOL_CONT_CODE(){
             return VIOL_CONT_CODE;
     };
  
     public String getVIOL_DT(){
             return VIOL_DT;
     };
  
     public String getD_PER_CODE(){
             return D_PER_CODE;
     };
  
     public String getDISPO_CONT(){
             return DISPO_CONT;
     };
  
     public String getDISPO_CAUSE(){
             return DISPO_CAUSE;
     };
  
     public String getDISPO_DT(){
             return DISPO_DT;
     };
  
     public String getMOT_STE(){
             return MOT_STE;
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
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getLEG_BAS(){
             return LEG_BAS;
     };
  
     public String getSND_STE(){
             return SND_STE;
     };
  
     public String getSND_DT(){
             return SND_DT;
     };
  
     public String getHOME_NOTE(){
             return HOME_NOTE;
     };
  
     public String getNOTE_GUID_DT(){
             return NOTE_GUID_DT;
     };
  
     public String getOFFI_REPORT_DT(){
             return OFFI_REPORT_DT;
     };
  
     public String getASSO_GUILD_DT(){
             return ASSO_GUILD_DT;
     };
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getDISPO_CONT2(){
             return DISPO_CONT2;
     };
  
     public String getBUSISUSP_START_DT(){
             return BUSISUSP_START_DT;
     };
  
     public String getBUSISUSP_END_DT(){
             return BUSISUSP_END_DT;
     };
  
     public String getDOC_CODE(){
             return DOC_CODE;
     };
  
     public String getPUNISHMENT_AGENCY(){
             return PUNISHMENT_AGENCY;
     };
  
     public String getDISPO_CONT_NM(){
             return DISPO_CONT_NM;
     };
  
     public String getAT_RECV_NUM(){
             return AT_RECV_NUM;
     };
  
     public String getMAST_PROC(){
             return MAST_PROC;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
       

//Setter 함수를 만든다
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
     public void setREGR(String REGR){
            this.REGR=REGR;
     };
  
     public void setVIOL_CONT_CODE(String VIOL_CONT_CODE){
            this.VIOL_CONT_CODE=VIOL_CONT_CODE;
     };
  
     public void setVIOL_DT(String VIOL_DT){
            this.VIOL_DT=VIOL_DT;
     };
  
     public void setD_PER_CODE(String D_PER_CODE){
            this.D_PER_CODE=D_PER_CODE;
     };
  
     public void setDISPO_CONT(String DISPO_CONT){
            this.DISPO_CONT=DISPO_CONT;
     };
  
     public void setDISPO_CAUSE(String DISPO_CAUSE){
            this.DISPO_CAUSE=DISPO_CAUSE;
     };
  
     public void setDISPO_DT(String DISPO_DT){
            this.DISPO_DT=DISPO_DT;
     };
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
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
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setLEG_BAS(String LEG_BAS){
            this.LEG_BAS=LEG_BAS;
     };
  
     public void setSND_STE(String SND_STE){
            this.SND_STE=SND_STE;
     };
  
     public void setSND_DT(String SND_DT){
            this.SND_DT=SND_DT;
     };
  
     public void setHOME_NOTE(String HOME_NOTE){
            this.HOME_NOTE=HOME_NOTE;
     };
  
     public void setNOTE_GUID_DT(String NOTE_GUID_DT){
            this.NOTE_GUID_DT=NOTE_GUID_DT;
     };
  
     public void setOFFI_REPORT_DT(String OFFI_REPORT_DT){
            this.OFFI_REPORT_DT=OFFI_REPORT_DT;
     };
  
     public void setASSO_GUILD_DT(String ASSO_GUILD_DT){
            this.ASSO_GUILD_DT=ASSO_GUILD_DT;
     };
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setDISPO_CONT2(String DISPO_CONT2){
            this.DISPO_CONT2=DISPO_CONT2;
     };
  
     public void setBUSISUSP_START_DT(String BUSISUSP_START_DT){
            this.BUSISUSP_START_DT=BUSISUSP_START_DT;
     };
  
     public void setBUSISUSP_END_DT(String BUSISUSP_END_DT){
            this.BUSISUSP_END_DT=BUSISUSP_END_DT;
     };
  
     public void setDOC_CODE(String DOC_CODE){
            this.DOC_CODE=DOC_CODE;
     };
  
     public void setPUNISHMENT_AGENCY(String PUNISHMENT_AGENCY){
            this.PUNISHMENT_AGENCY=PUNISHMENT_AGENCY;
     };
  
     public void setDISPO_CONT_NM(String DISPO_CONT_NM){
            this.DISPO_CONT_NM=DISPO_CONT_NM;
     };
  
     public void setAT_RECV_NUM(String AT_RECV_NUM){
            this.AT_RECV_NUM=AT_RECV_NUM;
     };
  
     public void setMAST_PROC(String MAST_PROC){
            this.MAST_PROC=MAST_PROC;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
       
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("REGR:"+ this.getREGR()+"\n");
      
      strB.append("VIOL_CONT_CODE:"+ this.getVIOL_CONT_CODE()+"\n");
      
      strB.append("VIOL_DT:"+ this.getVIOL_DT()+"\n");
      
      strB.append("D_PER_CODE:"+ this.getD_PER_CODE()+"\n");
      
      strB.append("DISPO_CONT:"+ this.getDISPO_CONT()+"\n");
      
      strB.append("DISPO_CAUSE:"+ this.getDISPO_CAUSE()+"\n");
      
      strB.append("DISPO_DT:"+ this.getDISPO_DT()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("LEG_BAS:"+ this.getLEG_BAS()+"\n");
      
      strB.append("SND_STE:"+ this.getSND_STE()+"\n");
      
      strB.append("SND_DT:"+ this.getSND_DT()+"\n");
      
      strB.append("HOME_NOTE:"+ this.getHOME_NOTE()+"\n");
      
      strB.append("NOTE_GUID_DT:"+ this.getNOTE_GUID_DT()+"\n");
      
      strB.append("OFFI_REPORT_DT:"+ this.getOFFI_REPORT_DT()+"\n");
      
      strB.append("ASSO_GUILD_DT:"+ this.getASSO_GUILD_DT()+"\n");
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("DISPO_CONT2:"+ this.getDISPO_CONT2()+"\n");
      
      strB.append("BUSISUSP_START_DT:"+ this.getBUSISUSP_START_DT()+"\n");
      
      strB.append("BUSISUSP_END_DT:"+ this.getBUSISUSP_END_DT()+"\n");
      
      strB.append("DOC_CODE:"+ this.getDOC_CODE()+"\n");
      
      strB.append("PUNISHMENT_AGENCY:"+ this.getPUNISHMENT_AGENCY()+"\n");
      
      strB.append("DISPO_CONT_NM:"+ this.getDISPO_CONT_NM()+"\n");
      
      strB.append("AT_RECV_NUM:"+ this.getAT_RECV_NUM()+"\n");
      
      strB.append("MAST_PROC:"+ this.getMAST_PROC()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
            
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_MASTERHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_MASTERHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_MASTERHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_MASTERHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_MASTERHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_MASTEREntity();
  }

  public ValueObject getClone(){
         PT_M_MASTEREntity newEnt = new PT_M_MASTEREntity();
	 
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setREGR(this.getREGR());
         
          newEnt.setVIOL_CONT_CODE(this.getVIOL_CONT_CODE());
         
          newEnt.setVIOL_DT(this.getVIOL_DT());
         
          newEnt.setD_PER_CODE(this.getD_PER_CODE());
         
          newEnt.setDISPO_CONT(this.getDISPO_CONT());
         
          newEnt.setDISPO_CAUSE(this.getDISPO_CAUSE());
         
          newEnt.setDISPO_DT(this.getDISPO_DT());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setLEG_BAS(this.getLEG_BAS());
         
          newEnt.setSND_STE(this.getSND_STE());
         
          newEnt.setSND_DT(this.getSND_DT());
         
          newEnt.setHOME_NOTE(this.getHOME_NOTE());
         
          newEnt.setNOTE_GUID_DT(this.getNOTE_GUID_DT());
         
          newEnt.setOFFI_REPORT_DT(this.getOFFI_REPORT_DT());
         
          newEnt.setASSO_GUILD_DT(this.getASSO_GUILD_DT());
         
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setDISPO_CONT2(this.getDISPO_CONT2());
         
          newEnt.setBUSISUSP_START_DT(this.getBUSISUSP_START_DT());
         
          newEnt.setBUSISUSP_END_DT(this.getBUSISUSP_END_DT());
         
          newEnt.setDOC_CODE(this.getDOC_CODE());
         
          newEnt.setPUNISHMENT_AGENCY(this.getPUNISHMENT_AGENCY());
         
          newEnt.setDISPO_CONT_NM(this.getDISPO_CONT_NM());
         
          newEnt.setAT_RECV_NUM(this.getAT_RECV_NUM());
         
          newEnt.setMAST_PROC(this.getMAST_PROC());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
                   
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_MASTERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getTMP_WRT_NUM();
        
             case 2 :
                 return  this.getWRT_NUM();
        
             case 3 :
                 return  this.getWRT_DT();
        
             case 4 :
                 return  this.getREGR();
        
             case 5 :
                 return  this.getVIOL_CONT_CODE();
        
             case 6 :
                 return  this.getVIOL_DT();
        
             case 7 :
                 return  this.getD_PER_CODE();
        
             case 8 :
                 return  this.getDISPO_CONT();
        
             case 9 :
                 return  this.getDISPO_CAUSE();
        
             case 10 :
                 return  this.getDISPO_DT();
        
             case 11 :
                 return  this.getMOT_STE();
        
             case 12 :
                 return  this.getINS_DT();
        
             case 13 :
                 return  this.getUPD_DT();
        
             case 14 :
                 return  this.getWRT_ID();
        
             case 15 :
                 return  this.getSIDO_CODE();
        
             case 16 :
                 return  this.getREMARK();
        
             case 17 :
                 return  this.getLEG_BAS();
        
             case 18 :
                 return  this.getSND_STE();
        
             case 19 :
                 return  this.getSND_DT();
        
             case 20 :
                 return  this.getHOME_NOTE();
        
             case 21 :
                 return  this.getNOTE_GUID_DT();
        
             case 22 :
                 return  this.getOFFI_REPORT_DT();
        
             case 23 :
                 return  this.getASSO_GUILD_DT();
        
             case 24 :
                 return  this.getRECV_NUM();
        
             case 25 :
                 return  this.getDISPO_CONT2();
        
             case 26 :
                 return  this.getBUSISUSP_START_DT();
        
             case 27 :
                 return  this.getBUSISUSP_END_DT();
        
             case 28 :
                 return  this.getDOC_CODE();
        
             case 29 :
                 return  this.getPUNISHMENT_AGENCY();
        
             case 30 :
                 return  this.getDISPO_CONT_NM();
        
             case 31 :
                 return  this.getAT_RECV_NUM();
        
             case 32 :
                 return  this.getMAST_PROC();
        
             case 33 :
                 return  this.getCOI_WRT_NUM();
        
             
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_MASTERHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 4 :
                    this.setREGR((String)value);
	            return;  
        
             case 5 :
                    this.setVIOL_CONT_CODE((String)value);
	            return;  
        
             case 6 :
                    this.setVIOL_DT((String)value);
	            return;  
        
             case 7 :
                    this.setD_PER_CODE((String)value);
	            return;  
        
             case 8 :
                    this.setDISPO_CONT((String)value);
	            return;  
        
             case 9 :
                    this.setDISPO_CAUSE((String)value);
	            return;  
        
             case 10 :
                    this.setDISPO_DT((String)value);
	            return;  
        
             case 11 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 12 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 13 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 14 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 15 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 16 :
                    this.setREMARK((String)value);
	            return;  
        
             case 17 :
                    this.setLEG_BAS((String)value);
	            return;  
        
             case 18 :
                    this.setSND_STE((String)value);
	            return;  
        
             case 19 :
                    this.setSND_DT((String)value);
	            return;  
        
             case 20 :
                    this.setHOME_NOTE((String)value);
	            return;  
        
             case 21 :
                    this.setNOTE_GUID_DT((String)value);
	            return;  
        
             case 22 :
                    this.setOFFI_REPORT_DT((String)value);
	            return;  
        
             case 23 :
                    this.setASSO_GUILD_DT((String)value);
	            return;  
        
             case 24 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 25 :
                    this.setDISPO_CONT2((String)value);
	            return;  
        
             case 26 :
                    this.setBUSISUSP_START_DT((String)value);
	            return;  
        
             case 27 :
                    this.setBUSISUSP_END_DT((String)value);
	            return;  
        
             case 28 :
                    this.setDOC_CODE((String)value);
	            return;  
        
             case 29 :
                    this.setPUNISHMENT_AGENCY((String)value);
	            return;  
        
             case 30 :
                    this.setDISPO_CONT_NM((String)value);
	            return;  
        
             case 31 :
                    this.setAT_RECV_NUM((String)value);
	            return;  
        
             case 32 :
                    this.setMAST_PROC((String)value);
	            return;  
        
             case 33 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
                     
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_MASTERHelper.toXML(this);
  }
  
}
