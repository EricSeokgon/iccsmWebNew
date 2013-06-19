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

public class BeforeMgrCCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BeforeMgrCCmd() {
    }

    public BeforeMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        ReportEntity uEntity     = null;
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
    	
    	String scTYPE = vl.getValueAsString("scType");
        String scRECV_NUM = vl.getValueAsString("scRECV_NUM");
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
		String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
		
    	String selectSQL=
    		"	SELECT *   FROM PT_UB_CONSTRUCTION  \n";
    	
    	String whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"'   \n" +
		   				   " AND SIDO_CODE = '"+SIDO_CODE+"'   \n" +
		   				   " AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  ";
    	
    	if(!"gread".equals(scTYPE)){
    		
    	rEntity    = rDAO.select(selectSQL+whereSQL);        
    	
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
    	}
        
    	String SQL=
    	"	SELECT UDM.SEQ,MIDCLAS AS CLASS_NAME,"+
		"   	case"+ 
		"       	when instr(MIDCLAS, '-') > 0 Then rtrim(replace(MIDCLAS,'-',''))"+
		"       	else SMACLAS"+
		"   	end CLASS_NAME1,"+
		"		case"+
		"	        when MIDCLAS is null then '' "+
		"	        else SMACLAS"+
		"	    end CLASS_NAME2,"+
  		"		SRL, BAS, UDM.CONT ,REPLACE(NVL(UCD.DETAIL_CONT,UDM.DETAIL_CONT),'   ','') AS DETAIL_CONT , NVL(UCD.ITEM_OUT, '해당없음') ITEM_OUT " +      
  		"	FROM PT_UB_DETAIL_MASTER UDM , PT_UB_CON_DETAIL UCD";

      String SQL2=
      	"	SELECT UDM.SEQ,MIDCLAS AS CLASS_NAME,"+
		"   	case "+
		"	        when instr(SMACLAS, '-') > 0 Then rtrim(substr(SMACLAS, 0, instr(SMACLAS,'-')-1))"+
		"	        else SMACLAS"+
		"	    end CLASS_NAME1,"+
		"	    case"+
		"	        when instr(SMACLAS, '-') > 0 Then ltrim(substr(SMACLAS, instr(SMACLAS,'-')+1, length(SMACLAS)))   "+   
		"	        else SMACLAS"+
		"	    end CLASS_NAME2,"+
  		"		SRL, BAS, UDM.CONT ,REPLACE(NVL(UCD.DETAIL_CONT,UDM.DETAIL_CONT),'   ','') AS DETAIL_CONT ,NVL(UCD.ITEM_OUT, '해당없음') ITEM_OUT " +      
  		"	FROM PT_UB_DETAIL_MASTER UDM , PT_UB_CON_DETAIL UCD";    
  		
      String WHERE1=
      	"     WHERE UDM.ITEM = '2'	\n " +
      	"		AND SUBSTR(LARCLAS,0,1) = '1' \n" ;
  		
      String WHERE= "";
      if(!KJFUtil.isEmpty(scRECV_NUM)){
      	 WHERE += "AND UCD.RECV_NUM(+) = '"+scRECV_NUM+"'  \n";
      }else{
      	WHERE += "AND UCD.RECV_NUM(+) = '0'	\n";
      }
      
      WHERE += "	  AND UDM.SEQ = UCD.SEQ(+)	\n" +
			 "    ORDER BY TO_NUMBER(ORDER_SEQ) ASC \n";
      
      uEntity    = rDAO.select(SQL+WHERE1+WHERE);   

      KJFMi.ReEnt2Ds(dl,uEntity,"output2");

      WHERE1=
      	"     WHERE UDM.ITEM = '2'	\n " +
      	"		AND SUBSTR(LARCLAS,0,1) = '2' \n" ;
      uEntity    = rDAO.select(SQL2+WHERE1+WHERE);   
      KJFMi.ReEnt2Ds(dl,uEntity,"output3");
      
      WHERE1=
      	"     WHERE UDM.ITEM = '2'	\n " +
      	"		AND SUBSTR(LARCLAS,0,1) = '3' \n" ;
      
      uEntity    = rDAO.select(SQL+WHERE1+WHERE);
      
      KJFMi.ReEnt2Ds(dl,uEntity,"output4");
                
        
        selectSQL=
    		"	SELECT  '0' AS CHECKER,  AA.* FROM PT_UB_CONMEMO AA  \n";
        whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND SIDO_CODE = '"+SIDO_CODE+"' \n" +
		   "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output5");
        
        selectSQL=
    		"	SELECT PDEF.*, PDEF_CODE.CONT AS DEFI_CONT FROM PT_UB_CONDEFICIT PDEF LEFT JOIN  \n" +
    		"          (SELECT DEFI_CODE, CONT FROM PT_R_DEFICIT_CODE WHERE DEFI_GROUP = 'BUBU')   \n" +
    		"	PDEF_CODE  ON PDEF.DEFI_CODE = PDEF_CODE.DEFI_CODE \n";
        whereSQL = "WHERE PDEF.RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND PDEF.SIDO_CODE = '"+SIDO_CODE+"' \n"+
           "  AND PDEF.SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  ";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output6");
        
        selectSQL=
    		"	SELECT * FROM PT_R_DEFICIT_CODE   \n";
        whereSQL = "    WHERE DEFI_GROUP = 'BUBU' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output7");
        
        selectSQL=
    		       "	SELECT CODE,CODE_NAME FROM PT_COM_CODE   \n";
        whereSQL = "     WHERE P_CODE = 'BLDDIV' ORDER BY CODE_NAME ASC  \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        
        
        KJFMi.ReEnt2Ds(dl,rEntity,"output8");
        
        selectSQL=
		       		"	SELECT CODE,CODE_NAME FROM PT_COM_CODE   \n";
		 whereSQL = "    WHERE P_CODE = 'WORK' ORDER BY CODE_NAME ASC  \n";
		 rEntity    = rDAO.select(selectSQL+whereSQL);        
		
		 KJFMi.ReEnt2Ds(dl,rEntity,"output9");
        
        selectSQL=
    		"	SELECT SERVER_YN, SERVER_ADDR   \n" +
    		"	  FROM PT_S_SYSVAR_MASTER   \n";
        whereSQL = "  WHERE SIDO_CODE = '"+SIDO_CODE+"' \n" +
		           "    AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output10");
        
        request.setAttribute("dl", dl);  

        return next;
    }
    
    


}