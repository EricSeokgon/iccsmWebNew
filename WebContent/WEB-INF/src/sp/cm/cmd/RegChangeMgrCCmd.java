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
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.util.keng.KengWorker;
import sp.util.keng.Kengineer;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegChangeMgrCCmd<PT_R_DOC_NUM> implements KJFCommand {
	
    private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
        
    public RegChangeMgrCCmd() {
    }

    public RegChangeMgrCCmd(String next_url) {
    	next = next_url;
    }

    //뷰화면처리
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
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        String scREC_NUM = vl.getValueAsString("scRECV_NUM");
        
        if(sworkMODE.equals("ALL")){
	        //Company Change History : 변경정보
	        //sQuery.append(" SELECT * FROM ( ");
	        sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        //sWhere.append(" AND PT_C.RECV_NUM = '" + scREC_NUM + "'");
	        sWhere.append(" ORDER BY CHGBRE_SEQ");
	        //sWhere.append(" ) WHERE ROWNUM=1 ");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
	        
	        //Change Seq
	        String sSeq = rMasterEntity.getValue(0, "CHGBRE_SEQ");
	        
	       	//Company Master Table : 업체정보
	        sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
	        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_C LEFT JOIN ");
	        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
	       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output1");
	        
	        //PT_R_MOT_STE : 넣어야 되나..
	        sQuery.append(" SELECT * FROM PT_R_MOT_STE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
	        sWhere.append(" AND CHGBRE_SEQ = '" + sSeq + "'");
		
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
    	}
        
        //PT_R_BASIC_CHANGE_HISTORY : 히스토리 변경내역 싹끌어오기
        sQuery.append(" SELECT  ");
        sQuery.append(" DECODE(b.CODE,'R00001','등록','신고') CODE_TYPE,");
        sQuery.append(" b.CODE_NAME CODE_NAME,CHG_DT DT, NAME, REP_NM_KOR, REP_NM_HAN, REP_SSN1, REP_SSN2, ");
        sQuery.append(" ADDR_ADDR, ADDR_DETAIL_ADDR, OFFICE_AREA, ADDR_TEL_NUM, ADDR_FAX_NUM, ");
        sQuery.append(" PAY_CAP, REA_CAP, c.CODE_NAME DIAG_ORG_NAME, DIAG_NM_NM, STA_CHG_CLASS_CODE, REPLACE(SUBSTR (UPD_DT,0,10),'-','') UPD_DT ");
        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY a ");
        sWhere.append(" LEFT JOIN PT_COM_CODE b ON a.STA_CHG_CLASS_CODE=b.CODE ");
        sWhere.append(" LEFT JOIN PT_COM_CODE c ON a.DIAG_ORG_CODE=c.CODE ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        sWhere.append(" ORDER BY CHGBRE_SEQ DESC ");
	
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
        
        //공사실적
        sQuery.append(" SELECT a.*,'0' AS CHECKER FROM PT_R_WORK_RESULTS a ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
        sWhere.append(" ORDER BY SEQ ASC");
        
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
        
        //시공능력평가
        sQuery.append(" SELECT a.*,'0' AS CHECKER FROM PT_R_WORK_CAPABILITY a ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
        sWhere.append(" ORDER BY SEQ ASC");
        
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
        
        //기술자 데이터
        sQuery.append(" SELECT ");
		sQuery.append(" ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  ");
		sQuery.append(" EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT,  ");
		sQuery.append(" SEQ, TMP_WRT_NUM, TMP_FIELD,  ");
		sQuery.append(" CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM, ");
		sQuery.append(" ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS ENGINEER_SSN, TMP_FIELD AS TMP_GRADE ");
		sQuery.append(" FROM PT_R_ENGINEER_CHANGE ");
    	sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        sWhere.append(" AND RET_YMD IS NULL ");
        
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    
	        
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
        
        request.setAttribute("dl", dl);  

        return next;
    }
    
    private void iccsSelectBySSN(DatasetList dl, Dataset ds, String[] sSSN, ReportEntity ent) throws Exception
    {
		ReportDAO rDAO = new ReportDAO();
		ReportEntity rEntity = null;

		StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		KengWorker kWorker = new KengWorker();
		Kengineer kengs[] = kWorker.getKengs( sSSN );
   	
		if( kengs == null )
			return;
		
   		for(int i=0; i < kengs.length;i++ )
   		{
            Kengineer keng = kengs[i];
            String NM_KOR  =   keng.getNM_KOR();    
            String SSN        =   keng.getSSN();          
            String GRADE     =   keng.getGRADE();      
            String TMP_GRADE  =   keng.getTMP_GRADE(); 
            String BOOK_NUM         =   keng.getBOOK_NUM();  
            String EDU_DT    =   keng.getEDU_DT();    
            String S_DT       =   keng.getS_DT();        
            String E_DT       =   keng.getE_DT();        
            String CORP      =   keng.getCORP();
            String EMPL_YMD = ent.getValue(i, "EMPL_YMD");
            String RET_YMD = ent.getValue(i, "RET_YMD");
            String TMP_WRT_NUM = ent.getValue(i, "TMP_WRT_NUM");
            String SEQ = ent.getValue(i, "SEQ");
            String REMARK = ent.getValue( i, "REMARK" );
            
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
            ds.setColumn(row, "ENGINEER_SSN2", SSN.substring(6, 13));
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