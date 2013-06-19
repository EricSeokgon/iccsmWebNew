package kjf.ops;

import java.io.ByteArrayInputStream;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kjf.util.KJFDate;
import kjf.util.KJFLog;
import oracle.jdbc.driver.OracleResultSet;
import oracle.sql.CLOB;

/**
 * ReportDAO 
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
public class ReportDAO  extends SuperToDB {

    private HashMap inputArg = new HashMap();

    public  void  setValue(int i, Object in) throws Exception{
        inputArg.put(new Integer(i), in);
    }

    public  void  setValue(int i, double in) throws Exception{
        inputArg.put(new Integer(i), new Double(in));
    }

    public  void  setValue(int i, float in) throws Exception{
        inputArg.put(new Integer(i), new Float(in));
    }

    public  void  setValue(int i, int in) throws Exception{
        inputArg.put(new Integer(i), new Integer(in));
    }

    public  void  setValue(int i, long in) throws Exception{
        inputArg.put(new Integer(i), new Long(in));
    }

    /**
     * 임의의 쿼리를 수행한다.
     * @param sql String
     * @return int
     * @throws SQLException
     */
    public int execute(String sql) throws SQLException {
        KJFLog.sql(sql);

        Connection conn = null;
        PreparedStatement  ps  =null;
        ResultSet rs = null;
        
        int result =0;
        
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);
            
            
            if (!inputArg.isEmpty()){
                for (int i=1;i <= inputArg.size(); i++){
                    if(inputArg.get(new Integer(i)) instanceof Double )
                        ps.setDouble(i , ((Double)inputArg.get(new Integer(i))).doubleValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Float )
                        ps.setFloat(i , ((Float)inputArg.get(new Integer(i))).floatValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Integer )
                        ps.setInt(i , ((Integer)inputArg.get(new Integer(i))).intValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Long )
                        ps.setLong(i , ((Long)inputArg.get(new Integer(i))).longValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof java.sql.Date  )
                        ps.setDate(i , (java.sql.Date)inputArg.get(new Integer(i)));
                    else
                        ps.setString(i , (String)inputArg.get(new Integer(i)));
                }
            }
            
            result = ps.executeUpdate();
        
       } catch (SQLException e) {
           System.out.println(e);
           throw e;
           
       } finally {
           if(rs!=null) rs.close();
           if(ps!=null) ps.close();
           this.release(conn);
       }
       
       return result;//Update나 Insert된  row 수
    }


    /**
     * 쿼리를 수행한다
     * 
     * @param sql String
     * @return ReportEntity
     * @throws SQLException
     */
    public ReportEntity select(String sql) throws SQLException {

        KJFLog.sql(sql);
    
        ReportEntity entity = null;
    
        Connection conn = null;
        PreparedStatement  ps  =null;
        ResultSet rs = null;
    
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);
    
            if (!inputArg.isEmpty()){
                for (int i=1;i <= inputArg.size(); i++){
                    if(inputArg.get(new Integer(i)) instanceof Double )
                        ps.setDouble(i , ((Double)inputArg.get(new Integer(i))).doubleValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Float )
                        ps.setFloat(i , ((Float)inputArg.get(new Integer(i))).floatValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Integer )
                        ps.setInt(i , ((Integer)inputArg.get(new Integer(i))).intValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Long )
                        ps.setLong(i , ((Long)inputArg.get(new Integer(i))).longValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof java.sql.Date  )
                        ps.setDate(i , (java.sql.Date)inputArg.get(new Integer(i)));
                    else
                        ps.setString(i , (String)inputArg.get(new Integer(i)));
                }
            }
    
            rs = ps.executeQuery();
    
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            int typeList[] = new int[columnCnt];
    
            entity = new ReportEntity();
    
            for(int col = 1; col <=columnCnt; col++){
                entity.addName(rsmd.getColumnLabel(col));
                entity.addType(rsmd.getColumnTypeName(col));
                typeList[col -1]  = rsmd.getColumnType(col);
            }
    
            while(rs.next()){
                List row = new ArrayList();
                for(int col=1;col<=columnCnt;col++){
                    if(typeList[col-1] == java.sql.Types.DATE ){
                        row.add(KJFDate.date(rs.getDate(col)));
                    } else if(typeList[col-1] == java.sql.Types.BLOB ){
                        row.add(rs.getBlob(col));
                    }else{
                           row.add(rs.getString(col));
                    }
                }
                entity.addRow(row);
            }    
    
       } catch (SQLException e) {
           System.out.println(e);
           throw e;
           
       } finally {
    
         if(rs!=null)
             rs.close();
         if(ps!=null)
             ps.close();
    
         this.release(conn);
       }

       return entity;
    }


    /**
     * 쿼리를 수행한다
     * @param sql      String
     * @param pageNum  int
     * @param pageSize int
     * @return ReportEntity
     * @throws SQLException
     */
    public ReportEntity select(String sql, int pageNum, int pageSize) throws SQLException {
        if(db_type ==0 || db_type == 3 ){ //oracle 8i 이상, my-sql
            return select_page_query( sql,  pageNum,  pageSize);
        } else {
            return select_page( sql,  pageNum,  pageSize);
        }
    }


    /**
     * 쿼리를 수행한다
     * @param sql    String
     * @param topCnt int
     * @return ReportEntity
     * @throws SQLException
     */
    public ReportEntity select(String sql, int topCnt) throws SQLException {
        if(db_type ==0 || db_type == 3 ){ //oracle 8i 이상, my-sql
            String nSql =
                "SELECT * FROM (SELECT ROWNUM RNUM, TAB.* FROM( "+
                sql + ") TAB ) WHERE RNUM <= "+topCnt;

            return select( nSql);
        } else {
            String nSql = sql.replaceFirst("select", "SELECT");
            return select( nSql.replaceFirst("SELECT", "SELECT TOP "+topCnt));
        }
    }

    
    /**
     * 페이지 쿼리를 쓸수 없을경우 쓴다.
     * @param sql
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public ReportEntity select_page(String sql, int pageNum, int pageSize) throws SQLException {
        
        if(pageNum < 1 ){
            KJFLog.log("Invalid PageNum");
            throw new SQLException("Invalid PageNum") ;
        }
    
        KJFLog.sql(sql);
        
        ReportEntity entity = null;    
        Connection conn = null;
        PreparedStatement  ps  =null;
        ResultSet rs = null;    
    
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);
        
            rs = ps.executeQuery();
    
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnCnt = rsmd.getColumnCount();
            int typeList[] = new int[columnCnt];
    
            entity = new ReportEntity();
    
            for(int col = 1; col <=columnCnt; col++){
                entity.addName(rsmd.getColumnLabel(col));
                entity.addType(rsmd.getColumnTypeName(col));
                typeList[col -1]  = rsmd.getColumnType(col);
            }
    
            //시작 및 끝 RowNO
            int startRowNO = (pageNum * pageSize) - (pageSize - 1);
            int endRowNO = pageNum * pageSize;
    
    
            while (rs.next()) {
    
                if (rs.getRow() >= startRowNO) {
                    List row = new ArrayList();
                    for(int col=1;col<=columnCnt;col++){
                        if(typeList[col-1] == java.sql.Types.DATE )
                            row.add(KJFDate.date(rs.getDate(col)));
                        else if(typeList[col-1] == java.sql.Types.BLOB )
                            row.add(rs.getBytes(col));
                        else
                            row.add(rs.getString(col));
                    }
        
                    entity.addRow(row);
                }
                if (rs.getRow() == endRowNO) {
                    break;
                }
            }    
    
       } catch (SQLException e) {
           KJFLog.log("ReportDAO.select error", e.toString() );
           throw e;
           
       } finally {
           if(rs !=null)
               rs.close();
           if(ps !=null)
               ps.close();
           
           this.release(conn);
       }
    
       return entity;    
    }
     

     /**
      * Oralce인 경우는 이것을 사용해야 한다.   
      * @param sql      String
      * @param pageNum  int
      * @param pageSize int
      * @return ReportEntity
      * @throws SQLException
      */
     public ReportEntity select_page_query(String sql, int pageNum, int pageSize) throws SQLException {
    
        KJFLog.sql(sql);
    
        ReportEntity entity = null;
    
        Connection conn = null;
        PreparedStatement  ps  =null;
        ResultSet rs = null;    
    
        try {
            conn = this.getConnection();
           
            ps = conn.prepareStatement(getPageQuery(sql, pageNum, pageSize ));
        
            if (!inputArg.isEmpty()){
                for (int i=1;i <= inputArg.size(); i++){
                    if(inputArg.get(new Integer(i)) instanceof Double )
                        ps.setDouble(i , ((Double)inputArg.get(new Integer(i))).doubleValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Float )
                        ps.setFloat(i , ((Float)inputArg.get(new Integer(i))).floatValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Integer )
                        ps.setInt(i , ((Integer)inputArg.get(new Integer(i))).intValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof Long )
                        ps.setLong(i , ((Long)inputArg.get(new Integer(i))).longValue()  );
                    else if(inputArg.get(new Integer(i)) instanceof java.sql.Date  )
                        ps.setDate(i , (java.sql.Date)inputArg.get(new Integer(i)));
                    else
                        ps.setString(i , (String)inputArg.get(new Integer(i)));
                }
            }
        
            rs = ps.executeQuery();
    
            ResultSetMetaData rsmd = rs.getMetaData();
        
            int columnCnt = rsmd.getColumnCount();
            int typeList[] = new int[columnCnt];
    
            entity = new ReportEntity();
    
            for(int col = 1; col <=columnCnt; col++){
                entity.addName(rsmd.getColumnLabel(col));
                entity.addType(rsmd.getColumnTypeName(col));
                typeList[col -1]  = rsmd.getColumnType(col);
            }
    
            /////////////////////////////////////////////////////////////////
            //  해당 페이지로 이동한다.
            //    Orace에서는 필요 없다.
            /////////////////////////////////////////////////////////////////
        
            int cnt = 0;
            while(rs.next()){
               /////////////////////////////////////////////////////////////////
               //지정한 Page Size만큼만 읽어 온다.
               // Oracle에서는 핑요없다.
               /////////////////////////////////////////////////////////////////
                List row = new ArrayList();
                for(int col=1;col<=columnCnt;col++){
                    if(typeList[col-1] == java.sql.Types.DATE )
                        row.add(KJFDate.date(rs.getDate(col)));
                    else if(typeList[col-1] == java.sql.Types.BLOB )
                        row.add(rs.getBlob(col));
                    else
                        row.add(rs.getString(col));
                }
                entity.addRow(row);
            }
    
       } catch (SQLException e) {
           KJFLog.log("ReportDAO.select error", e.toString() );
           throw e;
           
       } finally {
           if(rs !=null)
               rs.close();
           if(ps !=null)
               ps.close();
           this.release(conn);
       }
    
       return entity;
    }


     /**
      * Clob 데이타를 수행한다.
      * 
      * @param sql  String
      * @param data String
      * @return int 
      * @throws SQLException
      */
     public int executeClob(String sql, String data) throws SQLException {
         KJFLog.sql(sql);

         Connection conn = null;
         PreparedStatement  ps  =null;
         ResultSet rs = null;
         
         int result =0;
         
         try {
             conn = this.getConnection();
             ps = conn.prepareStatement(sql);

             CLOB cb = null;

             rs = ps.executeQuery();;

             if (rs.next()){
                 cb = ((OracleResultSet)rs).getCLOB (1);
             }

             long pos = 0; // CLOB 데이타가 insert되는 위치의 offset값을 나타낸다.

             if(cb==null){
                 pos=1;
             } else {
                 pos = cb.length()+1;
             }

             // CLOB.putString이 buf에 담긴 데이타를 해당 CLOB 컬럼에 update하는
             // 작업을 하게 된다.
             cb.putString(pos, data);

         } catch (SQLException e) {
             System.out.println(e);
             throw e;
             
         } finally {
             if(rs!=null) rs.close();
             if(ps!=null) ps.close();
             this.release(conn);
         }
         
         return result;//Update나 Insert된  row 수
     }


    /**
     * Blob 데이타를 수행한다.
     * 
     * @param sql  String
     * @param data byte[]
     * @param size int
     * @return int
     * @throws SQLException
     */
    public int executeBlob(String sql, byte[] data, int size) throws SQLException {
        KJFLog.sql(sql);

        Connection conn = null;
        PreparedStatement  ps  =null;
        ResultSet rs = null;
        
        int result =0;
        
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);

            ByteArrayInputStream bas = new ByteArrayInputStream(data);

            ps.setBinaryStream(1, bas, size );

            rs = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
            
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            this.release(conn);
        }
        
        return result;//Update나 Insert된  row 수
    }


    /**
     * Blob 데이타의 한 필드를 가져 온다.
     * 
     * @param sql String
     * @return byte[]
     * @throws SQLException
     */
    public  byte[]  slectBlob(String sql) throws SQLException {
        KJFLog.sql(sql);

        Connection conn = null;
        PreparedStatement  ps  =null;
        ResultSet rs = null;

        byte[] lb = null;

        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();;

            if (rs.next()){
                lb =  rs.getBytes(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
            
        } finally {
            if(rs!=null)         rs.close();
            if(ps!=null)       ps.close();
            this.release(conn);
        }
        
        return lb;
    }
    
    
    /**
     * batch 쿼리를 수행한다.
     * @param sql
     * @return
     * @throws SQLException
     */
    public int[] batchUpdate(String[] sqls) throws SQLException {
       // KJFLog.sql(sql);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        int result[] =null;
        
        try {
            conn = this.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            
            for(int i=0;i< sqls.length ;i++ ){
            	stmt.addBatch(sqls[i]);
            }
            
            

            
            result = stmt.executeBatch();
            
        
       }  catch(BatchUpdateException b) {
           System.err.println("SQLException: " + b.getMessage());
           System.err.println("SQLState: " + b.getSQLState());
           System.err.println("Message: " + b.getMessage());
           System.err.println("Vendor error code: " + b.getErrorCode());
           System.err.print("Update counts: ");
           int [] updateCounts = b.getUpdateCounts();
           for (int i = 0; i < updateCounts.length; i++) {
               System.err.print(updateCounts[i] + " ");
           }
           throw b;
       }catch (SQLException e) {
           System.out.println(e);
           throw e;
           
       } finally {
           if(rs!=null) rs.close();
           if(stmt!=null) stmt.close();
           this.release(conn);
       }
       
       return result;//Update나 Insert된  row 수
    }    
    
}
