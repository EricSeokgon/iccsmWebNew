package sp.statics.cmd;

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

public class RegEgradeStaticsMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegEgradeStaticsMgrCmd() {
    }

    public RegEgradeStaticsMgrCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        //String scDATE2 = vl.getValueAsString("scDATE2");
       
        sQuery.append(" SELECT COMMANA_CLASS,NVL(SIDO_CODE,'') SIDO_CODE,NVL(SIDO_NM,'') SIDO_NM,COUNT(*) ");
        sQuery.append(" FROM V_PT_R_STATICS_YEAR "); 
       
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND COMMANA_CLASS IS NOT NULL ");
        sWhere.append(" AND SIDO_CODE = '"+scSIDO_CODE+"' ");
        
        sWhere.append(" GROUP BY COMMANA_CLASS,NVL(SIDO_CODE,''),NVL(SIDO_NM,'') ");
        //sWhere.append(" ORDER BY COM_YEAR ASC ");
        
    	
    	rEntity    = rDAO.select(sQuery.toString()+sWhere.toString());   
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        
        request.setAttribute("dl", dl);  
    
        
        return next;
    }

}
