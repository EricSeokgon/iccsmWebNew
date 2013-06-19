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

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class StdReceiptMgrNCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public StdReceiptMgrNCmd() {
	}

	public StdReceiptMgrNCmd(String next_url) {
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

		String scDATE = vl.getValueAsString( "scDATE" );
		String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
		String scRECV_NUM = vl.getValueAsString( "scRECV_NUM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scCOM_NAME = vl.getValueAsString( "scCOM_NAME" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM");

		// 코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
		/*sQuery.append( " SELECT '0' AS CHECKER, PT_R.TMP_WRT_NUM, PT_R.RECV_NUM, PT_R.RECV_DT, PT_R.PROC_LIM, PT_R.COI_WRT_NUM, PT_R.SIDO_CODE, " );
		sQuery.append( " DECODE(PT_R.DEFI_STE, 'O', '정상', '오류')AS DEFI_STE, BB.CODE_NAME AS MOT_STE, PT_R.NAME " );
		sQuery.append( " FROM (PT_R_BASIC_STATEMENT PT_R LEFT JOIN (SELECT * FROM PT_R_BASIC_CHANGE_HISTORY WHERE STA_CHG_CLASS_CODE = 'R00002') PT_C  " );
		sQuery.append( " ON PT_R.RECV_NUM = PT_C.RECV_NUM ) LEFT JOIN " );
		sQuery.append( " (SELECT CODE, CODE_NAME FROM PT_COM_CODE " );
		sQuery.append( " WHERE P_CODE = 'REGSTDPROC')BB ON PT_C.MOT_STE = BB.CODE " );
*/
		
		sQuery.append( " SELECT '0' AS CHECKER,  AA.CHGBRE_SEQ,AA.TMP_WRT_NUM, AA.RECV_NUM, AA.RECV_DT, AA.REP_NM_KOR, AA.PROC_LIM, AA.SIDO_CODE, " );
		sQuery.append( " DECODE(AA.COI_WRT_NUM, null , CC.COI_WRT_NUM, AA.COI_WRT_NUM) AS COI_WRT_NUM,  " );
		sQuery.append( " DECODE(AA.MOT_STE, null , CC.MOT_STE, AA.MOT_STE) AS MOT_STE,  " );
		sQuery.append( " decode(AA.MOT_STE,'STD002','',substr(AA.WRT_DT,0,4)||'-'||substr(AA.WRT_DT,5,2)||'-'||substr(AA.WRT_DT,7,2)) AS WRT_DT, BB.CODE_NAME AS TMPMOT_STE, AA.NAME" );
		sQuery.append( " FROM (PT_R_BASIC_STATEMENT AA LEFT JOIN (SELECT * FROM PT_R_BASIC_CHANGE_HISTORY WHERE STA_CHG_CLASS_CODE = 'R00002') CC ON AA.RECV_NUM = CC.RECV_NUM AND AA.SIDO_CODE = CC.SIDO_CODE ) " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC')BB ON AA.MOT_STE = BB.CODE OR CC.MOT_STE = BB.CODE " );
		
		sWhere.append( " WHERE 1 = 1 " );
		/*sWhere.append( " AND (SUBSTR(AA.RECV_DT, 0, 8) BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "')" );*/
		sWhere.append(" AND(AA." + scDATE + " BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "')  ");

		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			
			sWhere.append( " AND AA.RECV_NUM = '" + scRECV_NUM + "'" );
		
		if( !KJFUtil.isEmpty( scCOM_NAME ) )
			sWhere.append( " AND AA.NAME LIKE '%" + scCOM_NAME + "%' " );
		
		if( !KJFUtil.isEmpty( scREP_NM ) )
			sWhere.append( " AND AA.REP_NM_KOR LIKE '%" + scREP_NM + "%' " );
		
		if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
			sWhere.append( " AND AA.COI_WRT_NUM LIKE '%" + scCOI_WRT_NUM + "%' " );
		
		sWhere.append( " AND AA.SIDO_CODE = '" + scSIDO_CODE + "'" );
		// sWhere.append(" GROUP BY PT_R.RECV_NUM, PT_R.RECV_DT, PT_R.PROC_LIM, PT_R.COI_WRT_NUM, PT_R.SIDO_CODE,PT_R.DEFI_STE, BB.CODE_NAME, PT_R.NAME ");

		sWhere.append( " ORDER BY RECV_DT DESC, RECV_TIME DESC" );
		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		// DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우 ReEnt2CodeDs
		// 를 사용한다.

		// 데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}

}