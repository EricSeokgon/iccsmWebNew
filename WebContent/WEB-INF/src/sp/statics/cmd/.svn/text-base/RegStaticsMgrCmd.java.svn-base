package sp.statics.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

public class RegStaticsMgrCmd implements KJFCommand {
	
	 	private String next;	
	    private DatasetList  dl = new DatasetList();
	    private VariableList vl = new VariableList();
	    
	    public RegStaticsMgrCmd() {
	    }

	    public RegStaticsMgrCmd(String next_url) {
	    	next = next_url;
	    }

	    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
	    	
	        ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity rEntity     = null;
	        
	        StringBuilder sQuery = new StringBuilder();
	        StringBuilder sWhere = new StringBuilder();
	        
	        //String bb = vl.getValueAsString("bb");
	        //String scDATE2 = vl.getValueAsString("scDATE2");
	        
	        sQuery.append(" SELECT BB.SIDO_NM,AA.SIDO_CODE ");
	        sQuery.append(" FROM V_PT_R_STATICS AA,PT_SIDO_CODE BB"); 
	       
	        sWhere.append(" WHERE 1=1 ");
	        sWhere.append(" AND AA.SIDO_CODE=BB.AREA_CODE ");
	        sWhere.append(" ORDER BY SIDO_CODE DESC ");
	        
	    	
	    	rEntity    = rDAO.select(sQuery.toString()+sWhere.toString());   	    	
	        
	        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
	        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	        	        	       
	        request.setAttribute("dl", dl);  
	       	        
	        return next;
	    }


}
