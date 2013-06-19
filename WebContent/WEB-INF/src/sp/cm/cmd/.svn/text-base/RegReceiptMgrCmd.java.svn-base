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

public class RegReceiptMgrCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public RegReceiptMgrCmd() {
	}

	public RegReceiptMgrCmd(String next_url) {
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
		String scRECV_NUM = vl.getValueAsString( "scRECV_NUM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scCOM_NAME = vl.getValueAsString( "scCOM_NAME" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
		String scREP_MOBILE = vl.getValueAsString( "scREP_MOBILE");

		// 코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
		sQuery.append( " SELECT	'0' AS CHECKER, AA.SIDO_CODE, AA.RECV_NUM,  AA.NAME, AA.RECV_DT, BB.MOT_STE, CC.CODE_NAME AS TMPMOT_STE, DD.NM AS WRT_NM, " );
		sQuery.append( " AA.PROC_LIM, AA.DEFI_STE, DECODE(AA.DEFI_STE, 'O', '정상', '오류') AS TMPDEFICIT_STATUS, AA.GUBUN " );
		sQuery.append( " FROM    ((PT_R_REGIST_STATEMENT AA LEFT JOIN  (SELECT MOT_STE, RECV_NUM, SIDO_CODE FROM PT_R_BASIC_CHANGE_HISTORY WHERE STA_CHG_CLASS_CODE = 'R00001') BB ON AA.RECV_NUM = BB.RECV_NUM AND AA.SIDO_CODE = BB.SIDO_CODE) " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC') CC ON BB.MOT_STE = CC.CODE) " );
		sQuery.append( " LEFT JOIN PT_MI_USER DD ON AA.WRT_ID = DD.OFFI_ID " );

		sWhere.append( " WHERE 1 = 1 " );
		sWhere.append( " AND (SUBSTR(AA.RECV_DT, 0, 8) BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "')" );
		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			sWhere.append( " AND AA.RECV_NUM = '" + scRECV_NUM + "' " );
		
		if( !KJFUtil.isEmpty( scCOM_NAME ) )
			sWhere.append( " AND AA.NAME LIKE '%" + scCOM_NAME + "%' " );
		
		if( !KJFUtil.isEmpty( scREP_NM ) )
			sWhere.append( " AND AA.REP_NM_KOR LIKE '%" + scREP_NM + "%' " );
		
		if( !KJFUtil.isEmpty( scREP_MOBILE ) )
			sWhere.append( " AND AA.REP_MOBILE LIKE '%" + scREP_MOBILE + "%' " );
		
		sWhere.append( " AND AA.SIDO_CODE = '" + scSIDO_CODE + "' " );
		sWhere.append( " ORDER BY RECV_DT DESC, RECV_TIME DESC " );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		// DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우 ReEnt2CodeDs 를 사용한다.

		// 데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;

	}

}