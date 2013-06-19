package kjf.util;

import com.ibm.icu.util.Calendar ; 
import com.ibm.icu.util.ChineseCalendar ; 

/**
 * <p>system        : 기본적인 양음력간 변환 유틸함수</p>
 * <p>Description   : 기본적인 양음력간 변환 유틸함수를 구현하여 제공. </p>
 * @author 김경덕
 * @version 1.0 2003.05.29 <br/>
 */
public class LunarCalendar { 
    
   private Calendar cal ; 
   private ChineseCalendar cc ; 

   /** 
   *   양음력간 변환 
   * 
   *   사용법>> 
   *      LunarCalendar lc = new LunarCalendar() ; 
   *      String lunarDate = lc.toLunar("20021023") ; 
   *      String date = lc.fromLunar("20020918") ; 
   */ 
   public LunarCalendar() { 
      // default TimeZone, Locale 을 사용.. 
      cal = Calendar.getInstance() ; 
      cc = new ChineseCalendar(); 
   } 

   /** 
   *   양력(yyyyMMdd) -> 음력(yyyyMMdd) 
   * 
   */ 
   public synchronized String toLunar( String yyyymmdd , String sep) { 
      if(    yyyymmdd == null ) 
         return "" ; 

      String date = yyyymmdd.trim() ; 
      if( date.length() != 8 ) { 
         if( date.length() == 4 ) 
            date = date + "0101" ; 
         else if( date.length() == 6 ) 
            date = date + "01" ; 
         else if( date.length() > 8 ) 
            date = date.substring(0,8) ; 
         else 
            return "" ; 
      } 

      cal.set( Calendar.YEAR, Integer.parseInt(date.substring(0,4)) ) ; 
      cal.set( Calendar.MONTH, Integer.parseInt(date.substring(4,6))-1 ) ; 
      cal.set( Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(6)) ) ; 

      cc.setTimeInMillis( cal.getTimeInMillis() ) ; 

      // ChinessCalendar.YEAR 는 1~60 까지의 값만 가지고 , ChinessCalendar.EXTENDED_YEAR 는 Calendar.YEAR 값과 2637 만큼의 차이를 가집니다. 
      int y = cc.get(ChineseCalendar.EXTENDED_YEAR)-2637 ; 
      int m = cc.get(ChineseCalendar.MONTH)+1 ; 
      int d = cc.get(ChineseCalendar.DAY_OF_MONTH) ; 

      StringBuffer ret = new StringBuffer() ; 
      if( y < 1000 ) 
         ret.append( "0" ) ; 
      else if( y < 100 ) 
         ret.append( "00" ) ; 
      else if( y < 10 ) 
         ret.append( "000" ) ; 
      ret.append( y + sep) ; 

      if( m < 10 ) 
         ret.append( "0" ) ; 
      ret.append( m + sep) ; 

      if( d < 10 ) 
         ret.append( "0" ) ; 
      ret.append( d ) ; 

      return ret.toString() ; 
   } 


   /** 
   *   음력(yyyyMMdd) -> 양력(yyyyMMdd) 
   * 
   */ 
   public synchronized String fromLunar( String yyyymmdd, String sep ) { 
      if(    yyyymmdd == null ) 
         return "" ; 

      String date = yyyymmdd.trim() ; 
      if( date.length() != 8 ) { 
         if( date.length() == 4 ) 
            date = date + "0101" ; 
         else if( date.length() == 6 ) 
            date = date + "01" ; 
         else if( date.length() > 8 ) 
            date = date.substring(0,8) ; 
         else 
            return "" ; 
      } 

      cc.set( ChineseCalendar.EXTENDED_YEAR, Integer.parseInt(date.substring(0,4))+2637 ) ; 
      cc.set( ChineseCalendar.MONTH, Integer.parseInt(date.substring(4,6))-1 ) ; 
      cc.set( ChineseCalendar.DAY_OF_MONTH, Integer.parseInt(date.substring(6)) ) ; 

      cal.setTimeInMillis( cc.getTimeInMillis() ) ; 

      int y = cal.get(Calendar.YEAR) ; 
      int m = cal.get(Calendar.MONTH)+1 ; 
      int d = cal.get(Calendar.DAY_OF_MONTH) ; 

      StringBuffer ret = new StringBuffer() ; 
      if( y < 1000 ) 
         ret.append( "0" ) ; 
      else if( y < 100 ) 
         ret.append( "00" ) ; 
      else if( y < 10 ) 
         ret.append( "000" ) ; 
      ret.append( y + sep) ; 

      if( m < 10 ) 
         ret.append( "0" ) ; 
      ret.append( m + sep) ; 

      if( d < 10 ) 
         ret.append( "0" ) ; 
      ret.append( d ) ; 

      return ret.toString() ; 
   } 

   public static void main(String args[]){ 
      LunarCalendar lc = new LunarCalendar() ; 

      System.out.println("2003년 4월 29일에 대한 음력날짜는 아래와 같습니다."); 
      System.out.println( lc.toLunar("20030429", "") ) ; // 양력을 음력으로 바꾸기 

      System.out.println("2007년 1월 1일에 대한 양력날짜는 아래와 같습니다."); 
      System.out.println( lc.fromLunar("20070101", "-").substring(5) ) ; // 2003년 4월 29일에 대한 음력날짜를 집어넣는다. 
   } // end class 
} // end 
