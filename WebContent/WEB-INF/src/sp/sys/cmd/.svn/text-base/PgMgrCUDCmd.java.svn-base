/**
 * 파일명   : PgMgrCUDCmd.java 
 * 설명     : CUD cmd  
 * 이력사항
 * CH00     :2006/05/27 김경덕 최초작성 
 */

package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_PGDAO;
import sp.dao.PT_PGEntity;

public class PgMgrCUDCmd implements KJFCommand {
	
	PT_PGEntity  PT_PGent 	=new PT_PGEntity();
	PT_PGDAO  PT_PGdao 	=new PT_PGDAO();
	

	private String next;
	
    public PgMgrCUDCmd() {
    }
    
    public PgMgrCUDCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String mode = request.getParameter("mode");
    	PT_PGent.setRequestOnlyString(request); // request 값들 자동 세팅
    	KJFLog.debug(PT_PGent.toString()); //세팅된 값들 확인
    	
    	if(mode.equals("C")) { //입력
    		insertExe(request);
    	} else if (mode.equals("U")) { //수정
    		updateExe(request);
    	} else if (mode.equals("D")) { //삭제
    		deleteExe(request);
    	}
    	
              
        return next;
    }
    
    

    /**
     * 입력
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{
    	
    	
    	
    	ReportDAO    rDAO        = new ReportDAO();
    	String PG_ID = KJFDBUtil.getMaxID("PG_ID", "PT_PG");

    	PT_PGent.setPG_ID(PG_ID);  	
    	PT_PGent.setUPD_DT(KJFDate.getCurTime());//현재 시간.
    	
    	PT_PGdao.insert(PT_PGent);
    	       
       
    } 
    

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
    	   	  	
    	PT_PGent.setUPD_DT(KJFDate.getCurTime());//현재 시간.    	
    	PT_PGdao.update(PT_PGent);        
       
    } 
    
    
    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{

    	String[] str = request.getParameterValues("chk");
        
    	for(int i = 0; i < str.length; i++){
    		PT_PGent.setPG_ID(str[i]);
        	PT_PGdao.delete(PT_PGent);
    	}
    } 
    
}