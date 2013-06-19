package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class CloseReceiptMgrCmd implements KJFCommand{
	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public CloseReceiptMgrCmd() {
	}

	public CloseReceiptMgrCmd(String next_url) {
		next = next_url;
	}
    
public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
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
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM" );
		String scNAME = vl.getValueAsString( "scNAME" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
        
		// �ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
		//sQuery.append( " SELECT	'0' AS CHECKER, A.* " );
		// sQuery.append(" PROC_LIM, RECV_WRT_DT, DEFI_STE, DECODE(DEFI_STE, 'O', '����', '����') AS TMPDEFICIT_STATUS ");
		//sQuery.append( " FROM     PT_R_CLOSE_STATEMENT A  " );
		
		sQuery.append( " SELECT	'0' AS CHECKER, AA.*, CC.CODE_NAME AS TMPMOT_STE  FROM     PT_R_CLOSE_STATEMENT AA    " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC') CC ON AA.MOT_STE = CC.CODE     " );

		sWhere.append( " WHERE 1 = 1 " );
		sWhere.append( " AND (SUBSTR(RECV_DT, 0, 8) BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "')" );
		sWhere.append( " AND SIDO_CODE = '" + scSIDO_CODE + "'" );
		
		if( scRECV_NUM != null && scRECV_NUM.length() > 0 )
			sWhere.append( " AND RECV_NUM = '" + scRECV_NUM + "'" );

		if( scCOI_WRT_NUM != null && scCOI_WRT_NUM.length() > 0 )
			sWhere.append( " AND COI_WRT_NUM = '" + scCOI_WRT_NUM + "'" );

		if( scNAME != null && scNAME.length() > 0 )
			sWhere.append( " AND NAME LIKE '%" + scNAME + "%'" );
		
		if( scRECV_NUM != null && scREP_NM.length() > 0 )
			sWhere.append( " AND REP_NM_KOR = '" + scREP_NM + "'" );
		
		sWhere.append( "  order by ins_dt desc " );
		
		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		// DB���� �������� ����Ÿ �� �߰������� 1���� ROW�� �߰��Ͽ� ����� ��� ReEnt2CodeDs
		// �� ����Ѵ�.

		// ����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
    }

}
