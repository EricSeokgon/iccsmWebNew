package sp.util.transdb;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;

public  class BackupScheduler  {
	
    private BackupThread bkThread;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


    public void activate() {
    	System.out.println("backup activate 시작");
        bkThread = new BackupThread();
        scheduler.scheduleWithFixedDelay(bkThread, 0, 60*10, TimeUnit.SECONDS);
    }

    public  void shutdown() throws Exception {
        scheduler.shutdown();
        while (!scheduler.isTerminated()) {
         Thread.sleep(1000L);
        }        
    }
    
    public  boolean isShutdown() {
        return scheduler.isShutdown();
    }    
    
}

		 

class BackupThread implements Runnable {
	
    public BackupThread() {
    }

    public void run() {
        process();
    }

    public void process() {

    	BackupTask  bktask= new BackupTask();
    	Calendar cal = Calendar.getInstance();

    	TimeZone tz = TimeZone.getTimeZone("GMT+09:00");

    	cal.setTimeZone(tz);
    	String startTime = ""+cal.get(cal.HOUR_OF_DAY)+""+cal.get(cal.MINUTE);//+""+cal.get(cal.SECOND);
    	
    	int tstartTime =KJFUtil.str2int(startTime);
    			
    	try {
    		//if("2300".equals(startTime) || "400".equals(startTime) ){
    		//if((tstartTime >= 2300 && tstartTime <= 2350) || (tstartTime >= 400 && tstartTime <= 450) ){
        		bktask.setBackupDB();
        	//}
    
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	// 현재 시간 출력
    	  System.out.println("Backup Scheduler !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + new Date());
    	  
    }
    
    
    
    
}
