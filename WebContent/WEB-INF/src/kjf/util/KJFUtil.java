package kjf.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

/**
 * <p>system		: KJF</p>
 * <p>Description	: �⺻���� ��ƿ�Լ��� �����Ͽ� ����. </p>
 * @author ����
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFUtil {


    /**
     * ReportEntity�� �ʱ� ���� null�϶� ó��
     * @param ReportEntity o
     * @return  ReportEntity    
     */	
	 public static ReportEntity REntPrint(ReportEntity o){
		 if (o==null){
			 return new ReportEntity() ;
		 }

		 return o;
	 }

	 /**
	  * null�� ""�� ��ȯ
	  * @param o Object
	  * @return String
	  */
	 public static String print(Object o){
		 if (o==null){
			 return "";
		 }
		 return o.toString();
	 }

	 /**
	  * null�� Ư�����ڷ� �ٲپ ��Ÿ����.
	  * @param o   Object
	  * @param rep String
	  * @return String
	  */
	 public  static String print(Object o, String rep){
			 if (isEmpty(o)){
				 return rep;
			 }
			 return o.toString();
	 }


	 /**
	  * Object�� NULL������ Ȯ���Ѵ�.
	  * @param obj Object
	  * @return boolean
	  */
	 public static boolean isEmpty(Object obj){
	     if(obj ==null)
	         return true;
	     if( obj instanceof String && "".equals(((String)obj).trim())  )
	         return true;
	     return false;
	 }

	 /**
	  * ����(�ݾ�)�� ���ڿ��� ��ȯ�Ͽ� ��ȯ(��, ���ڴ� long type)
	  * @param n
	  * @return
	  */
     public  static String money(long n){
          DecimalFormat df = new DecimalFormat("#,##0");

          return df.format(n);
     }

    /**
     * String ���信 �°� ��ȯ
     * @param numStr
     * @return
     */
 	public static String setNumFormat(String numStr) {

         int li_strLen;
         String ls_result;

         li_strLen = numStr.length();

 		switch(li_strLen){
 			// �����ȣ
 			case 6:
                 ls_result = numStr.substring(0,3) + "-" + numStr.substring(3,6);
 				break;
 			// ����ڵ�Ϲ�ȣ
 			case 10:
 				ls_result = numStr.substring(0,3) + "-" + numStr.substring(3,5) + "-" + numStr.substring(5,10);
 				break;
 			// �ֹε�Ϲ�ȣ
 			case 13:
 				ls_result = numStr.substring(0,6) + "-" + numStr.substring(6,13);
 				break;
 			default:
 				ls_result = numStr;
 				break;
 		}

 		return ls_result;
 	}


 	/**
 	 * ������ȯ : ���ڿ� �Է��� ������ ��ȯ�Ͽ� ��ȯ
 	 * @param str String
 	 * @return int
 	 */
	public  static int str2int(String str)  {
		int li = 0 ;

    	try {
    		if (str == null || str.equals("")) return 0;
    		li = Integer.parseInt(str);
    
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    
    	return li ;
	}


	/**
	 * long ��ȯ : ���ڿ� �Է��� long���� ��ȯ�Ͽ� ��ȯ
	 * @param str String
	 * @return long
	 */
	public static long str2long(String str)  {
		long li = 0 ;

    	try {
    		if (str == null || str.equals("")) return 0;
    		li = Long.parseLong(str);
    
    	} catch (Exception e) {
    		System.out.println(e);
    	}

		return li;
	}

	/**
	 * array ��ȯ : ���ڿ� �Է��� �����ڷ� �����Ͽ� �迭�� ��ȯ�Ͽ� ��ȯ
	 * @param str   String
	 * @param delim String
	 * @return String[]
	 */
	public static String[] str2strs(String str, String delim) {
        String[] strs= null;
        
        if(!isEmpty(str)){ //�迭�� ��´�.
            StringTokenizer st= new StringTokenizer(str,delim);
            int size= st.countTokens();
            int idx= 0;
            strs= new String[size];
            while(st.hasMoreTokens()){
                strs[idx]= st.nextToken();                
                idx++;                
            }
        }

        return strs;
	}

	/**
	 * Key���� boolean���� �����Ѵ�.
     * true/false�� ��ҹ��ڴ� ������� �ʴ´�.
	 * @param srt String
	 * @return boolean
	 */
    public  static boolean str2Boolean(String srt) {

       if("TRUE".equalsIgnoreCase(srt) == true)
           return true;
       else
           return false;
   }

    /**
     * "0"�� �������� ó��
     * @param srt
     * @return
     */
    public  static String str2NotZero(String srt) {

       if(srt.equals("0") )
           return "";
       else
           return srt;
   }

    /**
     * Key�� Y,N �� boolean���� �����Ѵ�.
     * Y,N �� ��ҹ��ڴ� ������� �ʴ´�.
     * @param strYN String
     * @return boolean
     */
    public static boolean yn2Boolean(String strYN) {

       if("Y".equalsIgnoreCase(strYN) == true)
           return true;
       else
           return false;
   }
    
    /**
     * ���� ���ڵ� ��ȯ(8859_1==>utf-8)
     * @param s String
     * @return String
     */
    public static String eng2utf8(String s) {
        if(s == null) return s;
        try{
            return new String(s.getBytes("8859_1"), "utf-8");
        }catch(Exception e){
        }
        return s;
    }

    /**
     * ���� ���ڵ� ��ȯ(8859_1==>ksc5601)
     * @param s String
     * @return String
     */
	public static String eng2kor(String s) {
        if(s == null) return s;
        try{
            return new String(s.getBytes("8859_1"), "ksc5601");
        }catch(Exception e){
        }
        return s;
    }

    /**
     * ���� ���ڵ� ��ȯ(ksc5601==>utf-8)
     * @param s String
     * @return String
     */
	public static String kor2utf8(String s) {
        if(s == null) return s;
        try{
            return new String(s.getBytes("ksc5601"), "utf-8");
        }catch(Exception e){
        }
        return s;
    }

    /**
     * ���� ���ڵ� ��ȯ(utf-8==>ksc5601)
     * @param s String
     * @return String
     */
	public static String utf82kor(String s) {
        if(s == null) return s;
        try{
            return new String(s.getBytes("utf-8"), "ksc5601");
        }catch(Exception e){
        }
        return s;
    }

    /**
     * ���� ���ڵ� ��ȯ(utf-8==>8859_1)
     * @param s String
     * @return String
     */
	public static String kor2eng(String s) {
        if(s == null) return s;
        try{
            return new String(s.getBytes("ksc5601"), "8859_1");
        }catch(Exception e){
        }
        return s;
    }

    /**
     * html ���·� �ҽ� ��ȯ
     * @param s String
     * @return String
     */
	public static String java2html(String s) {
		if ( s == null ) return null;

		StringBuffer buf = new StringBuffer();
		char[] c = s.toCharArray();
		int len = c.length;
		for ( int i=0; i < len; i++) {
			if      ( c[i] == '&' ) buf.append("&amp;");
			else if ( c[i] == '<' ) buf.append("&lt;");
			else if ( c[i] == '>' ) buf.append("&gt;");
			else if ( c[i] == '"' ) buf.append("&quot;");
			else if ( c[i] == '\'') buf.append("&#039;");
			else if ( c[i] == '\n') buf.append("<br>");
			else buf.append(c[i]);
		}
		
		return buf.toString();
	}

	/**
	 * request�� ���� ��� parameter �̸�(key)�� �ش� ��(value)�� ���
     * name1 = vaue1
     * name2 = vaue2
     * ���·� ������ش�
	 * @param request
	 * @return
	 */
	public static String reportParameters(HttpServletRequest request){

		StringBuffer l_tStringBuffer = null;
		Enumeration names = null;

		l_tStringBuffer = new StringBuffer();
		names = request.getParameterNames();

        l_tStringBuffer.append("\n");

		if(names.hasMoreElements()) {
			while(names.hasMoreElements()) {
				String name = (String)names.nextElement();
				String lss_values[] = request.getParameterValues(name);
				int i = 0;
				while(i < lss_values.length)
				{
					l_tStringBuffer.append("    ");
					l_tStringBuffer.append(name);
					l_tStringBuffer.append(" = ");
					l_tStringBuffer.append(lss_values[i]);
					l_tStringBuffer.append("\n");
					i++;
				}
			}
		}

		return l_tStringBuffer.toString();
    }


	/**
     * ������ �������� �迭�� ��ȯ
     * @param String[] firstArray, String[] secondArray
     * @return   String[]
     * @throws Exception
     */
    public static String[] getDifferenceOfSets(String[] firstArray, String[] secondArray)  {

        Vector temp=new Vector();
        for (int i=0; i < firstArray.length ; i++){
            boolean isSame=false;
            if (secondArray !=null ){
                for (int j=0;j< secondArray.length; j++){
                    if (firstArray[i].equals(secondArray[j])){
                        isSame=true;
                        break ;
                    }
                }
            }

            if (!isSame){
                temp.add(firstArray[i]);
            }
        }//end for (int i=0; i < firstArray.length ; i++)
        String[] result= (String[])temp.toArray(new String[0]);
        return result;

    }

    /**
	 * 1���� �迭�� �Ѿ�� ���� KJFSelect ��� ���ͷ� ��ȯ
	 * @param selItem String[]
	 * @return Vector
	 */
	public static Vector makeSelect (String[] selItem){

		Vector vec = new Vector();

		for(int i=0; i<selItem.length; i++){
			KJFSelect sel			= new KJFSelect();

			sel.setCode(Integer.toString(i));
			sel.setCode_nm(selItem[i]);

			vec.add(sel);
		}
		return vec;
	}

    /**
     * �Խ��� ī�װ� ���� ����Ʈ�� ī�װ� �˻��� ���<br>
     * 1���� �迭�� �Ѿ�� ���� KJFSelect ��� ���ͷ� ��ȯ
     * @param selItem String[]
     * @return Vector
     */
    public static Vector makeCategorySelect (String[] selItem) {

        Vector vec = new Vector();

        KJFSelect sel = new KJFSelect();

        sel.setCode("");
        sel.setCode_nm("��ü");
        vec.add(sel);

        for(int i = 0; i < selItem.length; i++) {
            sel = new KJFSelect();
            sel.setCode(selItem[i]);
            sel.setCode_nm(selItem[i]);

            vec.add(sel);
        }

        return vec;
    }


    /**
     * �Խ��� ī�װ� ���� ��� ������ ���� ī�װ�<br>
     * 1���� �迭�� �Ѿ�� ���� KJFSelect ��� ���ͷ� ��ȯ
     *
     * @param selItem String[]
     * @return Vector
     */
    public static Vector makeCategory (String[] selItem) {

        Vector vec = new Vector();

        for(int i = 0; i < selItem.length; i++) {
            KJFSelect sel = new KJFSelect();

            sel.setCode(selItem[i]);
            sel.setCode_nm(selItem[i]);

            vec.add(sel);
        }

        return vec;
    }


	/**
	 * (�ڵ�,��) ������
	 * 2���� �迭�� �Ѿ�� ���� KJFSelect ��� ���ͷ� ��ȯ
	 * @param selItem String[][]
	 * @return Vector
	 */
	public static Vector makeSelect (String[][] selItem){

		Vector vec = new Vector();

		for(int i=0; i<selItem.length; i++){
			KJFSelect sel			= new KJFSelect();

			sel.setCode(selItem[i][0]);
			sel.setCode_nm(selItem[i][1]);

			vec.add(sel);
		}
		return vec;
	}

	/**
	 * ����¡ ���μ�
	 * @return Vector
	 */
    public static Vector getSelPageLine(){
    	String[][] selType = {{"5","5 Line"},{"10","10 Line"},{"20","20 Line"},{"30","30 Line"},{"50","50 Line"},{"100","100 Line"}}; // �??????? ??????

        return makeSelect(selType);
    }

    /**
     * ����¡ ���μ�
     * @return Vector
     */
    public static Vector getSelCafePageLine(){
        String[][] selType = {{"6","6 Line"},{"15","15 Line"},{"21","21 Line"},{"30","30 Line"},{"60","60 Line"},{"90","90 Line"}}; // �??????? ??????

        return makeSelect(selType);
    }

    /**
     * �߱�(NEW) �Ⱓ
     * @return Vector
     */
    public static Vector getSelNewDay(){
    	String[][] selType = {{"1","1 ��"},{"2","2 ��"},{"3","3 ��"},{"4","4 ��"},{"5","5 ��"},{"6","6 ��"},{"7","7 ��"}}; // �??????? ??????

        return makeSelect(selType);
    }

    /**
     * �ڵ� ĭ ���߱� - f_code_make
     * @param as_code String
     * @param ai_size int
     * @return String
     * @throws Exception
     */
    public static String f_code_make(String as_code, int ai_size) throws Exception {
        StringBuffer zero = new StringBuffer();
        try {
        	if (!(as_code == null || as_code.equals(""))) {
	            int li_code_size = ai_size - as_code.length();
	            for(int i=0; i<li_code_size; i++){
	                zero.append("0");
	            }
	            return zero.toString() + as_code;
	     	} else {
	     		return "";
	     	}
         }catch (Exception e) {
            KJFLog.log("KJFUtil.f_code_make",e.toString());
            throw e;
         }
    }

    /**
     * html ���ڵ� ������ html �ڵ�� ġȯ
     * @param str String
     * @return String
     */
	public static String viewRemark(String str) {

		str = rplc(str,"''","'");
		str = rplc(str,"&quot;","\"");
		str = rplc(str," ","&nbsp;");
		str = rplc(str,"\n","<br>");

		return str;
	}

	/**
     * html ���ڵ� ������ html �ڵ�� ġȯ( br==>\r\n ���� \r\n==>br�� ��ȯ)
     * @param str String
     * @return String
     */
	public static String viewRemark02(String str) {
		str = rplc(str, "\r\n","<br>");
		str = rplc(str, "<br>","\\r\\n");
		return str;
	}


	/**
	 * �ڹٽ�ũ��Ʈ�� ���� ���ڸ� ��ȯ�Ѵ�.
	 * @param str String
	 * @return String
	 */
    public static String transRemarkJavaScript(String str ){

		if(str== null || (str.indexOf("'")==-1 && str.indexOf("\"")==-1) ) return str;

		StringBuffer sb= new StringBuffer();

		int cnt= str.length();
		String ch= "";
		for(int i=0;i<cnt;i++){
			ch= str.charAt(i)+"";
			if(ch.equals( "'"))  ch="\\'";
            if(ch.equals( "\""))  ch="\\'";
			sb.append(ch);
		}

		return sb.toString();
	}


    /**
     * ���ڿ����� Ư�� ���� ġȯ
     * @param str     String
     * @param pattern String
     * @param replace String
     * @return String
     */
	public static String rplc(String str, String pattern, String replace) {
		int s = 0;
		int e = 0;
		StringBuffer result = new StringBuffer();

		while ((e = str.indexOf(pattern, s)) >= 0) {
			result.append(str.substring(s, e));
			result.append(replace);
			s = e + pattern.length();
		}
		result.append(str.substring(s));
		return result.toString();
	}

	/**
	 * ���� �ڸ���
	 * @param title  String
	 * @param maxNum int
	 * @return String
	 */
	public static String getTitleLimit(String title, int maxNum) {
		int blankLen = 0;
		int tLen =title.length();
		int count = 0;
		char c;
		int s=0;
		for(s=0;s<tLen;s++){
			c = title.charAt(s);
			if((int)(count) > (int)(maxNum-blankLen)){
				break;
			}

			if(c>127) count +=2 ;
			else count ++;
		}
		return (tLen >s)? title.substring(0,s)+".." : title;
	}

	/**
	 * �Ű������� ���� ���ڿ����� '-'�� ã�� �����ϰ�    //CH03
     * '-'�� ���� ����� ���ڿ��� Return�Ѵ�.
	 * @param org String
	 * @return String
	 */
	public static String stripHyphen(String org){

		if (org == null) {
			org = "";
		} else {
			for(;;){
				int index = org.indexOf("-");

				if(index >=0){
					org=org.substring(0,index)+org.substring(index+1);
				}else{
					break;
				}
			}
		}

		return org;
	}

	/**
	 * FCK������Ʈ�� �ۼ��� ������ �����ٶ� ...<br>
	 * ������ü�� CSS ������ �޾�  frame ���� ó�� �Ͽ�����<br>
	 * ������ ���� �� �������� ���ϴ� ���� �߻��Ͽ� �÷����� �ٽ� ����.
	 * @param str String
	 * @return String
	 */
	public static String FCKeditorView(String str) {
        String ls_result="";

        ls_result +="<link href=\"../com/FCKeditor/editor/css/fck_view.css\" rel=\"stylesheet\" type=\"text/css\" /> \n";
        ls_result +="<div id='FCKview_hidden' style=\"display:;\" class=\"body\">									    \n";
        ls_result +="												 \n";
        ls_result += str;
        ls_result += "                                                           \n";
        ls_result += "</div>                                                    \n";

        //ls_result +="<iframe src='../com/FCKview.jsp' style='width:100%;height:400' name='FCKviewFrame' id='FCKviewFrame' frameborder='0' scrolling='no' onload='frameResize(this)'></iframe>  \n";

        return ls_result;
	}

	/**
	 * FCK������Ʈ�� �ۼ��� ������ �����ٶ� ...
	 * @param str String
	 * @return String
	 */
	public static String FCKeditorView_no_iframe(String str) {
        String ls_result="";

        //ls_result +="<link href=\"../com/FCKeditor/editor/css/fck_view.css\" rel=\"stylesheet\" type=\"text/css\" /> \n";
        //ls_result +="												 \n";
        ls_result +="<div id='FCKview_hidden' style=\"display:;\" class=\"body\">									    \n";
        ls_result += str;
        ls_result += "                                                           \n";
        ls_result += "</div>                                                    \n";
        
        return ls_result;
	}

   /**
    * ���� ����� ��ȯ�Ѵ�.
	* ����Ʈ�� �Էµ� ���� K,M,G�� ��ȯ
    * @param fileSize String
    * @return String
    */
	public static String getFileSize(String fileSize){

		long fsize = str2long(fileSize);

		long ONE_KByte = 1024;
		long ONE_MByte = ONE_KByte * 1024;
		long ONE_GByte = ONE_MByte * 1024;
		long ONE_TByte = ONE_GByte * 1024;

		if(fsize == 0){
			return "0KB";
		}else if(fsize < ONE_KByte){
			return "1KB";
		}else if(fsize < ONE_MByte){
			return ((int) Math.ceil(fsize/ONE_KByte) )+"KB";
		}else if(fsize < ONE_TByte){
			return ((int) Math.ceil(fsize/ONE_MByte) )+"MB";
		}else{
			return ((int) Math.ceil(fsize/ONE_GByte) )+"GB";
		}
	}

	/**
	 * Ư�� ���̺��� �ִ� ������ ���� ��ȯ
	 * @param SEQ_NAME   String
	 * @param TABLE_NAME String
	 * @return String
	 * @throws Exception
	 */
	public static String getMaxSeq(String SEQ_NAME, String TABLE_NAME) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        ReportEntity rEntity = null;

        String sql= "";

        switch(rDAO.db_type){
		    case 2: //Ms-sql
		    	sql =  "SELECT ISNULL( MAX( CONVERT(INT,  "+SEQ_NAME+") ), 0 ) + 1  MAXSEQ FROM "+TABLE_NAME+"       \n";
		    	break;
    	    default: //oracle
    	    	sql =  "SELECT NVL( MAX( TO_NUMBER("+SEQ_NAME+") ), 0 ) + 1  MAXSEQ FROM "+TABLE_NAME+"       \n";
    	    	break;
        }
        
        rEntity = rDAO.select(sql);

        return rEntity.getValue(0,"MAXSEQ");
    }

	/**
     * BASE64 Encoder
     * @param str String
     * @return String
     * @throws java.io.IOException
    */
	public static String base64Encode(String str) {
	    String result = "";
	    sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	    byte[] b1 = str.getBytes();
	    result = encoder.encode(b1);
	    return result;
	  }

	/**
	 * BASE64 Decoder*
	 * @param str String
	 * @return String
	 * @throws java.io.IOException
	 */
	public static String base64Decode(String str) {
	    String result = "";
	    try {
	        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	        byte[] b1 = decoder.decodeBuffer(str);
	        result = new String(b1);
	    } catch (IOException ex) {
	    }
	    return result;
	}

    /**
     * �ѱ� ���� ���� ���� �ѱ��̸� true
     * @param in String
     * @return boolean
     */
    public static boolean isHangle(String in) {
	      boolean flag = false;
	      String[] str = new String[in.length()];

	      for(int i=0; i<in.length();i++){
	      	    str[i] = in.substring(i,i+1);
	      }

	      for (int i=0;i<str.length;i++) {
				char[] charArray=str[i].toCharArray();
				for (int j=0; j<charArray.length; j++) {

					if (charArray[j]>='\uAC00' && charArray[j]<='\uD7A3')
					    flag = true;
				}
			}
   
	  	return flag;
	}

    /**
     * ������ ��ġ�� �ӽ� ������ �����Ѵ�.
     * @param Lo      String
     * @param userID  String
     * @param content String
     * @throws Exception
     */
    public static void createTempFile(String Lo, String userID, String content) throws Exception{
		String appTempPath = Config.props.get(Lo)+"temp"+KJFFile.FILE_S;
		String appTempFile = userID + ".tmp";

		KJFFile.saveFile(appTempPath, appTempFile, new ByteArrayInputStream(content.getBytes()) );
	}
    
    public static String getStrForm(String s, int num){
        if(s == null || s.equals("")) return s;
        
        // ����� 6�ڸ�(YYYYMMDD)�� �Է��ؾ� �Ѵ�...
        if ( s.length() <= num ) {
            return s;
        }
        
        return s.substring(0, num) + "-" +  s.substring(num, s.length());
    }
    
    
    //��,��,��(y,m,d) type �� ���� �ش� ���ڿ��� ��ȯ�Ѵ�.
    public static String getDateSubstring(String s, String type){
        if(s == null || s.equals("")) return s;
        
        if ( s.length() < 8 ) {
            return s;
        }
        
        if("yyyy".equals(type)) {
        	s = s.substring(0, 4);
        } else if("yy".equals(type)) {
        	s = s.substring(2, 4);
        } else if("mm".equals(type)) {
        	s = s.substring(4, 6);
        } else if("dd".equals(type)) {
        	s = s.substring(6, 8);
        }
        
        return s;
    }
    
}
