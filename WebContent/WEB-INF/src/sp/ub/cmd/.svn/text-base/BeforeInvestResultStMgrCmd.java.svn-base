/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
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

public class BeforeInvestResultStMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeInvestResultStMgrCmd() {
    }

    public BeforeInvestResultStMgrCmd(String next_url) {
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

		String scORPE_NM = vl.getValueAsString( "scORPE_NM" );
		String scPLANER_NAME = vl.getValueAsString( "scPLANER_NAME" );
		String scWORK_ITEM = vl.getValueAsString( "scWORK_ITEM" );
		String scRECV_ST = vl.getValueAsString( "scRECV_ST" );
		String scRECV_ET = vl.getValueAsString( "scRECV_ET" );
		String scSUV_APPL = vl.getValueAsString( "scSUV_APPL" );
		String scPROC_STE = vl.getValueAsString( "scPROC_STE" );
		String scCIV_RECV_NUM = vl.getValueAsString( "scCIV_RECV_NUM" );

		String scSIDO_CODE = vl.getValueAsString( "SIDO_CODE" );
		String SIGUNGU_CODE = vl.getValueAsString( "SIGUNGU_CODE" );

		String selectSQL	= "	SELECT '0' AS CHECKER,RECV_DT,ORPE_NM, PLANER_NAME, REPO_DT, SW_BEF_REPO_DELINUM,RECV_NUM,  \n" + 
								"          STRU_ADDR_ADDR||' '||STRU_ADDR_DETAILADDR AS ADDR,    \n" + 
								"		   CASE PROC_STE WHEN '1' THEN '신규입력' WHEN '2' THEN '처리중' WHEN '3' THEN '처리완료' ELSE ' ' END AS  PROC_STE, \n" + 
								"		   CASE SUV_APPL WHEN '1' THEN '적합' WHEN '2' THEN '부적합' WHEN '3' THEN '감리대상' WHEN '4' THEN '비대상' ELSE ' ' END AS  SUV_APPL , CIV_RECV_NUM \n";

		String fromSQL		= " FROM PT_UB_CONSTRUCTION  \n";

		String whereSQL		= " WHERE 1 = 1    \n";

		whereSQL += "      AND SIDO_CODE = '" + scSIDO_CODE + "'       \n" + "	   AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "'   \n";


		// 접수번호
		if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
    		whereSQL += "  AND CIV_RECV_NUM like '%"+scCIV_RECV_NUM+"'  \n";
    	}
    	
		// 발주자 성명
		if( !KJFUtil.isEmpty( scORPE_NM ) ) {
			whereSQL += "	   AND ORPE_NM LIKE '%" + scORPE_NM + "%'  \n";
		}

		// 설계자 성명
		if( !KJFUtil.isEmpty( scPLANER_NAME ) ) {
			whereSQL += "	   AND PLANER_NAME LIKE '%" + scPLANER_NAME + "%'  \n";
		}

		// 공사 종류
		if( !KJFUtil.isEmpty( scWORK_ITEM ) ) {
			whereSQL += "	   AND WORK_ITEM LIKE '%" + scWORK_ITEM + "%'  \n";
		}

		// 접수일자
		if( !KJFUtil.isEmpty( scRECV_ST ) && !KJFUtil.isEmpty( scRECV_ET ) ) {
			whereSQL += "	   AND RECV_DT BETWEEN '" + scRECV_ST + "' AND '" + scRECV_ET + "'  \n";
		}

		// 검토결과
		if( !KJFUtil.isEmpty( scSUV_APPL ) && !"0".equals( scSUV_APPL ) ) {
			whereSQL += "  	   AND SUV_APPL = '" + scSUV_APPL + "'  \n";
		}

		// 처리상태
		if( !KJFUtil.isEmpty( scPROC_STE ) && !"0".equals( scPROC_STE ) ) {
			whereSQL += "  	   AND PROC_STE = '" + scPROC_STE + "'  \n";
		}

		String orderSQL = "	   ORDER BY RECV_DT DESC";

		rEntity = rDAO.select( selectSQL + fromSQL + whereSQL + orderSQL );

		// 데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );
		
	    selectSQL = " SELECT SIDO_CODE, SIGUNGU_CODE, COUNT(*) AS CNT ";
        fromSQL = " FROM PT_S_SYSVAR_MASTER";
        whereSQL  =" WHERE 1 = 1 ";
        whereSQL += " AND SIDO_CODE = '" + scSIDO_CODE + "'";
        whereSQL += " AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "'";
        whereSQL += " group by sido_code, sigungu_code";
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);
        KJFMi.ReEnt2Ds(dl,rEntity,"output2");

		request.setAttribute( "dl", dl );

		return next;
	}


}