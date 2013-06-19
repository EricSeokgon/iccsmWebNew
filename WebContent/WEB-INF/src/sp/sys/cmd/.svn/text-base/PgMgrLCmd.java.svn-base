/**
 * 파일명   : PgMgrCmd.java 
 * 설명     : 리스트 cmd  
 * 이력사항
 * CH00     :2006/04/19 김경덕 최초작성 
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

public class PgMgrLCmd implements KJFCommand {

	private String next;
	
    public PgMgrLCmd() {
    }
    
    public PgMgrLCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        //검색조건 및 초기데이타 로드
       // loadCondition(request);
        //검색조건 설정및 체크
        SysParam pm = checkPm(request, form);
        //리스트 로드
        loadList(request, pm);
        
        return next;
    }
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	String sql=	"SELECT PG_GROUP_ID, GROUP_NAME " +
		   			"FROM   PT_PG_GROUP  ORDER BY GROUP_NAME";

		Vector v_pg_group_id 	= new Vector();
		
		v_pg_group_id = KJFSelectOPS.getSel(sql, "","전체");
		request.setAttribute("v_sc_pg_group_id", v_pg_group_id);   
		
		v_pg_group_id = KJFSelectOPS.getSel(sql);
		request.setAttribute("v_pg_group_id", v_pg_group_id);           
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
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        //SELECT 항목 SQL...
        String selectSQL =
        	"SELECT	PP.PG_ID,            	                               \n"+
        	"		PP.PG_NAME,     		                               \n"+
        	"		PP.PG_URL,         	                                   \n"+ 
        	"		PP.UPD_DT,         	                                   \n"+
        	"		PP.USE_YN,        		                               \n"+
        	"		PP.ORDER_SEQ,  		                                   \n"+ 
        	"		PP.PG_GROUP_ID, 		                               \n"+
        	"		( SELECT GROUP_NAME                                    \n"+
        	"         FROM   PT_PG_GROUP                                   \n"+
        	"         WHERE  PG_GROUP_ID = PP.PG_GROUP_ID ) AS GROUP_NAME  \n"+ 
            "FROM   PT_PG PP                                               \n";		
            
        /*******페이징 관련 cnt SQL...********/
        String cntSQL =
            "SELECT COUNT(*) CNT  FROM PT_PG \n";
       /*******페이징 관련 cnt SQL... 끝********/


        String whereSQL = 
        	"WHERE	1=1  \n";
        
        if(!KJFUtil.isEmpty(pm.getScCODE_NAME())){
        	whereSQL +=
        	"  AND	PG_NAME LIKE '%"+pm.getScCODE_NAME()+"%'  \n";
        }
        if(!KJFUtil.isEmpty(pm.getScP_CODE())){
        	whereSQL +=
        	"  AND	PG_GROUP_ID = '"+pm.getScP_CODE()+"'  \n";
        }
        
        String orderSQL =
        	"ORDER BY  ORDER_SEQ  \n";
        	

        
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

 
        rEntity    = rDAO.select(selectSQL+whereSQL+orderSQL ,nowPage, rowPerPage);
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);
    }//end loadList  
    
    
    
    


}