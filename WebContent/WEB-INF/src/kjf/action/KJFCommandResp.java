package kjf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

/**
 * <p>Subsystem   : ���� </P>
 * <p>Title       : ������� �������̽� </p>
 * <p>Description : ���class���� �ؼ��ؾ��� �������̽�</p>
 * <p>���� TABLE  :
 * @author ����
 * @version 1.0 2002.11.01 �ʱ�����
 */
public interface KJFCommandResp {
    public String execute(HttpServletRequest req, HttpServletResponse resp, ActionForm form) throws Exception;
}