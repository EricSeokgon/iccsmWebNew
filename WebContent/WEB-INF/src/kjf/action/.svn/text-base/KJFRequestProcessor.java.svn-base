package kjf.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

/**
 * <p>Subsystem   : 공통 </P>
 * <p>Title       : KJFRequestProcessor 클래스 </p>
 * <p>Description : KJFRequestProcessor 클래스</p>
 * @author 김경덕
 * @version 1.0 2002.11.01 초기제작
 */
abstract public class KJFRequestProcessor extends RequestProcessor {

    private String encoding = "utf-8";
	   
    protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) { 
	      
        setRequestEncoding(request);
	   
        return true;  
    }
	  
    public void setRequestEncoding(HttpServletRequest request) {
        
        if(request.getCharacterEncoding() == null || !request.getCharacterEncoding().equals(encoding)){
            try {
                request.setCharacterEncoding(encoding);
            } catch (UnsupportedEncodingException e) {     
                e.printStackTrace();
            }
        }    
    }
	 
}