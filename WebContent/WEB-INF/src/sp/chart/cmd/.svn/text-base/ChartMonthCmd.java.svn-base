package sp.chart.cmd;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import sp.chart.ChartParam;
import sp.chart.ChartWorker;

public class ChartMonthCmd implements KJFCommandResp {
    
    private String next;
    
    public ChartMonthCmd() {        
    }
    
    public ChartMonthCmd(String next_url) {
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
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append("SELECT                                          \n");
        sbSQL.append("        COUNT(PT_1.TMP_WRT_NUM) AS MON_01,      \n");
        sbSQL.append("        COUNT(PT_2.TMP_WRT_NUM) AS MON_02,      \n");
        sbSQL.append("        COUNT(PT_3.TMP_WRT_NUM) AS MON_03,      \n");
        sbSQL.append("        COUNT(PT_4.TMP_WRT_NUM) AS MON_04,      \n");
        sbSQL.append("        COUNT(PT_5.TMP_WRT_NUM) AS MON_05,      \n");
        sbSQL.append("        COUNT(PT_6.TMP_WRT_NUM) AS MON_06,      \n");
        sbSQL.append("        COUNT(PT_7.TMP_WRT_NUM) AS MON_07,      \n");
        sbSQL.append("        COUNT(PT_8.TMP_WRT_NUM) AS MON_08,      \n");
        sbSQL.append("        COUNT(PT_9.TMP_WRT_NUM) AS MON_09,      \n");
        sbSQL.append("        COUNT(PT_10.TMP_WRT_NUM) AS MON_10,     \n");
        sbSQL.append("        COUNT(PT_11.TMP_WRT_NUM) AS MON_11,     \n");
        sbSQL.append("        COUNT(PT_12.TMP_WRT_NUM) AS MON_12,     \n");
        sbSQL.append("        COUNT(PT_13.TMP_WRT_NUM) AS MON_13      \n");
        
        sbSQL.append("   FROM PT_R_COMPANY_MASTER PT_MST                \n");

        sbSQL.append("   LEFT JOIN (                                    \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                  \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER          \n");
        sbSQL.append("                WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -12),'YYYYMM')    \n");
        sbSQL.append("             ) PT_1 ON PT_MST.TMP_WRT_NUM = PT_1.TMP_WRT_NUM      \n");

        sbSQL.append("   LEFT JOIN (                                        \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                      \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER              \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -11),'YYYYMM')     \n");
        sbSQL.append("             ) PT_2 ON PT_MST.TMP_WRT_NUM = PT_2.TMP_WRT_NUM      \n");

        sbSQL.append("  LEFT JOIN (                                         \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                      \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER              \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -10),'YYYYMM')     \n");
        sbSQL.append("             ) PT_3 ON PT_MST.TMP_WRT_NUM = PT_3.TMP_WRT_NUM      \n");

        sbSQL.append("  LEFT JOIN (                                         \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                      \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER              \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -9),'YYYYMM')     \n");
        sbSQL.append("             ) PT_4 ON PT_MST.TMP_WRT_NUM = PT_4.TMP_WRT_NUM      \n");

        sbSQL.append(" LEFT JOIN (                                      \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                  \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER          \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -8),'YYYYMM')     \n");
        sbSQL.append("             ) PT_5 ON PT_MST.TMP_WRT_NUM = PT_5.TMP_WRT_NUM      \n");

        sbSQL.append("  LEFT JOIN (                                     \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                  \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER          \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -7),'YYYYMM')     \n");
        sbSQL.append("             ) PT_6 ON PT_MST.TMP_WRT_NUM = PT_6.TMP_WRT_NUM      \n");
        
        sbSQL.append("  LEFT JOIN (                                     \n");
        sbSQL.append("              SELECT TMP_WRT_NUM                  \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER          \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -6),'YYYYMM')     \n");
        sbSQL.append("             ) PT_7 ON PT_MST.TMP_WRT_NUM = PT_7.TMP_WRT_NUM      \n");
        
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -5),'YYYYMM')     \n");
        sbSQL.append("             ) PT_8 ON PT_MST.TMP_WRT_NUM = PT_8.TMP_WRT_NUM      \n");
       
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -4),'YYYYMM')     \n");
        sbSQL.append("             ) PT_9 ON PT_MST.TMP_WRT_NUM = PT_9.TMP_WRT_NUM      \n");
        
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -3),'YYYYMM')     \n");
        sbSQL.append("             ) PT_10 ON PT_MST.TMP_WRT_NUM = PT_10.TMP_WRT_NUM    \n");
       
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -2),'YYYYMM')     \n");
        sbSQL.append("             ) PT_11 ON PT_MST.TMP_WRT_NUM = PT_11.TMP_WRT_NUM    \n");
        
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(ADD_MONTHS(SYSDATE, -1),'YYYYMM')     \n");
        sbSQL.append("             ) PT_12 ON PT_MST.TMP_WRT_NUM = PT_12.TMP_WRT_NUM    \n");     
               
        sbSQL.append("  LEFT JOIN (                                 \n");
        sbSQL.append("              SELECT TMP_WRT_NUM              \n");
        sbSQL.append("                FROM PT_R_COMPANY_MASTER      \n");
        sbSQL.append("               WHERE TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') = TO_CHAR(SYSDATE, 'YYYYMM')     \n");
        sbSQL.append("             ) PT_13 ON PT_MST.TMP_WRT_NUM = PT_13.TMP_WRT_NUM    \n");     

        sbSQL.append("  WHERE PT_MST.SIDO_CODE = ?                          \n");
        sbSQL.append("    AND PT_MST.WRT_DT IS NOT NULL                     \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') >= TO_CHAR(ADD_MONTHS(SYSDATE, -12),'YYYYMM')   \n");
        sbSQL.append("    AND TO_CHAR(TO_DATE(WRT_DT),'YYYYMM') <= TO_CHAR(SYSDATE,'YYYYMM')                    \n");        
            
        int i = 1;
               
        rDAO.setValue(i++, request.getParameter("sido_code"));     
               
        rEntity = rDAO.select(sbSQL.toString());
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if (rEntity.getRowCnt() > 0) {
            
            Calendar cal = Calendar.getInstance();
            String beforeDate = String.valueOf(cal.get(Calendar.YEAR)-1) + KJFDate.getFillZero(String.valueOf(cal.get(Calendar.MONTH)+1), 2);
            
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_01")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);            
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_02")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_03")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_04")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_05")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_06")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_07")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_08")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_09")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_10")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_11")), "month", KJFDate.getYearMonthForm(beforeDate));
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_12")), "month", KJFDate.getYearMonthForm(beforeDate)); 
            
            beforeDate = KJFDate.getNextMonthDay(beforeDate);
            dataset.addValue(KJFUtil.str2int(rEntity.getValue(0, "MON_13")), "month", KJFDate.getYearMonthForm(beforeDate));  
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
        
        if (KJFUtil.isEmpty(pm.getChartHeight())){
            pm.setChartHeight("270");
        }
        
        if (KJFUtil.isEmpty(pm.getChartWidth())){
            pm.setChartWidth("706");
        }
        
        pm.setChartType("Line");
        pm.setChartTitle("");
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
