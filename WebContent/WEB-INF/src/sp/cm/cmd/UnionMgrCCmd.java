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

public class UnionMgrCCmd<PT_R_DOC_NUM> implements KJFCommand {
	
    private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    PT_R_WORK_RESULTSDAO PT_R_WORK_RESULTSdao = new PT_R_WORK_RESULTSDAO();
    PT_R_WORK_RESULTSEntity PT_R_WORK_RESULTSEnt = new PT_R_WORK_RESULTSEntity();
    
    PT_R_WORK_CAPABILITYDAO PT_R_WORK_CAPABILITYdao = new PT_R_WORK_CAPABILITYDAO();
    PT_R_WORK_CAPABILITYEntity PT_R_WORK_CAPABILITYEnt = new PT_R_WORK_CAPABILITYEntity();
    
    public UnionMgrCCmd() {
    }

    public UnionMgrCCmd(String next_url) {
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
        
        if (sworkMODE.equalsIgnoreCase("RECV_NUM"))
        {
        	String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        	String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        	
        	sQuery.append(" SELECT PT_U.*, PT_C1.COI_WRT_NUM AS A_COI_WRT_NUM, PT_C1.NAME AS A_NAME, PT_C1.TMP_WRT_NUM AS A_TMP_WRT_NUM, ");
        	sQuery.append(" PT_C1.REP_NM_KOR AS A_REP_NM_KOR, PT_C1.ADDR_TEL_NUM AS A_ADDR_TEL_NUM, ");
        	sQuery.append(" PT_C1.MANA_NUM AS A_MANA_NUM, PT_C1.ADDR_ADDR AS A_ADDR_ADDR, PT_C1.ADDR_POST_NUM AS A_ADDR_POST_NUM, ");
        	sQuery.append(" PT_C1.ADDR_DETAIL_ADDR AS A_ADDR_DETAIL_ADDR, PT_C3.TMP_WRT_NUM, ");
        	sQuery.append(" PT_C2.COI_WRT_NUM AS H_COI_WRT_NUM, PT_C2.NAME AS H_NAME, PT_C2.TMP_WRT_NUM AS H_TMP_WRT_NUM, ");
        	sQuery.append(" PT_C2.REP_NM_KOR AS H_REP_NM_KOR, PT_C2.ADDR_TEL_NUM AS H_ADDR_TEL_NUM, ");
        	sQuery.append(" PT_C2.MANA_NUM AS H_MANA_NUM, PT_C2.ADDR_ADDR AS H_ADDR_ADDR, PT_C2.ADDR_POST_NUM AS H_ADDR_POST_NUM, ");
        	sQuery.append(" PT_C2.ADDR_DETAIL_ADDR AS H_ADDR_DETAIL_ADDR ");
        	sQuery.append(" FROM PT_R_UNION_STATEMENT PT_U LEFT JOIN PT_R_COMPANY_MASTER PT_C1 ON PT_U.ASC_TMP_WRT_NUM = PT_C1.TMP_WRT_NUM ");
        	sQuery.append(" LEFT JOIN PT_R_COMPANY_MASTER PT_C2 ON PT_U.HANDED_TMP_WRT_NUM = PT_C2.TMP_WRT_NUM ");
        	sQuery.append(" LEFT JOIN PT_R_COMPANY_MASTER PT_C3 ON PT_U.ESTA_WRT_NUM = PT_C3.COI_WRT_NUM AND PT_U.ESTA_MANA_NUM = PT_C3.MANA_NUM ");
        	
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_U.RECV_NUM = '" + scRECV_NUM + "'");
	        sWhere.append(" AND PT_U.SIDO_CODE = '" + scSIDO_CODE + "'");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if (sworkMODE.equalsIgnoreCase("REFER_CHECK"))
        {
        	String scCOM_NUM = vl.getValueAsString("scCOM_NUM");
        	String scSSN1 = vl.getValueAsString("scSSN1");
        	String scSSN2 = vl.getValueAsString("scSSN2");
        	
        	sQuery.append(" SELECT BB.NM_KOR, BB.ENT_DT, BB.RET_DT, AA.TMP_WRT_NUM "); 
        	sQuery.append(" FROM PT_R_COMPANY_MASTER AA LEFT JOIN PT_R_REFFER BB ON AA.TMP_WRT_NUM = BB.TMP_WRT_NUM ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND ROWNUM = 1 ");
	        //sWhere.append(" AND RTRIM(AA.COM_NUM) != '" + scCOM_NUM + "'");
	        sWhere.append(" AND BB.SSN1 = '" + scSSN1 + "'");
	        sWhere.append(" AND BB.SSN2 = '" + scSSN2 + "'");
	        sWhere.append(" ORDER BY BB.ENT_DT DESC ");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if (sworkMODE.equalsIgnoreCase("ENGINEER_CHECK"))
        {
        	String scSSN = vl.getValueAsString("scSSN");
        	String scNM_KOR = vl.getValueAsString("scNM_KOR");

        	// 2010.01.14. PT_R_ENGINEER_MASTER 사용안함.
			sQuery.append(" SELECT '0' AS CHECKER, ");
			sQuery.append(" ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  ");
			sQuery.append(" EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT,  ");
			sQuery.append(" SEQ, TMP_WRT_NUM, TMP_FIELD,  ");
			sQuery.append(" CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM, ");
			sQuery.append(" ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS ENGINEER_SSN, TMP_FIELD AS TMP_GRADE ");
			sQuery.append(" FROM PT_R_ENGINEER_CHANGE ");
        	sWhere.append(" WHERE 1 = 1 ");
        	if (!KJFUtil.isEmpty(scSSN))
        		sWhere.append(" AND ENGINEER_SSN1 || ENGINEER_SSN2 = '" + scSSN + "' ");
        	if (!KJFUtil.isEmpty(scNM_KOR))
        		sWhere.append(" AND	  RTRIM(ENGINEER_NM) = '" + scNM_KOR + "' ");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        }
        else if (sworkMODE.equalsIgnoreCase("GET_CORP"))
        {
        	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
	        
	       	//Company Master Table
	        sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");      
       
	       	//Company Change History
	        sQuery.append(" SELECT MAX(CHGBRE_SEQ) + 1 AS CHGBRE_SEQ, MAX(CHGBRE_SEQ) AS TMP_SEQ FROM PT_R_BASIC_CHANGE_HISTORY ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        
	        //Change Seq
	        String sSeq = rMasterEntity.getValue(0, "TMP_SEQ");
	        
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
	        
	        //dsPT_R_SUBSIDIARY
	        sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS SUB_NAME FROM PT_R_SUBSIDIARY AA ");
	        sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'SUBSIDIARY')BB ON AA.SUB_CODE = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        
	        sQuery.append(" SELECT * FROM PT_R_DEFICIT_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND DEFI_GROUP = 'DRBC' ");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
	        
	        //PT_R_ENGINEER_CHANGE
	        // 2010.01.14. PT_R_ENGINEER_MASTER 사용안함.
	        
	        rMasterEntity    = rDAO.select("SELECT '0' AS CHECKER, TMP_WRT_NUM, SEQ, ENGINEER_SSN1 || ENGINEER_SSN2 AS SSN, EMPL_YMD, RET_YMD, REMARK FROM PT_R_ENGINEER_CHANGE WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");	        
	        
	        String[] sSSN = new String[rMasterEntity.getRowCnt()];
	       
	        if(rMasterEntity.getRowCnt() > 0){
		        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
		        {
		        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "SSN");
		        }
		        Dataset ds = new Dataset("output2");
		        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
		        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_SSN",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("TMP_FIELD",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("REMARK",ColumnInfo.CY_COLINFO_STRING, 200);
				
				iccsSelectBySSN(dl, ds, sSSN, rMasterEntity);
				dl.addDataset(ds);
	        }
        }
        else if (sworkMODE.equalsIgnoreCase("ASSI_RESULT"))
        {
        	String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        	String scTMP_WRT_NUM1 = vl.getValueAsString("scTMP_WRT_NUM1");
        	String scTMP_WRT_NUM2 = vl.getValueAsString("scTMP_WRT_NUM2");
        	
        	String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        	
        	ReportEntity ent1 = new ReportEntity();
        	ReportEntity ent2 = new ReportEntity();
        	       	
        	sQuery.append(" SELECT * FROM PT_R_WORK_RESULTS ");
        	sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM1 + "' ");
        	ent1 = rDAO.select(sQuery.toString() + sWhere.toString());
        	
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
        	
        	sQuery.append(" SELECT * FROM PT_R_WORK_RESULTS ");
        	sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM2 + "' ");
        	ent2 = rDAO.select(sQuery.toString() + sWhere.toString());
        	
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
        	
        	if(scTMP_WRT_NUM.equalsIgnoreCase(scTMP_WRT_NUM1))
        	{
        		for (int nLoop = 0; nLoop < ent2.getRowCnt(); nLoop++)
            	{
	        		PT_R_WORK_RESULTSEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_RESULTSEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_RESULTS"));
	        		PT_R_WORK_RESULTSEnt.setYEAR(ent2.getValue(nLoop, "YEAR"));
	        		PT_R_WORK_RESULTSEnt.setWORK_ROM(ent2.getValue(nLoop, "WORK_ROM"));
	        		PT_R_WORK_RESULTSEnt.setWRT_ID("admin");
	        		PT_R_WORK_RESULTSEnt.setINS_DT(KJFDate.getCurDatetime());
	            	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString());
	            	PT_R_WORK_RESULTSdao.insert(PT_R_WORK_RESULTSEnt);
            	}
        	}
        	else if(scTMP_WRT_NUM.equalsIgnoreCase(scTMP_WRT_NUM2))
        	{
        		for (int nLoop = 0; nLoop < ent1.getRowCnt(); nLoop++)
            	{
	        		PT_R_WORK_RESULTSEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_RESULTSEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_RESULTS"));
	        		PT_R_WORK_RESULTSEnt.setYEAR(ent1.getValue(nLoop, "YEAR"));
	        		PT_R_WORK_RESULTSEnt.setWORK_ROM(ent1.getValue(nLoop, "WORK_ROM"));
	        		PT_R_WORK_RESULTSEnt.setWRT_ID("admin");
	        		PT_R_WORK_RESULTSEnt.setINS_DT(KJFDate.getCurDatetime());
	            	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString());
	            	PT_R_WORK_RESULTSdao.insert(PT_R_WORK_RESULTSEnt);
            	}
        	}
        	else
        	{
        		for (int nLoop = 0; nLoop < ent1.getRowCnt(); nLoop++)
            	{
	        		PT_R_WORK_RESULTSEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_RESULTSEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_RESULTS"));
	        		PT_R_WORK_RESULTSEnt.setYEAR(ent1.getValue(nLoop, "YEAR"));
	        		PT_R_WORK_RESULTSEnt.setWORK_ROM(ent1.getValue(nLoop, "WORK_ROM"));
	        		PT_R_WORK_RESULTSEnt.setWRT_ID("admin");
	        		PT_R_WORK_RESULTSEnt.setINS_DT(KJFDate.getCurDatetime());
	            	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString());
	            	PT_R_WORK_RESULTSdao.insert(PT_R_WORK_RESULTSEnt);
            	}
        		
        		for (int nLoop = 0; nLoop < ent2.getRowCnt(); nLoop++)
            	{
	        		PT_R_WORK_RESULTSEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_RESULTSEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_RESULTS"));
	        		PT_R_WORK_RESULTSEnt.setYEAR(ent2.getValue(nLoop, "YEAR"));
	        		PT_R_WORK_RESULTSEnt.setWORK_ROM(ent2.getValue(nLoop, "WORK_ROM"));
	        		PT_R_WORK_RESULTSEnt.setWRT_ID("admin");
	        		PT_R_WORK_RESULTSEnt.setINS_DT(KJFDate.getCurDatetime());
	            	KJFLog.debug(PT_R_WORK_RESULTSEnt.toString());
	            	PT_R_WORK_RESULTSdao.insert(PT_R_WORK_RESULTSEnt);
            	}
        	}
        	
        	// 
        	sQuery.append(" SELECT * FROM pt_r_work_capability ");
        	sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM1 + "' ");
        	ent1 = rDAO.select(sQuery.toString() + sWhere.toString());
        	
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
        	
        	sQuery.append(" SELECT * FROM pt_r_work_capability ");
        	sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM2 + "' ");
        	ent2 = rDAO.select(sQuery.toString() + sWhere.toString());
        	
        	sQuery.delete(0, sQuery.length());
        	sWhere.delete(0, sWhere.length());
        	
        	if(scTMP_WRT_NUM.equalsIgnoreCase(scTMP_WRT_NUM1))
        	{
        		for (int nLoop = 0; nLoop < ent2.getRowCnt(); nLoop++)
            	{
	        		PT_R_WORK_CAPABILITYEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_CAPABILITY"));
	        		PT_R_WORK_CAPABILITYEnt.setCOI_WRT_NUM(scCOI_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setASSE_DT( ent2.getValue(nLoop, "ASSE_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setASSE_AOM( ent2.getValue(nLoop, "ASSE_AOM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_START_DT( ent2.getValue(nLoop, "APPL_TERM_START_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setCONFIRM( ent2.getValue(nLoop, "CONFIRM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_END_DT( ent2.getValue(nLoop, "APPL_TERM_END_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setWRT_ID("admin");
	        		PT_R_WORK_CAPABILITYEnt.setINS_DT(KJFDate.getCurDatetime());
	            	KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString());
	            	PT_R_WORK_CAPABILITYdao.insert(PT_R_WORK_CAPABILITYEnt);
            	}
        	}
        	else if(scTMP_WRT_NUM.equalsIgnoreCase(scTMP_WRT_NUM2))
        	{
        		for (int nLoop = 0; nLoop < ent1.getRowCnt(); nLoop++)
            	{
        			PT_R_WORK_CAPABILITYEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
        			PT_R_WORK_CAPABILITYEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_CAPABILITY"));
	        		PT_R_WORK_CAPABILITYEnt.setCOI_WRT_NUM(scCOI_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setASSE_DT( ent1.getValue(nLoop, "ASSE_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setASSE_AOM( ent1.getValue(nLoop, "ASSE_AOM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_START_DT( ent1.getValue(nLoop, "APPL_TERM_START_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setCONFIRM( ent1.getValue(nLoop, "CONFIRM"));
	        		PT_R_WORK_CAPABILITYEnt.setINS_DT(KJFDate.getCurDatetime());
	        		KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString());
	        		PT_R_WORK_CAPABILITYdao.insert(PT_R_WORK_CAPABILITYEnt);
            	}
        	}
        	else
        	{
        		for (int nLoop = 0; nLoop < ent1.getRowCnt(); nLoop++)
            	{
        			PT_R_WORK_CAPABILITYEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_CAPABILITY"));
	        		PT_R_WORK_CAPABILITYEnt.setCOI_WRT_NUM(scCOI_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setASSE_DT( ent1.getValue(nLoop, "ASSE_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setASSE_AOM( ent1.getValue(nLoop, "ASSE_AOM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_START_DT( ent1.getValue(nLoop, "APPL_TERM_START_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setCONFIRM( ent1.getValue(nLoop, "CONFIRM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_END_DT( ent1.getValue(nLoop, "APPL_TERM_END_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setINS_DT(KJFDate.getCurDatetime());
	        		KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString());
	        		PT_R_WORK_CAPABILITYdao.insert(PT_R_WORK_CAPABILITYEnt);
            	}
        		
        		for (int nLoop = 0; nLoop < ent2.getRowCnt(); nLoop++)
            	{
        			PT_R_WORK_CAPABILITYEnt.setTMP_WRT_NUM(scTMP_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setSEQ(getMaxChangeSeq(scTMP_WRT_NUM, "PT_R_WORK_CAPABILITY"));
	        		PT_R_WORK_CAPABILITYEnt.setCOI_WRT_NUM(scCOI_WRT_NUM);
	        		PT_R_WORK_CAPABILITYEnt.setASSE_DT( ent2.getValue(nLoop, "ASSE_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setASSE_AOM( ent2.getValue(nLoop, "ASSE_AOM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_START_DT( ent2.getValue(nLoop, "APPL_TERM_START_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setCONFIRM( ent2.getValue(nLoop, "CONFIRM"));
	        		PT_R_WORK_CAPABILITYEnt.setAPPL_TERM_END_DT( ent2.getValue(nLoop, "APPL_TERM_END_DT"));
	        		PT_R_WORK_CAPABILITYEnt.setINS_DT(KJFDate.getCurDatetime());
	        		KJFLog.debug(PT_R_WORK_CAPABILITYEnt.toString());
	        		PT_R_WORK_CAPABILITYdao.insert(PT_R_WORK_CAPABILITYEnt);
            	}
        	}
        }
        else
        {
	        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
	        String scREC_NUM = vl.getValueAsString("scRECV_NUM");
	        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
	        
	       	//Company Master Table
	        sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
	        
	       	//Company Change History        
	        sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND PT_C.RECV_NUM = '" + scREC_NUM + "'");

	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        
	        //Change Seq
	        String sSeq = rMasterEntity.getValue(0, "CHGBRE_SEQ");

	        // 테스트용으로 시도가 tete 예외 처리를 위해 wbjeon 2010-08-25
	        String rscSIDO_CODE = rMasterEntity.getValue(0, "SIDO_CODE");

	        //PT_R_REFER
	        sQuery.append(" SELECT '0' AS CHECKER, CONCAT(AA.SSN1, AA.SSN2) AS TMPSSN, AA.* FROM PT_R_REFFER AA ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output8");
	        
	        //PT_R_REG_MEMO
	        sQuery.append(" SELECT '0' AS CHECKER, AA.* FROM PT_R_REG_MEMO AA ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND AA.CHGBRE_SEQ = '" + sSeq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output9");
	    
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
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output10");
	        
	        //dsPT_R_SUBSIDIARY
	        sQuery.append(" SELECT '0' AS CHECKER, AA.*, BB.CODE_NAME AS SUB_NAME FROM PT_R_SUBSIDIARY AA ");
	        sQuery.append(" LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'SUBSIDIARY')BB ON AA.SUB_CODE = BB.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output11");
	        
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
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output12");
	        
	        //dsPT_R_UNION_STATEMENT
	        /*
	        sQuery.append(" SELECT '0' AS CHECKER, PT_U.RECV_NUM, PT_U.PROC_LIM, ");
        	sQuery.append(" PT_C1.NAME  AS A_COMPANY, PT_C2.NAME AS P_COMPANY, PT_H.MOT_STE, ");
        	sQuery.append(" PT_U.INS_DT, PT_U.ESTA_NAME AS E_COMPANY");    	
        	sQuery.append(" FROM PT_R_UNION_STATEMENT PT_U LEFT JOIN PT_R_COMPANY_MASTER PT_C1");
        	sQuery.append(" ON PT_U.ASC_TMP_WRT_NUM = PT_C1.TMP_WRT_NUM");
        	sQuery.append(" LEFT JOIN PT_R_COMPANY_MASTER PT_C2");
        	sQuery.append(" ON PT_U.HANDED_TMP_WRT_NUM = PT_C2.TMP_WRT_NUM");
        	sQuery.append(" LEFT JOIN PT_R_BASIC_CHANGE_HISTORY PT_H ON PT_U.RECV_NUM = PT_H.RECV_NUM");
        	
        	sWhere.append(" WHERE 1 = 1 ");        	
       		sWhere.append(" AND PT_U.RECV_NUM = '" + scREC_NUM + "' ");
       		sWhere.append(" AND PT_U.SIDO_CODE = '" + scSIDO_CODE + "' ");
        	//sWhere.append(" GROUP BY PT_U.RECV_NUM, PT_U.PROC_LIM, PT_C1.NAME, PT_C2.NAME, PT_U.INS_DT, PT_U.ESTA_NAME, PT_H.MOT_STE ");
        	*/
	        sQuery.append(" SELECT PT_U.*, PT_C1.COI_WRT_NUM AS A_COI_WRT_NUM, PT_C1.NAME AS A_NAME, PT_C1.TMP_WRT_NUM AS A_TMP_WRT_NUM, ");
        	sQuery.append(" PT_C1.REP_NM_KOR AS A_REP_NM_KOR, PT_C1.ADDR_TEL_NUM AS A_ADDR_TEL_NUM, ");
        	sQuery.append(" PT_C1.MANA_NUM AS A_MANA_NUM, PT_C1.ADDR_ADDR AS A_ADDR_ADDR, PT_C1.ADDR_POST_NUM AS A_ADDR_POST_NUM, ");
        	sQuery.append(" PT_C1.ADDR_DETAIL_ADDR AS A_ADDR_DETAIL_ADDR, PT_C3.TMP_WRT_NUM, ");
        	sQuery.append(" PT_C2.COI_WRT_NUM AS H_COI_WRT_NUM, PT_C2.NAME AS H_NAME, PT_C2.TMP_WRT_NUM AS H_TMP_WRT_NUM, ");
        	sQuery.append(" PT_C2.REP_NM_KOR AS H_REP_NM_KOR, PT_C2.ADDR_TEL_NUM AS H_ADDR_TEL_NUM, ");
        	sQuery.append(" PT_C2.MANA_NUM AS H_MANA_NUM, PT_C2.ADDR_ADDR AS H_ADDR_ADDR, PT_C2.ADDR_POST_NUM AS H_ADDR_POST_NUM, ");
        	sQuery.append(" PT_C2.ADDR_DETAIL_ADDR AS H_ADDR_DETAIL_ADDR ");
        	sQuery.append(" FROM PT_R_UNION_STATEMENT PT_U LEFT JOIN PT_R_COMPANY_MASTER PT_C1 ON PT_U.ASC_TMP_WRT_NUM = PT_C1.TMP_WRT_NUM ");
        	sQuery.append(" LEFT JOIN PT_R_COMPANY_MASTER PT_C2 ON PT_U.HANDED_TMP_WRT_NUM = PT_C2.TMP_WRT_NUM ");
        	sQuery.append(" LEFT JOIN PT_R_COMPANY_MASTER PT_C3 ON PT_U.ESTA_WRT_NUM = PT_C3.COI_WRT_NUM ");
		
        	sWhere.append(" WHERE 1 = 1 ");        	
       		sWhere.append(" AND PT_U.RECV_NUM = '" + scREC_NUM + "' ");
       		sWhere.append(" AND PT_U.SIDO_CODE = '" + scSIDO_CODE + "' ");
       		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	KJFMi.ReEnt2Ds(dl,rMasterEntity,"output13");
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	//PT_R_MOT_STE
	        sQuery.append(" SELECT * FROM PT_R_MOT_STE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND CHGBRE_SEQ = '" + sSeq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output14");
	        
	        // 2010.01.14. PT_R_ENGINEER_MASTER 사용안함.
	        //rMasterEntity    = rDAO.select("SELECT TMP_WRT_NUM, SEQ, ENGINEER_SSN1 || ENGINEER_SSN2 AS SSN, EMPL_YMD, RET_YMD, REMARK FROM PT_R_ENGINEER_CHANGE WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ORDER BY SEQ");	        
	        rMasterEntity    = rDAO.select("SELECT '0' AS CHECKER, ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT, SEQ, TMP_WRT_NUM, TMP_FIELD,  CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM,  ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS ENGINEER_SSN, TMP_FIELD AS TMP_GRADE FROM PT_R_ENGINEER_CHANGE WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ORDER BY SEQ");
	        //rMasterEntity    = rDAO.select("SELECT ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT, SEQ, TMP_WRT_NUM, TMP_FIELD,  CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM,  ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS SSN, TMP_FIELD AS TMP_GRADE FROM PT_R_ENGINEER_CHANGE WHERE 1 = 1  AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' AND RET_YMD IS NULL ");
	        /********************************************************/
	        /*	      TEST후 원복해야 함      wbjeon 2010-08-25  		    */
	        /********************************************************/		        
//	        Dataset ds = new Dataset("output7");
//	        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
//	        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("ENGINEER_SSN",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("TMP_FIELD",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
//			ds.addColumn("REMARK",ColumnInfo.CY_COLINFO_STRING, 100);
//			
//	        if (rMasterEntity.getRowCnt() != 0 && rMasterEntity != null){
//		        String[] sSSN = new String[rMasterEntity.getRowCnt()];
//		        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
//		        {
//		        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "SSN");
//		        }
//							
//		        iccsSelectBySSN(dl, ds, sSSN, rMasterEntity);
//			}
//					
//			dl.addDataset(ds);
	        
	        
	        if ("tete".equals(rscSIDO_CODE)|| "bsbs".equals(rscSIDO_CODE)){
		           KJFMi.ReEnt2Ds(dl,rMasterEntity,"output7");
	        } else {
		        Dataset ds = new Dataset("output7");
		        ds.addColumn("CHECKER",ColumnInfo.CY_COLINFO_STRING, 20);
		        ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_SSN",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_NM",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("TMP_FIELD",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("EMPL_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("RET_YMD",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("TMP_WRT_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("SEQ",ColumnInfo.CY_COLINFO_STRING, 20);
				ds.addColumn("REMARK",ColumnInfo.CY_COLINFO_STRING, 100);
				
		        if (rMasterEntity.getRowCnt() != 0 && rMasterEntity != null){
			        String[] sSSN = new String[rMasterEntity.getRowCnt()];
			        for(int nLoop = 0; nLoop < rMasterEntity.getRowCnt(); nLoop++)
			        {
			        	sSSN[nLoop] = rMasterEntity.getValue(nLoop, "ENGINEER_SSN");
			        }
								
			        iccsSelectBySSN(dl, ds, sSSN, rMasterEntity);
				}
						
				dl.addDataset(ds);	
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
    
    private void iccsSelectBySSN(DatasetList dl, Dataset ds, String[] sSSN, ReportEntity ent) throws Exception
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
            	if( ent.getValue(myIdx, "SSN").equals( SSN ) )
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
            ds.setColumn(row, "CARE_BOOK_ISSUE_NUM", BOOK_NUM);
            ds.setColumn(row, "CHECKER", "0");
            ds.setColumn(row, "ENGINEER_SSN", SSN);
            ds.setColumn(row, "ENGINEER_SSN1", SSN.substring(0, 6));
            ds.setColumn(row, "ENGINEER_SSN2", SSN.substring(6, SSN.length()));
            ds.setColumn(row, "ENGINEER_NM", NM_KOR);
            ds.setColumn(row, "CARE_BOOK_VAL_START_DT", S_DT);
            ds.setColumn(row, "CARE_BOOK_VAL_END_DT", E_DT);
            ds.setColumn(row, "ISSUE_DT", "");
            ds.setColumn(row, "TMP_FIELD", TMP_GRADE);
            ds.setColumn(row, "ENGINEER_GRADE", GRADE);
            ds.setColumn(row, "NAME", "");
            ds.setColumn(row, "EMPL_YMD", EMPL_YMD);
            ds.setColumn(row, "RET_YMD", RET_YMD);
            ds.setColumn(row, "TMP_WRT_NUM", TMP_WRT_NUM);
            ds.setColumn(row, "SEQ", SEQ);
            ds.setColumn( row, "REMARK", REMARK );
   		}
 	
    }
}