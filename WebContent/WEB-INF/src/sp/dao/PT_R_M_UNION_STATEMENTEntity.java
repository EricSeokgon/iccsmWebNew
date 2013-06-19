

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_M_UNION_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               COI_WRT_NUM:VARCHAR2(6):  
*               MOT_STE:VARCHAR2(6):  
*               DEFI_STE:VARCHAR2(1):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_TIME:VARCHAR2(6):  
*               PROC_LIM:VARCHAR2(8):  
*               PROC_TIME:VARCHAR2(4):  
*               COMMANA_CLASS:VARCHAR2(1):  
*               MANA_NUM:VARCHAR2(18):  
*               NAME:VARCHAR2(50):  
*               REP_SSN1:VARCHAR2(18):  
*               REP_SSN2:VARCHAR2(21):  
*               REP_NM_KOR:VARCHAR2(20):  
*               REP_NM_HAN:VARCHAR2(20):  
*               REP_TEL_NUM:VARCHAR2(17):  
*               ADDR_POST_NUM:VARCHAR2(6):  
*               ADDR_ADDR:VARCHAR2(120):  
*               ADDR_DETAIL_ADDR:VARCHAR2(120):  
*               ADDR_TEL_NUM:VARCHAR2(17):  
*               ADDR_FAX_NUM:VARCHAR2(17):  
*               EMAIL_ADDR:VARCHAR2(30):  
*               OFFICE_AREA:VARCHAR2(10):  
*               OFFICE_USE_CODE:VARCHAR2(6):  
*               COMPANY_DIAG_CLASS_CODE:VARCHAR2(6):  
*               COMPANY_DIAG_BAS_DT:VARCHAR2(8):  
*               COMPANY_DIAG_ISSUE_DT:VARCHAR2(8):  
*               DIAG_ORG_CODE:VARCHAR2(6):  
*               DIAG_NM_NM:VARCHAR2(50):  
*               DIAG_NM_WRT_NUM:VARCHAR2(50):  
*               PAY_CAP:VARCHAR2(15):  
*               REA_CAP:VARCHAR2(15):  
*               TUP_AOM:VARCHAR2(15):  
*               TUP_CLASS_CODE:VARCHAR2(6):  
*               COM_COV_DT:VARCHAR2(8):  
*               BAS_STA_DT:VARCHAR2(8):  
*               OFFICE_OWN_CLASS:VARCHAR2(1):  
*               REP_MOBILE:VARCHAR2(17):  
*               LICTAX:VARCHAR2(1):  
*               HOSCRE:VARCHAR2(1):  
*               COM_NUM:VARCHAR2(13):  
*               GUBUN:VARCHAR2(25):  
*               DOC_CODE:VARCHAR2(30):  
*               OFFICE_USE_NAME:VARCHAR2(20):  
*               MEMO_CONT:VARCHAR2(250):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_DT:VARCHAR2(24):  
*               CHG_DT:VARCHAR2(24):  
*               CHGBRE_SEQ:VARCHAR2(4):  
*               COMPANY_DIAG_BAS_DT2:VARCHAR2(8):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN_YN:VARCHAR2(1):  
*               REGIST_YMD:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_M_UNION_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String COI_WRT_NUM;
  
     private String MOT_STE;
  
     private String DEFI_STE;
  
     private String RECV_DT;
  
     private String RECV_TIME;
  
     private String PROC_LIM;
  
     private String PROC_TIME;
  
     private String COMMANA_CLASS;
  
     private String MANA_NUM;
  
     private String NAME;
  
     private String REP_SSN1;
  
     private String REP_SSN2;
  
     private String REP_NM_KOR;
  
     private String REP_NM_HAN;
  
     private String REP_TEL_NUM;
  
     private String ADDR_POST_NUM;
  
     private String ADDR_ADDR;
  
     private String ADDR_DETAIL_ADDR;
  
     private String ADDR_TEL_NUM;
  
     private String ADDR_FAX_NUM;
  
     private String EMAIL_ADDR;
  
     private String OFFICE_AREA;
  
     private String OFFICE_USE_CODE;
  
     private String COMPANY_DIAG_CLASS_CODE;
  
     private String COMPANY_DIAG_BAS_DT;
  
     private String COMPANY_DIAG_ISSUE_DT;
  
     private String DIAG_ORG_CODE;
  
     private String DIAG_NM_NM;
  
     private String DIAG_NM_WRT_NUM;
  
     private String PAY_CAP;
  
     private String REA_CAP;
  
     private String TUP_AOM;
  
     private String TUP_CLASS_CODE;
  
     private String COM_COV_DT;
  
     private String BAS_STA_DT;
  
     private String OFFICE_OWN_CLASS;
  
     private String REP_MOBILE;
  
     private String LICTAX;
  
     private String HOSCRE;
  
     private String COM_NUM;
  
     private String GUBUN;
  
     private String DOC_CODE;
  
     private String OFFICE_USE_NAME;
  
     private String MEMO_CONT;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String TMP_WRT_NUM;
  
     private String WRT_DT;
  
     private String CHG_DT;
  
     private String CHGBRE_SEQ;
  
     private String COMPANY_DIAG_BAS_DT2;
  
     private String BUSS_YMD;
  
     private String FOREIGN_YN;
  
     private String REGIST_YMD;
  

//생성자를 만든다
    public PT_R_M_UNION_STATEMENTEntity(){
    }
    
    
    public PT_R_M_UNION_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_M_UNION_STATEMENTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
       
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.DEFI_STE =request.getParameter("DEFI_STE");
		this.RECV_DT =request.getParameter("RECV_DT");
		this.RECV_TIME =request.getParameter("RECV_TIME");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.PROC_TIME =request.getParameter("PROC_TIME");
		this.COMMANA_CLASS =request.getParameter("COMMANA_CLASS");
		this.MANA_NUM =request.getParameter("MANA_NUM");
		this.NAME =request.getParameter("NAME");
		this.REP_SSN1 =request.getParameter("REP_SSN1");
		this.REP_SSN2 =request.getParameter("REP_SSN2");
		this.REP_NM_KOR =request.getParameter("REP_NM_KOR");
		this.REP_NM_HAN =request.getParameter("REP_NM_HAN");
		this.REP_TEL_NUM =request.getParameter("REP_TEL_NUM");
		this.ADDR_POST_NUM =request.getParameter("ADDR_POST_NUM");
		this.ADDR_ADDR =request.getParameter("ADDR_ADDR");
		this.ADDR_DETAIL_ADDR =request.getParameter("ADDR_DETAIL_ADDR");
		this.ADDR_TEL_NUM =request.getParameter("ADDR_TEL_NUM");
		this.ADDR_FAX_NUM =request.getParameter("ADDR_FAX_NUM");
		this.EMAIL_ADDR =request.getParameter("EMAIL_ADDR");
		this.OFFICE_AREA =request.getParameter("OFFICE_AREA");
		this.OFFICE_USE_CODE =request.getParameter("OFFICE_USE_CODE");
		this.COMPANY_DIAG_CLASS_CODE =request.getParameter("COMPANY_DIAG_CLASS_CODE");
		this.COMPANY_DIAG_BAS_DT =request.getParameter("COMPANY_DIAG_BAS_DT");
		this.COMPANY_DIAG_ISSUE_DT =request.getParameter("COMPANY_DIAG_ISSUE_DT");
		this.DIAG_ORG_CODE =request.getParameter("DIAG_ORG_CODE");
		this.DIAG_NM_NM =request.getParameter("DIAG_NM_NM");
		this.DIAG_NM_WRT_NUM =request.getParameter("DIAG_NM_WRT_NUM");
		this.PAY_CAP =request.getParameter("PAY_CAP");
		this.REA_CAP =request.getParameter("REA_CAP");
		this.TUP_AOM =request.getParameter("TUP_AOM");
		this.TUP_CLASS_CODE =request.getParameter("TUP_CLASS_CODE");
		this.COM_COV_DT =request.getParameter("COM_COV_DT");
		this.BAS_STA_DT =request.getParameter("BAS_STA_DT");
		this.OFFICE_OWN_CLASS =request.getParameter("OFFICE_OWN_CLASS");
		this.REP_MOBILE =request.getParameter("REP_MOBILE");
		this.LICTAX =request.getParameter("LICTAX");
		this.HOSCRE =request.getParameter("HOSCRE");
		this.COM_NUM =request.getParameter("COM_NUM");
		this.GUBUN =request.getParameter("GUBUN");
		this.DOC_CODE =request.getParameter("DOC_CODE");
		this.OFFICE_USE_NAME =request.getParameter("OFFICE_USE_NAME");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_DT =request.getParameter("WRT_DT");
		this.CHG_DT =request.getParameter("CHG_DT");
		this.CHGBRE_SEQ =request.getParameter("CHGBRE_SEQ");
		this.COMPANY_DIAG_BAS_DT2 =request.getParameter("COMPANY_DIAG_BAS_DT2");
		this.BUSS_YMD =request.getParameter("BUSS_YMD");
		this.FOREIGN_YN =request.getParameter("FOREIGN_YN");
		this.REGIST_YMD =request.getParameter("REGIST_YMD");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.DEFI_STE =KJFMi.dsGet(ds, arg_row, "DEFI_STE");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.RECV_TIME =KJFMi.dsGet(ds, arg_row, "RECV_TIME");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.PROC_TIME =KJFMi.dsGet(ds, arg_row, "PROC_TIME");
		this.COMMANA_CLASS =KJFMi.dsGet(ds, arg_row, "COMMANA_CLASS");
		this.MANA_NUM =KJFMi.dsGet(ds, arg_row, "MANA_NUM");
		this.NAME =KJFMi.dsGet(ds, arg_row, "NAME");
		this.REP_SSN1 =KJFMi.dsGet(ds, arg_row, "REP_SSN1");
		this.REP_SSN2 =KJFMi.dsGet(ds, arg_row, "REP_SSN2");
		this.REP_NM_KOR =KJFMi.dsGet(ds, arg_row, "REP_NM_KOR");
		this.REP_NM_HAN =KJFMi.dsGet(ds, arg_row, "REP_NM_HAN");
		this.REP_TEL_NUM =KJFMi.dsGet(ds, arg_row, "REP_TEL_NUM");
		this.ADDR_POST_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_POST_NUM");
		this.ADDR_ADDR =KJFMi.dsGet(ds, arg_row, "ADDR_ADDR");
		this.ADDR_DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "ADDR_DETAIL_ADDR");
		this.ADDR_TEL_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_TEL_NUM");
		this.ADDR_FAX_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_FAX_NUM");
		this.EMAIL_ADDR =KJFMi.dsGet(ds, arg_row, "EMAIL_ADDR");
		this.OFFICE_AREA =KJFMi.dsGet(ds, arg_row, "OFFICE_AREA");
		this.OFFICE_USE_CODE =KJFMi.dsGet(ds, arg_row, "OFFICE_USE_CODE");
		this.COMPANY_DIAG_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_CLASS_CODE");
		this.COMPANY_DIAG_BAS_DT =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_BAS_DT");
		this.COMPANY_DIAG_ISSUE_DT =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_ISSUE_DT");
		this.DIAG_ORG_CODE =KJFMi.dsGet(ds, arg_row, "DIAG_ORG_CODE");
		this.DIAG_NM_NM =KJFMi.dsGet(ds, arg_row, "DIAG_NM_NM");
		this.DIAG_NM_WRT_NUM =KJFMi.dsGet(ds, arg_row, "DIAG_NM_WRT_NUM");
		this.PAY_CAP =KJFMi.dsGet(ds, arg_row, "PAY_CAP");
		this.REA_CAP =KJFMi.dsGet(ds, arg_row, "REA_CAP");
		this.TUP_AOM =KJFMi.dsGet(ds, arg_row, "TUP_AOM");
		this.TUP_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "TUP_CLASS_CODE");
		this.COM_COV_DT =KJFMi.dsGet(ds, arg_row, "COM_COV_DT");
		this.BAS_STA_DT =KJFMi.dsGet(ds, arg_row, "BAS_STA_DT");
		this.OFFICE_OWN_CLASS =KJFMi.dsGet(ds, arg_row, "OFFICE_OWN_CLASS");
		this.REP_MOBILE =KJFMi.dsGet(ds, arg_row, "REP_MOBILE");
		this.LICTAX =KJFMi.dsGet(ds, arg_row, "LICTAX");
		this.HOSCRE =KJFMi.dsGet(ds, arg_row, "HOSCRE");
		this.COM_NUM =KJFMi.dsGet(ds, arg_row, "COM_NUM");
		this.GUBUN =KJFMi.dsGet(ds, arg_row, "GUBUN");
		this.DOC_CODE =KJFMi.dsGet(ds, arg_row, "DOC_CODE");
		this.OFFICE_USE_NAME =KJFMi.dsGet(ds, arg_row, "OFFICE_USE_NAME");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.CHG_DT =KJFMi.dsGet(ds, arg_row, "CHG_DT");
		this.CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "CHGBRE_SEQ");
		this.COMPANY_DIAG_BAS_DT2 =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_BAS_DT2");
		this.BUSS_YMD =KJFMi.dsGet(ds, arg_row, "BUSS_YMD");
		this.FOREIGN_YN =KJFMi.dsGet(ds, arg_row, "FOREIGN_YN");
		this.REGIST_YMD =KJFMi.dsGet(ds, arg_row, "REGIST_YMD");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  
     public String getDEFI_STE(){
             return DEFI_STE;
     };
  
     public String getRECV_DT(){
             return RECV_DT;
     };
  
     public String getRECV_TIME(){
             return RECV_TIME;
     };
  
     public String getPROC_LIM(){
             return PROC_LIM;
     };
  
     public String getPROC_TIME(){
             return PROC_TIME;
     };
  
     public String getCOMMANA_CLASS(){
             return COMMANA_CLASS;
     };
  
     public String getMANA_NUM(){
             return MANA_NUM;
     };
  
     public String getNAME(){
             return NAME;
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
  
     public String getREP_TEL_NUM(){
             return REP_TEL_NUM;
     };
  
     public String getADDR_POST_NUM(){
             return ADDR_POST_NUM;
     };
  
     public String getADDR_ADDR(){
             return ADDR_ADDR;
     };
  
     public String getADDR_DETAIL_ADDR(){
             return ADDR_DETAIL_ADDR;
     };
  
     public String getADDR_TEL_NUM(){
             return ADDR_TEL_NUM;
     };
  
     public String getADDR_FAX_NUM(){
             return ADDR_FAX_NUM;
     };
  
     public String getEMAIL_ADDR(){
             return EMAIL_ADDR;
     };
  
     public String getOFFICE_AREA(){
             return OFFICE_AREA;
     };
  
     public String getOFFICE_USE_CODE(){
             return OFFICE_USE_CODE;
     };
  
     public String getCOMPANY_DIAG_CLASS_CODE(){
             return COMPANY_DIAG_CLASS_CODE;
     };
  
     public String getCOMPANY_DIAG_BAS_DT(){
             return COMPANY_DIAG_BAS_DT;
     };
  
     public String getCOMPANY_DIAG_ISSUE_DT(){
             return COMPANY_DIAG_ISSUE_DT;
     };
  
     public String getDIAG_ORG_CODE(){
             return DIAG_ORG_CODE;
     };
  
     public String getDIAG_NM_NM(){
             return DIAG_NM_NM;
     };
  
     public String getDIAG_NM_WRT_NUM(){
             return DIAG_NM_WRT_NUM;
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
  
     public String getCOM_COV_DT(){
             return COM_COV_DT;
     };
  
     public String getBAS_STA_DT(){
             return BAS_STA_DT;
     };
  
     public String getOFFICE_OWN_CLASS(){
             return OFFICE_OWN_CLASS;
     };
  
     public String getREP_MOBILE(){
             return REP_MOBILE;
     };
  
     public String getLICTAX(){
             return LICTAX;
     };
  
     public String getHOSCRE(){
             return HOSCRE;
     };
  
     public String getCOM_NUM(){
             return COM_NUM;
     };
  
     public String getGUBUN(){
             return GUBUN;
     };
  
     public String getDOC_CODE(){
             return DOC_CODE;
     };
  
     public String getOFFICE_USE_NAME(){
             return OFFICE_USE_NAME;
     };
  
     public String getMEMO_CONT(){
             return MEMO_CONT;
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
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
     };
  
     public String getCHG_DT(){
             return CHG_DT;
     };
  
     public String getCHGBRE_SEQ(){
             return CHGBRE_SEQ;
     };
  
     public String getCOMPANY_DIAG_BAS_DT2(){
             return COMPANY_DIAG_BAS_DT2;
     };
  
     public String getBUSS_YMD(){
             return BUSS_YMD;
     };
  
     public String getFOREIGN_YN(){
             return FOREIGN_YN;
     };
  
     public String getREGIST_YMD(){
             return REGIST_YMD;
     };
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
     public void setDEFI_STE(String DEFI_STE){
            this.DEFI_STE=DEFI_STE;
     };
  
     public void setRECV_DT(String RECV_DT){
            this.RECV_DT=RECV_DT;
     };
  
     public void setRECV_TIME(String RECV_TIME){
            this.RECV_TIME=RECV_TIME;
     };
  
     public void setPROC_LIM(String PROC_LIM){
            this.PROC_LIM=PROC_LIM;
     };
  
     public void setPROC_TIME(String PROC_TIME){
            this.PROC_TIME=PROC_TIME;
     };
  
     public void setCOMMANA_CLASS(String COMMANA_CLASS){
            this.COMMANA_CLASS=COMMANA_CLASS;
     };
  
     public void setMANA_NUM(String MANA_NUM){
            this.MANA_NUM=MANA_NUM;
     };
  
     public void setNAME(String NAME){
            this.NAME=NAME;
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
  
     public void setREP_TEL_NUM(String REP_TEL_NUM){
            this.REP_TEL_NUM=REP_TEL_NUM;
     };
  
     public void setADDR_POST_NUM(String ADDR_POST_NUM){
            this.ADDR_POST_NUM=ADDR_POST_NUM;
     };
  
     public void setADDR_ADDR(String ADDR_ADDR){
            this.ADDR_ADDR=ADDR_ADDR;
     };
  
     public void setADDR_DETAIL_ADDR(String ADDR_DETAIL_ADDR){
            this.ADDR_DETAIL_ADDR=ADDR_DETAIL_ADDR;
     };
  
     public void setADDR_TEL_NUM(String ADDR_TEL_NUM){
            this.ADDR_TEL_NUM=ADDR_TEL_NUM;
     };
  
     public void setADDR_FAX_NUM(String ADDR_FAX_NUM){
            this.ADDR_FAX_NUM=ADDR_FAX_NUM;
     };
  
     public void setEMAIL_ADDR(String EMAIL_ADDR){
            this.EMAIL_ADDR=EMAIL_ADDR;
     };
  
     public void setOFFICE_AREA(String OFFICE_AREA){
            this.OFFICE_AREA=OFFICE_AREA;
     };
  
     public void setOFFICE_USE_CODE(String OFFICE_USE_CODE){
            this.OFFICE_USE_CODE=OFFICE_USE_CODE;
     };
  
     public void setCOMPANY_DIAG_CLASS_CODE(String COMPANY_DIAG_CLASS_CODE){
            this.COMPANY_DIAG_CLASS_CODE=COMPANY_DIAG_CLASS_CODE;
     };
  
     public void setCOMPANY_DIAG_BAS_DT(String COMPANY_DIAG_BAS_DT){
            this.COMPANY_DIAG_BAS_DT=COMPANY_DIAG_BAS_DT;
     };
  
     public void setCOMPANY_DIAG_ISSUE_DT(String COMPANY_DIAG_ISSUE_DT){
            this.COMPANY_DIAG_ISSUE_DT=COMPANY_DIAG_ISSUE_DT;
     };
  
     public void setDIAG_ORG_CODE(String DIAG_ORG_CODE){
            this.DIAG_ORG_CODE=DIAG_ORG_CODE;
     };
  
     public void setDIAG_NM_NM(String DIAG_NM_NM){
            this.DIAG_NM_NM=DIAG_NM_NM;
     };
  
     public void setDIAG_NM_WRT_NUM(String DIAG_NM_WRT_NUM){
            this.DIAG_NM_WRT_NUM=DIAG_NM_WRT_NUM;
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
  
     public void setCOM_COV_DT(String COM_COV_DT){
            this.COM_COV_DT=COM_COV_DT;
     };
  
     public void setBAS_STA_DT(String BAS_STA_DT){
            this.BAS_STA_DT=BAS_STA_DT;
     };
  
     public void setOFFICE_OWN_CLASS(String OFFICE_OWN_CLASS){
            this.OFFICE_OWN_CLASS=OFFICE_OWN_CLASS;
     };
  
     public void setREP_MOBILE(String REP_MOBILE){
            this.REP_MOBILE=REP_MOBILE;
     };
  
     public void setLICTAX(String LICTAX){
            this.LICTAX=LICTAX;
     };
  
     public void setHOSCRE(String HOSCRE){
            this.HOSCRE=HOSCRE;
     };
  
     public void setCOM_NUM(String COM_NUM){
            this.COM_NUM=COM_NUM;
     };
  
     public void setGUBUN(String GUBUN){
            this.GUBUN=GUBUN;
     };
  
     public void setDOC_CODE(String DOC_CODE){
            this.DOC_CODE=DOC_CODE;
     };
  
     public void setOFFICE_USE_NAME(String OFFICE_USE_NAME){
            this.OFFICE_USE_NAME=OFFICE_USE_NAME;
     };
  
     public void setMEMO_CONT(String MEMO_CONT){
            this.MEMO_CONT=MEMO_CONT;
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
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
     };
  
     public void setCHG_DT(String CHG_DT){
            this.CHG_DT=CHG_DT;
     };
  
     public void setCHGBRE_SEQ(String CHGBRE_SEQ){
            this.CHGBRE_SEQ=CHGBRE_SEQ;
     };
  
     public void setCOMPANY_DIAG_BAS_DT2(String COMPANY_DIAG_BAS_DT2){
            this.COMPANY_DIAG_BAS_DT2=COMPANY_DIAG_BAS_DT2;
     };
  
     public void setBUSS_YMD(String BUSS_YMD){
            this.BUSS_YMD=BUSS_YMD;
     };
  
     public void setFOREIGN_YN(String FOREIGN_YN){
            this.FOREIGN_YN=FOREIGN_YN;
     };
  
     public void setREGIST_YMD(String REGIST_YMD){
            this.REGIST_YMD=REGIST_YMD;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("DEFI_STE:"+ this.getDEFI_STE()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("RECV_TIME:"+ this.getRECV_TIME()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("PROC_TIME:"+ this.getPROC_TIME()+"\n");
      
      strB.append("COMMANA_CLASS:"+ this.getCOMMANA_CLASS()+"\n");
      
      strB.append("MANA_NUM:"+ this.getMANA_NUM()+"\n");
      
      strB.append("NAME:"+ this.getNAME()+"\n");
      
      strB.append("REP_SSN1:"+ this.getREP_SSN1()+"\n");
      
      strB.append("REP_SSN2:"+ this.getREP_SSN2()+"\n");
      
      strB.append("REP_NM_KOR:"+ this.getREP_NM_KOR()+"\n");
      
      strB.append("REP_NM_HAN:"+ this.getREP_NM_HAN()+"\n");
      
      strB.append("REP_TEL_NUM:"+ this.getREP_TEL_NUM()+"\n");
      
      strB.append("ADDR_POST_NUM:"+ this.getADDR_POST_NUM()+"\n");
      
      strB.append("ADDR_ADDR:"+ this.getADDR_ADDR()+"\n");
      
      strB.append("ADDR_DETAIL_ADDR:"+ this.getADDR_DETAIL_ADDR()+"\n");
      
      strB.append("ADDR_TEL_NUM:"+ this.getADDR_TEL_NUM()+"\n");
      
      strB.append("ADDR_FAX_NUM:"+ this.getADDR_FAX_NUM()+"\n");
      
      strB.append("EMAIL_ADDR:"+ this.getEMAIL_ADDR()+"\n");
      
      strB.append("OFFICE_AREA:"+ this.getOFFICE_AREA()+"\n");
      
      strB.append("OFFICE_USE_CODE:"+ this.getOFFICE_USE_CODE()+"\n");
      
      strB.append("COMPANY_DIAG_CLASS_CODE:"+ this.getCOMPANY_DIAG_CLASS_CODE()+"\n");
      
      strB.append("COMPANY_DIAG_BAS_DT:"+ this.getCOMPANY_DIAG_BAS_DT()+"\n");
      
      strB.append("COMPANY_DIAG_ISSUE_DT:"+ this.getCOMPANY_DIAG_ISSUE_DT()+"\n");
      
      strB.append("DIAG_ORG_CODE:"+ this.getDIAG_ORG_CODE()+"\n");
      
      strB.append("DIAG_NM_NM:"+ this.getDIAG_NM_NM()+"\n");
      
      strB.append("DIAG_NM_WRT_NUM:"+ this.getDIAG_NM_WRT_NUM()+"\n");
      
      strB.append("PAY_CAP:"+ this.getPAY_CAP()+"\n");
      
      strB.append("REA_CAP:"+ this.getREA_CAP()+"\n");
      
      strB.append("TUP_AOM:"+ this.getTUP_AOM()+"\n");
      
      strB.append("TUP_CLASS_CODE:"+ this.getTUP_CLASS_CODE()+"\n");
      
      strB.append("COM_COV_DT:"+ this.getCOM_COV_DT()+"\n");
      
      strB.append("BAS_STA_DT:"+ this.getBAS_STA_DT()+"\n");
      
      strB.append("OFFICE_OWN_CLASS:"+ this.getOFFICE_OWN_CLASS()+"\n");
      
      strB.append("REP_MOBILE:"+ this.getREP_MOBILE()+"\n");
      
      strB.append("LICTAX:"+ this.getLICTAX()+"\n");
      
      strB.append("HOSCRE:"+ this.getHOSCRE()+"\n");
      
      strB.append("COM_NUM:"+ this.getCOM_NUM()+"\n");
      
      strB.append("GUBUN:"+ this.getGUBUN()+"\n");
      
      strB.append("DOC_CODE:"+ this.getDOC_CODE()+"\n");
      
      strB.append("OFFICE_USE_NAME:"+ this.getOFFICE_USE_NAME()+"\n");
      
      strB.append("MEMO_CONT:"+ this.getMEMO_CONT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("CHG_DT:"+ this.getCHG_DT()+"\n");
      
      strB.append("CHGBRE_SEQ:"+ this.getCHGBRE_SEQ()+"\n");
      
      strB.append("COMPANY_DIAG_BAS_DT2:"+ this.getCOMPANY_DIAG_BAS_DT2()+"\n");
      
      strB.append("BUSS_YMD:"+ this.getBUSS_YMD()+"\n");
      
      strB.append("FOREIGN_YN:"+ this.getFOREIGN_YN()+"\n");
      
      strB.append("REGIST_YMD:"+ this.getREGIST_YMD()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_M_UNION_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_M_UNION_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_M_UNION_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_M_UNION_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_M_UNION_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_M_UNION_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_M_UNION_STATEMENTEntity newEnt = new PT_R_M_UNION_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setRECV_TIME(this.getRECV_TIME());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setPROC_TIME(this.getPROC_TIME());
         
          newEnt.setCOMMANA_CLASS(this.getCOMMANA_CLASS());
         
          newEnt.setMANA_NUM(this.getMANA_NUM());
         
          newEnt.setNAME(this.getNAME());
         
          newEnt.setREP_SSN1(this.getREP_SSN1());
         
          newEnt.setREP_SSN2(this.getREP_SSN2());
         
          newEnt.setREP_NM_KOR(this.getREP_NM_KOR());
         
          newEnt.setREP_NM_HAN(this.getREP_NM_HAN());
         
          newEnt.setREP_TEL_NUM(this.getREP_TEL_NUM());
         
          newEnt.setADDR_POST_NUM(this.getADDR_POST_NUM());
         
          newEnt.setADDR_ADDR(this.getADDR_ADDR());
         
          newEnt.setADDR_DETAIL_ADDR(this.getADDR_DETAIL_ADDR());
         
          newEnt.setADDR_TEL_NUM(this.getADDR_TEL_NUM());
         
          newEnt.setADDR_FAX_NUM(this.getADDR_FAX_NUM());
         
          newEnt.setEMAIL_ADDR(this.getEMAIL_ADDR());
         
          newEnt.setOFFICE_AREA(this.getOFFICE_AREA());
         
          newEnt.setOFFICE_USE_CODE(this.getOFFICE_USE_CODE());
         
          newEnt.setCOMPANY_DIAG_CLASS_CODE(this.getCOMPANY_DIAG_CLASS_CODE());
         
          newEnt.setCOMPANY_DIAG_BAS_DT(this.getCOMPANY_DIAG_BAS_DT());
         
          newEnt.setCOMPANY_DIAG_ISSUE_DT(this.getCOMPANY_DIAG_ISSUE_DT());
         
          newEnt.setDIAG_ORG_CODE(this.getDIAG_ORG_CODE());
         
          newEnt.setDIAG_NM_NM(this.getDIAG_NM_NM());
         
          newEnt.setDIAG_NM_WRT_NUM(this.getDIAG_NM_WRT_NUM());
         
          newEnt.setPAY_CAP(this.getPAY_CAP());
         
          newEnt.setREA_CAP(this.getREA_CAP());
         
          newEnt.setTUP_AOM(this.getTUP_AOM());
         
          newEnt.setTUP_CLASS_CODE(this.getTUP_CLASS_CODE());
         
          newEnt.setCOM_COV_DT(this.getCOM_COV_DT());
         
          newEnt.setBAS_STA_DT(this.getBAS_STA_DT());
         
          newEnt.setOFFICE_OWN_CLASS(this.getOFFICE_OWN_CLASS());
         
          newEnt.setREP_MOBILE(this.getREP_MOBILE());
         
          newEnt.setLICTAX(this.getLICTAX());
         
          newEnt.setHOSCRE(this.getHOSCRE());
         
          newEnt.setCOM_NUM(this.getCOM_NUM());
         
          newEnt.setGUBUN(this.getGUBUN());
         
          newEnt.setDOC_CODE(this.getDOC_CODE());
         
          newEnt.setOFFICE_USE_NAME(this.getOFFICE_USE_NAME());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setCHG_DT(this.getCHG_DT());
         
          newEnt.setCHGBRE_SEQ(this.getCHGBRE_SEQ());
         
          newEnt.setCOMPANY_DIAG_BAS_DT2(this.getCOMPANY_DIAG_BAS_DT2());
         
          newEnt.setBUSS_YMD(this.getBUSS_YMD());
         
          newEnt.setFOREIGN_YN(this.getFOREIGN_YN());
         
          newEnt.setREGIST_YMD(this.getREGIST_YMD());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_M_UNION_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSIDO_CODE();
        
             case 3 :
                 return  this.getCOI_WRT_NUM();
        
             case 4 :
                 return  this.getMOT_STE();
        
             case 5 :
                 return  this.getDEFI_STE();
        
             case 6 :
                 return  this.getRECV_DT();
        
             case 7 :
                 return  this.getRECV_TIME();
        
             case 8 :
                 return  this.getPROC_LIM();
        
             case 9 :
                 return  this.getPROC_TIME();
        
             case 10 :
                 return  this.getCOMMANA_CLASS();
        
             case 11 :
                 return  this.getMANA_NUM();
        
             case 12 :
                 return  this.getNAME();
        
             case 13 :
                 return  this.getREP_SSN1();
        
             case 14 :
                 return  this.getREP_SSN2();
        
             case 15 :
                 return  this.getREP_NM_KOR();
        
             case 16 :
                 return  this.getREP_NM_HAN();
        
             case 17 :
                 return  this.getREP_TEL_NUM();
        
             case 18 :
                 return  this.getADDR_POST_NUM();
        
             case 19 :
                 return  this.getADDR_ADDR();
        
             case 20 :
                 return  this.getADDR_DETAIL_ADDR();
        
             case 21 :
                 return  this.getADDR_TEL_NUM();
        
             case 22 :
                 return  this.getADDR_FAX_NUM();
        
             case 23 :
                 return  this.getEMAIL_ADDR();
        
             case 24 :
                 return  this.getOFFICE_AREA();
        
             case 25 :
                 return  this.getOFFICE_USE_CODE();
        
             case 26 :
                 return  this.getCOMPANY_DIAG_CLASS_CODE();
        
             case 27 :
                 return  this.getCOMPANY_DIAG_BAS_DT();
        
             case 28 :
                 return  this.getCOMPANY_DIAG_ISSUE_DT();
        
             case 29 :
                 return  this.getDIAG_ORG_CODE();
        
             case 30 :
                 return  this.getDIAG_NM_NM();
        
             case 31 :
                 return  this.getDIAG_NM_WRT_NUM();
        
             case 32 :
                 return  this.getPAY_CAP();
        
             case 33 :
                 return  this.getREA_CAP();
        
             case 34 :
                 return  this.getTUP_AOM();
        
             case 35 :
                 return  this.getTUP_CLASS_CODE();
        
             case 36 :
                 return  this.getCOM_COV_DT();
        
             case 37 :
                 return  this.getBAS_STA_DT();
        
             case 38 :
                 return  this.getOFFICE_OWN_CLASS();
        
             case 39 :
                 return  this.getREP_MOBILE();
        
             case 40 :
                 return  this.getLICTAX();
        
             case 41 :
                 return  this.getHOSCRE();
        
             case 42 :
                 return  this.getCOM_NUM();
        
             case 43 :
                 return  this.getGUBUN();
        
             case 44 :
                 return  this.getDOC_CODE();
        
             case 45 :
                 return  this.getOFFICE_USE_NAME();
        
             case 46 :
                 return  this.getMEMO_CONT();
        
             case 47 :
                 return  this.getWRT_ID();
        
             case 48 :
                 return  this.getINS_DT();
        
             case 49 :
                 return  this.getUPD_DT();
        
             case 50 :
                 return  this.getTMP_WRT_NUM();
        
             case 51 :
                 return  this.getWRT_DT();
        
             case 52 :
                 return  this.getCHG_DT();
        
             case 53 :
                 return  this.getCHGBRE_SEQ();
        
             case 54 :
                 return  this.getCOMPANY_DIAG_BAS_DT2();
        
             case 55 :
                 return  this.getBUSS_YMD();
        
             case 56 :
                 return  this.getFOREIGN_YN();
        
             case 57 :
                 return  this.getREGIST_YMD();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_M_UNION_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 5 :
                    this.setDEFI_STE((String)value);
	            return;  
        
             case 6 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 7 :
                    this.setRECV_TIME((String)value);
	            return;  
        
             case 8 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 9 :
                    this.setPROC_TIME((String)value);
	            return;  
        
             case 10 :
                    this.setCOMMANA_CLASS((String)value);
	            return;  
        
             case 11 :
                    this.setMANA_NUM((String)value);
	            return;  
        
             case 12 :
                    this.setNAME((String)value);
	            return;  
        
             case 13 :
                    this.setREP_SSN1((String)value);
	            return;  
        
             case 14 :
                    this.setREP_SSN2((String)value);
	            return;  
        
             case 15 :
                    this.setREP_NM_KOR((String)value);
	            return;  
        
             case 16 :
                    this.setREP_NM_HAN((String)value);
	            return;  
        
             case 17 :
                    this.setREP_TEL_NUM((String)value);
	            return;  
        
             case 18 :
                    this.setADDR_POST_NUM((String)value);
	            return;  
        
             case 19 :
                    this.setADDR_ADDR((String)value);
	            return;  
        
             case 20 :
                    this.setADDR_DETAIL_ADDR((String)value);
	            return;  
        
             case 21 :
                    this.setADDR_TEL_NUM((String)value);
	            return;  
        
             case 22 :
                    this.setADDR_FAX_NUM((String)value);
	            return;  
        
             case 23 :
                    this.setEMAIL_ADDR((String)value);
	            return;  
        
             case 24 :
                    this.setOFFICE_AREA((String)value);
	            return;  
        
             case 25 :
                    this.setOFFICE_USE_CODE((String)value);
	            return;  
        
             case 26 :
                    this.setCOMPANY_DIAG_CLASS_CODE((String)value);
	            return;  
        
             case 27 :
                    this.setCOMPANY_DIAG_BAS_DT((String)value);
	            return;  
        
             case 28 :
                    this.setCOMPANY_DIAG_ISSUE_DT((String)value);
	            return;  
        
             case 29 :
                    this.setDIAG_ORG_CODE((String)value);
	            return;  
        
             case 30 :
                    this.setDIAG_NM_NM((String)value);
	            return;  
        
             case 31 :
                    this.setDIAG_NM_WRT_NUM((String)value);
	            return;  
        
             case 32 :
                    this.setPAY_CAP((String)value);
	            return;  
        
             case 33 :
                    this.setREA_CAP((String)value);
	            return;  
        
             case 34 :
                    this.setTUP_AOM((String)value);
	            return;  
        
             case 35 :
                    this.setTUP_CLASS_CODE((String)value);
	            return;  
        
             case 36 :
                    this.setCOM_COV_DT((String)value);
	            return;  
        
             case 37 :
                    this.setBAS_STA_DT((String)value);
	            return;  
        
             case 38 :
                    this.setOFFICE_OWN_CLASS((String)value);
	            return;  
        
             case 39 :
                    this.setREP_MOBILE((String)value);
	            return;  
        
             case 40 :
                    this.setLICTAX((String)value);
	            return;  
        
             case 41 :
                    this.setHOSCRE((String)value);
	            return;  
        
             case 42 :
                    this.setCOM_NUM((String)value);
	            return;  
        
             case 43 :
                    this.setGUBUN((String)value);
	            return;  
        
             case 44 :
                    this.setDOC_CODE((String)value);
	            return;  
        
             case 45 :
                    this.setOFFICE_USE_NAME((String)value);
	            return;  
        
             case 46 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 47 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 48 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 49 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 50 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 51 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 52 :
                    this.setCHG_DT((String)value);
	            return;  
        
             case 53 :
                    this.setCHGBRE_SEQ((String)value);
	            return;  
        
             case 54 :
                    this.setCOMPANY_DIAG_BAS_DT2((String)value);
	            return;  
        
             case 55 :
                    this.setBUSS_YMD((String)value);
	            return;  
        
             case 56 :
                    this.setFOREIGN_YN((String)value);
	            return;  
        
             case 57 :
                    this.setREGIST_YMD((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_M_UNION_STATEMENTHelper.toXML(this);
  }
  
}
