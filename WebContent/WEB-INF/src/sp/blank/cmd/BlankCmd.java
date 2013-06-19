/**
 * ���ϸ�   : BbsKCmd.java 
 * ����     : BbsK  cmd  
 * �̷»���
 * CH00     :2006/05/27 ���� �����ۼ� 
 */

package sp.blank.cmd;


import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.LoginException;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.blank.BlankParam;

public class BlankCmd implements KJFCommand {
	
	private String next;
    private String cmd;
    private String mode;


    public BlankCmd() {
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
		//�˻����� ������ üũ
        BlankParam pm = checkPm(request, form);
        
        next = pm.getNextURL();
        
        request.setAttribute("pm", pm);
    	
    	mode = KJFUtil.print(request.getParameter("mode")); 
    	
        //�˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request);
        
        loadData(request, pm );
        
        
        
    	return next;
    }
    
    
    
    /**
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	/*********** �Խ��� �˻� �ڵ�  ���� ***************/		
    	String sql = "SELECT CODE, CODE_NAME " +
			 " FROM PT_BBS_COM_CODE " +
			 " WHERE CODE_GROUP = '003'" +
			 "  AND CODE <> '000'" +
			 " ORDER BY ORDER_NUM";
		
		Vector v_scSLCT_GUBUN 	= KJFSelectOPS.getSel(sql);	
		request.setAttribute("v_scSLCT_GUBUN", v_scSLCT_GUBUN);   
		/*********** �Խ��� �˻� �ڵ�  �� ***************/	

	
       
    }//end loadCondition
    
    


    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private BlankParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	BlankParam pm = (BlankParam)form;
    	String nextURL = KJFUtil.print(request.getParameter("nextURL"));
    	
    	if("".equals(nextURL))
    		nextURL = "/com/Blank.jsp";
    	
    	pm.setNextURL(nextURL);
    	
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
     * @param HttpServletRequest, BlankParam
     * @return
     */    
    private void loadData(HttpServletRequest request, BlankParam pm ) throws Exception {
          	
               

    }    
    
    
    
    
   
 


}