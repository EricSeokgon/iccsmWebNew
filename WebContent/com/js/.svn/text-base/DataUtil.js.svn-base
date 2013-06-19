//===================================================================
// DateUtil
//===================================================================
// DateCmp(date1, date2)
// date_Format(ymd, formatmask)
// date_FormatYM(ym, formatmask)
// format_YYYYMM(object)
// format_YYYYMMDD(object)
// getCurrentTime()
// getDay()
// getDayInterval(time1,time2)
// getHour()
// getHourInterval(time1,time2)
// getMMDD( separator)
// getMonth()
// getMonthInterval(time1,time2)
// getRelativeTime(y,m,d,h)
// getYear()
// getYYYYMM( separator)
// getYYYYMMDD( separator)
// isDate(y,m,d)
// isDateYM(ym)
// isDateYMD(ymd)
// isDateYYYY(yyyy)
// isDateYYYYMM( yyyymm )
// isFormatDate(ymd, formatmask)
// isFormatDateYM(ym, formatmask)
// isFutureTime(time)
// isPastTime(time)
// isValidDay(yyyy, mm, dd)
// isValidHour(hh)
// isValidMin(mi)
// isValidMonth(mm)
// isValidTime(time)
// isValidTimeFormat(time)
// isYM(y,m)
// isYunNyun(y)
// shiftTime(time,y,m,d,h)
// toTimeObject(time)
// toTimeString(date)
// offMoneyFormat( obj ) 
// onMoneyFormat( obj )
// cala_day(year, month, day)
// cala_weekday( x_nMonth, x_nDay, x_nYear)
// day_display(x_nDayOfWeek)

/////////////////////////////////////////////////////
function isValidMonth(num) {
/////////////////////////////////////////////////////
//유효한(존재하는) 월(月)인지 체크
    if(num == "") return;
 try{
  //object.value = object.value.replace(/./gi,'');
  if(isNaN(num)) { 
   throw Exception;
  }
  var m = parseInt(num,10);
  if(! (m >= 1 && m <= 12)){
   throw Exception;
  }
  if(num.length == 1){
   num = "0"+num;
  }
 }catch(Exception){
  window.alert("월 입력 오류입니다.");
  num="";
  num.focus();
 }
}


/////////////////////////////////////////////////////
function isValidMonthCheck(num) {
/////////////////////////////////////////////////////
//입력된 문자열이 유효한 월(月)인지 체크, 여부리턴
    if(num == "" || num == null)
  return false;

 if(isNaN(num)) { 
  return false;
 }

 var m = parseInt(num,10);
 
 if(! (m >= 1 && m <= 12)) {
  return false;
 }

 return true;
}


/////////////////////////////////////////////////////
function isValidDay(yyyy, mm, dd) {
/////////////////////////////////////////////////////
//유효한(존재하는) 일(日)인지 체크
    var m = parseInt(mm,10) - 1;
    var d = parseInt(dd,10);

    var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
        end[1] = 29;
    }

    return (d >= 1 && d <= end[m]);
}


/////////////////////////////////////////////////////
function getCurrentTime() {
/////////////////////////////////////////////////////
// 현재 시각을 Time 형식으로 리턴
    return toTimeString(new Date());
}

/////////////////////////////////////////////////////
function getYear() {
/////////////////////////////////////////////////////
// 현재 年을 YYYY형식으로 리턴
    return getCurrentTime().substr(0,4);
}

/////////////////////////////////////////////////////
function getMonth() {
/////////////////////////////////////////////////////
// 현재 月을 MM형식으로 리턴
    return getCurrentTime().substr(4,2);
}

/////////////////////////////////////////////////////
function getDay() {
/////////////////////////////////////////////////////
// 현재 日을 DD형식으로 리턴
    return getCurrentTime().substr(6,2);
}

/////////////////////////////////////////////////////
function getYYYYMM( separator) {
/////////////////////////////////////////////////////
// 현재 年月을 separator 로 구분하여 리턴
    return getYear() + separator + getMonth();
}


/////////////////////////////////////////////////////
function getMMDD( separator) {
/////////////////////////////////////////////////////
// 현재 月日을 separator 로 구분하여 리턴
    return getMonth() + separator + getDay();
}


/////////////////////////////////////////////////////
function getYYYYMMDD( separator) {
/////////////////////////////////////////////////////
// 현재 年月日을 separator 로 구분하여 리턴
    return getYear() + separator + getMonth() + separator + getDay();
}

/////////////////////////////////////////////////////
function getHour() {
/////////////////////////////////////////////////////
// 현재 時를 HH형식으로 리턴
    return getCurrentTime().substr(8,2);
}

/////////////////////////////////////////////////////
function format_YYYYMM(object) {
/////////////////////////////////////////////////////
/**
 * 연월(YYYYMM)의 유효성을 체크하고 표준 날짜 포맷 (YYYY/MM) 으로 변환하여 리턴
 * (주의 : 이 함수의 파라미터는 객체임 (input object))
 */
    var num, year, month;
    num=object.value;   
    while (num.search("/") != -1) { 
  num = num.replace("/","");
 }
 if (isNaN(num)) {        
     window.alert("숫자로만 작성하셔야 합니다.");
  object.focus();
  return "";
 }  
    if( num != 0 && (num.length >= 5 && num.length <= 6)) {
        year = num.substring(0,4);
        month = num.substring(4);
        if (isValidMonthYYYYMM(object, month)==false){
            alert("월을 다시 한번 확인하시고 입력해 주세요.");
          object.focus();
          return "";
        }
        if (num.length==6) {
         num = year+"/"+month;
        } else if (num.length==5) { 
         num = year+"/"+"0"+month;
        } 
    } else {
        num = "";
  window.alert("년월을 다시 한번 확인하시고 입력해 주세요.");
  object.focus();
        return "";
    } 
    return num;
}

/////////////////////////////////////////////////////
function isValidMonthYYYYMM(object, num) {
/////////////////////////////////////////////////////
//유효한(존재하는) 월(月)인지 체크 -- format_YYYYMM 에서만 사용
    if(num == "") return false;
 if(isNaN(num)) { 
  return false;
 }

 var m = parseInt(num,10);
 if(! (m >= 1 && m <= 12)){
  return false;
 } 
}

/////////////////////////////////////////////////////
function format_YYYYMMDD(object) {
/////////////////////////////////////////////////////
// 연월일(YYYYMMDD)의 유효성을 체크하고 표준 날짜 포맷 (YYYY/MM/DD) 으로 변환하여 리턴 (주의 : 이 함수의 파라미터는 객체임 (input object))

    var num, year, month, day;
    num=object.value;
    
    while (num.search("/") != -1){ 
      num = num.replace("/","");
 }
 
 if (isNaN(num)) {        
     window.alert("숫자로만 작성하셔야 합니다");
     object.focus();
     return "";
 }
    if( num != 0 && num.length == 8 ) {
        year = num.substring( 0, 4 );
        month = num.substring( 4, 6 );  
        day = num.substring(6);
        if(isValidDay(year,month,day)==false) {
         num = "";
         window.alert("유효하지 않는 일자입니다. 다시 한번 확인하시고 입력해 주세요.");
         object.focus();
         return "";
  }          
        num = year+"/"+month + "/" + day;
    } 
    else {
        num = "";
        window.alert("날짜 입력형식 오류입니다. 다시 한번 확인하시고 입력해 주세요.");
        object.focus();
        return "";
    } 
    return num;
}
/////////////////////////////////////////////////////
function format_YYYYMMDDHHMM(object) {
/////////////////////////////////////////////////////

    var num, year, month, day;
    num=object.value;
    
    while (num.search("/") != -1){ 
      num = num.replace("/","");
      num = num.replace(":","");
      num = num.replace(" ","");
 }
  
  if (isNaN(num)) {        
      window.alert("숫자로만 작성하셔야 합니다");
      object.focus();
      return "";
  }
   
    if( num != 0 && num.length == 12 ) {
        year = num.substring( 0, 4 );
        month = num.substring( 4, 6 );  
        day = num.substring(6,8);
  if(isValidDay(year,month,day)==false) {
         num = "";
         window.alert("유효하지 않는 일자입니다. 다시 한번 확인하시고 입력해 주세요.");
         object.focus();
         return "";
  }          
  hh = num.substring(8,10);
  if(isValidHour(hh)==false) {
         num = "";
         window.alert("유효하지 않는 시간입니다. 다시 한번 확인하시고 입력해 주세요.");
         object.focus();
         return "";
  }
  mm = num.substring(10,12);
  if(isValidMin(mm)==false) {
         num = "";
         window.alert("유효하지 않는 분입니다. 다시 한번 확인하시고 입력해 주세요.");
         object.focus();
         return "";
  }
  
        num = year+"/"+month + "/" + day+" "+hh+":"+mm;
    } 
    else {
        num = "";
        window.alert("날짜 입력형식 오류입니다. 다시 한번 확인하시고 입력해 주세요.");
        object.focus();
        return "";
    } 
    return num;
}


/////////////////////////////////////////////////////
function isDate(y,m,d)
/////////////////////////////////////////////////////
{
 var yy,mm,dd;

// if (!isNumber(y) || !isNumber(m) || !isNumber(d)) return false;
 yy = parseInt(y, 10);
 mm = parseInt(m, 10);
 dd = parseInt(d, 10);

 if (yy < 1900 || yy > 2200 ) return false;

 if (mm < 1 || mm > 12) return false;
 if (dd < 1) return false;
 if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm==10 || mm==12)
 {
  if (dd > 31) return false;
 }
 else if (mm==2)
 {
  if (isYunNyun(yy))
  {
   if (dd > 29) return false;
  }
  else {
   if (dd > 28) return false;
  }

 }
 else if (dd > 30) return false;
 return true;
}

/////////////////////////////////////////////////////
function isYM(y,m){
/////////////////////////////////////////////////////
// 날짜인지 체크 (년, 월)

 var yy,mm;
 if (!isNumber(y) || !isNumber(m)) return false;
 yy = parseInt(y, 10);
 mm = parseInt(m, 10);

 if (yy < 1900 ) return false;

 if (mm < 1 || mm > 12) return false;
 
 return true;
}

//=============================================================================
// Function  : setDateFormat(obj, index, obj2)
// Parameter : Obj     현재의 입력 객체      
//      index   객체의 인텍스 
//      obj2    타겟객체 
// Return    : NONE
// 기능      : 날짜format을 check  하고 두번째 객체의 값으로 할당한다.
//      obj[index]의 값을 yyyy/mm/dd 형식으로 변경하고 원래 입력값은 obj2[index]의 value로 할당한다.
//=============================================================================
function setDateFormat(obj, index, obj2) {
    val = delChar(obj.value, '/'); //comma filtering
    obj.value = val;
    
    a = isNumber(obj);
    var no = "";
    if (a == 1) {        
        if (obj2.length == "undefined" || obj2.length == null) {
            obj2.value = "";
        } else {
            obj2[index].value = "";
        }        
        return;
    }

    val = obj.value;
    len = val.length;
    
    if (len == 6) {
  no = format_YYYYMM(obj);  
 } else if (len == 8) {
  no = format_YYYYMMDD(obj);  
 }
        
 if (no == "") {
  obj.value = no;
 }
            
 if (obj2.length == "undefined" || obj2.length == null) {
  obj2.value = obj.value;
 } else {
  obj2[index].value = obj.value;
 }
 obj.value = no;
}


/////////////////////////////////////////////////////
function date_FormatYM(ym, formatmask){
/////////////////////////////////////////////////////
 // 날짜인지 체크 (년, 월)
 
  var fcount = formatmask.length;
  var len = trim(ym).length;
 var rv = "";
 ym = trim(ym);

 if (len == 6)
 {
  if (ym.substring(4, 5) == "/")
  {
   return  ym;
  }

  y = ym.substring(0, 4);
  m = ym.substring(4, 6);
 }
 else if (len == 7)
 {
  if (ym.substring(4, 5) != "/")
  {
   return  -1;
  }
  y = ym.substring(0, 4);
  m = ym.substring(5, 7);
 }
 else 
 {
  return ym; 
 }
 
 var ym_concat = y + m;
 var ret_ = -1;
 
 if((fcount == 7) && (formatmask == "????/??"))
 {
  if (isDateYM(ym_concat))
  {
   ret_ = y + "/" + m;
  }
  else
  {
   ret_ = -1;
  }
 }
 else
 {
  alert('Format["????/??"] 형식을 다시 한번 확인하시고 입력해 주세요.');
  ret_ = -1; 
 }
 
 return ret_;
}

/////////////////////////////////////////////////////
function isDateYM(ym){
/////////////////////////////////////////////////////
 var yy,mm;
 var y = "";
 var m = "";
 ym = trim(ym);
 y = ym.substring(0, 4);
 m = ym.substring(4, 6);

 if ( isYM(y, m) == true )
 {
  return true;
 }
 else
 {
  return false; 
 }
}

/////////////////////////////////////////////////////
function isYunNyun(y){
/////////////////////////////////////////////////////
// 운년인지 check.
 if ( (y % 4) == 0 )
 {
  if ((y % 100) != 0) return true;
  if ((y % 400) == 0) return true;
 }
 return false;
}

/////////////////////////////////////////////////////
function date_Format(ymd, formatmask){
/////////////////////////////////////////////////////
//  "20020204"의 날짜 문자열에 대한 formatting하기. 
  var fcount = formatmask.length;
  var len = trim(ymd).length;
 var rv = "";
 ymd = trim(ymd);

 if (len == 8)
 {
  if (ymd.substring(4, 5) == "/" )
  {
   return  ymd;
  }
  y = ymd.substring(0, 4);
  m = ymd.substring(4, 6);
  d = ymd.substring(6, 8);
 }
 else if (len == 9)
 {
  if (ymd.substring(4, 5) == "/")
  {
   if (ymd.substring(7, 8) == "/" )
   {
    return  ymd;
   }
   else  //yyyy/mmdd 형식
   {
    y = ymd.substring(0, 4);
    m = ymd.substring(5, 7);
    d = ymd.substring(7, 9);
   }
  }
  else
  {
   return  -1;
  }
 }
 else if (len == 10)
 {
  if (ymd.substring(4, 5) != "/" || ymd.substring(7, 8) != "/" )
  {
   return  -1;
  }
  y = ymd.substring(0, 4);
  m = ymd.substring(5, 7);
  d = ymd.substring(8, 10);
 }
 else 
 {
  return ymd; 
 }
 
 var ymd_concat = y + m + d;
 var ret_ = -1;
 
 if((fcount == 10) && (formatmask == "????/??/??"))
 {
  if (isDateYMD(ymd_concat))
  {
   ret_ = y + "/" + m + "/" + d;
  }
  else
  {
   ret_ = -1;
  }
 }
 else
 {
  alert('Format["????/??/??"] 형식을 다시 한번 확인하시고 입력해 주세요.');
  ret_ = -1; 
 }

 return ret_;
}

/////////////////////////////////////////////////////
function isDateYMD(ymd){
/////////////////////////////////////////////////////
// "20020204"의 날짜 문자열에 대한 formatting하기. 
 var yy,mm,dd;
 var y = "";
 var m = "";
 var d = "";

 y = ymd.substring(0, 4);
 m = ymd.substring(4, 6);
 d = ymd.substring(6, 8);

 if(isNaN(y) || isNaN(m) || isNaN(d)){
  return false; 
 }

 if ( isDate(y, m, d) == true )
 {
  return true;
 }
 else
 {
  return false; 
 }
}

/////////////////////////////////////////////////////
function isDateYYYY(yyyy){
/////////////////////////////////////////////////////
//년도 체크
 var yyyymmdd = yyyy + "0101";
 return isDateYMD(yyyymmdd);
}
/////////////////////////////////////////////////////
function isDateYYYYMM( yyyymm ){
/////////////////////////////////////////////////////
//년-월 체크

 var returnValue = false;
 var len = trim(yyyymm).length;
 yyyymm = trim(yyyymm);
 
 if( len == 7 )
 {
  if( yyyymm.substring(4, 5) == "/" )
  {
   returnValue = isYM( yyyymm.substring(0, 4), yyyymm.substring(5, 7) );
  }
 }
 else if( len == 6 )
 {
  returnValue = isYM( yyyymm.substring(0, 4), yyyymm.substring(4, 6) );
 }

 return returnValue;
}

/////////////////////////////////////////////////////
function isValidHour(hh) {
/////////////////////////////////////////////////////
// 유효한(존재하는) 시(時)인지 체크
    var h = parseInt(hh,10);
    return (h >= 1 && h <= 24);
}

/////////////////////////////////////////////////////
function isValidMin(mi) {
/////////////////////////////////////////////////////
// 유효한(존재하는) 분(分)인지 체크
    var m = parseInt(mi,10);
    return (m >= 1 && m <= 60);
}

/////////////////////////////////////////////////////
function isValidTimeFormat(time) {
/////////////////////////////////////////////////////
// Time 형식인지 체크(느슨한 체크)
    return (!isNaN(time) && time.length == 12);
}

/////////////////////////////////////////////////////
function isValidTime(time) {
/////////////////////////////////////////////////////
// 유효하는(존재하는) Time 인지 체크 년/월/일 만을(시간,분 제외) 검사. 
    var year  = time.substring(0,4);
    var month = time.substring(4,6);
    var day   = time.substring(6,8);
    //var hour  = time.substring(8,10);
    //var min   = time.substring(10,12);

    if (parseInt(year,10) >= 1900  && isValidMonth(month) &&isValidDay(year,month,day)){
     //&& isValidHour(hour)   && isValidMin(min)) {
        return true;
    }
    return false;
}

/////////////////////////////////////////////////////
function toTimeObject(time) { //parseTime(time)
/////////////////////////////////////////////////////
// Time 스트링을 자바스크립트 Date 객체로 변환  parameter time: Time 형식의 String
    var year  = time.substr(0,4);
    var month = time.substr(4,2) - 1; // 1월=0,12월=11
    var day   = time.substr(6,2);
    var hour  = time.substr(8,2);
    var min   = time.substr(10,2);

    return new Date(year,month,day,hour,min);
}

 

/////////////////////////////////////////////////////
function toTimeString(date) { //formatTime(date)
/////////////////////////////////////////////////////
// 자바스크립트 Date 객체를 Time 스트링으로 변환 
// parameter date: JavaScript Date Object
    var year  = date.getFullYear();
    var month = date.getMonth() + 1; // 1월=0,12월=11이므로 1 더함
    var day   = date.getDate();
    var hour  = date.getHours();
    var min   = date.getMinutes();

    if (("" + month).length == 1) { month = "0" + month; }
    if (("" + day).length   == 1) { day   = "0" + day;   }
    if (("" + hour).length  == 1) { hour  = "0" + hour;  }
    if (("" + min).length   == 1) { min   = "0" + min;   }

    return ("" + year + month + day + hour + min)
}

/////////////////////////////////////////////////////
function isFutureTime(time) {
/////////////////////////////////////////////////////
// Time이 현재시각 이후(미래)인지 체크
    return (toTimeObject(time) > new Date());
}

/////////////////////////////////////////////////////
function isPastTime(time) {
/////////////////////////////////////////////////////
// Time이 현재시각 이전(과거)인지 체크
    return (toTimeObject(time) < new Date());
}

/////////////////////////////////////////////////////
function shiftTime(time,y,m,d,h) { //moveTime(time,y,m,d,h)
/////////////////////////////////////////////////////
// 주어진 Time 과 y년 m월 d일 h시 차이나는 Time을 리턴
    var date = toTimeObject(time);
    date.setFullYear(date.getFullYear() + y); //y년을 더함
    date.setMonth(date.getMonth() + m);       //m월을 더함
    date.setDate(date.getDate() + d);         //d일을 더함
    date.setHours(date.getHours() + h);       //h시를 더함
    return toTimeString(date);
}

/////////////////////////////////////////////////////
function getMonthInterval(time1,time2) { //measureMonthInterval(time1,time2)
/////////////////////////////////////////////////////
// 두 Time이 몇 개월 차이나는지 구함
    var date1 = toTimeObject(time1);
    var date2 = toTimeObject(time2);

    var years  = date2.getFullYear() - date1.getFullYear();
    var months = date2.getMonth() - date1.getMonth();
    var days   = date2.getDate() - date1.getDate();

    return (years * 12 + months + (days >= 0 ? 0 : -1) );
}

/////////////////////////////////////////////////////
function getDayInterval(time1,time2) {
/////////////////////////////////////////////////////
// 두 Time이 며칠 차이나는지 구함
    var date1 = toTimeObject(time1);
    var date2 = toTimeObject(time2);
    var day   = 1000 * 3600 * 24; //24시간

    return parseInt((date2 - date1) / day, 10) + 1;
}

/////////////////////////////////////////////////////
function getHourInterval(time1,time2) {
/////////////////////////////////////////////////////
// 두 Time이 몇 시간 차이나는지 구함
    var date1 = toTimeObject(time1);
    var date2 = toTimeObject(time2);
    var hour  = 1000 * 3600; //1시간

    return parseInt((date2 - date1) / hour, 10);
}

/////////////////////////////////////////////////////
function getRelativeTime(y,m,d,h) {
/////////////////////////////////////////////////////
// 현재 시각과 y년 m월 d일 h시 차이나는 Time을 리턴
    return shiftTime(getCurrentTime(),y,m,d,h);
}

/////////////////////////////////////////////////////
function isFormatDate(ymd, formatmask){
/////////////////////////////////////////////////////
//9999/99/99 가 날짜인지
  var len_ymd = trim(ymd).length;
  var fcount = formatmask.length;

 if (len_ymd != 10)
 {
  return -1; 
 }
 
 if((fcount == 10) && (formatmask == "????/??/??"))
 {
  if (ymd.substring(4, 5) != "/" || ymd.substring(7, 8) != "/" )
  {
   return  -1;
  }
  y = ymd.substring(0, 4);
  m = ymd.substring(5, 7);
  d = ymd.substring(8, 10);

  var ymd_concat = y + m + d;
  var ret_value = -1;

  if (isDateYMD(ymd_concat))
  {
   ret_value = y + "/" + m + "/" + d;
  }
  else
  {
   ret_value = -1;
  }
 }
 else
 {
  alert('Format["????/??/??"] 형식을 다시 한번 확인하시고 입력해 주세요.');
  ret_value = -1; 
 }
 
 return ret_value;
}

/////////////////////////////////////////////////////
function isFormatDateYM(ym, formatmask) {
/////////////////////////////////////////////////////
//9999/99 가 날짜인지
  var len_ym = trim(ym).length;
  var fcount = formatmask.length;

 if (len_ym != 7)
 {
  return -1; 
 }
 
 if((fcount == 7) && (formatmask == "????/??"))
 {
  if (ym.substring(4, 5) != "/")
  {
   return  -1;
  }
  y = ym.substring(0, 4);
  m = ym.substring(5, 7);

  var ymd_concat = y + m + "01";
  var ret_value = -1;

  if (isDateYMD(ymd_concat))
  {
   ret_value = y + "/" + m;
  }
  else
  {
   ret_value = -1;
  }
 }
 else
 {
  alert('Format["????/??"] 형식을 다시 한번 확인하시고 입력해 주세요.');
  ret_value = -1; 
 }
 
 return ret_value;

}

 

/////////////////////////////////////////////////////
function DateCmp(date1, date2){
/////////////////////////////////////////////////////
//날자 크기 비교 입력형식 yyyy/mm/dd 또는 yyyymmdd
//ret = 0  if date1 == date2
//ret = 1  if date1 >  date2
//ret = -1 if date1 <  date2
 var s_date1 = date1 + ""; 
 var s_date2 = date2 + ""; 
 var ret = -2;
 
 if (s_date1 == s_date2)
 {
  ret = 0;
 }
 else if (s_date1 > s_date2)
 {
  ret = 1;
 }
 else if (s_date1 < s_date2)
 {
  ret = -1;
 }
 
 if (ret == -2)
 {
  alert("날자 비교가 잘못 되었습니다. 다시 한번 확인하시고 입력해 주세요.");
 }
 
 return ret;
}
// 해당 년월일의 요일 가져오기
function cala_day(year, month, day) {
 var nDayOfWeek = cala_weekday(month, day, year); 
 return day_display(nDayOfWeek)
} 

// 해당 년월일에 따른 요일 계산하기
function cala_weekday( x_nMonth, x_nDay, x_nYear) {
  

        if(x_nMonth >= 3){         
                x_nMonth -= 2; 
        } 
        else { 
                x_nMonth += 10; 
        } 

        if( (x_nMonth == 11) || (x_nMonth == 12) ){ 
                x_nYear--; 
        } 

        var nCentNum = parseInt(x_nYear / 100); 
        var nDYearNum = x_nYear % 100; 

        var g = parseInt(2.6 * x_nMonth - .2); 

        g +=  parseInt(x_nDay + nDYearNum); 
        g += nDYearNum / 4;         
        g = parseInt(g); 
        g += parseInt(nCentNum / 4); 
        g -= parseInt(2 * nCentNum); 
        g %= 7; 
         
        if(x_nYear >= 1700 && x_nYear <= 1751) { 
                g -= 3; 
        } 
        else { 
   if(x_nYear <= 1699) { 
     g -= 4; 
   } 
        } 
         
        if(g < 0){ 
                g += 7; 
        } 
         
        return g; 
} 

//요일 보여주기
function day_display(x_nDayOfWeek) { 

 if(x_nDayOfWeek == 0) return "일"; 
 if(x_nDayOfWeek == 1) return "월"; 
 if(x_nDayOfWeek == 2) return "화"; 
 if(x_nDayOfWeek == 3) return "수"; 
 if(x_nDayOfWeek == 4) return "목"; 
 if(x_nDayOfWeek == 5) return "금"; 
 if(x_nDayOfWeek == 6) return "토"; 

} 


//년월일 포멧을 맞춰 준다.
//예 2000년 3월 2일 ====> 2000년 03월 02일
function convertDate(sfrYear, sfrMonth, sfrDay) {

 var sYear = sfrYear.value ;
 var sMonth = sfrMonth.value ;
 var sDay = sfrDay.value ;
 
 
 if ((sYear == null || sYear == "") && (sMonth == null || sMonth == "" )&& (sDay == null || sDay == "" ))
  return;


 if (isNaN(sYear))
  sYear = "";
 if (isNaN(sMonth))
  sMonth = "";
 if (isNaN(sDay))
  sDay = "";
 
 if (sYear == null || sYear == "" ) {
  sfrYear.value = "";
  return;
 }
 if (sMonth == null || sMonth == "" ) {
  sfrMonth.value = "";
  return;
 }
 if (sDay == null || sDay == "" ) {
  sfrDay.value = "";
  return;
 }
  

 var iYear=parseInt(sYear,10);
 var iMonth=parseInt(sMonth,10);
 var iDay=parseInt(sDay,10);

 if( iMonth<10 ) sMonth="0"+iMonth;
 else sMonth=""+iMonth;
 if( iDay<10)sDay="0"+iDay;
 else if( iDay<29)sDay=""+iDay;
 if(iYear<10 ){
  sYear="000"+iYear;
 } else if(iYear<100 ){
  sYear = "00"+iYear;
 } else if(iYear<1000 ){
  sYear = "0"+iYear;
 }else sYear = ""+iYear;
 
 sfrYear.value = sYear;
 sfrMonth.value = sMonth;
 sfrDay.value = sDay; 
}


//유효한 날짜 인지 체크 한다.
function checkDate(sfrYear, sfrMonth, sfrDay) {

 var sYear = sfrYear.value ;
 var sMonth = sfrMonth.value ;
 var sDay = sfrDay.value ;

 if (sYear == null || sYear == "" || sMonth == null || sMonth == "" || sDay == null || sDay == "" ){
  return "false";
 }

 var iYear=parseInt(sYear,10);
 var iMonth=parseInt(sMonth,10);
 var iDay=parseInt(sDay,10);

 if( iMonth<1 || iMonth>12 ){
   return "false";
 }
  
 if( iDay<1 || iDay > 31){
  return "false";
 }
 
 if( iMonth<10 ) sMonth="0"+iMonth;
 else sMonth=""+iMonth;
 if( iDay<10)sDay="0"+iDay;
 else if( iDay<29)sDay=""+iDay;
 else {
  if(iMonth==2){
   if  (( ( iYear%400 == 0 ) || ( ( iYear%100 != 0 ) && ( iYear%4 == 0 ) ) ) ) { if (iDay>29) { return "false";}}
   else if (iDay>28) return "false";
  }else if(iMonth==4 || iMonth==6 || iMonth==9 || iMonth==11){
   if(iDay>30 ) return "false";
  }else{
   if(iDay>31 ) return "false";
  }
 }
 if(iYear<10 ){
  sYear="000"+iYear;
 } else if(iYear<100 ){
  sYear = "00"+iYear;
 } else if(iYear<1000 ){
  sYear = "0"+iYear;
 }else sYear = ""+iYear;
 sfrYear.value = sYear;
 sfrMonth.value = sMonth;
 sfrDay.value = sDay;
 return "true";
  
}


// 쓰여진 공백을 제거하고, 생년월일의 입력이 올바른지 체크
// (2004.07.13 for KNTO by 고상원)
// 매개변수 : year,month,date (form의 input type=text 객체)
//
// 입력이 틀린부분이 있으면
// 1. 메시지를 출력하고
// 2. 해당부분에 focus()를 호출하고
// 3. false를 return한다.
// 입력이 모두 맞으면 true를 리턴한다.
// (자릿수가 1자리인 월,일에는 앞에 0을 붙인다.)
function isValidBirthdateInput(year, month, date) {

 // 공백제거
 year.value = year.value.replace(/ /gi,"");
 month.value = month.value.replace(/ /gi,"");
 date.value = date.value.replace(/ /gi,"");

 // 년
 if (year.value.length != 4 || isNaN(year.value)) {
  alert("해당 년을 다시 한번 확인하시고 입력해 주세요.");
  year.focus();
  return false;
 }

 // 월
 if (!isValidMonthCheck(month.value)) {
  alert("해당 월을 다시 한번 확인하시고 입력해 주세요.");
  month.focus();
  return false;
 }
 else if (month.value.length == 1)
  month.value = "0" + month.value;

 // 일
 if (!isValidDay(year.value, month.value, date.value)) {
  alert("해당 날짜를 다시 한번 확인하시고 입력해 주세요.");
  date.focus();
  return false;
 }
 else if (date.value.length == 1)
  date.value = "0" + date.value;

 return true;
}

// 선택한 포맷으로 날짜형식을 정한다.
function make_date_format(strDate, strformat){

 if(strDate != null) {
  if ( strDate.length == 8) {
   str = strDate.substring(0,4) + strformat + strDate.substring(4,6) + strformat + strDate.substring(6,8); //날짜
  }
 }

 return str ;
}
