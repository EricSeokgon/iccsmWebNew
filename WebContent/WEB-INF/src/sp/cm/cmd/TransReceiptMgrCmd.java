/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
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

public class TransReceiptMgrCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public TransReceiptMgrCmd() {
	}

	public TransReceiptMgrCmd(String next_url) {
		next = next_url;
	}

	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		/****** Service API �ʱ�ȭ ******/
		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );
		/** Web Server���� XML���� �� Parsing **/
		pReq.receiveData();
		/** ���� ȹ�� **/
		vl = pReq.getVariableList();

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rEntity = null;

		StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
		String scRECV_NUM = vl.getValueAsString( "scRECV_NUM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scTRAN_COM_NAME = vl.getValueAsString( "scTRAN_COM_NAME" );
		String scTRAN_REP_NM = vl.getValueAsString( "scTRAN_REP_NM" );

		/**
		 * PT_R.TRAN_WRT_NUM �÷� �߰� ������ : 10/01/08 ������ : ���
		 */

		sQuery.append( " SELECT PT_R.RECV_NUM, PT_R.RECV_DT, PT_R.PROC_LIM, PT_R.ASSI_NAME, PT_R.TRAN_NAME, BB.MOT_STE, " );
		sQuery.append( " PT_R.DEFI_STE, DECODE(DEFI_STE, 'O', '����', '����') AS TMPDEFICIT_STATUS, PT_R.SIDO_CODE, PT_R.TRAN_WRT_NUM, PT_R.ASSI_TMP_WRT_NUM " );
		sQuery.append( " FROM (PT_R_ASSI_TRANS_STATEMENT PT_R LEFT JOIN PT_R_COMPANY_MASTER PT_C " );
		sQuery.append( " ON PT_R.ASSI_TMP_WRT_NUM = PT_C.TMP_WRT_NUM " );
		sQuery.append( " LEFT JOIN PT_R_BASIC_CHANGE_HISTORY BB ON PT_R.RECV_NUM = BB.RECV_NUM) " );

		sWhere.append( " WHERE 1 = 1 " );
		sWhere.append( " AND (PT_R.RECV_DT BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "')" );
		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			sWhere.append( " AND PT_R.RECV_NUM = '" + scRECV_NUM + "'" );
		
		if( !KJFUtil.isEmpty( scTRAN_COM_NAME ) )
			sWhere.append( " AND PT_R.TRAN_NAME LIKE '%" + scTRAN_COM_NAME + "%' " );
		
		if( !KJFUtil.isEmpty( scTRAN_REP_NM ) )
			sWhere.append( " AND PT_R.TRAN_REP LIKE '%" + scTRAN_REP_NM + "%' " );
		
		if( !KJFUtil.isEmpty( scSIDO_CODE ) )
			sWhere.append( " AND PT_R.SIDO_CODE = '" + scSIDO_CODE + "'" );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );

		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}

}