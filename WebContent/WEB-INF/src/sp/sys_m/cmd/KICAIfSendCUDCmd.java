/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2008/12/22 김경덕 최초작성
 */

package sp.sys_m.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_TMP_TRANS_KEYDAO;
import sp.dao.PT_TMP_TRANS_KEYEntity;

import kjf.util.KJFDate;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;



public class KICAIfSendCUDCmd implements KJFCommand {
	
    private String next;
    
    private PT_TMP_TRANS_KEYDAO    dao = new PT_TMP_TRANS_KEYDAO();
    private PT_TMP_TRANS_KEYEntity Eent = new PT_TMP_TRANS_KEYEntity();

    
    public KICAIfSendCUDCmd() {
    }


    public KICAIfSendCUDCmd(String next_url) {
    	next = next_url;
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {   	    	
    	
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** List 획득 및 Dataset 획득 **/
    	
    	Dataset ds = pReq.getDatasetList().getDataset("dsPT_TMP_TRANS_KEY");
    	
    	dsProc(ds);
    	

        return next;
    }
    
    private void dsProc(Dataset ds) throws Exception{
    	/******** Dataset을 INSERT, UPDATE처리 ********/
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
    	
    	Eent.setDsOnlyString(ds, arg_row);//
    	Eent.setSEQ(getMaxSeq("PT_TMP_TRANS_KEY"));
    	Eent.setINS_DT(KJFDate.getCurDatetime()); 
    	dao.insert(Eent);
    	
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	String sCode = Eent.getWORK_CLASS_CODE();
    	String sKey1 = Eent.getKEY1();
		String sKey2 = Eent.getKEY2();
		String sDate = ds.getColumnAsString(arg_row, "INS_DT");

    	if (sCode.equalsIgnoreCase("R00012"))
    	{
    		
    		sQuery.append(" UPDATE PT_M_MASTER SET SND_STE = 'O', ");
    		sQuery.append(" SND_DT = '" + sDate + "' ");
    		sWhere.append(" WHERE TMP_WRT_NUM = '" + sKey1 + "' ");
    		sWhere.append(" AND WRT_NUM = '" + sKey2 + "' ");
    	  
    		ReportDAO rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString() + sWhere.toString());
    	}
  
    	
 
    }
    


    /**
     * 수정
     * @param Dataset ds, int arg_row
     * @return
     */
    private void updateExe(Dataset ds, int arg_row)throws Exception{
    		
    	/****** Dataset one_row 값 전체 자동 세팅 ******/
    	Eent.setDsOnlyString(ds, arg_row);//     	
    	dao.update(Eent);
    }

    /**
     * 삭제
     * @param Dataset ds, int arg_row
     * @return
     */
    private void deleteExe(Dataset ds, int arg_row)throws Exception{
    	Eent.setSEQ(ds.getDeleteColumn(arg_row,"SEQ").getString());
    	dao.delete(Eent);
    }
    
    private String getMaxSeq(String sTABLE) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(SEQ)), 0) + 1 MAX_ID ";
        sQuery += " FROM " + sTABLE + " ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"MAX_ID");
    }
}