/**
 * 파일명   : BbsControlCmd.java 
 * 설명     : 보드관리 cmd  
 * 이력사항
 * CH00     :2006/07/4 오두식 최초작성 
 */
package sp.user.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFSelect;
import kjf.util.KJFUtil;
import sp.user.UserParam;


public class UserMgrCmd implements KJFCommand {

	private String next;
	
    public UserMgrCmd() {
    }
    
    public UserMgrCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	
        //검색조건 및 초기데이타 로드
        loadCondition(request);
        
        //검색조건 설정및 체크
        UserParam pm = checkPm(request, form);
        
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
    	    	
    	/*********** 회원 검색  타입추가       시작 ***************/		
    	String[][] selField = {{"000","검색조건"},{"USER_NAME","성명"},{"USER_ID","아이디"},{"USER_TEL","전화번호"},{"USER_MOBILE","핸드폰"},{"USER_EMAIL","이메일"}}; // 게시판 타입
    	String[][] selCondition = {{"like","유사검색"},{"=","단어일치"}}; //사용 유무
    	String[][] selOrder = {{"desc","오름차순 정렬"},{"asc","내림차순 정렬"}}; //사용 유무
		String sql=" SELECT   CODE, CODE_NAME " +
				   " FROM     PT_COM_CODE     " +
				   " WHERE    P_CODE = '0027' AND USE_YN='Y' AND CODE!='000'" +
				   " ORDER BY CODE            ";
		
		Vector v_sc_field 	= KJFUtil.makeSelect(selField);
		request.setAttribute("v_sc_field", v_sc_field);   
		
		Vector v_sc_condition 	= KJFUtil.makeSelect(selCondition);
		request.setAttribute("v_sc_condition", v_sc_condition);
		
		Vector v_sc_order 	= KJFUtil.makeSelect(selOrder);
		request.setAttribute("v_sc_order", v_sc_order);
		
		Vector v_sc_position 	= KJFSelectOPS.getSel(sql,"","부서");
		request.setAttribute("v_sc_position", v_sc_position);
		/*********** 회원 검색 타입추가  끝************************/      
       
    }//end loadCondition


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private UserParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	UserParam pm = (UserParam)form;



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
     * @param HttpServletRequest, UserParam
     * @return
     */
    private void loadList(HttpServletRequest request, UserParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String orderSQL 		 = "";


        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                     									\n"+ 
          	"  USER_CODE, USER_NAME, USER_ID, USER_PASSWD, USER_EMAIL, USER_TEL,  \n"+ 
        	"  USER_MOBILE, USER_NAT_NUM, ORGANIZATION," +
        	"(SELECT CODE_NAME FROM PT_COM_CODE WHERE P_CODE = '0027' AND CODE =  POSITION) POSITION, POST, STAFF_SYSTEM,  \n"+ 
        	"  STAFF_LEVEL, EMAIL, (SELECT AUTH_GROUP_NAME FROM PT_AUTH_GROUP WHERE AUTH_GROUP_CODE = CAPITAL) CAPITAL, \n" +
        	"  USER_AUTH, USE_YN, REG_DATE, MOD_DATE, LAST_CONN \n" +
        	"  \n";


        String fromSQL=
            "FROM                          									\n"+
            "    PT_USER							                  	\n";




        
            
        /*******페이징 관련 cnt SQL...********/
        String cntSQL =
            "SELECT             \n"+
            "    COUNT(*)  CNT  \n"+
            fromSQL ;
       /*******페이징 관련 cnt SQL... 끝********/


        String whereSQL = 
        	"WHERE	1=1				\n";
        
        if(!KJFUtil.isEmpty(pm.getScPOSITION())){
        	whereSQL +=
        		"	AND POSITION = '" + pm.getScPOSITION() + "'    \n";
        }
        		
        if(!KJFUtil.isEmpty(pm.getScTEXT()) && !"000".equals(pm.getScFIELD())){
        	if(pm.getScCONDITION().equals("like")){
        		whereSQL +=
                	"  AND	"+pm.getScFIELD()+" like '%"+pm.getScTEXT()+"%' 	\n";
        	}else{
        		whereSQL +=
                	"  AND	"+pm.getScFIELD()+" = '"+pm.getScTEXT()+"' 	\n";
        	}
        	
        }
        
        
        if(!KJFUtil.isEmpty(pm.getScORDER()) && !"000".equals(pm.getScFIELD())){
        	orderSQL =
            	"ORDER BY  "+pm.getScFIELD()+" "+pm.getScORDER()+"      \n";
        }else{
        	orderSQL =
            	"ORDER BY  USER_NAME ASC      \n";
        	
        	pm.setScORDER("asc");        	
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