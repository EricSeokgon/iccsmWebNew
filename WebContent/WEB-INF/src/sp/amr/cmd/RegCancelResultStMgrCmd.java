package sp.amr.cmd;

/**
 * 파일명   : RegCancelResultStMgrCmd.java
 * 설명     :  착공전 설계검토 처리목록 cmd
 * 이력사항
 * CH00     : 2010/01/25 전원배 최초작성
 */

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

public class RegCancelResultStMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegCancelResultStMgrCmd() {
    }

    public RegCancelResultStMgrCmd(String next_url) {
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
        
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM" );
		String scNAME = vl.getValueAsString( "scNAME" );
		String scREP_NM_KOR = vl.getValueAsString( "scREP_NM_KOR" );
		String scDISPO_CONT = vl.getValueAsString( "scDISPO_CONT" );
		String scBUSISUSP_START_DT = vl.getValueAsString( "scBUSISUSP_START_DT" );
		String scBUSISUSP_END_DT = vl.getValueAsString( "scBUSISUSP_END_DT" );
		String scREMARK = vl.getValueAsString( "scREMARK" );
		

		String scSIDO_CODE = vl.getValueAsString( "SIDO_CODE" );
		//String SIGUNGU_CODE = vl.getValueAsString( "SIGUNGU_CODE" );

		String selectSQL	=
							" SELECT ROWNUM AS SEQ, MA.* FROM ("+
							" SELECT  \n" +
							"	PM.COI_WRT_NUM, PM.DISPO_DT,PM.DISPO_CAUSE, PM.REMARK,PM.BUSISUSP_START_DT,PM.BUSISUSP_END_DT, \n" +
						    "   DECODE(PM.DISPO_CONT,'M00001','등록취소(폐업)','M00002','영업정지(기타)','M00003','제 78조관련 과태료','M00004','시정명령',  \n"+
						    "   'M00005','형사고발','M00006','징계(경고)','M00008','징계(주의)','M00009','영업정지1개월미만','M00010','영업정지1개월','M00011','영업정지2개월미만',  \n"+
						    "   'M00012','영업정지3개월미만','M00013','영업정지4개월미만','M00014','영업정지5개월미만','M00015','영업정지6개월미만',  \n"+
						    "   'M00016','영업정지7개월미만','M00017','영업정지8개월미만','M00018','영업정지9개월미만','M00019','영업정지(부실시공)') AS DISPO_CONT,  \n"+
						    "	PM.DOC_CODE, PC.NAME, PC.REP_NM_KOR  \n";
		String fromSQL		= " FROM PT_M_MASTER PM, PT_R_COMPANY_MASTER PC  \n";
		String whereSQL		= " WHERE 1 = 1  \n";
		whereSQL += "      AND PM.COI_WRT_NUM = PC.COI_WRT_NUM \n";
		whereSQL += "      AND DISPO_CONT = 'M00001' \n"; 
		
		//시도
		if( !KJFUtil.isEmpty( scSIDO_CODE) && !"ALL".equals(scSIDO_CODE) ) {
			whereSQL += "	   AND PC.SIDO_CODE LIKE '"+ scSIDO_CODE + "'  \n";
		}
		
		// 발주자 성명
		if( !KJFUtil.isEmpty( scNAME ) ) {
			whereSQL += "	   AND PC.NAME LIKE '%" + scNAME + "%'  \n";
		}
		//상호
		if( !KJFUtil.isEmpty( scREP_NM_KOR ) ) {
			whereSQL += "	   AND PC.REP_NM_KOR LIKE '%" + scREP_NM_KOR  + "%'  \n";
		}
		// 처분기간
		if( !KJFUtil.isEmpty( scBUSISUSP_START_DT  ) && !KJFUtil.isEmpty( scBUSISUSP_END_DT ) ) {
			whereSQL += "	   AND PM.DISPO_DT BETWEEN '" + scBUSISUSP_START_DT+ "' AND '" + scBUSISUSP_END_DT + "'  \n";
		}
		if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
			whereSQL +=" AND PM.COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n";
		
		//처분내용
		if( !KJFUtil.isEmpty( scREP_NM_KOR ) ) {
			whereSQL += " AND PM.DISPO_CONT '%" + scDISPO_CONT  + "%'  \n";
		}
		
		//비고
		if( !KJFUtil.isEmpty( scREMARK ) ) {
			whereSQL += " AND PM.REMARK '%" + scREMARK  + "%'  \n";
		}
		
		// 처리상태
		/*if( !KJFUtil.isEmpty( scPROC_STE ) && !"0".equals( scPROC_STE ) ) {
			whereSQL += "  	   AND PROC_STE = '" + scPROC_STE + "'  \n";
//			whereSQL += "  	   AND PROC_STE = '3'  \n";
		}*/

		String orderSQL = "	   ORDER BY PM.BUSISUSP_START_DT ASC) MA ORDER BY SEQ DESC";

		rEntity = rDAO.select( selectSQL + fromSQL + whereSQL + orderSQL );

		// 데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}


}