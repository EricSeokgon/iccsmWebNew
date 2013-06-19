/**
 * ���ϸ�   : BbsKCmd.java 
 * ����     : BbsK  cmd  
 * �̷»���
 * CH00     :2006/05/27 ���� �����ۼ� 
 */

package sp.sys.cmd;


import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.util.KJFDate;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;

public class ComCodeMgrPCmd implements KJFCommand {
	

	private String next;
	
    public ComCodeMgrPCmd() {
    }
    
    public ComCodeMgrPCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String cmd = KJFUtil.print(request.getParameter("cmd"));
    	
		//�˻����� ������ üũ
    	SysParam pm = checkPm(request, form);
        
        request.setAttribute("pm", pm);
    	
    	//�˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request);  
            
        
    	return next;
    }
    
    
    
    /**
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	String sql=" SELECT   P_CODE, CODE_NAME " +
		   " FROM     PT_COM_CODE     " +
		   " WHERE    CODE = '000'  " +
		   " ORDER BY P_CODE            ";

		Vector v_code_group = new Vector();
		
		v_code_group = KJFSelectOPS.getSel(sql, "%","   ��ü     ");		
		request.setAttribute("v_sc_code_group", v_code_group);  
       
    }//end loadCondition
    
    


    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	SysParam pm = (SysParam)form;
    	
    		
    	//�Ķ���� �����

    	//KJFLog.debug(pm.toString(request));
 
        return pm;

    }//end checkPm
        
    
}