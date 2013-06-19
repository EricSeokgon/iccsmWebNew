package sp.bbs;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;

/**
 * <p>Title       : BbsWorker Class</p>
 * <p>Description : bbs 모듈의 공통 함수를 정의</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 *
 * NOTE : bbs 모듈의 공통 함수를 정의.
 *
 * @version 1.0
 * @author PKT
 */
public class BbsWorker{

    /**
     * 게시판기본정보를 가져온다.
     * 
     * @param CT_ID
     * @return ReportEntity
     * @throws Exception
     */
    public ReportEntity loadStatusFromDB(String CT_ID) throws  Exception {
        
        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT *                 \n");
        sbSQL.append("   FROM PT_BBS_COM_CT     \n");
        sbSQL.append("  WHERE CT_ID = ?         \n");
        
        rDAO.setValue(1, CT_ID);
        
        rEntity = rDAO.select(sbSQL.toString());
        
        return rEntity;
    }


    /**
     * 사용자 특정 권한 검사
     * 
     * @param auth_level
     * @param user_level
     * @return boolean
     */
    public boolean checkAuth(String auth_level, String user_level) {
        boolean isAuth = false;

        if (user_level != null && !KJFUtil.isEmpty(user_level)) {
            
            String[] str = auth_level.split(",");

            for(int i = 0; i < str.length; i++) {
                
                if (user_level.equals(str[i])) {
                    isAuth = true;
                    break;
                }
            }
        }
        
        return isAuth;
    }
}
