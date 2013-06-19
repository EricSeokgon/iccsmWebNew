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


public class UserZipSearchCmd implements KJFCommand {

	private String next;
	
    public UserZipSearchCmd() {
    }
    
    public UserZipSearchCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	
        
        //검색조건 설정및 체크
        UserParam pm = checkPm(request, form);
        
        String searchKey 		 = KJFUtil.print(request.getParameter("searchKey"));
        //리스트 로드
        if(!"".equals(searchKey) && !"null".equals(searchKey))
        	loadList(request, pm);
        
        
        return next;
    }
    
    
    
    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private UserParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	UserParam pm = (UserParam)form;



        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));

       
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
        String searchKey 		 = KJFUtil.print(request.getParameter("searchKey"));


        //SELECT 항목 SQL...
        String selectSQL =
			"SELECT                     								\n"+ 
        	"			SEQ,      										\n"+
        	"			ZIPCODE,    			                        \n"+
        	"			SIDO,  			                            	\n"+
        	"			GUGUN,         	                             	\n"+
        	"			DONG,   	  	                              	\n"+
        	"			BUNJI      	                              	\n";


        String fromSQL=
            "FROM                          								\n"+
            "    PT_COM_ZIPCODE							                \n";

        String whereSQL = "WHERE 1=1 ";
        
        if(!"null".equals(searchKey)){
	        whereSQL += 
	            	" AND	GUGUN like '%" + searchKey + "%' OR \n " +
	            	" DONG like '%" + searchKey + "%'			\n";
        }

        
        String orderSQL =
        	"ORDER BY SEQ      \n";
        

        	

        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL );
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);



    }//end loadList  
    
    
    
    


}