

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_MGR
*  테이블 설명 :
*  테이블 PK   :  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               M_SEQ:VARCHAR2(6):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               DISPO_CLASS:VARCHAR2(1):  
*               VIOL_DT:VARCHAR2(8):  
*               DISPO_CAUSE:VARCHAR2(512):  
*               NOTE_DT:VARCHAR2(8):  
*               NOTE_RECV_YN:VARCHAR2(1):  
*               NOTE_OPIN_PRES_LIM_DT:VARCHAR2(8):  
*               DEL_NOTE_DT:VARCHAR2(8):  
*               DEL_OPIN_PRES_LIM_DT:VARCHAR2(8):  
*               DISPO_CONT:VARCHAR2(6):  
*               DISPO_DT:VARCHAR2(8):  
*               BUSISUSP_START_DT:VARCHAR2(8):  
*               BUSISUSP_END_DT:VARCHAR2(8):  
*               REMARK:VARCHAR2(256):  
*               RECV_DT:VARCHAR2(8):  
*               MOT_STE:VARCHAR2(6):  
*               DOC_CODE:VARCHAR2(50):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(30):  
*               REGSTD_START_DT:VARCHAR2(8):  
*               REGSTD_END_DT:VARCHAR2(8):  
*               FINE:VARCHAR2(30):  
*               PAY_NOTI_DT:VARCHAR2(8):  
*               PAY_TERM:VARCHAR2(8):  
*               PAY_DT:VARCHAR2(8):  
*               DEL_RECV_YN:VARCHAR2(1):  
*               WRT_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(6):  
*               SND_STE:VARCHAR2(1):  
*               SND_DT:VARCHAR2(8):  
*               PUNISHMENT_AGENCY:VARCHAR2(50):  
*               DISPO_CONT_NM:VARCHAR2(30):  
*               AUDI_EXEC_ADDR:VARCHAR2(120):  
*               AUDI_EXEC_DT:VARCHAR2(8):  
*               AUDI_EXEC_START_TIME:VARCHAR2(4):  
*               AUDI_EXEC_END_TIME:VARCHAR2(4):  
*               AUDI_SUPINT_NM:VARCHAR2(20):  
*               AUDI_SUPINT_POS:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_MGREntity extends ValueObject{

  
     private String M_SEQ;
  
     private String COI_WRT_NUM;
  
     private String TMP_WRT_NUM;
  
     private String DISPO_CLASS;
  
     private String VIOL_DT;
  
     private String DISPO_CAUSE;
  
     private String NOTE_DT;
  
     private String NOTE_RECV_YN;
  
     private String NOTE_OPIN_PRES_LIM_DT;
  
     private String DEL_NOTE_DT;
  
     private String DEL_OPIN_PRES_LIM_DT;
  
     private String DISPO_CONT;
  
     private String DISPO_DT;
  
     private String BUSISUSP_START_DT;
  
     private String BUSISUSP_END_DT;
  
     private String REMARK;
  
     private String RECV_DT;
  
     private String MOT_STE;
  
     private String DOC_CODE;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String REGSTD_START_DT;
  
     private String REGSTD_END_DT;
  
     private String FINE;
  
     private String PAY_NOTI_DT;
  
     private String PAY_TERM;
  
     private String PAY_DT;
  
     private String DEL_RECV_YN;
  
     private String WRT_NUM;
  
     private String SIDO_CODE;
  
     private String SND_STE;
  
     private String SND_DT;
  
     private String PUNISHMENT_AGENCY;
  
     private String DISPO_CONT_NM;
  
     private String AUDI_EXEC_ADDR;
  
     private String AUDI_EXEC_DT;
  
     private String AUDI_EXEC_START_TIME;
  
     private String AUDI_EXEC_END_TIME;
  
     private String AUDI_SUPINT_NM;
  
     private String AUDI_SUPINT_POS;
  

//생성자를 만든다
    public PT_M_MGREntity(){
    }
    
    
    public PT_M_MGREntity(String TMP_WRT_NUM,String WRT_NUM ){
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_MGREntity(ValueObject ent) throws Exception{
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
		this.M_SEQ =request.getParameter("M_SEQ");
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.DISPO_CLASS =request.getParameter("DISPO_CLASS");
		this.VIOL_DT =request.getParameter("VIOL_DT");
		this.DISPO_CAUSE =request.getParameter("DISPO_CAUSE");
		this.NOTE_DT =request.getParameter("NOTE_DT");
		this.NOTE_RECV_YN =request.getParameter("NOTE_RECV_YN");
		this.NOTE_OPIN_PRES_LIM_DT =request.getParameter("NOTE_OPIN_PRES_LIM_DT");
		this.DEL_NOTE_DT =request.getParameter("DEL_NOTE_DT");
		this.DEL_OPIN_PRES_LIM_DT =request.getParameter("DEL_OPIN_PRES_LIM_DT");
		this.DISPO_CONT =request.getParameter("DISPO_CONT");
		this.DISPO_DT =request.getParameter("DISPO_DT");
		this.BUSISUSP_START_DT =request.getParameter("BUSISUSP_START_DT");
		this.BUSISUSP_END_DT =request.getParameter("BUSISUSP_END_DT");
		this.REMARK =request.getParameter("REMARK");
		this.RECV_DT =request.getParameter("RECV_DT");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.DOC_CODE =request.getParameter("DOC_CODE");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.REGSTD_START_DT =request.getParameter("REGSTD_START_DT");
		this.REGSTD_END_DT =request.getParameter("REGSTD_END_DT");
		this.FINE =request.getParameter("FINE");
		this.PAY_NOTI_DT =request.getParameter("PAY_NOTI_DT");
		this.PAY_TERM =request.getParameter("PAY_TERM");
		this.PAY_DT =request.getParameter("PAY_DT");
		this.DEL_RECV_YN =request.getParameter("DEL_RECV_YN");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SND_STE =request.getParameter("SND_STE");
		this.SND_DT =request.getParameter("SND_DT");
		this.PUNISHMENT_AGENCY =request.getParameter("PUNISHMENT_AGENCY");
		this.DISPO_CONT_NM =request.getParameter("DISPO_CONT_NM");
		this.AUDI_EXEC_ADDR =request.getParameter("AUDI_EXEC_ADDR");
		this.AUDI_EXEC_DT =request.getParameter("AUDI_EXEC_DT");
		this.AUDI_EXEC_START_TIME =request.getParameter("AUDI_EXEC_START_TIME");
		this.AUDI_EXEC_END_TIME =request.getParameter("AUDI_EXEC_END_TIME");
		this.AUDI_SUPINT_NM =request.getParameter("AUDI_SUPINT_NM");
		this.AUDI_SUPINT_POS =request.getParameter("AUDI_SUPINT_POS");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.M_SEQ =KJFMi.dsGet(ds, arg_row, "M_SEQ");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.DISPO_CLASS =KJFMi.dsGet(ds, arg_row, "DISPO_CLASS");
		this.VIOL_DT =KJFMi.dsGet(ds, arg_row, "VIOL_DT");
		this.DISPO_CAUSE =KJFMi.dsGet(ds, arg_row, "DISPO_CAUSE");
		this.NOTE_DT =KJFMi.dsGet(ds, arg_row, "NOTE_DT");
		this.NOTE_RECV_YN =KJFMi.dsGet(ds, arg_row, "NOTE_RECV_YN");
		this.NOTE_OPIN_PRES_LIM_DT =KJFMi.dsGet(ds, arg_row, "NOTE_OPIN_PRES_LIM_DT");
		this.DEL_NOTE_DT =KJFMi.dsGet(ds, arg_row, "DEL_NOTE_DT");
		this.DEL_OPIN_PRES_LIM_DT =KJFMi.dsGet(ds, arg_row, "DEL_OPIN_PRES_LIM_DT");
		this.DISPO_CONT =KJFMi.dsGet(ds, arg_row, "DISPO_CONT");
		this.DISPO_DT =KJFMi.dsGet(ds, arg_row, "DISPO_DT");
		this.BUSISUSP_START_DT =KJFMi.dsGet(ds, arg_row, "BUSISUSP_START_DT");
		this.BUSISUSP_END_DT =KJFMi.dsGet(ds, arg_row, "BUSISUSP_END_DT");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.DOC_CODE =KJFMi.dsGet(ds, arg_row, "DOC_CODE");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.REGSTD_START_DT =KJFMi.dsGet(ds, arg_row, "REGSTD_START_DT");
		this.REGSTD_END_DT =KJFMi.dsGet(ds, arg_row, "REGSTD_END_DT");
		this.FINE =KJFMi.dsGet(ds, arg_row, "FINE");
		this.PAY_NOTI_DT =KJFMi.dsGet(ds, arg_row, "PAY_NOTI_DT");
		this.PAY_TERM =KJFMi.dsGet(ds, arg_row, "PAY_TERM");
		this.PAY_DT =KJFMi.dsGet(ds, arg_row, "PAY_DT");
		this.DEL_RECV_YN =KJFMi.dsGet(ds, arg_row, "DEL_RECV_YN");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SND_STE =KJFMi.dsGet(ds, arg_row, "SND_STE");
		this.SND_DT =KJFMi.dsGet(ds, arg_row, "SND_DT");
		this.PUNISHMENT_AGENCY =KJFMi.dsGet(ds, arg_row, "PUNISHMENT_AGENCY");
		this.DISPO_CONT_NM =KJFMi.dsGet(ds, arg_row, "DISPO_CONT_NM");
		this.AUDI_EXEC_ADDR =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_ADDR");
		this.AUDI_EXEC_DT =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_DT");
		this.AUDI_EXEC_START_TIME =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_START_TIME");
		this.AUDI_EXEC_END_TIME =KJFMi.dsGet(ds, arg_row, "AUDI_EXEC_END_TIME");
		this.AUDI_SUPINT_NM =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_NM");
		this.AUDI_SUPINT_POS =KJFMi.dsGet(ds, arg_row, "AUDI_SUPINT_POS");
				
    }    
    
//Getter 함수를 만든다
  
     public String getM_SEQ(){
             return M_SEQ;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getDISPO_CLASS(){
             return DISPO_CLASS;
     };
  
     public String getVIOL_DT(){
             return VIOL_DT;
     };
  
     public String getDISPO_CAUSE(){
             return DISPO_CAUSE;
     };
  
     public String getNOTE_DT(){
             return NOTE_DT;
     };
  
     public String getNOTE_RECV_YN(){
             return NOTE_RECV_YN;
     };
  
     public String getNOTE_OPIN_PRES_LIM_DT(){
             return NOTE_OPIN_PRES_LIM_DT;
     };
  
     public String getDEL_NOTE_DT(){
             return DEL_NOTE_DT;
     };
  
     public String getDEL_OPIN_PRES_LIM_DT(){
             return DEL_OPIN_PRES_LIM_DT;
     };
  
     public String getDISPO_CONT(){
             return DISPO_CONT;
     };
  
     public String getDISPO_DT(){
             return DISPO_DT;
     };
  
     public String getBUSISUSP_START_DT(){
             return BUSISUSP_START_DT;
     };
  
     public String getBUSISUSP_END_DT(){
             return BUSISUSP_END_DT;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getRECV_DT(){
             return RECV_DT;
     };
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  
     public String getDOC_CODE(){
             return DOC_CODE;
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
  
     public String getREGSTD_START_DT(){
             return REGSTD_START_DT;
     };
  
     public String getREGSTD_END_DT(){
             return REGSTD_END_DT;
     };
  
     public String getFINE(){
             return FINE;
     };
  
     public String getPAY_NOTI_DT(){
             return PAY_NOTI_DT;
     };
  
     public String getPAY_TERM(){
             return PAY_TERM;
     };
  
     public String getPAY_DT(){
             return PAY_DT;
     };
  
     public String getDEL_RECV_YN(){
             return DEL_RECV_YN;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getSND_STE(){
             return SND_STE;
     };
  
     public String getSND_DT(){
             return SND_DT;
     };
  
     public String getPUNISHMENT_AGENCY(){
             return PUNISHMENT_AGENCY;
     };
  
     public String getDISPO_CONT_NM(){
             return DISPO_CONT_NM;
     };
  
     public String getAUDI_EXEC_ADDR(){
             return AUDI_EXEC_ADDR;
     };
  
     public String getAUDI_EXEC_DT(){
             return AUDI_EXEC_DT;
     };
  
     public String getAUDI_EXEC_START_TIME(){
             return AUDI_EXEC_START_TIME;
     };
  
     public String getAUDI_EXEC_END_TIME(){
             return AUDI_EXEC_END_TIME;
     };
  
     public String getAUDI_SUPINT_NM(){
             return AUDI_SUPINT_NM;
     };
  
     public String getAUDI_SUPINT_POS(){
             return AUDI_SUPINT_POS;
     };
  

//Setter 함수를 만든다
  
     public void setM_SEQ(String M_SEQ){
            this.M_SEQ=M_SEQ;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setDISPO_CLASS(String DISPO_CLASS){
            this.DISPO_CLASS=DISPO_CLASS;
     };
  
     public void setVIOL_DT(String VIOL_DT){
            this.VIOL_DT=VIOL_DT;
     };
  
     public void setDISPO_CAUSE(String DISPO_CAUSE){
            this.DISPO_CAUSE=DISPO_CAUSE;
     };
  
     public void setNOTE_DT(String NOTE_DT){
            this.NOTE_DT=NOTE_DT;
     };
  
     public void setNOTE_RECV_YN(String NOTE_RECV_YN){
            this.NOTE_RECV_YN=NOTE_RECV_YN;
     };
  
     public void setNOTE_OPIN_PRES_LIM_DT(String NOTE_OPIN_PRES_LIM_DT){
            this.NOTE_OPIN_PRES_LIM_DT=NOTE_OPIN_PRES_LIM_DT;
     };
  
     public void setDEL_NOTE_DT(String DEL_NOTE_DT){
            this.DEL_NOTE_DT=DEL_NOTE_DT;
     };
  
     public void setDEL_OPIN_PRES_LIM_DT(String DEL_OPIN_PRES_LIM_DT){
            this.DEL_OPIN_PRES_LIM_DT=DEL_OPIN_PRES_LIM_DT;
     };
  
     public void setDISPO_CONT(String DISPO_CONT){
            this.DISPO_CONT=DISPO_CONT;
     };
  
     public void setDISPO_DT(String DISPO_DT){
            this.DISPO_DT=DISPO_DT;
     };
  
     public void setBUSISUSP_START_DT(String BUSISUSP_START_DT){
            this.BUSISUSP_START_DT=BUSISUSP_START_DT;
     };
  
     public void setBUSISUSP_END_DT(String BUSISUSP_END_DT){
            this.BUSISUSP_END_DT=BUSISUSP_END_DT;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setRECV_DT(String RECV_DT){
            this.RECV_DT=RECV_DT;
     };
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
     public void setDOC_CODE(String DOC_CODE){
            this.DOC_CODE=DOC_CODE;
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
  
     public void setREGSTD_START_DT(String REGSTD_START_DT){
            this.REGSTD_START_DT=REGSTD_START_DT;
     };
  
     public void setREGSTD_END_DT(String REGSTD_END_DT){
            this.REGSTD_END_DT=REGSTD_END_DT;
     };
  
     public void setFINE(String FINE){
            this.FINE=FINE;
     };
  
     public void setPAY_NOTI_DT(String PAY_NOTI_DT){
            this.PAY_NOTI_DT=PAY_NOTI_DT;
     };
  
     public void setPAY_TERM(String PAY_TERM){
            this.PAY_TERM=PAY_TERM;
     };
  
     public void setPAY_DT(String PAY_DT){
            this.PAY_DT=PAY_DT;
     };
  
     public void setDEL_RECV_YN(String DEL_RECV_YN){
            this.DEL_RECV_YN=DEL_RECV_YN;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setSND_STE(String SND_STE){
            this.SND_STE=SND_STE;
     };
  
     public void setSND_DT(String SND_DT){
            this.SND_DT=SND_DT;
     };
  
     public void setPUNISHMENT_AGENCY(String PUNISHMENT_AGENCY){
            this.PUNISHMENT_AGENCY=PUNISHMENT_AGENCY;
     };
  
     public void setDISPO_CONT_NM(String DISPO_CONT_NM){
            this.DISPO_CONT_NM=DISPO_CONT_NM;
     };
  
     public void setAUDI_EXEC_ADDR(String AUDI_EXEC_ADDR){
            this.AUDI_EXEC_ADDR=AUDI_EXEC_ADDR;
     };
  
     public void setAUDI_EXEC_DT(String AUDI_EXEC_DT){
            this.AUDI_EXEC_DT=AUDI_EXEC_DT;
     };
  
     public void setAUDI_EXEC_START_TIME(String AUDI_EXEC_START_TIME){
            this.AUDI_EXEC_START_TIME=AUDI_EXEC_START_TIME;
     };
  
     public void setAUDI_EXEC_END_TIME(String AUDI_EXEC_END_TIME){
            this.AUDI_EXEC_END_TIME=AUDI_EXEC_END_TIME;
     };
  
     public void setAUDI_SUPINT_NM(String AUDI_SUPINT_NM){
            this.AUDI_SUPINT_NM=AUDI_SUPINT_NM;
     };
  
     public void setAUDI_SUPINT_POS(String AUDI_SUPINT_POS){
            this.AUDI_SUPINT_POS=AUDI_SUPINT_POS;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("M_SEQ:"+ this.getM_SEQ()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("DISPO_CLASS:"+ this.getDISPO_CLASS()+"\n");
      
      strB.append("VIOL_DT:"+ this.getVIOL_DT()+"\n");
      
      strB.append("DISPO_CAUSE:"+ this.getDISPO_CAUSE()+"\n");
      
      strB.append("NOTE_DT:"+ this.getNOTE_DT()+"\n");
      
      strB.append("NOTE_RECV_YN:"+ this.getNOTE_RECV_YN()+"\n");
      
      strB.append("NOTE_OPIN_PRES_LIM_DT:"+ this.getNOTE_OPIN_PRES_LIM_DT()+"\n");
      
      strB.append("DEL_NOTE_DT:"+ this.getDEL_NOTE_DT()+"\n");
      
      strB.append("DEL_OPIN_PRES_LIM_DT:"+ this.getDEL_OPIN_PRES_LIM_DT()+"\n");
      
      strB.append("DISPO_CONT:"+ this.getDISPO_CONT()+"\n");
      
      strB.append("DISPO_DT:"+ this.getDISPO_DT()+"\n");
      
      strB.append("BUSISUSP_START_DT:"+ this.getBUSISUSP_START_DT()+"\n");
      
      strB.append("BUSISUSP_END_DT:"+ this.getBUSISUSP_END_DT()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("DOC_CODE:"+ this.getDOC_CODE()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("REGSTD_START_DT:"+ this.getREGSTD_START_DT()+"\n");
      
      strB.append("REGSTD_END_DT:"+ this.getREGSTD_END_DT()+"\n");
      
      strB.append("FINE:"+ this.getFINE()+"\n");
      
      strB.append("PAY_NOTI_DT:"+ this.getPAY_NOTI_DT()+"\n");
      
      strB.append("PAY_TERM:"+ this.getPAY_TERM()+"\n");
      
      strB.append("PAY_DT:"+ this.getPAY_DT()+"\n");
      
      strB.append("DEL_RECV_YN:"+ this.getDEL_RECV_YN()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SND_STE:"+ this.getSND_STE()+"\n");
      
      strB.append("SND_DT:"+ this.getSND_DT()+"\n");
      
      strB.append("PUNISHMENT_AGENCY:"+ this.getPUNISHMENT_AGENCY()+"\n");
      
      strB.append("DISPO_CONT_NM:"+ this.getDISPO_CONT_NM()+"\n");
      
      strB.append("AUDI_EXEC_ADDR:"+ this.getAUDI_EXEC_ADDR()+"\n");
      
      strB.append("AUDI_EXEC_DT:"+ this.getAUDI_EXEC_DT()+"\n");
      
      strB.append("AUDI_EXEC_START_TIME:"+ this.getAUDI_EXEC_START_TIME()+"\n");
      
      strB.append("AUDI_EXEC_END_TIME:"+ this.getAUDI_EXEC_END_TIME()+"\n");
      
      strB.append("AUDI_SUPINT_NM:"+ this.getAUDI_SUPINT_NM()+"\n");
      
      strB.append("AUDI_SUPINT_POS:"+ this.getAUDI_SUPINT_POS()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_MGRHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_MGRHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_MGRHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_MGRHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_MGRHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getTMP_WRT_NUM();
       values[1]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_MGREntity();
  }

  public ValueObject getClone(){
         PT_M_MGREntity newEnt = new PT_M_MGREntity();
	 
          newEnt.setM_SEQ(this.getM_SEQ());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setDISPO_CLASS(this.getDISPO_CLASS());
         
          newEnt.setVIOL_DT(this.getVIOL_DT());
         
          newEnt.setDISPO_CAUSE(this.getDISPO_CAUSE());
         
          newEnt.setNOTE_DT(this.getNOTE_DT());
         
          newEnt.setNOTE_RECV_YN(this.getNOTE_RECV_YN());
         
          newEnt.setNOTE_OPIN_PRES_LIM_DT(this.getNOTE_OPIN_PRES_LIM_DT());
         
          newEnt.setDEL_NOTE_DT(this.getDEL_NOTE_DT());
         
          newEnt.setDEL_OPIN_PRES_LIM_DT(this.getDEL_OPIN_PRES_LIM_DT());
         
          newEnt.setDISPO_CONT(this.getDISPO_CONT());
         
          newEnt.setDISPO_DT(this.getDISPO_DT());
         
          newEnt.setBUSISUSP_START_DT(this.getBUSISUSP_START_DT());
         
          newEnt.setBUSISUSP_END_DT(this.getBUSISUSP_END_DT());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setDOC_CODE(this.getDOC_CODE());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setREGSTD_START_DT(this.getREGSTD_START_DT());
         
          newEnt.setREGSTD_END_DT(this.getREGSTD_END_DT());
         
          newEnt.setFINE(this.getFINE());
         
          newEnt.setPAY_NOTI_DT(this.getPAY_NOTI_DT());
         
          newEnt.setPAY_TERM(this.getPAY_TERM());
         
          newEnt.setPAY_DT(this.getPAY_DT());
         
          newEnt.setDEL_RECV_YN(this.getDEL_RECV_YN());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSND_STE(this.getSND_STE());
         
          newEnt.setSND_DT(this.getSND_DT());
         
          newEnt.setPUNISHMENT_AGENCY(this.getPUNISHMENT_AGENCY());
         
          newEnt.setDISPO_CONT_NM(this.getDISPO_CONT_NM());
         
          newEnt.setAUDI_EXEC_ADDR(this.getAUDI_EXEC_ADDR());
         
          newEnt.setAUDI_EXEC_DT(this.getAUDI_EXEC_DT());
         
          newEnt.setAUDI_EXEC_START_TIME(this.getAUDI_EXEC_START_TIME());
         
          newEnt.setAUDI_EXEC_END_TIME(this.getAUDI_EXEC_END_TIME());
         
          newEnt.setAUDI_SUPINT_NM(this.getAUDI_SUPINT_NM());
         
          newEnt.setAUDI_SUPINT_POS(this.getAUDI_SUPINT_POS());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_MGRHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getM_SEQ();
        
             case 2 :
                 return  this.getCOI_WRT_NUM();
        
             case 3 :
                 return  this.getTMP_WRT_NUM();
        
             case 4 :
                 return  this.getDISPO_CLASS();
        
             case 5 :
                 return  this.getVIOL_DT();
        
             case 6 :
                 return  this.getDISPO_CAUSE();
        
             case 7 :
                 return  this.getNOTE_DT();
        
             case 8 :
                 return  this.getNOTE_RECV_YN();
        
             case 9 :
                 return  this.getNOTE_OPIN_PRES_LIM_DT();
        
             case 10 :
                 return  this.getDEL_NOTE_DT();
        
             case 11 :
                 return  this.getDEL_OPIN_PRES_LIM_DT();
        
             case 12 :
                 return  this.getDISPO_CONT();
        
             case 13 :
                 return  this.getDISPO_DT();
        
             case 14 :
                 return  this.getBUSISUSP_START_DT();
        
             case 15 :
                 return  this.getBUSISUSP_END_DT();
        
             case 16 :
                 return  this.getREMARK();
        
             case 17 :
                 return  this.getRECV_DT();
        
             case 18 :
                 return  this.getMOT_STE();
        
             case 19 :
                 return  this.getDOC_CODE();
        
             case 20 :
                 return  this.getINS_DT();
        
             case 21 :
                 return  this.getUPD_DT();
        
             case 22 :
                 return  this.getWRT_ID();
        
             case 23 :
                 return  this.getREGSTD_START_DT();
        
             case 24 :
                 return  this.getREGSTD_END_DT();
        
             case 25 :
                 return  this.getFINE();
        
             case 26 :
                 return  this.getPAY_NOTI_DT();
        
             case 27 :
                 return  this.getPAY_TERM();
        
             case 28 :
                 return  this.getPAY_DT();
        
             case 29 :
                 return  this.getDEL_RECV_YN();
        
             case 30 :
                 return  this.getWRT_NUM();
        
             case 31 :
                 return  this.getSIDO_CODE();
        
             case 32 :
                 return  this.getSND_STE();
        
             case 33 :
                 return  this.getSND_DT();
        
             case 34 :
                 return  this.getPUNISHMENT_AGENCY();
        
             case 35 :
                 return  this.getDISPO_CONT_NM();
        
             case 36 :
                 return  this.getAUDI_EXEC_ADDR();
        
             case 37 :
                 return  this.getAUDI_EXEC_DT();
        
             case 38 :
                 return  this.getAUDI_EXEC_START_TIME();
        
             case 39 :
                 return  this.getAUDI_EXEC_END_TIME();
        
             case 40 :
                 return  this.getAUDI_SUPINT_NM();
        
             case 41 :
                 return  this.getAUDI_SUPINT_POS();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_MGRHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setM_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
             case 3 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setDISPO_CLASS((String)value);
	            return;  
        
             case 5 :
                    this.setVIOL_DT((String)value);
	            return;  
        
             case 6 :
                    this.setDISPO_CAUSE((String)value);
	            return;  
        
             case 7 :
                    this.setNOTE_DT((String)value);
	            return;  
        
             case 8 :
                    this.setNOTE_RECV_YN((String)value);
	            return;  
        
             case 9 :
                    this.setNOTE_OPIN_PRES_LIM_DT((String)value);
	            return;  
        
             case 10 :
                    this.setDEL_NOTE_DT((String)value);
	            return;  
        
             case 11 :
                    this.setDEL_OPIN_PRES_LIM_DT((String)value);
	            return;  
        
             case 12 :
                    this.setDISPO_CONT((String)value);
	            return;  
        
             case 13 :
                    this.setDISPO_DT((String)value);
	            return;  
        
             case 14 :
                    this.setBUSISUSP_START_DT((String)value);
	            return;  
        
             case 15 :
                    this.setBUSISUSP_END_DT((String)value);
	            return;  
        
             case 16 :
                    this.setREMARK((String)value);
	            return;  
        
             case 17 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 18 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 19 :
                    this.setDOC_CODE((String)value);
	            return;  
        
             case 20 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 21 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 22 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 23 :
                    this.setREGSTD_START_DT((String)value);
	            return;  
        
             case 24 :
                    this.setREGSTD_END_DT((String)value);
	            return;  
        
             case 25 :
                    this.setFINE((String)value);
	            return;  
        
             case 26 :
                    this.setPAY_NOTI_DT((String)value);
	            return;  
        
             case 27 :
                    this.setPAY_TERM((String)value);
	            return;  
        
             case 28 :
                    this.setPAY_DT((String)value);
	            return;  
        
             case 29 :
                    this.setDEL_RECV_YN((String)value);
	            return;  
        
             case 30 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 31 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 32 :
                    this.setSND_STE((String)value);
	            return;  
        
             case 33 :
                    this.setSND_DT((String)value);
	            return;  
        
             case 34 :
                    this.setPUNISHMENT_AGENCY((String)value);
	            return;  
        
             case 35 :
                    this.setDISPO_CONT_NM((String)value);
	            return;  
        
             case 36 :
                    this.setAUDI_EXEC_ADDR((String)value);
	            return;  
        
             case 37 :
                    this.setAUDI_EXEC_DT((String)value);
	            return;  
        
             case 38 :
                    this.setAUDI_EXEC_START_TIME((String)value);
	            return;  
        
             case 39 :
                    this.setAUDI_EXEC_END_TIME((String)value);
	            return;  
        
             case 40 :
                    this.setAUDI_SUPINT_NM((String)value);
	            return;  
        
             case 41 :
                    this.setAUDI_SUPINT_POS((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_MGRHelper.toXML(this);
  }
  
}
