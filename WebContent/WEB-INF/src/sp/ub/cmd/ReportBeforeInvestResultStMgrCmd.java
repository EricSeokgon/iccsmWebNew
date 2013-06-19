/**
 * 파일명   : ReportBeforeInvestResultStMgrCmd.java
 * 설명     :  착공전 설계검토 처리목록 cmd
 * 이력사항
 * CH00     : 2010/01/25 전원배 최초작성
 */

package sp.ub.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class ReportBeforeInvestResultStMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public ReportBeforeInvestResultStMgrCmd() {
    }

    public ReportBeforeInvestResultStMgrCmd(String next_url) {
    	next = next_url;
    }



	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rEntity = null;

		/****** Service API 초기화 ******/
		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );
		/** Web Server에서 XML수신 및 Parsing **/
		pReq.receiveData();
		/** 변수 획득 **/
		vl = pReq.getVariableList();

        String scDATE = vl.getValueAsString("scDATE");
		String scORPE_NM = vl.getValueAsString( "scORPE_NM" );
		String scRECV_ST = vl.getValueAsString( "scRECV_ST" );
		String scRECV_ET = vl.getValueAsString( "scRECV_ET" );
		String scSUV_APPL = vl.getValueAsString( "scSUV_APPL" );
		String scPROC_STE = vl.getValueAsString( "scPROC_STE" );

		String scSIDO_CODE = vl.getValueAsString( "SIDO_CODE" );
		String SIGUNGU_CODE = vl.getValueAsString( "SIGUNGU_CODE" );

		String selectSQL	=
							" SELECT ROWNUM AS SEQ, UB.* FROM ("+
							" SELECT RECV_DT, ORPE_NM, NVL(PLANER_NAME,PLANER_NM) AS PLANER_NAME_S, \n" +
							"	STRU_ADDR_ADDR ||' ' ||STRU_ADDR_DETAILADDR AS  STRU_ADDR_ADDR_S, \n" +
							"	DECODE(SUV_APPL,1,'적합',2,'부적합',3,'감리대상',4,'비대상') AS SUV_APPL_S, REPO_DT  \n";

		String fromSQL		= " FROM PT_UB_CONSTRUCTION  \n";

		String whereSQL		= " WHERE 1 = 1    \n";

		whereSQL += "      AND SIDO_CODE = '" + scSIDO_CODE + "'       \n" + "	   AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "'   \n";

		//처리완료만 검색  20120501추가
		whereSQL += "      AND PROC_STE = '3'  \n";
		
		// 발주자 성명
		if( !KJFUtil.isEmpty( scORPE_NM ) ) {
			whereSQL += "	   AND ORPE_NM LIKE '%" + scORPE_NM + "%'  \n";
		}

		// 접수일자
		if( !KJFUtil.isEmpty( scRECV_ST ) && !KJFUtil.isEmpty( scRECV_ET ) ) {
			whereSQL += "	   AND " + scDATE + " BETWEEN '" + scRECV_ST + "' AND '" + scRECV_ET + "'  \n";
		}

		// 검토결과
		if( !KJFUtil.isEmpty( scSUV_APPL ) && !"0".equals( scSUV_APPL ) ) {
			whereSQL += "  	   AND SUV_APPL = '" + scSUV_APPL + "'  \n";
		}

/*		// 처리상태	       처리완료만 검색하기 위해 20120501 주석처리
		if( !KJFUtil.isEmpty( scPROC_STE ) && !"0".equals( scPROC_STE ) ) {
			whereSQL += "  	   AND PROC_STE = '" + scPROC_STE + "'  \n";
//			whereSQL += "  	   AND PROC_STE = '3'  \n";
		}
*/   
		String orderSQL = "	   ORDER BY " + scDATE + " ASC) UB ORDER BY SEQ ASC";

		rEntity = rDAO.select( selectSQL + fromSQL + whereSQL + orderSQL );

		// 데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}


}