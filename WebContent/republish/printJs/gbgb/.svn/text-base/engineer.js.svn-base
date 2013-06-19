

var myControl;
 
function StartUp() {
	myControl = GetMyObject();
}
 
function PrintPage() {
 
	var count = document.frm.count.value;
	var num = document.frm.number.value ;
	
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
	
	
	var vertical = 27;//28
	myControl.prop_vertical_line = vertical;
	myControl.ex_set_vertical_line();
	
	
	
	if(count > 0) {
		for(i=Number(0)+Number(0);i<Number(num)+Number(0);i++) {
 
			
			if( (pgubun == "4") && (eval("document.frm.IN_WRITE_YN"+i).value == "Y") ){
				myControl.prop_stringToSend = " "+"\r\n\r\n";
				myControl.ex_send_1_string();
				continue;
			}
			
			myControl.prop_horizontal_tab = 3;
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.NM_KOR"+i).value;
			myControl.ex_send_1_string();
			
			myControl.prop_horizontal_tab = 12;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.TECH_GRADE_NM"+i).value+" ";
			myControl.ex_send_1_string();
    		
			myControl.prop_horizontal_tab = 40;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.VLID_YMD_FR"+i).value+" ";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 32;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.EDU_FINISH_YMD"+i).value+" ";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 50;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.AFTER_JOIN_COMP_YMD_Y"+i).value+"/";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 65;
			myControl.ex_set_horizontal_tab();
    		
			if(eval("document.frm.AFTER_RETIRE_YMD_Y"+i).value==""){
				myControl.prop_stringToSend = " "+"\r\n";
				myControl.ex_send_1_string();
			}else{	
				myControl.prop_stringToSend = eval("document.frm.AFTER_RETIRE_YMD_Y"+i).value+"/"+"\r\n";
				myControl.ex_send_1_string();
			}	
			
			myControl.prop_horizontal_tab = 12;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.CAREER_NOTE_NO"+i).value+" ";
			myControl.ex_send_1_string();
    		
			myControl.prop_horizontal_tab = 40;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.VLID_YMD_TO"+i).value+" ";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 50;
			myControl.ex_set_horizontal_tab();
    		
			
			myControl.prop_stringToSend = eval("document.frm.AFTER_JOIN_COMP_YMD_M"+i).value+"/"+eval("document.frm.AFTER_JOIN_COMP_YMD_D"+i).value;
			myControl.ex_send_1_string();	
			
			myControl.prop_horizontal_tab = 65;
			myControl.ex_set_horizontal_tab();
    		
			if(eval("document.frm.AFTER_RETIRE_YMD_Y"+i).value==""){
				myControl.prop_stringToSend = " "+"\r\n";
				myControl.ex_send_1_string();
			}else{	
				myControl.prop_stringToSend = eval("document.frm.AFTER_RETIRE_YMD_M"+i).value+"/"+eval("document.frm.AFTER_RETIRE_YMD_D"+i).value+"\r\n";
				myControl.ex_send_1_string();
			}	
 
			
		}
	} else {
		alert("인쇄할 내용이 없습니다.");
	}
 
	myControl.ex_eject_paper();
	
	myControl.ex_port_1_terminate();
		
}
 
 
function PrintPage2() {
 
	var count = document.frm.count.value;
	var num = document.frm.number.value ;
	
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
	
	
	var vertical = 6;//7
	myControl.prop_vertical_line = vertical;
	myControl.ex_set_vertical_line();
	
	
	
	if(count > 0) {
		for(i=Number(0)+Number(0);i<Number(num)+Number(0);i++) {
 
			
			if( (pgubun == "4") && (eval("document.frm.IN_WRITE_YN"+i).value == "Y") ){
				myControl.prop_stringToSend = " "+"\r\n\r\n";
				myControl.ex_send_1_string();
				continue;
			}
			
			myControl.prop_horizontal_tab = 3;
			myControl.ex_set_horizontal_tab();
			myControl.prop_stringToSend = eval("document.frm.NM_KOR"+i).value;
			myControl.ex_send_1_string();
			
			myControl.prop_horizontal_tab = 12;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.TECH_GRADE_NM"+i).value+" ";
			myControl.ex_send_1_string();
    		
			myControl.prop_horizontal_tab = 40;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.VLID_YMD_FR"+i).value+" ";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 32;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.EDU_FINISH_YMD"+i).value+" ";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 50;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.AFTER_JOIN_COMP_YMD_Y"+i).value+"/";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 65;
			myControl.ex_set_horizontal_tab();
    		
			if(eval("document.frm.AFTER_RETIRE_YMD_Y"+i).value==""){
				myControl.prop_stringToSend = " "+"\r\n";
				myControl.ex_send_1_string();
			}else{	
				myControl.prop_stringToSend = eval("document.frm.AFTER_RETIRE_YMD_Y"+i).value+"/"+"\r\n";
				myControl.ex_send_1_string();
			}	
			
			myControl.prop_horizontal_tab = 12;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.CAREER_NOTE_NO"+i).value+" ";
			myControl.ex_send_1_string();
    		
			myControl.prop_horizontal_tab = 40;
			myControl.ex_set_horizontal_tab();
    		
			myControl.prop_stringToSend = eval("document.frm.VLID_YMD_TO"+i).value+" ";
			myControl.ex_send_1_string();	
    		
			myControl.prop_horizontal_tab = 50;
			myControl.ex_set_horizontal_tab();
    		
			
			myControl.prop_stringToSend = eval("document.frm.AFTER_JOIN_COMP_YMD_M"+i).value+"/"+eval("document.frm.AFTER_JOIN_COMP_YMD_D"+i).value;
			myControl.ex_send_1_string();	
			
			myControl.prop_horizontal_tab = 65;
			myControl.ex_set_horizontal_tab();
    		
			if(eval("document.frm.AFTER_RETIRE_YMD_Y"+i).value==""){
				myControl.prop_stringToSend = " "+"\r\n";
				myControl.ex_send_1_string();
			}else{	
				myControl.prop_stringToSend = eval("document.frm.AFTER_RETIRE_YMD_M"+i).value+"/"+eval("document.frm.AFTER_RETIRE_YMD_D"+i).value+"\r\n";
				myControl.ex_send_1_string();
			}	
 
			
		}
	} else {
		alert("인쇄할 내용이 없습니다.");
	}
 
	myControl.ex_eject_paper();
	
	myControl.ex_port_1_terminate();
	
	
	
}