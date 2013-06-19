/**
 * 파일명   : UserMgrWCmd.java 
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
import sp.uent.*;


public class UserMgrWCmd implements KJFCommand {

	private String next;
	
    public UserMgrWCmd() {
    }
    
    public UserMgrWCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	// 커멘드 값
    	//String cmd = request.getParameter("cmd");
    	String mode = request.getParameter("mode");
    	
        //검색조건 및 초기데이타 로드
        loadCondition(request);
        
        //검색조건 설정및 체크
        UserParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);     
        
        //수정 상태 이면 데이터  로드
        if("M".equals(mode)){
        	loadDetail(request);
        }
        
        return next;
    }
    
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	
    	
    	/*********** 게시판 타입추가       시작 ***************/		
    	String sql = "SELECT CODE, CODE_NAME " +
			 " FROM PT_COM_CODE " +
			 " WHERE P_CODE = '0027'" +
			 " ORDER BY ORDER_SEQ";
    	
    	String sql1 = "SELECT AUTH_GROUP_CODE, AUTH_GROUP_NAME   FROM PT_AUTH_GROUP   ORDER BY AUTH_GROUP_NAME";

		
		Vector v_sc_type 	= KJFSelectOPS.getSel(sql);	
		request.setAttribute("v_sc_type", v_sc_type);   

		Vector v_sc_group_code 	= new Vector();
		
		v_sc_group_code = KJFSelectOPS.getSel(sql1);
		request.setAttribute("v_sc_group_code", v_sc_group_code);
		
		/*********** 게시판 타입추가  끝************************/      
       
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
     * Data를 load
     * @param HttpServletRequest
     * @return
     */
    private void loadDetail(HttpServletRequest request)throws Exception{

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = new ReportEntity();
       
        String USER_CODE = KJFUtil.print(request.getParameter("USER_CODE"));

        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                     									\n"+
			"			USER_CODE,      									\n"+
        	"			USER_ID,      										\n"+
        	"			USER_NAME,    			                            \n"+
        	"			USER_PASSWD,  			                            \n"+
        	"			USER_TEL,         	                             	\n"+
        	"			USER_EMAIL,   	  	                              	\n"+
        	"			USER_MOBILE,      	                              	\n"+
        	"			USER_NAT_NUM,   		                            \n"+
        	"			ORGANIZATION,                                     	\n"+
        	"			POSITION,    			                            \n"+
        	"			POST,			                            		\n"+
        	"			STAFF_LEVEL,			                            \n"+
        	"			STAFF_SYSTEM,			                            \n"+
        	"			CAPITAL,			                            	\n"+
        	"			USE_YN,			                            		\n"+
        	"			REG_DATE,  			                            	\n"+
        	"			MOD_DATE,  			                            	\n"+
        	"			LAST_CONN			                            	\n";    


        String fromSQL=
            "FROM                          									\n"+
            "    PT_USER							                  	\n";



        String whereSQL = 
        	"WHERE	USER_CODE='"+USER_CODE+"'	\n";
        
           

 
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);
        
        request.setAttribute("rEntity", rEntity);



    }//end loadDetail  
    
    
    
    


}