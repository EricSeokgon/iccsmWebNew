package kjf.ops;

import kjf.cfg.Config;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;

/**
 * Oracle을 위한 최상위 DAO이다.
 * 
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
public abstract class SuperToDB extends SuperDAO {
	
	public int db_type = KJFUtil.str2int(KJFUtil.print(Config.props.get("DB_TYPE"),"0"));	
  
	/**
     * Oracle을 위한 코드변환등을 수행한다.
     * @param in Object
     * @return String
     */
	protected final String toDB(Object in) {
	    
	    if(in instanceof String) {
	        return "'" + in.toString().replaceAll("'","''") + "'";
	        
	    } else if(in instanceof java.util.Date) {
	        if(db_type ==0 || db_type ==1){
	            return "to_date('"+KJFDate.datetimeOnly((java.util.Date)in)+"','YYYY-MM-DD HH24:MI:SS')"; 
	        } else{
	            return "'"+KJFDate.datetimeOnly((java.util.Date)in)+"'";
	        }
	    } else {
	        if(in==null)  return "null";
	        else     	  return in.toString();
	    }
	}        

  
	/**
	 * Page Query문
	 * @param subQuery
	 * @param pageIndex
	 * @param sizePerPage
	 * @return
	 */
	public String getPageQuery( String subQuery, int pageIndex, int sizePerPage) {
	    String query ="";
        
        switch (db_type){
        case 0: //oracle 8i이상
        	query = " SELECT *" +
	            " FROM   (" +
	            " SELECT PAGE_QUERY.*, ROWNUM NUM" +
	            " FROM   (" +
	            "         " + subQuery +
	            "        ) PAGE_QUERY" +
	            " )" +
	            " WHERE  NUM between " +
	            ( (pageIndex - 1) * sizePerPage + 1 ) +
	            " AND " +
	            ( pageIndex * sizePerPage  );         	
	        	break;
        
        case 3: //My-sql
        	query = subQuery +" limit " + ( (pageIndex - 1) * sizePerPage + 1 ) +", "+sizePerPage;        	
        	break;
        
        }
        
        return query;
	}
}