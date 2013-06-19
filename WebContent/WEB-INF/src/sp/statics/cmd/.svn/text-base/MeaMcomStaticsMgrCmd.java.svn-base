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

public class MeaMcomStaticsMgrCmd implements KJFCommand {
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public MeaMcomStaticsMgrCmd() {
    }

    public MeaMcomStaticsMgrCmd(String next_url) {
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
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        //String scDATE2 = vl.getValueAsString("scDATE2");
       
        sQuery.append(" SELECT SUBSTR(AA.VIOL_DT,1,4) M_YEAR,NVL(AA.SIDO_CODE,'') SIDO_CODE,NVL(BB.SIDO_NM,'') SIDO_NM,COUNT(*) M_CNT ");
        sQuery.append(" FROM PT_M_MASTER AA,PT_SIDO_CODE BB "); 
       
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND AA.VIOL_DT IS NOT NULL ");
        sWhere.append(" AND AA.SIDO_CODE = BB.AREA_CODE ");
        sWhere.append(" AND SIDO_CODE = '"+scSIDO_CODE+"' ");
        
        sWhere.append(" GROUP BY SUBSTR(AA.VIOL_DT,1,4),NVL(AA.SIDO_CODE,''),NVL(BB.SIDO_NM,'') ");
        sWhere.append(" ORDER BY M_YEAR ASC ");
        
        
    	rEntity    = rDAO.select(sQuery.toString()+sWhere.toString());   
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        
        request.setAttribute("dl", dl);  
    
        
        return next;
    }

}
