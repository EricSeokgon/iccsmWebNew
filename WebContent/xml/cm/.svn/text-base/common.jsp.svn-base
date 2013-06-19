<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java"%>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import="com.tobesoft.platform.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	String Insert_Sql = null;   // insert sql문으로 사용할 변수
	String Update_Sql = null;   // update sql문으로 사용할 변수
	String Delete_Sql = null;   // delete sql문으로 사용할 변수

	VariableList in_vl = new VariableList();     //input variable list
	DatasetList  in_dl = new DatasetList();     //input dataset list

	VariableList out_vl = new VariableList();    // output variable list
	DatasetList  out_dl = new DatasetList();    // output dataset list

	Connection conn = null; //Connection 객체
	
	//sql에서 사용할 statement를 선언
	PreparedStatement pstmt= null;
	
	// sql결과를 받을 resultset 선언
	ResultSet rs = null; 
	int rvalue=-1;
	
	String db_driver="oracle.jdbc.driver.OracleDriver"; 
	String db_url="jdbc:oracle:thin:@home.pktcorp.com:1521:orcl";
	String db_user="iccs"; 
	String db_password="iccs1441$"; 

	try
	{ 
		Class.forName(db_driver); 
		try
		{ 
			conn = DriverManager.getConnection(db_url,db_user,db_password); 
		//	System.out.println("연결성공"); 
		}catch(Exception e){ 
			System.out.println("DB에 연결할 수 없습니다." + e.toString()); 
			conn = null;
			this.setResultMessage(-1, "DB에 연결할 수 없습니다.",out_vl);
		} 
	}catch(ClassNotFoundException e){ 
		System.out.println("JDBC 드라이버를 찾을 수 없습니다." + e); 
		conn = null;
		this.setResultMessage(-2, "JDBC 드라이버를 찾을 수 없습니다.",out_vl);
	} 
%>
<%!
	PlatformData in_data = null;
	
	public String default_charset = "utf-8";   //character set
	public int default_encode_method = PlatformRequest.XML;
	
	/**********************************
	 * output variable에 message를 지정한다.
	 *
	 **********************************/
	public void setResultMessage(int code, String msg,VariableList out_vl) 
	{ 
		if (out_vl == null)
		    out_vl = new VariableList();
		
		out_vl.addVariable("ErrorCode", new Variant(code));
		out_vl.addVariable("ErrorMsg", new Variant(msg));
	}

	/*********************************************************
	 * request로 들어온 내용을 parsing하여
	 * input variable list, input dataset list에 저장한다.
	 *********************************************************/
	public PlatformRequest proc_input(HttpServletRequest request) throws ServletException, IOException 
	{
		PlatformRequest platformRequest = new PlatformRequest(request, default_charset);
		
		platformRequest.receiveData();
	
		in_data = platformRequest.getPlatformData();
		
	//System.out.println(in_data.toString());
		this.default_charset = platformRequest.getCharset();
		
		return platformRequest;
	}
	
	/*********************************************************
	 * response로 작성된 output variable list,output dataset을
	 * 보낸다.
	 *********************************************************/
	public void proc_output(HttpServletResponse response,JspWriter out,VariableList out_vl,DatasetList out_dl)  throws ServletException, IOException 
	{
		PlatformResponse platformResponse = new PlatformResponse(response, default_encode_method, default_charset);
	
		if (out_vl == null)
		    out_vl = new VariableList();
	
		if (out_dl == null)
		    out_dl = new DatasetList();
	
		out.clearBuffer();  // 가비지값들이 존재할수 있어서 out을 clear해준다.
		platformResponse.sendData(out_vl, out_dl);
	
	}
	
	/*********************************************************
	 * resultset으로 부터 dataset을 생성한다.
	 * 컬럼순 정렬, 조회순서에 관계없이 컬럼을 알파벳순 정렬
	 *********************************************************/
	public Dataset makeDataSet(ResultSet rs,String strDataSet)  throws ServletException, Exception
	{
		Dataset ds = new Dataset(strDataSet,default_charset);
		ds.setUpdate(false);
	
		ResultSetMetaData rsmd = rs.getMetaData();     // select 한 정보
		int numberOfColumns = rsmd.getColumnCount();   // select한 컬럼수
	
		int    ColSize;

		for ( int j = 1 ; j <= numberOfColumns ; j++ )
		{
			String Colnm = rsmd.getColumnName(j);
			int    ColType = rsmd.getColumnType(j);
			ColSize = rsmd.getColumnDisplaySize(j);
	
			// select한 컬럼의 type에 맞게 데이타셋 컬럼을 생성
			if ( ColType == Types.NUMERIC || ColType == Types.DOUBLE )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_DECIMAL,ColSize);
			}
			else if ( ColType == Types.VARCHAR )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_STRING,ColSize);
			}
			else if ( ColType == Types.DATE )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_DATE,ColSize);
			}
			else if ( ColType == Types.INTEGER )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_INT,ColSize);
			}
			else
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_STRING,ColSize);
			}
		}
	
		int Row = 0;
		int i;
	
		while(rs.next())
		{
			Row = ds.appendRow();   // 데이타셋 row 추가
			for ( i = 0 ; i < numberOfColumns ; i++ )
			{
				if ( ds.getColumnInfo(i).getColumnType() == ColumnInfo.COLTYPE_DATE )
				{
					ds.setColumn(Row,ds.getColumnID(i),new Variant(rs.getDate(ds.getColumnID(i))));  // 데이타저장
				}        
				else
				{
					ds.setColumn(Row,ds.getColumnID(i),new Variant(rs.getString(ds.getColumnID(i))));  // 데이타저장
				}        
			}	
		}
		return ds;
	}
	/*********************************************************
	 * resultset으로 부터 dataset을 생성한다.
	 * 컬럼순 정렬하지 않음 조회 순서대로 데이터셋 작성
	 *********************************************************/
	public Dataset makeDataSetNS(ResultSet rs,String strDataSet)  throws ServletException, Exception
	{
		Dataset ds = new Dataset(strDataSet,default_charset,false,false);
		ds.setUpdate(false);
	
		ResultSetMetaData rsmd = rs.getMetaData();     // select 한 정보
		int numberOfColumns = rsmd.getColumnCount();   // select한 컬럼수
	
		int    ColSize;

		for ( int j = 1 ; j <= numberOfColumns ; j++ )
		{
			String Colnm = rsmd.getColumnName(j);
			int    ColType = rsmd.getColumnType(j);
			ColSize = rsmd.getColumnDisplaySize(j);
	
			// select한 컬럼의 type에 맞게 데이타셋 컬럼을 생성
			if ( ColType == Types.NUMERIC || ColType == Types.DOUBLE )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_DECIMAL,ColSize);
			}
			else if ( ColType == Types.VARCHAR )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_STRING,ColSize);
			}
			else if ( ColType == Types.DATE )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_DATE,ColSize);
			}
			else if ( ColType == Types.INTEGER )
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_INT,ColSize);
			}
			else
			{
				ds.addColumn(Colnm, ColumnInfo.COLTYPE_STRING,ColSize);
			}
		}
	
		int Row = 0;
		int i;
	
		while(rs.next())
		{
			Row = ds.appendRow();   // 데이타셋 row 추가
			for ( i = 0 ; i < numberOfColumns ; i++ )
			{
				if ( ds.getColumnInfo(i).getColumnType() == ColumnInfo.COLTYPE_DATE )
				{
					ds.setColumn(Row,ds.getColumnID(i),new Variant(rs.getDate(ds.getColumnID(i))));  // 데이타저장
				}        
				else
				{
					ds.setColumn(Row,ds.getColumnID(i),new Variant(rs.getString(ds.getColumnID(i))));  // 데이타저장
				}        
			}	
		}
		return ds;
	}
	
	/*******************************************************************
	 * Dataset을 생성
	 * ex) makeDataSet("output2");
	 *******************************************************************/
	public Dataset makeDataSet(String strDataSet)  throws ServletException, Exception
	{
		return new Dataset(strDataSet,default_charset);
	}
	
	/*********************************************************
	 * null인경우 empty string을 return
	 *********************************************************/
	public String checkNullString(String str)
	{
		if ( str == null || str.equals("") ) str = "null";
		else str = "'" + replaceAll(str,"'","''") + "'";
		return str;
	}
	/*********************************************************
	 * null인경우 empty string을 return
	 * LIKE '%?%' 를 사용할 경우,
	 *********************************************************/
	public String checkNullStringLIKE(String str)
	{
		if ( str == null || str.equals("") ) str = "null";
		else str = "'%" + replaceAll(str,"'","''") + "%'";
		return str;
	}
	/*********************************************************
	 * null인경우 blank string을 return
	 *********************************************************/
	public String nullToBlank(String str) {
	    if(str == null) str = "";
	    return str;
	}
	
	/*********************************************************
	 * null인경우 zero string을 return
	 *********************************************************/
	public String nullToZero(String str) {
	    if(str == null) str = "0";
	    return str;
	}
	
	/*********************************************************
	 * String을 float 으로 변경하여 return
	 *********************************************************/
	public float stringToFloat(String str) {
	    float ft;
	
	    if(str == null || str.equals("")) ft = 0;
	    else ft = Float.parseFloat(str);
	
	    return ft;
	}
	
	/*********************************************************
	 * String을 입력한 소숫점 이하 자릿수만큼만 float 으로 변경하여 return
	 *********************************************************/
	public float stringToFloat(String str, int dp) {
	
	    float ft;
	
	    if(str == null || str.equals("")) {
	        ft = 0;
	    } else {
	        if(str.indexOf('.') > 0) {
	            String strInt = str.substring(0, str.indexOf('.'));
	            String strDp  = str.substring(str.indexOf('.') + 1, str.length());
	
	            if(strDp.length() > dp) {
	                strDp = strDp.substring(0, dp);
	            } else {
	                strDp = strDp.substring(0, strDp.length());
	            }
	
	            str = strInt + "." + strDp;
	        }
	
	        ft = Float.parseFloat(str);
	    }
	
	    return ft;
	}
	
	public static String EucToUni(String s)
	{
	  try{
	    if ( s == null )  return null;
	    return new String(s.getBytes("8859_1"),"EUC-KR");
	  }
	  catch(Exception e){
	    return s;
	  }
	}
	
	public static String UniToEuc(String s)
	{
	  try{
	
	    if ( s == null )  return null;
	    return new String(s.getBytes("EUC-KR"),"8859_1");
	  }
	  catch(Exception e){
	    return s;
	  }
	}
	
	public String replaceAll(String str, String pattern, String replace) {
	    int e = 0, s = 0;
	    StringBuffer result = new StringBuffer();
	
	    while ((e = str.indexOf(pattern, s)) >= 0) {
	      result.append(str.substring(s, e));
	      result.append(replace);
	      s = e+pattern.length();
	    }
	    result.append(str.substring(s));
	
	    return result.toString();
	}
	
	/**************************************************************************
	 * 현재 날짜/시간을 구해오는 함수
	 **************************************************************************/
	public int getTime(int section) {
	    Calendar cal = Calendar.getInstance();
	    return cal.get(section);
	}
	
	public String getYear() {
	    return String.valueOf(getTime(Calendar.YEAR));
	}
	
	public String getMonth() {
	    return String.valueOf(getTime(Calendar.MONTH));
	}
	
	public String getDay() {
	    return String.valueOf(getTime(Calendar.DAY_OF_MONTH));
	}
	
	public String getHour() {
	    return String.valueOf(getTime(Calendar.HOUR_OF_DAY));
	}
	
	public String getMinute() {
	    return String.valueOf(getTime(Calendar.MINUTE));
	}
	
	public String getSecond() {
	    return String.valueOf(getTime(Calendar.SECOND));
	}
	/**************************************************************************/
%>
