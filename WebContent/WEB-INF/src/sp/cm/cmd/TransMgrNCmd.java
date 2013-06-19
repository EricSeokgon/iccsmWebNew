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

public class TransMgrNCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public TransMgrNCmd() {
	}

	public TransMgrNCmd(String next_url) {
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
		String scRECV_NUM = vl.getValueAsString( "scRC_REGIST_NUM" );
		String scTRAN_NAME = vl.getValueAsString( "scCOM_NAME" );
		String scTRAN_REP = vl.getValueAsString( "scREP_NM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM");
		 System.out.println(scDATE);
		//sQuery.append( " SELECT '0' AS CHECKER, RECV_NUM, COI_WRT_NUM, SIDO_CODE, DECODE(NVL(ASSI_TMP_WRT_NUM,''),'',TRAN_TMP_WRT_NUM,ASSI_TMP_WRT_NUM) AS TMP_WRT_NUM, RECV_DT, ASSI_NAME, TRAN_NAME, TRAN_REP,");
		 //sQuery.append( " SELECT '0' AS CHECKER, RECV_NUM, COI_WRT_NUM, SIDO_CODE, DECODE(NVL(TRAN_TMP_WRT_NUM,''),'',ASSI_TMP_WRT_NUM,TRAN_TMP_WRT_NUM) AS TMP_WRT_NUM, RECV_DT, ASSI_NAME, TRAN_NAME, TRAN_REP,");
		 sQuery.append( " SELECT '0' AS CHECKER, RECV_NUM, COI_WRT_NUM, SIDO_CODE, DECODE(ASSI_TMP_WRT_NUM,'000000',TRAN_TMP_WRT_NUM,ASSI_TMP_WRT_NUM) AS TMP_WRT_NUM, RECV_DT, ASSI_NAME, TRAN_NAME, TRAN_REP,");
		 sQuery.append( " (SELECT CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGPROC' AND CODE = MOT_STE) MOT_STE, ASSI_WRT_DT FROM PT_R_ASSI_TRANS_STATEMENT");
		sWhere.append( " WHERE 1 = 1 " );
		/*sWhere.append( " AND (RECV_DT BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "')" );
		*/
		if(scDATE.equals("RECV_DT"))
		sWhere.append(" AND("+ scDATE + " BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "')  ");
		
		if(scDATE.equals("UPD_DT"))
		sWhere.append( " AND (SUBSTR(UPD_DT, 1, 4)||SUBSTR(UPD_DT, 6, 2)||SUBSTR(UPD_DT, 9, 2)  BETWEEN '" + scDATE1 +"' AND '" + scDATE2 + "') ");
		
		if( !KJFUtil.isEmpty( scRECV_NUM ) )
			sWhere.append( " AND RECV_NUM = '" + scRECV_NUM + "'" );
		
		if( !KJFUtil.isEmpty( scTRAN_NAME ) )
			sWhere.append( " AND TRAN_NAME LIKE '%" + scTRAN_NAME + "%'" );
		
		if( !KJFUtil.isEmpty( scTRAN_REP ) )
			sWhere.append( " AND TRAN_REP LIKE '%" + scTRAN_REP + "%'" );
		
		if( !KJFUtil.isEmpty( scSIDO_CODE ) )
			sWhere.append( " AND SIDO_CODE = '" + scSIDO_CODE + "'" );
		
		if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
			sWhere.append( " AND COI_WRT_NUM LIKE '%" + scCOI_WRT_NUM + "%' " );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}
}