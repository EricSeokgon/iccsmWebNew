/*
2006. 8. 14.오후 4:42:1
*/

package sp.log.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import sp.log.*;


public class PageHOURChartCmd implements KJFCommandResp {

	private String next;
	
    public PageHOURChartCmd() {
    }
    
    public PageHOURChartCmd(String next_url) {
    	next = next_url; 
    }
	
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionForm form) throws Exception {
		LogParam pm = checkFrm(form);
		
		pm.setDataSet(createDataset(pm));
		
		ChartWorker worker =new ChartWorker();
		
		worker.ChartProcess(request, response, pm);
		
		return next;
	}
	
	private LogParam checkFrm(ActionForm form)throws Exception{
		
		LogParam pm = (LogParam)form;
        if (KJFUtil.isEmpty(pm.getChartHeight()))
        	pm.setChartHeight("400");
        
        if (KJFUtil.isEmpty(pm.getChartWidth()))
        	pm.setChartWidth("700");
        
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
		
		String selectSQL = "\n" +
				"SELECT " +
				"	SUM(H_01) H_01,SUM(H_02) H_02,SUM(H_03) H_03,SUM(H_04) H_04,SUM(H_05) H_05,\n" +
				"	SUM(H_06) H_06,SUM(H_07) H_07,SUM(H_08) H_08,SUM(H_09) H_09,SUM(H_10) H_10,\n" +
				"	SUM(H_11) H_11,SUM(H_12) H_12,SUM(H_13) H_13,SUM(H_14) H_14,SUM(H_15) H_15,\n" +
				"	SUM(H_16) H_16,SUM(H_17) H_17,SUM(H_18) H_18,SUM(H_19) H_19,SUM(H_20) H_20,\n" +
				"	SUM(H_21) H_21,SUM(H_22) H_22,SUM(H_23) H_23,SUM(H_24) H_24 \n"; 

		String fromSQL = "FROM PT_HOM_VIEW_HOUR_COUNT			\n";
		
		String whereSQL = 
	    	"WHERE	1=1						\n"+
	    	//"		AND REG_DATE BETWEEN TO_DATE('"+KJFUtil.print(pm.getScStartDate())+"') AND TO_DATE('"+KJFUtil.print(pm.getScEndDate())+"') \n" +
	    	"		AND REG_DATE ='"+KJFUtil.print(pm.getScStartDate())+"' \n" +
	    	"		AND PAGE_ID='"+KJFUtil.print(pm.getPage_id())+"' "; 
	
	    
	    String orderSQL ="";
	    
	    rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
	    
	    if (rEntity!=null){
		    String ia = "";
	        for (int i=0;i< rEntity.getRowCnt();i++ ){
	        	for(int ii = 1; ii <= 24; ii++){
	        		
	        		if(ii < 10){
	        			ia = "0"+ii;
	        		}else{
	        			ia = ""+ii;
	        		}
	        		
	        		defaultcategorydataset.addValue(0, "1", ia+"시("+rEntity.getValue(i,"H_"+ia)+"명)");
	        		defaultcategorydataset.addValue(KJFUtil.str2int(rEntity.getValue(i,"H_"+ia)), "2", ia+"시("+rEntity.getValue(i,"H_"+ia)+"명)");
	        		defaultcategorydataset.addValue(0, "3", ia+"시("+rEntity.getValue(i,"H_"+ia)+"명)");
	        	}
	        }
	    }
	  
	    return defaultcategorydataset;
		
	}
	
}
