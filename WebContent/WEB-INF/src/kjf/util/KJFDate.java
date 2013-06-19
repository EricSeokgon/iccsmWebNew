package kjf.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

/**
 * <p>Subsystem		:  </p>
 * <p>Title			: 기본적인 유틸함수 </p>
 * <p>Description	: 기본적인 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE		: </p>
 * @author 김경덕
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFDate {

     /**
      * 날짜 입력을 문자열(년-월-일 시:분:초 1000/1 초)로 변환하여 반환 
      * @param d
      * @return String
      */
     public static String date(Date d){
        if(d == null) return null;
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return smf.format(d);
     }

     /**
      * 날짜 입력을 문자열(년-월-일)로 변환하여 반환
      * @param d
      * @return String
      */
     public static String dateOnly(Date d){
        if(d == null) return null;
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        return smf.format(d);
     }

     /**
      * 날짜 입력을 문자열(년-월-일 시:분:초)로 변환하여 반환
      * @param d
      * @return String
      */
     public static String datetimeOnly(Date d){
        if(d == null) return null;
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return smf.format(d);
     }

     /**
      * 날짜 입력을 문자열(년-월-일 시:분:초)로 변환하여 반환
      * @return String
      */
     public static String getCurDatetime(){
         SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return smf.format(new java.util.Date());
     }

     /**
      * 날짜 입력을 문자열을 패턴에 맞게 변환하여 반환
      * @param d Date
      * @param pattern String
      * @return String
      */
     public static String getTimeAsPattern(Date d, String pattern) {
        if(d == null) return null;

       if (KJFUtil.isEmpty(pattern)){
            pattern = "yyyy-MM-dd";
		}

        SimpleDateFormat smf = new SimpleDateFormat(pattern, new Locale("ko","KOREA"));
        return smf.format(d);
     }

    /**
     * 패턴에 따른 현재시간을 반환
     * @param pattern
     * @return String
     */
	public static String getCurTime(String pattern) {
		if (KJFUtil.isEmpty(pattern)){
            pattern = "yyyy-MM-dd";
		}

		Date date = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat(pattern, new Locale("ko","KOREA"));
		String result = formatter.format(date);

		return result;
	}
	
	/**
	 * 현재시간을 java.util.Date 반환
	 * @return Date
	 */
	public static java.util.Date getCurTime() {

		return new java.util.Date();
	}

	/**
	 * 날짜및 시간 : 문자열 입력을 Date(java.util) 변환하여 반환
	 * @param s String
	 * @param pattern String
	 * @return Date
	 */
    public static Date str2date(String s , String pattern){
	    if(s == null || s.equals("")) return null;

	    if (KJFUtil.isEmpty(pattern)){
	        pattern = "yyyy-MM-dd";
		}

	    try {
			SimpleDateFormat smf = new SimpleDateFormat(pattern);
			return smf.parse(s, new ParsePosition(0));
		} catch (Exception e) {
			return null;
		}
	 }

	 /**
	  * 날짜및 시간 : 문자형식의 날짜를  입력 받아 특정 형태의 패턴으로 변환.
	  * @param s String
	  * @param dateFormat String
	  * @param pattern String
	  * @return String
	  */
	 public static String getChangDatePattern(String s , String dateFormat, String pattern){
	    if(s == null || s.equals("")) return null;

	    if (KJFUtil.isEmpty(pattern)){
	        pattern = "yyyy-MM-dd";
		}

	    try {
			SimpleDateFormat smf = new SimpleDateFormat(dateFormat);
			return getTimeAsPattern(smf.parse(s),pattern);
		} catch (Exception e) {
			return null;
		}
	 }

	 /**
	  * 날짜및 시간 : 문자형식의 date를  입력 받아 년월일만 잘라서 반환.
	  * @param date String
	  * @return String
	  */
	 public static String cutStrDate(String date){
	    if(date == null || date.equals("") || date.length()<10) return date;
	    return date.substring(0, 10);
	 }
	 
	  /**
	   * 날짜 차이 구하기
	   * @param s1 String
	   * @param s2 String
	   * @return int
	   */
	  public static int getDaysDiff(String s1, String s2) {
	    int y1 = getDaysFrom21Century(s1);
	    int y2 = getDaysFrom21Century(s2);
	    return y1 - y2;
	  }
	  
	  /**
	   * 2000년 1월 1일 부터 지정한 년, 월, 일 까지의 날짜 수를 구한다.<br>
       * 2000년 1월 1일 이전의 경우에는 음수를 리턴한다.
	   * @param s String
	   * @return int
	   */
	  public static int getDaysFrom21Century(String s) {
	    int d, m, y;
	    if (s.length() == 8) {
	        y = Integer.parseInt(s.substring(0, 4));
	        m = Integer.parseInt(s.substring(4, 6));
	        d = Integer.parseInt(s.substring(6));
	        return getDaysFrom21Century(d, m, y);
	    }
	    else if (s.length() == 10) {
	        y = Integer.parseInt(s.substring(0, 4));
	        m = Integer.parseInt(s.substring(5, 7));
	        d = Integer.parseInt(s.substring(8));
	        return getDaysFrom21Century(d, m, y);
	    }
	    else if (s.length() == 11) {
	        d = Integer.parseInt(s.substring(0, 2));
	        String strM = s.substring(3, 6).toUpperCase();
	        String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
	                                "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	        m = 0;
	        for (int j = 1; j <= 12; j++) {
	            if (strM.equals(monthNames[j-1])) {
	                m = j;
	                break;
	            }
	        }
	        if (m < 1 || m > 12)
	            throw new RuntimeException("Invalid month name: " + strM + " in " + s);
	        y = Integer.parseInt(s.substring(7));
	        return getDaysFrom21Century(d, m, y);
	    }
	    else
	        throw new RuntimeException("Invalid date format: " + s);
	  }
	  
	  /**
	   * 지정한 년도, 지정한 월의 총 날짜 수를 구한다.
	   * @param m int
	   * @param y int
	   * @return int
	   */
	  public static int getDaysInMonth(int m, int y) {
	    if (m < 1 || m > 12)
	        throw new RuntimeException("Invalid month: " + m);

	    int[] b = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    if (m != 2 && m >= 1 && m <= 12 && y != 1582)
	        return b[m - 1];
	    if (m != 2 && m >= 1 && m <= 12 && y == 1582)
	        if (m != 10)
	            return b[m - 1];
	        else
	            return b[m - 1] - 10;

	    if (m != 2)
	        return 0;

	    // m == 2 (즉 2월)
	    if (y > 1582) {
	        if (y % 400 == 0)
	            return 29;
	        else if (y % 100 == 0)
	            return 28;
	        else if (y % 4 == 0)
	            return 29;
	        else
	            return 28;
	    }
	    else if (y == 1582)
	        return 28;
	    else if (y > 4) {
	        if (y % 4 == 0)
	            return 29;
	        else
	            return 28;
	    }
	    else if (y > 0)
	        return 28;
	    else
	        throw new RuntimeException("Invalid year: " + y);
	  }


	  /**
	   * 지정한 년도의 지정한 월의 첫날 부터 지정한 날 까지의 날짜 수를 구한다.
	   * @param d int
	   * @param m int
	   * @param y int
	   * @return int
	   */
	  public static int getDaysFromMonthFirst(int d, int m, int y) {
	    if (m < 1 || m > 12)
	        throw new RuntimeException("Invalid month " + m + " in " + d + "/" + m + "/" + y);

	    int max = getDaysInMonth(m, y);
	    if (d >= 1 && d <= max)
	        return d;
	    else
	        throw new RuntimeException("Invalid date " + d + " in " + d + "/" + m + "/" + y);
	  }
	  
	  /**
	   * 지정한 년도의 첫날 부터 지정한 월의 지정한 날 까지의 날짜 수를 구한다. 
	   * @param d int
	   * @param m int
	   * @param y int
	   * @return int
	   */
	  public static int getDaysFromYearFirst(int d, int m, int y) {
	    if (m < 1 || m > 12)
	        throw new RuntimeException("Invalid month " + m + " in " + d + "/" + m + "/" + y);

	    int max = getDaysInMonth(m, y);
	    if (d >= 1 && d <= max) {
	        int sum = d;
	        for (int j = 1; j < m; j++)
	            sum += getDaysInMonth(j, y);
	        return sum;
	    }
	    else
	        throw new RuntimeException("Invalid date " + d + " in " + d + "/" + m + "/" + y);
	  }

	  /**
	   * 문자형식의 날짜를  입력 받아 특정 형태의 패턴으로 변환
	   * @param format String
	   * @param dateString String
	   * @return String
	   */
	  public static String getDateFormat(String format , String dateString) {
	    SimpleDateFormat sd = new SimpleDateFormat( format );
	    String rtValue = null;
	    try{
	         Date d = sd.parse( dateString );
	         rtValue = sd.format( d );
	    }catch( ParseException e ){}
	    return rtValue;
	  }
	  
	  /**
	   * 지정한 년도의 첫날 부터 지정한 월의 지정한 날 까지의 날짜 수를 구한다.
	   * @param s String
	   * @return int
	   */
	  public static int getDaysFromYearFirst(String s) {
	    int d, m, y;
	    if (s.length() == 8) {
	        y = Integer.parseInt(s.substring(0, 4));
	        m = Integer.parseInt(s.substring(4, 6));
	        d = Integer.parseInt(s.substring(6));
	        return getDaysFromYearFirst(d, m, y);
	    }
	    else if (s.length() == 10) {
	        y = Integer.parseInt(s.substring(0, 4));
	        m = Integer.parseInt(s.substring(5, 7));
	        d = Integer.parseInt(s.substring(8));
	        return getDaysFromYearFirst(d, m, y);
	    }
	    else if (s.length() == 11) {
	        d = Integer.parseInt(s.substring(0, 2));
	        String strM = s.substring(3, 6).toUpperCase();
	        String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
	                                "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	        m = 0;
	        for (int j = 1; j <= 12; j++) {
	            if (strM.equals(monthNames[j-1])) {
	                m = j;
	                break;
	            }
	        }
	        if (m < 1 || m > 12)
	            throw new RuntimeException("Invalid month name: " + strM + " in " + s);
	        y = Integer.parseInt(s.substring(7));
	        return getDaysFromYearFirst(d, m, y);
	    }
	    else
	        throw new RuntimeException("Invalid date format: " + s);
	  }
	  
	  /**
	   * 2000년 1월 1일 부터 지정한 년, 월, 일 까지의 날짜 수를 구한다.
       * 2000년 1월 1일 이전의 경우에는 음수를 리턴한다. 
	   * @param d int
	   * @param m int
	   * @param y int
	   * @return int
	   */
	  public static int getDaysFrom21Century(int d, int m, int y) {
	    if (y >= 2000) {
	        int sum = getDaysFromYearFirst(d, m, y);
	        for (int j = y - 1; j >= 2000; j--)
	            sum += getDaysInYear(j);
	        return sum - 1;
	    }
	    else if (y > 0 && y < 2000) {
	        int sum = getDaysFromYearFirst(d, m, y);
	        for (int j = 1999; j >= y; j--)
	             sum -= getDaysInYear(y);
	        return sum - 1;
	    }
	    else
	        throw new RuntimeException("Invalid year " + y + " in " + d + "/" + m + "/" + y);
	  }
	  
	 /**
	  * 지정한 년도의 총 날짜 수를 구한다.
	  * @param y int
	  * @return int
	  */
	  public static int getDaysInYear(int y) {
	    if (y > 1582) {
	        if (y % 400 == 0)
	            return 366;
	        else if (y % 100 == 0)
	            return 365;
	        else if (y % 4 == 0)
	            return 366;
	        else
	            return 365;
	    }
	    else if (y == 1582)
	        return 355;
	    else if (y > 4) {
	        if (y % 4 == 0)
	            return 366;
	        else
	            return 365;
	    } 
	    else if (y > 0)
	        return 365;
	    else
	        return 0;
	  }
	  
	  /**
       * new 표시 관련 날짜 구하기
       * 
       * @return intNewDay String
       * @return inDate    String
       * @throws Exception
       */
      public static boolean isNew(int intNewDay, String inDate) throws Exception {
        
          Date mydate = new Date();   // 시스템 날짜를 사용할  mydate객체 생성
          Date indate = new Date();   // 게시물에 등록일을  사용할 indate객체 생성
        
          String today   = "";   // 오늘 날짜 
          String in_date = "";   // 등록 일자             
        
          // 출력 형태를 가지고 있는 객체를 생성
          SimpleDateFormat myToday = new SimpleDateFormat("yyyy-MM-dd");        
        
          indate = str2date(inDate, "yyyy-MM-dd");
        
          today   = myToday.format(mydate);
          in_date = myToday.format(indate);           
        
          // 등록일이 NEW_DAY일 이하 인경우 NEW 표시 
          if ( intNewDay >= KJFDate.getDaysDiff(today, in_date)) {
              return true;
            
          } else {
              return false;
          }
      }
      
    /**
     *  입력한 년월일의 익월 구하는 함수
     *  getNextMonthDay(200601) ==> 200602
     * @param sThisYmd
     * @return
     */
     public static String getNextMonthDay (String sThisYm)  {
            
         if(sThisYm == null || sThisYm.equals("")) return sThisYm;
         
         String sNextYm  = "";    // 다음 년월
        
         try {
             
             // 년월은 6자리(YYYYMM)를 입력해야 한다...
             if ( sThisYm.length() != 6 ) {
                 return sNextYm;
             }
             
             int iThisYear  = Integer.parseInt(sThisYm.substring(0, 4));
             int iThisMonth = Integer.parseInt(sThisYm.substring(4, 6));
            
             if ( iThisMonth == 12 ) {
                sNextYm = (iThisYear + 1) + "01";
                
             } else {
                sNextYm = sThisYm.substring(0, 4) + getFillZero(String.valueOf(iThisMonth + 1), 2);
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        
         return sNextYm;
     }
     
     /**
      * 입력한 년월의 00.00형식으로 포멧
      * 
      * @param s
      * @return
      */
     public static String getYearMonthForm(String s) {
         
         if(s == null || s.equals("")) return s;
         
         // 년월은 6자리(YYYYMM)를 입력해야 한다...
         if ( s.length() != 6 ) {
             return s;
         }
         
         return s.substring(2, 4) + "." +  s.substring(4, 6);
     }
     

     /**
      * 숫자앞에 입력한 자리수 만큼 0을 붙여주는 함수
      * getFillZero("1",2) ==> 01
      * 
      * @param sInput
      * @param iCount
      * @return
      */
     public static String getFillZero(String sInput, int iCount) {
            
         if(sInput == null || sInput.equals("")) return sInput;
         
         String strTemp = sInput.trim();
         
         int iLen = strTemp.length();
         
         int iRemain = iCount - iLen;
            
         if(iRemain > 0) {
             for(int j = 0; j < iRemain; j++) { 
                 strTemp = "0" + strTemp;
             }
         }
         
         return strTemp;
     }
     
     
     /**
	   * 특정 일에서 지정한 날수만큼 이전 이후의 날짜를 지정한 포맷으로 반환한다.
	   * @param initDate
	   * @param amountDate
	   * @param dataFormat
	   * @return
	   */
	  public static String getDateInitAdd(String initDate, int amountDate, String dataFormat) {
		  int d=0, m=0, y = 0;
		  
		  if (initDate.length() == 8) {
			  y = Integer.parseInt(initDate.substring(0, 4));
		      m = Integer.parseInt(initDate.substring(4, 6)) - 1;
		      d = Integer.parseInt(initDate.substring(6));
		      
		  }
		  else if (initDate.length() == 10) {
		      y = Integer.parseInt(initDate.substring(0, 4));
		      m = Integer.parseInt(initDate.substring(5, 7)) - 1;
		      d = Integer.parseInt(initDate.substring(8));
		      
		  }
		  
		  Calendar cal = Calendar.getInstance(); 
		  
		  cal.set(y, m, d);
		  
		  cal.add(cal.DATE, amountDate);
		  
		  String rdate = getTimeAsPattern(cal.getTime(), dataFormat);
		  
		  return rdate;		  

	  }
	  


	  /**
	  * 입력한 날짜가 공유일인지 검사를 한다.
	  * 공휴일인 경우에는 경고창 후 멈춘다.
	  * 입력형식 : 2004년 3월 1일 --> 20040301
	  *
	  * @param string
	  */
	 public static boolean isHoliday(String yyyymmdd ) {
	  // 검사년도
	  String yyyy = yyyymmdd.substring( 0, 4 );
	  String [] holidays = new String[16];
	  
	  LunarCalendar lc = new LunarCalendar() ;
	  
	  // 음력 공휴일을 양력으로 바꾸어서 입력
	  int tmp01 = KJFUtil.str2int(lc.fromLunar( yyyy + "0101" ,""));// 음력설날
	  int tmp02 = KJFUtil.str2int(lc.fromLunar( yyyy + "0815" ,""));// 음력추석
	  
	  holidays[0] = Integer.toString(tmp01 - 1); // 음력설 첫째날
	  holidays[1] = Integer.toString(tmp01);   // 음력설 둘째날
	  holidays[2] = Integer.toString(tmp01 + 1); // 음력설 셋째날
	  holidays[3] = Integer.toString(tmp02 - 1); // 추석 첫째날
	  holidays[4] = Integer.toString(tmp02);   // 추석 둘째날
	  holidays[5] = Integer.toString(tmp02 + 1); // 추석 셋째날 
	  holidays[6] = lc.fromLunar( yyyy + "0408","" ); // 석가탄신일

	  // 양력 공휴일 입력
	  holidays[7] = yyyy + "0101";  // 양력설날
	  holidays[8] = yyyy + "0301";  // 삼일절
	  holidays[9] = yyyy + "0405";  // 식목일
	  holidays[10] = yyyy + "0505";  // 어린이날
	  holidays[11] = yyyy + "0606";  // 현충일
	  holidays[12] = yyyy + "0717";  // 제헌절
	  holidays[13] = yyyy + "0815";  // 광복절
	  holidays[14] = yyyy + "1003";  // 개천절
	  holidays[15] = yyyy + "1225";  // 성탄절

	  for ( int i=0; i<holidays.length ; i++ ) {
		  if ( yyyymmdd.equals(holidays[i])) {
			  return true ;
		  } 
	  }
	  return false;
	 }
	 

	 /**
	   * 주말인 검사한다.
	   * 입력형식 : 2004년 3월 1일 --> 20040301
	   * weekChk : 0 일요일 제외, 6 토요일 제외, 60 토/일 제외
	   * 주말이면 false반환
	   * @param string
	   * @return boolean
	 * @throws ParseException 
	   */
	  public static boolean isWeekend(String yyyymmdd, int weekChk )  {
	   String yyyy = yyyymmdd.substring( 0, 4 );
	   String mm  = yyyymmdd.substring( 4, 6 );
	   String dd  = yyyymmdd.substring( 6, 8 );
	  
	   SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
	   
	   try {
		   Date weekdate = df.parse(yyyy+"-"+mm+"-"+dd);
		   if (weekChk == 60){
			   if ( weekdate.getDay() == 6 || weekdate.getDay() == 0 ) {
				    return true;
			   }
		   } else {
			   if ( weekdate.getDay() == weekChk ) {
				    return true;
			   }
		   }
	   }catch(ParseException pe){
		    pe.printStackTrace();
			return false;
	   }
	   return false;
	  }
	 
	  /**
	   * 입력한 날짜가  일요일, 공휴일인지 검사를 한다.
	   * 입력형식 : 2004년 3월 1일 --> 20040301
	   * weekChk : 토요일, 일요일, 토요일+일요일 제외 기준
	   * @param string
	   */
	  
	  
	  public static boolean isHolidayWeekendCheck(String yyyymmdd, int weekChk ) {
		  if ( isHoliday( yyyymmdd ) || isWeekend( yyyymmdd, weekChk ) ) {	    
			  return true; 
		  }
		  
	      return false; 
	  }
	  
	  /**
	   * 입력한 날자를 기준으로 (공유일/주말 제외한) 입력 이후의 날자 가져오기
	   * 입력형식 : 2004년 3월 1일 --> 20040301
	   * inDate: 현재 기준일
	   * count : count일 이후의 날자 기준
	   * weekChk : 6 토요일, 0 일요일, 60 토요일+일요일 제외 기준
	   * insToDay : div 당일제외, add 당일 포함 
	   * @param string
	   */
	  
	 public static String fromDayAfter(String inDate, int count, int weekChk, String insToDay){
		//KJFDate kDate = new KJFDate(); //일요일, 공휴일 체크
    	//String startDate = kDate.getCurDatetime().replace("-","").substring(0,8);
    	String startDate = inDate.substring(0,8);
    	int yDay = KJFUtil.str2int(startDate.substring(0,4));
    	int hDate = yDay + 10;		
    	String msDay = "";
    	int mDay = 0;

    	String eDate = Integer.toString(hDate)+startDate.substring(4,8);	

    	int chkDay = 0;
    	int Days = 0;
    	
    	String endDate = "";
    	int initDate = KJFUtil.str2int(startDate);
    	int i = 0;
    	
    	if ( "div".equals(insToDay)){
        	//count = count + 1;
        } else {
    		initDate = initDate - 1;
        }
    	
   		for (i = initDate; i <= KJFUtil.str2int(eDate); i++){
    		yDay = KJFUtil.str2int(Integer.toString(i).substring(0,4));
    		mDay = KJFUtil.str2int(Integer.toString(i).substring(4,6));
	    	msDay = Integer.toString(i).substring(4,6);
	    	
	    	//int lastDay = kDate.getDaysInMonth(mDay,yDay);
	    	int lastDay = getDaysInMonth(mDay,yDay);

    		//if (!kDate.isHolidayWeekendCheck(Integer.toString(i))){
	    	if (!isHolidayWeekendCheck(Integer.toString(i), weekChk)){
        		chkDay = KJFUtil.str2int(Integer.toString(i).substring(6,8));
        		if ((chkDay == lastDay) && (mDay >= 12)){ //년도 변경
        			i = KJFUtil.str2int(yDay + "0101")+10000;
        		} else if ((chkDay == lastDay) && (mDay <= 11)){//월변경        			
        			i = KJFUtil.str2int(yDay + msDay + "01")+100;        			
        		}        		
        		Days = Days + 1;
    		}    


	    	if (Days == count){
	    			endDate = Integer.toString(i);
	    			break;
	    	}
	    	
    	}
    	//System.out.println("시작일="+startDate+"일수"+Days+"종료일="+endDate);    	
    	return endDate;
	 }
	 
    public static String getDateForm(String s) {
         
         if(s == null || s.equals("")) return s;
         
         // 년월은 6자리(YYYYMMDD)를 입력해야 한다...
         if ( s.length() != 8 ) {
             return s;
         }
         
         return s.substring(0, 4) + "-" +  s.substring(4, 6) + "-" +  s.substring(6, 8);
     }
	 
    /**
     * 날짜 입력을 문자열(년-월-일)로 변환하여 반환
     * @param d
     * @return String
     */
    public static String dateType(Date d){
       if(d == null) return null;
       SimpleDateFormat smf = new SimpleDateFormat("yyyy년 MM월 dd일");
       return smf.format(d);
    }
   
    /**
     * 날짜 입력을 문자열(년-월-일)로 변환하여 반환
     * @param d
     * @return String
     */
    public static String getDateForm2(String s){
        if(s == null || s.equals("")) return s;
        
        // 년월은 6자리(YYYYMMDD)를 입력해야 한다...
        if ( s.length() != 8 ) {
            return s;
        }
        
        return s.substring(0, 4) + "/" +  s.substring(4, 6) + "/" +  s.substring(6, 8);
    }
    
}
