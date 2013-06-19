<%@ include file = "./common.jsp" %>
<%
	try 
	{	
		if(conn != null)
		{
			StringBuffer sQuery = new StringBuffer();
			String sReturn = "";

			String sVALUE = request.getParameter("VALUE");
			String sCLASS = request.getParameter("CLASS");

			sQuery.append(" SELECT	TMP_WRT_NUM, ");
			sQuery.append("			COI_WRT_NUM, ");
			sQuery.append("			NAME, ");
			sQuery.append("			REP_NM_KOR, ");			
			sQuery.append("			ADDR_ADDR ");
			sQuery.append("	FROM	PT_R_COMPANY_MASTER ");
			sQuery.append("	WHERE	1 = 1 ");

			if(sCLASS.equalsIgnoreCase("NAME"))
				sQuery.append("	AND		NAME LIKE '%" + sVALUE + "%' ");
			else
				sQuery.append("	AND		COI_WRT_NUM = '" + sVALUE + "' ");
			sQuery.append("	AND		C_COM_DT IS NULL ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

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
					String sTMP_WRT_NUM = rs.getString("TMP_WRT_NUM");
					String sCOI_WRT_NUM = rs.getString("COI_WRT_NUM");
					String sNAME = rs.getString("NAME");
					String sREP_NM_KOR = rs.getString("REP_NM_KOR");
					String sADDR_TEL_NUM = rs.getString("ADDR_ADDR");

					sReturn = sReturn + sTMP_WRT_NUM + "|" + sCOI_WRT_NUM + "|" + sNAME + "|" + sREP_NM_KOR + "|" + sADDR_TEL_NUM + "\n";
				}
				out.print("START^" + sReturn + "^END");

				return;
			}
		}
		else
		{
			out.print("START^NULL DB^END");
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
