package sp.util.transdb;


public class BackupAgent  {
	

    public static  BackupScheduler bscheduler;
    
    public static void start()throws Exception {
    	if(bscheduler !=null){
    		System.out.println("=backupscheduler null พฦดิ");
    		if(!bscheduler.isShutdown()){
    			bscheduler.shutdown();
    		}
    	}
    	bscheduler = new BackupScheduler();
    	bscheduler.activate();
    	
    }
  

}

		 

