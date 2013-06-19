/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.sys_m.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class SidoCodeMgrCCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public SidoCodeMgrCCmd() {
    }

    public SidoCodeMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        ReportEntity sEntity     = null;
        
        /****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scSIDO_NM = vl.getValueAsString("scSIDO_NM");
        String scSIGUNGU_NM = vl.getValueAsString("scSIGUNGU_NM");
        String scAREA_CODE = vl.getValueAsString("scAREA_CODE");
        
    	String selectSQL=
    		"	SELECT '0' AS CHECKER, SEQ, SIDO_NM, SIGUNGU_NM, TEL, ADDR, OFFPART, AREA_CODE, HOME  \n" ;
    	
    	String fromSQL = " FROM PT_SIDO_CODE  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n";
    	
    	
    	if(!KJFUtil.isEmpty(scSIDO_NM)){    		 
    		whereSQL += "AND SIDO_NM = '"+scSIDO_NM+"'";    		
    	}
    	
    	if(!KJFUtil.isEmpty(scSIGUNGU_NM)){
    		whereSQL += "AND SIGUNGU_NM LIKE '%"+scSIGUNGU_NM+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scAREA_CODE)){
    		whereSQL += "AND AREA_CODE LIKE '"+scAREA_CODE+"%'";
    	}
    	
    	String orderSQL = " ORDER BY SEQ ASC ";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
//      �ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
    	String subSQL=
    		" SELECT SIDO_NM FROM PT_SIDO_CODE GROUP BY SIDO_NM ORDER BY SIDO_NM ASC    ";
    	sEntity    = rDAO.select(subSQL);    
    	KJFMi.ReEnt2Ds(dl,sEntity,"output2");
    	 
        request.setAttribute("dl", dl);  

        return next;
    }


}