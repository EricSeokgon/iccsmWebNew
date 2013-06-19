package sp.gpkisample;

import com.gpki.gpkiapi.GpkiApi;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.cms.SignedData;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.crypto.Random;
import com.gpki.gpkiapi.storage.Disk;

public class Login {
	/*******************************************************************************************/
	// 아래 define은 적용 시스템에 맞게 수정해 주어야 한다.
     private static String WORK_DIR_PATH  = "C:/Program Files/GPKISecureWeb";
     private static String CLIENT_SIGN_CERT_PATH = "";
     private static String CLIENT_SIGN_PRIKEY_PATH  = "";
     private static String CLIENT_SIGN_PRIKEY_PASSWD = "";
     private static String SERVER_SIGN_CERT_PATH = "";
     private static String SERVER_SIGN_PRIKEY_PATH  = "";
     private static String SERVER_SIGN_PRIKEY_PASSWD = "";

	/*******************************************************************************************/
     byte[] genRandom() {
    	 
    	 byte[] bRandom = null;

	           try {
                    // 랜덤값 20Byte(R1)를 생성	
                    Random random = new Random();	
                    bRandom = random.generateRandom(20);
	
	           } catch (Exception e) {	
                    e.printStackTrace();                      
	           }
	
	     return bRandom;
     }

     
     byte[] signRandom(byte[] bRandom) {

           byte[] bSignedData = null;
         
           		try {
                    // 로그인에 사용할 서명용 인증서와 개인키를 획득
                    X509Certificate signCert = Disk.readCert(CLIENT_SIGN_CERT_PATH);
                    PrivateKey signPriKey = Disk.readPriKey(CLIENT_SIGN_PRIKEY_PATH, CLIENT_SIGN_PRIKEY_PASSWD);

                    // 서버로부터 받은 R1을 서명
                    SignedData signedData = new SignedData();
                    	signedData.setMessage(bRandom);
                        bSignedData = signedData.generate(signCert, signPriKey);
	           } catch (Exception e) {
	                e.printStackTrace();                      
	
	           }

           return bSignedData;
     }

     
     void verifySign(byte[] bSvrRandom, byte[] bSignedData) {
                
    	 try {
                // 서명값을 검증
                SignedData signedData = new SignedData();
                signedData.verify(bSignedData);
              
                // 서명값에 포함되어있던 원본메시지가 서버가 이전에
                // 전송했던 메시지와 같은지 확인

                byte[] bRandom = signedData.getMessage();

                
                if (bRandom.length != bSvrRandom.length)
                	throw new Exception("서버에서 보낸 랜덤값에 대한 서명이 아닙니다.");

                for (int i=0; i<bRandom.length; i++)
                {
                    if (bRandom[i] != bSvrRandom[i])
                    	throw new Exception("서버에서 보낸 랜덤값에 대한 서명이 아닙니다.");
                }

 
                // 통합검증서버에 인증서 검증을 요청하기 위해서 서버의 서명용 인증서 획득
                X509Certificate svrCert = Disk.readCert(SERVER_SIGN_CERT_PATH);
                PrivateKey svrKey = Disk.readPriKey(SERVER_SIGN_PRIKEY_PATH, SERVER_SIGN_PRIKEY_PASSWD);
                                     
                // 검증할 클라이언트의 인증서 획득
                X509Certificate clientCert = signedData.getSignerCert(0);
                    
                // 서명값에 포함되어있던 클라이언트의 인증서 검증 (3.2.5. 참조)
                Cert cert = new Cert();
 //               cert.setMyCert(svrCert, svrKey);
 //               cert.setCert(“sign”, clientCert);
              
                cert.verify();

                // 클라이언트의 인증서의 이름을 이용하여 

                // 해당 클라이언트의 로그인 수용 여부 확인
                String sClientName = clientCert.getSubjectDN();

           } catch (Exception e) {
                e.printStackTrace();                      
           }

     }

     

     void login() {
           // API 초기화
           try {
               	GpkiApi.init(WORK_DIR_PATH);
           } catch (Exception e) {
                e.printStackTrace();                      
           }
        
           // 서버
           byte[] bRandom = genRandom();
           
           // 클라이언트
           byte[] bSignedData = signRandom(bRandom);
           
           // 서버
           verifySign(bRandom, bSignedData);

     }



}
