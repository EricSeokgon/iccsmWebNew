package sp.bas.cmd;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

public class ComCountCmd{
	
	
	public static String getCount(String sCol,String sTABLE) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number("+sCol+")), 0) + 1 "+sCol;
        sQuery += " FROM " + sTABLE + " ";
        //sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,sCol);
    }

	public static String getCount(String sCol,String sTABLE,String sWehere) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(count("+sCol+"),0) "+sCol;
        sQuery += " FROM " + sTABLE + " " + sWehere ;
        //sQuery += " WHERE 1=1 '"
        
        ReportEntity rEntity     = null;
        
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,sCol);
    }
}
