

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_ASSI_TRANS_STATEMENT
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
*               CHG_DT:VARCHAR2(24):  
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
*               MEMO_CONT:VARCHAR2(256):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               ASSI_TMP_WRT_NUM:VARCHAR2(12):  
*               ASSI_COI_WRT_NUM:VARCHAR2(6):  
*               ASSI_COMMANA_CLASS:VARCHAR2(4):  
*               ASSI_MANA_NUM:VARCHAR2(18):  
*               ASSI_STE:VARCHAR2(1):  
*               ASSI_NAME:VARCHAR2(50):  
*               ASSI_TELNUM:VARCHAR2(17):  
*               ASSI_REP:VARCHAR2(20):  
*               ASSI_COMNUM:VARCHAR2(13):  
*               ASSI_ADDR:VARCHAR2(120):  
*               ASSI_POST_NUM:VARCHAR2(120):  
*               ASSI_DETAIL_ADDR:VARCHAR2(120):  
*               ASSI_GUBUN:VARCHAR2(1):  
*               ASSI_WRT_DT:VARCHAR2(24):  
*               ASSI_CHGBRE_SEQ:VARCHAR2(4):  
*               TRAN_TMP_WRT_NUM:VARCHAR2(12):  
*               TRAN_COI_WRT_NUM:VARCHAR2(6):  
*               TRAN_COMMANA_CLASS:VARCHAR2(4):  
*               TRAN_MANA_NUM:VARCHAR2(18):  
*               TRAN_NAME:VARCHAR2(50):  
*               TRAN_TELNUM:VARCHAR2(17):  
*               TRAN_REP:VARCHAR2(20):  
*               TRAN_COMNUM:VARCHAR2(13):  
*               TRAN_ADDR:VARCHAR2(120):  
*               TRAN_POST_NUM:VARCHAR2(6):  
*               TRAN_DETAIL_ADDR:VARCHAR2(120):  
*               TRAN_GUBUN:VARCHAR2(1):  
*               TRAN_WRT_DT:VARCHAR2(24):  
*               TRAN_CHGBRE_SEQ:VARCHAR2(4):  
*               COMPANY_DIAG_BAS_DT2:VARCHAR2(4):  
*               BUSS_YMD:VARCHAR2(8):  
*               FOREIGN_YN:VARCHAR2(1):  
*               REGIST_YMD:VARCHAR2(8):  
*               ASSI_BUSS_YMD:VARCHAR2(8):  
*               ASSI_FOREIGN_YN:VARCHAR2(1):  
*               ASSI_REGIST_YMD:VARCHAR2(8):  
*               TRAN_BUSS_YMD:VARCHAR2(8):  
*               TRAN_FOREIGN_YN:VARCHAR2(1):  
*               TRAN_REGIST_YMD:VARCHAR2(8):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_ASSI_TRANS_STATEMENTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SIDO_CODE;
  
     private String COI_WRT_NUM;
  
     private String MOT_STE;
  
     private String DEFI_STE;
  
     private String RECV_DT;
  
     private String RECV_TIME;
  
     private String PROC_LIM;
  
     private String PROC_TIME;
  
     private String CHG_DT;
  
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
  
     private String ASSI_TMP_WRT_NUM;
  
     private String ASSI_COI_WRT_NUM;
  
     private String ASSI_COMMANA_CLASS;
  
     private String ASSI_MANA_NUM;
  
     private String ASSI_STE;
  
     private String ASSI_NAME;
  
     private String ASSI_TELNUM;
  
     private String ASSI_REP;
  
     private String ASSI_COMNUM;
  
     private String ASSI_ADDR;
  
     private String ASSI_POST_NUM;
  
     private String ASSI_DETAIL_ADDR;
  
     private String ASSI_GUBUN;
  
     private String ASSI_WRT_DT;
  
     private String ASSI_CHGBRE_SEQ;
  
     private String TRAN_TMP_WRT_NUM;
  
     private String TRAN_COI_WRT_NUM;
  
     private String TRAN_COMMANA_CLASS;
  
     private String TRAN_MANA_NUM;
  
     private String TRAN_NAME;
  
     private String TRAN_TELNUM;
  
     private String TRAN_REP;
  
     private String TRAN_COMNUM;
  
     private String TRAN_ADDR;
  
     private String TRAN_POST_NUM;
  
     private String TRAN_DETAIL_ADDR;
  
     private String TRAN_GUBUN;
  
     private String TRAN_WRT_DT;
  
     private String TRAN_CHGBRE_SEQ;
  
     private String COMPANY_DIAG_BAS_DT2;
  
     private String BUSS_YMD;
  
     private String FOREIGN_YN;
  
     private String REGIST_YMD;
  
     private String ASSI_BUSS_YMD;
  
     private String ASSI_FOREIGN_YN;
  
     private String ASSI_REGIST_YMD;
  
     private String TRAN_BUSS_YMD;
  
     private String TRAN_FOREIGN_YN;
  
     private String TRAN_REGIST_YMD;
  

//생성자를 만든다
    public PT_R_ASSI_TRANS_STATEMENTEntity(){
    }
    
    
    public PT_R_ASSI_TRANS_STATEMENTEntity(String RECV_NUM,String SIDO_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       
    }
      
    public PT_R_ASSI_TRANS_STATEMENTEntity(ValueObject ent) throws Exception{
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
		this.CHG_DT =request.getParameter("CHG_DT");
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
		this.ASSI_TMP_WRT_NUM =request.getParameter("ASSI_TMP_WRT_NUM");
		this.ASSI_COI_WRT_NUM =request.getParameter("ASSI_COI_WRT_NUM");
		this.ASSI_COMMANA_CLASS =request.getParameter("ASSI_COMMANA_CLASS");
		this.ASSI_MANA_NUM =request.getParameter("ASSI_MANA_NUM");
		this.ASSI_STE =request.getParameter("ASSI_STE");
		this.ASSI_NAME =request.getParameter("ASSI_NAME");
		this.ASSI_TELNUM =request.getParameter("ASSI_TELNUM");
		this.ASSI_REP =request.getParameter("ASSI_REP");
		this.ASSI_COMNUM =request.getParameter("ASSI_COMNUM");
		this.ASSI_ADDR =request.getParameter("ASSI_ADDR");
		this.ASSI_POST_NUM =request.getParameter("ASSI_POST_NUM");
		this.ASSI_DETAIL_ADDR =request.getParameter("ASSI_DETAIL_ADDR");
		this.ASSI_GUBUN =request.getParameter("ASSI_GUBUN");
		this.ASSI_WRT_DT =request.getParameter("ASSI_WRT_DT");
		this.ASSI_CHGBRE_SEQ =request.getParameter("ASSI_CHGBRE_SEQ");
		this.TRAN_TMP_WRT_NUM =request.getParameter("TRAN_TMP_WRT_NUM");
		this.TRAN_COI_WRT_NUM =request.getParameter("TRAN_COI_WRT_NUM");
		this.TRAN_COMMANA_CLASS =request.getParameter("TRAN_COMMANA_CLASS");
		this.TRAN_MANA_NUM =request.getParameter("TRAN_MANA_NUM");
		this.TRAN_NAME =request.getParameter("TRAN_NAME");
		this.TRAN_TELNUM =request.getParameter("TRAN_TELNUM");
		this.TRAN_REP =request.getParameter("TRAN_REP");
		this.TRAN_COMNUM =request.getParameter("TRAN_COMNUM");
		this.TRAN_ADDR =request.getParameter("TRAN_ADDR");
		this.TRAN_POST_NUM =request.getParameter("TRAN_POST_NUM");
		this.TRAN_DETAIL_ADDR =request.getParameter("TRAN_DETAIL_ADDR");
		this.TRAN_GUBUN =request.getParameter("TRAN_GUBUN");
		this.TRAN_WRT_DT =request.getParameter("TRAN_WRT_DT");
		this.TRAN_CHGBRE_SEQ =request.getParameter("TRAN_CHGBRE_SEQ");
		this.COMPANY_DIAG_BAS_DT2 =request.getParameter("COMPANY_DIAG_BAS_DT2");
		this.BUSS_YMD =request.getParameter("BUSS_YMD");
		this.FOREIGN_YN =request.getParameter("FOREIGN_YN");
		this.REGIST_YMD =request.getParameter("REGIST_YMD");
		this.ASSI_BUSS_YMD =request.getParameter("ASSI_BUSS_YMD");
		this.ASSI_FOREIGN_YN =request.getParameter("ASSI_FOREIGN_YN");
		this.ASSI_REGIST_YMD =request.getParameter("ASSI_REGIST_YMD");
		this.TRAN_BUSS_YMD =request.getParameter("TRAN_BUSS_YMD");
		this.TRAN_FOREIGN_YN =request.getParameter("TRAN_FOREIGN_YN");
		this.TRAN_REGIST_YMD =request.getParameter("TRAN_REGIST_YMD");
		
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
		this.CHG_DT =KJFMi.dsGet(ds, arg_row, "CHG_DT");
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
		this.ASSI_TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "ASSI_TMP_WRT_NUM");
		this.ASSI_COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "ASSI_COI_WRT_NUM");
		this.ASSI_COMMANA_CLASS =KJFMi.dsGet(ds, arg_row, "ASSI_COMMANA_CLASS");
		this.ASSI_MANA_NUM =KJFMi.dsGet(ds, arg_row, "ASSI_MANA_NUM");
		this.ASSI_STE =KJFMi.dsGet(ds, arg_row, "ASSI_STE");
		this.ASSI_NAME =KJFMi.dsGet(ds, arg_row, "ASSI_NAME");
		this.ASSI_TELNUM =KJFMi.dsGet(ds, arg_row, "ASSI_TELNUM");
		this.ASSI_REP =KJFMi.dsGet(ds, arg_row, "ASSI_REP");
		this.ASSI_COMNUM =KJFMi.dsGet(ds, arg_row, "ASSI_COMNUM");
		this.ASSI_ADDR =KJFMi.dsGet(ds, arg_row, "ASSI_ADDR");
		this.ASSI_POST_NUM =KJFMi.dsGet(ds, arg_row, "ASSI_POST_NUM");
		this.ASSI_DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "ASSI_DETAIL_ADDR");
		this.ASSI_GUBUN =KJFMi.dsGet(ds, arg_row, "ASSI_GUBUN");
		this.ASSI_WRT_DT =KJFMi.dsGet(ds, arg_row, "ASSI_WRT_DT");
		this.ASSI_CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "ASSI_CHGBRE_SEQ");
		this.TRAN_TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TRAN_TMP_WRT_NUM");
		this.TRAN_COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TRAN_COI_WRT_NUM");
		this.TRAN_COMMANA_CLASS =KJFMi.dsGet(ds, arg_row, "TRAN_COMMANA_CLASS");
		this.TRAN_MANA_NUM =KJFMi.dsGet(ds, arg_row, "TRAN_MANA_NUM");
		this.TRAN_NAME =KJFMi.dsGet(ds, arg_row, "TRAN_NAME");
		this.TRAN_TELNUM =KJFMi.dsGet(ds, arg_row, "TRAN_TELNUM");
		this.TRAN_REP =KJFMi.dsGet(ds, arg_row, "TRAN_REP");
		this.TRAN_COMNUM =KJFMi.dsGet(ds, arg_row, "TRAN_COMNUM");
		this.TRAN_ADDR =KJFMi.dsGet(ds, arg_row, "TRAN_ADDR");
		this.TRAN_POST_NUM =KJFMi.dsGet(ds, arg_row, "TRAN_POST_NUM");
		this.TRAN_DETAIL_ADDR =KJFMi.dsGet(ds, arg_row, "TRAN_DETAIL_ADDR");
		this.TRAN_GUBUN =KJFMi.dsGet(ds, arg_row, "TRAN_GUBUN");
		this.TRAN_WRT_DT =KJFMi.dsGet(ds, arg_row, "TRAN_WRT_DT");
		this.TRAN_CHGBRE_SEQ =KJFMi.dsGet(ds, arg_row, "TRAN_CHGBRE_SEQ");
		this.COMPANY_DIAG_BAS_DT2 =KJFMi.dsGet(ds, arg_row, "COMPANY_DIAG_BAS_DT2");
		this.BUSS_YMD =KJFMi.dsGet(ds, arg_row, "BUSS_YMD");
		this.FOREIGN_YN =KJFMi.dsGet(ds, arg_row, "FOREIGN_YN");
		this.REGIST_YMD =KJFMi.dsGet(ds, arg_row, "REGIST_YMD");
		this.ASSI_BUSS_YMD =KJFMi.dsGet(ds, arg_row, "ASSI_BUSS_YMD");
		this.ASSI_FOREIGN_YN =KJFMi.dsGet(ds, arg_row, "ASSI_FOREIGN_YN");
		this.ASSI_REGIST_YMD =KJFMi.dsGet(ds, arg_row, "ASSI_REGIST_YMD");
		this.TRAN_BUSS_YMD =KJFMi.dsGet(ds, arg_row, "TRAN_BUSS_YMD");
		this.TRAN_FOREIGN_YN =KJFMi.dsGet(ds, arg_row, "TRAN_FOREIGN_YN");
		this.TRAN_REGIST_YMD =KJFMi.dsGet(ds, arg_row, "TRAN_REGIST_YMD");
				
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
  
     public String getCHG_DT(){
             return CHG_DT;
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
  
     public String getASSI_TMP_WRT_NUM(){
             return ASSI_TMP_WRT_NUM;
     };
  
     public String getASSI_COI_WRT_NUM(){
             return ASSI_COI_WRT_NUM;
     };
  
     public String getASSI_COMMANA_CLASS(){
             return ASSI_COMMANA_CLASS;
     };
  
     public String getASSI_MANA_NUM(){
             return ASSI_MANA_NUM;
     };
  
     public String getASSI_STE(){
             return ASSI_STE;
     };
  
     public String getASSI_NAME(){
             return ASSI_NAME;
     };
  
     public String getASSI_TELNUM(){
             return ASSI_TELNUM;
     };
  
     public String getASSI_REP(){
             return ASSI_REP;
     };
  
     public String getASSI_COMNUM(){
             return ASSI_COMNUM;
     };
  
     public String getASSI_ADDR(){
             return ASSI_ADDR;
     };
  
     public String getASSI_POST_NUM(){
             return ASSI_POST_NUM;
     };
  
     public String getASSI_DETAIL_ADDR(){
             return ASSI_DETAIL_ADDR;
     };
  
     public String getASSI_GUBUN(){
             return ASSI_GUBUN;
     };
  
     public String getASSI_WRT_DT(){
             return ASSI_WRT_DT;
     };
  
     public String getASSI_CHGBRE_SEQ(){
             return ASSI_CHGBRE_SEQ;
     };
  
     public String getTRAN_TMP_WRT_NUM(){
             return TRAN_TMP_WRT_NUM;
     };
  
     public String getTRAN_COI_WRT_NUM(){
             return TRAN_COI_WRT_NUM;
     };
  
     public String getTRAN_COMMANA_CLASS(){
             return TRAN_COMMANA_CLASS;
     };
  
     public String getTRAN_MANA_NUM(){
             return TRAN_MANA_NUM;
     };
  
     public String getTRAN_NAME(){
             return TRAN_NAME;
     };
  
     public String getTRAN_TELNUM(){
             return TRAN_TELNUM;
     };
  
     public String getTRAN_REP(){
             return TRAN_REP;
     };
  
     public String getTRAN_COMNUM(){
             return TRAN_COMNUM;
     };
  
     public String getTRAN_ADDR(){
             return TRAN_ADDR;
     };
  
     public String getTRAN_POST_NUM(){
             return TRAN_POST_NUM;
     };
  
     public String getTRAN_DETAIL_ADDR(){
             return TRAN_DETAIL_ADDR;
     };
  
     public String getTRAN_GUBUN(){
             return TRAN_GUBUN;
     };
  
     public String getTRAN_WRT_DT(){
             return TRAN_WRT_DT;
     };
  
     public String getTRAN_CHGBRE_SEQ(){
             return TRAN_CHGBRE_SEQ;
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
  
     public String getASSI_BUSS_YMD(){
             return ASSI_BUSS_YMD;
     };
  
     public String getASSI_FOREIGN_YN(){
             return ASSI_FOREIGN_YN;
     };
  
     public String getASSI_REGIST_YMD(){
             return ASSI_REGIST_YMD;
     };
  
     public String getTRAN_BUSS_YMD(){
             return TRAN_BUSS_YMD;
     };
  
     public String getTRAN_FOREIGN_YN(){
             return TRAN_FOREIGN_YN;
     };
  
     public String getTRAN_REGIST_YMD(){
             return TRAN_REGIST_YMD;
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
  
     public void setCHG_DT(String CHG_DT){
            this.CHG_DT=CHG_DT;
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
  
     public void setASSI_TMP_WRT_NUM(String ASSI_TMP_WRT_NUM){
            this.ASSI_TMP_WRT_NUM=ASSI_TMP_WRT_NUM;
     };
  
     public void setASSI_COI_WRT_NUM(String ASSI_COI_WRT_NUM){
            this.ASSI_COI_WRT_NUM=ASSI_COI_WRT_NUM;
     };
  
     public void setASSI_COMMANA_CLASS(String ASSI_COMMANA_CLASS){
            this.ASSI_COMMANA_CLASS=ASSI_COMMANA_CLASS;
     };
  
     public void setASSI_MANA_NUM(String ASSI_MANA_NUM){
            this.ASSI_MANA_NUM=ASSI_MANA_NUM;
     };
  
     public void setASSI_STE(String ASSI_STE){
            this.ASSI_STE=ASSI_STE;
     };
  
     public void setASSI_NAME(String ASSI_NAME){
            this.ASSI_NAME=ASSI_NAME;
     };
  
     public void setASSI_TELNUM(String ASSI_TELNUM){
            this.ASSI_TELNUM=ASSI_TELNUM;
     };
  
     public void setASSI_REP(String ASSI_REP){
            this.ASSI_REP=ASSI_REP;
     };
  
     public void setASSI_COMNUM(String ASSI_COMNUM){
            this.ASSI_COMNUM=ASSI_COMNUM;
     };
  
     public void setASSI_ADDR(String ASSI_ADDR){
            this.ASSI_ADDR=ASSI_ADDR;
     };
  
     public void setASSI_POST_NUM(String ASSI_POST_NUM){
            this.ASSI_POST_NUM=ASSI_POST_NUM;
     };
  
     public void setASSI_DETAIL_ADDR(String ASSI_DETAIL_ADDR){
            this.ASSI_DETAIL_ADDR=ASSI_DETAIL_ADDR;
     };
  
     public void setASSI_GUBUN(String ASSI_GUBUN){
            this.ASSI_GUBUN=ASSI_GUBUN;
     };
  
     public void setASSI_WRT_DT(String ASSI_WRT_DT){
            this.ASSI_WRT_DT=ASSI_WRT_DT;
     };
  
     public void setASSI_CHGBRE_SEQ(String ASSI_CHGBRE_SEQ){
            this.ASSI_CHGBRE_SEQ=ASSI_CHGBRE_SEQ;
     };
  
     public void setTRAN_TMP_WRT_NUM(String TRAN_TMP_WRT_NUM){
            this.TRAN_TMP_WRT_NUM=TRAN_TMP_WRT_NUM;
     };
  
     public void setTRAN_COI_WRT_NUM(String TRAN_COI_WRT_NUM){
            this.TRAN_COI_WRT_NUM=TRAN_COI_WRT_NUM;
     };
  
     public void setTRAN_COMMANA_CLASS(String TRAN_COMMANA_CLASS){
            this.TRAN_COMMANA_CLASS=TRAN_COMMANA_CLASS;
     };
  
     public void setTRAN_MANA_NUM(String TRAN_MANA_NUM){
            this.TRAN_MANA_NUM=TRAN_MANA_NUM;
     };
  
     public void setTRAN_NAME(String TRAN_NAME){
            this.TRAN_NAME=TRAN_NAME;
     };
  
     public void setTRAN_TELNUM(String TRAN_TELNUM){
            this.TRAN_TELNUM=TRAN_TELNUM;
     };
  
     public void setTRAN_REP(String TRAN_REP){
            this.TRAN_REP=TRAN_REP;
     };
  
     public void setTRAN_COMNUM(String TRAN_COMNUM){
            this.TRAN_COMNUM=TRAN_COMNUM;
     };
  
     public void setTRAN_ADDR(String TRAN_ADDR){
            this.TRAN_ADDR=TRAN_ADDR;
     };
  
     public void setTRAN_POST_NUM(String TRAN_POST_NUM){
            this.TRAN_POST_NUM=TRAN_POST_NUM;
     };
  
     public void setTRAN_DETAIL_ADDR(String TRAN_DETAIL_ADDR){
            this.TRAN_DETAIL_ADDR=TRAN_DETAIL_ADDR;
     };
  
     public void setTRAN_GUBUN(String TRAN_GUBUN){
            this.TRAN_GUBUN=TRAN_GUBUN;
     };
  
     public void setTRAN_WRT_DT(String TRAN_WRT_DT){
            this.TRAN_WRT_DT=TRAN_WRT_DT;
     };
  
     public void setTRAN_CHGBRE_SEQ(String TRAN_CHGBRE_SEQ){
            this.TRAN_CHGBRE_SEQ=TRAN_CHGBRE_SEQ;
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
  
     public void setASSI_BUSS_YMD(String ASSI_BUSS_YMD){
            this.ASSI_BUSS_YMD=ASSI_BUSS_YMD;
     };
  
     public void setASSI_FOREIGN_YN(String ASSI_FOREIGN_YN){
            this.ASSI_FOREIGN_YN=ASSI_FOREIGN_YN;
     };
  
     public void setASSI_REGIST_YMD(String ASSI_REGIST_YMD){
            this.ASSI_REGIST_YMD=ASSI_REGIST_YMD;
     };
  
     public void setTRAN_BUSS_YMD(String TRAN_BUSS_YMD){
            this.TRAN_BUSS_YMD=TRAN_BUSS_YMD;
     };
  
     public void setTRAN_FOREIGN_YN(String TRAN_FOREIGN_YN){
            this.TRAN_FOREIGN_YN=TRAN_FOREIGN_YN;
     };
  
     public void setTRAN_REGIST_YMD(String TRAN_REGIST_YMD){
            this.TRAN_REGIST_YMD=TRAN_REGIST_YMD;
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
      
      strB.append("CHG_DT:"+ this.getCHG_DT()+"\n");
      
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
      
      strB.append("ASSI_TMP_WRT_NUM:"+ this.getASSI_TMP_WRT_NUM()+"\n");
      
      strB.append("ASSI_COI_WRT_NUM:"+ this.getASSI_COI_WRT_NUM()+"\n");
      
      strB.append("ASSI_COMMANA_CLASS:"+ this.getASSI_COMMANA_CLASS()+"\n");
      
      strB.append("ASSI_MANA_NUM:"+ this.getASSI_MANA_NUM()+"\n");
      
      strB.append("ASSI_STE:"+ this.getASSI_STE()+"\n");
      
      strB.append("ASSI_NAME:"+ this.getASSI_NAME()+"\n");
      
      strB.append("ASSI_TELNUM:"+ this.getASSI_TELNUM()+"\n");
      
      strB.append("ASSI_REP:"+ this.getASSI_REP()+"\n");
      
      strB.append("ASSI_COMNUM:"+ this.getASSI_COMNUM()+"\n");
      
      strB.append("ASSI_ADDR:"+ this.getASSI_ADDR()+"\n");
      
      strB.append("ASSI_POST_NUM:"+ this.getASSI_POST_NUM()+"\n");
      
      strB.append("ASSI_DETAIL_ADDR:"+ this.getASSI_DETAIL_ADDR()+"\n");
      
      strB.append("ASSI_GUBUN:"+ this.getASSI_GUBUN()+"\n");
      
      strB.append("ASSI_WRT_DT:"+ this.getASSI_WRT_DT()+"\n");
      
      strB.append("ASSI_CHGBRE_SEQ:"+ this.getASSI_CHGBRE_SEQ()+"\n");
      
      strB.append("TRAN_TMP_WRT_NUM:"+ this.getTRAN_TMP_WRT_NUM()+"\n");
      
      strB.append("TRAN_COI_WRT_NUM:"+ this.getTRAN_COI_WRT_NUM()+"\n");
      
      strB.append("TRAN_COMMANA_CLASS:"+ this.getTRAN_COMMANA_CLASS()+"\n");
      
      strB.append("TRAN_MANA_NUM:"+ this.getTRAN_MANA_NUM()+"\n");
      
      strB.append("TRAN_NAME:"+ this.getTRAN_NAME()+"\n");
      
      strB.append("TRAN_TELNUM:"+ this.getTRAN_TELNUM()+"\n");
      
      strB.append("TRAN_REP:"+ this.getTRAN_REP()+"\n");
      
      strB.append("TRAN_COMNUM:"+ this.getTRAN_COMNUM()+"\n");
      
      strB.append("TRAN_ADDR:"+ this.getTRAN_ADDR()+"\n");
      
      strB.append("TRAN_POST_NUM:"+ this.getTRAN_POST_NUM()+"\n");
      
      strB.append("TRAN_DETAIL_ADDR:"+ this.getTRAN_DETAIL_ADDR()+"\n");
      
      strB.append("TRAN_GUBUN:"+ this.getTRAN_GUBUN()+"\n");
      
      strB.append("TRAN_WRT_DT:"+ this.getTRAN_WRT_DT()+"\n");
      
      strB.append("TRAN_CHGBRE_SEQ:"+ this.getTRAN_CHGBRE_SEQ()+"\n");
      
      strB.append("COMPANY_DIAG_BAS_DT2:"+ this.getCOMPANY_DIAG_BAS_DT2()+"\n");
      
      strB.append("BUSS_YMD:"+ this.getBUSS_YMD()+"\n");
      
      strB.append("FOREIGN_YN:"+ this.getFOREIGN_YN()+"\n");
      
      strB.append("REGIST_YMD:"+ this.getREGIST_YMD()+"\n");
      
      strB.append("ASSI_BUSS_YMD:"+ this.getASSI_BUSS_YMD()+"\n");
      
      strB.append("ASSI_FOREIGN_YN:"+ this.getASSI_FOREIGN_YN()+"\n");
      
      strB.append("ASSI_REGIST_YMD:"+ this.getASSI_REGIST_YMD()+"\n");
      
      strB.append("TRAN_BUSS_YMD:"+ this.getTRAN_BUSS_YMD()+"\n");
      
      strB.append("TRAN_FOREIGN_YN:"+ this.getTRAN_FOREIGN_YN()+"\n");
      
      strB.append("TRAN_REGIST_YMD:"+ this.getTRAN_REGIST_YMD()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_ASSI_TRANS_STATEMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_ASSI_TRANS_STATEMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_ASSI_TRANS_STATEMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_ASSI_TRANS_STATEMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_ASSI_TRANS_STATEMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_ASSI_TRANS_STATEMENTEntity();
  }

  public ValueObject getClone(){
         PT_R_ASSI_TRANS_STATEMENTEntity newEnt = new PT_R_ASSI_TRANS_STATEMENTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setMOT_STE(this.getMOT_STE());
         
          newEnt.setDEFI_STE(this.getDEFI_STE());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setRECV_TIME(this.getRECV_TIME());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setPROC_TIME(this.getPROC_TIME());
         
          newEnt.setCHG_DT(this.getCHG_DT());
         
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
         
          newEnt.setASSI_TMP_WRT_NUM(this.getASSI_TMP_WRT_NUM());
         
          newEnt.setASSI_COI_WRT_NUM(this.getASSI_COI_WRT_NUM());
         
          newEnt.setASSI_COMMANA_CLASS(this.getASSI_COMMANA_CLASS());
         
          newEnt.setASSI_MANA_NUM(this.getASSI_MANA_NUM());
         
          newEnt.setASSI_STE(this.getASSI_STE());
         
          newEnt.setASSI_NAME(this.getASSI_NAME());
         
          newEnt.setASSI_TELNUM(this.getASSI_TELNUM());
         
          newEnt.setASSI_REP(this.getASSI_REP());
         
          newEnt.setASSI_COMNUM(this.getASSI_COMNUM());
         
          newEnt.setASSI_ADDR(this.getASSI_ADDR());
         
          newEnt.setASSI_POST_NUM(this.getASSI_POST_NUM());
         
          newEnt.setASSI_DETAIL_ADDR(this.getASSI_DETAIL_ADDR());
         
          newEnt.setASSI_GUBUN(this.getASSI_GUBUN());
         
          newEnt.setASSI_WRT_DT(this.getASSI_WRT_DT());
         
          newEnt.setASSI_CHGBRE_SEQ(this.getASSI_CHGBRE_SEQ());
         
          newEnt.setTRAN_TMP_WRT_NUM(this.getTRAN_TMP_WRT_NUM());
         
          newEnt.setTRAN_COI_WRT_NUM(this.getTRAN_COI_WRT_NUM());
         
          newEnt.setTRAN_COMMANA_CLASS(this.getTRAN_COMMANA_CLASS());
         
          newEnt.setTRAN_MANA_NUM(this.getTRAN_MANA_NUM());
         
          newEnt.setTRAN_NAME(this.getTRAN_NAME());
         
          newEnt.setTRAN_TELNUM(this.getTRAN_TELNUM());
         
          newEnt.setTRAN_REP(this.getTRAN_REP());
         
          newEnt.setTRAN_COMNUM(this.getTRAN_COMNUM());
         
          newEnt.setTRAN_ADDR(this.getTRAN_ADDR());
         
          newEnt.setTRAN_POST_NUM(this.getTRAN_POST_NUM());
         
          newEnt.setTRAN_DETAIL_ADDR(this.getTRAN_DETAIL_ADDR());
         
          newEnt.setTRAN_GUBUN(this.getTRAN_GUBUN());
         
          newEnt.setTRAN_WRT_DT(this.getTRAN_WRT_DT());
         
          newEnt.setTRAN_CHGBRE_SEQ(this.getTRAN_CHGBRE_SEQ());
         
          newEnt.setCOMPANY_DIAG_BAS_DT2(this.getCOMPANY_DIAG_BAS_DT2());
         
          newEnt.setBUSS_YMD(this.getBUSS_YMD());
         
          newEnt.setFOREIGN_YN(this.getFOREIGN_YN());
         
          newEnt.setREGIST_YMD(this.getREGIST_YMD());
         
          newEnt.setASSI_BUSS_YMD(this.getASSI_BUSS_YMD());
         
          newEnt.setASSI_FOREIGN_YN(this.getASSI_FOREIGN_YN());
         
          newEnt.setASSI_REGIST_YMD(this.getASSI_REGIST_YMD());
         
          newEnt.setTRAN_BUSS_YMD(this.getTRAN_BUSS_YMD());
         
          newEnt.setTRAN_FOREIGN_YN(this.getTRAN_FOREIGN_YN());
         
          newEnt.setTRAN_REGIST_YMD(this.getTRAN_REGIST_YMD());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_ASSI_TRANS_STATEMENTHelper.fieldMap.get(key);
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
                 return  this.getCHG_DT();
        
             case 11 :
                 return  this.getCOMMANA_CLASS();
        
             case 12 :
                 return  this.getMANA_NUM();
        
             case 13 :
                 return  this.getNAME();
        
             case 14 :
                 return  this.getREP_SSN1();
        
             case 15 :
                 return  this.getREP_SSN2();
        
             case 16 :
                 return  this.getREP_NM_KOR();
        
             case 17 :
                 return  this.getREP_NM_HAN();
        
             case 18 :
                 return  this.getREP_TEL_NUM();
        
             case 19 :
                 return  this.getADDR_POST_NUM();
        
             case 20 :
                 return  this.getADDR_ADDR();
        
             case 21 :
                 return  this.getADDR_DETAIL_ADDR();
        
             case 22 :
                 return  this.getADDR_TEL_NUM();
        
             case 23 :
                 return  this.getADDR_FAX_NUM();
        
             case 24 :
                 return  this.getEMAIL_ADDR();
        
             case 25 :
                 return  this.getOFFICE_AREA();
        
             case 26 :
                 return  this.getOFFICE_USE_CODE();
        
             case 27 :
                 return  this.getCOMPANY_DIAG_CLASS_CODE();
        
             case 28 :
                 return  this.getCOMPANY_DIAG_BAS_DT();
        
             case 29 :
                 return  this.getCOMPANY_DIAG_ISSUE_DT();
        
             case 30 :
                 return  this.getDIAG_ORG_CODE();
        
             case 31 :
                 return  this.getDIAG_NM_NM();
        
             case 32 :
                 return  this.getDIAG_NM_WRT_NUM();
        
             case 33 :
                 return  this.getPAY_CAP();
        
             case 34 :
                 return  this.getREA_CAP();
        
             case 35 :
                 return  this.getTUP_AOM();
        
             case 36 :
                 return  this.getTUP_CLASS_CODE();
        
             case 37 :
                 return  this.getCOM_COV_DT();
        
             case 38 :
                 return  this.getBAS_STA_DT();
        
             case 39 :
                 return  this.getOFFICE_OWN_CLASS();
        
             case 40 :
                 return  this.getREP_MOBILE();
        
             case 41 :
                 return  this.getLICTAX();
        
             case 42 :
                 return  this.getHOSCRE();
        
             case 43 :
                 return  this.getCOM_NUM();
        
             case 44 :
                 return  this.getGUBUN();
        
             case 45 :
                 return  this.getDOC_CODE();
        
             case 46 :
                 return  this.getOFFICE_USE_NAME();
        
             case 47 :
                 return  this.getMEMO_CONT();
        
             case 48 :
                 return  this.getWRT_ID();
        
             case 49 :
                 return  this.getINS_DT();
        
             case 50 :
                 return  this.getUPD_DT();
        
             case 51 :
                 return  this.getASSI_TMP_WRT_NUM();
        
             case 52 :
                 return  this.getASSI_COI_WRT_NUM();
        
             case 53 :
                 return  this.getASSI_COMMANA_CLASS();
        
             case 54 :
                 return  this.getASSI_MANA_NUM();
        
             case 55 :
                 return  this.getASSI_STE();
        
             case 56 :
                 return  this.getASSI_NAME();
        
             case 57 :
                 return  this.getASSI_TELNUM();
        
             case 58 :
                 return  this.getASSI_REP();
        
             case 59 :
                 return  this.getASSI_COMNUM();
        
             case 60 :
                 return  this.getASSI_ADDR();
        
             case 61 :
                 return  this.getASSI_POST_NUM();
        
             case 62 :
                 return  this.getASSI_DETAIL_ADDR();
        
             case 63 :
                 return  this.getASSI_GUBUN();
        
             case 64 :
                 return  this.getASSI_WRT_DT();
        
             case 65 :
                 return  this.getASSI_CHGBRE_SEQ();
        
             case 66 :
                 return  this.getTRAN_TMP_WRT_NUM();
        
             case 67 :
                 return  this.getTRAN_COI_WRT_NUM();
        
             case 68 :
                 return  this.getTRAN_COMMANA_CLASS();
        
             case 69 :
                 return  this.getTRAN_MANA_NUM();
        
             case 70 :
                 return  this.getTRAN_NAME();
        
             case 71 :
                 return  this.getTRAN_TELNUM();
        
             case 72 :
                 return  this.getTRAN_REP();
        
             case 73 :
                 return  this.getTRAN_COMNUM();
        
             case 74 :
                 return  this.getTRAN_ADDR();
        
             case 75 :
                 return  this.getTRAN_POST_NUM();
        
             case 76 :
                 return  this.getTRAN_DETAIL_ADDR();
        
             case 77 :
                 return  this.getTRAN_GUBUN();
        
             case 78 :
                 return  this.getTRAN_WRT_DT();
        
             case 79 :
                 return  this.getTRAN_CHGBRE_SEQ();
        
             case 80 :
                 return  this.getCOMPANY_DIAG_BAS_DT2();
        
             case 81 :
                 return  this.getBUSS_YMD();
        
             case 82 :
                 return  this.getFOREIGN_YN();
        
             case 83 :
                 return  this.getREGIST_YMD();
        
             case 84 :
                 return  this.getASSI_BUSS_YMD();
        
             case 85 :
                 return  this.getASSI_FOREIGN_YN();
        
             case 86 :
                 return  this.getASSI_REGIST_YMD();
        
             case 87 :
                 return  this.getTRAN_BUSS_YMD();
        
             case 88 :
                 return  this.getTRAN_FOREIGN_YN();
        
             case 89 :
                 return  this.getTRAN_REGIST_YMD();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_ASSI_TRANS_STATEMENTHelper.fieldMap.get(key);
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
                    this.setCHG_DT((String)value);
	            return;  
        
             case 11 :
                    this.setCOMMANA_CLASS((String)value);
	            return;  
        
             case 12 :
                    this.setMANA_NUM((String)value);
	            return;  
        
             case 13 :
                    this.setNAME((String)value);
	            return;  
        
             case 14 :
                    this.setREP_SSN1((String)value);
	            return;  
        
             case 15 :
                    this.setREP_SSN2((String)value);
	            return;  
        
             case 16 :
                    this.setREP_NM_KOR((String)value);
	            return;  
        
             case 17 :
                    this.setREP_NM_HAN((String)value);
	            return;  
        
             case 18 :
                    this.setREP_TEL_NUM((String)value);
	            return;  
        
             case 19 :
                    this.setADDR_POST_NUM((String)value);
	            return;  
        
             case 20 :
                    this.setADDR_ADDR((String)value);
	            return;  
        
             case 21 :
                    this.setADDR_DETAIL_ADDR((String)value);
	            return;  
        
             case 22 :
                    this.setADDR_TEL_NUM((String)value);
	            return;  
        
             case 23 :
                    this.setADDR_FAX_NUM((String)value);
	            return;  
        
             case 24 :
                    this.setEMAIL_ADDR((String)value);
	            return;  
        
             case 25 :
                    this.setOFFICE_AREA((String)value);
	            return;  
        
             case 26 :
                    this.setOFFICE_USE_CODE((String)value);
	            return;  
        
             case 27 :
                    this.setCOMPANY_DIAG_CLASS_CODE((String)value);
	            return;  
        
             case 28 :
                    this.setCOMPANY_DIAG_BAS_DT((String)value);
	            return;  
        
             case 29 :
                    this.setCOMPANY_DIAG_ISSUE_DT((String)value);
	            return;  
        
             case 30 :
                    this.setDIAG_ORG_CODE((String)value);
	            return;  
        
             case 31 :
                    this.setDIAG_NM_NM((String)value);
	            return;  
        
             case 32 :
                    this.setDIAG_NM_WRT_NUM((String)value);
	            return;  
        
             case 33 :
                    this.setPAY_CAP((String)value);
	            return;  
        
             case 34 :
                    this.setREA_CAP((String)value);
	            return;  
        
             case 35 :
                    this.setTUP_AOM((String)value);
	            return;  
        
             case 36 :
                    this.setTUP_CLASS_CODE((String)value);
	            return;  
        
             case 37 :
                    this.setCOM_COV_DT((String)value);
	            return;  
        
             case 38 :
                    this.setBAS_STA_DT((String)value);
	            return;  
        
             case 39 :
                    this.setOFFICE_OWN_CLASS((String)value);
	            return;  
        
             case 40 :
                    this.setREP_MOBILE((String)value);
	            return;  
        
             case 41 :
                    this.setLICTAX((String)value);
	            return;  
        
             case 42 :
                    this.setHOSCRE((String)value);
	            return;  
        
             case 43 :
                    this.setCOM_NUM((String)value);
	            return;  
        
             case 44 :
                    this.setGUBUN((String)value);
	            return;  
        
             case 45 :
                    this.setDOC_CODE((String)value);
	            return;  
        
             case 46 :
                    this.setOFFICE_USE_NAME((String)value);
	            return;  
        
             case 47 :
                    this.setMEMO_CONT((String)value);
	            return;  
        
             case 48 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 49 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 50 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 51 :
                    this.setASSI_TMP_WRT_NUM((String)value);
	            return;  
        
             case 52 :
                    this.setASSI_COI_WRT_NUM((String)value);
	            return;  
        
             case 53 :
                    this.setASSI_COMMANA_CLASS((String)value);
	            return;  
        
             case 54 :
                    this.setASSI_MANA_NUM((String)value);
	            return;  
        
             case 55 :
                    this.setASSI_STE((String)value);
	            return;  
        
             case 56 :
                    this.setASSI_NAME((String)value);
	            return;  
        
             case 57 :
                    this.setASSI_TELNUM((String)value);
	            return;  
        
             case 58 :
                    this.setASSI_REP((String)value);
	            return;  
        
             case 59 :
                    this.setASSI_COMNUM((String)value);
	            return;  
        
             case 60 :
                    this.setASSI_ADDR((String)value);
	            return;  
        
             case 61 :
                    this.setASSI_POST_NUM((String)value);
	            return;  
        
             case 62 :
                    this.setASSI_DETAIL_ADDR((String)value);
	            return;  
        
             case 63 :
                    this.setASSI_GUBUN((String)value);
	            return;  
        
             case 64 :
                    this.setASSI_WRT_DT((String)value);
	            return;  
        
             case 65 :
                    this.setASSI_CHGBRE_SEQ((String)value);
	            return;  
        
             case 66 :
                    this.setTRAN_TMP_WRT_NUM((String)value);
	            return;  
        
             case 67 :
                    this.setTRAN_COI_WRT_NUM((String)value);
	            return;  
        
             case 68 :
                    this.setTRAN_COMMANA_CLASS((String)value);
	            return;  
        
             case 69 :
                    this.setTRAN_MANA_NUM((String)value);
	            return;  
        
             case 70 :
                    this.setTRAN_NAME((String)value);
	            return;  
        
             case 71 :
                    this.setTRAN_TELNUM((String)value);
	            return;  
        
             case 72 :
                    this.setTRAN_REP((String)value);
	            return;  
        
             case 73 :
                    this.setTRAN_COMNUM((String)value);
	            return;  
        
             case 74 :
                    this.setTRAN_ADDR((String)value);
	            return;  
        
             case 75 :
                    this.setTRAN_POST_NUM((String)value);
	            return;  
        
             case 76 :
                    this.setTRAN_DETAIL_ADDR((String)value);
	            return;  
        
             case 77 :
                    this.setTRAN_GUBUN((String)value);
	            return;  
        
             case 78 :
                    this.setTRAN_WRT_DT((String)value);
	            return;  
        
             case 79 :
                    this.setTRAN_CHGBRE_SEQ((String)value);
	            return;  
        
             case 80 :
                    this.setCOMPANY_DIAG_BAS_DT2((String)value);
	            return;  
        
             case 81 :
                    this.setBUSS_YMD((String)value);
	            return;  
        
             case 82 :
                    this.setFOREIGN_YN((String)value);
	            return;  
        
             case 83 :
                    this.setREGIST_YMD((String)value);
	            return;  
        
             case 84 :
                    this.setASSI_BUSS_YMD((String)value);
	            return;  
        
             case 85 :
                    this.setASSI_FOREIGN_YN((String)value);
	            return;  
        
             case 86 :
                    this.setASSI_REGIST_YMD((String)value);
	            return;  
        
             case 87 :
                    this.setTRAN_BUSS_YMD((String)value);
	            return;  
        
             case 88 :
                    this.setTRAN_FOREIGN_YN((String)value);
	            return;  
        
             case 89 :
                    this.setTRAN_REGIST_YMD((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_ASSI_TRANS_STATEMENTHelper.toXML(this);
  }
  
}
