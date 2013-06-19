package sp.util.transdb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import kjf.util.KJFLog;

public class BackupAgentStart  extends HttpServlet {
	 
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("============init===============");
    	try {
    		BackupAgent.start();
		} catch (Exception e) {
			KJFLog.log(e.toString());
			e.printStackTrace();			
		}
    	
    }    

}

		 

