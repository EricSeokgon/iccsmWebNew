/**
 * 파일명   : RegMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class StdNearStCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public StdNearStCmd() {
    }
 
    public StdNearStCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        String scDATE = vl.getValueAsString("scDATE");
        String scDATE1 = vl.getValueAsString("scDATE1");
        String scDATE2 = vl.getValueAsString("scDATE2");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scCOM_NAME = vl.getValueAsString("scCOM_NAME");

    /*    
      	sQuery.append("select *  \n");
      	sQuery.append("from (   \n");
      	sQuery.append("select * \n");
      	sQuery.append("from (   \n");
      	sQuery.append("    select  \n");
      	sQuery.append("    sido_code, tmp_wrt_num, coi_wrt_num, name, recv_dt,  \n");
//      	sQuery.append("    to_char(ADD_MONTHS(fn_date(recv_dt, 'yyyymmdd'),36), 'yyyymmdd') recv_dt2,to_char(ADD_MONTHS(recv_dt,36)+30, 'yyyymmdd') bas_sta_dt2, \n");
//		wbjeon 완료일 기준
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
      	sQuery.append("and (recv_dt2 between '" + scDATE1 + "' and '" + scDATE2 + "' )       \n");
      	sQuery.append("                                                         \n");
      	sQuery.append("union all                                                \n");
      	sQuery.append("                                                         \n");
      	sQuery.append("select                                                   \n");
      	sQuery.append("sido_code, tmp_wrt_num, coi_wrt_num, name, recv_dt,     \n");
//      	sQuery.append("to_char(ADD_MONTHS(recv_dt,36), 'yyyymmdd') recv_dt2,to_char(ADD_MONTHS(recv_dt,36)+30, 'yyyymmdd') bas_sta_dt2,   \n");
//	wbjeon 완료일 기준
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
      	sQuery.append("                    where sta_chg_class_code in ( 'R00001', 'R00002' ) and (chg_dt between '" + scDATE1 + "' and '" + scDATE2 + "')\n");
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
*/  
        sQuery.append(" select PT_S.SIDO_NM_CUT AS SiDO_NM,tmp.*,to_char(ADD_MONTHS(fn_date(chg_dt, 'yyyymmdd'),36), 'yyyymmdd') recv_dt2, to_char(ADD_MONTHS(chg_dt,36)-29, 'yyyymmdd') bas_sta_dt3, " +
        		"to_char(ADD_MONTHS(chg_dt,36)+29, 'yyyymmdd') bas_sta_dt2 from \n");
        sQuery.append(" (select a.coi_wrt_num,a.rep_nm_kor,a.sido_code,SUBSTR(a.ADDR_POST_NUM,1,3) || '-' ||SUBSTR(a.ADDR_POST_NUM,4,3) as ADDR_POST_NUM,a.ADDR_ADDR||a.ADDR_DETAIL_ADDR as ADDR_ADDR,  a.name , max( b.chg_dt) chg_dt,a.ADDR_TEL_NUM,a.ADDR_FAX_NUM from pt_r_company_master a, \n");
        sQuery.append(" PT_R_BASIC_CHANGE_HISTORY b \n");
        sQuery.append(" where 1=1 \n");
        sQuery.append(" and a.coi_wrt_num=b.coi_wrt_num \n");
        sQuery.append(" AND (a.C_COM_DT IS NULL AND TRANS_UNION_PROC IS NULL AND TRANS_UNION_PARENT IS NULL )  \n"); // 폐업이 아닌것,합병된것 제외
        sQuery.append(" and b.sta_chg_Class_code in ( 'R00001', 'R00002', 'R00006','R00005','R00011','R00004', 'R00016' , 'R00021') \n"); //신규,기준, 합병, 분할, 법인, 양도
        sQuery.append(" group by a.coi_wrt_num, a.sido_code, a.name,  a.addr_post_num, a.addr_addr,a.ADDR_DETAIL_ADDR,a.rep_nm_kor,a.ADDR_TEL_NUM,a.ADDR_FAX_NUM)  tmp \n");
        sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON tmp.SIDO_CODE = PT_S.AREA_CODE \n");  
        sWhere.append(" WHERE 1 = 1 ");
     //   if (!scDIV.equalsIgnoreCase("A"))
        //	sWhere.append(" AND BAS_RET = '" + scDIV + "' ");
        if (scDATE.equalsIgnoreCase("recv_dt2"))
        sWhere.append("	and (to_char(ADD_MONTHS(fn_date(chg_dt, 'yyyymmdd'),36), 'yyyymmdd') between '" + scDATE1 + "' and '" + scDATE2 + "' ) ");
        if (scDATE.equalsIgnoreCase("bas_sta_dt2"))
        sWhere.append("	and (to_char(ADD_MONTHS(chg_dt,36)+29, 'yyyymmdd') between '" + scDATE1 + "' and '" + scDATE2 + "' ) ");
        if (scDATE.equalsIgnoreCase("bas_sta_dt3"))
            sWhere.append("	and (to_char(ADD_MONTHS(chg_dt,36)-29, 'yyyymmdd') between '" + scDATE1 + "' and '" + scDATE2 + "' ) ");
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        sWhere.append("	AND tmp.SIDO_CODE = '" + scSIDO_CODE + "' ");
        if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
        sWhere.append("	AND tmp.COI_WRT_NUM = '" + scCOI_WRT_NUM + "' ");
        if( !KJFUtil.isEmpty( scCOM_NAME ))
        sWhere.append("	AND tmp.NAME  LIKE '%" + scCOM_NAME + "%' ");
        sWhere.append( " order by to_char(ADD_MONTHS(fn_date(chg_dt, 'yyyymmdd'),36), 'yyyymmdd')" );
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}