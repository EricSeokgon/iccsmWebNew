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

public class BeforeViewMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeViewMgrCmd() {
    }

    public BeforeViewMgrCmd(String next_url) {
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
        
    	String selectSQL= "  \n"+
    		             "	SELECT ORPE_NM,PLANER_NM,PLANER_NAME,RECV_DT,CC.CODE_NAME AS USE,WORK_ITEM||'/'||WORK_ITEM_ETC AS WORK_ITEM,NUM_FL,AREA,   \n" +
    		             "		   INSP_OPIN,REPO_DT,SW_BEF_REPO_DELINUM,ORPE_TEL,ORPE_POSTNUM,   \n" +
    		             "		   ORPE_ADDR,ORPE_DETAILADDR,PLANER_TEL,PLANER_POSTNUM,PLANER_ADDR,PLANER_DETAILADDR,   \n" +
    		             "		   STRU_COMMIT_NUM,STRU_ADDR_POSTNUM,STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,   \n" +
    		             "     	 CASE SUV_APPL WHEN '1' THEN '����' WHEN '2' THEN '������' WHEN '3' THEN '�������' ELSE ' ' END AS  SUV_APPL,	 \n" +
    		             "       INSP_BAS, PRE_ITEM \n";
    	
    	String fromSQL = "    FROM PT_UB_CONSTRUCTION UB LEFT JOIN PT_COM_CODE CC ON CC.CODE = UB.USE AND CC.P_CODE = 'BLDDIV'  \n";
    	
    	String whereSQL = "  WHERE RECV_NUM = '"+scRECV_NUM+"'  \n" +
    					  "    AND SIDO_CODE = '"+scSIDO_CODE+"'  \n" +
    					  "    AND SIGUNGU_CODE = '"+scSIGUNGU_CODE+"'  \n";
    	
    	
    	
    	
       	
    	
    	String orderSQL = "ORDER BY RECV_DT DESC  \n";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}