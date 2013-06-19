package sp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.db.TX_MGR;
import kjf.util.KJFLog;
import kjf.util.LoginException;
import kjf.util.MsgException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sp.login.LoginWorker;
import sp.sys.SysWorker;





/**
 * <b>class : </b> KJFMiAction
 * <b>Class Description</b><br>
 * ActionŬ������ ��ӹ��� �߻�ȭ Ŭ����
 * <b>History</b><br>
 * @author ����
 * @version 1.0.0
 * @since 2008/12/24
 */
abstract public class KJFMiAction extends Action {

	public String  next;
    public String _error = "miError";
    public ActionForward a_next;
    public String URI;
    /**
     * ��ü �����ӿ�ũ�� ������ ó���� ���ؼ� ������ �� �Լ�
     * (���� Ȯ�强�� ���ؼ�..)
     * @param ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response
     * @return ActionForward
     * @throws java.lang.Exception
     */
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        try {

			String serverURL 	= request.getContextPath();
			String url		= request.getRequestURI() + "?" + request.getQueryString();
			String cmd = url.replaceAll(serverURL,"");
			        	
        	KJFLog.log("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        	KJFLog.log("==========================================================================================================");
        	KJFLog.log(cmd);
        	KJFLog.log("==========================================================================================================");
        	
        	java.util.Enumeration enuma = request.getParameterNames();

    		while(enuma.hasMoreElements()) {

	    		String key = (String)enuma.nextElement();
	    		String value = request.getParameter(key);
	    		KJFLog.log(key + " : " + value);
    		
    		}
    		
        	KJFLog.log("==========================================================================================================");

        	TX_MGR.begin("KJF");

        	//���� üũ
        	//LoginWorker.checkSession(request);

        	//Ÿ��Ʋ �׺���̼�
        	//SysWorker.setTitleNavi(request);

        	//����� ���α׷� �α� �����
        	//SysWorker.userActionLog(request);

        	next= executeAction(mapping, form, request, response);




            //	next �� ���̷�Ʈ ��� ���� mapping forward ������� "."�� �Ǵ��Ѵ�.
        	//�׷��Ƿ�  struts-config �� "." �� �־� ������ �ȵȴ�.
            if(next.indexOf(".")== -1){
            	a_next = mapping.findForward(next);

            } else{
            	a_next = new ActionForward(next);
            }

            KJFLog.log("==========================================================================================================");
            KJFLog.log("=== next_url : "+ a_next.getPath() +" =====");
            KJFLog.log("==========================================================================================================");

            TX_MGR.commit(); //db commit

            return a_next;
        }
        catch (Exception ex) {

        	TX_MGR.rollback(); //db rollbacd

            request.setAttribute("ex", ex);
            
            KJFLog.log(ex.toString()); // Exception log
            ex.printStackTrace();

            return mapping.findForward(_error);

        }
    }





    abstract public String executeAction(ActionMapping mapping,
                                                ActionForm form,
                                                HttpServletRequest request,
                                                HttpServletResponse response) throws Exception;

}