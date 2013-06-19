package sp.chart.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFArea;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import sp.chart.ChartParam;
import sp.chart.ChartWorker;

/***************************************************************************
 * <p>Title       : ChartAreaCmd Class</p>
 * <p>Description : 지역별 정보통신공사업등록현황 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 지역별 정보통신공사업등록현황 정보 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class ChartUbCmd implements KJFCommandResp {
    
	private String next;
	
    public ChartUbCmd(String next_url) {
        next = next_url; 
    }	

    
    public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception { 
       
        // 검색조건 설정및 체크
        ChartParam pm = checkPm(request, form);  
        request.setAttribute("pm", pm);
        
        ChartWorker worker = new ChartWorker();
        
        worker.ChartProcess(request, response, pm);
        
        return next;
    }
    
    
    /**
     * HTML 컨텐츠 정보를 불러온다
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     */
    private CategoryDataset createDataset(HttpServletRequest request) throws Exception {        
        

    	int C1 = KJFUtil.str2int(request.getParameter("C1"));
    	int C2 = KJFUtil.str2int(request.getParameter("C2"));
    	int C3 = KJFUtil.str2int(request.getParameter("C3"));
    	int C4 = KJFUtil.str2int(request.getParameter("C4"));
    	int U1 = KJFUtil.str2int(request.getParameter("U1"));
    	int U2 = KJFUtil.str2int(request.getParameter("U2"));
    	int U3 = KJFUtil.str2int(request.getParameter("U3"));
    	int U4 = KJFUtil.str2int(request.getParameter("U4"));
    	int S1 = KJFUtil.str2int(request.getParameter("S1"));
    	int S2 = KJFUtil.str2int(request.getParameter("S2"));
    	int S3 = KJFUtil.str2int(request.getParameter("S3"));
    	int S4 = KJFUtil.str2int(request.getParameter("S4"));
        

        
        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String rowKey="착공전설계검토";
        
        dataset.addValue(C1, rowKey, "1분기");
        dataset.addValue(C2, rowKey, "2분기");
        dataset.addValue(C3, rowKey, "3분기");
        dataset.addValue(C4, rowKey, "4분기");
        
        rowKey="사용전검사";
        
        dataset.addValue(U1, rowKey, "1분기");
        dataset.addValue(U2, rowKey, "2분기");
        dataset.addValue(U3, rowKey, "3분기");
        dataset.addValue(U4, rowKey, "4분기");

        rowKey="감리결과보고서접수";
        
        dataset.addValue(S1, rowKey, "1분기");
        dataset.addValue(S2, rowKey, "2분기");
        dataset.addValue(S3, rowKey, "3분기");
        dataset.addValue(S4, rowKey, "4분기");   
        
        return dataset;        
    }
    
    /**
     * 검색조건 초기값 설정및 체크
     * 
     * @param request
     * @param form
     * @return BbsParam
     * @throws Exception
     */
    private ChartParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

        ChartParam pm = (ChartParam) form;
        
        if (KJFUtil.isEmpty(pm.getChartHeight())){
            pm.setChartHeight("350");
        }
        
        if (KJFUtil.isEmpty(pm.getChartWidth())){
            pm.setChartWidth("660");
        }
        
        pm.setChartTitle("");
        pm.setDomainAxisLabel("");
        pm.setRangeAxisLabel("");
        pm.setChartLegend(true);
        pm.setChartTooltips(true);
        pm.setChartUrl(false);
  
        pm.setDataSet(createDataset(request));

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        return pm;
    } 

}
