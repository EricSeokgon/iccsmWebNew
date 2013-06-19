/**
 * 파일명   : RegParam.java
 * 설명      : Parameter Bean 
 * 이력사항
 * 
 */
package sp.reg;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import kjf.util.*;


public class RegParam extends ActionForm{    


    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 

    	
    /*검색 조건-접두사 sc (serch condition) */







    public RegParam() {
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




}//end class


