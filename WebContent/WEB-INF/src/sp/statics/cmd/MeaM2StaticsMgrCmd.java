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

public class MeaM2StaticsMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public MeaM2StaticsMgrCmd() {
    }

    public MeaM2StaticsMgrCmd(String next_url) {
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
       
        sQuery.append(" SELECT VIOL_CONT_CODE ,NVL(BB.CODE_NAME,'') CODE_NAME,NVL(AA.SIDO_CODE,'') SIDO_CODE,COUNT(*) M_CNT ");
        sQuery.append(" FROM PT_M_MASTER AA,PT_COM_CODE BB "); 
       
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND AA.VIOL_CONT_CODE = BB.CODE ");
        sWhere.append(" AND P_CODE='PTMPRO'");
        sWhere.append(" AND SIDO_CODE = '"+scSIDO_CODE+"' ");
        
        sWhere.append(" GROUP BY AA.VIOL_CONT_CODE,NVL(BB.CODE_NAME,''),NVL(AA.SIDO_CODE,'') ");
        sWhere.append(" ORDER BY AA.VIOL_CONT_CODE ASC ");
        
    	
    	rEntity    = rDAO.select(sQuery.toString()+sWhere.toString());   
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        
        request.setAttribute("dl", dl);  
    
        
        return next;
    }

}
