/**
 * ���ϸ�   : RegMgrCmd.java
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

public class UnionMgrCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public UnionMgrCmd() {
	}

	public UnionMgrCmd(String next_url) {
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
		String scNAME = vl.getValueAsString( "scNAME" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );

		//sQuery.append( " SELECT '0' AS CHECKER, PT_U.RECV_NUM, PT_U.PROC_LIM, PT_H.TMP_WRT_NUM, PT_H.CHGBRE_SEQ, " );
		// WBJEON ���� MASTER���̺��� ����Ϲ�ȣ ��ȸ (�������� ������� ����Ϲ�ȣ ��ȸ�� �ٸ� ����� ��ȣ�� ����)
		// ������ȣ�� ������ �������̺��� ������ȣ�� üũ�� �ϰ� ��������� ������ȣ�� ������ ��Ű�Ƿν�
		// ������� ���̺��� ������ȣ�� �����Ѱ� �߻��� �Ҽ� ����  ������ �� �ɾ ��ȸ�ÿ��� ������ ����
		sQuery.append( " SELECT '0' AS CHECKER, PT_U.RECV_NUM, PT_U.PROC_LIM, PT_C2.TMP_WRT_NUM, PT_H.CHGBRE_SEQ, " );
		sQuery.append( " PT_C1.NAME  AS A_COMPANY, PT_C2.NAME AS P_COMPANY, PT_H.MOT_STE, " );
		sQuery.append( " PT_U.RECV_DT, PT_U.ESTA_NAME AS E_COMPANY, PT_U.ESTA_WRT_NUM, PT_H.WRT_DT " );
		sQuery.append( " FROM PT_R_UNION_STATEMENT PT_U LEFT JOIN PT_R_COMPANY_MASTER PT_C1 " );
		sQuery.append( " ON PT_U.ASC_TMP_WRT_NUM = PT_C1.TMP_WRT_NUM " );
		sQuery.append( " LEFT JOIN PT_R_COMPANY_MASTER PT_C2 " );
		sQuery.append( " ON PT_U.HANDED_TMP_WRT_NUM = PT_C2.TMP_WRT_NUM " );
		sQuery.append( " INNER JOIN PT_R_BASIC_CHANGE_HISTORY PT_H ON PT_U.RECV_NUM = PT_H.RECV_NUM " );

		sWhere.append( " WHERE 1 = 1 " );
		sWhere.append( " AND (PT_H.WRT_DT BETWEEN '" + scDATE1 + "' " );
		sWhere.append( " AND '" + scDATE2 + "') " );
		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			sWhere.append( " AND PT_U.RECV_NUM = '" + scRECV_NUM + "' " );
		
		if( !KJFUtil.isEmpty( scSIDO_CODE ) )
			sWhere.append( " AND PT_U.SIDO_CODE = '" + scSIDO_CODE + "' " );
		
		if( !KJFUtil.isEmpty( scNAME ) )
			sWhere.append( " AND PT_U.ESTA_NAME LIKE '%" + scNAME + "%' " );
		
		if( !KJFUtil.isEmpty( scREP_NM ) )
			sWhere.append( " AND PT_U.ESTA_REP_NM_KOR LIKE '%" + scREP_NM + "%' " );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );
		return next;
	}
}