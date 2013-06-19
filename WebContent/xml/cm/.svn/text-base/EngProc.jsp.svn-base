<%@ include file = "./common.jsp" %>
<%
	PlatformRequest platformRequest = this.proc_input(request);  
	in_vl = platformRequest.getVariableList();
	in_dl = platformRequest.getDatasetList();
	
	String sTMP_WRT_NUM = in_vl.getValueAsString("sTMP_WRT_NUM");
	//String sTMP_WRT_NUM = request.getParameter("sTMP_WRT_NUM");
	
	
	try 
	{	
		if(conn!=null)
		{
			StringBuffer sQuery = new StringBuffer();
			StringBuffer sWhere = new StringBuffer();
	
	/*
			sQuery.append(" SELECT '0' AS CHECKER, AA.TMP_WRT_NUM, AA.SEQ, AA.ENGINEER_NM, AA.EMPL_YMD, AA.RET_YMD, AA.ENGINEER_SSN1, AA.ENGINEER_SSN2, DD.CARE_BOOK_ISSUE_NUM, DD.ENGINEER_GRADE, ");
	        sQuery.append(" 	   DD.CARE_BOOK_VAL_START_DT, DD.CARE_BOOK_VAL_END_DT, DD.TMP_GRADE, AA.ENGINEER_SSN1 || AA.ENGINEER_SSN2 AS TMPSSN ");
	        sQuery.append(" FROM PT_R_ENGINEER_CHANGE AA LEFT JOIN   ");
	        sQuery.append(" 	 (SELECT BB.NM_KOR, BB.CARE_BOOK_ISSUE_NUM, BB.ENGINEER_GRADE, ");
	        sQuery.append(" 	 BB.CARE_BOOK_VAL_START_DT, BB.CARE_BOOK_VAL_END_DT, ");
	        sQuery.append(" 	 PC.CODE_NAME AS TMP_GRADE, BB.ENGINEER_SSN1, BB.ENGINEER_SSN2 ");
	        sQuery.append(" 	 FROM PT_R_ENGINEER_MASTER BB ");
	        sQuery.append(" 	 LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'ENGCLASS') PC ");
	        sQuery.append(" 	 ON BB.ENGINEER_GRADE = PC.CODE) DD ");
	        sQuery.append(" 	 ON AA.ENGINEER_SSN1 = DD.ENGINEER_SSN1 AND AA.ENGINEER_SSN2 = DD.ENGINEER_SSN2 ");
	        sWhere.append(" WHERE 1 = 1 ");
	        sWhere.append(" AND AA.TMP_WRT_NUM = '" + sTMP_WRT_NUM + "'");
	        sWhere.append(" AND AA.RET_YMD IS NULL ");
			*/

			sQuery.append(" SELECT  '0' AS CHECKER, ");
        sQuery.append(" BB.NM_KOR AS ENGINEER_NM, ");
        sQuery.append(" AA.EMPL_YMD, ");
        sQuery.append(" AA.RET_YMD, ");
        sQuery.append(" AA.ENGINEER_SSN1, ");
        sQuery.append(" 'GRADE' AS TMP_GRADE, ");
        sQuery.append(" AA.ENGINEER_SSN2, ");
        sQuery.append(" CONCAT(AA.ENGINEER_SSN1, AA.ENGINEER_SSN2) AS TMPSSN, ");
        sQuery.append(" BB.CARE_BOOK_ISSUE_NUM, ");
        sQuery.append(" BB.ENGINEER_GRADE, ");
        sQuery.append(" BB.CARE_BOOK_VAL_START_DT, ");
        sQuery.append(" BB.CARE_BOOK_VAL_END_DT, ");
        sQuery.append(" AA.REMARK, ");
        sQuery.append(" AA.SEQ ");
sQuery.append(" FROM    PT_R_ENGINEER_CHANGE AA LEFT JOIN PT_R_ENGINEER_MASTER BB ");
        sQuery.append(" ON AA.ENGINEER_SSN1 = BB.ENGINEER_SSN1 AND AA.ENGINEER_SSN2 = BB.ENGINEER_SSN2 ");
sQuery.append(" WHERE   AA.TMP_WRT_NUM = '" + sTMP_WRT_NUM + "' ");
sQuery.append(" AND     AA.RET_YMD IS NULL");
out.print(sQuery.toString() + sWhere.toString());

			pstmt = conn.prepareStatement(sQuery.toString() + sWhere.toString());
			rs = pstmt.executeQuery();
			out_dl.addDataset("output", this.makeDataSet(rs,"output")); 	

			//this.setResultMessage(0, "OK",out_vl);
		}
	} 
	catch(Exception ex) 
	{ 
        this.setResultMessage(-1, ex.getMessage(),out_vl);
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
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}
	proc_output(response,out,out_vl,out_dl);
    
%>