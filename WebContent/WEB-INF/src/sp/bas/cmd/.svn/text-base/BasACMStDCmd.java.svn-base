package sp.bas.cmd;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

public class BasACMStDCmd implements KJFCommand {
	private String next;
	private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BasACMStDCmd(){
    	
    }
    
    public BasACMStDCmd(String next_url){
    	next = next_url;
    }
    
public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
		/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;   
    	
    	vl = pReq.getVariableList();
    	String sWorkMODE = vl.getValueAsString("workMODE");
    	String scP_CODE = vl.getValueAsString("scP_CODE");
    	String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
    	String scNAME = vl.getValueAsString("scNAME");
    	
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	if(sWorkMODE.equalsIgnoreCase("CODE"))
    	{
    		sQuery.append(" SELECT AREA_CODE AS CODE, SIDO_NM AS CODE_NAME ");
    		sQuery.append(" FROM PT_SIDO_CODE ");
    		sWhere.append(" WHERE SUBSTR(AREA_CODE, 0, 2) = SUBSTR(AREA_CODE, 3, 2) and  AREA_CODE <>'tete' ");
    		sWhere.append(" ORDER BY SIDO_NM  ");
    		
    		rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
            KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	}
    	else if(sWorkMODE.equalsIgnoreCase("RegReCompany"))
    	{
    		sQuery.append(" SELECT TMP_WRT_NUM, COI_WRT_NUM, MANA_NUM, NAME, ADDR_ADDR,ADDR_POST_NUM,ADDR_DETAIL_ADDR,ADDR_TEL_NUM,REP_NM_KOR ");
    		sQuery.append(" FROM PT_R_COMPANY_MASTER ");
    		sWhere.append(" WHERE 1 = 1 ");
    		sWhere.append(" AND COI_WRT_NUM = '" + scCOI_WRT_NUM + "' ");
    		sWhere.append(" AND ( TRANS_UNION_PROC IS NULL OR TRANS_UNION_PROC = 'N' OR TRANS_UNION_PROC = 'null')" );
    		
    		rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
            KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	}	
    	else
    	{
    		sQuery.append(" SELECT TMP_WRT_NUM, COI_WRT_NUM, MANA_NUM, NAME, ADDR_ADDR, DECODE(C_COM_DT, NULL, '', '폐업') AS C_COM_DT, DECODE(TRANS_UNION_PROC, NULL, '', '양수,합병') AS TRANS_UNION_PROC ");
    		sQuery.append(" FROM PT_R_COMPANY_MASTER ");
    		sWhere.append(" WHERE 1 = 1 ");
    		//sWhere.append(" AND TRIM(C_COM_DT) IS NULL");
    		//sWhere.append(" AND ( TRANS_UNION_PROC IS NULL OR TRANS_UNION_PROC = 'N' OR TRANS_UNION_PROC = 'null')" );
    		
    		if(!KJFUtil.isEmpty(scP_CODE))    
    			if (!"ALL".equals(scP_CODE)){
    				sWhere.append(" AND SIDO_CODE = '" + scP_CODE + "' ");
    			}
    		if(!KJFUtil.isEmpty(scCOI_WRT_NUM))
    			sWhere.append(" AND COI_WRT_NUM = '" + scCOI_WRT_NUM + "' ");
    		if(!KJFUtil.isEmpty(scNAME))
    			sWhere.append(" AND NAME LIKE '%" + scNAME + "%' ");
    		sWhere.append(" ORDER BY COI_WRT_NUM ");
    		
    		//sWhere.append("and rownum < 50 ");
    		rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
            KJFMi.ReEnt2Ds(dl,rEntity,"output");
    	}

        request.setAttribute("dl", dl);
        
        return next;
	}
}
