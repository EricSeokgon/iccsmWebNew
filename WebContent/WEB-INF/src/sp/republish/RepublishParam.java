/**
 * ���ϸ�   : RepublishParam.java
 * ����      : Parameter Bean 
 * �̷»���
 * 
 */
package sp.republish;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import kjf.util.*;


public class RepublishParam extends ActionForm{    


    /*����¡ ����*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 

    /* �������ø ����κ� -> ����, �� ������ */
    private String sPage;
    private String ePage;
    
    /*�˻� ����-���λ� sc (serch condition) */


    public RepublishParam() {
    }


 

    /**
    *	request�� ���� parameter�� �ش� value�� ���
    *	paramName : value
    *	�������� ���
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

	public String getSPage() {
		return sPage;
	}

	public void setSPage(String page) {
		sPage = page;
	}

	public String getEPage() {
		return ePage;
	}

	public void setEPage(String page) {
		ePage = page;
	}



}//end class


