/**
 */

package sp.ub.cmd;

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

public class UBInvestMgrPCmd implements KJFCommand
{

	private String next;
	private static DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public UBInvestMgrPCmd() {
	}

	public UBInvestMgrPCmd(String next_url) {
		next = next_url;
	}

	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rEntity = null;

		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );

		pReq.receiveData();

		vl = pReq.getVariableList();

		String scCIV_RECV_NUM = vl.getValueAsString( "scCIV_RECV_NUM" );
		String scOPE_NAME = vl.getValueAsString( "scOPE_NAME" );
		String scAPPLPER_NM = vl.getValueAsString( "scAPPLPER_NM" );
		String scINSP_SPOT_NM = vl.getValueAsString( "scINSP_SPOT_NM" );
		String scRECV_ST = vl.getValueAsString( "scRECV_ST" );
		String scRECV_ET = vl.getValueAsString( "scRECV_ET" );
		String scSUV_APPL = vl.getValueAsString( "scSUV_APPL" );
		String scFINISH = vl.getValueAsString( "scFINISH" );

		String SIDO_CODE = vl.getValueAsString( "SIDO_CODE" );
		String SIGUNGU_CODE = vl.getValueAsString( "SIGUNGU_CODE" );

		StringBuffer sb = new StringBuffer();
		sb.append( "SELECT \n" );
		sb.append( "'' AS CHECKER, " );	// 순번은 클라이언트가 별도 관리
		sb.append( "\n" );
		
		sb.append( "UB_UB.RECV_DT, " );
		sb.append( "UB_UB.APPLPER_REP, " );
		sb.append( "UB_UB.APPLPER_TELNUM, " );
		sb.append( "UB_UB.INSP_SPOT_ADDR || ' ' || UB_UB.INSP_SPOT_DETAILADDR AS INSP_SPOT_ADDR, " );
		
		sb.append( "UB_CS.ORPE_NM, " );
		sb.append( "UB_CS.ORPE_TEL, " );
		sb.append( "UB_CS.PLANER_NM, " );
		sb.append( "UB_CS.PLANER_TEL, " );
		sb.append( "UB_CS.STRU_ADDR_ADDR || ' ' || STRU_ADDR_DETAILADDR AS STRU_ADDR, " );
		sb.append( "\n" );
		
		sb.append( "UB_UB.USE, " );	// 용도코드
		sb.append( "CC_USE.CODE_NAME USE_NAME, " );	// 용도명
		sb.append( "UB_UB.AREA, " );
		sb.append( "UB_UB.NUM_FL, " );
		sb.append( "TRIM(REPLACE(UB_UB.WORK_ITEM, '/', ' ')) WORK_ITEM, " );
		sb.append( "UB_UB.SW_BEF_REPO_DELINUM, " );	// 통보교부 번호
		sb.append( "UB_CS.REPO_DT, " ); // 통보교부 일자
		sb.append( "\n" );
		
		sb.append( "UB_CS.INSP_OPIN, " );	// 검토의견
		//sb.append( "UB_UB.WRT_ID_NM, " ); // 검사자 성명 (사용안함)
		sb.append( "DECODE(UB_UB.CER_DELI_YN, 1, '○' ) AS CER_DELI_YN," );	// 필증교부 확인 (교부확인시 1, 그외 NULL)
		sb.append( "UB_UB.INSP_WISH_YMD, " );	// 검사희망연월일
		sb.append( "UB_UB.DELI_DT, " );	// 필증교부일자
		sb.append( "\n" );
		
		sb.append( "MI_US.NM AS WRT_NM, " );	// WRT_ID 의 이름
		sb.append( "UB_UB.USEBEFINSP_DELINUM " );	// 사용전검사 필증 교부번호 (그리드에서는 안씀)
		sb.append( "\n" );
		
		sb.append( "FROM PT_UB_USEBEFORE UB_UB \n" );
		
		// 착공전설계도 LEFT OUTER JOIN
		sb.append( "LEFT JOIN PT_UB_CONSTRUCTION UB_CS \n" );
		sb.append( "ON UB_CS.SW_BEF_REPO_DELINUM = UB_UB.SW_BEF_REPO_DELINUM \n" );
		
		// 용도 코드 LEFT OUTER JOIN
		sb.append( "LEFT JOIN PT_COM_CODE CC_USE \n" );
		sb.append( "ON CC_USE.CODE = UB_UB.USE AND CC_USE.P_CODE = 'BLDDIV' \n" );
		
		// 관리자정보 LEFT OUTER JOIN
		sb.append( "LEFT JOIN PT_MI_USER MI_US \n" );
		sb.append( "ON UB_UB.WRT_ID = MI_US.OFFI_ID \n" );
		
		sb.append( "WHERE 1 = 1\n" );

		sb.append( "AND UB_UB.SIDO_CODE = '" + SIDO_CODE + "' AND UB_UB.SIGUNGU_CODE = '" + SIGUNGU_CODE + "'\n" );

		if( !KJFUtil.isEmpty( scINSP_SPOT_NM ) ) {
			sb.append( "AND UB_UB.INSP_SPOT_NM LIKE '%" + scINSP_SPOT_NM + "%'\n" );
		}
		
		if( !KJFUtil.isEmpty( scOPE_NAME ) ) {
			sb.append( "AND UB_UB.OPE_NAME LIKE '%" + scOPE_NAME + "%'\n" );
		}

		if( !KJFUtil.isEmpty( scAPPLPER_NM ) ) {
			sb.append( "AND UB_UB.APPLPER_NM LIKE '" + scAPPLPER_NM + "%'\n" );
		}

		if( !KJFUtil.isEmpty( scRECV_ST ) && !KJFUtil.isEmpty( scRECV_ET ) ) {
			sb.append( "AND UB_UB.RECV_DT BETWEEN '" + scRECV_ST + "' AND '" + scRECV_ET + "'  \n" );
		}

		if( !KJFUtil.isEmpty( scSUV_APPL ) && !"0".equals( scSUV_APPL ) ) {
			sb.append( "AND UB_CS.SUV_APPL = '" + scSUV_APPL + "'\n" );
		}
		
		if( !KJFUtil.isEmpty( scCIV_RECV_NUM ) ) {
			sb.append( "AND UB_UB.CIV_RECV_NUM = '" + scCIV_RECV_NUM + "'\n" );
		}

		sb.append( "ORDER BY UB_UB.RECV_DT DESC\n" );

		rEntity = rDAO.select( sb.toString() );

		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}

}