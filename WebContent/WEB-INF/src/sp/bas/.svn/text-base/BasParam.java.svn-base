/**
 * 파일명   : BasParam.java
 * 설명      : Parameter Bean 
 * 이력사항
 * 
 */
package sp.bas;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import kjf.util.*;


public class BasParam extends ActionForm{    


    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 

    	
    /*검색 조건-접두사 sc (serch condition) */
    private String scDong;
    private String AREA_CODE;
    private String SIGUNGU_NM;
    private String SIDO_NM_CUT;
    private String scSIDO;
    private String SIDO_CODE;


    public BasParam() {
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




	public String getScDong() {
		return scDong;
	}

	public void setScDong(String scDong) {
		this.scDong = scDong;
	}

	public String getAREA_CODE() {
		return AREA_CODE;
	}

	public void SIDO_NM(String AREA_CODE) {
		this.AREA_CODE = AREA_CODE;
	}

	public String getSIDO_NM_CUT() {
		return SIDO_NM_CUT;
	}
	
	public void SIDO_NM_CUT(String SIDO_NM_CUT) {
		this.SIDO_NM_CUT = SIDO_NM_CUT;
	}

	
	public String getSIGUNGU_NM() {
		return SIGUNGU_NM;
	}

	public void SIGUNGU_NM(String SIGUNGU_NM) {
		this.SIGUNGU_NM = SIGUNGU_NM;
	}

	public String getscSIDO() {
		return scSIDO;
	}

	public void scSIDO(String scSIDO) {
		this.scSIDO = scSIDO;
	}
	
	public String getSIDO_CODE() {
		return SIDO_CODE;
	}

	public void SIDO_CODE(String SIDO_CODE) {
		this.SIDO_CODE = SIDO_CODE;
	}

}//end class


