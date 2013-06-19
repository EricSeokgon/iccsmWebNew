function viewpall(n, txt, count){
  var txtn;
  var view;
  var count2 = parseInt(count)+1;
  for(i=1;i<count2;i++){
	txtn = txt+eval(i);
	view = eval("this.viewp"+txt+i);
	if(n==txtn){
	   view.style.display = "";
	}
	else{
	   view.style.display = "none";
	}
  }
}