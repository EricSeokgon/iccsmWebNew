/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.am.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class AMCodeCCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public AMCodeCCmd() {
    }

    public AMCodeCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scDOC_CLASS = vl.getValueAsString("scDOC_CLASS");
        String scSD_CODE = vl.getValueAsString("scSD_CODE");
        String scSGG_CODE = vl.getValueAsString("scSGG_CODE");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rMasterEntity     = null;

        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();

        sQuery.append(" SELECT DOC_NUM1, DOC_NUM2, DOC_NUM3, DOC_NUM4 ");
        sQuery.append(" FROM PT_R_DOC_NUM ");    	
       	
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND DOC_CLASS = '" + scDOC_CLASS + "' ");
        sWhere.append(" AND SD_CODE = '" + scSD_CODE + "' ");
        if(scSGG_CODE != null && scSGG_CODE.length() > 0)
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
       		sQuery.append(" INSERT INTO PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) ");
       		sQuery.append(" VALUES('" + scDOC_CLASS + "', '" + scSD_CODE + "', '" + scSGG_CODE + "', '" +  scSD_CODE + "', '101') ");
        	rDAO = new ReportDAO();
        	rDAO.execute(sQuery.toString());
        	ArrayList arrField = new ArrayList();
        	arrField.add(scSD_CODE);
        	arrField.add("100");
        	arrField.add(null);
        	arrField.add(null);
        	rMasterEntity.addRow(arrField);
       	}
       	
        KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");

        request.setAttribute("dl", dl); 

        return next;
    }
}