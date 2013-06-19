﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿//////////////////////////////////////////////////////////////////
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