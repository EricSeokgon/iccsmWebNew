/**
 * 파일명   : BlankParam.java
 * 설명      : Parameter Bean 
 * 이력사항
 * 
 */
package sp.blank;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import kjf.util.*;


public class BlankParam extends ActionForm{    


    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 
    
    private String isSearch;

    	
    /*검색 조건-접두사 sc (serch condition) */
    
    private String nextURL;


    public BlankParam() {
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




	public String getNextURL() {
		return nextURL;
	}




	public void setNextURL(String nextURL) {
		this.nextURL = nextURL;
	}




	public String getIsSearch() {
		return isSearch;
	}




	public void setIsSearch(String isSearch) {
		this.isSearch = isSearch;
	}




}//end class


