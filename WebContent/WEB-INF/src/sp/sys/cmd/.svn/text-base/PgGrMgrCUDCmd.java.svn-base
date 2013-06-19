/**
 * 파일명   : PgGrMgrCUDCmd.java 
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
import kjf.util.KJFUtil;
import org.apache.struts.action.ActionForm;

import sp.dao.PT_PG_GROUPDAO;
import sp.dao.PT_PG_GROUPEntity;

public class PgGrMgrCUDCmd implements KJFCommand {
	
	PT_PG_GROUPEntity  PT_PG_GROUPent 	=new PT_PG_GROUPEntity();
	PT_PG_GROUPDAO  PT_PG_GROUPdao 	=new PT_PG_GROUPDAO();
	

	private String next;
	
    public PgGrMgrCUDCmd() {
    }
    
    public PgGrMgrCUDCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String mode = request.getParameter("mode");
    	PT_PG_GROUPent.setRequestOnlyString(request); // request 값들 자동 세팅
    	KJFLog.debug(PT_PG_GROUPent.toString()); //세팅된 값들 확인
    	
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

    	String PG_GROUP_ID =KJFDBUtil.getMaxID("PG_GROUP_ID", "PT_PG_GROUP");

    	PT_PG_GROUPent.setPG_GROUP_ID(PG_GROUP_ID);  	
    	PT_PG_GROUPent.setUPD_DT(KJFDate.getCurTime());//현재 시간.
    	
    	PT_PG_GROUPdao.insert(PT_PG_GROUPent);
    	       
       
    } 
    

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
        PT_PG_GROUPent.setGROUP_NAME(request.getParameter("GROUP_NAME"));
    	PT_PG_GROUPent.setUPD_DT(KJFDate.getCurTime());//현재 시간.    	
    	PT_PG_GROUPdao.update(PT_PG_GROUPent);        
       
    } 
    
    
    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{
        
    	PT_PG_GROUPdao.delete(PT_PG_GROUPent);
    	
        String sql      = "";
        ReportDAO    rDAO        = new ReportDAO();
        
		sql      =
            "\n     DELETE FROM  PT_PG           "+
            "\n     WHERE	PG_GROUP_ID='"+PT_PG_GROUPent.getPG_GROUP_ID()+"' 	";
		rDAO.execute(sql);
    } 
    
    
}