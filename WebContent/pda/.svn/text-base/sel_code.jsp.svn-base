<%@ include file = "./common.jsp" %>
<%
	try 
	{	
		if(conn != null)
		{
			StringBuffer sQuery = new StringBuffer();
			String sReturn = "";

			String sOFFI_ID = request.getParameter("OFFI_ID");
			String sPASS = request.getParameter("PASS");

			sQuery.append(" SELECT	SIDO_CODE, ");
			sQuery.append("			SIGUNGU_CODE, ");
			sQuery.append("			NM, ");
			sQuery.append("			GROUP_CODE, ");			
			sQuery.append("			PASS ");
			sQuery.append("	FROM	PT_MI_USER ");
			sQuery.append("	WHERE	1 = 1 ");
			sQuery.append("	AND		OFFI_ID = ? ");
			sQuery.append("	AND		PASS = ? ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1, sOFFI_ID);
			pstmt.setString(2, sPASS);

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

				rs.first();

				String sSido = rs.getString("SIDO_CODE");
				String sSigungu = rs.getString("SIGUNGU_CODE");
				String sNM = rs.getString("NM");
				String sGroup = rs.getString("GROUP_CODE");
				String sPass = rs.getString("PASS");

				sReturn = sSido + "|" + sSigungu + "|" + sNM + "|" + sGroup + "|" + sPass;
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
