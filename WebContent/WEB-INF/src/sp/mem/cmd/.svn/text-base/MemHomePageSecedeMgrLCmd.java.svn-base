package sp.mem.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.mem.MemParam;

public class MemHomePageSecedeMgrLCmd implements KJFCommand {
    
    private String next;
    
    public MemHomePageSecedeMgrLCmd() {
    }
    
    public MemHomePageSecedeMgrLCmd(String next_url) {
        next = next_url; 
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
                
        //검색조건 설정및 체크
        MemParam pm = checkPm(request, form);
        
        //검색조건 및 초기데이타 로드
        loadCondition(request, pm);  
        
        //리스트 로드
        loadList(request, pm);        
        
        return next;
    }
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request, MemParam pm) throws Exception{
       
        StringBuffer sbSQL = new StringBuffer();
        sbSQL.append(" SELECT AREA_CODE, SIDO_NM    \n");
        sbSQL.append("   FROM PT_SIDO_CODE          \n");
        sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR(AREA_CODE, 3, 4)    \n");
        sbSQL.append("  ORDER BY SIDO_NM     \n");           
        
        Vector<KJFSelect> v_scSD_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "시.도 선택");
        request.setAttribute("v_scSD_CD", v_scSD_CD);
        
        sbSQL = new StringBuffer();
        sbSQL.append(" SELECT AREA_CODE, RTRIM(SIGUNGU_NM, '본청')   \n");
        sbSQL.append("   FROM PT_SIDO_CODE                           \n");
        sbSQL.append("  WHERE SUBSTR(AREA_CODE, 1, 2) = SUBSTR('" + pm.getScSD_CD() + "', 1, 2) \n");
        sbSQL.append("    AND SUBSTR(AREA_CODE, 1, 2) != SUBSTR(AREA_CODE, 3, 4)                \n");
        sbSQL.append("  ORDER BY SIGUNGU_NM      \n");
                
        Vector<KJFSelect> v_scSGG_CD = KJFSelectOPS.getSel(sbSQL.toString(), "", "시.군.구 선택");
        request.setAttribute("v_scSGG_CD", v_scSGG_CD);    
    }

    
    /**
     * 조건에 따른 list를 load
     * @param HttpServletRequest, UserParam
     * @return
     */
    private void loadList(HttpServletRequest request, MemParam pm) throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        int i = 1;

        StringBuffer selectSQL = new StringBuffer();
        selectSQL.append(" SELECT                           \n");
        selectSQL.append("        PT_U.USER_ID,                  \n");
        selectSQL.append("        PT_U.USER_NAME,                \n");
        selectSQL.append("        PT_U.USER_PASSWD,              \n");
        selectSQL.append("        PT_U.USER_SSN1,                \n");
        selectSQL.append("        PT_U.USER_SSN2,                \n");
        selectSQL.append("        PT_U.USER_POST_NUM,            \n");
        selectSQL.append("        PT_U.USER_ADDR,                \n");
        selectSQL.append("        PT_U.USER_ADDR_DETAIL,         \n");
        selectSQL.append("        PT_U.USER_TEL1,                \n");
        selectSQL.append("        PT_U.USER_TEL2,                \n");
        selectSQL.append("        PT_U.USER_TEL3,                \n");
        selectSQL.append("        PT_U.USER_MOBILE1,             \n");
        selectSQL.append("        PT_U.USER_MOBILE2,             \n");
        selectSQL.append("        PT_U.USER_MOBILE3,             \n");
        selectSQL.append("        PT_U.USER_MOBILE_YN,           \n");
        selectSQL.append("        PT_U.USER_EMAIL,               \n");
        selectSQL.append("        PT_U.USER_DN,                  \n");
        selectSQL.append("        PT_U.COM_REG_YN,               \n");
        selectSQL.append("        PT_U.COM_NAME,                 \n");
        selectSQL.append("        PT_U.COM_NUM,                  \n");
        selectSQL.append("        PT_U.REG_NUM,                  \n");
        selectSQL.append("        PT_U.OFFICE_POST_NUM,          \n");
        selectSQL.append("        PT_U.OFFICE_ADDR,              \n");
        selectSQL.append("        PT_U.OFFICE_ADDR_DETAIL,       \n");
        selectSQL.append("        PT_U.OFFICE_TEL,               \n");
        selectSQL.append("        PT_U.OFFICE_FAX,               \n");
        selectSQL.append("        PT_U.SIDO_CODE,                \n");
        selectSQL.append("        PT_U.SIGUNGU_CODE,             \n");
        selectSQL.append("        PT_SIDO_CODE.SIGUNGU_NM,       \n");        
        selectSQL.append("        PT_U.CAPITAL,                  \n");
        selectSQL.append("        PT_U.USE_YN,                   \n");
        selectSQL.append("        PT_U.INS_DT,                   \n");
        selectSQL.append("        PT_U.UPD_DT                    \n");        
        selectSQL.append("   FROM PT_HOM_USER PT_U               \n");
        selectSQL.append("   LEFT JOIN PT_SIDO_CODE ON PT_U.SIGUNGU_CODE = PT_SIDO_CODE.AREA_CODE   \n"); 

        StringBuffer whereSQL = new StringBuffer();
        whereSQL.append(" WHERE 1=1                 \n");
        whereSQL.append("   AND PT_U.USE_YN = ?     \n");        
        rDAO.setValue(i++, "N");        
        
        // 시도 구분
        if ( !KJFUtil.isEmpty(pm.getScSD_CD()) ) {
            whereSQL.append("   AND PT_U.SIDO_CODE = ?     \n"); 
            rDAO.setValue(i++, pm.getScSD_CD());
        }
        
        // 시군구 구분
        if ( !KJFUtil.isEmpty(pm.getScSGG_CD()) ) {
            whereSQL.append("   AND PT_U.SIGUNGU_CODE = ?     \n");    
            rDAO.setValue(i++, pm.getScSGG_CD());
        }
        
        // 회원구분
        if ( !KJFUtil.isEmpty(pm.getScMEM_GUBUN()) ) {
            whereSQL.append("   AND PT_U.CAPITAL = ?     \n");    
            rDAO.setValue(i++, pm.getScMEM_GUBUN());
        }
        
        // 검색값
        if ( !KJFUtil.isEmpty(pm.getScTEXTVALUE()) ) {
            
            // ID 검색
            if(KJFUtil.print(pm.getScSLCT_GUBUN()).equals("ID")) {
                
                whereSQL.append("   AND PT_U.USER_ID = ?     \n");  
                rDAO.setValue(i++, pm.getScTEXTVALUE());
                
            // 이름 검색
            } else {
                whereSQL.append("   AND PT_U.USER_NAME = ?     \n");  
                rDAO.setValue(i++, pm.getScTEXTVALUE());
            }
        }
        
        String orderSQL = " ORDER BY PT_U.INS_DT DESC    \n";
        
        /* ************************** 페이징 관련 START **************************/
        
        StringBuffer cntSQL = new StringBuffer();
        cntSQL.append(" SELECT COUNT(*)  CNT        \n");
        cntSQL.append("   FROM PT_HOM_USER PT_U     \n");
        
        // 전체 목록 수
        String totalCount="";

        // 페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        // 현재 페이지 번호
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL.toString() + whereSQL.toString());
        totalCount=rEntity.getValue(0,"CNT");
        
        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);
        
        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* ************************** 페이징 관련 END **************************/
 
        rEntity = rDAO.select(selectSQL.toString() + whereSQL.toString() + orderSQL ,nowPage, rowPerPage);
        
        /****** 검색조건 초기값 ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);
    }
    
    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MemParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
        
        MemParam pm = (MemParam)form;

        // 파라미터 디버깅
        KJFLog.debug(pm.toString(request));

        // 페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
            
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
       
        return pm;
    }

}
