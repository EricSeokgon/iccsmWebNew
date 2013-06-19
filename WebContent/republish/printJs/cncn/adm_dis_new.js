var myControl;
function StartUp() {
	myControl = GetMyObject();
}
function PrintPage() {
	var count = document.frm.count.value;	
	var pgubun = "1";
	if( myControl == null || !myControl ){ 
		alert('ACTIVE X를 완전히 다운 받으셔야 됩니다.');
		location.reload();
		return;
	}	
	var ret = myControl.ex_port_1_open();	
	if(ret == 0){
		alert("시리얼 1포트를 열 수 없습니다.");
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
	myControl.prop_lpi = 6;
	myControl.ex_set_lpi();
	var vertical = 27;
	if(count > 0) {
		for(i=0;i<count;i++) {			
			if( (pgubun == "4") && (eval("document.frm.RREGIST_WRITE_YN"+i).value == "Y") ){
				vertical += 2;
				continue;
			}
			myControl.prop_vertical_line = vertical;
			myControl.ex_set_vertical_line();
			myControl.prop_horizontal_tab = 3;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.STOP_YMD_FM"+i).value+" ";
			myControl.ex_send_1_string();    		
			myControl.prop_horizontal_tab = 16;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.REGIST_WRITE_YN"+i).value+" ";
			myControl.ex_send_1_string();	    		
			myControl.prop_horizontal_tab = 35;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.PUNISHMENT_REASON1"+i).value+" "+"\r\n";
			myControl.ex_send_1_string();					
			myControl.prop_horizontal_tab = 35;
			myControl.ex_set_horizontal_tab();				
			myControl.prop_stringToSend = eval("document.frm.PUNISHMENT_REASON2"+i).value+" ";
			myControl.ex_send_1_string();	
			vertical += 2;
		}
	} else {
		alert("인쇄할 내용이 없습니다.");
	}
	myControl.ex_eject_paper();	
	myControl.ex_port_1_terminate();
}