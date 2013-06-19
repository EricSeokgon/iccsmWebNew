package kjf.db;

import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kjf.cfg.Config;
import kjf.util.JFTimer;
import kjf.util.KJFLog;

/**
 * <p>Subsystem   : TX_MGR </P>
 * <p>Title       : TX_MGR </p>
 * <p>Description : 오라클 10g에서 clob 일반 처럼</p>
 * <p>관련 TABLE  :
 * @author 오두식
 * @version 1.0 2007.07
 */
public class TX_MGR{

    static ThreadLocal txMap = new ThreadLocal();
    static ThreadLocal trMap = new ThreadLocal();

//   static public JFDataSource jdataSource  =  new JFDataSource();
    
//    private static Hashtable dataSourceCache = null;
    
    public static  DataSource dataSource ;

    static {
        try {
        	
        	// 	Tomcat용 DB 사용시
        	Context initCtx = new InitialContext();
        	Context envCtx = (Context) initCtx.lookup("java:comp/env");    
        	dataSource = (DataSource) envCtx.lookup(Config.props.get("RESOURCE_NAME"));
        	 
        	//	Jeus용 DB 사용시
        	//InitialContext ctx = new InitialContext(); 
        	//dataSource = (DataSource)ctx.lookup("iccsdb");
//        	
//            jdataSource.setAutoCommit(false); // True 로 하면 AutoCommit 된다.
//            jdataSource.setDescription("DB Connection Pool");
//            jdataSource.setDriverClass(Config.props.get("DB_DRIVER"));
//            jdataSource.setMaxCount(Config.props.getInt("DB_MAX"));
//            jdataSource.setMinCount(Config.props.getInt("DB_MIN"));
//			jdataSource.setUser(Config.props.get("DB_USER"));
//            jdataSource.setPassword(Config.props.get("DB_PASSWORD"));
//            jdataSource.setUrl(Config.props.get("DB_URL"));
//
//            //오라클 10g 일 경우에 사용 가능 Clob 처리 용
//            if("0".equals(Config.props.get("DB_TYPE"))){
//            	jdataSource.addProperty("SetBigStringTryClob", "true");
//            }
//
//			jdataSource.open();
        	
     
        	
        	
         } catch (Exception e) {
            KJFLog.log("DataSource can't init : "+e);

         }
    }
    
    /**
     * 수정  업무 구분에 따른 다른  DB Connection 처리는 추후에 처리한다.
     * 
     * @param bizName
     * @throws Exception
     */
    static public void begin( String  bizName ) throws Exception {
        
            try {
                KJFLog.info("TX_BEGIN");
                
                Connection jdc = dataSource.getConnection();
                
                jdc.setAutoCommit(false);
                
                if(jdc ==null)
                    throw new Exception("TX_BEGIN error");

                txMap.set(jdc);
                JFTimer tr = new JFTimer();
                
                tr.start();
                trMap.set(tr);
                
            } catch(Exception e) {
                
                KJFLog.log(bizName, e.getMessage());
                throw e;
            }
    }
    
    /**
     * DB커넥션
     * @return
     */
    static public Connection getConnection() {
            return (Connection)txMap.get();
    }
    
    /**
     * 강제로 커밋시킴 
     */
    static public void commit() {
        
        JFTimer tr= (JFTimer) trMap.get();
        trMap.set(null);
        
        if(tr !=null) KJFLog.info("TX_COMMIT "+tr.stop());
        else          KJFLog.info("TX_COMMIT ???");

        try {
          Connection jdc =(Connection)txMap.get();
          
          if(jdc!=null){
             jdc.commit();								//	(강제로 커밋시킴)
             jdc.close();
             KJFLog.log("Connection Closed");
          }
          
        } catch(Exception e) {
             KJFLog.log("error",e.getMessage());
             
        } finally {
            txMap.set(null);
        }

    }
    
    /**
     * 강제로 롤백시킴 
     */
    static public void rollback() {
        
        JFTimer tr= (JFTimer) trMap.get();
        trMap.set(null);
        
        if(tr !=null) KJFLog.info("TX_ROLLBACK "+tr.stop());
        else          KJFLog.info("TX_ROLLBACK ???");

        try {
         Connection jdc =(Connection)txMap.get();
         
          if(jdc!=null){
             jdc.rollback();							// (강제로 롤백시킴)
             jdc.close();
          }
          
        } catch(Exception e) {
             KJFLog.log("error", e.getMessage());
             
        } finally {
            txMap.set(null);
        }
    }

};


