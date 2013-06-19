/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.ub.cmd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;
import kjf.util.LunarCalendar;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBInvestResultStMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBInvestResultStMgrCmd() {
    }

    public UBInvestResultStMgrCmd(String next_url) {
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
    	
    	String scCIV_RECV_NUM = vl.getValueAsString("scCIV_RECV_NUM");
        String scAPPLPER_NM = vl.getValueAsString("scAPPLPER_NM");
        String scUSEBEFINSP_DELINUM = vl.getValueAsString("scUSEBEFINSP_DELINUM");
        String scOK = vl.getValueAsString("scOK");
        String scNO = vl.getValueAsString("scNO");
        String scNO_2 = vl.getValueAsString("scNO_2");
        String scNO_3 = vl.getValueAsString("scNO_3");
        String scRECV_ST = vl.getValueAsString("scRECV_ST");
        String scRECV_ET = vl.getValueAsString("scRECV_ET");
        String scOPE_NAME = vl.getValueAsString("scOPE_NAME");
        String scINSP_FEE = vl.getValueAsString("scINSP_FEE");
                
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        
        
    	String selectSQL=    		
    		"	SELECT '0' as CHECKER, RECV_NUM, RECV_DT, APPLPER_NM, APPLPER_TELNUM, OPE_REP, OPE_NAME,  \n" +
    		//"   	   OPE_TELNUM, CC.CODE_NAME AS USE, AREA, NUM_FL, WORK_ITEM, DELI_DT,USEBEFINSP_DELINUM,     \n" +
    		"   	   OPE_TELNUM, decode(USE_ETC,'',CC.CODE_NAME,USE_ETC,CC.CODE_NAME||','||USE_ETC) AS USE, AREA, NUM_FL,DELI_DT,USEBEFINSP_DELINUM,     \n" +
    		"   	   DECODE(WORK_ITEM_ETC,NULL,WORK_ITEM,WORK_ITEM||' '||WORK_ITEM_ETC) AS WORK_ITEM, \n" +
    		"		   CASE NAPPL_YN WHEN '1' THEN '적합' WHEN '2' THEN '부적합' WHEN '3' THEN '취하' WHEN '4' THEN '이첩' ELSE ' ' END AS NAPPL_YN,	\n" +
    		"		   INSP_SPOT_ADDR||' '||RTRIM(INSP_SPOT_DETAILADDR) AS ADDR     \n" ;
    	selectSQL = selectSQL+", WORK_ITEM_ETC, INSP_FEE, to_date(deli_dt, 'yyyymmdd')-to_date(recv_dt, 'yyyymmdd')+1 as SCNT";    //서춘교 수수료 부분 추가 2012/04/24, 처리기간수정 2012/05/08
    	String fromSQL = " FROM PT_UB_USEBEFORE  UB LEFT JOIN PT_COM_CODE CC ON CC.CODE = UB.USE AND CC.P_CODE = 'BLDDIV'  \n";
    	
    	String whereSQL = "WHERE 1 = 1 \n";
    	
    	whereSQL += "AND NAPPL_YN is not null   \n" +
    				"AND SIDO_CODE = '"+SIDO_CODE+"'   \n"+
    				"AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n";   
    	
    	if(!KJFUtil.isEmpty(scCIV_RECV_NUM)){    		
    		whereSQL += "AND CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'  \n";    		
    	}
    	
    	if(!KJFUtil.isEmpty(scAPPLPER_NM)){    		
    		whereSQL += "AND APPLPER_NM LIKE '"+scAPPLPER_NM+"%'  \n";    		
    	}
    	
    	if(!KJFUtil.isEmpty(scUSEBEFINSP_DELINUM)){
    		whereSQL += "AND USEBEFINSP_DELINUM LIKE '"+scUSEBEFINSP_DELINUM+"%'  \n";
    	}

    	
    	if("1".equals(scOK) && "0".equals(scNO) && "0".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND NAPPL_YN = '1'  \n";
    	} else if("0".equals(scOK) && "1".equals(scNO) && "0".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND NAPPL_YN = '2'  \n";
    	} else if("0".equals(scOK) && "0".equals(scNO) && "1".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND NAPPL_YN = '3'  \n";
    	} else if("0".equals(scOK) && "0".equals(scNO) && "0".equals(scNO_2) && "1".equals(scNO_3)){whereSQL += "AND NAPPL_YN = '4'  \n";
    	} else if("1".equals(scOK) && "1".equals(scNO) && "0".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='1' OR NAPPL_YN='2' ) \n";
		} else if("0".equals(scOK) && "1".equals(scNO) && "1".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='2' OR NAPPL_YN='3' ) \n";
		} else if("0".equals(scOK) && "0".equals(scNO) && "1".equals(scNO_2) && "1".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='3' OR NAPPL_YN='4' ) \n";
		} else if("1".equals(scOK) && "0".equals(scNO) && "0".equals(scNO_2) && "1".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='1' OR NAPPL_YN='4' ) \n";    	
		} else if("0".equals(scOK) && "1".equals(scNO) && "0".equals(scNO_2) && "1".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='2' OR NAPPL_YN='4' ) \n";
		} else if("1".equals(scOK) && "0".equals(scNO) && "1".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='1' OR NAPPL_YN='3' ) \n";    	
		} else if("1".equals(scOK) && "1".equals(scNO) && "1".equals(scNO_2) && "0".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='1' OR NAPPL_YN='2' OR NAPPL_YN='3') \n";
		} else if("0".equals(scOK) && "1".equals(scNO) && "1".equals(scNO_2) && "1".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='2' OR NAPPL_YN='3' OR NAPPL_YN='4') \n";    	
		} else if("1".equals(scOK) && "1".equals(scNO) && "0".equals(scNO_2) && "1".equals(scNO_3)){whereSQL += "AND ( NAPPL_YN ='1' OR NAPPL_YN='2' OR NAPPL_YN='4') \n";}
		 	

    	
    	if(!KJFUtil.isEmpty(scRECV_ST) && !KJFUtil.isEmpty(scRECV_ET)){
    		whereSQL += "AND RECV_DT BETWEEN '"+scRECV_ST+"' AND '"+scRECV_ET+"'  \n";
    	}
    	
    	if(!KJFUtil.isEmpty(scOPE_NAME)){
    		whereSQL += "AND OPE_NAME LIKE '%"+scOPE_NAME+"%'  \n";
    	}
    	
    	String orderSQL = " ORDER BY RECV_DT, CIV_RECV_NUM ASC  ";
    		   
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);   

        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
                
        selectSQL = " SELECT SIDO_CODE, SIGUNGU_CODE, COUNT(*) AS CNT ";
        fromSQL = " FROM PT_S_SYSVAR_MASTER";
        whereSQL  =" WHERE 1 = 1 ";
        whereSQL += " AND SIDO_CODE = '" + SIDO_CODE + "'";
        whereSQL += " AND SIGUNGU_CODE = '" + SIGUNGU_CODE + "'";
        whereSQL += " group by sido_code, sigungu_code";
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);
        KJFMi.ReEnt2Ds(dl,rEntity,"output2");
        
        request.setAttribute("dl", dl);  
        
        return next;
    }


}