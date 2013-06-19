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
//��ȿ��(�����ϴ�) ��(��)���� üũ
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
  window.alert("�� �Է� �����Դϴ�.");
  num="";
  num.focus();
 }
}


/////////////////////////////////////////////////////
function isValidMonthCheck(num) {
/////////////////////////////////////////////////////
//�Էµ� ���ڿ��� ��ȿ�� ��(��)���� üũ, ���θ���
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
//��ȿ��(�����ϴ�) ��(��)���� üũ
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
// ���� �ð��� Time �������� ����
    return toTimeString(new Date());
}

/////////////////////////////////////////////////////
function getYear() {
/////////////////////////////////////////////////////
// ���� Ҵ�� YYYY�������� ����
    return getCurrentTime().substr(0,4);
}

/////////////////////////////////////////////////////
function getMonth() {
/////////////////////////////////////////////////////
// ���� ���� MM�������� ����
    return getCurrentTime().substr(4,2);
}

/////////////////////////////////////////////////////
function getDay() {
/////////////////////////////////////////////////////
// ���� ���� DD�������� ����
    return getCurrentTime().substr(6,2);
}

/////////////////////////////////////////////////////
function getYYYYMM( separator) {
/////////////////////////////////////////////////////
// ���� Ҵ���� separator �� �����Ͽ� ����
    return getYear() + separator + getMonth();
}


/////////////////////////////////////////////////////
function getMMDD( separator) {
/////////////////////////////////////////////////////
// ���� ������ separator �� �����Ͽ� ����
    return getMonth() + separator + getDay();
}


/////////////////////////////////////////////////////
function getYYYYMMDD( separator) {
/////////////////////////////////////////////////////
// ���� Ҵ������ separator �� �����Ͽ� ����
    return getYear() + separator + getMonth() + separator + getDay();
}

/////////////////////////////////////////////////////
function getHour() {
/////////////////////////////////////////////////////
// ���� ���� HH�������� ����
    return getCurrentTime().substr(8,2);
}

/////////////////////////////////////////////////////
function format_YYYYMM(object) {
/////////////////////////////////////////////////////
/**
 * ����(YYYYMM)�� ��ȿ���� üũ�ϰ� ǥ�� ��¥ ���� (YYYY/MM) ���� ��ȯ�Ͽ� ����
 * (���� : �� �Լ��� �Ķ���ʹ� ��ü�� (input object))
 */
    var num, year, month;
    num=object.value;   
    while (num.search("/") != -1) { 
  num = num.replace("/","");
 }
 if (isNaN(num)) {        
     window.alert("���ڷθ� �ۼ��ϼž� �մϴ�.");
  object.focus();
  return "";
 }  
    if( num != 0 && (num.length >= 5 && num.length <= 6)) {
        year = num.substring(0,4);
        month = num.substring(4);
        if (isValidMonthYYYYMM(object, month)==false){
            alert("���� �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
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
  window.alert("����� �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
  object.focus();
        return "";
    } 
    return num;
}

/////////////////////////////////////////////////////
function isValidMonthYYYYMM(object, num) {
/////////////////////////////////////////////////////
//��ȿ��(�����ϴ�) ��(��)���� üũ -- format_YYYYMM ������ ���
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
// ������(YYYYMMDD)�� ��ȿ���� üũ�ϰ� ǥ�� ��¥ ���� (YYYY/MM/DD) ���� ��ȯ�Ͽ� ���� (���� : �� �Լ��� �Ķ���ʹ� ��ü�� (input object))

    var num, year, month, day;
    num=object.value;
    
    while (num.search("/") != -1){ 
      num = num.replace("/","");
 }
 
 if (isNaN(num)) {        
     window.alert("���ڷθ� �ۼ��ϼž� �մϴ�");
     object.focus();
     return "";
 }
    if( num != 0 && num.length == 8 ) {
        year = num.substring( 0, 4 );
        month = num.substring( 4, 6 );  
        day = num.substring(6);
        if(isValidDay(year,month,day)==false) {
         num = "";
         window.alert("��ȿ���� �ʴ� �����Դϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
         object.focus();
         return "";
  }          
        num = year+"/"+month + "/" + day;
    } 
    else {
        num = "";
        window.alert("��¥ �Է����� �����Դϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
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
      window.alert("���ڷθ� �ۼ��ϼž� �մϴ�");
      object.focus();
      return "";
  }
   
    if( num != 0 && num.length == 12 ) {
        year = num.substring( 0, 4 );
        month = num.substring( 4, 6 );  
        day = num.substring(6,8);
  if(isValidDay(year,month,day)==false) {
         num = "";
         window.alert("��ȿ���� �ʴ� �����Դϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
         object.focus();
         return "";
  }          
  hh = num.substring(8,10);
  if(isValidHour(hh)==false) {
         num = "";
         window.alert("��ȿ���� �ʴ� �ð��Դϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
         object.focus();
         return "";
  }
  mm = num.substring(10,12);
  if(isValidMin(mm)==false) {
         num = "";
         window.alert("��ȿ���� �ʴ� ���Դϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
         object.focus();
         return "";
  }
  
        num = year+"/"+month + "/" + day+" "+hh+":"+mm;
    } 
    else {
        num = "";
        window.alert("��¥ �Է����� �����Դϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
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
// ��¥���� üũ (��, ��)

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
// Parameter : Obj     ������ �Է� ��ü      
//      index   ��ü�� ���ؽ� 
//      obj2    Ÿ�ٰ�ü 
// Return    : NONE
// ���      : ��¥format�� check  �ϰ� �ι�° ��ü�� ������ �Ҵ��Ѵ�.
//      obj[index]�� ���� yyyy/mm/dd �������� �����ϰ� ���� �Է°��� obj2[index]�� value�� �Ҵ��Ѵ�.
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
 // ��¥���� üũ (��, ��)
 
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
  alert('Format["????/??"] ������ �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.');
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
// ������� check.
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
//  "20020204"�� ��¥ ���ڿ��� ���� formatting�ϱ�. 
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
   else  //yyyy/mmdd ����
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
  alert('Format["????/??/??"] ������ �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.');
  ret_ = -1; 
 }

 return ret_;
}

/////////////////////////////////////////////////////
function isDateYMD(ymd){
/////////////////////////////////////////////////////
// "20020204"�� ��¥ ���ڿ��� ���� formatting�ϱ�. 
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
//�⵵ üũ
 var yyyymmdd = yyyy + "0101";
 return isDateYMD(yyyymmdd);
}
/////////////////////////////////////////////////////
function isDateYYYYMM( yyyymm ){
/////////////////////////////////////////////////////
//��-�� üũ

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
// ��ȿ��(�����ϴ�) ��(��)���� üũ
    var h = parseInt(hh,10);
    return (h >= 1 && h <= 24);
}

/////////////////////////////////////////////////////
function isValidMin(mi) {
/////////////////////////////////////////////////////
// ��ȿ��(�����ϴ�) ��(��)���� üũ
    var m = parseInt(mi,10);
    return (m >= 1 && m <= 60);
}

/////////////////////////////////////////////////////
function isValidTimeFormat(time) {
/////////////////////////////////////////////////////
// Time �������� üũ(������ üũ)
    return (!isNaN(time) && time.length == 12);
}

/////////////////////////////////////////////////////
function isValidTime(time) {
/////////////////////////////////////////////////////
// ��ȿ�ϴ�(�����ϴ�) Time ���� üũ ��/��/�� ����(�ð�,�� ����) �˻�. 
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
// Time ��Ʈ���� �ڹٽ�ũ��Ʈ Date ��ü�� ��ȯ  parameter time: Time ������ String
    var year  = time.substr(0,4);
    var month = time.substr(4,2) - 1; // 1��=0,12��=11
    var day   = time.substr(6,2);
    var hour  = time.substr(8,2);
    var min   = time.substr(10,2);

    return new Date(year,month,day,hour,min);
}

 

/////////////////////////////////////////////////////
function toTimeString(date) { //formatTime(date)
/////////////////////////////////////////////////////
// �ڹٽ�ũ��Ʈ Date ��ü�� Time ��Ʈ������ ��ȯ 
// parameter date: JavaScript Date Object
    var year  = date.getFullYear();
    var month = date.getMonth() + 1; // 1��=0,12��=11�̹Ƿ� 1 ����
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
// Time�� ����ð� ����(�̷�)���� üũ
    return (toTimeObject(time) > new Date());
}

/////////////////////////////////////////////////////
function isPastTime(time) {
/////////////////////////////////////////////////////
// Time�� ����ð� ����(����)���� üũ
    return (toTimeObject(time) < new Date());
}

/////////////////////////////////////////////////////
function shiftTime(time,y,m,d,h) { //moveTime(time,y,m,d,h)
/////////////////////////////////////////////////////
// �־��� Time �� y�� m�� d�� h�� ���̳��� Time�� ����
    var date = toTimeObject(time);
    date.setFullYear(date.getFullYear() + y); //y���� ����
    date.setMonth(date.getMonth() + m);       //m���� ����
    date.setDate(date.getDate() + d);         //d���� ����
    date.setHours(date.getHours() + h);       //h�ø� ����
    return toTimeString(date);
}

/////////////////////////////////////////////////////
function getMonthInterval(time1,time2) { //measureMonthInterval(time1,time2)
/////////////////////////////////////////////////////
// �� Time�� �� ���� ���̳����� ����
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
// �� Time�� ��ĥ ���̳����� ����
    var date1 = toTimeObject(time1);
    var date2 = toTimeObject(time2);
    var day   = 1000 * 3600 * 24; //24�ð�

    return parseInt((date2 - date1) / day, 10) + 1;
}

/////////////////////////////////////////////////////
function getHourInterval(time1,time2) {
/////////////////////////////////////////////////////
// �� Time�� �� �ð� ���̳����� ����
    var date1 = toTimeObject(time1);
    var date2 = toTimeObject(time2);
    var hour  = 1000 * 3600; //1�ð�

    return parseInt((date2 - date1) / hour, 10);
}

/////////////////////////////////////////////////////
function getRelativeTime(y,m,d,h) {
/////////////////////////////////////////////////////
// ���� �ð��� y�� m�� d�� h�� ���̳��� Time�� ����
    return shiftTime(getCurrentTime(),y,m,d,h);
}

/////////////////////////////////////////////////////
function isFormatDate(ymd, formatmask){
/////////////////////////////////////////////////////
//9999/99/99 �� ��¥����
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
  alert('Format["????/??/??"] ������ �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.');
  ret_value = -1; 
 }
 
 return ret_value;
}

/////////////////////////////////////////////////////
function isFormatDateYM(ym, formatmask) {
/////////////////////////////////////////////////////
//9999/99 �� ��¥����
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
  alert('Format["????/??"] ������ �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.');
  ret_value = -1; 
 }
 
 return ret_value;

}

 

/////////////////////////////////////////////////////
function DateCmp(date1, date2){
/////////////////////////////////////////////////////
//���� ũ�� �� �Է����� yyyy/mm/dd �Ǵ� yyyymmdd
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
  alert("���� �񱳰� �߸� �Ǿ����ϴ�. �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
 }
 
 return ret;
}
// �ش� ������� ���� ��������
function cala_day(year, month, day) {
 var nDayOfWeek = cala_weekday(month, day, year); 
 return day_display(nDayOfWeek)
} 

// �ش� ����Ͽ� ���� ���� ����ϱ�
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

//���� �����ֱ�
function day_display(x_nDayOfWeek) { 

 if(x_nDayOfWeek == 0) return "��"; 
 if(x_nDayOfWeek == 1) return "��"; 
 if(x_nDayOfWeek == 2) return "ȭ"; 
 if(x_nDayOfWeek == 3) return "��"; 
 if(x_nDayOfWeek == 4) return "��"; 
 if(x_nDayOfWeek == 5) return "��"; 
 if(x_nDayOfWeek == 6) return "��"; 

} 


//����� ������ ���� �ش�.
//�� 2000�� 3�� 2�� ====> 2000�� 03�� 02��
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


//��ȿ�� ��¥ ���� üũ �Ѵ�.
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


// ������ ������ �����ϰ�, ��������� �Է��� �ùٸ��� üũ
// (2004.07.13 for KNTO by ����)
// �Ű����� : year,month,date (form�� input type=text ��ü)
//
// �Է��� Ʋ���κ��� ������
// 1. �޽����� ����ϰ�
// 2. �ش�κп� focus()�� ȣ���ϰ�
// 3. false�� return�Ѵ�.
// �Է��� ��� ������ true�� �����Ѵ�.
// (�ڸ����� 1�ڸ��� ��,�Ͽ��� �տ� 0�� ���δ�.)
function isValidBirthdateInput(year, month, date) {

 // ��������
 year.value = year.value.replace(/ /gi,"");
 month.value = month.value.replace(/ /gi,"");
 date.value = date.value.replace(/ /gi,"");

 // ��
 if (year.value.length != 4 || isNaN(year.value)) {
  alert("�ش� ���� �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
  year.focus();
  return false;
 }

 // ��
 if (!isValidMonthCheck(month.value)) {
  alert("�ش� ���� �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
  month.focus();
  return false;
 }
 else if (month.value.length == 1)
  month.value = "0" + month.value;

 // ��
 if (!isValidDay(year.value, month.value, date.value)) {
  alert("�ش� ��¥�� �ٽ� �ѹ� Ȯ���Ͻð� �Է��� �ּ���.");
  date.focus();
  return false;
 }
 else if (date.value.length == 1)
  date.value = "0" + date.value;

 return true;
}

// ������ �������� ��¥������ ���Ѵ�.
function make_date_format(strDate, strformat){

 if(strDate != null) {
  if ( strDate.length == 8) {
   str = strDate.substring(0,4) + strformat + strDate.substring(4,6) + strformat + strDate.substring(6,8); //��¥
  }
 }

 return str ;
}
