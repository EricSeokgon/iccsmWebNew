/*
2006. 8. 4오후 5:53:58
*/

package sp.log.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_PAGE_CODEDAO;
import sp.dao.PT_PAGE_CODEEntity;


public class PageMgrCUDCmd implements KJFCommand {
	
	private PT_PAGE_CODEDAO dao = new PT_PAGE_CODEDAO();
	private PT_PAGE_CODEEntity entity = new PT_PAGE_CODEEntity();
	
	private String next;
	
    public PageMgrCUDCmd() {
    }
    
    public PageMgrCUDCmd(String next_url) {
    	next = next_url; 
    }
	
	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
		
		entity.setRequestOnlyString(request);
		
		String cmd = request.getParameter("cmd");
		
		/*신규등록*/
		if(cmd.equals("PageMgrC")){
			
			insertExe(request);
			
		}
		
		/*수정*/
		else if(cmd.equals("PageMgrU")){
			
			updateExe();
			
		}
		
		/*삭제*/
		else if(cmd.equals("PageMgrD")){
			
			deleteExe();
			
		}
		
		return next;
	}
	

    /**
     * 신규등록
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{

    	ReportDAO rdao = new ReportDAO();
    	ReportEntity renty1CHECK = new ReportEntity();
    	ReportEntity renty2CODE_GROUP_ID = new ReportEntity();
    	
    	
    	String query = "" +
    			"SELECT " +
    			"CODE_GROUP " +
    			"FROM PT_PAGE_CODE " +
    			"WHERE " +
    			"1=1" +
    			" AND CODE_GROUP = '"+KJFUtil.print(request.getParameter("CODE_GROUP"))+"'" +
    			" AND CODE ='"+KJFUtil.print(request.getParameter("CODE"))+"'";
    	
    	renty1CHECK = rdao.select(query);
    	
    	String queryMaxnum = "SELECT IFNULL(MAX(CODE_GROUP_ID)+0,0)+1 AS CODE_GROUP_ID FROM PT_PAGE_CODE";
    	renty2CODE_GROUP_ID = rdao.select(queryMaxnum);
    	   	
    	if(KJFUtil.isEmpty(renty1CHECK.getValue(0,"CODE_GROUP"))){
    		entity.setCODE_GROUP_ID(renty2CODE_GROUP_ID.getValue(0,"CODE_GROUP_ID"));
    		dao.insert(entity);
    	}else{
    		request.setAttribute("ex","이미 동일한 그룹에 동일한 코드가 등록되어 있습니다.");
    		throw new MsgException("");
    	}

    	
    }

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe()throws Exception{
    	
    		String[] fields ={"CODE_NAME","CODE_URL","ORDER_NUM","USE_YN"};
    		dao.updateModifiedOnly(entity, fields);
    }
    
    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe()throws Exception{
    	dao.delete(entity);
    }

}
