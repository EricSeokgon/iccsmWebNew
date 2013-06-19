<%@ include file = "./common.jsp" %>
<%
	try 
	{	
		if(conn != null)
		{
			StringBuffer sQuery = new StringBuffer();
			String sReturn = "";

			String sSIDO_CODE = request.getParameter("SIDO_CODE");
			String sSIGUNGU_CODE = request.getParameter("SIGUNGU_CODE");

			sQuery.append(" SELECT	RECV_NUM, ");
			sQuery.append("			SIDO_CODE, ");
			sQuery.append("			SIGUNGU_CODE, ");
			sQuery.append("			CIV_RECV_NUM, ");			
			sQuery.append("			APPLPER_NM, ");
			sQuery.append("			APPLPER_TELNUM, ");
			sQuery.append("			COI_WRT_NUM, ");
			sQuery.append("			OPE_NAME, ");			
			sQuery.append("			OPE_TELNUM, ");
			sQuery.append("			INSP_SPOT_ADDR, ");
			sQuery.append("			INSP_SPOT_DETAILADDR ");
			sQuery.append("	FROM	PT_UB_USEBEFORE ");
			sQuery.append("	WHERE	1 = 1 ");
			sQuery.append("	AND		SIDO_CODE = ? ");
			sQuery.append("	AND		SIGUNGU_CODE = ? ");
			sQuery.append("	AND		USEBEFINSP_DELINUM IS NULL ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1, sSIDO_CODE);
			pstmt.setString(2, sSIGUNGU_CODE);

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
					String sRECV_NUM = rs.getString("RECV_NUM");
					String sSIDO = rs.getString("SIDO_CODE");
					String sSIGUNGU = rs.getString("SIGUNGU_CODE");
					String sCIV_RECV_NUM = rs.getString("CIV_RECV_NUM");
					String sAPPLPER_NM = rs.getString("APPLPER_NM");

					String sAPPLPER_TELNUM = rs.getString("APPLPER_TELNUM");
					String sCOI_WRT_NUM = rs.getString("COI_WRT_NUM");
					String sOPE_NAME = rs.getString("OPE_NAME");
					String sOPE_TELNUM = rs.getString("OPE_TELNUM");
					String sINSP_SPOT_ADDR = rs.getString("INSP_SPOT_ADDR");

					String sINSP_SPOT_DETAILADDR = rs.getString("INSP_SPOT_DETAILADDR");

					sReturn = sReturn + sRECV_NUM + "|" + sSIDO + "|" + sSIGUNGU + "|" + sCIV_RECV_NUM + "|" + sAPPLPER_NM + "|" + sAPPLPER_TELNUM + "|" + sCOI_WRT_NUM + "|" + sOPE_NAME + "|" + sOPE_TELNUM + "|" + sINSP_SPOT_ADDR + "|" + sINSP_SPOT_DETAILADDR + "\n";
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
