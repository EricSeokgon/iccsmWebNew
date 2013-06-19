package sp.bbs;

import javax.servlet.http.HttpServletRequest;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class BbsParam extends ActionForm {

    // 페이징 관련
    private String nowPage;
    private String totalCount;
    private String rowPerPage;

    // 검색 조건-접두사 sc (serch condition)
    private String scBOARD_NAME;
    private String scTYPE;

    private String scCODE_GROUP;
    private String scCODE_NAME;

    private String scSD_CD;         // 시.도 코드
    private String scSGG_CD;        // 시.군.구 코드
    
    private String scFAQ_L_CATE;        // 질의회신 분류 코드 대분류
    private String scFAQ_S_CATE;        // 질의회신 분류 코드 소분류
    
    private String scSLCT_GUBUN;    // 검색 코드
    private String scTEXTVALUE;     // 검색 값

    // 첨부 파일
    private FormFile[] BBS_FILE = new FormFile[10] ;

    public BbsParam() {
    }

    /**
    *   request로 부터 parameter의 해당 value를 얻어
    *   paramName : value
    *   형식으로 출력
    */
    public String toString(HttpServletRequest request) {
        return KJFUtil.reportParameters(request) ;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public String getRowPerPage() {
        return rowPerPage;
    }

    public void setRowPerPage(String rowPerPage) {
        this.rowPerPage = rowPerPage;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
    
    public String getScBOARD_NAME() {
        return scBOARD_NAME;
    }

    public void setScBOARD_NAME(String scBOARD_NAME) {
        this.scBOARD_NAME = scBOARD_NAME;
    }

    public String getScTYPE() {
        return scTYPE;
    }

    public void setScTYPE(String scTYPE) {
        this.scTYPE = scTYPE;
    }

    public String getScCODE_NAME() {
        return scCODE_NAME;
    }

    public void setScCODE_NAME(String scCODE_NAME) {
        this.scCODE_NAME = scCODE_NAME;
    }

    public String getScCODE_GROUP() {
        return scCODE_GROUP;
    }
    
    public void setScCODE_GROUP(String scCODE_GROUP) {
        this.scCODE_GROUP = scCODE_GROUP;
    }
    
    public String getScSD_CD() {
        return scSD_CD;
    }

    public void setScSD_CD(String scSD_CD) {
        this.scSD_CD = scSD_CD;
    }

    public String getScSGG_CD() {
        return scSGG_CD;
    }

    public void setScSGG_CD(String scSGG_CD) {
        this.scSGG_CD = scSGG_CD;
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

    public FormFile[] getBBS_FILE() {
        return BBS_FILE;
    }

    public void setBBS_FILE(FormFile[] bbs_file) {
        BBS_FILE = bbs_file;
    }

	public String getScFAQ_L_CATE() {
		return scFAQ_L_CATE;
	}

	public void setScFAQ_L_CATE(String scFAQ_L_CATE) {
		this.scFAQ_L_CATE = scFAQ_L_CATE;
	}

	public String getScFAQ_S_CATE() {
		return scFAQ_S_CATE;
	}

	public void setScFAQ_S_CATE(String scFAQ_S_CATE) {
		this.scFAQ_S_CATE = scFAQ_S_CATE;
	}
}