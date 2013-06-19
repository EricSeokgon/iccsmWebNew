/**
* File name   : kjs.js 
* @author     :김경덕
* @Version    :1.4
*
* @History
* 2002.11.? 초기제작   김경덕
* 2003.09.18 kjsOnlyCheck 추가
* 2004.03.11 버전업
* 2005.04.07 추가
* 2005.04.14 envetnKeeper 삭제..
* 2006.08.09 기능 추가
* 2006.09.19 필수 입력 백그라운 칼라 추가
* 2006.12.13 money 에서 stripMask 시 처리 안되는 문제 수정(오두식)
* 
* 사용법
*       - required, required="에러메세지" , slct_required , moveFocus ='focus가 이동할 obj name'                           
*         필드를 필수입력으로 만든다.        
*                                                                                              
*       - mask="999-999",  stripMask(mask가 있을 경우에만 사용= submit 시 마스크가 풀리면서 값이 넘어간다. 
*          onkeyup="ee_on_keyup(this)"  같이 사용
*                                                                                                                  
*       - minlength ="7"                                                                       
*         최소자리수 이상 입력   
*                                                         
*       - date, date='9999-99-99',   dateErrMsg='에러 메세지'                                                   
*          날자를 입력하는 필드의 경우 사용한다.                                      
*        
*       - isLower='비교될 obj name'  isLowerErrMsg='에러 메세지'
*          비교되는 obj value값보다 크면 에러 메세지를 출력한다. 
*
*       - isHigher='비교될 obj name'  isHigherErrMsg='에러 메세지'
*          비교되는 obj value값보다  작으면 에러 메세지를 출력한다.
*
*       - isSame='비교될 obj name'  isSameErrMsg='에러 메세지'
*          비교되는 obj value값과 같지 않으면 에러 메세지를 출력한다.
*
*       - upper   onkeyup="ee_on_keyup(this)"  같이 사용
*         입력된 value를 대문자로 바꾼다.
*
*       - lower    onkeyup="ee_on_keyup(this)"  같이 사용
*         입력된 value를 소문자로 바꾼다.
*
*       - isImage,   isImageErrMsg='에러 메세지'
*         file 폼 필드에서 이미지에서, jpg,gif 파일체크
*
*       - number  onkeyup="ee_on_keyup(this)"  같이 사용
*         숫자만 입력가능하다.
*
*       - entSubmit='form Name' onkeyup ="ee_on_keyup(this)"
*         텍스트 박스에서 엔터를 눌렀을경우 해방 폼을 submit 시킨다.
*
*       - envetnKeeper 삭제
*          사용방법 변경
*           1. mask, date , number,upper, lower, money 일경우 onkeyup="ee_on_keyup(this)"
*           2. entSubmit 일경우     onkeypress ="ee_on_keypress(this)"
* 
*       - money      onkeyup="ee_on_keyup(this)"  같이 사용
*         금액 표시. ex 3,000
* 
*       - email
* 		  이메일 체크 
* 
*       -jumin, jumin='2번째 주민 번호 뒷자리  obj name'
* 			1.하나의 필드로 만 사용시에는 mask='999999-9999999' 와 함께 써준다.
*           2.두개의 필드로 사용시에는 주민 번호 뒷자리 필드 이름을 적어준다. 
* 
*       -csn, csn='2번째 obj name, 3번째 obj name'
*        사업자 등록번호 체크
* 			1.하나의 필드로 만 사용시에는 mask='999-99-99999' 와 함께 써준다.
*           2.3개의 필드로 사용시에는 사업자 번호 2번재 3번째 필드 이름을 콤마(,)로 구분 하여 적어준다. 
* 
*       - alpha   
* 			영문만 입력 가능 
* 
*       -  alpha_numbur   
*           영문 숫자만 입력 가능
*/

// 전역변수와 상수를 정의
// ( ) [ ] { } < > " ' ` ~  $ ! # % ^ & @  , . ; :  \ / |  * = - ? ''
var KJS_DEFAULT_SPECIAL_CHAR  = /(\(|\)|\[|\]|\{|\}|\<|\>|\"|\'|\`|\~|\$|\!|\#|\%|\^|\&|\@|\,|\.|\;|\:|\\|\/|\||\*|\=|\-|\?|\s)*/g; 
var KJS_DEFAULT_BG_COLOR="#FFFFFF";
var KJS_ERROR_BG_COLOR="#ECE7F9";

function beforeKjs(){
    return true;
}
//////////////////////////////////////////////////////////////////////////////////
// 함수명 : kjsSubmit(form_name)
// 내  용 : 입력값 Submit시 에러체크를 위해 호출되는 함수
//          
function kjsSubmit(form_name){
//alert("fire_kjs시작");
    eval("mForm=document."+form_name);
    mForm.initialize = fm_initialize;
    mForm.initialize();    
    mForm.beforeSubmit = em_beforeSubmit;
    if(mForm.beforeSubmit()){
        if(!beforeKjs())  return; //kjs처리후 수행해야하는 함수
        mForm.submit();
    }

}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : kjsOnlyCheck(form_name)
// 내  용 : 입력값  에러체크를 위해 호출되는 함수(submit은 시키지 않는다.)
//          validation 체크후 성공이면 ture, 실패면 false를 반환한다.
function kjsOnlyCheck(form_name){
    eval("mForm=document."+form_name);
    mForm.initialize = fm_initialize;
    mForm.initialize();    
    mForm.beforeSubmit = em_beforeSubmit;
    if(mForm.beforeSubmit()){
        if(!beforeKjs())  return false; //kjs처리후 수행해야하는 함수
        return true;
    }
    return false;
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : fm_initialize(form_name)
// 메소드명 : element.initialize()
// 내  용 : 전체 element 객체를 초기화
//    
function fm_initialize(){
//alert("fm_initialize시작");
    for(var idx=0; idx < this.elements.length ; idx++){
        this.elements[idx].initialize = em_initialize;
        this.elements[idx].initialize(this);
    }
    
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_initialize()
// 메소드명 : element.initialize(parent)
// 내    용 : element의 method, attribute를 redefine한다.
//
function em_initialize(parent){
    //alert("em_initialize 시작");
    var sMsg;
    this.parent = parent;
    this.AKey = new Array;
    this.setMessage = em_set_message;
    this.lowering = em_lowering;
    this.uppering = em_uppering;
    this.masking = em_masking;
    this.unmasking = em_unmasking;
    this.isAttribute = em_is_attribute;  // this.getAttribute(attr) != null
    this.keyFactory = em_key_factory; //개별 element 초기화
    this.validate = em_validate;
    this.validate_display = em_validate_display;    
    

    this.keyFactory();
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_is_attribute()
// 메소드명 : element.isAttribute()
// 내    용 : element의 attribute 알아낸다.
//
function em_is_attribute(attr){
    return ( this.getAttribute(attr) != null ) ? true : false;
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_set_message()
// 메소드명 : element.setMessage()
// 내    용 : 에러메세지를 set
//
function em_set_message(sMsg){
    this.setAttribute("msg",sMsg);
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_beforeSubmit()
// 메소드명 : element.beforeSubmit()
// 내  용 : submit전의 전처리
// 
function em_beforeSubmit(){
//alert("em_beforeSubmit 시작");

    for(var i=0; i< this.elements.length; i++){        
        if (!this.elements[i].validate_display()) return false;
    } 

    for(var i=0; i< this.elements.length; i++){        
        if (this.elements[i].isAttribute("stripMask")) this.elements[i].unmasking();
    }
    
    return true;
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_validate_display()
// 메소드명 : element.validate_display()
// 내  용 : 각 입력 값에 대한 입력 체크후 display
//          
function em_validate_display(){
//alert("em_validate_display 시작");
    if (this.validate()){
        this.style.backgroundColor = KJS_DEFAULT_BG_COLOR;
        return true;
    } else {
        alert(this.getAttribute("msg") );       
        if (this.isAttribute("moveFocus")){
            eval("target=this.parent."+this.getAttribute("moveFocus"));
            target.style.backgroundColor = KJS_ERROR_BG_COLOR;
            target.focus();
        }else{
        	this.style.backgroundColor = KJS_ERROR_BG_COLOR;
            this.focus();
        }

        return false;
    }
}


//////////////////////////////////////////////////////////////////////////////////
// 메소드명 : em_masking
// 내용 : 일반적인 masking을 담당한다.
//
function em_masking(){

    var sStr = this.value.replace( KJS_DEFAULT_SPECIAL_CHAR ,"");
    var tStr="";
    var i;
    var j=0; 

    for(i=0; i< sStr.length; i++){
     tStr += sStr.charAt(i);
     j++;
     if (j < this.mask.length && this.mask.charAt(j)!="9") tStr += this.mask.charAt(j++);
    }   
    this.value= tStr;
}

//////////////////////////////////////////////////////////////////////////////////
// 메소드명 : em_unmasking
// 내용 : submit 하기 전 포맷형식을 제거한다.일반적인 unmasking을 담당한다.
// 
function em_unmasking(){
//alert("시작");
    if (!this.isAttribute("mask") && !this.isAttribute("money"))  return;   
    var sStr = this.value;
    var tStr="";
    var i;
    if(this.isAttribute("money")){
    	tStr = sStr.replace(/,/gi,"");
    }
    else{
	    for(i=0; i< sStr.length; i++){
	     if (this.mask.charAt(i)=="9")  tStr += sStr.charAt(i);
	    }
    }
   
    this.value= tStr;
//alert(this.value); 
}

//////////////////////////////////////////////////////////////////////////////////
// 메소드명 : em_lowering
// 내용 : submit 하기 전 모든 문자를 소문자로 바꾼다.
// 
function em_lowering(){
    this.value=this.value.toLowerCase();
}


//////////////////////////////////////////////////////////////////////////////////
// 메소드명 : em_uppering
// 내용 : submit 하기 전 모든 문자를 대문자로 바꾼다.
// 
function em_uppering(){
    this.value=this.value.toUpperCase();
}






//////////////////////////////////////////////////////////////////////////////////
// 메소드명 : isNum()
// 파라메터 : strnum : 검사할 숫자
// 리 턴 값 : boolean(true / false)
// 내    용 : strnum이 숫자인지 검사한다.
function isNum (strnum){
  return (strnum.toString() && !/\D/.test(strnum));
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_key_factory()
// 메소드명 : element.keyFactory()
// 내    용 : element의 type과 주어진 attribute에 따라 필요한
//            key를 사용 가능하게 한다.
//
function em_key_factory(){
//alert("em_key_factory시작");

    switch (this.type) {

    case "password" :
    case "text" :
        if ( this.isAttribute("required") )     this.AKey[0]="required";
        if ( this.isAttribute("minlength") )    this.AKey[1]="minlength";
        if ( this.isAttribute("mask") )         this.AKey[2]="mask";
        if ( this.isAttribute("date") )         this.AKey[3]="date";
        if ( this.isAttribute("isLower") )      this.AKey[4]="isLower";
        if ( this.isAttribute("isHigher") )     this.AKey[5]="isHigher";
        if ( this.isAttribute("lower") )        this.AKey[6]="lower";
        if ( this.isAttribute("upper") )        this.AKey[7]="upper";
        if ( this.isAttribute("isSame") )       this.AKey[8]="isSame";
        if ( this.isAttribute("number") )       this.AKey[9]="number";
		if ( this.isAttribute("float") )		this.AKey[9]="float";
        if ( this.isAttribute("entSubmit") )    this.AKey[10]="entSubmit";
        if ( this.isAttribute("money") )        this.AKey[11]="money";
        if ( this.isAttribute("email") )        this.AKey[12]="email";
        if ( this.isAttribute("jumin") )        this.AKey[13]="jumin";
        if ( this.isAttribute("csn") )          this.AKey[14]="csn";
        if ( this.isAttribute("alpha") )        this.AKey[15]="alpha";
        if ( this.isAttribute("alpha_number"))  this.AKey[16]="alpha_number";

        
        break;
    
    case "textarea" :
        if ( this.isAttribute("required") )     this.AKey[0]="required";

        break;

    case "checkbox" :

    case "file" :
        if ( this.isAttribute("required") )     this.AKey[0]="required";
        if ( this.isAttribute("isImage") )      this.AKey[1]="isImage";
        break;

    case "select-one" :
        if ( this.value=="slct_required" )      this.AKey[0]="slct_required";
        break;

    default :
        break;
    }    
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_validate()
// 메소드명 : element.validate()
// 내  용 : 각 입력 값에 대한 입력 체크
//          Select는 필수입력여부만을 검사한다.
function em_validate(){
//alert("em_validate()시작");

    for (var i=0;i < this.AKey.length; i++){
        switch(this.AKey[i]){
        case "required" :
            this.xo_required = ex_required;
            this.ikey="required";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_required())    return false;
            break;

        case "slct_required" :
            this.xo_slct_required = ex_slct_required;
            this.ikey="slct_required";
            if (!this.xo_slct_required())    return false;
            break;

        case "minlength" :
            this.xo_minlength = ex_minlength;
            this.ikey="minlength";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_minlength())    return false;
            break;

        case "mask" :
            this.masking();
            break;

        case "date" :
            this.xo_date = ex_date;
            this.ikey="date";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_date())    return false;
            break;

        case "isLower" :
            this.xo_isLower = ex_is_lower;
            this.ikey="isLower";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_isLower())    return false;
            break;

        case "isHigher" :
            this.xo_isHigher = ex_is_higher;
            this.ikey="isHigher";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_isHigher())    return false;
            break;

        case "lower" :
            this.lowering();
            break;

        case "upper" :
            this.uppering();
            break;

        case "isSame" :
            this.xo_isSame = ex_is_same;
            this.ikey="isSame";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_isSame())    return false;
            break;

        case "isImage" :
            this.xo_isImage = ex_is_image;
            this.ikey="isImage";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_isImage())    return false;
            break;

        case "number" :
            this.xo_number = ex_number;
            this.ikey="number";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_number())    return false;
            break;

        case "money" :        
            this.money = em_money_masking;
            this.money();
            this.xo_numrep = ex_numrep;
            this.filter = /,/g;
            if (!this.xo_numrep())    return false;            
            break;
            
        case "email" :        
            this.xo_email = ex_email;
            if (!this.xo_email())    return false;            
            break;
            
        case "jumin" :
            this.xo_jumin = ex_jumin;
            this.ikey="jumin";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_jumin())    return false;
            break;
            
        case "csn" :
            this.xo_csn = ex_csn;
            this.ikey="csn";
            this.ikey_value = this.getAttribute(this.ikey);
            if (!this.xo_csn())    return false;
            break; 
            
        case "alpha" :        
            this.xo_alpha = ex_alpha
            if (!this.xo_alpha())    return false;            
            break; 
            
        case "alpha_number" :        
            this.xo_alpha_number = ex_alpha_number
            if (!this.xo_alpha_number())    return false;            
            break;                                                           

        }//end  switch(this.AKey)                                              
    }
    return true;
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_alpha_number()
// 내  용 : 영문 숫자 입력을 체크 한다. 
// 사용법: ex) alpha_number  
//
function ex_alpha_number()
{

  var flag = true; 
  var msg = "";

  if (!this.parent.value) return flag; //입력값 없는 경우는 Pass

  var tsTarget = this.parent.value;

  var regExp_alpha_numeric = /^[a-zA-Z0-9]+$/;

  if(!regExp_alpha_numeric.test(tsTarget)) {
    flag = false;
    msg = "영문  혹은 숫자만 입력 가능 합니다.";
    this.setMessage(msg);
  }

  return flag;

}
//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_alpha()
// 내  용 : 영문 입력을 체크 한다. 
// 사용법: ex) alpha  
//
function ex_alpha()
{

  var flag = true; 
  var msg = "";

  if (!this.value) return flag; //입력값 없는 경우는 Pass

  var tsTarget = this.value;

  var regExp_alphabetic = /^[a-zA-Z]+$/;
  if(!regExp_alphabetic.test(tsTarget)) {
    flag = false;
    msg = "영문만 입력 가능합니다.";
    this.setMessage(msg);
  }

  return flag;

}
//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_csn()
// 내  용 : 주민 번호 체크 
// 사용법: ex) csn, csn='2번째 obj name, 3번째 obj name'  
//         
function ex_csn(){
//alert("ex_csn 시작");
    
  var flag = true; 
  var msg = "";
  var sum = 0;

  if (!this.value) return flag; //입력값이 없는 경우는 Pass
  
  var csNumber;
  alert(this.ikey_value);
  
  if(this.ikey_value) {
  	var tmp = this.ikey_value.split(",");	
  	eval("target2=this.parent."+tmp[0]);
  	eval("target3=this.parent."+tmp[1]);
  	csNumber = this.value + target2.value+ target3.value;

  }else {
  	csNumber = this.value.replace(/(\,|\.|\-|\/)/g,"");
  }
  	
  var checkArray = new Array(1,3,7,1,3,7,1,3,5);

  for(idx=0 ; idx < 9 ; idx++)
    sum += csNumber.charAt(idx) * checkArray[idx];

  sum = sum + ((csNumber.charAt(8) * 5 ) / 10);

  var nam = Math.floor(sum) % 10;

  var checkDigit = ( nam == 0 ) ? 0 : 10 - nam;

  if ( !isNum(csNumber) || csNumber.charAt(9) != checkDigit)  {
    flag = false;
    msg = "입력한 사업자 등록번호가 잘못되었습니다.";
    this.setMessage(msg);
  }

  return flag;

  return flag;
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_jumin()
// 내  용 : 주민 번호 체크 
// 사용법: ex) jumin, jumin='2번째 주민 번호  obj name'  
//         
function ex_jumin(){
//alert("ex_jumin 시작");

  var flag = true;
  var msg = "";
  var sum = 0;

  if (!this.value) return flag; //입력값이 없는 경우는 Pass

  var psNumber;

  if(this.ikey_value) {
  	eval("target=this.parent."+this.ikey_value);
  	psNumber = this.value + target.value;

  }else {
  	psNumber = this.value.replace(/(\,|\.|\-|\/)/g,"");
  }

  for (idx = 0, jdx=2; jdx < 10; idx++, jdx++) {
    sum = sum + ( psNumber.charAt(idx) * jdx );
  }

  for (idx = 8, jdx=2; jdx < 6; idx++, jdx++) {
    sum = sum + ( psNumber.charAt(idx) * jdx );
  }

  var nam = sum % 11;
  var checkDigit = 11 - nam ;

  if ( !isNum(psNumber) || psNumber.charAt(12) != checkDigit)  {
    flag = false;
    msg = "입력한 주민등록번호가 잘못되었습니다.";
    this.setMessage(msg);
  }

  return flag;
}
//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_email()
// 내  용 : email 체크
// 사용법: email
// 
function ex_email()
{
  //this core script from http://tech.irt.org/articles/js049/index.htm
  //customize by TKshin.

  var flag = true; //true when validation successful.
  var msg = "";

  if (!this.value) return flag; //입력값 없는 경우는 Pass

  var tsTarget = this.value;
  var regExpEmail = /^\w+((-|\.)\w+)*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]{2,4}$/;

  if(!regExpEmail.test(tsTarget)) {
    flag = false;
    msg = "이메일 형식이 아닙니다.";
    this.setMessage(msg);
  }

  return flag;

}
//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_money_masking()
// 내  용 : money에 관련된 masking을 담당
// 사용법: money
// 
function em_money_masking() {

  var sMoney = this.value.replace(/,/g,"");
  var tMoney = "";
  var i;
  var j=0;
  var tLen =sMoney.length;

  if (tLen <= 3 ) return ;

  for(i=0;i<tLen;i++){
    if (i!=0 && ( i % 3 == tLen % 3) ) tMoney += ",";
    if(i < tLen ) tMoney += sMoney.charAt(i);
  }

  this.value = tMoney;
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_numrep()
// 내  용 : 특정 필터를 제외한 숫자 여부를 체크 한다.
// 사용법: 
//
function ex_numrep() {

  var sVal = this.value.replace(this.filter,"");
  sMsg ="숫자만 입력가능합니다.";
    if (!sVal) return true;
    if (!isNum(sVal)){
        this.setMessage(sMsg);
        return false;
    }
        
    return true;
}
//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_required()
// 내  용 : 필수입력체크
// 사용법: required, required="message"
//          
function ex_required(){
sMsg ="필수입력입니다";
    var regExp_whiteSpace = /^[\s]*$/;
    if (regExp_whiteSpace.test(this.value)){
        if (this.ikey_value)    sMsg=this.ikey_value;
        this.setMessage(sMsg);
        this.value = this.value.replace( /(\s)/g,"");
        return false;
    }        
    return true;
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_slct_required()
// 내  용 : select box 필수선택체크
// 사용법: option value="slct_required"
//          
function ex_slct_required(){
//alert("ex_slct_required 시작");
    sMsg ="필수 선택입니다";
    this.setMessage(sMsg);
    return false;
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_minlength()
// 내  용 : 최소길이 체크
// 사용법: ex)minlength="7"
//         
function ex_minlength(){
//alert("ex_minlength 시작");
    if (!this.value) return true; //입력값 없는 경우는 Pass
    var tsTarget = this.value;
    //Validation Logic for Min Legnth..
    if (tsTarget.length <  this.ikey_value ) {
        sMsg ="입력된 항목의 자릿수가 너무 작습니다. \n최소 " + this.ikey_value + "자리이상입니다.";
        this.setMessage(sMsg);
        return false;
    }
    return true;
}



//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_date()
// 내    용 :날짜 포맷체크 체크
// 사용법 :date=>yyyymmdd 형식, date='9999-99-99'=> 'yyyy-mm-dd' 형식으로 변환
function ex_date(){
    
    var flag = true;    
    if (!this.value) return flag; //입력값이 없는 경우는 Pass

    //Validation Logic for Date..
    var iYear = null;
    var iMonth = null;
    var iDay = null;
    var iDaysInMonth = null;

    var sDate=this.value.replace(/(\,|\.|\-|\/)/g,"");
    var sFormat="YYYYMMDD";  //아직까지 YYYYMMDD의 형태만 지원한다. --;
    var aDaysInMonth=new Array(31,28,31,30,31,30,31,31,30,31,30,31);

    //완전한 날짜의 입력이 들어온 경우이다.
    if ( sDate.length != 8 ) flag = false ;

    if (flag) {
    iYear  = eval(sDate.substr(0,4));
    iMonth = eval(sDate.substr(4,2));
    iDay   = eval(sDate.substr(6,2));
    if (!isNum(iYear) || !isNum(iMonth) || !isNum(iDay) )
      flag = false ;
    }

    if (flag) {
     iDaysInMonth = (iMonth != 2) ? aDaysInMonth[iMonth-1] : (( iYear%4 == 0 && iYear%100 != 0 || iYear % 400==0 ) ? 29 : 28 );
     if( iDay==null || iMonth==null || iYear==null  || iMonth > 13 || iMonth < 1 || iDay < 1 || iDay > iDaysInMonth )
      flag = false ;
    }

    if (!flag) {
    sMsg = "날짜입력이 잘못되었습니다.";
    if ( this.isAttribute("dateErrMsg") )     sMsg=this.dateErrMsg;
    this.setMessage(sMsg);
    }

    if ( flag && this.ikey_value){
        if (flag) this.value=this.value.replace(/(\,|\.|\-|\/)/g,"");
        this.mask=this.ikey_value;
        this.masking();  //포맷형식이 있으면.. 리포맷한다..
    }

    return flag;
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_is_lower()
// 내  용 : 지정된 필드의 값을 비교하여 비교되는 값보다 작으면 true를 리턴 
// 사용법: ex)isLower='비교될 obj name'  isLowerErrMsg='에러 메세지'
//         
function ex_is_lower(){
//alert("ex_is_lower 시작");
    sMsg ="입력된 값이 비교되는 값보다 클수 없습니다.";
    if (!this.value) return true; //입력값 없는 경우는 Pass
    var srcValue = this.value.replace(KJS_DEFAULT_SPECIAL_CHAR,"");
    eval("target=this.parent."+this.ikey_value);
    var tgValue= target.value;
    tgValue = tgValue.replace(KJS_DEFAULT_SPECIAL_CHAR,"");

    if (!(tgValue=="" || tgValue==null)){
        if ( srcValue > tgValue ) {
            if ( this.isAttribute("isLowerErrMsg") )     sMsg=this.isLowerErrMsg;
            this.setMessage(sMsg);
            return false;
        }
    }

    return true;
}



//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_is_higher()
// 내  용 : 지정된 필드의 값을 비교하여 비교되는 값보다 크면 true를 리턴 
// 사용법: ex)isHigher='비교될 obj name'  isHigherErrMsg='에러 메세지'
//         
function ex_is_higher(){
//alert("ex_is_higher 시작");
    sMsg ="입력된 값이 비교되는 값보다 작을수 없습니다.";
    if (!this.value) return true; //입력값 없는 경우는 Pass
    var srcValue = this.value.replace(KJS_DEFAULT_SPECIAL_CHAR,"");
    eval("target=this.parent."+this.ikey_value);
    var tgValue= target.value;
    tgValue = tgValue.replace(KJS_DEFAULT_SPECIAL_CHAR,"");

    if (!(tgValue=="" || tgValue==null)){
        if ( srcValue < tgValue ) {
            if ( this.isAttribute("isHigherErrMsg") )     sMsg=this.isHigherErrMsg;
            this.setMessage(sMsg);
            return false;
        }
    }

    return true;
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_is_same()
// 내  용 : 지정된 필드의 값을 비교하여 비교되는 값과 같으면 true를 리턴 
// 사용법: ex)isSame='비교될 obj name'  isSameErrMsg='에러 메세지'
//         
function ex_is_same(){
//alert("ex_is_same 시작");
    sMsg ="입력된 값이 비교되는 값과 같지 않습니다.";
    if (!this.value) return true; //입력값 없는 경우는 Pass
    var srcValue = this.value.replace(KJS_DEFAULT_SPECIAL_CHAR,"");
    eval("target=this.parent."+this.ikey_value);
    var tgValue= target.value;
    tgValue = tgValue.replace(KJS_DEFAULT_SPECIAL_CHAR,"");

    if (!(tgValue=="" || tgValue==null)){
        if ( srcValue != tgValue ) {
            if ( this.isAttribute("isSameErrMsg") )     sMsg=this.isSameErrMsg;
            this.setMessage(sMsg);
            return false;
        }
    }

    return true;
}

function CheckImageFile(obj){
  var ImageFile = obj.value;
  var extFile = ImageFile.split("\\");
  var ImgInfo = extFile[extFile.length-1];
  var ext = ImgInfo.split(".");
    if (ext[1].toUpperCase() == "JPG" || ext[1].toUpperCase() == "GIF")
      return true;
    else
      return false;
  
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_is_image()
// 내  용 : file 폼 필드에서 jpg,gif 파일체크
// 사용법: ex)isImage,   isImageErrMsg='에러 메세지'
//         
function ex_is_image(){
//alert("ex_is_image 시작");
    sMsg ="이미지 파일은 gif,jpg, jpeg, png 만 가능합니다!";
    if (!this.value) return true; //입력값 없는 경우는 Pass

    var ImageFile = this.value;
    var extFile = ImageFile.split("\\");
    var ImgInfo = extFile[extFile.length-1];
    var ext = ImgInfo.split(".");
    if (ext[1].toUpperCase() == "JPG" || ext[1].toUpperCase() == "GIF"
        || ext[1].toUpperCase() == "JPEG" || ext[1].toUpperCase() == "PNG"){
      return true;
    }else{
            if ( this.isAttribute("isImageErrMsg") )     sMsg=this.isImageErrMsg;
            this.setMessage(sMsg);
      return false;
    }


}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ex_number()
// 내  용 : 숫자입력체크
// 사용법: required, required="message"
//          
function ex_number(){
sMsg ="숫자만 입력가능합니다.";
    if (!this.value) return true;
    if (!isNum(this.value)){
        this.setMessage(sMsg);
        return false;
    }
        
    return true;
}





//////////////////////////////////////////////////////////////이하-이벤트 관련 스크립트/////////////////////////////////////////////






//////////////////////////////////////////////////////////////////////////////////
// 함수명 : em_kek_initialize()
// 메소드명 : element.initialize(parent)
// 내    용 : element의 method, attribute, event를 redefine한다.
//
function em_kek_initialize(){
//alert("em_kek_initialize 시작-3");
    var sMsg; 
    this.AKey = new Array;
    this.setMessage = em_set_message;
    this.keyupMasking = ee_keyup_masking;
    this.isAttribute = em_is_attribute;  // this.getAttribute(attr) != null
    this.keyFactory = em_key_factory; //개별 element 초기화
    this.enterSubmit = ee_enter_submit;
    
    this.keyFactory();
}





//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ee_on_keyup()
// 메소드명 : element.keyup(parent)
// 내    용 : element의 onkeyup의 event를 실행한다.
//
function ee_on_keyup(obj){

    obj.initialize = em_kek_initialize;
    obj.initialize();

    for (var i=0;i < obj.AKey.length; i++){
        switch(obj.AKey[i]){
        case "mask" :
            obj.ikey="mask";
            obj.filter=KJS_DEFAULT_SPECIAL_CHAR;
            obj.keyupMasking();
            break ;
        case "date" :
            obj.keyupDate = ee_keyup_date;
            obj.ikey="date";
            obj.ikey_value = obj.getAttribute(obj.ikey);
            obj.keyupDate();
            break ;

        case "number" :
            obj.keyupNumber = ee_keyup_number;
            obj.keyupNumber();
            break ;

        case "entSubmit" :
            obj.ikey="entSubmit";
            obj.ikey_value = obj.getAttribute(obj.ikey);
            obj.enterSubmit();
            break ;
            
            
        case "lower" :
            obj.lower= em_lowering;
            obj.lower();
            break ; 
            
        case "upper" :
            obj.upper= em_uppering;
            obj.upper();
            break ;
                                   
        case "money" :
            obj.keyupNumber = ee_keyup_number;
            obj.keyupNumber();
            obj.money = em_money_masking;
            obj.money();
            break;

		case "float" :
            obj.keyupNumber = ee_keyup_float;
            obj.keyupNumber();
            break ;
        }//end  switch(obj.AKey)                                              
    }


}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : skipKeyCode()
// 내    용 : skip할 keyCode check
//
function skipKeyCode(keyCode) {
    if (keyCode == 8 || keyCode == 9 || keyCode == 35 || keyCode == 36 ||
        keyCode == 37 || keyCode == 39 || keyCode == 46) {
        return true;
    } else {
        return false;
    }
}

//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ee_keyup_masking()
// 메소드명 : element.keyupMasking(parent)
// 내    용 : element의 mask attribute의 onkeyup의 event를 실행한다.
//
function ee_keyup_masking(){

    var mask = this.getAttribute(this.ikey);
    var sMask = mask.replace( KJS_DEFAULT_SPECIAL_CHAR ,"");//포맷형식을 지운다.
    if (skipKeyCode(event.keyCode)) return; //필요한 키는 건너뛴다.
    if (!this.value) return;
    this.value = this.value.replace(this.filter , ""); //숫자만 입력가능
    this.value = this.value.replace(/([^0-9])/g, ""); //숫자만 입력가능

    if (this.value.length < 1) return;
    var tStr = "";
    var j=0; 
    for (var i = 0; i < this.value.length; i++) {
        if (i > sMask.length-1) { //포맷형식길이보다 길면 나간다.
            break;
        }
        tStr += this.value.charAt(i);
        j++;
        if (j < mask.length && mask.charAt(j)!="9") tStr += mask.charAt(j++);
        
    }
    this.value = tStr;
}



//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ee_keyup_date()
// 메소드명 : element.keyupDate(parent)
// 내    용 : element의 date attribute의 onkeyup의 event를 실행한다.
//
function ee_keyup_date(){
    this.filter = /([^0-9])/g ; //숫자외의 모든것- 숫자만 입력가능
    if (this.ikey_value)    this.mask=this.ikey_value;        
    this.keyupMasking();
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ee_keyup_number()
// 메소드명 : element.keyupNumber(parent)
// 내    용 : element의 number attribute의 onkeyup의 event를 실행한다.
//
function ee_keyup_number(){
    this.filter = /([^0-9])/g ; //숫자외의 모든것- 숫자만 입력가능
    
    if (skipKeyCode(event.keyCode)) return; //필요한 키는 건너뛴다.
    if (!this.value) return;
    this.value = this.value.replace(this.filter , ""); //숫자만 입력가능
    this.focus();
}


//////////////////////////////////////////////////////////////////////////////////
// 함수명 : ee_enter_submit()
// 메소드명 : element.enterSubmit(parent)
// 내    용 : 
//
function ee_enter_submit(){
    
    if (event.keyCode==13)  kjsSubmit(this.ikey_value);

}

function ee_keyup_float(){
    this.filter = /([^.0-9])/g ; //숫자외의 모든것- 숫자만 입력가능
    
    if (skipKeyCode(event.keyCode)) return; //필요한 키는 건너뛴다.
    if (!this.value) return;
    this.value = this.value.replace(this.filter , ""); //숫자만 입력가능
	if ((this.value.split(".")).length > 2)	this.value = this.value.substring(0,this.value.lastIndexOf("."));

    this.focus();
}

