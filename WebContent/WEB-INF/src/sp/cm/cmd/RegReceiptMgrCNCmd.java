/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegReceiptMgrCNCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegReceiptMgrCNCmd() {
    }

    public RegReceiptMgrCNCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scRECV_NUM = vl.getValueAsString("RECV_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCHECK = vl.getValueAsString("CHECK");
        //String scCHGBRE_SEQ = vl.getValueAsString("CHGBRE_SEQ");
        String scCOI_WRT_NUM = vl.getValueAsString("COI_WRT_NUM");
        String scDOC_CODE = vl.getValueAsString("DOC_CODE");
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;
        
        
                        
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
         if (scCHECK.equalsIgnoreCase("TRUE"))
        {
        	sQuery.append(" SELECT RECV_NUM, TMP_WRT_NUM FROM PT_R_REGIST_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	sQuery.append(" SELECT RECV_NUM FROM PT_R_BASIC_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        sQuery.append(" SELECT RECV_NUM FROM PT_R_ASSI_TRANS_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        sQuery.append(" SELECT RECV_NUM FROM PT_R_M_UNION_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       
        }
         else if (scCHECK.equalsIgnoreCase("CHECK2"))
         {
         	sQuery.append(" SELECT DOC_CODE, TMP_WRT_NUM FROM PT_R_REGIST_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	       	sQuery.append(" SELECT DOC_CODE FROM PT_R_BASIC_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_ASSI_TRANS_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_M_UNION_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
 	        sQuery.append(" SELECT DOC_CODE FROM PT_R_CLOSE_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
 	        sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
 	       	
        	sQuery.append(" SELECT DOC_CODE FROM PT_M_MASTER ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	DOC_CODE = '" + scDOC_CODE + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	  	       
            KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
            sQuery.delete(0, sQuery.length());
 	       	sWhere.delete(0, sWhere.length());
         }
         else if((scCHECK.equalsIgnoreCase("TRUE1")))
         {
        	 sQuery.append(" SELECT COI_WRT_NUM FROM PT_R_REGIST_STATEMENT ");
         	sWhere.append(" WHERE	1=1	\n");
         	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
         	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
 	    	
 	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
 	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
 	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
 	        sQuery.append(" SELECT COI_WRT_NUM FROM PT_R_COMPANY_MASTER ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
 	    
         }
         
        else if((scCHECK.equalsIgnoreCase("FALSE")))
        {
	        //Master Table
        	sQuery.append(" select RECV_NUM, SIDO_CODE, RECV_DT,RECV_TIME,PROC_LIM,OFFI_PART,OFFI_PART_REBO_WRT_NUM,NAME,");
           	sQuery.append(" MANA_NUM,COM_NUM,REP_NM_KOR,REP_NM_HAN,ADDR_POST_NUM,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,");
           	sQuery.append(" DEFI_STE,WRT_ID,UPD_DT,INS_DT,ADDR_ADDR,PROC_TIME,REP_MOBILE,REP_MOBILE2,REP_MOBILE3,ADDR_TEL_NUM2,ADDR_TEL_NUM3,");
           	sQuery.append(" ADDR_FAX_NUM2,ADDR_FAX_NUM3,ADDR_TEL_NUM1,ADDR_FAX_NUM1,REP_MOBILE1,REP_SSN1 ,");
           	sQuery.append(" REP_SSN2 ,decode(GUBUN,null,1,1,1,2,2) GUBUN,COI_WRT_NUM,MOT_STE,DOC_CODE,decode(COMMANA_CLASS,null,1,1,1,2,2,3,3) COMMANA_CLASS,OFFICE_AREA,DIAG_ORG_CODE,DIAG_NM_NM,COMPANY_DIAG_BAS_DT,");
           	sQuery.append(" PAY_CAP,DIAG_NM_WRT_NUM,COMPANY_DIAG_ISSUE_DT,REA_CAP,TUP_CLASS_CODE,TUP_AOM,OFFICE_USE_NAME,OFFICE_OWN_CLASS,");
           	sQuery.append(" LICTAX,HOSCRE,MEMO_CONT,TMP_WRT_NUM,WRT_DT,BUSS_YMD,decode(FOREIGN_YN,null,'N','N','N','Y','Y') FOREIGN_YN,REGIST_YMD,STA_CHG_CLASS_CODE,");
           	sQuery.append(" CHG_DT,EXT_CHG_CLASS_CODE from PT_R_REGIST_STATEMENT");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
        	/*
        	sQuery.append(" SELECT * FROM PT_R_REGIST_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + scRECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	        */
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        
	        //Memo Table
	        sQuery.append(" SELECT '0' AS CHECKER, A.* FROM PT_R_MEMO A ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND	RECV_NUM = '" + scRECV_NUM + "' \n");
	        sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        //Corp Table
	        sQuery.append(" SELECT '0' AS CHECKER, A.*, B.CODE_NAME AS OTOB_COM_TOB_CONT ");
	        sQuery.append(" FROM PT_R_SUBSIDIARY_COMPANY A LEFT JOIN  ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'SUBSIDIARY') ");
	        sQuery.append(" B ON A.OTOB_COM_CODE = B.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND	A.RECV_NUM = '" + scRECV_NUM + "' \n");
	        sWhere.append("  AND	A.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	
	        	        
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        
	        //Deficit Table
	        sQuery.append(" SELECT PDEF.*, PDEF_CODE.CONT AS DEFI_CONT FROM PT_R_DEFICIT PDEF LEFT JOIN ");
	        sQuery.append(" (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE WHERE DEFI_GROUP = 'GUBU') ");
	        sQuery.append(" PDEF_CODE  ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PDEF.RECV_NUM = '" + scRECV_NUM + "' ");
	        sWhere.append("  AND	PDEF.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        //dsPT_R_SUBSIDIARY
	        //String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");

	       	sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS SUB_NAME FROM PT_R_SUBSIDIARY AA ");
	        sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'SUBSIDIARY')BB ON AA.SUB_CODE = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output11");
	        
	        //PT_R_ENGINEER_CHANGE
			// 2010.01.14. PT_R_ENGINEER_MASTER 사용안함.
	  		sQuery.append(" SELECT ");
			sQuery.append(" '0' AS CHECKER,RECV_NUM,ENGINEER_NM, ENGINEER_SSN1 ,ENGINEER_SSN2,  ");
			sQuery.append(" EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT,  ");
			sQuery.append(" SEQ, TMP_WRT_NUM, TMP_FIELD,  ");
			sQuery.append(" CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM, ");
			sQuery.append(" ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS ENGINEER_SSN, TMP_FIELD AS TMP_GRADE ");
			sQuery.append(" FROM PT_R_ENGINEER_CHANGE_TEMP ");
        	sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
	        sWhere.append(" ORDER BY ENGINEER_SSN1 ASC ");
	        //sWhere.append(" AND RET_YMD IS NULL ");
	        //sWhere.append(" ORDER BY EMPL_YMD ");
	        
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output7");
	        
	        //Change Seq
	        String sSeq = rMasterEntity.getValue(0, "SEQ");
	        int chg_seq =1;
	        //PT_R_REFER
	        sQuery.append(" SELECT '0' AS CHECKER, CONCAT(AA.SSN1, AA.SSN2) AS TMPSSN,");
	        sQuery.append(" SSN1,ssn2,seq,tmp_wrt_num,si_do_code,si_gun_gu_code,ent_dt,ret_dt,nm_kor,nm_han,ori,addr,POS_CLASS,");
	        sQuery.append(" DECODE(AA.POS_CLASS, 'P1', '대표이사', 'P2', '감사', 'P3', '이사', '대표자') AS POS_NAME, ");
	        sQuery.append(" hefa,hefa_rela,remark,char_ref_yn,wrt_id,ins_dt,upd_dt,send_yn,foreign_yn,coi_wrt_num,accept_no,del_yn");
	        sQuery.append(" FROM PT_R_REFFER AA ");
	        
	        /*  sQuery.append(" SELECT '0' AS CHECKER, CONCAT(AA.SSN1,AA.SSN)) AS TMPSSN,AA.*");
	        sQuery.append(" DECODE(AA.POS_CLASS, 'P1', '대표이사', 'P2', '감사', 'P3', '이사', '대표자') AS POS_NAME, ");
	        sQuery.append(" FROM PT_R_REFFER AA ");
	        */	
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output8");
	        
	        //PT_R_REFUSAL_REASON
	        sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS REFUSAL_DIV_NAME ");
	        sQuery.append(" FROM PT_R_REFUSAL_REASON AA LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE  ");
	        sQuery.append(" WHERE P_CODE = 'REGCANCEL') BB ON AA.REFS_ITEM = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND AA.CHGBRE_SEQ = '" + chg_seq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output10");
	        
	        //PT_R_MOT_STE
	       // String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");

	        sQuery.append(" SELECT * FROM PT_R_MOT_STE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND RECV_NUM = '" + scRECV_NUM + "'");
	        sWhere.append(" AND CHGBRE_SEQ = '" + chg_seq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output13");
	        
        }
        else if((scCHECK.equalsIgnoreCase("VALIDATION")))
        {
        	String scMANA_NUM = vl.getValueAsString("scMANA_NUM");
        	
        	sQuery.append(" SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER  ");
        	sWhere.append(" WHERE 1 = 1 ");
        	sWhere.append(" AND C_COM_DT is null AND MANA_NUM = '" + scMANA_NUM + "' ");
        	        	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        }
        else
        {
        	//Deficit Codes Table
        	sQuery.append(" SELECT * ");
        	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
        	sQuery.append(" WHERE DEFI_GROUP = 'GUBU' ");
	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
                
        request.setAttribute("dl", dl);  

        return next;
    }
}