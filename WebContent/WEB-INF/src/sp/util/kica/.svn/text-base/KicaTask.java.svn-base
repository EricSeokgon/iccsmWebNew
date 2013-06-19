package sp.util.kica;

import kjf.db.TX_MGR;
import kjf.ops.ReportEntity;

public class KicaTask {

	private KicaTaskDAO taskdao = new KicaTaskDAO();
	private SildbTaskDAO sildbdao = new SildbTaskDAO();

	public void getKicaDB() throws Exception {
		
		// NOTE. ICS_TRANS_DT 컬럼은 가장 마지막에 있어야 됨. INSERT 부분에서 마지막에 오늘 날짜 강제 기입.
		
		KicaLog.log("=====================getKicaDB() start==============================");

		// NOTE. 아래 header 변수는 keyRegYn이 true인 일 경우 SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM 의 순이어야 함. 
		
		// 2010.07.26. 현시점에선 아직 ENGINEER_GRADE_NM 컬럼이 존재하지 않음.
		String header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, ENGINEER_NM, ENGINEER_SSN1, " +
				"ENGINEER_SSN2, EMPL_YMD, RET_YMD, WRT_CHG_DT, CHG_STA_DT, SEQ_SUB, " +
				"CUD_FLAG, KICA_INS_DT, CARE_BOOK_ISSUE_NUM, ENGINEER_GRADE, ICS_TRANS_DT";
		
		String tbName = "PT_TMP_ENGINEER_CHANGE";	//임시 기술자
		getKicaOneTable(header, tbName, true);

		
		header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, REP_SSN1, REP_SSN2, REP_NM_KOR, REP_NM_HAN, " +
				"CHG_STA_DT, WRT_CHG_DT, CUD_FLAG, KICA_INS_DT, SEQ_LINK, ICS_TRANS_DT ";
		
		tbName = "PT_TMP_REP_CHANGE";				// 임시대표자변경
		getKicaOneTable(header, tbName, true);

		header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, NAME, CHG_STA_DT, WRT_CHG_DT, CUD_FLAG, " +
				"KICA_INS_DT, SEQ_LINK, ICS_TRANS_DT ";
		tbName = "PT_TMP_NAME_CHANGE";
		getKicaOneTable(header, tbName, true);

		header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, ADDR_POST_NUM, ADDR_ADDR, ADDR_DETAIL_ADDR, " +
				"ADDR_TEL_NUM, ADDR_FAX_NUM, OFFICE_AREA, CHG_STA_DT, WRT_CHG_DT, CUD_FLAG, " +
				"KICA_INS_DT, SEQ_LINK, ICS_TRANS_DT ";
		tbName = "PT_TMP_ADDR_CHANGE";
		getKicaOneTable(header, tbName, true);

		header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, COMPANY_DIAG_BAS_DT, DIAG_ORG_CODE, " +
				"DIAG_ORG_CODE_NM, DIAG_NM_NM, PAY_CAP, REA_CAP, TUP_AOM, CHG_STA_DT, WRT_CHG_DT, " +
				"CUD_FLAG, KICA_INS_DT, SEQ_LINK, ICS_TRANS_DT ";
		tbName = "PT_TMP_CAPITAL_CHANGE";
		getKicaOneTable(header, tbName, true);

		header = " SEQ, CARE_BOOK_ISSUE_NUM, ENGINEER_SSN, ENGINEER_GRADE, ENGINEER_GRADE_NM, " +
				"NM_KOR, NM_HAN, CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, CUD_FLAG, " +
				"CHG_FILD, CHG_FILD_NM, KICA_INS_DT, ICS_TRANS_DT ";
		tbName = "PT_TMP_ENGINEER";
		getKicaOneTable(header, tbName, false);

		header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, YEAR, WORK_ROM, CUD_FLAG, KICA_INS_DT, ICS_TRANS_DT ";
		tbName = "PT_TMP_WORK_RESULTS";
		getKicaOneTable(header, tbName, true);

		//
		header = " SEQ, COI_WRT_NUM, SIDO_CODE, MANA_NUM, ASSE_DT, ASSE_AOM, APPL_TERM_START_DT, " +
				"APPL_TERM_END_DT, CUD_FLAG, KICA_INS_DT, SEQ_LINK, ICS_TRANS_DT ";
		tbName = "PT_TMP_WORK_CAPABILITY";
		getKicaOneTable(header, tbName, true);
		//
	}

	// TMP >> 실디비 이관
	public void getKicaDBProcess() throws Exception {
		// 이전될 데이터는 pt_tmp_receive_key 에 모든 키가 저장되 있음
		KicaLog.logSilEx( ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" );
		String TMP_TB_NM = "";
		ReportEntity rEntity = taskdao.getReceiveKeyEnt();
		if (rEntity != null && rEntity.getRowCnt() != 0) {
			try {
				//트랜잭션이 물려야 됨 : 한꺼번에 올 롤백 처리 해야 됨
				TX_MGR.begin("KJF");
				String TB_NM, SEQ, COI_WRT_NUM, INS_DT, SIDO_CODE, MANA_NUM, TMP_WRT_NUM;
				
	    		for(int i=0;i<rEntity.getRowCnt();i++){
	    			TB_NM = TMP_TB_NM= rEntity.getValue(i, "TB_NM");
	    			SEQ			= rEntity.getValue(i, "SEQ");
	    			COI_WRT_NUM = rEntity.getValue(i, "COI_WRT_NUM");
	    			TMP_WRT_NUM = rEntity.getValue(i, "TMP_WRT_NUM");
	    			SIDO_CODE	= rEntity.getValue(i, "SIDO_CODE");
	    			
	    			//sildbdao.icsToSildb(TB_NM, SEQ, TMP_WRT_NUM, COI_WRT_NUM, INS_DT, SIDO_CODE, MANA_NUM);
	    			sildbdao.icsToSildb(TB_NM, SEQ, TMP_WRT_NUM, COI_WRT_NUM, SIDO_CODE);
	    		}
				TX_MGR.commit(); // db commit

			} catch (Exception e) {
				TX_MGR.rollback(); // db rollbacd
				KicaLog.log(e.toString());
				KicaLog.log(e.fillInStackTrace());
				try {
					TX_MGR.begin("KJF");
					taskdao.insTransLog("S", TMP_TB_NM, e.toString(), "Y");
					TX_MGR.commit(); // db commit
				} catch (Exception ex) {
					TX_MGR.rollback(); // db rollbacd
					KicaLog.log(e.toString());
					KicaLog.log(e.fillInStackTrace());
				}
			}
		}
	}

	// KICA >> TMP 이관
	public void getKicaOneTable(String header, String tbName, boolean keyRegYn)
			throws Exception {

		// KicaTaskDAO taskdao = new KicaTaskDAO();
		try {
			TX_MGR.begin("KJF");
			taskdao.kicaToIcs(header, tbName, keyRegYn);
			TX_MGR.commit(); // db commit

		} catch (Exception e) {
			TX_MGR.rollback(); // db rollbacd
			KicaLog.log(e.toString());
			KicaLog.log(e.fillInStackTrace());
			try {
				TX_MGR.begin("KJF");
				taskdao.insTransLog("D", tbName, e.toString(), "Y");
				TX_MGR.commit(); // db commit
			} catch (Exception ex) {
				TX_MGR.rollback(); // db rollbacd
				KicaLog.log(e.toString());
				KicaLog.log(e.fillInStackTrace());
			}
		}
	}

	public void setKicaDB() throws Exception {
		System.out
				.println("=====================setKicaDB() 시작=====================");
		KicaTaskDAO taskdao = new KicaTaskDAO();
		ReportEntity rEntity = null;

		try {
			TX_MGR.begin("KJF");

			rEntity = taskdao.getTransKeyEnt();
			if (rEntity.getRowCnt() == 0) {
				// 가져올 데이타 없음
				taskdao.insTransLog("U", "", "전송할 데이타가 없습니다.!", "N");
				TX_MGR.commit(); // db commit
				return;
			}

			TX_MGR.commit(); // db commit

		} catch (Exception e) {
			TX_MGR.rollback(); // db rollbacd
			KicaLog.log(e.toString());
			KicaLog.log(e.fillInStackTrace());
		}

		try {
			// transaction 단위
			for (int i = 0; i < rEntity.getRowCnt(); i++) {
				TX_MGR.begin("KJF");
				String WORK_CLASS_CODE = rEntity.getValue(i, "WORK_CLASS_CODE");
				taskdao.transLow(rEntity.getValue(i, "SEQ"), 
								rEntity.getValue(i, "WORK_CLASS_CODE"), 
								rEntity.getValue(i, "KEY1"),
								rEntity.getValue(i, "KEY2"), 
								rEntity.getValue(i, "KEY3"),
								rEntity.getValue(i,"CUD_FLAG"));

				TX_MGR.commit(); // db commit
			}

		} catch (Exception e) {
			TX_MGR.rollback(); // db rollbacd
			KicaLog.log(e.toString());
			KicaLog.log(e.fillInStackTrace());
			try {
				TX_MGR.begin("KJF");
				taskdao.insTransLog("U", "", e.toString(), "Y");
				TX_MGR.commit(); // db commit
			} catch (Exception ex) {
				TX_MGR.rollback(); // db rollbacd
				KicaLog.log(e.toString());
				KicaLog.log(e.fillInStackTrace());
			}
		}

	}

}
