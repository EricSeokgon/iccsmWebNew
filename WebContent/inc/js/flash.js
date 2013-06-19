function flash(value, width, height){
	document.writeln('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="'+width+'" height="'+height+'">');
	document.writeln('<param name="movie" value="'+value+'">');
	document.writeln('<param name="quality" value="high">');
	document.writeln('<param name="wmode" value="transparent">');
	document.writeln('<param name="menu" value="false">');
	document.writeln('<embed src="'+value+'" width="'+width+'" height="'+height+'" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="transparent" menu="false"></embed>');
	document.writeln('</object>');
}

function movie(value, width, height){	//메인플래쉬
	document.writeln('<object id="WMP" classid="CLSID:22d6f312-b0f6-11d0-94ab-0080c74c7e95" standby="Loading Microsoft Windows Media Player..." width="'+width+'" height="'+height+'">');
	document.writeln('<param name="FileName" value="'+value+'">');
	document.writeln('<param name="AutoStart" value="true">');
	document.writeln('<param name="AutoSize" value="false">');
	document.writeln('<param name="transparentAtStart" value="True">');
	document.writeln('<param name="transparentAtStop" value="True">');
	document.writeln('<param name="ShowControls" value="false">');
	document.writeln('<param name="ShowStatusBar" value="false">');
	document.writeln('<param name="loop" value="-1">');
	document.writeln('<param name="Volume" value="-600">');
	document.writeln('<param name="PLUGINSPAGE" value="http://www.microsoft.com/korea/windows/windowsmedia/">');
	document.writeln('<embed src="'+value+'" width="'+width+'" height="'+height+'" autostart="False" loop="-1" filename="'+value+'" autosize="false" showcontrols="false" showstatusbar="false" volume="-600" pluginspage="http://www.microsoft.com/korea/windows/windowsmedia/"></embed>');
	document.writeln('</object>');
}
