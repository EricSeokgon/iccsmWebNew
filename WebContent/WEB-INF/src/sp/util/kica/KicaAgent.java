package sp.util.kica;

import java.util.Date;


public class KicaAgent  {
	

    public void start() {

    	
    	KicaTask  task= new KicaTask(); 

        try {

	    	task.getKicaDB();			// WS -> TEMP �̰�
        	task.getKicaDBProcess();	// TEMP -> �����̺�
				
	    	// �۽� �ּ�ó��
	    	//task.setKicaDB();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

    	
    	// ���� �ð� ���
    	  System.out.println("KicaAgent !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + new Date());
    	  
    	  
    }
  

}

		 

