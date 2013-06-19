package sp.log;


import java.awt.Color;
import java.awt.GradientPaint;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ChartWorker {

	
    /**
	* 차트 프로세서
	* @param   HttpServletRequest request, HttpServletResponse response ,ActionForm form
	* @return  void
	*/
	public  void ChartProcess(HttpServletRequest request, HttpServletResponse response ,ActionForm form) throws  Exception{
	
		LogParam pm = (LogParam)form;
        
		String chartTitle 		= pm.getChartTitle();
		String chartXTitle 		= pm.getChartXTitle();
		String chartYTitle 		= pm.getChartYTitle();
		String chartAxis		= pm.getChartAxis();
//		String fonrAxis			= pm.getFontAxis();
        String chartType 		= KJFUtil.print(pm.getChartType());
        int chartWidth 			= KJFUtil.str2int(pm.getChartWidth());
        int chartHeight 		= KJFUtil.str2int(pm.getChartHeight());
        String chartCaption		= KJFUtil.print(pm.getChartCaption()); // 하단 시리즈 표시 여부
        Object dataSet 			= pm.getDataSet();
        String itemLabel		= KJFUtil.print(pm.getItemLabel());

        
        boolean isLegend		= true;
        
        JFreeChart objCht = null;
        
        if("N".equals(chartCaption)){
        	isLegend = false;
        }
        
	    if(chartType.equals("pie")){
	        objCht = ChartFactory.createPieChart3D(chartTitle,(DefaultPieDataset)dataSet, 
	        		isLegend, true, false);
	        PiePlot plot=(PiePlot)objCht.getPlot();
	        plot.setNoDataMessage("데이터가 없습니다.");
	        plot.setExplodePercent(0,0.1);
	        plot.setCircular(true);
	        plot.setStartAngle(180);
	        plot.setForegroundAlpha(0.6F);
	          

	        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));

	    }else if(chartType.equals("") || chartType.equals("bar")){
	    	PlotOrientation po = null;
	    	
	    	if(chartAxis.equals("X"))
	    		po = PlotOrientation.VERTICAL;
	    	else 
	    		po = PlotOrientation.HORIZONTAL;
	    	
	    	
	        objCht = ChartFactory.createBarChart(chartTitle, chartXTitle, chartYTitle,
	        		(CategoryDataset)dataSet, po, isLegend, true, false);
	        
	        CategoryPlot categoryplot = objCht.getCategoryPlot();
	        categoryplot.setNoDataMessage("데이터가 없습니다.");
	        categoryplot.setBackgroundPaint(Color.white);
	        categoryplot.setDomainGridlinePaint(Color.white);
	        categoryplot.setDomainGridlinesVisible(true);
	        categoryplot.setRangeGridlinePaint(Color.lightGray);
	        
        
	        if(chartAxis.equals("X")){
	        	CategoryAxis domainAxis = categoryplot.getDomainAxis();
	        	domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
	        }
	        
	        
	        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
	        barrenderer.setDrawBarOutline(false);
	        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
	        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
	        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
	        GradientPaint gradientpaint3 = new GradientPaint(0.0F, 0.0F, Color.yellow, 0.0F, 0.0F, new Color(0, 0, 64));
	        GradientPaint gradientpaint4 = new GradientPaint(0.0F, 0.0F, Color.pink, 0.0F, 0.0F, new Color(64, 0, 0));
	        barrenderer.setSeriesPaint(0, gradientpaint);
	        barrenderer.setSeriesPaint(1, gradientpaint1);
	        barrenderer.setSeriesPaint(2, gradientpaint2);
	        barrenderer.setSeriesPaint(3, gradientpaint3);
	        barrenderer.setSeriesPaint(4, gradientpaint4);
	        
	        if("Y".equals(itemLabel)){
		        barrenderer.setSeriesItemLabelsVisible(0, true);
		        barrenderer.setSeriesItemLabelGenerator(0,new StandardCategoryItemLabelGenerator());
		        barrenderer.setSeriesItemLabelsVisible(1, true);
		        barrenderer.setSeriesItemLabelGenerator(1,new StandardCategoryItemLabelGenerator());
		        barrenderer.setSeriesItemLabelsVisible(2, true);
		        barrenderer.setSeriesItemLabelGenerator(2,new StandardCategoryItemLabelGenerator());	        
		        barrenderer.setSeriesItemLabelsVisible(3, true);
		        barrenderer.setSeriesItemLabelGenerator(3,new StandardCategoryItemLabelGenerator());
		        barrenderer.setSeriesItemLabelsVisible(4, true);
		        barrenderer.setSeriesItemLabelGenerator(5,new StandardCategoryItemLabelGenerator());
	        }

	    }

		objCht.setBackgroundPaint(Color.WHITE);
        // 바이너리 출력 스트림에 JPEG형식으로 그래프를 출력 (700×400픽셀)
        response.setContentType("image/jpeg"); 
        ServletOutputStream objSos=response.getOutputStream();
        ChartUtilities.writeChartAsJPEG(objSos,objCht,chartWidth,chartHeight); 
  
	}
	
	
}
