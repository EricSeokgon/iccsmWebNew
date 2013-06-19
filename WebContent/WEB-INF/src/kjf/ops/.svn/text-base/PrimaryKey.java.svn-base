package kjf.ops;

import java.io.Serializable;

/**
 * ValueObject에 대한 PrimaryKey 표현할 때 사용한다.
 * ValueObject의 getPrimaryKey()를 호출하여 생성하는 것이 일반적이다.<br>
 * 주의)prifix는 각 ValueObject를 구분하는 역활을 수행한다.
 *  
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
public class PrimaryKey implements Serializable {

    private String prefix;
    private Object keys[];

   /**
    * prifix와 keys을 받아 객체를 생성한다.
    * @param prefix
    * @param keys
    */
    public PrimaryKey(String prefix, Object[] keys){
	    this.prefix = prefix;
	    this.keys = keys;
    }                    

    /**
     * prifix를 리턴한다.
     * @return String
     */
    public String getPrefix() {
	    return this.prefix;
    }  

    /**
     * key 리스트를 리턴한다.
     * @return Object[]
     */
    public Object[] getKeys() {
	    return this.keys;
    }  


    /**
     * PrimaryKey Class의 hash Code를 리턴한다.
     * @return int
     */
    public int hashCode() {
	    StringBuffer stringKey = new StringBuffer(prefix);
	    for (int i = 0; i < keys.length; i++)
		    stringKey.append('@').append(keys[i]);

	    return stringKey.toString().hashCode();
    }
    
    /**
     * PrimaryKey들을 비교한다.
     * @return boolean
     */
    public boolean equals(Object newKey) {
	    if (this.hashCode() == newKey.hashCode())
		    return true;
	    return false;
    }

}