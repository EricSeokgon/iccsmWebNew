package sp.amr.cmd;

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

public class AmReceiptMgr implements KJFCommand {
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public AmReceiptMgr() {
    }
    
    public AmReceiptMgr(String next_url) {
    	next = next_url;
    }
	
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData();
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
    	
        String scDispo_class1 = vl.getValueAsString("scDispo_class1");
        String scDispo_class2 = vl.getValueAsString("scDispo_class2");
        if("1".equals(scDispo_class2)) { scDispo_class2="2";}
        String scDispo_class3 = vl.getValueAsString("scDispo_class3");
        if("1".equals(scDispo_class3)) { scDispo_class3="3";}
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scDATE1 = vl.getValueAsString("scDATE1");
        String scDATE2 = vl.getValueAsString("scDATE2");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scCOM_NAME = vl.getValueAsString("scCOM_NAME");
        String scREMARK = vl.getValueAsString("scREMARK");
        String scMOT_STE = vl.getValueAsString("scMOT_STE");
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sQuery.append(" SELECT '0' AS CHECKER, \n");
        sQuery.append("    P.M_SEQ, P.COI_WRT_NUM, P.TMP_WRT_NUM,  \n");
        sQuery.append("    DECODE(P.DISPO_CLASS,'1','���','2','��������','3','������') AS DISPO_CLASS,  \n");
        sQuery.append("    P.VIOL_DT, P.DISPO_CAUSE,  \n");
        sQuery.append("    P.NOTE_DT, P.NOTE_OPIN_PRES_LIM_DT, \n"); 
        sQuery.append("    DECODE(P.NOTE_RECV_YN,'0','�̼���','1','����') AS NOTE_RECV_YN, \n"); 
        sQuery.append("    P.DEL_NOTE_DT, P.DEL_OPIN_PRES_LIM_DT, \n");
        sQuery.append("    DECODE(P.DISPO_CONT,'M00001','������(���)','M00002','��������(��Ÿ)','M00003','�� 78������ ���·�','M00004','�������', \n"); 
        sQuery.append("	   'M00005','������','M00006','¡��(���)','M00008','¡��(����)','M00009','��������1�����̸�','M00010','��������1����','M00011','��������2�����̸�', \n"); 
        sQuery.append("	   'M00012','��������3�����̸�','M00013','��������4�����̸�','M00014','��������5�����̸�','M00015','��������6�����̸�', \n");
        sQuery.append("	   'M00016','��������7�����̸�','M00017','��������8�����̸�','M00018','��������9�����̸�','M00019','��������(�νǽð�)') AS DISPO_CONT, \n"); 
        sQuery.append("    P.DISPO_DT, P.BUSISUSP_START_DT, P.BUSISUSP_END_DT,  \n");
        sQuery.append("    DECODE(P.MOT_STE,'C00001','������','C00002','ó�пϷ�','C00003','ó������') AS MOT_STE,   \n");
        sQuery.append("    P.REMARK, P.RECV_DT, \n");
        sQuery.append("    P.DOC_CODE, P.INS_DT, P.UPD_DT,  \n");
        sQuery.append("    P.WRT_ID, P.REGSTD_START_DT, P.REGSTD_END_DT,  \n");
        sQuery.append("    P.FINE, P.PAY_NOTI_DT, P.PAY_TERM,  \n");
        sQuery.append("    P.PAY_DT, P.WRT_NUM,   \n");
        sQuery.append("    DECODE(P.DEL_RECV_YN,'0','�̼���','1','����') AS DEL_RECV_YN,   \n");
        sQuery.append("    M.REP_NM_KOR, M.NAME, M.SIDO_CODE \n");
        sQuery.append(" FROM PT_M_MGR P, PT_R_COMPANY_MASTER M \n");
        sQuery.append(" WHERE P.COI_WRT_NUM = M.COI_WRT_NUM \n");
        
        sWhere.append(" AND P.DISPO_CLASS IN('"+scDispo_class1+"','"+scDispo_class2+"','"+scDispo_class3+"') \n");
        
        if(scSIDO_CODE.length() > 0 && !"ALL".equals(scSIDO_CODE))
        	sWhere.append(" AND     M.SIDO_CODE = '" + scSIDO_CODE + "' ");
        
        if(scDATE1.length() > 0 && scDATE2.length() > 0)
        	sWhere.append(" AND     P.RECV_DT BETWEEN '" + scDATE1 + "' AND '" + scDATE2 + "' ");
        
        if(scCOI_WRT_NUM.length() > 0)
        	sWhere.append(" AND     P.COI_WRT_NUM = '" + scCOI_WRT_NUM + "' ");
        
        if(scCOM_NAME.length() > 0)
        	sWhere.append(" AND     M.NAME like '%" + scCOM_NAME + "%' ");
        
        if(scREMARK.length() > 0)
        	sWhere.append(" AND     P.REMARK like '%" + scREMARK + "%' ");
        
        if(!"ALL".equals(scMOT_STE))
        	sWhere.append(" AND     P.MOT_STE = '" + scMOT_STE + "' ");
        
       
        
        rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	

        KJFMi.ReEnt2Ds(dl,rEntity,"output");        
        request.setAttribute("dl", dl); 
    	
    	return next;
    }
}
