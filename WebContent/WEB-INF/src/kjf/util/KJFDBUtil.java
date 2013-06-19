package kjf.util;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

/**
 * <p>Subsystem		:  </p>
 * <p>Title			: 기본적인 DB 유틸함수 </p>
 * <p>Description	: 기본적인 DB 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE		: </p>
 * @author 김경덕
 * @version 1.0	2006.02.26 <br/>
 */
public class KJFDBUtil{

	public static int DB_TYPE = KJFUtil.str2int(Config.props.get("DB_TYPE"));

    /**
    * Max ID를 가져온다.
    * @param   String as_Table, String  as_KeyCol
    * @return   String
    */
    public  static String getMaxID( String  as_KeyCol, String as_Table) throws  Exception{

        String sql = "";
        ReportDAO rDAO = new ReportDAO();

        switch (rDAO.db_type){

        case 2: //Ms-sql
        	sql =
	        	" SELECT														\n" +
	        	"     ISNULL(MAX(convert(numeric,"+as_KeyCol+")),0)+1  MAX_ID   \n" +
	        	" FROM "+as_Table+"												\n" ;
	        break;
	    default:
        	sql =
	        	//" SELECT SEQ_PT_SM_USER_LOG.NEXTVAL AS MAX_ID FROM DUAL           		\n" ;
        		" SELECT														\n" +
	        	"     NVL( MAX( to_number("+as_KeyCol+") ), 0 ) + 1   MAX_ID    \n" +
	        	" FROM "+as_Table+"												\n" ;

	    	break;
        }
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sql);

        return rEntity.getValue(0,"MAX_ID");
    }
    /**
    * Max ID2를 가져온다.
    * @param   String as_Table, String  as_KeyCol
    * @return   String
    */
    public  static String getMaxID2( String  as_KeyCol, String as_Table, int as_TYPE) throws  Exception{

        String sql = "";
        ReportDAO rDAO = new ReportDAO();
        int as_type = as_TYPE;
        
        
        switch (as_type){

        case 2: //사용전검사
        	sql =
            		" SELECT	 /*+ index_desc (t PSCAN XPK"+as_Table+") */	\n" +
            	    "     NVL( MAX( to_number("+as_KeyCol+") ), 0 ) + 1   MAX_ID    \n" +
            	    " FROM "+as_Table+" t												\n" +
                    " where rownum = 1												\n" ;
	        break;
	    default://착공전
        	sql =
	        	//" SELECT SEQ_PT_SM_USER_LOG.NEXTVAL AS MAX_ID FROM DUAL           		\n" ;
        		" SELECT	 /*+ index_desc (t PSCAN XPK"+as_Table+") */	\n" +
	        	"     NVL( MAX( to_number("+as_KeyCol+") ), 0 ) + 1   MAX_ID    \n" +
	        	" FROM "+as_Table+" t												\n" +
        	    " where rownum = 1												\n" ;

	    	break;
        }
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sql);

        return rEntity.getValue(0,"MAX_ID");
    } 

    /**
    * DB별로 null 변환 함수를 반환한다.
    * @param   String as_Table, String  as_KeyCol
    * @return   String
    */
    public  static String makeSql_nullFunc() throws  Exception{
        switch (DB_TYPE){
        case 2: //Ms-sql
        	return "ISNULL";
	    default:
	    	return "NVL";
        }
    }

    /**
     * DB별로 날짜 함수를 반환한다.
     * @param   java.util.Date in
     * @return   String
     */
    public  static String toDate(java.util.Date in) throws  Exception{
	    if(DB_TYPE ==0 || DB_TYPE ==1){
			 return "to_date('"+KJFDate.datetimeOnly((java.util.Date)in)+"','YYYY-MM-DD HH24:MI:SS')";
		} else{
			 return "'"+KJFDate.datetimeOnly((java.util.Date)in)+"'";
		}
    }

    /**
    * DB별로 현재 날짜를 가져오는 함수를 반환한다.
    * @param   String as_Table, String  as_KeyCol
    * @return   String
    */
    public  static String makeSql_getDateFunc() throws  Exception{
        switch (DB_TYPE){
        case 2: //Ms-sql
        	return "GETDATE()";
	    default:
	    	return "SYSDATE";
        }
    }

    /**
     * 테이블이 존재하는지 여부를 조사한다.
     * @param   String tName
     * @return   boolean
     */
    public  static boolean isTable( String tName) throws  Exception{

         String sql ="";
         ReportDAO    rDAO        = new ReportDAO();

         switch (rDAO.db_type){

         case 2: //Ms-sql
         	sql =
 	        	" SELECT										\n" +
 	        	"     ISNULL(OBJECT_ID('"+tName+"'),0) AS TID	\n" ;
 	        break;
 	    default:
         	sql =
 	        	" SELEC							         \n" +
 	        	"     COUNT(*) AS TID                    \n" +
 	        	" FROM TAB WHERE TNAME = '"+tName+"'     \n" ;
 	    	break;
         }

         ReportEntity rEntity = null;
         rEntity = rDAO.select(sql);

         if ("0".equals(rEntity.getValue(0,"TID"))) {
        	 return false;
         } else {
        	 return true;
         }
    }

    /**
    * DB별로 현재 문자형을 숫자형으로 변환하는 함수를 반환한다.
    * @param   String as_Table, String  as_KeyCol
    * @return   String
    */
    public  static String makeSql_toNumFunc(String col) throws  Exception {
        switch (DB_TYPE){
        case 2: //Ms-sql
        	return " convert(int, "+col+") ";
	    default:
	    	return " to_number("+col+") ";
        }
    }

    /**
    * 예약어인 '(홑따옴표)를 ''것으로 바꿔준다.    
    * @param   String txt
    * @return   String
    */
    public static String convertQMark (String txt) throws  Exception {
    	if(txt==null) return "";
        switch (DB_TYPE){
        case 2: //Ms-sql
        	return "";
	    default:
	    	return txt.replaceAll("'", "''");
        }
    }
}
