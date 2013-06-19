/**
 * 파일명   : BbsParam.java
 * 설명     : Parameter Bean 
 * 이력사항
 * HN00     :
 */
package sp.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.util.*;


public class UserParam extends ActionForm{    


    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 
    
    private String IsSearch; 	
    
    /*검색 조건-접두사 sc (serch condition) */
    private String scFIELD;  		//검색필드
    private String scTEXT;   		//검색어
    private String scCONDITION;   	//검색조건
    private String scORDER;  		//정렬 조건
    private String scPOSITION;  		//부서
    private String scORGANIZATION;  		//기관
    
    private String scUSER_ID;  				//아이디
    
    private String scCODE_GROUP;
    private String scCODE_NAME;

    private String scPTNR_CODE;


    public UserParam() {
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




	public String getScFIELD() {
		return scFIELD;
	}




	public void setScFIELD(String scFIELD) {
		this.scFIELD = scFIELD;
	}




	public String getScTEXT() {
		return scTEXT;
	}




	public void setScTEXT(String scTEXT) {
		this.scTEXT = scTEXT;
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




	public String getScORDER() {
		return scORDER;
	}




	public void setScORDER(String scORDER) {
		this.scORDER = scORDER;
	}




	public String getScCONDITION() {
		return scCONDITION;
	}




	public void setScCONDITION(String scCONDITION) {
		this.scCONDITION = scCONDITION;
	}




	public String getIsSearch() {
		return IsSearch;
	}




	public void setIsSearch(String isSearch) {
		IsSearch = isSearch;
	}




	public String getScPOSITION() {
		return scPOSITION;
	}




	public void setScPOSITION(String scPOSITION) {
		this.scPOSITION = scPOSITION;
	}




	public String getScUSER_ID() {
		return scUSER_ID;
	}




	public void setScUSER_ID(String scUSER_ID) {
		this.scUSER_ID = scUSER_ID;
	}




	public String getScORGANIZATION() {
		return scORGANIZATION;
	}




	public void setScORGANIZATION(String scORGANIZATION) {
		this.scORGANIZATION = scORGANIZATION;
	}




    public String getScPTNR_CODE() {
        return scPTNR_CODE;
    }




    public void setScPTNR_CODE(String scPTNR_CODE) {
        this.scPTNR_CODE = scPTNR_CODE;
    }



}//end class