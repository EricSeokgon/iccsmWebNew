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

public class SidoCodeMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public SidoCodeMgrCmd() {
    }

    public SidoCodeMgrCmd(String next_url) {
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
    	
        String WRT_ID = vl.getValueAsString("WRT_ID");
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        
    	String selectSQL=
    		"	SELECT SIDO_NM, AREA_CODE        \n";
    	
    	String fromSQL = " FROM PT_SIDO_CODE   \n";
    	
    	String whereSQL = " WHERE SUBSTR(AREA_CODE,0,2) = SUBSTR(AREA_CODE,3,4)   \n";
    	
    	
    	if(!"admin".equals(WRT_ID)){
    		whereSQL += "AND AREA_CODE = '"+SIDO_CODE+"'   \n";
    	}
    	
    	String orderSQL = " ORDER BY SIDO_NM ASC ";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
       
    	whereSQL = "    \n";
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   
        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}