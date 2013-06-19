import java.math.BigInteger;

import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.storage.Disk;
import com.gpki.gpkiapi.tsa.TimeStamp;
import com.gpki.gpkiapi.tsa.TimeStampToken;
import com.gpki.gpkiapi.tsa.TimeStampRes;
import com.gpki.gpkiapi.util.Dump;

/*
 * Created on 2005. 9. 29.
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
public class Tsa {
	private int nErrCnt = 0;
	
	public int getErrCnt() {
		return nErrCnt;
	}
	
	public void reqTimeStamp() {
		
		byte[] message 	= null;
		
		X509Certificate myCert;
		PrivateKey myPriKey;
		
		try {
			
			message = Disk.read("./Sample/TSA/Message.txt");
						
			TimeStamp timeStamp = new TimeStamp();
			TimeStampToken 	timeStampToken;
					
			// 1. 시점확인 토큰받기
			
			// 시점확인 받을 메시지 설정
			timeStamp.setMessage(message);
			
			// 시점확인 토큰 요청하기
			timeStampToken = timeStamp.reqTimeStampToken("152.99.56.61", 80);
			
			Disk.write("./Sample/TSA/Message.tst", timeStampToken.getTimeStampToken());
			
			// 2. 받은 시점확인 토큰 검증하기
			timeStampToken.verify(message);
			
			// 3. 시점확인 토큰 내용 확인하기
			displayTimeStampTokenInfo(timeStampToken);
			
			// 4. 시점확인 응답 메시지 확인하기
			TimeStampRes	timeStampRes;
			byte[] resMsg = Disk.read("./Sample/TSA/TimeStampRes_nok.ber");
			
			timeStampRes = new TimeStampRes(resMsg);
			
			System.out.println("Status = " + timeStampRes.getStatus());
			
			if (timeStampRes.getStatus() != 0)
				System.out.println("PKIFreeText = " + timeStampRes.getPkiFreeText());
			else
				displayTimeStampTokenInfo(timeStampRes.getTimeStampToken());
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void displayTimeStampTokenInfo(TimeStampToken timeStampToken) {
		
		byte[] bBuf 	= null;
		
		try {
			X509Certificate tsaCert = timeStampToken.getTSACert();
		
			// DN
			System.out.println("  [TSA 서버 DN] " + tsaCert.getSubjectDN());
		
			// SerialNumber
			BigInteger serialNum = timeStampToken.getSerialNumber();
		
			System.out.print("  [토큰 일련번호] " + serialNum + "(");
		
			bBuf = serialNum.toByteArray();
			for (int i=0; i<bBuf.length; i++)
				System.out.print(Dump.getHexString(bBuf[i]));
		
			System.out.println(")");
		
			// GenTime
			System.out.println("  [토큰 생성시간] " + timeStampToken.getGeneratedTime());
		
			// Policy
			System.out.println("  [토큰 발급정책] " + timeStampToken.getPolicy());
		
			// Hash Algorithm
			System.out.println("  [해쉬 알고리즘] " + timeStampToken.getHashAlgorithm());
		
			// MessageImprint
			System.out.print("  [메시지 해쉬값] ");
		
			bBuf = timeStampToken.getMessageImprint();
			for (int i=0; i<bBuf.length; i++)
				System.out.print(Dump.getHexString(bBuf[i]));
			
			System.out.println(" ");
		
			// Nonce
			System.out.print("  [Nonce] ");
			
			bBuf = timeStampToken.getNonce();
			for (int i=0; i<bBuf.length; i++)
				System.out.print(Dump.getHexString(bBuf[i]));
			
			System.out.println(" ");
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
}
