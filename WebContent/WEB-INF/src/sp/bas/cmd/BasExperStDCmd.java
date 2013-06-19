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

public class BasExperStDCmd implements KJFCommand {
	private String next;
	private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
	public BasExperStDCmd(){
		
	}
	public BasExperStDCmd(String next_url){
		next = next_url;
	}
	
	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
		/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scBookNum = vl.getValueAsString("scBookNum");
        String scName = vl.getValueAsString("scName");
        String scSsn = vl.getValueAsString("scSsn");
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sQuery.append(" SELECT  CARE_BOOK_ISSUE_NUM, NM_KOR, (ENGINEER_SSN1 || '-' || ENGINEER_SSN2) AS SSN, ");
        sQuery.append(" DECODE(TRIM(ENGINEER_GRADE), '1', '�ʱ�', '2', '�߱�', '3', '���', '4', 'Ư��', '') AS TMPENGINEER_GRAD, ");
        sQuery.append(" CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ADDR, ENGINEER_GRADE ");
        sQuery.append(" FROM PT_R_ENGINEER_MASTER ");
        
        sWhere.append(" WHERE 1 = 1 ");
        if(scBookNum.length() > 0)
        	sWhere.append(" AND CARE_BOOK_ISSUE_NUM LIKE '%" + scBookNum + "%' ");
        if(scSsn.length() > 0)
        	sWhere.append(" AND (ENGINEER_SSN1 || ENGINEER_SSN2) LIKE '%" + scSsn + "%' ");
        if(scName.length() > 0)
        	sWhere.append(" AND NM_KOR LIKE '" + scName + "%' ");
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;  
           
        rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);
        
		return next;
	}

}
