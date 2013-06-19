/**
 * ���ϸ�   : PgGrMgrCUDCmd.java 
 * ����     : CUD cmd  
 * �̷»���
 * CH00     :2006/05/27 ���� �����ۼ� 
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
    	PT_PG_GROUPent.setRequestOnlyString(request); // request ���� �ڵ� ����
    	KJFLog.debug(PT_PG_GROUPent.toString()); //���õ� ���� Ȯ��
    	
    	if(mode.equals("C")) { //�Է�
    		insertExe(request);
    	} else if (mode.equals("U")) { //����
    		updateExe(request);
    	} else if (mode.equals("D")) { //����
    		deleteExe(request);
    	}
    	
              
        return next;
    }
    
    

    /**
     * �Է�
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{
    	
    	ReportDAO    rDAO        = new ReportDAO();

    	String PG_GROUP_ID =KJFDBUtil.getMaxID("PG_GROUP_ID", "PT_PG_GROUP");

    	PT_PG_GROUPent.setPG_GROUP_ID(PG_GROUP_ID);  	
    	PT_PG_GROUPent.setUPD_DT(KJFDate.getCurTime());//���� �ð�.
    	
    	PT_PG_GROUPdao.insert(PT_PG_GROUPent);
    	       
       
    } 
    

    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
        PT_PG_GROUPent.setGROUP_NAME(request.getParameter("GROUP_NAME"));
    	PT_PG_GROUPent.setUPD_DT(KJFDate.getCurTime());//���� �ð�.    	
    	PT_PG_GROUPdao.update(PT_PG_GROUPent);        
       
    } 
    
    
    /**
     * ����
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