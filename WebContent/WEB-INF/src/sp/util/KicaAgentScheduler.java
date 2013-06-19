package sp.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sp.util.kica.KicaTask;
import java.io.PrintStream;

import kjf.util.KJFDate;

public class KicaAgentScheduler {
	
    private static MyThread myThread;
    private static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    	System.out.println("activate 시작");
	        myThread = new MyThread();
	        System.out.println("activate 시간"+TimeUnit.SECONDS);
	        //scheduler.scheduleWithFixedDelay(myThread, 0, 60*30, TimeUnit.SECONDS);
	        scheduler.scheduleWithFixedDelay(myThread, 0, 10*1, TimeUnit.SECONDS);
	        System.out.println("activate 시간"+TimeUnit.SECONDS);
	    }

	    public  void shutdown() throws Exception {
	        scheduler.shutdown();
	        // ScheduledExecutorService 오브젝트의 종료가 완료될 때까지 대기
	        while (!scheduler.isTerminated()) {
	         Thread.sleep(1000L);
	        }        
	    }
	    
	    public  boolean isShutdown() {
	        return scheduler.isShutdown();
	    }

}


class MyThread implements Runnable {
	
    public MyThread() {
    	
    }

    public void run() {
        process();
    }

    public void process() {
    	System.out.println("############process##############"+KJFDate.getCurTime());
    	
//    	  HttpClient httpclient = new DefaultHttpClient(); 
//          
//          String id = "월드 아이디"; 
//          String pw = "비밀번호"; 
           
//          List<NameValuePair> qparams = new ArrayList<NameValuePair>(); 
//          qparams.add(new BasicNameValuePair("URL", "http://www.tworld.co.kr/loginservlet.do?returnURL=http%3A%2F%2Fwww.tworld.co.kr&kind=&popup=&cmd=&reload=&ID=" + id)); 
//          qparams.add(new BasicNameValuePair("ID", id)); 
//          qparams.add(new BasicNameValuePair("PASSWORD", pw)); 
//          qparams.add(new BasicNameValuePair("SERVERIP", "203.236.20.129")); 
//          qparams.add(new BasicNameValuePair("X", "0")); 
//          qparams.add(new BasicNameValuePair("Y", "0")); 
//          UrlEncodedFormEntity entity = new UrlEncodedFormEntity(qparams, "UTF-8"); 
//          HttpPost httpPost = new HttpPost("http://nicasams.sktelecom.com:2040/icas/fc/LogOnSV"); 
//          httpPost.setEntity(entity); 
//           
//          ResponseHandler<String> responseHandler = new BasicResponseHandler(); 
//          String responseBody = ""; 
//          HttpResponse response = httpclient.execute(httpPost); 
//          Header[] headers  = response.getAllHeaders(); 
//          httpclient = new DefaultHttpClient(); 
//          HttpGet httpGet = new HttpGet(); 
//          if (headers.length > 1){ 
//              String url = headers[1].getValue(); 
//              System.out.println("url = " + url); 
//              httpGet.setURI(new URI(url)); 
//              responseBody = httpclient.execute(httpGet, responseHandler); 
//              System.out.println(responseBody); 
//          } 
//          httpGet.setURI(new URI("http://localhost/iccsm/sys/KicaGetData.jsp")); 
//          responseBody = httpclient.execute(httpGet, responseHandler); 
//           
//          System.out.println("result = " + responseBody); 

    	String str = "";
		    	
		try{
			str = HttpPost2("http://99.1.5.83/sys/KicaGetData.jsp","",80,"");
			//str = HttpPost2("http://localhost/iccsm/sys/KicaGetData.jsp","",80,"");
		}catch(Exception e){
			System.out.println(" Exception  " + e.getMessage());
		}finally{
			System.out.println(" finally  ");
		} 
		
//    	PrintStream out = null;  
    	
//		out.println("<script language='javascript'>");
//		out.println("	var URL = 'http://localhost/iccsm/sys/KicaGetData.jsp';");
//		out.println("	var tarFrm = new Image() ;");
//		out.println("	var Targ = URL;");
//		out.println("	tarFrm.src = Targ;");
//		out.println("</script>");
    	
//    	 String server = "http://localhost/iccsm/sys/KicaGetData.jsp"; //xml파일 주소
//    	 URL url;
//    	 URLConnection connection;  
//    	 InputStream is; 
//    	 InputStreamReader isr;
//    	 BufferedReader br;
//    	 
//    	 String strXML = new String(); //xml내용 저장하기 위한 변수
//    	 try {
//    		  url = new URL(server); //URL 세팅
//    		  connection = url.openConnection(); //접속
//    		  
//    		  is = connection.getInputStream(); //inputStream 이용
//    		 
//    		  isr = new InputStreamReader(is); 
//    		  br = new BufferedReader(isr);
//    		  
//    		  
//    		  String buf = null;
//    		  while (true) { //무한반복
//    		      buf = br.readLine(); //화면에 있는 내용을 \n단위로 읽어온다
//    		      if (buf == null) { //null일 경우 화면이 끝난 경우이므로
//    		          break; //반복문 끝
//    		      } else {
//    		          strXML += buf + "\n"; //strXML에 화면에 출력된 내용을 기억시킨다.
//    		      }
//    		  }
//    		 }catch (Exception e) {
//    			  e.printStackTrace();
//    		 }    	 
//
//    	
//    	// 현재 시간 출력
//          System.out.println(strXML); 
//    	  System.out.println("KicaScheduler !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + new Date());
//    	  
//    	  
    }
    
	public static String HttpPost2(String hostname, String path, int port, String data) throws  Exception{
		URL url=null;
	    HttpURLConnection urlConn=null;

	    String flag = "1";

	    url = new URL(hostname+path);
	    	    	    
	    urlConn = (HttpURLConnection)url.openConnection();

	    byte[] sendByte = new String(data).getBytes();

	    urlConn.setDefaultUseCaches(false);
	    urlConn.setDoInput(true);
	    urlConn.setDoOutput(true);
	    urlConn.setRequestMethod("POST");

	    urlConn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
	    DataOutputStream out = null;
	    out = new DataOutputStream(urlConn.getOutputStream());
	    out.write(sendByte);
	    out.flush();

	    //	RECIEVE

	    BufferedReader bf=null;
	       bf = new BufferedReader(new InputStreamReader(urlConn.
	          getInputStream()));
	      Vector vtRet = new Vector();
	      
		return flag;

	}
    
    
}

