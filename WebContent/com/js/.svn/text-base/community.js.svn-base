// 한글 문자를 자른다.
function substringKor2(str,lengths)
{
      var len = 0;
      var newStr = '';
  
      for (var i=0;i<str.length; i++) 
      {
        var n = str.charCodeAt(i);
        var nv = str.charAt(i);
        if ((n>= 0)&&(n<256)) len ++;
        else len += 2;
        if (len>lengths) break;
        else newStr = newStr + nv;
      }
      return newStr;
}

// 한글 길이를 구한다.
function checkLengthKor(oField, min, max, strMsg, blnFocus)
{
	var isValid = false;
	var lengthValue = oField.value.bytes();
	
	if (min < 0)
	{
		if (lengthValue < max)
			isValid = true;
	}
	if (max < 0)
	{
		if (lengthValue > min)
			isValid = true;
	}
	if (min >= 0 && max >= 0)
	{
		if (lengthValue >= min && lengthValue <= max)
			isValid = true;
	}
		
	if (!isValid)
	{
		_alertMessage(strMsg);
		_focusField(oField, blnFocus);
	}
	
	return isValid;
}

// 문자길이를 구한다.
function strLenCk(str)
{
  var len = 0;
  for (var i=0;i<str.length; i++) {
    var n = str.charCodeAt(i);
    if ((n>= 0)&&(n<256)) {
      len ++;
    } else {
      len += 2;
	}
  }
  return len;
}

// 바이트를 구한다.
String.prototype.bytes = function() 
{
    var str = this;
    var l = 0;
    for (var i=0; i<str.length; i++) 
        l += (str.charCodeAt(i) > 128) ? 2 : 1;

    return l;
}

// 메세지창 
function _alertMessage(strMsg)
{
	if (typeof(strMsg) != 'undefined' && strMsg != "")
		alert(strMsg);
}

// 포커스 필드 
function _focusField(oField, blnFocus)
{
	if (typeof(blnFocus) != 'undefined' && blnFocus != null && blnFocus == true)
		_getField(oField).focus();
}

// 필드타입 가져오기
function _getFieldType(oField)
{
	return _getField(oField).type;
}

// 필드 가져오기
function _getField(oField)
{
	if (typeof(oField.type) == 'undefined' && typeof(oField.length) != 'undefined')
		return oField[0];
	else
		return oField;
}