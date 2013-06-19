/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.ub.cmd;

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

public class BeforeSchMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeSchMgrCmd() {
    }

    public BeforeSchMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        /****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scCIV_RECV_NUM = vl.getValueAsString("scCIV_RECV_NUM");
        String scORPE_NM = vl.getValueAsString("scORPE_NM");
        String scPLANER_NAME = vl.getValueAsString("scPLANER_NAME");
        String scRECV_DT = vl.getValueAsString("scRECV_DT");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        
    	String selectSQL=
    		"	SELECT CIV_RECV_NUM,RECV_DT,ORPE_NM,'0' AS CHECKER,RECV_NUM,    \n" +
    		"		   PLANER_NAME, SW_BEF_REPO_DELINUM   \n";
    	
    	String fromSQL = " FROM PT_UB_CONSTRUCTION  \n";
    	
    	String whereSQL = "WHERE SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "  AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scORPE_NM)){
    		whereSQL += "AND ORPE_NM LIKE '"+scORPE_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scPLANER_NAME)){
    		whereSQL += "AND PLANER_NAME LIKE '%"+scPLANER_NAME+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_DT)){
    		whereSQL += "AND RECV_DT LIKE '"+scRECV_DT+"%'  \n";
    	}
    	
       	
    	
    	String orderSQL = "ORDER BY RECV_DT DESC  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}