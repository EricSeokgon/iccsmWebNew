/**
 * ���ϸ�   : NewBasPostStDCmd.java
 * ����     : �����ȣ ���ּ� cmd
 * �̷»���
 * CH00     : 2012/07/22 ���ᱳ �����ۼ�
 */

package sp.sys_m.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;


import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class NewBasPostStDCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public NewBasPostStDCmd() {
    }

    public NewBasPostStDCmd(String next_url) {
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
    	
    	String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
    	String AREA_CODE = vl.getValueAsString("AREA_CODE");
 
    	System.out.println("scSIDO  "+SIDO_CODE);
    	//System.out.println("scSIDO1  "+AREA_CODE);
    	
    	StringBuilder sQuery = new StringBuilder();
    	StringBuilder sWhere = new StringBuilder();
    	
    	sQuery.append(" SELECT SIDO_NM_CUT, AREA_CODE FROM PT_SIDO_CODE ");
    	sWhere.append(" WHERE 1 = 1 ");
    	if (!KJFUtil.isEmpty(SIDO_CODE))
    		sWhere.append(" AND AREA_CODE = '" + SIDO_CODE + "' ");
   		sWhere.append(" AND SIGUNGU_NM = '��û' and area_code<>'tete' and area_code <>'fefe' and SIGUNGU_NM<>'����Ư����ġ��'  ");
   		sWhere.append(" ORDER BY TO_NUMBER(SIDO_SEQ) ");
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());
    	
    	sQuery.delete(0, sQuery.length());
    	if (KJFUtil.isEmpty(SIDO_CODE)){
    	sQuery.append(" SELECT SIDO_NM_CUT, decode(sigungu_nm, '��û', '����', sigungu_nm)as SIGUNGU_NM, AREA_CODE FROM PT_SIDO_CODE where area_code<>'tete' and area_code<>'test'  and area_code<>'fefe' and area_code<>'feif' and area_code<>'febj'and area_code<>'fedg'and area_code<>'feye'and area_code<>'fesg'and area_code<>'fegf' and sigungu_nm<>'��û' and sigungu_nm<>'����Ư����ġ��' ORDER BY TO_NUMBER(SIGUNGU_SEQ) ");
    	}else{
       	sQuery.append(" SELECT SIDO_NM_CUT, SIGUNGU_NM, AREA_CODE FROM PT_SIDO_CODE where sigungu_nm<>'��û' and AREA_CODE<>'test' and sigungu_nm<>'����Ư����ġ��' ORDER BY TO_NUMBER(SIGUNGU_SEQ) ");
    	}
    	sEntity    = rDAO.select(sQuery.toString());

        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        KJFMi.ReEnt2Ds(dl,sEntity,"output2");

        request.setAttribute("dl", dl);

        return next;
    }


}