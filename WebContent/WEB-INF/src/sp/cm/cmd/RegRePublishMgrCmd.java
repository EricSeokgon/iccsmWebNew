package sp.cm.cmd;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

public class RegRePublishMgrCmd implements KJFCommand {
	
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegRePublishMgrCmd() {
    }

    public RegRePublishMgrCmd(String next_url) {
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
        
        String scDATE1 = vl.getValueAsString("scDATE1");
        String scDATE2 = vl.getValueAsString("scDATE2");
    	String scNAME = vl.getValueAsString( "scNAME" );
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        String scCOM_NAME = vl.getValueAsString("scCOM_NAME");
        String scCOI_WRT_NUM = vl.getValueAsString("scCOI_WRT_NUM");
        String scSIDO_CODE = vl.getValueAsString("scSIDO_CODE");
      
        System.out.println(scRECV_NUM);
        
  
        sQuery.append(" SELECT '0' AS CHECKER, RECV_NUM,SIDO_CODE,COI_WRT_NUM,RECV_DT,NAME,WRT_NUM, ");
        sQuery.append(" TEL_NUM,FAX_NUM,WRT_ID,UPD_DT,INS_DT,DECODE(MOT_STE,'STD002','진행중','STD003','처리완료') AS MOT_STE,TMP_WRT_NUM ");
        sQuery.append(" FROM PT_R_RE_DERIVERY_STATEMENT ");
        sWhere.append(" WHERE 1=1 ");
        sWhere.append(" AND (SUBSTR(RECV_DT, 0, 8) BETWEEN '" + scDATE1 + "'");
		sWhere.append(" AND '" + scDATE2 + "')");
        sWhere.append(" AND SIDO_CODE ='" +scSIDO_CODE+"' \n");
		if (!KJFUtil.isEmpty(scRECV_NUM))
        	sWhere.append(" AND RECV_NUM ='" + scRECV_NUM + "' ");
		
		if( !KJFUtil.isEmpty( scCOM_NAME ) )
			sWhere.append( " AND NAME LIKE '%" + scCOM_NAME + "%' " );
				
		if( !KJFUtil.isEmpty( scNAME ) ) {
			sWhere.append( "AND NAME LIKE '%" + scNAME + "%' ");
		}
		
		if( !KJFUtil.isEmpty( scCOI_WRT_NUM ) )
			sWhere.append( " AND COI_WRT_NUM LIKE '" + scCOI_WRT_NUM + "' " );
         
    	rEntity    = rDAO.select(sQuery.toString() + sWhere.toString());    	
    	//DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우  ReEnt2CodeDs
    	//를 사용한다.
      
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }

}
