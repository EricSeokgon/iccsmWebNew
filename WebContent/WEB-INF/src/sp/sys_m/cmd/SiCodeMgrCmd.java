/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.sys_m.cmd;

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

public class SiCodeMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public SiCodeMgrCmd() {
    }

    public SiCodeMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        ReportEntity sEntity     = null;
        
        /****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
    	String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
    	String scSIGUNGU_CODE = vl.getValueAsString("scSIGUNGU_CODE");
    	
    	
    		
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	sQuery.append(" SELECT SIDO_NM, AREA_CODE FROM PT_SIDO_CODE WHERE SUBSTR(AREA_CODE,0,2) = SUBSTR(AREA_CODE,3,4)  ");
    	if (!KJFUtil.isEmpty(scSIDO_CODE))
    		sWhere.append(" AND AREA_CODE = '" + scSIDO_CODE + "' ");
   		sWhere.append(" ORDER BY SIDO_NM ASC ");    	
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
    	
    	sQuery.delete(0, sQuery.length());
    	sWhere.delete(0, sWhere.length());
    	
    	sQuery.append(" SELECT SIDO_NM, SIGUNGU_NM, AREA_CODE FROM PT_SIDO_CODE  ");
    	/*
    	if (scSIGUNGU_CODE.length() >= 6){
    		sQuery.append("  WHERE AREA_CODE = '"+scSIGUNGU_CODE.toString().trim()+"' ");
    	} else {
    		sQuery.append("  WHERE AREA_CODE like '"+scSIGUNGU_CODE.toString().trim()+"%' ");
    	}
    	*/
    	if (scSIGUNGU_CODE.length() >= 6){
    		sQuery.append("  WHERE AREA_CODE = '"+scSIGUNGU_CODE.toString().trim()+"' ");
    	} else if(scSIDO_CODE.equals(scSIGUNGU_CODE))  {
    	//} else if(scSIDO_CODE==scSIGUNGU_CODE)  {
    		sQuery.append("  WHERE AREA_CODE like '"+scSIGUNGU_CODE.substring(0, 2)+"%' ");
    		//sQuery.append("  WHERE AREA_CODE like '"+scSIGUNGU_CODE+"%' ");
    	}else{
    	   	sQuery.append("  WHERE AREA_CODE like '"+scSIGUNGU_CODE.toString().trim()+"%' ");
    	}
    	sQuery.append("  ORDER BY SEQ");
    	
    	sEntity    = rDAO.select(sQuery.toString());   
        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        KJFMi.ReEnt2Ds(dl,sEntity,"output2");
    	 
        request.setAttribute("dl", dl);  

        return next;
    }


}