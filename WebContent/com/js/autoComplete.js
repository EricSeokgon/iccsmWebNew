function paramEscape(paramValue)
{
   return encodeURIComponent(paramValue);
}


function keywordKeyDown()
{
    var keyCode = window.event.keyCode;

    if(keyCode ==  9)   return;     //Tab Ű
    if(keyCode == 13)   return;     //Enter Ű
    if(keyCode == 16)   return;     //Shift Ű
    if(keyCode == 16)   return;     //Ctrl Ű
    if(keyCode == 18)   return;     //Alt Ű
    if(keyCode == 45)   return;     //Ins Ű
    if(keyCode == 46)   return;     //Del Ű
    if(keyCode == 33)   return;     //PgUp Ű
    if(keyCode == 34)   return;     //PgDn Ű
    if(keyCode == 35)   return;     //End Ű
    if(keyCode == 36)   return;     //Home Ű

    if(keyCode >= 37 && keyCode <= 40)   return;     //����Ű

    //Keydown �̺�Ʈ �߻� �������� ���� TextField�� ����ڰ� �Է��� Ű ���� �������� �ʾұ� ������
    //�������� �̺�Ʈ�� �����Ͽ� ���� �����Ҷ� ���� ��� ��ٸ���.
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

   //IE�ΰ��
   if(window.ActiveXObject)
   {
     //xmlHttpRequest = new ActiveXObject('Microsoft.XMLHTTP');
     
     	/*2007-05-19 �赿�� �߰�*/
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
             //alert('����: ' + actionUrl + '�� �������� ����');
             break;
          case 500:
             //alert('����: ' + xmlHttpRequest.responseText);
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

   //IE�ΰ��
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
             //alert('����: ' + actionUrl + '�� �������� ����');
        }else if(xmlHttpRequest.status == 500){
             //alert('����: ' + xmlHttpRequest.responseText);
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



//Ư�� Ű �˻���
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

//�ڵ� �ϼ���
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
		var viewResult = '<div align=right><A href ="javascript:hiddenResult();">[�ݱ�]</A></div>';
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

//����Ʈ �ڽ� �ڵ� �����
function selectResult(result,selName)
{	
	var sel = document.getElementById(selName);

	var items 	= result.getElementsByTagName("item");
	var values 	= result.getElementsByTagName("name");
    var keys 	= result.getElementsByTagName("code");

	
	//�ش絥���͸� ���������� ��ü�� disabled ���¸� �����Ѵ�.
	//sel.disabled = false;

	clearSelectList(selName);

    if(items.length<=0){
    	option = new Option("�ش系�� ����","");
	    sel.options[0] = option;
   	}else{
   		option = new Option("-����-","");
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
 // ���� ǥ������ ����Ͽ� ȭ��Ʈ�����̽��� ���ڷ� ��ȯ
 str = str.replace(/^\s*/,'').replace(/\s*$/, '');
 return str;
}

function searchEnd(){
	//�˻������ ����
}