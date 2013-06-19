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

public class StdMgrCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public StdMgrCmd() {
	}

	public StdMgrCmd(String next_url) {
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
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM" );
		String scNAME = vl.getValueAsString( "scNAME" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );
		String scDATE_CLASS= vl.getValueAsString( "scDATE_CLASS" );
		
		sQuery.append( " SELECT '0' AS CHECKER, DD.RECV_DT, BB.SIDO_CODE,BB.CHGBRE_SEQ, BB.MOT_STE, AA.COI_WRT_NUM, AA.WRT_DT, AA.NAME, " );
		sQuery.append( " AA.REP_NM_KOR, AA.C_COM_DT, AA.ADDR_ADDR,  DECODE(AA.C_COM_DT, NULL, '', '폐업') AS TMPC_COM_DT, " );
		sQuery.append( " AA.TMP_WRT_NUM, BB.RECV_NUM, AA.MANA_NUM, CC.CODE_NAME AS TMPMOT_STE, " );
		sQuery.append( " REPLACE(SUBSTR(BB.INS_DT, 0, 10), '-', '') INS_DT, " );
		sQuery.append( " BB.CHG_DT HISTORY_CHG_DT,to_char(ADD_MONTHS(BB.CHG_DT,36), 'yyyymmdd')AS BAS_STA_DT, to_char(ADD_MONTHS(BB.CHG_DT,36)+30, 'yyyymmdd')AS BAS_STA_DT2 " );
		sQuery.append( " FROM (PT_R_COMPANY_MASTER AA INNER JOIN " );
		sQuery.append( " (SELECT SIDO_CODE, RECV_NUM, TMP_WRT_NUM, CHGBRE_SEQ, MOT_STE, INS_DT, CHG_DT " );
		sQuery.append( " FROM PT_R_BASIC_CHANGE_HISTORY " );
		sQuery.append( " WHERE STA_CHG_CLASS_CODE = 'R00002' AND SIDO_CODE = '" + scSIDO_CODE + "') BB ON AA.TMP_WRT_NUM = BB.TMP_WRT_NUM) " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGSTDPROC') CC " );
		sQuery.append( " ON BB.MOT_STE = CC.CODE " );
		sQuery.append( " INNER JOIN PT_R_BASIC_STATEMENT DD " );
		sQuery.append( " ON BB.RECV_NUM = DD.RECV_NUM AND BB.SIDO_CODE = DD.SIDO_CODE " );
		sWhere.append( " WHERE 1 = 1 " );
		//sWhere.append( " AND (REPLACE(SUBSTR(BB.INS_DT,0, 10), '-', '') BETWEEN '" + scDATE1 + "'" );
		/*sWhere.append( " AND (REPLACE(SUBSTR(DECODE(BB.CHG_DT,'',BB.INS_DT,BB.CHG_DT),0, 10), '-', '') BETWEEN '" + scDATE1 + "'" );
		sWhere.append( " AND '" + scDATE2 + "') " );*/
		if (scDATE_CLASS.equalsIgnoreCase("D00001"))
        	sWhere.append(" AND (REPLACE(SUBSTR(DD.RECV_DT ,0, 10), '-', '') BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
        else if(scDATE_CLASS.equalsIgnoreCase("D00002"))
        	sWhere.append(" AND (AA.WRT_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
        else
        	sWhere.append(" AND (BB.CHG_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "') ");
        
		
		// sWhere.append(" AND BB.SIDO_CODE = '" + scSIDO_CODE + "' ");
		
		if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
			sWhere.append( " AND AA.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'" );
		
		if( !KJFUtil.isEmpty( scNAME ) )
			sWhere.append( " AND AA.NAME LIKE '%" + scNAME + "%'" );
		
		if( !KJFUtil.isEmpty( scREP_NM ) )
			sWhere.append( " AND AA.REP_NM_KOR LIKE '%" + scREP_NM + "%'" );

		sWhere.append( " ORDER BY RECV_DT DESC " );

		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}
}