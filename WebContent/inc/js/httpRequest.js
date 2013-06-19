var httpRequest;
var callbackFunc;

function getXMLHttpRequest() {
	var xmlreq;

	if (window.ActiveXObject) {
		try {
			xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) { }
		}
	}else if (window.XMLHttpRequest) {
		xmlreq = new XMLHttpRequest();
	}
	return xmlreq;
}

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : "GET";
	if (method!="GET" && method!="POST") method = "GET";
	
	var httpParams = (params==null || params =="") ? null : params;
	
	var httpUrl = url;
	if (httpMethod == "GET" && httpParams != null) httpUrl = httpUrl + "?" + httpParams;
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	callbackFunc = eval(callback);
	httpRequest.onreadystatechange = processReq;
	httpRequest.send(httpMethod == "POST" ? httpParams : null );
//alert(httpUrl+"/"+httpParams);
}

function processReq() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			callbackFunc.call();
		} else {
			alert("There was a problem retrieving the XML data:\n" + REQ.statusText);
		}
	}
}
