/**
 * 파일명   : DellNumMgr2Cmd.java
 * 설명     : 필증발급번호감소 cmd
 * 이력사항
 * CH00     : 2010/11/02 이석곤 최초작성
 */

package sp.ub.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;
import kjf.util.KJFDate;
import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class DeliNumMgr2Cmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public DeliNumMgr2Cmd() {
    }

    public DeliNumMgr2Cmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity cEntity     = null;
        ReportEntity oEntity     = null;
        ReportEntity rEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        String DELI_ITEM  = vl.getValueAsString("DELI_ITEM");
        
        String year = KJFUtil.print(vl.getValueAsString("DELI_DT"),KJFDate.getCurTime("yyyy"));
    	
        String cntSQL=
    		"	SELECT COUNT(*) AS CNT FROM  PT_UB_DELI_MASTER WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' AND YEAR = '"+year+"' AND DELI_ITEM = '"+DELI_ITEM+"'   \n";
    	
    	cEntity    = rDAO.select(cntSQL);   
    	
    	if(cEntity.getValue(0,"CNT").equals("0")){
    		String codeSQL = " SELECT SUBSTR(SIDO_NM,0,2) AS SIDO_NM , SIGUNGU_NM FROM PT_SIDO_CODE WHERE AREA_CODE = '"+SIGUNGU_CODE+"' ";
    		oEntity = rDAO.select(codeSQL);   
    		String DELI_SIGUNGU = oEntity.getValue(0,"SIGUNGU_NM");
    		
    		if("본청".equals(DELI_SIGUNGU)){
    			DELI_SIGUNGU = oEntity.getValue(0,"SIDO_NM");
    		}
    		
    		String insertSQL = "INSERT INTO PT_UB_DELI_MASTER (SIDO_CODE,SIGUNGU_CODE,YEAR,DELI_NUM,DELI_ITEM,DELI_SIGUNGU) VALUES   " +
    				"('"+SIDO_CODE+"','"+SIGUNGU_CODE+"','"+year+"','00000','"+DELI_ITEM+"','"+DELI_SIGUNGU+"')";
    		rDAO.execute(insertSQL);
    		
    	}
    	
    	String selectSQL = 
    			" SELECT DELI_SIGUNGU||'-'||YEAR||'-'||LPAD(TO_NUMBER(DELI_NUM),5,'0') AS DELI_NUM   \n" +
    			"   FROM PT_UB_DELI_MASTER   \n" +
    			"  WHERE SIDO_CODE = '"+SIDO_CODE+"' \n" +
    			"    AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n" +
    			"	 AND YEAR = '"+year+"' \n" +
    			"	 AND DELI_ITEM = '"+DELI_ITEM+"'  ";
    	
    	rEntity = rDAO.select(selectSQL);  
    	
    	String updateSQL = "UPDATE PT_UB_DELI_MASTER SET DELI_NUM = LPAD(TO_NUMBER(DELI_NUM)-1,5,'0')  \n"+
							"  WHERE SIDO_CODE = '"+SIDO_CODE+"' \n" +
							"    AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n" +
							"	 AND YEAR = '"+year+"' \n" +
							"	 AND DELI_ITEM = '"+DELI_ITEM+"'  ";
    	
    	rDAO.execute(updateSQL);
    	
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }

}