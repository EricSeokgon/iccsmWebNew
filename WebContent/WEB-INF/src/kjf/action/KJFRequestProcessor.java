package kjf.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

/**
 * <p>Subsystem   : ���� </P>
 * <p>Title       : KJFRequestProcessor Ŭ���� </p>
 * <p>Description : KJFRequestProcessor Ŭ����</p>
 * @author ����
 * @version 1.0 2002.11.01 �ʱ�����
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