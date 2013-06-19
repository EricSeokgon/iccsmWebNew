/**
 * 파일명	: CorpChgStatusCmd.java
 * 설명		: 양수양도 및 합병 시 처리
 * 이력사항
 * CH00     : 2010/01/14 김원 최초작성
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

public class CorpChgStatusCmd implements KJFCommand {
	
    private String next;
    
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CorpChgStatusCmd() {
    }

    public CorpChgStatusCmd(String next_url) {
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
           
    	if(sworkMODE.equalsIgnoreCase("AM_TRANS"))
    		UpdateM_MASTER(scTMP_WRT_NUM, scOLDTMP_WRT_NUM);  
    	else if(sworkMODE.equalsIgnoreCase("CORP_UNION"))
    		UpdateCorp_union(scTMP_WRT_NUM, scOLDTMP_WRT_NUM);
    	else if(sworkMODE.equalsIgnoreCase("TRANS_2"))
    		UpdateCorp_trans_2(scTMP_WRT_NUM, scOLDTMP_WRT_NUM);
    	else if(sworkMODE.equalsIgnoreCase("TRANS_3"))
    		UpdateCorp_trans_3(scTMP_WRT_NUM, scOLDTMP_WRT_NUM);
        
        return next;
    }    
    
    /** 행정처분 이양 **********/
    public void UpdateM_MASTER(String scTMP_WRT_NUM, String scOLDTMP_WRT_NUM) throws Exception 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	sQuery.append(" UPDATE PT_M_MASTER SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");
        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	
    	// 서울시, 양도양수시 기술자정보 가져오기
    	// 이미 폐업처리 되어 있어 별도 구현.
    	
    }
    
    /** 겸업사항 이양 **********/
    public void UpdateR_SUBSIDIARY(String scTMP_WRT_NUM, String scOLDTMP_WRT_NUM) throws Exception 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	sQuery.append(" UPDATE PT_R_SUBSIDIARY SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");
        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    }
    
    /** 합병시 처리 *********************/
    private int getLastROM_results(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT WORK_ROM FROM PT_R_WORK_RESULTS";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "' AND YEAR = (";
        sQuery += " 	SELECT MAX(YEAR) FROM PT_R_WORK_RESULTS WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        sQuery += " 	)";
        ReportEntity rEntity     = null;
        
        int v = 0;
        
        try {
        	rEntity = rDAO.select(sQuery);
        	v = Integer.parseInt(rEntity.getValue(0,"WORK_ROM"));
        } catch(Exception e) {        	
        }
        return v;
    }
    
    private int getLastAOM_capability(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT ASSE_AOM FROM PT_R_WORK_CAPABILITY";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "' AND ASSE_DT = (";
        sQuery += " 	SELECT MAX(ASSE_DT) FROM PT_R_WORK_CAPABILITY WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        sQuery += " 	)";
        ReportEntity rEntity     = null;
        
        int v = 0;
        
        try {
        	rEntity = rDAO.select(sQuery);
        	v = Integer.parseInt(rEntity.getValue(0,"WORK_ROM"));
        } catch(Exception e) {        	
        }
        return v;
    }
    
    private int getMaxSeq_subsidairy(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT MAX(SEQ) as SEQ FROM PT_R_SUBSIDIARY";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        int v = 0;
        
        try {
        	rEntity = rDAO.select(sQuery);
        	v = Integer.parseInt(rEntity.getValue(0,"SEQ"));
        } catch(Exception e) {        	
        }
        return v;
    }
    
    private ReportEntity getSeq_subsidairy(String oldtmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT SEQ FROM PT_R_SUBSIDIARY";        
        sQuery += " WHERE TMP_WRT_NUM = '" + oldtmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);
        return rEntity;
    }
    
    private int getMaxSeq_reffer(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT MAX(SEQ) as SEQ FROM PT_R_REFFER";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        int v = 0;
        
        try {
        	rEntity = rDAO.select(sQuery);
        	v = Integer.parseInt(rEntity.getValue(0,"SEQ"));
        } catch(Exception e) {        	
        }
        return v;
    }
    
    private ReportEntity getSeq_reffer(String oldtmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT SEQ FROM PT_R_REFFER";        
        sQuery += " WHERE TMP_WRT_NUM = '" + oldtmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);
        return rEntity;
    }
    
    private int getMaxSeq_engineer(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT MAX(SEQ) as SEQ FROM PT_R_ENGINEER_CHANGE";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        int v = 0;
        
        try {
        	rEntity = rDAO.select(sQuery);
        	v = Integer.parseInt(rEntity.getValue(0,"SEQ"));
        } catch(Exception e) {        	
        }
        return v;
    }
    
    private ReportEntity getSeq_engineer(String oldtmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT SEQ FROM PT_R_ENGINEER_CHANGE";        
        sQuery += " WHERE TMP_WRT_NUM = '" + oldtmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);
        return rEntity;
    }
    
    private boolean has_results(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT TMP_WRT_NUM FROM PT_R_WORK_RESULTS";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);
        
        if(rEntity == null) return false;
        else return true;
    }
    
    private boolean has_capability(String tmp_wrt_num) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT TMP_WRT_NUM FROM PT_R_WORK_CAPABILITY";        
        sQuery += " WHERE TMP_WRT_NUM = '" + tmp_wrt_num + "'";
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);
        
        if(rEntity == null) return false;
        else return true;
    }

    public void UpdateCorp_union(String scTMP_WRT_NUM, String scOLDTMP_WRT_NUM) throws Exception 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        // 실적
        /*
        int old_rom = getLastROM_results(scOLDTMP_WRT_NUM); 
        
        if(old_rom > 0) { // 존속되지 않는 업체의 실적이 있을 경우        	
        	if(has_results(scTMP_WRT_NUM)) { // 존속업체의 실적이 있을경우
        		sQuery.append(" UPDATE PT_R_WORK_RESULTS SET WORK_ROM = TO_NUMBER(WORK_ROM) + " + old_rom);
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'  AND ");
    	        sWhere.append("    YEAR = (SELECT MAX(YEAR) FROM PT_R_WORK_RESULTS WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "')"); 
    	        rDAO = new ReportDAO();        
    	    	rDAO.execute(sQuery.toString() + sWhere.toString());
        	} else {
        		sQuery.append(" UPDATE PT_R_WORK_RESULTS SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'  AND ");
    	        sWhere.append("    YEAR = (SELECT MAX(YEAR) FROM PT_R_WORK_RESULTS WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "')"); 
    	        rDAO = new ReportDAO();        
    	    	rDAO.execute(sQuery.toString() + sWhere.toString());
        	}
        }
        */
        /*
        // 시공능력
        sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	   
    	int old_aom = getLastAOM_capability(scOLDTMP_WRT_NUM);
    	
    	if(old_aom > 0) { // 존속되지 않는 업체의 시공능력이 없을 경우
        	if(has_capability(scTMP_WRT_NUM)) {	// 존속업체의 시공능력이 있을경우
        		sQuery.append(" UPDATE PT_R_WORK_CAPABILITY SET ASSE_AOM = TO_NUMBER(ASSE_AOM) + " + old_aom);
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'  AND ");
    	        sWhere.append("    ASSE_DT = (SELECT MAX(ASSE_DT) FROM PT_R_WORK_CAPABILITY WHERE TMP_WRT_NUM = '" + scTMP_WRT_NUM + "')"); 
    	        rDAO = new ReportDAO();        
    	    	rDAO.execute(sQuery.toString() + sWhere.toString());
        	} else {
        		sQuery.append(" UPDATE PT_R_WORK_CAPABILITY SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'  AND ");
    	        sWhere.append("    ASSE_DT = (SELECT MAX(ASSE_DT) FROM PT_R_WORK_CAPABILITY WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "')"); 
    	        rDAO = new ReportDAO();        
    	    	rDAO.execute(sQuery.toString() + sWhere.toString());
        	}
        }
    	
    	
    	// 자본금
        
        // 행정처분
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	    	
    	sQuery.append(" UPDATE PT_M_MASTER SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());        
        */
        int max_seq = 0;
        /*
        // 겸업사항    	
    	rMasterEntity = getSeq_subsidairy(scOLDTMP_WRT_NUM);
    	
    	if(rMasterEntity != null) {
    		max_seq = getMaxSeq_subsidairy(scTMP_WRT_NUM);
    		for(int i=0;i<rMasterEntity.getRowCnt();i++) {
    			sQuery.delete(0, sQuery.length());
    	    	sWhere.delete(0, sWhere.length());	    	
    	        sQuery.append(" UPDATE PT_R_SUBSIDIARY SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"', " +
    	        		"	SEQ = '" + (++max_seq + 1) + "'");
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' AND SEQ = '" + rMasterEntity.getValue(i, "SEQ")+"'");        
    	        rDAO = new ReportDAO();
    	    	rDAO.execute(sQuery.toString() + sWhere.toString());    			
    		}
    	}
    	*/
    	
        // 임원
    	rMasterEntity = getSeq_reffer(scOLDTMP_WRT_NUM);
    	if(rMasterEntity != null) {
    		max_seq = getMaxSeq_reffer(scTMP_WRT_NUM);
    		for(int i=0;i<rMasterEntity.getRowCnt();i++) {
		    	sQuery.delete(0, sQuery.length());
		    	sWhere.delete(0, sWhere.length());	    	
		    	sQuery.append(" UPDATE PT_R_REFFER SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"', " +
    	        		"	SEQ = '" + (++max_seq + 1) + "'");
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' AND SEQ = '" + rMasterEntity.getValue(i, "SEQ")+"'");    
		        rDAO = new ReportDAO();
		    	rDAO.execute(sQuery.toString() + sWhere.toString());
    		}
    	}
       
        // 기술자
    	rMasterEntity = getSeq_engineer(scOLDTMP_WRT_NUM);
    	if(rMasterEntity != null) {
    		max_seq = getMaxSeq_engineer(scTMP_WRT_NUM);
    		for(int i=0;i<rMasterEntity.getRowCnt();i++) {
		    	sQuery.delete(0, sQuery.length());
		    	sWhere.delete(0, sWhere.length());	    	
		    	sQuery.append(" UPDATE PT_R_ENGINEER_CHANGE SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"', " +
    	        		"	SEQ = '" + (++max_seq + 1) + "'");
    	        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' AND SEQ = '" + rMasterEntity.getValue(i, "SEQ")+"'");    
		        rDAO = new ReportDAO();
		        
		        if (!"".equals(KJFUtil.print(scTMP_WRT_NUM,""))){
		        	rDAO.execute(sQuery.toString() + sWhere.toString());
		        }
		        
    		}
    	}
    	
    }
    
    public void UpdateCorp_trans_2(String scOLDTMP_WRT_NUM, String scTMP_WRT_NUM) throws Exception	// 법인전환일 경우 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        // 실적
        sQuery.append(" UPDATE PT_R_WORK_RESULTS SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' " +
        		" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'"); 
    	rDAO = new ReportDAO();        
    	rDAO.execute(sQuery.toString() + sWhere.toString());
        
        // 시공능력
        sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	   
    	
		sQuery.append(" UPDATE PT_R_WORK_CAPABILITY SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'" +
				" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'"); 
        rDAO = new ReportDAO();        
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	
    	// 자본금 -> 신규
        
        // 행정처분
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	    	
    	sQuery.append(" UPDATE PT_M_MASTER SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());        
        
        // 겸업사항    --> 신규
     	
        // 임원 --> 신규
       
        // 기술자 --> 신규     	
    }
    
    public void UpdateCorp_trans_3(String scOLDTMP_WRT_NUM, String scTMP_WRT_NUM) throws Exception	// 법인전환일 경우 
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        // 실적
        sQuery.append(" UPDATE PT_R_WORK_RESULTS SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "' " +
        		" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'"); 
    	rDAO = new ReportDAO();        
    	rDAO.execute(sQuery.toString() + sWhere.toString());
        
        // 시공능력
        sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	   
    	
		sQuery.append(" UPDATE PT_R_WORK_CAPABILITY SET TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'" +
				" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'"); 
        rDAO = new ReportDAO();        
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    	
    	// 자본금 -> 신규
        
        // 행정처분
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	    	
    	sQuery.append(" UPDATE PT_M_MASTER SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' ");
        sWhere.append(" WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "' ");        
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());        
        
        // 겸업사항    	
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	 
    	sQuery.append(" UPDATE PT_R_SUBSIDIARY SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' " +
    	        		"	WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'");    	        
        rDAO = new ReportDAO();
     	rDAO.execute(sQuery.toString() + sWhere.toString());    			
     	
        // 임원 --> 신규
       
        // 기술자    	
     	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());	 
		sQuery.append(" UPDATE PT_R_ENGINEER_CHANGE SET TMP_WRT_NUM = '"+scTMP_WRT_NUM+"' " +
    	        		"	WHERE TMP_WRT_NUM = '" + scOLDTMP_WRT_NUM + "'");    	     
        rDAO = new ReportDAO();
    	rDAO.execute(sQuery.toString() + sWhere.toString());
    }
    
}