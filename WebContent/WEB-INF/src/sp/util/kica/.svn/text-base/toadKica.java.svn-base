package sp.util.kica;

import java.util.Scanner;

import sp.webservice.UBAgentPortTypeProxy;

import kjf.util.KJFSec;
import kjf.util.KJFUtil;

public class toadKica {
	
	public static UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://211.34.100.185:8080/iccsWs/services/UBAgent");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true){
			System.out.println("종료: q");
			
			run(keyboard.nextLine());


			
		}

	}
	
	
	public static void   run(String order){
		
		if(order.equalsIgnoreCase("q")){
			System.exit(0);
		}	

		String od = KJFUtil.print(order.trim().toLowerCase());
		if(od.startsWith("select")){
			select(od);
			
		}else if(od.startsWith("update")||
				od.startsWith("insert")||
				od.startsWith("delete")
				){
			excute(od);
		} else{
			System.out.println("잘못된 입력:"+order);
		}
	
	}
	
	public static void   select(String sql){
		String resultFlag="0";
		String kica_data="";
    	String rt="";
    	sql = "select * from ("+sql+") where rownum < 201";

		try {

			String s_result[]=ub.select(KJFSec.encode("kica"), sql);
	    	resultFlag=s_result[0];
	    	kica_data=s_result[1];
	    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return;
		}
    	
    	//협회서버 오류일경우.
    	if(resultFlag.equals("0")  ){
        	rt="협회서버 오류:"+kica_data;
    	}else if(resultFlag.equals("1") && KJFUtil.isEmpty(kica_data)){
    		rt="데이타  없음";
    		
    	} else{
    		String rows[] =KJFUtil.str2strs(kica_data, "!#$");
    		
        	for(int i=0;i< rows.length ;i++ ){
        		//KJFUtil.str2strs를 쓰게 되면 공백일 경우 에러가 나기 때문에
        		System.out.println(rows[i]);
    		
        	}
    		
    	}	
    		
    	System.out.println(rt);
	};

	public static void   excute(String sql){
		
		try {
			
		   	String result= ub.excute(KJFSec.encode("kica"), sql);
	    	if(!result.equals("1")){
	    		throw new Exception("Kica 서버 오류 :"+ result);
	    	}	
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return;
		}
    	
 
		System.out.println("정상 실행 되었음!!");
	};	
	

}
