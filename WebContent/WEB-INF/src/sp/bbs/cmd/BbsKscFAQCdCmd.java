package sp.bbs.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;

/**
 * <p>Title       : BbsKscSggCdCmd Class</p>
 * <p>Description : 질의회신 소분류 코드 처리 한다.</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE : 게시판 질의회신 소분류 코드를 Ajax 처리 한다. 
 * 
 * @version 1.0
 * @author  PKT
 */
public class BbsKscFAQCdCmd implements KJFCommand {

    public BbsKscFAQCdCmd() {
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        // 검색조건 설정및 체크
        BbsParam pm = checkPm(request, form);   
        
        request.setAttribute("pm", pm);
        
        // 검색조건에 따른 List를 Load
        loadData(request, pm);
        
        return request.getParameter("cmd");
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
        String ScFAQ_L = KJFUtil.print(request.getParameter("ScFAQ_L_CATE"),"001");
        
        sbSQL = new StringBuffer();
        sbSQL.append(" SELECT CODE,CODE_NAME 		 			\n");
        sbSQL.append(" FROM PT_BBS_COM_CODE          			\n");
        sbSQL.append(" WHERE CODE_GROUP ='004' AND BIGO ='"+ ScFAQ_L +"'  \n");
        sbSQL.append(" ORDER BY ORDER_NUM ASC 	    			\n");  
    
        Vector<KJFSelect> v_scFAQ_S_CATE = KJFSelectOPS.getSel(sbSQL.toString(), "ALL", "소분류");
        
        request.setAttribute("v_scFAQ_S_CATE", v_scFAQ_S_CATE);
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
