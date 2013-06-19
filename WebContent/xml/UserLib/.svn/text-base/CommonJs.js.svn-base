﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿//////////////////////////////////////////////////////////////////
// 전역함수들
//////////////////////////////////////////////////////////////////

function fnCopyRowByColumnName(srcDataset, destDataset)
{
	for(var nLoop = 0; nLoop < srcDataset.colcount; nLoop++)
	{
		var sSrcName = srcDataset.GetColID();
		for(var nIdx = 0; nIdx < destDataset.colcount; nIdx++)
		{
			var sDestName = destDataset.GetColID();
			if(sSrcName == sDestName)
			{
				destDataset.SetColumn(0, sDestName, srcDataset.GetColumn(0, sSrcName));
			}
		}
	}
}
	
function fnDisplayErrorMsg(obj)
{
	var bReturn = false;
	var sObjType = toUpper(obj.GetType());
	
	if(sObjType == "EDIT" && !obj.Readonly )
	{
		if(!fnEmpty(obj.UserData) && fnEmpty(obj.Text))
		{
			alert(obj.UserData);
			bReturn = true;
		}
	}
	
	if((sObjType == "MASKEDIT" || sObjType == "CALENDAR") && obj.Enable)
	{
		if(!fnEmpty(obj.UserData) && fnEmpty(obj.Value))
		{
			alert(obj.UserData);
			bReturn = true;
		}
	}
	
	return bReturn;
}

function fnCreateDialog(strURL, sArgs)
{
	var sReturn = Dialog(strURL, sArgs);
	return sReturn;
}

// 사용자가 크기를 변경할 수 있는 다이얼로그
function fnCreateDialogResize(strURL, sArgs)
{
	var sReturn = Dialog(strURL, sArgs, -1, -1, "Resize=true Scroll=true");
	return sReturn;
}

function fnEmpty(strText)
{
	// 2010.01.15. Length() 를 통해 체크하면 안된다.
	if( strText == null || strText == "" )
		return true;
	else
		return false;
}

function fnGridToExcel(obj, sSheetName)
{
	obj.ExportExcelEx(sSheetName);
}

function fnGridHead_Click(obj,nCell,nX,nY,nPivotIndex)
{
	var objDs = obj.BindDataset;

	if (object(objDs).RowCount() == 0)
		return;
	 
	if (obj.GetCellProp("head", nCell, "edit") == "checkbox")
	{
		if(obj.GetCellProp("head", nCell, "text") == "1")
		{
			obj.SetCellProp("head", nCell, "text", "0");
			fnSetGridCheck(0, objDs, "CHECKER");
		}
		else
		{
			obj.SetCellProp("head", nCell, "text", "1");
			fnSetGridCheck(1, objDs, "CHECKER");
		}
		
		object(objDs).ApplyChange();
	}
	else
	{
		for(var nLoop = 0; nLoop < obj.GetColCount(); nLoop++)
		{
			//alert(nLoop + '===' + nCell);
			if(nLoop == nCell) continue;
			
			obj.SetCellProp("head", nLoop, "text", replace(obj.GetCellProp("head", nLoop, "text"), "▼", ""));
			obj.SetCellProp("head", nLoop, "text", replace(obj.GetCellProp("head", nLoop, "text"), "▲", ""));
		}
		
		var sHeadName = obj.GetCellProp("head", nCell, "text");
		var sColName = obj.GetCellProp("body", nCell, "colid");
		
		if (right(sHeadName, 1) == "▼") 
		{
			object(objDs).Sort(sColName, true);
			obj.SetCellProp("head", nCell, "text", replace(sHeadName, "▼", "▲"));
		}
		else if (right(sHeadName, 1) == "▲") 
		{
			object(objDs).Sort(sColName, false);
			obj.SetCellProp("head", nCell, "text", replace(sHeadName, "▲", "▼"));
		}
		else
		{
			object(objDs).Sort(sColName, true);
			obj.SetCellProp("head", nCell, "text", sHeadName + "▼");
		}
	}
}

function fnSetGridCheck(sValue, objDs, sCol)
{
	for (var nLoop = 0; nLoop < object(objDs).RowCount(); nLoop++)
	{
		object(objDs).SetColumn(nLoop, sCol, sValue);
	}
}

function fnMakeKeyDataSet(p_KeyParams)
{
	var sColumn = split(p_KeyParams, ",");

	Create("Dataset", "dsTemp");
	var ds = object("dsTemp");
	
	if (ds == NULL)
	{
		alert("데이터셋 생성 오류 - fn_MakeKeyDataSet");
		return;
	}
	
	for (var nCount = 0; nCount < sColumn.Length(); nCount++)
	{
		ds.AddColumn(trim(sColumn[nCount]));
	}
	
	dsTemp.Fireevent = true;
	
	return ds;
}

/**
 1. 함수명 : fnRejectChange
 2. 기  능 : 데이터셋의 변경내용 취소
 3. Params 
    dChangeDS : 취소할 데이터셋
 4. Return
    없음
*/
function fnRejectChange(dChangeDS)
{
	if(!dChangeDS.UpdateControl) return;
	
	for(var nLoop = 0; nLoop < dChangeDS.RowCount(); nLoop++)
	{
		if(dChangeDS.getRowtype(nLoop) <> "normal")
		{
			for(var nColIndex = 0; nColIndex < dChangeDS.GetColCount(); nColIndex++)
			{
				if(dChangeDS.GetColumn(nLoop, nColIndex) <> dChangeDS.GetOrgColumn(nLoop, nColIndex))
				{
					dChangeDS.SetColumn(nLoop, nColIndex, dChangeDS.GetOrgColumn(nLoop, nColIndex));
				}
			}
		}
	}
}

function fnFindComponent(oParent, sComponent)
{
	for (var nCount = 0; nCount < oParent.Components.Count; nCount++)
	{
		var cTarget = oParent.Components[nCount];
		var sChildName = toUpper(cTarget.GetType());
		
		if (cTarget.Id == sComponent) 
		{
			cTarget.SetFocus();
		}
		
		if (sChildName == "DIV" || sChildName == "TAB" || sChildName == "TABPAGE")
		{
			fnFindComponent(cTarget, sComponent);
		}
	}
	
	return;
}

/**
 1. 함수명 : fnControlState
 2. 기  능 : 각 컨트롤에 대한 활성화 여부 설정
 3. Params 
    @obj : 대상 컨트롤
    @bFlag : 활성화 여부
 4. Return
    없음
*/
function fnControlState(bFlag, oParent, sComponent)
{
	if (sComponent == null)
	{
		oParent.Enable = bFlag;
		return;
	}
	
	var arrComponent = split(sComponent, ",");
	
		
	for(var nLoop = 0; nLoop < arrComponent.length(); nLoop++)
	{
		for (var nCount = 0; nCount < oParent.Components.Count; nCount++)
		{
			var cTarget = oParent.Components[nCount];
			
			if (cTarget.Id == trim(arrComponent[nLoop]))
			{	
				var sTargetname = toUpper(cTarget.GetType());

				if(sTargetname == "EDIT" || sTargetname == "MASKEDIT" || sTargetname == "TEXTAREA")
				{
					cTarget.Readonly = !bFlag;
					if (cTarget.Readonly) cTarget.BKColor = "#dedede";
					else cTarget.BKColor = "#FFFFFF";
				}
				if(sTargetname == "COMBO" || sTargetname == "CALENDAR" || sTargetname == "GRID" ||
				sTargetname == "BUTTON" || sTargetname == "RADIO")
				{
					cTarget.Enable = bFlag;
					if(sTargetname == "GRID" || sTargetname == "RADIO") continue;
					if (!cTarget.Enable) cTarget.DisableBKColor = "#dedede";
					else cTarget.BKColor = "#FFFFFF";
				}				
			}
		}
	}
}

function fnAllControlState(bFlag, obj)
{
	var nCount = obj.Components.Count;

	for(var nLoop = 0; nLoop < nCount; nLoop++ )
	{
		var objChild = obj.Components[nLoop];
		var sChildName = toUpper(objChild.GetType());
		
		if (sChildName == "DATASET")
		{
			continue;
		}
		
		if (sChildName == "DIV" || sChildName == "TAB" || sChildName == "TABPAGE")
		{
			fnAllControlState(bFlag, objChild);
		}
		else
		{
			if (sChildName == "MASKEDIT" || sChildName == "EDIT" || sChildName == "TEXTAREA")
			{
				objChild.Readonly = !bFlag;
				if (objChild.Readonly) objChild.BKColor = "#dedede";
				else 
				{
					if (trim(objChild.UserData) = "Y")
						objChild.BKColor = "#FFCCCC";
					else
						objChild.BKColor = "#FFFFFF";
				}
			}
			else if (sChildName == "COMBO" || sChildName == "CALENDAR" || sChildName == "GRID"
			|| sChildName == "BUTTON" || sChildName == "RADIO")
			{
				objChild.Enable = bFlag;
				if(sChildName == "GRID" || sChildName == "RADIO") continue;
				if (!objChild.Enable) objChild.DisableBKColor = "#dedede";
				else objChild.BKColor = "#FFFFFF";
			}
		}
	}
}

function fnSetMenuInsertButtonAuth(nAuth, bFlag)
{
	var bAuth = false;
	if (nAuth == 1) //읽기
	{
		bAuth = false;
	}
	if (nAuth == 2) //쓰기
	{
		bAuth = true;
	}
	
	return (bAuth && bFlag);
}

function fnSetMenuModifyButtonAuth(nAuth, bFlag)
{
	var bAuth = false;
	if (nAuth == 1) //읽기
	{
		bAuth = false;
	}
	if (nAuth == 2) //쓰기
	{
		bAuth = true;
	}
	
	return (bAuth && bFlag);
}

function fnSetMenuRemoveButtonAuth(nAuth, bFlag)
{
	var bAuth = false;
	if (nAuth == 1) //읽기
	{
		bAuth = false;
	}
	if (nAuth == 2) //쓰기
	{
		bAuth = true;
	}
	
	return (bAuth && bFlag);
}

function fnSetMenuSaveButtonAuth(nAuth, bFlag)
{
	var bAuth = false;
	if (nAuth == 1) //읽기
	{
		bAuth = false;
	}
	if (nAuth == 2) //쓰기
	{
		bAuth = true;
	}
	
	return (bAuth && bFlag);
}

function fnGridRowRemove(obj)
{
	var nCount = 0;
	for (var nLoop = obj.rowcount - 1; nLoop >= 0; nLoop--)
	{
		if (obj.GetColumn(nLoop, "CHECKER") == "1")
		{
			obj.DeleteRow(nLoop);
			nCount++;
		}
	}
	
	return nCount;
}

//검색컨트롤 트레이싱 : 복사해서 쓸수 있게..
function traceControl( ctl ){
	return;
	var nCount = ctl.Components.Count;
	var traceStr1, traceStr2;
	for(var i = 0; i < ctl.Components.Count; i++ )
	{
		var obj = ctl.Components[i];
		var objType = ToString( toUpper(obj.GetType()) );
		var objName = obj.ID;
		if(objType=="EDIT" || objType=="CHECKBOX" || objType=="CALENDAR" || objType=="COMBO"){
			//obj.Value = eval( "p"+objName );
			traceStr1 += "p"+objName+",";
			traceStr2 += objName+",";
		}
	}
	trace( SubStr(traceStr1,0,Length(traceStr1)-1) );
	trace( SubStr(traceStr2,0,Length(traceStr2)-1) );
}

//받은 파라미터 값에 의한 초기화 : 목록
function fnControlInit( str, ctl ){
	if( str!="" ){//수동
		var strArr = Split(str, ",");
		var sArgs = " ";
		for ( var i = 0; i < strArr.length(); i ++ ) {
			var str = SubStr( ToString(strArr[i]), 1, Length(ToString(strArr[i])) );
			var obj = Object( str );
			if( ( !fnEmpty( eval(ToString(strArr[i])) ) ) ){
				obj.Value = eval( ToString(strArr[i]) );
			}
		}
	}else{//자동
		var nCount = ctl.Components.Count;

		for(var i = 0; i < ctl.Components.Count; i++ )
		{
			var obj = ctl.Components[i];
			var objType = ToString( toUpper(obj.GetType()) );
			var objName = obj.ID;
			if(objType=="EDIT" || objType=="CHECKBOX" || objType=="CALENDAR" || objType=="COMBO"){
				obj.Value = eval( "p"+objName );
			}
		}
	}
}

//받은 파라미터 매핑해주기 : 리스트로갈때 컨트롤충돌이 일어나지 않게 던져야 함.
function fnSearchInit(str){
	var strArr = Split(str, ",");
	var sArgs = " ";
	for ( var i = 0; i < strArr.length(); i ++ ) {
		//trace( ToString(strArr[i])+" "+(eval(strArr[i])==null)+" "+eval(strArr[i]) );
		//var obj = Object( strArr[i] );
		if( IsExistVar(strArr[i]) ){
			var strVal = ToString(eval(strArr[i]));//값
			if( !fnEmpty(strVal)  ){
				sArgs +=  Space(1) + ToString(strArr[i]) + "=" + ToString(strVal) + Space(1);
			}
		}
	}
	//alert( sArgs );
	return sArgs+" ";
}

//보낼 파라미터 : 보기로 갈때
//첫번째는 문자열, 두번째는 FORM(this)
function fnParamInit( str, ctl ){
	var sArgs = " ";
	if( str!="" ){//수동
		var strArr = Split(str, ",");
		for ( var i = 0; i < strArr.length(); i ++ ) {
			var str = SubStr( ToString(strArr[i]), 1, Length(ToString(strArr[i])) );
			var obj = Object(str);
			//alert( ToString(obj.GetType()) +" : "+ strArr[i] +" : "+ obj.Value +" : "+ (obj.Value!=null) +" : "+ (obj.value!="") );
			if( ( (ToString(obj.GetType())=="Edit") || (ToString(obj.GetType())=="Checkbox") ) && !fnEmpty(obj.Value) )
				sArgs += " " + ToString(strArr[i]) + "=" + quote(ToString(obj.Value)) + " ";
			if( ToString(obj.GetType()) == "Calendar" && !fnEmpty(obj.Text) )
				sArgs += " " + ToString(strArr[i]) + "=" +  quote(replace(replace(obj.Text,"-",""),"_","")) + " ";
			if( ToString(obj.GetType()) == "Combo" ){
				//obj.SetFocus();
				if( !fnEmpty(obj.Value) ){
					sArgs += " " + ToString(strArr[i]) + "=" + quote(obj.Value) + " ";
				}
			}		
		}
	}else{//자동
		var nCount = ctl.Components.Count;

		for(var i = 0; i < ctl.Components.Count; i++ )
		{
			var obj = ctl.Components[i];
			var objType = ToString( toUpper(obj.GetType()) );
			if(objType=="EDIT" || objType=="CHECKBOX" || objType=="CALENDAR" || objType=="COMBO"){
				sArgs += " p" + obj.ID + "=" + quote(ToString(obj.Value)) + " ";
			}
		}
	}
	//alert(sArgs);
	return sArgs+" ";
}



////////////////////////////////////////////////////////
///  공휴일, 주말 포함여부에 따라 지정된 날자수 계산////
///  start 	wbjeon 2010-09-30 writer				////
///////////////////////////////////////////////////////

//  - 휴일 : 휴일 글자
//  - 비휴일 : ""
function IsHoliday(yyyymmdd,weekchk)
{
  var mmdd;
  var lunar;

  ////// 양력 체크
  mmdd = substr(yyyymmdd, 4, 4);
  // 신정 Check
  if( mmdd == "0101" )
		return "신정";
	// 삼일절
	if( mmdd == "0301" )
		return "삼일절";
	// 어린이날
	if( mmdd == "0505" )
		return "어린이날";
	// 현충일
	if( mmdd == "0606" )
		return "현충일";
	// 제헌절
	if( mmdd == "0717" )
		return "제헌절";
	// 광복절
	if( mmdd == "0815" )
		return "광복절";
	// 개천절
	if( mmdd == "1003" )
		return "개천절";
	// 성탄절
	if( mmdd == "1225" )
		return "성탄절";
		
	/////// 음력 체크
	lunar = Solar2Lunar( yyyymmdd );
	mmdd = substr(lunar, 4, 4);
	
	// 구정	
	if( mmdd == "1230" || mmdd == "0101" || mmdd == "0102" )
		return "설날";
	// 초파일
	if( mmdd == "0408" )
		return "석가탄신일";
	// 추석
	if( mmdd == "0814" || mmdd == "0815" || mmdd == "0816" )
		return "추석";
  
	////// 주말 체크
	if (weekchk == 60){
		if( GetDay(yyyymmdd) == 6 || GetDay(yyyymmdd) == 0){
			return "일요일";
		}
	} else {
		if( GetDay(yyyymmdd) == weekchk ){
			return "토/일요일";
		}
	}	
	  
  return "";
}

/***************************************************************
 * 설명 : 해당월의 맨마지막 날짜를 찾는 함수
 * arg :
			str_yyyymm
 * return : 
			성공 = 맨 마지막 날짜
			실패 = -1
****************************************************************/
function GetLastDay(str_yyyymm)
{
	var   int_year, int_month;
	var		len;
	var		yy, mm, last_day, dd;
	var		c;

	int_year = ToInteger(substr(str_yyyymm, 0, 4));
	int_month = ToInteger(substr(str_yyyymm, 4, 2));
	if( int_month < 1 || int_month > 12 )
	{
		return -1;
	}
	if ( int_month == 2 )
	{
		if ( (int_year%4) == 0 && (int_year%100) != 0 || (int_year%400) == 0 )
		{
			last_day = 29;
		}
		else
		{
			last_day = 28;
		}
	}
	else if ( int_month == 4 || int_month == 6 || int_month == 9 || int_month == 11 )
	{
		last_day = 30;
	}
	else
	{
		last_day = 31;
	}

	return last_day;
}

/**
* 입력한 날자를 기준으로 (공유일/주말 제외한) 입력 이후의 날자 가져오기
* 입력형식 : 2004년 3월 1일 --> 20040301
* inDate: 현재 기준일
* count : -/+count일 이후의 날자 기준
* weekChk : 6 토요일, 0 일요일, 60 토요일+일요일 제외 기준
* insToDay : div 당일제외, add 당일 포함 
*/
function fromDayAfter(thisToDay,count,weekChk,insToDay)
{
	var yDay = substr(thisToDay,0,4);				// 현재 년도
	var mDay = ToInteger(substr(thisToDay,4,2));	// 현재 월
	var lastDay = GetLastDay(thisToDay);			// 현재 달의 마지막 날
	var Days = 0;									// 일자 초기화
	var i = 0;										// for 증감 초기화
	var initDay = ToInteger(thisToDay);				// 현재일자를 정수형으로 변환
	
	var Limit = pos(ToString(count),"-"); 			//음수 유무

	var eDate = 0;	// for 임시저장 초기화 값
    
    var subDay = "";		// 문자열 분리 (일자)
    var subMonth = "";  	// 문자열 분리 (월별)
    var subYear = "";   	// 문자열 분리 (년도)
    
    var intDay = 0;	    	// 분리된 문자열 정수 치환 (일별)
    var intMonth = 0;   	// 분리된 문자열 정수 치환 (월별)
    var intYear = 0;    	// 분리된 문자열 정수 치환 (년도별)
    
    var intSumMonth = 0;	// 이전-이후 달 저장
    var strSumDay = "";		// 이전-이후 ymd 문자열 저장
    var strSumMonth = "";   // 이전-이후 달 문자열 저장
    var intCount = 0;       // 이전-이후로 지정된 일수만큼 이동
    var expre = 0;			// +/- 부호 값 추출
    var endDate = "";		// 리턴 날자 (이동한 일수)


	if (Limit >=0 ){
	   	if (insToDay == "div") {
			subDay = substr(thisToDay,6,2);	
			intDay = toInteger(subDay);
			count = count - 1;
			
			if ((intDay == 1) && (mDay == 1)){ //년도 변경 1월 1일
				intYear = ToInteger(yDay) - 1;
				strSumDay = ToString(intYear) + "1231";
			} else if (intDay == 1 && mDay != 1) {
				intMonth = mDay - 1;
				if (intMonth < 10){
					strSumMonth = "0" + ToString(intMonth);
				}  else {
					strSumMonth = ToString(intMonth);
				}
				strSumDay = ToString(subYear) + strSumMonth + subDay;					
				lastDay = GetLastDay(strSumDay);			// 현재 달의 마지막 날
				strSumDay = ToString(yDay) + ToString(strSumMonth) + lastDay;
			} else {
				strSumDay = thisToDay;
			}
			initDay = ToInteger(strSumDay);	
		} 
		
		eDate = initDay-100000;
		
		expre = ToInteger(substr(ToString(count),1,length(ToString(count))-Limit-1));

		for (i = initDay; i >=eDate; i--){
			subMonth = substr(i,4,2);
			intMonth = ToInteger(subMonth);
			
			if (IsHoliday(i,weekchk) == "")
			{
				subYear = subStr(i,0,4);
				subDay = substr(i,6,2);
				intDay = ToInteger(subDay);
					
				if ((intDay == 0) && (intMonth == 1)){ //1월 1일 -> 년도 월 변경
					intYear = ToInteger(subYear) - 1;
					strSumDay = ToString(intYear) + "1231";
				} else if ((intDay == 0) && (intMonth != 1)){// 1일 -> 월 변경
					intSumMonth = intMonth - 1;
					if (intSumMonth < 10){
						strSumMonth = "0" + ToString(intSumMonth);
					}  else {
						strSumMonth = ToString(intSumMonth);
					}
					strSumDay = ToString(subYear) + strSumMonth + subDay;					
					lastDay = GetLastDay(strSumDay);			// 현재 달의 마지막 날
					strSumDay = ToString(yDay) + strSumMonth + lastDay;
				} else {
					strSumDay = ToString(i);
				}
				i = ToInteger(strSumDay);
				Days = Days + 1;

				if (Days == expre){
					endDate = i;
					return endDate;
				}
			}
		}
	} else {
	
/*   		if (insToDay == "add") {
			subDay = substr(thisToDay,6,2);	
			intDay = toInteger(subDay);

			if ((intDay == 1) && (mDay == 1)){ //년도 변경 1월 1일
				intYear = ToInteger(yDay) - 1;
				strSumDay = ToString(intYear) + "0101";
			} else if (intDay == 1 && mDay != 1) {
				intMonth = mDay - 1;
				if (intMonth < 10){
					strSumMonth = "0" + ToString(intMonth);
				}  else {
					strSumMonth = ToString(intMonth);
				}
				strSumDay = ToString(subYear) + strSumMonth + subDay;					
				lastDay = GetLastDay(strSumDay);			// 현재 달의 마지막 날
				strSumDay = ToString(yDay) + ToString(strSumMonth) + lastDay;
			} else {
				strSumDay = ToString(initDay-1);
			}
			initDay = ToInteger(strSumDay);	
		} 	
*/	
		if (insToDay == "div") {
			count = count + 1;
		} 
	
		eDate = initDay+100101;
		
		for (i = initDay; i <= eDate; i++){
	
			subMonth = substr(i,4,2);
	
			if (IsHoliday(i,weekchk) == "")
			{
				chkDay = substr(i,6,2);
		
				if ((chkDay >= lastDay) && (mDay >= 12)){ //년도 변경
					strSumDay = yDay + "0101";
					i = ToInteger(strSumDay) +10000;
				} else if ((chkDay >= lastDay) && (mDay <= 11)){//월변경        			
					strSumDay = yDay +subMonth+"01";
					i = ToInteger(strSumDay)+100;
				} 
			  
				Days = Days + 1;

				if (Days == count){
					endDate = i;
					return endDate;
				}
			}
		}		

	}
	
	return;
/*    if (Limit >= 0){		// 현재일로 부터 이전 날자 계산
    
		eDate = initDay-100000;
		
		var expre = substr(ToString(count),1,length(ToString(count))-Limit-1);
		var tmpCount = 0;
		
//	if (insToDay == "div" && Limit >=0 ){
//			tmpCount = ToInteger(expre);		
//		} else {
//			tmpCount = ToInteger(expre)-1;
//		}

		for (i = initDay; i >=eDate; i--){
	
			subMonth = substr(i,4,2);
	
			if (IsHoliday(i,weekchk) == "")
			{
				chkDay = substr(i,6,2);

				if (length(subMonth) < 2){
					tMonth = "0"+ToString(subMonth);
				} else {
					tMonth = ToString(subMonth);
				}
					
				if ((chkDay == 1) && (subMonth == 1)){ //년도 변경
					var tempYear = ToInteger(yDay) - 1;
					tmp = ToString(tempYear) + ToString(12 - ToInteger(tMonth)) + ToString(chkDay);
				} else if ((chkDay == 1) && (subMonth > 1)){//월변경 
					var ttMonth = ToInteger(tMonth) - 1 ;
					tmp = yDay+ttMonth+GetLastDay(tempDay);	
				}  
				
				i = ToInteger(tmp)-1;
				
				Days = Days + 1;
				
				if (Days == tmpCount){
					endDate = i;
					return endDate;
				}
			}
		}
	
    } else { // 현재일로 부터 이후 날자 계산
		    
		eDate = initDay+100101;
		for (i = initDay; i <= eDate; i++){
	
			subMonth = substr(i,4,2);
	
			if (IsHoliday(i,weekchk) == "")
			{
				chkDay = substr(i,6,2);
		
				if ((chkDay == lastDay) && (mDay >= 12)){ //년도 변경
					tmp = yDay + "0101";
					i = ToInteger(tmp) +10000;
				} else if ((chkDay == lastDay) && (mDay <= 11)){//월변경        			
					tmp = yDay +subMonth+"01";
					i = ToInteger(tmp)+100;
				}  
			  
				Days = Days + 1;
			
				if (Days == count){
					endDate = i;
					return endDate;
				}
			}
		}
	}
	*/
}
////////////////////////////////////////////////////////
///  공휴일, 주말 포함여부에 따라 지정된 날자수 계산////
///  end   											////
///////////////////////////////////////////////////////


/*===============================================================
= 기능 : 입력받은 from월로부터 입력to월까지 일수 반환하기
= 인수 : rMonth-- 반환할 오브젝트, fMonth ~부터, tMonth~까지
= 
= 리턴 : 총일수
== 이석곤 2011.07.08
===============================================================*/
function gfnCalcDay(fdate,tdate)
{
  var iMonth    = 0; //계산된 개월수
  var iYear     = 0; //계산된 년도
  var iday      = 0; //계산된 일수
  var iMonthday = 0; //계산된 월의 일수
  var rMonth    = 0; //반환할 개월수

  if(parseInt(fdate) <= parseInt(tdate)){
    
    iYear  = parseInt(tdate.substr(0,4)) - parseInt(fdate.substr(0,4)) ;
    iMonth = parseInt(toNumber(tdate.substr(4,2))) - parseInt(toNumber(fdate.substr(4,2)));
    
    //iday   = parseInt(toNumber(tdate.substr(6,2))) - parseInt(toNumber(fdate.substr(6,2)));
    // alert(tMonth.substring(4,6) + ":::" +fMonth.substring(4,6));
    
    if ( iMonth > 1 )
    {
      for( i=1 ;i < iMonth; i++)
      {
         iMonthday += gfnMonthLastDay( toNumber(fdate.substr(4,2)) + i );
      }
    }
    
    if( iMonth == 0 )
    {
      iday  =  parseInt(toNumber(tdate.substr(6,2))) - parseInt(toNumber(fdate.substr(6,2)));
    } else
    {
      iday  = gfnMonthLastDay( toNumber(fdate.substr(4,2))) - parseInt(toNumber(fdate.substr(6,2)));
      iday  = iday + parseInt(toNumber(tdate.substr(6,2)));
      
    }
    
    rMonth = (365 * iYear) + iMonthday + iday + 1;
     
    return rMonth;
     
   }else {
     return 0;
   }
}

function gfnMonthLastDay(fmonth)
{
  if ( fmonth == 1 )
    return 31;  
  if ( fmonth == 2 )
    return 29;  
  if ( fmonth == 3 )
    return 31;  
  if ( fmonth == 4 )
    return 30;  
  if ( fmonth == 5 )
    return 31;  
  if ( fmonth == 6 )
    return 30;  
  if ( fmonth == 7 )
    return 31;  
  if ( fmonth == 8 )
    return 31;  
  if ( fmonth == 9 )
    return 30;  
  if ( fmonth == 10 )
    return 31;  
  if ( fmonth == 11 )
    return 30;  
  if ( fmonth == 12 )
    return 31;
}
