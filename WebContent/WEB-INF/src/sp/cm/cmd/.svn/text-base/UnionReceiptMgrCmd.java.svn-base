package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;


public class UnionReceiptMgrCmd implements KJFCommand
{
	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();
	
	public UnionReceiptMgrCmd() {
	}

	public UnionReceiptMgrCmd(String next_url) {
		next = next_url;
	}

	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		/****** Service API 초기화 ******/
		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );
		/** Web Server에서 XML수신 및 Parsing **/
		pReq.receiveData();
		/** 변수 획득 **/
		vl = pReq.getVariableList();

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rMasterEntity = null;

		StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		
		
		
		
		String sworkMODE = vl.getValueAsString( "workMODE" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
		String scESTA_COM_NAME = vl.getValueAsString( "scESTA_COM_NAME" );
		String scESTA_REP_NM = vl.getValueAsString( "scESTA_REP_NM" );

		if( sworkMODE.equalsIgnoreCase( "RECV_NUM" ) ) {
			String scRECV_NUM = vl.getValueAsString( "scRECV_NUM" );

			sQuery.append( " SELECT '0' AS CHECKER, PT_U.RECV_NUM, DECODE(PT_U.DEFI_STE, 'O', '정상', '오류') AS TMPDEFI_STE, PT_U.PROC_LIM, " );
			sQuery.append( " PT_C1.NAME  AS A_COMPANY, PT_C2.NAME AS P_COMPANY, PT_H.MOT_STE, " );
			sQuery.append( " PT_U.RECV_DT, PT_U.ESTA_NAME AS E_COMPANY" );
			sQuery.append( " FROM PT_R_UNION_STATEMENT PT_U LEFT JOIN PT_R_COMPANY_MASTER PT_C1" );
			sQuery.append( " ON PT_U.ASC_TMP_WRT_NUM = PT_C1.TMP_WRT_NUM" );
			sQuery.append( " LEFT JOIN PT_R_COMPANY_MASTER PT_C2" );
			sQuery.append( " ON PT_U.HANDED_TMP_WRT_NUM = PT_C2.TMP_WRT_NUM" );
			sQuery.append( " LEFT JOIN PT_R_BASIC_CHANGE_HISTORY PT_H ON PT_U.RECV_NUM = PT_H.RECV_NUM" );
			sWhere.append( " WHERE 1 = 1 " );
			sWhere.append( " AND (PT_U.RECV_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') " );

			if( !KJFUtil.isEmpty( scRECV_NUM ) )
				sWhere.append( " AND PT_U.RECV_NUM = '" + scRECV_NUM + "' " );
			
			if( !KJFUtil.isEmpty( scESTA_COM_NAME ) )
				sWhere.append( " AND PT_U.ESTA_NAME LIKE '%" + scESTA_COM_NAME + "%' " );
			
			if( !KJFUtil.isEmpty( scESTA_REP_NM ) )
				sWhere.append( " AND PT_U.ESTA_REP_NM_KOR LIKE '%" + scESTA_REP_NM + "%' " );
			
			if( !KJFUtil.isEmpty( scSIDO_CODE ) )
				sWhere.append( " AND PT_U.SIDO_CODE = '" + scSIDO_CODE + "' " );
			// sWhere.append(" GROUP BY PT_U.RECV_NUM, PT_U.PROC_LIM, PT_C1.NAME, PT_C2.NAME, PT_U.RECV_DT, PT_U.ESTA_NAME, PT_H.MOT_STE ");

			rMasterEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
			sQuery.delete( 0, sQuery.length() );
			sWhere.delete( 0, sWhere.length() );
			KJFMi.ReEnt2Ds( dl, rMasterEntity, "dsPT_R_UNION_MASTER" );
		}
		request.setAttribute( "dl", dl );

		return next;
	}

}
