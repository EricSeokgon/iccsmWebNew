package sp.mem.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.mem.MemParam;

public class MemAdminMgrLCmd implements KJFCommand {
	
	private String next;
	
	public MemAdminMgrLCmd() {
    }
	
	public MemAdminMgrLCmd(String next_url) {
    	next = next_url; 
    }
	
	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
        //검색조건 및 초기데이타 로드
        loadCondition(request);
        
        //검색조건 설정및 체크
        MemParam pm = checkPm(request, form);
        
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
    	String[][] selField = {{"LNAME","이름"},{"STAFF_CD","아이디"},{"TEL_NUM","전화번호"},{"MOBILE_NO","핸드폰"},{"EMAIL_ADDR","이메일"},{"JOIN_DATE","가입일"}}; // 게시판 타입
    	String[][] selCondition = {{"like","유사검색"},{"=","단어일치"}}; //사용 유무
    	String[][] selOrder = {{"desc","오름차순 정렬"},{"asc","내림차순 정렬"}}; //사용 유무
		
		Vector v_sc_field 	= KJFUtil.makeSelect(selField);
		request.setAttribute("v_sc_field", v_sc_field);   
		
		Vector v_sc_condition 	= KJFUtil.makeSelect(selCondition);
		request.setAttribute("v_sc_condition", v_sc_condition);
		
		Vector v_sc_order 	= KJFUtil.makeSelect(selOrder);
		request.setAttribute("v_sc_order", v_sc_order);
		/*********** 회원 검색 타입추가  끝************************/      
       
    }//end loadCondition
    
    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MemParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	MemParam pm = (MemParam)form;



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
    private void loadList(HttpServletRequest request, MemParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String orderSQL 		 = "";


        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                   									    \n"+ 
        	"			STAFF_CD,   										\n"+
        	"			PASSWORD,      										\n"+
        	"			FNAME,      										\n"+
        	"			LNAME,      										\n"+
        	"			CONAME,      										\n"+
        	"			DEPTNM,      										\n"+
        	"			ADDR,      										    \n"+
        	"			ZIP_CD,      										\n"+
        	"			TEL_INT,      										\n"+
        	"			TEL_AREA,      										\n"+
        	"			TEL_NUM,      										\n"+
        	"			TEL_EXT,      										\n"+
        	"			FAX_INT,      										\n"+
        	"			FAX_AREA,      										\n"+
        	"			FAX_NUM,      										\n"+
        	"			MOBILE_NO,      									\n"+
        	"			EMAIL_ADDR,      									\n"+
        	"			CITY_CODE,      									\n"+
        	"			STATE_CODE,      									\n"+
        	"			PTNR_TYPE,      									\n"+
        	"			ADMIN,      										\n"+
        	"			USER_LEVEL,      									\n"+
        	"			USER_TYPE,      									\n"+
        	"			USER_CHK,      										\n"+
        	"			USER_TMNL,      									\n"+
        	"			USER_APP,      										\n"+
        	"			USER_GROUP,      									\n"+
        	"			GENDER,      										\n"+
        	"			AGE,      										    \n"+
        	"			BIRTHDAY,      										\n"+  
            "           USER_NOTY,                                          \n"+
            "           JOIN_DATE,                                          \n"+
            "           UPDATE_CD,                                          \n"+
            "           UPDATE_TIME,                                        \n"+
            "           BRNUM,                                              \n"+
            "           RRNUM                                               \n";
        
        String fromSQL=
            "FROM                          									\n"+
            "    WEB_IP_USER							                  	\n";




        
            
        /*******페이징 관련 cnt SQL...********/
        String cntSQL =
            "SELECT             \n"+
            "    COUNT(*)  CNT  \n"+
            fromSQL ;
       /*******페이징 관련 cnt SQL... 끝********/


        String whereSQL = 
        	"WHERE	1=1				\n";
        
        if(!KJFUtil.isEmpty(pm.getScTEXT()) && !"000".equals(pm.getScFIELD())){
        	if(pm.getScCONDITION().equals("like")){
        		whereSQL +=
                	"  AND	"+pm.getScFIELD()+" like '%"+pm.getScTEXT()+"%' 	\n";
        	}else{
        		whereSQL +=
                	"  AND	"+pm.getScFIELD()+" = '"+pm.getScTEXT()+"' 	\n";
        	}
    	}
        
        
        if(!KJFUtil.isEmpty(pm.getScORDER())){
        	orderSQL =
            	"ORDER BY  "+pm.getScFIELD()+" "+pm.getScORDER()+"      \n";
        }else{
        	orderSQL =
            	"ORDER BY  JOIN_DATE DESC      \n";
        	
        	pm.setScFIELD("LNAME");
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
