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

public class UsebeforeFlSchMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UsebeforeFlSchMgrCmd() {
    }

    public UsebeforeFlSchMgrCmd(String next_url) {
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
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String scRECV_DT = vl.getValueAsString("scRECV_DT");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
        
    	String selectSQL=
    		"	SELECT CIV_RECV_NUM,RECV_DT,APPLPER_NM,OPE_NAME,    \n" +
    		"		   RECV_NUM   \n";
    	
    	String fromSQL = " FROM PT_UB_USEBEFORE  \n";
    	
    	String whereSQL = "WHERE SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "  AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){
    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){
    		whereSQL += "AND APPLPER_NM LIKE '"+scAPPLPER_NM+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND OPE_NAME LIKE '%"+scOPE_NAME+"%'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scRECV_DT)){
    		whereSQL += "AND RECV_DT LIKE '"+scRECV_DT+"%'  \n";
    	}
    	
    	// 2010.01.08. ����� �������ΰ͸� SELECT
    	// ����:1, ������:2
      // whereSQL += " AND NAPPL_YN = '2' \n";
    	
    	String orderSQL = "ORDER BY RECV_DT DESC  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}