/**
 * ���ϸ�   : BbsControlCmd.java 
 * ����     : ������� cmd  
 * �̷»���
 * CH00     :2006/07/4 ���ν� �����ۼ� 
 */
package sp.user.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFSelect;
import kjf.util.KJFUtil;
import kjf.util.MsgException;
import sp.user.UserParam;


public class UserIDCheckCmd implements KJFCommand {

	private String next;
	
    public UserIDCheckCmd() {
    }
    
    public UserIDCheckCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        //�˻����� ������ üũ
        UserParam pm = checkPm(request, form);
        
        //����Ʈ �ε�
	    if(isUserID(request, pm)){
	    	request.setAttribute("isUserID","Y");
	    }else{
	    	request.setAttribute("isUserID","N");
	    }
	    request.setAttribute("pm", pm);
	    
        return next;
    }
    


    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private UserParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	UserParam pm = (UserParam)form;
    	
    	pm.setScUSER_ID(request.getParameter("USER_ID"));


        //�Ķ���� �����
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm


    
    
    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, UserParam
     * @return
     */
    private boolean isUserID(HttpServletRequest request, UserParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String orderSQL 		 = "";
        boolean isRegistered		 = false; 				

        //SELECT �׸� SQL...
        String selectSQL =
			"SELECT                     									\n"+ 
        	"			count(*) as CNT      								\n";
 


        String fromSQL=
            "FROM                          									\n"+
            "    PT_USER							                  	\n";


        String whereSQL = "";

        
        if (KJFUtil.isEmpty(pm.getScUSER_ID()) ) {
            throw new MsgException("�˻��� ���̵� �Է��� �ֽʽÿ�.");
        }
        else{
        	whereSQL +=
        		"  WHERE USER_ID=LOWER('" + pm.getScUSER_ID() + "')" +
        		" OR USER_ID=UPPER('" + pm.getScUSER_ID() + "') \n";
        }
        

        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
        
        if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0)
        	isRegistered = true;

        return isRegistered;
    }//end loadList   
    
    
    
    


}