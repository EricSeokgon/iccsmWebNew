/**
 * 파일명   : AuthGrMgrCmd.java 
 * 설명     : 권한그룹관리 cmd  
 * 이력사항
 * CH00     : 2006/09/12 양석환 최초작성 
 */

package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import sp.sys.SysParam;

public class AuthGrMgrCmd implements KJFCommand  {
	
	private String next;
	
    public AuthGrMgrCmd() {
    }
    
    public AuthGrMgrCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        //검색조건 설정및 체크
        SysParam pm = checkPm(request, form);
        
        //리스트 로드
        loadList(request, pm);
        
        return next;
    }

    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{

    	SysParam pm = (SysParam)form;

        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));
        
        /********************페이징 관련*****************************/
        //페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
       
        return pm;

    }//end checkPm
    
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
    	
        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        //SELECT 항목 SQL...
        String selectSQL = "SELECT AUTH_GROUP_CODE,	\n"+
						   "       AUTH_GROUP_NAME, \n"+ 
						   "       ORDER_SEQ,       \n"+ 
						   "       USE_YN           \n"; 
				
		String fromSQL   = "FROM   PT_AUTH_GROUP    \n";

        /*******페이징 관련 cnt SQL...********/
        String cntSQL    = "SELECT COUNT(*) CNT     \n" + fromSQL ;
        /*******페이징 관련 cnt SQL... 끝********/

        String whereSQL  = "WHERE  1=1 \n";
        
        if(!KJFUtil.isEmpty(pm.getScCODE())){
        	whereSQL    += "  AND  AUTH_GROUP_CODE LIKE '%" + pm.getScCODE() + "%' \n";
        }
        if(!KJFUtil.isEmpty(pm.getScCODE_NAME())){
        	whereSQL    += "  AND  AUTH_GROUP_NAME LIKE '%" + pm.getScCODE_NAME() + "%' \n";
        }
        
        String orderSQL  = "ORDER BY  ORDER_SEQ ASC \n";

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
        
        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);
        
        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /********************페이징 관련 끝********************************************************************/
        
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL ,nowPage, rowPerPage);
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);

    }//end loadList  
    
}
