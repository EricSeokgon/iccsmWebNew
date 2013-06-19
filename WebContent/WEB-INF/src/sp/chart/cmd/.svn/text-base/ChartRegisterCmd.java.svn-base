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

public class ChartRegisterCmd implements KJFCommandResp {
    
    private String next;
    
    public ChartRegisterCmd() {        
    }
    
    public ChartRegisterCmd(String next_url) {
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
        sbSQL.append(" SELECT                                   \n");        
       
        sbSQL.append("        PT_AREA.SIDO_NM,                  \n");   // 시도명 
        sbSQL.append("        PT_MST.SIDO_CODE,                 \n");   // 시도코드
        sbSQL.append("        COUNT(PT_MST.SIDO_CODE) AS CNT    \n");   // 통계
        
        sbSQL.append("   FROM PT_R_COMPANY_MASTER PT_MST        \n");
        
        sbSQL.append("  INNER JOIN (                                                            \n");
        sbSQL.append("              SELECT AREA_CODE, SIDO_NM                                   \n");  
        sbSQL.append("                FROM PT_SIDO_CODE                                         \n");  
        sbSQL.append("               WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR(AREA_CODE, 3, 4)    \n");        
        sbSQL.append("             ) PT_AREA ON PT_AREA.AREA_CODE = PT_MST.SIDO_CODE            \n");      
        sbSQL.append("  GROUP BY PT_MST.SIDO_CODE, PT_AREA.SIDO_NM                              \n");  
        sbSQL.append("  ORDER BY PT_AREA.SIDO_NM                                                \n");  
        
        rEntity = rDAO.select(sbSQL.toString());
        
        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if (rEntity.getRowCnt() > 0) {
            
            for (int i = 0; i < rEntity.getRowCnt(); i++) {                                    
                dataset.addValue(KJFUtil.str2int(rEntity.getValue(i, "CNT")), KJFArea.getSido_Name(rEntity.getValue(i, "SIDO_CODE")), KJFArea.getSido_Name(rEntity.getValue(i, "SIDO_CODE")));             
            }
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
        
        pm.setChartType("StackedBar3D");
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
