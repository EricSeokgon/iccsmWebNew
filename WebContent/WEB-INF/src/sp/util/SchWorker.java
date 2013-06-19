package sp.util;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFUtil;
import kjf.util.LunarCalendar;
import sp.uent.UserEnt;

public class SchWorker {
	private static int thisYear;
	private static HashMap solarHoliday;
	private static HashMap thisYearHoliday;
	private static String STR_APP;
	
	static{
		switch(KJFDBUtil.DB_TYPE){
		case 2:
			STR_APP = " + ";
			break;
		default:
			STR_APP = " || ";			
		}
	}
	
	public static HashMap getHoidayMap(int year)throws  Exception{
		GregorianCalendar today = new GregorianCalendar ();
		int thisY = today.get ( GregorianCalendar.YEAR );
		if(thisY==year || year==0){
			return getThisYearHolidayMap(thisY);
		}else{
			HashMap holidayMap = new HashMap();
			if(solarHoliday==null) loadSolarHoiday();
			holidayMap.putAll(solarHoliday);
			holidayMap.putAll(getLunarHolidayMap(year));
			return holidayMap;		
		}
	}
	
	private static HashMap getThisYearHolidayMap(int year)throws  Exception{
	
		if(thisYear!=year){
			thisYear = year;
			if(solarHoliday==null) loadSolarHoiday();
			thisYearHoliday = new HashMap();
			thisYearHoliday.putAll(solarHoliday);
			thisYearHoliday.putAll(getLunarHolidayMap(thisYear));
			
			return thisYearHoliday;
		}else{
			return thisYearHoliday;			
		}
	}

	public static void reloadHoidayMap()throws  Exception{
		thisYearHoliday = new HashMap();
		loadSolarHoiday();
		thisYearHoliday.putAll(solarHoliday);
		if(thisYear==0){
			GregorianCalendar today = new GregorianCalendar ();
			thisYear = today.get ( GregorianCalendar.YEAR );
		}
		thisYearHoliday.putAll(getLunarHolidayMap(thisYear));
	}
	
	
	private static HashMap getLunarHolidayMap(int year)throws  Exception{
		HashMap LunarHoliday = new HashMap();
		//음력 휴일
		LunarCalendar lc = new LunarCalendar();
		String lunarLastDay = String.valueOf(KJFUtil.str2int(lc.fromLunar(year+"0101",""))-1).substring(4);
		LunarHoliday.put(lunarLastDay.equals("0200")?"01-31":lunarLastDay.subSequence(0,2)+"-"+lunarLastDay.substring(2),"");
		LunarHoliday.put(lc.fromLunar(year+"0101", "-").substring(5),"설날");
		LunarHoliday.put(lc.fromLunar(year+"0102", "-").substring(5),"");
		LunarHoliday.put(lc.fromLunar(year+"0408", "-").substring(5),"석가탄신일");
		LunarHoliday.put(lc.fromLunar(year+"0814", "-").substring(5),"");
		LunarHoliday.put(lc.fromLunar(year+"0815", "-").substring(5),"추석");
		LunarHoliday.put(lc.fromLunar(year+"0816", "-").substring(5),"");

		return LunarHoliday;
	}
	
	private static void loadSolarHoiday()throws  Exception{
		solarHoliday = new HashMap();
		ReportDAO    rDAO        = new ReportDAO();
		ReportEntity rEntity     = null;

	    String sql = "SELECT H_MONTH, H_DAY, H_SUB FROM PT_SCH_HOLIDAY";
	    rEntity = rDAO.select(sql);
	    for (int i = 0; i < rEntity.getRowCnt(); i++) {
	    	solarHoliday.put(rEntity.getValue(i, "H_MONTH")+"-"+rEntity.getValue(i, "H_DAY"), rEntity.getValue(i, "H_SUB"));
		}
	}

	
	private String makeSqlDateDiff(String col1, String col2){
		
		switch(KJFDBUtil.DB_TYPE){
		case 2:
			return " DATEDIFF(DAY, "+col1+", "+col2+") ";
		default:
			return " TO_DATE("+col1+")-TO_DATE("+col2+") ";
		}		
	}
	
	
	// 2007-07-24 문자를 07/24 로 반환 한다.
	private String makeSqlDt_mmdd(String col){
		
		switch(KJFDBUtil.DB_TYPE){
		case 2:
			return " convert( char(5), CONVERT(DATETIME, "+col+"), 1) ";
		default:
			return " to_char(to_date("+col+"), 'mm/dd') ";
			
		}		
	}
}


