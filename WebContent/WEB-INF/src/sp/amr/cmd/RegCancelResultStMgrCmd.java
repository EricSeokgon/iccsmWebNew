package sp.amr.cmd;

/**
 * ���ϸ�   : RegCancelResultStMgrCmd.java
 * ����     :  ������ ������� ó����� cmd
 * �̷»���
 * CH00     : 2010/01/25 ������ �����ۼ�
 */

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

public class RegCancelResultStMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegCancelResultStMgrCmd() {
    }

    public RegCancelResultStMgrCmd(String next_url) {
    	next = next_url;
    }



	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rEntity = null;

		/****** Service API �ʱ�ȭ ******/
		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );
		/** Web Server���� XML���� �� Parsing **/
		pReq.receiveData();
		/** ���� ȹ�� **/
		vl = pReq.getVariableList();
        
		String scCOI_WRT_NUM = vl.getValueAsString( "scCOI_WRT_NUM" );
		String scNAME = vl.getValueAsString( "scNAME" );
		String scREP_NM_KOR = vl.getValueAsString( "scREP_NM_KOR" );
		String scDISPO_CONT = vl.getValueAsString( "scDISPO_CONT" );
		String scBUSISUSP_START_DT = vl.getValueAsString( "scBUSISUSP_START_DT" );
		String scBUSISUSP_END_DT = vl.getValueAsString( "scBUSISUSP_END_DT" );
		String scREMARK = vl.getValueAsString( "scREMARK" );
		

		String scSIDO_CODE = vl.getValueAsString( "SIDO_CODE" );
		//String SIGUNGU_CODE = vl.getValueAsString( "SIGUNGU_CODE" );

		String selectSQL	=
							" SELECT ROWNUM AS SEQ, MA.* FROM ("+
							" SELECT  \n" +
							"	PM.COI_WRT_NUM, PM.DISPO_DT,PM.DISPO_CAUSE, PM.REMARK,PM.BUSISUSP_START_DT,PM.BUSISUSP_END_DT, \n" +
						    "   DECODE(PM.DISPO_CONT,'M00001','������(���)','M00002','��������(��Ÿ)','M00003','�� 78������ ���·�','M00004','�������',  \n"+
						    "   'M00005','������','M00006','¡��(���)','M00008','¡��(����)','M00009','��������1�����̸�','M00010','��������1����','M00011','��������2�����̸�',  \n"+
						    "   'M00012','��������3�����̸�','M00013','��������4�����̸�','M00014','��������5�����̸�','M00015','��������6�����̸�',  \n"+
						    "   'M00016','��������7�����̸�','M00017','��������8�����̸�','M00018','��������9�����̸�','M00019','��������(�νǽð�)') AS DISPO_CONT,  \n"+
						    "	PM.DOC_CODE, PC.NAME, PC.REP_NM_KOR  \n";
		String fromSQL		= " FROM PT_M_MASTER PM, PT_R_COMPANY_MASTER PC  \n";
		String whereSQL		= " WHERE 1 = 1  \n";
		whereSQL += "      AND PM.COI_WRT_NUM = PC.COI_WRT_NUM \n";
		whereSQL += "      AND DISPO_CONT = 'M00001' \n"; 
		
		//�õ�
		if( !KJFUtil.isEmpty( scSIDO_CODE) && !"ALL".equals(scSIDO_CODE) ) {
			whereSQL += "	   AND PC.SIDO_CODE LIKE '"+ scSIDO_CODE + "'  \n";
		}
		
		// ������ ����
		if( !KJFUtil.isEmpty( scNAME ) ) {
			whereSQL += "	   AND PC.NAME LIKE '%" + scNAME + "%'  \n";
		}
		//��ȣ
		if( !KJFUtil.isEmpty( scREP_NM_KOR ) ) {
			whereSQL += "	   AND PC.REP_NM_KOR LIKE '%" + scREP_NM_KOR  + "%'  \n";
		}
		// ó�бⰣ
		if( !KJFUtil.isEmpty( scBUSISUSP_START_DT  ) && !KJFUtil.isEmpty( scBUSISUSP_END_DT ) ) {
			whereSQL += "	   AND PM.DISPO_DT BETWEEN '" + scBUSISUSP_START_DT+ "' AND '" + scBUSISUSP_END_DT + "'  \n";
		}
		if (!KJFUtil.isEmpty(scCOI_WRT_NUM))
			whereSQL +=" AND PM.COI_WRT_NUM = '" + scCOI_WRT_NUM + "' \n";
		
		//ó�г���
		if( !KJFUtil.isEmpty( scREP_NM_KOR ) ) {
			whereSQL += " AND PM.DISPO_CONT '%" + scDISPO_CONT  + "%'  \n";
		}
		
		//���
		if( !KJFUtil.isEmpty( scREMARK ) ) {
			whereSQL += " AND PM.REMARK '%" + scREMARK  + "%'  \n";
		}
		
		// ó������
		/*if( !KJFUtil.isEmpty( scPROC_STE ) && !"0".equals( scPROC_STE ) ) {
			whereSQL += "  	   AND PROC_STE = '" + scPROC_STE + "'  \n";
//			whereSQL += "  	   AND PROC_STE = '3'  \n";
		}*/

		String orderSQL = "	   ORDER BY PM.BUSISUSP_START_DT ASC) MA ORDER BY SEQ DESC";

		rEntity = rDAO.select( selectSQL + fromSQL + whereSQL + orderSQL );

		// ����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
		KJFMi.ReEnt2Ds( dl, rEntity, "output" );

		request.setAttribute( "dl", dl );

		return next;
	}


}