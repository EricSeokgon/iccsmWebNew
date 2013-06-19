<%@ page language="java" contentType="text/html;charset=euc-kr" isErrorPage="true" %>
<%
	// modified by Sangwook, Han (2005-12-26)
	// contentType="text/html;charset=iso-8859-1" -> contentType="text/html;charset=euc-kr"


	//String errmsg=request.getParameter("errmsg")==null?exception.toString():request.getParameter("errmsg");
	String errmsg=request.getParameter("errmsg")==null?exception.toString():request.getParameter("errmsg");

	// added by Sangwook, Han (2005-12-26)
	errmsg=new String(errmsg.getBytes("8859_1"),"euc-kr");
	
%>
<html>
<head>
<title>
	GPKIError Page
</title>
<STYLE>
BODY
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
TABLE
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
TR
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
TD
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
SELECT
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
INPUT
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
TEXTAREA
{
    SCROLLBAR-FACE-COLOR: #dddddd;
    FONT-SIZE: 9pt;
    SCROLLBAR-HIGHLIGHT-COLOR: #cccccc;
    SCROLLBAR-SHADOW-COLOR: #cccccc;
    COLOR: #333333;
    SCROLLBAR-3DLIGHT-COLOR: #f5f5f5;
    LINE-HEIGHT: 18px;
    SCROLLBAR-ARROW-COLOR: #000000;
    SCROLLBAR-TRACK-COLOR: #f0f0f0;
    FONT-FAMILY: "±¼¸²", "arial";
    SCROLLBAR-DARKSHADOW-COLOR: #f5f5f5
}
A:link
{
    COLOR: #1f3174;
    TEXT-DECORATION: none
}
A:active
{
    COLOR: #1f3174;
    TEXT-DECORATION: none
}
A:visited
{
    COLOR: #1f3174;
    TEXT-DECORATION: none
}
A:hover
{
    COLOR: #3366cc;
    TEXT-DECORATION: underline
}
A.s11:link
{
    COLOR: #ffffff;
    TEXT-DECORATION: none
}
A.s11:visited
{
    COLOR: #ffffff;
    TEXT-DECORATION: none
}
A.s11:active
{
    COLOR: #ffffff;
    TEXT-DECORATION: none
}
A.s11:hover
{
    COLOR: #ddeeff;
    TEXT-DECORATION: none
}
A.copyright:link
{
    COLOR: #e0e0e0;
    TEXT-DECORATION: none
}
A.copyright:visited
{
    COLOR: #e0e0e0;
    TEXT-DECORATION: none
}
A.copyright:active
{
    COLOR: #e0e0e0;
    TEXT-DECORATION: none
}
A.copyright:hover
{
    COLOR: #aaaaaa;
    TEXT-DECORATION: none
}
A.gray:link
{
    COLOR: #666666;
    TEXT-DECORATION: none
}
A.gray:visited
{
    COLOR: #666666;
    TEXT-DECORATION: none
}
A.gray:active
{
    COLOR: #666666;
    TEXT-DECORATION: none
}
A.gray:hover
{
    COLOR: #000000;
    TEXT-DECORATION: underline
}
A.gray2:link
{
    COLOR: #222222;
    TEXT-DECORATION: none
}
A.gray2:visited
{
    COLOR: #222222;
    TEXT-DECORATION: none
}
A.gray2:active
{
    COLOR: #222222;
    TEXT-DECORATION: none
}
A.gray2:hover
{
    COLOR: #666666;
    TEXT-DECORATION: underline
}
A.orange:link
{
    COLOR: #ff3300;
    TEXT-DECORATION: none
}
A.orange:visited
{
    COLOR: #ff3300;
    TEXT-DECORATION: none
}
A.orange:active
{
    COLOR: #ff3300;
    TEXT-DECORATION: none
}
A.orange:hover
{
    COLOR: #ff6600;
    TEXT-DECORATION: underline
}
.basic
{
    FONT-SIZE: 9pt;
    LINE-HEIGHT: 20px;
    FONT-FAMILY: "±¼¸²";
    TEXT-ALIGN: justify;
    TEXT-DECORATION: none
}
.basic9
{
    FONT-SIZE: 9pt;
    COLOR: #333333;
    LINE-HEIGHT: 130%;
    FONT-FAMILY: "±¼¸²";
    TEXT-ALIGN: justify;
    TEXT-DECORATION: none
}
.gray_130
{
    COLOR: #333333;
    LINE-HEIGHT: 130%
}
.gray_b
{
    FONT-WEIGHT: bold;
    COLOR: #333333
}
.f11
{
    FONT-SIZE: 11px
}
.subtitle
{
    FONT-WEIGHT: bold;
    FONT-SIZE: 14px;
    COLOR: #ff3300
}
.orange1
{
    COLOR: #ff3300
}
.orange2
{
    COLOR: #ee7000
}
.orange_b
{
    FONT-WEIGHT: bold;
    COLOR: #ff3300
}
.pink
{
    COLOR: #ff4a85
}
.pink_b
{
    FONT-WEIGHT: bold;
    COLOR: #ff4a85
}
.blue
{
    FONT-SIZE: 11px;
    COLOR: #333333
}
.blue_b
{
    FONT-WEIGHT: bold;
    COLOR: #0099cc
}
.brown
{
    COLOR: #ac5009
}
.brown_b
{
    FONT-WEIGHT: bold;
    COLOR: #ac5009
}
.green
{
    COLOR: #5b7243
}
.green_b
{
    FONT-WEIGHT: bold;
    COLOR: #5b7243
}
.verdana
{
    FONT-SIZE: 9px;
    FONT-FAMILY: verdana
}
.verdana_b
{
    FONT-WEIGHT: bold;
    FONT-SIZE: 9px;
    FONT-FAMILY: verdana
}
.num
{
    FONT-SIZE: 9px;
    FONT-FAMILY: verdana;
    LETTER-SPACING: -1px
}
.td_gray
{
    COLOR: #333333;
    BORDER-BOTTOM: #e6e6e6 1px solid
}
.input2
{
    BORDER-RIGHT: #333333 1px solid;
    BORDER-TOP: #333333 1px solid;
    BORDER-LEFT: #333333 1px solid;
    COLOR: #666666;
    BORDER-BOTTOM: #333333 1px solid
}
.gray3
{
    COLOR: #333333;
    TEXT-ALIGN: justify
}
.t9L
{
    FONT-WEIGHT: normal;
    FONT-SIZE: 11px;
    FONT-FAMILY: "Tahoma", "±¼¸²";
    TEXT-ALIGN: justify;
    TEXT-DECORATION: none
}
.t9R
{
    FONT-WEIGHT: normal;
    FONT-SIZE: 11px;
    FONT-FAMILY: "Tahoma", "±¼¸²";
    TEXT-DECORATION: none
}
.gray4
{
    COLOR: #333333;
    LINE-HEIGHT: 105%;
    TEXT-ALIGN: justify;
    TEXT-DECORATION: none
}
</STYLE>
</head>
<body>
	<font size=5><b>GPKIError Page.</b></font><p>
	<table  border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td bgColor='#A198FE' width=100>
				<b>&nbsp;Message</b>
			</td>
			<td >
				&nbsp;<%=errmsg%>
			</td>
		</tr>
	</table>
</body>
</html>