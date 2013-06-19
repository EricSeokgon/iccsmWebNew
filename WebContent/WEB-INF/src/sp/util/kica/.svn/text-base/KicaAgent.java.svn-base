package sp.util.kica;

import java.util.Date;


public class KicaAgent  {
	

    public void start() {

    	
    	KicaTask  task= new KicaTask(); 

        try {

	    	task.getKicaDB();			// WS -> TEMP 이관
        	task.getKicaDBProcess();	// TEMP -> 실테이블
				
	    	// 송신 주석처리
	    	//task.setKicaDB();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

    	
    	// 현재 시간 출력
    	  System.out.println("KicaAgent !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + new Date());
    	  
    	  
    }
  

}

		 

