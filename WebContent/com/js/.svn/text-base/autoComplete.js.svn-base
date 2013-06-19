function paramEscape(paramValue)
{
   return encodeURIComponent(paramValue);
}


function keywordKeyDown()
{
    var keyCode = window.event.keyCode;

    if(keyCode ==  9)   return;     //Tab 키
    if(keyCode == 13)   return;     //Enter 키
    if(keyCode == 16)   return;     //Shift 키
    if(keyCode == 16)   return;     //Ctrl 키
    if(keyCode == 18)   return;     //Alt 키
    if(keyCode == 45)   return;     //Ins 키
    if(keyCode == 46)   return;     //Del 키
    if(keyCode == 33)   return;     //PgUp 키
    if(keyCode == 34)   return;     //PgDn 키
    if(keyCode == 35)   return;     //End 키
    if(keyCode == 36)   return;     //Home 키

    if(keyCode >= 37 && keyCode <= 40)   return;     //방향키

    //Keydown 이벤트 발생 시점에는 아직 TextField에 사용자가 입력한 키 값이 설정되지 않았기 때문에
    //브라우저가 이벤트에 반응하여 값을 설정할때 까지 잠시 기다린다.
    setTimeout('searchWord()', 250);

}


function formData2QueryString(docForm)
{
   var submitString = '';
   var formElement = '';
   var lastElementName = '';

   for(i = 0 ; i < docForm.elements.length ; i++)
   {
     formElement = docForm.elements[i];
     switch(formElement.type)
     {
        case 'text' :
        case 'select-one' :
        case 'hidden' :
        case 'password' :
        case 'textarea' :
           submitString += formElement.name + '=' + paramEscape(formElement.value) + '&';
           break;
        case 'radio' :
           if(formElement.checked)
           {
             submitString += formElement.name + '=' + paramEscape(formElement.value) + '&';
           }
           break;
        case 'checkbox' :
           if(formElement.checked)
           {
             if(formElement.name == lastElementName)
             {
                if(submitString.lastIndexOf('&') == submitString.length - 1)
                {
                   submitString = submitString.substring(0, submitString.length - 1);
                }
                submitString += ',' + paramEscape(formElement.value);
             }
             else
             {
                submitString += formElement.name + '=' + paramEscape(formElement.value);
             }
             submitString += '&';
             lastElementName = formElement.name;
           }
           break;
     }
   }
   //alert(submitString);
   submitString = submitString.substring(0, submitString.length - 1);
   //alert(submitString);
   return submitString;

}

function xmlHttpPost(actionUrl, submitParameter, resultFunction)
{
   var xmlHttpRequest = false;

   //IE인경우
   if(window.ActiveXObject)
   {
     //xmlHttpRequest = new ActiveXObject('Microsoft.XMLHTTP');
     
     	/*2007-05-19 김동엽 추가*/
		var ms_xml_http = new Array('Msxml2.XMLHTTP.7.0','Msxml2.XMLHTTP.6.0','Msxml2.XMLHTTP.5.0','Msxml2.XMLHTTP.4.0','Msxml2.XMLHTTP.3.0','Msxml2.XMLHTTP','Microsoft.XMLHTTP');
		
		for (var i = 0; i < ms_xml_http.length; i++){
			try{
				xmlHttpRequest = new ActiveXObject(ms_xml_http[i]);
			}catch (e){
				xmlHttpRequest = null;
			}
		}
		
     
   }
   else
   {
     xmlHttpReq = new XMLHttpRequest();
     xmlHttpReq.overrideMimeType('text/xml');
   }

   xmlHttpRequest.open('POST', actionUrl, true);
   xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
   xmlHttpRequest.onreadystatechange = function() {
     if(xmlHttpRequest.readyState == 4)
     {
        switch (xmlHttpRequest.status)
        {
           case 404:
             //alert('오류: ' + actionUrl + '이 존재하지 않음');
             break;
          case 500:
             //alert('오류: ' + xmlHttpRequest.responseText);
             break;
          default:
             eval(resultFunction + '(xmlHttpRequest.responseText);');
             break;
        }
     }
   }

   xmlHttpRequest.send(submitParameter);
}

function xmlHttpGet(actionUrl, resultFunction, selName)
{
   var xmlHttpRequest = false;

   //IE인경우
   if(window.ActiveXObject)
   {
     xmlHttpRequest = new ActiveXObject('Microsoft.XMLHTTP');
   }
   else
   {
     xmlHttpReq = new XMLHttpRequest();
     xmlHttpReq.overrideMimeType('text/xml');
   }
   
   xmlHttpRequest.open('GET', actionUrl, true);
   xmlHttpRequest.onreadystatechange = function() {
     if(xmlHttpRequest.readyState == 4)
     {
        if(xmlHttpRequest.status == 404){
             //alert('오류: ' + actionUrl + '이 존재하지 않음');
        }else if(xmlHttpRequest.status == 500){
             //alert('오류: ' + xmlHttpRequest.responseText);
        }else{
        	if(resultFunction == 'selectResult'){
        		eval(resultFunction + '(xmlHttpRequest.responseXML,\'' + selName + '\');');
        	}else{
        		if(selName=='selText'){
        			eval(resultFunction + '(xmlHttpRequest.responseText);');
        		}else{
             		eval(resultFunction + '(xmlHttpRequest.responseXML);');
             	}
            }
        }
     }
   }

   xmlHttpRequest.send(null);
}



//특정 키 검색용
function searchResult(result)
{
	var items 	= result.getElementsByTagName("item");
	var keys 	= result.getElementsByTagName("code");

    if(items.length<=0)
    {

    }
    else
    {
    	setSearchWord(keys[0].firstChild.nodeValue);
    }
}

//자동 완성용
function viewResult(result)
{
	var items 	= result.getElementsByTagName("item");
	var values 	= result.getElementsByTagName("name");
    var keys 	= result.getElementsByTagName("code");

	searchEnd();

    if(items.length<=0)
    {
        var searchKeywordDiv = document.all("searchKeywordDiv");
        searchKeywordDiv.innerHTML = "";
        searchKeywordDiv.style.visibility = "hidden";
    }
    else
    {
		var viewResult = '<div align=right><A href ="javascript:hiddenResult();">[닫기]</A></div>';
		var resultValues = '';
        for(i = 0 ; i < items.length; i++)
        {
			resultValues = values[i].firstChild.nodeValue.replaceAll('\"','&quot;');
			resultValues = resultValues.replaceAll('\'','&amp;&#35;&#51;&#57;&#59;');
            viewResult += '<A href="javascript:setKeyword(\'' + keys[i].firstChild.nodeValue +'\',\'' + resultValues + '\');hiddenResult();">' + values[i].firstChild.nodeValue + '</A><BR>';
        }
        var searchKeywordDiv = document.all("searchKeywordDiv");
        searchKeywordDiv.innerHTML = viewResult;
        searchKeywordDiv.style.visibility = "visible";
    }
}

//셀렉트 박스 자동 변경용
function selectResult(result,selName)
{	
	var sel = document.getElementById(selName);

	var items 	= result.getElementsByTagName("item");
	var values 	= result.getElementsByTagName("name");
    var keys 	= result.getElementsByTagName("code");

	
	//해당데이터를 가져왔을때 객체의 disabled 상태를 해제한다.
	//sel.disabled = false;

	clearSelectList(selName);

    if(items.length<=0){
    	option = new Option("해당내용 없음","");
	    sel.options[0] = option;
   	}else{
   		option = new Option("-선택-","");
   		sel.options[0] = option;
        for(var i = 0; i < items.length; i++) {
	        option = new Option(trim(values[i].firstChild.nodeValue),trim(keys[i].firstChild.nodeValue));
	        sel.options[i+1] = option;
	    }
	}

	//if(sel.size == 0) sel.reInitializeSelectBox();

}


function clearSelectList(selName) {
    var sel = document.getElementById(selName);
    while(sel.childNodes.length > 0) {
        sel.removeChild(sel.childNodes[0]);
    }
}

function hiddenResult()
{
    var searchKeywordDiv = document.all("searchKeywordDiv");
    searchKeywordDiv.innerHTML = "";
    searchKeywordDiv.style.visibility = "hidden";
}


function trim(str){
 // 정규 표현식을 사용하여 화이트스페이스를 빈문자로 전환
 str = str.replace(/^\s*/,'').replace(/\s*$/, '');
 return str;
}

function searchEnd(){
	//검색종료시 실행
}