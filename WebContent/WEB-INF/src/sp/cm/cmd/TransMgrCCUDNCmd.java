/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_M_MASTER_TEMPDAO;
import sp.dao.PT_M_MASTER_TEMPEntity;
import sp.dao.PT_R_ASSI_TRANS_STATEMENTDAO;
import sp.dao.PT_R_ASSI_TRANS_STATEMENTEntity;
import sp.dao.PT_R_BASIC_CHANGE_HISTORYDAO;
import sp.dao.PT_R_BASIC_CHANGE_HISTORYEntity;
import sp.dao.PT_R_COMPANY_MASTERDAO;
import sp.dao.PT_R_COMPANY_MASTEREntity;
import sp.dao.PT_R_DEFICITDAO;
import sp.dao.PT_R_DEFICITEntity;
import sp.dao.PT_R_ENGINEER_CHANGEDAO;
import sp.dao.PT_R_ENGINEER_CHANGEEntity;
import sp.dao.PT_R_ENGINEER_CHANGE_TEMPDAO;
import sp.dao.PT_R_ENGINEER_CHANGE_TEMPEntity;
import sp.dao.PT_R_MOT_STEDAO;
import sp.dao.PT_R_MOT_STEEntity;
import sp.dao.PT_R_REFFERDAO;
import sp.dao.PT_R_REFFEREntity;
import sp.dao.PT_R_REFUSAL_REASONDAO;
import sp.dao.PT_R_REFUSAL_REASONEntity;
import sp.dao.PT_R_REG_MEMODAO;
import sp.dao.PT_R_REG_MEMOEntity;
import sp.dao.PT_R_SUBSIDIARYDAO;
import sp.dao.PT_R_SUBSIDIARYEntity;
import sp.dao.PT_R_TRANS_COMPANY_BEFOREDAO;
import sp.dao.PT_R_TRANS_COMPANY_BEFOREEntity;
import sp.dao.PT_R_WORK_CAPABILITY_TEMPDAO;
import sp.dao.PT_R_WORK_CAPABILITY_TEMPEntity;
import sp.dao.PT_R_WORK_RESULTS_TEMPDAO;
import sp.dao.PT_R_WORK_RESULTS_TEMPEntity;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.VariableList;
 
  
    
public class TransMgrCCUDNCmd implements KJFCommand {
	
    private String next;
    private String scTMP_WRT_NUM;

    private PT_R_COMPANY_MASTERDAO    PT_R_COMPANY_MASTERdao = new PT_R_COMPANY_MASTERDAO();
    private PT_R_COMPANY_MASTEREntity PT_R_COMPANY_MASTEREnt = new PT_R_COMPANY_MASTEREntity();
    
    private PT_R_REFFERDAO    PT_R_REFFERdao = new PT_R_REFFERDAO();
    private PT_R_REFFEREntity PT_R_REFFEREnt = new PT_R_REFFEREntity();
    
    private PT_R_REG_MEMODAO    PT_R_REG_MEMOdao = new PT_R_REG_MEMODAO();
    private PT_R_REG_MEMOEntity PT_R_REG_MEMOEnt = new PT_R_REG_MEMOEntity();

    private PT_R_BASIC_CHANGE_HISTORYDAO    PT_R_BASIC_CHANGE_HISTORYdao = new PT_R_BASIC_CHANGE_HISTORYDAO();
    private PT_R_BASIC_CHANGE_HISTORYEntity PT_R_BASIC_CHANGE_HISTORYEnt = new PT_R_BASIC_CHANGE_HISTORYEntity();
    
    private PT_R_REFUSAL_REASONDAO    PT_R_REFUSAL_REASONdao = new PT_R_REFUSAL_REASONDAO();
    private PT_R_REFUSAL_REASONEntity PT_R_REFUSAL_REASONEnt = new PT_R_REFUSAL_REASONEntity();
    
    private PT_R_SUBSIDIARYDAO    PT_R_SUBSIDIARYdao = new PT_R_SUBSIDIARYDAO();
    private PT_R_SUBSIDIARYEntity PT_R_SUBSIDIARYEnt = new PT_R_SUBSIDIARYEntity();
    
    private PT_R_MOT_STEDAO PT_R_MOT_STEdao = new PT_R_MOT_STEDAO();
    private PT_R_MOT_STEEntity PT_R_MOT_STEEnt = new PT_R_MOT_STEEntity(); 
    
   
    private PT_R_ASSI_TRANS_STATEMENTDAO    PT_R_ASSI_TRANS_STATEMENTdao = new PT_R_ASSI_TRANS_STATEMENTDAO();
    private PT_R_ASSI_TRANS_STATEMENTEntity PT_R_ASSI_TRANS_STATEMENTEnt = new PT_R_ASSI_TRANS_STATEMENTEntity();
    
    private PT_R_TRANS_COMPANY_BEFOREDAO    PT_R_TRANS_COMPANY_BEFOREdao = new PT_R_TRANS_COMPANY_BEFOREDAO();
    private PT_R_TRANS_COMPANY_BEFOREEntity PT_R_TRANS_COMPANY_BEFOREEnt = new PT_R_TRANS_COMPANY_BEFOREEntity();
    
    private PT_R_DEFICITDAO    PT_R_DEFICITdao = new PT_R_DEFICITDAO();
    private PT_R_DEFICITEntity PT_R_DEFICITEnt = new PT_R_DEFICITEntity();

    private PT_R_ENGINEER_CHANGEDAO    PT_R_ENGINEER_CHANGEdao = new PT_R_ENGINEER_CHANGEDAO();
    private PT_R_ENGINEER_CHANGEEntity PT_R_ENGINEER_CHANGEEnt = new PT_R_ENGINEER_CHANGEEntity();
    
    private PT_R_ENGINEER_CHANGE_TEMPDAO    PT_R_ENGINEER_CHANGE_TEMPdao = new PT_R_ENGINEER_CHANGE_TEMPDAO();
    private PT_R_ENGINEER_CHANGE_TEMPEntity PT_R_ENGINEER_CHANGE_TEMPEnt = new PT_R_ENGINEER_CHANGE_TEMPEntity();

    private PT_R_WORK_RESULTS_TEMPDAO    PT_R_WORK_RESULTS_TEMPdao = new PT_R_WORK_RESULTS_TEMPDAO();
    private PT_R_WORK_RESULTS_TEMPEntity PT_R_WORK_RESULTS_TEMPEnt = new PT_R_WORK_RESULTS_TEMPEntity();
    
    private PT_R_WORK_CAPABILITY_TEMPDAO    PT_R_WORK_CAPABILITY_TEMPdao = new PT_R_WORK_CAPABILITY_TEMPDAO();
    private PT_R_WORK_CAPABILITY_TEMPEntity PT_R_WORK_CAPABILITY_TEMPEnt = new PT_R_WORK_CAPABILITY_TEMPEntity();
    
    private PT_M_MASTER_TEMPDAO    PT_M_MASTER_TEMPdao = new PT_M_MASTER_TEMPDAO();
    private PT_M_MASTER_TEMPEntity PT_M_MASTER_TEMPEnt = new PT_M_MASTER_TEMPEntity();
    
    


    
    private VariableList vl = new VariableList();
    
    public TransMgrCCUDNCmd() {
    }

    public TransMgrCCUDNCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	vl = pReq.getVariableList();
    	
    	String scMODE = vl.getValueAsString("workMODE");
    	
    	/** List 획득 및 Dataset 획득 **/
    	Dataset ds;
    	
    	if (scMODE.equalsIgnoreCase("ALL"))
    	{
    		    		
    	    		
        	ReportDAO rDAO;
    		StringBuilder sQuery = new StringBuilder();
          		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT");
    		
    		String a_tmp_num = "";
    		String t_tmp_num = "";
    		String a_gubun = "";
    		String t_gubun = "";
    		String a_assi_ste = "";
    		String sRecv_num  = "";
    		String sSIDO_CODE = "";
    		
    		if (ds != null){
    			
    			if ("STD003".equals(ds.getColumnAsString(0, "MOT_STE"))){
	    			sQuery.delete(0, sQuery.length());
	    			
	    			a_tmp_num = ds.getColumnAsString(0, "ASSI_TMP_WRT_NUM");
	    			t_tmp_num = ds.getColumnAsString(0, "TRAN_TMP_WRT_NUM");
	    			a_gubun = ds.getColumnAsString(0, "ASSI_GUBUN");
	    			t_gubun = ds.getColumnAsString(0, "TRAN_GUBUN");
	    			a_assi_ste = ds.getColumnAsString(0, "ASSI_STE");
	    			sRecv_num = ds.getColumnAsString(0, "RECV_NUM");
	    			sSIDO_CODE = ds.getColumnAsString(0, "SIDO_CODE");
	    			
	    			/**
	    			 * 실적  백업
	    			 */
	    			sQuery.append(" DELETE FROM PT_R_WORK_RESULTS_TEMP ");
    				sQuery.append(" WHERE TMP_WRT_NUM in ('" + t_tmp_num + "','"+ a_tmp_num +"')");
    				rDAO = new ReportDAO();
    				rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
	    	       	
	    			sQuery.append(" INSERT INTO PT_R_WORK_RESULTS_TEMP "); 
	    			sQuery.append(" SELECT SEQ, '"+sRecv_num+"' AS RECV_NUM, TMP_WRT_NUM, ");
	    			sQuery.append(" '"+sSIDO_CODE+"' AS SIDO_CODE, 'T' AS WORK_PROC, YEAR, WORK_ROM, WRT_ID, UPD_DT, INS_DT");
	    			sQuery.append(" FROM PT_R_WORK_RESULTS WHERE TMP_WRT_NUM IN ('" + t_tmp_num + "','"+ a_tmp_num +"')");
	    			PT_R_WORK_RESULTS_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());
	    			rDAO = new ReportDAO();
	            	rDAO.execute(sQuery.toString());
	            	sQuery.delete(0, sQuery.length());
	            	
	            	/**
	            	 * 시공능력 백업
	            	 */
	            	sQuery.append(" DELETE FROM PT_R_WORK_CAPABILITY_TEMP ");
    				sQuery.append(" WHERE TMP_WRT_NUM in ('" + t_tmp_num + "','"+ a_tmp_num +"')");
    				rDAO = new ReportDAO();
    				rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
	    	       	
	    			sQuery.append(" INSERT INTO PT_R_WORK_CAPABILITY_TEMP "); 
	    			sQuery.append(" SELECT SEQ,TMP_WRT_NUM, '"+sRecv_num+"' AS RECV_NUM,  ");
	    			sQuery.append(" '"+sSIDO_CODE+"' AS SIDO_CODE, 'T' AS CAP_PROC, COI_WRT_NUM, ASSE_DT, ASSE_AOM,");
	    			sQuery.append(" APPL_TERM_START_DT, CONFIRM, WRT_ID, UPD_DT, INS_DT, APPL_TERM_END_DT,SEQ_LINK_CAPABILITY");
	    			sQuery.append(" FROM PT_R_WORK_CAPABILITY WHERE TMP_WRT_NUM IN ('" + t_tmp_num + "','"+ a_tmp_num +"')");
	    			PT_R_WORK_CAPABILITY_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());
	    			rDAO = new ReportDAO();
	            	rDAO.execute(sQuery.toString());
	            	sQuery.delete(0, sQuery.length());
	            	
	    	       	/**
	    	       	 * 행정처분백업 
	    	       	 */
	            	sQuery.append(" DELETE FROM PT_M_MASTER_TEMP ");
    				sQuery.append(" WHERE TMP_WRT_NUM in ('" + t_tmp_num + "','"+ a_tmp_num +"')");
    				rDAO = new ReportDAO();
    				rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
	    	       	
	    			sQuery.append(" INSERT INTO PT_M_MASTER_TEMP ");
	    			sQuery.append(" SELECT M.*  ");
	    			//sQuery.append(", '"+sRecv_num+"' AS AT_RECV_NUM,'T' AS MAST_PROC");
	    			sQuery.append(" FROM PT_M_MASTER M WHERE M.TMP_WRT_NUM IN ('" + t_tmp_num + "','"+ a_tmp_num +"')");
	    			PT_M_MASTER_TEMPEnt.setINS_DT(KJFDate.getCurDatetime());
	    			rDAO = new ReportDAO();
	            	rDAO.execute(sQuery.toString());
	    			sQuery.delete(0, sQuery.length());
	    			
	            	/**
	            	 * 양도양수   			-> 실적, 시공능력	-> 신규 처리
	            	 * 법인전환, 분할합병 	-> 실적,시공능력 	-> 이양
	            	 */
   
        			if ("1".equals(a_assi_ste)){	
        				sQuery.append(" DELETE FROM PT_R_WORK_RESULTS ");
        				sQuery.append(" WHERE TMP_WRT_NUM in ('" + t_tmp_num + "','"+ a_tmp_num +"')");
        				rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
        			}
        			/*
        			if(!"".equals(a_tmp_num) || t_tmp_num != "null" ){
        				sQuery.append(" UPDATE PT_R_WORK_RESULTS ");
        				sQuery.append(" SET TMP_WRT_NUM = '"+ a_tmp_num +"'");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        			}
        			*/
        			if("3".equals(a_assi_ste) && "1".equals(t_gubun) ){
        				sQuery.append(" DELETE FROM PT_R_WORK_RESULTS ");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        				rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
    	    	       	
        				sQuery.append(" UPDATE PT_R_WORK_RESULTS ");
        				sQuery.append(" SET TMP_WRT_NUM = '"+ a_tmp_num +"'");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        				
        				rDAO = new ReportDAO();
    	            	rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
        			}
        			/*
	            	rDAO = new ReportDAO();
	            	rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
	    	       	*/
	    	       	if ("1".equals(a_assi_ste)){	
        				sQuery.append(" DELETE FROM PT_R_WORK_CAPABILITY ");
        				sQuery.append(" WHERE TMP_WRT_NUM in ('" + t_tmp_num + "','"+ a_tmp_num +"')");
        				rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
        			}  
	    	       	/*
	    	       	if(!"".equals(a_tmp_num) ||  t_tmp_num != "null" ){
        				sQuery.append(" UPDATE PT_R_WORK_CAPABILITY ");
        				sQuery.append(" SET TMP_WRT_NUM = '"+ a_tmp_num +"'");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        			}
	            	rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
                    */ 
	    	    	if("3".equals(a_assi_ste) && "1".equals(t_gubun) ){
	    	    		sQuery.append(" DELETE FROM PT_R_WORK_CAPABILITY ");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        				rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
    	    	       	
    	    	       	sQuery.append(" UPDATE PT_R_WORK_CAPABILITY ");
        				sQuery.append(" SET TMP_WRT_NUM = '"+ a_tmp_num +"'");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        				
        				rDAO = new ReportDAO();
    	            	rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
        			}
	    	    	/**
	    	       	 * 공사업마스터 분할합병 양도자 플래그 처리
	    	       	 */
	    	    	if("3".equals(a_assi_ste) && "1".equals(t_gubun) ){
	    	    			    	    		
    	    	       	sQuery.append(" UPDATE PT_R_COMPANY_MASTER ");
        				sQuery.append(" SET TRANS_UNION_PARENT ='"+ t_tmp_num +"', TRANS_UNION_PROC = 'Y' ");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + a_tmp_num + "' ");
        				
        				rDAO = new ReportDAO();
    	            	rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
        			}
	    	       	/**
	    	       	 * 행정처분 ALL 이양
	    	       	 */
        			if(!"".equals(a_tmp_num) || !"".equals(t_tmp_num)){
        				sQuery.append(" DELETE FROM PT_M_MASTER ");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        				rDAO.execute(sQuery.toString());
    	    	       	sQuery.delete(0, sQuery.length());
    	    	       	
        				sQuery.append(" UPDATE PT_M_MASTER ");
        				sQuery.append(" SET TMP_WRT_NUM = '"+ a_tmp_num +"'");
        				sQuery.append(" WHERE TMP_WRT_NUM = '" + t_tmp_num + "' ");
        			}
	            	rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
    			}
    			
	        	dsProc(ds);
    		}
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
  	       
    		if (ds != null)
    		{
    		     if ("STD003".equals(ds.getColumnAsString(0, "MOT_STE")) && "1".equals(ds.getColumnAsString(0, "TRAN_GUBUN"))){
    	    	String scTMP_WRT_NUMS = vl.getValueAsString("scTMP_WRT_NUMS");
    		    a_tmp_num = ds.getColumnAsString(0, "ASSI_TMP_WRT_NUM");    		    	 
    		    			    			
            	String deleteQuery = " UPDATE PT_R_COMPANY_MASTER " +
            			" SET TRANS_UNION_PARENT ='"+scTMP_WRT_NUM+"', TRANS_UNION_PROC = 'Y' " +
            			" WHERE TMP_WRT_NUM IN (" + a_tmp_num + ")";
            	rDAO = new ReportDAO();
            	rDAO.execute(deleteQuery);

    			dsProc(ds);
    		}
            } 		
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_TRANS_COMPANY_BEFORE");
    		if (ds != null) dsProc(ds);

    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");    		
    		if (ds != null) dsProc(ds);
    	
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE");   
    		
    		if (ds != null) {
    			sQuery.delete(0, sQuery.length());
        		for (int cnt=0; cnt < ds.getRowCount(); cnt++){
	        		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE ");
	        		sQuery.append(" WHERE TMP_WRT_NUM = '" + ds.getColumnAsString(cnt, "TMP_WRT_NUM") + "' ");
	        		sQuery.append(" AND RET_YMD IS NULL ");
	        		
	            	rDAO = new ReportDAO();
	            	rDAO.execute(sQuery.toString());
	    	       	sQuery.delete(0, sQuery.length());
        		}
            	dsProc(ds);
    		}
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFUSAL_REASON");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_MOT_STE");
    		if (ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_COMPANY_MASTER");
    		if (ds != null) dsProc(ds);

    		ds = pReq.getDatasetList().getDataset("dsPT_R_BASIC_CHANGE_HISTORY");
    		if (ds != null) dsProc(ds);
   		
    	} 
    	else if (scMODE.equalsIgnoreCase("SUBSIDIARY")) //  겸험 저장
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_SUBSIDIARY");
    		if(ds != null) dsProc(ds);
    	}   
    	else if (scMODE.equalsIgnoreCase("RECV_NUM_CHECK_SV")) // 접수번호
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT");
    		if(ds != null) dsProc(ds);
    		
    		ds = pReq.getDatasetList().getDataset("dsPT_R_MOT_STE");		//세부업무진행사항
    		if(ds != null) dsProc(ds);
    		
    	}	  
    	else if (scMODE.equalsIgnoreCase("ENGINEER"))	// 보유기술자 
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ENGINEER_CHANGE_TEMP");
    		if(ds != null) dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("REFUSAL"))	// 등록결격사유
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFUSAL_REASON");
    		dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("REPER"))		// 임직원 정보
    	{
    		ds = pReq.getDatasetList().getDataset("dsPT_R_REFFER");
    		dsProc(ds);
    	}
    	else if (scMODE.equalsIgnoreCase("ALL_DEL")){	// 조회 데이터 삭제
    		ds = pReq.getDatasetList().getDataset("dsPT_R_ASSI_TRANS_STATEMENT_LI");
    		if(ds != null) dsProc(ds);
    	}
    	

        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception
    {
    	for(int i=0;i<ds.getRowCount();i++){
    		if(ds.getRowStatus(i).equals("insert")) insertExe(ds,i);
    		if(ds.getRowStatus(i).equals("update")) updateExe(ds,i);
    	}

    	/****** Dataset을 DELETE처리 ****/
    	for(int i = 0 ; i< ds.getDeleteRowCount() ; i++ ){
    		deleteExe(ds,i);
    	}
    }

    /**
     * 입력
     * @param Dataset ds, int arg_row
     * @return
     */
    private void insertExe(Dataset ds, int arg_row)throws Exception{
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);

        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		

       		if ("".equals(ds.getColumnAsString(0, "INS_DT"))){
       			PT_R_COMPANY_MASTEREnt.setINS_DT(KJFDate.getCurDatetime());        			
       		}
       		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());       		       		
       		PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
 
    	}
       	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
       		String scTMP_WRT_NUMS = vl.getValueAsString("scTMP_WRT_NUMS");
       		
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setCHGBRE_SEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(0, "TMP_WRT_NUM"), "PT_R_BASIC_CHANGE_HISTORY", "CHGBRE_SEQ"));
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setINS_DT(KJFDate.getCurDatetime());
    	    //PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());        			

        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.insert(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{    		
    		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);//
    		PT_R_REFFEREnt.setINS_DT(KJFDate.getCurDatetime());
    		PT_R_REFFEREnt.setSEQ(
    	    		getMaxChangeSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_REFFER", "SEQ"));
        	KJFLog.debug(PT_R_REFFEREnt.toString()); 		    	
        	PT_R_REFFERdao.insert(PT_R_REFFEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
    	{
    		PT_R_SUBSIDIARYEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_SUBSIDIARYEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_SUBSIDIARYEnt.toString()); 		    	
        	PT_R_SUBSIDIARYdao.insert(PT_R_SUBSIDIARYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFUSAL_REASON"))
    	{
    		PT_R_REFUSAL_REASONEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_REFUSAL_REASONEnt.setINS_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFUSAL_REASONEnt.toString()); 		    	
        	PT_R_REFUSAL_REASONdao.insert(PT_R_REFUSAL_REASONEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{	
    		 String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    		 
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setINS_DT(KJFDate.getCurDatetime()); 
    		//PT_R_ENGINEER_CHANGE_TEMPEnt.setRECV_NUM(KJFMi.dsGet(ds, arg_row, "RECV_TEMP"));
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setRECV_NUM(scRECV_NUM);

    		PT_R_ENGINEER_CHANGE_TEMPEnt.setSEQ(
    				getMaxChangeEngSeq(ds.getColumnAsString(arg_row, "RECV_NUM"), "PT_R_ENGINEER_CHANGE_TEMP", "SEQ"));
    		
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setENG_PROC("T");
        	KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGE_TEMPdao.insert(PT_R_ENGINEER_CHANGE_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE"))
    	{	
    		PT_R_ENGINEER_CHANGEEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGEEnt.setINS_DT(KJFDate.getCurDatetime());
    		//PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
    		PT_R_ENGINEER_CHANGEEnt.setSEQ(
    				getMaxChangeSeq(ds.getColumnAsString(arg_row, "TMP_WRT_NUM"), "PT_R_ENGINEER_CHANGE", "SEQ"));
        	
    		PT_R_ENGINEER_CHANGEEnt.setUPD_DT(KJFDate.getCurDatetime());
       		
    		KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	

        	PT_R_ENGINEER_CHANGEdao.insert(PT_R_ENGINEER_CHANGEEnt);
    	}    	
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_MOT_STE"))
    	{
    		PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);    		
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.insert(PT_R_MOT_STEEnt);
    	}   
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ASSI_TRANS_STATEMENT")) 
    	{
    		PT_R_ASSI_TRANS_STATEMENTEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ASSI_TRANS_STATEMENTEnt.setINS_DT(KJFDate.getCurDatetime());
    		//PT_R_ASSI_TRANS_STATEMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ASSI_TRANS_STATEMENTEnt.toString()); 		    	
        	PT_R_ASSI_TRANS_STATEMENTdao.insert(PT_R_ASSI_TRANS_STATEMENTEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_TRANS_COMPANY_BEFORE"))	// 양도양수 공사업업체의 이전 정보 협회에 전송시 이전테이블에 전송하는 역할 
    	{
    		PT_R_TRANS_COMPANY_BEFOREEnt.setDsOnlyString(ds, arg_row);
    		PT_R_TRANS_COMPANY_BEFOREEnt.setINS_DT(KJFDate.getCurDatetime());
    		//PT_R_TRANS_COMPANY_BEFOREEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_TRANS_COMPANY_BEFOREEnt.toString()); 		    	
        	PT_R_TRANS_COMPANY_BEFOREdao.insert(PT_R_TRANS_COMPANY_BEFOREEnt);
        	
    	}
    	else  if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_DEFICITEnt.toString());
    		PT_R_DEFICITdao.insert(PT_R_DEFICITEnt);
    	}
    	
    }
    
    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
       	if(ds.getId().equalsIgnoreCase("dsPT_R_COMPANY_MASTER"))
    	{
    		PT_R_COMPANY_MASTEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_COMPANY_MASTEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_COMPANY_MASTEREnt.toString()); 		    	
        	PT_R_COMPANY_MASTERdao.update(PT_R_COMPANY_MASTEREnt);
    	}
       	else if(ds.getId().equalsIgnoreCase("dsPT_R_BASIC_CHANGE_HISTORY"))
    	{
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setDsOnlyString(ds, arg_row);//
    	    PT_R_BASIC_CHANGE_HISTORYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_BASIC_CHANGE_HISTORYEnt.toString()); 		    	
        	PT_R_BASIC_CHANGE_HISTORYdao.update(PT_R_BASIC_CHANGE_HISTORYEnt);
    	}
       	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFUSAL_REASON"))
    	{
    		PT_R_REFUSAL_REASONEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_REFUSAL_REASONEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFUSAL_REASONEnt.toString()); 		    	
        	PT_R_REFUSAL_REASONdao.update(PT_R_REFUSAL_REASONEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{
    		PT_R_REFFEREnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_REFFEREnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_REFFEREnt.toString()); 		    	
        	PT_R_REFFERdao.update(PT_R_REFFEREnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
    	{
    		PT_R_SUBSIDIARYEnt.setDsOnlyString(ds, arg_row);// 
    		PT_R_SUBSIDIARYEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_SUBSIDIARYEnt.toString()); 		    	
        	PT_R_SUBSIDIARYdao.update(PT_R_SUBSIDIARYEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{
    		
    		String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setRECV_NUM(scRECV_NUM);

    		PT_R_ENGINEER_CHANGE_TEMPEnt.setDsOnlyString(ds, arg_row);//
    		PT_R_ENGINEER_CHANGE_TEMPEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ENGINEER_CHANGE_TEMPEnt.toString()); 		    	
        	PT_R_ENGINEER_CHANGE_TEMPdao.update(PT_R_ENGINEER_CHANGE_TEMPEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_MOT_STE"))
    	{
    		// 양도양수는 공사업체를 반복 지정시에 BRECHG_SEQ에 문제가 발생하여 아래 내용으로 보완을 함
    		// dao 생성 하면 안되면 변경이 있으면 아래의 내용으로 수정해야함 MOT_PROC= T -> 양동양수처리건
    		// where 조건   
            //sb.append(" and SIDO_CODE = ").append( toDB(entity.getSIDO_CODE()));
            //sb.append(" and RECV_NUM = ").append( toDB(entity.getRECV_NUM()));
            //sb.append(" and MOT_STE = ").append( toDB(entity.getMOT_PROC()));
    		
    		PT_R_MOT_STEEnt.setDsOnlyString(ds, arg_row);
    		KJFLog.debug(PT_R_MOT_STEEnt.toString());
    		PT_R_MOT_STEdao.update(PT_R_MOT_STEEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ASSI_TRANS_STATEMENT"))
    	{
    		PT_R_ASSI_TRANS_STATEMENTEnt.setDsOnlyString(ds, arg_row);
    		PT_R_ASSI_TRANS_STATEMENTEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_ASSI_TRANS_STATEMENTEnt.toString()); 		    	
        	PT_R_ASSI_TRANS_STATEMENTdao.update(PT_R_ASSI_TRANS_STATEMENTEnt);
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_TRANS_COMPANY_BEFORE"))
    	{
    		PT_R_TRANS_COMPANY_BEFOREEnt.setDsOnlyString(ds, arg_row);
    		PT_R_TRANS_COMPANY_BEFOREEnt.setUPD_DT(KJFDate.getCurDatetime());
        	KJFLog.debug(PT_R_TRANS_COMPANY_BEFOREEnt.toString()); 		    	
        	PT_R_TRANS_COMPANY_BEFOREdao.update(PT_R_TRANS_COMPANY_BEFOREEnt);
    	}   
    	 else  if(ds.getId().equalsIgnoreCase("dsPT_R_DEFICIT"))
    	{
    		String[] fields = {"DEFICIT_CONTENT"};
    		PT_R_DEFICITEnt.setDsOnlyString(ds, arg_row);
    		PT_R_DEFICITdao.updateExcludeOnly(PT_R_DEFICITEnt, fields);
    	}
    	
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	
    	String sKey = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
    	
    	if ("null".equals(sKey) || "".equals(sKey) || sKey == null){
    		sKey = "";
    	}

    	//String scTMP_WRT_NUM = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();    
    	
    	String deleteQuery;
    	
    	ReportDAO rDAO;
    	
    	if(ds.getId().equalsIgnoreCase("dsPT_R_SUBSIDIARY"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_SUBSIDIARY ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		//sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ENGINEER_CHANGE_TEMP"))
    	{
        	
    		//String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
    		//String sRECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString().trim();
    		
    		String sTMP_WRT_NUM = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString().trim();
   	
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//System.out.println("KEY ============= " + sKey);
    		
    		sQuery.append(" DELETE FROM PT_R_ENGINEER_CHANGE_TEMP ");
    		sQuery.append(" WHERE ENG_PROC='T' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		sQuery.append(" AND TMP_WRT_NUM = '" + sTMP_WRT_NUM + "' ");    		
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFUSAL_REASON"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_REFUSAL_REASON ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_REFFER"))
    	{
    		StringBuilder sQuery = new StringBuilder();
    		
    		String sSEQ = ds.getDeleteColumn(arg_row,"SEQ").getString();
    		//String sChgSeq = ds.getDeleteColumn(arg_row,"CHGBRE_SEQ").getString();
    		
    		sQuery.append(" DELETE FROM PT_R_REFFER ");
    		sQuery.append(" WHERE TMP_WRT_NUM = '" + sKey + "' ");
    		sQuery.append(" AND SEQ = '" + sSEQ + "' ");
    		//sQuery.append(" AND CHGBRE_SEQ = '" + sChgSeq + "' ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	
        	return;
    	}
    	else if(ds.getId().equalsIgnoreCase("dsPT_R_ASSI_TRANS_STATEMENT_LI"))
    	{       

        	String sRECV_NUM = ds.getDeleteColumn(arg_row,"RECV_NUM").getString().trim();
        	//String sKey1 = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
        	String sKey2 = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
        	//String sKey1 = vl.getValueAsString("sKey1");

        	String sKey1 = vl.getValueAsString("scTMP_WRT_NUM");
            System.out.println("KEY1============= " + sKey1);
            
        	if ("null".equals(sKey2) || "".equals(sKey2) || sKey2 == null){
        		sKey2 = "";
        	}
        	
    		deleteQuery = " DELETE FROM PT_R_ENGINEER_CHANGE_TEMP WHERE";
    		deleteQuery += " ENG_PROC='T' AND RECV_NUM='"+sRECV_NUM+"'";
    		
    			
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_REFFER WHERE TMP_WRT_NUM = '" + sKey1 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_SUBSIDIARY WHERE TMP_WRT_NUM = '" + sKey1 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_REFUSAL_REASON WHERE TMP_WRT_NUM = '" + sKey1 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
        	deleteQuery = " DELETE FROM PT_R_MOT_STE WHERE RECV_NUM = '" + sRECV_NUM + "' AND MOT_PROC ='T' AND SIDO_CODE ='"+sKey2+"'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    		PT_R_ASSI_TRANS_STATEMENTEnt.setRECV_NUM(sRECV_NUM);
    		PT_R_ASSI_TRANS_STATEMENTEnt.setSIDO_CODE(sKey2);
    		PT_R_ASSI_TRANS_STATEMENTdao.delete(PT_R_ASSI_TRANS_STATEMENTEnt);

    		PT_R_TRANS_COMPANY_BEFOREEnt.setRECV_NUM(sRECV_NUM);
    		PT_R_TRANS_COMPANY_BEFOREEnt.setTMP_WRT_NUM(sKey1);
    		PT_R_TRANS_COMPANY_BEFOREEnt.setSIDO_CODE(sKey2);
    		PT_R_TRANS_COMPANY_BEFOREdao.delete(PT_R_TRANS_COMPANY_BEFOREEnt);
    		
    		deleteQuery = " DELETE FROM PT_R_DEFICIT WHERE RECV_NUM = '" + sRECV_NUM + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sKey2 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
        	
    	} 	//#############신규로 추가 2010-11-19 ~###############    	
    	else 
    	{	
    		sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();
    		
    		//String sKey1 = ds.getDeleteColumn(arg_row,"TMP_WRT_NUM").getString();
    		String sKey1 = vl.getValueAsString("sKey1");
        	String sKey2 = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();
        	   
        	if ("null".equals(sKey2) || "".equals(sKey2) || sKey2 == null){
        		sKey2 = "";
        	}
        	
    		if ("".equals(sKey.trim())){sKey = ds.getDeleteColumn(arg_row,"RECV_NUM").getString();}
    		if ("".equals(sKey2.trim())){sKey2 = ds.getDeleteColumn(arg_row,"SIDO_CODE").getString();}
		
    		//PT_R_ASSI_TRANS_STATEMENTEnt.setRECV_NUM(sKey);
    		//PT_R_ASSI_TRANS_STATEMENTEnt.setSIDO_CODE(sKey2);
    		//PT_R_ASSI_TRANS_STATEMENTdao.delete(PT_R_ASSI_TRANS_STATEMENTEnt);

    		PT_R_TRANS_COMPANY_BEFOREEnt.setRECV_NUM(sKey);
    		PT_R_TRANS_COMPANY_BEFOREEnt.setTMP_WRT_NUM(sKey1);
    		PT_R_TRANS_COMPANY_BEFOREEnt.setSIDO_CODE(sKey2);
    		PT_R_TRANS_COMPANY_BEFOREdao.delete(PT_R_TRANS_COMPANY_BEFOREEnt);
    		
    		deleteQuery = " DELETE FROM PT_R_DEFICIT WHERE RECV_NUM = '" + sKey + "'";
    		deleteQuery += " AND SIDO_CODE = '" + sKey2 + "'";
        	rDAO = new ReportDAO();
        	rDAO.execute(deleteQuery);
    		
    	}
    }
    
   private String getMaxChangeEngSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        
        System.out.println("KEY ============= " + scRECV_NUM);
        
        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE RECV_NUM = '" + scRECV_NUM + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
   
   
    private String getMaxChangeSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	 
        ReportDAO rDAO = new ReportDAO();
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        
        
        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
    
}