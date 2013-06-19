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
 * <p>Description : ������ ������Ű���������Ȳ Ŭ����</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : ������ ������Ű���������Ȳ ���� ó���� �Ѵ�. 
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
       
        // �˻����� ������ üũ
        ChartParam pm = checkPm(request, form);  
        request.setAttribute("pm", pm);
        
        ChartWorker worker = new ChartWorker();
        
        worker.ChartProcess(request, response, pm);
        
        return next;
    }
    
    
    /**
     * HTML ������ ������ �ҷ��´�
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
        
        String rowKey="�������������";
        
        dataset.addValue(C1, rowKey, "1�б�");
        dataset.addValue(C2, rowKey, "2�б�");
        dataset.addValue(C3, rowKey, "3�б�");
        dataset.addValue(C4, rowKey, "4�б�");
        
        rowKey="������˻�";
        
        dataset.addValue(U1, rowKey, "1�б�");
        dataset.addValue(U2, rowKey, "2�б�");
        dataset.addValue(U3, rowKey, "3�б�");
        dataset.addValue(U4, rowKey, "4�б�");

        rowKey="���������������";
        
        dataset.addValue(S1, rowKey, "1�б�");
        dataset.addValue(S2, rowKey, "2�б�");
        dataset.addValue(S3, rowKey, "3�б�");
        dataset.addValue(S4, rowKey, "4�б�");   
        
        return dataset;        
    }
    
    /**
     * �˻����� �ʱⰪ ������ üũ
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

        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));

        return pm;
    } 

}
