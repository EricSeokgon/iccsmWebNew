package sp.mem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.util.*;


public class MemParam extends ActionForm {    
    
    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 

    	
    /*검색 조건-접두사 sc (serch condition) */
    private String scSD_CD;         // 시.도 코드
    private String scSGG_CD;        // 시.군.구 코드
    
    private String scSLCT_GUBUN;    // 검색 코드
    private String scTEXTVALUE;     // 검색 값
    
    private String scMEM_GUBUN;

    public MemParam() {
    } 

    /**
    *	request로 부터 parameter의 해당 value를 얻어
    *	paramName : value
    *	형식으로 출력
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

    public String getScMEM_GUBUN() {
        return scMEM_GUBUN;
    }

    public void setScMEM_GUBUN(String scMEM_GUBUN) {
        this.scMEM_GUBUN = scMEM_GUBUN;
    }    
}