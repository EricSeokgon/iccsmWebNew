
var myControl;
function StartUp() {
	myControl = GetMyObject();
}
function PrintPage() {
	if( myControl == null || !myControl ){ 
		alert('ACTIVE X를 완전히 다운 받으셔야 됩니다.');
		location.reload();
		return;
	}	
	myControl.ex_port_1_terminate();	
	var ret = myControl.ex_port_1_open();	
	if(ret == 0){
		alert("시리얼 1포트를 열 수 없습니다. PC 재부팅 후 다시하시기 바랍니다.");
		myControl.ex_port_1_terminate();
		return;	
	}	
	var status;
	status = myControl.ex_check_status();
 
	if( status == 64)
	{
		alert("용지를 넣으세요.");
		myControl.ex_port_1_terminate();
		return;
	}		
	
	myControl.ex_insert_paper();
	
	myControl.prop_cpi = 15;	
	myControl.ex_set_cpi();
	myControl.prop_lpi = 4;		
	myControl.ex_set_lpi();
	myControl.prop_vertical_line = 18;
	myControl.ex_set_vertical_line();
	myControl.prop_horizontal_tab = 18;
	myControl.ex_set_horizontal_tab();
 
	//신규 수첩
	myControl.prop_lpi = 6;		
	myControl.ex_set_lpi();
	myControl.prop_stringToSend = " "+"\r\n"; //"\r\n";
	myControl.ex_send_1_string();
	myControl.prop_lpi = 4;		
	myControl.ex_set_lpi();
 
	//myControl.prop_stringToSend = " "+"\r\n"; //"\r\n";
	//myControl.ex_send_1_string();
	myControl.prop_horizontal_tab = 18;
	myControl.ex_set_horizontal_tab();
 
	
	myControl.prop_stringToSend = document.frm.NAME.value+" ";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 59;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.COI_WRT_NUM.value+" "+"\r\n";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 18;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.REP_NM_KOR.value+" ";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 59;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.REP_CERTI_RESI_NO1.value+""+document.frm.REP_CERTI_RESI_NO2.value+"\r\n";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 18;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.REGIST_YMD.value+" ";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 59;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.PAY_IN_CAPITAL_AMT_K.value+"  (천원)"+"\r\n";
	myControl.ex_send_1_string();
 
	// 주소2와 날짜 위치 조정
	myControl.prop_lpi = 5;		
	myControl.ex_set_lpi();
	
	myControl.prop_horizontal_tab = 18;
	myControl.ex_set_horizontal_tab();
 
	//한글 문자수
	for(var k=0,i=0;i < document.frm.SITE_ADDR.value.length;i++){ 
		if(document.frm.SITE_ADDR.value.charCodeAt(i) > 127) k++;
	}	
 
	if(document.frm.SITE_ADDR.value.length>50-k){
		myControl.prop_stringToSend = document.frm.SITE_ADDR.value.substring(0,50-k)+" "+"\r\n";
		myControl.ex_send_1_string();
		
		myControl.prop_horizontal_tab = 18;
		myControl.ex_set_horizontal_tab();
		
		myControl.prop_stringToSend = document.frm.SITE_ADDR.value.substring(50-k)+" "+"\r\n";
		myControl.ex_send_1_string();
	}else{
		myControl.prop_stringToSend = document.frm.SITE_ADDR.value+" "+"\r\n\r\n";
		myControl.ex_send_1_string();
	}	
 
	// 주소2와 날짜 위치 조정
	myControl.prop_lpi = 4;		
	myControl.ex_set_lpi();
 
	myControl.prop_stringToSend = "\r\n";
	myControl.ex_send_1_string();
	
	myControl.prop_horizontal_tab = 48;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.FIRST_ISSUE_Y.value+" ";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 59;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.FIRST_ISSUE_M.value+" ";
	myControl.ex_send_1_string();
 
	myControl.prop_horizontal_tab = 69;
	myControl.ex_set_horizontal_tab();
 
	myControl.prop_stringToSend = document.frm.FIRST_ISSUE_D.value+" ";
	myControl.ex_send_1_string();
 
	myControl.ex_eject_paper();
	
	myControl.ex_port_1_terminate();
}