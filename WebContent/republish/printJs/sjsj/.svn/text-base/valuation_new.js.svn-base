
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
		alert("시리얼 1포트를 열 수 없습니다. PC 재부팅후 다시 해보시기 바랍니다.");
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
	var vertical = 7;//6;
	var horizontal = 4;//3
	if(count > 0) {
		for(i=0;i<count;i++) {
			myControl.prop_vertical_line = vertical;
			myControl.ex_set_vertical_line();
			myControl.prop_horizontal_tab = horizontal;
			myControl.ex_set_horizontal_tab();			
			if( (pgubun == "4") && (eval("document.frm.REGIST_WRITE_YN"+i).value == "Y") ){
				if(i != 5) {
					vertical += 2;
				} else {
					vertical = 7;//6;
					horizontal = 42;//41
				}
				continue;
			}	
			myControl.prop_stringToSend = eval("document.frm.EVAL_Y"+i).value+"/";
			myControl.ex_send_1_string();
			if(i > 5) {
				myControl.prop_horizontal_tab = 45;
			} else {
				myControl.prop_horizontal_tab = 8;//7
			}
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.ABILITY_EVAL_AMT"+i).value;
			myControl.ex_send_1_string();
			if(i > 5) {
				myControl.prop_horizontal_tab = 63;
			} else {
				myControl.prop_horizontal_tab = 26;//25
			}
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.APPLY_Y"+i).value+"/";
			myControl.ex_send_1_string();	
			if(i > 5) {
				myControl.prop_horizontal_tab = 66;
			} else {
				myControl.prop_horizontal_tab = 29;//28
			}
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.APPLY_M"+i).value+"/";
			myControl.ex_send_1_string();	
			if(i > 5) {
				myControl.prop_horizontal_tab = 69;
			} else {
				myControl.prop_horizontal_tab = 32;//31
			}
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.APPLY_D"+i).value+"\r\n";
			myControl.ex_send_1_string();	
			if(i > 5) {
				myControl.prop_horizontal_tab = 41;
			} else {
				myControl.prop_horizontal_tab = 4;//3
			}
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.EVAL_M"+i).value+"/"+eval("document.frm.EVAL_D"+i).value;
			myControl.ex_send_1_string();
			if(i > 5) {
				myControl.prop_horizontal_tab = 63;
			} else {
				myControl.prop_horizontal_tab = 26;//25
			}
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.TO_GIGAN"+i).value;
			myControl.ex_send_1_string();
			if(i != 5) {
				vertical += 2;
			} else {
				vertical = 8;//6;
				horizontal = 42;//41
			}
		}
	}
	myControl.ex_eject_paper();	
	myControl.ex_port_1_terminate();	
}
