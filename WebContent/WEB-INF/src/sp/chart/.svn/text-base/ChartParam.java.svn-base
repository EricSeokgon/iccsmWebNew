package sp.chart;

import javax.servlet.http.HttpServletRequest;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ChartParam extends ActionForm {
    
    /*차트  관련*/
    private String chartTitle;      // 차트 타이틀
    private String chartXTitle;     // 차트 X좌표 타이틀
    private String chartYTitle;     // 차트 Y좌표 타이틀
    private String chartType;       // 차트 타입
    private String chartWidth;      // 차트 넓이
    private String chartHeight;     // 차트 높이
    
    private boolean chartLegend;    // 차트 legend
    private boolean chartTooltips;  // 차트 툴팁
    private boolean chartUrl;       // 차트 URL
    
    private String domainAxisLabel; // domain axis label
    private String rangeAxisLabel;  // range axis label
    private String orientation;     // orientation 
    
    private double total;
    
    private Object dataSet ;        // 차트 데이타셋
    
    public ChartParam() {
    }

    /**
    *   request로 부터 parameter의 해당 value를 얻어
    *   paramName : value
    *   형식으로 출력
    */
    public String toString(HttpServletRequest request){
        return KJFUtil.reportParameters(request) ;
    }
    
    public String getChartTitle() {
        return chartTitle;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
    }

    public String getChartXTitle() {
        return chartXTitle;
    }

    public void setChartXTitle(String chartXTitle) {
        this.chartXTitle = chartXTitle;
    }

    public String getChartYTitle() {
        return chartYTitle;
    }

    public void setChartYTitle(String chartYTitle) {
        this.chartYTitle = chartYTitle;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getChartWidth() {
        return chartWidth;
    }

    public void setChartWidth(String chartWidth) {
        this.chartWidth = chartWidth;
    }

    public String getChartHeight() {
        return chartHeight;
    }

    public void setChartHeight(String chartHeight) {
        this.chartHeight = chartHeight;
    }
    
    public boolean isChartLegend() {
        return chartLegend;
    }

    public void setChartLegend(boolean chartLegend) {
        this.chartLegend = chartLegend;
    }

    public boolean isChartTooltips() {
        return chartTooltips;
    }

    public void setChartTooltips(boolean chartTooltips) {
        this.chartTooltips = chartTooltips;
    }

    public boolean isChartUrl() {
        return chartUrl;
    }

    public void setChartUrl(boolean chartUrl) {
        this.chartUrl = chartUrl;
    }   

    public String getDomainAxisLabel() {
        return domainAxisLabel;
    }

    public void setDomainAxisLabel(String domainAxisLabel) {
        this.domainAxisLabel = domainAxisLabel;
    }

    public String getRangeAxisLabel() {
        return rangeAxisLabel;
    }

    public void setRangeAxisLabel(String rangeAxisLabel) {
        this.rangeAxisLabel = rangeAxisLabel;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Object getDataSet() {
        return dataSet;
    }

    public void setDataSet(Object dataSet) {
        this.dataSet = dataSet;
    }
}
