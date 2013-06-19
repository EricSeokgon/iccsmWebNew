/**
 * ���ϸ�   : PgGrMgrCmd.java 
 * ����     : ����Ʈ cmd  
 * �̷»���
 * CH00     :2006/05/27 ���� �����ۼ� 
 */

package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import sp.sys.SysParam;
import sp.sys.SysWorker;

public class PgGrMgrCmd implements KJFCommand {


	private String next;
	
    public PgGrMgrCmd() {
    }
    
    public PgGrMgrCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	
        //�˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request);
        
        //�˻����� ������ üũ
        SysParam pm = checkPm(request, form);
        
        //����Ʈ �ε�
        loadList(request, pm);
        
        
        return next;
    }
    
    
    
    /**
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	
    	String sql="SELECT PG_GROUP_ID, GROUP_NAME " +
    			   " FROM   PT_PG_GROUP  ORDER BY GROUP_NAME";
    	
        Vector v_p_group_id 	= new Vector();
        v_p_group_id = KJFSelectOPS.getSel(sql, "0","�����޴� ����");
        request.setAttribute("v_p_group_id", v_p_group_id);        
       
    }//end loadCondition


    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{

    	SysParam pm = (SysParam)form;

        //�Ķ���� �����
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm

 
    
    
    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
    	
    	
    	SysWorker worker =new SysWorker();
        //�޴��׷찡����
        Vector v_menuEntList = new Vector();
        v_menuEntList = worker.getMenuGrEntList("0");
        request.setAttribute("v_menuEntList", v_menuEntList);    	
        




    }//end loadList  
    
    
    
    


}