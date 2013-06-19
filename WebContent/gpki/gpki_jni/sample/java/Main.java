import com.gpki.gpkiapi.GpkiApi;

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
public class Main {

	public static void main(String[] args) {

		boolean bPrintLog = false;
		
		int nCertErr = 0;
		int nCryptoErr = 0;
		int nCmsErr = 0;
		int nIvsErr = 0;
		int nTsaErr = 0;
		int nUtilErr = 0;
		int nTotalErr = 0;

		System.out.println("-----------------------------------------");
		System.out.println("         gpkiapi (JAVA) Test\n");
		System.out.println("Copyright ¨Ï 2005-2006 DreamSecurity Co.,Ltd.");
		System.out.println("-----------------------------------------\n");

		try {
			GpkiApi.init(".");

			System.out.println("======================================");
			System.out.println("          [1] Crypto");
			System.out.println("======================================");

			Crypto crypto = new Crypto(bPrintLog);
			crypto.SymmetricKey();
			crypto.AsymmetricKey();
			crypto.Random();
			crypto.Mac();
			crypto.Hash();

			nCryptoErr = crypto.getErrCnt();

			System.out.println("======================================");
			System.out.println("          [2] Cert");
			System.out.println("======================================");

			Cert cert = new Cert();

			cert.view();
			cert.verify();
			cert.verifyVID();
			cert.checkStatus();

			nCertErr = cert.getErrCnt();
					
			System.out.println("======================================");
			System.out.println("          [3] CMS");
			System.out.println("======================================");

			Cms cms = new Cms(bPrintLog);
			cms.signData();
			cms.envData();
			cms.signedAndEnvData();
			cms.signedContent();
			cms.wapEnvData();

			nCmsErr = cms.getErrCnt();
			
			System.out.println("======================================");
			System.out.println("          [4] IVS");
			System.out.println("======================================");

			Ivs ivs = new Ivs();
			ivs.verify();
			ivs.identify();

			nIvsErr = ivs.getErrCnt();
			
			System.out.println("======================================");
			System.out.println("          [5] TSA");
			System.out.println("======================================");

			Tsa tsa = new Tsa();
			tsa.reqTimeStamp();

			nTsaErr = tsa.getErrCnt();

			System.out.println("======================================");
			System.out.println("          [6] Util");
			System.out.println("======================================");

			Util util = new Util();
			util.ldap();

			nUtilErr = util.getErrCnt();
			
			System.out.println("==============================================================");
			System.out.println("		          Error Count");
			System.out.println("==============================================================");

			nTotalErr = nCertErr + nCmsErr + nCryptoErr + nIvsErr + nTsaErr + nUtilErr;

			System.out.println("CERT    : " + nCertErr);
			System.out.println("CMS     : " + nCmsErr);
			System.out.println("CRYPTO  : " + nCryptoErr);
			System.out.println("IVS     : " + nIvsErr);
			System.out.println("TSA     : " + nTsaErr);
			System.out.println("UTIL    : " + nUtilErr);
			System.out.println("--------------------------------------------------------------");
			System.out.println("TOTAL   : " + nTotalErr);

			System.out.println("==============================================================");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
