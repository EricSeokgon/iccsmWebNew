<%@ page contentType="text/html; charset=utf-8" %>
<%
String frm = request.getParameter("frm");
String fName = request.getParameter("fName");
%>
<HTML>
<HEAD>
<TITLE>날짜 입력</TITLE>

<style type="text/css">
a:link { text-decoration: none;}
a:visited { text-decoration: none;}
TD { text-align: center; vertical-align: middle;}
.CalHead { font:bold 8pt Arial; color: black;}
.CalCell { font:8pt Arial; cursor: hand;}
.HeadBtn { vertical-align:middle; height:22; width:18; font:10pt Fixedsys;}
.HeadBox { vertical-align:middle; font:10pt;}
.Today { font:bold 10pt Arial; color:white;}
</style>
</head>
<body style='width:100%;overflow-x:hidden;overflow-y:hidden' leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>

<script>
<!--
/******** 환경설정 부분 *******************************************************/

var giStartYear = 1973;
var giEndYear = 2073;
var giCellWidth = 16;
var gMonths = new Array("01","02","03","04","05","06","07","08","09","10","11","12");
var gcOtherDay = "gray";
var gcToggle = "yellow";
var gcBG = "#ffffff";
var gcTodayBG = "#eeeeee";
var gcFrame = "#efefef";
var gcHead = "green";
var gcWeekend = "red";
var gcWorkday = "black";
var gcCalBG = "lightblue";
//-->

var gcTemp = gcBG;
var gdCurDate = new Date();
var giYear = gdCurDate.getFullYear();
var giMonth = gdCurDate.getMonth()+1;
var giDay = gdCurDate.getDate();
var tbMonSelect, tbYearSelect;
var gCellSet = new Array;

function fSetDate(iYear, iMonth, iDay){
  if(iDay < 10) iDay = '0'+iDay;
  if(iMonth < 10) iMonth = '0'+iMonth;
  iDay1 = iDay + 5;
  iDay2 = iDay + 14;
  ilja = iYear+'-'+iMonth+'-'+iDay;
  ilja1 = iYear+'-'+iMonth+'-'+iDay1;
  ilja2 = iYear+'-'+iMonth+'-'+iDay2;
  
  parent.<%=frm%>.<%=fName%>.value=iYear+'-'+iMonth+'-'+iDay;
  parent.click_where();

}

function fSetSelected(aCell){
  var iOffset = 0;
  var iYear = parseInt(tbSelYear.value);
  var iMonth = parseInt(tbSelMonth.value);

  aCell.bgColor = gcBG;

  with (aCell.firstChild){
          var iDate = parseInt(innerHTML);
          if (style.color==gcOtherDay)
                iOffset = (id<10)?-1:1;
        iMonth += iOffset;
        if (iMonth<1) {
                iYear--;
                iMonth = 12;
        }else if (iMonth>12){
                iYear++;
                iMonth = 1;
        }
 }


  fSetDate(iYear, iMonth, iDate);
}



function fBuildCal(iYear, iMonth) {
  var aMonth=new Array();
  for(i=1;i<7;i++)
          aMonth[i]=new Array(i);

  var dCalDate=new Date(iYear, iMonth-1, 1);
  var iDayOfFirst=dCalDate.getDay();
  var iDaysInMonth=new Date(iYear, iMonth, 0).getDate();
  var iOffsetLast=new Date(iYear, iMonth-1, 0).getDate()-iDayOfFirst+1;
  var iDate = 1;
  var iNext = 1;

  for (d = 0; d < 7; d++)
        aMonth[1][d] = (d<iDayOfFirst)?-(iOffsetLast+d):iDate++;
  for (w = 2; w < 7; w++)
          for (d = 0; d < 7; d++)
                aMonth[w][d] = (iDate<=iDaysInMonth)?iDate++:-(iNext++);
  return aMonth;
}

function fDrawCal(iCellWidth) {
  var WeekDay = new Array("일","월","화","수","목","금","토");
  var styleTD = " width='"+iCellWidth+"' ";

  with (document) {
        write("<tr>");
        for(i=0; i<7; i++)
                write("<td class='CalHead' "+styleTD+">" + WeekDay[i] + "</td>");
        write("</tr>");

          for (w = 1; w < 7; w++) {
                write("<tr>");
                for (d = 0; d < 7; d++) {
                       write("<td class='CalCell' "+styleTD+" onMouseOver='gcTemp=this.bgColor;this.bgColor=gcToggle;this.bgColor=gcToggle' onMouseOut='this.bgColor=gcTemp;this.bgColor=gcTemp' onclick='fSetSelected(this)'>");
                        write("<A href='#null' onfocus='this.blur();'>00</A></td>")
                }
                write("</tr>");
        }
  }
}

function fUpdateCal(iYear, iMonth) {
  myMonth = fBuildCal(iYear, iMonth);
  var i = 0;
  var iDate = 0;
  for (w = 0; w < 6; w++)
        for (d = 0; d < 7; d++)
               with (gCellSet[(7*w)+d]) {
                        id = i++;
                        if (myMonth[w+1][d]<0) {
                                style.color = gcOtherDay;
                                innerHTML = -myMonth[w+1][d];
                                iDate = 0;
                        }else{
                                style.color = ((d==0)||(d==6))?gcWeekend:gcWorkday;
                                innerHTML = myMonth[w+1][d];
                                iDate++;
                        }
                        parentNode.bgColor = ((iYear==giYear)&&(iMonth==giMonth)&&(iDate==giDay))?gcTodayBG:gcBG;
                        parentNode.bgColor = parentNode.bgColor;
                }
}

function fSetYearMon(iYear, iMon){
  tbSelMonth.options[iMon-1].selected = true;
  if (iYear>giEndYear) iYear=giEndYear;
  if (iYear<giStartYear) iYear=giStartYear;
  tbSelYear.options[iYear-giStartYear].selected = true;
  fUpdateCal(iYear, iMon);
}

function fPrevMonth(){
  var iMon = tbSelMonth.value;
  var iYear = tbSelYear.value;

  if (--iMon<1) {
         iMon = 12;
          iYear--;
  }

  fSetYearMon(iYear, iMon);
}

function fNextMonth(){
  var iMon = tbSelMonth.value;
  var iYear = tbSelYear.value;


  if (++iMon>12) {
          iMon = 1;
          iYear++;
  }

 fSetYearMon(iYear, iMon);
}

with (document) {
  write("<table align=center id='popTable' bgcolor='"+gcCalBG+"' cellspacing='0' cellpadding='1' border='0'><TR>");
  write("<td align='center'><input type='button' value='<' class='HeadBtn' onClick='fPrevMonth()'>");
  write("&nbsp;<select id='tbMonSelect' class='HeadBox' onChange='fUpdateCal(tbSelYear.value, tbSelMonth.value)' Victor='Won'>");
  for (i=0; i<12; i++)
        write("<option value='"+(i+1)+"'>"+gMonths[i]+"</option>");
  write("</SELECT><SELECT id='tbYearSelect' class='HeadBox' onChange='fUpdateCal(tbSelYear.value, tbSelMonth.value)' Victor='Won'>");
  for(i=giStartYear;i<=giEndYear;i++)
        write("<OPTION value='"+i+"'>"+i+"</OPTION>");
  write("</SELECT>&nbsp;<input type='button' value='>' class='HeadBtn' onclick='fNextMonth()'>");
  write("</td></TR><TR><td align='center'>");
  write("<DIV style='background-color:"+gcFrame+";width:"+((giCellWidth+6)*7+2)+"px;'><table border='0' cellpadding='2' >");
  tbSelMonth = getElementById("tbMonSelect");
 tbSelYear = getElementById("tbYearSelect");
  fDrawCal(giCellWidth);
  gCellSet = getElementsByTagName("A");
  fSetYearMon(giYear, giMonth);
  write("</table></DIV></td></TR><TR><TD align='center'>");
  write("<A href='#null' class='Today' onclick='fSetDate(giYear,giMonth,giDay); this.blur();' onMouseOver='gcTemp=this.style.color;this.style.color=gcToggle' onMouseOut='this.style.color=gcTemp'>오늘 :&nbsp;"+giYear+" "+gMonths[giMonth-1]+" "+giDay+"</A>");
  write("</TD></TR></TD></TR><TR></TR></TABLE>");

 // opener.document.getElementById(self.name).width = getElementById("popTable").offsetWidth;
  //opener.document.getElementById(self.name).height = getElementById("popTable").offsetHeight;
}
// -->
</script>
</body>
</html>