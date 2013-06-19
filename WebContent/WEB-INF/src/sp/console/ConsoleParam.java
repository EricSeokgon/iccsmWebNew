package sp.console;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.util.KJFUtil;

@SuppressWarnings("serial")
public class ConsoleParam extends ActionForm {
    
    // ����¡ ����
    private String nowPage;
    private String totalCount;
    private String rowPerPage;
    
    /* �ʼ����� */
    private String sido_code;           // �Ҽ� �õ�
    private String sigungu_code;        // �Ҽ� �ñ���
    
    public ConsoleParam() {
    }

    /**
    *   request�� ���� parameter�� �ش� value�� ���
    *   paramName : value
    *   �������� ���
    */
    public String toString(HttpServletRequest request) {
        return KJFUtil.reportParameters(request) ;
    }
    
    public String getSido_code() {
        return sido_code;
    }

    public void setSido_code(String sido_code) {
        this.sido_code = sido_code;
    }

    public String getSigungu_code() {
        return sigungu_code;
    }

    public void setSigungu_code(String sigungu_code) {
        this.sigungu_code = sigungu_code;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getRowPerPage() {
        return rowPerPage;
    }

    public void setRowPerPage(String rowPerPage) {
        this.rowPerPage = rowPerPage;
    }
}
