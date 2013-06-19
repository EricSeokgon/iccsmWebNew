package sp.chart;

import javax.servlet.http.HttpServletRequest;

import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ChartParam extends ActionForm {
    
    /*��Ʈ  ����*/
    private String chartTitle;      // ��Ʈ Ÿ��Ʋ
    private String chartXTitle;     // ��Ʈ X��ǥ Ÿ��Ʋ
    private String chartYTitle;     // ��Ʈ Y��ǥ Ÿ��Ʋ
    private String chartType;       // ��Ʈ Ÿ��
    private String chartWidth;      // ��Ʈ ����
    private String chartHeight;     // ��Ʈ ����
    
    private boolean chartLegend;    // ��Ʈ legend
    private boolean chartTooltips;  // ��Ʈ ����
    private boolean chartUrl;       // ��Ʈ URL
    
    private String domainAxisLabel; // domain axis label
    private String rangeAxisLabel;  // range axis label
    private String orientation;     // orientation 
    
    private double total;
    
    private Object dataSet ;        // ��Ʈ ����Ÿ��
    
    public ChartParam() {
    }

    /**
    *   request�� ���� parameter�� �ش� value�� ���
    *   paramName : value
    *   �������� ���
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
