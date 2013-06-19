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

public class UBReceiptMgrCCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBReceiptMgrCCmd() {
    }

    public UBReceiptMgrCCmd(String next_url) {
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
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		
    	String selectSQL=
    		"	SELECT *  FROM PT_UB_USEBEFORE  \n";
    	
    	String whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"'   \n" +
						   " AND SIDO_CODE = '"+SIDO_CODE+"'   \n" +
						   " AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  ";
    	
    	
    	rEntity    = rDAO.select(selectSQL+whereSQL);        
    	
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        selectSQL=
    		"	SELECT  '0' AS CHECKER,  AA.* FROM PT_UB_MEMO AA  \n";
        whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND SIDO_CODE = '"+SIDO_CODE+"' \n" +
		   "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
        
       
        
        selectSQL=
    		"	SELECT PDEF.*, PDEF_CODE.CONT AS DEFI_CONT FROM PT_UB_DEFICIT PDEF LEFT JOIN  \n" +
    		"          (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE WHERE DEFI_GROUP = 'GUBU')   \n" +
    		"	PDEF_CODE  ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE \n";
        whereSQL = "WHERE PDEF.RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND PDEF.SIDO_CODE = '"+SIDO_CODE+"' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output3");
        
        selectSQL=
    		"	SELECT * FROM PT_R_DEFICIT_CODE   \n";
        whereSQL = "    WHERE DEFI_GROUP = 'GUBU' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output4");
        
        selectSQL=
		       "	SELECT CODE,CODE_NAME FROM PT_COM_CODE   \n";
		 whereSQL = "     WHERE P_CODE = 'BLDDIV' ORDER BY CODE_NAME ASC  \n";
		 rEntity    = rDAO.select(selectSQL+whereSQL);        
		
		 KJFMi.ReEnt2Ds(dl,rEntity,"output5");
		 
		 selectSQL=
			   "	SELECT CODE,CODE_NAME FROM PT_COM_CODE   \n";
		 whereSQL = "    WHERE P_CODE = 'WORK' ORDER BY CODE_NAME ASC  \n";
		 rEntity    = rDAO.select(selectSQL+whereSQL);        
			
		KJFMi.ReEnt2Ds(dl,rEntity,"output6");
		
		selectSQL=
			//   "	SELECT NVL(USEBEF_INSP,'14') AS USEBEF_INSP FROM PT_S_SYSVAR_MASTER   \n";
			   "	SELECT USEBEF_INSP,WEEKCHK,INSTODAY FROM PT_S_SYSVAR_MASTER   \n";
		 whereSQL = "     WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n";
		 rEntity    = rDAO.select(selectSQL+whereSQL);        
			
		KJFMi.ReEnt2Ds(dl,rEntity,"output7");
		
		
        
        request.setAttribute("dl", dl);  

        return next;
    }
    
    


}