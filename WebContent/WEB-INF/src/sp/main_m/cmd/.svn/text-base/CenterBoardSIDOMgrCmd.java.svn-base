/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.main_m.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class CenterBoardSIDOMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CenterBoardSIDOMgrCmd() {
    }

    public CenterBoardSIDOMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
           		   
	 	rEntity    = rDAO.select(CM_CODE(SIDO_CODE));    
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
	    
        rEntity    = rDAO.select(AM_CD(SIDO_CODE));        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
        
        rEntity    = rDAO.select(UB_CD(SIDO_CODE));        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output3");
        
        rEntity    = rDAO.select(LIST_CODE(SIDO_CODE));        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output4");

        StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		/*sQuery.append( " SELECT '0' AS CHECKER, DD.RECV_DT, BB.SIDO_CODE,BB.CHGBRE_SEQ, BB.MOT_STE, AA.COI_WRT_NUM, AA.WRT_DT, AA.NAME, " );
		sQuery.append( " AA.REP_NM_KOR, AA.C_COM_DT, AA.ADDR_ADDR,  DECODE(AA.C_COM_DT, NULL, '', '폐업') AS TMPC_COM_DT, " );
		sQuery.append( " AA.TMP_WRT_NUM, BB.RECV_NUM, AA.MANA_NUM, CC.CODE_NAME AS TMPMOT_STE, " );
		sQuery.append( " REPLACE(SUBSTR(BB.INS_DT, 0, 10), '-', '') INS_DT, " );
		sQuery.append( " BB.CHG_DT HISTORY_CHG_DT,to_char(ADD_MONTHS(BB.CHG_DT,36), 'yyyymmdd')AS BAS_STA_DT, to_char(ADD_MONTHS(BB.CHG_DT,36)+30, 'yyyymmdd')AS BAS_STA_DT2 " );
		sQuery.append( " FROM (PT_R_COMPANY_MASTER AA INNER JOIN " );
		sQuery.append( " (SELECT SIDO_CODE, RECV_NUM, TMP_WRT_NUM, CHGBRE_SEQ, MOT_STE, INS_DT, CHG_DT " );
		sQuery.append( " FROM PT_R_BASIC_CHANGE_HISTORY " );
		sQuery.append( " WHERE STA_CHG_CLASS_CODE = 'R00002' AND SIDO_CODE = '" + SIDO_CODE + "') BB ON AA.TMP_WRT_NUM = BB.TMP_WRT_NUM) " );
		sQuery.append( " LEFT JOIN (SELECT CODE, CODE_NAME FROM PT_COM_CODE WHERE P_CODE = 'REGSTDPROC') CC " );
		sQuery.append( " ON BB.MOT_STE = CC.CODE " );
		sQuery.append( " INNER JOIN PT_R_BASIC_STATEMENT DD " );
		sQuery.append( " ON BB.RECV_NUM = DD.RECV_NUM AND BB.SIDO_CODE = DD.SIDO_CODE " );
		sWhere.append( " WHERE 1 = 1 AND MOT_STE<>'STD003' " );
		sWhere.append( " ORDER BY RECV_DT  " );*/
		/*
		sQuery.append("select *  \n");
      	sQuery.append("from (   \n");
      	sQuery.append("select * \n");
      	sQuery.append("from (   \n");
      	sQuery.append("    select  \n");
      	sQuery.append("    sido_code, tmp_wrt_num, coi_wrt_num, name, recv_dt,  \n");
      	sQuery.append("    to_char(ADD_MONTHS(fn_date(wrt_dt, 'yyyymmdd'),36), 'yyyymmdd') recv_dt2,to_char(ADD_MONTHS(wrt_dt,36)+30, 'yyyymmdd') bas_sta_dt2, \n");
      	sQuery.append("    wrt_dt, chg_dt,  bas_sta_dt, \n");
      	sQuery.append("    'X' BAS_RET     \n");
      	sQuery.append("    from (         \n");
      	sQuery.append("        select      \n");
      	sQuery.append("        decode(bc.sido_code, '', cm.sido_code, bc.sido_code) sido_code, bc.tmp_wrt_num, bc.coi_wrt_num, decode(bc.name, '', cm.name, bc.name) name, \n");
      	sQuery.append("        case  \n");
      	sQuery.append("             when bc.rec_dt is not null then bc.rec_dt   \n");
      	sQuery.append("             when bc.chg_dt is not null then bc.chg_dt   \n");
      	sQuery.append("             when cm.wrt_dt is not null then cm.wrt_dt   \n");
      	sQuery.append("             else null                                   \n");
      	sQuery.append("        end recv_dt,                                     \n");
      	sQuery.append("        bc.bas_sta_dt, bc.wrt_dt, bc.chg_dt              \n");
      	sQuery.append("        from                                             \n");
      	sQuery.append("        PT_R_COMPANY_MASTER cm                           \n");
      	sQuery.append("        inner join                                  \n");
      	sQuery.append("        (                                                \n");
      	sQuery.append("            select bc1.* from                            \n");
      	sQuery.append("            pt_r_basic_change_history bc1                \n");
      	sQuery.append("            where (tmp_wrt_num, chgbre_seq) in  (                                \n");
      	sQuery.append("                select tmp_wrt_num, max(chgbre_seq) chgbre_seq from ( \n"); // 가장 최근에 변경된 내역을 조회
      	sQuery.append("                    select tmp_wrt_num, chgbre_seq from  \n");				
      	sQuery.append("                    pt_r_basic_change_history            \n");
      	sQuery.append("                    where sta_chg_class_code in ( 'R00001', 'R00002' )\n"); //공사업 신규등록/기준신고
      	sQuery.append("                ) bc2                                    \n");
      	sQuery.append("                group by tmp_wrt_num         \n");
      	sQuery.append("            )                                       \n");
      	sQuery.append("        ) bc                                             \n");
      	sQuery.append("        on cm.tmp_wrt_num = bc.tmp_wrt_num               \n");
      	sQuery.append("        where cm.c_com_dt is null                    \n");
      	sQuery.append("    )                                                    \n");
      	sQuery.append("    where REGEXP_LIKE(recv_dt, '[[:digit:]]{8}') and fn_date(recv_dt, 'yyyymmdd') is not null  \n");
      	sQuery.append(")                                                        \n");
      	sQuery.append("where 1 = 1                                              \n");
//      	sQuery.append("and (recv_dt2 between '20101001' and '20101231')       \n");
      	sQuery.append("and (recv_dt2 between  sysdate-30 and to_char(ADD_MONTHS(fn_date(wrt_dt, 'yyyymmdd'),36), 'yyyymmdd')  )        \n");
      	sQuery.append("                                                         \n");
      	sQuery.append("union all                                                \n");
      	sQuery.append("                                                         \n");
      	sQuery.append("select                                                   \n");
      	sQuery.append("sido_code, tmp_wrt_num, coi_wrt_num, name, recv_dt,     \n");
      	sQuery.append("to_char(ADD_MONTHS(wrt_dt,36), 'yyyymmdd') recv_dt2,to_char(ADD_MONTHS(wrt_dt,36)+30, 'yyyymmdd') bas_sta_dt2,   \n");
      	sQuery.append("wrt_dt, chg_dt, bas_sta_dt,                             \n");
      	sQuery.append("'O' BAS_RET                                              \n");
      	sQuery.append("from (                                                   \n");
      	sQuery.append("    select *                                             \n");
      	sQuery.append("    from                                                 \n");
      	sQuery.append("    (                                                    \n");
      	sQuery.append("        select                                           \n");
      	sQuery.append("        decode(bc.sido_code, '', cm.sido_code, bc.sido_code) sido_code, bc.tmp_wrt_num, bc.coi_wrt_num, decode(bc.name, '', cm.name, bc.name) name, \n");
      	sQuery.append("        decode(bc.rec_dt, '', bc.chg_dt, bc.rec_dt) recv_dt,         \n");
      	sQuery.append("        bc.bas_sta_dt, bc.wrt_dt, bc.chg_dt                             \n");
      	sQuery.append("        from                                             \n");
      	sQuery.append("        PT_R_COMPANY_MASTER cm                           \n");
      	sQuery.append("        inner join                                       \n");
      	sQuery.append("        (                                                \n");
      	sQuery.append("        select bc1.*                                     \n");
      	sQuery.append("         from                                            \n");
      	sQuery.append("            pt_r_basic_change_history bc1                \n");
      	sQuery.append("            inner join (                                 \n");
      	sQuery.append("                select tmp_wrt_num, max(chgbre_seq) chgbre_seq from ( \n");
      	sQuery.append("                    select tmp_wrt_num, chgbre_seq from  \n");
      	sQuery.append("                    pt_r_basic_change_history            \n");
      	sQuery.append("                    where sta_chg_class_code in ( 'R00001', 'R00002' ) and (chg_dt between '20101001' and '20101231')\n");
      	sQuery.append("                ) bc2                                    \n");
      	sQuery.append("                group by tmp_wrt_num, chgbre_seq         \n");
      	sQuery.append("            ) bc2                                        \n");
      	sQuery.append("            on bc1.tmp_wrt_num = bc2.tmp_wrt_num and bc1.chgbre_seq = bc2.chgbre_seq  \n");
      	sQuery.append("        ) bc                                             \n");
      	sQuery.append("        on cm.tmp_wrt_num = bc.tmp_wrt_num               \n");
      	sQuery.append("     where cm.c_com_dt is null                         \n");
      	sQuery.append("    ) where REGEXP_LIKE(recv_dt, '[[:digit:]]{8}') and fn_date(recv_dt, 'yyyymmdd') is not null  \n");
      	sQuery.append(")                                                        \n");
      	sQuery.append(")                                                        \n");
        sWhere.append(" WHERE 1 = 1 ");
        sWhere.append(" AND BAS_RET = 'X' ");
        sWhere.append(" AND BAS_STA_DT is not null AND SIDO_CODE = '" + SIDO_CODE + "' ");
        sWhere.append(" ORDER BY RECV_DT " );
        */
		sQuery.append(" select   TO_CHAR(SYSDATE, 'YYYYMMDD') as start_dt,TO_CHAR(TRUNC(ADD_MONTHS(SYSDATE, 0)+2,'DD'), 'YYYYMMDD') as end_dt,PT_S.SIDO_NM_CUT AS SiDO_NM,tmp.*,to_char(ADD_MONTHS(fn_date(chg_dt, 'yyyymmdd'),36), 'yyyymmdd') recv_dt2,to_char(ADD_MONTHS(chg_dt,36)+30, 'yyyymmdd') bas_sta_dt2 from " );
		sQuery.append(" (select a.coi_wrt_num,a.sido_code,  a.name , max( b.chg_dt) chg_dt from pt_r_company_master a, " );
		sQuery.append(" PT_R_BASIC_CHANGE_HISTORY b " );
		sQuery.append(" where 1=1 " );
		sQuery.append(" and a.coi_wrt_num=b.coi_wrt_num " );
		sQuery.append(" and a.c_com_dt is  null             " );
		sQuery.append(" and b.sta_chg_Class_code in ( 'R00001', 'R00002', 'R00006','R00005','R00011','R00004', 'R00016' , 'R00021') " );
		sQuery.append(" group by a.coi_wrt_num, a.sido_code, a.name)  tmp " );
		sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON tmp.SIDO_CODE = PT_S.AREA_CODE " );  
		sWhere.append(" where 1=1 " );
		sWhere.append(" and (to_char(ADD_MONTHS(fn_date(chg_dt, 'yyyymmdd'),36), 'yyyymmdd') between  TO_CHAR(SYSDATE, 'YYYYMMDD') and TO_CHAR(TRUNC(ADD_MONTHS(SYSDATE, 0)+2,'DD'), 'YYYYMMDD') ) " );
		sWhere.append(" and sido_code ='bsbs' " );
		sWhere.append(" order by RECV_DT2 asc " );
		
		
		rEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		KJFMi.ReEnt2Ds( dl, rEntity, "output6" );
				
        request.setAttribute("dl", dl);  

        return next;
    }
    public String LIST_CODE(String SIDO_CODE) throws Exception {
    	
    	StringBuilder result = new StringBuilder();
    	
    	result.append(" SELECT SIDO_CODE,CALS_NAME,NAME,RECV_DT,LIST_DT,N_URL_ID,N_URL   \n");
    	result.append("   FROM V_PT_MAIN_SIDO   \n");
    	result.append("  WHERE SIDO_CODE = '"+SIDO_CODE+"'   \n");
    	result.append("    AND ROWNUM <= 10   \n");
    	result.append("  ORDER BY LIST_DT DESC   \n");
    	
    	return result.toString();
    }   
    
    public String CM_CODE(String SIDO_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();

    	result.append("SELECT * FROM(      \n" );
    	result.append("	SELECT       \n" );
    	result.append("		'신규등록' AS GUBUN,     \n");
    	result.append("		'15' AS GR_NM,    \n");
		result.append("		'cm::RegReceiptMgr.xml' AS N_URL_ID,    \n");
		result.append("		'../cm/RegReceiptMgr.xml' AS N_URL,    \n");
		result.append("		'120' AS N_ID,    \n");
		result.append("		'cm::RegMgr.xml' AS M_URL_ID,      \n");
		result.append("		'../cm/RegMgr.xml' AS M_URL,      \n");
		result.append("		'215' AS M_ID,    \n");
		result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD001' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD002' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 3  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 6  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 9  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 12  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
		result.append("		FROM PT_R_BASIC_CHANGE_HISTORY		\n");
		result.append("		WHERE REC_DT is not null			\n");
		result.append("		AND STA_CHG_CLASS_CODE = 'R00001'	\n");
		result.append("		AND SIDO_CODE = '"+SIDO_CODE+"'		\n");
		result.append("		AND SUBSTR(REC_DT,1,4) = '2010'		\n");
		result.append("		GROUP BY SUBSTR(REC_DT,1,4)			\n");
		result.append("	UNION ALL     \n");
		result.append("	SELECT       \n");
		result.append("		'등록기준신고' AS GUBUN,     \n");
		result.append("		'16' AS GR_NM,    \n");
		result.append("		'cm::StdReceiptMgr.xml' AS N_URL_ID,    \n");
		result.append("		'../cm/StdReceiptMgr.xml' AS N_URL,    \n");
		result.append("		'131' AS N_ID,    \n");
		result.append("		'cm::StdMgr.xml' AS M_URL_ID,    \n");
		result.append("		'../cm/StdMgr.xml' AS M_URL,    \n");
		result.append("		'132' AS M_ID,    \n");
		result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD001' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD002' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 3  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 6  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 9  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 12  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
		result.append("		FROM PT_R_BASIC_CHANGE_HISTORY		\n");
		result.append("		WHERE REC_DT is not null			\n");
		result.append("		AND STA_CHG_CLASS_CODE = 'R00002'	\n");
		result.append("		AND SIDO_CODE = '"+SIDO_CODE+"'		\n");
		result.append("		AND SUBSTR(REC_DT,1,4) = '2010'		\n");
		result.append("		GROUP BY SUBSTR(REC_DT,1,4)			\n");
    	result.append("	UNION ALL     \n");
    	result.append("	SELECT       \n");
    	result.append("		'양도 양수' AS GUBUN,    \n");
    	result.append("		'17' AS GR_NM,    \n");
    	result.append("		'cm::TransReceiptMgr.xml' AS N_URL_ID,    \n");
    	result.append("		'cm::TransReceiptMgr.xml' AS N_URL,    \n");
    	result.append("		'137' AS N_ID,    \n");
    	result.append("		'cm::TransMgr.xml' AS M_URL_ID,    \n");
    	result.append("		'../cm/TransMgr.xml' AS M_URL,    \n");
    	result.append("		'138' AS M_ID,    \n");
		result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD001' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD002' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 3  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 6  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 9  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 12  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
		result.append("		FROM PT_R_BASIC_CHANGE_HISTORY		\n");
		result.append("		WHERE REC_DT is not null			\n");
		result.append("		AND (STA_CHG_CLASS_CODE = 'R00004' OR STA_CHG_CLASS_CODE = 'R00005' OR STA_CHG_CLASS_CODE = 'R00011')	\n");
		result.append("		AND SIDO_CODE = '"+SIDO_CODE+"'		\n");
		result.append("		AND SUBSTR(REC_DT,1,4) = '2010'		\n");
		result.append("		GROUP BY SUBSTR(REC_DT,1,4)			\n");
    	result.append("	UNION ALL     \n");
    	result.append("	SELECT      \n");
    	result.append("		'법인합병' AS GUBUN,    \n");
    	result.append("		'18' AS GR_NM,    \n");
    	result.append("		'cm::UnionReceiptMgr.xml' AS N_URL_ID,    \n");
    	result.append("		'../cm/UnionReceiptMgr.xml' AS N_URL,    \n");
    	result.append("		'149' AS N_ID,    \n");
    	result.append("		'cm::UnionMgr.xml' AS M_URL_ID,    \n");
    	result.append("		'../cm/UnionMgr.xml' AS M_URL,    \n");
    	result.append("		'151' AS M_ID,    \n");
		result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD001' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD002' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 3  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 6  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 9  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 12  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
		result.append("		FROM PT_R_BASIC_CHANGE_HISTORY		\n");
		result.append("		WHERE REC_DT is not null			\n");
		result.append("		AND STA_CHG_CLASS_CODE = 'R00006'	\n");
		result.append("		AND SIDO_CODE = '"+SIDO_CODE+"'		\n");
		result.append("		AND SUBSTR(REC_DT,1,4) = '2010'		\n");
		result.append("		GROUP BY SUBSTR(REC_DT,1,4)			\n");
    	result.append("		UNION ALL    \n");
    	result.append("	SELECT     \n");
    	result.append("		'폐업처리' AS GUBUN,    \n");
    	result.append("		'23' AS GR_NM,    \n");
    	result.append("		'' AS N_URL_ID,    \n");
    	result.append("		'' AS N_URL,    \n");
    	result.append("		'' AS N_ID,    \n");
    	result.append("		'cm::CloseMgr.xml' AS M_URL_ID,    \n");
    	result.append("		'../cm/CloseMgr.xml' AS M_URL,    \n");
    	result.append("		'152' AS M_ID,    \n");
		result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD001' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
		result.append("		NVL(sum(CASE MOT_STE WHEN 'STD002' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 3  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 6  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 9  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
		result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(CHG_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(CHG_DT,5,2)) <= 12  AND MOT_STE  = 'STD003' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
		result.append("		FROM PT_R_BASIC_CHANGE_HISTORY		\n");
		result.append("		WHERE REC_DT is not null			\n");
		result.append("		AND STA_CHG_CLASS_CODE = 'R00003'	\n");
		result.append("		AND SIDO_CODE = '"+SIDO_CODE+"'		\n");
		result.append("		AND SUBSTR(REC_DT,1,4) = '2010'		\n");
		result.append("		GROUP BY SUBSTR(REC_DT,1,4)			\n");
    	result.append(") \n");

		return result.toString();
    }
    
    public String AM_CD(String SIDO_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();
    	
    		result.append("SELECT * FROM(   \n");
    		result.append("		  SELECT       \n");
    		result.append("			'등록취소' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::CancelMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/CancelMgr.xml' AS N_URL,    \n");
    		result.append("			'162' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::CancelMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/CancelMgr.xml' AS M_URL,      \n");
    		result.append("			'162' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(RC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_REGIST_CANCEL RC  LEFT OUTER JOIN  PT_M_MASTER MM\n");
    		result.append("		ON RC.TMP_WRT_NUM = MM.TMP_WRT_NUM AND RC.WRT_NUM = MM.WRT_NUM        \n");
    		result.append("		  WHERE RC.INS_DT is not null     \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");
    		result.append("		UNION ALL\n");
    		
    		result.append("		SELECT       \n");
    		result.append("			'영업정지' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::StopMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/StopMgr.xml' AS N_URL,    \n");
    		result.append("			'161' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::StopMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/StopMgr.xml' AS M_URL,      \n");
    		result.append("			'161' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MS.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_SUSPENSION MS  LEFT OUTER JOIN  PT_M_MASTER MM\n");
    		result.append("		ON MS.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MS.WRT_NUM = MM.WRT_NUM AND MM.DISPO_CONT = 'M00002' AND MM.DISPO_CONT2 IS NULL       \n");
    		result.append("		  WHERE MS.INS_DT is not null     \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");
    		result.append("		UNION ALL\n");
    		
    		result.append("		  SELECT       \n");
    		result.append("			'과태료부과' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::IncidenceMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/IncidenceMgr.xml' AS N_URL,    \n");
    		result.append("			'163' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::IncidenceMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/IncidenceMgr.xml' AS M_URL,      \n");
    		result.append("			'163' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MN.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_NEGLIGENCE MN  LEFT OUTER JOIN  PT_M_MASTER MM\n");
    		result.append("		ON MN.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MN.WRT_NUM = MM.WRT_NUM AND MM.DISPO_CONT = 'M00003' AND MM.DISPO_CONT2 IS NULL       \n");
    		result.append("		  WHERE MN.INS_DT is not null     \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");

    		result.append("		UNION ALL\n");
    		result.append("		  SELECT       \n");
    		result.append("			'영업정지및과태료부과' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::IncidenceMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/IncidenceMgr.xml' AS N_URL,    \n");
    		result.append("			'163' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::IncidenceMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/IncidenceMgr.xml' AS M_URL,      \n");
    		result.append("			'163' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(DECODE(MS.INS_DT,'',MN.INS_DT,MS.INS_DT),'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_MASTER MM  \n");
    		result.append("		LEFT OUTER JOIN PT_M_SUSPENSION MS ON MS.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MS.WRT_NUM = MM.WRT_NUM AND MM.DISPO_CONT IN ('M00002', 'M00003') AND MM.DISPO_CONT2 IS NOT NULL       \n");
    		result.append("		LEFT OUTER JOIN PT_M_NEGLIGENCE MN  ON MN.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MN.WRT_NUM = MM.WRT_NUM AND MM.DISPO_CONT IN ('M00002', 'M00003') AND MM.DISPO_CONT2 IS NOT NULL       \n");
    		result.append("		  WHERE MN.INS_DT is not null AND MS.INS_DT is not null \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");    		
    		
    		result.append("		UNION ALL\n");
    		result.append("		  SELECT       \n");
    		result.append("			'경고조치' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::WarnMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/WarnMgr.xml' AS N_URL,    \n");
    		result.append("			'169' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::WarnMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/WarnMgr.xml' AS M_URL,      \n");
    		result.append("			'169' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MW.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_WARNING MW  LEFT OUTER JOIN  PT_M_MASTER MM\n");
    		result.append("		ON MW.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MW.WRT_NUM = MM.WRT_NUM        \n");
    		result.append("		  WHERE MW.INS_DT is not null     \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");
    		result.append("		UNION ALL\n");
    		result.append("		  SELECT       \n");
    		result.append("			'시정명령' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::CorrectMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/CorrectMgr.xml' AS N_URL,    \n");
    		result.append("			'164' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::CorrectMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/CorrectMgr.xml' AS M_URL,      \n");
    		result.append("			'164' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MC.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_CORRECT MC  LEFT OUTER JOIN  PT_M_MASTER MM\n");
    		result.append("		ON MC.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MC.WRT_NUM = MM.WRT_NUM        \n");
    		result.append("		  WHERE MC.INS_DT is not null     \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");
    		result.append("		UNION ALL\n");
    		result.append("		  SELECT       \n");
    		result.append("			'형사고발' AS GUBUN,     \n");
    		result.append("			'25' AS GR_NM,    \n");
    		result.append("			NVL(MAX(MM.SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,     \n");
    		result.append("			NVL(SUM(CASE  WHEN MM.MOT_STE = 'C00002' OR MM.MOT_STE is null THEN 1 ELSE 0 END),'0') AS  NEW_DATA,     \n");
    		result.append("			'am::CorrectMgr.xml' AS N_URL_ID,    \n");
    		result.append("			'../am/CorrectMgr.xml' AS N_URL,    \n");
    		result.append("			'165' AS N_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN MM.MOT_STE = 'C00001' THEN 1 ELSE 0 END),'0') AS  ING_DATA,      \n");
    		result.append("			'am::CorrectMgr.xml' AS M_URL_ID,      \n");
    		result.append("			'../am/CorrectMgr.xml' AS M_URL,      \n");
    		result.append("			'165' AS M_ID,    \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 3  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 3 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 6  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 6 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 9  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,     \n");
    		result.append("			NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) > 9 AND TO_NUMBER(SUBSTR(TO_CHAR(TO_DATE(MP.INS_DT,'YYYY-MM-DD HH24:MI:SS'),'yyyyMMdd'),5,2)) <= 12  AND MM.MOT_STE  = 'C00001' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER     \n");
    		result.append("		FROM PT_M_PROSECUTION MP  LEFT OUTER JOIN  PT_M_MASTER MM\n");
    		result.append("		ON MP.TMP_WRT_NUM = MM.TMP_WRT_NUM AND MP.WRT_NUM = MM.WRT_NUM        \n");
    		result.append("		  WHERE MP.INS_DT is not null     \n");
    		result.append("		  AND MM.SIDO_CODE = '"+SIDO_CODE+"' \n");
    		
    		
    		result.append(") \n");

    	
		return result.toString();
    	
    }
    
    public String UB_CD(String SIDO_CODE) throws Exception {
    	StringBuilder result = new StringBuilder();
    		result.append("SELECT * FROM(   \n");
        	result.append("	SELECT    \n");
        	result.append("		'착공전설계' AS GUBUN,     \n");
        	result.append("		'20' AS GR_NM,    \n");
        	result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '1' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,    \n");
        	result.append("		'ub::BeforeMgr.xml' AS N_URL_ID,    \n");
        	result.append("		'../ub/BeforeMgr.xml' AS N_URL,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '2' THEN 1 ELSE 0 END),'0') AS  ING_DATA,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS M_URL_ID,    \n");
        	result.append("		'../ub/BeforeInvestResultSt.xml' AS M_URL,    \n");
        	result.append("		'ub::BeforeInvestResultSt.xml' AS O_URL_ID,    \n");
        	result.append("		'../ub/BeforeInvestResultSt.xml' AS O_URL,    \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 3  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,    \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 6  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,	  \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 9  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,	  \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER	  \n");
        	result.append("	FROM PT_UB_CONSTRUCTION     \n");
        	result.append("	WHERE RECV_DT is not null     \n");
        	result.append("	AND SIDO_CODE = '"+SIDO_CODE+"'     \n");
        	result.append("	UNION ALL	\n");
        	result.append("	SELECT    \n");
        	result.append("		'사용전검사' AS GUBUN,     \n");
        	result.append("		'21' AS GR_NM,    \n");
        	result.append("		NVL(MAX(SIDO_CODE),'"+SIDO_CODE+"') AS SIDO_CODE,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '1' THEN 1 ELSE 0 END),'0') AS  NEW_DATA,    \n");
        	result.append("		'ub::UBReceiptMgr' AS N_URL_ID,    \n");
        	result.append("		'../ub/UBReceiptMgr' AS N_URL,    \n");
        	result.append("		NVL(sum(CASE PROC_STE WHEN '2' THEN 1 ELSE 0 END),'0') AS  ING_DATA,    \n");
        	result.append("		'ub::UBInvestMgr' AS M_URL_ID,    \n");
        	result.append("		'../ub/UBInvestMgr' AS M_URL,    \n");
        	result.append("		'ub::UBInvestResultSt.xml' AS O_URL_ID,    \n");
        	result.append("		'../ub/UBInvestResultSt.xml' AS O_URL,    \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 3  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,    \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 6  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,	  \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 9  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,	  \n");
        	result.append("		NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER	  \n");
        	result.append("	FROM PT_UB_USEBEFORE     \n");
        	result.append("	WHERE RECV_DT is not null     \n");
        	result.append("	AND SIDO_CODE = '"+SIDO_CODE+"'     \n");
        	result.append(") \n");
    	
    	
		return result.toString();
    	
    }


}