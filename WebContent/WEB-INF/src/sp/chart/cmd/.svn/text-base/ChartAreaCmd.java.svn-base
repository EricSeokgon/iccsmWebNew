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
public class ChartAreaCmd implements KJFCommandResp {
    
    public ChartAreaCmd() {        
    }
    
    public String execute(HttpServletRequest request, HttpServletResponse response,  ActionForm form) throws Exception { 
       
        // 검색조건 설정및 체크
        ChartParam pm = checkPm(request, form);  
        request.setAttribute("pm", pm);
        
        ChartWorker worker = new ChartWorker();
        
        worker.ChartProcess(request, response, pm);
        
        return request.getParameter("cmd");
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
        
    	
    	/*
    	 			" 	SELECT      \n"+ 
			" 		COM.SIDO_NM, M.SIDO_CODE AS SIDO_CODE, COUNT(M.SIDO_CODE) AS CNT    \n"+
        	" 	FROM PT_R_COMPANY_MASTER M, PT_SIDO_CODE COM      	\n"+
        	" 		WHERE M.SIDO_CODE IS NOT NULL    \n"+	
	        " 			AND M.SIDO_CODE = COM.AREA_CODE(+)  \n"+	
	        " 			AND M.SIDO_CODE != 'tete'     \n"+
	        " 			AND (M.TRANS_UNION_PROC IS NULL OR M.TRANS_UNION_PARENT IS NULL) AND C_COM_DT IS NOT NULL    \n"+
	        " 		GROUP BY COM.SIDO_NM,SIDO_CODE     \n"+
	        " 	ORDER BY COM.SIDO_NM ASC       \n"; 
    	 
    	 * */
    	
    	
 
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuffer sbSQL = new StringBuffer();        
        sbSQL.append(" SELECT  \n");     
        sbSQL.append("        COM.SIDO_NM, M.SIDO_CODE AS SIDO_CODE, COUNT(M.SIDO_CODE) AS CNT  \n");   
        sbSQL.append("        FROM PT_R_COMPANY_MASTER M, PT_SIDO_CODE COM   \n");   
        sbSQL.append("        WHERE M.SIDO_CODE IS NOT NULL     \n");  
        sbSQL.append("   		AND M.SIDO_CODE = COM.AREA_CODE(+)   \n");
        sbSQL.append("  		AND M.SIDO_CODE != 'tete'     \n");
        sbSQL.append("          AND (M.TRANS_UNION_PROC IS NULL AND M.TRANS_UNION_PARENT IS NULL) AND C_COM_DT IS NULL   \n");  
        sbSQL.append("          GROUP BY COM.SIDO_NM,SIDO_CODE    \n");  
        sbSQL.append("          ORDER BY COM.SIDO_NM ASC    \n");         
        
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
            pm.setChartHeight("330");
        }
        
        if (KJFUtil.isEmpty(pm.getChartWidth())){
            pm.setChartWidth("660");
        }
        
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
