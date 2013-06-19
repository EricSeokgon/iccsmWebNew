/*
2006. 8. 14.오후 4:41:51
*/

package sp.log.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import sp.log.*;


public class PageDAYChartCmd implements KJFCommandResp {
	
	private String next;
	
    public PageDAYChartCmd() {
    }
    
    public PageDAYChartCmd(String next_url) {
    	next = next_url; 
    }

	public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception {
		
		LogParam pm = checkFrm(form);
				
		pm.setDataSet(createDataset(pm));
		
		ChartWorker worker =new ChartWorker();
		
		worker.ChartProcess(request, response, pm);
		
		return next;
	}
	

	
	private LogParam checkFrm(ActionForm form)throws Exception{
		
//		System.out.println(form);

		LogParam pm = (LogParam)form;
//		LogParam pm = new LogParam();
				
        if (KJFUtil.isEmpty(pm.getChartHeight())){
        	pm.setChartHeight("400");
        }
        
        if (KJFUtil.isEmpty(pm.getChartWidth())){
        	pm.setChartWidth("700");
        }
        
        if (KJFUtil.isEmpty(pm.getChartAxis()))
        	pm.setChartAxis("Y");
        
        if (KJFUtil.isEmpty(pm.getFontAxis()))
        	pm.setFontAxis("Y");       
        	pm.setChartTitle(pm.getChartTitle()); // get 방식으로 넘어온 타이틀 한글 처리

		return pm;
		
	}
	
	private CategoryDataset createDataset(ActionForm form) throws Exception{
		
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		LogParam pm = (LogParam)form;
        ReportDAO    rDAO        = new ReportDAO();
		ReportEntity rEntity     = null;
		
		String date = KJFDate.getCurTime("yyyy-MM");
		
		if(!KJFUtil.isEmpty(pm.getScStartDate())){
			date = KJFUtil.print(pm.getScStartDate().substring(0,7));
		}
		
		String page_id = "";
		if(!KJFUtil.isEmpty(pm.getPage_id())){
			page_id = KJFUtil.print(pm.getPage_id());
		}
		
		String selectSQL = " SELECT	" +
				"	PAGE_ID,REG_DATE, \n" +
				"	D_01,D_02,D_03,D_04,D_05,D_06,D_07,D_08,D_09,D_10,D_11,D_12, \n" +
				"	D_13,D_14,D_15,D_16,D_17,D_18,D_19,D_20,D_21,D_22,D_23,D_24, \n" +
				"	D_25,D_26,D_27,D_28,D_29,D_30,D_31,MONTH_TOTAL \n"; 

		String fromSQL = "FROM PT_HOM_VIEW_DAY_COUNT			\n";
		
		String whereSQL = 
	    	"WHERE	1=1						\n"+
	    	"		AND REG_DATE = '"+date+"' \n" +
	    	"		AND PAGE_ID = '"+page_id+"' "; 
	
	    
	    String orderSQL =" ORDER BY PAGE_ID DESC \n";
	    
	    rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
	    
	    if (rEntity!=null){
		    String ia = "";
	        for (int i=0;i< rEntity.getRowCnt();i++ ){
	        	for(int ii = 1; ii <= 31; ii++){
	        		
	        		if(ii < 10){
	        			ia = "0"+ii;
	        		}else{
	        			ia = ""+ii;
	        		}
	        		
	        		defaultcategorydataset.addValue(0, "1", ia+"일("+rEntity.getValue(i,"D_"+ia)+"명)");
	        		defaultcategorydataset.addValue(KJFUtil.str2int(rEntity.getValue(i,"D_"+ia)), "2", ia+"일("+rEntity.getValue(i,"D_"+ia)+"명)");
	        		defaultcategorydataset.addValue(0, "3", ia+"일("+rEntity.getValue(i,"D_"+ia)+"명)");
	        	}
	        }
	    }
	  
	    return defaultcategorydataset;
		
	}

}







































