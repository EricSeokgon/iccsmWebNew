package kjf.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import kjf.cfg.Config;

/**
 * <p>Subsystem		: 공통모튤 </p>
 * <p>Title			: 기본적인 로그 유틸함수 </p>
 * <p>Description	: 기본적인 로그 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE		: </p>
 * @author 김경덕
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFLog{

	private static boolean IS_INFO = false;
	private static boolean IS_LOG = false;
	private static boolean IS_LOG_SQL = false;
	private static boolean IS_LOG_DEBUG = false;
	private static boolean IS_LOG_FILE_WRITE = false;
	private static String LOG_FILE_PATH = null;
	private static SimpleDateFormat smf = null;
		
	static{
		IS_INFO = Config.props.getBoolean("IS_INFO");
		IS_LOG = Config.props.getBoolean("IS_LOG");
		IS_LOG_SQL = Config.props.getBoolean("IS_LOG_SQL");
		IS_LOG_DEBUG = Config.props.getBoolean("IS_LOG_DEBUG");
		IS_LOG_FILE_WRITE = Config.props.getBoolean("IS_LOG_FILE_WRITE");
		LOG_FILE_PATH = Config.props.get("LOG_FILE_PATH");
		smf = new SimpleDateFormat("yyMMdd.H:m:s.SSS");
		try{
			KJFFile.fullDirMake(Config.props.get("LOG_FILE_PATH"));		
		}catch(Exception e){}
	}
	
	/**
	 * 정보 
	 * @param key     String
	 * @param message String
	 */
    public static final void info(String key , String message){

        String time=getCurrentTime();
        

        if(IS_INFO ){
            System.out.println(time+"("+key+") : "+message);			
        }

        logFileWrite(key, time, message);
    }


    /**
     * 정보
     * @param message String
     */
    public static final void info( String message){
        
        String time=getCurrentTime();
    	
        if(IS_INFO ){
            System.out.println(time+" : "+message);
        }

        logFileWrite("", time, message);
    }


    /**
     * 로그
     * @param key     String
     * @param message String
     */
    public static final void log(String key , String message){

        String time=getCurrentTime();
        

        if(IS_LOG){
            System.out.println(time+"("+key+") : "+message);			
        }

        logFileWrite(key, time, message);
    }



    /**
     * 로그
     * @param message String
     */
    public static final void log( String message){
        
        String time=getCurrentTime();
    	
        if(IS_LOG ){
            System.out.println(time+" : "+message);
        }

        logFileWrite("", time, message);
    }
    
    /**
     * 로그
     * @param Throwable tw
     */
    public static final void log( Throwable tw){
        
        String time=getCurrentTime();
        String message = captureStackTrace(tw);
        if(IS_LOG ){
            System.out.println(time+" : "+message);
            
        }

        logFileWrite("", time, message);
    }    


    /**
     * SQL
     * @param key     String
     * @param message String
     */
    public static final void sql(String key , String message){
    	
        if(IS_LOG_SQL ){

            String time=getCurrentTime();

            System.out.println(time+"("+key+") : "+message);
            logFileWrite(key, time, message);
			
        }
    }
    
    /**
     * SQL
     * @param message
     */
    public static final void sql( String message){
    	
        if(IS_LOG_SQL ){
			String time=getCurrentTime();
            System.out.println(time+" : "+message);
            logFileWrite("", time, message);
			
        }
    }
    
    /**
     * 디버그
     * @param key       String
     * @param message   String
     */
    public static final void debug(String key , String message){
    	
        if(IS_LOG_DEBUG){

            String time=getCurrentTime();

            System.out.println(time+"("+key+") : "+message);
            logFileWrite(key, time, message);
			
        }
    }
    
    /**
     * 디버그
     * @param message String
     */
    public static final void debug( String message){
    	
        if(IS_LOG_DEBUG ){

			String time=getCurrentTime();
            System.out.println(time+" : "+message);
            logFileWrite("", time, message);
			
        }
    }
    
    /**
     * 디버그
     * @param Throwable tw
     */
    public static final void debug( Throwable tw ){
    	
        if(IS_LOG_DEBUG ){
        	String message = captureStackTrace(tw);
			String time=getCurrentTime();
            System.out.println(time+" : "+message);
            logFileWrite("", time, message);
			
        }
    }    
    
    /**
     * 로그파일 쓰기
     * @param key       String
     * @param time      String
     * @param message   String
     */
    public static final void  logFileWrite(String key , String time,  String message){
    	
        if(IS_LOG_FILE_WRITE ){
			
			PrintWriter logWriter= null;
			try{
				String logFile = LOG_FILE_PATH + time.substring(0,6)+".log"; 
								
				if(!new File(logFile).exists())	new FileOutputStream(logFile);				
				logWriter = new PrintWriter(new FileWriter(logFile, true), true);

			}catch(Exception exp) {
				System.out.println("LogFile Open Error:");
			}
            if (key==null || key.equals("")){
                logWriter.print(time+" : "+message+"\n");
            }else {
			    logWriter.print(time+"("+key+") : "+message+"\n");
            }
			logWriter.close();
			
        }
    }
    
    /**
     * 현제 날짜
     * @return String
     */
    public static final String getCurrentTime (){
        return smf.format(new Date());
    }
    
    
    /**
     * StackTrace내용을 String으로 변환하여 반환
     * @return String
     */
    public static String captureStackTrace(Throwable tw) {
        StringWriter sw = new StringWriter();
        tw.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }    
}
