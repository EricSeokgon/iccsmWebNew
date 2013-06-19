/**
 * 파일명   : RegMgrCmd.java
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
import kjf.util.KJFLog;
import sp.util.keng.*;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class EngListMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public EngListMgrCmd() {
    }
   
    public EngListMgrCmd(String next_url) {
    	next = next_url;
    }  
 

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();

        
        
        String scISSUE_NUM = vl.getValueAsString("scISSUE_NUM");
        String scSSN = vl.getValueAsString("scSSN");
        String scNAME = vl.getValueAsString("scNAME");
        
        String [] sTSSN = new String[1];
        sTSSN[0] = scSSN;
    	String [] sNAME = {scNAME};
        
    	Dataset ds = new Dataset("output");
    	ds.addColumn("CARE_BOOK_ISSUE_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ENGINEER_SSN",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ENGINEER_SSN1",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ENGINEER_SSN2",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("NM_KOR",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("CARE_BOOK_VAL_START_DT",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("CARE_BOOK_VAL_END_DT",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ISSUE_DT",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("TMP_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("ENGINEER_GRADE",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("NAME",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("CORP",ColumnInfo.CY_COLINFO_STRING, 20);
    	
		if(KJFUtil.isEmpty(scNAME)){
			//KJFLog.log("#iccsSelectBySSN#");
			iccsSelectBySSN(dl, ds, sTSSN);
		} else {
			//KJFLog.log("#iccsSelectByName#");
			iccsSelectByName(dl, ds, sNAME);
		}
        
        request.setAttribute("dl", dl);  

        return next;
    }
    
    private void iccsSelectBySSN(DatasetList dl, Dataset ds, String[] sSSN) throws Exception
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	KengWorker kWorker = new KengWorker();
   		Kengineer kengs[]= kWorker.getKengs(sSSN);
   		
   		for(int i=0; i < kengs.length;i++ )
   		{
            Kengineer keng = kengs[i];
            String NM_KOR  =   keng.getNM_KOR();    
            String SSN        =   keng.getSSN();          
            String GRADE     =   keng.getGRADE();      
            String TMP_GRADE =   keng.getTMP_GRADE(); 
            String BOOK_NUM         =   keng.getBOOK_NUM();  
            String EDU_DT    =   keng.getEDU_DT();    
            String S_DT       =   keng.getS_DT();        
            String E_DT       =   keng.getE_DT();        
            String CORP      =   keng.getCORP();
            
            sQuery.delete(0, sQuery.length());
            sWhere.delete(0, sWhere.length());
            
            sQuery.append(" SELECT NAME FROM PT_R_COMPANY_MASTER ");
            sWhere.append(" WHERE COI_WRT_NUM = '" + CORP + "' ");
            sWhere.append(" AND C_COM_DT IS NULL ");
            
            rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
                        
            int row = ds.appendRow();
            ds.setColumn(row, "CARE_BOOK_ISSUE_NUM", BOOK_NUM);
            ds.setColumn(row, "ENGINEER_SSN", SSN);
            ds.setColumn(row, "ENGINEER_SSN1", SSN.substring(0, 6));
            ds.setColumn(row, "ENGINEER_SSN2", SSN.substring(6, 13));
            //System.out.println("======================== " + SSN.substring(6, 13));
            ds.setColumn(row, "NM_KOR", NM_KOR);
            ds.setColumn(row, "CARE_BOOK_VAL_START_DT", S_DT);
            ds.setColumn(row, "CARE_BOOK_VAL_END_DT", E_DT);
            ds.setColumn(row, "ISSUE_DT", "");
            ds.setColumn(row, "TMP_GRADE", TMP_GRADE);
            ds.setColumn(row, "ENGINEER_GRADE", GRADE);
            ds.setColumn(row, "NAME", rEntity.getValue(0, "NAME"));
            ds.setColumn(row, "CORP", CORP);          
   		}
 	
   		dl.addDataset(ds);
    }
    
    private void iccsSelectByName(DatasetList dl, Dataset ds, String[] sSSN) throws Exception
    {
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	KengWorker kWorker = new KengWorker();
   		Kengineer kengs[]= kWorker.getKengsName(sSSN);
   		
   		for(int i=0; i < kengs.length;i++ )
   		{
            Kengineer keng = kengs[i];
            String NM_KOR  =   keng.getNM_KOR();    
            String SSN        =   keng.getSSN();    
            String GRADE     =   keng.getGRADE();      
            String TMP_GRADE=   keng.getTMP_GRADE(); 
            String BOOK_NUM         =   keng.getBOOK_NUM();  
            String EDU_DT    =   keng.getEDU_DT();    
            String S_DT       =   keng.getS_DT();        
            String E_DT       =   keng.getE_DT();        
            String CORP      =   keng.getCORP();
            
            if (S_DT != null && S_DT.length() > 10)
            	S_DT = S_DT.substring(0, 10).replaceAll("-", "");
            
            if (E_DT != null && E_DT.length() > 10)
            	E_DT = E_DT.substring(0, 10).replaceAll("-", "");
            
            sQuery.delete(0, sQuery.length());
            sWhere.delete(0, sWhere.length());
            
            sQuery.append(" SELECT NAME FROM PT_R_COMPANY_MASTER ");
            sWhere.append(" WHERE COI_WRT_NUM = '" + CORP + "' ");
            sWhere.append(" AND C_COM_DT IS NULL ");
            
            //KJFLog.log("ssn=" + SSN + "=corp="+ CORP + "=SQL="+ sQuery.toString() + sWhere.toString());
            
            rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
            
            int row = ds.appendRow();
            ds.setColumn(row, "CARE_BOOK_ISSUE_NUM", BOOK_NUM);
            ds.setColumn(row, "ENGINEER_SSN", SSN);
            ds.setColumn(row, "ENGINEER_SSN1", SSN.substring(0, 6));
            ds.setColumn(row, "ENGINEER_SSN2", SSN.substring(6, 13));

            ds.setColumn(row, "NM_KOR", NM_KOR);
            ds.setColumn(row, "CARE_BOOK_VAL_START_DT", S_DT);
            //System.out.println("CARE_BOOK_VAL_START_DT = " + E_DT);
            ds.setColumn(row, "CARE_BOOK_VAL_END_DT", E_DT);
            ds.setColumn(row, "ISSUE_DT", "");

            ds.setColumn(row, "TMP_GRADE", TMP_GRADE);
            ds.setColumn(row, "ENGINEER_GRADE", GRADE);
            ds.setColumn(row, "NAME", rEntity.getValue(0, "NAME"));
            ds.setColumn(row, "CORP", CORP);            
   		}
 	
   		dl.addDataset(ds);
    }
}