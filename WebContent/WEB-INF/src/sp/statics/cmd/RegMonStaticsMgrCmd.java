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

public class RegMonStaticsMgrCmd implements KJFCommand{
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegMonStaticsMgrCmd() {
    }

    public RegMonStaticsMgrCmd(String next_url) {
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
        String scTDATE = vl.getValueAsString("scTDATE").substring(0,6);
        String scFDATE = vl.getValueAsString("scFDATE").substring(0,6);
        
       
        sQuery.append(" SELECT COM_YMONTH,NVL(SIDO_CODE,'') SIDO_CODE,NVL(SIDO_NM,'') SIDO_NM,COUNT(*) ");
        sQuery.append(" FROM V_PT_R_STATICS_YEAR "); 
       
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND COM_YMONTH IS NOT NULL ");
        sWhere.append(" AND COM_YMONTH BETWEEN "+scFDATE+" AND "+scTDATE);
        sWhere.append(" AND SIDO_CODE = '"+scSIDO_CODE+"' ");
        
        sWhere.append(" GROUP BY COM_YMONTH,NVL(SIDO_CODE,''),NVL(SIDO_NM,'') ");
        sWhere.append(" ORDER BY COM_YMONTH ASC ");
       
    	
    	rEntity    = rDAO.select(sQuery.toString()+sWhere.toString());   
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        
        request.setAttribute("dl", dl);  
    
        
        return next;
    }

}
