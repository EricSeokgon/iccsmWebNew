package sp.rch.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.uent.UserEnt;

public class RchMgrCUDCmd implements KJFCommand {

	private String next;
	
    public RchMgrCUDCmd() {
    }
    
    public RchMgrCUDCmd(String next_url) {
    	next = next_url; 
    }
	
	
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

    	String mode = request.getParameter("mode");

    	if (mode.equals("J")) { //참여
    		joinExe(request, form);

    	} else if(mode.equals("C")) { //입력
    		insertExe(request, form);

    	} else if (mode.equals("U")) { //수정
    		updateExe(request, form);

    	} else if (mode.equals("IU")) { //설문 정보 수정
    		updateRchInfoExe(request);
    		
    	} else if (mode.equals("D")) { //삭제
    		deleteExe(request);

    	} else if (mode.equals("F")) { //설문 종료
    		finishExe(request);
    	}

        return next;
    }


    /***********************************************************************
     * 참여 입력
     *
     * @param HttpServletRequest
     * @return
     **********************************************************************/
    private void joinExe(HttpServletRequest request, ActionForm form)throws Exception{

    	String CT_ID = request.getParameter("CT_ID");
    	int rid = Integer.parseInt(request.getParameter("RID"));
    	UserEnt user = (UserEnt)request.getSession().getAttribute("user");
    	String USER_ID = user.getUSER_ID();


    	ReportDAO    rDAO       = new ReportDAO();
    	String sql = "SELECT RID FROM PT_RS_ANSWERER WHERE RID="+rid+" AND USER_ID='"+USER_ID+"'";
    	ReportEntity rEntity = rDAO.select(sql);
    	if(rEntity.getRowCnt()!=0){
    		throw new MsgException("이미 해당 설문조사에 참여 하셨습니다.");
    	}

    	sql = "INSERT INTO PT_RS_ANSWERER (RID,USER_ID,IN_DATE) VALUES (?,?,"+KJFDBUtil.makeSql_getDateFunc()+")";

    	int cnt=1;

    	rDAO.setValue(cnt++, rid);
    	rDAO.setValue(cnt++, USER_ID);
    	rDAO.execute(sql);

    	rDAO       = new ReportDAO();

    	//PT_RS_OBJQST_ANSWER insert
    	if(!KJFUtil.isEmpty(request.getParameter("objQstIdxs"))){
    		String[] objQstIdxs = request.getParameter("objQstIdxs").split(",");

	    	for(int i=0;i<objQstIdxs.length;i++){
	    		String strSeq = objQstIdxs[i];
	    		String[] ojbAsnArr = request.getParameterValues("objAns_"+strSeq);
	    		if(ojbAsnArr!=null){
		    		int objRsCnt = ojbAsnArr.length;
		    		for(int j=0;j<objRsCnt;j++){
		    			sql =
		    				"INSERT INTO PT_RS_OBJQST_ANSWER (RID,USER_ID,SEQ,IDX,ANSWER) VALUES "+
		    				"("+rid+",'"+USER_ID+"',"+strSeq+","+j+",'"+ojbAsnArr[j]+"') ";
		    			rDAO.execute(sql);
		    		}
	    		}
	    	}
	    	if(!KJFUtil.isEmpty(request.getParameter("objEtcAnsIdxs"))){
		    	//기타의견 저장
	    		String[] objEtcAnsIdxs = request.getParameter("objEtcAnsIdxs").split(",");
		    	for(int i=0;i<objEtcAnsIdxs.length;i++){
		    		String strSeq = objEtcAnsIdxs[i];
	    			sql =
	    				"INSERT INTO PT_RS_OBJQST_ETC_ANSWER (RID, SEQ, USER_ID, ANSWER) VALUES "+
	    				"("+rid+","+strSeq+",'"+USER_ID+"', '"+KJFDBUtil.convertQMark(request.getParameter("objEtcAns_"+strSeq))+"') ";
	    			rDAO.execute(sql);
	
		    	}
	    	}
    	}

    	//PT_RS_SBJQST_ANSWER insert
    	String[] sbjAns = request.getParameterValues("sbjAns");
    	if(sbjAns!=null){
	    	for(int i=0;i<sbjAns.length;i++){
		    	sql =
    				"INSERT INTO PT_RS_SBJQST_ANSWER (RID,USER_ID,SEQ,ANSWER) VALUES "+
    				"("+rid+",'"+USER_ID+"',"+(i+1)+",'"+KJFDBUtil.convertQMark(sbjAns[i])+"') ";
		    	rDAO.execute(sql);
	    	}
    	}
    	
    	sql = "SELECT PUBLISH_LVL FROM PT_RS_RESEARCH WHERE RID="+rid;
    	rEntity = rDAO.select(sql);
    	
    	if ("1".equals(rEntity.getValue(0, 0))) {
    		request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=Result&CT_ID="+CT_ID+"&RID="+rid + "&titPgId=" + request.getParameter("titPgId"));
    	} else {
    		request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=RchL&CT_ID="+CT_ID+"&titPgId=" + request.getParameter("titPgId"));
    	}
    }

    /***********************************************************************
     * 설문 입력
     * @param HttpServletRequest
     * @return
     **********************************************************************/
    private void insertExe(HttpServletRequest request, ActionForm form) throws Exception {

    	UserEnt user = (UserEnt)request.getSession().getAttribute("user");
    	
    	//PT_RS_RESEARCH insert
    	ReportDAO    rDAO       = new ReportDAO();
    	
    	String sql =
    		"INSERT INTO PT_RS_RESEARCH 		\n"+
    		"(CT_ID,RID,TITLE,S_DATE,E_DATE,RS_DESC,FINISH_YN,IN_DATE,PUBLISH_LVL,USER_ID,USER_NAME)	\n"+
    		"VALUES (?,?,?,?,?,?,'N',"+KJFDBUtil.makeSql_getDateFunc()+",?,?,?)	";

    	int cnt=1;

    	String CT_ID = request.getParameter("CT_ID");

    	int rid = Integer.parseInt(KJFDBUtil.getMaxID("RID", "PT_RS_RESEARCH"));
    	rDAO.setValue(cnt++, CT_ID);
    	rDAO.setValue(cnt++, rid);
    	rDAO.setValue(cnt++, request.getParameter("TITLE"));
    	rDAO.setValue(cnt++, request.getParameter("S_DATE"));
    	rDAO.setValue(cnt++, request.getParameter("E_DATE"));
    	rDAO.setValue(cnt++, request.getParameter("RS_DESC"));
    	rDAO.setValue(cnt++, request.getParameter("PUBLISH_LVL"));
    	rDAO.setValue(cnt++, user.getUSER_ID());
    	rDAO.setValue(cnt++, user.getUSER_NAME());

    	rDAO.execute(sql);

    	insertQst(request, rid);

    	request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=RchV&CT_ID=" + CT_ID + "&RID="+rid + "&titPgId=" + request.getParameter("titPgId"));
    }


    /***********************************************************************
     * 설문 수정
     * @param HttpServletRequest
     * @return
     **********************************************************************/
    private void updateExe(HttpServletRequest request, ActionForm form)throws Exception{

    	//PT_RS_RESEARCH insert
    	ReportDAO    rDAO       = new ReportDAO();

    	String CT_ID = KJFUtil.print(request.getParameter("CT_ID"), "");

    	String sql = "UPDATE PT_RS_RESEARCH SET TITLE=?,S_DATE=?,E_DATE=?,RS_DESC=?, PUBLISH_LVL=? WHERE RID=?";

    	int cnt=1;

    	int rid = Integer.parseInt(request.getParameter("RID"));
    	rDAO.setValue(cnt++, request.getParameter("TITLE"));
    	rDAO.setValue(cnt++, request.getParameter("S_DATE"));
    	rDAO.setValue(cnt++, request.getParameter("E_DATE"));
    	rDAO.setValue(cnt++, request.getParameter("RS_DESC"));
    	rDAO.setValue(cnt++, request.getParameter("PUBLISH_LVL"));
    	rDAO.setValue(cnt++, rid);

    	rDAO.execute(sql);

    	deleteQst(rid);
    	insertQst(request, rid);

    	request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=RchV&CT_ID=" + CT_ID + "&RID=" + rid + "&titPgId=" + request.getParameter("titPgId"));
    }


    /***********************************************************************
     * 설문 수정
     * @param HttpServletRequest
     * @return
     **********************************************************************/
    private void updateRchInfoExe(HttpServletRequest request)throws Exception{

    	//PT_RS_RESEARCH insert
    	ReportDAO    rDAO       = new ReportDAO();

    	String CT_ID = KJFUtil.print(request.getParameter("CT_ID"), "");

    	String sql = "UPDATE PT_RS_RESEARCH SET TITLE=?,S_DATE=?,E_DATE=?,RS_DESC=? WHERE RID=?";

    	int cnt=1;

    	int rid = Integer.parseInt(request.getParameter("RID"));
    	rDAO.setValue(cnt++, request.getParameter("TITLE"));
    	rDAO.setValue(cnt++, request.getParameter("S_DATE"));
    	rDAO.setValue(cnt++, request.getParameter("E_DATE"));
    	rDAO.setValue(cnt++, request.getParameter("RS_DESC"));
    	rDAO.setValue(cnt++, rid);

    	rDAO.execute(sql);

    	request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=RchV&CT_ID=" + CT_ID + "&RID=" + rid + "&titPgId=" + request.getParameter("titPgId"));
    }

    
    /***********************************************************************
     * 설문 삭제 삭제
     * @param HttpServletRequest
     * @return
     **********************************************************************/
    private void deleteExe(HttpServletRequest request)throws Exception{

    	//PT_RS_RESEARCH insert
    	ReportDAO    rDAO       = new ReportDAO();
    	String sql = "DELETE PT_RS_RESEARCH WHERE RID=?";

    	String CT_ID = request.getParameter("CT_ID");

    	int rid = Integer.parseInt(request.getParameter("RID"));
    	rDAO.setValue(1, rid);

    	rDAO.execute(sql);

    	deleteQst(rid);

    	request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=RchL&CT_ID=" + CT_ID + "&titPgId=" + request.getParameter("titPgId"));
    }


    /***********************************************************************
     * 설문조사 끝내기
     *
     * @param request
     * @throws Exception
     **********************************************************************/
    private void finishExe(HttpServletRequest request)throws Exception{

    	ReportDAO rDAO = new ReportDAO();

    	String CT_ID = request.getParameter("CT_ID");

    	String sql = "UPDATE PT_RS_RESEARCH SET FINISH_YN='Y' WHERE RID="+request.getParameter("RID");
    	rDAO.execute(sql);
    	request.setAttribute("nextURL", "../rch/RchMgrAction.do?cmd=RchL&CT_ID=" + CT_ID + "&titPgId=" + request.getParameter("titPgId"));
    }


    /***********************************************************************
     * 설문 질문등록
     *
     * @param request
     * @param CT_ID
     * @param rid
     * @throws Exception
     **********************************************************************/
    private void insertQst(HttpServletRequest request, int rid)throws Exception{

    	//PT_RS_OBJ_QUESTION insert
    	String[] objQst = request.getParameterValues("objQst");

    	if (objQst != null) {

	    	String[] objQstIdxs = request.getParameter("objQstIdxs").split(",");
	    	String[] dupYnStr = request.getParameter("dupYnStr").split(",");
	    	String[] reqYnStr = request.getParameter("reqYnStr").split(",");
	    	String[] includeEtcStr = request.getParameter("includeEtcStr").split(",");

	    	for (int i = 0; i < objQst.length; i++) {
	    		insertOBJ_QUESTION(rid, objQstIdxs[i], objQst[i], dupYnStr[i], reqYnStr[i], includeEtcStr[i]);
	    	}

	    	//PT_RS_OBJQST_EXAM insert
	    	for (int i = 0; i < objQstIdxs.length; i++) {
	    		String strSeq = objQstIdxs[i];

	    		String[] objQstExam = request.getParameterValues("exam_" + strSeq);

	    		int num = 1;

	    		for (int j = 0; j < objQstExam.length; j++) {
	    			insertOBJQST_EXAM(rid, strSeq, num++, objQstExam[j]);
				}
	    		if("Y".equals(includeEtcStr[i])){
	    			insertOBJQST_EXAM(rid, strSeq, 99, request.getParameter("etc_exam_" + strSeq));
	    		}
	    	}
    	}

    	//PT_RS_SBJ_QUESTION insert
    	String[] sbjQst = request.getParameterValues("sbjQst");

    	if (sbjQst != null) {
			int seq = 1;

			for (int i = 0; i < sbjQst.length; i++) {
				insertSBJ_QUESTION(rid, seq++, sbjQst[i]);
	    	}
    	}
    }


    /***********************************************************************
     * 객관식 질문 저장
     *
     * @param rid
     * @param SEQ
     * @param QUESTION
     * @param CT_ID
     * @throws Exception
     *********************************************************************/
    private void insertOBJ_QUESTION(int rid, String SEQ, String QUESTION, String DUP_YN, String REQ_YN, String INCLUDE_ETC)throws Exception {
    	ReportDAO rDAO = new ReportDAO();
    	String sql = "";

    	sql = "INSERT INTO PT_RS_OBJ_QUESTION (RID, SEQ, QUESTION, DUP_YN, REQ_YN,INCLUDE_ETC) VALUES (?,?,?,?,?,?) ";

    	int cnt = 1;

    	rDAO.setValue(cnt++, rid);
    	rDAO.setValue(cnt++, SEQ);
    	rDAO.setValue(cnt++, QUESTION);
    	rDAO.setValue(cnt++, DUP_YN);
    	rDAO.setValue(cnt++, REQ_YN);
    	rDAO.setValue(cnt++, INCLUDE_ETC);
    	rDAO.execute(sql);
    }


    /***********************************************************************
     * 객관식 질문 저장
     *
     * @param rid
     * @param SEQ
     * @param num
     * @param EXAM
     * @param CT_ID
     * @throws Exception
     **********************************************************************/
	private void insertOBJQST_EXAM(int rid, String SEQ, int num, String EXAM)throws Exception{
		ReportDAO rDAO = new ReportDAO();
    	String sql = "";

    	sql = "INSERT INTO PT_RS_OBJQST_EXAM (RID, SEQ, NUM, EXAM) VALUES (?,?,?,?) ";

    	int cnt = 1;

    	rDAO.setValue(cnt++, rid);
    	rDAO.setValue(cnt++, SEQ);
    	rDAO.setValue(cnt++, num);
    	rDAO.setValue(cnt++, EXAM);
    	rDAO.execute(sql);
    }


	/***********************************************************************
	 * 주관식 질문 저장
	 *
	 * @param rid
	 * @param SEQ
	 * @param QUESTION
	 * @param CT_ID
	 * @throws Exception
	 **********************************************************************/
	private void insertSBJ_QUESTION(int rid, int SEQ, String QUESTION) throws Exception {
		
		ReportDAO rDAO = new ReportDAO();

    	String sql = "INSERT INTO PT_RS_SBJ_QUESTION (RID, SEQ, QUESTION) VALUES (?,?,?) ";

    	int cnt = 1;

    	rDAO.setValue(cnt++, rid);
    	rDAO.setValue(cnt++, SEQ);
    	rDAO.setValue(cnt++, QUESTION);
    	rDAO.execute(sql);
	}


	/***********************************************************************
	 *
	 * @param CT_ID
	 * @param rid
	 * @throws Exception
	 **********************************************************************/
    private void deleteQst(int rid)throws Exception{

    	ReportDAO rDAO = new ReportDAO();
    	String sql = null;

    	// PT_RS_OBJ_QUESTION delete
    	sql = "DELETE PT_RS_OBJ_QUESTION WHERE RID=" + rid;
    	rDAO.execute(sql);

    	// PT_RS_OBJQST_EXAM delete
    	sql = "DELETE PT_RS_OBJQST_EXAM WHERE RID=" + rid;
    	rDAO.execute(sql);

    	// PT_RS_SBJ_QUESTION delete
    	sql = "DELETE PT_RS_SBJ_QUESTION WHERE RID=" + rid;
    	rDAO.execute(sql);

    	// PT_RS_ANSWERER delete
    	sql = "DELETE PT_RS_ANSWERER WHERE RID=" + rid;
    	rDAO.execute(sql);

    	// PT_RS_OBJQST_ANSWER delete
    	sql = "DELETE PT_RS_OBJQST_ANSWER WHERE RID=" + rid;
    	rDAO.execute(sql);

    	// PT_RS_SBJ_QUESTION delete
    	sql = "DELETE PT_RS_SBJQST_ANSWER WHERE RID=" + rid;
    	rDAO.execute(sql);

    	// PT_RS_OBJQST_ETC_ANSWER delete
    	sql = "DELETE PT_RS_OBJQST_ETC_ANSWER WHERE RID=" + rid;
    	rDAO.execute(sql);
    }

}
