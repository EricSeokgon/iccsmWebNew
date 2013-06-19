package sp.hms;

import javax.servlet.http.HttpServletRequest;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

public class HmsParam extends ActionForm {
    
    /*페이징 관련*/ 
    private String nowPage;
    private String totalCount;
    private String rowPerPage;
    
    private String scCODE_GROUP;
    private String scCODE_NAME;
    
    private String scL_MENU_CD;    // 대분류 코드
    private String scM_MENU_CD;    // 중분류  코드
    
    private String scSLCT_GUBUN;    // 검색 코드
    private String scTEXTVALUE;     // 검색 값   

    public HmsParam() {
        
    }
    
    /**
     *   request로 부터 parameter의 해당 value를 얻어
     *   paramName : value
     *   형식으로 출력
     */
     public String toString(HttpServletRequest request){
         return KJFUtil.reportParameters(request) ;
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
    
    public String getScCODE_GROUP() {
        return scCODE_GROUP;
    }

    public void setScCODE_GROUP(String scCODE_GROUP) {
        this.scCODE_GROUP = scCODE_GROUP;
    }

    public String getScCODE_NAME() {
        return scCODE_NAME;
    }

    public void setScCODE_NAME(String scCODE_NAME) {
        this.scCODE_NAME = scCODE_NAME;
    }   
    
    public String getScL_MENU_CD() {
        return scL_MENU_CD;
    }

    public void setScL_MENU_CD(String scL_MENU_CD) {
        this.scL_MENU_CD = scL_MENU_CD;
    }

    public String getScM_MENU_CD() {
        return scM_MENU_CD;
    }

    public void setScM_MENU_CD(String scM_MENU_CD) {
        this.scM_MENU_CD = scM_MENU_CD;
    }
    
    public String getScSLCT_GUBUN() {
        return scSLCT_GUBUN;
    }

    public void setScSLCT_GUBUN(String scSLCT_GUBUN) {
        this.scSLCT_GUBUN = scSLCT_GUBUN;
    }

    public String getScTEXTVALUE() {
        return scTEXTVALUE;
    }

    public void setScTEXTVALUE(String scTEXTVALUE) {
        this.scTEXTVALUE = scTEXTVALUE;
    }
}
