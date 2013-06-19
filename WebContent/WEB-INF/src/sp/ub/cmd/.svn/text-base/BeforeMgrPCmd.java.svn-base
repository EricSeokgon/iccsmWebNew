/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
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

public class BeforeMgrPCmd implements KJFCommand
{

	private String next;
	private static DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public BeforeMgrPCmd() {
	}

	public BeforeMgrPCmd(String next_url) {
		next = next_url;
	}

	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rEntity = null;

		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );

		pReq.receiveData();

		vl = pReq.getVariableList();

		String scCIV_RECV_NUM = vl.getValueAsString( "scCIV_RECV_NUM" );
		String scORPE_NM = vl.getValueAsString( "scORPE_NM" );
		String scPLANER_NAME = vl.getValueAsString( "scPLANER_NAME" );
		String scRECV_ST = vl.getValueAsString( "scRECV_ST" );
		String scRECV_ET = vl.getValueAsString( "scRECV_ET" );
		String scSUV_APPL = vl.getValueAsString( "scSUV_APPL" );
		String scFINISH = vl.getValueAsString( "scFINISH" );
		String scPROC_STE = vl.getValueAsString( "scPROC_STE" );

		String SIDO_CODE = vl.getValueAsString( "SIDO_CODE" );
		String SIGUNGU_CODE = vl.getValueAsString( "SIGUNGU_CODE" );

		StringBuffer sb = new StringBuffer();
		sb.append( "SELECT \n" );
		sb.append( " ROWNUM AS UB_SEQ, UB_C.* FROM ( \n" );	// 순번은 클라이언트가 별도 관리
		
		sb.append( "SELECT  " );
		sb.append( "UB_CS.RECV_DT, " );
		sb.append( "UB_CS.ORPE_NM, " );
		sb.append( "UB_CS.ORPE_TEL, " );
		sb.append( "UB_CS.PLANER_NAME, " );
		sb.append( "UB_CS.PLANER_TEL, " );
		sb.append( "UB_CS.STRU_ADDR_ADDR || ' ' || STRU_ADDR_DETAILADDR AS STRU_ADDR, " );
		sb.append( "\n" );
		
		sb.append( "UB_CS.USE, " );	// 용도코드
		//sb.append( "CC_USE.CODE_NAME USE_NAME, " );	// 용도명
		//sb.append( "decode(USE_ETC,'',CC_USE.CODE_NAME,CC_USE.CODE_NAME||' '||USE_ETC) AS USE_NAME, " );	// 용도명
		sb.append( "decode(UB_CS.USE_ETC,'',CC_USE.CODE_NAME,UB_CS.USE_ETC,CC_USE.CODE_NAME||','||UB_CS.USE_ETC) AS USE_NAME, " );	// 용도명
		sb.append( "UB_CS.AREA, " );
		sb.append( "UB_CS.NUM_FL, " );
		sb.append( "UB_CS.CONFIRMER_NM, " ); //검토자		
		sb.append( "(REPLACE(UB_CS.WORK_ITEM, '/', '')||', '||UB_CS.WORK_ITEM_ETC) AS WORK_ITEM, " );
		sb.append( "UB_CS.SW_BEF_REPO_DELINUM, " );	// 통보교부 번호
		sb.append( "UB_CS.REPO_DT, " ); // 통보교부 일자
		sb.append( "\n" );
		
		sb.append( "UB_CS.INSP_OPIN, " );	// 검토의견
		sb.append( "DECODE(UB_UB.CER_DELI_YN, 1, '○' ) AS CER_DELI_YN," );	// 필증교부 확인 (교부확인시 1, 그외 NULL)
		sb.append( "UB_UB.INSP_WISH_YMD, " );	// 검사희망연월일
		sb.append( "UB_UB.DELI_DT, " );	// 필증교부일자
		sb.append( "UB_CS.SUV_APPL, " );	// 검사신청일자
		
		sb.append( "\n" );
		
		//sb.append( "MI_US.NM AS WRT_NM, " );	// WRT_ID 의 이름
		sb.append( "DECODE(UB_CS.CONFIRMER_NM, '',MI_US.NM,UB_CS.CONFIRMER_NM  ) AS WRT_NM, " );	// WRT_ID 의 이름
		sb.append( "UB_UB.USEBEFINSP_DELINUM, " );	// 사용전검사 필증 교부번호 (그리드에서는 안씀)
		sb.append( "DECODE(UB_CS.STRU_INFO_BIGO,'1','신축','2','증축','3','용도변경','4','허가변경','5','개축','') AS STRU_INFO_BIGO " );	// 건축정보 비고
		sb.append( "\n" );
		
		sb.append( "FROM PT_UB_CONSTRUCTION UB_CS \n" );
		
		// 용도 코드 LEFT OUTER JOIN
		sb.append( "LEFT JOIN PT_COM_CODE CC_USE \n" );
		sb.append( "ON CC_USE.CODE = UB_CS.USE AND CC_USE.P_CODE = 'BLDDIV' \n" );

		// 사용전검사 LEFT OUTER JOIN
		sb.append( "LEFT JOIN PT_UB_USEBEFORE UB_UB \n" );
		sb.append( "ON UB_CS.SW_BEF_REPO_DELINUM = UB_UB.SW_BEF_REPO_DELINUM \n" );
		
		// 관리자정보 LEFT OUTER JOIN
		sb.append( "LEFT JOIN PT_MI_USER MI_US \n" );
		sb.append( "ON UB_CS.WRT_ID = MI_US.OFFI_ID \n" );
		
		sb.append( "WHERE 1 = 1\n" );

		sb.append( "AND UB_CS.SIDO_CODE = '" + SIDO_CODE + "' AND UB_CS.SIGUNGU_CODE = '" + SIGUNGU_CODE + "'\n" );

		if( !KJFUtil.isEmpty( scORPE_NM ) ) {
			sb.append( "AND UB_CS.ORPE_NM LIKE '%" + scORPE_NM + "%'\n" );
		}

		if( !KJFUtil.isEmpty( scPLANER_NAME ) ) {
			sb.append( "AND UB_CS.PLANER_NAME LIKE '" + scPLANER_NAME + "%'\n" );
		}

		if( !KJFUtil.isEmpty( scRECV_ST ) && !KJFUtil.isEmpty( scRECV_ET ) ) {
			sb.append( "AND UB_CS.RECV_DT BETWEEN '" + scRECV_ST + "' AND '" + scRECV_ET + "'  \n" );
		}

		if( !KJFUtil.isEmpty( scSUV_APPL ) && !"0".equals( scSUV_APPL ) ) {
			sb.append( "AND UB_CS.SUV_APPL = '" + scSUV_APPL + "'\n" );
		}
		
		if( !KJFUtil.isEmpty( scCIV_RECV_NUM ) ) {
			sb.append( "AND UB_CS.CIV_RECV_NUM = '" + scCIV_RECV_NUM + "'\n" );
		}
		
		if( !KJFUtil.isEmpty( scPROC_STE ) && !"0".equals( scPROC_STE ) ) {
		//if( !KJFUtil.isEmpty( scPROC_STE ) ) {
			sb.append( "AND UB_CS.PROC_STE = '" + scPROC_STE + "'\n" );
		}

		sb.append( "ORDER BY REPLACE(UB_CS.SW_BEF_REPO_DELINUM,'-','') ASC \n" );
		sb.append( " ) UB_C ORDER BY UB_SEQ, RECV_DT \n" );
		//sb.append( " ) UB_C ORDER BY UB_SEQ DESC \n" );

		rEntity = rDAO.select( sb.toString() );

		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}

}