
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.ivs.*;
import com.gpki.gpkiapi.storage.Disk;

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
public class Ivs {

	private int nErrCnt = 0;
	
	public int getErrCnt() {
		return nErrCnt;
	}
	
	void verify() {
		
		byte[] bBuf = null;
		try {
			
			System.out.println("1. Verify Cert");
			
			X509Certificate myCert = Disk.readCert("./Sample/IVS/myCert.der");
			X509Certificate cert = Disk.readCert("./Sample/IVS/cert.der");
			
			VerifyCert verifyCert = new VerifyCert("./Sample/IVS/gpkiapi.conf");
			
			verifyCert.setMyCert(myCert);
			verifyCert.verify(cert);
			
			System.out.println(" ... ok");
									
		} catch (Exception e) {
			
			e.printStackTrace();
			nErrCnt++;
		}
	}
	
	void identify() {
		
		try {
			
			byte[] random = null;
			System.out.println("2. Identify User");
			
			X509Certificate myCert = Disk.readCert("./Sample/IVS/myCert.der");
			X509Certificate cert = Disk.readCert("./Sample/IVS/cert.der");
			
			IdentifyUser verifyCert = new IdentifyUser("./Sample/IVS/gpkiapi.conf");
			
			verifyCert.setMyCert(myCert);
			verifyCert.identify("7777770000001", random, cert);
			
			System.out.println(" ... ok");
									
		} catch (Exception e) {
			
			e.printStackTrace();
			nErrCnt++;
		}
	}
}
