
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel="stylesheet" href="./image/style.css" type="text/css">
<SCRIPT LANGUAGE="JavaScript" src="./MiInstaller320.js"></SCRIPT>
<script language="vbscript">
	Function  Check_Module
	  
	  	On Error Resume Next
	  	
	   	Err.number = 0
	   	chkMsg= document.MiInstaller.Version
	  	if  Err.number = 438 Then	
			Check_Module = "false"
	  	Else
	        Check_Module = "true"
	  	End If
	End Function 
</script>

<SCRIPT LANGUAGE="JavaScript">
	var TotalVersionFileCnt;
	var TotalItemCnt;
	var progressColor = "red";	// set to progress bar color
	var pg_cell_At = 0,pg1_cell_At = 0; 
	var IsError = false;
	var proMsg, procMsg;
  var iccs_path = "http://192.168.1.100/iccsm";
	//var iccs_path = "http://localhost/iccsm";
	
	var prj_key         = "ICCS";
	var prj_startxml    = iccs_path + "/xml/xml_ci_main_Win32.xml";
	var prj_comppath    = "%UserApp%TOBESOFT\\" + prj_key + "\\component";
//	alert(prj_compath);
	var prj_update_url  = iccs_path + "/Install/update_cfg.xml";	
	var prj_update_vista_url  = iccs_path + "/Install/update_cfg_vista.xml";	
	var prj_update_fixuac_url  = iccs_path + "/Install/update_cfg.xml";	
	
	function fn_OnLoad()
	{
		if ( Check_Module() == "true" )
		{
			var tmp_len     = progress.offsetWidth; 
			var tmp_tot_len = pg.offsetWidth; 
			pg_cell_init(tmp_len,pg,"progress",tmp_tot_len);
			pg_cell_init(tmp_len,pg1,"progress1",tmp_tot_len);

			MiInstaller.Launch = true;	
			MiInstaller.Width  = 1024;
			MiInstaller.Height	= 768;
			MiInstaller.Retry   = 1;
			MiInstaller.Timeout = 300;
			MiInstaller.GlobalVal = "";
			MiInstaller.OnlyOne = true;
			
			MiInstaller.Key           = prj_key;
			MiInstaller.ComponentPath = prj_comppath;
			MiInstaller.StartXml      = prj_startxml;
			MiInstaller.StartImage     =  "%component%kjs.jpg";
      
			var mode = checkOS();
	    
			var IsUACEnabled = MiInstaller.IsUACEnabled();
			var uacMode = "Y";
			
			if ( mode == "VISTA" )
			{
				if ( !IsUACEnabled )  //uac off
				{
					uacMode = "N"
				} else	if ( MiInstaller.IsElevatedProcess() ) // uac on && admin권한 상속
				{
				  uacMode = "N";
				}
				
				if( uacMode == "N" )
  			  prj_update_url = prj_update_fixuac_url;
  			else
  			  prj_update_url = prj_update_vista_url;
			}
			
      
      //alert("prj_update_url : " + prj_update_url);
      MiInstaller.UpdateURL =  prj_update_url;
      
			var Bcnt = MiInstaller.ExistVersionUpCnt(); 
      
			if ( Bcnt )
			{
				MiInstaller.StartDownload();
			} else {
				fn_run();
			}
		}
	}
	
	function page_link()
	{
	
		// 단축 아이콘 만들기
		// UBKImage : 250 * 300
		
		//BYTE가 256을 넘으면 안됨..
		// 256을 넘을 경우 MiInstaller의 property를 이용할것

		var strCommand = '-V 3.2 -D Win32U -R FALSE -K ICCS -L TRUE -LE TRUE -BI "%component%next_upd.gif" ';
        alert(strCommand);        
		MiInstaller.MakeShortCut("%system%MiUpdater320.exe",strCommand,"네트","%Component%iccs.ico","");
		
		// MakeShortCut 바로가기를 만드는 함수
		// strExeName: 바로가기를 만들 실행 파일 이름
		// strCommand: 바로가기를 만들 때 필요한 Command 정보
		// strShortcutName: 바로가기 파일 이름
		// strIConPath: 변경하려는 Icon 경로를 %alias%형태로 입력할 수 있습니다.
		// strPos: Startmenu-시작 / Desktop-바탕화면(Default)
	
		// Alias 참고
		// %MiPlatform%
		// %Component%
		// %system%
		// %Window%
		// %ProgramFiles%
	
	} 

	function fn_run()
	{
		if ( IsError ) return ;
		
		alert("설치가 완료 되었습니다.");
//		opener.close();

		//단축 아이콘 생성
		page_link();
		
		MiInstaller.run();
		opener = self;
		self.close();
	}

	function pg_cell_init(icell_width,obj,cell_id_nm,tot_len) {
		var inum = 0;
		var ins_cell_str = "";	
	
		while ( inum <= tot_len ) {
			inum += icell_width*2 ; 
			ins_cell_str += '<span id="' + cell_id_nm + '" >&nbsp;</span><span>&nbsp;</span>';
		} 
		obj.innerHTML = ins_cell_str;
	}
	
	function progress_clear(obj) {
		for (var i = 0; i < obj.length; i++) obj[i].style.backgroundColor = 'transparent';
	}
	
	function progress_update(obj,cur_cnt) {

		if ( cur_cnt >= obj.length ) cur_cnt = obj.length - 1;

		obj[cur_cnt].style.backgroundColor = progressColor;
	}
</SCRIPT>

<SCRIPT language=JavaScript for=MiInstaller event=OnConfirm(ItemName)>
{
	
	var a;
	a  = "OnConfirm=>Item=";
	a += ItemName;	
	//alert(a);
}
</SCRIPT>


<SCRIPT language=JavaScript for=MiInstaller event=OnStartDownLoad(VersionFileName,DownFileName,Type,TotalCnt,CurIndex)>
{
//alert(VersionFileName);
//alert(DownFileName);
		if ( Type == 1 ) //EVENTCONFIG
		{
			progress_clear(progress);
		}
		else if ( Type == 2 ) //EVENTGETVERSIONCNT
		{
			ins_tbl.className = "show";
			reinstall.className = "show";
			progress_clear(progress1);
			pg1_cell_At = 0;

		}
		else if ( Type == 3 ) //EVENTDOWNLOAD
		{
			item_nm.innerHTML = "&nbsp;" + DownFileName;
			prc_msg.innerHTML = "&nbsp;파일 다운로드 중....";
		}
		else if ( Type == 4 ) //EVENTDISTRIBUTE
		{
			prc_msg.innerHTML = "&nbsp;실제 경로 배포 중....";
		}	
}
</SCRIPT>

<!--ItemSize는 미지정 -->
<SCRIPT language=JavaScript for=MiInstaller event=OnEndDownLoad(VersionFileName,DownFileName,Type,TotalCnt,CurIndex)>
{
		if ( Type == 1 ) //EVENTCONFIG
		{
			fn_run();

		}
		else if ( Type == 2 )//EVENTGETVERSIONCNT
		{
/*
			if ( TotalCnt == CurIndex )
				for ( var i = pg1_cell_At ; i < progress1.length ; i++ ) progress_update(progress1,i);
			else 
			{	
				if ( CurIndex > 1 ) {
				    var before_At = pg_cell_At;
					pg_cell_At += parseInt( ( ( (CurIndex - 1)/TotalCnt ) * progress.length ) - before_At );
		
					for ( var i = before_At ; i < pg_cell_At ; i++ ) progress_update(progress,i);
				}	
				pg1_cell_At = 0;
				tot_item.innerHTML = "&nbsp;" + CurIndex + "/" + TotalCnt;
			}
*/
		}
		else if ( Type == 3 )//EVENTDOWNLOAD
		{
		    var before_At = pg1_cell_At;

			comp_cnt.innerHTML = "&nbsp;" + CurIndex + "/" + TotalCnt;

			pg1_cell_At += parseInt( ( ( (CurIndex - 1)/TotalCnt ) * progress1.length ) - before_At );

			for ( var i = before_At ; i < pg1_cell_At ; i++ ) progress_update(progress1,i);
		
			prc_msg.innerHTML = "&nbsp;파일 다운로드 완료....";
		}
		else if ( Type == 4 )//EVENTDISTRIBUTE
		{

			tot_item.innerHTML = "&nbsp;" + CurIndex + "/" + TotalCnt;
			item_nm.innerHTML = "&nbsp;" + DownFileName;
		    var before_At = pg_cell_At;

			pg_cell_At += parseInt( ( ( (CurIndex - 1)/TotalCnt ) * progress.length ) - before_At );

			for ( var i = before_At ; i < pg_cell_At ; i++ ) progress_update(progress,i);
			prc_msg.innerHTML = "&nbsp;파일 설치 완료";
		}
			
}
</SCRIPT>
<SCRIPT language=JavaScript for=MiInstaller event=OnError(ItemName,ErrorCode,ErrorMsg)>
{
		IsError = true;
		err_msg.innerHTML += '<font class="f2" color="red">' + ItemName + '&nbsp;다운&nbsp;실패&nbsp; -- ErrorCode:' + ErrorCode + ' ' + ErrorMsg + "<br>";
		t_err.className = "show";
		reinstall.className = "show";
		MiInstaller.stop();

}

</SCRIPT>

</HEAD>
<BODY leftmargin="0" topmargin="0" onload="fn_OnLoad()">
<br><br>
<center>
<table id="ins_tbl" align="center" border=0 width="600">
  <tr>
    <td><table width="637" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td height="10"></td>
        </tr>
        <tr> 
          <td><img src="./image/insu_down_listbg1.gif" width="637" height="11"></td>
        </tr>
        <tr> 
          <td height="37" bgcolor="#EEEEEE"> <table width="607" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td height="15"></td>
              </tr>
              <tr> 
                <td><table width="590" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="10" rowspan="3"><img src="./image/insu_down_img.gif" width="150" height="90"></td>
                      <td width="590" height="35"><img src="./image/insu_down_title.gif" width="204" height="27"></td>
                    </tr>
                    <tr> 
                      <td height="45"><img src="./image/insu_down_title2.gif" width="329" height="32"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><table width="607" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="12" height="12"><img src="./image/insu_down_listbg_sub1.gif" width="12" height="12"></td>
                      <td width="583" height="12" bgcolor="#FFFFFF"></td>
                      <td width="12" height="12"><img src="./image/insu_down_listbg_sub2.gif" width="12" height="12"></td>
                    </tr>
                    <tr> 
                      <td rowspan="5" bgcolor="#FFFFFF">&nbsp;</td>
                      <td bgcolor="#FFFFFF">
<table width="570" border="0" align="center" cellpadding="0" cellspacing="0">
<tr> 
                            <td width="10" valign="top"><img src="./image/insu_down_list_icon1.gif" width="8" height="11"></td>
                            <td width="570">암호화 프로그램 설치여부를
                            암호화 프로그램 설치여부를 묻는 보안경고창이 나타나면 반드시 
                              “<strong><font color="#FF7200">예</font></strong>”를 
                              선택하여주시기 바랍니다.<br>
                              “아니오”를 선택하시면 보안을 위해 사용이 제한됩니다.</td>
                          </tr>
                        </table></td>
                      <td rowspan="5" bgcolor="#FFFFFF">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td bgcolor="#FFFFFF">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td bgcolor="#FFFFFF"><table width="570" border="0" align="center" cellpadding="0" cellspacing="0">
<tr> 
                            <td width="10" valign="top"><img src="./image/insu_down_list_icon1.gif" width="8" height="11"></td>
                            <td width="570">윈도우 XP 서비스팩2 사용자께서는 주소 표시줄 아래 경고문구 
                              “ <img src="./image/insu_down_list_icon2.gif" width="15" height="15" align="absmiddle">이 
                              사이트에서...여기를 클릭하십<br>
                              시오” 를 선택하시어, Active X컨트롤을 설치하시기 바랍니다.</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#FFFFFF">&nbsp;</td>
                    </tr>
                    <tr> 
<td bgcolor="#FFFFFF">
<table width="570" border="0" align="center" cellpadding="0" cellspacing="0">
<tr> 
                            <td width="10" valign="top"><img src="./image/insu_down_list_icon1.gif" width="8" height="11"></td>
                            <td width="570">프로그램 설치가 정상적이지 않을 경우에는 <strong><font color="#FF7200">수동설치</font></strong>를 
                              통해 수동설치하시거나 <strong><font color="#FF7200">문의하기</font></strong>를 
                              통해 질문<br>
                              하시면 신속히 답변을 드리겠습니다.</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td width="12" height="12"><img src="./image/insu_down_listbg_sub3.gif" width="12" height="12"></td>
                      <td bgcolor="#FFFFFF"></td>
                      <td width="12" height="12"><img src="./image/insu_down_listbg_sub4.gif" width="12" height="12"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td><img src="./image/insu_down_listbg2.gif" width="637" height="11"></td>
        </tr>
        <tr>
          <td height="5"></td>
        </tr>
      </table></td>
  </tr>
</table>
</center>
<table  id="ins_tbl" align="center" border=0 width="600" >
<tr>
	<td>
	<table >
		<tr>
			<td class="f2"> 파일다운로드 진행 상황</td><td id="comp_cnt" class="f2" align=left NOWRAP>&nbsp;</td>
		</tr>
	</table>
	</td>
</tr>
<tr>
	<td>
	<div id=pg1 style="font-size:8pt;padding:1px;border:1px GROOVE silver;">
		<span id="progress1" >&nbsp;</span>
	</div>	
	
	</td>
</tr>
<tr>
	<td>
	<table>
		<tr>
		<td class="f2" >파일설치 진행 상황</td><td id="tot_item" align=left class="f2" NOWRAP>&nbsp;</td>
		</tr>
	</table>
	</td>		
</tr>
<tr>
	<td>
	
	<div id=pg style="font-size:8pt;padding:1px;border:1px GROOVE silver;" >
	
		<span id="progress" >&nbsp;</span>
	</div>
	</td>
</tr>
<tr>
	<td>
	<table>
		<tr>
			<td class="f2">대상파일</td><td id="item_nm" class="f2" align=left NOWRAP>&nbsp;</td>
		</tr>
	</table>
	</td>		
</tr>
<tr>
	<td id=prc_msg class="f2" >&nbsp;<td>
</tr>	
</table>
<!--
<table class="ins_tbl" align=center>
	<tr>
		<td class="f2">기존 사용자 처리사항</td>
	</tr>
	<tr>
		<td class="f2">1.Program files\\TobeSoft\\Miplatform320U\Componnet\remove\next_remove.bat을 실행시켜 파일을 삭제</td>
	</tr>
	<tr>
		<td class="f2">2.Program files\\TobeSoft\\Miplatform320U 폴더  삭제</td>
	</tr>
	<tr>
		<td class="f2">3.레지스트리에서 HKEY_CURRENT_USER\\Software\\tobesoft\\miplatform320U 삭제</td>
	</tr>
</table>
-->
<table class="hide" id=t_err align=center>
	<tr>
		<td class="f2">설치시 에러가 발생한 항목</td>
	</tr>
	<tr>
		<td id=err_msg class="f2">&nbsp;</td>
	</tr>
</table>
<SCRIPT LANGUAGE="JavaScript">
	CreateMiInstlr("MiInstaller","Win32U","3.2",prj_key);
</SCRIPT>
</BODY>
</HTML>
