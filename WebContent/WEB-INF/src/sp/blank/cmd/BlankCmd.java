/**
 * 파일명   : BbsKCmd.java 
 * 설명     : BbsK  cmd  
 * 이력사항
 * CH00     :2006/05/27 김경덕 최초작성 
 */

package sp.blank.cmd;


import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.LoginException;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.blank.BlankParam;

public class BlankCmd implements KJFCommand {
	
	private String next;
    private String cmd;
    private String mode;


    public BlankCmd() {
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
		//검색조건 설정및 체크
        BlankParam pm = checkPm(request, form);
        
        next = pm.getNextURL();
        
        request.setAttribute("pm", pm);
    	
    	mode = KJFUtil.print(request.getParameter("mode")); 
    	
        //검색조건 및 초기데이타 로드
        loadCondition(request);
        
        loadData(request, pm );
        
        
        
    	return next;
    }
    
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	/*********** 게시판 검색 코드  시작 ***************/		
    	String sql = "SELECT CODE, CODE_NAME " +
			 " FROM PT_BBS_COM_CODE " +
			 " WHERE CODE_GROUP = '003'" +
			 "  AND CODE <> '000'" +
			 " ORDER BY ORDER_NUM";
		
		Vector v_scSLCT_GUBUN 	= KJFSelectOPS.getSel(sql);	
		request.setAttribute("v_scSLCT_GUBUN", v_scSLCT_GUBUN);   
		/*********** 게시판 검색 코드  끝 ***************/	

	
       
    }//end loadCondition
    
    


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private BlankParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	BlankParam pm = (BlankParam)form;
    	String nextURL = KJFUtil.print(request.getParameter("nextURL"));
    	
    	if("".equals(nextURL))
    		nextURL = "/com/Blank.jsp";
    	
    	pm.setNextURL(nextURL);
    	
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
     * @param HttpServletRequest, BlankParam
     * @return
     */    
    private void loadData(HttpServletRequest request, BlankParam pm ) throws Exception {
          	
               

    }    
    
    
    
    
   
 


}