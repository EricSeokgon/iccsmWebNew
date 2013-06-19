var target_url = global.g_ext_iccs_url + "file/";
var upload_packetSize = 4096000; //1048576;
var download_packetSize = 1048576;

/*====================================================================
= 기능 : File 생성 (Write)
= 인수 : file_url			file Path
				 str_param		Parameter (Cookie)
				 nRow					Dataset Row Position 
				 strCol				Column ID (Progress 설정)
				 objState			Progress 표시 Grid
= Return : Result/Message/file Size				 
=====================================================================*/

function gfn_FileWrite(httpfileObj,file_url, str_param, nRow, strCol, objState, sido_code,sigg_code,filepath,idpath,sv_url){
	
	var rtn_arr = Array(3);
	rtn_arr[0] = "FAIL";

	if (length(file_url) < 7) {
		rtn_arr[1] = "Not Found Seleced File!";
		return rtn_arr;
	}
	
	if (length(str_param) < 1){
		rtn_arr[1] = "Not Found CookieParam!";
		return rtn_arr;
	} 

	
	var write_size;
	var tot_write_size;
	var file_size;

	remote_url =  global.g_ext_iccs_url + "file/fileUpload.jsp"+"?pathType="+filepath+"&sido_code="+sido_code+"&sigg_code="+sigg_code+"&idpath="+idpath+"&sv_url="+sv_url; 	
	

	file_size = httpfileObj.GetFileSizeLocal(file_url);
	
	//httpfileObj.CookieParam = str_param;
	httpFileObj.CookieParam = UrlEncode(str_Param);

	trace("httpfileObj.CookieParam : " + httpfileObj.CookieParam);
	trace("remote_url : " + remote_url);
	trace("file_url : " + file_url);

	ret = httpfileObj.OpenFile(remote_url, file_url, "PUT");

	if( ret < 0 )	{
		rtn_arr[0] = "FAIL";
		rtn_arr[1] = "OpenFile Failed :: " + httpfileObj.ErrorMsg;
		return rtn_arr;
	}

	if (IsValidObject(objState)){
		var objDs = objState.BindDataset;
		var readpercent;
		object(objDs).SetColumn(nRow, "filesize",round(file_size/1024)); 

		while(1) {
			write_size = httpfileObj.WriteFile(upload_packetSize);
//			trace(write_size);
			tot_write_size += write_size;
			
			readpercent = truncate((tot_write_size / file_size) * 100,1);
			
			object(objDs).SetColumn(nRow, strCol, readpercent); 
			object(objDs).SetColumn(nRow, "progsize",round(tot_write_size/1024)); 
			
			if( write_size < upload_packetSize )	break;
			
		}
		
	} else {
		while(1)	{
			write_size = httpfileObj.WriteFile(upload_packetSize);				
			if( write_size < upload_packetSize )	break;
			
		}
	}

	httpfileObj.CloseFile();

	if (isExistVar("objState",true)){
		if ( write_size == -1 )	{
			rtn_arr[0] = "FAIL";
			rtn_arr[1] = httpfileObj.ErrorMsg;
			return rtn_arr;
		}
	}

	var rtn_val = httpfileObj.CookieParam;

	var str_sp = split2(rtn_val,";","=");
	var tmp_a;
	
	for ( var i = 0 ; i < str_sp.length() ; i++ )
	{
		tmp_a = str_sp[i];
		if ( tmp_a[0].pos("FileParam") > -1 )
		{
			rtn_arr[0] = left(tmp_a[1],4);
			rtn_arr[1] = right(tmp_a[1], length(tmp_a[1]) -6);
		}	
	}	
	return rtn_arr;
}


/*====================================================================
= 기능 : File Read
= 인수 : file_url			file Path
				 str_cookie		Cookie (parameter)
				 str_size			File Size
				 nRow					Dataset Row Position
				 strCol				Column ID (progress 설정)
				 objState			progress 설정 Grid
= Return : Result/Message/file Size				 
=====================================================================*/
function gfn_FileRead(httpfileObj,file_url, str_cookie, str_size, nRow, strCol, objState,sido_code,filepath){
	  trace("file_url::"+file_url);
	  trace("str_cookie::"+str_cookie);
	  trace("str_size::"+str_size);
	var rtn_arr = Array(2);
	rtn_arr[0] = "FAIL";

	if (length(quote(file_url)) < 7) {
		rtn_arr[1] = "Not Found Seleced File!";
		return rtn_arr;
	}
	
	if (length(quote(str_cookie)) < 1){
		rtn_arr[1] = "Not Found CookieParam!";
		return rtn_arr;
	}

	if (length(quote(str_size)) < 1 || str_size == 0){
		rtn_arr[1] = "Not Found File Size!";
		return rtn_arr;
	}

	remote_url =  target_url + "fileDownload.jsp"+"?pathType="+filepath+"&sido_code="+sido_code;
		
	var read_size;
	var tot_read_size;
	var file_size;

	//HttpFile0.SessionParam = SMSESSION;
	//httpfileObj.CookieParam = str_cookie;
	httpFileObj.CookieParam = UrlEncode(str_cookie);
	
	file_size = str_size;
//trace("remote_url::"+remote_url);	
//trace("file_url::"+file_url);
	ret = httpfileObj.OpenFile(remote_url, file_url, "GET");
	
	if( ret < 0 ) {
		rtn_arr[0] = "FAIL";
		rtn_arr[1] = "OpenFile Fail ::" + httpfileObj.ErrorMsg;
		return rtn_arr;
	}
	
	tot_read_size = 0;	

	if (IsValidObject(objState)){
		var objDs = objState.BindDataset;
		var readpercent;

		while(1) {
			read_size = httpfileObj.ReadFile(download_packetSize);
//trace(read_size);
			tot_read_size += read_size;
			
			readpercent = truncate((toNumber(tot_read_size) / toNumber(file_size)) * 100,1);
			
			object(objDs).SetColumn(nRow, strCol, readpercent); 
			
			if( (read_size == 0) || ( read_size == -1) ) break;
		}
		
	} else {
		while(1) {
			read_size = httpfileObj.ReadFile(download_packetSize);
			if( (read_size == 0) || ( read_size == -1) ) break;
		}
	}
	
	httpfileObj.CloseFile();
	
	if ( read_size == -1 )	{
		rtn_arr[0] = "FAIL";
		rtn_arr[1] = httpfileObj.ErrorMsg;
		return rtn_arr;
	}
	
	var rtn_val = httpfileObj.CookieParam;
	var str_sp = split2(rtn_val,";","=");
	var tmp_a;
	
	for ( var i = 0 ; i < str_sp.length() ; i++ )
	{
		tmp_a = str_sp[i];
		if ( tmp_a[0].pos("FileParam") > -1 )
		{
			rtn_arr[0] = left(tmp_a[1],4);
			rtn_arr[1] = right(tmp_a[1], length(tmp_a[1]) -6);
		}	
	}	
	
	return rtn_arr;
}
