package sp.util.kica;

import java.util.HashMap;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;

public class SildbTaskDAO {


    public void icsToSildb(String TB_NM,String SEQ,String TMP_WRT_NUM,String COI_WRT_NUM,String SIDO_CODE) throws Exception{
    	//초기화
    	ReportDAO    rDAO		= new ReportDAO();
    	ReportEntity rEntity	= null;
    	String selectSQL = new String(); 
    	String whereSQL  = new String();
    	
    	StringBuffer sb_INSERT = new StringBuffer();
    	StringBuffer sb_MASTER = new StringBuffer();
    	StringBuffer sb_UPDATE = new StringBuffer();

    	
    	String now_dt =KJFDate.getCurDatetime();
    	
    	// 실디비에 TMP_WRT_NUM 이 없는 경우 보류처리 << 차후에 ..
    	if( "".equals(TMP_WRT_NUM) || TMP_WRT_NUM==null ){
    		KicaLog.logSilEx( "TB_NM : "+TB_NM+" / COI_WRT_NUM="+COI_WRT_NUM+" :PT_TMP_WRT_NUM : SEQ="+SEQ+" / COMPANY MASTER 에 미반영" );
    		return;
    	}
    	
    	// 각 구분별로 이관 처리 PT_TMP_ENGINEER_CHANGE
    	if( ("PT_TMP_ENGINEER_CHANGE").equals(TB_NM) ){//기술자 변경
    		selectSQL = " SELECT * \n";
    		selectSQL += " FROM PT_TMP_ENGINEER_CHANGE ";
    		selectSQL += " WHERE SEQ = '"+SEQ+"'";
    		KicaLog.log("--------------------------------------기술자 변경:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
	
			
			// 임시테이블에 TMP_WRT_NUM이 없는 경우 보류처리
	    	if( "".equals(rEntity.getValue(0, "CARE_BOOK_ISSUE_NUM")) || rEntity.getValue(0, "CARE_BOOK_ISSUE_NUM")==null ){
	    		KicaLog.logSilEx( "TB_NM : "+TB_NM+" / CARE_BOOK_ISSUE_NUM : SEQ="+SEQ+" / ENGINEER MASTER 에 미반영 (임시테이블아웃)" );
	    		return;
	    	}
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "TB_NM : "+TB_NM+" / PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}
			
			String FiledSQL = " ENGINEER_NM, ENGINEER_SSN1, ENGINEER_SSN2, EMPL_YMD, RET_YMD, REMARK, ";
			FiledSQL += " WRT_ID, UPD_DT, INS_DT, SEQ, TMP_WRT_NUM, TMP_FIELD,  ";
			FiledSQL += " CARE_BOOK_VAL_START_DT, CARE_BOOK_VAL_END_DT, ISSUE_DT, CARE_BOOK_ISSUE_NUM, "; 
			FiledSQL += " CARE_BOOK_VAL_START_DT1, CARE_BOOK_VAL_START_DT2 ";

			//long maxKey = getMaxChgBreSeq(TMP_WRT_NUM, TB_NM, "CHGBRE_SEQ")+1;
			long oriKey = getMaxSeq(TMP_WRT_NUM, "ENGINEER_CHANGE", "SEQ")+1;
			String cudFlag = KJFUtil.print(rEntity.getValue(0, "CUD_FLAG"),"");
			
			
			
			if("C".equals(cudFlag)){
				
				//퇴사일 경우 "C" 이더라도  기존 데이터에 업데이트를 할수 있도록  cudFlag를 변경해준다.
				int cnt = getCntEngineer(rEntity.getValue(0, "ENGINEER_SSN1"),
										rEntity.getValue(0, "ENGINEER_SSN2"), 
										rEntity.getValue(0, "EMPL_YMD"),
										TMP_WRT_NUM);
				if( cnt>0 ){
					cudFlag ="U"; 
					KicaLog.log("C->U 플래그 변경,   cnt:"+cnt);
				} else{
		    		sb_INSERT
		    		.append(" INSERT INTO PT_R_ENGINEER_CHANGE (" + FiledSQL + ") values ( ")
		      		.append(" '"+ rEntity.getValue(0, "ENGINEER_NM")	+"', ")//ENGINEER_NM
		      		.append(" '"+ rEntity.getValue(0, "ENGINEER_SSN1")	+"', ")//ENGINEER_SSN1
		      		.append(" '"+ rEntity.getValue(0, "ENGINEER_SSN2")	+"', ")//ENGINEER_SSN2
		      		.append(" '"+ rEntity.getValue(0, "EMPL_YMD")		+"', ")//EMPL_YMD
		      		.append(" '"+ rEntity.getValue(0, "RET_YMD")		+"', ")//RET_YMD
		      		.append(" '"+ ""									+"', ")//REMARK~~
		      		.append(" '"+ "PT_TMP_ENGINEER_CHANGE"								+"', ")//WRT_ID
		      		.append(" '"+ ""									+"', ")//UPD_DT~~
		      		//.append(" '"+ rEntity.getValue(0, "WRT_CHG_DT")		+"', ")//INS_DT 
		      		.append(" '"+ now_dt								+"', ")//INS_DT
		      		.append(" '"+ oriKey								+"', ")//SEQ
		      		.append(" '"+ TMP_WRT_NUM							+"', ")//TMP_WRT_NUM
		      		.append(" FNGetKicaCodeName('ENGCLASS', '"+ rEntity.getValue(0, "ENGINEER_GRADE")	+"'), ")//TMP_FIELD<--등급<<<<<<<<<<추가필드
		      		.append(" '"+ rEntity.getValue(0, "CHG_STA_DT")		+"', ")//CARE_BOOK_VAL_START_DT~~
		      		.append(" '"+ rEntity.getValue(0, "SEQ_SUB")		+"', ")//CARE_BOOK_VAL_END_DT~~
		      		.append(" '"+ ""									+"', ")//ISSUE_DT~~
		      		.append(" '"+ rEntity.getValue(0, "CARE_BOOK_ISSUE_NUM")+"', ")//CARE_BOOK_ISSUE_NUM<<<<<<<<추가필드
		      		.append(" '"+ ""									+"', ")//CARE_BOOK_VAL_START_DT1~~
		      		.append(" '"+ ""									+"' ")//CARE_BOOK_VAL_START_DT2~~
		    		.append(" ) ");
				}	

			}
			
			if("U".equals(cudFlag)){
				// 수정/삭제 시는 입/퇴사를 번복한 기술자가 있을 수 있으므로 입사일자를 추가 AND 조건에 건다.
				// 만약 입사일자를 잘못 입력한 경우는 어쩔 수 없다.
				sb_INSERT
	    		.append(" UPDATE PT_R_ENGINEER_CHANGE SET ")
	    		.append(" WRT_ID='"+"PT_TMP_ENGINEER_CHANGE"+"', ")
	    		.append(" UPD_DT='"+now_dt+"', ")
	    		.append(" EMPL_YMD 	= '"+ rEntity.getValue(0, "EMPL_YMD")	+"', ")//
	    		.append(" RET_YMD 	= '"+ rEntity.getValue(0, "RET_YMD")	+"', ")//
	    		.append(" CARE_BOOK_VAL_START_DT 	= '"+ rEntity.getValue(0, "CHG_STA_DT")	+"', ")//
	    		.append(" CARE_BOOK_VAL_END_DT 	= '"+ rEntity.getValue(0, "SEQ_SUB")	+"', ")//
	    		.append(" CARE_BOOK_ISSUE_NUM 	= '"+ rEntity.getValue(0, "CARE_BOOK_ISSUE_NUM")	+"', ")//
	    		.append(" TMP_FIELD = FNGetKicaCodeName('ENGCLASS', '"+ rEntity.getValue(0, "ENGINEER_GRADE")	+"') ")//
	    		.append(" WHERE 1=1")
				.append(" AND ENGINEER_SSN1='"+rEntity.getValue(0,"ENGINEER_SSN1")+"'")
				.append(" AND ENGINEER_SSN2='"+rEntity.getValue(0,"ENGINEER_SSN2")+"'")
				.append(" AND TMP_WRT_NUM='"+TMP_WRT_NUM+"' ")
				.append(" AND EMPL_YMD = '"+rEntity.getValue(0, "EMPL_YMD")+"' ");
			} 
			if("D".equals(cudFlag) && !"".equals(rEntity.getValue(0, "RET_YMD"))){
				//D플러그에 RET_YMD일자가있을경우 퇴사 취소이으로 RET_YMD를 비워둔다. 

				sb_INSERT
	    		.append(" UPDATE PT_R_ENGINEER_CHANGE SET ")
	    		.append(" UPD_DT='"+now_dt+"', ")
	    		.append(" RET_YMD 	= '' ")
	    		.append(" WHERE 1=1")
				.append(" AND ENGINEER_SSN1='"+rEntity.getValue(0,"ENGINEER_SSN1")+"'")
				.append(" AND ENGINEER_SSN2='"+rEntity.getValue(0,"ENGINEER_SSN2")+"'")
				.append(" AND TMP_WRT_NUM='"+TMP_WRT_NUM+"' ")
				.append(" AND EMPL_YMD = '"+rEntity.getValue(0, "EMPL_YMD")+"' ");
			}
			if("D".equals(cudFlag) && "".equals(rEntity.getValue(0, "RET_YMD"))){
				sb_INSERT
	    		.append(" DELETE FROM PT_R_ENGINEER_CHANGE ")
	    		.append(" WHERE 1=1")
				.append(" AND ENGINEER_SSN1='"+rEntity.getValue(0,"ENGINEER_SSN1")+"'")
				.append(" AND ENGINEER_SSN2='"+rEntity.getValue(0,"ENGINEER_SSN2")+"'")
				.append(" AND TMP_WRT_NUM='"+TMP_WRT_NUM+"' ")
				.append(" AND EMPL_YMD = '"+rEntity.getValue(0, "EMPL_YMD")+"' ");
			}
    		
    		sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    		// 이관
    		KicaLog.log(sb_INSERT.toString());
    		rDAO.execute(sb_INSERT.toString());
    		
    		// 입력처리 반영
    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());
			
    	}else if( ("PT_TMP_WORK_CAPABILITY").equals(TB_NM) ){//시공능력
    		

    		selectSQL = " SELECT * \n";
    		selectSQL += " FROM PT_TMP_WORK_CAPABILITY ";
    		selectSQL += " WHERE SEQ = '"+SEQ+"'";
    		KicaLog.log("--------------------------------------시공능력:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
			
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}
			
			String 	FiledSQL  = " SEQ, TMP_WRT_NUM, COI_WRT_NUM, ASSE_DT, ASSE_AOM, APPL_TERM_START_DT, ";
					FiledSQL += " CONFIRM, WRT_ID, UPD_DT, INS_DT, APPL_TERM_END_DT, SEQ_LINK_CAPABILITY ";
			

			long oriKey = getMaxSeq(TMP_WRT_NUM, "WORK_CAPABILITY", "SEQ")+1;
			String cudFlag = KJFUtil.print(rEntity.getValue(0, "CUD_FLAG"),"");
			
			
			
			if("C".equals(cudFlag)){
				
				//기존에 값있는지 체크
				int cnt = getCntWCpability(rEntity.getValue(0, "ASSE_DT"),
										TMP_WRT_NUM);
				if( cnt>0 ){
					cudFlag ="U"; 
					KicaLog.log("C->U 플래그 변경,   cnt:"+cnt);
				} else{			
			
		    		sb_INSERT
		    		.append(" INSERT INTO PT_R_WORK_CAPABILITY (" + FiledSQL + ") values ( ")
		      		.append(" '"+ oriKey		+"', ")//tmp_wrt_num
		    		.append(" '"+ TMP_WRT_NUM	+"', ")//coi_wrt_num
		    		.append(" '"+ COI_WRT_NUM	+"', ")//
		    		.append(" '"+ rEntity.getValue(0, "ASSE_DT")	+"', ")//
		    		.append(" '"+ rEntity.getValue(0, "ASSE_AOM")	+"', ")//
		    		.append(" '"+ rEntity.getValue(0, "APPL_TERM_START_DT")	+"', ")//
		    		.append(" '"+ ""	+"', ")//confirm
		    		.append(" 'PT_TMP_WORK_CAPABILITY', ")//
		    		.append(" '"+ ""	+"', ")//upd_dt
		    		.append(" '"+ now_dt	+"', ")//ins_dt
		    		.append(" '"+ rEntity.getValue(0, "APPL_TERM_END_DT")	+"', ")//
		    		.append(" '"+ rEntity.getValue(0, "SEQ_LINK")	+"' ")//
		    		.append(" ) ");
				}
			}
				
			if("U".equals(cudFlag)){
				sb_INSERT
	    		.append(" UPDATE PT_R_WORK_CAPABILITY SET ")
	    	    .append(" WRT_ID='"+"PT_TMP_WORK_CAPABILITY"+"', ")
	    		.append(" UPD_DT='"+now_dt+"', ")
	    		.append(" ASSE_DT = '"+ rEntity.getValue(0, "ASSE_DT")	+"', ")//
	    		.append(" ASSE_AOM = '"+ rEntity.getValue(0, "ASSE_AOM")	+"', ")//
	    		.append(" APPL_TERM_START_DT = '"+ rEntity.getValue(0, "APPL_TERM_START_DT")	+"', ")//
	    		.append(" APPL_TERM_END_DT ='"+rEntity.getValue(0,"APPL_TERM_END_DT")+"'")
	    		.append(" WHERE ASSE_DT='"+rEntity.getValue(0,"ASSE_DT")+"'")
	    		.append(" AND COI_WRT_NUM='"+COI_WRT_NUM+"' ");
			}
			
			if("D".equals(cudFlag)){
				sb_INSERT
	    		.append(" DELETE FROM PT_R_WORK_CAPABILITY ")
	    		.append(" WHERE ASSE_DT='"+rEntity.getValue(0,"ASSE_DT")+"'")
	    		.append(" AND TMP_WRT_NUM='"+COI_WRT_NUM+"' ");
			}
    		
    		sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    		// 이관
    		KicaLog.log(sb_INSERT.toString());
    		rDAO.execute(sb_INSERT.toString());    		
    		
    		// 입력처리 반영
    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());
    		
    	}else if( ("PT_TMP_WORK_RESULTS").equals(TB_NM) ){//공사 실적
    		
    		selectSQL = " SELECT * \n";
    		selectSQL += " FROM PT_TMP_WORK_RESULTS ";
    		selectSQL += " WHERE SEQ = '"+SEQ+"'";
    		
    		KicaLog.log("--------------------------------------실적:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
			
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}
			
			String 	FiledSQL  = " SEQ, TMP_WRT_NUM, YEAR, WORK_ROM, WRT_ID, ";
					FiledSQL += " UPD_DT, INS_DT ";
			
					
			long oriKey = getMaxSeq(TMP_WRT_NUM, "WORK_RESULTS", "SEQ")+1;
			String cudFlag = KJFUtil.print(rEntity.getValue(0, "CUD_FLAG"),"");
			
			if("C".equals(cudFlag)){
				
				//기존에 값있는지 체크
				int cnt = getCntWResult(rEntity.getValue(0, "YEAR"),
										TMP_WRT_NUM);
				if( cnt>0 ){
					cudFlag ="U"; 
					KicaLog.log("C->U 플래그 변경,   cnt:"+cnt);
				} else{				
			
		    		sb_INSERT
		    		.append(" INSERT INTO PT_R_WORK_RESULTS (" + FiledSQL + ") values ( ")
		      		.append(" '"+ oriKey		+"', ")//tmp_wrt_num
		    		.append(" '"+ TMP_WRT_NUM	+"', ")//coi_wrt_num
		    		.append(" '"+ rEntity.getValue(0, "YEAR")	+"', ")//
		    		.append(" '"+ rEntity.getValue(0, "WORK_ROM")	+"', ")//
		    		.append(" 'PT_TMP_WORK_RESULTS', ")//
		    		.append(" '"+ ""	+"', ")//upd_dt
		    		.append(" '"+ now_dt	+"' ")//ins_dt
		    		.append(" ) ");
				}
			}
			
			if("U".equals(cudFlag)){
				sb_INSERT
	    		.append(" UPDATE PT_R_WORK_RESULTS SET ")
	    	    .append(" WRT_ID='"+"PT_TMP_WORK_RESULTS"+"', ")
	    		.append(" UPD_DT='"+now_dt+"', ")	    		
	    		.append(" WORK_ROM = '"+ rEntity.getValue(0, "WORK_ROM")	+"' ")//
	    		.append(" WHERE YEAR='"+rEntity.getValue(0,"YEAR")+"'")
	    		.append(" AND TMP_WRT_NUM='"+TMP_WRT_NUM+"' ");
			}
			
			if("D".equals(cudFlag)){
				sb_INSERT
	    		.append(" DELETE FROM PT_R_WORK_RESULTS ")
	    		.append(" WHERE YEAR='"+rEntity.getValue(0,"YEAR")+"'")
				.append(" AND TMP_WRT_NUM='"+TMP_WRT_NUM+"' ");
			}
    		
    		sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    		// 이관
    		KicaLog.log(sb_INSERT.toString());
    		rDAO.execute(sb_INSERT.toString());    		
    		
    		// 입력처리 반영
    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());
    		
    	}else if( ("PT_TMP_ADDR_CHANGE").equals(TB_NM) ){//소재지 변경
    		
	
    		
    		selectSQL = " SELECT ADDR_ADDR,ADDR_DETAIL_ADDR,ADDR_FAX_NUM,ADDR_POST_NUM,ADDR_TEL_NUM,";
    		selectSQL += " CHG_STA_DT,COI_WRT_NUM,CUD_FLAG,ICS_TRANS_DT,KICA_INS_DT,MANA_NUM,";
    		selectSQL += " OFFICE_AREA,SEQ,SIDO_CODE,WRT_CHG_DT, SEQ_LINK \n";
    		selectSQL += " FROM PT_TMP_ADDR_CHANGE ";
    		
    		
    		whereSQL += " WHERE SEQ = '"+SEQ+"'";
    		
    		
    		
    		KicaLog.log("--------------------------------------소재지 변경:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
			
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}
			
			String cud_flag 		= KJFUtil.print(rEntity.getValue(0,  "CUD_FLAG" ) );	// CUD_FLAG	변경플래그
			
			String coi_wrt_num 		= COI_WRT_NUM;	// COI_WRT_NUM	등록증_등록_번호
			String tmp_wrt_num 		= TMP_WRT_NUM;	// TMP_WRT_NUM	
			String wrt_chg_dt = KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자	
    		
    		if("D".equals(cud_flag)){
    			String prev_seq = getPrevSeq("PT_TMP_ADDR_CHANGE", coi_wrt_num,  wrt_chg_dt,  SEQ);
    			
    			if(KJFUtil.isEmpty(prev_seq)){
    				KicaLog.logSilEx( "PT_TMP_ADDR_CHANGE:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM +" D 이나 이전 SEQ 없음" );
    				return;    				
    			}
    			
    			String prevSeqWhereSQL = " WHERE SEQ = '"+prev_seq+"'";
        		KicaLog.log(selectSQL+prevSeqWhereSQL);
    			rEntity = rDAO.select(selectSQL+prevSeqWhereSQL);
    					
    		}			
			
						
			
			
			String recv_num 		= KJFUtil.print(rEntity.getValue(0,  "SEQ" ) );	// RECV_NUM	접수_번호
			
			
			String chg_dt 			= KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자				
						
			String sido_code 		= getSido(SIDO_CODE, rEntity.getValue(0, "ADDR_ADDR"));//시도코드
			//String sido_code 		= KJFUtil.print(rEntity.getValue(0,  "SIDO_CODE" ) );	// SIDO_CODE 시도코드

			String addr_post_num 		= KJFUtil.print(rEntity.getValue(0,  "ADDR_POST_NUM" ) );	// ADDR_POST_NUM	소재지_우편_번호
			String addr_addr 		= KJFUtil.print(rEntity.getValue(0,  "ADDR_ADDR" ) ) ;	// ADDR_ADDR	소재지_주소
			String addr_detail_addr 		= KJFUtil.print(rEntity.getValue(0,  "ADDR_DETAIL_ADDR" ) );	// ADDR_DETAIL_ADDR	소재지_상세_주소
			String addr_tel_num 		= KJFUtil.print(rEntity.getValue(0,  "ADDR_TEL_NUM" ) );	// ADDR_TEL_NUM	소재지_전화_번호
			String addr_fax_num 		= KJFUtil.print(rEntity.getValue(0,  "ADDR_FAX_NUM" ) );	// ADDR_FAX_NUM	소재지_팩스_번호
			String office_area 		= KJFUtil.print(rEntity.getValue(0,  "OFFICE_AREA" ) );	// OFFICE_AREA	사무실_면적


			String wrt_dt = chg_dt;	// WRT_DT	등록_일자
			String sta_chg_class_code = "R00007";	// STA_CHG_CLASS_CODE	신고_변경_구분_코드
			String ext_chg_class_code = "A";	// EXT_CHG_CLASS_CODE	변경사항구분코드값(ABCD)
			String rec_dt =  KJFUtil.print(rEntity.getValue(0,  "CHG_STA_DT" ) );	// 접수일자	

			String wrt_id               =KJFUtil.print( "PT_TMP_ADDR_CHANGE");	// 등록ID
			String upd_dt               =now_dt;	// 수정일자
			String ins_dt               =now_dt;	// 입력일자			
			
			
			
			
			String chgbre_seq 		= getCurChgBreSeq(coi_wrt_num, chg_dt, sta_chg_class_code);
			
			String historySql="";
			
			if(KJFUtil.isEmpty(chgbre_seq)){
				chgbre_seq = (getMaxChgBreSeq(coi_wrt_num,  "CHGBRE_SEQ")+1)+"";
				
				//insert
				historySql=
					" INSERT                                        \n" +
					" INTO PT_R_BASIC_CHANGE_HISTORY       \n" +
					"   (                                               \n" +
					" 	TMP_WRT_NUM,		          \n" +
					" 	RECV_NUM,			  \n" +
					" 	COI_WRT_NUM,		          \n" +
					" 	CHG_DT,			          \n" +
					" 	CHGBRE_SEQ,			  \n" +
					" 	SIDO_CODE,			          \n" +
					" 	ADDR_POST_NUM,			          \n" +
					" 	ADDR_ADDR	,		  \n" +
					" 	ADDR_DETAIL_ADDR,		          \n" +
					" 	ADDR_TEL_NUM,			          \n" +
					" 	ADDR_FAX_NUM,			          \n" +
					" 	OFFICE_AREA	,		  \n" +				
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
					" 	'"+tmp_wrt_num+"',               \n" +
					" 	'"+recv_num+"',                    \n" +
					" 	'"+coi_wrt_num+"',                \n" +
					" 	'"+chg_dt+"',                        \n" +
					" 	'"+chgbre_seq+"',                  \n" +
					" 	'"+sido_code+"',                     \n" +
					" 	'"+addr_post_num+"',                     \n" +
					" 	'"+addr_addr+"',                 \n" +
					" 	'"+addr_detail_addr+"',                 \n" +
					" 	'"+addr_tel_num+"',                     \n" +
					" 	'"+addr_fax_num+"',                 \n" +
					" 	'"+office_area+"',                 \n" +					
					" 	'"+wrt_dt+"',                         \n" +
					" 	'"+sta_chg_class_code+"',       \n" +
					" 	'"+ext_chg_class_code+"',       \n" +
					" 	'"+rec_dt+"',                         \n" +
					" 	'"+wrt_id+"',                         \n" +
					" 	'',                        \n" +
					" 	'"+ins_dt+"'                          \n" +
					"  )                                                \n" ;					
				
			} else{
				//update
				historySql=
					" 	UPDATE PT_R_BASIC_CHANGE_HISTORY SET                           \n" +
					" 		RECV_NUM='"+recv_num+"',		                                \n" +
					" 		CHG_DT='"+chg_dt+"',		         	                        \n" +
					" 		SIDO_CODE='"+sido_code+"',		                        \n" +
					" 		ADDR_POST_NUM='"+addr_post_num+"',		         \n" +
					" 		ADDR_ADDR	='"+addr_addr+"',	                        \n" +
					" 		ADDR_DETAIL_ADDR='"+addr_detail_addr+"',	                \n" +
					" 		ADDR_TEL_NUM='"+addr_tel_num+"',		                \n" +
					" 		ADDR_FAX_NUM='"+addr_fax_num+"',		                \n" +
					" 		OFFICE_AREA	='"+office_area+"',	 	                \n" +
					" 		REC_DT	='"+rec_dt+"',	 	                \n" +
					" 		WRT_DT='"+wrt_dt+"',		                                        \n" +
					" 		STA_CHG_CLASS_CODE='"+sta_chg_class_code+"',           \n" +
					" 		EXT_CHG_CLASS_CODE='"+ext_chg_class_code+"',           \n" +
					" 		WRT_ID='"+wrt_id+"',            		                        \n" +
					" 		UPD_DT='"+upd_dt+"',       		                                \n" +
					" 		INS_DT='"+ins_dt+"'                                                    \n" +
					" 	 WHERE CHGBRE_SEQ='"+chgbre_seq+"'  AND  TMP_WRT_NUM='"+tmp_wrt_num+"'     \n" ;					
				
			}
			
		
    		sb_MASTER
    		.append(" UPDATE PT_R_COMPANY_MASTER SET")
    		.append(" WRT_ID='"+wrt_id+"', ")
    		.append(" UPD_DT='"+upd_dt+"', ")
    		.append(" SIDO_CODE='"+			sido_code+"', ")//addr_post_num
    		.append(" ADDR_POST_NUM='"+		addr_post_num+"', ")//addr_post_num
    		.append(" ADDR_ADDR='"+			addr_addr+"', ")//addr_addr
    		.append(" ADDR_DETAIL_ADDR='"+	addr_detail_addr+"', ")//addr_detail_addr
    		.append(" ADDR_TEL_NUM='"+		addr_tel_num+"', ")//addr_tel_num
    		.append(" ADDR_FAX_NUM='"+		addr_fax_num+"', ")//addr_fax_num
    		.append(" OFFICE_AREA='"+		office_area+"' ")//office_area
    		.append(" WHERE TMP_WRT_NUM ='"+tmp_wrt_num+"'");
    		
    		sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    		
    			
    		// history table
    		KicaLog.log(historySql.toString());
    		rDAO.execute(historySql.toString());
    		
    		// 마스터 업데이트
    		KicaLog.log(sb_MASTER.toString());
    		rDAO.execute(sb_MASTER.toString());

    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());
    		
    	}else if(("PT_TMP_CAPITAL_CHANGE").equals(TB_NM)){//자본금 변경
    		selectSQL = " SELECT CHG_STA_DT, COI_WRT_NUM, COMPANY_DIAG_BAS_DT, ";
    		selectSQL += " CUD_FLAG, DIAG_NM_NM, DIAG_ORG_CODE, DIAG_ORG_CODE_NM, ";
			selectSQL += " ICS_TRANS_DT, KICA_INS_DT, MANA_NUM, ";
			selectSQL += " PAY_CAP, REA_CAP, SEQ, SIDO_CODE, TUP_AOM, WRT_CHG_DT, SEQ_LINK ";
			selectSQL += " FROM PT_TMP_CAPITAL_CHANGE ";
    		
    		
    		whereSQL += " WHERE SEQ = '"+SEQ+"'";
    		
    		KicaLog.log("--------------------------------------자본금 변경:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
			
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}


			
			
			String cud_flag 		= KJFUtil.print(rEntity.getValue(0,  "CUD_FLAG" ) );	// CUD_FLAG	변경플래그
			
			String coi_wrt_num 		= COI_WRT_NUM;	// COI_WRT_NUM	등록증_등록_번호
			String tmp_wrt_num 		= TMP_WRT_NUM;	// TMP_WRT_NUM	
			String wrt_chg_dt = KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자	
    		
    		if("D".equals(cud_flag)){
    			String prev_seq = getPrevSeq("PT_TMP_CAPITAL_CHANGE", coi_wrt_num,  wrt_chg_dt,  SEQ);
    			
    			if(KJFUtil.isEmpty(prev_seq)){
    				KicaLog.logSilEx( "PT_TMP_CAPITAL_CHANGE:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM +" D 이나 이전 SEQ 없음" );
    				return;    				
    			}
    			
    			String prevSeqWhereSQL = " WHERE SEQ = '"+prev_seq+"'";
        		KicaLog.log(selectSQL+prevSeqWhereSQL);
    			rEntity = rDAO.select(selectSQL+prevSeqWhereSQL);
    					
    		}			

			
			
			
						
				
			String recv_num 		= KJFUtil.print(rEntity.getValue(0,  "SEQ" ) );	// RECV_NUM	접수_번호
			
			String chg_dt 			= KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT") );	// CHG_DT	변경_일자				
			
			
			
			String company_diag_bas_dt 		= KJFUtil.print(rEntity.getValue(0,  "COMPANY_DIAG_BAS_DT" ));	// COMPANY_DIAG_BAS_DT	기업_진단_기준_일자
			String company_diag_issue_dt 		=  company_diag_bas_dt;	// COMPANY_DIAG_ISSUE_DT	기업_진단_발급_일자
			String diag_nm_nm 		= KJFUtil.print(rEntity.getValue(0,"DIAG_NM_NM") );	// DIAG_NM_NM	진단자_성명
			String diag_nm_wrt_num 		= diag_nm_nm;	// DIAG_NM_WRT_NUM	진단자_등록_번호
			String pay_cap 		= KJFUtil.print(rEntity.getValue(0,  "PAY_CAP" ));// PAY_CAP	납입_자본금
			String rea_cap 		=  KJFUtil.print(rEntity.getValue(0,  "REA_CAP" ));// REA_CAP	실질_자본금
			String tup_aom 		= KJFUtil.print(rEntity.getValue(0,  "TUP_AOM" ));// TUP_AOM	예치_금액		
			
				
			String wrt_dt = chg_dt;	// WRT_DT	등록_일자
			String sta_chg_class_code = "R00008";	// STA_CHG_CLASS_CODE	신고_변경_구분_코드
			String ext_chg_class_code = "B";	// EXT_CHG_CLASS_CODE	변경사항구분코드값(ABCD)
			
			String rec_dt =  KJFUtil.print(rEntity.getValue(0,  "CHG_STA_DT" ) );	// 접수일자	

			String wrt_id               =KJFUtil.print( "PT_TMP_CAPITAL_CHANGE");	// 등록ID
			String upd_dt               =now_dt;	// 수정일자
			String ins_dt               =now_dt;	// 입력일자			
			
			
			
			
			String chgbre_seq 		= getCurChgBreSeq(coi_wrt_num, chg_dt, sta_chg_class_code);
			
			String historySql="";
			
			if(KJFUtil.isEmpty(chgbre_seq)){
				chgbre_seq = (getMaxChgBreSeq(coi_wrt_num,  "CHGBRE_SEQ")+1)+"";
				
				//insert
				historySql=
					" INSERT                                        \n" +
					" INTO PT_R_BASIC_CHANGE_HISTORY       \n" +
					"   (                                               \n" +
					" 	TMP_WRT_NUM,		          \n" +
					" 	RECV_NUM,			  \n" +
					" 	COI_WRT_NUM,		          \n" +
					" 	CHG_DT,			          \n" +
					" 	CHGBRE_SEQ,			  \n" +
					" 	COMPANY_DIAG_BAS_DT,			          \n" +
					" 	COMPANY_DIAG_ISSUE_DT	,		  \n" +
					" 	DIAG_NM_NM,		          \n" +
					" 	DIAG_NM_WRT_NUM,			          \n" +
					" 	PAY_CAP,			          \n" +
					" 	REA_CAP	,		  \n" +				
					" 	TUP_AOM	,		  \n" +								
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
					" 	'"+tmp_wrt_num+"',               \n" +
					" 	'"+recv_num+"',                    \n" +
					" 	'"+coi_wrt_num+"',                \n" +
					" 	'"+chg_dt+"',                        \n" +
					" 	'"+chgbre_seq+"',                  \n" +
					" 	'"+company_diag_bas_dt+"',                     \n" +
					" 	'"+company_diag_issue_dt+"',                 \n" +
					" 	'"+diag_nm_nm+"',                 \n" +
					" 	'"+diag_nm_wrt_num+"',                     \n" +
					" 	'"+pay_cap+"',                 \n" +
					" 	'"+rea_cap+"',                 \n" +
					" 	'"+tup_aom+"',                 \n" +					
					" 	'"+wrt_dt+"',                         \n" +
					" 	'"+sta_chg_class_code+"',       \n" +
					" 	'"+ext_chg_class_code+"',       \n" +
					" 	'"+rec_dt+"',                         \n" +
					" 	'"+wrt_id+"',                         \n" +
					" 	'',                        \n" +
					" 	'"+ins_dt+"'                          \n" +
					"  )                                                \n" ;						
				
			} else{
				//update
				historySql=
					" 	UPDATE PT_R_BASIC_CHANGE_HISTORY SET                           \n" +
					" 		RECV_NUM='"+recv_num+"',		                                \n" +
					" 		CHG_DT='"+chg_dt+"',		         	                        \n" +
					" 		COMPANY_DIAG_BAS_DT='"+company_diag_bas_dt+"',		                        \n" +
					" 		COMPANY_DIAG_ISSUE_DT='"+company_diag_issue_dt+"',		         \n" +
					" 		DIAG_NM_NM	='"+diag_nm_nm+"',	                        \n" +
					" 		DIAG_NM_WRT_NUM='"+diag_nm_wrt_num+"',	                \n" +
					" 		PAY_CAP='"+pay_cap+"',		                \n" +
					" 		REA_CAP='"+rea_cap+"',		                \n" +
					" 		TUP_AOM	='"+tup_aom+"',	 	                \n" +
					" 		REC_DT	='"+rec_dt+"',	 	                \n" +					
					" 		WRT_DT='"+wrt_dt+"',		                                        \n" +
					" 		STA_CHG_CLASS_CODE='"+sta_chg_class_code+"',           \n" +
					" 		EXT_CHG_CLASS_CODE='"+ext_chg_class_code+"',           \n" +
					" 		WRT_ID='"+wrt_id+"',            		                        \n" +
					" 		UPD_DT='"+upd_dt+"',       		                                \n" +
					" 		INS_DT='"+ins_dt+"'                                                    \n" +
					" 	 WHERE CHGBRE_SEQ='"+chgbre_seq+"'  AND  TMP_WRT_NUM='"+tmp_wrt_num+"'     \n" ;					
				
			}			
			
			
			sb_MASTER
    		.append(" UPDATE PT_R_COMPANY_MASTER SET")
    		.append(" WRT_ID='"+wrt_id+"', ")
    		.append(" UPD_DT='"+upd_dt+"', ")
    		.append(" DIAG_ORG_CODE='"+rEntity.getValue(0, "DIAG_ORG_CODE")+"', ")
    		.append(" DIAG_NM_NM='"+rEntity.getValue(0, "DIAG_NM_NM")+"', ")
    		.append(" DIAG_NM_WRT_NUM='', ")
    		.append(" COMPANY_DIAG_BAS_DT='"+rEntity.getValue(0, "COMPANY_DIAG_BAS_DT")+"', ")
			.append(" COMPANY_DIAG_ISSUE_DT='', ")
    		.append(" PAY_CAP='"+rEntity.getValue(0, "PAY_CAP")+"', ")
    		.append(" REA_CAP='"+rEntity.getValue(0, "REA_CAP")+"', ")
    		.append(" TUP_AOM='"+rEntity.getValue(0, "TUP_AOM")+"' ")
    		.append(" WHERE TMP_WRT_NUM ='"+TMP_WRT_NUM+"'");
			
			sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    			
    		// history table
    		KicaLog.log(historySql.toString());
    		rDAO.execute(historySql.toString());
    		
    		// 마스터 업데이트
    		KicaLog.log(sb_MASTER.toString());
    		rDAO.execute(sb_MASTER.toString());

    		// 입력처리 반영
    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());
    		
    		
    		
    	}else if( ("PT_TMP_REP_CHANGE").equals(TB_NM) ){/////////////////대표자 변경
    		selectSQL = " SELECT CHG_STA_DT,COI_WRT_NUM,CUD_FLAG,ICS_TRANS_DT,KICA_INS_DT,MANA_NUM,";
    		selectSQL += " REP_NM_HAN,REP_NM_KOR,REP_SSN1,REP_SSN2,SEQ,SIDO_CODE,WRT_CHG_DT, SEQ_LINK \n";
    		selectSQL += " FROM PT_TMP_REP_CHANGE ";
    		
    		
    		whereSQL += " WHERE SEQ = '"+SEQ+"'";

    		KicaLog.log("--------------------------------------대표자 변경:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
			
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}
			
			
			String cud_flag 		= KJFUtil.print(rEntity.getValue(0,  "CUD_FLAG" ) );	// CUD_FLAG	변경플래그
			
			String coi_wrt_num 		= COI_WRT_NUM;	// COI_WRT_NUM	등록증_등록_번호
			String tmp_wrt_num 		= TMP_WRT_NUM;	// TMP_WRT_NUM	
			String wrt_chg_dt = KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자	
    		
    		if("D".equals(cud_flag)){
    			String prev_seq = getPrevSeq("PT_TMP_REP_CHANGE", coi_wrt_num,  wrt_chg_dt,  SEQ);
    			
    			if(KJFUtil.isEmpty(prev_seq)){
    				KicaLog.logSilEx( "PT_TMP_REP_CHANGE:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM +" D 이나 이전 SEQ 없음" );
    				return;    				
    			}
    			
    			String prevSeqWhereSQL = " WHERE SEQ = '"+prev_seq+"'";
        		KicaLog.log(selectSQL+prevSeqWhereSQL);
    			rEntity = rDAO.select(selectSQL+prevSeqWhereSQL);
    					
    		}			
			
						
			
			
			String recv_num 		= KJFUtil.print(rEntity.getValue(0,  "SEQ" ) );	// RECV_NUM	접수_번호
			
			
			String chg_dt 			= KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자				

			String rep_ssn1 		= KJFUtil.print( rEntity.getValue(0, "REP_SSN1" ) );	// REP_SSN1	대표자_주민번호1
			String rep_ssn2 		= KJFUtil.print( rEntity.getValue(0, "REP_SSN2" ) ) ;	// REP_SSN2	대표자_주민번호2
			String rep_nm_kor 		= KJFUtil.print( rEntity.getValue(0, "REP_NM_KOR" ) );	// REP_NM_KOR	대표자_성명_한글
			String rep_nm_han 		= KJFUtil.print( rEntity.getValue(0, "REP_NM_HAN" ) );	// REP_NM_HAN	대표자_성명_한자

			String wrt_dt = chg_dt;	// WRT_DT	등록_일자
			String sta_chg_class_code = "R00009";	// STA_CHG_CLASS_CODE	신고_변경_구분_코드
			String ext_chg_class_code = "C";	// EXT_CHG_CLASS_CODE	변경사항구분코드값(ABCD)
			
			
			String rec_dt =  KJFUtil.print(rEntity.getValue(0,  "CHG_STA_DT" ) );	// 접수일자	

			String wrt_id               =KJFUtil.print( "PT_TMP_REP_CHANGE");	// 등록ID
			String upd_dt               =now_dt;	// 수정일자
			String ins_dt               =now_dt;	// 입력일자			
			
			
			
			
			String chgbre_seq 		= getCurChgBreSeq(coi_wrt_num, chg_dt, sta_chg_class_code);
			
			String historySql="";
			
			if(KJFUtil.isEmpty(chgbre_seq)){
				chgbre_seq = (getMaxChgBreSeq(coi_wrt_num,  "CHGBRE_SEQ")+1)+"";
				
				//insert
				historySql=
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
					" 	'"+tmp_wrt_num+"',               \n" +
					" 	'"+recv_num+"',                    \n" +
					" 	'"+coi_wrt_num+"',                \n" +
					" 	'"+chg_dt+"',                        \n" +
					" 	'"+chgbre_seq+"',                  \n" +
					" 	'"+rep_ssn1+"',                     \n" +
					" 	'"+rep_ssn2+"',                     \n" +
					" 	'"+rep_nm_kor+"',                 \n" +
					" 	'"+rep_nm_han+"',                 \n" +
					" 	'"+wrt_dt+"',                         \n" +
					" 	'"+sta_chg_class_code+"',       \n" +
					" 	'"+ext_chg_class_code+"',       \n" +
					" 	'"+rec_dt+"',                         \n" +
					" 	'"+wrt_id+"',                         \n" +
					" 	'',                        \n" +
					" 	'"+ins_dt+"'                          \n" +
					"  )                                                \n" ;						
				
			} else{
				//update
				historySql=
					" 	UPDATE PT_R_BASIC_CHANGE_HISTORY SET                           \n" +
					" 		RECV_NUM='"+recv_num+"',		                                \n" +
					" 		CHG_DT='"+chg_dt+"',		         	                        \n" +
					" 		REP_SSN1='"+rep_ssn1+"',		                        \n" +
					" 		REP_SSN2='"+rep_ssn2+"',		         \n" +
					" 		REP_NM_KOR	='"+rep_nm_kor+"',	                        \n" +
					" 		REP_NM_HAN='"+rep_nm_han+"',	                \n" +
					" 		REC_DT	='"+rec_dt+"',	 	                \n" +
					" 		WRT_DT='"+wrt_dt+"',		                                        \n" +
					" 		STA_CHG_CLASS_CODE='"+sta_chg_class_code+"',           \n" +
					" 		EXT_CHG_CLASS_CODE='"+ext_chg_class_code+"',           \n" +
					" 		WRT_ID='"+wrt_id+"',            		                        \n" +
					" 		UPD_DT='"+upd_dt+"',       		                                \n" +
					" 		INS_DT='"+ins_dt+"'                                                    \n" +
					" 	 WHERE CHGBRE_SEQ='"+chgbre_seq+"'  AND  TMP_WRT_NUM='"+tmp_wrt_num+"'     \n" ;					
				
			}			
			
    		
    		sb_MASTER
    		.append(" UPDATE PT_R_COMPANY_MASTER SET ")
    		.append(" WRT_ID='"+wrt_id+"', ")
    		.append(" UPD_DT='"+upd_dt+"', ")    		
    		.append(" REP_NM_KOR='"+rep_nm_kor+"', ")//rep_nm_kor
    		.append(" REP_NM_HAN='"+rep_nm_han+"', ")//rep_nm_han
    		.append(" REP_SSN1='"+rep_ssn1+"', ")//rep_ssn1
    		.append(" REP_SSN2='"+rep_ssn2+"' ")//rep_ssn2
    		.append(" WHERE TMP_WRT_NUM ='"+TMP_WRT_NUM+"' ");
    		
    		sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    		// history table
    		KicaLog.log(historySql.toString());
    		rDAO.execute(historySql.toString());
    		
    		// 마스터 업데이트
    		KicaLog.log(sb_MASTER.toString());
    		rDAO.execute(sb_MASTER.toString());

    		// 입력처리 반영
    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());
    		
    		
    	}else if( ("PT_TMP_NAME_CHANGE").equals(TB_NM) ){/////////////////상호 변경
    		selectSQL = " SELECT SEQ, SIDO_CODE, MANA_NUM, NAME, CHG_STA_DT, WRT_CHG_DT, COI_WRT_NUM, CUD_FLAG, SEQ_LINK \n";
    		selectSQL += " FROM PT_TMP_NAME_CHANGE ";
    		
    		
    		whereSQL += " WHERE SEQ = '"+SEQ+"'";
    		
    		KicaLog.log("--------------------------------------상호변경:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM);
    		KicaLog.log(selectSQL+whereSQL);
			rEntity = rDAO.select(selectSQL+whereSQL);
			
			if( rEntity.getRowCnt()==0 ){
				KicaLog.logSilEx( "PT_TMP_RECEIVE_KEY : SEQ="+SEQ+" 해당 ROW가 없슴" );
				return;
			}
			
			
			
			String cud_flag 		= KJFUtil.print(rEntity.getValue(0,  "CUD_FLAG" ) );	// CUD_FLAG	변경플래그
			
			String coi_wrt_num 		= COI_WRT_NUM;	// COI_WRT_NUM	등록증_등록_번호
			String tmp_wrt_num 		= TMP_WRT_NUM;	// TMP_WRT_NUM	
			String wrt_chg_dt = KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자	
    		
    		if("D".equals(cud_flag)){
    			String prev_seq = getPrevSeq("PT_TMP_NAME_CHANGE", coi_wrt_num,  wrt_chg_dt,  SEQ);
    			
    			if(KJFUtil.isEmpty(prev_seq)){
    				KicaLog.logSilEx( "PT_TMP_NAME_CHANGE:"+SEQ +"  TMP_WRT_NUM:"+TMP_WRT_NUM+"  COI_WRT_NUM:"+COI_WRT_NUM +" D 이나 이전 SEQ 없음" );
    				return;    				
    			}
    			
    			String prevSeqWhereSQL = " WHERE SEQ = '"+prev_seq+"'";
        		KicaLog.log(selectSQL+prevSeqWhereSQL);
    			rEntity = rDAO.select(selectSQL+prevSeqWhereSQL);
    					
    		}
    		
			
	
			String recv_num 		= KJFUtil.print(rEntity.getValue(0,  "SEQ" ) );	// RECV_NUM	접수_번호
			
			
			String chg_dt 			= KJFUtil.print(rEntity.getValue(0,  "WRT_CHG_DT" ) );	// CHG_DT	변경_일자				

			String name 		= KJFUtil.print(rEntity.getValue(0,  "NAME" ) );	//  NAME	상호

			String wrt_dt = chg_dt;	// WRT_DT	등록_일자
			String sta_chg_class_code = "R00010";	// STA_CHG_CLASS_CODE	신고_변경_구분_코드
			String ext_chg_class_code = "D";	// EXT_CHG_CLASS_CODE	변경사항구분코드값(ABCD)
			
			
			String rec_dt =  KJFUtil.print(rEntity.getValue(0,  "CHG_STA_DT" ) );	// 접수일자	

			String wrt_id               =KJFUtil.print( "PT_TMP_NAME_CHANGE");	// 등록ID
			String upd_dt               =now_dt;	// 수정일자
			String ins_dt               =now_dt;	// 입력일자			
			
			
			
			
			String chgbre_seq 		= getCurChgBreSeq(coi_wrt_num, chg_dt, sta_chg_class_code);
			
			String historySql="";
			
			if(KJFUtil.isEmpty(chgbre_seq)){
				chgbre_seq = (getMaxChgBreSeq(coi_wrt_num,  "CHGBRE_SEQ")+1)+"";
				
				//insert
				historySql=
					" INSERT                                        \n" +
					" INTO PT_R_BASIC_CHANGE_HISTORY       \n" +
					"   (                                               \n" +
					" 	TMP_WRT_NUM,		          \n" +
					" 	RECV_NUM,			  \n" +
					" 	COI_WRT_NUM,		          \n" +
					" 	CHG_DT,			          \n" +
					" 	CHGBRE_SEQ,			  \n" +
					" 	NAME,			          \n" +
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
					" 	'"+tmp_wrt_num+"',               \n" +
					" 	'"+recv_num+"',                    \n" +
					" 	'"+coi_wrt_num+"',                \n" +
					" 	'"+chg_dt+"',                        \n" +
					" 	'"+chgbre_seq+"',                  \n" +
					" 	'"+name+"',                     \n" +
					" 	'"+wrt_dt+"',                         \n" +
					" 	'"+sta_chg_class_code+"',       \n" +
					" 	'"+ext_chg_class_code+"',       \n" +
					" 	'"+rec_dt+"',                         \n" +
					" 	'"+wrt_id+"',                         \n" +
					" 	'',                        \n" +
					" 	'"+ins_dt+"'                          \n" +
					"  )                                                \n" ;						
				
			} else{
				//update
				historySql=
					" 	UPDATE PT_R_BASIC_CHANGE_HISTORY SET                           \n" +
					" 		RECV_NUM='"+recv_num+"',		                                \n" +
					" 		CHG_DT='"+chg_dt+"',		         	                        \n" +
					" 		NAME='"+name+"',		                        \n" +
					" 		REC_DT	='"+rec_dt+"',	 	                \n" +
					" 		WRT_DT='"+wrt_dt+"',		                                        \n" +
					" 		STA_CHG_CLASS_CODE='"+sta_chg_class_code+"',           \n" +
					" 		EXT_CHG_CLASS_CODE='"+ext_chg_class_code+"',           \n" +
					" 		WRT_ID='"+wrt_id+"',            		                        \n" +
					" 		UPD_DT='"+upd_dt+"',       		                                \n" +
					" 		INS_DT='"+ins_dt+"'                                                    \n" +
					" 	 WHERE CHGBRE_SEQ='"+chgbre_seq+"'  AND  TMP_WRT_NUM='"+tmp_wrt_num+"'     \n" ;					
				
			}			
			
    		
    		sb_MASTER
    		.append(" UPDATE PT_R_COMPANY_MASTER SET ")
    		.append(" WRT_ID='"+wrt_id+"', ")
    		.append(" UPD_DT='"+upd_dt+"', ")    		
    		.append(" NAME='"+name+"' ")//NAME
    		.append(" WHERE TMP_WRT_NUM ='"+TMP_WRT_NUM+"' ");
    		
    		sb_UPDATE
			.append(" UPDATE "+TB_NM+" SET ")
			.append(" ICS_TRANS_DT = '"+now_dt+"'")
			.append(" WHERE SEQ='"+SEQ+"'");
    		
    		// history table
    		KicaLog.log(historySql.toString());
    		rDAO.execute(historySql.toString());
    		
    		// 마스터 업데이트
    		KicaLog.log(sb_MASTER.toString());
    		rDAO.execute(sb_MASTER.toString());

    		// 입력처리 반영
    		KicaLog.log(sb_UPDATE.toString());
    		rDAO.execute(sb_UPDATE.toString());			
    		
    	}
    	
    	// 입력 처리후 키 삭제처리 - 
    	String deleteSql = "DELETE FROM PT_TMP_RECEIVE_KEY WHERE SEQ='"+SEQ+"'";
    	KicaLog.log(deleteSql);
    	rDAO.execute(deleteSql);
    }



    //입력될 자기 테이블 seq max value 세팅
    private long getMaxSeq(String sKEY, String sTABLE, String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) MAX_ID ";
        sQuery += " FROM PT_R_"+sTABLE;
        sQuery += " WHERE TMP_WRT_NUM = '" + sKEY + "' ";
        
        ReportEntity rEntity     = null;
        
        KicaLog.log(sQuery);
        rEntity = rDAO.select(sQuery);

        return Long.parseLong( rEntity.getValue(0,"MAX_ID") );
    }
    
    // 기술자 입력 확인용
    private int getCntEngineer( String ssn1, String ssn2, String empl_ymd, String tmp_wrt_num) throws Exception {
    	
    	ReportDAO rDAO = new ReportDAO();
    	
    	String sQuery = " SELECT COUNT(*) CNT  ";
    	sQuery += " FROM PT_R_ENGINEER_CHANGE ";
    	sQuery += " WHERE 1=1 ";
		sQuery += " AND ENGINEER_SSN1='"+ ssn1 +"'";
		sQuery += " AND ENGINEER_SSN2='"+ ssn2 +"'";
		sQuery += " AND EMPL_YMD='"+ empl_ymd +"'";
		sQuery += " AND TMP_WRT_NUM='"+tmp_wrt_num+"' ";
    	
    	ReportEntity rEntity     = null;
    	
    	KicaLog.log(sQuery);
    	rEntity = rDAO.select(sQuery);
    	
    	return Integer.parseInt( rEntity.getValue(0,"CNT") );
    }
    
    // 시공능력 입력 확인용
    private int getCntWCpability(String asse_dt,  String tmp_wrt_num) throws Exception {
    	
    	ReportDAO rDAO = new ReportDAO();
    	

		
    	String sQuery = " SELECT COUNT(*) CNT  ";
    	sQuery += " FROM PT_R_WORK_CAPABILITY ";
    	sQuery += " WHERE 1=1 ";
		sQuery += " AND ASSE_DT='"+ asse_dt +"'";
		sQuery += " AND TMP_WRT_NUM='"+tmp_wrt_num+"' ";    	
		
		
    	ReportEntity rEntity     = null;
    	
    	KicaLog.log(sQuery);
    	rEntity = rDAO.select(sQuery);
    	
    	return Integer.parseInt( rEntity.getValue(0,"CNT") );
    }
    
    // 공사실적 입력 확인용
    private int getCntWResult(String year,  String tmp_wrt_num) throws Exception {
    	
    	ReportDAO rDAO = new ReportDAO();
    	

		
    	String sQuery = " SELECT COUNT(*) CNT  ";
    	sQuery += " FROM PT_R_WORK_RESULTS ";
    	sQuery += " WHERE 1=1 ";
		sQuery += " AND YEAR='"+ year +"'";
		sQuery += " AND TMP_WRT_NUM='"+tmp_wrt_num+"' ";    	
		
		
    	ReportEntity rEntity     = null;
    	
    	KicaLog.log(sQuery);
    	rEntity = rDAO.select(sQuery);
    	
    	return Integer.parseInt( rEntity.getValue(0,"CNT") );
    }      
    
    
    // 들어온 값이 마지막 값인지 확인
    private boolean getMaxChangeIs(String TB_NM, String TB_NM_SUB, String SEQ_LINK, String MAX_KEY) throws Exception {
    	ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT COUNT(*) CNT ";
        sQuery += " FROM " + TB_NM + " ";
        sQuery += " WHERE SEQ_LINK_"+ TB_NM_SUB +" = '" + SEQ_LINK + "' ";
        sQuery += " AND CHGBRE_SEQ = '" + MAX_KEY + "' ";
        
        ReportEntity rEntity     = null;
        
        KicaLog.log(sQuery);
        rEntity = rDAO.select(sQuery);
        int cnt = Integer.parseInt( rEntity.getValue(0,"CNT") );
        
        if(cnt>0) return true;	//마지막 ROW 임
        else return false;		//마지막 ROW 아님
    }
    
    //pt_r_basic_change_history chgbre_seq max value 세팅
    private long getMaxChgBreSeq(String coi_wrt_num,  String sField) throws Exception {
    	
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT NVL(MAX(to_number(" + sField + ")), 0) MAX_ID ";
        sQuery += " FROM PT_R_BASIC_CHANGE_HISTORY ";
        sQuery += " WHERE COI_WRT_NUM = '" + coi_wrt_num + "' ";
        
        ReportEntity rEntity     = null;
        
        KicaLog.log(sQuery);
        rEntity = rDAO.select(sQuery);

        return Long.parseLong( rEntity.getValue(0,"MAX_ID") );
    }
    
    
    
    // 주소지 변경시 시도 코드 변환
    private String getSido(String sido_code, String addr ) throws Exception {
    	String rt=sido_code; 
    	
    	if(KJFUtil.isEmpty(addr) || addr.length()< 2){
    		return rt;
    	}
    	
    	String sido_nm=addr.substring(0, 2);
    	
		HashMap<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("서울", "susu");
		codeMap.put("부산", "bsbs");
		codeMap.put("대구", "dgdg");
		codeMap.put("인천", "icic");
		codeMap.put("광주", "gjgj");
		codeMap.put("대전", "djdj");
		codeMap.put("울산", "usus");
		codeMap.put("경기", "gggg");
		codeMap.put("강원", "gwgw");
		codeMap.put("충북", "cbcb");
		codeMap.put("충남", "cncn");
		codeMap.put("전북", "jbjb");
		codeMap.put("전남", "jnjn");
		codeMap.put("경북", "gbgb");
		codeMap.put("경남", "gngn");
		codeMap.put("제주", "jjjj");
		codeMap.put("세종", "sjsj");
		
		if(KJFUtil.isEmpty(codeMap.get( sido_nm ))){
			return rt;
		} else {
			return codeMap.get( sido_nm );
		}
 
    } 
    
    
    //history 테이블에서 공사업번호와 변경일 기준으로  CHGBRE_SEQ 가져온다.
    private String getCurChgBreSeq(String coi_wrt_num, String chg_dt, String sta_chg_class_code) throws Exception {
    	 
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT CHGBRE_SEQ FROM PT_R_BASIC_CHANGE_HISTORY ";
        sQuery += " WHERE COI_WRT_NUM='"+coi_wrt_num+"' AND CHG_DT='"+chg_dt+"' ";
        sQuery += " AND  STA_CHG_CLASS_CODE='"+sta_chg_class_code+"' ";
        
        ReportEntity rEntity     = null;
        
        KicaLog.log(sQuery);
        rEntity = rDAO.select(sQuery);

        return rEntity.getValue(0,"CHGBRE_SEQ") ;
    }    
 
    
    //D일경우 이전 seq의 정보를 넣어준다.
    private String  getPrevSeq(String TB_NM, String coi_wrt_num, String wrt_chg_dt, String seq) throws Exception {
    	 
        ReportDAO rDAO = new ReportDAO();

        String sQuery = " SELECT MAX(SEQ) SEQ FROM ICCS.PT_TMP_ADDR_CHANGE WHERE 1=1 ";
        sQuery += " AND COI_WRT_NUM='"+coi_wrt_num+"'  ";
        sQuery += " AND WRT_CHG_DT='"+wrt_chg_dt+"' ";
        sQuery += " AND SEQ < "+seq+" ";
        
        ReportEntity rEntity     = null;
        
        KicaLog.log(sQuery);
        rEntity = rDAO.select(sQuery);

        return KJFUtil.print(rEntity.getValue(0,"SEQ"))  ;
    }     
    

}
