<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="kjf.util.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>

<%!
final static String PREV_MARK = "<img src='../bbs/images/bot_bt_p.gif' border='0' align='absmiddle'>";
final static String NEXT_MARK = "<img src='../bbs/images//bot_bt_n.gif' border='0' align='absmiddle'>";
%>
<%

	int pagePerScreen = 10; //�� ��ũ�� �� ������ ����
	int row_perPage    = 10; //�� �������� ��ϰ���

	int totalScreen = 1; //��ü ��ũ�� ��
	int totalPage   = 1; //��ü ������ ��
	int nowScreen   = 1; //���� ��ũ��
	int n_page     = 1; //���� ������
	int total_cnt  = 1; //��ü �˻���� ��
	int firstPageNumber = 1;  //���� ��ũ���� ���۹�ȣ
	int lastPageNumber  = 1; //���� ��ũ���� ��������ȣ

	//�Ķ���� ������ ����
	try {
		row_perPage    = request.getParameter("rowPerPage")   ==null? 10 : Integer.parseInt(request.getParameter("rowPerPage"));
		total_cnt    = request.getParameter("totalCount")   ==null?  1 : Integer.parseInt(request.getParameter("totalCount"));
		n_page       = request.getParameter("nowPage")      ==null?  1 : Integer.parseInt(request.getParameter("nowPage"));
	}catch (Exception ex) {
	}

	//��ü ������ �� ����.
	if (row_perPage==0){
		totalPage = 1;
	} else {
		totalPage = (int)Math.ceil((double)total_cnt / (double)row_perPage);
		if (totalPage == 0) totalPage = 1;
	}

	//��ü ��ũ�� �� ����
	totalScreen = (int)Math.ceil((double)totalPage / (double)pagePerScreen);
	if (totalScreen == 0) totalScreen = 1;

	//���� ��ũ�� ����
	nowScreen = (int)Math.ceil((double)n_page / (double)pagePerScreen);

	//���� ��ũ���� ���۹�ȣ
	firstPageNumber = (nowScreen * pagePerScreen) - (pagePerScreen - 1);
	//���� ��ũ���� ��������ȣ
	if (nowScreen == totalScreen) {
		lastPageNumber = totalPage;
	}else{
		lastPageNumber = nowScreen * pagePerScreen;
	}

%>



	            <table border="0" cellpadding="0" cellspacing="0" width=100%>
                <tr>
                    <td align=center class=bbs04>
					<%if(n_page == 1){%>
                    <a href="javascript:alert('���̻� �������� �����ϴ�.')">
					<%}else{%>
					<a href="javascript:movePage('1')">
					<%}%>
					<img src="../bbs/images/arr_left.gif" align="absmiddle" border="0"></a>
                    <%
				if (nowScreen == 1) {
					if(n_page == 1){				
				%>
				<%}else{%>
				<a href="javascript:movePage('<%=(n_page-1)%>')"></a>	
				<%}%>
				<%
				}else{
					out.print("<a href=\"javascript:movePage('" + ((nowScreen - 1) * 10) + "')\">" + "</a>");
				}
			%>
			<%
			for (int i = firstPageNumber; i <= lastPageNumber ; i++) {
				if (i != firstPageNumber)
					out.print("|");
				if (i == n_page) {
					out.print("&nbsp;<B>" + i + "</B>&nbsp;");
				}else{
				%>
					<a href="javascript:movePage('<%=i%>')">&nbsp;<%=i%>&nbsp;</a>&nbsp;
				<%
				}
			}
		%>
		 <%
			if (nowScreen == totalScreen) {
				if(n_page == lastPageNumber){
			%>
			<%	
				}else{%>
				<a href="javascript:movePage('<%=(n_page+1)%>')"></a>	
			<%	}
			}else{
			%>
				<a href="javascript:movePage('<%=(nowScreen * 10 + 1)%>')"></a>
			<%
			}
			%>
			<%if(n_page == lastPageNumber){%>
			<a href="javascript:alert('���̻� �������� �����ϴ�.');"><img src="../bbs/images/arr_right.gif" align="absmiddle" border="0"></a>
			<%}else{%>
			<a href="javascript:movePage('<%=lastPageNumber%>')"><img src="../bbs/images/arr_right.gif" align="absmiddle" border="0"></a>
			<%}%>
		 </td>
                </tr>
            </table>