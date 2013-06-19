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
					
			// 1. ����Ȯ�� ��ū�ޱ�
			
			// ����Ȯ�� ���� �޽��� ����
			timeStamp.setMessage(message);
			
			// ����Ȯ�� ��ū ��û�ϱ�
			timeStampToken = timeStamp.reqTimeStampToken("152.99.56.61", 80);
			
			Disk.write("./Sample/TSA/Message.tst", timeStampToken.getTimeStampToken());
			
			// 2. ���� ����Ȯ�� ��ū �����ϱ�
			timeStampToken.verify(message);
			
			// 3. ����Ȯ�� ��ū ���� Ȯ���ϱ�
			displayTimeStampTokenInfo(timeStampToken);
			
			// 4. ����Ȯ�� ���� �޽��� Ȯ���ϱ�
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
			System.out.println("  [TSA ���� DN] " + tsaCert.getSubjectDN());
		
			// SerialNumber
			BigInteger serialNum = timeStampToken.getSerialNumber();
		
			System.out.print("  [��ū �Ϸù�ȣ] " + serialNum + "(");
		
			bBuf = serialNum.toByteArray();
			for (int i=0; i<bBuf.length; i++)
				System.out.print(Dump.getHexString(bBuf[i]));
		
			System.out.println(")");
		
			// GenTime
			System.out.println("  [��ū �����ð�] " + timeStampToken.getGeneratedTime());
		
			// Policy
			System.out.println("  [��ū �߱���å] " + timeStampToken.getPolicy());
		
			// Hash Algorithm
			System.out.println("  [�ؽ� �˰���] " + timeStampToken.getHashAlgorithm());
		
			// MessageImprint
			System.out.print("  [�޽��� �ؽ���] ");
		
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
