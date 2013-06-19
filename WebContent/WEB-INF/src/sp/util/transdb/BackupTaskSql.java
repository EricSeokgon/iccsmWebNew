package sp.util.transdb;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;
import sp.dao.PT_KICA_TRANS_LOGDAO;
import sp.dao.PT_KICA_TRANS_LOGEntity;
import sp.webservice.UBAgentPortTypeProxy;

public  class BackupTaskSql  {
	
	
	private String TB_NM;
	private String CUD_FLAG;
	private String SIGUNGU_CODE;
	
	public BackupTaskSql(String v_TB_NM,
						String v_CUD_FLAG, 
						String v_SIGUNGU_CODE){
		
		this.TB_NM = v_TB_NM;
		this.CUD_FLAG = v_CUD_FLAG;
		this.SIGUNGU_CODE = v_SIGUNGU_CODE;
		
	}
    
	// 착공전 설계 접수 기본정보
    public  String  getPT_UB_CONSTRUCTION()throws Exception {    	
    	String PT_UB_CONSTRUCTION_SQL = "NOT";
    	
    	if ("PT_UB_CONSTRUCTION".equals(TB_NM)){
		    	PT_UB_CONSTRUCTION_SQL =
			    	" SELECT  " +
			    	"  ORPE_NM         , ORPE_TEL          , ORPE_POSTNUM     , ORPE_ADDR            , ORPE_DETAILADDR   , PLANER_NAME    , \n"+
			    	"  PLANER_NM       , PLANER_TEL        , PLANER_POSTNUM   , PLANER_ADDR          , PLANER_DETAILADDR , RECV_DT        , \n"+
			    	"  STRU_COMMIT_NUM , STRU_ADDR_POSTNUM , STRU_ADDR_ADDR   , STRU_ADDR_DETAILADDR , USE               , AREA           , \n"+
			    	"  NUM_FL          , WORK_ITEM         , STE              , SUV_APPL             , CONFIRMER_NM      , CONFIRMER_POSI , \n"+
			    	"  CONFIRMER_TEL   , INSP_OPIN         , PRE_ITEM         , SW_BEF_REPO_DELINUM  , REPO_DT           , WRT_ID         , \n"+
			    	"  CIV_RECV_NUM    , SIDO_CODE         , SIGUNGU_CODE     , INS_DT               , UPD_DT            , RECV_NUM       , \n"+
			    	"  INSP_BAS        , CER_DELI_NUM      , CER_DELI_CONFIRM , INSP_APPL_DT         , PROC_STE          , CER_DELI_YN    , \n"+
			    	"  PROC_OFFI_NM    , WORK_ITEM_ETC     , ETC_INSP_BAS     \n"+
			    	" FROM "+ TB_NM + "					\n";

		    if ("C".equals(CUD_FLAG)){
		  		PT_UB_CONSTRUCTION_SQL +=	
			    	" WHERE " +
			    	" SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND PROC_STE ='3' AND BACKUP_TRANS_DT IS NULL \n"; //접수번호
		  		    //" AND ROWNUM <= 10";
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_CONSTRUCTION_SQL +=
		   			" WHERE 1=1"+
		   			"  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  AND PROC_STE ='3' AND  (UPD_DT IS NOT NULL AND BACKUP_TRANS_DT IS NOT NULL) AND (UPD_DT != UPD_DT_OLD) ";
	   				//"      ) -- AND ROWNUM <= 10	\n";
		   	}

    	} 
    	
    		return PT_UB_CONSTRUCTION_SQL;
    		
    }
    	
	// 착공전설계도 메모
    public  String  getPT_UB_CONMEMO()throws Exception {
    	
    	String PT_UB_CONMEMO_SQL="NOT";
    	
    	if ("PT_UB_CONMEMO".equals(TB_NM)){
	    	PT_UB_CONMEMO_SQL =
		    	" SELECT  " +
		    	" A.MEMO_DT  , A.MEMO_CONT , A.INS_DT  , A.UPD_DT   , A.WRT_ID , A.SEQ , \n"+
		    	" A.RECV_NUM , A.SIDO_CODE , A.SIGUNGU_CODE , A.WRT_NAME , A.WRT_TIME       \n"+
	    		" FROM "+ TB_NM + " A, PT_UB_CONSTRUCTION B	\n";

			    if ("C".equals(CUD_FLAG)){
			    	PT_UB_CONMEMO_SQL +=	
			   			" WHERE 			  				\n" +
			   			" B.PROC_STE = '3' AND \n" +
				    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
			    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
			    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
			    		" A.RECV_NUM = B.RECV_NUM AND \n" +
				    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
			    	 //" AND ROWNUM <= 10";
			   	} else if ("U".equals(CUD_FLAG)){
			   		PT_UB_CONMEMO_SQL +=	
			   			" WHERE 1=1		AND	  				\n" +
			   			" B.PROC_STE = '3' AND \n" +
				    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
			    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
			    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
			    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";
 
			   	}

    	}
    	return PT_UB_CONMEMO_SQL;
    }
    
    // 착공전 세부검토 정보 테이블
    public  String  getPT_UB_CON_DETAIL()throws Exception {
    	String PT_UB_CON_DETAIL_SQL="NOT";
    	
    	if ("PT_UB_CON_DETAIL".equals(TB_NM)){
	    	PT_UB_CON_DETAIL_SQL=
		    	" SELECT  " +
		    	"  A.DETAIL_CONT , A.ITEM_OUT  , A.WRT_ID   , A.INS_DT       , A.UPD_DT ,\n"+
		    	"  A.SRL         , A.SIDO_CODE , A.RECV_NUM , A.SIGUNGU_CODE , A.SEQ     \n"+
		    	" FROM "+ TB_NM + "	A, PT_UB_CONSTRUCTION B					\n";
    		
		    if ("C".equals(CUD_FLAG)){
		    	PT_UB_CON_DETAIL_SQL +=	
		   			" WHERE 			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_CON_DETAIL_SQL +=	
		   			" WHERE 1=1 AND			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
		   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";
		   	}
    	}
    	
    	return PT_UB_CON_DETAIL_SQL;
    }
    
    // 착공전 검사 흠결
    public  String  getPT_UB_CONDEFICIT()throws Exception {
    	String PT_UB_CONDEFICIT_SQL="NOT";
    	
    	if ("PT_UB_CONDEFICIT".equals(TB_NM)){
    		PT_UB_CONDEFICIT_SQL=
	    	" SELECT  " +
	    	"  A.DEFI_SEQ , A.DEFI_CODE , A.DEFI_OUT  , A.WRT_ID       , A.UPD_DT ,\n"+
	    	"  A.INS_DT   , A.RECV_NUM  , A.SIDO_CODE , A.SIGUNGU_CODE           \n"+
	    	" FROM "+ TB_NM + "	A, PT_UB_CONSTRUCTION B				\n";
    		
		    if ("C".equals(CUD_FLAG)){
		    	PT_UB_CONDEFICIT_SQL +=	
		   			" WHERE 			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_CONDEFICIT_SQL +=	
		   			" WHERE 1=1 AND"+
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
		   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";

		   	}

    	}
    	return PT_UB_CONDEFICIT_SQL;
    }

    // 사용전 검사 기본정보
    public  String  getPT_UB_USEBEFORE()throws Exception {
    	String PT_UB_USEBEFORE_SQL="NOT";
    	
    	if ("PT_UB_USEBEFORE".equals(TB_NM)){
    		PT_UB_USEBEFORE_SQL=
	    	" SELECT  " +
	    	"  SIDO_CODE            , SIGUNGU_CODE       , APPLPER_NM               , APPLPER_REP          , APPLPER_POSTNUM     ,\n"+
	    	"  APPLPER_ADDR         , APPLPER_DETAILADDR , APPLPER_TELNUM           , OPE_NAME             , OPE_REP             ,\n"+
	    	"  OPE_TELNUM           , COI_WRT_NUM        , OPE_POSTNUM              , OPE_ADDR             , OPE_DETAILADDR      ,\n"+
	    	"  INSP_SPOT_NM         , INSP_SPOT_POSTNUM  , INSP_SPOT_ADDR           , INSP_SPOT_DETAILADDR , PLANER_NM           ,\n"+
	    	"  WORK_ITEM,  AREA     , NUM_FL             , USE                      , INSP_APPL_WORK       , INSP_APPL_DT        ,\n"+
	    	"  INSP_DT  ,  INSP_FEE , INSPER_NM          , INSPER_POSI              , JUDGM                , PLAN_CONFIRM_YN     ,\n"+
	    	"  SW_BEF_REPO_DELINUM  , SW_DT              , EW_DT                    , INSP_WISH_YMD        , OFFI_TELNUM         ,\n"+ 
	    	"  OFFI_NM	        , USEBEFINSP_DELINUM , SUV                      , REMARK               , CER_DELI_YN         ,\n"+
	    	"  PLAN_CONFIRM_REMARK  , NAPPL_YN           , NAPPL_CAUSE              , DOC_INSP_REMARK      , WRT_ID              ,\n"+ 
	    	"  INS_DT               , UPD_DT             , CIV_RECV_NUM             , RECV_DT              , PLAN_CONFIRM_PER_YN ,\n"+ 
	    	"  PLAN_ENT_CHG_YN      , PLAN_CONT_CHG_YN   , RECV_NUM                 , ATT_DOC              , DELI_DT             ,\n"+ 
	    	"  DEFI_YN              , PROC_STE           , ISSUE_ITEM               , NET_RECV_YN          , PROC_LIM            ,\n"+ 
	    	"  INSP_NUM             , PROC_OFFI          , PLAN_CONFIRM_PER_YN_CONT , PLAN_ENT_CHG_YN_CONT , PLAN_CONT_CHG_YN_CONT ,\n"+ 
	    	"  CHG_INSP             , INSP_ITEM          , ETC_INSP_BAS             , WORK_ITEM_ETC \n"+
	    	" FROM "+ TB_NM + "					\n";
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_USEBEFORE_SQL +=	
		   			" WHERE 			  				\n" +
			    	" SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND PROC_STE ='3' AND BACKUP_TRANS_DT IS NULL \n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_USEBEFORE_SQL +=	
		   			" WHERE 1=1"+
		   			"  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  AND PROC_STE ='3' AND  (UPD_DT IS NOT NULL AND BACKUP_TRANS_DT IS NOT NULL) AND (UPD_DT != UPD_DT_OLD) ";
		   	}

    	}
    	return PT_UB_USEBEFORE_SQL;
    }
        
    // 사용전 검사 메모
    public  String  getPT_UB_MEMO()throws Exception {
    	String PT_UB_MEMO_SQL="NOT";
    	
    	if ("PT_UB_MEMO".equals(TB_NM)){
    		PT_UB_MEMO_SQL=
	    	"  SELECT  " +
	    	"  A.MEMO_DT  , A.MEMO_CONT , A.INS_DT       , A.UPD_DT , A.WRT_ID   ," +
	    	"  A.RECV_NUM , A.SIDO_CODE , A.SIGUNGU_CODE , A.SEQ    , A.WRT_NAME ," +     
	    	"  A.WRT_TIME      	    									" + 
	    	"  FROM "+ TB_NM + "	A, PT_UB_USEBEFORE B				\n";
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_MEMO_SQL +=	
		   			" WHERE 			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_MEMO_SQL +=	
		   			" WHERE 1=1 AND"+
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
		   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";

		   	}
    	}
    	return PT_UB_MEMO_SQL;
    }
    
    //사용전 세부 검토 정보
    public  String  getPT_UB_DETAIL()throws Exception {
    	String PT_UB_DETAIL_SQL="NOT";
    	
    	if ("PT_UB_DETAIL".equals(TB_NM)){
    		PT_UB_DETAIL_SQL=
	    	"  SELECT  " +
	    	"  A.DETAIL_CONT , A.ITEM_OUT  , A.WRT_ID   , A.INS_DT       , A.UPD_DT , \n"+
	    	"  A.SRL         , A.SIDO_CODE , A.RECV_NUM , A.SIGUNGU_CODE , A.SEQ      \n"+
	    	" FROM "+ TB_NM + "			A, PT_UB_USEBEFORE B			\n";
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_DETAIL_SQL +=	
		   			" WHERE 			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_DETAIL_SQL +=	
		   			" WHERE 1=1 AND"+
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
		   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";
		   	}
	
    	}
    	return PT_UB_DETAIL_SQL;
    }

    // 사용전 검사 첨부파일
    public  String  getPT_UB_FILE()throws Exception {
    	String PT_UB_FILE_SQL="NOT";
    	
    	if ("PT_UB_FILE".equals(TB_NM)){
    		PT_UB_FILE_SQL=
	    	"  SELECT  " +
	    	"  A.FILE_NM , A.FILE_SIZE , A.WRT_ID    , A.INS_DT       , A.UPD_DT , \n"+          
	    	"  A.SEQ     , A.RECV_NUM  , A.SIDO_CODE , A.SIGUNGU_CODE	         \n"+ 
	    	"  FROM "+ TB_NM + "		A, PT_UB_USEBEFORE B				\n";
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_FILE_SQL +=	
		   			" WHERE 			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_FILE_SQL +=	
		   			" WHERE 1=1 AND "+
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
		   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";
		   	}
    	}
    	return PT_UB_FILE_SQL;
    }

    // 사용전 검사 흠결
    public  String  getPT_UB_DEFICIT()throws Exception {
    	String PT_UB_DEFICIT_SQL="NOT";
    	
    	if ("PT_UB_DEFICIT".equals(TB_NM)){
    		PT_UB_DEFICIT_SQL=
	    	"  SELECT  " +
	    	"  A.DEFI_SEQ , A.DEFI_CODE , A.DEFI_OUT  , A.WRT_ID , A.UPD_DT , \n"+
	    	"  A.INS_DT   , A.RECV_NUM  , A.SIDO_CODE , A.SIGUNGU_CODE      \n"+
	    	"  FROM "+ TB_NM + "		A, PT_UB_USEBEFORE B				\n";
	    	
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_DEFICIT_SQL +=	
		   			" WHERE 			  				\n" +
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
			    	" A.BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_DEFICIT_SQL +=	
		   			" WHERE 1=1 AND "+
		   			" B.PROC_STE = '3' AND \n" +
			    	" A.SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND \n" +
		    		" A.SIDO_CODE = B.SIDO_CODE AND \n" +
		    	    " A.SIGUNGU_CODE = B.SIGUNGU_CODE AND \n" +
		    		" A.RECV_NUM = B.RECV_NUM AND \n" +
		   			" (A.UPD_DT IS NOT NULL AND A.BACKUP_TRANS_DT IS NOT NULL) AND (A.UPD_DT != A.UPD_DT_OLD) ";
		   	}
    	}
    	return PT_UB_DEFICIT_SQL;
    }
    
    // 감리결과 관리  
    public  String  getPT_UB_SUVSPOT()throws Exception {
    	String PT_UB_SUVSPOT_SQL="NOT";
    	
    	if ("PT_UB_SUVSPOT".equals(TB_NM)){
    		PT_UB_SUVSPOT_SQL=
	    	"  SELECT  " +
	    	"  RECV_NUM      , SUV_NAME       , SUV_STANUM      , SUV_NM            , SUV_TELNUM , \n"+
	    	"  SUV_POSTNUM   , SUV_ADDR       , SUV_DETAILADDR  , SIWORK_NAME       , SIWORK_REP , \n"+
	    	"  COI_WRT_NUM   , SIWORK_POSTNUM , SIWORK_ADDR     , SIWORK_DETAILADDR , SPOTNM     , \n"+
	    	"  SPOT_POSTNUM  , SPOT_ADDR      , SPOT_DETAILADDR , WORK_ITEM         , USE        , \n"+
	    	"  STRU_AREA     , AREA           , SW_DT           , EW_DT             , WRT_ID     , \n"+
	    	"  INS_DT        , UPD_DT         , SIDO_CODE       , SIGUNGU_CODE      , SUV_MOBILE , \n"+
	    	"  SIWORK_TELNUM , SIWORK_MOBILE  , DOC_YN          , PROC_LIM          , ORPE_NM    , \n"+
	    	"  WORK_ITEM_ETC 																	   \n"+
	    	"  FROM "+ TB_NM + "					\n";
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_SUVSPOT_SQL +=	
		   			" WHERE 			  				\n" +
			    	" SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND  BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_SUVSPOT_SQL +=	
		   			" WHERE 1=1"+
		   			"  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND  (UPD_DT IS NOT NULL AND BACKUP_TRANS_DT IS NOT NULL) AND (UPD_DT != UPD_DT_OLD) ";
		   	}
 	
    	}
    	return PT_UB_SUVSPOT_SQL;
    }
    
	// 감리결과 메모
    public  String  getPT_UB_SUVMEMO()throws Exception {
    	String PT_UB_SUVMEMO_SQL="NOT";
    	
    	if ("PT_UB_SUVMEMO".equals(TB_NM)){
    		PT_UB_SUVMEMO_SQL=
	    	"  SELECT  " +
	    	"  MEMO_DT  , MEMO_CONT , INS_DT    , UPD_DT       , WRT_ID   , \n"+
	    	"  SEQ      , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE , WRT_NAME   \n"+
	    	"  FROM "+ TB_NM + " \n" ;
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_SUVMEMO_SQL +=	
		   			" WHERE 			  				\n" +
			    	" SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_SUVMEMO_SQL +=	
		   			" WHERE 1=1"+
		   			"  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND  (UPD_DT IS NOT NULL AND BACKUP_TRANS_DT IS NOT NULL) AND (UPD_DT != UPD_DT_OLD) ";
		   	}
	
    	}
    	return PT_UB_SUVMEMO_SQL;
    }
    
	// 착공전검사흠결
    public  String  getPT_UB_SUVDEFICIT()throws Exception {
    	String PT_UB_SUVDEFICIT_SQL="NOT";
    	
    	if ("PT_UB_SUVDEFICIT".equals(TB_NM)){
    		PT_UB_SUVDEFICIT_SQL=
	    	"  SELECT  " +
	    	"  DEFI_SEQ , DEFI_CODE , DEFI_OUT  , WRT_ID       , UPD_DT , \n"+
	    	"  INS_DT   , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE            \n"+ 
	    	"  FROM "+ TB_NM + "					\n" ;
    		
	    	if ("C".equals(CUD_FLAG)){
	    		PT_UB_SUVDEFICIT_SQL +=	
		   			" WHERE 			  				\n" +
			    	" SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND BACKUP_TRANS_DT IS NULL 		\n"; //접수번호
		   	} else if ("U".equals(CUD_FLAG)){
		   		PT_UB_SUVDEFICIT_SQL +=	
		   			" WHERE 1=1"+
		   			"  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND  (UPD_DT IS NOT NULL AND BACKUP_TRANS_DT IS NOT NULL) AND (UPD_DT != UPD_DT_OLD) ";
		   	}
	
    	}
    	return PT_UB_SUVDEFICIT_SQL;
    }
    
   
    
    
/**
 * 
 * 
 */
    
    
//	// 착공전 설계 접수 기본정보
//    public  String  getPT_UB_CONSTRUCTION()throws Exception {    	
//    	String PT_UB_CONSTRUCTION_SQL = "NOT";
//    	
//    	if ("PT_UB_CONSTRUCTION".equals(TB_NM)){
//	    	PT_UB_CONSTRUCTION_SQL =
//		    	" SELECT  " +
//		    	"  ORPE_NM         , ORPE_TEL          , ORPE_POSTNUM     , ORPE_ADDR            , ORPE_DETAILADDR   , PLANER_NAME    , \n"+
//		    	"  PLANER_NM       , PLANER_TEL        , PLANER_POSTNUM   , PLANER_ADDR          , PLANER_DETAILADDR , RECV_DT        , \n"+
//		    	"  STRU_COMMIT_NUM , STRU_ADDR_POSTNUM , STRU_ADDR_ADDR   , STRU_ADDR_DETAILADDR , USE               , AREA           , \n"+
//		    	"  NUM_FL          , WORK_ITEM         , STE              , SUV_APPL             , CONFIRMER_NM      , CONFIRMER_POSI , \n"+
//		    	"  CONFIRMER_TEL   , INSP_OPIN         , PRE_ITEM         , SW_BEF_REPO_DELINUM  , REPO_DT           , WRT_ID         , \n"+
//		    	"  CIV_RECV_NUM    , SIDO_CODE         , SIGUNGU_CODE     , INS_DT               , UPD_DT            , RECV_NUM       , \n"+
//		    	"  INSP_BAS        , CER_DELI_NUM      , CER_DELI_CONFIRM , INSP_APPL_DT         , PROC_STE          , CER_DELI_YN    , \n"+
//		    	"  PROC_OFFI_NM    , WORK_ITEM_ETC     , ETC_INSP_BAS     \n"+	    	
//		    	" FROM "+ TB_NM + "					\n" +
//		    	" WHERE 1=1			  				\n" +
//		    	"  AND RECV_NUM 	= '"+KEY1+"' 	\n"+ //접수번호
//		    	"  AND SIDO_CODE 	= '"+KEY2+"' 	\n"+ //시도코드
//		    	"  AND SIGUNGU_CODE = '"+KEY3+"' 	\n"; //시군구코드
//    	} 
//    		return PT_UB_CONSTRUCTION_SQL;
//    		
//    }
//    	
//	// 착공전설계도 메모
//    public  String  getPT_UB_CONMEMO()throws Exception {
//    	
//    	String PT_UB_CONMEMO_SQL="NOT";
//    	
//    	if ("PT_UB_CONMEMO".equals(TB_NM)){
//	    	PT_UB_CONMEMO_SQL =
//		    	" SELECT  " +
//		    	" MEMO_DT  , MEMO_CONT , INS_DT       , UPD_DT   , WRT_ID , SEQ , \n"+
//		    	" RECV_NUM , SIDO_CODE , SIGUNGU_CODE , WRT_NAME , WRT_TIME       \n"+
//	    		" FROM "+ TB_NM + "					\n" +
//		    	" WHERE 1=1			  				\n" +	    	
//		    	"  AND SEQ 			= '"+KEY1+"' 	\n"+ //일련번호
//		    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//		    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//		    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드
//    	}
//    	
//    	return PT_UB_CONMEMO_SQL;
//    }
//    
//    // 착공전 세부검토 정보 테이블
//    public  String  getPT_UB_CON_DETAIL()throws Exception {
//    	String PT_UB_CON_DETAIL_SQL="NOT";
//    	
//    	if ("PT_UB_CON_DETAIL".equals(TB_NM)){
//	    	PT_UB_CON_DETAIL_SQL=
//		    	" SELECT  " +
//		    	"  DETAIL_CONT , ITEM_OUT  , WRT_ID   , INS_DT       , UPD_DT ,\n"+
//		    	"  SRL         , SIDO_CODE , RECV_NUM , SIGUNGU_CODE , SEQ     \n"+
//		    	" FROM "+ TB_NM + "					\n" +
//		    	" WHERE 1=1			  				\n" +
//		    	"  AND SRL 			= '"+KEY1+"' 	\n" + //순번
//		    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n" + //접수번호
//		    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n" + //시도코드
//		    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드
//    	}
//    	
//    	return PT_UB_CON_DETAIL_SQL;
//    }
//    
//    // 착공전 검사 흠결
//    public  String  getPT_UB_CONDEFICIT()throws Exception {
//    	String PT_UB_CONDEFICIT_SQL="NOT";
//    	
//    	if ("PT_UB_CONDEFICIT".equals(TB_NM)){
//    		PT_UB_CONDEFICIT_SQL=
//	    	" SELECT  " +
//	    	"  DEFI_SEQ , DEFI_CODE , DEFI_OUT  , WRT_ID       , UPD_DT ,\n"+
//	    	"  INS_DT   , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE           \n"+
//	    	" FROM "+ TB_NM + "					\n" +
//	    	" WHERE 1=1			  				\n" +
//	    	"  AND DEFI_SEQ 	= '"+KEY1+"' 	\n"+ //흠결일련번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드
//    	}
//    	return PT_UB_CONDEFICIT_SQL;
//    }
//
//    // 사용전 검사 기본정보
//    public  String  getPT_UB_USEBEFORE()throws Exception {
//    	String PT_UB_USEBEFORE_SQL="NOT";
//    	
//    	if ("PT_UB_USEBEFORE".equals(TB_NM)){
//    		PT_UB_USEBEFORE_SQL=
//	    	" SELECT  " +
//	    	"  SIDO_CODE            , SIGUNGU_CODE       , APPLPER_NM               , APPLPER_REP          , APPLPER_POSTNUM     ,\n"+
//	    	"  APPLPER_ADDR         , APPLPER_DETAILADDR , APPLPER_TELNUM           , OPE_NAME             , OPE_REP             ,\n"+
//	    	"  OPE_TELNUM           , COI_WRT_NUM        , OPE_POSTNUM              , OPE_ADDR             , OPE_DETAILADDR      ,\n"+
//	    	"  INSP_SPOT_NM         , INSP_SPOT_POSTNUM  , INSP_SPOT_ADDR           , INSP_SPOT_DETAILADDR , PLANER_NM           ,\n"+
//	    	"  WORK_ITEM,  AREA     , NUM_FL             , USE                      , INSP_APPL_WORK       , INSP_APPL_DT        ,\n"+
//	    	"  INSP_DT  ,  INSP_FEE , INSPER_NM          , INSPER_POSI              , JUDGM                , PLAN_CONFIRM_YN     ,\n"+
//	    	"  SW_BEF_REPO_DELINUM  , SW_DT              , EW_DT                    , INSP_WISH_YMD        , OFFI_TELNUM         ,\n"+ 
//	    	"  OFFI_NM	        , USEBEFINSP_DELINUM , SUV                      , REMARK               , CER_DELI_YN         ,\n"+
//	    	"  PLAN_CONFIRM_REMARK  , NAPPL_YN           , NAPPL_CAUSE              , DOC_INSP_REMARK      , WRT_ID              ,\n"+ 
//	    	"  INS_DT               , UPD_DT             , CIV_RECV_NUM             , RECV_DT              , PLAN_CONFIRM_PER_YN ,\n"+ 
//	    	"  PLAN_ENT_CHG_YN      , PLAN_CONT_CHG_YN   , RECV_NUM                 , ATT_DOC              , DELI_DT             ,\n"+ 
//	    	"  DEFI_YN              , PROC_STE           , ISSUE_ITEM               , NET_RECV_YN          , PROC_LIM            ,\n"+ 
//	    	"  INSP_NUM             , PROC_OFFI          , PLAN_CONFIRM_PER_YN_CONT , PLAN_ENT_CHG_YN_CONT , PLAN_CONT_CHG_YN_CONT ,\n"+ 
//	    	"  CHG_INSP             , INSP_ITEM          , ETC_INSP_BAS             , WORK_ITEM_ETC \n"+
//	    	" FROM "+ TB_NM + "					\n" +
//	    	" WHERE 1=1			  				\n" +
//	    	"  AND RECV_NUM 	= '"+KEY1+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY2+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY3+"' 	\n"; //시군구코드
//    	}
//    	return PT_UB_USEBEFORE_SQL;
//    }
//        
//    // 사용전 검사 메모
//    public  String  getPT_UB_MEMO()throws Exception {
//    	String PT_UB_MEMO_SQL="NOT";
//    	
//    	if ("PT_UB_MEMO".equals(TB_NM)){
//    		PT_UB_MEMO_SQL=
//	    	"  SELECT  " +
//	    	"  MEMO_DT  , MEMO_CONT , INS_DT       , UPD_DT , WRT_ID   ," +
//	    	"  RECV_NUM , SIDO_CODE , SIGUNGU_CODE , SEQ    , WRT_NAME ," +     
//	    	"  WRT_TIME      	    									" + 
//	    	"  FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND SEQ 			= '"+KEY1+"' 	\n"+ //접수번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_MEMO_SQL;
//    }
//    
//    //사용전 세부 검토 정보
//    public  String  getPT_UB_DETAIL()throws Exception {
//    	String PT_UB_DETAIL_SQL="NOT";
//    	
//    	if ("PT_UB_DETAIL".equals(TB_NM)){
//    		PT_UB_DETAIL_SQL=
//	    	"  SELECT  " +
//	    	"  DETAIL_CONT , ITEM_OUT  , WRT_ID   , INS_DT       , UPD_DT , \n"+
//	    	"  SRL         , SIDO_CODE , RECV_NUM , SIGUNGU_CODE , SEQ      \n"+
//	    	" FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND SRL 			= '"+KEY1+"' 	\n"+ //일련번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_DETAIL_SQL;
//    }
//
//    // 사용전 검사 첨부파일
//    public  String  getPT_UB_FILE()throws Exception {
//    	String PT_UB_FILE_SQL="NOT";
//    	
//    	if ("PT_UB_FILE".equals(TB_NM)){
//    		PT_UB_FILE_SQL=
//	    	"  SELECT  " +
//	    	"  FILE_NM , FILE_SIZE , WRT_ID    , INS_DT       , UPD_DT , \n"+          
//	    	"  SEQ     , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE	         \n"+ 
//	    	"  FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND SEQ 			= '"+KEY1+"' 	\n"+ //일련번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_FILE_SQL;
//    }
//
//    // 사용전 검사 흠결
//    public  String  getPT_UB_DEFICIT()throws Exception {
//    	String PT_UB_DEFICIT_SQL="NOT";
//    	
//    	if ("PT_UB_DEFICIT".equals(TB_NM)){
//    		PT_UB_DEFICIT_SQL=
//	    	"  SELECT  " +
//	    	"  DEFI_SEQ , DEFI_CODE , DEFI_OUT  , WRT_ID , UPD_DT , \n"+
//	    	"  INS_DT   , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE      \n"+
//	    	"  FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND DEFI_SEQ		= '"+KEY1+"' 	\n"+ //흠결일련번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_DEFICIT_SQL;
//    }
//    
//    // 감리결과 관리  
//    public  String  getPT_UB_SUVSPOT()throws Exception {
//    	String PT_UB_SUVSPOT_SQL="NOT";
//    	
//    	if ("PT_UB_SUVSPOT".equals(TB_NM)){
//    		PT_UB_SUVSPOT_SQL=
//	    	"  SELECT  " +
//	    	"  RECV_NUM      , SUV_NAME       , SUV_STANUM      , SUV_NM            , SUV_TELNUM , \n"+
//	    	"  SUV_POSTNUM   , SUV_ADDR       , SUV_DETAILADDR  , SIWORK_NAME       , SIWORK_REP , \n"+
//	    	"  COI_WRT_NUM   , SIWORK_POSTNUM , SIWORK_ADDR     , SIWORK_DETAILADDR , SPOTNM     , \n"+
//	    	"  SPOT_POSTNUM  , SPOT_ADDR      , SPOT_DETAILADDR , WORK_ITEM         , USE        , \n"+
//	    	"  STRU_AREA     , AREA           , SW_DT           , EW_DT             , WRT_ID     , \n"+
//	    	"  INS_DT        , UPD_DT         , SIDO_CODE       , SIGUNGU_CODE      , SUV_MOBILE , \n"+
//	    	"  SIWORK_TELNUM , SIWORK_MOBILE  , DOC_YN          , PROC_LIM          , ORPE_NM    , \n"+
//	    	"  WORK_ITEM_ETC 																	   \n"+
//	    	"  FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND RECV_NUM 	= '"+KEY1+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY2+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY3+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_SUVSPOT_SQL;
//    }
//    
//	// 감리결과 메모
//    public  String  getPT_UB_SUVMEMO()throws Exception {
//    	String PT_UB_SUVMEMO_SQL="NOT";
//    	
//    	if ("PT_UB_SUVMEMO".equals(TB_NM)){
//    		PT_UB_SUVMEMO_SQL=
//	    	"  SELECT  " +
//	    	"  MEMO_DT  , MEMO_CONT , INS_DT    , UPD_DT       , WRT_ID   , \n"+
//	    	"  SEQ      , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE , WRT_NAME   \n"+
//	    	"  FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND SEQ 			= '"+KEY1+"' 	\n"+ //일련번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_SUVMEMO_SQL;
//    }
//    
//	// 착공전검사흠결
//    public  String  getPT_UB_SUVDEFICIT()throws Exception {
//    	String PT_UB_SUVDEFICIT_SQL="NOT";
//    	
//    	if ("PT_UB_SUVDEFICIT".equals(TB_NM)){
//    		PT_UB_SUVDEFICIT_SQL=
//	    	"  SELECT  " +
//	    	"  DEFI_SEQ , DEFI_CODE , DEFI_OUT  , WRT_ID       , UPD_DT , \n"+
//	    	"  INS_DT   , RECV_NUM  , SIDO_CODE , SIGUNGU_CODE            \n"+ 
//	    	"  FROM "+ TB_NM + "					\n" +
//	    	"  WHERE 1=1			  			\n" +
//	    	"  AND DEFI_SEQ		= '"+KEY1+"' 	\n"+ //흠결일련번호
//	    	"  AND RECV_NUM 	= '"+KEY2+"' 	\n"+ //접수번호
//	    	"  AND SIDO_CODE 	= '"+KEY3+"' 	\n"+ //시도코드
//	    	"  AND SIGUNGU_CODE = '"+KEY4+"' 	\n"; //시군구코드    	
//    	}
//    	return PT_UB_SUVDEFICIT_SQL;
//    }
}

		 


