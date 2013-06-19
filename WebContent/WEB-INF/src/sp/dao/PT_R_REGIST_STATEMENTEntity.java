

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_REGIST_STATEMENT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               SIDO_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(12):  
*               SIDO_CODE:VARCHAR2(4):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_TIME:VARCHAR2(4):  
*               PROC_LIM:VARCHAR2(8):  
*               OFFI_PART:VARCHAR2(50):  
*               OFFI_PART_REBO_WRT_NUM:VARCHAR2(12):  
*               NAME:VARCHAR2(50):  
*               MANA_NUM:VARCHAR2(18):  
*               COM_NUM:VARCHAR2(18):  
*               REP_NM_KOR:VARCHAR2(20):  
*               REP_NM_HAN:VARCHAR2(20):  
*               ADDR_POST_NUM:VARCHAR2(6):  
*               ADDR_DETAIL_ADDR:VARCHAR2(200):  
*               ADDR_TEL_NUM:VARCHAR2(17):  
*               ADDR_FAX_NUM:VARCHAR2(17):  
*               DEFI_STE:VARCHAR2(1):  
*               WRT_ID:VARCHAR2(16):  
*               UPD_DT:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               ADDR_ADDR:VARCHAR2(100):  
*               PROC_TIME:VARCHAR2(6):  
*               REP_MOBILE:VARCHAR2(17):  
*               REP_MOBILE2:VARCHAR2(4):  
*               REP_MOBILE3:VARCHAR2(4):  
*               ADDR_TEL_NUM2:VARCHAR2(4):  
*               ADDR_TEL_NUM3:VARCHAR2(4):  
*               ADDR_FAX_NUM2:VARCHAR2(4):  
*               ADDR_FAX_NUM3:VARCHAR2(4):  
*               ADDR_TEL_NUM1:VARCHAR2(4):  
*               ADDR_FAX_NUM1:VARCHAR2(4):  
*               REP_MOBILE1:VARCHAR2(4):  
*               REP_SSN1:VARCHAR2(18):  
*               REP_SSN2:VARCHAR2(21):  
*               GUBUN:VARCHAR2(25):  
*               COI_WRT_NUM:VARCHAR2(12):  
*               MOT_STE:VARCHAR2(6):  
*               DOC_CODE:VARCHAR2(50):  
*               COMMANA_CLASS:VARCHAR2(3):  
*               OFFICE_AREA:VARCHAR2(10):  
*               DIAG_ORG_CODE:VARCHAR2(6):  
*               DIAG_NM_NM:VARCHAR2(20):  
*               COMPANY_DIAG_BAS_DT:VARCHAR2(8):  
*               PAY_CAP:VARCHAR2(15):  
*               DIAG_NM_WRT_NUM:VARCHAR2(12):  
*               COMPANY_DIAG_ISSUE_DT:VARCHAR2(24):  
*               REA_CAP:VARCHAR2(15):  
*               TUP_CLASS_CODE:VARCHAR2(6):  
*               TUP_AOM:VARCHAR2(15):  
*               OFFICE_USE_NAME:VARCHAR2(50):  
*               OFFICE_OWN_CLASS:VARCHAR2(1):  
*               LICTAX:VARCHAR2(1):  
*               HOSCRE:VARCHAR2(1):  
*               MEMO_CONT:VARCHAR2(256):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_DT:VARCHAR2(8):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN_YN:VARCHAR2(1):  
*               REGIST_YMD:VARCHAR2(8):  
*               STA_CHG_CLASS_CODE:VARCHAR2(6):  
*               CHG_DT:VARCHAR2(8):  
*               EXT_CHG_CLASS_CODE:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_REGIST_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String RECV_DT;
  
     private String RECV_TIME;
  
     private String PROC_LIM;
  
     private String OFFI_PART;
  
     private String OFFI_PART_REBO_WRT_NUM;
  
     private String NAME;
  
     private String MANA_NUM;
  
     private String COM_NUM;
  
     private String REP_NM_KOR;
  
     private String REP_NM_HAN;
  
     private String ADDR_POST_NUM;
  
     private String ADDR_DETAIL_ADDR;
  
     private String ADDR_TEL_NUM;
  
     private String ADDR_FAX_NUM;
  
     private String DEFI_STE;
  
     private String WRT_ID;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String ADDR_ADDR;
  
     private String PROC_TIME;
  
     private String REP_MOBILE;
  
     private String REP_MOBILE2;
  
     private String REP_MOBILE3;
  
     private String ADDR_TEL_NUM2;
  
     private String ADDR_TEL_NUM3;
  
     private String ADDR_FAX_NUM2;
  
     private String ADDR_FAX_NUM3;
  
     private String ADDR_TEL_NUM1;
  
     private String ADDR_FAX_NUM1;
  
     private String REP_MOBILE1;
  
     private String REP_SSN1;
  
     private String REP_SSN2;
  
     private String GUBUN;
  
     private String COI_WRT_NUM;
  
     private String MOT_STE;
  
     private String DOC_CODE;
  
     private String COMMANA_CLASS;
  
     private String OFFICE_AREA;
  
     private String DIAG_ORG_CODE;
  
     private String DIAG_NM_NM;
  
     private String COMPANY_DIAG_BAS_DT;
  
     private String PAY_CAP;
  
     private String DIAG_NM_WRT_NUM;
  
     private String COMPANY_DIAG_ISSUE_DT;
  
     private String REA_CAP;
  
     private String TUP_CLASS_CODE;
  
     private String TUP_AOM;
  
     private String OFFICE_USE_NAME;
  
     private String OFFICE_OWN_CLASS;
  
     private String LICTAX;
  
     private String HOSCRE;
  
     private String MEMO_CONT;
  
     private String TMP_WRT_NUM;
  
     private String WRT_DT;
  
     private String BUSS_YMD;
  
     private String FOREIGN_YN;
  
     private String REGIST_YMD;
  
     private String STA_CHG_CLASS_CODE;
  
     private String CHG_DT;
  
     private String EXT_CHG_CLASS_CODE;
  

//생성자를 만든다
    public PT_R_REGIST_STATEMENTEntity(){
    }
    
    
    public PT_R_REGIST_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_REGIST_STATEMENTEntity(ValueObject ent) throws Exception{
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
		this.RECV_DT =request.getParameter("RECV_DT");
		this.RECV_TIME =request.getParameter("RECV_TIME");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.OFFI_PART =request.getParameter("OFFI_PART");
		this.OFFI_PART_REBO_WRT_NUM =request.getParameter("OFFI_PART_REBO_WRT_NUM");
		this.NAME =request.getParameter("NAME");
		this.MANA_NUM =request.getParameter("MANA_NUM");
		this.COM_NUM =request.getParameter("COM_NUM");
		this.REP_NM_KOR =request.getParameter("REP_NM_KOR");
		this.REP_NM_HAN =request.getParameter("REP_NM_HAN");
		this.ADDR_POST_NUM =request.getParameter("ADDR_POST_NUM");
		this.ADDR_DETAIL_ADDR =request.getParameter("ADDR_DETAIL_ADDR");
		this.ADDR_TEL_NUM =request.getParameter("ADDR_TEL_NUM");
		this.ADDR_FAX_NUM =request.getParameter("ADDR_FAX_NUM");
		this.DEFI_STE =request.getParameter("DEFI_STE");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.ADDR_ADDR =request.getParameter("ADDR_ADDR");
		this.PROC_TIME =request.getParameter("PROC_TIME");
		this.REP_MOBILE =request.getParameter("REP_MOBILE");
		this.REP_MOBILE2 =request.getParameter("REP_MOBILE2");
		this.REP_MOBILE3 =request.getParameter("REP_MOBILE3");
		this.ADDR_TEL_NUM2 =request.getParameter("ADDR_TEL_NUM2");
		this.ADDR_TEL_NUM3 =request.getParameter("ADDR_TEL_NUM3");
		this.ADDR_FAX_NUM2 =request.getParameter("ADDR_FAX_NUM2");
		this.ADDR_FAX_NUM3 =request.getParameter("ADDR_FAX_NUM3");
		this.ADDR_TEL_NUM1 =request.getParameter("ADDR_TEL_NUM1");
		this.ADDR_FAX_NUM1 =request.getParameter("ADDR_FAX_NUM1");
		this.REP_MOBILE1 =request.getParameter("REP_MOBILE1");
		this.REP_SSN1 =request.getParameter("REP_SSN1");
		this.REP_SSN2 =request.getParameter("REP_SSN2");
		this.GUBUN =request.getParameter("GUBUN");
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		this.MOT_STE =request.getParameter("MOT_STE");
		this.DOC_CODE =request.getParameter("DOC_CODE");
		this.COMMANA_CLASS =request.getParameter("COMMANA_CLASS");
		this.OFFICE_AREA =request.getParameter("OFFICE_AREA");
		this.DIAG_ORG_CODE =request.getParameter("DIAG_ORG_CODE");
		this.DIAG_NM_NM =request.getParameter("DIAG_NM_NM");
		this.COMPANY_DIAG_BAS_DT =request.getParameter("COMPANY_DIAG_BAS_DT");
		this.PAY_CAP =request.getParameter("PAY_CAP");
		this.DIAG_NM_WRT_NUM =request.getParameter("DIAG_NM_WRT_NUM");
		this.COMPANY_DIAG_ISSUE_DT =request.getParameter("COMPANY_DIAG_ISSUE_DT");
		this.REA_CAP =request.getParameter("REA_CAP");
		this.TUP_CLASS_CODE =request.getParameter("TUP_CLASS_CODE");
		this.TUP_AOM =request.getParameter("TUP_AOM");
		this.OFFICE_USE_NAME =request.getParameter("OFFICE_USE_NAME");
		this.OFFICE_OWN_CLASS =request.getParameter("OFFICE_OWN_CLASS");
		this.LICTAX =request.getParameter("LICTAX");
		this.HOSCRE =request.getParameter("HOSCRE");
		this.MEMO_CONT =request.getParameter("MEMO_CONT");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_DT =request.getParameter("WRT_DT");
		this.BUSS_YMD =request.getParameter("BUSS_YMD");
		this.FOREIGN_YN =request.getParameter("FOREIGN_YN");
		this.REGIST_YMD =request.getParameter("REGIST_YMD");
		this.STA_CHG_CLASS_CODE =request.getParameter("STA_CHG_CLASS_CODE");
		this.CHG_DT =request.getParameter("CHG_DT");
		this.EXT_CHG_CLASS_CODE =request.getParameter("EXT_CHG_CLASS_CODE");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.RECV_TIME =KJFMi.dsGet(ds, arg_row, "RECV_TIME");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.OFFI_PART =KJFMi.dsGet(ds, arg_row, "OFFI_PART");
		this.OFFI_PART_REBO_WRT_NUM =KJFMi.dsGet(ds, arg_row, "OFFI_PART_REBO_WRT_NUM");
		this.NAME =KJFMi.dsGet(ds, arg_row, "NAME");
		this.MANA_NUM =KJFMi.dsGet(ds, arg_row, "MANA_NUM");
		this.COM_NUM =KJFMi.dsGet(ds, arg_row, "COM_NUM");
		this.REP_NM_KOR =KJFMi.dsGet(ds, arg_row, "REP_NM_KOR");
		this.REP_NM_HAN =KJFMi.dsGet(ds, arg_row, "REP_NM_HAN");
		this.ADDR_POST_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_POST_NUM");
		this.ADDR_DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "ADDR_DETAIL_ADDR");
		this.ADDR_TEL_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_TEL_NUM");
		this.ADDR_FAX_NUM =KJFMi.dsGet(ds, arg_row, "ADDR_FAX_NUM");
		this.DEFI_STE =KJFMi.dsGet(ds, arg_row, "DEFI_STE");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.ADDR_ADDR =KJFMi.dsGet(ds, arg_row, "ADDR_ADDR");
		this.PROC_TIME =KJFMi.dsGet(ds, arg_row, "PROC_TIME");
		this.REP_MOBILE =KJFMi.dsGet(ds, arg_row, "REP_MOBILE");
		this.REP_MOBILE2 =KJFMi.dsGet(ds, arg_row, "REP_MOBILE2");
		this.REP_MOBILE3 =KJFMi.dsGet(ds, arg_row, "REP_MOBILE3");
		this.ADDR_TEL_NUM2 =KJFMi.dsGet(ds, arg_row, "ADDR_TEL_NUM2");
		this.ADDR_TEL_NUM3 =KJFMi.dsGet(ds, arg_row, "ADDR_TEL_NUM3");
		this.ADDR_FAX_NUM2 =KJFMi.dsGet(ds, arg_row, "ADDR_FAX_NUM2");
		this.ADDR_FAX_NUM3 =KJFMi.dsGet(ds, arg_row, "ADDR_FAX_NUM3");
		this.ADDR_TEL_NUM1 =KJFMi.dsGet(ds, arg_row, "ADDR_TEL_NUM1");
		this.ADDR_FAX_NUM1 =KJFMi.dsGet(ds, arg_row, "ADDR_FAX_NUM1");
		this.REP_MOBILE1 =KJFMi.dsGet(ds, arg_row, "REP_MOBILE1");
		this.REP_SSN1 =KJFMi.dsGet(ds, arg_row, "REP_SSN1");
		this.REP_SSN2 =KJFMi.dsGet(ds, arg_row, "REP_SSN2");
		this.GUBUN =KJFMi.dsGet(ds, arg_row, "GUBUN");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		this.MOT_STE =KJFMi.dsGet(ds, arg_row, "MOT_STE");
		this.DOC_CODE =KJFMi.dsGet(ds, arg_row, "DOC_CODE");
		this.COMMANA_CLASS =KJFMi.dsGet(ds, arg_row, "COMMANA_CLASS");
		this.OFFICE_AREA =KJFMi.dsGet(ds, arg_row, "OFFICE_AREA");
		this.DIAG_ORG_CODE =KJFMi.dsGet(ds, arg_row, "DIAG_ORG_CODE");
		this.DIAG_NM_NM =KJFMi.dsGet(ds, arg_row, "DIAG_NM_NM");
		this.COMPANY_DIAG_BAS_DT =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_BAS_DT");
		this.PAY_CAP =KJFMi.dsGet(ds, arg_row, "PAY_CAP");
		this.DIAG_NM_WRT_NUM =KJFMi.dsGet(ds, arg_row, "DIAG_NM_WRT_NUM");
		this.COMPANY_DIAG_ISSUE_DT =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_ISSUE_DT");
		this.REA_CAP =KJFMi.dsGet(ds, arg_row, "REA_CAP");
		this.TUP_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "TUP_CLASS_CODE");
		this.TUP_AOM =KJFMi.dsGet(ds, arg_row, "TUP_AOM");
		this.OFFICE_USE_NAME =KJFMi.dsGet(ds, arg_row, "OFFICE_USE_NAME");
		this.OFFICE_OWN_CLASS =KJFMi.dsGet(ds, arg_row, "OFFICE_OWN_CLASS");
		this.LICTAX =KJFMi.dsGet(ds, arg_row, "LICTAX");
		this.HOSCRE =KJFMi.dsGet(ds, arg_row, "HOSCRE");
		this.MEMO_CONT =KJFMi.dsGet(ds, arg_row, "MEMO_CONT");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_DT =KJFMi.dsGet(ds, arg_row, "WRT_DT");
		this.BUSS_YMD =KJFMi.dsGet(ds, arg_row, "BUSS_YMD");
		this.FOREIGN_YN =KJFMi.dsGet(ds, arg_row, "FOREIGN_YN");
		this.REGIST_YMD =KJFMi.dsGet(ds, arg_row, "REGIST_YMD");
		this.STA_CHG_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "STA_CHG_CLASS_CODE");
		this.CHG_DT =KJFMi.dsGet(ds, arg_row, "CHG_DT");
		this.EXT_CHG_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "EXT_CHG_CLASS_CODE");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
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
  
     public String getOFFI_PART(){
             return OFFI_PART;
     };
  
     public String getOFFI_PART_REBO_WRT_NUM(){
             return OFFI_PART_REBO_WRT_NUM;
     };
  
     public String getNAME(){
             return NAME;
     };
  
     public String getMANA_NUM(){
             return MANA_NUM;
     };
  
     public String getCOM_NUM(){
             return COM_NUM;
     };
  
     public String getREP_NM_KOR(){
             return REP_NM_KOR;
     };
  
     public String getREP_NM_HAN(){
             return REP_NM_HAN;
     };
  
     public String getADDR_POST_NUM(){
             return ADDR_POST_NUM;
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
  
     public String getDEFI_STE(){
             return DEFI_STE;
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
  
     public String getADDR_ADDR(){
             return ADDR_ADDR;
     };
  
     public String getPROC_TIME(){
             return PROC_TIME;
     };
  
     public String getREP_MOBILE(){
             return REP_MOBILE;
     };
  
     public String getREP_MOBILE2(){
             return REP_MOBILE2;
     };
  
     public String getREP_MOBILE3(){
             return REP_MOBILE3;
     };
  
     public String getADDR_TEL_NUM2(){
             return ADDR_TEL_NUM2;
     };
  
     public String getADDR_TEL_NUM3(){
             return ADDR_TEL_NUM3;
     };
  
     public String getADDR_FAX_NUM2(){
             return ADDR_FAX_NUM2;
     };
  
     public String getADDR_FAX_NUM3(){
             return ADDR_FAX_NUM3;
     };
  
     public String getADDR_TEL_NUM1(){
             return ADDR_TEL_NUM1;
     };
  
     public String getADDR_FAX_NUM1(){
             return ADDR_FAX_NUM1;
     };
  
     public String getREP_MOBILE1(){
             return REP_MOBILE1;
     };
  
     public String getREP_SSN1(){
             return REP_SSN1;
     };
  
     public String getREP_SSN2(){
             return REP_SSN2;
     };
  
     public String getGUBUN(){
             return GUBUN;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
     public String getMOT_STE(){
             return MOT_STE;
     };
  
     public String getDOC_CODE(){
             return DOC_CODE;
     };
  
     public String getCOMMANA_CLASS(){
             return COMMANA_CLASS;
     };
  
     public String getOFFICE_AREA(){
             return OFFICE_AREA;
     };
  
     public String getDIAG_ORG_CODE(){
             return DIAG_ORG_CODE;
     };
  
     public String getDIAG_NM_NM(){
             return DIAG_NM_NM;
     };
  
     public String getCOMPANY_DIAG_BAS_DT(){
             return COMPANY_DIAG_BAS_DT;
     };
  
     public String getPAY_CAP(){
             return PAY_CAP;
     };
  
     public String getDIAG_NM_WRT_NUM(){
             return DIAG_NM_WRT_NUM;
     };
  
     public String getCOMPANY_DIAG_ISSUE_DT(){
             return COMPANY_DIAG_ISSUE_DT;
     };
  
     public String getREA_CAP(){
             return REA_CAP;
     };
  
     public String getTUP_CLASS_CODE(){
             return TUP_CLASS_CODE;
     };
  
     public String getTUP_AOM(){
             return TUP_AOM;
     };
  
     public String getOFFICE_USE_NAME(){
             return OFFICE_USE_NAME;
     };
  
     public String getOFFICE_OWN_CLASS(){
             return OFFICE_OWN_CLASS;
     };
  
     public String getLICTAX(){
             return LICTAX;
     };
  
     public String getHOSCRE(){
             return HOSCRE;
     };
  
     public String getMEMO_CONT(){
             return MEMO_CONT;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_DT(){
             return WRT_DT;
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
  
     public String getSTA_CHG_CLASS_CODE(){
             return STA_CHG_CLASS_CODE;
     };
  
     public String getCHG_DT(){
             return CHG_DT;
     };
  
     public String getEXT_CHG_CLASS_CODE(){
             return EXT_CHG_CLASS_CODE;
     };
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
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
  
     public void setOFFI_PART(String OFFI_PART){
            this.OFFI_PART=OFFI_PART;
     };
  
     public void setOFFI_PART_REBO_WRT_NUM(String OFFI_PART_REBO_WRT_NUM){
            this.OFFI_PART_REBO_WRT_NUM=OFFI_PART_REBO_WRT_NUM;
     };
  
     public void setNAME(String NAME){
            this.NAME=NAME;
     };
  
     public void setMANA_NUM(String MANA_NUM){
            this.MANA_NUM=MANA_NUM;
     };
  
     public void setCOM_NUM(String COM_NUM){
            this.COM_NUM=COM_NUM;
     };
  
     public void setREP_NM_KOR(String REP_NM_KOR){
            this.REP_NM_KOR=REP_NM_KOR;
     };
  
     public void setREP_NM_HAN(String REP_NM_HAN){
            this.REP_NM_HAN=REP_NM_HAN;
     };
  
     public void setADDR_POST_NUM(String ADDR_POST_NUM){
            this.ADDR_POST_NUM=ADDR_POST_NUM;
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
  
     public void setDEFI_STE(String DEFI_STE){
            this.DEFI_STE=DEFI_STE;
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
  
     public void setADDR_ADDR(String ADDR_ADDR){
            this.ADDR_ADDR=ADDR_ADDR;
     };
  
     public void setPROC_TIME(String PROC_TIME){
            this.PROC_TIME=PROC_TIME;
     };
  
     public void setREP_MOBILE(String REP_MOBILE){
            this.REP_MOBILE=REP_MOBILE;
     };
  
     public void setREP_MOBILE2(String REP_MOBILE2){
            this.REP_MOBILE2=REP_MOBILE2;
     };
  
     public void setREP_MOBILE3(String REP_MOBILE3){
            this.REP_MOBILE3=REP_MOBILE3;
     };
  
     public void setADDR_TEL_NUM2(String ADDR_TEL_NUM2){
            this.ADDR_TEL_NUM2=ADDR_TEL_NUM2;
     };
  
     public void setADDR_TEL_NUM3(String ADDR_TEL_NUM3){
            this.ADDR_TEL_NUM3=ADDR_TEL_NUM3;
     };
  
     public void setADDR_FAX_NUM2(String ADDR_FAX_NUM2){
            this.ADDR_FAX_NUM2=ADDR_FAX_NUM2;
     };
  
     public void setADDR_FAX_NUM3(String ADDR_FAX_NUM3){
            this.ADDR_FAX_NUM3=ADDR_FAX_NUM3;
     };
  
     public void setADDR_TEL_NUM1(String ADDR_TEL_NUM1){
            this.ADDR_TEL_NUM1=ADDR_TEL_NUM1;
     };
  
     public void setADDR_FAX_NUM1(String ADDR_FAX_NUM1){
            this.ADDR_FAX_NUM1=ADDR_FAX_NUM1;
     };
  
     public void setREP_MOBILE1(String REP_MOBILE1){
            this.REP_MOBILE1=REP_MOBILE1;
     };
  
     public void setREP_SSN1(String REP_SSN1){
            this.REP_SSN1=REP_SSN1;
     };
  
     public void setREP_SSN2(String REP_SSN2){
            this.REP_SSN2=REP_SSN2;
     };
  
     public void setGUBUN(String GUBUN){
            this.GUBUN=GUBUN;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
     public void setMOT_STE(String MOT_STE){
            this.MOT_STE=MOT_STE;
     };
  
     public void setDOC_CODE(String DOC_CODE){
            this.DOC_CODE=DOC_CODE;
     };
  
     public void setCOMMANA_CLASS(String COMMANA_CLASS){
            this.COMMANA_CLASS=COMMANA_CLASS;
     };
  
     public void setOFFICE_AREA(String OFFICE_AREA){
            this.OFFICE_AREA=OFFICE_AREA;
     };
  
     public void setDIAG_ORG_CODE(String DIAG_ORG_CODE){
            this.DIAG_ORG_CODE=DIAG_ORG_CODE;
     };
  
     public void setDIAG_NM_NM(String DIAG_NM_NM){
            this.DIAG_NM_NM=DIAG_NM_NM;
     };
  
     public void setCOMPANY_DIAG_BAS_DT(String COMPANY_DIAG_BAS_DT){
            this.COMPANY_DIAG_BAS_DT=COMPANY_DIAG_BAS_DT;
     };
  
     public void setPAY_CAP(String PAY_CAP){
            this.PAY_CAP=PAY_CAP;
     };
  
     public void setDIAG_NM_WRT_NUM(String DIAG_NM_WRT_NUM){
            this.DIAG_NM_WRT_NUM=DIAG_NM_WRT_NUM;
     };
  
     public void setCOMPANY_DIAG_ISSUE_DT(String COMPANY_DIAG_ISSUE_DT){
            this.COMPANY_DIAG_ISSUE_DT=COMPANY_DIAG_ISSUE_DT;
     };
  
     public void setREA_CAP(String REA_CAP){
            this.REA_CAP=REA_CAP;
     };
  
     public void setTUP_CLASS_CODE(String TUP_CLASS_CODE){
            this.TUP_CLASS_CODE=TUP_CLASS_CODE;
     };
  
     public void setTUP_AOM(String TUP_AOM){
            this.TUP_AOM=TUP_AOM;
     };
  
     public void setOFFICE_USE_NAME(String OFFICE_USE_NAME){
            this.OFFICE_USE_NAME=OFFICE_USE_NAME;
     };
  
     public void setOFFICE_OWN_CLASS(String OFFICE_OWN_CLASS){
            this.OFFICE_OWN_CLASS=OFFICE_OWN_CLASS;
     };
  
     public void setLICTAX(String LICTAX){
            this.LICTAX=LICTAX;
     };
  
     public void setHOSCRE(String HOSCRE){
            this.HOSCRE=HOSCRE;
     };
  
     public void setMEMO_CONT(String MEMO_CONT){
            this.MEMO_CONT=MEMO_CONT;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_DT(String WRT_DT){
            this.WRT_DT=WRT_DT;
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
  
     public void setSTA_CHG_CLASS_CODE(String STA_CHG_CLASS_CODE){
            this.STA_CHG_CLASS_CODE=STA_CHG_CLASS_CODE;
     };
  
     public void setCHG_DT(String CHG_DT){
            this.CHG_DT=CHG_DT;
     };
  
     public void setEXT_CHG_CLASS_CODE(String EXT_CHG_CLASS_CODE){
            this.EXT_CHG_CLASS_CODE=EXT_CHG_CLASS_CODE;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("RECV_TIME:"+ this.getRECV_TIME()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("OFFI_PART:"+ this.getOFFI_PART()+"\n");
      
      strB.append("OFFI_PART_REBO_WRT_NUM:"+ this.getOFFI_PART_REBO_WRT_NUM()+"\n");
      
      strB.append("NAME:"+ this.getNAME()+"\n");
      
      strB.append("MANA_NUM:"+ this.getMANA_NUM()+"\n");
      
      strB.append("COM_NUM:"+ this.getCOM_NUM()+"\n");
      
      strB.append("REP_NM_KOR:"+ this.getREP_NM_KOR()+"\n");
      
      strB.append("REP_NM_HAN:"+ this.getREP_NM_HAN()+"\n");
      
      strB.append("ADDR_POST_NUM:"+ this.getADDR_POST_NUM()+"\n");
      
      strB.append("ADDR_DETAIL_ADDR:"+ this.getADDR_DETAIL_ADDR()+"\n");
      
      strB.append("ADDR_TEL_NUM:"+ this.getADDR_TEL_NUM()+"\n");
      
      strB.append("ADDR_FAX_NUM:"+ this.getADDR_FAX_NUM()+"\n");
      
      strB.append("DEFI_STE:"+ this.getDEFI_STE()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("ADDR_ADDR:"+ this.getADDR_ADDR()+"\n");
      
      strB.append("PROC_TIME:"+ this.getPROC_TIME()+"\n");
      
      strB.append("REP_MOBILE:"+ this.getREP_MOBILE()+"\n");
      
      strB.append("REP_MOBILE2:"+ this.getREP_MOBILE2()+"\n");
      
      strB.append("REP_MOBILE3:"+ this.getREP_MOBILE3()+"\n");
      
      strB.append("ADDR_TEL_NUM2:"+ this.getADDR_TEL_NUM2()+"\n");
      
      strB.append("ADDR_TEL_NUM3:"+ this.getADDR_TEL_NUM3()+"\n");
      
      strB.append("ADDR_FAX_NUM2:"+ this.getADDR_FAX_NUM2()+"\n");
      
      strB.append("ADDR_FAX_NUM3:"+ this.getADDR_FAX_NUM3()+"\n");
      
      strB.append("ADDR_TEL_NUM1:"+ this.getADDR_TEL_NUM1()+"\n");
      
      strB.append("ADDR_FAX_NUM1:"+ this.getADDR_FAX_NUM1()+"\n");
      
      strB.append("REP_MOBILE1:"+ this.getREP_MOBILE1()+"\n");
      
      strB.append("REP_SSN1:"+ this.getREP_SSN1()+"\n");
      
      strB.append("REP_SSN2:"+ this.getREP_SSN2()+"\n");
      
      strB.append("GUBUN:"+ this.getGUBUN()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
      strB.append("MOT_STE:"+ this.getMOT_STE()+"\n");
      
      strB.append("DOC_CODE:"+ this.getDOC_CODE()+"\n");
      
      strB.append("COMMANA_CLASS:"+ this.getCOMMANA_CLASS()+"\n");
      
      strB.append("OFFICE_AREA:"+ this.getOFFICE_AREA()+"\n");
      
      strB.append("DIAG_ORG_CODE:"+ this.getDIAG_ORG_CODE()+"\n");
      
      strB.append("DIAG_NM_NM:"+ this.getDIAG_NM_NM()+"\n");
      
      strB.append("COMPANY_DIAG_BAS_DT:"+ this.getCOMPANY_DIAG_BAS_DT()+"\n");
      
      strB.append("PAY_CAP:"+ this.getPAY_CAP()+"\n");
      
      strB.append("DIAG_NM_WRT_NUM:"+ this.getDIAG_NM_WRT_NUM()+"\n");
      
      strB.append("COMPANY_DIAG_ISSUE_DT:"+ this.getCOMPANY_DIAG_ISSUE_DT()+"\n");
      
      strB.append("REA_CAP:"+ this.getREA_CAP()+"\n");
      
      strB.append("TUP_CLASS_CODE:"+ this.getTUP_CLASS_CODE()+"\n");
      
      strB.append("TUP_AOM:"+ this.getTUP_AOM()+"\n");
      
      strB.append("OFFICE_USE_NAME:"+ this.getOFFICE_USE_NAME()+"\n");
      
      strB.append("OFFICE_OWN_CLASS:"+ this.getOFFICE_OWN_CLASS()+"\n");
      
      strB.append("LICTAX:"+ this.getLICTAX()+"\n");
      
      strB.append("HOSCRE:"+ this.getHOSCRE()+"\n");
      
      strB.append("MEMO_CONT:"+ this.getMEMO_CONT()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_DT:"+ this.getWRT_DT()+"\n");
      
      strB.append("BUSS_YMD:"+ this.getBUSS_YMD()+"\n");
      
      strB.append("FOREIGN_YN:"+ this.getFOREIGN_YN()+"\n");
      
      strB.append("REGIST_YMD:"+ this.getREGIST_YMD()+"\n");
      
      strB.append("STA_CHG_CLASS_CODE:"+ this.getSTA_CHG_CLASS_CODE()+"\n");
      
      strB.append("CHG_DT:"+ this.getCHG_DT()+"\n");
      
      strB.append("EXT_CHG_CLASS_CODE:"+ this.getEXT_CHG_CLASS_CODE()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_REGIST_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_REGIST_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_REGIST_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_REGIST_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_REGIST_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_REGIST_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_REGIST_STATEMENTEntity newEnt = new PT_R_REGIST_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setRECV_TIME(this.getRECV_TIME());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setOFFI_PART(this.getOFFI_PART());
         
          newEnt.setOFFI_PART_REBO_WRT_NUM(this.getOFFI_PART_REBO_WRT_NUM());
         
          newEnt.setNAME(this.getNAME());
         
          newEnt.setMANA_NUM(this.getMANA_NUM());
         
          newEnt.setCOM_NUM(this.getCOM_NUM());
         
          newEnt.setREP_NM_KOR(this.getREP_NM_KOR());
         
          newEnt.setREP_NM_HAN(this.getREP_NM_HAN());
         
          newEnt.setADDR_POST_NUM(this.getADDR_POST_NUM());
         
          newEnt.setADDR_DETAIL_ADDR(this.getADDR_DETAIL_ADDR());
         
          newEnt.setADDR_TEL_NUM(this.getADDR_TEL_NUM());
         
          newEnt.setADDR_FAX_NUM(this.getADDR_FAX_NUM());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setADDR_ADDR(this.getADDR_ADDR());
         
          newEnt.setPROC_TIME(this.getPROC_TIME());
         
          newEnt.setREP_MOBILE(this.getREP_MOBILE());
         
          newEnt.setREP_MOBILE2(this.getREP_MOBILE2());
         
          newEnt.setREP_MOBILE3(this.getREP_MOBILE3());
         
          newEnt.setADDR_TEL_NUM2(this.getADDR_TEL_NUM2());
         
          newEnt.setADDR_TEL_NUM3(this.getADDR_TEL_NUM3());
         
          newEnt.setADDR_FAX_NUM2(this.getADDR_FAX_NUM2());
         
          newEnt.setADDR_FAX_NUM3(this.getADDR_FAX_NUM3());
         
          newEnt.setADDR_TEL_NUM1(this.getADDR_TEL_NUM1());
         
          newEnt.setADDR_FAX_NUM1(this.getADDR_FAX_NUM1());
         
          newEnt.setREP_MOBILE1(this.getREP_MOBILE1());
         
          newEnt.setREP_SSN1(this.getREP_SSN1());
         
          newEnt.setREP_SSN2(this.getREP_SSN2());
         
          newEnt.setGUBUN(this.getGUBUN());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setDOC_CODE(this.getDOC_CODE());
         
          newEnt.setCOMMANA_CLASS(this.getCOMMANA_CLASS());
         
          newEnt.setOFFICE_AREA(this.getOFFICE_AREA());
         
          newEnt.setDIAG_ORG_CODE(this.getDIAG_ORG_CODE());
         
          newEnt.setDIAG_NM_NM(this.getDIAG_NM_NM());
         
          newEnt.setCOMPANY_DIAG_BAS_DT(this.getCOMPANY_DIAG_BAS_DT());
         
          newEnt.setPAY_CAP(this.getPAY_CAP());
         
          newEnt.setDIAG_NM_WRT_NUM(this.getDIAG_NM_WRT_NUM());
         
          newEnt.setCOMPANY_DIAG_ISSUE_DT(this.getCOMPANY_DIAG_ISSUE_DT());
         
          newEnt.setREA_CAP(this.getREA_CAP());
         
          newEnt.setTUP_CLASS_CODE(this.getTUP_CLASS_CODE());
         
          newEnt.setTUP_AOM(this.getTUP_AOM());
         
          newEnt.setOFFICE_USE_NAME(this.getOFFICE_USE_NAME());
         
          newEnt.setOFFICE_OWN_CLASS(this.getOFFICE_OWN_CLASS());
         
          newEnt.setLICTAX(this.getLICTAX());
         
          newEnt.setHOSCRE(this.getHOSCRE());
         
          newEnt.setMEMO_CONT(this.getMEMO_CONT());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_DT(this.getWRT_DT());
         
          newEnt.setBUSS_YMD(this.getBUSS_YMD());
         
          newEnt.setFOREIGN_YN(this.getFOREIGN_YN());
         
          newEnt.setREGIST_YMD(this.getREGIST_YMD());
         
          newEnt.setSTA_CHG_CLASS_CODE(this.getSTA_CHG_CLASS_CODE());
         
          newEnt.setCHG_DT(this.getCHG_DT());
         
          newEnt.setEXT_CHG_CLASS_CODE(this.getEXT_CHG_CLASS_CODE());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_REGIST_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSIDO_CODE();
        
             case 3 :
                 return  this.getRECV_DT();
        
             case 4 :
                 return  this.getRECV_TIME();
        
             case 5 :
                 return  this.getPROC_LIM();
        
             case 6 :
                 return  this.getOFFI_PART();
        
             case 7 :
                 return  this.getOFFI_PART_REBO_WRT_NUM();
        
             case 8 :
                 return  this.getNAME();
        
             case 9 :
                 return  this.getMANA_NUM();
        
             case 10 :
                 return  this.getCOM_NUM();
        
             case 11 :
                 return  this.getREP_NM_KOR();
        
             case 12 :
                 return  this.getREP_NM_HAN();
        
             case 13 :
                 return  this.getADDR_POST_NUM();
        
             case 14 :
                 return  this.getADDR_DETAIL_ADDR();
        
             case 15 :
                 return  this.getADDR_TEL_NUM();
        
             case 16 :
                 return  this.getADDR_FAX_NUM();
        
             case 17 :
                 return  this.getDEFI_STE();
        
             case 18 :
                 return  this.getWRT_ID();
        
             case 19 :
                 return  this.getUPD_DT();
        
             case 20 :
                 return  this.getINS_DT();
        
             case 21 :
                 return  this.getADDR_ADDR();
        
             case 22 :
                 return  this.getPROC_TIME();
        
             case 23 :
                 return  this.getREP_MOBILE();
        
             case 24 :
                 return  this.getREP_MOBILE2();
        
             case 25 :
                 return  this.getREP_MOBILE3();
        
             case 26 :
                 return  this.getADDR_TEL_NUM2();
        
             case 27 :
                 return  this.getADDR_TEL_NUM3();
        
             case 28 :
                 return  this.getADDR_FAX_NUM2();
        
             case 29 :
                 return  this.getADDR_FAX_NUM3();
        
             case 30 :
                 return  this.getADDR_TEL_NUM1();
        
             case 31 :
                 return  this.getADDR_FAX_NUM1();
        
             case 32 :
                 return  this.getREP_MOBILE1();
        
             case 33 :
                 return  this.getREP_SSN1();
        
             case 34 :
                 return  this.getREP_SSN2();
        
             case 35 :
                 return  this.getGUBUN();
        
             case 36 :
                 return  this.getCOI_WRT_NUM();
        
             case 37 :
                 return  this.getMOT_STE();
        
             case 38 :
                 return  this.getDOC_CODE();
        
             case 39 :
                 return  this.getCOMMANA_CLASS();
        
             case 40 :
                 return  this.getOFFICE_AREA();
        
             case 41 :
                 return  this.getDIAG_ORG_CODE();
        
             case 42 :
                 return  this.getDIAG_NM_NM();
        
             case 43 :
                 return  this.getCOMPANY_DIAG_BAS_DT();
        
             case 44 :
                 return  this.getPAY_CAP();
        
             case 45 :
                 return  this.getDIAG_NM_WRT_NUM();
        
             case 46 :
                 return  this.getCOMPANY_DIAG_ISSUE_DT();
        
             case 47 :
                 return  this.getREA_CAP();
        
             case 48 :
                 return  this.getTUP_CLASS_CODE();
        
             case 49 :
                 return  this.getTUP_AOM();
        
             case 50 :
                 return  this.getOFFICE_USE_NAME();
        
             case 51 :
                 return  this.getOFFICE_OWN_CLASS();
        
             case 52 :
                 return  this.getLICTAX();
        
             case 53 :
                 return  this.getHOSCRE();
        
             case 54 :
                 return  this.getMEMO_CONT();
        
             case 55 :
                 return  this.getTMP_WRT_NUM();
        
             case 56 :
                 return  this.getWRT_DT();
        
             case 57 :
                 return  this.getBUSS_YMD();
        
             case 58 :
                 return  this.getFOREIGN_YN();
        
             case 59 :
                 return  this.getREGIST_YMD();
        
             case 60 :
                 return  this.getSTA_CHG_CLASS_CODE();
        
             case 61 :
                 return  this.getCHG_DT();
        
             case 62 :
                 return  this.getEXT_CHG_CLASS_CODE();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_REGIST_STATEMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 4 :
                    this.setRECV_TIME((String)value);
	            return;  
        
             case 5 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 6 :
                    this.setOFFI_PART((String)value);
	            return;  
        
             case 7 :
                    this.setOFFI_PART_REBO_WRT_NUM((String)value);
	            return;  
        
             case 8 :
                    this.setNAME((String)value);
	            return;  
        
             case 9 :
                    this.setMANA_NUM((String)value);
	            return;  
        
             case 10 :
                    this.setCOM_NUM((String)value);
	            return;  
        
             case 11 :
                    this.setREP_NM_KOR((String)value);
	            return;  
        
             case 12 :
                    this.setREP_NM_HAN((String)value);
	            return;  
        
             case 13 :
                    this.setADDR_POST_NUM((String)value);
	            return;  
        
             case 14 :
                    this.setADDR_DETAIL_ADDR((String)value);
	            return;  
        
             case 15 :
                    this.setADDR_TEL_NUM((String)value);
	            return;  
        
             case 16 :
                    this.setADDR_FAX_NUM((String)value);
	            return;  
        
             case 17 :
                    this.setDEFI_STE((String)value);
	            return;  
        
             case 18 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 19 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 20 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 21 :
                    this.setADDR_ADDR((String)value);
	            return;  
        
             case 22 :
                    this.setPROC_TIME((String)value);
	            return;  
        
             case 23 :
                    this.setREP_MOBILE((String)value);
	            return;  
        
             case 24 :
                    this.setREP_MOBILE2((String)value);
	            return;  
        
             case 25 :
                    this.setREP_MOBILE3((String)value);
	            return;  
        
             case 26 :
                    this.setADDR_TEL_NUM2((String)value);
	            return;  
        
             case 27 :
                    this.setADDR_TEL_NUM3((String)value);
	            return;  
        
             case 28 :
                    this.setADDR_FAX_NUM2((String)value);
	            return;  
        
             case 29 :
                    this.setADDR_FAX_NUM3((String)value);
	            return;  
        
             case 30 :
                    this.setADDR_TEL_NUM1((String)value);
	            return;  
        
             case 31 :
                    this.setADDR_FAX_NUM1((String)value);
	            return;  
        
             case 32 :
                    this.setREP_MOBILE1((String)value);
	            return;  
        
             case 33 :
                    this.setREP_SSN1((String)value);
	            return;  
        
             case 34 :
                    this.setREP_SSN2((String)value);
	            return;  
        
             case 35 :
                    this.setGUBUN((String)value);
	            return;  
        
             case 36 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
             case 37 :
                    this.setMOT_STE((String)value);
	            return;  
        
             case 38 :
                    this.setDOC_CODE((String)value);
	            return;  
        
             case 39 :
                    this.setCOMMANA_CLASS((String)value);
	            return;  
        
             case 40 :
                    this.setOFFICE_AREA((String)value);
	            return;  
        
             case 41 :
                    this.setDIAG_ORG_CODE((String)value);
	            return;  
        
             case 42 :
                    this.setDIAG_NM_NM((String)value);
	            return;  
        
             case 43 :
                    this.setCOMPANY_DIAG_BAS_DT((String)value);
	            return;  
        
             case 44 :
                    this.setPAY_CAP((String)value);
	            return;  
        
             case 45 :
                    this.setDIAG_NM_WRT_NUM((String)value);
	            return;  
        
             case 46 :
                    this.setCOMPANY_DIAG_ISSUE_DT((String)value);
	            return;  
        
             case 47 :
                    this.setREA_CAP((String)value);
	            return;  
        
             case 48 :
                    this.setTUP_CLASS_CODE((String)value);
	            return;  
        
             case 49 :
                    this.setTUP_AOM((String)value);
	            return;  
        
             case 50 :
                    this.setOFFICE_USE_NAME((String)value);
	            return;  
        
             case 51 :
                    this.setOFFICE_OWN_CLASS((String)value);
	            return;  
        
             case 52 :
                    this.setLICTAX((String)value);
	            return;  
        
             case 53 :
                    this.setHOSCRE((String)value);
	            return;  
        
             case 54 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 55 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 56 :
                    this.setWRT_DT((String)value);
	            return;  
        
             case 57 :
                    this.setBUSS_YMD((String)value);
	            return;  
        
             case 58 :
                    this.setFOREIGN_YN((String)value);
	            return;  
        
             case 59 :
                    this.setREGIST_YMD((String)value);
	            return;  
        
             case 60 :
                    this.setSTA_CHG_CLASS_CODE((String)value);
	            return;  
        
             case 61 :
                    this.setCHG_DT((String)value);
	            return;  
        
             case 62 :
                    this.setEXT_CHG_CLASS_CODE((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_REGIST_STATEMENTHelper.toXML(this);
  }
  
}
