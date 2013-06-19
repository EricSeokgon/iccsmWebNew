package sp.st.cmd;
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

public class EngineerChgListMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public EngineerChgListMgrCmd () {
    }

    public  EngineerChgListMgrCmd (String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API ÃÊ±âÈ­ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server¿¡¼­ XML¼ö½Å ¹× Parsing **/
    	pReq.receiveData();
    	/** º¯¼ö È¹µæ **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
    	String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
		String scREP_NM = vl.getValueAsString( "scREP_NM" );
		String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
       // String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");

        //String scCLOSE = vl.getValueAsString("scCLOSE");
        
//        sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, PT_M.REP_NM_KOR, PT_M.MANA_NUM, ");
//        sQuery.append(" DECODE(PT_M.C_COM_DT, NULL, '', 'Æó¾÷') AS C_COM_DT, ");
//        sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM ");
//        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_M ");
        
        sQuery.append(" select a.COI_WRT_NUM, b.name, a.WRT_CHG_DT, a.CHG_STA_DT, a.ENGINEER_NM,a.ENGINEER_SSN1||'-'||a.ENGINEER_SSN2 as ENGINEER_SSN, a.EMPL_YMD, a.RET_YMD,b.sido_code ");
        sQuery.append(" from PT_TMP_ENGINEER_CHANGE a, PT_R_company_master b  ");
        sQuery.append(" where 1=1 ");
        sQuery.append(" and a.seq in(  ");
        sQuery.append(" select max(seq) seq from PT_TMP_ENGINEER_CHANGE  ");
        sQuery.append(" where cud_flag !='D' ");
        sQuery.append(" group by ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2, WRT_CHG_DT,  SIDO_CODE, COI_WRT_NUM ) ");
        // sWhere.append(" AND PT_H.TMP_WRT_NUM = '" + scTMP_WRT_NUM + "'");
        sQuery.append(" and a.coi_wrt_num =b.coi_wrt_num ");
        //sWhere.append(" AND PT_C.CODE is not null ");
    	sWhere.append( " AND (a.CHG_STA_DT BETWEEN '" + scDATE1 + "' " );
		sWhere.append( " AND '" + scDATE2 + "') " );
		
        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND a.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND b.NAME LIKE '%" + scNAME + "%'");
       
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        	sWhere.append(" AND b.SIDO_CODE = '" + scSIDO_CODE + "'");
       
        if (!KJFUtil.isEmpty( scREP_NM ) )
        	
		sWhere.append( "AND b.REP_NM_KOR LIKE '%" + scREP_NM + "%' " );
        sWhere.append( "ORDER BY a.COI_WRT_NUM , ENGINEER_SSN1 " );
        
        /*
        if (!KJFUtil.isEmpty(scCLOSE)) {
        	if( scCLOSE.equals( "A" ) )
        		sWhere.append(" AND C_COM_DT IS NULL");
        	else if( scCLOSE.equals( "C" ) )
        		sWhere.append(" AND C_COM_DT IS NOT NULL");
        }
  */  	
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}
