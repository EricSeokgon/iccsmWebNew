package sp.bbs.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;

/***************************************************************************
 * <p>Title       : BbsCodeMgrCmd Class</p>
 * <p>Description : 게시판 코드관리 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판 코드관리 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class BbsCodeMgrCmd implements KJFCommand {
	private String next;

    public BbsCodeMgrCmd() {
    }
    
    public BbsCodeMgrCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        //검색조건 및 초기데이타 로드
        loadCondition(request);

        //검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);

        //리스트 로드
        loadList(request, pm);

        return next;
    }


    /***************************************************************************
     * 검색조건 및 초기데이타 로드
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadCondition(HttpServletRequest request)throws Exception{

    	String sql=
            " SELECT CODE_GROUP, CODE_NAME  \n" +
		    "   FROM PT_BBS_COM_CODE        \n" +
		    "  WHERE CODE like '%000'       \n" +
		    "  ORDER BY CODE_GROUP";

		Vector v_code_group 	= new Vector();

		v_code_group = KJFSelectOPS.getSel(sql, "0", "그룹 코드 등록");
		request.setAttribute("v_code_group", v_code_group);

		v_code_group = KJFSelectOPS.getSel(sql, "", "코드 그룹 선택");
		request.setAttribute("v_code_group_search", v_code_group);
    }


    /***************************************************************************
     * 검색조건 초기값 설정및 체크
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     **************************************************************************/
    private BbsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

    	BbsParam pm = (BbsParam)form;
        
        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        // 페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

        return pm;
    }
    

    /***************************************************************************
     * 조건에 따른 list를 load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadList(HttpServletRequest request, BbsParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;

        //SELECT 항목 SQL...
        String selectSQL =
        	" SELECT                     \n" +
        	"		 CODE_GROUP,         \n" +
        	"		 CODE,               \n" +
        	"		 CODE_NAME,          \n" +
        	"		 BIGO,               \n" +
        	"		 ORDER_NUM,          \n" +
        	"		 USE_YN              \n";

        String fromSQL=
            "   FROM PT_BBS_COM_CODE     \n";


        /*******페이징 관련 cnt SQL...********/
        String cntSQL =
            " SELECT COUNT(*)  CNT      \n"+
            fromSQL ;
       /*******페이징 관련 cnt SQL... 끝********/

        String whereSQL =
        	"  WHERE 1=1				\n";

        if (!KJFUtil.isEmpty(pm.getScCODE_NAME())) {
        	whereSQL +=
        	"    AND CODE_NAME LIKE '%" + pm.getScCODE_NAME() + "%' \n";
        }
        
        if (!KJFUtil.isEmpty(pm.getScCODE_GROUP())) {
        	whereSQL +=
        	"    AND CODE_GROUP = '" + pm.getScCODE_GROUP() + "' 	\n";
        }

        String orderSQL =
        	" ORDER BY  CODE_GROUP,ORDER_NUM ASC                    \n";


        /* *************************** 페이징 관련 *******************************/
        // 전체 목록 수
        String totalCount="";

        // 페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        // 현재 페이지 번호
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL+whereSQL);
        totalCount=rEntity.getValue(0, "CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* *************************** 페이징 관련 끝 *****************************/

        rEntity = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL ,nowPage, rowPerPage);

        // 검색조건 초기값
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
    }

}