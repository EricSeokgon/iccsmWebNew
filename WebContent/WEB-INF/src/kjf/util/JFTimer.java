package kjf.util;

/**
 * <p>Title         : Ÿ�� ��ƿ�Լ� </p>
 * <p>Description   : Ÿ�� ��ƿ�Լ��� �����Ͽ� ����. </p>
 * @author ���ν�
 * @version 1.0
 */
public class JFTimer{

    private long curTime;
	private boolean stopFlag = false;

	public void start(){
		curTime = System.currentTimeMillis();
		stopFlag = false;
	}
	
    public long stop(){
		if(stopFlag == false){
		   curTime = System.currentTimeMillis() - curTime;
		   stopFlag = true;
		}
		return curTime;
	}

    public long period(){
		return stop();
	}

};


