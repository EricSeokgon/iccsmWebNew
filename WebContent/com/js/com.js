	function MM_swapImgRestore() { //v3.0
	  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
	}

	function MM_preloadImages() { //v3.0
	  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
		var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
		if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
	}

	function MM_findObj(n, d) { //v4.01
	  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	  if(!x && d.getElementById) x=d.getElementById(n); return x;
	}

	function MM_swapImage() { //v3.0
	  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
	}

	//경고 메세지 출력
	function msg(str){
		alert(str);
		return false;
	}
	
	//경고 메세지를 띠우고 해당 폼으로 간다.
	function errMsg(str,returnForm){
		alert(str+" 입력이 잘못 되었습니다.");
		returnForm.focus();
		return false;
	}
	
	/*팝업창 화면 중앙에 띄우기*/
	function centerwin(path,winname, w, h,scroll){
		winToTop = (screen.height) ? (screen.height-h)/2 : 0;
		winToLeft = (screen.width) ? (screen.width-w)/2 : 0;
		making ='width='+w+',height='+h+',top='+winToTop+',left='+winToLeft+',scrollbars='+scroll+',resizable=0'
		winname = window.open(path,winname,making)//새창으로 나타날 문서의 경로 지정
		winname.focus();
	}
		
    //최상위 체크 로직(chars로 넘긴 값이 있다면 true)
    function containsCharsOnly(input,chars) {
        for (var inx = 0; inx < input.value.length; inx++) {
            if (chars.indexOf(input.value.charAt(inx)) == -1)
                return false;
        }
        return true;
    }

    //최상위 체크 로직(chars로 넘긴 값이 있다면 false)
    function containsChars(input,chars) {
        for (var inx = 0; inx < input.value.length; inx++) {
           if (chars.indexOf(input.value.charAt(inx)) != -1)
               return true;
        }
        return false;
    }

    // 숫자 체크
    function isNum(input) {
        var chars = "0123456789";
        return containsCharsOnly(input,chars);
    }

    //이름체크
    function nameCheck(input){
     var chars = '0123456789~!@#$%^&*()_-+=|{}[]<>,./?';
           return containsChars(input,chars);
    }

    // 전화 번호 Check
    function isPhoneCheck(input) { 
     var chars = "0123456789( ).-,<>{}[]_~";
        return containsCharsOnly(input,chars);
    }

    // 영문 판별
    function isEngCheck(input) { 
     var chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return containsCharsOnly(input,chars);
    }

    // 영숫자 판별
    function isEngNumCheck(input) { 
     var chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return containsCharsOnly(input,chars);
    }

    // 입력값이 숫자,대시(-)로 되어있는지 체크
    function isNumDash(input) {
        var chars = "-0123456789";
        return containsCharsOnly(input,chars);
    }

    // 입력값이 숫자,콤마(,)로 되어있는지 체크
    function isNumComma(input) {
        var chars = ",0123456789";
        return containsCharsOnly(input,chars);
    }

    // 입력값이 사용자가 정의한 포맷 형식인지 체크
    // 자세한 format 형식은 자바스크립트의 ''regular expression''을 참조
    function isValidFormat(input,format) {
        if (input.value.search(format) != -1) {
            return true; //올바른 포맷 형식
        }
        return false;
    }

    /**
     * 입력값이 이메일 형식인지 체크
     * ex) if (!isValidEmail(form.email)) {
     *         alert("올바른 이메일 주소가 아닙니다.");
     *     }
     */
    function isValidEmail(input) {

        var format = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
        return isValidFormat(input,format);
    }

    /**
     * 입력값이 전화번호 형식(숫자-숫자-숫자)인지 체크
     */
    function isValidPhone(input) {
        var format = /^(\d+)-(\d+)-(\d+)$/;
        return isValidFormat(input,format);
    }

    // 콤마 없애기
    function removeComma(input) {
        return input.value.replace(/,/gi,"");
    }

    // 문자 변환 함수
    function alterString(str,before,after) {
     var returnStr = "";
     for(i = 0; i < str.length; i++) {
      value = str.charAt(i);
      index = before.indexOf(value);
      if(index >= 0) value = after.charAt(index);
      returnStr += value;
     }
     return returnStr;
    }

    // 소 --> 대문자 변환 함수
    function ToUpper(arg) {
     var str1 = "abcdefghijklmnopqrstuvwxyz";
     var str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     return alterString(arg,str1,str2);
    }

    // 대 --> 소문자 변환 함수
    function ToLower(arg){
     var str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     var str2 = "abcdefghijklmnopqrstuvwxyz";
     return alterString(arg,str1,str2);
    }

    // 반각 문자를 전각문자로
    function convert2ByteChar(x_char) {
        var x_2byteChar = ""; //컨버트된 문자
        var c = x_char.charCodeAt(0);
        if(32 <= c && c <= 126) { //전각으로 변환될수 있는 문자의 범위
            if(c == 32) { //스페이스인경우 ascii 코드 32
                x_2byteChar = unescape("%uFFFC");
            } else {
                x_2byteChar = unescape("%u"+gf_DecToHex(c+65248));
            }
        }
        return  x_2byteChar;
    }

    // 10진수를 16진수로
    function gf_DecToHex(x_dec) {
        var x_Hex = new Array();
        var x_serial = 0;
        var x_over16 = x_dec;
        var x_tempNum = 0;
        while(x_dec > 15) {
            var x_h = x_dec % 16; //나머지
            x_dec = parseInt(x_dec/16); //몫
            x_Hex[x_serial++] = (x_h > 9 ? String.fromCharCode(x_h + 55) : x_h); //16진수코드변환
        }
        //마지막은 몫의 값을 가짐
        x_Hex[x_serial++] = (x_dec > 9 ? String.fromCharCode(x_dec + 55) : x_dec); //16진수코드변환
        //몫,나머지,나머지,.....
        var retValue = "";
        for(var i=x_Hex.length ; i>0 ;i--) {
            retValue += x_Hex[i-1];
        }
        return retValue;
    }

    // input box에 space, &nbsp;등 만으로 넣고 장난 칠때 이들 문자 뺀 길이를 통해 유효성 체크한다...
    function CheckStr(strOriginal, strFind, strChange){ 
        var position, strOri_Length; 
        position = strOriginal.indexOf(strFind);  
        while (position != -1){ 
            strOriginal = strOriginal.replace(strFind, strChange); 
            position = strOriginal.indexOf(strFind); 
        } 
        strOri_Length = strOriginal.length; 
        return strOri_Length; 
    } 

    // 체크 박스에 체크가 되어 있으면 true
    function checkValidator(str) { 
     if(str.checked) return true; 
     else return false;
    }

    // 비밀번호는 4자 등 최대 최소 길이를 파람으로 주고 처리... 
    function checkLength(str,minLng,maxLng){
        var ckstr = str.value.length; 
        if (parseInt(ckstr) < parseInt(minLng) || parseInt(ckstr) > parseInt(maxLng)) return false;
        return true;
    }

    // 숫자만 받아서 아니면 메세지 보여 주는 
    function onlyNumber(objEv) {
        if(!isNum(objEv)){
            alert("숫자만 입력가능합니다.");
            objEv.value = "";
            objEv.focus();
            return;
        }
    }

    // 숫자를 체크하다가 6자 등 원하는 만큼 이동후 다음 input 박스로 이동 시키는...
    function goJump(fname, len, goname){
        onlyNumber(fname);
        if (document.all[fname].value.length == len) document.all[goname].focus();
    }

    // 주민등록번호 체크 로직
    function check_ResidentNO(str_f_num,str_l_num){  
        var i3=0
        for (var i=0;i<str_f_num.length;i++){
         var ch1 = str_f_num.substring(i,i+1);
            if (ch1<'0' || ch1>'9') i3=i3+1;
        }
        if ((str_f_num == '') || ( i3 != 0 )) return false;
        var i4=0;
        for (var i=0;i<str_l_num.length;i++){
            var ch1 = str_l_num.substring(i,i+1);
            if (ch1<'0' || ch1>'9') i4=i4+1; 
        }
        if ((str_l_num == '') || ( i4 != 0 )) return false;
        if(str_f_num.substring(0,1) < 4) return false;
        if(str_l_num.substring(0,1) > 2) return false;
        if((str_f_num.length > 7) || (str_l_num.length > 8)) return false;
        if ((str_f_num == '72') || ( str_l_num == '18'))  return false;
                
        var f1=str_f_num.substring(0,1)
        var f2=str_f_num.substring(1,2)
        var f3=str_f_num.substring(2,3)
        var f4=str_f_num.substring(3,4)
        var f5=str_f_num.substring(4,5)
        var f6=str_f_num.substring(5,6)
        var hap=f1*2+f2*3+f3*4+f4*5+f5*6+f6*7
        var l1=str_l_num.substring(0,1)
        var l2=str_l_num.substring(1,2)
        var l3=str_l_num.substring(2,3)
        var l4=str_l_num.substring(3,4)
        var l5=str_l_num.substring(4,5)
        var l6=str_l_num.substring(5,6)
        var l7=str_l_num.substring(6,7)
        hap=hap+l1*8+l2*9+l3*2+l4*3+l5*4+l6*5
        hap=hap%11
        hap=11-hap
        hap=hap%10
        if (hap != l7) return false;
        return true; 
    }
    
    // 3자리 씩 콤마를 찍어 준다
    function moneyComma(number) {
         number = '' + Math.round(number);

         if (number.length > 3) {
         var mod = number.length % 3;
         var output = (mod > 0 ? (number.substring(0,mod)) : '');


         for (i=0 ; i < Math.floor(number.length / 3); i++) {
              if ((mod == 0) && (i == 0)) output += number.substring(mod+ 3 * i, mod + 3 * i + 3);
              else output+= ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
         }
         return (output);
         }
         else return number;
		}

    // 바이트 구하기
    function getByteLen(str){
        return(str.length+(escape(str)+"%u").match(/%u/g).length-1);
    }

    // url 가져오기
    function getUrlAddress(){
        var pageUrl = document.location; 
     pageUrl  = new String(pageUrl);
      return pageUrl.substring(0,pageUrl.lastIndexOf("/"));
    }

    // 오른마우스 금지, 나중에 해당 주석 풀고 사용
    function rightbutton(e){
        if (navigator.appName == 'Netscape' &&  (e.which == 3 || e.which == 2))
            return false;
        else if (navigator.appName == 'Microsoft Internet Explorer' && (event.button == 2 || event.button == 3))
        {
            alert("죄송합니다!! 정보무단복제를 막기 위하여 오른쪽 마우스 사용을 허용하지 않습니다.");
            return false;
        }
        return true;
    }

    //document.onmousedown=rightbutton;
    
    // 컨트롤 키 금지, 나중에 해당 주석 풀고 사용
    function checkCtl(){
        if (document.all){
            if(event.keyCode==17) {
                alert("죄송합니다!! 컨트롤키 사용을 허용하지 않습니다.");
                return false;
            }
        }
    }
    //document.onkeydown = checkCtl;


    function setCookie(name,value) {
        document.cookie = name+"="+escape(value)+";path=/;domain=.kkaok.pe.kr;";
    }

    //쿠키관련
    function setCookie(name,value, expires) {
        document.cookie = name + "=" + escape(value) +
        "; path=/; expires=" + expires.toGMTString();
    }

    function getCookie(Name) {
        var search = Name + "="
        if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
            offset = document.cookie.indexOf(search)
            if (offset != -1) { // 쿠키가 존재하면
                offset += search.length
                // set index of beginning of value
                end = document.cookie.indexOf(";", offset)
                // 쿠키 값의 마지막 위치 인덱스 번호 설정
                if (end == -1)
                    end = document.cookie.length
                return unescape(document.cookie.substring(offset, end));
            }
        }
    }

   //문자 바꾸기, 사용법 var str = 문자열.replaceAll("a", "1");  
    String.prototype.trim = function(){
        return this.replace(/(^\s*)|(\s*$)/gi, "");
    }

    String.prototype.replaceAll = function(str1, str2) {
        var temp_str = "";
        if (this.trim() != "" && str1 != str2) {
            temp_str = this.trim();
            while (temp_str.indexOf(str1) > -1){
                temp_str = temp_str.replace(str1, str2);
            }
        }
        return temp_str;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////
	// 함수명 : chkBoxCheck()
	// 내  용 : 체크 박스의 선택된 항목이 있는지 검사.
	// 사용법: chkName에 체크박스 명 입력
	// 반   환 : 선택된 값이 있으면 true 반환
	function chkBoxCheck(chkName){
		var fm = document.fmParam;
		
		chkCount = 0;
		chkBoxNums = 0;
		
		for(i = 0;i < fm.elements.length;i++){
			if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName){
	        	chkBoxNums ++;
	        }
		}
		
		if(chkBoxNums == 0){
			alert("삭제 할 항목이 없습니다.");
			return false;
		}
		   
		for(i = 0;i < fm.elements.length;i++){
			if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName && fm.elements[i].checked == true){
		       	chkCount ++;
		    }
		}
		
		if(chkCount == 0){
			alert("삭제 할 항목을 선택해 주십시오");
			return false;
		}	
		return true;
	}
	
	
	//체크 박스 전체 선택 및 전체 해제
	function selectAll(chkName) {
	
	        var fm = document.fmParam;
	        
			for(i = 0;i < fm.elements.length;i++){
				if(fm.elements[i].type == "checkbox" && fm.elements[i].name == chkName){
		        	fm.elements[i].checked = !fm.elements[i].checked;
		        }
		    }       
		      
	}
	
	
	/////////////////////////////페이지 이동 스크립트////////////////////////////
	function movePage(page){
	    var fm= document.fmParam;
	    
		fm.nowPage.value= page;
	    fm.method = "post";
	    fm.submit();
	}
	
	function changeRowPerPage(obj){
	    var fm= document.fmParam;
	    
	    fm.rowPerPage.value= obj.value;
	    fm.nowPage.value="1";
	    fm.method = "post";
	    fm.submit();
	}
	/////////////////////////////페이지 이동 스크립트////////////////////////////
	
	
	/////////////////////////////달력 스크립트////////////////////////////
	function MM_findObj(n, d) { //v4.01
	  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
	    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	  if(!x && d.getElementById) x=d.getElementById(n); return x;
	}
	
	function MM_showHideLayers() { //v6.0
	  var i,p,v,obj,args=MM_showHideLayers.arguments;
	  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
	    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
	    obj.visibility=v; }
	}
	function click_where() {
	        MM_showHideLayers('div_start','','hide');
	        MM_showHideLayers('div_end','','hide');
	         MM_showHideLayers('div_day','','hide');
	}
	document.onmousedown=click_where;
	/////////////////////////////달력 스크립트////////////////////////////
    
	//inputbox에서 엔터를 쳤을때 필요한 함수를 호출
	//ex) inputbox에 onKeydown="execFuncOnEnt('IDCheck')" 문구를 삽입시
	//엔터를 쳤을경우 IDCheck() 함수 호출
	function execFuncOnEnt(callback) {
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyCode == 13) {
			eval(callback).call();
		}
	}

