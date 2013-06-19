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
import kjf.util.KJFDate;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class SpuCheckKeyMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public SpuCheckKeyMgrCmd() {
    }

    public SpuCheckKeyMgrCmd(String next_url) {
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
        String CIV_RECV_NUM = vl.getValueAsString("CIV_RECV_NUM");
        
        String WRT_ID = vl.getValueAsString("WRT_ID");
        String to_date = KJFDate.datetimeOnly(KJFDate.getCurTime());
    	
    	String type = "Y";
    	String DOC_NUM = "";
		
    	String selectSQL=
    		"	SELECT COUNT(CIV_RECV_NUM) AS CNT   \n";    	
    	String fromSQL = " FROM PT_UB_SUVSPOT  \n";    	
    	String whereSQL = "WHERE CIV_RECV_NUM = '"+CIV_RECV_NUM+"'   \n" +
    					  "  AND  SIDO_CODE = '"+SIDO_CODE+"'    \n"+
    					  "  AND  SIGUNGU_CODE = '"+SIGUNGU_CODE+"'    \n";
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);   
    	
    	
        if(rEntity != null){
        	if(rEntity.getRowCnt() > 0){
        		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
        			type = "N";
        		}else{
    	
					if(!KJFUtil.isEmpty(SIDO_CODE) && !KJFUtil.isEmpty(SIGUNGU_CODE)){
						DOC_NUM = DOC_NUM(SIDO_CODE,SIGUNGU_CODE);
						DOC_NUM = SIDO_CODE+DOC_NUM;
					}
					
					if(!KJFUtil.isEmpty(DOC_NUM)){
						String insert = "INSERT INTO PT_UB_SUVSPOT" +
								" (CIV_RECV_NUM,RECV_NUM,SIDO_CODE,SIGUNGU_CODE,WRT_ID,INS_DT) VALUES ('"+CIV_RECV_NUM+"','"+DOC_NUM+"','"+SIDO_CODE+"','"+SIGUNGU_CODE+"','"+WRT_ID+"','"+to_date+"')";
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
        sWhere.append(" WHERE DOC_CLASS = 'SuvSpotMgrCUD'  ");
        sWhere.append("   AND SD_CODE = '"+SD_CODE+"'  ");
         
         if(!KJFUtil.isEmpty(SGG_CODE)){
        	 sWhere.append("   AND SGG_CODE = '"+SGG_CODE+"'  ");
         }
         
         rEntity    = rDAO.select(sSelect.toString() + sFrom.toString() + sWhere.toString());    
         
         if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
        	 DOC_NUM = rEntity.getValue(0,"DOC_NUM");
        	 sDAO.execute("update PT_R_DOC_NUM set DOC_NUM2 = '"+DOC_NUM+"' "+sWhere.toString());
         }else{
        	 DOC_NUM = "100";
        	 String insert = " insert into PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) values " +
        	 				 "('SuvSpotMgrCUD','"+SD_CODE+"','"+SGG_CODE+"','"+SD_CODE+"','100')";
        	 sDAO.execute(insert);
         }
         
         return DOC_NUM;
    }


}