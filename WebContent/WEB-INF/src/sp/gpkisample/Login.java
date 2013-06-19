package sp.gpkisample;

import com.gpki.gpkiapi.GpkiApi;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.cms.SignedData;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.crypto.Random;
import com.gpki.gpkiapi.storage.Disk;

public class Login {
	/*******************************************************************************************/
	// �Ʒ� define�� ���� �ý��ۿ� �°� ������ �־�� �Ѵ�.
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
                    // ������ 20Byte(R1)�� ����	
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
                    // �α��ο� ����� ����� �������� ����Ű�� ȹ��
                    X509Certificate signCert = Disk.readCert(CLIENT_SIGN_CERT_PATH);
                    PrivateKey signPriKey = Disk.readPriKey(CLIENT_SIGN_PRIKEY_PATH, CLIENT_SIGN_PRIKEY_PASSWD);

                    // �����κ��� ���� R1�� ����
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
                // ������ ����
                SignedData signedData = new SignedData();
                signedData.verify(bSignedData);
              
                // ������ ���ԵǾ��ִ� �����޽����� ������ ������
                // �����ߴ� �޽����� ������ Ȯ��

                byte[] bRandom = signedData.getMessage();

                
                if (bRandom.length != bSvrRandom.length)
                	throw new Exception("�������� ���� �������� ���� ������ �ƴմϴ�.");

                for (int i=0; i<bRandom.length; i++)
                {
                    if (bRandom[i] != bSvrRandom[i])
                    	throw new Exception("�������� ���� �������� ���� ������ �ƴմϴ�.");
                }

 
                // ���հ��������� ������ ������ ��û�ϱ� ���ؼ� ������ ����� ������ ȹ��
                X509Certificate svrCert = Disk.readCert(SERVER_SIGN_CERT_PATH);
                PrivateKey svrKey = Disk.readPriKey(SERVER_SIGN_PRIKEY_PATH, SERVER_SIGN_PRIKEY_PASSWD);
                                     
                // ������ Ŭ���̾�Ʈ�� ������ ȹ��
                X509Certificate clientCert = signedData.getSignerCert(0);
                    
                // ������ ���ԵǾ��ִ� Ŭ���̾�Ʈ�� ������ ���� (3.2.5. ����)
                Cert cert = new Cert();
 //               cert.setMyCert(svrCert, svrKey);
 //               cert.setCert(��sign��, clientCert);
              
                cert.verify();

                // Ŭ���̾�Ʈ�� �������� �̸��� �̿��Ͽ� 

                // �ش� Ŭ���̾�Ʈ�� �α��� ���� ���� Ȯ��
                String sClientName = clientCert.getSubjectDN();

           } catch (Exception e) {
                e.printStackTrace();                      
           }

     }

     

     void login() {
           // API �ʱ�ȭ
           try {
               	GpkiApi.init(WORK_DIR_PATH);
           } catch (Exception e) {
                e.printStackTrace();                      
           }
        
           // ����
           byte[] bRandom = genRandom();
           
           // Ŭ���̾�Ʈ
           byte[] bSignedData = signRandom(bRandom);
           
           // ����
           verifySign(bRandom, bSignedData);

     }



}
