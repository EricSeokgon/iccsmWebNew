/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.sample.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys_m.Sys_mParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegReceiptMgrCCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegReceiptMgrCCmd() {
    }

    public RegReceiptMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scREC_NUM = vl.getValueAsString("REC_NUM");
        String scREG_NUM = vl.getValueAsString("REG_NUM");
                
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
                
        //�ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
        String selectSQL = "";
        String whereSQL = "";
        
        if (scREG_NUM != null && scREG_NUM.length() > 0){
	        selectSQL = " SELECT * FROM PT_SAMPLE ";
	    	
	    	whereSQL = " WHERE	1=1	\n";
	    	whereSQL += "  AND	REC_NUM = '" + scREC_NUM + "' \n";
	    	whereSQL += "  AND	REG_NUM = '" + scREG_NUM + "' \n";
        }
        else
        {
        	selectSQL = " SELECT REC_NUM FROM PT_SAMPLE ";
	    	
	    	whereSQL = " WHERE	1=1	\n";
	    	whereSQL += "  AND	REC_NUM = '" + scREC_NUM + "' \n";
        }
        
    	rEntity    = rDAO.select(selectSQL + whereSQL);    	
    	//DB���� �������� ����Ÿ �� �߰������� 1���� ROW�� �߰��Ͽ� ����� ���  ReEnt2CodeDs
    	//�� ����Ѵ�.
      
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}