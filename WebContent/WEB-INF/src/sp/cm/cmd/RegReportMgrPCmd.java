package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import sp.util.keng.KengWorker;
import sp.util.keng.Kengineer;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegReportMgrPCmd implements KJFCommand
{
	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public RegReportMgrPCmd() {
	}

	public RegReportMgrPCmd(String next_url) {
		next = next_url;
	}

	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		/****** Service API 초기화 ******/
		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );
		/** Web Server에서 XML수신 및 Parsing **/
		pReq.receiveData();
		/** 변수 획득 **/
		vl = pReq.getVariableList();

		String scTMP_WRT_NUM = vl.getValueAsString( "scTMP_WRT_NUM" );
		String scWorkMODE = vl.getValueAsString( "workMODE" );
		// String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
		// String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rMasterEntity = null;

		// 코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
		StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		if( scWorkMODE.equalsIgnoreCase( "ALL" ) ) {
			// Company Master
			sQuery.append( " SELECT * FROM PT_R_COMPANY_MASTER" );
			sWhere.append( " WHERE 1=1 \n" );
			sWhere.append( " AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'\n" );

			rMasterEntity = rDAO.select( sQuery.toString() + sWhere.toString() );

			if( rMasterEntity.getRowCnt() > 0 && rMasterEntity != null ) {
				KJFMi.ReEnt2Ds( dl, rMasterEntity, "output1" );
			}

			sQuery.delete( 0, sQuery.length() );
			sWhere.delete( 0, sWhere.length() );

			// History Table
			// RegRepublishMgrPCmd 에서 복사. 조금 다름 -_-
			/*
			sQuery.append( "	SELECT 	\n" );
			sQuery.append( "	'0' AS CHECKER, 	\n" );
			sQuery.append( "	PT_RBCH.CHGBRE_SEQ,	\n" );
			sQuery.append( "	CASE PT_RBCH.STA_CHG_CLASS_CODE 	\n" );
			sQuery.append( "	WHEN 'R00007' THEN PT_RBCH.ADDR_ADDR || ' ' || PT_RBCH.ADDR_DETAIL_ADDR	\n" );
			sQuery.append( "	WHEN 'R00008' THEN PT_RBCH.REA_CAP 	\n" );
			sQuery.append( "	WHEN 'R00009' THEN PT_RBCH.REP_NM_KOR 	\n" );
			sQuery.append( "	WHEN 'R00002' THEN '차기신고일자(' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy/mm/dd') || ')'   	\n" );
			sQuery.append( "	WHEN 'R00010' THEN PT_RBCH.NAME	\n" );
			sQuery.append( "	END AS VALUE, 	\n" );
			sQuery.append( "	PT_CC.CODE_NAME, PT_RBCH.CHG_DT, '' AS CONFIRM  	\n" );
			sQuery.append( "	FROM PT_R_BASIC_CHANGE_HISTORY PT_RBCH  	\n" );
			sQuery.append( "	INNER JOIN(SELECT * FROM PT_COM_CODE WHERE P_CODE = 'REGDIV') PT_CC 	\n" );
			sQuery.append( "	ON PT_RBCH.STA_CHG_CLASS_CODE = PT_CC.CODE   	\n" );
			sQuery.append( "	WHERE	1=1 \n" );
			sQuery.append( "	AND PT_RBCH.TMP_WRT_NUM ='" + scTMP_WRT_NUM + "'\n" );
			sQuery.append( "	ORDER BY PT_RBCH.CHGBRE_SEQ ASC 	\n" );
            			
			rMasterEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
			if( rMasterEntity.getRowCnt() > 0 && rMasterEntity != null ) {
				KJFMi.ReEnt2Ds( dl, rMasterEntity, "output4" );
			}
			
			*/
			
			  sQuery.append(" SELECT '0' AS CHECKER, A.CHGBRE_SEQ,  CASE A.STA_CHG_CLASS_CODE WHEN 'R00007' THEN A.ADDR_ADDR || ' ' || A.ADDR_DETAIL_ADDR WHEN 'R00008' THEN A.REA_CAP     ");
		        sQuery.append(" WHEN 'R00009' THEN A.REP_NM_KOR  WHEN 'R00002' THEN '충족 (다음신고예정일:' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy/mm/dd') || ')'  WHEN 'R00010' THEN A.NAME    ");
		        sQuery.append(" END AS VALUE,  B.CODE_NAME,  A.CHG_DT,'' AS CONFIRM ");   
		        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY A,   PT_COM_CODE B      ");    
		        sWhere.append(" WHERE    1=1 ");
		        sWhere.append(" AND A.STA_CHG_CLASS_CODE = B.CODE(+)   AND B.P_CODE = 'REGDIV'   AND A.TMP_WRT_NUM ='" +scTMP_WRT_NUM+ "'   AND A.CHG_DT >(SELECT MAX(NVL(C.CHG_DT,0)) FROM PT_R_BASIC_CHANGE_HISTORY  C "); 
		        sWhere.append(" WHERE    1=1             AND C.TMP_WRT_NUM ='" +scTMP_WRT_NUM+ "' ");
		        sWhere.append(" AND C.STA_CHG_CLASS_CODE  IN ('R00001', 'R00017', 'R00018' ,'R00016' ,'R00021' ,'R00006', 'R00005' ,'R00011', 'R00004'))   ORDER BY A.CHG_DT ASC ");
		       
	        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
	       	sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
	        
		}

		request.setAttribute( "dl", dl );

		return next;
	}

}
