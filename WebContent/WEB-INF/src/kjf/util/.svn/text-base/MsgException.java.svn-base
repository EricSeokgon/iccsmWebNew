package kjf.util;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Subsystem     :  util </p>
 * <p>Title         :  메세 지클래스 </p>
 * <p>Description   :  메세지를 나타낸다. </p>
 * <p>관련 TABLE      : </p>
 * @author 김경덕
 * @version 1.0 2003.05.30 <br/>
 */
public final class MsgException extends Exception{

  public String msg="";
  private String returnURL=null;

  public MsgException(String msg){

      this.msg = msg;
  }
  
  public MsgException(String msg,String url){

      this.msg = msg;
      this.returnURL = url.replaceAll(url,"");
  }

  public MsgException(HttpServletRequest request, String msg){
      String serverURL  = request.getContextPath();
      String url        = request.getRequestURI() + "?" + request.getQueryString();
      this.returnURL    = url.replaceAll(serverURL,"");
      this.msg = msg;
     
      request.getSession().setAttribute("returnURL", returnURL);
  }
  
  public MsgException(HttpServletRequest request, String msg, String URL){
      this.returnURL = URL;
      this.msg = msg;
      request.getSession().setAttribute("returnURL", returnURL);
  }
  
  

  public String  getMessage(){
      return this.msg;
  }

}