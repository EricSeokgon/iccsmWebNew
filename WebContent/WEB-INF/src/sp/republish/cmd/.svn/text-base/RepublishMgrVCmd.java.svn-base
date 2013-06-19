package sp.republish.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.LoginException;

import sp.uent.UserEnt;
import sp.republish.RepublishParam;

import org.apache.struts.action.ActionForm;

public class RepublishMgrVCmd implements KJFCommand {
	
	public String execute(HttpServletRequest request, ActionForm form)
	throws Exception {
		// TODO Auto-generated method stub
	
		String cmd = KJFUtil.print(request.getParameter("cmd"));
		String mode = KJFUtil.print(request.getParameter("mode"));
		String page = KJFUtil.print(request.getParameter("page"));
		
		/*
		 	type parameter : _new (신규양식 일 경우는 FW 파일명 끝에 _new 를 붙인다. )
		 */
		String type = KJFUtil.print(request.getParameter("type"),"");
	
		request.setAttribute("page", page);
		
		//page 설정값 세팅
		RepublishParam pm = checkPage(form, page);
		
		
		//수첩 VIEW 메인 페이지
		if("RepublishMain".equals(cmd)) {
			
			String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
			
			String scSD_CD = KJFUtil.print(request.getParameter("scSD_CD"));
			
			getComPName(request);
			
			return "/republish/regist_print_main.jsp?coi_wrt_num="+p_coi_wrt_num+"&scSD_CD="+scSD_CD;
		}
		
		if("RepublishView".equals(cmd)) {
			
			String p_gubun = KJFUtil.print(request.getParameter("p_gubun"),"afresh");
			
			defaultViewLoad(request, p_gubun);
			
			request.setAttribute("p_gubun", p_gubun); //출력구분
			request.setAttribute("p_type", type); //출력구분
			
			cmd = "/republish/RepublishView.jsp";
		
		} else if("RegisterView".equals(cmd)) {
			
			String p_gubun = KJFUtil.print(request.getParameter("p_gubun"),"register");
			
			defaultViewLoad(request, p_gubun);
			
			request.setAttribute("p_gubun", p_gubun); //출력구분
			request.setAttribute("p_type", type); //출력구분
			
			cmd = "/republish/RegisterView.jsp";
		
		} else {
			
			if("basics".equals(mode)) { //공사업자 기본사항(2쪽) 
				basicsLoad(request); 		
				cmd = "/republish/DetailBasics"+type+".jsp";
				
			} else if("valuation".equals(mode)) { //시공능력평가사항(3쪽)
				valuationLoad(request); 			 
				cmd = "/republish/DetailValuation"+type+".jsp";
				
			} else if("engineer".equals(mode)) { //정보통신기술자사항( 4쪽 ~ 11쪽 )
				engineerLoad(request,pm); 		
				cmd = "/republish/DetailEngineer"+type+".jsp";
				
			} else if("change".equals(mode)) { //변경사항( 12쪽 ~ 13쪽 )
				changeLoad(request,pm); 		
				cmd = "/republish/DetailChange"+type+".jsp";
				
			} else if("adm_dis".equals(mode)) { //행정처분사항(14쪽)
				adm_disLoad(request); 		
				cmd = "/republish/DetailAdm_dis"+type+".jsp";
				
			}
			
			String sido_num = KJFUtil.print(request.getParameter("scSD_CD"));  //시도코드
			//대구 나 충남이 아니면.. 기본값 설정
			if(!"dgdg".equals(sido_num) &&  !"cncn".equals(sido_num) &&  !"gggg".equals(sido_num) &&  !"bsbs".equals(sido_num) &&  !"sjsj".equals(sido_num) &&  !"gbgb".equals(sido_num)) {
				sido_num = "basic";
			} 
			
			request.setAttribute("p_sido_num", sido_num); 
		}	
		
		
		return cmd;
	}
	
	
	private void getComPName(HttpServletRequest request) throws Exception {
		
		ReportDAO    rDAO        = new ReportDAO();
        ReportEntity nameEntity     = null;
        
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        String selectSQL =
			" 	SELECT  NAME, REP_NM_KOR  \n"+ 
			" 	    	FROM PT_R_COMPANY_MASTER     \n"+ 
			" 			WHERE 	COI_WRT_NUM = '"+p_coi_wrt_num+"'    \n";
        
        nameEntity = rDAO.select(selectSQL);

        request.setAttribute("p_name", nameEntity.getValue(0, "NAME")); //출력구분
	}
		
	
	
	private void defaultViewLoad(HttpServletRequest request, String p_gubun) throws Exception {
		
        /*********** 게시판 검색 코드  시작 ***************/
    	String sql = 
    	    " SELECT  AREA_CODE, SIDO_NM " +
			"   FROM 	PT_SIDO_CODE WHERE SIGUNGU_NM = '본청' " +
			"   		AND AREA_CODE !='tete' AND AREA_CODE !='test' AND AREA_CODE !='fefe'" +
			"   		ORDER BY SIDO_NM ";

		Vector v_scSD_CD 	= KJFSelectOPS.getSel(sql);
		request.setAttribute("v_scSD_CD", v_scSD_CD);
		
		
        String[] P_NUM = new String[14];
        String P_NUM_D = "";
        
        /*
         * 등록수첩 각 항목별 데이터 유무를 체크후 P_NUM 배열에 담아 Attribute로 넘긴다..
         * ex) 2쪽은 P_NUM[2] , 3쪽은 P_NUM[3]  이다.
         * 데이터 값이 없을경우 문자열 "disabled" 을 넣는다.
         * jsp 에서 는 disabled 인지 아닌지 체크하면 됨
         * */
        
        if("afresh".equals(p_gubun)) {			//신규
	        P_NUM = pAfresh(request);
	        request.setAttribute("p_num", P_NUM);
        } else if("reissue".equals(p_gubun)) {  //재발급
	        P_NUM = pReissue(request);
	        request.setAttribute("p_num", P_NUM);
        } else {								//등록기준신고
        	 pRegister(request);
        }
	}
	
	 public void pRegister(HttpServletRequest request) throws Exception {
		 
			ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity viewCntEntity     = null;
	        
	        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
	        
	        String NUM = "disabled";
			
	        String selectSQL =
				" 	SELECT  COUNT(A.CHGBRE_SEQ) AS CNT     --변경사항  \n"+ 
				" 	    	FROM PT_R_BASIC_CHANGE_HISTORY A,   PT_COM_CODE B    \n"+ 
				" 			WHERE 	A.STA_CHG_CLASS_CODE = B.CODE(+)     \n"+ 	
				" 					AND B.P_CODE = 'REGDIV'    \n"+	
				" 					AND A.COI_WRT_NUM = '"+p_coi_wrt_num+"'    \n"+	
				" 					AND A.CHG_DT >     \n"+	
				" 									(SELECT MAX(NVL(C.CHG_DT,0)) FROM PT_R_BASIC_CHANGE_HISTORY  C   \n"+	
				" 									 WHERE    1=1 AND C.COI_WRT_NUM = '"+p_coi_wrt_num+"' AND A.STA_CHG_CLASS_CODE='R00002'   \n"+	
				" 									AND C.STA_CHG_CLASS_CODE  IN ('R00001', 'R00017', 'R00018' ,'R00016' ,'R00021' ,'R00006', 'R00005' ,'R00011', 'R00004'))  \n";

	        viewCntEntity = rDAO.select(selectSQL);
			 

	        
	       //변경사항
	        NUM = str2ReturnZero(viewCntEntity.getValue(0,"CNT"));
	        if(!"disabled".equals(NUM)) {
	        	NUM = "";
	        }
	        
	        request.setAttribute("p_num", NUM);
	 }	 
	
	
	 public String[] pAfresh(HttpServletRequest request) throws Exception {
		 
			ReportDAO    rDAO        = new ReportDAO();
	        ReportEntity viewCntEntity     = null;
	        
	        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
	        
	        String NUM[] = new String[23];
			
	        String etc_engineer_display = "NO";   //정보통신 기술자  48명 이상일경우..  추가 출력 으로 4쪽부터 다시 출력한다.
	        
	        for(int i=0; i < 23; i++) {
	        	NUM[i] = "disabled";
	        }
	        
	        
	        String selectSQL =
				" 	SELECT  COUNT(SEQ) AS CNT    --정보통신 기술자 현황 \n"+ 
				" 	    FROM  PT_R_ENGINEER_CHANGE    \n"+ 
				" 		WHERE 1 = 1  AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"')    \n"+ 	
				" 					 AND RET_YMD IS NULL    \n"+	
				" 	UNION ALL    \n"+	
				" 	SELECT  COUNT(*) AS CNT  --행정처분사항   \n"+	
				" 			FROM    \n"+	
				" 			(    \n"+	
				" 	 			PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)   \n"+	
				" 	  			LEFT JOIN ( SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMREQ' )PT_C1  \n"+	
				" 	 					ON PT_M.D_PER_CODE = PT_C1.CODE   \n"+	
				" 	  			LEFT JOIN ( SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 	  \n"+	
				" 	 					ON PT_M.DISPO_CONT = PT_C2.CODE   \n"+	
				" 	 			LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMSTE' )PT_C3 	   \n"+	
				" 	  					ON PT_M.MOT_STE = PT_C3.CODE    \n"+	
				" 	 			LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMCONT' )PT_C4 	   \n"+	
				" 	 					ON PT_M.VIOL_CONT_CODE = PT_C4.CODE  WHERE	1=1	   \n"+	
				" 			AND PT_M.TMP_WRT_NUM =(SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"')     \n";

	        viewCntEntity = rDAO.select(selectSQL);
			 
	       //정보통신기술자사항
	        NUM[4] = str2ReturnZero(viewCntEntity.getValue(0,"CNT"));
	         
	        int engineer_tmp=0;
	        if(!"disabled".equals(NUM[4])) {
	        	engineer_tmp = KJFUtil.str2int(NUM[4]);  
	        	NUM[4] = "";
	        }
	        
	        if(engineer_tmp > 6 && engineer_tmp <= 12) { NUM[5] = ""; }
	        if(engineer_tmp > 12 && engineer_tmp <= 18) { NUM[5] = ""; NUM[6] = ""; }
	        if(engineer_tmp > 18 && engineer_tmp <= 24) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; }
	        if(engineer_tmp > 24 && engineer_tmp <= 30) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; }
	        if(engineer_tmp > 30 && engineer_tmp <= 36) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; NUM[9] = ""; }
	        if(engineer_tmp > 36 && engineer_tmp <= 42) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; NUM[9] = ""; NUM[10] = ""; }
	        if(engineer_tmp > 42 ) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; NUM[9] = ""; NUM[10] = ""; NUM[11] = ""; }
	        
	        //정보통신 기술자  48명 이상일경우..  추가 출력 으로 4쪽부터 다시 출력을 위해 etc_engineer_display 를 yes 로 한다.
	        if(engineer_tmp > 48) { 
	        	etc_engineer_display="YES"; 
	        	NUM[15] = ""; 
	        }
	        if(engineer_tmp > 54 && engineer_tmp <= 60) {  NUM[15] = ""; NUM[16] = ""; }  
	        if(engineer_tmp > 60 && engineer_tmp <= 66) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; }  
	        if(engineer_tmp > 66 && engineer_tmp <= 72) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; }  
	        if(engineer_tmp > 72 && engineer_tmp <= 78) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; }  
	        if(engineer_tmp > 78 && engineer_tmp <= 84) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; NUM[20] = ""; }  
	        if(engineer_tmp > 84 && engineer_tmp <= 90) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; NUM[20] = ""; NUM[21] = ""; }  
	        if(engineer_tmp > 90 && engineer_tmp <= 96) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; NUM[20] = ""; NUM[21] = ""; NUM[22] = ""; }  
	        
	        
	        //행정처분사항
	        NUM[14] = str2ReturnZero(viewCntEntity.getValue(1,"CNT"));
	        if(!"disabled".equals(NUM[14])) {
	        	NUM[14] = "";
	        }
	        
	        request.setAttribute("etc_engineer_display", etc_engineer_display);  //기술자 48명 이상일 경우 활성
	        return NUM;
	 }
	
	 
	 public String[] pReissue(HttpServletRequest request) throws Exception {
		 
		ReportDAO    rDAO        = new ReportDAO();
        ReportEntity viewCntEntity     = null;

        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        String etc_engineer_display = "NO";   //정보통신 기술자  48명 이상일경우..  추가 출력 으로 4쪽부터 다시 출력한다.
        
        String NUM[] = new String[23];
		
        for(int i=0; i < 23; i++) {
        	NUM[i] = "disabled";
        }
		
        String selectSQL =
        	
				
			" 	SELECT    \n"+	
			" 		COUNT(PT_RWC.SEQ) AS CNT  --시공능력평가사항    \n"+	
			" 	  FROM PT_R_COMPANY_MASTER PT_RCM INNER JOIN PT_R_WORK_CAPABILITY PT_RWC ON PT_RCM.TMP_WRT_NUM = PT_RWC.TMP_WRT_NUM    \n"+	
			" 	  WHERE  PT_RWC.SEQ IN(SELECT MAX(SEQ) SEQ FROM   \n"+	
			" 	  		 PT_R_WORK_CAPABILITY PT_RWC  INNER JOIN PT_R_COMPANY_MASTER  PT_RCM   \n"+	
			" 	  		 ON PT_RCM.TMP_WRT_NUM = PT_RWC.TMP_WRT_NUM AND PT_RCM.COI_WRT_NUM ='"+p_coi_wrt_num+"')   \n"+  
			" 	UNION ALL    \n"+
			" 	SELECT  COUNT(SEQ) AS CNT    --정보통신 기술자 현황 \n"+ 
			" 	    FROM  PT_R_ENGINEER_CHANGE    \n"+ 
			" 		WHERE 1 = 1  AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"')    \n"+ 	
			" 					 AND RET_YMD IS NULL    \n"+	
			" 	UNION ALL   \n"+	
			" 	SELECT  COUNT(*) AS CNT  --행정처분사항   \n"+	
			" 			FROM    \n"+	
			" 			(    \n"+	
			" 	 			PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)   \n"+	
			" 	  			LEFT JOIN ( SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMREQ' )PT_C1  \n"+	
			" 	 					ON PT_M.D_PER_CODE = PT_C1.CODE   \n"+	
			" 	  			LEFT JOIN ( SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 	  \n"+	
			" 	 					ON PT_M.DISPO_CONT = PT_C2.CODE   \n"+	
			" 	 			LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMSTE' )PT_C3 	   \n"+	
			" 	  					ON PT_M.MOT_STE = PT_C3.CODE    \n"+	
			" 	 			LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMCONT' )PT_C4 	   \n"+	
			" 	 					ON PT_M.VIOL_CONT_CODE = PT_C4.CODE  WHERE	1=1	   \n"+	
			" 			AND PT_M.TMP_WRT_NUM =(SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"')     \n";

        viewCntEntity = rDAO.select(selectSQL);
		
        //시공능력평가사항
        NUM[3] = str2ReturnZero(viewCntEntity.getValue(0,"CNT"));
	    //정보통신기술자사항
        NUM[4] = str2ReturnZero(viewCntEntity.getValue(1,"CNT"));
        
        int engineer_tmp=0;
        if(!"disabled".equals(NUM[4])) {
        	engineer_tmp = KJFUtil.str2int(NUM[4]);  
        	NUM[4] = "";
        }
        
        if(engineer_tmp > 6 && engineer_tmp <= 12) { NUM[5] = ""; }
        if(engineer_tmp > 12 && engineer_tmp <= 18) { NUM[5] = ""; NUM[6] = ""; }
        if(engineer_tmp > 18 && engineer_tmp <= 24) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; }
        if(engineer_tmp > 24 && engineer_tmp <= 30) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; }
        if(engineer_tmp > 30 && engineer_tmp <= 36) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; NUM[9] = ""; }
        if(engineer_tmp > 36 && engineer_tmp <= 42) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; NUM[9] = ""; NUM[10] = ""; }
        if(engineer_tmp > 42 ) { NUM[5] = ""; NUM[6] = ""; NUM[7] = ""; NUM[8] = ""; NUM[9] = ""; NUM[10] = ""; NUM[11] = ""; }
        
        
       //정보통신 기술자  48명 이상일경우..  추가 출력 으로 4쪽부터 다시 출력을 위해 etc_engineer_display 를 yes 로 한다.
        if(engineer_tmp > 48) { 
        	etc_engineer_display="YES"; 
        	NUM[15] = ""; 
        }
        if(engineer_tmp > 54 && engineer_tmp <= 60) {  NUM[15] = ""; NUM[16] = ""; }  
        if(engineer_tmp > 60 && engineer_tmp <= 66) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; }  
        if(engineer_tmp > 66 && engineer_tmp <= 72) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; }  
        if(engineer_tmp > 72 && engineer_tmp <= 78) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; }  
        if(engineer_tmp > 78 && engineer_tmp <= 84) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; NUM[20] = ""; }  
        if(engineer_tmp > 84 && engineer_tmp <= 90) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; NUM[20] = ""; NUM[21] = ""; }  
        if(engineer_tmp > 90 && engineer_tmp <= 96) {  NUM[15] = ""; NUM[16] = ""; NUM[17] = ""; NUM[18] = ""; NUM[19] = ""; NUM[20] = ""; NUM[21] = ""; NUM[22] = ""; }  
        
        
        //행정처분사항
        NUM[14] = str2ReturnZero(viewCntEntity.getValue(2,"CNT"));
        if(!"disabled".equals(NUM[14])) {
        	NUM[14] = "";
        }
        
        request.setAttribute("etc_engineer_display", etc_engineer_display);  //기술자 48명 이상일 경우 활성
        return NUM;
	 }
	

	 
	 
	/*
	 * 공사업자 기본사항(2쪽) 
	 */
	private void basicsLoad(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity basicsEntity     = null;  //공사업자 기본정보
        
        ReportEntity refferEntity     = null;  
        
        
        
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	COMMANA_CLASS, NAME, COI_WRT_NUM, REP_SSN1, REP_SSN2, REP_NM_KOR, COM_NUM, BUSS_YMD,  PAY_CAP, ADDR_ADDR, ADDR_DETAIL_ADDR, REA_CAP  \n";	

        String fromSQL=
        	" 	FROM PT_R_COMPANY_MASTER  \n";	

        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND COI_WRT_NUM = '"+p_coi_wrt_num+"' \n";
        
        basicsEntity = rDAO.select(selectSQL + fromSQL + whereSQL);
        
        String refferSQL =
        	" SELECT distinct(A.SSN1||A.SSN2),A.SSN1, A.SSN2, A.NM_KOR \n"+ 
			" 	FROM PT_R_REFFER A WHERE   A.COI_WRT_NUM = '"+p_coi_wrt_num+"' AND (A.POS_CLASS='P1' OR   A.POS_CLASS='P4') AND NVL(A.DEL_YN,'N') != 'Y' \n";
        
        refferEntity = rDAO.select(refferSQL);
        
        int cnt = refferEntity.getRowCnt();
        String ceo_nm = basicsEntity.getValue(0, "REP_NM_KOR"); //공동대표 명
        
        String master_ssn = basicsEntity.getValue(0, "REP_SSN1")+basicsEntity.getValue(0, "REP_SSN2");
        String sub_ssn = "";
        
        int j = 0;
        
        for(int i=0; i < cnt; i++) {
        	sub_ssn = refferEntity.getValue(i, "SSN1")+refferEntity.getValue(i, "SSN2");
        	
        	if(j == 1) {
        		ceo_nm = ceo_nm + " 외 2명";
        		break;
        	}
        	
        	if(!master_ssn.equals(sub_ssn)) {
        		ceo_nm = ceo_nm + ", "+refferEntity.getValue(i, "NM_KOR");
        		j++;
        	}
        }
        
        request.setAttribute("ceo_nm", ceo_nm);  //기술자 48명 이상일 경우 활성
        request.setAttribute("basicsEntity", basicsEntity); //공사업자 기본정보
	}
	
	/*
	 * 시공능력평가사항(3쪽) 
	 */
	private void valuationLoad(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity valuationEntity     = null;
        
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			//" 	PT_RWC.*   \n";
			 " *  \n";
        String fromSQL=
        	//" 	FROM PT_R_COMPANY_MASTER PT_RCM INNER JOIN PT_R_WORK_CAPABILITY PT_RWC ON PT_RCM.COI_WRT_NUM = PT_RWC.COI_WRT_NUM  \n";	
        	" FROM PT_R_WORK_CAPABILITY A \n";
        String whereSQL = 
        	//" 	WHERE 1=1 \n"+
        	//" 	and PT_RWC.seq in(select max(seq) seq from \n"+
        	//" 	and PT_RWC.seq in(select nvl(max(to_number(seq)),0) seq from \n"+
        	//" 	PT_R_WORK_CAPABILITY PT_RWC  INNER JOIN PT_R_COMPANY_MASTER  PT_RCM \n"+
        	//" 	ON PT_RCM.COI_WRT_NUM = PT_RWC.COI_WRT_NUM AND PT_RCM.COI_WRT_NUM ='"+p_coi_wrt_num+"') \n"+
            //" 	AND PT_RCM.COI_WRT_NUM ='"+p_coi_wrt_num+"' \n";
        	" WHERE \n"+
        	" A.COI_WRT_NUM='"+p_coi_wrt_num+"' AND A.ASSE_DT = (SELECT MAX(ASSE_DT) FROM PT_R_WORK_CAPABILITY WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"') \n";
        
      
        valuationEntity = rDAO.select(selectSQL + fromSQL + whereSQL);
        
        request.setAttribute("valuationEntity", valuationEntity);
	}	
	
	/*
	 * 정보통신기술자사항( 4쪽 ~ 11쪽 )
	 */
	private void engineerLoad(HttpServletRequest request, RepublishParam pm) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity engineerEntity     = null;
        ReportEntity countEntity     = null;
        
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT A.*      		\n"+ 
			" 	 	FROM (		    \n"+	
			" 	  		SELECT rowNUM AS rNUM, B.*	\n"+	
			" 	  		FROM (	\n"+	
			" 	 			SELECT  ENGINEER_NM AS NM_KOR,TMP_WRT_NUM, SEQ, \n"+	
			" 	  		  			ENGINEER_SSN1 || ENGINEER_SSN2 AS SSN, TMP_FIELD||' '||CARE_BOOK_ISSUE_NUM AS ENGINEER_GRADE,	\n"+	
			" 	  					EMPL_YMD, RET_YMD,TMP_FIELD AS CODE_NAME,TMP_FIELD , \n"+	
			" 	  					CARE_BOOK_ISSUE_NUM,CARE_BOOK_VAL_START_DT,CARE_BOOK_VAL_END_DT   \n"+	
			" 	 			FROM PT_R_ENGINEER_CHANGE \n"+	
			" 	 			WHERE 1 = 1  AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"') \n"+	
			" 	 					 	 AND RET_YMD IS NULL  \n"+	
			//" 	 			ORDER BY NVL(CARE_BOOK_VAL_START_DT,0) ASC, NVL(CARE_BOOK_VAL_END_DT,0) ASC, EMPL_YMD,ENGINEER_SSN1 ASC  \n"+	
			" 	 			ORDER BY EMPL_YMD, ENGINEER_SSN1 ASC  \n"+
			" 	 		 ) B \n"+	 
			" 	 	) A 	 \n"+	
			" WHERE  rNUM>='"+pm.getSPage()+"' and rNUM<= '"+pm.getEPage()+"'	 		 \n";	
			
      
      
        engineerEntity = rDAO.select(selectSQL);
        
        String countSQL =		
			" SELECT COUNT(SEQ) CNT    \n"+	
			" 	 FROM PT_R_ENGINEER_CHANGE \n"+	
			" 	 WHERE 1 = 1  AND TMP_WRT_NUM = (SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"') \n"+	
			" 	 			  AND RET_YMD IS NULL  \n";	
			
     
      
        countEntity = rDAO.select(countSQL);
        
        request.setAttribute("engineerEntity", engineerEntity);
        request.setAttribute("countEntity", countEntity);
	}	
	
	
	/*
	 * 변경사항(12쪽 ~ 13쪽)  
	 */
	private void changeLoad(HttpServletRequest request, RepublishParam pm) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity changeEntity     = null;
        
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        String page = KJFUtil.print(request.getParameter("page"));
        String spage = "";
        String epage = "";
        

        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT A.*      		\n"+ 
			" 	 	FROM (		    \n"+	
			" 	  			SELECT rowNUM AS rNUM, B.*	\n"+	
			" 	  				FROM (	\n"+	
			" 	  					SELECT  A.CHGBRE_SEQ, 	\n"+	
			" 	  							CASE A.STA_CHG_CLASS_CODE	\n"+	
			" 	  								WHEN 'R00007' THEN A.ADDR_ADDR || ' ' || A.ADDR_DETAIL_ADDR 	\n"+	
			" 	  								WHEN 'R00008' THEN A.REA_CAP	\n"+	
			" 	  								WHEN 'R00009' THEN A.REP_NM_KOR  	\n"+	
			" 	  								WHEN 'R00002' THEN '충족 (다음신고예정일:' || TO_CHAR(ADD_MONTHS(BAS_STA_DT, 36), 'yyyy/mm/dd') || ')'  	\n"+	
			" 	  								WHEN 'R00010' THEN A.NAME     END AS VALUE,  	\n"+	
			" 	  							B.CODE_NAME,  A.CHG_DT,'' AS CONFIRM  	\n"+	
			" 	  			FROM PT_R_BASIC_CHANGE_HISTORY A,   PT_COM_CODE B 	\n"+	
			" 	  			WHERE    1=1 	\n"+	
			" 	  					 AND A.STA_CHG_CLASS_CODE = B.CODE(+) 	\n"+	
			" 	  					 AND B.P_CODE = 'REGDIV' 	\n"+	
			" 	  					 AND A.COI_WRT_NUM = '"+p_coi_wrt_num+"' AND A.STA_CHG_CLASS_CODE='R00002' 	\n"+	
			" 	  					 AND A.CHG_DT >	\n"+	
			" 	  									(SELECT MAX(NVL(C.CHG_DT,0)) FROM PT_R_BASIC_CHANGE_HISTORY  C  	\n"+	
			" 	  											WHERE    1=1 AND C.COI_WRT_NUM = '"+p_coi_wrt_num+"'  	\n"+	
			" 	  														 AND C.STA_CHG_CLASS_CODE  IN ('R00001', 'R00017', 'R00018' ,'R00016' ,'R00021' ,'R00006', 'R00005' ,'R00011', 'R00004')) 	\n"+	
			" 	  			ORDER BY A.CHG_DT ASC 	\n"+	
			" 	  	) B		\n"+	
			" 	) A   			\n";	
	
        changeEntity = rDAO.select(selectSQL);
        
        request.setAttribute("changeEntity", changeEntity);
	}
	
	/*
	 * 행정처분사항(14쪽)
	 */
	private void adm_disLoad(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity adm_disEntity     = null;
        
        String p_coi_wrt_num = KJFUtil.print(request.getParameter("coi_wrt_num"));  //등록번호
        
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT  '0' AS CHECKER, PT_C.NAME,      		\n"+ 
			" 	 	PT_M.*, '' AS CONFIRM,	    \n"+	
			" 	  	PT_C1.CODE_NAME AS TMPD_PER_CODE, 			\n"+	
			" 	  	PT_C2.CODE_NAME AS TMPDISPO_CONT,			\n"+	
			" 	  	PT_C3.CODE_NAME AS TMPMOT_STE,			\n"+	
			" 	  	PT_C4.CODE_NAME AS VIOL_CONT			\n"+	
			" 	  	FROM 			\n"+	
			" 	  	(			\n"+	
			" 	  		PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)		\n"+	
			" 	  				LEFT JOIN ( SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMREQ' )PT_C1 	\n"+	
			" 	  					 ON PT_M.D_PER_CODE = PT_C1.CODE		\n"+	
			" 	  				LEFT JOIN ( SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMPRO' )PT_C2 	\n"+	
			" 	  					 ON PT_M.DISPO_CONT = PT_C2.CODE	\n"+	
			" 	  				LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMSTE' )PT_C3 	\n"+	
			" 	  					 ON PT_M.MOT_STE = PT_C3.CODE  	\n"+	
			" 	  				LEFT JOIN (SELECT P_CODE, CODE, CODE_NAME FROM PT_COM_CODE  WHERE P_CODE = 'PTMCONT' )PT_C4 	\n"+	
			" 	  					 ON PT_M.VIOL_CONT_CODE = PT_C4.CODE  WHERE	1=1	\n"+	
			" AND PT_M.TMP_WRT_NUM =(SELECT TMP_WRT_NUM FROM PT_R_COMPANY_MASTER WHERE COI_WRT_NUM = '"+p_coi_wrt_num+"')	  ORDER BY DISPO_DT ASC				\n";		
	
        adm_disEntity = rDAO.select(selectSQL);
        
        request.setAttribute("adm_disEntity", adm_disEntity);
	}

	
    private RepublishParam checkPage(ActionForm form, String page)throws Exception{
    	
    	RepublishParam pm = (RepublishParam)form;
    	
    	// 정보통신기술자사항 page 값
        if("4".equals(page)) {
        	pm.setSPage("1");
        	pm.setEPage("6");
        } else if("5".equals(page)) {
        	pm.setSPage("7");
        	pm.setEPage("12");
        } else if("6".equals(page)) {
        	pm.setSPage("13");
        	pm.setEPage("18");
        } else if("7".equals(page)) {
        	pm.setSPage("19");
        	pm.setEPage("24");
        } else if("8".equals(page)) {
        	pm.setSPage("25");
        	pm.setEPage("30");
        } else if("9".equals(page)) {
        	pm.setSPage("31");
        	pm.setEPage("36");
        } else if("10".equals(page)) {
        	pm.setSPage("37");
        	pm.setEPage("42");
        } else if("11".equals(page)) {
        	pm.setSPage("43");
        	pm.setEPage("48");
        } 
        
        //추가 기술자
        else if("15".equals(page)) {
        	pm.setSPage("49");
        	pm.setEPage("54");
        } else if("16".equals(page)) {
        	pm.setSPage("55");
        	pm.setEPage("60");
        } else if("17".equals(page)) {
        	pm.setSPage("61");
        	pm.setEPage("66");
        } else if("18".equals(page)) {
        	pm.setSPage("67");
        	pm.setEPage("72");
        } else if("19".equals(page)) {
        	pm.setSPage("73");
        	pm.setEPage("78");
        } else if("20".equals(page)) {
        	pm.setSPage("79");
        	pm.setEPage("84");
        } else if("21".equals(page)) {
        	pm.setSPage("85");
        	pm.setEPage("90");
        } else if("22".equals(page)) {
        	pm.setSPage("91");
        	pm.setEPage("96");
        }
        
        return pm;

    }
	
    public  static String str2ReturnZero(String srt) {

        if(srt.equals("0") )
            return "disabled";
        else
            return srt;
    }
    
}
