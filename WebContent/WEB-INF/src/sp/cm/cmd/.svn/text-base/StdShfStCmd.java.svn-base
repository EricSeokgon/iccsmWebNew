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

public class StdShfStCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public StdShfStCmd() {
    }

    public StdShfStCmd(String next_url) {
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
        

        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scCOM_NAME = vl.getValueAsString("scCOM_NAME");

        sQuery.append(" select PT_S.SIDO_NM_CUT AS SiDO_NM,tmp.*,to_char(ADD_MONTHS(fn_date(chg_dt, 'yyyymmdd'),36), 'yyyymmdd') recv_dt2,to_char(ADD_MONTHS(chg_dt,36)+29, 'yyyymmdd') bas_sta_dt2 from \n");
        sQuery.append(" (select a.coi_wrt_num,a.sido_code,  a.name , max( b.chg_dt) chg_dt, '미달' as shortfall from pt_r_company_master a, \n");
        sQuery.append(" PT_R_BASIC_CHANGE_HISTORY b \n");
        sQuery.append(" where 1=1 \n");
        sQuery.append(" and a.coi_wrt_num=b.coi_wrt_num \n");
        sQuery.append(" AND (a.C_COM_DT IS NULL AND TRANS_UNION_PROC IS NULL AND TRANS_UNION_PARENT IS NULL )  \n"); // 폐업이 아닌것,합병된것 제외
        sQuery.append(" and b.sta_chg_Class_code in ( 'R00001', 'R00002', 'R00006','R00005','R00011','R00004', 'R00016' , 'R00021') \n"); //신규,기준, 합병, 분할, 법인, 양도
        sQuery.append(" group by a.coi_wrt_num, a.sido_code, a.name)  tmp \n");
        sQuery.append(" LEFT JOIN  PT_SIDO_CODE PT_S ON tmp.SIDO_CODE = PT_S.AREA_CODE \n");  
        
        sWhere.append(" WHERE 1 = 1 ");
        //  if (!scDIV.equalsIgnoreCase("A"))
        //	sWhere.append(" AND BAS_RET = '" + scDIV + "' ");
    	
        sWhere.append(" and to_char(ADD_MONTHS(chg_dt,36)+29, 'yyyymmdd') < to_char(sysdate,'yyyymmdd') "); //신고마감일자 위반
        if (!KJFUtil.isEmpty(scSIDO_CODE) && !scSIDO_CODE.equalsIgnoreCase("ALL"))
        sWhere.append("	AND tmp.SIDO_CODE = '" + scSIDO_CODE + "' ");
        if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
        sWhere.append("	AND tmp.COI_WRT_NUM = '" + scCOI_WRT_NUM + "' ");
        if( !KJFUtil.isEmpty( scCOM_NAME ))
        sWhere.append("	AND tmp.NAME  LIKE '%" + scCOM_NAME + "%' ");
        sWhere.append( " order by tmp.coi_wrt_num " );
        
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        request.setAttribute("dl", dl);  

        return next;
    }
}