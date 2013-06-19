package sp.log;

import org.apache.struts.action.ActionForm;

public class LogParam extends ActionForm{    
    
    /*차트  관련*/
	private String chartTitle;
	private String chartXTitle;
	private String chartYTitle;
    private String chartType;
    private String chartWidth;
    private String chartHeight;
    private String chartDataCode;
    private String chartAxis;
    private String fontAxis;
    private Object dataSet ;
    
    private String scStartDate;
    private String scEndDate;
    private String calyear;
    private String caldate;
    private String page_id;
    
    private String chartCaption;
    private String itemLabel;

    private String scGUBUN;

	public String getCaldate() {
		return caldate;
	}

	public void setCaldate(String caldate) {
		this.caldate = caldate;
	}

	public String getCalyear() {
		return calyear;
	}

	public void setCalyear(String calyear) {
		this.calyear = calyear;
	}

	public String getChartAxis() {
		return chartAxis;
	}

	public void setChartAxis(String chartAxis) {
		this.chartAxis = chartAxis;
	}

	public String getChartCaption() {
		return chartCaption;
	}

	public void setChartCaption(String chartCaption) {
		this.chartCaption = chartCaption;
	}

	public String getChartDataCode() {
		return chartDataCode;
	}

	public void setChartDataCode(String chartDataCode) {
		this.chartDataCode = chartDataCode;
	}

	public String getChartHeight() {
		return chartHeight;
	}

	public void setChartHeight(String chartHeight) {
		this.chartHeight = chartHeight;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
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

	public Object getDataSet() {
		return dataSet;
	}

	public void setDataSet(Object dataSet) {
		this.dataSet = dataSet;
	}

	public String getFontAxis() {
		return fontAxis;
	}

	public void setFontAxis(String fontAxis) {
		this.fontAxis = fontAxis;
	}

	public String getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}

	public String getScEndDate() {
		return scEndDate;
	}

	public void setScEndDate(String scEndDate) {
		this.scEndDate = scEndDate;
	}

	public String getScGUBUN() {
		return scGUBUN;
	}

	public void setScGUBUN(String scGUBUN) {
		this.scGUBUN = scGUBUN;
	}

	public String getScStartDate() {
		return scStartDate;
	}

	public void setScStartDate(String scStartDate) {
		this.scStartDate = scStartDate;
	}
    
    
}
