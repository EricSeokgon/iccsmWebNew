package sp.mem.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.mem.MemParam;

public class MemHomePageSecedeMgrLCmd implements KJFCommand {
    
    private String next;
    
    public MemHomePageSecedeMgrLCmd() {
    }
    
    public MemHomePageSecedeMgrLCmd(String next_url) {
        next = next_url; 
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
                
        //�˻����� ������ üũ
        MemParam pm = checkPm(request, form);
        
        //�˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request, pm);  
        
        //����Ʈ �ε�
        loadList(request, pm);        
        
        return next;
    }
    
    /**
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request, MemParam pm) throws Exception{
       
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT AREA_CODE, SIDO_NM    \n");
        sbSQL.append("   FROM PT_SIDO_CODE          \n");
        sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR(AREA_CODE, 3, 4)    \n");
        sbSQL.append("  ORDER BY SIDO_NM     \n");           
        
        Vector<KJFSelect> v_scSD_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "��.�� ����");
        request.setAttribute("v_scSD_CD", v_scSD_CD);
        
        sbSQL = new StringBuffer();
        sbSQL.append(" SELECT AREA_CODE, RTRIM(SIGUNGU_NM, '��û')   \n");
        sbSQL.append("   FROM PT_SIDO_CODE                           \n");
        sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR('" + pm.getScSD_CD() + "', 1, 2) \n");
        sbSQL.append("    AND SUBSTR(AREA_CODE, 1, 2) != SUBSTR(AREA_CODE, 3, 4)                \n");
        sbSQL.append("  ORDER BY SIGUNGU_NM      \n");
                
        Vector<KJFSelect> v_scSGG_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "��.��.�� ����");
        request.setAttribute("v_scSGG_CD", v_scSGG_CD);    
    }

    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, UserParam
     * @return
     */
    private void loadList(HttpServletRequest request, MemParam pm) throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        int i = 1;

        StringBuffer selectSQL = new StringBuffer();
        selectSQL.append(" SELECT                           \n");
        selectSQL.append("        PT_U.USER_ID,                  \n");
        selectSQL.append("        PT_U.USER_NAME,                \n");
        selectSQL.append("        PT_U.USER_PASSWD,              \n");
        selectSQL.append("        PT_U.USER_SSN1,                \n");
        selectSQL.append("        PT_U.USER_SSN2,                \n");
        selectSQL.append("        PT_U.USER_POST_NUM,            \n");
        selectSQL.append("        PT_U.USER_ADDR,                \n");
        selectSQL.append("        PT_U.USER_ADDR_DETAIL,         \n");
        selectSQL.append("        PT_U.USER_TEL1,                \n");
        selectSQL.append("        PT_U.USER_TEL2,                \n");
        selectSQL.append("        PT_U.USER_TEL3,                \n");
        selectSQL.append("        PT_U.USER_MOBILE1,             \n");
        selectSQL.append("        PT_U.USER_MOBILE2,             \n");
        selectSQL.append("        PT_U.USER_MOBILE3,             \n");
        selectSQL.append("        PT_U.USER_MOBILE_YN,           \n");
        selectSQL.append("        PT_U.USER_EMAIL,               \n");
        selectSQL.append("        PT_U.USER_DN,                  \n");
        selectSQL.append("        PT_U.COM_REG_YN,               \n");
        selectSQL.append("        PT_U.COM_NAME,                 \n");
        selectSQL.append("        PT_U.COM_NUM,                  \n");
        selectSQL.append("        PT_U.REG_NUM,                  \n");
        selectSQL.append("        PT_U.OFFICE_POST_NUM,          \n");
        selectSQL.append("        PT_U.OFFICE_ADDR,              \n");
        selectSQL.append("        PT_U.OFFICE_ADDR_DETAIL,       \n");
        selectSQL.append("        PT_U.OFFICE_TEL,               \n");
        selectSQL.append("        PT_U.OFFICE_FAX,               \n");
        selectSQL.append("        PT_U.SIDO_CODE,                \n");
        selectSQL.append("        PT_U.SIGUNGU_CODE,             \n");
        selectSQL.append("        PT_SIDO_CODE.SIGUNGU_NM,       \n");        
        selectSQL.append("        PT_U.CAPITAL,                  \n");
        selectSQL.append("        PT_U.USE_YN,                   \n");
        selectSQL.append("        PT_U.INS_DT,                   \n");
        selectSQL.append("        PT_U.UPD_DT                    \n");        
        selectSQL.append("   FROM PT_HOM_USER PT_U               \n");
        selectSQL.append("   LEFT JOIN PT_SIDO_CODE ON PT_U.SIGUNGU_CODE = PT_SIDO_CODE.AREA_CODE   \n"); 

        StringBuffer whereSQL = new StringBuffer();
        whereSQL.append(" WHERE 1=1                 \n");
        whereSQL.append("   AND PT_U.USE_YN = ?     \n");        
        rDAO.setValue(i++, "N");        
        
        // �õ� ����
        if ( !KJFUtil.isEmpty(pm.getScSD_CD()) ) {
            whereSQL.append("   AND PT_U.SIDO_CODE = ?     \n"); 
            rDAO.setValue(i++, pm.getScSD_CD());
        }
        
        // �ñ��� ����
        if ( !KJFUtil.isEmpty(pm.getScSGG_CD()) ) {
            whereSQL.append("   AND PT_U.SIGUNGU_CODE = ?     \n");    
            rDAO.setValue(i++, pm.getScSGG_CD());
        }
        
        // ȸ������
        if ( !KJFUtil.isEmpty(pm.getScMEM_GUBUN()) ) {
            whereSQL.append("   AND PT_U.CAPITAL = ?     \n");    
            rDAO.setValue(i++, pm.getScMEM_GUBUN());
        }
        
        // �˻���
        if ( !KJFUtil.isEmpty(pm.getScTEXTVALUE()) ) {
            
            // ID �˻�
            if(KJFUtil.print(pm.getScSLCT_GUBUN()).equals("ID")) {
                
                whereSQL.append("   AND PT_U.USER_ID = ?     \n");  
                rDAO.setValue(i++, pm.getScTEXTVALUE());
                
            // �̸� �˻�
            } else {
                whereSQL.append("   AND PT_U.USER_NAME = ?     \n");  
                rDAO.setValue(i++, pm.getScTEXTVALUE());
            }
        }
        
        String orderSQL = " ORDER BY PT_U.INS_DT DESC    \n";
        
        /* ************************** ����¡ ���� START **************************/
        
        StringBuffer cntSQL = new StringBuffer();
        cntSQL.append(" SELECT COUNT(*)  CNT        \n");
        cntSQL.append("   FROM PT_HOM_USER PT_U     \n");
        
        // ��ü ��� ��
        String totalCount="";

        // �������� ��� ��
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        // ���� ������ ��ȣ
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL.toString() + whereSQL.toString());
        totalCount=rEntity.getValue(0,"CNT");
        
        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);
        
        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* ************************** ����¡ ���� END **************************/
 
        rEntity = rDAO.select(selectSQL.toString() + whereSQL.toString() + orderSQL ,nowPage, rowPerPage);
        
        /****** �˻����� �ʱⰪ ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);
    }
    
    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MemParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
        
        MemParam pm = (MemParam)form;

        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));

        // ����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
            
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
       
        return pm;
    }

}
