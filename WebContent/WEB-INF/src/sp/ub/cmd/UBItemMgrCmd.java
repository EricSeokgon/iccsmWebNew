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

public class UBItemMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBItemMgrCmd() {
    }

    public UBItemMgrCmd(String next_url) {
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
    	
        String scITEM = vl.getValueAsString("scITEM");
        String scLARCLAS = vl.getValueAsString("scLARCLAS");
        String scMIDCLAS = vl.getValueAsString("scMIDCLAS");
        String scSMACLAS = vl.getValueAsString("scSMACLAS");
        
    	String selectSQL=
    		"	SELECT '0' AS CHK, ITEM, SEQ, LARCLAS, MIDCLAS, SMACLAS, CONT, BAS, CONT_YN,ORDER_SEQ,DETAIL_CONT,  \n" +
    		"   CASE ITEM WHEN '1' THEN '����������' WHEN '2' THEN '���������' WHEN '0' THEN '��ü' ELSE ' ' END AS ITEM_NAME \n";
    	
    	String fromSQL = " FROM PT_UB_DETAIL_MASTER  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n";
    	
    	
    	if(!KJFUtil.isEmpty(scITEM) && !"0".equals(scITEM)){
    		
    		whereSQL += "AND ITEM = '"+scITEM+"'";
    		
    	}
    	
    	if(!KJFUtil.isEmpty(scLARCLAS)){
    		whereSQL += "AND LARCLAS LIKE '%"+scLARCLAS+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scMIDCLAS)){
    		whereSQL += "AND MIDCLAS LIKE '%"+scMIDCLAS+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSMACLAS)){
    		whereSQL += "AND SMACLAS LIKE '%"+scSMACLAS+"%'";
    	}
    	
    	String orderSQL = " ORDER BY ORDER_SEQ ASC ";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}