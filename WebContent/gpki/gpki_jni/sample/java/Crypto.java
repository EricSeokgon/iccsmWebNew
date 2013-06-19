import com.gpki.gpkiapi.crypto.*;
import com.gpki.gpkiapi.storage.Disk;
import com.gpki.gpkiapi.util.Dump;
import com.gpki.gpkiapi.cert.X509Certificate;

/*
 * Created on 2005. 9. 26.
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
public class Crypto {

	private byte[] plainText = new byte[128], cipherText = null;
	private int nSubIndex = 0, nIndex = 0;
	private int nErrCnt = 0;
	private boolean bPrintLog = false;

	public int getErrCnt() {
		return nErrCnt;
	}

	public Crypto(boolean bPrintLog) {

		try {
			this.bPrintLog = bPrintLog;
			plainText = Disk.read("./Sample/CRYPTO/plainText.txt");

		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}

	public void SymmetricKey() {

		System.out.println("1. SymmetricKey");
		
		nIndex = 1;
	
		System.out.println("1.1. DES");
		
		nSubIndex = 1;
		SymmetricKey("DES", "DES/CBC/PKCS5");
		nSubIndex ++;
		SymmetricKey("DES", "DES/CBC/NONE");
		
		nIndex ++;
		
		System.out.println("1.2. 3DES");
		
		nSubIndex = 1;
		SymmetricKey("3DES", "3DES/CBC/PKCS5");
		nSubIndex ++;
		SymmetricKey("3DES", "3DES/CBC/NONE");
		
		nIndex ++;
		
		System.out.println("1.3. SEED");
		
		nSubIndex = 1;
		SymmetricKey("SEED", "SEED/CBC/PKCS5");
		nSubIndex ++;
		SymmetricKey("SEED", "SEED/CBC/NONE");
		
		nIndex ++;
		
		System.out.println("1.4. NEAT");
		
		nSubIndex = 1;
		SymmetricKey("NEAT", "NEAT/CBC/PKCS5");
		nSubIndex ++;
		SymmetricKey("NEAT", "NEAT/CBC/NONE");
		
		nIndex ++;
		
		System.out.println("1.5. ARIA");
		
		nSubIndex = 1;
		SymmetricKey("ARIA", "ARIA/CBC/PKCS5");
		nSubIndex ++;
		SymmetricKey("ARIA", "ARIA/CBC/NONE");
		
		nIndex ++;
		
		System.out.println("1.6. NES");
		
		nSubIndex = 1;
		SymmetricKey("NES", "NES/CBC/PKCS5");
		nSubIndex ++;
		SymmetricKey("NES", "NES/CBC/NONE");
	}

	private void SymmetricKey(String alg, String mode) {
		
		byte[] bBuf = null;
		
		try {
		
			System.out.println(" 1." + nIndex + "." + nSubIndex + ". " + mode);

			System.out.print("  - GenerateKey");
			KeyGenerator keyGen = KeyGenerator.getInstance(alg);
			SecretKey seedKey = keyGen.generateKey();

			byte[] key = seedKey.getKey();
			byte[] iv = seedKey.getIv();

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("   Algorithm = " + seedKey.getKeyAlg());
				System.out.print("   Key [" + key.length + "]= ");

				for (int i = 0; i < key.length; i++)
					System.out.print(Dump.getHexString(key[i]));

				System.out.println(" ");

				System.out.print("   IV [" + iv.length + "]= ");

				for (int i = 0; i < iv.length; i++)
					System.out.print(Dump.getHexString(iv[i]));

				System.out.println(" ");
			}
			else
				System.out.println("  ... ok");

			System.out.print("   - Encrypt");

			Cipher seed = Cipher.getInstance(mode);
			seed.init(Cipher.ENCRYPT_MODE, seedKey);
			cipherText = seed.doFinal(plainText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("   PlainText[" + plainText.length + "]  = "
					+ new String(plainText, 0, plainText.length));
				System.out.print("   CihperText[" + cipherText.length + "] = ");

				for (int i = 0; i < cipherText.length; i++)
					System.out.print(Dump.getHexString(cipherText[i]));

				System.out.println(" ");
			}
			else
				System.out.println("  ... ok");
			
			System.out.print("   - Decrypt");

			// 암호화  후, Key와  IV가 변경되므로 초기화한다.
			seed.init(Cipher.DECRYPT_MODE, seedKey);
			plainText = seed.doFinal(cipherText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("   PlainText[" + plainText.length + "]  = "
					+ new String(plainText, 0, plainText.length));
			}
			else
				System.out.println("  ... ok");

		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	public void AsymmetricKey() {

		PrivateKey priKey = null;
		PublicKey pubKey = null;
		byte[] signature = null;
		byte[] bBuf = null;

		try {
			
			System.out.println("2. AsymmetricKey");
			
			// 비대칭키 암/복호화
			System.out.println(" 2.1. RSA Encrypt/Decyrpt");

			// RSA 개인키와 인증서 읽기
			System.out.print("  - Read cert and prikey");
			
			X509Certificate cert = Disk.readCert("./Sample/CRYPTO/rsaCert.der");
			priKey = Disk.readPriKey("./Sample/CRYPTO/rsaPri.key", "1111");
			
			pubKey = cert.getSubjectPublicKeyInfo();
			
			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("   개인키 : " + priKey.getKeyAlg() + " (" + priKey.getKeyLen() + ")");
				System.out.println("   공개키 : " + pubKey.getKeyAlg() + " (" + pubKey.getKeyLen() + ")");
			}
			else
				System.out.println(" ... ok");
			
			// 암호화
			System.out.print("  - Encrypt");
			
			Cipher rsa = Cipher.getInstance("RSA");
			rsa.init(Cipher.ENCRYPT_MODE, pubKey);
			cipherText = rsa.doFinal(plainText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.print("  CihperText[" + cipherText.length + "] = ");

				for (int i = 0; i < cipherText.length; i++)
					System.out.print(Dump.getHexString(cipherText[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");
			
			// 복호화
			System.out.print("  - Decrypt");

			rsa.init(Cipher.DECRYPT_MODE, priKey);
			plainText = rsa.doFinal(cipherText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("  PlainText[" + plainText.length + "]  = "
					+ new String(plainText, 0, plainText.length));
			}
			else
				System.out.println(" ... ok");
			
			// 서명값 생성
			System.out.println(" 2.2. SHA1WithRSA");

			Signature sign = new Signature();
			sign.initSign(priKey, "SHA1");
			signature = sign.sign(plainText);

			System.out.print("  - Sign");
			
			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.print("  Signature[" + signature.length + "] = ");

				for (int i = 0; i < signature.length; i++)
					System.out.print(Dump.getHexString(signature[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");

			// 서명값 검증
			System.out.print("  - Verify");

			sign.initVerify(pubKey, "SHA1");
			sign.verify(plainText, signature);

			System.out.println(" ... ok");
			
			// 서명값 생성
			System.out.println(" 2.3. SHA256WithRSA");

			sign.initSign(priKey, "SHA256");
			signature = sign.sign(plainText);

			System.out.print("  - Sign");
			
			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.print("  Signature[" + signature.length + "] = ");

				for (int i = 0; i < signature.length; i++)
					System.out.print(Dump.getHexString(signature[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");

			// 서명값 검증
			System.out.print("  - Verify");

			sign.initVerify(pubKey, "SHA256");
			sign.verify(plainText, signature);

			System.out.println(" ... ok");
			
			// KCDSA
			System.out.println(" 2.4. SHA1WithKCDSA");

			// KCDSA 개인키와 인증서 읽기
			System.out.print("  - Read cert and prikey");
			
			cert = Disk.readCert("./Sample/CRYPTO/kcdsaCert.der");
			priKey = Disk.readPriKey("./Sample/CRYPTO/kcdsaPri.key", "1111");
			
			pubKey = cert.getSubjectPublicKeyInfo();
			
			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("   개인키 : " + priKey.getKeyAlg() + " (" + priKey.getKeyLen() + ")");
				System.out.println("   공개키 : " + pubKey.getKeyAlg() + " (" + pubKey.getKeyLen() + ")");
			}
			else
				System.out.println(" ... ok");
			
			System.out.print("  - Sign");
			
			sign.initSign(priKey, pubKey, "SHA1");
			signature = sign.sign(plainText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.print("  Signature[" + signature.length + "] = ");

				for (int i = 0; i < signature.length; i++)
					System.out.print(Dump.getHexString(signature[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");

			// 서명값 검증
			System.out.print("  - Verify");

			sign.initVerify(pubKey, "SHA1");
			sign.verify(plainText, signature);

			System.out.println(" ... ok");

			System.out.println(" 2.5. SHA256WithKCDSA");

			System.out.print("  - Sign");
			
			sign.initSign(priKey, pubKey, "SHA256");
			signature = sign.sign(plainText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.print("  Signature[" + signature.length + "] = ");

				for (int i = 0; i < signature.length; i++)
					System.out.print(Dump.getHexString(signature[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");

			// 서명값 검증
			System.out.print("  - Verify");

			sign.initVerify(pubKey, "SHA256");
			sign.verify(plainText, signature);

			System.out.println(" ... ok");
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}

	public void Random() {

		byte[] nonce = null;

		try {

			System.out.println("3. Random");
			System.out.print(" - Generate Random");

			Random random = new Random();
			nonce = random.generateRandom(20);

			if (bPrintLog == true)
			{
				System.out.print("  Random[" + nonce.length + "] = ");

				for (int i = 0; i < nonce.length; i++)
					System.out.print(Dump.getHexString(nonce[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");

		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}

	public void Mac() {

		System.out.println("4. MAC");
		
		nSubIndex = 1;
		Mac("sha1Hmac");
		
		nSubIndex ++;
		Mac("md5Hmac");
	}
	
	public void Mac(String alg){
		
		byte[] authCode = null;

		try {
			
			System.out.println(" 4." + nSubIndex + ". " + alg);

			System.out.print("  - Generate mac");
			
			Mac mac = Mac.getInstance(alg);

			mac.init("abc");
			authCode = mac.generate(plainText);

			if (bPrintLog == true)
			{
				System.out.println(" ");
				System.out.println("  Message[" + plainText.length + "]  = "
					+ new String(plainText, 0, plainText.length));
				System.out.println("  Key[" + "abc".length() + "]       = " + "abc");
				System.out.print("  MacValue[" + authCode.length + "] = ");

				for (int i = 0; i < authCode.length; i++)
					System.out.print(Dump.getHexString(authCode[i]));

				System.out.println(" ");
			}
			else
				System.out.println(" ... ok");
			
			// 맥값 검증
			System.out.print("  - Verify mac");
			
			mac.verify(plainText, authCode);

			System.out.println(" ... ok");

		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}

	public void Hash() {

		System.out.println("5. HASH");
		
		nSubIndex = 1;
		Hash("SHA1");
		
		nSubIndex ++;
		Hash("HAS160");
		
		nSubIndex ++;
		Hash("SHA256");
		
		nSubIndex ++;
		Hash("MD5");
	}
	
	public void Hash(String alg) {

		byte[] hashValue = null;

		try {
			
			System.out.println(" 5." + nSubIndex + ". " + alg);

			MessageDigest hash = MessageDigest.getInstance(alg);
			hashValue = hash.digest(plainText);

			if (bPrintLog == true)
			{
				System.out.println("  Message[" + plainText.length + "]   = "
					+ new String(plainText, 0, plainText.length));
				System.out.print("  HashValue[" + hashValue.length + "] = ");

				for (int i = 0; i < hashValue.length; i++)
					System.out.print(Dump.getHexString(hashValue[i]));

				System.out.println(" ");
			}
			else
				System.out.println("  ... ok");

		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
}
