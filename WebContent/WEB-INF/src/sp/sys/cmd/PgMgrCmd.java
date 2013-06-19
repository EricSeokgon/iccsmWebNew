/**
 * ���ϸ�   : PgMgrCmd.java 
 * ����     : ���α׷� ������ ����Ʈ cmd  
 * �̷»���
 * �����ۼ� :2006/09/05 �缮ȯ �����ۼ� 
 */

package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.sys.SysWorker;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;


public class PgMgrCmd implements KJFCommand {

	private String next;
	
    public PgMgrCmd() {
    }
    
    public PgMgrCmd(String next_url) {
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
    	String sql=	"SELECT PG_GROUP_ID, GROUP_NAME " +
			"FROM   PT_PG_GROUP  ORDER BY GROUP_NAME";

		Vector v_pg_group_id 	= new Vector();
		
		v_pg_group_id = KJFSelectOPS.getSel(sql, "","��ü");
		request.setAttribute("v_sc_pg_group_id", v_pg_group_id);   
		
		v_pg_group_id = KJFSelectOPS.getSel(sql);
		request.setAttribute("v_pg_group_id", v_pg_group_id);           
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

        /********************����¡ ����*****************************/
        //����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
             pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
       
        return pm;
    }//end checkPm
    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
        /****** �˻����� �ʱⰪ ***********/
    	SysWorker worker =new SysWorker();
        //�޴��׷찡����
        Vector v_menuEntList = new Vector();
        v_menuEntList = worker.getMenuGrEntList("0");        
        request.setAttribute("v_menuEntList", v_menuEntList);    
        
        request.setAttribute("pm", pm);       
    }//end loadList  


}