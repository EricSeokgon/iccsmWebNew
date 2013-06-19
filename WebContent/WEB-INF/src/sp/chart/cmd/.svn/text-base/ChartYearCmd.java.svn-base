package sp.chart.cmd;

import java.util.Calendar;

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

public class ChartYearCmd implements KJFCommandResp {
    
    private String next;
    
    public ChartYearCmd() {        
    }
    
    public ChartYearCmd(String next_url) {
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
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        Calendar cal = Calendar.getInstance();
        
        String sido_code = KJFUtil.print(request.getParameter("sido_code"));
        
        int cnt = 1;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("SELECT                                            \n");
        sbSQL.append("         COUNT(PT_Y1.TMP_WRT_NUM) AS YEAR_01,     \n");
        sbSQL.append("         COUNT(PT_Y2.TMP_WRT_NUM) AS YEAR_02,     \n");
        sbSQL.append("         COUNT(PT_Y3.TMP_WRT_NUM) AS YEAR_03,     \n");
        sbSQL.append("         COUNT(PT_Y4.TMP_WRT_NUM) AS YEAR_04,     \n");
        sbSQL.append("         COUNT(PT_Y5.TMP_WRT_NUM) AS YEAR_05,     \n");
        sbSQL.append("         COUNT(PT_Y6.TMP_WRT_NUM) AS YEAR_06,     \n");
        sbSQL.append("         COUNT(PT_Y7.TMP_WRT_NUM) AS YEAR_07,     \n");
        sbSQL.append("         COUNT(PT_Y8.TMP_WRT_NUM) AS YEAR_08      \n");
        
        sbSQL.append("    FROM PT_R_COMPANY_MASTER PT_MST               \n");

        sbSQL.append("    LEFT JOIN (                                   \n");
        sbSQL.append("                SELECT TMP_WRT_NUM                \n");
        sbSQL.append("                  FROM PT_R_COMPANY_MASTER        \n");
        sbSQL.append("                 WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') = ?        \n");
        sbSQL.append("              ) PT_Y1 ON PT_MST.TMP_WRT_NUM = PT_Y1.TMP_WRT_NUM   \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));

        sbSQL.append("    LEFT JOIN (                                                   \n");
        sbSQL.append("                SELECT TMP_WRT_NUM                                \n");
        sbSQL.append("                  FROM PT_R_COMPANY_MASTER                        \n");
        sbSQL.append("                 WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ?  \n");
        sbSQL.append("              ) PT_Y2 ON PT_MST.TMP_WRT_NUM = PT_Y2.TMP_WRT_NUM   \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-6));

        sbSQL.append("   LEFT JOIN (                                                    \n");
        sbSQL.append("                SELECT TMP_WRT_NUM                                \n");
        sbSQL.append("                  FROM PT_R_COMPANY_MASTER                        \n");
        sbSQL.append("                 WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ?  \n");
        sbSQL.append("              ) PT_Y3 ON PT_MST.TMP_WRT_NUM = PT_Y3.TMP_WRT_NUM  \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-5));

        sbSQL.append("   LEFT JOIN (                                                    \n");
        sbSQL.append("               SELECT TMP_WRT_NUM                                 \n");
        sbSQL.append("                 FROM PT_R_COMPANY_MASTER                         \n");
        sbSQL.append("                WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ? \n");
        sbSQL.append("             ) PT_Y4 ON PT_MST.TMP_WRT_NUM = PT_Y4.TMP_WRT_NUM    \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-4));

        sbSQL.append("    LEFT JOIN (                                                   \n");
        sbSQL.append("                 SELECT TMP_WRT_NUM                               \n");
        sbSQL.append("                   FROM PT_R_COMPANY_MASTER                       \n");
        sbSQL.append("                  WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ? \n");
        sbSQL.append("               ) PT_Y5 ON PT_MST.TMP_WRT_NUM = PT_Y5.TMP_WRT_NUM  \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-3));
        
        sbSQL.append("  LEFT JOIN (                                                     \n");
        sbSQL.append("               SELECT TMP_WRT_NUM                                 \n");
        sbSQL.append("                 FROM PT_R_COMPANY_MASTER                         \n");
        sbSQL.append("                WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ?   \n");
        sbSQL.append("             ) PT_Y6 ON PT_MST.TMP_WRT_NUM = PT_Y6.TMP_WRT_NUM    \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-2));
        
        sbSQL.append("    LEFT JOIN (                                                   \n");
        sbSQL.append("                 SELECT TMP_WRT_NUM                               \n");
        sbSQL.append("                   FROM PT_R_COMPANY_MASTER                       \n");
        sbSQL.append("                  WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ? \n");
        sbSQL.append("               ) PT_Y7 ON PT_MST.TMP_WRT_NUM = PT_Y7.TMP_WRT_NUM  \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-1));

        sbSQL.append("    LEFT JOIN (                                                   \n");
        sbSQL.append("                 SELECT TMP_WRT_NUM                               \n");
        sbSQL.append("                   FROM PT_R_COMPANY_MASTER                       \n");
        sbSQL.append("                  WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ? \n");
        sbSQL.append("               ) PT_Y8 ON PT_MST.TMP_WRT_NUM = PT_Y8.TMP_WRT_NUM  \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)));

        sbSQL.append("   WHERE PT_MST.SIDO_CODE = ?   \n");
        rDAO.setValue(cnt++, sido_code);
        
        sbSQL.append("   AND TO_CHAR(TO_DATE(WRT_DT),'YYYY') BETWEEN ? AND ? \n");
        rDAO.setValue(cnt++, (cal.get(Calendar.YEAR)-7));
        rDAO.setValue(cnt++, cal.get(Calendar.YEAR));
                
        
        rEntity = rDAO.select(sbSQL.toString());
        
        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if (rEntity.getRowCnt() > 0) {
            
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_01")), String.valueOf((cal.get(Calendar.YEAR)-7)), String.valueOf((cal.get(Calendar.YEAR)-7)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_02")), String.valueOf((cal.get(Calendar.YEAR)-6)), String.valueOf((cal.get(Calendar.YEAR)-6)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_03")), String.valueOf((cal.get(Calendar.YEAR)-5)), String.valueOf((cal.get(Calendar.YEAR)-5)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_04")), String.valueOf((cal.get(Calendar.YEAR)-4)), String.valueOf((cal.get(Calendar.YEAR)-4)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_05")), String.valueOf((cal.get(Calendar.YEAR)-3)), String.valueOf((cal.get(Calendar.YEAR)-3)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_06")), String.valueOf((cal.get(Calendar.YEAR)-2)), String.valueOf((cal.get(Calendar.YEAR)-2)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_07")), String.valueOf((cal.get(Calendar.YEAR)-1)), String.valueOf((cal.get(Calendar.YEAR)-1)));
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "YEAR_08")), String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.YEAR)));
        }       
        
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
        
        String chartTitle = "";
        
        if (KJFUtil.isEmpty(pm.getChartHeight())){
            pm.setChartHeight("270");
        }
        
        if (KJFUtil.isEmpty(pm.getChartWidth())){
            pm.setChartWidth("706");
        }
        
        pm.setChartType("StackedBar");
        pm.setChartTitle(chartTitle);
        pm.setDomainAxisLabel("");
        pm.setRangeAxisLabel("");
        pm.setChartLegend(false);
        pm.setChartTooltips(false);
        pm.setChartUrl(false);
        
        pm.setDataSet(createDataset(request));

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        return pm;
    } 

}
