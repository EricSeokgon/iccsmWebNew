package kjf.sys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kjf.cfg.Config;
import kjf.db.TX_MGR;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;
import kjf.util.LoginManager;


public class SysCheck extends Thread implements ServletContextListener {

	private String serverID;
	long cycleTime;
	static boolean isStart = false;

	private SysCheck sc = null;

	public void contextInitialized(ServletContextEvent event)
	{
		//property 파일에 true 이면 시스템 체크를 한다.
		if("TRUE".equals(Config.props.get("IS_SYSTEM_CHECK"))){
			isStart = true;
		}

		if(isStart){
			System.out.println("1. 시스템 체크 시작");
			sc = new SysCheck(Config.props.get("SERVER_NAME"),1000*30);
			sc.start();
		}
	}

	public void contextDestroyed(ServletContextEvent event)
	{
	    if(isStart){
	    	System.out.println("99. 시스템 체크 종료");
	    	isStart = false;
	    	sc.interrupt();
//	    	sc.stop();
	    }
	}


	public SysCheck(){

	}


	public SysCheck(String sid,long cycleTime) {
		 this.serverID = sid;
		 this.cycleTime = cycleTime;
	}

	public void run(){
		LoginManager loginManager = LoginManager.getInstance();
		Runtime rt = Runtime.getRuntime();

		long free = 0;
		long total = 0;
		String sysDate = null;
		int curUser;


		System.out.println("2. 시스템 체크 메인 로직 시작");
		while(isStart){
			//try{Thread.sleep(this.cycleTime);}catch(Exception e){}

			free = rt.freeMemory()/1024/1024;
			total = rt.totalMemory()/1024/1024;
			sysDate = KJFDate.getCurDatetime();
			curUser = loginManager.getUserCount();

			System.out.print("서버 아이디 : " + serverID);
			System.out.print("  현재 사용자 : " + curUser);
			System.out.print("  여유 메모리 : " + free + "MB");
			System.out.println("  전체 메모리 : " + total +"MB");

			try{
				setDBInsert(serverID, curUser, free, total, sysDate);

			    Thread.sleep(this.cycleTime);
			}catch(Exception e){
				System.out.println("3. 시스템 체크 메인 로직 종료");
				//e.printStackTrace();
			}
		}
	}

	public void setDBInsert(String sId,int curUser,long freeMem, long totalMem,String sDate) throws Exception{
		TX_MGR.begin("KJF");

		ReportDAO rDAO = new ReportDAO();
		StringBuffer sf = new StringBuffer(300);
		int idx = 1;

		ReportEntity rEntity = rDAO.select("SELECT IFNULL(MAX(SEQ), 0)+1 SEQ FROM PT_SYS_CHECK");
    	if(rEntity.getRowCnt()>0) idx = KJFUtil.str2int(rEntity.getValue(0, 0));

		sf.append("insert into PT_SYS_CHECK (SEQ,SERVER_ID,CUR_USER,FREE_MEM,TOTAL_MEM,INP_DT) ");
		sf.append("values(" + idx +", ");
		sf.append("'" + sId + "', ");
		sf.append("'" + curUser + "', ");
		sf.append("'" + freeMem + "', ");
		sf.append("'" + totalMem + "', ");
		sf.append("'" + sDate + "') ");


		try{
			rDAO.execute(sf.toString());

			TX_MGR.commit(); //db commit
		}catch (Exception ex) {

        	TX_MGR.rollback(); //db rollbacd
		}
	}
}
