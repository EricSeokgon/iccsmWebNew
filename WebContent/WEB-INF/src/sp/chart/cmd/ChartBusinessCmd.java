package sp.chart.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import sp.chart.ChartParam;
import sp.chart.ChartWorker;

public class ChartBusinessCmd implements KJFCommandResp {
    
    private String next;
    private double total;
    
    public ChartBusinessCmd() {        
    }
    
    public ChartBusinessCmd(String next_url) {
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
    private PieDataset createDataset(HttpServletRequest request) throws Exception {        
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("SELECT                                        \n");
        sbSQL.append("        COUNT(PT_1.TMP_WRT_NUM) AS BUS_RAW,   \n");
        sbSQL.append("        COUNT(PT_2.TMP_WRT_NUM) AS BUS_PRI,   \n");
        sbSQL.append("        COUNT(PT_3.TMP_WRT_NUM) AS BUS_ETC    \n");
        
        sbSQL.append("   FROM PT_R_COMPANY_MASTER PT_MST            \n");
        
        // ����
        sbSQL.append("   LEFT JOIN (                                \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("                WHERE COMMANA_CLASS = '1'     \n");
        sbSQL.append("             ) PT_1 ON PT_MST.TMP_WRT_NUM = PT_1.TMP_WRT_NUM  \n");
        
        // ����
        sbSQL.append("   LEFT JOIN (                                \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE COMMANA_CLASS = '2'      \n");
        sbSQL.append("             ) PT_2 ON PT_MST.TMP_WRT_NUM = PT_2.TMP_WRT_NUM  \n");

        // ��Ÿ
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE COMMANA_CLASS = '3'      \n");
        sbSQL.append("             ) PT_3 ON PT_MST.TMP_WRT_NUM = PT_3.TMP_WRT_NUM  \n");

        sbSQL.append("  WHERE PT_MST.SIDO_CODE = ?                  \n");  

        rDAO.setValue(1, request.getParameter("sido_code"));
        
        rEntity = rDAO.select(sbSQL.toString());
        
        // create the dataset...
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        if (rEntity.getRowCnt() > 0) {
            
            dataset.setValue("����", Integer.parseInt(rEntity.getValue(0, "BUS_RAW")));
            dataset.setValue("����", Integer.parseInt(rEntity.getValue(0, "BUS_PRI")));
            dataset.setValue("��Ÿ", Integer.parseInt(rEntity.getValue(0, "BUS_ETC")));
            
            total = Integer.parseInt(rEntity.getValue(0, "BUS_RAW")) 
                        + Integer.parseInt(rEntity.getValue(0, "BUS_PRI")) 
                            + Integer.parseInt(rEntity.getValue(0, "BUS_ETC"));
        } else {
            
            dataset.setValue("����", new Integer(0));
            dataset.setValue("����", new Integer(0));
            dataset.setValue("��Ÿ", new Integer(0));
            
            total = 0;
        }
        
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
            pm.setChartHeight("270");
        }
        
        if (KJFUtil.isEmpty(pm.getChartWidth())){
            pm.setChartWidth("706");
        }
        
        pm.setChartType("Pie3D");
        pm.setChartTitle("");
        pm.setDomainAxisLabel("");
        pm.setRangeAxisLabel("");
        pm.setChartLegend(false);
        pm.setChartTooltips(false);
        pm.setChartUrl(false);
                
        pm.setDataSet(createDataset(request));
        
        pm.setTotal(total);

        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));

        return pm;
    } 

}
