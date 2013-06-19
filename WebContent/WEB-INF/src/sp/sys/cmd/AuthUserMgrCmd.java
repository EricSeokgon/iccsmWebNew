package sp.sys.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.sys.SysWorker;

public class AuthUserMgrCmd implements KJFCommand {
    
	private String next;
	
    public AuthUserMgrCmd() {
    }
    
    public AuthUserMgrCmd(String next_url) {
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
    	//���߿� �ٽ�..Ȯ��
    	String sql = "SELECT USER_ID, USER_NAME   FROM PT_USER   ORDER BY USER_NAME";

		Vector v_code_group 	= new Vector();
		
		v_code_group = KJFSelectOPS.getSel(sql);
		request.setAttribute("v_user_id", v_code_group);  
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
	    ReportDAO    rDAO    = new ReportDAO();
	    
	    ReportEntity rEntity = null;
	    
	    String sql = "SELECT USER_ID, USER_NAME , CAPITAL  FROM PT_USER   ORDER BY  USER_NAME";
        
        /****** �˻����� �ʱⰪ ***********/
        request.setAttribute("pm", pm);
        if(pm.getScUSER_ID() == null ){
		    rEntity = rDAO.select(sql);	       
		    pm.setScUSER_ID(rEntity.getValue(0, "USER_ID"));
        }
        
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
        SysWorker worker = new SysWorker();
        request.setAttribute("v_menuEntList", worker.getMenuEntList("0"));
        
        request.setAttribute("pm", pm); 
    }//end loadList
}
