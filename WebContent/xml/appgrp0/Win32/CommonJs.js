﻿﻿﻿﻿//////////////////////////////////////////////////////////////////
// 전역함수들
//////////////////////////////////////////////////////////////////
/*
function fnCreateNewWindow(strFormID, strURL, bDialog)
{
	NewWindow(strFormID, strURL, "_bDialog=" + bDialog, -1, -1, "Resize=false" );
}
*/
function fnCreateDialog(strURL, sArgs)
{
	var sReturn = Dialog(strURL, sArgs);
	return sReturn;
}

function fnEmpty(strText)
{
	if (Length(strText) == 0)
		return true;
	else
		return false;
}

function fnGridToExcel(obj, sSheetName)
{
	obj.ExportExcelEx(sSheetName);
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
	
	return null;
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

				if(sTargetname == "EDIT" || sTargetname == "MASKEDIT")
				{
					cTarget.Readonly = !bFlag;
				}
				if(sTargetname == "CALENDAR")
				{
					cTarget.Enable = bFlag;
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
			if (sChildName == "MASKEDIT")
			{
				objChild.Readonly = !bFlag;
			}
			else if (sChildName == "EDIT")
			{
				objChild.Readonly = !bFlag;
			}
			else if (sChildName == "COMBO")
			{
				objChild.Enable = bFlag;
			}
			else if (sChildName == "CALENDAR")
			{
				objChild.Enable = bFlag;
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