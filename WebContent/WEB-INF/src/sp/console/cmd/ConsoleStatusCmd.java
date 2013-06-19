package sp.console.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.console.ConsoleParam;

public class ConsoleStatusCmd implements KJFCommand {
    private String next;

    public ConsoleStatusCmd() {
    }
    
    public ConsoleStatusCmd(String next_url) {
        next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        //�˻����� ������ üũ
        ConsoleParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);

        // ����� ���� ���� �ε�
        loadPubWorkDate(request, pm);
        
        // ������Ȳ ���� ���� �ε�
        loadIllegalityDate(request, pm);
        
        // ������ ���赵 Ȯ��
        loadStWorkDate(request, pm);
        
        // ����� �˻� ����
        loadUsebeforeDate(request, pm);

        return next;
    }

    /***************************************************************************
     * ����� ���� ���� load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadPubWorkDate(HttpServletRequest request, ConsoleParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        String regproc = "STD003";  // �������
        
        int i = 1;
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append("SELECT                                                \n");
        sbSQL.append("       COUNT(PT_R_REGIST.RECV_NUM) AS REGIST_CNT,     \n");
        sbSQL.append("       COUNT(PT_R_BASIC.RECV_NUM)  AS BASIC_CNT,      \n");
        sbSQL.append("       COUNT(PT_R_ASSI.RECV_NUM)   AS ASSI_CNT,       \n");
        sbSQL.append("       COUNT(PT_R_UNION.RECV_NUM)  AS UNION_CNT,      \n");
        sbSQL.append("       COUNT(PT_R_CLOSE.RECV_NUM)  AS CLOSE_CNT       \n");
        
        sbSQL.append("  FROM PT_R_BASIC_CHANGE_HISTORY PT_H                 \n");

        // �������
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("                FROM PT_R_REGIST_STATEMENT                        \n");
        sbSQL.append("            ) PT_R_REGIST ON PT_H.RECV_NUM = PT_R_REGIST.RECV_NUM \n");

        // ���ؽŰ�
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("              FROM PT_R_BASIC_STATEMENT PT_R_BASIC                \n");
        sbSQL.append("            ) PT_R_BASIC ON PT_H.RECV_NUM = PT_R_BASIC.RECV_NUM   \n");

        // �絵 ���
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("              FROM PT_R_ASSI_TRANS_STATEMENT                      \n");
        sbSQL.append("            ) PT_R_ASSI ON PT_H.RECV_NUM = PT_R_ASSI.RECV_NUM     \n");

        // �����պ�
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("               FROM PT_R_UNION_STATEMENT PT_U                     \n");
        sbSQL.append("            ) PT_R_UNION ON PT_H.RECV_NUM = PT_R_UNION.RECV_NUM   \n");

        // ���ó��
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("               FROM PT_R_CLOSE_STATEMENT PT_U                     \n");
        sbSQL.append("            ) PT_R_CLOSE ON PT_H.RECV_NUM = PT_R_CLOSE.RECV_NUM   \n");
        
        sbSQL.append("  WHERE PT_H.SIDO_CODE = ?     \n");
        sbSQL.append("    AND PT_H.MOT_STE !=  ?     \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, regproc);
        
        
        sbSQL.append("  UNION ALL   \n");
        
        sbSQL.append("SELECT                                                \n");
        sbSQL.append("       COUNT(PT_R_REGIST.RECV_NUM) AS REGIST_CNT,     \n");
        sbSQL.append("       COUNT(PT_R_BASIC.RECV_NUM)  AS BASIC_CNT,      \n");
        sbSQL.append("       COUNT(PT_R_ASSI.RECV_NUM)   AS ASSI_CNT,       \n");
        sbSQL.append("       COUNT(PT_R_UNION.RECV_NUM)  AS UNION_CNT,      \n");
        sbSQL.append("       COUNT(PT_R_CLOSE.RECV_NUM)  AS CLOSE_CNT       \n");
        
        sbSQL.append("  FROM PT_R_BASIC_CHANGE_HISTORY PT_H                 \n");

        // �������
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("                FROM PT_R_REGIST_STATEMENT                        \n");
        sbSQL.append("            ) PT_R_REGIST ON PT_H.RECV_NUM = PT_R_REGIST.RECV_NUM \n");

        // ���ؽŰ�
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("              FROM PT_R_BASIC_STATEMENT PT_R_BASIC                \n");
        sbSQL.append("            ) PT_R_BASIC ON PT_H.RECV_NUM = PT_R_BASIC.RECV_NUM   \n");

        // �絵 ���
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("              FROM PT_R_ASSI_TRANS_STATEMENT                      \n");
        sbSQL.append("            ) PT_R_ASSI ON PT_H.RECV_NUM = PT_R_ASSI.RECV_NUM     \n");

        // �����պ�
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("               FROM PT_R_UNION_STATEMENT PT_U                     \n");
        sbSQL.append("            ) PT_R_UNION ON PT_H.RECV_NUM = PT_R_UNION.RECV_NUM   \n");

        // ���ó��
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("              SELECT RECV_NUM                                     \n");
        sbSQL.append("               FROM PT_R_CLOSE_STATEMENT PT_U                     \n");
        sbSQL.append("            ) PT_R_CLOSE ON PT_H.RECV_NUM = PT_R_CLOSE.RECV_NUM   \n");
        
        sbSQL.append("  WHERE PT_H.SIDO_CODE = ?       \n");
        sbSQL.append("    AND PT_H.MOT_STE =  ?        \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, regproc);
        
        sbSQL.append("    AND TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') >= TO_CHAR(ADD_MONTHS(SYSDATE, -3),'YYYYMM')    \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') <= TO_CHAR(SYSDATE,'YYYYMM')                    \n");

        rEntity = rDAO.select(sbSQL.toString());

        // �˻����� �ʱⰪ        
        request.setAttribute("rEntity", rEntity);
    }
    
    
    /***************************************************************************
     * ������Ȳ ���� ���� load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadIllegalityDate(HttpServletRequest request, ConsoleParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        String regproc = "C00003";  // �������
        
        int i = 1;
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append("SELECT                                                \n");
        sbSQL.append("        COUNT(PT_M_SUS.WRT_NUM) AS PT_M_SUS_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_CAN.WRT_NUM) AS PT_M_CAN_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_NEG.WRT_NUM) AS PT_M_NEG_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_WAR.WRT_NUM) AS PT_M_WAR_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_COR.WRT_NUM) AS PT_M_COR_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_PRO.WRT_NUM) AS PT_M_PRO_CNT       \n");

        sbSQL.append("   FROM PT_M_MASTER PT_M                              \n");

        // ��������
        sbSQL.append("  LEFT JOIN PT_M_SUSPENSION PT_M_SUS                  \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_SUS.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00002'                \n");

        // ������
        sbSQL.append("  LEFT JOIN PT_M_REGIST_CANCEL PT_M_CAN               \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_CAN.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00001'                \n");

        // ���·�ΰ�
        sbSQL.append("  LEFT JOIN PT_M_NEGLIGENCE PT_M_NEG                  \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_NEG.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00003'                \n");

        // �����ġ
        sbSQL.append("  LEFT JOIN PT_M_WARNING PT_M_WAR                     \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_WAR.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00006'                \n");

        // �������
        sbSQL.append("  LEFT JOIN PT_M_CORRECT PT_M_COR                     \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_COR.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00004'                \n");

        // ������
        sbSQL.append("  LEFT JOIN PT_M_PROSECUTION PT_M_PRO                 \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_PRO.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00005'                \n");

        sbSQL.append("  WHERE PT_M.SIDO_CODE = ?    \n");
        sbSQL.append("    AND PT_M.MOT_STE != ?     \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, regproc);
        
        sbSQL.append("  UNION ALL   \n");
        
        sbSQL.append("SELECT                                                \n");
        sbSQL.append("        COUNT(PT_M_SUS.WRT_NUM) AS PT_M_SUS_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_CAN.WRT_NUM) AS PT_M_CAN_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_NEG.WRT_NUM) AS PT_M_NEG_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_WAR.WRT_NUM) AS PT_M_WAR_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_COR.WRT_NUM) AS PT_M_COR_CNT,      \n");
        sbSQL.append("        COUNT(PT_M_PRO.WRT_NUM) AS PT_M_PRO_CNT       \n");

        sbSQL.append("   FROM PT_M_MASTER PT_M                              \n");

        // ��������
        sbSQL.append("  LEFT JOIN PT_M_SUSPENSION PT_M_SUS                  \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_SUS.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00002'                \n");

        // ������
        sbSQL.append("  LEFT JOIN PT_M_REGIST_CANCEL PT_M_CAN               \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_CAN.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00001'                \n");

        // ���·�ΰ�
        sbSQL.append("  LEFT JOIN PT_M_NEGLIGENCE PT_M_NEG                  \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_NEG.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00003'                \n");

        // �����ġ
        sbSQL.append("  LEFT JOIN PT_M_WARNING PT_M_WAR                     \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_WAR.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00006'                \n");

        // �������
        sbSQL.append("  LEFT JOIN PT_M_CORRECT PT_M_COR                     \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_COR.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00004'                \n");

        // ������
        sbSQL.append("  LEFT JOIN PT_M_PROSECUTION PT_M_PRO                 \n");
        sbSQL.append("         ON PT_M.TMP_WRT_NUM = PT_M_PRO.TMP_WRT_NUM   \n");
        sbSQL.append("        AND PT_M.DISPO_CONT = 'M00005'                \n");
        
        sbSQL.append("  WHERE PT_M.SIDO_CODE = ?    \n");
        sbSQL.append("    AND PT_M.MOT_STE = ?      \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') >= TO_CHAR(ADD_MONTHS(SYSDATE, -3),'YYYYMM')    \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') <= TO_CHAR(SYSDATE,'YYYYMM')                    \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, regproc);

        rEntity = rDAO.select(sbSQL.toString());

        // �˻����� �ʱⰪ
        request.setAttribute("mEntity", rEntity);
    }
    
    
    /***************************************************************************
     * ������ ���赵 ���� load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadStWorkDate(HttpServletRequest request, ConsoleParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        int i = 1;
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append("SELECT COUNT(*) AS PT_UB_CON_CNT      \n");
        sbSQL.append("   FROM PT_UB_CONSTRUCTION            \n");
        sbSQL.append("  WHERE SIDO_CODE = ?                 \n");
        sbSQL.append("    AND PROC_STE != ?                 \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, "3");

        sbSQL.append(" UNION ALL \n");

        sbSQL.append("  SELECT COUNT(*) AS PT_UB_CON_CNT    \n");
        sbSQL.append("   FROM PT_UB_CONSTRUCTION            \n");
        sbSQL.append("  WHERE SIDO_CODE = ?                 \n");
        sbSQL.append("    AND PROC_STE = ?                  \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(RECV_DT),'YYYYMM') >= TO_CHAR(ADD_MONTHS(SYSDATE, -3),'YYYYMM')   \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(RECV_DT),'YYYYMM') <= TO_CHAR(SYSDATE,'YYYYMM')                   \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, "3");

        rEntity = rDAO.select(sbSQL.toString());

        // �˻����� �ʱⰪ
        request.setAttribute("sEntity", rEntity);
    }
    
    
    /***************************************************************************
     * ������˻� ���� load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadUsebeforeDate(HttpServletRequest request, ConsoleParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        int i = 1;
        
        StringBuffer sbSQL = new StringBuffer(); 
        sbSQL.append("SELECT COUNT(*) AS PT_UB_USE_CNT      \n");
        sbSQL.append("   FROM PT_UB_USEBEFORE               \n");
        sbSQL.append("  WHERE SIDO_CODE = ?                 \n");
        sbSQL.append("    AND PROC_STE != ?                 \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, "3");

        sbSQL.append(" UNION ALL \n");

        sbSQL.append("  SELECT COUNT(*) AS PT_UB_USE_CNT    \n");
        sbSQL.append("   FROM PT_UB_USEBEFORE               \n");
        sbSQL.append("  WHERE SIDO_CODE = ?                 \n");
        sbSQL.append("    AND PROC_STE = ?                  \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(RECV_DT),'YYYYMM') >= TO_CHAR(ADD_MONTHS(SYSDATE, -3),'YYYYMM')   \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(RECV_DT),'YYYYMM') <= TO_CHAR(SYSDATE,'YYYYMM')                   \n");
        
        rDAO.setValue(i++, pm.getSido_code());
        rDAO.setValue(i++, "3");

        rEntity = rDAO.select(sbSQL.toString());

        // �˻����� �ʱⰪ
        request.setAttribute("uEntity", rEntity);
    }
    
    
    /***************************************************************************
     * �˻����� �ʱⰪ ������ üũ
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     **************************************************************************/
    private ConsoleParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        ConsoleParam pm = (ConsoleParam)form;
        
        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));

        // ����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

        return pm;
    }

}
