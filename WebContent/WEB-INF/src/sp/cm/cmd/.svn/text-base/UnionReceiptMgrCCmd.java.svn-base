package sp.cm.cmd;
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
public class UnionReceiptMgrCCmd implements KJFCommand {
	
	
    ReportDAO    rDAO        = new ReportDAO();
    ReportEntity rEntity     = null;
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
	
    public UnionReceiptMgrCCmd(){

	}

	public UnionReceiptMgrCCmd(String next_url){
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
	    ReportEntity rEntity     = null;
	
	  
        String scTMP_WRT_NUM = vl.getValueAsString("scTMP_WRT_NUM");
    	String RECV_NUM = vl.getValueAsString("RECV_NUM"); 
    	String scCHECK = vl.getValueAsString("CHECK"); 
    	String sworkMODE = vl.getValueAsString("workMODE");
    	String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
    	
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();

        if(scCHECK.equalsIgnoreCase("TRUE"))
        {
        	sQuery.append(" SELECT RECV_NUM FROM PT_R_UNION_STATEMENT ");
        	sWhere.append(" WHERE	1=1	\n");
        	sWhere.append("  AND	RECV_NUM = '" + RECV_NUM + "' \n");
        	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	    	
	        KJFMi.ReEnt2Ds(dl,rEntity,"dsCheckKey"); 
        }
        else if(scCHECK.equalsIgnoreCase("FALSE"))
        {
	        if (sworkMODE.equalsIgnoreCase("ACTIVE"))
	        {
		        sQuery.append(" SELECT  TMP_WRT_NUM, COI_WRT_NUM, MANA_NUM, REP_NM_KOR, REP_NM_HAN, ");
		        sQuery.append(" ADDR_TEL_NUM, NAME,ADDR_DETAIL_ADDR,ADDR_ADDR,ADDR_POST_NUM");
		        sQuery.append(" FROM PT_R_COMPANY_MASTER");
		        sWhere.append(" WHERE 	1 = 1 ");	        	
		        if(scTMP_WRT_NUM.length() > 0)
		        	sWhere.append(" AND     RTRIM(TMP_WRT_NUM) = '" + scTMP_WRT_NUM + "' ");
	
		    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	
		        KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_COMPANY");         
	        }
	        else if (sworkMODE.equalsIgnoreCase("PASSIVE"))
	        {
		        sQuery.append(" SELECT  TMP_WRT_NUM, COI_WRT_NUM, MANA_NUM, REP_NM_KOR, REP_NM_HAN, ");
		        sQuery.append(" ADDR_TEL_NUM, NAME,ADDR_DETAIL_ADDR,ADDR_ADDR,ADDR_POST_NUM");
		        sQuery.append(" FROM PT_R_COMPANY_MASTER");
		        sWhere.append(" WHERE 	1 = 1 ");	        	
		        if(scTMP_WRT_NUM.length() > 0)
		        	sWhere.append(" AND     RTRIM(TMP_WRT_NUM) = '" + scTMP_WRT_NUM + "' ");
	
		    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
	
		        KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_COMPANY");        
	        }
        }
        else if(scCHECK.equalsIgnoreCase("MODIFY"))
        {
        		      
        	sQuery.append(" SELECT PDEF.*, PDEF_CODE.CONT ");
	        sQuery.append(" FROM PT_R_DEFICIT PDEF LEFT JOIN PT_R_DEFICIT_CODE PDEF_CODE ");
	        sQuery.append(" ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND PDEF.RECV_NUM = '" + RECV_NUM + "' ");
	        sWhere.append(" AND PDEF_CODE.DEFI_GROUP = 'GUBU' ");
	       	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_R_DEFICIT");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
		    
        	sQuery.append(" SELECT * ");
	       	sQuery.append(" FROM PT_R_UNION_STATEMENT ");
	       	sQuery.append(" WHERE RECV_NUM = '"+RECV_NUM+"'");
	       	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
        	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_R_UNION_STATEMENT");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
		    sQuery.append(" SELECT * ");
	       	sQuery.append(" FROM PT_R_MEMO ");
	       	sQuery.append(" WHERE RECV_NUM = '"+RECV_NUM+"'");
	       	sWhere.append("  AND	SIDO_CODE = '" + scSIDO_CODE + "' \n");
	       	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_R_MEMO");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
        	sQuery.append(" SELECT AA.NAME, AA.COI_WRT_NUM, AA.MANA_NUM, AA.REP_NM_KOR, AA.REP_NM_HAN, AA.ADDR_ADDR, AA.ADDR_TEL_NUM, AA.ADDR_DETAIL_ADDR, AA.ADDR_POST_NUM, AA.TMP_WRT_NUM ");
	       	sQuery.append(" FROM PT_R_COMPANY_MASTER AA  INNER JOIN PT_R_UNION_STATEMENT BB  ");
	        sQuery.append(" ON AA.TMP_WRT_NUM = BB.ASC_TMP_WRT_NUM");
	       	sQuery.append(" WHERE BB.RECV_NUM = '"+RECV_NUM+"'");
	       	sWhere.append("  AND	BB.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_ACOMPANY");
	        sQuery.delete(0, sQuery.length());
	       	sWhere.delete(0, sWhere.length());
	       	
	       	sQuery.append(" SELECT AA.NAME, AA.COI_WRT_NUM, AA.MANA_NUM, AA.REP_NM_KOR, AA.REP_NM_HAN, AA.ADDR_ADDR, AA.ADDR_TEL_NUM, AA.ADDR_DETAIL_ADDR, AA.ADDR_POST_NUM, AA.TMP_WRT_NUM ");
	       	sQuery.append(" FROM PT_R_COMPANY_MASTER AA  INNER JOIN PT_R_UNION_STATEMENT BB ");
	        sQuery.append(" ON AA.TMP_WRT_NUM = BB.HANDED_TMP_WRT_NUM");
	       	sQuery.append(" WHERE BB.RECV_NUM = '"+RECV_NUM+"'");
	       	sWhere.append("  AND	BB.SIDO_CODE = '" + scSIDO_CODE + "' \n");
	    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_PCOMPANY");      
        }
        else
	    {
	        	//Deficit Codes Table
	       	sQuery.append(" SELECT * ");
	       	sQuery.append(" FROM PT_R_DEFICIT_CODE ");
	       	sQuery.append(" WHERE DEFI_GROUP = 'GUBU' ");
	
	       	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
		    KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_R_DEFICIT_CODE");
	    }
	        request.setAttribute("dl", dl);
        return next;
    }
}
