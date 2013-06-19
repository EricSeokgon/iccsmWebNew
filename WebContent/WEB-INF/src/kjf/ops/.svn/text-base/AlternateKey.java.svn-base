package kjf.ops;

import java.io.Serializable;

/**
 * ValueObject에 대한 PrimaryKey 표현할 때 사용한다.
 * ValueObject의 getAlternateKey(String[] keys)를 호출하여 생성하는 것이 일반적이다.
 *  
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
public class AlternateKey implements Serializable {

   private Object keys[];

   /**
    * Key 값을 받아 Class가 인스턴스화된다. 
    * @param keys
    */
   public AlternateKey(Object[] keys){
       this.keys = keys;
   }                    

   /**
    * 키값 리스트를 리턴한다.
    * @return Object[]
    */
   public Object[] getKeys() {
      return this.keys;
   }  

   
   /**
    * 값을 기준으로 HashCode를 생성하도록 재정의 하였다.따라서 hashtable이나 HashSet등에서
    * 사용될때 동일한 값을 갖는 AlternateKey는 동일한 객체로 인식한다.
    * @return int
    */
   public int hashCode() {
      StringBuffer stringKey = new StringBuffer();
      
      for (int i = 0; i < keys.length; i++)
	     stringKey.append('@').append(keys[i]);

      return stringKey.toString().hashCode();
   }
    
   /**
    * 값을 기준으로 비교연산을 수행한다.
    * @return boolean
    */
   public boolean equals(Object newKey) {
       if((newKey instanceof AlternateKey) == false)
           return false;
       
       Object[] newKeyList =  ((AlternateKey)newKey).getKeys();
       
       for(int i =0; i < keys.length; i++)
           if (keys[i].equals(newKeyList[i]) == false)
               return false;
    
       return true;
   }

}