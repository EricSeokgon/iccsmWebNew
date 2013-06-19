/**
 * ���ϸ�   : RegMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.cm.cmd;

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

public class RegListMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegListMgrCmd() {
    }

    public RegListMgrCmd(String next_url) {
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
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scNAME = vl.getValueAsString("scNAME");
        String scCLOSE = vl.getValueAsString("scCLOSE");
        String scREP_NM = vl.getValueAsString("scREP_NM");
        
//        sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, PT_M.REP_NM_KOR, PT_M.MANA_NUM, ");
//        sQuery.append(" DECODE(PT_M.C_COM_DT, NULL, '', '���') AS C_COM_DT, ");
//        sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM ");
//        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_M ");
        
  //      sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, PT_M.REP_NM_KOR, PT_M.MANA_NUM, ");
  //      sQuery.append("   DECODE(PT_M.C_COM_DT, NULL, PT_C2.CODE_NAME, '���'|| DECODE(PT_C2.CODE_NAME,NULL,'','('||PT_C2.CODE_NAME||')') )  AS C_COM_DT, ");
  //      sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM ");
  //      sQuery.append(" FROM  (PT_R_COMPANY_MASTER PT_M LEFT JOIN PT_M_MASTER PT_MM ON PT_M.TMP_WRT_NUM = PT_MM.TMP_WRT_NUM) ");
  //      sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_MM.DISPO_CONT = PT_C2.CODE ");
        
        
        sQuery.append(" SELECT PT_M.TMP_WRT_NUM, PT_M.NAME, decode(pt_rr.NM_KOR,'',PT_M.REP_NM_KOR,PT_M.REP_NM_KOR||','||pt_rr.NM_KOR) as REP_NM_KOR, PT_M.ADDR_ADDR||PT_M.ADDR_DETAIL_ADDR AS ADDR_ADDR, PT_M.ADDR_TEL_NUM, ");
        //sQuery.append(" DECODE(PT_M.C_COM_DT, NULL, PT_C2.CODE_NAME, '���'|| DECODE(PT_C2.CODE_NAME,NULL,'','('||PT_C2.CODE_NAME||')') )  AS C_COM_DT, ");
        sQuery.append(" DECODE(PT_S.SIDO_NM, '����Ư����', '����', '�λ걤����', '�λ�','��걤����','��� ','�뱸������', '�뱸','��󳲵�' , '�泲', '��õ������', '��õ', " +
        		      "'��⵵', '���' ,'���ϵ�','���','���ֱ�����','����','���󳲵�','����'," +
        		      "'����������','����','��û����','�泲','����ϵ�','����','������','����','��û�ϵ�','���','����Ư����ġ��','����','����Ư����ġ��','����' ) AS SIDO_NM,");
        sQuery.append(" PT_M.WRT_DT, PT_M.COI_WRT_NUM, PT_M.C_COM_DT ");
       // sQuery.append(" FROM (PT_R_COMPANY_MASTER PT_M LEFT JOIN PT_M_MASTER PT_MM ON PT_M.TMP_WRT_NUM = PT_MM.TMP_WRT_NUM)");
        sQuery.append(" FROM PT_R_COMPANY_MASTER PT_M ");
        sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON PT_M.SIDO_CODE = PT_S.AREA_CODE ");
        sQuery.append(" left join PT_R_REFFER pt_rr on pt_rr.TMP_WRT_NUM=PT_M.TMP_WRT_NUM AND (pt_rr.POS_CLASS='P1' OR   pt_rr.POS_CLASS='P4') AND NVL(pt_rr.DEL_YN,'N') != 'Y' AND PT_M.REP_NM_KOR!=pt_rr.NM_KOR ");
        //sQuery.append(" LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 ON PT_MM.DISPO_CONT = PT_C2.CODE ");
        
        sWhere.append(" WHERE 1 = 1 ");
        //sWhere.append(" AND PT_M.C_COM_DT IS NULL ");
        //sWhere.append(" and PT_M.trans_union_proc is null AND PT_M.C_COM_DT IS NULL ");

        if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
        	sWhere.append(" AND PT_M.COI_WRT_NUM = '" + scCOI_WRT_NUM + "'");
        if (!KJFUtil.isEmpty(scNAME))
        	sWhere.append(" AND PT_M.NAME LIKE '%" + scNAME + "%'");
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        	sWhere.append(" AND PT_M.SIDO_CODE = '" + scSIDO_CODE + "'");
        if (!KJFUtil.isEmpty(scREP_NM))
        	sWhere.append(" AND PT_M.REP_NM_KOR LIKE '%" + scREP_NM + "%'");
        sWhere.append(" order by PT_M.COI_WRT_NUM ");
        if (!KJFUtil.isEmpty(scCLOSE)) {
        	if( scCLOSE.equals( "A" ) )
        		sWhere.append(" AND C_COM_DT IS NULL");
        	else if( scCLOSE.equals( "C" ) )
        		sWhere.append(" AND C_COM_DT IS NOT NULL");
        }
       
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}