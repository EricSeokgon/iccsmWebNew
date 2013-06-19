/*
2006. 8. 1오후 7:06:47
*/

package sp.log.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.log.PageParam;


public class PageMgrLCmd implements KJFCommand{
	
	private String next;
	
    public PageMgrLCmd() {
    }
    
    public PageMgrLCmd(String next_url) {
    	next = next_url; 
    }

	public String execute(HttpServletRequest req, ActionForm form) throws Exception {
		
		
		PageParam pm = checkFrm(form);
		
		loadCondition(req);
		
		loadList(req, pm);
		
		return next;
	}
	
	private PageParam checkFrm(ActionForm form)throws Exception{
		
		PageParam frm = (PageParam)form;

        /*페이징 라인*/
        if (KJFUtil.isEmpty(frm.getRowPerPage())){
        	
        	frm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
		return frm;
		
	}
	
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	    	
    	/*********** 검색  타입추가       시작 ***************/		
    	String[][] scCODE = {{"CODE_GROUP","코드그룹"},{"CODE","코드"},{"CODE_NAME","코드명"},{"CODE_URL","URL"}}; //검색 조건
		Vector v_scCODE 	= KJFUtil.makeSelect(scCODE);
		request.setAttribute("v_scCODE", v_scCODE);
		
		String[][] scORDER = {{"desc","오름차순 정렬"},{"asc","내림차순 정렬"}};
		Vector v_scORDER 	= KJFUtil.makeSelect(scORDER);
		request.setAttribute("v_scORDER", v_scORDER);
		
		/*********** 검색 타입추가  끝************************/      
       
    }//end loadCondition
	
	private void loadList(HttpServletRequest request, PageParam pm)throws Exception{
		
		ReportDAO    rDAO        = new ReportDAO();
		ReportEntity rEntity     = null;
		
		String selectSQL = "SELECT CODE_GROUP_ID, CODE_GROUP, CODE, CODE_NAME, CODE_URL, ORDER_NUM,USE_YN ";

		String fromSQL = "FROM PT_PAGE_CODE \n";
		
	    /*******페이징 관련 cnt SQL...********/
	    String cntSQL =
	        "SELECT             \n"+
	        "    COUNT(*)  CNT  \n"+
	        fromSQL ;
	   /*******페이징 관련 cnt SQL... 끝********/
	    
	    
	    /*검색 시작*/
	    String whereSQL = 
	    	"WHERE	1=1						\n";
	    
	    if(!KJFUtil.isEmpty(pm.getV_scCODE())){
	    	whereSQL +="AND "+pm.getV_scCODE()+" like '%"+pm.getScFILDE()+"%' ";
	    }
			
	    String orderSQL ="ORDER BY ";
	    		
	    if(!KJFUtil.isEmpty(pm.getScORDER_NUM())){
	    	orderSQL += "ORDER_NUM "+pm.getScORDER_NUM();
	    }else{
	    	orderSQL += "ORDER_NUM DESC";
	    }
	    
	    /********************페이징 관련***********************************************************************/
	    //전체 목록 수
	    String totalCount="";
	
	    //페이지별 목록 수
	    int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());
	
	    //현재 페이지 번호
	    int nowPage = 1;
	    nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());
	
	    rEntity = rDAO.select(cntSQL+whereSQL);
	    totalCount=rEntity.getValue(0,"CNT");
	
	    if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;
	
	    pm.setTotalCount(totalCount);
	    pm.setNowPage(String.valueOf(nowPage));
	    /********************페이징 관련 끝********************************************************************/
	    
	    rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL ,nowPage, rowPerPage);
	    
	    /****** 검색조건 초기값 ***********/
	    request.setAttribute("pm", pm);       
	    request.setAttribute("rEntity", rEntity);
    
		
	}
}
