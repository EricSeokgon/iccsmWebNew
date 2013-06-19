/**
 * 파일명   : RegMgrCmd.java
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

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class TransMgrCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public TransMgrCmd() {
	}

	public TransMgrCmd(String next_url) {
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
		ReportEntity rEntity = null;

		StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
		String scRECV_NUM = vl.getValueAsString( "scRC_REGIST_NUM" );
		String scTRAN_NAME = vl.getValueAsString( "scCOM_NAME" );
		String scTRAN_REP = vl.getValueAsString( "scREP_NM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );

		sQuery.append( " SELECT '0' AS CHECKER, PT_R.RECV_NUM, PT_R.RECV_DT, PT_R.PROC_LIM, PT_R.ASSI_NAME, PT_R.TRAN_NAME,PT_R.TRAN_REP,  " );
		sQuery.append( " PT_R.SIDO_CODE, PT_H.MOT_STE, PT_CD.CODE_NAME, PT_H.WRT_DT, PT_H.TMP_WRT_NUM, PT_H.CHGBRE_SEQ " );
		sQuery.append( " FROM (PT_R_ASSI_TRANS_STATEMENT PT_R LEFT JOIN PT_R_COMPANY_MASTER PT_C  ON PT_R.ASSI_TMP_WRT_NUM = PT_C.TMP_WRT_NUM) " );
		sQuery.append( " INNER JOIN (SELECT * FROM PT_R_BASIC_CHANGE_HISTORY WHERE STA_CHG_CLASS_CODE = 'R00004' OR STA_CHG_CLASS_CODE = 'R00005' OR STA_CHG_CLASS_CODE = 'R00011') PT_H ON PT_R.RECV_NUM = PT_H.RECV_NUM " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC') PT_CD ON PT_H.MOT_STE = PT_CD.CODE " );

		sWhere.append( " WHERE 1 = 1 " );
		sWhere.append( " AND (PT_R.RECV_DT BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "')" );
		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			sWhere.append( " AND PT_R.TRAN_WRT_NUM = '" + scRECV_NUM + "'" );
		
		if( !KJFUtil.isEmpty( scTRAN_NAME ) )
			sWhere.append( " AND PT_R.TRAN_NAME LIKE '%" + scTRAN_NAME + "%'" );
		
		if( !KJFUtil.isEmpty( scTRAN_REP ) )
			sWhere.append( " AND PT_R.TRAN_REP LIKE '%" + scTRAN_REP + "%'" );
		
		if( !KJFUtil.isEmpty( scSIDO_CODE ) )
			sWhere.append( " AND PT_R.SIDO_CODE = '" + scSIDO_CODE + "'" );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}
}