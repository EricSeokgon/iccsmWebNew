/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
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

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBItemMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBItemMgrCmd() {
    }

    public UBItemMgrCmd(String next_url) {
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
    	
        String scITEM = vl.getValueAsString("scITEM");
        String scLARCLAS = vl.getValueAsString("scLARCLAS");
        String scMIDCLAS = vl.getValueAsString("scMIDCLAS");
        String scSMACLAS = vl.getValueAsString("scSMACLAS");
        
    	String selectSQL=
    		"	SELECT '0' AS CHK, ITEM, SEQ, LARCLAS, MIDCLAS, SMACLAS, CONT, BAS, CONT_YN,ORDER_SEQ,DETAIL_CONT,  \n" +
    		"   CASE ITEM WHEN '1' THEN '착공정설계' WHEN '2' THEN '사용전설계' WHEN '0' THEN '전체' ELSE ' ' END AS ITEM_NAME \n";
    	
    	String fromSQL = " FROM PT_UB_DETAIL_MASTER  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n";
    	
    	
    	if(!KJFUtil.isEmpty(scITEM) && !"0".equals(scITEM)){
    		
    		whereSQL += "AND ITEM = '"+scITEM+"'";
    		
    	}
    	
    	if(!KJFUtil.isEmpty(scLARCLAS)){
    		whereSQL += "AND LARCLAS LIKE '%"+scLARCLAS+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scMIDCLAS)){
    		whereSQL += "AND MIDCLAS LIKE '%"+scMIDCLAS+"%'";
    	}
    	
    	if(!KJFUtil.isEmpty(scSMACLAS)){
    		whereSQL += "AND SMACLAS LIKE '%"+scSMACLAS+"%'";
    	}
    	
    	String orderSQL = " ORDER BY ORDER_SEQ ASC ";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        request.setAttribute("dl", dl);  

        return next;
    }


}