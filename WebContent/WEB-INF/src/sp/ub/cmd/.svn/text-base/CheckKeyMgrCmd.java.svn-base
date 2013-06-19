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

import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;
import kjf.util.KJFDate;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class CheckKeyMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public CheckKeyMgrCmd() {
    }

    public CheckKeyMgrCmd(String next_url) {
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
    	
        String scCIV_RECV_NUM = vl.getValueAsString("scCIV_RECV_NUM");        
        String SIDO_CODE = vl.getValueAsString("SIDO_CODE");
        String SIGUNGU_CODE = vl.getValueAsString("SIGUNGU_CODE");
        String WRT_ID = vl.getValueAsString("WRT_ID");
        String to_date = KJFDate.datetimeOnly(KJFDate.getCurTime());
        // 2010.01.08. 기본수수료를 넣기 위해.. 마이플랫폼에서는 fnModify()로 똑같이 이동해서 체크하기 귀찮다.
        String INSP_FEE = vl.getValueAsString("INSP_FEE");
        String scName = KJFUtil.print(vl.getValueAsString("scName"),"");
        
        String selectSQL=
    		"	SELECT COUNT(CIV_RECV_NUM) AS CNT   \n";
    	
    	String fromSQL = " FROM PT_UB_USEBEFORE  \n";
    	
    	String whereSQL = "WHERE CIV_RECV_NUM = '"+scCIV_RECV_NUM+"'   \n" +
    					  "  AND  SIDO_CODE = '"+SIDO_CODE+"'    \n"+
    					  "  AND  SIGUNGU_CODE = '"+SIGUNGU_CODE+"'    \n";
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);   
    	
    	String type = "Y";
    	String DOC_NUM = "";
    	String RECV_DT = KJFDate.getCurTime("yyyyMMdd");
    	
        if(rEntity != null){
        	if(rEntity.getRowCnt() > 0){
        		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
        			type = "N";
        		}else{
        			if(!KJFUtil.isEmpty(SIDO_CODE) && !KJFUtil.isEmpty(SIGUNGU_CODE)){
        				DOC_NUM = DOC_NUM(SIDO_CODE,SIGUNGU_CODE);
        				//DOC_NUM = "u"+SIGUNGU_CODE+DOC_NUM;
        				DOC_NUM = SIGUNGU_CODE+DOC_NUM;
        			}
        			
        			if(!KJFUtil.isEmpty(DOC_NUM)){
        				String sql = "  SELECT NVL(USEBEF_INSP,'14') AS USEBEF_INSP FROM PT_S_SYSVAR_MASTER WHERE SIDO_CODE = '"+SIDO_CODE+"' AND SIGUNGU_CODE = '"+SIGUNGU_CODE+"'  \n";
        				uEntity = rDAO.select(sql);
        				
        				String insert = "INSERT INTO " +
        				"PT_UB_USEBEFORE " +
        				"(RECV_NUM,SIDO_CODE,SIGUNGU_CODE,CIV_RECV_NUM,RECV_DT,PROC_STE,WRT_ID,INS_DT,PROC_LIM,INSP_APPL_DT, INSP_FEE, PROC_OFFI_ID,PROC_OFFI) " +
        				"VALUES " +
        				"('"+DOC_NUM+"','"+SIDO_CODE+"','"+SIGUNGU_CODE+"','"+scCIV_RECV_NUM+"','"+RECV_DT+"','1','"+WRT_ID+"',TO_CHAR(TO_DATE(SYSDATE),'yyyyMMdd'),TO_CHAR(TO_DATE(SYSDATE+"+KJFUtil.print(uEntity.getValue(0,"USEBEF_INSP"),"14")+"),'yyyyMMdd'),TO_CHAR(TO_DATE(SYSDATE),'yyyyMMdd'), '" + INSP_FEE + "', '" + WRT_ID + "', '" + scName + "')";
        				rDAO.execute(insert);
        			}
        		}
        	}
        }
        
        Dataset ds = new Dataset("output");
		
		ds.addColumn("KEY_YN",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("DOC_NUM",ColumnInfo.CY_COLINFO_STRING, 20);
		
		int row = ds.appendRow();
		ds.setColumn(row, "KEY_YN", type);	
		ds.setColumn(row, "DOC_NUM", DOC_NUM);	
		

		/********* 생성된 Dataset을 DatasetList에 추가 ************/
		dl.addDataset(ds);
                
        request.setAttribute("dl", dl);  

        return next;
    }
    
    
    private String DOC_NUM(String SD_CODE, String SGG_CODE)throws Exception{
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportDAO    sDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        String DOC_NUM = "";
        
        StringBuilder sSelect = new StringBuilder();
        StringBuilder sFrom = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sSelect.append("SELECT COUNT(*) AS CNT , ");
        sSelect.append("       NVL( MAX( to_number(DOC_NUM2) ), 0 ) + 1 AS DOC_NUM   ");
        sFrom.append("  FROM PT_R_DOC_NUM ");
        sWhere.append(" WHERE DOC_CLASS = 'UBReceiptMgrCUD'  ");
        sWhere.append("   AND SD_CODE = '"+SD_CODE+"'  ");
        sWhere.append("   AND SGG_CODE = '"+SGG_CODE+"'  ");
        
         
         rEntity    = rDAO.select(sSelect.toString() + sFrom.toString() + sWhere.toString());    
         
         if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
        	 DOC_NUM = rEntity.getValue(0,"DOC_NUM");
        	 sDAO.execute("update PT_R_DOC_NUM set DOC_NUM2 = '"+DOC_NUM+"' "+sWhere.toString());
         }else{
        	 DOC_NUM = "100";
        	 String insert = " insert into PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) values " +
        	 				 "('UBReceiptMgrCUD','"+SD_CODE+"','"+SGG_CODE+"','"+SGG_CODE+"','100')";
        	 sDAO.execute(insert);
         }
         
         return DOC_NUM;
    }


}