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

public class RegReceiptMgrNCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public RegReceiptMgrNCmd() {
	}

	public RegReceiptMgrNCmd(String next_url) {
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

		String scDATE = vl.getValueAsString( "scDATE" );
		String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
		String scRECV_NUM = vl.getValueAsString( "scRECV_NUM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scCOM_NAME = vl.getValueAsString( "scCOM_NAME" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM");

		// �ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
		sQuery.append( " SELECT	'0' AS CHECKER, AA.SIDO_CODE, AA.RECV_NUM,  DECODE(AA.COI_WRT_NUM, null , BB.COI_WRT_NUM, AA.COI_WRT_NUM) AS COI_WRT_NUM, AA.NAME, AA.REP_NM_KOR, AA.RECV_DT, DECODE(AA.MOT_STE, null , BB.MOT_STE, AA.MOT_STE) AS MOT_STE, CC.CODE_NAME AS TMPMOT_STE, DD.NM AS WRT_NM, " );
		sQuery.append( " AA.PROC_LIM, AA.DEFI_STE, decode(AA.WRT_DT,null,'',substr(AA.WRT_DT,0,4)||'-'||substr(AA.WRT_DT,5,2)||'-'||substr(AA.WRT_DT,7,2)) AS WRT_DT, AA.GUBUN, AA.TMP_WRT_NUM, AA.LICTAX, AA.HOSCRE " );
		sQuery.append( " FROM    ((PT_R_REGIST_STATEMENT AA LEFT JOIN  (SELECT MOT_STE, RECV_NUM, SIDO_CODE, COI_WRT_NUM FROM PT_R_BASIC_CHANGE_HISTORY WHERE STA_CHG_CLASS_CODE = 'R00001') BB ON AA.RECV_NUM = BB.RECV_NUM AND AA.SIDO_CODE = BB.SIDO_CODE) " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC') CC ON AA.MOT_STE = CC.CODE OR BB.MOT_STE = CC.CODE) " );
		sQuery.append( " LEFT JOIN PT_MI_USER DD ON AA.WRT_ID = DD.OFFI_ID " );

		sWhere.append( " WHERE 1 = 1 " );
		/*sWhere.append( " AND (SUBSTR(AA.RECV_DT, 0, 8) BETWEEN '" + scDATE1 + "'" );
		  sWhere.append( " AND '" + scDATE2 + "')" );
		*/
		  sWhere.append(" AND(AA." + scDATE + " BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "')  ");
	      
		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			sWhere.append( " AND AA.RECV_NUM = '" + scRECV_NUM + "' " );
		
		if( !KJFUtil.isEmpty( scCOM_NAME ) )
			sWhere.append( " AND AA.NAME LIKE '%" + scCOM_NAME + "%' " );
		
		if( !KJFUtil.isEmpty( scREP_NM ) )
			sWhere.append( " AND AA.REP_NM_KOR LIKE '%" + scREP_NM + "%' " );
		
		if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
			sWhere.append( " AND AA.COI_WRT_NUM LIKE '" + scCOI_WRT_NUM + "' " );
		
		sWhere.append( " AND AA.SIDO_CODE = '" + scSIDO_CODE + "' " );
		sWhere.append( " ORDER BY RECV_DT DESC, RECV_TIME DESC " );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		// DB���� �������� ����Ÿ �� �߰������� 1���� ROW�� �߰��Ͽ� ����� ��� ReEnt2CodeDs �� ����Ѵ�.

		// ����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );
		/*
		  sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	//Company Change History
	       	sQuery.append( " SELECT '0' AS CHECKER, BB.CHGBRE_SEQ, BB.COI_WRT_NUM, BB.WRT_DT, BB.NAME, BB.REP_NM_KOR, BB.C_COM_DT, BB.ADDR_ADDR, " );
			sQuery.append( " DECODE(BB.C_COM_DT, NULL, '', '���') AS TMPC_COM_DT,  BB.TMP_WRT_NUM, BB.RECV_NUM, BB.MANA_NUM, CC.CODE_NAME AS TMPMOT_STE, " );
			// ��ϿϷ� �������� ������ڿ� ���� ���� �ʴ´�.
			sQuery.append( " REPLACE(SUBSTR(BB.INS_DT, 0, 10), '-', '') INS_DT " );
			sQuery.append( " FROM    PT_R_BASIC_CHANGE_HISTORY BB " );
			sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC')CC ON BB.MOT_STE = CC.CODE " );

			sWhere.append( " WHERE 1 = 1 " );
			sWhere.append( " AND (REPLACE(SUBSTR(BB.INS_DT, 0, 10), '-', '') BETWEEN '" + scDATE1 + "'" );
			sWhere.append( " AND '" + scDATE2 + "')" );
			
			if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
			sWhere.append( " AND BB.COI_WRT_NUM LIKE '%" + scCOI_WRT_NUM + "%'" );
			
			sWhere.append( " AND BB.SIDO_CODE = '" + scSIDO_CODE + "' " );
		
			rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
	
			KJFMi.ReEnt2Ds( dl, rEntity, "output1" );
*/
		request.setAttribute( "dl", dl );

		return next;

	}

}