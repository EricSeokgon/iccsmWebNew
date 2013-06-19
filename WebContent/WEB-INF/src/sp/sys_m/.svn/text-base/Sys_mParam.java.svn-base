/**
 * 파일명   : Sys_mParam.java
 * 설명      : Parameter Bean 
 * 이력사항
 * 
 */
package sp.sys_m;

import javax.servlet.http.HttpServletRequest;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;


public class Sys_mParam extends ActionForm{    


    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 
    

    	
    /*검색 조건-접두사 sc (serch condition) */

    private String scP_CODE;
    private String scCODE_NAME;
    private String scUSE_YN;
   

    public Sys_mParam() {
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




	public String getScP_CODE() {
		return scP_CODE;
	}




	public void setScP_CODE(String scP_CODE) {
		this.scP_CODE = scP_CODE;
	}




	public String getScCODE_NAME() {
		return scCODE_NAME;
	}




	public void setScCODE_NAME(String scCODE_NAME) {
		this.scCODE_NAME = scCODE_NAME;
	}




	public String getScUSE_YN() {
		return scUSE_YN;
	}




	public void setScUSE_YN(String scUSE_YN) {
		this.scUSE_YN = scUSE_YN;
	}


	
	


}//end class


