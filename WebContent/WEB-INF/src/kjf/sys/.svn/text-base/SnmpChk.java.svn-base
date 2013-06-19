package kjf.sys;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SnmpChk {
	public SnmpChk(String arg) {
	    try {
	      // CPU 가용율
	      String sCPU_idle = getSNMPvalue(arg, "enterprises.ucdavis.systemStats.ssCpuIdle.0", "=");
	      float fCPU_idle = Float.valueOf(sCPU_idle).floatValue();
	      System.out.println("CPU idle: "+fCPU_idle+" %");
	    
	      // 메모리 가용율
	      String sMEM_tot   = getSNMPvalue(arg, "enterprises.ucdavis.memory.memTotalReal.0", "=");
	      String sMEM_avail = getSNMPvalue(arg, "enterprises.ucdavis.memory.memAvailReal.0", "=");
	      float fMEM_free = 100 * Float.valueOf(sMEM_avail).floatValue() / Float.valueOf(sMEM_tot).floatValue();
	      System.out.println("MEM free: "+fMEM_free+" %");

	      // 시스템 부하율
	      String sLoad_avg = getSNMPvalue(arg, "enterprises.ucdavis.laTable.laEntry.laLoad.1", "="); // 1분 시스템부하
	      float fLoad_avg = Float.valueOf(sLoad_avg).floatValue();
	      System.out.println("System load(1m avg.): "+fLoad_avg+" %");

	      // 네트워크 이용률 = 단위시간부하/네트워크 용량 * 100%
	      // OID 맨뒤의 ".2" 는 첫번째 NIC 를 나타냄, ".1" 은 loopback 
	      String sNET_bandwidth = getSNMPvalue(arg, "interfaces.ifTable.ifEntry.ifSpeed.2", ":");
	      float fNET_bandwidth = Float.valueOf(sNET_bandwidth).floatValue() / 1000; // byte 로 환산
	      String sNET_t1_in  = getSNMPvalue(arg, "interfaces.ifTable.ifEntry.ifInOctets.2", ":");
	      String sNET_t1_out = getSNMPvalue(arg, "interfaces.ifTable.ifEntry.ifOutOctets.2", ":");
	      float fNET_t1_tf = Float.valueOf(sNET_t1_in).floatValue() + Float.valueOf(sNET_t1_out).floatValue(); // recv+send traffic
	      java.lang.Thread.sleep(1000);
	      String sNET_t2_in  = getSNMPvalue(arg, "interfaces.ifTable.ifEntry.ifInOctets.2", ":");
	      String sNET_t2_out = getSNMPvalue(arg, "interfaces.ifTable.ifEntry.ifOutOctets.2", ":");
	      float fNET_t2_tf = Float.valueOf(sNET_t2_in).floatValue() + Float.valueOf(sNET_t2_out).floatValue();
	      float fNET_load = 100 * (fNET_t2_tf - fNET_t1_tf) / fNET_bandwidth;
	      System.out.println("NET load: "+fNET_load+" %");

	      // 시스템 가용율
	      float fHost_avail = Math.round(fCPU_idle / 100 * 20 +
	                                     fMEM_free / 100 * 20 +
	                                     (100 - fLoad_avg) / 100 * 20 +
	                                     (100 - fNET_load) / 100 * 40);
	      System.out.println("host avail: "+fHost_avail+" %");
	      
	    } catch (Exception e) {
	      System.out.println("Exception ::" + e);
	    }
	    
	  }
	  
	  public static String getSNMPvalue(String IP, String OID, String deli) {
	    Process p;
	    String val = null;
	    String s = "";
	    
	    try {
	      p = Runtime.getRuntime().exec("snmpwalk "+IP+" public "+OID); 
	      int exitVal = p.waitFor(); // 대기
	    } catch(Exception e ) {
	      return null;
	    }

	    BufferedInputStream buffer = new BufferedInputStream(p.getInputStream());
	    BufferedReader commandResult = new BufferedReader(new InputStreamReader(buffer));

	    try {
	      s = commandResult.readLine(); // stdout capture
	      int i = s.indexOf(deli);
	      if (i > -1) 
	        val = s.substring(i+2).trim(); 
	      commandResult.close();
	    } catch (Exception e) {
	      System.err.println("Exception ::" + e);
	    }

	    return val;
	  }
}
