package sp.gpkisample;

import java.math.BigInteger;
import java.util.Date;

import com.gpki.gpkiapi.cert.CertPathValidator;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.crypto.PublicKey;
import com.gpki.gpkiapi.storage.Disk;
import com.gpki.gpkiapi.util.Dump;
import com.gpki.gpkiapi.ocsp.OCSPRequest;
import com.gpki.gpkiapi.ocsp.OCSPResponse;

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
public class Cert {
	private int nErrCnt = 0;
	
	public int getErrCnt() {
		return nErrCnt;
	}
	
	void view() {
		
		byte[] bBuf = null;
		try {
			
			X509Certificate x509Cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/viewCert.der");
			
			System.out.println("1. View");
			System.out.println(" 1.1. TBSCertificate");
			
			// serialNum
			BigInteger serialNum = x509Cert.getSerialNumber();
			
			System.out.print("  [SerialNum] " + serialNum + "(");
			
			bBuf = serialNum.toByteArray();
			for (int i=0; i<bBuf.length; i++)
				System.out.print(Dump.getHexString(bBuf[i]));
			
			System.out.println(")");
			
			// Issuer DN
			System.out.println("  [IssuerDN] " + x509Cert.getIssuerDN());
			
			// Validity
			System.out.println("  [Validity] " + x509Cert.getNotBefore() + " ~ " + x509Cert.getNotAfter());
			
			// Subject DN
			System.out.println("  [SubjectDN] " + x509Cert.getSubjectDN());
			
			// Subject PublicKeyInfo
			PublicKey pubKey = x509Cert.getSubjectPublicKeyInfo();
			
			System.out.println("  [SubjectPublicKeyInfo] " + pubKey.getKeyAlg() + " (" + pubKey.getKeyLen() + ")");
		
			bBuf = pubKey.getKey();
			for (int i=0; i<bBuf.length; i++)
			{
				if (i == 0)
					System.out.print("  ");
				System.out.print(Dump.getHexString(bBuf[i]));
			}
			
			System.out.println(" ");
			
			// Extensions
			String extValue;
			System.out.println("  [Extensions]");
			
			//  BasicConstraints
			extValue = x509Cert.getBasicConstsraints();
			if (extValue.length() != 0)
			{
				System.out.println("   <BasicConstraints>");
				System.out.println("   " + extValue + "\n");
				extValue = "";
			}
			
			//  CertPolicy
			extValue = x509Cert.getCertPolicy();
			if (extValue.length() != 0)
			{
				System.out.println("  <CertPolicy>");
				System.out.println("  " + extValue + "\n");
				extValue = "";
			}
			
			//  KeyUsage
			extValue = x509Cert.getKeyUsage();
			if (extValue.length() != 0)
			{
				System.out.println("   <KeyUsage>");
				System.out.println("   " + extValue + "\n");
				extValue = "";
			}
							
			System.out.println("  ... ok");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void verify() {
		
		System.out.println("2. Verify");
		
		CertPathValidator certPathValiditor = null; 
		X509Certificate cert = null;
		
		try {
			certPathValiditor = new CertPathValidator("C:/work/JSP_Project/iccsm/gpki_files/conf/gpkiapi.conf");
			
			//X509Certificate rootCert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/KISA.der");
			
			X509Certificate myCert = Disk.readCert("./Sample/CERT/001권한용001_sig.der");
			PrivateKey myPrikey = Disk.readPriKey("./Sample/CERT/001권한용001_sig.key", "1111");
			
			//certPathValiditor.addTrustedRootCert(rootCert);
			certPathValiditor.setMyCert(myCert, myPrikey);
			
			long lTime = java.lang.System.currentTimeMillis();
			Date curTime = new Date(lTime);

			certPathValiditor.setValidationTime(curTime);
			certPathValiditor.setUserPolicySet("1.2.410.100001.2.2.1;1.2.410.200005.1.1.4;1.2.410.200012.1.1.1;1.2.410.200004.5.1.1.11;1.2.410.200004.5.2.1.2;1.2.410.200004.5.3.1.5;1.2.410.200004.5.4.1.2");
			
			System.out.println(" 2.1. GPKI");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/gpkiCert.cer");
			//certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL);
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_NONE);
			certPathValiditor.validate(CertPathValidator.CERT_SIGN, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
			
		try {
			System.out.println(" 2.2. NPKI (YesSign)");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/yessignCert.der");
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL);
			certPathValiditor.validate(CertPathValidator.CERT_SIGN, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}	
		
		try {
			System.out.println(" 2.3. NPKI (KTNet)");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/tradesignCert.der");
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL | CertPathValidator.REVOKE_CHECK_OCSP);
			certPathValiditor.validate(CertPathValidator.CERT_SIGN, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
		
		try {
			System.out.println(" 2.4. NPKI (SignKorea)");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/signkoreaCert.der");
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL | CertPathValidator.REVOKE_CHECK_OCSP);
			certPathValiditor.validate(CertPathValidator.CERT_SIGN, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
		
		try {
			System.out.println(" 2.5. NPKI (KICA)");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/kicaCert.der");
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL | CertPathValidator.REVOKE_CHECK_OCSP);
			certPathValiditor.validate(CertPathValidator.CERT_SIGN, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
		
		try {
			System.out.println(" 2.6. NPKI (CrossCert)");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/crossCert.der");
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL | CertPathValidator.REVOKE_CHECK_OCSP);
			certPathValiditor.validate(CertPathValidator.CERT_KM, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}

		try {
			System.out.println(" 2.7. NPKI (NCaSign)");
			cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/ncasignCert.der");
			certPathValiditor.setRevokationCheck(CertPathValidator.REVOKE_CHECK_ARL | CertPathValidator.REVOKE_CHECK_CRL | CertPathValidator.REVOKE_CHECK_OCSP);
			certPathValiditor.validate(CertPathValidator.CERT_SIGN, cert);
			System.out.println("  OK...");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void verifyVID() {
		
		try {
			
			System.out.println("2. VerifyVID");
		
			X509Certificate cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/vidCert.der");
			PrivateKey prikey = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/vidPri.key", "88888888");
			
			byte[] random = null;
			
			random = prikey.getRandomForVID();
			cert.verifyVID("2098121464", random);

			System.out.println("  ... ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void checkStatus() {
		
		try {
			
			System.out.println("3. CheckStauts");
			
			X509Certificate cert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/vidCert.der");
			X509Certificate myCert = Disk.readCert("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/vidCert.der");
			PrivateKey myPriKey = Disk.readPriKey("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/vidPri.key", "88888888");
			
			OCSPRequest ocspRequest = new OCSPRequest();
			
			ocspRequest.setMyCert(myCert, myPriKey);
			byte[] reqMsg = ocspRequest.generateReqMsg(cert);
			
			Disk.write("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/ocspReqMsg.ber", reqMsg);
			
			byte[] resMsg;
			resMsg = Disk.read("C:/work/JSP_Project/iccsm/WEB-INF/src/sp/gpkisample/Sample/CERT/ocspResMsg.ber");
			
			OCSPResponse ocspResponse = new OCSPResponse(resMsg, ocspRequest);
			int stat = ocspResponse.getCertStatus();
			
			if (stat == OCSPResponse.CERT_STATUS_VALID)
				System.out.println("valid");
			else if (stat == OCSPResponse.CERT_STATUS_REVOKED)
				System.out.println("revoked");
			else if (stat == OCSPResponse.CERT_STATUS_HOLDED)
				System.out.println("holded");
			
			X509Certificate ocspCert = ocspResponse.getOcspSvrCert();
			
			System.out.println(ocspCert.getSubjectDN());
			
		} catch (Exception e) {
			e.printStackTrace();
			nErrCnt++;
		}
	}
}
