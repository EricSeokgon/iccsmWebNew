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

public class BeforeDataMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeDataMgrCmd() {
    }

    public BeforeDataMgrCmd(String next_url) {
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
    	
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        
    	String selectSQL=
    		"	SELECT  ORPE_NM,USE,AREA,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,NUM_FL  \n";
    	
    	String fromSQL = " FROM PT_UB_CONSTRUCTION  \n";
    	
    	String whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"'  \n" +
    					  "	 AND SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "  AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
       	
    	
    	String orderSQL = "  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}