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
import kjf.util.KJFDate;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import com.tobesoft.platform.data.Dataset;

public class CorpCloseProcCmd implements KJFCommand {
	
    private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CorpCloseProcCmd() {
    }

    public CorpCloseProcCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();    	
    	
    	Dataset ds = pReq.getDatasetList().getDataset("dsClose");

        String sworkMODE = vl.getValueAsString("workMODE");
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
        String scOLDTMP_WRT_NUM = vl.getValueAsString("scOLDTMP_WRT_NUM");
        String scASSI_STE = vl.getValueAsString("scASSI_STE");
        String[] sNUM = scTMP_WRT_NUM.split(",");
        
        
        String scC_COM_DT = vl.getValueAsString("scC_COM_DT");
        
        /*
        for (int nLoop = 0; nLoop < sNUM.length; nLoop++) {
        	if(sworkMODE.equalsIgnoreCase("UPD_REFFER_ENGI"))
        		UpdateReferEngi_trans(sworkMODE, sNUM[nLoop], scOLDTMP_WRT_NUM);
        	else if(sworkMODE.equalsIgnoreCase("CLO002_TRANS"))
        		CloseCorpProc_trans(sworkMODE, sNUM[nLoop]);
        	else
        		CloseCorpProc(sworkMODE, sNUM[nLoop]);
        }
        */
        
        for (int nLoop = 0; nLoop < sNUM.length; nLoop++) {
        	if( sNUM[nLoop] == null || sNUM[nLoop].length() == 0 )
        		continue;
        	CloseCorpProc(sworkMODE, sNUM[nLoop], scASSI_STE, scC_COM_DT);
        }
        return next;
    }
    
    public void CloseCorpProc(String sworkMODE, String scTMP_WRT_NUM, String assi_ste, String scC_COM_DT) throws Exception 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
      
      // 폐업일자가 넘어온 경우, SYSDATE로 넣지 않기
      String sqlC_COM_DT = "TO_CHAR(SYSDATE, 'YYYYMMDD')";
      if( scC_COM_DT != null && scC_COM_DT.length() == 8 )
      	sqlC_COM_DT = "'" + scC_COM_DT + "'";
      String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
      String scDOC_CODE = vl.getValueAsString("scDOC_CODE");
      
    	sQuery.append(" UPDATE PT_R_COMPANY_MASTER SET C_COM_DT = " + sqlC_COM_DT + ", RECV_NUM = '" + scRECV_NUM + "', DOC_CODE = '" + scDOC_CODE + "', ");
        sQuery.append(" C_COM_CAUSE_CODE = '"+sworkMODE+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString()); 
	    
    	// 양도양수, 합병에 대해서만 PT_R_BASIC_CHANGE_HISTORY 에 레코드 넣기.
    	// 추가로 접수번호(RECV_NUM), 접수일자(RECV_DT) 를 넘겨준것으로 가정.
    	if( sworkMODE.equals( "CLO003" ) || sworkMODE.equals( "CLO004" ) ) {
    		//String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    		String scRECV_DT = vl.getValueAsString("scRECV_DT");
    		
    		sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());
	    	
	    	sQuery.append( 
	    	"INSERT INTO " +
    		"PT_R_BASIC_CHANGE_HISTORY " +
    		"( " +
    		"SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE, " +
    		"COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM, " +
    		"TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT,INS_DT,WRT_DT,BAS_STA_DT,OFFICE_OWN_CLASS, " +
    		"CHGBRE_SEQ,STA_CHG_CLASS_CODE,RECV_NUM,CHG_DT,MOT_STE, " +
    		"TMP_WRT_NUM,COI_WRT_NUM,REP_MOBILE,HOSCRE,LICTAX,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3, " +
    		"COMPANY_DIAG_BAS_DT2,EXT_CHG_CLASS_CODE,REC_DT,SEQ_LINK_ADDR,SEQ_LINK_CAPITAL,SEQ_LINK_NAME,SEQ_LINK_REP " +
    		") " +
    		"SELECT  " +
    		"SIDO_CODE,COMMANA_CLASS,MANA_NUM,NAME,REP_SSN1,REP_SSN2,REP_NM_KOR,REP_NM_HAN,REP_TEL_NUM,ADDR_POST_NUM,ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,ADDR_FAX_NUM,EMAIL_ADDR,OFFICE_AREA,OFFICE_USE_CODE, " +
    		"COMPANY_DIAG_CLASS_CODE,COMPANY_DIAG_BAS_DT,COMPANY_DIAG_ISSUE_DT,DIAG_ORG_CODE,DIAG_NM_NM,DIAG_NM_WRT_NUM,PAY_CAP,REA_CAP,TUP_AOM, " +
    		"TUP_CLASS_CODE,C_COM_DT,C_COM_CAUSE_CODE,COM_COV_DT,WRT_ID,UPD_DT," + sqlC_COM_DT + "," + sqlC_COM_DT + ",BAS_STA_DT,OFFICE_OWN_CLASS, " +
    		"(SELECT MAX(NVL(CHGBRE_SEQ, 0)) + 1 FROM PT_R_BASIC_CHANGE_HISTORY WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'), 'R00003', '" + scRECV_NUM + "', " + sqlC_COM_DT + ", 'STD003', " +
    		"TMP_WRT_NUM,COI_WRT_NUM,REP_MOBILE,LICTAX,HOSCRE,SND_DT,SND_STE,COM_NUM,ADDR_TEL_NUM1,ADDR_TEL_NUM2,ADDR_TEL_NUM3,ADDR_FAX_NUM1,ADDR_FAX_NUM2,ADDR_FAX_NUM3,REP_MOBILE1,REP_MOBILE2,REP_MOBILE3, " +
    		"NULL, NULL, '" + scRECV_DT + "', NULL, NULL, NULL, NULL " +
    		"FROM PT_R_COMPANY_MASTER " +
    		"WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' " 
    		);
	    	rDAO = new ReportDAO();
		    rDAO.execute(sQuery.toString() + sWhere.toString());
    	}
    	
    	// 법인전환일 경우는 기술자 정보 이양됨(1:양도양수 2:분할합병 3:법인전환)
    	if(!"3".equals(assi_ste)) {
			sQuery.delete(0, sQuery.length());
	    	sWhere.delete(0, sWhere.length());        	
	    	sQuery.append(" UPDATE PT_R_ENGINEER_CHANGE SET RET_YMD = " + sqlC_COM_DT);
	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
	        sWhere.append(" AND RET_YMD IS NULL ");
	        
	        rDAO = new ReportDAO();
	    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	}
    	
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	    	
    	sQuery.append(" UPDATE PT_R_REFFER SET RET_DT = " + sqlC_COM_DT);
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	
    }
    
    /*
    public void CloseCorpProc_trans(String sworkMODE, String scTMP_WRT_NUM) throws Exception 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sworkMODE = "CLO002";
        
    	sQuery.append(" UPDATE PT_R_COMPANY_MASTER SET C_COM_DT = TO_CHAR(SYSDATE, 'YYYYMMDD'), ");
        sQuery.append(" C_COM_CAUSE_CODE = '"+sworkMODE+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    }
    
    public void UpdateReferEngi_trans(String sworkMODE, String scTMP_WRT_NUM, String scOLDTMP_WRT_NUM) throws Exception 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();        
    	
    	sQuery.append(" UPDATE PT_R_ENGINEER_CHANGE SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");
        sWhere.append(" AND RET_YMD IS NULL ");
        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	    	
    	sQuery.append(" UPDATE PT_R_REFFER SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");
        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	
    }
    */
}