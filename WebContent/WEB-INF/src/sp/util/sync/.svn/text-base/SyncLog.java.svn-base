package sp.util.sync;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import kjf.cfg.Config;
import kjf.util.KJFFile;


public class SyncLog{



	private static String KICA_LOG_FILE_PATH = null;
	private static SimpleDateFormat smf = null;
		
	static{
		KICA_LOG_FILE_PATH = Config.props.get("KICA_LOG_FILE_PATH");
		smf = new SimpleDateFormat("yyMMdd.H:m:s.SSS");
		
		try{
			KJFFile.fullDirMake(Config.props.get("KICA_LOG_FILE_PATH"));		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	




    /**
     * 로그
     * @param key     String
     * @param message String
     */
    public static final void log(String key , String message){

        String time=getCurrentTime();
        
        System.out.println(time+"("+key+") : "+message);			
        logFileWrite(key, time, message);
    }



    /**
     * 로그
     * @param message String
     */
    public static final void log( String message){
        
        String time=getCurrentTime();
    	System.out.println(time+" : "+message);

        logFileWrite("", time, message);
    }
    
    
    /**
     * 로그
     * @param message String
     */
    public static final void logData( String message){
        
        String time=getCurrentTime();
    	System.out.println(time+" : "+message);

        logFileWriteSilEx("", time, message);
    }   

    /**
     * 로그
     * @param Throwable tw
     */
    public static final void log( Throwable tw){
        
        String time=getCurrentTime();
        String message = captureStackTrace(tw);
        System.out.println(time+" : "+message);
            


        logFileWrite("", time, message);
    }    

       


    
    /**
     * 로그파일 쓰기
     * @param key       String
     * @param time      String
     * @param message   String
     */
    public static final void  logFileWrite(String key , String time,  String message){
    	
			
			PrintWriter logWriter= null;
			try{
				String logFile = KICA_LOG_FILE_PATH + time.substring(0,6)+"Sync.log"; 
								
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
    
    /**
     * 로그파일 쓰기
     * @param key       String
     * @param time      String
     * @param message   String
     */
    public static final void  logFileWriteSilEx(String key , String time,  String message){
    	
			
			PrintWriter logWriter= null;
			try{
				String logFile = KICA_LOG_FILE_PATH + time.substring(0,6)+"SyncData"+".log"; 
								
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
    
    
    /**
     * 현재 날짜
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
