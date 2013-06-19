package kjf.ops;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import kjf.db.TX_MGR;

/**
 * 모든 DAO, PAO, SAO, GAO의 최상위 객체이다.
 * 
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
public abstract class SuperDAO {

    static public final int MIN =0;
    static public final int MID =1;
    static public final int MAX =2;

    private boolean isWorkWithTX=false;
    
    /**
     * Connection Pool로 부터 Connection을 얻어온다.
     * @return Connection
     * @throws SQLException
     */
    protected final Connection getConnection() throws SQLException {
         Connection conn =null;
    
         conn = TX_MGR.getConnection();
         if(conn != null){
             isWorkWithTX = true;
             return conn;
         }
         isWorkWithTX = false;
         conn = TX_MGR.dataSource.getConnection();
         return conn;

    }

    /**
     * Connection Pool로 Connection을 되돌려 준다.
     * @param conn Connection
     */
    protected final void release(Connection conn) {
       if(isWorkWithTX == false){
           try{
               conn.close();
           }catch(Exception e){
           }
       }
    }
  
    /**
     * 반드시 각 데이타베이스에 맞는 toDB를 구현하여야 한다.
     *  <pre>
     *  - 코드변환
     *  - ESC문자 처리
     *  - Date Type의 적절한 String 변환
     *  </pre>
     * @param in Object
     * @return String
     */
    abstract protected String toDB(Object in);

    /**
     * 다수의 조건값을 비교구문으로 생성한다.특히 field의 수가 하나인 경우는
     *  xxx in("xxx","xxx")로 생성하고 field수가 둘이상인 경우는 
     *  (yyy = "yyy" and yyy="yyy") or (yyy = "yyy" and yyy="yyy") 형태로 생성한다.
     * @param fields String[]
     * @param values Set
     * @return String
     */
    public String makeWhereGroup(String[] fields, Set values){

		if(fields==null || fields.length ==0) return "";
        switch(fields.length){
            case 0: return "";
            case 1: return makeInString(fields[0], values);
           default: return makeOrString(fields, values);
        } 
    }

    /**
     * field가 하나인경우의 Where절 생성 함수 이다.
     *  xxx in("xxx","xxx")로 생성
     * @param field String
     * @param values Set
     * @return String
     */
    protected String makeInString(String field, Set values) {
        StringBuffer inStr= new StringBuffer(field +" in (");
	    Iterator iKey = values.iterator();

	    if(iKey.hasNext()){
	      AlternateKey ak = (AlternateKey)iKey.next();
          Object o[]=ak.getKeys();
          inStr.append(toDB(o[0]));
	    }
	    while(iKey.hasNext()){
	      AlternateKey ak = (AlternateKey)iKey.next();
          Object o[]=ak.getKeys();
          inStr.append(","+toDB(o[0]));
	    }
        inStr.append(")");

        return "(" + inStr.toString() + ")";
     
    }

    /**
     * field가 둘 이상인경우의 Where절 생성 함수 이다.
     *  (yyy = "yyy" and yyy="yyy") or (yyy = "yyy" and yyy="yyy") 형태로 생성한다.
     * @param fields String[]
     * @param values Set
     * @return Set
     */
    protected String makeOrString(String[] fields, Set values) {
        
        StringBuffer inStr=null;
	    Iterator iKey = values.iterator();
	    
	    while(iKey.hasNext()){
	      AlternateKey ak = (AlternateKey)iKey.next();
          Object o[]=ak.getKeys();
          StringBuffer str = new StringBuffer("(");
          str.append( fields[0] + " = " +toDB(o[0]) ); 
          for(int i =1 ;i < o.length ; i++){
             str.append(" and " + fields[i] + " = " +toDB(o[i]) ); 
          }
          str.append(")");
          if(inStr == null)
             inStr = str;
          else
             inStr.append(" or " + str.toString());
	    }
	    
        return "(" + inStr.toString() + ")";     
    }

    /**
     * 반드시 재정의 되어야 한다.
     * @param obj ValueObject
     * @return int
     * @throws SQLException
     */
    public int delete(ValueObject obj) throws SQLException {
        throw new SQLException("You must override this function");
    }
    
    /**
     * 반드시 재정의 되어야 한다.
     * @param key PrimaryKey
     * @return ValueObject
     * @throws SQLException
     */
    public ValueObject getByPrimaryKey(PrimaryKey key)	throws SQLException{
        throw new SQLException("You must override this function");
    }

    /**
     * 반드시 재정의 되어야 한다.
     * @param obj ValueObject
     * @return int
     * @throws SQLException
     */
    public int insert(ValueObject obj) throws SQLException{
        throw new SQLException("You must override this function");
    }

    /**
     * 반드시 재정의 되어야 한다.
     * @param obj
     * @return
     * @throws SQLException
     */
    public int update(ValueObject obj) throws SQLException{
        throw new SQLException("You must override this function");
    }

    /**
     * 반드시 재정의 되어야 한다.
     * @param obj ValueObject
     * @param fields String[]
     * @return int
     * @throws SQLException
     */
    public  int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException {
        throw new SQLException("You must override this function");
    }

}