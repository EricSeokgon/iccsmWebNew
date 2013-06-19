package sp.util.transdb;

import kjf.db.TX_MGR;
import kjf.ops.ReportEntity;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;

public  class BackupTask  {
		
	private BackupTaskDAO taskdao = new BackupTaskDAO();
    
    public void setBackupDB()throws Exception {
    	System.out.println("=====================setBackupDB() start=====================");
    	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportEntity rEnt 		 = null;
    	//String SIGUNGU_CODE = "ggae";
    	
    
    	TX_MGR.begin("KJF");
    	rEnt = rDAO.select("SELECT SIGUNGU_CODE,SERVER_ADDR,GROUPWARE_MODULE_TYPE FROM PT_S_SYSVAR_MASTER WHERE SERVER_ADDR IS NOT NULL");
    	
    	if (rEnt != null || rEnt.getRowCnt() != 0){
    		for (int i = 0 ; i< rEnt.getRowCnt(); i++){
    			
    			
    			String SIGUNGU_CODE = rEnt.getValue(i,"SIGUNGU_CODE");
    			String SERVER_ADDR = "http://localhost";//rEnt.getValue(i,"SERVER_ADDR");
    			String GROUPWARE_MODULE_TYPE = KJFUtil.print(rEnt.getValue(i,"GROUPWARE_MODULE_TYPE"),"");
    			
    			if (!"".equals(GROUPWARE_MODULE_TYPE)){
    			   System.out.println(SIGUNGU_CODE+"=="+SERVER_ADDR);	
			    	taskdao.transLow("PT_UB_CONSTRUCTION","C",SIGUNGU_CODE,SERVER_ADDR);  
			    	taskdao.transLow("PT_UB_CONMEMO","C",SIGUNGU_CODE,SERVER_ADDR);
			    	//taskdao.transLow("PT_UB_CON_DETAIL","C",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_CONDEFICIT","C",SIGUNGU_CODE,SERVER_ADDR);
			    	
			    	taskdao.transLow("PT_UB_USEBEFORE","C",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_MEMO","C",SIGUNGU_CODE,SERVER_ADDR);
			    	//taskdao.transLow("PT_UB_DETAIL","C",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_FILE","C",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_DEFICIT","C",SIGUNGU_CODE,SERVER_ADDR);
			    	
			    	taskdao.transLow("PT_UB_SUVSPOT","C",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_SUVMEMO","C",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_SUVDEFICIT","C",SIGUNGU_CODE,SERVER_ADDR);
			
			    	taskdao.transLow("PT_UB_CONSTRUCTION","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_CONMEMO","U",SIGUNGU_CODE,SERVER_ADDR);
			    	//taskdao.transLow("PT_UB_CON_DETAIL","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_CONDEFICIT","U",SIGUNGU_CODE,SERVER_ADDR);
			    	
			    	taskdao.transLow("PT_UB_USEBEFORE","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_MEMO","U",SIGUNGU_CODE,SERVER_ADDR);
			    	//taskdao.transLow("PT_UB_DETAIL","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_FILE","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_DEFICIT","U",SIGUNGU_CODE,SERVER_ADDR);
			    	
			    	taskdao.transLow("PT_UB_SUVSPOT","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_SUVMEMO","U",SIGUNGU_CODE,SERVER_ADDR);
			    	taskdao.transLow("PT_UB_SUVDEFICIT","U",SIGUNGU_CODE,SERVER_ADDR);
			    	
    			}
    			//TX_MGR.commit(); //db commit
    		}
    	}	
		    	TX_MGR.commit(); //db commit
		
    }
}

		 


