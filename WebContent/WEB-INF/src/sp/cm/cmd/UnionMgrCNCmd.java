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

import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFMi;

import kjf.util.KJFUtil;

import sp.dao.PT_R_WORK_CAPABILITYDAO;
import sp.dao.PT_R_WORK_CAPABILITYEntity;
import sp.dao.PT_R_WORK_RESULTSDAO;
import sp.dao.PT_R_WORK_RESULTSEntity;
import sp.util.keng.KengWorker;
import sp.util.keng.Kengineer;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UnionMgrCNCmd<PT_R_DOC_NUM> implements KJFCommand {
	
    private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    PT_R_WORK_RESULTSDAO PT_R_WORK_RESULTSdao = new PT_R_WORK_RESULTSDAO();
    PT_R_WORK_RESULTSEntity PT_R_WORK_RESULTSEnt = new PT_R_WORK_RESULTSEntity();
    
    PT_R_WORK_CAPABILITYDAO PT_R_WORK_CAPABILITYdao = new PT_R_WORK_CAPABILITYDAO();
    PT_R_WORK_CAPABILITYEntity PT_R_WORK_CAPABILITYEnt = new PT_R_WORK_CAPABILITYEntity();
    
    public UnionMgrCNCmd() {
    }

    public UnionMgrCNCmd(String next_url) {
    	next = next_url;
    }
 
 

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();    	     
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();

        String sworkMODE = vl.getValueAsString("workMODE");
    	String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    	String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        String scDOC_CODE = vl.getValueAsString("DOC_CODE");
        
       if ((sworkMODE.equalsIgnoreCase("RECV_NUM_CHECK")))
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
       else if (sworkMODE.equalsIgnoreCase("DOC_CODE_CHECK"))
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
        else if(sworkMODE.equalsIgnoreCase("GETDEF")) //합병관리 접수관리 상세보기 (흡결)
        {
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	    	//Deficit Codes Table
	    	sQuery.append(" SELECT * ");
	    	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
	    	sQuery.append(" WHERE DEFI_GROUP = 'GUBU' ");
	
	    	rMasterEntity    = rDAO.select(sQuery.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	       	       	
        }
        else if (sworkMODE.equalsIgnoreCase("GET_NEXT_SEQ_ENGINEER")) // 보유 기술자 SEQ
        {
        	sQuery.append(" SELECT MAX(NVL(SEQ, 0)) + 1 AS SEQ "); 
        	sQuery.append(" FROM PT_R_ENGINEER_CHANGE_TEMP ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND RECV_NUM = '" + scRECV_NUM + "' AND ENG_PROC='U' ");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());	       	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if (sworkMODE.equalsIgnoreCase("GET_NEXT_SEQ_REFFER")) // 임직원 SEQ
        {
        	sQuery.append(" SELECT MAX(NVL(SEQ, 0)) + 1 AS SEQ "); 
        	sQuery.append(" FROM PT_R_REFFER ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());	       	
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");

        }
        else if((sworkMODE.equalsIgnoreCase("GET_CORP"))) //합병관리-공사업체 조회
        {
	    	String scOLD_TMP_WRT_NUM =  vl.getValueAsString("scOLD_TMP_WRT_NUM");
	    	
	    	sQuery.append(" SELECT '0' AS CHECKER,TMP_WRT_NUM, SIDO_CODE, COMMANA_CLASS, MANA_NUM, ");
	    	sQuery.append(" NAME, REP_SSN1, REP_SSN2, REP_NM_KOR, REP_NM_HAN, REP_TEL_NUM, ");
	    	sQuery.append(" ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR, ADDR_TEL_NUM, ADDR_FAX_NUM, ");
	    	sQuery.append(" EMAIL_ADDR, OFFICE_AREA, OFFICE_USE_CODE, COMPANY_DIAG_CLASS_CODE, COMPANY_DIAG_BAS_DT, ");
	    	sQuery.append(" COMPANY_DIAG_ISSUE_DT, DIAG_ORG_CODE, DIAG_NM_NM, DIAG_NM_WRT_NUM, PAY_CAP, ");
	    	sQuery.append(" REA_CAP, TUP_AOM, TUP_CLASS_CODE, C_COM_DT, C_COM_CAUSE_CODE, COM_COV_DT, WRT_ID, ");
	    	sQuery.append(" UPD_DT, INS_DT, WRT_DT, BAS_STA_DT, OFFICE_OWN_CLASS, COI_WRT_NUM, REP_MOBILE, LICTAX, ");
	    	sQuery.append(" HOSCRE, SND_DT, SND_STE , COM_NUM , ADDR_TEL_NUM1, ADDR_TEL_NUM2, ADDR_TEL_NUM3, ADDR_FAX_NUM1, ");
	    	sQuery.append(" ADDR_FAX_NUM2, ADDR_FAX_NUM3, REP_MOBILE1, REP_MOBILE2, REP_MOBILE3,decode(GUBUN,null,1,1,1,2,2) GUBUN,BUSS_YMD,decode(FOREIGN_YN,null,'N','N','N','Y','Y') FOREIGN_YN ,REGIST_YMD ");
	    	sQuery.append(" FROM PT_R_COMPANY_MASTER ");
	    	sQuery.append(" WHERE 1 = 1 ");
	    	sQuery.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' " );
	    	sQuery.append(" AND ( TRANS_UNION_PROC IS NULL OR TRANS_UNION_PROC = 'N' OR TRANS_UNION_PROC = 'null')" );
	
	    	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	       	
	        scSIDO_CODE = rMasterEntity.getValue(0,"SIDO_CODE");
	        
	        /**
	         * 보유 기술자 정보 처리 
	         */
	        // 공사업 보유 기술자 PT_R_ENGINEER_CHANGE 사용
	       	rMasterEntity    = rDAO.select("SELECT  '0' AS CHECKER, '"+scRECV_NUM+"' AS RECV_NUM, 'U' AS ENG_PROC, ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  " +
	       			"EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT, SEQ, TMP_WRT_NUM, TMP_FIELD, " +
	       			"CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT,CARE_BOOK_VAL_START_DT1,CARE_BOOK_VAL_START_DT2, " +
	       			"CARE_BOOK_ISSUE_NUM,  ENGINEER_SSN1 || ENGINEER_SSN2 AS TMP_SSN, '' AS ENG_TARGET " +
	       			"FROM PT_R_ENGINEER_CHANGE WHERE RET_YMD IS NULL AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");	        	        
	        			
	        String[] sSSN = new String[rMasterEntity.getRowCnt()];
	       
	        if(rMasterEntity.getRowCnt() > 0){
	        	
		        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
		        {
		        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "TMP_SSN");
		        }
		        
		    	// 테스트용으로 시도가 tete 예외 처리를 위해 wbjeon 2010-08-25
		        if ("bsbs".equals(scSIDO_CODE)){
			        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
			    } else {	
			        Dataset ds = new Dataset("output2");
			        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
			        ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
			        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("REMARK",ColumnInfo.CY_COLINFO_STRING, 200);
					ds.addColumn("WRT_ID",ColumnInfo.CY_COLINFO_STRING, 16);
					ds.addColumn("UPD_DT",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("INS_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("TMP_FIELD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);					
					ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("CARE_BOOK_VAL_START_DT1",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("CARE_BOOK_VAL_START_DT2",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("TMP_SSN",ColumnInfo.CY_COLINFO_STRING, 30);
					ds.addColumn("RECV_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENG_PROC",ColumnInfo.CY_COLINFO_STRING, 2);
					ds.addColumn("ENG_TARGET",ColumnInfo.CY_COLINFO_STRING, 2);
							
					iccsSelectBySSN(dl, ds, sSSN, rMasterEntity, scRECV_NUM);
				    dl.addDataset(ds);
			    }
	        }
	        
	        /**
		     * 변경관리 변경순번 증감
		     */	        
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	//Company Change History
	        sQuery.append(" SELECT MAX(CHGBRE_SEQ) + 1 AS CHGBRE_SEQ, MAX(CHGBRE_SEQ) AS TMP_SEQ FROM PT_R_BASIC_CHANGE_HISTORY ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	        
	        /**
		     * 공사업 등록 (합병업체들) 
		     */		       	
		    sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
        	sQuery.append(" SELECT '0' AS CHECKER, UCB.* ");
        	sQuery.append(" FROM PT_R_UNION_COMPANY_BEFORE UCB ");
        	sQuery.append(" WHERE 1 = 1 ");
        	sQuery.append(" AND UCB.RECV_NUM = '" + scRECV_NUM + "' " );
        	//sQuery.append(" AND UCB.SIDO_CODE = '" + scSIDO_CODE + "' " );
        	
        	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");

    	} 
       // 대표자가 타업체 재직기술자 등록되면 안됨
        else if (sworkMODE.equalsIgnoreCase("REFER_DUPLICATE_CHECK"))
        {
        	/**
        	 * 사업자 구분 -> 법인:1, 개인:2, 기타:3
        	 */
        	String scCOM_CLASS = vl.getValueAsString("scCOM_CLASS");
        	
        	Dataset dsPT_R_REFFER = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
        	String scSSN_IN = "";
        	for(int i = 0; i < dsPT_R_REFFER.getRowCount(); i++ ) {
        		String posClass = dsPT_R_REFFER.getColumn( i, "POS_CLASS" ) + "";
        		
        		if (scCOM_CLASS.equals("1")){ 
        			if( !posClass.equals( "P4" ) )
        				continue;
        		} else if (!scCOM_CLASS.equals("1")){
        			if( !posClass.equals( "P1" ) && !posClass.equals( "P4" ) )
        				continue;
        		}
        		
        		String scSSN = dsPT_R_REFFER.getColumn( i, "SSN1" ) + "" + dsPT_R_REFFER.getColumn( i, "SSN2" );
        		scSSN_IN += "'" + scSSN + "', ";
        	}
        	if( scSSN_IN.length() > 0 ) {
        		scSSN_IN = scSSN_IN.substring( 0, scSSN_IN.length() - 2 );
        	
	        	sQuery.append(" SELECT R.TMP_WRT_NUM, R.ENGINEER_NM NM_KOR, C.SIDO_CODE, C.NAME  "); 
	        	sQuery.append(" FROM PT_R_ENGINEER_CHANGE_TEMP R ");
	        	sQuery.append(" LEFT OUTER JOIN PT_R_COMPANY_MASTER C ");
	        	sQuery.append(" ON R.TMP_WRT_NUM = C.TMP_WRT_NUM ");
		        sWhere.append(" WHERE 1 = 1 ");
		        sWhere.append(" AND R.RET_YMD IS NULL ");
		        sWhere.append(" AND R.RET_YMD IS NULL ");
		        sWhere.append(" AND (R.ENGINEER_SSN1 || R.ENGINEER_SSN2) IN (" + scSSN_IN + ")");
	        	sWhere.append(" AND C.TMP_WRT_NUM <> '" + scTMP_WRT_NUM + "'");
			
		       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		       	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        } // if( scSSN_IN.length() > 0 )
        }
        // 재직기술자가 타업체 대표자로 등록되면 안됨
        else if (sworkMODE.equalsIgnoreCase("ENGINEER_DUPLICATE_CHECK"))
        {
        	/**
        	 * 사업자 구분 법인:1, 개인:2, 기타:3
        	 */
        	String scCOM_CLASS = vl.getValueAsString("scCOM_CLASS");
        	
        	Dataset dsPT_R_ENGINEER_CHANGE_TEMP = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");
        	String scSSN_IN = "";
        	String scSSN = "";
        	for(int i = 0; i < dsPT_R_ENGINEER_CHANGE_TEMP.getRowCount(); i++ ) {
        		if (!scCOM_CLASS.equals("1")){ 
        			scSSN = dsPT_R_ENGINEER_CHANGE_TEMP.getColumn( i, "ENGINEER_SSN1" ) + "" + dsPT_R_ENGINEER_CHANGE_TEMP.getColumn( i, "ENGINEER_SSN2" );
        		}
        		scSSN_IN += "'" + scSSN + "', ";
        	}
        	if( scSSN_IN.length() > 0 ) {
        		scSSN_IN = scSSN_IN.substring( 0, scSSN_IN.length() - 2 );
        	
	        	sQuery.append(" SELECT R.TMP_WRT_NUM, R.NM_KOR, C.SIDO_CODE, C.NAME  "); 
	        	sQuery.append(" FROM PT_R_REFFER R ");
	        	sQuery.append(" LEFT OUTER JOIN PT_R_COMPANY_MASTER C ");
	        	sQuery.append(" ON R.TMP_WRT_NUM = C.TMP_WRT_NUM ");
		        sWhere.append(" WHERE 1 = 1 ");
		        sWhere.append(" AND R.RET_DT IS NULL ");
		        sWhere.append(" AND (R.SSN1 || R.SSN2) IN (" + scSSN_IN + ")");
		        sWhere.append(" AND C.TMP_WRT_NUM <> '" + scTMP_WRT_NUM + "'");
			
		       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		       	sQuery.delete(0, sQuery.length());
		       	sWhere.delete(0, sWhere.length());
		       	
		        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        } // if( scSSN_IN.length() > 0 )
        }
        else if(sworkMODE.equalsIgnoreCase("SEL_SUBSIDIARY")) //겹헙관리 상세보기        	
        {   
        	rDAO.execute("DELETE FROM PT_R_SUBSIDIARY_TEMP WHERE RECV_NUM = '"+ scRECV_NUM +"'");
        	
	        //dsPT_R_SUBSIDIARY
	        sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS SUB_NAME, '' AS RECV_NUM FROM PT_R_SUBSIDIARY AA ");
	        sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'SUBSIDIARY')BB ON AA.SUB_CODE = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());	       	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        	
        }
        else if(sworkMODE.equalsIgnoreCase("WORK_RES_CAP")) // 실적, 시공능력 백업처리를 하기 위해 조회        	
        {   
        	Dataset dsPT_R_UNION_COMPANY_BEFORE = pReq.getDatasetList().getDataset("dsPT_R_UNION_COMPANY_BEFORE");
        	
        	String TMP_WRT_NUM_KEY = "";
        	String TEMP = "";
        	
        	for (int i = 0; i < dsPT_R_UNION_COMPANY_BEFORE.getRowCount(); i++ ) 
        	{
        		String TEMP_WRT_NUM = ""+dsPT_R_UNION_COMPANY_BEFORE.getColumn(i, "TMP_WRT_NUM");
        		if ("0".equals(""+dsPT_R_UNION_COMPANY_BEFORE.getColumn(i, "PCOM_SELECT"))){        			
        			TEMP += "'" + TEMP_WRT_NUM + "',";	
        		}
        	}
        	
       		TMP_WRT_NUM_KEY = TEMP.substring(0,TEMP.length()-1);
        	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        	//dsPT_R_WORK_RESULTS
	        sQuery.append(" SELECT 'U' AS WORK_PROC, '"+scRECV_NUM+"' AS RECV_NUM, SEQ, YEAR, WORK_ROM, WRT_ID, UPD_DT, INS_DT, TMP_WRT_NUM ");
	        sQuery.append(" FROM PT_R_WORK_RESULTS ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM IN (" + TMP_WRT_NUM_KEY + ")");
	        sWhere.append(" ORDER BY TMP_WRT_NUM, SEQ");
	        		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());	       	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");

        	//dsPT_R_WORK_CAPABILITY
	        sQuery.append(" SELECT 'U' AS WORK_PROC, '"+scRECV_NUM+"' AS RECV_NUM, SEQ, TMP_WRT_NUM,COI_WRT_NUM" +
	        		", ASSE_DT, ASSE_AOM, APPL_TERM_START_DT, CONFIRM, WRT_ID, UPD_DT, INS_DT, APPL_TERM_END_DT, SEQ_LINK_CAPABILITY ");
	        sQuery.append(" FROM PT_R_WORK_CAPABILITY ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM IN (" + TMP_WRT_NUM_KEY + ")");
	        sWhere.append(" ORDER BY TMP_WRT_NUM, SEQ");
	        		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());	       	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
        	
        	Dataset ds_tmp = new Dataset("output3");
        	ds_tmp.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 256);
        	ds_tmp.addColumn("RECV_NUM",ColumnInfo.CY_COLINFO_STRING, 24);
            
	        int row = ds_tmp.appendRow();
	        ds_tmp.setColumn(row, "TMP_WRT_NUM", TMP_WRT_NUM_KEY);
	        ds_tmp.setColumn(row, "RECV_NUM", scRECV_NUM);
		    
            dl.addDataset(ds_tmp);
        	
        	
        }
        else if(sworkMODE.equalsIgnoreCase("UnionView")) //합병관리 상세보기
        {
	        //Company Master Table
	        //sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
           	/*sQuery.append(" SELECT '0' AS CHECKER,TMP_WRT_NUM, SIDO_CODE, decode(COMMANA_CLASS,null,1,1,2,2,3,3) COMMANA_CLASS, MANA_NUM, ");
	    	sQuery.append(" NAME, REP_SSN1, REP_SSN2, REP_NM_KOR, REP_NM_HAN, REP_TEL_NUM, ");
	    	sQuery.append(" ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR, ADDR_TEL_NUM, ADDR_FAX_NUM, ");
	    	sQuery.append(" EMAIL_ADDR, OFFICE_AREA, OFFICE_USE_CODE, COMPANY_DIAG_CLASS_CODE, COMPANY_DIAG_BAS_DT, ");
	    	sQuery.append(" COMPANY_DIAG_ISSUE_DT, DIAG_ORG_CODE, DIAG_NM_NM, DIAG_NM_WRT_NUM, PAY_CAP, ");
	    	sQuery.append(" REA_CAP, TUP_AOM, TUP_CLASS_CODE, C_COM_DT, C_COM_CAUSE_CODE, COM_COV_DT, WRT_ID, ");
	    	sQuery.append(" UPD_DT, INS_DT, WRT_DT, BAS_STA_DT, OFFICE_OWN_CLASS, COI_WRT_NUM, REP_MOBILE, LICTAX, ");
	    	sQuery.append(" HOSCRE, SND_DT, SND_STE , COM_NUM , ADDR_TEL_NUM1, ADDR_TEL_NUM2, ADDR_TEL_NUM3, ADDR_FAX_NUM1, ");
	    	sQuery.append(" ADDR_FAX_NUM2, ADDR_FAX_NUM3, REP_MOBILE1, REP_MOBILE2, REP_MOBILE3,decode(GUBUN,null,1,1,1,2,2,1) GUBUN,BUSS_YMD,decode(FOREIGN_YN,null,'N','N','N','Y','Y') FOREIGN_YN ,REGIST_YMD ");
	    	sQuery.append(" FROM PT_R_COMPANY_MASTER ");
	    	sQuery.append(" WHERE 1 = 1 ");
	    	sQuery.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' " );
        	*/
        	sQuery.append(" SELECT PT_C.* ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		   
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        
	       	//PT_R_BASIC_CHANGE_HISTORY
	        /*sQuery.append(" select TMP_WRT_NUM, SIDO_CODE, COMMANA_CLASS, MANA_NUM,  NAME, REP_SSN1, REP_SSN2, REP_NM_KOR, REP_NM_HAN, REP_TEL_NUM, ");
	        sQuery.append(" ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR, ADDR_TEL_NUM, ADDR_FAX_NUM,");
	        sQuery.append(" COMPANY_DIAG_ISSUE_DT, DIAG_ORG_CODE, DIAG_NM_NM, DIAG_NM_WRT_NUM, PAY_CAP, ");
	        sQuery.append(" REA_CAP, TUP_AOM, TUP_CLASS_CODE, C_COM_DT, C_COM_CAUSE_CODE, COM_COV_DT, WRT_ID,  ");
	        sQuery.append(" UPD_DT, INS_DT, WRT_DT, BAS_STA_DT, OFFICE_OWN_CLASS, COI_WRT_NUM, REP_MOBILE, LICTAX,   ");
	        sQuery.append(" HOSCRE, SND_DT, SND_STE , COM_NUM , ADDR_TEL_NUM1, ADDR_TEL_NUM2, ADDR_TEL_NUM3,   ");
	        sQuery.append(" ADDR_FAX_NUM1,  ADDR_FAX_NUM2, ADDR_FAX_NUM3, REP_MOBILE1, REP_MOBILE2, REP_MOBILE3,   ");
	        sQuery.append(" BUSS_YMD,REGIST_YMD,  decode(FOREIGN_YN,null,'N','N','N','Y','Y') FOREIGN_YN, decode(gubun,null,1,'본청',1,2,2,1) gubun  , PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_C ");
	        sQuery.append(" LEFT JOIN  (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");	        
	        sWhere.append(" AND PT_C.RECV_NUM = '" + scRECV_NUM + "'");
	        */
	        
	        sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");	        
	        sWhere.append(" AND PT_C.RECV_NUM = '" + scRECV_NUM + "'");
		  
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        
	        
	        //PT_R_REFER
	        sQuery.append(" SELECT '0' AS CHECKER, CONCAT(AA.SSN1, AA.SSN2) AS TMPSSN, AA.*, ");
	        sQuery.append(" DECODE(AA.POS_CLASS, 'P1', '대표이사', 'P2', '감사', 'P3', '이사', '대표자') AS POS_NAME ");
       		sQuery.append(" FROM PT_R_REFFER AA ");
	        
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
	        
	        
	        sQuery.append(" select RECV_NUM,SIDO_CODE,COI_WRT_NUM,MOT_STE,DEFI_STE,RECV_DT,RECV_TIME,PROC_LIM,PROC_TIME,  ");
	        sQuery.append(" MANA_NUM,NAME,REP_SSN1,REP_SSN2, REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,  ");
	        sQuery.append(" ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE,");
	        sQuery.append(" COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,");
	        sQuery.append(" DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM,TUP_CLASS_CODE,  ");
	        sQuery.append(" COM_COV_DT,BAS_STA_DT,OFFICE_OWN_CLASS,REP_MOBILE,LICTAX,HOSCRE,COM_NUM,");
	        sQuery.append(" DOC_CODE,OFFICE_USE_NAME,MEMO_CONT,WRT_ID,INS_DT,UPD_DT,TMP_WRT_NUM,");
	        sQuery.append(" WRT_DT,CHG_DT,CHGBRE_SEQ,COMPANY_DIAG_BAS_DT2,BUSS_YMD,");
	        sQuery.append(" REGIST_YMD,decode(FOREIGN_YN,null,'N','N','N','Y','Y') FOREIGN_YN, decode(COMMANA_CLASS,null,1,1,1,2,2,3,3) COMMANA_CLASS,decode(gubun,null,1,'본청',1,2,2,1) gubun");
	        sQuery.append(" FROM PT_R_M_UNION_STATEMENT ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND RECV_NUM = '" + scRECV_NUM + "'");
	        sWhere.append(" AND SIDO_CODE = '" + scSIDO_CODE + "'");
	        
	       /* sQuery.append(" SELECT * ");
	        sQuery.append(" FROM PT_R_M_UNION_STATEMENT ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND RECV_NUM = '" + scRECV_NUM + "'");
	        sWhere.append(" AND SIDO_CODE = '" + scSIDO_CODE + "'");
		*/
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       		       	
	       	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output8");
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	String sSeq = KJFUtil.print(rMasterEntity.getValue(0, "CHGBRE_SEQ"),"0");
	       	
	       	
	        //PT_R_REFUSAL_REASON
	        sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS REFUSAL_DIV_NAME ");
	        sQuery.append(" FROM PT_R_REFUSAL_REASON AA LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE  ");
	        sQuery.append(" WHERE P_CODE = 'REGCANCEL') BB ON AA.REFS_ITEM = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND AA.CHGBRE_SEQ = '" + sSeq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	        	        
	        //dsPT_R_SUBSIDIARY
	        sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS SUB_NAME FROM PT_R_SUBSIDIARY_TEMP AA ");
	        sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'SUBSIDIARY')BB ON AA.SUB_CODE = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.RECV_NUM = '" + scRECV_NUM + "'");
	        		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());	       	
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
        	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
	       	
	        //dsPT_R_COM_DEFICIT
	        sQuery.append(" SELECT AA.*, BB.CONT AS DEFI_CONT FROM PT_R_COM_DEFICIT AA LEFT JOIN ");
	        sQuery.append(" (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE ");
	        sQuery.append(" WHERE DEFI_GROUP = 'CRRS') BB ON AA.DEFI_CODE = BB.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND AA.CHGBRE_SEQ = '" + sSeq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output7");

	       	//dsPT_R_COM_DEFICIT
	        sQuery.append(" SELECT * FROM PT_R_MOT_STE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND RECV_NUM = '" + scRECV_NUM + "'");
	        sWhere.append(" AND MOT_PROC = 'U'");
	        sWhere.append(" AND SIDO_CODE = '" + scSIDO_CODE + "'");

	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output9");
	       	
	        
	        
	        sQuery.append(" SELECT '0' AS CHECKER, UCB.TMP_WRT_NUM, UCB.SIDO_CODE, UCB.COMMANA_CLASS, UCB.MANA_NUM, UCB.NAME, UCB.REP_SSN1, UCB.REP_SSN2, ");
	        sQuery.append(" UCB.REP_NM_KOR, UCB.REP_NM_HAN, UCB.REP_TEL_NUM, UCB.ADDR_POST_NUM, UCB.ADDR_ADDR, UCB.ADDR_DETAIL_ADDR, UCB.ADDR_TEL_NUM, ");
	        sQuery.append(" UCB.ADDR_FAX_NUM, UCB.EMAIL_ADDR, UCB.OFFICE_AREA, UCB.OFFICE_USE_CODE, UCB.COMPANY_DIAG_CLASS_CODE, UCB.COMPANY_DIAG_BAS_DT, ");
	        sQuery.append(" UCB.COMPANY_DIAG_ISSUE_DT, UCB.DIAG_ORG_CODE, UCB.DIAG_NM_NM, UCB.DIAG_NM_WRT_NUM, UCB.PAY_CAP, UCB.REA_CAP, UCB.TUP_AOM, UCB.TUP_CLASS_CODE, ");
	        sQuery.append(" UCB.C_COM_DT, UCB.C_COM_CAUSE_CODE, UCB.COM_COV_DT, UCB.WRT_ID, UCB.UPD_DT, UCB.INS_DT, UCB.WRT_DT, UCB.BAS_STA_DT, UCB.OFFICE_OWN_CLASS, ");
	        sQuery.append(" UCB.COI_WRT_NUM, UCB.REP_MOBILE, UCB.LICTAX, UCB.HOSCRE, UCB.SND_DT, UCB.SND_STE, UCB.COM_NUM, UCB.ADDR_TEL_NUM1,UCB.ADDR_TEL_NUM2, UCB.ADDR_TEL_NUM3, ");
	        sQuery.append(" UCB.ADDR_FAX_NUM1, UCB.ADDR_FAX_NUM2, UCB.ADDR_FAX_NUM3, REP_MOBILE1, REP_MOBILE2, REP_MOBILE3, UCB.RECV_NUM,UCB.BUSS_YMD,UCB.FOREIGN_YN,UCB.REGIST_YMD, ");
	        sQuery.append(" UCB.CHGBRE_SEQ,(SELECT COUNT(*) FROM PT_R_M_UNION_STATEMENT MU WHERE UCB.RECV_NUM = MU.RECV_NUM AND UCB.SIDO_CODE = MU.SIDO_CODE AND UCB.TMP_WRT_NUM =  MU.TMP_WRT_NUM)  AS PCOM_SELECT ");  
	        sWhere.append(" FROM PT_R_UNION_COMPANY_BEFORE UCB ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND UCB.RECV_NUM = '" + scRECV_NUM + "' " );
	       // sWhere.append(" AND UCB.SIDO_CODE = '" + scSIDO_CODE + "'");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       		       	
	       	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output10");
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());

	        //Deficit Table
	        sQuery.append(" SELECT PDEF.*, PDEF_CODE.CONT AS DEFI_CONT FROM PT_R_DEFICIT PDEF LEFT JOIN ");
	        sQuery.append(" (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE WHERE DEFI_GROUP = 'GUBU') ");
	        sQuery.append(" PDEF_CODE  ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PDEF.DEFI_PROC = 'U'");
	        sWhere.append(" AND PDEF.RECV_NUM = '" + scRECV_NUM + "' ");
	        sWhere.append(" AND	PDEF.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	        
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       		       	
	       	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output11");
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());

	    	//Deficit Codes Table
	    	sQuery.append(" SELECT * ");
	    	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
	    	sQuery.append(" WHERE DEFI_GROUP = 'GUBU' ");
	
	    	rMasterEntity    = rDAO.select(sQuery.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output12");
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	        sQuery.append(" SELECT  '0' AS CHECKER, ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  EMPL_YMD, RET_YMD, REMARK, " +
	        		"WRT_ID, UPD_DT, INS_DT, SEQ, TMP_WRT_NUM, TMP_FIELD,  CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, " +
	        		"CARE_BOOK_ISSUE_NUM, CARE_BOOK_VAL_START_DT1, CARE_BOOK_VAL_START_DT2,  " +
	        		"ENGINEER_SSN1 || ENGINEER_SSN2 AS TMP_SSN, RECV_NUM, " +
	        		"ENG_PROC, ENG_TARGET ");	        
	        sQuery.append(" FROM PT_R_ENGINEER_CHANGE_TEMP");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND RECV_NUM = '" + scRECV_NUM + "' ");
	        sWhere.append(" AND ENG_PROC = 'U' ");	        
	        sWhere.append(" AND RET_YMD IS NULL ");
	        sWhere.append(" ORDER BY ENGINEER_SSN1 ASC ");
	        
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
			
			if (rMasterEntity.getRowCnt() != 0 && rMasterEntity != null){
		        String[] sSSN = new String[rMasterEntity.getRowCnt()];
		        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
		        {
		        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "TMP_SSN");
		        }
		        
		    	// 테스트용으로 시도가 tete 예외 처리를 위해 wbjeon 2010-08-25
		        if ("bsbs".equals(scSIDO_CODE)){
			           KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
			    } else {	
			        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	    	        Dataset ds = new Dataset("output4");
			        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);			        
			        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("REMARK",ColumnInfo.CY_COLINFO_STRING, 200);
					ds.addColumn("WRT_ID",ColumnInfo.CY_COLINFO_STRING, 16);
					ds.addColumn("UPD_DT",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("INS_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("TMP_FIELD",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);					
					ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("CARE_BOOK_VAL_START_DT1",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("CARE_BOOK_VAL_START_DT2",ColumnInfo.CY_COLINFO_STRING, 24);
					ds.addColumn("TMP_SSN",ColumnInfo.CY_COLINFO_STRING, 30);
					ds.addColumn("RECV_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
					ds.addColumn("ENG_PROC",ColumnInfo.CY_COLINFO_STRING, 2);
					ds.addColumn("ENG_TARGET",ColumnInfo.CY_COLINFO_STRING, 2);//					
	    			iccsSelectBySSN(dl, ds, sSSN, rMasterEntity, scRECV_NUM);
				    dl.addDataset(ds);
			    }		    

			}

        }

        request.setAttribute("dl", dl);  

        return next;
    }
    
    private String getMaxChangeSeq(String sKEY, String sTABLE) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(SEQ)), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
    
    private void iccsSelectBySSN(DatasetList dl, Dataset ds, String[] sSSN, ReportEntity ent, String RECV_NUM) throws Exception
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	KengWorker kWorker = new KengWorker();
   		Kengineer kengs[]= kWorker.getKengs(sSSN);
   		
   		if( kengs == null )
  			return;
   		
   		for(int i=0; i < kengs.length;i++ )
   		{
            Kengineer keng = kengs[i];
            String NM_KOR  =   keng.getNM_KOR();    
            String SSN        =   keng.getSSN();          
            String GRADE     =   keng.getGRADE();      
            String TMP_GRADE=   keng.getTMP_GRADE(); 
            String BOOK_NUM         =   keng.getBOOK_NUM();  
            String EDU_DT    =   keng.getEDU_DT();    
            String S_DT       =   keng.getS_DT();        
            String E_DT       =   keng.getE_DT();        
            String CORP      =   keng.getCORP();
            
            // 협회 쿼리 후, 인덱스가 동일하게 온다는 보장이 없다.
            int myIdx = -1;
            for( myIdx = 0; myIdx < ent.getRowCnt(); myIdx++ ) {
            	if( ent.getValue(myIdx, "TMP_SSN").equals( SSN ) )
            		break;
            }
            if( myIdx < 0 )
            	continue;
            
            String EMPL_YMD = ent.getValue(myIdx, "EMPL_YMD");
            String RET_YMD = ent.getValue(myIdx, "RET_YMD");
            String TMP_WRT_NUM = ent.getValue(myIdx, "TMP_WRT_NUM");
            String SEQ = ent.getValue(myIdx, "SEQ");
            String REMARK = ent.getValue( myIdx, "REMARK" );
            
            if (S_DT != null && S_DT.length() > 10)
            	S_DT = S_DT.substring(0, 10).replaceAll("-", "");
            
            if (E_DT != null && E_DT.length() > 10)
            	E_DT = E_DT.substring(0, 10).replaceAll("-", "");
            
            sQuery.delete(0, sQuery.length());
            sWhere.delete(0, sWhere.length());
            
            /*
            sQuery.append(" SELECT NAME FROM PT_R_COMPANY_MASTER ");
            sWhere.append(" WHERE COI_WRT_NUM = '" + CORP + "' ");
            sWhere.append(" AND C_COM_DT IS NULL ");
            
            rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            */
            int row = ds.appendRow();
            ds.setColumn(row, "CHECKER", "0");
            ds.setColumn(row, "ENGINEER_NM", NM_KOR);
            ds.setColumn(row, "ENGINEER_SSN1", SSN.substring(0, 6));
            ds.setColumn(row, "ENGINEER_SSN2", SSN.substring(6, SSN.length()));            
            ds.setColumn(row, "EMPL_YMD", EMPL_YMD);
            ds.setColumn(row, "RET_YMD", RET_YMD);
            ds.setColumn( row, "REMARK", REMARK );
            ds.setColumn( row, "WRT_ID", "admin" );
            ds.setColumn( row, "UPD_DT", "" );
            ds.setColumn( row, "INS_DT", "" );
            ds.setColumn(row, "SEQ", SEQ);
            ds.setColumn(row, "TMP_WRT_NUM", TMP_WRT_NUM);            
            ds.setColumn(row, "CARE_BOOK_VAL_START_DT", S_DT);
            ds.setColumn(row, "CARE_BOOK_VAL_END_DT", E_DT);
            ds.setColumn(row, "ISSUE_DT", "");
            ds.setColumn(row, "CARE_BOOK_ISSUE_NUM", BOOK_NUM);
            ds.setColumn(row, "CARE_BOOK_VAL_START_DT1", "");
            ds.setColumn(row, "CARE_BOOK_VAL_START_DT2", "");
            ds.setColumn(row, "TMP_FIELD", TMP_GRADE);
            ds.setColumn(row, "TMP_SSN", SSN);
            ds.setColumn(row, "RECV_NUM", RECV_NUM);
            ds.setColumn(row, "ENG_PROC", "U");
            ds.setColumn(row, "ENG_TARGET", "");
   		}
 	
    }
}