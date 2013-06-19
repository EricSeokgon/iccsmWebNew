<%@ include file = "./common.jsp" %>
<%
	try 
	{	
		if(conn != null)
		{
			ResultSet rMaster = null;

			StringBuffer sQuery = new StringBuffer();
			String sReturn = "";

			String sSSN = request.getParameter("SSN");

			sQuery.append(" SELECT	EM.CARE_BOOK_ISSUE_NUM, "); 
			sQuery.append("			EM.ENGINEER_SSN1 || EM.ENGINEER_SSN2 AS TMPSSN, "); 
    		sQuery.append("			EM.NM_KOR, ES.NAME AS CORP_NAME ");
        	sQuery.append(" FROM	PT_R_ENGINEER_MASTER EM INNER JOIN ");
        	sQuery.append(" 		( ");
        	sQuery.append(" 		SELECT IV.* FROM (SELECT AA.*, DECODE(AA.RET_YMD, NULL, BB.NAME, NULL) AS NAME  ");
        	sQuery.append(" 		FROM PT_R_ENGINEER_CHANGE AA LEFT JOIN PT_R_COMPANY_MASTER BB ");
        	sQuery.append(" 		ON AA.TMP_WRT_NUM = BB.TMP_WRT_NUM ");
        	sQuery.append(" 		WHERE 1 = 1 ");
        	sQuery.append(" 		AND AA.ENGINEER_SSN1 || AA.ENGINEER_SSN2 = '" + sSSN + "' ");
        	sQuery.append(" 		ORDER BY AA.EMPL_YMD DESC )IV WHERE 1 = 1 AND ROWNUM = 1 ");
        	sQuery.append(" 	) ES ON ES.ENGINEER_SSN1 = EM.ENGINEER_SSN1 AND ES.ENGINEER_SSN2 = EM.ENGINEER_SSN2 ");
        	sQuery.append(" 	LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'ENGCLASS') PC  ");
        	sQuery.append(" 	ON EM.ENGINEER_GRADE = PC.CODE  ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			rMaster = pstmt.executeQuery();

			rs = pstmt.executeQuery();

			if(rs == null)
			{
				out.print("START^NOK^END");
			}
			else
			{
				
				rs.last();  
				int nCnt = rs.getRow(); 
				if (nCnt == 0)
				{
					out.print("START^NOK^END");
					return;
				}

				rs.beforeFirst();
				
				while(rs.next())
				{
					String sCARE_BOOK_ISSUE_NUM = rs.getString("CARE_BOOK_ISSUE_NUM");
					String sTMPSSN = rs.getString("TMPSSN");
					String sNM_KOR = rs.getString("NM_KOR");
					String sCORP_NAME = rs.getString("CORP_NAME");

					sReturn = sReturn + sCARE_BOOK_ISSUE_NUM + "|" + sTMPSSN + "|" + sNM_KOR + "|" + sCORP_NAME + "\n";
				}
				out.print("START^" + sReturn + "^END");

				return;
			}
		}
		else
		{
			out.print("START^NULL DBR^END");
		}
	} 
	catch(Exception ex) 
	{ 
		out.print(ex.toString());
	} 
	finally 
	{
		if(rs != null) 
		{
			try 
			{
				rs.close();
			}catch(Exception e) {}
		}
		if(pstmt != null) 
		{
			try 
			{
				pstmt.close();
			}catch(Exception e) {}
		}
		if(conn != null) 
		{
			try 
			{
				conn.close();
			}catch(Exception e) {}
		}
	}
    
%>
