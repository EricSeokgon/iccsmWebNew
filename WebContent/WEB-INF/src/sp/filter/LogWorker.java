/*
2006. 8. 3오후 5:23:06
*/

package sp.filter;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.ops.SuperToDB;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;


public class LogWorker extends SuperToDB{
	
	public LogWorker() {}

	/*======================================================================================================*/
	public void viewMgr(String page_id){
		
		try{
			
		/*=====================================*/
		/*날짜별 통계 기록*/
		/*=====================================*/
			
			/*우선 해당 날짜에 대한 로그가 있는지 검사한다.*/
			boolean Daycheck = checkInsertDayViewLog(page_id);
			
			if(Daycheck){
				/*이미 기록된 데이터가 있으면 카운터만 +1 시킨다*/
				this.updateDayViewLog(page_id);
			}else{
				/*오늘에 해당하는 데이터가 없으면 신규로 테이터를 삽입후 카운터 +1 시킨다.*/
				this.insertDayViewLog(page_id);
				this.updateDayViewLog(page_id);
			}
		}catch(Exception e){
			
		}
		
		
		/*=====================================*/		
		/*일자별 통계 기록*/
		/*=====================================*/
		
		/*우선 해당 날짜에 대한 로그가 있는지 검사한다.*/
		boolean Hourcheck = checkInsertHourViewLog(page_id);
		
		if(Hourcheck){
			
			/*이미 기록된 데이터가 있으면 카운터만 +1 시킨다*/
			this.updateHourViewLog(page_id);
			
		}else{
			
			/*오늘에 해당하는 데이터가 없으면 신규로 테이터를 삽입후 카운터 +1 시킨다.*/
			this.insertHourViewLog(page_id);
			this.updateHourViewLog(page_id);
		}
		
		/*=====================================*/
				
	}
	/*======================================================================================================*/
	public boolean checkInsertHourViewLog(String page_id){
		
		ReportDAO dao = new ReportDAO();
		ReportEntity enty = new ReportEntity();
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		
		boolean flag=false;
		String checkString = "";
		
		try {
			String query = "select page_id from PT_HOM_VIEW_HOUR_COUNT where REG_DATE = '"+Year+"-"+Month+"-"+Day+"' AND PAGE_ID = '"+page_id+"'";
			enty = dao.select(query);
			
			for(int i =0; i < enty.getRowCnt(); i++){
				checkString = enty.getValue(i, "PAGE_ID");
			}
			
			if(!KJFUtil.isEmpty(checkString)){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	/*======================================================================================================*/
	public void insertHourViewLog(String page_id){
		
		ReportDAO dao = new ReportDAO();
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		
		try {
			String query = "insert into PT_HOM_VIEW_HOUR_COUNT values('"+page_id+"', '"+Year+"-"+Month+"-"+Day+"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
			dao.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*======================================================================================================*/
	public void updateHourViewLog(String page_id){

		ReportDAO dao = new ReportDAO();
		
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		String Hour = KJFDate.getCurTime("HH");;
		
		try {
			String query = "update PT_HOM_VIEW_HOUR_COUNT set H_"+Hour+" = H_"+Hour+"+1, Day_Total =  Day_Total+1 where reg_date ='"+Year+"-"+Month+"-"+Day+"' and page_id ='"+page_id+"' ";
			dao.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*======================================================================================================*/
	public boolean checkInsertDayViewLog(String page_id){
		
		ReportDAO dao = new ReportDAO();
		ReportEntity enty = new ReportEntity();
		
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		
		boolean flag=false;
		String checkString = "";
		
		try {
			
			StringBuffer query = new StringBuffer("");
			query.append("SELECT PAGE_ID FROM PT_HOM_VIEW_DAY_COUNT WHERE REG_DATE = '")
			.append(Year+"-"+Month)
			.append("' AND PAGE_ID = '")
			.append(page_id)
			.append("'");
			enty = dao.select(query.toString());
			
			for(int i =0; i < enty.getRowCnt(); i++){
				checkString = enty.getValue(i, "PAGE_ID");
			}
			
			if(!KJFUtil.isEmpty(checkString)){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/*======================================================================================================*/
	public void insertDayViewLog(String page_id){
		
		ReportDAO dao = new ReportDAO();
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		
		try {
			String query = "insert into PT_HOM_VIEW_DAY_COUNT values ('" +page_id+"','" +Year+"-"+Month+"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
			dao.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*======================================================================================================*/
	public void updateDayViewLog(String page_id){
		
		ReportDAO dao = new ReportDAO();
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		
		try {
			
			String queryDay = "update PT_HOM_VIEW_DAY_COUNT set D_"+Day+" = D_"+Day+"+1, MONTH_TOTAL = MONTH_TOTAL+1 where REG_DATE = '"+Year+"-"+Month+"' AND PAGE_ID = '"+page_id+"'";
			dao.execute(queryDay);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	/*======================================================================================================*/
	public String SearchCODE(String URL){

		String CodeNum = "";
		ReportDAO dao = new ReportDAO();
		ReportEntity enty = new ReportEntity();
		
		
		StringBuffer query = new StringBuffer();
		/*  오라클 용*/
		query.append("SELECT CODE_GROUP||'-'||CODE AS CODENUM FROM PT_PAGE_CODE WHERE CODE_URL = '").append(URL).append("' AND CODE != '000' AND ROWNUM = 1 AND USE_YN='Y' ");
		
		/*  MYSQL 용*/
		//query.append("SELECT CODE_GROUP||'-'||CODE AS CODENUM FROM PT_PAGE_CODE WHERE CODE_URL = '").append(URL).append("' AND CODE != '000' AND USE_YN='Y' LIMIT 1");

		/*  MYSQL 용*/
		//query.append("SELECT TOP 1 CODE_GROUP+'-'+CODE AS CODENUM FROM PT_PAGE_CODE WHERE CODE_URL = '").append(URL).append("' AND CODE != '000' AND USE_YN='Y'");
		
		try {
			enty = dao.select(query.toString());
			for(int i = 0; i < enty.getRowCnt(); i++){
				
				CodeNum = enty.getValue(i,"CODENUM");	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return CodeNum ;
	}
	/*======================================================================================================*/
	public void insertVisit(){
	
		/*=====================================*/	
		boolean check_day = CHECK_VISIT_DAY_COUNT();

		if(check_day){
			
			/*이미 기록된 데이터가 있으면 카운터만 +1 시킨다*/
			this.UPDATE_VISIT_DAY_COUNT();
			
		}else{
			
			/*오늘에 해당하는 데이터가 없으면 신규로 테이터를 삽입후 카운터 +1 시킨다.*/
			this.INSERT_VISIT_DAY_COUNT();
			this.UPDATE_VISIT_DAY_COUNT();
		}
		
		/*=====================================*/
		boolean check_hour =CHECK_VISIT_HOUR_COUNT();
		
		if(check_hour){
			
			/*이미 기록된 데이터가 있으면 카운터만 +1 시킨다*/
			this.UPDATE_VISIT_HOUR_COUNT();
			
		}else{
			
			/*오늘에 해당하는 데이터가 없으면 신규로 테이터를 삽입후 카운터 +1 시킨다.*/
			this.INSERT_VISIT_HOUR_COUNT();
			this.UPDATE_VISIT_HOUR_COUNT();
		}
		/*=====================================*/

	}
	/*======================================================================================================*/
	public boolean CHECK_VISIT_DAY_COUNT(){
		
		String check = "";
		boolean flag = false;
		ReportDAO dao = new ReportDAO();
		ReportEntity enty = new ReportEntity();
		
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
				
		try {
			enty = dao.select("SELECT REG_DATE FROM PT_HOM_VISIT_DAY_COUNT WHERE REG_DATE='"+Year+"-"+Month+"' ");
			for(int i = 0; i < enty.getRowCnt(); i++){
				check = enty.getValue(i,"REG_DATE");
			}

			if(!KJFUtil.isEmpty(check)){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;		
	}
	/*======================================================================================================*/
	public void INSERT_VISIT_DAY_COUNT(){
		
		ReportDAO dao = new ReportDAO();
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		
		try {
			dao.execute("insert into PT_HOM_VISIT_DAY_COUNT values('"+Year+"-"+Month+"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*======================================================================================================*/
	public void UPDATE_VISIT_DAY_COUNT(){
		
		ReportDAO dao = new ReportDAO();
		/*기초 날짜 데이터*/
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		
		try{
			dao.execute("UPDATE PT_HOM_VISIT_DAY_COUNT SET D_"+Day+" = D_"+Day+" +1, MONTH_TOTAL = MONTH_TOTAL+1 WHERE REG_DATE ='"+Year+"-"+Month+"' ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*======================================================================================================*/
	public boolean CHECK_VISIT_HOUR_COUNT(){
		
		String check = "";
		boolean flag = false;
		ReportDAO dao = new ReportDAO();
		ReportEntity enty = new ReportEntity();
		
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		
		try {

			enty = dao.select("SELECT REG_DATE FROM PT_HOM_VISIT_HOUR_COUNT WHERE REG_DATE='"+Year+"-"+Month+"-"+Day+"' ");
			for(int i = 0; i < enty.getRowCnt(); i++){
				check = enty.getValue(i,"REG_DATE");
			}
			if(!KJFUtil.isEmpty(check)){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;		
	}
	/*======================================================================================================*/
	public void INSERT_VISIT_HOUR_COUNT(){
		
		ReportDAO dao = new ReportDAO();
		
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		
		try {
			dao.execute("INSERT INTO PT_HOM_VISIT_HOUR_COUNT VALUES ('"+Year+"-"+Month+"-"+Day+"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*======================================================================================================*/
	public void UPDATE_VISIT_HOUR_COUNT(){
		
		ReportDAO dao = new ReportDAO();
		
		String Year= KJFDate.getCurTime("yyyy");
		String Month = KJFDate.getCurTime("MM");
		String Day= KJFDate.getCurTime("dd");
		String Hour = KJFDate.getCurTime("HH");;
		
		try {
			dao.execute("UPDATE PT_HOM_VISIT_HOUR_COUNT SET H_"+Hour+" = H_"+Hour+"+1, DAY_TOTAL = DAY_TOTAL+1 WHERE REG_DATE = '"+Year+"-"+Month+"-"+Day+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getCurTime(String pattern) {
		if (KJFUtil.isEmpty(pattern)){
            pattern = "yyyy-MM-dd";
		}
		
		Date date = new java.util.Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, new Locale("ko","KOREA"));
		String result = formatter.format(date);

		return result;
	}
}
