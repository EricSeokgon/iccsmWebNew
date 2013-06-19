<%@ include file = "./common.jsp" %>
<%
	try 
	{	
		if(conn != null)
		{
			StringBuffer sQuery = new StringBuffer();
			String sReturn = "";

			String sVALUE = request.getParameter("VALUE");

			sQuery.append(" SELECT	TMP_WRT_NUM, ");
			sQuery.append("			COI_WRT_NUM, ");
			sQuery.append("			NAME, ");
			sQuery.append("			REP_NM_KOR, ");			
			sQuery.append("			ADDR_ADDR, ");
			sQuery.append("			COMPANY_DIAG_BAS_DT, ");
			sQuery.append("			REA_CAP, ");
			sQuery.append("			TUP_AOM, ");			
			sQuery.append("			OFFICE_AREA ");
			sQuery.append("	FROM	PT_R_COMPANY_MASTER ");
			sQuery.append("	WHERE	1 = 1 ");
			sQuery.append("	AND		TMP_WRT_NUM = ? ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1, sVALUE);

			rs = pstmt.executeQuery();

			if(rs == null)
			{
				out.print("START^NOK^END");
				return;
			}

			rs.next();

			sReturn = sReturn + rs.getString("TMP_WRT_NUM") + "|" + rs.getString("COI_WRT_NUM") + "|" + rs.getString("NAME") + "|" + rs.getString("REP_NM_KOR") + "|" + rs.getString("ADDR_ADDR") + "|" + rs.getString("COMPANY_DIAG_BAS_DT") + "|" + rs.getString("REA_CAP") + "|" + rs.getString("TUP_AOM") + "|" + rs.getString("OFFICE_AREA") + "\\";

			sQuery.delete(0, sQuery.length());

			//Engineer 
			sQuery.append(" SELECT AA.EMPL_YMD, DD.NM_KOR, DD.CARE_BOOK_ISSUE_NUM, ");
	        sQuery.append(" 	   DD.TMP_GRADE ");
	        sQuery.append(" FROM PT_R_ENGINEER_CHANGE AA LEFT JOIN   ");
	        sQuery.append(" 	 (SELECT BB.NM_KOR, BB.CARE_BOOK_ISSUE_NUM, BB.ENGINEER_GRADE, ");
	        sQuery.append(" 	 PC.CODE_NAME AS TMP_GRADE, BB.ENGINEER_SSN1, BB.ENGINEER_SSN2 ");
	        sQuery.append(" 	 FROM PT_R_ENGINEER_MASTER BB ");
	        sQuery.append(" 	 LEFT JOIN ");
			sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'ENGCLASS') PC ");
	        sQuery.append(" 	 ON BB.ENGINEER_GRADE = PC.CODE) DD ");
	        sQuery.append(" 	 ON AA.ENGINEER_SSN1 = DD.ENGINEER_SSN1  ");
			sQuery.append("		 AND AA.ENGINEER_SSN2 = DD.ENGINEER_SSN2 ");
	        sQuery.append(" WHERE 1 = 1 ");
	        sQuery.append(" AND AA.TMP_WRT_NUM = ? ");
	        sQuery.append(" AND AA.RET_YMD IS NULL ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1, sVALUE);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				sReturn += rs.getString("EMPL_YMD") + "|" + rs.getString("NM_KOR") + "|" + rs.getString("CARE_BOOK_ISSUE_NUM") + "|" + rs.getString("TMP_GRADE") + "\n";
			}

			sReturn += "\\";

			sQuery.delete(0, sQuery.length());

			//Work Result
			sQuery.append(" SELECT * FROM PT_R_WORK_RESULTS ");
	        sQuery.append(" WHERE 1 = 1 ");
	        sQuery.append(" AND TMP_WRT_NUM = ? ");
	        sQuery.append(" ORDER BY YEAR ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1, sVALUE);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				sReturn += rs.getString("YEAR") + "|" + rs.getString("WORK_ROM") + "\n";
			}

			sReturn += "\\";

			sQuery.delete(0, sQuery.length());

			//WORK CAPABILITY
			sQuery.append(" SELECT * FROM PT_R_WORK_CAPABILITY ");
	        sQuery.append(" WHERE 1 = 1 ");
	        sQuery.append(" AND TMP_WRT_NUM = ? ");
	        sQuery.append(" ORDER BY ASSE_DT ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1, sVALUE);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				sReturn += rs.getString("ASSE_DT") + "|" + rs.getString("ASSE_AOM") + "|" + rs.getString("APPL_TERM_START_DT") + "|" + rs.getString("APPL_TERM_END_DT") + "\n";
			}

			sReturn += "\\";

			sQuery.delete(0, sQuery.length());

			//M MASTER
			sQuery.append(" SELECT  BB.CODE_NAME AS TMPDISPO_CONT, ");
			sQuery.append("			AA.DISPO_CAUSE, ");
			sQuery.append("			AA.DISPO_DT ");
			sQuery.append(" FROM    PT_M_MASTER AA LEFT JOIN ");
			sQuery.append(" (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'PTMPRO') BB ");
			sQuery.append(" ON AA.DISPO_CONT = BB.CODE ");
	        sQuery.append(" WHERE 1 = 1 ");
	        sQuery.append(" AND TMP_WRT_NUM = ? ");
	        sQuery.append(" ORDER BY AA.DISPO_DT ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1, sVALUE);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				sReturn += rs.getString("TMPDISPO_CONT") + "|" + rs.getString("DISPO_CAUSE") + "|" + rs.getString("DISPO_DT") + "\n";
			}

			sReturn += "\\";

			sQuery.delete(0, sQuery.length());

			//CHANGE HISTORY
			sQuery.append(" SELECT  CASE PT_RBCH.STA_CHG_CLASS_CODE ");
			sQuery.append("             WHEN 'R00007' THEN PT_RBCH.ADDR_ADDR  ");
			sQuery.append("             WHEN 'R00008' THEN PT_RBCH.REA_CAP  ");
			sQuery.append("             WHEN 'R00009' THEN PT_RBCH.REP_NM_KOR  ");
			sQuery.append("             WHEN 'R00002' THEN '차기신고일자(' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy-mm-dd') || ')'   ");
			sQuery.append("         END AS VALUE, PT_CC.CODE_NAME, PT_RBCH.CHG_DT ");
			sQuery.append(" FROM PT_R_BASIC_CHANGE_HISTORY PT_RBCH  ");
			sQuery.append(" INNER JOIN(SELECT * FROM PT_COM_CODE WHERE P_CODE = 'REGDIV') PT_CC ");
			sQuery.append(" ON PT_RBCH.STA_CHG_CLASS_CODE = PT_CC.CODE ");
			sQuery.append(" WHERE    1=1 ");
			sQuery.append(" AND PT_RBCH.TMP_WRT_NUM = ? ");
			sQuery.append(" ORDER BY PT_RBCH.CHG_DT DESC ");

			pstmt = conn.prepareStatement(sQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1, sVALUE);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				sReturn += rs.getString("VALUE") + "|" + rs.getString("CODE_NAME") + "|" + rs.getString("CHG_DT") + "\n";
			}

			out.print("START^" + sReturn + "^END");

			return;
			
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
