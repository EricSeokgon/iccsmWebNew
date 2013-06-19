package sp.console;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.util.KJFUtil;

@SuppressWarnings("serial")
public class ConsoleParam extends ActionForm {
    
    // 페이징 관련
    private String nowPage;
    private String totalCount;
    private String rowPerPage;
    
    /* 필수정보 */
    private String sido_code;           // 소속 시도
    private String sigungu_code;        // 소속 시군구
    
    public ConsoleParam() {
    }

    /**
    *   request로 부터 parameter의 해당 value를 얻어
    *   paramName : value
    *   형식으로 출력
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
