package sp.gpkisample;

import java.util.Date;

import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.cms.*;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.crypto.SecretKey;
import com.gpki.gpkiapi.storage.Disk;
import com.gpki.gpkiapi.util.Dump;

/*
 * Created on 2005. 10. 4.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author tomato
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cms {
	private byte[] plainText = new byte[128];
	private boolean bPrintLog = false;
	private int nErrCnt = 0;
	
	public int getErrCnt() {
		return nErrCnt;
	}
	
	public Cms(boolean bPrintLog) {
		
		try {
			this.bPrintLog = bPrintLog;
			
			plainText = Disk.read("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/plainText.txt");
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;		
		}
	}
	
	public void signData() {
			
		System.out.println("1. SignedData");
		
		X509Certificate signerCert1, signerCert2;
		PrivateKey signerPriKey1, signerPriKey2;
		byte[] outData = null;
		
		try {
			
			signerCert1 = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signCert1.der");
			signerPriKey1 = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signPri1.key", "1111");
			
			signerCert2 = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signCert2.der");
			signerPriKey2 = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signPri2.key", "qwer1234");

			SignedData signedData = new SignedData();
			
			System.out.println(" 1.1. Make");
			
			System.out.println("  1.1.1. Message base");
			
			signedData.setMessage(plainText);
			outData = signedData.generate(signerCert1, signerPriKey1);
			System.out.println("  ... ok");

			System.out.println("  1.1.2. File base");
			
			signedData.setMessage_File("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/plainText_File.txt");
			signedData.generate_File(signerCert1, signerPriKey1, "C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/SignedData_File.ber");
			System.out.println("  ... ok");
			
			System.out.println(" 1.2. Add Signer");

			outData = signedData.addSigner(outData, signerCert2, signerPriKey2);
			System.out.println("  ... ok");
			
			//Disk.write("./Sample/CMS/SignedData.ber", outData);
			
			System.out.println(" 1.3. Verify");
			
			System.out.println("  1.3.1. Message base");

			System.out.print("  - SelfTest");
			
			byte[] msg = null;
			int cnt = 0;
			
			signedData.verify(outData);
			msg = signedData.getMessage();
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  MSG = " + new String(msg, 0, msg.length));
			}
						
			cnt = signedData.getSignerCnt();
			
			if (bPrintLog == true)
				System.out.println("  [SignInfo]");

			for (int i=0; i<cnt; i++) {
				X509Certificate signer = signedData.getSignerCert(i);
				Date signTime = signedData.getSigningTime(i);
				
				if (bPrintLog == true) {
					System.out.println("  Singner[" + i + "]  = " + signer.getSubjectDN());
					System.out.println("  SignTime[" + i + "] = " + signTime);
				}
			}
			
			if (bPrintLog == false)
				System.out.println(" ... ok");
			
			System.out.print("  - Compatibility");
			outData = Disk.read("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/SignedData.ber");
			
			signedData.verify(outData);
			msg = signedData.getMessage();
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  MSG = " + new String(msg, 0, msg.length));
			}
			
			cnt = signedData.getSignerCnt();
			
			if (bPrintLog == true)
				System.out.println("  [SignInfo]");
			
			for (int i=0; i<cnt; i++) {
				X509Certificate signer = signedData.getSignerCert(i);
				Date signTime = signedData.getSigningTime(i);
				
				if (bPrintLog == true) {
					System.out.println("   Singner[" + i + "]  = " + signer.getSubjectDN());
					System.out.println("   SignTime[" + i + "] = " + signTime);
				}
			}
			
			if (bPrintLog == false)
				System.out.println(" ... ok");

			System.out.println("  1.3.2. File base");
						
			signedData.verify_File("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/SignedData_File.ber", "./Sample/CMS/message_File.txt");
						
			cnt = signedData.getSignerCnt();
			
			if (bPrintLog == true)
				System.out.println("  [SignInfo]");

			for (int i=0; i<cnt; i++) {
				X509Certificate signer = signedData.getSignerCert(i);
				Date signTime = signedData.getSigningTime(i);
				
				if (bPrintLog == true) {
					System.out.println("  Singner[" + i + "]  = " + signer.getSubjectDN());
					System.out.println("  SignTime[" + i + "] = " + signTime);
				}
			}
			
			if (bPrintLog == false)
				System.out.println(" ... ok");
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void envData() {

		System.out.println("2. EnvelopedData");
		
		X509Certificate recCert1, recCert2;
		PrivateKey recPriKey1, recPriKey2;
		byte[] outData = null, msg = null;
		
		try {
			
			recCert1 = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmCert1.der");
			recPriKey1 = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmPri1.key", "1111");
			
			recCert2 = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmCert2.der");
			recPriKey2 = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmPri2.key", "qwer1234");

			System.out.println(" 2.1. Make");
			
			EnvelopedData envData = new EnvelopedData("ARIA");
			
			System.out.println("  2.1.1. File Base");
			
			envData.addRecipient(recCert1);
			envData.generate_File("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/plainText_File.txt", "C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/envData_File.ber");
			
			//	세션키 정보 확인
			SecretKey secretKey = envData.getSecretKey();
			
			byte[] bKey = null;
			byte[] bIv = null;
			if (bPrintLog == true) {
				System.out.println("Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("Key = ");	
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println("   ... ok");
			
			System.out.println("  2.1.2. Message Base");
			
			envData.addRecipient(recCert2);
			
			outData = envData.generate(plainText);
			
			// 세션키 정보 확인
			secretKey = envData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("Key = ");	
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println("   ... ok");
			
			//Disk.write("./Sample/CMS/EnvelopedData.ber", outData);
			
			System.out.println(" 2.2. Process");
			System.out.println("  2.2.1. Message Base");
			System.out.println("   - SelfTest");

			msg = envData.process(outData, recCert1, recPriKey1);
			
			System.out.print("   first recipient");
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  - 원본메시지 = " + new String(msg, 0, msg.length));
			}
			
			// 세션키 정보 확인
			secretKey = envData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("  - Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("  - Key = ");
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("  - IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println(" ... ok");
			
			msg = envData.process(outData, recCert2, recPriKey2);
			
			System.out.print("   second recipient");
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  - 원본메시지 = " + new String(msg, 0, msg.length));
			}
			
			// 세션키 정보 확인
			secretKey = envData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("  - Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("  - Key = ");
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("  - IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println(" ... ok");
		
			System.out.println("   - Compatibility");
			outData = Disk.read("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/EnvelopedData.ber");
			
			msg = envData.process(outData, recCert1, recPriKey1);
			
			System.out.print("   first recipient");
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  - 원본메시지 = " + new String(msg, 0, msg.length));	
			}
			
			// 세션키 정보 확인
			secretKey = envData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("  - Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("  - Key = ");
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("  - IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println(" ... ok");
			
			msg = envData.process(outData, recCert2, recPriKey2);
			
			System.out.print("   second recipient");
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  - 원본 메시지 = " + new String(msg, 0, msg.length));
			}
			
			// 세션키 정보 확인
			secretKey = envData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("  - Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("  - Key = ");
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("  - IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println(" ... ok");
			
			System.out.println("  2.2.2. File Base");
			
			msg = envData.process_File("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/EnvData_File.ber", recCert1, recPriKey1, "C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/Messsage_File.txt");
			
			// 세션키 정보 확인
			secretKey = envData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("  - Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("  - Key = ");
				bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("  - IV  = ");
				bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println(" ... ok");
			
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void signedAndEnvData() {

		System.out.println("3. SignedAndEnvelopedData");
		
		X509Certificate signerCert, kmCert;
		PrivateKey signerKey, kmKey;
		byte[] outData = null, msg = null;
		
		try {
	
			signerCert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signCert1.der");
			signerKey = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signPri1.key", "1111");
			
			kmCert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmCert1.der");
			kmKey = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmPri1.key", "1111");
			
			System.out.println(" 3.1. Make");
			
			SignedAndEnvelopedData signedAndEnvData = new SignedAndEnvelopedData("SEED");
			
			signedAndEnvData.setMyCert(signerCert, signerKey);
			outData = signedAndEnvData.generate(kmCert, plainText);
			Disk.write("./Sample/CMS/signedAndEnvData.ber", outData);
			
			System.out.println("  ... ok");
			
			System.out.println(" 3.2. Process");
			
			signedAndEnvData.setMyCert(kmCert, kmKey);
			outData = signedAndEnvData.process(outData);
			
			SecretKey secretKey = signedAndEnvData.getSecretKey();
			
			if (bPrintLog == true) {
				System.out.println("  MSG = " + new String(outData, 0, outData.length));
				
				System.out.println("  - Session KeyAlg = " + secretKey.getKeyAlg());
				
				System.out.print("  - Key = ");
				byte[] bKey = secretKey.getKey();
				for (int i=0; i<bKey.length; i++)
					System.out.print(Dump.getHexString(bKey[i]));
				System.out.println("");
				
				System.out.print("  - IV  = ");
				byte[] bIv = secretKey.getIv();
				for (int i=0; i<bIv.length; i++)
					System.out.print(Dump.getHexString(bIv[i]));
				System.out.println("");
			}
			else
				System.out.println("  ... ok");
			
			//Disk.write("./Sample/CMS/aaa.txt", outData);
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void signedContent() {
		
		System.out.println("4. SignedContent");
		
		X509Certificate signerCert;
		PrivateKey signerPriKey;
		byte[] outData	= null;
		byte[] msg 		= null;
		int cnt			= 0;
		
		try {
			
			signerCert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signCert3.der");
			signerPriKey = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/signPri3.key", "88888888");
			
			System.out.println(" 4.1. Make");
			
			SignedContent signedContent = new SignedContent();
			
			if (bPrintLog == true)
				System.out.println(new String(plainText, 0, plainText.length));
			
			outData = signedContent.generate(plainText, signerCert, signerPriKey);
			
			//Disk.write("./Sample/CMS/SignedContent.xdr", outData);
			
			System.out.println("  ... ok");
			
			System.out.println(" 4.2. Verify");
			System.out.print("  - SelfTest");
			
			signedContent.verify(outData);
			msg = signedContent.getMessage();
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  Message = " + new String(msg, 0, msg.length));
			}
			
			X509Certificate signer = signedContent.getSignerCert();
			
			if (bPrintLog == true) {
				System.out.println("  Singner = " + signer.getSubjectDN());
				System.out.println("  SignTime = " + signedContent.getSigningTime());
			}
			else
				System.out.println(" ... ok");
			
			System.out.print("  - Compatibility");
			outData = Disk.read("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/SignedContent.xdr");
			
			signedContent.verify(outData);
			msg = signedContent.getMessage();
			
			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  Message = " + new String(msg, 0, msg.length));
			}
			
			signer = signedContent.getSignerCert();
			
			if (bPrintLog == true) {
				System.out.println("  Singner = " + signer.getSubjectDN());
				System.out.println("  SignTime = " + signedContent.getSigningTime());
			}
			else
				System.out.println(" ... ok");

		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void wapEnvData() {

		System.out.println("5. WapEnvelopedData");
		
		X509Certificate recCert;
		PrivateKey recPriKey;
		byte[] outData = null, msg = null;
		
		try {
			
			recCert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmCert1.der");
			recPriKey = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/kmPri1.key", "1111");
						
			System.out.println(" 5.1. Make");
			
			WapEnvelopedData wapEnvData = new WapEnvelopedData("3DES");
			
			outData = wapEnvData.generate(plainText, recCert);
			//Disk.write("./Sample/CMS/WapEnvelopedData.xdr", outData);
			
			System.out.println("  ... ok");
			
			System.out.println(" 5.2. Process");
			System.out.print("  - SelfTest");
						
			wapEnvData.setMyCert(recCert, recPriKey);
			msg = wapEnvData.process(outData);

			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  MSG = " + new String(msg, 0, msg.length));
			}
			else
				System.out.println(" ... ok");
			
			System.out.print("  - Compatibility");
			outData = Disk.read("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CMS/WapEnvelopedData.xdr");

			wapEnvData.setMyCert(recCert, recPriKey);
			msg = wapEnvData.process(outData);

			if (bPrintLog == true) {
				System.out.println(" ");
				System.out.println("  MSG = " + new String(msg, 0, msg.length));
			}
			else
				System.out.println(" ... ok");
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
}
