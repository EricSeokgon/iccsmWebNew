package sp.util.sync;

import java.util.HashMap;
import java.util.StringTokenizer;

public class SyncUtil
{


	
	/**
	 * 진단기관(회계, 세무,..) 코드 가져오기
	 * @param code 협회코드
	 * @return 네트코드
	 */
	public static String getDigDiv( String code ) {
		if( code == null )
			return null;
		
		if( code.equals( "1" ))
			return "DIG001";
		else if( code.equals( "2" ))
			return "DIG002";
		else if( code.equals( "3" ))
			return "DIG003";
		else
			return null;
	}
	
	/**
	 * 이건 언제 쓰는건지?
	 * @param code
	 * @return
	 */
	public static String getSidoCode2( String code ) {
		HashMap<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("2001", "susu");
		codeMap.put("2002", "bsbs");
		codeMap.put("2007", "dgdg");
		codeMap.put("2005", "icic");
		codeMap.put("2009", "gjgj");
		codeMap.put("2011", "djdj");
		codeMap.put("2003", "usus");
		codeMap.put("2006", "gggg");
		codeMap.put("2014", "gwgw");
		codeMap.put("2015", "cbcb");
		codeMap.put("2012", "cncn");
		codeMap.put("2013", "jbjb");
		codeMap.put("2010", "jnjn");
		codeMap.put("2008", "gbgb");
		codeMap.put("2004", "gngn");
		codeMap.put("2016", "jjjj");
		
		codeMap.put("1001", "susu");
		codeMap.put("1002", "bsbs");
		codeMap.put("1003", "gbgb");
		codeMap.put("1004", "cbcb");
		codeMap.put("1005", "jnjn");
		codeMap.put("1006", "jbjb");
		codeMap.put("1007", "gwgw");
		codeMap.put("1008", "jjjj");
						
		codeMap.put("0", "susu");
		codeMap.put("22", "susu");
		codeMap.put("11", "bsbs");
		codeMap.put("33", "gbgb");
		codeMap.put("44", "cbcb");
		codeMap.put("55", "jnjn");
		codeMap.put("66", "jbjb");
		codeMap.put("77", "gwgw");
		codeMap.put("88", "jjjj");
		codeMap.put("99", "cncn");
						
		return codeMap.get( code );
	}
	
	public static String getSidoCode( String code ) {
		if( code == null )
			return null;
		
		HashMap<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("11", "susu");
		codeMap.put("21", "bsbs");
		codeMap.put("22", "dgdg");
		codeMap.put("23", "icic");
		codeMap.put("24", "gjgj");
		codeMap.put("25", "djdj");
		codeMap.put("26", "usus");
		codeMap.put("31", "gggg");
		codeMap.put("32", "gwgw");
		codeMap.put("33", "cbcb");
		codeMap.put("34", "cncn");
		codeMap.put("35", "jbjb");
		codeMap.put("36", "jnjn");
		codeMap.put("37", "gbgb");
		codeMap.put("38", "gngn");
		codeMap.put("39", "jjjj");
		codeMap.put("41", "gggg");
		
		
		return codeMap.get( code.trim() );
	}
	
	/**
	 * 폐업사유 코드 가져오기
	 * @param code
	 * @return
	 */
	public static String getCloDiv( String code ) {
		if( code == null || code.trim().length() == 0 ) 
			return null;
		
		if( code.indexOf( "취소" ) > -1 )
			return "CLO002";
		else
			return "CLO001";
	}
	
	
	/**
	 * 행정처분 요청자 코드 가져오기
	 * @param code
	 * @return
	 */
	public static String getPtmReq( String code ) {
		if( code == null || code.trim().length() == 0 ) 
			return null;
		/*
		REQ004	기타
		REQ001	정보통신공사협회
		REQ002	정보통신공제조합
		REQ003	지방자치단체
		*/
		if( code.endsWith( "시" ) || code.endsWith( "도" ) )
			return "REQ003";
		
		return "REQ004";

	}
	
	/**
	 * 행정처분 처분 코드 가져오기
	 * @param code 협회코드
	 * @return 네트코드
	 */
	public static String getDispoCD( String code ) {
		if( code == null || code.trim().length() == 0 ) 
			return null;
		
		if(code.equals("30")) return "M00001";
		if(code.equals("09"))  return "M00002";      
		if(code.equals("03"))  return "M00004";   
		if(code.equals("02"))  return "M00007";      
		if(code.equals("01"))  return "M00008";   
		if(code.equals("10"))  return "M00009";      
		if(code.equals("11"))  return "M00010";   
		if(code.equals("12"))  return "M00011";      
		if(code.equals("13"))  return "M00012";   
		if(code.equals("14"))  return "M00013";      
		if(code.equals("15"))  return "M00014";   
		if(code.equals("16"))  return "M00015";      
		if(code.equals("17"))  return "M00016";   
		if(code.equals("18"))  return "M00017";      
		if(code.equals("19"))  return "M00018";  
		if(code.equals("20"))  return "M00019"; 		
			
		
		return code;
	}
	
	
	/**
	 * 업무구분 코드 가져오기
	 * @param code 협회코드
	 * @return 네트코드
	 */
	public static String getChgCsCD( String code ) {
		if( code == null || code.trim().length() == 0 ) 
			return null;
		
		if( code.equals( "10" ) )//신규등록
			return  "R00001";
		if( code.equals( "11" ) )//등급변경
			return  "R00017";
		if( code.equals( "12" ) ) //업종변경
			return  "R00018";
		if( code.equals( "20" ) ) //재등록
			return  "R00016";
		if( code.equals( "21" ) ) //재등록
			return  "R00021";
		if( code.equals( "30" ) || code.equals( "31" ) ) //합병
			return  "R00006";
		if( code.equals( "40" ) || code.equals( "41" ) ) //분할합병
			return  "R00005";
		if( code.equals( "50" ) ) //법인전환
			return  "R00011";	
		if( code.equals( "60" ) ) //양도양수
			return  "R00004"; 
		if( code.equals( "70" ) ) //폐업
			return  "R00003";		
		if( code.equals( "99" ) ) //기준신고
			return  "R00002";
		
		return code;
	}	
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String[] initStringArray( String[] input ) {
		String defaultValue = "";
		for( int i = 0; i < input.length; i++ )
			input[i] = defaultValue;
		
		return input;
	}

	public static String removeBlank( String input ) {
		String result = null;
		
		if( input != null ) {
			result = input.trim().replaceAll( "\\s", "" );
		}
		
		return result;
	}
	
	
	public static String removeComma( String input ) {
		String result = null;
		
		if( input != null ) {
			result = input.replaceAll( "\'", "" );
		}
		
		return result;
	}
	
	public static String trim( String input ) {
		String result = null;
		
		if( input != null ) {
			result = input.trim();
		}
		
		return result;
	}
	
	


	 
}
