package sp.bbs.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFSelectOPS;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;

/**
 * <p>Title       : BbsKscSggCdCmd Class</p>
 * <p>Description : 시.군.구 코드 처리 한다.</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판 시.군.구 코드를 Ajax 처리 한다. 
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsKscSggCdCmd implements KJFCommand {

    private String next;
    
    public BbsKscSggCdCmd() {
    }
    
    public BbsKscSggCdCmd(String next_url) {
        next = next_url;
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);   
        
        request.setAttribute("pm", pm);
        
        // 검색조건에 따른 List를 Load
        loadData(request, pm);
        
        return next;
    }
    
    /************************************************************************
     * 시.군.구 코드 load
     * 
     * @param HttpServletRequest
     * @param KmsParam
     * @return void
     ***********************************************************************/    
    private void loadData(HttpServletRequest request, BbsParam pm) throws Exception {         
       
     // 게시판 검색 코드  시작
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT AREA_CODE, RTRIM(SIGUNGU_NM, '본청')   \n");
        sbSQL.append("   FROM PT_SIDO_CODE                           \n");
        sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR('" + pm.getScSD_CD() + "', 1, 2) \n");
        sbSQL.append("    AND SUBSTR(AREA_CODE, 1, 2) != SUBSTR(AREA_CODE, 3, 4)                \n");
        sbSQL.append("  ORDER BY SIGUNGU_NM      \n");
    
        Vector<KJFSelect> v_scSGG_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "시.군.구 선택");
        
        request.setAttribute("v_scSGG_CD", v_scSGG_CD);
    } 
    
    /************************************************************************
     * 검색조건 초기값 설정 및 체크
     * 
     * @param HttpServletRequest
     * @param ActionForm
     * @return KmsParam
     ************************************************************************/
    private BbsParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {
        
        BbsParam pm = (BbsParam) form;
                
        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));
       
        return pm;
    }  
}
