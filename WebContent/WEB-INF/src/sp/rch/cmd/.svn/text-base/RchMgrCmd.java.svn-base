package sp.rch.cmd;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.rch.RchParam;
import sp.uent.UserEnt;

public class RchMgrCmd implements KJFCommand {
	
	private String next;
	
    public RchMgrCmd() {
    }
    
    public RchMgrCmd(String next_url) {
    	next = next_url; 
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        String cmd = request.getParameter("cmd");
        
        if (cmd.equals("RchL")) {               // 설문조사 리스트 
            RchParam pm = checkPm(request, form);
            loadList(request, pm);
        
        } else if (cmd.equals("RchRL")) {   // 준비중 설문조사 리스트 
            RchParam pm = checkPm(request, form);
            loadReadyList(request, pm);
        
        } else if (cmd.equals("RchEL")) {       // 종료된 설문조사 리스트 
            RchParam pm = checkPm(request, form);
            loadEndList(request, pm);
        
        } else if(cmd.equals("RchC")) {         // 설문조사 등록
            RchParam pm = checkPm(request, form);
            request.setAttribute("pm", pm);
        
        } else if(cmd.equals("RchV")) {         // 설문조사 보기
            RchParam pm = checkPm(request, form);
            loadData(request, pm);
            
        } else if(cmd.equals("RchU")) {         // 설문조사 수정
            RchParam pm = checkPm(request, form);
            loadData(request, pm);
            if("updRchInfo".equals(request.getParameter("mode"))) return "/rch/researchInfoMod.jsp";
        
        } else if(cmd.equals("Result")){    // 결과보기
            loadResult(request);
        
        } else if(cmd.equals("RchExcel")){    // 결과보기
            loadExcel(request);
        }
        
        return next;
    }

    /************************************************************************
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSSearchCondition
     ***********************************************************************/   
    private RchParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{

        RchParam pm = (RchParam)form;
        
        /********************페이징 관련*****************************/
        //페이징 라인
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
        return pm;

    }//end checkPm



    /************************************************************************
     * 조건에 따른 list를 load
     * 
     * @param HttpServletRequest
     * @return
     ***********************************************************************/
    private void loadList(HttpServletRequest request, RchParam pm)throws Exception {
        
        String CT_ID = request.getParameter("CT_ID");
        
        if (KJFUtil.isEmpty(CT_ID)) {
            CT_ID = "ALL";
        }

        ReportDAO    rDAO        = new ReportDAO();
        
        ReportEntity rEntity     = null;    // 준비중
       
        // 진행중 설문조사 
        StringBuffer selectStartSQL = new StringBuffer();
        selectStartSQL.append(" SELECT RID, TITLE, S_DATE, E_DATE, RS_DESC,     \n");
        selectStartSQL.append("        FINISH_YN, IN_DATE, USER_ID, USER_NAME,  \n");
        selectStartSQL.append("        (SELECT COUNT(RID)                       \n");
        selectStartSQL.append("           FROM PT_RS_ANSWERER                   \n");
        selectStartSQL.append("          WHERE RID    = RS.RID                  \n");
        selectStartSQL.append("            AND CT_ID  = RS.CT_ID) CNT           \n");
        selectStartSQL.append(" FROM   PT_RS_RESEARCH RS                        \n");
        selectStartSQL.append(" WHERE  FINISH_YN = 'N'                          \n");
       
        if (!CT_ID.equals("ALL")) {
            selectStartSQL.append("   AND  CT_ID = '" + CT_ID + "'              \n");
        }      
        
        selectStartSQL.append("   AND  S_DATE <= TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n");
        selectStartSQL.append("   AND  E_DATE >= TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n");
        selectStartSQL.append(" ORDER BY RID DESC                               \n");
        
               
        // 진행중 설문조사  페이징 관련 cnt SQL
        String cntSQL = " SELECT COUNT(RID) CNT                             \n " +
                        "   FROM PT_RS_RESEARCH                             \n " +
                        "  WHERE  FINISH_YN = 'N'                           \n ";
        
        if (!CT_ID.equals("ALL")) {
            cntSQL += "    AND  CT_ID = '" + CT_ID + "'                 \n ";
        }
        
        cntSQL += "   AND  S_DATE <= TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n " +
                  "   AND  E_DATE >= TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n ";
        
        /* ******************* 준비중 설문조사 페이징 관련 ************************ */
        //전체 목록 수
        String totalCount  = "";  

        //페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        //현재 페이지 번호
        int nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());
        if (nowPage == 0) nowPage = 1;

        rEntity = rDAO.select(cntSQL);
        totalCount = rEntity.getValue(0,"CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* ******************* 준비중 설문조사 페이징 관련 끝 ********************** */       

        rEntity = rDAO.select(selectStartSQL.toString(), nowPage, rowPerPage);

        /* ***** 검색조건 초기값 ********** */
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
        
    }//end loadList 
    
    /************************************************************************
     * 진행중 설문 list를 load
     * 
     * @param HttpServletRequest
     * @return
     ***********************************************************************/
    private void loadReadyList(HttpServletRequest request, RchParam pm)throws Exception {
        
        String CT_ID = request.getParameter("CT_ID");

        ReportDAO    rDAO        = new ReportDAO();
        
        ReportEntity rEntity     = null;    // 준비중
                
        // 준비중 설문조사  
        StringBuffer selectReadySQL = new StringBuffer();
        selectReadySQL.append(" SELECT RID, TITLE, S_DATE, E_DATE, RS_DESC,     \n");
        selectReadySQL.append("        FINISH_YN, IN_DATE, USER_ID, USER_NAME,  \n");
        selectReadySQL.append("        (SELECT COUNT(RID)                       \n");
        selectReadySQL.append("           FROM PT_RS_ANSWERER                   \n");
        selectReadySQL.append("          WHERE RID    = RS.RID                  \n");
        selectReadySQL.append("            AND CT_ID  = RS.CT_ID) CNT           \n");
        selectReadySQL.append("  FROM PT_RS_RESEARCH RS                         \n");
        selectReadySQL.append(" WHERE FINISH_YN = 'N'                           \n");
        
        if (!CT_ID.equals("ALL")) {
            selectReadySQL.append("   AND CT_ID = '" + CT_ID + "'               \n");     
        }
          
        selectReadySQL.append("   AND S_DATE > TO_CHAR(SYSDATE, 'YYYY-MM-DD')   \n");
        selectReadySQL.append("   AND E_DATE > TO_CHAR(SYSDATE, 'YYYY-MM-DD')   \n");
        selectReadySQL.append(" ORDER BY RID DESC                               \n");
        
        
        // 준비중 설문조사 페이징 관련 cnt SQL
        String cntSQL = " SELECT COUNT(RID) CNT                             \n " +
                        "   FROM PT_RS_RESEARCH                             \n " +
                        "  WHERE  FINISH_YN = 'N'                           \n ";
        
        if (!CT_ID.equals("ALL")) {
            cntSQL += "    AND  CT_ID = '" + CT_ID + "'                         \n ";  
        }
        
        cntSQL += "    AND  CT_ID = '" + CT_ID + "'                 \n " +      
                  "    AND  S_DATE > TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n " +
                  "    AND  E_DATE > TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n ";
        
        
        
        /* ******************* 준비중 설문조사 페이징 관련 ************************ */
        //전체 목록 수
        String totalCount  = "";  

        //페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        //현재 페이지 번호
        int nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());
        if (nowPage == 0) nowPage = 1;

        rEntity = rDAO.select(cntSQL);
        totalCount = rEntity.getValue(0,"CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* ******************* 준비중 설문조사 페이징 관련 끝 ********************** */       

        rEntity = rDAO.select(selectReadySQL.toString(), nowPage, rowPerPage);

        /* ***** 검색조건 초기값 ********** */
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
        
    }//end loadList 
    
    /************************************************************************
     * 진행중 설문 list를 load
     * 
     * @param HttpServletRequest
     * @return
     ***********************************************************************/
    private void loadEndList(HttpServletRequest request, RchParam pm)throws Exception {
        
        String CT_ID = request.getParameter("CT_ID");       

        ReportDAO    rDAO        = new ReportDAO();
        
        ReportEntity rEntity     = null;    // 준비중
                
        //  종료 설문조사 
        StringBuffer selectEndSQL = new StringBuffer();
        
        selectEndSQL.append(" SELECT RID, TITLE, S_DATE, E_DATE, RS_DESC,    \n");
        selectEndSQL.append("        FINISH_YN, IN_DATE, USER_ID, USER_NAME, \n");
        selectEndSQL.append("        (SELECT COUNT(RID)                      \n");
        selectEndSQL.append("           FROM PT_RS_ANSWERER                  \n");
        selectEndSQL.append("          WHERE RID    = RS.RID                 \n");
        selectEndSQL.append("            AND CT_ID  = RS.CT_ID) CNT          \n");
        selectEndSQL.append("  FROM PT_RS_RESEARCH RS                        \n");
        selectEndSQL.append(" WHERE 1=1                                      \n");
        
        if (!CT_ID.equals("ALL")) {
             selectEndSQL.append("   AND  CT_ID = '" + CT_ID + "'            \n");
        }
        
        selectEndSQL.append("   AND  (FINISH_YN = 'Y'                           \n");
        selectEndSQL.append("    OR  E_DATE < TO_CHAR(SYSDATE, 'YYYY-MM-DD'))   \n");
        selectEndSQL.append(" ORDER BY RID DESC                                 \n");
        
        
        // 준비중 설문조사 페이징 관련 cnt SQL
        String cntSQL = " SELECT COUNT(RID) CNT                         \n " +
                        "   FROM PT_RS_RESEARCH                         \n " +
                        "  WHERE 1=1                                    \n ";
        
        if (!CT_ID.equals("ALL")) {
            cntSQL += "    AND  CT_ID = '" + CT_ID + "'                 \n ";  
        }       
    
        cntSQL += "   AND  (FINISH_YN = 'Y'                         \n " +
                  "    OR  E_DATE < TO_CHAR(SYSDATE, 'YYYY-MM-DD')) \n ";        
        
        /* ******************* 준비중 설문조사 페이징 관련 ************************ */
        //전체 목록 수
        String totalCount  = "";  

        //페이지별 목록 수
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        //현재 페이지 번호
        int nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());
        if (nowPage == 0) nowPage = 1;

        rEntity = rDAO.select(cntSQL);
        totalCount = rEntity.getValue(0,"CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* ******************* 준비중 설문조사 페이징 관련 끝 ********************** */       

        rEntity = rDAO.select(selectEndSQL.toString(), nowPage, rowPerPage);

        /* ***** 검색조건 초기값 ********** */
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
        
    }//end loadList 

    
    /************************************************************************
     * 조건에 따른 list를 load
     * @param HttpServletRequest
     * @return
     ***********************************************************************/
    private void loadData(HttpServletRequest request, RchParam pm)throws Exception{
        
        String RID = request.getParameter("RID");
        
        String sql =
            " SELECT RID,TITLE,S_DATE,E_DATE,RS_DESC,FINISH_YN,IN_DATE,PUBLISH_LVL,                 \n" +
            "       USER_ID, FN_USER_INFO(USER_ID) USER_INFO,           	                     \n" +
            "       ( SELECT COUNT(RID) FROM PT_RS_ANSWERER WHERE RID=R.RID) ANS_CNT,               \n" +
            "       DECODE(FINISH_YN, 'Y', 'N', (CASE WHEN S_DATE <= TO_CHAR(SYSDATE, 'YYYY-MM-DD') \n" +
            "       AND E_DATE >= TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 'Y' ELSE 'N' END)) ING_YN     \n" +
            "  FROM PT_RS_RESEARCH R                                                                \n" +
            " WHERE RID = '" + RID + "'                                                             \n" ;

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        rEntity = rDAO.select(sql);

        request.setAttribute("rEntity", rEntity);
        request.setAttribute("pm", pm);
        
        //PT_RS_OBJ_QUESTION 
        sql = " SELECT SEQ, QUESTION, DUP_YN, REQ_YN, INCLUDE_ETC   \n" +
              "   FROM PT_RS_OBJ_QUESTION       \n" +
              "  WHERE RID = '" + RID + "'      \n" +
              "  ORDER BY SEQ                   \n";
        
        ReportEntity objQstList = rDAO.select(sql);
        request.setAttribute("objQstList", objQstList);
        
        //PT_RS_OBJQST_EXAM
        sql = " SELECT SEQ, NUM, EXAM           \n" +
              "   FROM PT_RS_OBJQST_EXAM        \n" +
              "  WHERE RID = '" + RID + "'  \n" +
              "  ORDER BY SEQ, NUM              \n";
        
        ReportEntity objQstExam    = rDAO.select(sql);
        
        int cnt = objQstExam.getRowCnt();
        
        String tempSeq = null;
        
        HashMap map = new HashMap();
        
        ArrayList list = null;
        boolean incEtcAns = false; 
        for (int i = 0; i < cnt;i++) {
            incEtcAns = objQstExam.getValue(i, 1).equals("99");
            if (!objQstExam.getValue(i, 0).equals(tempSeq)) {
                if(list != null) map.put(tempSeq, list);
                list = new ArrayList();
            }
            tempSeq = objQstExam.getValue(i, 0);
            list.add((incEtcAns ? "ETC_ANS" : "" )+objQstExam.getValue(i, 2));      
        }
        
        if (tempSeq != null) {
            map.put(tempSeq, list);
        }
        
        request.setAttribute("examMap", map);       
        
        // PT_RS_SBJ_QUESTION
        sql = " SELECT SEQ, QUESTION            \n " +
              "   FROM PT_RS_SBJ_QUESTION       \n " +
              "  WHERE RID = '" + RID + "'      \n " +
              "  ORDER BY SEQ                   \n ";
        
        ReportEntity sbjQstList = rDAO.select(sql);
        request.setAttribute("sbjQstList", sbjQstList);
        

        // 설문을 참여 하였으면 알려준다.
        UserEnt user = (UserEnt)request.getSession().getAttribute("user");
        sql = " SELECT RID FROM PT_RS_ANSWERER WHERE RID = '" + RID + "' AND USER_ID='"+user.getUSER_ID()+"'";
        
        ReportEntity joinedChkEnt = rDAO.select(sql);
        if(joinedChkEnt.getRowCnt()>0){
            request.setAttribute("joinedChkEnt", "JOINED");
        }
        
    } // end loadList  
    

    /************************************************************************
     * 설문조사 결과 조회 메소드 
     * 
     * @param request
     * @throws Exception
     ***********************************************************************/
    private void loadResult(HttpServletRequest request) throws Exception {

        UserEnt user = (UserEnt)request.getSession().getAttribute("user");
        String USER_ID = user.getUSER_ID();
        
        String RID   = request.getParameter("RID");
        //String CT_ID = request.getParameter("CT_ID");
        
        String sql =
            " SELECT RID, TITLE, S_DATE, E_DATE, RS_DESC, FINISH_YN, IN_DATE,   \n" +
            "        CT_ID, FN_USER_INFO(USER_ID) USER_INFO         			\n" +
            "   FROM PT_RS_RESEARCH                                             \n" +
            "  WHERE RID = '" + RID + "'                                        \n" ;

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        rEntity    = rDAO.select(sql);

        request.setAttribute("rEntity", rEntity);
        
        //PT_RS_OBJ_QUESTION 
        sql = " SELECT SEQ, QUESTION, DUP_YN    \n " +
              "   FROM PT_RS_OBJ_QUESTION       \n " +
              "  WHERE RID = '" + RID + "'      \n " +
              "  ORDER BY SEQ                   \n ";
        
        ReportEntity objQstList    = rDAO.select(sql);
        request.setAttribute("objQstList", objQstList);
        
        //PT_RS_OBJQST_EXAM AND ANSWER
        sql = 
            " SELECT SEQ, NUM, EXAM,                                \n " +
            "       (SELECT COUNT(ANSWER)                           \n " +
            "          FROM PT_RS_OBJQST_ANSWER                     \n " +
            "         WHERE RID    = EX.RID                         \n " +
            "           AND SEQ    = EX.SEQ                         \n " +
            "           AND ANSWER = EX.NUM) CNT                    \n " +
            "   FROM PT_RS_OBJQST_EXAM EX                           \n " +
            "  WHERE RID = '" + RID + "'                            \n " +
            "  ORDER BY SEQ, NUM                                    \n ";
        
        ReportEntity objQstExam    = rDAO.select(sql);
        
        int cnt = objQstExam.getRowCnt();
        
        String tempSeq = null;
        
        HashMap map = new HashMap();
        
        ArrayList list = null;
        String[] rsArr = null;
        
        for (int i = 0; i < cnt; i++) {
            rsArr = new String[2];
            rsArr[0] = ("99".equals(objQstExam.getValue(i,1))?"ETC_ANS":"") + objQstExam.getValue(i,2);
            rsArr[1] = objQstExam.getValue(i,3);
            
            if (objQstExam.getValue(i, 0).equals(tempSeq)) {
                list.add(rsArr);    
            } else {
                if (list == null) {
                    list = new ArrayList();
                    tempSeq = objQstExam.getValue(i,0);
                    list.add(rsArr);
                } else {
                    map.put(tempSeq, list);
                    list = new ArrayList();
                    tempSeq = objQstExam.getValue(i,0);
                    list.add(rsArr);
                }
            }
        }
        
        if (tempSeq != null) {
            map.put(tempSeq, list);
        }
        
        request.setAttribute("oAnsMap", map);
        
        //PT_RS_SBJ_QUESTION
        sql = " SELECT SEQ, QUESTION            \n " +
              "   FROM PT_RS_SBJ_QUESTION       \n " +
              "  WHERE RID = '" + RID + "'      \n " +
             // "    AND CT_ID = '" + CT_ID + "'    \n " +
              "  ORDER BY SEQ                   \n ";
        
        ReportEntity sbjQstList = rDAO.select(sql);
        request.setAttribute("sbjQstList", sbjQstList);
        
        //PT_RS_SBJQST_ANSWER
        sql = 
            " SELECT SEQ, FN_USER_INFO(A.USER_ID) USER_INFO, ANSWER  \n" +
            "   FROM PT_RS_SBJQST_ANSWER A, PT_RS_RESEARCH R                    \n" +
            "  WHERE A.RID = R.RID                                              \n" +
            "    AND A.RID = '" + RID + "'                                      \n" +
            (user.isAdmin()?"":" AND A.USER_ID LIKE DECODE(R.USER_ID, '" + USER_ID + "', '%%', '" + USER_ID + "')")+
            "  ORDER BY SEQ,  USER_INFO";
        
        ReportEntity sbjQstExam    = rDAO.select(sql);
        
        cnt = sbjQstExam.getRowCnt();
        
        tempSeq = null;
        
        map = new HashMap();
        
        for (int i = 0; i < cnt; i++) {
            if (sbjQstExam.getValue(i, 0).equals(tempSeq)) {
                rsArr = new String[2];
                rsArr[0] = sbjQstExam.getValue(i, 1);
                rsArr[1] = sbjQstExam.getValue(i, 2);
                list.add(rsArr);    
            } else {
                if( list == null) {
                    list = new ArrayList();
                    
                    tempSeq = sbjQstExam.getValue(i, 0);
                    
                    rsArr = new String[2];
                    rsArr[0] = sbjQstExam.getValue(i, 1);
                    rsArr[1] = sbjQstExam.getValue(i, 2);
                    
                    list.add(rsArr);
                } else { 
                    map.put(tempSeq, list);
                    
                    list = new ArrayList();
                    
                    tempSeq = sbjQstExam.getValue(i, 0);
                    
                    rsArr = new String[2];
                    rsArr[0] = sbjQstExam.getValue(i, 1);
                    rsArr[1] = sbjQstExam.getValue(i, 2);
                    
                    list.add(rsArr);
                }
            }
        }
        
        if (tempSeq != null) {
            map.put(tempSeq, list);
        }
        
        request.setAttribute("sAnsMap", map);
        
        // 설문조사 참여자 수 구하기
        sql = " SELECT COUNT(RID)           \n" +
              "   FROM PT_RS_ANSWERER       \n" +
              "  WHERE RID = '" + RID + "'  \n";
        
        int totJoinCnt = 0;
        
        ReportEntity rEnt = rDAO.select(sql);
        
        if (rEnt.getRowCnt() > 0) { 
            totJoinCnt = KJFUtil.str2int(rEnt.getValue(0,0));
        }
        
        request.setAttribute("totJoinCnt", totJoinCnt+"");
        
        
        //기타의견에 대한 대답
        sql = 
            " SELECT SEQ, FN_USER_INFO(USER_ID) USER_INFO, ANSWER    \n " +
            "   FROM PT_RS_OBJQST_ETC_ANSWER                                \n " +
            "  WHERE RID = '" + RID + "'                                    \n " ;
        
        ReportEntity objEtcAns    = rDAO.select(sql);
        cnt = objEtcAns.getRowCnt();
        
        tempSeq = null;
        
        HashMap etcAnsMap = new HashMap();
        
        ArrayList etcAnslist = null;
        String[] etcAnsArr = null;
        
        for (int i = 0; i < cnt; i++) {
            etcAnsArr = new String[2];
            etcAnsArr[0] = objEtcAns.getValue(i,1);
            etcAnsArr[1] = objEtcAns.getValue(i,2);
            
            if (!objEtcAns.getValue(i, 0).equals(tempSeq)) {
                if (etcAnslist != null) {
                    etcAnsMap.put(tempSeq, etcAnslist);
                }
                etcAnslist = new ArrayList();
                tempSeq = objEtcAns.getValue(i,0);
            }
            etcAnslist.add(etcAnsArr);  
        }
        
        if (tempSeq != null) {
            etcAnsMap.put(tempSeq, etcAnslist);
        }
        
        request.setAttribute("etcAnsMap", etcAnsMap);        
        
    }//end loadList 
    
    
    /************************************************************************
     * 설문엑셀 조회 메소드 
     * 
     * @param request
     * @throws Exception
     ***********************************************************************/
    private void loadExcel(HttpServletRequest request) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;
        
        String RID   = request.getParameter("RID");
        
        // 설문 정보
        String sql =
            " SELECT RID, TITLE, S_DATE, E_DATE, RS_DESC, FINISH_YN, IN_DATE,   \n" +
            "        CT_ID, FN_USER_INFO(USER_ID) USER_INFO             		\n" +
            "   FROM PT_RS_RESEARCH                                             \n" +
            "  WHERE RID = '" + RID + "'                                        \n" ;       
        
        rEntity    = rDAO.select(sql);

        request.setAttribute("rEntity", rEntity);
                
        //객관식 질문 타이틀
        sql = " SELECT SEQ, QUESTION, DUP_YN    \n " +
              "   FROM PT_RS_OBJ_QUESTION       \n " +
              "  WHERE RID = '" + RID + "'      \n " +
              "  ORDER BY SEQ                   \n ";
        
        ReportEntity objQstList    = rDAO.select(sql);
        request.setAttribute("objQstList", objQstList);        
        
        sql =  
            " SELECT USR.USER_ID, USR.USER_NAME, DEPT.DEPT_NM       \n " +             
            "   FROM PT_RS_ANSWERER ANS, PT_USER USR, PT_DEPT DEPT  \n " +  
            "  WHERE ANS.RID = '" + RID + "'                        \n " +
            "    AND ANS.USER_ID = USR.USER_ID                      \n " +
            "    AND USR.DEPT_CD = DEPT.DEPT_CD                     \n " +
            "  ORDER BY USR.USER_NAME                               \n ";
           
        ReportEntity userInfoList = rDAO.select(sql);
        
        request.setAttribute("userInfoList", userInfoList);
        
        
        // 객관식 질문을 리스트에 담는다.
        if (objQstList != null) {
            
            ArrayList listObjqst_Exam  = new ArrayList();
            ArrayList listObjqstUser_Exam = new ArrayList();                  
            
            for (int i = 0; i < objQstList.getRowCnt(); i++) {
                
                sql = 
                    " SELECT SEQ, NUM, EXAM,                                \n " +
                    "       (SELECT COUNT(ANSWER)                           \n " +
                    "          FROM PT_RS_OBJQST_ANSWER                     \n " +
                    "         WHERE RID    = EX.RID                         \n " +
                    "           AND SEQ    = EX.SEQ                         \n " +
                    "           AND ANSWER = EX.NUM) CNT                    \n " +
                    "   FROM PT_RS_OBJQST_EXAM EX                           \n " +
                    "  WHERE RID = '" + RID + "'                            \n " +
                    "    AND SEQ = '" + objQstList.getValue(i, "SEQ")  + "' \n " +      
                    "  ORDER BY SEQ, NUM                                    \n ";
                
                ReportEntity objQstExam    = rDAO.select(sql);
                
                listObjqst_Exam.add(objQstExam);
                
                
                // 객관식 질문 대답
                sql = 
                " SELECT RID, SEQ, USER_ID, IDX, ANSWER                             \n " +
                "   FROM PT_RS_OBJQST_ANSWER                                        \n " +                      
                "  WHERE RID = '" + RID + "'                                        \n " +                                   
                "    AND SEQ = '" + objQstList.getValue(i, "SEQ")  + "'             \n " +
                "  ORDER BY ANSWER                                                  \n ";
                
                ReportEntity answerInfo = rDAO.select(sql);  
                
                
                // 객관식 추가 대답
                sql = 
                " SELECT RID, SEQ, USER_ID, ANSWER                      \n " +
                "   FROM PT_RS_OBJQST_ETC_ANSWER                        \n " +
                "  WHERE RID = '" + RID + "'                            \n " +                                    
                "    AND SEQ = '" + objQstList.getValue(i, "SEQ")  + "' \n ";
                
                ReportEntity answerEtcInfo = rDAO.select(sql); 
                
                
                ArrayList listTemp_Exam = new ArrayList();
                
                for(int j = 0; j < userInfoList.getRowCnt(); j++) {
                    HashMap mapUserInfo = new HashMap();
                    
                    ArrayList answerInfoTemp = new ArrayList();                     
                    
                    // 사용자 응답 
                    for(int k = 0; k < answerInfo.getRowCnt(); k++) {                        
                        if (userInfoList.getObjValue(j, "USER_ID").equals(answerInfo.getObjValue(k, "USER_ID"))) {
                            answerInfoTemp.add(answerInfo.getObjValue(k, "ANSWER"));
                        }                        
                    }                    
                    
                    String answerEtcInfoTemp = ""; 
                    
                    // 사용자 기타  응답 
                    for(int l = 0; l < answerEtcInfo.getRowCnt(); l++) {                        
                        if (userInfoList.getObjValue(j, "USER_ID").equals(answerEtcInfo.getObjValue(l, "USER_ID"))) {
                            answerEtcInfoTemp =  (String) answerEtcInfo.getObjValue(l, "ANSWER");
                            System.out.println("ID" + answerInfo.getObjValue(l, "USER_ID") + "answer : " + answerEtcInfoTemp);
                            System.out.println("ID" + userInfoList.getObjValue(j, "USER_ID"));
                        }                        
                    }
                    
                    mapUserInfo.put("USER_ID", userInfoList.getObjValue(j, "USER_ID"));  // 사용자 정보                      
                    mapUserInfo.put("LIST_ANSERE", answerInfoTemp);                      // 객관식 대답         
                    mapUserInfo.put("ETC_ANSWER", answerEtcInfoTemp);                    // 기타 대답
                    
                    listTemp_Exam.add(mapUserInfo);
                    
                }               
                
                listObjqstUser_Exam.add(listTemp_Exam);                
            }      
            
            request.setAttribute("listObjqst_Exam", listObjqst_Exam);
            request.setAttribute("listObjqstUser_Exam", listObjqstUser_Exam);           
        }           
        
        /********************************************************************
         * 주관식 질문, 대답 START
         ********************************************************************/
        //주관식 질문
        sql = " SELECT SEQ, QUESTION            \n " +
              "   FROM PT_RS_SBJ_QUESTION       \n " +
              "  WHERE RID = '" + RID + "'      \n " +
              "  ORDER BY SEQ                   \n ";
        
        ReportEntity sbjQstList = rDAO.select(sql);
        request.setAttribute("sbjQstList", sbjQstList);
        
        
        ArrayList listSbjQstAnswer = new ArrayList();
        
        if (sbjQstList != null) {
            for (int i = 0; i < sbjQstList.getRowCnt(); i++) {
                
                // 주관식 대답
                sql = 
                    " SELECT ANS.RID, ANS.SEQ, ANS.USER_ID, ANS.ANSWER          \n" +
                    "   FROM PT_RS_SBJQST_ANSWER ANS, PT_USER USR               \n" +
                    "  WHERE ANS.RID = '" + RID + "'                            \n" +
                    "    AND ANS.SEQ = '" + sbjQstList.getValue(i, "SEQ")  + "' \n" +      
                    "    AND ANS.USER_ID = USR.USER_ID                          \n" +  
                    "  ORDER BY USR.USER_NAME                                   \n";  
                
                ReportEntity sbjQstExam = rDAO.select(sql);      
                listSbjQstAnswer.add(i, sbjQstExam);
            }            
        }
        
        request.setAttribute("listSbjQstAnswer", listSbjQstAnswer);
        
        /********************************************************************
         * 주관식 질문, 대답 END
         ********************************************************************/     
       
        
        // 설문조사 참여자 수 구하기
        sql = " SELECT COUNT(RID)           \n" +
              "   FROM PT_RS_ANSWERER       \n" +
              "  WHERE RID = '" + RID + "'  \n";
        
        int totJoinCnt = 0;
        
        ReportEntity rEnt = rDAO.select(sql);
        
        if (rEnt.getRowCnt() > 0) { 
            totJoinCnt = KJFUtil.str2int(rEnt.getValue(0,0));
        }
        
        request.setAttribute("totJoinCnt", totJoinCnt + "");
        
        
    }//end loadList 

}
