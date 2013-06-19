/**
 * 파일명   : ComCodeMgrCmd.java 
 * 설명     : 공통코드관리 cmd  
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성 
 */

package sp.sys.cmd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.KJFDBUtil;

import sp.sys.SysParam;

public class ComCodeMgrCmd implements KJFCommand {

	private String next;
	
    public ComCodeMgrCmd() {
    }
    
    public ComCodeMgrCmd(String next_url) {
    	next = next_url; 
    }
    
    //검색 데이터 xml 자료 저장용
    private static List xmlListData = new ArrayList();
        

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        //검색조건 및 초기데이타 로드
        loadCondition(request);
        
        //검색조건 설정및 체크
        SysParam pm = checkPm(request, form); 
        
        //리스트 로드
        loadList(request, pm);
        
        //검색 데이터 초기화
        xmlDataInit();
        
        return next;
    }
   
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	
    	String sql=" SELECT   P_CODE, CODE_NAME " +
				   " FROM     PT_COM_CODE     " +
				   " WHERE    CODE = '000'  " +
				   " ORDER BY P_CODE            ";

		Vector v_code_group = new Vector();
		
		v_code_group = KJFSelectOPS.getSel(sql, "000","그룹 코드 등록(수정)");		
		request.setAttribute("v_code_group", v_code_group);
		
		v_code_group = KJFSelectOPS.getSel(sql, "","그룹 코드 유형 선택");		
		request.setAttribute("v_code_group_search", v_code_group);      
       
    }//end loadCondition

    
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
     * @param HttpServletRequest, ComParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        // 페이징 관련 cnt SQL 
        String cntSQL = "SELECT COUNT(*) CNT  FROM PT_COM_CODE PCC \n";

        //SELECT 항목 SQL
        String selectSQL =
        	" SELECT    PCC.SEQ,                                                              \n"+
        	"			PCC.CODE,                                                             \n"+ 
        	"			PCC.P_CODE,                                                           \n"+ 
        	"           "+KJFDBUtil.makeSql_nullFunc()+"(( SELECT CODE_NAME                                                \n"+ 
        	"                 FROM   PT_COM_CODE                                              \n"+ 
        	"                 WHERE  CODE='000'                                             \n"+ 
        	"                 AND    P_CODE=PCC.P_CODE ), 'Group') P_NAME,                      \n"+
        	"			PCC.CODE_NAME,                                                        \n"+ 
        	"			PCC.ORDER_SEQ,                                                        \n"+ 
        	"			PCC.USE_YN,    	                                                      \n"+ 
        	"			PCC.BIGO,    	                                                      \n"+ 
        	"			PCC.REG_DATE,                                                         \n"+ 
        	"			PCC.MOD_DATE,                                                         \n"+ 
        	"           CASE P_CODE WHEN '000' THEN (SELECT COUNT(CODE) CNT                        \n"+
        	"                                   FROM   PT_COM_CODE                            \n"+
        	"                                   WHERE  P_CODE= PCC.CODE)	     \n"+
        	"           			ELSE 0 END AS CHILD_CHK      \n"+
            " FROM      PT_COM_CODE PCC                                                       \n";
        
        String whereSQL = 
        	"WHERE	1=1	\n";
        
        if(!KJFUtil.isEmpty(pm.getScCODE_NAME())){
        	whereSQL +=
        	"  AND	PCC.CODE_NAME LIKE '%"+pm.getScCODE_NAME()+"%' \n";
        }
        if(!KJFUtil.isEmpty(pm.getScP_CODE()) && !"000".equals(pm.getScP_CODE())){
        	whereSQL +=
        	"  AND	PCC.P_CODE = '"+pm.getScP_CODE()+"' \n";
        }
        
        String orderSQL =
        	"ORDER BY  PCC.P_CODE, PCC.ORDER_SEQ ASC  \n";
        	
        
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

 
        rEntity    = rDAO.select(selectSQL+whereSQL+orderSQL ,nowPage, rowPerPage);
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);

    }//end loadList
    
    protected void xmlDataProcess(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String str = request.getParameter("str");
        
        StringBuffer results = new StringBuffer("<strings>");
        makeXmlData xmlData = null;
        for(Iterator it = xmlListData.iterator(); it.hasNext();) {
        	xmlData = (makeXmlData)it.next();
            if(xmlData.str.equals(str)) {
                    results.append("<string>");
                    results.append(xmlData.str);
                    results.append("</string>");
            }
        }
        results.append("</strings>");
        
        response.setContentType("text/xml");
        response.getWriter().write(results.toString());
    }
    
    public void xmlDataInit() throws ServletException {
    	xmlListData.add(new makeXmlData("한글"));
    	xmlListData.add(new makeXmlData("간다"));
    	xmlListData.add(new makeXmlData("간다고"));
    	xmlListData.add(new makeXmlData("한글날"));
    }

    private static class makeXmlData {
        private String str;
        
        public makeXmlData(String str) {
            this.str = str;
        }
    }
    
    

}