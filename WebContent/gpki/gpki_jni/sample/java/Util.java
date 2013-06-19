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
			
			dataBuff = ldap.getData(Ldap.DATA_TYPE_SIGN_CERT, "ou=�ɻ�м�2��,ou=���������м���,ou=����������,o=Government of Korea,c=KR");
			
			System.out.println(" .. ok");
			
			System.out.println(" 1.2. Get data by attribute");
			
			dataBuff = ldap.getData("modifiersName", "ou=������ȹ��,ou=����,ou=����������,o=Government of Korea,c=KR");
			
			System.out.println(" .. ok");
			
			System.out.println(" 1.3. Get data by search cn");
			
			ldap.searchCN(Ldap.DATA_TYPE_GPKI_WCERT, "001�ӿ���001");
			
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
