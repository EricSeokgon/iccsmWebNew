package kjf.util;

import java.util.Vector;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

/**
 * <p>Title       : slect box의 option들을 가져온다 </p>
 * <p>Description : slect box의 option들을 가져온다 </p>
 * <p>관련 TABLE  :
 * @author 김경덕
 * @version 1.0 2003.06.16 초기제작
 */
public class KJFSelectOPS {

    /**
     * 셀 가져오기
     * @param sql String
     * @return Vector
     * @throws Exception
     */
    static public Vector getSel(String sql) throws  Exception{
        Vector result= new Vector();

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        try{   	
            rEntity = rDAO.select(sql);                   
            for (int i=0;i< rEntity.getRowCnt();i++ ){               	
                KJFSelect sel=new KJFSelect();                  
                sel.setCode(rEntity.getValue(i,0));                  
                sel.setCode_nm(rEntity.getValue(i,1));                 
                result.add(sel);                
            }
         
        } catch (Exception e) {
            KJFLog.log("KJFSelectOPS.getSel()  에러", e.toString());
            throw e;
        }

        return result;
    }
   
    /**
     * 셀 가져오기
     * @param sql           String
     * @param firstCode     String
     * @param firstCodeNm   String
     * @return Vector
     * @throws Exception
     */
    static public Vector getSel(String sql, String firstCode, String firstCodeNm) throws  Exception {
        Vector result= new Vector();

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        try{
        	
            KJFSelect sel=new KJFSelect();                 
            sel.setCode(firstCode);                  
            sel.setCode_nm(firstCodeNm);                 
            result.add(sel);
                    	  	
            rEntity = rDAO.select(sql);                   
            for (int i=0;i< rEntity.getRowCnt();i++ ){               	
                KJFSelect sel01=new KJFSelect();               
                sel01.setCode(rEntity.getValue(i,0));                  
                sel01.setCode_nm(rEntity.getValue(i,1));                 
                result.add(sel01);                  
                
            }
         
        } catch (Exception e) {
            KJFLog.log("KJFSelectOPS.getSel()  에러", e.toString()); 
            throw e;
        }

        return result;
   }

}