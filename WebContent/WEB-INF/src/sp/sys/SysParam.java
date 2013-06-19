/**
 * 파일명   : SysParam.java
 * 설명     : Parameter Bean 
 * 이력사항
 * HN00     :
 */

package sp.sys;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import kjf.util.KJFUtil;

public class SysParam extends ActionForm{    

    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage;

    private String isSearch;
    private String nextURL;
	
    /*검색 조건-접두사 sc (serch condition) */
    
    private String scP_CODE;
    private String scP_CODE_NAME;
    private String scCODE;
    private String scCODE_NAME;
    
    private String scAUTH_GROUP_CODE;
    private String scAUTH_GROUP_CODE_NAME;
    private String scUSER_ID;

    private String PG_GROUP_ID;
    private String USER_ID;
    
    /* 로그 관련 */
    private String scSTART_DATE;
    private String scEND_DATE;
    private String scUSER_CODE;
    private String scPG_ID;
    private String scCUD;
    
    private String scERR_YN;
    private String scTABLE_NAME;
    
    public SysParam() {
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




	public String getScP_CODE() {
		return this.scP_CODE;
	}

	public void setScP_CODE(String scP_CODE) {
		this.scP_CODE = scP_CODE;
	}

	public String getScP_CODE_NAME() {
		return this.scP_CODE_NAME;
	}

	public void setScP_CODE_NAME(String scCODE_NAME) {
		this.scP_CODE_NAME = scCODE_NAME;
	}

	public String getScCODE() {
		return scCODE;
	}

	public void setScCODE(String scCODE) {
		this.scCODE = scCODE;
	}

	public String getScCODE_NAME() {
		return scCODE_NAME;
	}

	public void setScCODE_NAME(String scCODE_NAME) {
		this.scCODE_NAME = scCODE_NAME;
	}


	public String getPG_GROUP_ID() {
		return PG_GROUP_ID;
	}


	public void setPG_GROUP_ID(String pg_group_id) {
		PG_GROUP_ID = pg_group_id;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String user_id) {
		USER_ID = user_id;
	}


	public String getScAUTH_GROUP_CODE() {
		return scAUTH_GROUP_CODE;
	}


	public void setScAUTH_GROUP_CODE(String scAUTH_GROUP_CODE) {
		this.scAUTH_GROUP_CODE = scAUTH_GROUP_CODE;
	}


	public String getScCUD() {
		return scCUD;
	}


	public void setScCUD(String scCUD) {
		this.scCUD = scCUD;
	}


	public String getScEND_DATE() {
		return scEND_DATE;
	}


	public void setScEND_DATE(String scEND_DATE) {
		this.scEND_DATE = scEND_DATE;
	}


	public String getScPG_ID() {
		return scPG_ID;
	}


	public void setScPG_ID(String scPG_ID) {
		this.scPG_ID = scPG_ID;
	}


	public String getScSTART_DATE() {
		return scSTART_DATE;
	}


	public void setScSTART_DATE(String scSTART_DATE) {
		this.scSTART_DATE = scSTART_DATE;
	}


	public String getScUSER_CODE() {
		return scUSER_CODE;
	}


	public void setScUSER_CODE(String scUSER_CODE) {
		this.scUSER_CODE = scUSER_CODE;
	}


	public String getScUSER_ID() {
		return scUSER_ID;
	}


	public void setScUSER_ID(String scUSER_ID) {
		this.scUSER_ID = scUSER_ID;
	}


	public String getScAUTH_GROUP_CODE_NAME() {
		return scAUTH_GROUP_CODE_NAME;
	}


	public void setScAUTH_GROUP_CODE_NAME(String scAUTH_GROUP_CODE_NAME) {
		this.scAUTH_GROUP_CODE_NAME = scAUTH_GROUP_CODE_NAME;
	}


	public String getScERR_YN() {
		return scERR_YN;
	}


	public void setScERR_YN(String scERR_YN) {
		this.scERR_YN = scERR_YN;
	}


	public String getScTABLE_NAME() {
		return scTABLE_NAME;
	}


	public void setScTABLE_NAME(String scTABLE_NAME) {
		this.scTABLE_NAME = scTABLE_NAME;
	}

}//end class