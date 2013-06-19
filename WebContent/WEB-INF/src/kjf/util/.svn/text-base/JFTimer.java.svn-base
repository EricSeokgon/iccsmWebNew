package kjf.util;

/**
 * <p>Title         : 타임 유틸함수 </p>
 * <p>Description   : 타임 유틸함수를 구현하여 제공. </p>
 * @author 오두식
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


