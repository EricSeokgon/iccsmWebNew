
package kjf.db;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Savepoint;
import java.util.Map;
import javax.sql.DataSource;


/**
 * Generic wrapper implementation of a <strong>Connection</strong> that
 * works with <code>JFDataSource</code> to wrap connections for any
 * JDBC driver.
 *
 * @author Craig R. McClanahan
 * @author Ted Husted
 * @version $Revision: 1.2 $ $Date: 2011/01/04 08:27:22 $
 */
public class JFConnection implements Connection {


    /**
     * Construct a new GenericConnection wrapping the specified connection.
     *
     * @param source The data source that owns this connection
     * @param conn The connection to wrap
     * @param autoCommit Desired auto-commit state for this connection
     * @param readOnly Desired read-only state for this connection
     *
     * @exception SQLException if an SQL processing error occurs
     */
    public JFConnection(JFDataSource source, Connection conn,
                             boolean autoCommit, boolean readOnly)
        throws SQLException {

        super();
        this.source = source;
        this.conn = conn;

        this.autoCommit = autoCommit;
        this.catalog = conn.getCatalog();
        this.level = conn.getTransactionIsolation();
        try {
            this.map = conn.getTypeMap();
        } catch (SQLException e) {
            ;   // PostgreSQL throws a "not yet implemented" exception
        } catch (UnsupportedOperationException e) {
            ;   // JDBC-ODBC bridge throws this
        } catch (AbstractMethodError e) {
            ;   // mm.mysql throws this
        }
	this.readOnly = readOnly;
        this.conn.setAutoCommit(this.autoCommit);
	try {
	    this.conn.setReadOnly(this.readOnly);
	} catch (SQLException e) {
	    ;  // Informix throws a "not supported" exception
	}


    }


    // ----------------------------------------------------- Instance Constants


    private final static String SQLEXCEPTION_CLOSED = "Connection was closed.";


    // ----------------------------------------------------- Instance Variables


    /**
     * The initial auto-commit state to which we should return after release.
     */
    protected boolean autoCommit = false;


    /**
     * The initial catalog to which we should return after release.
     */
    protected String catalog = null;


    /**
     * The closed flag for this wrapped connection.
     */
    private boolean closed = false;


    /**
     * The Connection that is being wrapped.
     */
    protected Connection conn = null;


    /**
     * The initial transaction isolation level to which we should return
     * after release.
     */
    protected int level = 0;


    /**
     * The initial type map to which we should return after release.
     */
    protected Map map = null;


    /**
     * The initial read-only state to which we should return after release.
     */
    protected boolean readOnly = false;


    /**
     * The JFDataSource that owns this connection.
     */
    protected JFDataSource source = null;


    // --------------------------------------------------------- Public Methods


    /**
     * Clear all warnings reported for this Connection.
     *
     * @exception SQLException if a database access error occurs
     */
    public void clearWarnings() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.clearWarnings();
    }

    /**
     * Return this wrapped Connection to our data source connection pool.
     *
     * @exception SQLException if a database access error occurs
     */
    public void close() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        // Clean up any outstanding transaction as best we can
        try {
            conn.rollback();
        } catch (SQLException e) {
            ;
        }
        try {
            conn.setAutoCommit(this.autoCommit);
        } catch (SQLException e) {
            ;
        }
        try {
            conn.setCatalog(this.catalog);
        } catch (SQLException e) {
            ;
        }
        try {
            conn.setTransactionIsolation(this.level);
        } catch (SQLException e) {
            ;
        }
        try {
            conn.setTypeMap(this.map);
        } catch (SQLException e) {
            ;   // PostgreSQL throws a "not yet implemented" exception
        } catch (UnsupportedOperationException e) {
            ;   // JDBC-ODBC driver throws this
        } catch (AbstractMethodError e) {
            ;   // mm.mysql throws this
        }
        try {
            conn.setReadOnly(this.readOnly);
        } catch (SQLException e) {
            ;   // Informix throws a "not supported" exception
        }
        try {
            conn.clearWarnings();
        } catch (SQLException e) {
            ;
        }

        // Flag that this connection is closed
        // All methods accessing conn will now throw SQLEXCEPTION_CLOSED
        closed = true;

        // Return this connection to the available connection pool
        source.returnConnection(this);

    }

    /**
     * Make all changes made since the previous commit or rollback
     * permanent, and releases any database locks currently held.
     *
     * @exception SQLException if a database access error occurs
     */
    public void commit() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.commit();
    }

    /**
     * Create a <code>Statement</code> for sending SQL statements to the
     * database.
     *
     * @exception SQLException if a database access error occurs
     */
    public Statement createStatement() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.createStatement());

    }

    /**
     * (JDBC 2.0) Create a Statement that will create a ResultSet of the
     * specified type and concurrency.
     *
     * @param resultSetType A result set type
     * @param resultSetConcurrency A result set concurrency
     *
     * @exception SQLException if a database access error occurs
     */
    public Statement createStatement(int resultSetType,
                                     int resultSetConcurrency)
        throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.createStatement(resultSetType, resultSetConcurrency));

    }

    /**
     * Return the current auto-commit state.
     *
     * @exception SQLException if a database access error occurs
     */
    public boolean getAutoCommit() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.getAutoCommit());
    }

    /**
     * Return the current catalog name for this Connection.
     *
     * @exception SQLException if a database access error occurs
     */
    public String getCatalog() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.getCatalog());
    }


    /**
     * Get the metadata regarding this connection's database.
     *
     * @exception SQLException if a database access error occurs
     */
    public DatabaseMetaData getMetaData() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.getMetaData());
    }


    /**
     * Return this Connection's current transaction isolation level.
     *
     * @exception SQLException if a database access error occurs
     */
    public int getTransactionIsolation() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.getTransactionIsolation());
    }


    /**
     * (JDBC 2.0) Return the type map for this connection.
     *
     * @exception SQLException if a database access error occurs
     */
    public Map getTypeMap() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.getTypeMap());
    }

    /**
     * Return the first warning reported by calls to this Connection.
     *
     * @exception SQLException if a database access error occurs
     */
    public SQLWarning getWarnings() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.getWarnings());
    }


    /**
     * Return <code>true</code> if this Connection is closed.
     *
     * The GenericConnection.isClosed() method is only guaranteed to return true after
     * GenericConnection.closed() has been called. This method cannot be called, in
     * general, to determine if a database connection is valid or invalid.
     *
     * A typical JDBC client can determine that a connection is invalid by catching the
     * exception that is thrown when a JDBC operation is attempted.
     *
     * @exception SQLException if a database access error occurs
     */
    public boolean isClosed() throws SQLException {
        return (closed);
    }


    /**
     * Return <code>true</code> if this Connection is in read-only mode.
     *
     * @exception SQLException if a database access error occurs
     */
    public boolean isReadOnly() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.isReadOnly());
    }


    /**
     * Convert the given SQL statement into the system's native SQL grammer.
     *
     * @param sql Statement to be processed
     */
    public String nativeSQL(String sql) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.nativeSQL(sql));
    }


    /**
     * Create a <code>CallableStatement</code> object for calling database
     * stored procedures.
     *
     * @param sql Statement to be processed
     *
     * @exception SQLException if a database access error occurs
     */
    public CallableStatement prepareCall(String sql) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.prepareCall(sql));
    }


    /**
     * (JDBC 2.0) Create a CallableStatement object that will generate
     * ResultSet objects with the given type and concurrency.
     *
     * @param sql Statement to be processed
     * @param resultSetType A result set type
     * @param resultSetConcurrency A result set concurrency
     *
     * @exception SQLException if a database access error occurs
     */
    public CallableStatement prepareCall(String sql, int resultSetType,
                                         int resultSetConcurrency)
        throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.prepareCall(sql, resultSetType, resultSetConcurrency));
    }


    /**
     * Create a <code>PreparedStatement</code> object for sending
     * parameterized SQL statements to the database.
     *
     * @param sql Statement to be processed
     *
     * @exception SQLException if a database access error occurs
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.prepareStatement(sql));
    }


    /**
     * (JDBC 2.0) Create a PreparedStatement object that will generate
     * ResultSet objects with the given type and concurrency.
     *
     * @param sql Statement to be processed
     * @param resultSetType A result set type
     * @param resultSetConcurrency A result set concurrency
     *
     * @exception SQLException if a database access error occurs
     */
    public PreparedStatement prepareStatement(String sql, int resultSetType,
                                              int resultSetConcurrency)
        throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        return (conn.prepareStatement(sql, resultSetType,
                                      resultSetConcurrency));
    }


    /**
     * Drop all changes made since the previous commit or rollback.
     *
     * @exception SQLException if a database access error occurs
     */
    public void rollback() throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.rollback();

    }


    /**
     * Sets this connection's auto-commit mode.
     *
     * @param autoCommit The new auto-commit mode.
     *
     * @exception SQLException if a database access error occurs
     */
    public void setAutoCommit(boolean autoCommit) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.setAutoCommit(autoCommit);
    }


    /**
     * Set the catalog name for this Connection.
     *
     * @param catalog The new catalog name
     *
     * @exception SQLException if a database access error occurs
     */
    public void setCatalog(String catalog) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.setCatalog(catalog);
    }


    /**
     * Set the read-only mode of this connection.
     *
     * @param readOnly The new read-only mode
     *
     * @exception SQLException if a database access error occurs
     */
    public void setReadOnly(boolean readOnly) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.setReadOnly(readOnly);
    }


    /**
     * Set the transaction isolation level for this Connection.
     *
     * @param level The new transaction isolation level
     *
     * @exception SQLException if a database access error occurs
     */
    public void setTransactionIsolation(int level) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.setTransactionIsolation(level);
    }


    /**
     * (JDBC 2.0) Set the type map for this connection.
     *
     * @param map The new type map
     *
     * @exception SQLException if a database access error occurs
     */
    public void setTypeMap(Map map) throws SQLException {

        if (closed) throw new SQLException(SQLEXCEPTION_CLOSED);

        conn.setTypeMap(map);
    }


    // -------------------------------------------------------- Package Methods


    /**
     * Return the actual connection that we are wrapping.
     */
    Connection getConnection() {
        return (this.conn); // FIXME - Good idea to return if closed?
    }


    /**
     * Return the data source that owns this connection.
     */
    DataSource getDataSource() {

        // Do not check for closed exception, to allow for a fresh connection
        return (this.source);
    }


    /**
     * Set the closed status of this connection wrapper.
     *
     * Would usually only be called by the owning DataSource (source), with
     * setClosed(false), when a pooled connection is being recycled.
     *
     */
    void setClosed(boolean closed) {
        this.closed = closed;
    }
    
    
    //////////// 이하 jdk1.4 추가 메서드들//////////////////////
    //나중에 제대로 구현
	public void setHoldability(int holdability)throws SQLException{} 
	
	public int getHoldability()throws SQLException{
		int result=0;
		return result;	
	}
	
	public Savepoint setSavepoint()throws SQLException{
		Savepoint result=null;
		return result;	
	}
	public Savepoint setSavepoint(String name)throws SQLException{
		Savepoint result=null;
		return result;	
	}
	
	public void rollback(Savepoint savepoint)throws SQLException{}
	
	public void releaseSavepoint(Savepoint savepoint)
	                  throws SQLException{}

	public Statement createStatement(int resultSetType,
	                                 int resultSetConcurrency,
	                                 int resultSetHoldability)
	                          throws SQLException{
		Statement result=null;
		return result;	
	}
	public PreparedStatement prepareStatement(String sql,
	                                          int resultSetType,
	                                          int resultSetConcurrency,
	                                          int resultSetHoldability)
	                                   throws SQLException{
		PreparedStatement result=null;
		return result;	
	}
	public CallableStatement prepareCall(String sql,
	                                     int resultSetType,
	                                     int resultSetConcurrency,
	                                     int resultSetHoldability)
	                              throws SQLException{
		CallableStatement result=null;
		return result;	
	}

	public PreparedStatement prepareStatement(String sql,
	                                          int autoGeneratedKeys)
	                                   throws SQLException{
		PreparedStatement result=null;
		return result;	
	}	                              
	
	public PreparedStatement prepareStatement(String sql,
	                                          int[] columnIndexes)
	                                   throws SQLException{
		PreparedStatement result=null;
		return result;	
	}	                              
	

	public PreparedStatement prepareStatement(String sql,
	                                          String[] columnNames)
	                                   throws SQLException{
		PreparedStatement result=null;
		return result;	
	}                                 
}
