/**
 * 파일명   : ComCodeMgrCmd.java
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

public class RegListMgrCCmd<PT_R_DOC_NUM> implements KJFCommand {
	

	private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegListMgrCCmd() {
    }

    public RegListMgrCCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();    	     
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;
        
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
                
       	//Company Master Table
        //sQuery.append(" SELECT PT_C.*, PT_CD.CODE_NAME AS OFFICE_USE_NAME ");
        sQuery.append(" SELECT PT_C.* ");
        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_C LEFT JOIN ");
        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE ");
        sQuery.append(" WHERE P_CODE = 'BLDDIV')PT_CD ON PT_C.OFFICE_USE_CODE = PT_CD.CODE ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND PT_C.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
                
       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
       	sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
        
       	//Company Change History
        /*
        sQuery.append(" SELECT PT_H.CHG_DT, PT_H.CHGBRE_SEQ, TMP_WRT_NUM, SUBSTR(REPLACE(UPD_DT, '-', ''), 0, 8) AS UPD_DT, RECV_NUM, PT_C.CODE_NAME ");
        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_H LEFT JOIN ");
        sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGDIV') ");
        sQuery.append(" PT_C ON PT_H.STA_CHG_CLASS_CODE = PT_C.CODE ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND PT_H.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
        sWhere.append(" ORDER BY CHGBRE_SEQ DESC");
	*/
        
        sQuery.append(" SELECT '0' AS CHECKER, A.CHGBRE_SEQ,  CASE A.STA_CHG_CLASS_CODE WHEN 'R00007' THEN A.ADDR_ADDR || ' ' || A.ADDR_DETAIL_ADDR WHEN 'R00008' THEN A.REA_CAP     ");
        sQuery.append(" WHEN 'R00009' THEN A.REP_NM_KOR  WHEN 'R00002' THEN '차기신고일자(' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy/mm/dd') || ')'  WHEN 'R00010' THEN A.NAME    ");
        sQuery.append(" END AS VALUE,  B.CODE_NAME,  A.CHG_DT,'' AS CONFIRM ");   
        sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY A,   PT_COM_CODE B      ");    
        sWhere.append(" WHERE    1=1 ");
        sWhere.append(" AND A.STA_CHG_CLASS_CODE = B.CODE(+)   AND B.P_CODE = 'REGDIV'   AND A.TMP_WRT_NUM ='" +scTMP_WRT_NUM+ "'   AND A.CHG_DT >(SELECT MAX(NVL(C.CHG_DT,0)) FROM PT_R_BASIC_CHANGE_HISTORY  C "); 
        sWhere.append(" WHERE    1=1             AND C.TMP_WRT_NUM ='" +scTMP_WRT_NUM+ "' ");
        sWhere.append(" AND C.STA_CHG_CLASS_CODE  IN ('R00001', 'R00017', 'R00018' ,'R00016' ,'R00021' ,'R00006', 'R00005' ,'R00011', 'R00004'))   ORDER BY A.CHG_DT ASC ");
        
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
        sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
        
        //dsPT_M_MASTER
        Integer getCNT =0;
        String getDISPO_DT ="";
        String sql = "SELECT * FROM (SELECT DISPO_DT,COUNT(*) AS CNT FROM PT_M_MASTER WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' GROUP BY DISPO_DT) AA WHERE AA.CNT > 1 ";
        rMasterEntity = rDAO.select(sql);
      

        if (rMasterEntity.getRowCnt() > 0){  
        	for (int i = 0; i < rMasterEntity.getRowCnt(); i++){
        		getCNT = KJFUtil.str2int((rMasterEntity.getValue(i, "CNT")));
        		getDISPO_DT =  getDISPO_DT + rMasterEntity.getValue(i, "DISPO_DT") + ",";
        	}
        	String temp = getDISPO_DT.substring(0, getDISPO_DT.length()-1);
        	getDISPO_DT = "";
        	getDISPO_DT = temp;
        } 



        if(getCNT > 1 ){
        	sQuery.append("	SELECT AA.* FROM (SELECT '0' AS CHECKER,  PT_C.NAME,  PT_M.*,  PT_C1.CODE_NAME AS TMPD_PER_CODE, PT_C2.CODE_NAME,PT_C5.SIDO_NM AS TMPDISPO_CONT , PT_C3.CODE_NAME ");
        	//sQuery.append("		 AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT  FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM AND LENGTH(WRT_NUM) < 4 AND DISPO_DT in (" + getDISPO_DT + ") ) "); 
        	sQuery.append("		 AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT  FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM AND TRIM(TRANSLATE(WRT_NUM,'123456789','         ')) IS NULL AND DISPO_DT in (" + getDISPO_DT + ") ) "); 
        	
        	sQuery.append("		 LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE  LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME ");
        	sQuery.append("		 FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE  LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMSTE' )PT_C3 ");
        	sQuery.append("		 ON PT_M.MOT_STE = PT_C3.CODE  LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE  ");
        	sQuery.append("			 WHERE       1 = 1  AND     PT_M.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'  ");
        	sQuery.append("		 UNION ALL  ");
        	sQuery.append("		SELECT '0' AS CHECKER,  PT_C.NAME,  PT_M.*,  PT_C1.CODE_NAME AS TMPD_PER_CODE, PT_C2.CODE_NAME AS  TMPDISPO_CONT, PT_C3.CODE_NAME ");
        	sQuery.append("		 AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT  FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM AND DISPO_DT not in (" +getDISPO_DT + ") )  ");
            sQuery.append("		 LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE  LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME ");
            sQuery.append("		 FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE  LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMSTE' )PT_C3 ");
        	sQuery.append("		 ON PT_M.MOT_STE = PT_C3.CODE  LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE  ");
        	sQuery.append("		 LEFT JOIN (SELECT AREA_CODE, SIDO_NM FROM PT_SIDO_CODE WHERE SIGUNGU_NM = '본청' )PT_C5 ON PT_M.SIDO_CODE = PT_C5.AREA_CODE  ");
        	sQuery.append("		 WHERE       1 = 1  AND     PT_M.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        	sQuery.append("		 ) AA   ");
        	sQuery.append("	 ORDER BY AA.WRT_DT DESC   ");
        }else{
        
	        sQuery.append(" SELECT  '0' AS CHECKER, PT_C.NAME, PT_M.*, ");
	        sQuery.append(" PT_C1.CODE_NAME,PT_C5.SIDO_NM AS TMPDISPO_CONTE, PT_C2.CODE_NAME AS TMPDISPO_CONT, PT_C3.CODE_NAME AS TMPMOT_STE, PT_C4.CODE_NAME AS VIOL_CONT,PT_C.COI_WRT_NUM,PT_C.REP_NM_KOR, ");
	        sQuery.append(" DECODE(PT_M.PUNISHMENT_AGENCY, '서울특별시', '서울', '부산광역시', '부산', '부산체신청', '부산','울산광역시','울산 ','대구광역시', '대구','경상남도' , '경남', '인천광역시', '인천', '경기도', '경기' ,'경상북도','경북','광주광역시','광주','전라남도','전남','대전광역시','대전','충청남도','충남','전라북도','전북','강원도','강원','충청북도','충북','제주특별자치도','제주' ) AS SIDO_NM  ");
	        sQuery.append(" FROM    (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M ");
	        sQuery.append(" ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM) ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMREQ' )PT_C1 ON PT_M.D_PER_CODE = PT_C1.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_M.DISPO_CONT = PT_C2.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMSTE' )PT_C3 ON PT_M.MOT_STE = PT_C3.CODE ");
	        sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE ");
	        sQuery.append(" WHERE P_CODE = 'PTMCONT' )PT_C4 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE ");
        	sQuery.append("	LEFT JOIN (SELECT AREA_CODE, SIDO_NM FROM PT_SIDO_CODE WHERE SIGUNGU_NM = '본청' )PT_C5 ON PT_M.SIDO_CODE = PT_C5.AREA_CODE  ");
	        sWhere.append(" WHERE 	1 = 1 ");	 
	        sWhere.append(" AND     PT_M.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
	        sWhere.append(" ORDER BY PT_M.WRT_DT DESC ");
        }
        
        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output3");
        sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        
        //Company Master Table
        sQuery.append(" SELECT * FROM PT_R_WORK_CAPABILITY ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
       	sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output4");
        
        sQuery.append(" SELECT * FROM PT_R_WORK_RESULTS ");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
		
       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
       	sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output5");
        
        // 2010.01.14. PT_R_ENGINEER_MASTER 사용안함.
		sQuery.append(" SELECT  ");
		sQuery.append(" ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2,  ");
		sQuery.append(" EMPL_YMD, RET_YMD, REMARK, WRT_ID, UPD_DT, INS_DT,  ");
		sQuery.append(" SEQ, TMP_WRT_NUM, TMP_FIELD,  ");
		sQuery.append(" CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM, ");
		sQuery.append(" ENGINEER_NM AS NM_KOR, ENGINEER_SSN1 || ENGINEER_SSN2 AS ENGINEER_SSN, TMP_FIELD AS TMP_GRADE ");
		sQuery.append(" FROM PT_R_ENGINEER_CHANGE ");
		sWhere.append(" WHERE 1 = 1 ");
		sWhere.append(" AND TMP_WRT_NUM = '"+ scTMP_WRT_NUM +"' ");
		sWhere.append(" AND RET_YMD IS NULL ");
		sWhere.append(" ORDER BY EMPL_YMD ");

        rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
       	sQuery.delete(0, sQuery.length());
       	sWhere.delete(0, sWhere.length());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output6");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}