package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;


public class PgLogLCmd implements KJFCommand{
	
	private String next;
	
    public PgLogLCmd() {
    }
    
    public PgLogLCmd(String next_url) {
    	next = next_url; 
    }

	public String execute(HttpServletRequest req, ActionForm form) throws Exception {
		
		
		SysParam pm = checkFrm(form);
		
		loadCondition(req);
		
		loadList(req, pm);
		
		return next;
	}
	
	private SysParam checkFrm(ActionForm form)throws Exception{
		
		SysParam frm = (SysParam)form;

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
    	ReportDAO    rDAO        = new ReportDAO();
		ReportEntity rEntity     = null;
		
		/*********** 사용자 정보 가져오기 시작 ***************/	
		String sql = "SELECT USER_CODE, USER_NAME FROM PT_USER ORDER BY USER_NAME ";
		Vector v_scUSER_CODE = KJFSelectOPS.getSel(sql,"",":::선택:::");
		request.setAttribute("v_scUSER_CODE", v_scUSER_CODE);
		/*********** 사용자 정보 가져오기 끝 ************************/
		
		/*********** 프로그램 목록 가져오기 시작 ***************/	
		String sql1 = "SELECT PG_ID, PG_NAME FROM PT_PG ORDER BY PG_NAME ";
		Vector v_scPG_ID = KJFSelectOPS.getSel(sql1,"",":::선택:::");
		request.setAttribute("v_scPG_ID", v_scPG_ID);
		/*********** 프로그램 목록 가져오기 끝 ************************/
		
		/*********** 사용자 액션 가져오기 시작 ***************/
		String[][] userAction = {{"",":::선택:::"},{"C","입력"},{"U","수정"},{"D","삭제"}}; 
		Vector v_user_action = KJFUtil.makeSelect(userAction);
		request.setAttribute("v_user_action", v_user_action);
		/*********** 사용자 액션 가져오기 끝 ************************/
        
    }//end loadCondition
	
	private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
		
		ReportDAO    rDAO        = new ReportDAO();
		ReportEntity rEntity     = null;
		
		String selectSQL = 
	         "    SELECT                                                                        	\n"+                                                         
	         "    		LOG_NUM,                                                                  	\n"+                                                         
	         "    		USER_CODE,                                                                	\n"+                                                         
	         "    		(SELECT USER_NAME FROM PT_USER WHERE USER_CODE = A.USER_CODE) USER_NAME,    \n"+
	         "  		(SELECT CODE_NAME FROM   PT_COM_CODE WHERE  CODE='0027'						\n"+
	         "			AND P_CODE=(SELECT USER_CODE FROM PT_USER WHERE USER_CODE = A.USER_CODE) ) POSITION, \n"+
	         "    		ACCESS_TIME,                                                             	\n"+                                                         
	         "    		PROGRAM_ID,                                                                 	\n"+                                                         
	         "    		B.PG_NAME PROGRAM_NAME,                                                                	\n"+                                                         
	         "    		USER_ACTION,                                                                   	\n"+                                                         
			 "    		REQ_URI                                                                   	\n";

	         
	    String fromSQL = 
			" FROM PT_SM_PROGRAM_LOG A LEFT JOIN PT_PG B ON A.PROGRAM_ID = B.PG_ID \n";
		
	    /*******페이징 관련 cnt SQL...********/
	    String cntSQL =
	        "SELECT             \n"+
	        "    COUNT(*)  CNT  \n"+
	        fromSQL ;
	    /*******페이징 관련 cnt SQL... 끝********/
	    
	    /*검색 시작*/
	    String whereSQL 	= "WHERE	1=1	\n";	    
	    
	    if(!KJFUtil.isEmpty(pm.getScSTART_DATE()) && !KJFUtil.isEmpty(pm.getScEND_DATE())){
    		whereSQL +=" AND SUBSTR(ACCESS_TIME,1,10) BETWEEN '" + pm.getScSTART_DATE() + "' AND '" + pm.getScEND_DATE() + "' ";
    	}
	    
	    if(!KJFUtil.isEmpty(pm.getScUSER_CODE())){
        	whereSQL +=" AND USER_CODE = '"+ pm.getScUSER_CODE()+"' ";
	    }
	    
	    if(!KJFUtil.isEmpty(pm.getScCUD())){
        	whereSQL +=" AND USER_ACTION = '"+ pm.getScCUD()+"' ";
	    }
	    
	    String orderSQL =" ORDER BY LOG_NUM DESC";
	    		
	    	    
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
		
	}
}

