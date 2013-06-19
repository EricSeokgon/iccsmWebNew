package sp.mem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.util.*;


public class MemParam extends ActionForm {    
    
    /*����¡ ����*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 

    	
    /*�˻� ����-���λ� sc (serch condition) */
    private String scSD_CD;         // ��.�� �ڵ�
    private String scSGG_CD;        // ��.��.�� �ڵ�
    
    private String scSLCT_GUBUN;    // �˻� �ڵ�
    private String scTEXTVALUE;     // �˻� ��
    
    private String scMEM_GUBUN;

    public MemParam() {
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