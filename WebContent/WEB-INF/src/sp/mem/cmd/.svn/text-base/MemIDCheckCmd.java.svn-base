/**
 * 파일명   : BbsControlCmd.java 
 * 설명     : 보드관리 cmd  
 * 이력사항
 * CH00     :2006/07/4 오두식 최초작성 
 */
package sp.mem.cmd;

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
import kjf.util.MsgException;
import sp.mem.MemParam;


public class MemIDCheckCmd implements KJFCommand {


	private String next;
	
    public MemIDCheckCmd() {
    }
    
    public MemIDCheckCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	if(request.getParameter("type")==null||request.getParameter("type").equals("id")){
    		//아이디 중복 검사
    		
    		//검색조건 설정및 체크
    		MemParam pm = checkPm(request, form);
    		
    		//리스트 로드
    		if(isUserID(request, pm)){
    			request.setAttribute("isUserID","Y");
    		}else{
    			request.setAttribute("isUserID","N");
    		}
    		
    		request.setAttribute("pm", pm);
    	}else{
    		//별명 중복 검사
    		if(existUserNickname(request)){
    			request.setAttribute("isUserID","Y");
    		}else{
    			request.setAttribute("isUserID","N");
    		}
    	}
	    
        return next;
    }
    


    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MemParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	MemParam pm = (MemParam)form;
    	
    	pm.setScSTAFF_CD(request.getParameter("STAFF_CD"));


        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm


    
    
    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, MemParam
     * @return
     */
    private boolean isUserID(HttpServletRequest request, MemParam pm)throws Exception{
        
    	 ReportDAO    rDAO        = new ReportDAO();
         ReportEntity rEntity     = null;
         String orderSQL 		 = "";
         boolean isRegistered		 = false; 				

         //SELECT 항목 SQL...
         String selectSQL =
 			"SELECT                     									\n"+ 
         	"			count(*) as CNT      								\n";
  


         String fromSQL=
             "FROM                          									\n"+
             "    PT_HOM_USER							                  	\n";


         String whereSQL = "";

         
         if (KJFUtil.isEmpty(pm.getScUSER_ID()) ) {
             throw new MsgException("검색할 아이디를 입력해 주십시오.");
         }
         else{
         	whereSQL +=
         		"  WHERE USER_ID=LOWER('" + pm.getScUSER_ID() + "')" +
         		" OR USER_ID=UPPER('" + pm.getScUSER_ID() + "') \n";
         }
         

         rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
         
         if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){        	 
         	isRegistered = true;
         }

         return isRegistered;
    }//end loadList   
    

    private boolean existUserNickname(HttpServletRequest request)throws Exception{
        
//        ReportDAO    rDAO        = new ReportDAO();
//        ReportEntity rEntity     = null;
//       // String orderSQL 		 = "";
        boolean isRegistered		 = false; 		
//        String nickname =  request.getParameter("USER_NICKNAME");
//        //String nickname = new String(request.getParameter("USER_NICKNAME").getBytes("8859_1"), "EUC-KR");
//
//        //SELECT 항목 SQL...
//        String selectSQL =
//			"SELECT                     									\n"+ 
//        	"			count(*) as CNT      								\n";
// 
//
//
//        String fromSQL=
//            "FROM                          									\n"+
//            "    WEB_IP_USER							                  	\n";
//
//
//        String whereSQL = "";
//
//
//    	whereSQL +=
//    		"  WHERE USER_NICKNAME='"+nickname+"' \n";
//    
//        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);
//        
//        if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0)
//        	isRegistered = true;
//
        return isRegistered;
    }//end loadList   
    
}