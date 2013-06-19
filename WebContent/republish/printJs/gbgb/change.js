
var myControl;
function StartUp() {
	myControl = GetMyObject();
}
function PrintPage() {
	var count = document.frm.count.value;	
	
	var cntNum = parent.searchfrm.printNum.value;
	parent.searchfrm.printNum.value="";
	cntNum = cntNum-0;
	
	
	if(cntNum <=6) {
		
		cntNum = ((cntNum-1) *2) + 26;//27 
		
	} else {
		cntNum = ((cntNum-7) *2) + 5;//6 
	}
	
	
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
	var vertical = cntNum;
	if(count > 0) {
			myControl.prop_vertical_line = vertical;
			myControl.ex_set_vertical_line();
			myControl.prop_horizontal_tab = 3;
			myControl.ex_set_horizontal_tab();			
			myControl.prop_stringToSend = eval("document.frm.change_ymd").value+" ";
			myControl.ex_send_1_string();    		
			myControl.prop_horizontal_tab = 15;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.d_name").value+" ";
			myControl.ex_send_1_string();	    		
			myControl.prop_horizontal_tab = 34;
			myControl.ex_set_horizontal_tab();    		
			myControl.prop_stringToSend = eval("document.frm.chg_story1").value+" "+"\r\n";
			myControl.ex_send_1_string();					
			myControl.prop_horizontal_tab = 34;
			myControl.ex_set_horizontal_tab();				
			myControl.prop_stringToSend = eval("document.frm.chg_story2").value+" ";
			myControl.ex_send_1_string();	
			vertical += 2;
	
	} else {
		alert("인쇄할 내용이 없습니다.");
	}
	myControl.ex_eject_paper();	
	myControl.ex_port_1_terminate();
}