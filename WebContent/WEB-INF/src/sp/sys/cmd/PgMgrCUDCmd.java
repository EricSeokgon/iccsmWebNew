/**
 * ���ϸ�   : PgMgrCUDCmd.java 
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
    	PT_PGent.setRequestOnlyString(request); // request ���� �ڵ� ����
    	KJFLog.debug(PT_PGent.toString()); //���õ� ���� Ȯ��
    	
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
    	String PG_ID = KJFDBUtil.getMaxID("PG_ID", "PT_PG");

    	PT_PGent.setPG_ID(PG_ID);  	
    	PT_PGent.setUPD_DT(KJFDate.getCurTime());//���� �ð�.
    	
    	PT_PGdao.insert(PT_PGent);
    	       
       
    } 
    

    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
    	   	  	
    	PT_PGent.setUPD_DT(KJFDate.getCurTime());//���� �ð�.    	
    	PT_PGdao.update(PT_PGent);        
       
    } 
    
    
    /**
     * ����
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