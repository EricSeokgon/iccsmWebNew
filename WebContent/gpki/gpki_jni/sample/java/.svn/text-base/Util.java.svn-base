import com.gpki.gpkiapi.util.Ldap;

/*
 * Created on 2006. 5. 31.
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
public class Util {

	private int nErrCnt = 0;
	
	public int getErrCnt() {
		return nErrCnt;
	}
	
	public void ldap() {
		
		byte[] dataBuff = null;
		String strBuff = "";
		
		try {
			System.out.println("1. LDAP");
			
			Ldap ldap = new Ldap();
		
			ldap.setLdap("ldap.gcc.go.kr", 389);
			
			System.out.println(" 1.1. Get data by type");
			
			dataBuff = ldap.getData(Ldap.DATA_TYPE_SIGN_CERT, "ou=심사분석2과,ou=금융정보분석원,ou=재정경제부,o=Government of Korea,c=KR");
			
			System.out.println(" .. ok");
			
			System.out.println(" 1.2. Get data by attribute");
			
			dataBuff = ldap.getData("modifiersName", "ou=재정기획과,ou=국고국,ou=재정경제부,o=Government of Korea,c=KR");
			
			System.out.println(" .. ok");
			
			System.out.println(" 1.3. Get data by search cn");
			
			ldap.searchCN(Ldap.DATA_TYPE_GPKI_WCERT, "001임영란001");
			
			strBuff = ldap.getDN();
			System.out.println("FullDN = " + strBuff);
			
			dataBuff = ldap.getData();
			
			System.out.println(" .. ok");
			
		} catch (Exception e) {

			e.printStackTrace();
			nErrCnt++;
		}
	}
}
