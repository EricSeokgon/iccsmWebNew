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
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class UBInvestMgrCCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UBInvestMgrCCmd() {
    }

    public UBInvestMgrCCmd(String next_url) {
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
    		"	SELECT UU.*, CC.CODE_NAME FROM PT_UB_USEBEFORE UU LEFT JOIN PT_COM_CODE CC ON CC.CODE = UU.USE AND CC.P_CODE = 'BLDDIV'  \n";
    	
    	String whereSQL = "WHERE UU.RECV_NUM = '"+scRECV_NUM+"'   \n" +
    					   " AND UU.SIDO_CODE = '"+SIDO_CODE+"'   \n" +
    					   " AND UU.SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  ";
    	
    	
    	rEntity    = rDAO.select(selectSQL+whereSQL);        
    	
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
        /*
        String SQL=
    		"	 SELECT UDM.SEQ, MIDCLAS||' '|| SMACLAS AS  CLASS_NAME, SRL, BAS,     \n" +
    		"           UDM.CONT ,REPLACE(NVL(UCD.DETAIL_CONT,UDM.DETAIL_CONT),'   ','') AS DETAIL_CONT ,UCD.ITEM_OUT      \n" +    		
    		"      FROM PT_UB_DETAIL_MASTER UDM , PT_UB_DETAIL UCD    \n" ;
		*/
        
        String SQL=
        	"	SELECT UDM.SEQ,MIDCLAS||' '|| SMACLAS AS  CLASS_NAME,"+
			"   	case"+ 
			"       	when instr(MIDCLAS, '-') > 0 Then rtrim(replace(MIDCLAS,'-',''))"+
			"       	else SMACLAS"+
			"   	end CLASS_NAME1,"+
			"		case"+
			"	        when MIDCLAS is null then '' "+
			"	        else SMACLAS"+
			"	    end CLASS_NAME2,"+
    		"		SRL, BAS, UDM.CONT ,REPLACE(NVL(UCD.DETAIL_CONT,UDM.DETAIL_CONT),'   ','') AS DETAIL_CONT ,UCD.ITEM_OUT" +      
    		"	FROM PT_UB_DETAIL_MASTER UDM , PT_UB_DETAIL UCD";
        
        String SQL2=
        	"	SELECT UDM.SEQ,MIDCLAS||' '|| SMACLAS AS  CLASS_NAME,"+
			"   	case "+
			"	        when instr(SMACLAS, '-') > 0 Then rtrim(substr(SMACLAS, 0, instr(SMACLAS,'-')-1))"+
			"	        else SMACLAS"+
			"	    end CLASS_NAME1,"+
			"	    case"+
			"	        when instr(SMACLAS, '-') > 0 Then ltrim(substr(SMACLAS, instr(SMACLAS,'-')+1, length(SMACLAS)))   "+   
			"	        else SMACLAS"+
			"	    end CLASS_NAME2,"+
    		"		SRL, BAS, UDM.CONT ,REPLACE(NVL(UCD.DETAIL_CONT,UDM.DETAIL_CONT),'   ','') AS DETAIL_CONT ,UCD.ITEM_OUT" +      
    		"	FROM PT_UB_DETAIL_MASTER UDM , PT_UB_DETAIL UCD";    
    		
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
    		"	SELECT  '0' AS CHECKER,  AA.* FROM PT_UB_MEMO AA  \n";
        whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND SIDO_CODE = '"+SIDO_CODE+"' \n" +
		   "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output5");
        
        selectSQL=
    		"	SELECT  '0' AS CHECKER, SEQ, RECV_NUM, FILE_NM, FILE_SIZE, INS_DT, SYS_FILE_NAME  FROM PT_UB_FILE   \n";
        whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND SIDO_CODE = '"+SIDO_CODE+"' \n" +
		   "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n" +
           "  ORDER BY INS_DT DESC\n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output6");
        
        selectSQL=
    		"	SELECT SERVER_YN, SERVER_ADDR   \n" +
    		"	  FROM PT_S_SYSVAR_MASTER   \n";
        whereSQL = "  WHERE SIDO_CODE = '"+SIDO_CODE+"' \n" +
		           "    AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output7");
        
        //COI_WRT_NUM -> TMP_WRT_NUM 바꾸기
        selectSQL=
    		"	SELECT TMP_WRT_NUM,COI_WRT_NUM   \n" +
    		"	  FROM PT_R_COMPANY_MASTER   \n";
        whereSQL = "  WHERE COI_WRT_NUM = '"+ dl.getDataset("output").getColumnAsString(0, "COI_WRT_NUM")+"'";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output8");
        
      //SW_BEF_REPO_DELINUM -> RECV_NUM 바꾸기
        selectSQL=
    		"	SELECT RECV_NUM   \n" +
    		"	  FROM PT_UB_CONSTRUCTION   \n";
        whereSQL = "  WHERE SW_BEF_REPO_DELINUM = '"+ dl.getDataset("output").getColumnAsString(0, "SW_BEF_REPO_DELINUM")+"'";
        rEntity    = rDAO.select(selectSQL+whereSQL);        

        KJFMi.ReEnt2Ds(dl,rEntity,"output9");
        
        selectSQL=
    		" SELECT  RECV_NUM, SIDO_CODE, SIGUNGU_CODE ,CIV_RECV_NUM ,	"+		
        	" 		TYPE_PROC_NO_CA,TYPE_PROC_NM_CA,FREQUENCY_SCOPE_CA,WIRE_TYPE_CA, "+
        	" 		TYPE_PROC_NO_MA,TYPE_PROC_NM_MA,FREQUENCY_SCOPE_MA,WIRE_TYPE_MA, "+			
        	" 		TYPE_PROC_NO_SMA ,TYPE_PROC_NM_SMA,FREQUENCY_SCOPE_SMA, WIRE_TYPE_SMA,INS_DT,'U' AS EQU_CMD \n"+
    		" FROM PT_UB_EQUIPMENT   \n";
        whereSQL = "WHERE RECV_NUM = '"+scRECV_NUM+"' \n" +
		   "  AND SIDO_CODE = '"+SIDO_CODE+"' \n" +
		   "  AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"' \n";
        
        rEntity    = rDAO.select(selectSQL+whereSQL); 

        if(rEntity.getRowCnt() > 0 ){        
        	KJFMi.ReEnt2Ds(dl,rEntity,"output10");
        } else {
            Dataset ds = new Dataset("output10");
          
    		ds.addColumn("RECV_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
    		ds.addColumn("SIDO_CODE",ColumnInfo.CY_COLINFO_STRING, 24);
    		ds.addColumn("SIGUNGU_CODE",ColumnInfo.CY_COLINFO_STRING, 24);
    		ds.addColumn("CIV_RECV_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
    		ds.addColumn("TYPE_PROC_NO_CA",ColumnInfo.CY_COLINFO_STRING, 100);
    		ds.addColumn("TYPE_PROC_NM_CA",ColumnInfo.CY_COLINFO_STRING,256);
    		ds.addColumn("FREQUENCY_SCOPE_CA",ColumnInfo.CY_COLINFO_STRING, 100);
    		ds.addColumn("WIRE_TYPE_CA",ColumnInfo.CY_COLINFO_STRING, 256);
    		ds.addColumn("TYPE_PROC_NO_MA",ColumnInfo.CY_COLINFO_STRING, 100);
    		ds.addColumn("TYPE_PROC_NM_MA",ColumnInfo.CY_COLINFO_STRING,256);
    		ds.addColumn("FREQUENCY_SCOPE_MA",ColumnInfo.CY_COLINFO_STRING, 100);
    		ds.addColumn("WIRE_TYPE_MA",ColumnInfo.CY_COLINFO_STRING, 256);
    		ds.addColumn("TYPE_PROC_NO_SMA",ColumnInfo.CY_COLINFO_STRING, 100);
    		ds.addColumn("TYPE_PROC_NM_SMA",ColumnInfo.CY_COLINFO_STRING,256);
    		ds.addColumn("FREQUENCY_SCOPE_SMA",ColumnInfo.CY_COLINFO_STRING, 100);
    		ds.addColumn("WIRE_TYPE_SMA",ColumnInfo.CY_COLINFO_STRING, 256);
    		ds.addColumn("EQU_CMD",ColumnInfo.CY_COLINFO_STRING, 1);
    		
    		
    		int row = ds.appendRow();    		
    		
    		ds.setColumn(row, "RECV_NUM", scRECV_NUM);	
    		ds.setColumn(row, "SIDO_CODE", SIDO_CODE);	
    		ds.setColumn(row, "SIGUNGU_CODE", SIGUNGU_CODE);
    		ds.setColumn(row, "CIV_RECV_NUM", "");	
    		ds.setColumn(row, "TYPE_PROC_NO_CA", "");	
    		ds.setColumn(row, "TYPE_PROC_NM_CA", "");
    		ds.setColumn(row, "FREQUENCY_SCOPE_CA", "");
    		ds.setColumn(row, "WIRE_TYPE_CA", "");
    		ds.setColumn(row, "TYPE_PROC_NO_MA", "");	
    		ds.setColumn(row, "TYPE_PROC_NM_MA", "");
    		ds.setColumn(row, "FREQUENCY_SCOPE_MA", "");
    		ds.setColumn(row, "WIRE_TYPE_MA", "");
    		ds.setColumn(row, "TYPE_PROC_NO_SMA", "");	
    		ds.setColumn(row, "TYPE_PROC_NM_SMA", "");
    		ds.setColumn(row, "FREQUENCY_SCOPE_SMA", "");
    		ds.setColumn(row, "WIRE_TYPE_SMA", "");
    		ds.setColumn(row, "EQU_CMD","I");
    		
    		/********* 생성된 Dataset을 DatasetList에 추가 ************/
    		dl.addDataset(ds);
        }
        
        
        request.setAttribute("dl", dl);  

        return next;
    }
    
    


}