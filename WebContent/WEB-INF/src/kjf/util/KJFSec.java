package kjf.util;



/**
 * <p>Subsystem     :  </p>
 * <p>Title         : �⺻���� ��ȣȭ ��ƿ�Լ� </p>
 * <p>Description   : �⺻���� ��ȣȭ ��ƿ�Լ��� �����Ͽ� ����. </p>
 * @author ����
 * @version 1.0 2003.05.29 <br/>
 */
public class KJFSec {
	

	

   
    /**
     * encoding
     * @param data String
     * @return String
     * @throws Exception
     */
    protected String encoding(String data) throws Exception {
    	
        String result = "";
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        byte[] b1 = data.getBytes();
        result = encoder.encode(b1);
        return result;
	}
    
    /**
     * decoding
     * @param b64Str String
     * @return String
     * @throws Exception
     */
    protected String decoding(String b64Str) throws Exception {
    	
		  String result = "";
		  sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		  byte[] b1 = decoder.decodeBuffer(b64Str);
		  result = new String(b1);
        
        return result;
      }
  
    
    /**
     * encode
     * @param data String
     * @return String
     * @throws Exception
     */
    public static  String encode(String data) throws Exception {	
		return new KJFSec().encoding(data);
	}    
    
    /**
     * decode
     * @param data String
     * @return String
     * @throws Exception
     */
    public  static String decode(String data) throws Exception {    	
		return new KJFSec().decoding(data);
	}   
    
  }