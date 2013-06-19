/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.cm.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.bas.cmd.ComCountCmd;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegMgrCodeCCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegMgrCodeCCmd() {
    }

    public RegMgrCodeCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scDOC_CLASS = vl.getValueAsString("scDOC_CLASS");
        String scSD_CODE = vl.getValueAsString("scSD_CODE");
        String scSGG_CODE = vl.getValueAsString("scSGG_CODE");
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        //�ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();

        //Deficit Codes Table
        sQuery.append(" SELECT DOC_NUM1, DOC_NUM2, DOC_NUM3, DOC_NUM4 ");
        sQuery.append(" FROM PT_R_DOC_NUM ");    	
       	
        // �� �޼���� TMP_WRT_NUM ���� �� �ٸ� �������� ������ ����.
        // TMP_WRT_NUM �� �õ��ڵ� + ����(bsbs100)�� �������� �ʰ�, �õ� ���� ���� ����ϴ� ����(VARCHAR(12))��ŭ ���ڷθ� ����.
        // ��������� DOC_NUM2 �� ������ ��� �÷����� ����.
        scDOC_CLASS = "TMP_WRT_NUM";
        scSD_CODE  = "all";
        scSGG_CODE = "all";
        
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND DOC_CLASS = '" + scDOC_CLASS + "' ");
        sWhere.append(" AND SD_CODE = '" + scSD_CODE + "' ");

        if(!KJFUtil.isEmpty(scSGG_CODE))
        	sWhere.append(" AND SGG_CODE = '" + scSGG_CODE + "' ");

       	rMasterEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
       	sQuery.delete(0, sQuery.length());
       	if (rMasterEntity.getRowCnt() > 0)
       	{
    		sQuery.append(" UPDATE PT_R_DOC_NUM SET DOC_NUM2 = DOC_NUM2 + 1 ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString() + sWhere.toString());
       	}
       	else
       	{
       		
       		// �űԻ����� �õ����о��� 1���� ����. ������ ��ȸ ���ʵ����͸� �ֱ� ������ �� �κ�(else ���)�� �ǹ� ����.
       		sQuery.append(" INSERT INTO PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) ");
       		sQuery.append(" VALUES('" + scDOC_CLASS + "', '" + scSD_CODE + "', '" + scSGG_CODE + "', '', '2') ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	ArrayList arrField = new ArrayList();
        	arrField.add(scSD_CODE);
        	arrField.add("1");
        	arrField.add(null);
        	arrField.add(null);
        	rMasterEntity.addRow(arrField);
       	}
       	
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");               
        
        sQuery.delete(0, sQuery.length());

        //sQuery.append(" SELECT * FROM PT_R_DEFICIT_CODE ");    	
       	//rMasterEntity    = rDAO.select(sQuery.toString());
        
        sQuery.append(" SELECT '0' AS DEFI_OUT, AA.DEFI_CODE, AA.CONT AS DEFI_CONT ");
        sQuery.append(" FROM PT_R_DEFICIT_CODE AA ");
        sQuery.append(" WHERE DEFI_GROUP = 'REGDEF' ");
       	rMasterEntity    = rDAO.select(sQuery.toString());
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output2");
        request.setAttribute("dl", dl); 
        
        return next;
    }
}