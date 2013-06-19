package kjf.util;

/**
 * <p>Subsystem     : 공통 </p>
 * <p>Title         : 공통 탭상자 Custom Tag </p>
 * <p>Description   : 공통 탭상자</p>
 * @author 김경덕
 * @version 1.0 2003.04.28 <br/> 
*/
public class KJFTab {

	private String columTitle[];
	private String columUrl[];
	private String columWidth[];
	private String columSelected[];
	private boolean isScript=false;

	public KJFTab(String arg_totaColum[]) {


		columTitle = new String[arg_totaColum.length];
		columUrl 		= new String[arg_totaColum.length];
		columWidth = new String[arg_totaColum.length];
		columSelected = new String[arg_totaColum.length];


		try{
		for(int i=0; i< arg_totaColum.length ; i++){
			String ls_tmp[] = KJFUtil.str2strs(arg_totaColum[i],"|");
			columTitle[i]=ls_tmp[0];
			columUrl[i]= ls_tmp[1];
			columWidth[i]= "";
			columSelected[i]= "";
			if(ls_tmp[2].length() > 4){
				String flag = ls_tmp[2].substring(0,4);
				String value= ls_tmp[2].substring(4, ls_tmp[2].length());
				if(flag.equalsIgnoreCase("sel-")){
					columWidth[i]= value;
					columSelected[i]= flag;
				}else{
					columWidth[i]= ls_tmp[2];
					columSelected[i]= "";
				}
			} else{
				columWidth[i]= ls_tmp[2];
				columSelected[i]= "";
			}

		}//for(int i=0; i< arg_totaColum.length ; i++)
		} catch(Exception e){
			e.printStackTrace();
		}

	}


	public String toString() {

		StringBuffer rtnBuf = new StringBuffer();

		try {
			if(isScript){
		      rtnBuf.append("\t\t<script>\r\n");
		      rtnBuf.append("\t\tfunction tab_click(n) {\r\n");
		      rtnBuf.append("\t\t\tfor(var i = 0; i < "+columTitle.length+"; i++) {\r\n");
		      rtnBuf.append("\r\n");
		      rtnBuf.append("\t\t\t\tleft_img = document.getElementById(\"left_bg\"+i);\r\n");
		      rtnBuf.append("\t\t\t\teval(\"center_td=document.all.center_bg\"+i);\r\n");
		      rtnBuf.append("\t\t\t\tright_img = document.getElementById(\"right_bg\"+i);\r\n");
		      rtnBuf.append("\r\n");
		      rtnBuf.append("\t\t\t\tif ( n == i ) {\r\n");
		      rtnBuf.append("\t\t\t\t\tleft_img.src = \"../images/tab_left_r.gif\";\t\t\r\n");
		      rtnBuf.append("\t\t\t\t\tcenter_td.style.backgroundImage=\"url(../images/tab_center_r.gif)\";\r\n");
		      rtnBuf.append("\t\t\t\t\tright_img.src = \"../images/tab_right_r.gif\"; \r\n");
		      rtnBuf.append("\t\t\t\t} else {\r\n");
		      rtnBuf.append("\t\t\t\t\tleft_img.src = \"../images/tab_left.gif\";\r\n");
		      rtnBuf.append("\t\t\t\t\tcenter_td.style.backgroundImage=\"url(../images/tab_center.gif)\";\r\n");
		      rtnBuf.append("\t\t\t\t\tright_img.src = \"../images/tab_right.gif\"; \r\n");
		      rtnBuf.append("\t\t\t\t}\r\n");
		      rtnBuf.append("\t\t\t}\r\n");
		      rtnBuf.append("\t\t}\r\n");
		      rtnBuf.append("\t\t</script>\r\n");
			}
			  rtnBuf.append("\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" background=\"../images/tab_bg.gif\">\r\n\t\t  ");
		      rtnBuf.append("<tr><td> \r\n");

		      rtnBuf.append("\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t  ");
		      rtnBuf.append("<tr> \r\n");

			for(int i=0;i<columTitle.length ;i++){
				String selected="";
				if(KJFUtil.print(columSelected[i]).equalsIgnoreCase("sel-")) selected="_r";

		      rtnBuf.append("\t\t  \r\n\t\t\t");
		      rtnBuf.append("<td >\r\n                  ");
		      rtnBuf.append("<img src=\"../images/tab_left");
		      rtnBuf.append(selected);
		      rtnBuf.append(".gif\" id=\"left_bg"+i+"\">");
		      rtnBuf.append("</td>\r\n\t\t\t");
		      rtnBuf.append("<td width=\"");
		      rtnBuf.append(columWidth[i] );
		      rtnBuf.append("\" valign=\"middle\" align=\"center\" background=\"../images/tab_center");
		      rtnBuf.append(selected);
//		      rtnBuf.append(".gif\" id=\"center_bg"+i+"\">\r\n");
		      rtnBuf.append(".gif\" id=\"center_bg"+i+"\" style=\"margin:0 0 0 0;cursor:hand;\" onclick=\"javascript:tab_click("+i+");");//정용규 수정
		      rtnBuf.append(columUrl[i] );//정용규 수정
		      rtnBuf.append("\">");//정용규 수정
		      rtnBuf.append("\t\t\t\r\n\t\t\t");
//		      rtnBuf.append("<a onFocus='this.blur();' style='TEXT-DECORATION: none;' href=\"");
//		      if(isScript)rtnBuf.append("javascript:tab_click("+i+");");
//		      rtnBuf.append(columUrl[i] );
//		      rtnBuf.append("\">");
		      rtnBuf.append(columTitle[i] );
//		      rtnBuf.append("</a>\t\t\t\t\t\r\n");
//		      rtnBuf.append("\r\n\t\t\t");
		      rtnBuf.append("</td>\t\t\t\r\n\t\t\t");
		      rtnBuf.append("<td >");
		      rtnBuf.append("<img src=\"../images/tab_right");
		      rtnBuf.append(selected);
		      rtnBuf.append(".gif\" id=\"right_bg"+i+"\">");
		      rtnBuf.append("</td>\r\n");

			}

		      rtnBuf.append("\r\n            ");
		      rtnBuf.append("<td  align=\"right\">&nbsp;\r\n            ");
		      rtnBuf.append("</td>\r\n\t\t  ");
		      rtnBuf.append("</tr>\r\n");
		      rtnBuf.append("<tr> \r\n\t\t\t");
		      rtnBuf.append("<td height=\"5\" colspan=\"100\"> ");
		      rtnBuf.append("</td>\r\n\t\t  ");
		      rtnBuf.append("</tr>\r\n\t\t");
		      rtnBuf.append("</table>\r\n        ");

		      rtnBuf.append("</td></tr>\r\n\t\t");
		      rtnBuf.append("</table>\r\n        ");

		} catch(Exception e){
			e.printStackTrace();
		}

		return rtnBuf.toString();
	}

	public String toScript() {

		isScript=true;

		return toString();
	}
}
