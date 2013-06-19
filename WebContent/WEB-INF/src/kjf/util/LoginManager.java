package kjf.util;

import java.util.*;
import javax.servlet.http.*;

/**
 * <p>Subsystem		:  </p>
 * <p>Title			: 로그인 사용자 처리(현재 접속자) </p>
 * <p>Description	: 현재 접속자 확인 및 관리 유틸<br>
 *                    session이 끊어졌을때를 처리하기 위해 사용<br>
 *                    static메소드에서는 static만사용 하므로static으로 선언한다.</p>
 * @author 오두식
 * @version 1.0	2007.11.29 <br/>
 */
public class LoginManager implements HttpSessionBindingListener {

    private static LoginManager loginManager = null;

    /** 로그인한 접속자를 담기위한 해시테이블 */
    private static Hashtable loginUsers = new Hashtable();

    /**
     * 싱글톤 패턴 사용
     * @return synchronized
     */
    public static synchronized LoginManager getInstance(){
        if(loginManager == null){
            loginManager = new LoginManager();
        }
        return loginManager;
    }

    /**
     * 이 메소드는 세션이 연결되을때 호출된다.(session.setAttribute("login", this))
     * Hashtable에 세션과 접속자 아이디를 저장한다.
     */
    public void valueBound(HttpSessionBindingEvent event) {
        //session값을 put한다.
        loginUsers.put(event.getSession(), event.getName());
        System.out.println(event.getName() + "님이 로그인 하셨습니다.");
        System.out.println("현재 접속자 수 : " +  getUserCount());
     }

     /**
      * 이 메소드는 세션이 끊겼을때 호출된다.(invalidate)
      * Hashtable에 저장된 로그인한 정보를 제거해 준다.
      * @param event HttpSessionBindingEvent
      */
     public void valueUnbound(HttpSessionBindingEvent event) {
         //session값을 찾아서 없애준다.
         loginUsers.remove(event.getSession());
         System.out.println("  " + event.getName() + "님이 로그아웃 하셨습니다.");
         System.out.println("현재 접속자 수 : " +  getUserCount());
     }


     /**
      * 입력받은 아이디를 해시테이블에서 삭제.
      * @param userID 사용자 아이디
      * @return void
      */
     public void removeSession(String userId){
          Enumeration e = loginUsers.keys();
          HttpSession session = null;
          while(e.hasMoreElements()){
               session = (HttpSession)e.nextElement();
               if(loginUsers.get(session).equals(userId)){
                   //세션이 invalidate될때 HttpSessionBindingListener를
                   //구현하는 클레스의 valueUnbound()함수가 호출된다.
                   session.invalidate();
               }
          }
     }


     /**
      * 사용자가 입력한 ID, PW가 맞는지 확인하는 메소드
      * @param userID 사용자 아이디
      * @param userPW 사용자 패스워드
      * @return boolean ID/PW가 일치하는 지 여부
      */
     public boolean isValid(String userId, String userPw){

         /*
          * 이부분에 Database 로직이 들어간다.
          */
         return true;
     }


    /**
     * 해당 아이디의 동시 사용을 막기위해서
     * 이미 사용중인 아이디인지를 확인한다.
     * @param userID 사용자 아이디
     * @return boolean 이미 사용 중인 경우 true, 사용중이 아니면 false
     */
    public boolean isUsing(String userID){
        return loginUsers.containsValue(userID);
    }


    /**
     * 로그인을 완료한 사용자의 아이디를 세션에 저장하는 메소드
     * @param session 세션 객체
     * @param userID 사용자 아이디
     */
    public void setSession(HttpSession session, String userId){
        //이순간에 Session Binding이벤트가 일어나는 시점
        //name값으로 userId, value값으로 자기자신(HttpSessionBindingListener를 구현하는 Object)
        session.setAttribute(userId, this);//login에 자기자신을 집어넣는다.
    }


    /**
     * 입력받은 세션Object로 아이디를 리턴한다.
     * @param session : 접속한 사용자의 session Object
     * @return String : 접속자 아이디
     */
    public String getUserID(HttpSession session){
        return (String)loginUsers.get(session);
    }


    /**
     * 현재 접속한 총 사용자 수
     * @return int  현재 접속자 수
     */
    public int getUserCount(){
        return loginUsers.size();
    }


    /**
     * 현재 접속중인 모든 사용자 아이디를 출력
     * @return void
     */
    public void printloginUsers(){
        Enumeration e = loginUsers.keys();
        HttpSession session = null;
        System.out.println("===========================================");
        int i = 0;
        while(e.hasMoreElements()){
            session = (HttpSession)e.nextElement();
            System.out.println((++i) + ". 접속자 : " +  loginUsers.get(session));
        }
        System.out.println("===========================================");
     }

    /**
     * 현재 접속중인 모든 사용자리스트를 리턴
     * @return list
     */
    public Collection getUsers(){
        Collection collection = loginUsers.values();
        return collection;
    }
}
