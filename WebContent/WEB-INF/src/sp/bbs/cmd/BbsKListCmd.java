    package sp.bbs.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.LoginException;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;
import sp.bbs.BbsSetConf;
import sp.bbs.StatusEnt;

/**
 * <p>Title       : BbsKListCmd Class</p>
 * <p>Description : �Խ��� List�� Load ó�� �Ѵ�.</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : �Խ��� List ������ ó���� �Ѵ�. 
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsKListCmd implements KJFCommand {
    
    /** �Խ��� ���� */
    private StatusEnt status;
  
    public BbsKListCmd() {        
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // �Խ��� �ʱ� ���� ���� �� ����.
        BbsSetConf.check(request);       

        status = (StatusEnt)request.getSession().getAttribute("status");
        
        String next = "/bbs/BbsK.jsp";        
        request.setAttribute("url_us", next);     
        
        // �˻����� ������ üũ
        BbsParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);
        
        // �˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request, pm);
        
        // �Խ��� List Load
        loadList(request, pm);       
        
        return next;
    }
    
    
    /**
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * 
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request, BbsParam pm) throws Exception {
        
     // �Խ��� �˻� �ڵ�        
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT CODE, CODE_NAME       \n");
        sbSQL.append("   FROM PT_BBS_COM_CODE       \n");
        sbSQL.append("  WHERE CODE_GROUP = '003'    \n");
        sbSQL.append("    AND CODE <> '000'         \n");
        sbSQL.append("  ORDER BY ORDER_NUM          \n");            

        Vector<KJFSelect> v_scSLCT_GUBUN = KJFSelectOPS.getSel(sbSQL.toString());
        request.setAttribute("v_scSLCT_GUBUN", v_scSLCT_GUBUN);


        // ��.�� ������ ����� ��
        if (status.isSD_DIV_YN()) {
            
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT AREA_CODE, SIDO_NM    \n");
            sbSQL.append("   FROM PT_SIDO_CODE          \n");
            sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR(AREA_CODE, 3, 4)    \n");
            sbSQL.append("  ORDER BY SIDO_NM     \n");           
            
            Vector<KJFSelect> v_scSD_CD = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "��.�� ����");
            request.setAttribute("v_scSD_CD", v_scSD_CD);
        }
        
        // ��.��.�� ������ ����� ��
        if (status.isSGG_DIV_YN()) {
            
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT AREA_CODE, RTRIM(SIGUNGU_NM, '��û')   \n");
            sbSQL.append("   FROM PT_SIDO_CODE                           \n");
            sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR('" + pm.getScSD_CD() + "', 1, 2) \n");
            sbSQL.append("    AND SUBSTR(AREA_CODE, 1, 2) != SUBSTR(AREA_CODE, 3, 4)                \n");
            sbSQL.append("  ORDER BY SIGUNGU_NM      \n");
                    
            Vector<KJFSelect> v_scSGG_CD = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "��.��.�� ����");
            request.setAttribute("v_scSGG_CD", v_scSGG_CD);            
        }
        
        // ����ȸ�ſ�
        if ("faq_basic_pub".equals(status.getTYPE())) {
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT CODE,CODE_NAME 		 			\n");
            sbSQL.append(" FROM PT_BBS_COM_CODE          			\n");
            sbSQL.append(" WHERE CODE_GROUP ='004' AND BIGO ='000'  \n");
            sbSQL.append(" ORDER BY ORDER_NUM ASC 	    			\n");           
            
            Vector<KJFSelect> v_scFAQ_L_CATE = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "��з�");
            request.setAttribute("v_scFAQ_L_CATE", v_scFAQ_L_CATE);
            
            sbSQL = new StringBuffer();
            sbSQL.append(" SELECT CODE,CODE_NAME 		 			\n");
            sbSQL.append(" FROM PT_BBS_COM_CODE          			\n");
            sbSQL.append(" WHERE CODE_GROUP ='004' AND BIGO ='"+ KJFUtil.print(pm.getScFAQ_L_CATE(),"ALL")+"'  \n");
            sbSQL.append(" ORDER BY ORDER_NUM ASC 	    			\n");           
            
            Vector<KJFSelect> v_scFAQ_S_CATE = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "�Һз�");
            request.setAttribute("v_scFAQ_S_CATE", v_scFAQ_S_CATE);
            
        }
    }
    
    
    /**
     * �Խ��� List Load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    private void loadList(HttpServletRequest request, BbsParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();        
        ReportEntity rEntity = null;
        
        int intCNT = 1;
        
        String CT_ID        = status.getCT_ID();        
        String scSD_CD      = KJFUtil.print(pm.getScSD_CD());       
        String scSGG_CD     = KJFUtil.print(pm.getScSGG_CD());        
        String scSLCT_GUBUN = KJFUtil.print(pm.getScSLCT_GUBUN());
        String scTEXTVALUE  = KJFUtil.print(pm.getScTEXTVALUE());
        String tableName    = "";  
        String scFAQ_L_CATE = KJFUtil.print(pm.getScFAQ_L_CATE());       
        String scFAQ_S_CATE = KJFUtil.print(pm.getScFAQ_S_CATE());
        if ("Y".equals(status.getTABLE_ONE_YN())) {
            tableName = "PT_BBS_BOARD";
            
        } else {
            tableName = "PT_BBS_" + CT_ID;
        }        
        
        // Select Query
        StringBuffer sbSelectSQL = new StringBuffer();        
        sbSelectSQL.append("SELECT                 \n");
        sbSelectSQL.append("       BOARD_SEQ,      \n");
        sbSelectSQL.append("       INDEX1,         \n");
        sbSelectSQL.append("       INDEX2,         \n");
        sbSelectSQL.append("       DEPTH,          \n");
        sbSelectSQL.append("       SIDO_CODE,      \n");
        sbSelectSQL.append("       SIGUNGU_CODE,   \n");
    
        // ��.��.�� �ڵ� ���
        if (status.isSGG_DIV_YN()) {    
            sbSelectSQL.append("       (SELECT SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE = A.SIGUNGU_CODE) AS SGG_NM,        \n");
        }
        
        sbSelectSQL.append("       USER_ID,        \n");
        sbSelectSQL.append("       USER_NAME,      \n");
        sbSelectSQL.append("       USER_EMAIL,     \n");
        sbSelectSQL.append("       USER_PASS,      \n");
        sbSelectSQL.append("       USER_IP,        \n");
        sbSelectSQL.append("       USER_TEL,       \n");
        sbSelectSQL.append("       USER_HOMEPAGE,  \n");
        sbSelectSQL.append("       SUBJECT,        \n");
        sbSelectSQL.append("       CONTENT,        \n");      
        sbSelectSQL.append("       REPLIED_YN,     \n");
        sbSelectSQL.append("       SECRET_YN,      \n");
        sbSelectSQL.append("       NOTICE_YN,      \n");
        sbSelectSQL.append("       READ_NUM,       \n");
        sbSelectSQL.append("       UPD_DT,         \n");
        sbSelectSQL.append("       INS_DT,         \n");
        sbSelectSQL.append("       WRT_ID,         \n");
        
        // ÷������ ���
        if (status.isATTACH() && status.getATT_NUM() > 0) {
            sbSelectSQL.append("       (SELECT COUNT(*) CNT FROM PT_BBS_COM_FILES WHERE CT_ID = A.CT_ID AND BOARD_SEQ = A.BOARD_SEQ) AS FILE_CNT,  \n");
        }
        
        sbSelectSQL.append("       ETC_1,          \n");
        sbSelectSQL.append("       ETC_2,          \n");
        sbSelectSQL.append("       ETC_3,          \n");
        sbSelectSQL.append("       ETC_4,          \n");
        sbSelectSQL.append("       ETC_5,          \n");
        sbSelectSQL.append("       ETC_6,          \n");
        sbSelectSQL.append("       ETC_7,          \n");
        sbSelectSQL.append("       ETC_8,          \n");
        sbSelectSQL.append("       ETC_9,          \n");
        sbSelectSQL.append("       ETC_10          \n");
        
        // From Query
        StringBuffer sbFromSQL = new StringBuffer();
        sbFromSQL.append("  FROM " + tableName + " A  \n");

        // Where Query
        StringBuffer sbWhereSQL = new StringBuffer();        
        sbWhereSQL.append(" WHERE 1=1               \n");        
        sbWhereSQL.append(" AND NOTICE_YN = 'N'     \n");

        if ("Y".equals(status.getTABLE_ONE_YN())) {            
            rDAO.setValue(intCNT++, CT_ID);            
            sbWhereSQL.append(" AND CT_ID = ?   \n");
        }

        // �������̸� �ϴ��� �Խ����̶� ��ü�� ��Ÿ ����.
        if ( !status.isADMIN() && status.isONE_ONE()){
            rDAO.setValue(intCNT++, status.getUSER_ID());
            sbWhereSQL.append(" AND USER_ID = ? \n") ;
        }
        
     // ��.��  �˻� ó�� ����
        if (status.isSD_DIV_YN()) {
            
            if ( !scSD_CD.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scSD_CD)) {
                rDAO.setValue(intCNT++, scSD_CD);
                sbWhereSQL.append(" AND SIDO_CODE = ?       \n") ;
            } 
        }
        
        // ��.��.�� ����           
        if (status.isSGG_DIV_YN()) {            
            
            if ( !scSD_CD.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scSD_CD) 
                    && !scSGG_CD.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scSGG_CD) ) {
               rDAO.setValue(intCNT++, scSGG_CD);
               sbWhereSQL.append(" AND SIGUNGU_CODE = ?      \n") ;
            }
        }     

        // ����ȸ�Ż���� ��з� ����           
        if ("faq_basic_pub".equals(status.getTYPE())) {            
            if ( !scFAQ_L_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_L_CATE) 
                    && !scFAQ_L_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_L_CATE) ) {
               rDAO.setValue(intCNT++, scFAQ_L_CATE);
               sbWhereSQL.append(" AND ETC_2 = ?      \n") ;
            }
            
            if ( !scFAQ_S_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_S_CATE) 
                    && !scFAQ_S_CATE.equalsIgnoreCase("ALL") && !KJFUtil.isEmpty(scFAQ_S_CATE) ) {
               rDAO.setValue(intCNT++, scFAQ_S_CATE);
               sbWhereSQL.append(" AND ETC_3 = ?      \n") ;
            }
        }    
        
        // �˻� ���� ó��
        if ( !KJFUtil.isEmpty(scSLCT_GUBUN) && !KJFUtil.isEmpty(scTEXTVALUE)  ) {
            
            if (scSLCT_GUBUN.equals("001")) {           // ����
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                sbWhereSQL.append(" AND SUBJECT Like ?    \n") ;
                
            } else if (scSLCT_GUBUN.equals("002")) {    // ����
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                sbWhereSQL.append(" AND CONTENT like ?     \n") ;
                
            } else if (scSLCT_GUBUN.equals("003")) {    // ���� + ����
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");                
                sbWhereSQL.append(" AND (SUBJECT Like ? OR CONTENT like ?)   \n") ;
                
            } else if (scSLCT_GUBUN.equals("004")) {    // �ۼ���
                rDAO.setValue(intCNT++, "%" + scTEXTVALUE + "%");
                sbWhereSQL.append(" AND USER_NAME Like ?    \n") ;
            }
        }
        
        // ORDER BY Query
        String orderSQL = " ORDER BY INDEX1 DESC, INDEX2 ASC  \n";
        
        /* ************************** ����¡ ���� START **************************/
        StringBuffer sbCntSQL = new StringBuffer();
        sbCntSQL.append(" SELECT COUNT(*)  CNT  \n");
        sbCntSQL.append(sbFromSQL.toString());
        sbCntSQL.append(sbWhereSQL.toString());        
        
        //��ü ��� ��
        String totalCount="";

        //�������� ��� ��
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        //���� ������ ��ȣ
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(sbCntSQL.toString());
        
        totalCount = rEntity.getValue(0, "CNT");
        
        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);//�߰�
        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* *************************** ����¡ ����  END **************************/

        rEntity = rDAO.select(sbSelectSQL.toString() + sbFromSQL.toString() + sbWhereSQL.toString() + orderSQL, nowPage, rowPerPage);

        /****** �˻����� �ʱⰪ ***********/
        request.setAttribute("pm", pm);
        request.setAttribute("ListEntity", rEntity);
    }    
    
    
    /**
     * �˻����� �ʱⰪ ������ üũ
     * 
     * @param request
     * @param form
     * @return BbsParam
     * @throws Exception
     */
    private BbsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        BbsParam pm = (BbsParam)form;

        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));

        // ����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {
            pm.setRowPerPage(Integer.toString(status.getROWPERPAGE()));
        }
        
        // �õ� �ڵ�
        if (KJFUtil.isEmpty(pm.getScSD_CD()) ) {
            pm.setScSD_CD(status.getSIDO_CODE());
        }
        
        // �ñ��� �ڵ�
        if (KJFUtil.isEmpty(pm.getScSGG_CD()) ) {
            pm.setScSGG_CD(status.getSIGUNGU_CODE());
        }

        return pm;
    }
}
