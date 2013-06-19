package kjf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

/**
 * <p>Subsystem   : 공통 </P>
 * <p>Title       : 명령패턴 인터페이스 </p>
 * <p>Description : 명령class들이 준수해야할 인터페이스</p>
 * <p>관련 TABLE  :
 * @author 김경덕
 * @version 1.0 2002.11.01 초기제작
 */
public interface KJFCommandResp {
    public String execute(HttpServletRequest req, HttpServletResponse resp, ActionForm form) throws Exception;
}