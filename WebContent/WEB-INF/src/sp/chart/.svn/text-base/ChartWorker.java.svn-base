package sp.chart;

import java.awt.Color;
import java.awt.Font;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.util.KJFUtil;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

/***************************************************************************
 * <p>Title       : ChartWorker Class</p>
 * <p>Description : 차트처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 차트 정보 처리를 한다. 
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class ChartWorker {
	
    /**
	* 차트 프로세서
	* @param   HttpServletRequest request, HttpServletResponse response ,ActionForm form
	* @return  void
	*/
	public void ChartProcess(HttpServletRequest request, HttpServletResponse response, ChartParam pm) throws  Exception{

		
	    String chartType = KJFUtil.print(pm.getChartType());
	           
        Object dataSet 	= pm.getDataSet();
        
        JFreeChart chart = null;
       
        // 한글 깨짐 방지
        StandardChartTheme chartTheme = new StandardChartTheme("sansserif");
        chartTheme.setExtraLargeFont(new Font("sansserif", Font.BOLD, 20));
        chartTheme.setLargeFont(new Font("sansserif", Font.BOLD, 14));
        chartTheme.setRegularFont(new Font("sansserif", Font.PLAIN, 12));

        ChartFactory.setChartTheme(chartTheme);
        
	    if(chartType.equals("") || chartType.equals("StackedBarChart3D")) {
	        
	        // create the chart...
            chart = ChartFactory.createStackedBarChart3D(
                       pm.getChartTitle(),            // chart title
                       pm.getDomainAxisLabel(),       // x axis label
                       pm.getRangeAxisLabel(),        // y axis label
                       (CategoryDataset) dataSet,     // data
                       PlotOrientation.VERTICAL,      // orientation
                       pm.isChartLegend(),            // include legend
                       pm.isChartTooltips(),          // tooltips
                       pm.isChartUrl()                // urls
                   );

	    }

	    chart.setBackgroundPaint(Color.WHITE);
	    
	    request.setAttribute("chart", chart);
	    
//        // 바이너리 출력 스트림에 JPEG형식으로 그래프를 출력 (700×400픽셀)
//        response.setContentType("image/jpeg"); 
//        ServletOutputStream objSos=response.getOutputStream();
//        ChartUtilities.writeChartAsJPEG(objSos, chart, chartWidth, chartHeight);   
	}
	
	
}
