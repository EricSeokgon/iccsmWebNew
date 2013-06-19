package sp.util.sync;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import kjf.cfg.Config;

public class SyncAgent {
	
	public void oneAday() {
		
		String KICA_LOG_FILE_PATH = Config.props.get("KICA_LOG_FILE_PATH");
		
		SimpleDateFormat smf = new SimpleDateFormat("yyMMdd.H:m:s.SSS");
		String time= smf.format(new Date());
		String logFile = KICA_LOG_FILE_PATH + time.substring(0,6)+"SyncData"+".log"; 
		
		if(!new File(logFile).exists())
			start();

	}	
	

	public void start() {
		
		SyncLog.logData("SyncAgent start!!.........................................................");
		SyncTask  task= new SyncTask(); 
		
		
		try {
			
	    	//1.데이타 가져오기
	    	task.getTablesData();
	    	
	    	//2.데이타 검증
	    	task.compareAllData();
		
		} catch (Exception e) {
			//e.printStackTrace();
			SyncLog.log(e.fillInStackTrace());
		}

		SyncLog.logData("SyncAgent end!!!.........................................................");
	}
	

}
