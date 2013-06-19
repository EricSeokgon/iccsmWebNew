package sp.util.sync;

import java.util.ArrayList;
import java.util.List;

import kjf.db.TX_MGR;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;



public class SyncTask {
	
	SyncTaskDAO taskdao = new SyncTaskDAO();
	String tableName="";
	String coiWrtNum="";
	String tmpWrtNum="";
	
	/**
	 * ��ȸ�ý��ۿ��� data�� ������ �λ��û ������ �����Ѵ�.
	 * @throws Exception
	 */
	public void getTablesData() throws Exception{
		
		String header = "REGIST_NO, ICS_SIDO, BUSS_YMD, JURIDICAL_PERSON_GB, VAT_NO, JURIDICAL_NO, FIRM_NM_KOR, REP_CERTI_RESI_NO_1, REP_CERTI_RESI_NO_2, REP_NM_KOR, REP_NM_CHI, SITE_ZIP_CD, SITE_ADDR_1, SITE_ADDR_2, PHONE_NO_OFFICE, FAX_NO_OFFICE, OFFICE_SPACE, DIAGNOS_AGENCY_GB, DIAGNOS_AGENCY, PAY_IN_CAPITAL_AMT_K, REAL_CAPITAL_AMT_K, UNION_INVEST_AMT_K";
		String tbName = "TB_ICS_SAUPJA_MT";				// ������ ���̺�		
		String where = "";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, SIDE_REGIST_NO, SIDE_JOB_GB";
		tbName = "TB_ICS_KYUMUP_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, SILJUK_YEAR, SILJUK_AMT";
		tbName = "TB_ICS_SILJUK_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);	
		
		header = "REGIST_NO, EVAL_YMD, EVAL_AMT, STRART_YMD";
		tbName = "TB_ICS_EVALMAIN_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, ICS_SIDO, PUNISH_AGENCY, PUNISH_LIST, PUNISH_NM, START_YMD, STOP_YMD, PUNISH_REASON, PUNISH_YMD";
		tbName = "TB_ICS_PUNISH_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, ACCEPT_NO, JUMIN_NO1, JUMIN_NO2, DAEPYO_NM, CHANGE_YMD";
		tbName = "TB_ICS_DAEPYO_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);

		header = "REGIST_NO, ACCEPT_NO, SANGHO_NM, CHANGE_YMD";
		tbName = "TB_ICS_SANGHO_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, ACCEPT_NO, ZIP_CD, ADDR_1, ADDR_2, OFFICE_AREA, PHONE_NO, FAX_NO, CHANGE_YMD";
		tbName = "TB_ICS_SOJAEJI_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, ACCEPT_NO, AGENCY_GB, AGENCY_NM, AGENCY_YMD, PAY_AMT, REAL_AMT, INVEST_AMT, CHANGE_YMD";
		tbName = "TB_ICS_JABON_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);
		
		
		header = "REGIST_NO, ACCEPT_NO, JOB_GB, REPORT_NO, REGIST_NO_BEFO, REGIST_NO_AFTER, CHANGE_YMD";
		tbName = "TB_ICS_HISTORY_DT";				
		where = " where (REGIST_NO!='120573' and ACCEPT_NO!='20110034' and CHANGE_YMD !='20110325')";
		getKicaOneTable(header, tbName, where);
		
		header = "REGIST_NO, ACCEPT_NO, ACCEPT_OFFICE, JUMIN_NO, NM_KOR, NM_CHI, FOREINER_YN, CHANGE_YMD";
		tbName = "TB_ICS_REP_DT";				
		where = "";
		getKicaOneTable(header, tbName, where);		
		
		
	}

	
	// KICA >> TMP �̰�
	public void getKicaOneTable(String header, String tbName, String where) throws Exception{

		 
		try {
			TX_MGR.begin("KJF");
			taskdao.insertOneTable(header, tbName, where);
			TX_MGR.commit(); // db commit

		} catch (Exception e) {
			TX_MGR.rollback(); // db rollbacd
			//SyncLog.log(e.toString());
			//SyncLog.log(e.fillInStackTrace());
			throw e;

		}
	}
	
	/**
	 * ��ȸ�� ������ ��
	 * @throws Exception
	 */
	public void compareAllData(){
		
		try {
			TX_MGR.begin("KJF");
			
			//1.�λ��û ����������� ��ü ��������
			ReportEntity rEntity	= taskdao.getMasterEnt();
			
			for (int i = 0; i < rEntity.getRowCnt(); i++ ){
				
				String COI_WRT_NUM = rEntity.getValue(i, "COI_WRT_NUM");
				String TMP_WRT_NUM = rEntity.getValue(i, "TMP_WRT_NUM");
				
				
				//1.1. master ��
				cpMaster(COI_WRT_NUM,  TMP_WRT_NUM, rEntity, i);
				//1.2. ��� ��
				cpSubDiary(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.3. �������
				cpWorkResults(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.4. �ð��ɷ���
				cpWorkCapability(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.5. ����ó��
				//cpM(COI_WRT_NUM, TMP_WRT_NUM);
				
//				//1.6. ����ں���
//				cpEngineer(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.7. ��ǥ�ں���
				//cpChgRep(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.8. ��ȣ����
				cpChgCom(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.9. ����������
				//cpChgAddr(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.10. �ں��� ����
				cpChgMoney(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.11. ����
				cpHistory(COI_WRT_NUM, TMP_WRT_NUM);
				
				//1.12. ������ǥ
				cpReffer(COI_WRT_NUM, TMP_WRT_NUM);
			}
			
			
			//2.��ȸ ����� ������ �� ����� ��ȣ ��ü ��������(������ �����ü �� ����)
			rEntity	= taskdao.getOmitedKicaMasterEnt();
			for (int i = 0; i < rEntity.getRowCnt(); i++ ){
				SyncLog.logData("������ �����ü :COI_WRT_NUM(REGIST_NO) : "+rEntity.getValue(i, "REGIST_NO")+ " :��ȣ : "+rEntity.getValue(i, "FIRM_NM_KOR"));
			}
			
						
			TX_MGR.commit(); // db commit
		} catch (Exception e){
			TX_MGR.rollback(); // db rollbacd
			SyncLog.log(e.toString());
			SyncLog.log(e.fillInStackTrace());	
			
		}

	}
	
	
	
	


	/**
	 * ����� ������ ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @param netREnt
	 * @param i
	 * @throws Exception
	 */
	
	public void cpMaster( String COI_WRT_NUM, String TMP_WRT_NUM, ReportEntity netREnt, int i) throws Exception{
		
		tableName="PT_R_COMPANY_MASTER";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		
		ReportEntity kicaREnt = taskdao.getKicaMasterEnt( COI_WRT_NUM);
		
		cpAndLog( "SIDO_CODE", netREnt.getValue(i, "SIDO_CODE"), kicaREnt.getValue(0, "ICS_SIDO"));//�õ��ڵ�
		cpAndLog( "BUSS_YMD", netREnt.getValue(i, "BUSS_YMD"), kicaREnt.getValue(0, "BUSS_YMD"));//�������������
		cpAndLog( "COMMANA_CLASS", netREnt.getValue(i, "COMMANA_CLASS"), kicaREnt.getValue(0, "JURIDICAL_PERSON_GB")); //���λ���ڱ���
		cpAndLog( "MANA_NUM", netREnt.getValue(i, "MANA_NUM"), kicaREnt.getValue(0, "VAT_NO"));//����ڹ�ȣ
		cpAndLog( "COM_NUM", netREnt.getValue(i, "COM_NUM"), kicaREnt.getValue(0, "JURIDICAL_NO"));//���ι�ȣ
		cpAndLog( "NAME", netREnt.getValue(i, "NAME"), kicaREnt.getValue(0, "FIRM_NM_KOR")); //��ȣ
		cpAndLog( "REP_SSN1", netREnt.getValue(i, "REP_SSN1"), kicaREnt.getValue(0, "REP_CERTI_RESI_NO_1"));//��ǥ���ֹι�ȣ1
		cpAndLog( "REP_SSN2", netREnt.getValue(i, "REP_SSN2"), kicaREnt.getValue(0, "REP_CERTI_RESI_NO_2"));//��ǥ���ֹι�ȣ2
		cpAndLog( "REP_NM_KOR", SyncUtil.removeBlank(netREnt.getValue(i, "REP_NM_KOR")), SyncUtil.removeBlank(kicaREnt.getValue(0, "REP_NM_KOR"))); //��ǥ�ڼ����ѱ�
		cpAndLog( "REP_NM_HAN", SyncUtil.removeBlank(netREnt.getValue(i, "REP_NM_HAN")), SyncUtil.removeBlank(kicaREnt.getValue(0, "REP_NM_CHI")));//��ǥ�ڼ�������
		//cpAndLog( "ADDR_POST_NUM", netREnt.getValue(i, "ADDR_POST_NUM"), kicaREnt.getValue(0, "SITE_ZIP_CD"));//�����������ȣ
		//cpAndLog( "ADDR_ADDR", SyncUtil.removeBlank(netREnt.getValue(i, "ADDR_ADDR")), SyncUtil.removeBlank(kicaREnt.getValue(0, "SITE_ADDR_1"))); //�������ּ�		
		//cpAndLog( "ADDR_DETAIL_ADDR", SyncUtil.removeBlank(netREnt.getValue(i, "ADDR_DETAIL_ADDR")), SyncUtil.removeBlank(kicaREnt.getValue(0, "SITE_ADDR_2")));//���������ּ�
		
		String ADDR_TEL_NUM = SyncUtil.removeBlank(netREnt.getValue(i, "ADDR_TEL_NUM")).replace("-", "").replace(")", "");
		String PHONE_NO_OFFICE = SyncUtil.removeBlank(kicaREnt.getValue(0, "PHONE_NO_OFFICE")).replace("-", "").replace(")", "");
//		cpAndLog( "ADDR_TEL_NUM", ADDR_TEL_NUM , PHONE_NO_OFFICE );//��������ȭ��ȣ
		
		String ADDR_FAX_NUM = SyncUtil.removeBlank(netREnt.getValue(i, "ADDR_FAX_NUM")).replace("-", "").replace(")", "");
		String FAX_NO_OFFICE = SyncUtil.removeBlank(kicaREnt.getValue(0, "FAX_NO_OFFICE")).replace("-", "").replace(")", "");
//		cpAndLog( "ADDR_FAX_NUM", ADDR_FAX_NUM , FAX_NO_OFFICE ); //�������ѽ���ȣ
		
		cpAndLog( "OFFICE_AREA", netREnt.getValue(i, "OFFICE_AREA"), kicaREnt.getValue(0, "OFFICE_SPACE"));//�繫�Ǹ���
//		cpAndLog( "DIAG_ORG_CODE", netREnt.getValue(i, "DIAG_ORG_CODE"), SyncUtil.getDigDiv(kicaREnt.getValue(0, "DIAGNOS_AGENCY_GB")));//���ܱ���ڵ�
//		cpAndLog( "DIAG_NM_NM + DIAG_NM_WRT_NUM", SyncUtil.removeBlank(netREnt.getValue(i, "DIAG_NM_NM")+netREnt.getValue(i, "DIAG_NM_WRT_NUM")), SyncUtil.removeBlank(kicaREnt.getValue(0, "DIAGNOS_AGENCY"))); //���ܱ����(������ ���� +�����ڵ�Ϲ�ȣ)
		cpAndLog( "PAY_CAP", netREnt.getValue(i, "PAY_CAP"), kicaREnt.getValue(0, "PAY_IN_CAPITAL_AMT_K")); //�����ں���
		cpAndLog( "REA_CAP", netREnt.getValue(i, "REA_CAP"), kicaREnt.getValue(0, "REAL_CAPITAL_AMT_K"));//�����ں���
		//cpAndLog( "TUP_AOM", netREnt.getValue(i, "TUP_AOM"), kicaREnt.getValue(0, "UNION_INVEST_AMT_K"));//��ġ�ݾ�				
	}
	
	
	/**
	 * ��� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	public void cpSubDiary( String COI_WRT_NUM, String TMP_WRT_NUM ) throws Exception{
		
		tableName="PT_R_SUBSIDIARY";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetSubDiaryEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaSubDiaryEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){
				
				String SIDE_JOB_GB ="";
				if(!KJFUtil.isEmpty(kicaREnt.getValue(j, "SIDE_JOB_GB"))){
					SIDE_JOB_GB = "SUBS" + SyncUtil.removeBlank(kicaREnt.getValue(j, "SIDE_JOB_GB"));
				}
					
				 if(netREnt.getValue(i, "SUB_CODE").equals(SIDE_JOB_GB) &&
						 netREnt.getValue(i, "SUB_WRT_NUM").equals(kicaREnt.getValue(j, "SIDE_REGIST_NO"))	 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "SUB_CODE")+", "+   //����ڵ�
						netREnt.getValue(i, "SUB_WRT_NUM")      //�����Ϲ�ȣ 
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "SIDE_JOB_GB")+", "+   //����ڵ�
					kicaREnt.getValue(j, "SIDE_REGIST_NO")      //�����Ϲ�ȣ 
					);		
			
			
			String insertSql=
				" INSERT                          \n" +
				" INTO PT_R_SUBSIDIARY            \n" +
				"   (                             \n" +
				" 	SEQ,        	          \n" +
				" 	TMP_WRT_NUM,		  \n" +
				" 	SUB_WRT_NUM,	          \n" +
				" 	SUB_CODE,   	          \n" +
				" 	WRT_ID,     		  \n" +
				" 	UPD_DT,     		  \n" +
				" 	INS_DT      		  \n" +
				"   )                             \n" +
				"   VALUES                        \n" +
				"   (                             \n" +
				" 	(SELECT TO_CHAR(NVL(MAX(TO_NUMBER(SEQ)), 0) + 1) tmp FROM PT_R_SUBSIDIARY WHERE TMP_WRT_NUM = '"+tmpWrtNum+"'), \n" +
				" 	'"+tmpWrtNum+"',               \n" +
				" 	'"+kicaREnt.getValue(j, "SIDE_REGIST_NO")+"',                         \n" +
				" 	'SUBS"+kicaREnt.getValue(j, "SIDE_JOB_GB")+"',                        \n" +
				" 	'T2_SUBSIDIARY',                                                 \n" +
				" 	null,                       			                 \n" +
				" 	'"+KJFDate.getCurDatetime()+"'                          	 \n" +
				"  )                                               			 \n" ;
			
			SyncLog.logData(insertSql);
			
			
			
		}
		
	}	
	
	/**
	 * ������� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpWorkResults(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_WORK_RESULTS";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetWorkResultsEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaWorkResultsEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "YEAR").equals(kicaREnt.getValue(j, "SILJUK_YEAR")) &&
						 netREnt.getValue(i, "WORK_ROM").equals(kicaREnt.getValue(j, "SILJUK_AMT"))	 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "YEAR")+", "+   //�⵵
						netREnt.getValue(i, "WORK_ROM")      //��������� 
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "SILJUK_YEAR")+", "+   //�⵵
					kicaREnt.getValue(j, "SILJUK_AMT")      //��������� 
					);			
		}
		
	}	

	
	/**
	 * �ð��ɷ��� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpWorkCapability(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_WORK_CAPABILITY";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetWorkCapabilityEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaWorkCapabilityEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "ASSE_DT").equals(kicaREnt.getValue(j, "EVAL_YMD")) &&
						 netREnt.getValue(i, "ASSE_AOM").equals(kicaREnt.getValue(j, "EVAL_AMT"))	 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "ASSE_DT")+", "+   //������
						netREnt.getValue(i, "ASSE_AOM")      //�򰡱ݾ� 
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "EVAL_YMD")+", "+   //������
					kicaREnt.getValue(j, "EVAL_AMT")      //�򰡱ݾ� 
					);			
		}
		
	}		

	
	/**
	 * ����ó�� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpM(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_M_MASTER";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetMEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaMEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(SyncUtil.removeBlank(netREnt.getValue(i, "PUNISHMENT_AGENCY")).equals(SyncUtil.removeBlank(kicaREnt.getValue(j, "PUNISH_AGENCY"))) && //ó�б��
						 netREnt.getValue(i, "DISPO_CONT").equals(SyncUtil.getDispoCD(kicaREnt.getValue(j, "PUNISH_LIST"))) &&  //ó�г����ڵ�
						 SyncUtil.removeBlank(netREnt.getValue(i, "DISPO_CONT_NM")).equals(SyncUtil.removeBlank(kicaREnt.getValue(j, "PUNISH_NM"))) && //ó�г����ڵ��	 
						 netREnt.getValue(i, "BUSISUSP_START_DT").equals(kicaREnt.getValue(j, "START_YMD")) &&  //ó�н�����
						 netREnt.getValue(i, "BUSISUSP_END_DT").equals(kicaREnt.getValue(j, "STOP_YMD")) &&  //ó��������
						 SyncUtil.removeBlank(netREnt.getValue(i, "DISPO_CAUSE")).equals(SyncUtil.removeBlank(kicaREnt.getValue(j, "PUNISH_REASON"))) &&  //ó�л���
						 netREnt.getValue(i, "DISPO_DT").equals(kicaREnt.getValue(j, "PUNISH_YMD"))   //ó������
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "PUNISHMENT_AGENCY")+", "+   
						netREnt.getValue(i, "DISPO_CONT")+", "+   
						netREnt.getValue(i, "DISPO_CONT_NM")+", "+   
						netREnt.getValue(i, "BUSISUSP_START_DT")+", "+   
						netREnt.getValue(i, "BUSISUSP_END_DT")+", "+   
						netREnt.getValue(i, "DISPO_CAUSE")+", "+   
						netREnt.getValue(i, "DISPO_DT")       
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "PUNISH_AGENCY")+", "+ 
					SyncUtil.getDispoCD(kicaREnt.getValue(j, "PUNISH_LIST"))+", "+  
					kicaREnt.getValue(j, "PUNISH_NM")+", "+  
					kicaREnt.getValue(j, "START_YMD")+", "+  
					kicaREnt.getValue(j, "STOP_YMD")+", "+  
					kicaREnt.getValue(j, "PUNISH_REASON")+", "+  
					kicaREnt.getValue(j, "PUNISH_YMD")      
					);			
		}
		
	}	
	
	/**
	 * ��������� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpEngineer(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_ENGINEER_CHANGE";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetEngineerEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaEngineerEnt( TMP_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "ENGINEER_NM").equals(kicaREnt.getValue(j, "ENGINEER_NM")) &&
						 netREnt.getValue(i, "ENGINEER_SSN1").equals(kicaREnt.getValue(j, "ENGINEER_SSN1"))	 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "ENGINEER_NM")+", "+   //������
						netREnt.getValue(i, "ENGINEER_SSN1")      //�򰡱ݾ� 
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "k")+", "+   //������
					kicaREnt.getValue(j, "k")      //�򰡱ݾ� 
					);			
		}
	}	
	
	/**
	 * ��ǥ�� ���� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpChgRep(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_BASIC_CHANGE_HISTORY(��ǥ�ں���)";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetChgRepEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaChgRepEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "CHG_DT").equals(kicaREnt.getValue(j, "CHANGE_YMD")) &&			//��������
						 netREnt.getValue(i, "REP_SSN1").equals(kicaREnt.getValue(j, "JUMIN_NO1")) &&	//��ǥ�ֹ�1
						 netREnt.getValue(i, "REP_SSN2").equals(kicaREnt.getValue(j, "JUMIN_NO2")) &&	//��ǥ�ֹ�2
						 SyncUtil.removeBlank(netREnt.getValue(i, "REP_NM_KOR")).equals(SyncUtil.removeBlank(kicaREnt.getValue(j, "DAEPYO_NM"))) 	//��ǥ�ڼ����ѱ�
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "CHG_DT")+", "+   
						netREnt.getValue(i, "REP_SSN1")+", "+ 
						netREnt.getValue(i, "REP_SSN2")+", "+ 
						netREnt.getValue(i, "REP_NM_KOR")      
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "CHANGE_YMD")+", "+
					kicaREnt.getValue(j, "JUMIN_NO1")+", "+
					kicaREnt.getValue(j, "JUMIN_NO2")+", "+
					kicaREnt.getValue(j, "DAEPYO_NM")      
					);	
			
			
			
			String insertSql=
				" INSERT                                        \n" +
				" INTO PT_R_BASIC_CHANGE_HISTORY       \n" +
				"   (                                               \n" +
				" 	TMP_WRT_NUM,		          \n" +
				" 	RECV_NUM,			  \n" +
				" 	COI_WRT_NUM,		          \n" +
				" 	CHG_DT,			          \n" +
				" 	CHGBRE_SEQ,			  \n" +
				" 	REP_SSN1,			          \n" +
				" 	REP_SSN2,			          \n" +
				" 	REP_NM_KOR	,		  \n" +
				" 	REP_NM_HAN,		          \n" +
				" 	WRT_DT,			          \n" +
				" 	STA_CHG_CLASS_CODE,	  \n" +
				" 	EXT_CHG_CLASS_CODE,	  \n" +
				" 	REC_DT,			          \n" +
				" 	WRT_ID,              		  \n" +
				" 	UPD_DT,              		  \n" +
				" 	INS_DT                                \n" +
				"   )                                               \n" +
				"   VALUES                                     \n" +
				"   (                                               \n" +
				" 	'"+tmpWrtNum+"',               \n" +
				" 	'"+kicaREnt.getValue(j, "ACCEPT_NO")+"',                    \n" +
				" 	'"+coiWrtNum+"',                \n" +
				" 	'"+kicaREnt.getValue(j, "CHANGE_YMD")+"',                        \n" +
				" 	(SELECT TO_CHAR(NVL(MAX(TO_NUMBER(CHGBRE_SEQ)), 0) + 1) tmp FROM PT_R_BASIC_CHANGE_HISTORY WHERE TMP_WRT_NUM = '"+tmpWrtNum+"'), \n" +
				" 	'"+kicaREnt.getValue(j, "JUMIN_NO1")+"',                        \n" +
				" 	'"+kicaREnt.getValue(j, "JUMIN_NO2")+"',                        \n" +
				" 	'"+kicaREnt.getValue(j, "DAEPYO_NM")+"',                        \n" +
				" 	'"+kicaREnt.getValue(j, "DAEPYO_NM")+"',                        \n" +
				" 	'"+kicaREnt.getValue(j, "CHANGE_YMD")+"',                        \n" +
				" 	'R00009',       \n" +
				" 	'C',       \n" +
				" 	'"+kicaREnt.getValue(j, "CHANGE_YMD")+"',                        \n" +
				" 	'TB_ICS_DAEPYO_DT',                         					\n" +
				" 	null,                       			 \n" +
				" 	'"+KJFDate.getCurDatetime()+"'                          			\n" +
				"  )                                               						 \n" ;
			
			SyncLog.logData(insertSql);
			
		}
	}
		
	
	
	/**
	 * ��ȣ���� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpChgCom(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_BASIC_CHANGE_HISTORY(��ȣ����)";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetChgComEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaChgComEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "CHG_DT").equals(kicaREnt.getValue(j, "CHANGE_YMD")) &&
						 netREnt.getValue(i, "NAME").equals(kicaREnt.getValue(j, "SANGHO_NM"))	 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "CHG_DT")+", "+   //��������
						netREnt.getValue(i, "NAME")      //��ȣ 
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "CHANGE_YMD")+", "+   
					kicaREnt.getValue(j, "SANGHO_NM")       
					);			
		}
	}
	
	
	/**
	 * �ּ������� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpChgAddr(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_BASIC_CHANGE_HISTORY(�ּ�������)";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetChgAddrEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaChgAddrEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			

			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){
				
				String ADDR_TEL_NUM = SyncUtil.removeBlank(netREnt.getValue(i, "ADDR_TEL_NUM")).replace("-", "").replace(")", "");
				String PHONE_NO = SyncUtil.removeBlank(kicaREnt.getValue(j, "PHONE_NO")).replace("-", "").replace(")", "");
				String ADDR_FAX_NUM = SyncUtil.removeBlank(netREnt.getValue(i, "ADDR_FAX_NUM")).replace("-", "").replace(")", "");
				String FAX_NO = SyncUtil.removeBlank(kicaREnt.getValue(j, "FAX_NO")).replace("-", "").replace(")", "");
				
				 if(netREnt.getValue(i, "CHG_DT").equals(kicaREnt.getValue(j, "CHANGE_YMD")) &&//��������
						 SyncUtil.trim(netREnt.getValue(i, "ADDR_POST_NUM")).equals(SyncUtil.trim(kicaREnt.getValue(j, "ZIP_CD"))) && //�����ȣ
						 SyncUtil.trim(netREnt.getValue(i, "ADDR_ADDR")).equals(SyncUtil.trim(kicaREnt.getValue(j, "ADDR_1"))) && //�ּ�
						 //netREnt.getValue(i, "ADDR_DETAIL_ADDR").equals(kicaREnt.getValue(j, "ADDR_2"))  //���ּ�
						 SyncUtil.trim(netREnt.getValue(i, "ADDR_DETAIL_ADDR")).equals(SyncUtil.trim(kicaREnt.getValue(j, "ADDR_2"))) && //���ּ�
						 netREnt.getValue(i, "OFFICE_AREA").equals(kicaREnt.getValue(j, "OFFICE_AREA")) && //�繫�Ǹ���
						 ADDR_TEL_NUM.equals(PHONE_NO) && //��ȭ��ȣ
						 ADDR_FAX_NUM.equals(FAX_NO)  //�ѽ���ȣ 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "CHG_DT")+", "+ 
						netREnt.getValue(i, "ADDR_POST_NUM")+", "+ 
						netREnt.getValue(i, "ADDR_ADDR")+", "+ 
						netREnt.getValue(i, "ADDR_DETAIL_ADDR")+", "+ 
						netREnt.getValue(i, "OFFICE_AREA")+", "+ 
						netREnt.getValue(i, "ADDR_TEL_NUM")+", "+ 
						netREnt.getValue(i, "ADDR_FAX_NUM")       
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "CHANGE_YMD")+", "+
					kicaREnt.getValue(j, "ZIP_CD")+", "+
					kicaREnt.getValue(j, "ADDR_1")+", "+
					kicaREnt.getValue(j, "ADDR_2")+", "+
					kicaREnt.getValue(j, "OFFICE_AREA")+", "+
					kicaREnt.getValue(j, "PHONE_NO")+", "+
					kicaREnt.getValue(j, "FAX_NO")       
					);			
		}
	}
		
		
	/**
	 * �ں��ݺ��� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpChgMoney(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_BASIC_CHANGE_HISTORY(�ں��� ����)";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetChgMoneyEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaChgMoneyEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "CHG_DT").equals(kicaREnt.getValue(j, "CHANGE_YMD")) &&//��������
						 //SyncUtil.removeBlank(netREnt.getValue(i, "DIAG_NM_NM")+netREnt.getValue(i, "DIAG_NM_WRT_NUM")).matches(".*"+SyncUtil.removeBlank(kicaREnt.getValue(j, "AGENCY_NM"))+".*") && //���ܱ��
						 netREnt.getValue(i, "COMPANY_DIAG_BAS_DT").equals(kicaREnt.getValue(j, "AGENCY_YMD")) && //��������
						 netREnt.getValue(i, "PAY_CAP").equals(kicaREnt.getValue(j, "PAY_AMT")) && //�����ں���
						 netREnt.getValue(i, "REA_CAP").equals(kicaREnt.getValue(j, "REAL_AMT"))  //�����ں���
						 //netREnt.getValue(i, "REA_CAP").equals(kicaREnt.getValue(j, "REAL_AMT")) && //�����ں���
						 //netREnt.getValue(i, "TUP_AOM").equals(kicaREnt.getValue(j, "INVEST_AMT")) //��ġ�ݾ�
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "CHG_DT")+", "+   
						//netREnt.getValue(i, "COMPANY_DIAG_CLASS_CODE")+", "+
						netREnt.getValue(i, "DIAG_ORG_CODE")+", "+
						SyncUtil.removeBlank(netREnt.getValue(i, "DIAG_NM_NM")+netREnt.getValue(i, "DIAG_NM_WRT_NUM"))+", "+ 
						netREnt.getValue(i, "COMPANY_DIAG_BAS_DT")+", "+ 
						netREnt.getValue(i, "PAY_CAP")+", "+
						netREnt.getValue(i, "REA_CAP")
						//netREnt.getValue(i, "REA_CAP")+", "+ 
						//netREnt.getValue(i, "TUP_AOM")
						);
			}		
		}

	
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "CHANGE_YMD")+", "+
					SyncUtil.getDigDiv(kicaREnt.getValue(j, "AGENCY_GB"))+", "+
					SyncUtil.removeBlank(kicaREnt.getValue(j, "AGENCY_NM"))+", "+
					kicaREnt.getValue(j, "AGENCY_YMD")+", "+
					kicaREnt.getValue(j, "PAY_AMT")+", "+
					kicaREnt.getValue(j, "REAL_AMT")
					//kicaREnt.getValue(j, "REAL_AMT")+", "+
					//kicaREnt.getValue(j, "INVEST_AMT")       
					);			
		}
	}
	
	
	/**
	 * ���� ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpHistory(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_BASIC_CHANGE_HISTORY(����)";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetHistoryEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaHistoryEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		 
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if(netREnt.getValue(i, "CHG_DT").equals(kicaREnt.getValue(j, "CHANGE_YMD")) && //��������
						 netREnt.getValue(i, "STA_CHG_CLASS_CODE").equals(SyncUtil.getChgCsCD(kicaREnt.getValue(j, "JOB_GB")))// && //���������ڵ�
						 //kicaREnt.getValue(j, "REPORT_NO").matches(netREnt.getValue(i, "DOC_CODE")+".*") //������ȣ
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "CHG_DT")+", "+   
						netREnt.getValue(i, "STA_CHG_CLASS_CODE")+", "+
						netREnt.getValue(i, "DOC_CODE")
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "CHANGE_YMD")+", "+   
					SyncUtil.getChgCsCD(kicaREnt.getValue(j, "JOB_GB"))+", "+ 
					kicaREnt.getValue(j, "REPORT_NO")
					);			
		}
	}
	
	/**
	 * ������ǥ ��
	 * @param COI_WRT_NUM
	 * @param TMP_WRT_NUM
	 * @throws Exception
	 */
	private void cpReffer(String COI_WRT_NUM, String TMP_WRT_NUM) throws Exception{
		tableName="PT_R_REFFER";
		coiWrtNum= COI_WRT_NUM;
		tmpWrtNum= TMP_WRT_NUM;
		
		ReportEntity netREnt =taskdao.getNetRefferEnt( TMP_WRT_NUM);
		ReportEntity kicaREnt = taskdao.getKicaRefferEnt( COI_WRT_NUM);
		
		
		 List rowNum = new ArrayList();
		
		for (int i = 0; i < netREnt.getRowCnt() ; i++ ){

			//System.out.println("kicaREnt.getRowCnt():"+kicaREnt.getRowCnt());
			for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){				 
				 if((netREnt.getValue(i, "SSN1")+netREnt.getValue(i, "SSN2")).equals(kicaREnt.getValue(j, "JUMIN_NO")) && //�ֹι�ȣ
						 SyncUtil.removeBlank(netREnt.getValue(i, "NM_KOR")).equals(SyncUtil.removeBlank(kicaREnt.getValue(j, "NM_KOR"))) && //��ǥ��_�ѱ�
						 SyncUtil.removeBlank(netREnt.getValue(i, "NM_HAN")).equals(SyncUtil.removeBlank(kicaREnt.getValue(j, "NM_CHI"))) && //��ǥ��_����
						 netREnt.getValue(i, "FOREIGN_YN").equals(kicaREnt.getValue(j, "FOREINER_YN"))  //�ܱ��ο���	 
				 ){					 
					 kicaREnt.remove(j);
					 rowNum.add(i);
					 break;
				 }	 				 
			 }//for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){	 			
		}//for (int i = 0; i < netEntCnt ; i++ )
		
		
		if(rowNum.size()!= netREnt.getRowCnt()){//rownum ������ netREnt�� ������ ������ for���� ���� �ʿ䰡 ����.		
			for (int i = 0; i < netREnt.getRowCnt() ; i++ ){
				if(rowNum.contains(i))  continue;				
				log(
						"NET ", 
						netREnt.getValue(i, "SSN1")+netREnt.getValue(i, "SSN2")+", "+   
						netREnt.getValue(i, "NM_KOR")+", "+
						netREnt.getValue(i, "NM_HAN")+", "+
						netREnt.getValue(i, "FOREIGN_YN")
						);
			}		
		}
		
		for(int j = 0; j < kicaREnt.getRowCnt(); j++ ){			
			log(
					"KICA", 
					kicaREnt.getValue(j, "JUMIN_NO")+", "+ 
					kicaREnt.getValue(j, "NM_KOR")+", "+   
					kicaREnt.getValue(j, "NM_CHI")+", "+   
					kicaREnt.getValue(j, "FOREINER_YN")       
					);			
		}
	}
	
	
	
	public void cpAndLog( String fieldName, String netData, String kicaData) throws Exception{
		
		if("DIAG_ORG_CODE".equals(fieldName) && KJFUtil.isEmpty(netData)) return;
		
		if (!netData.equals(kicaData ))
			SyncLog.logData("COI_WRT_NUM : "+coiWrtNum+ " :TMP_WRT_NUM : "+tmpWrtNum+ " : ("+tableName+") "+fieldName+" = NET- "+netData+", KICA- "+kicaData);
		
	}
	
	public void log(  String gubun, String allData) throws Exception{		
		
			SyncLog.logData("COI_WRT_NUM : "+coiWrtNum+ " :TMP_WRT_NUM : "+tmpWrtNum+ " : ("+tableName+") : "+gubun+" :"+allData);
		
	}	

}
