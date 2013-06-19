/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.sys_m.cmd;

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

public class UserMgrCCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public UserMgrCCmd() {
    }

    public UserMgrCCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String workMODE = vl.getValueAsString("workMODE");
        String OFFI_ID = vl.getValueAsString("scOFFI_ID");
        String scNM = vl.getValueAsString("scNM");
        String scSIDO = vl.getValueAsString("scSIDO");
        
        
        if("IDCHECK".equals(workMODE)){
        	Id_Check(OFFI_ID);
        }else if("SEARCH".equals(workMODE)){
        	Search(OFFI_ID,scNM,scSIDO);
        }
        
    	 
        request.setAttribute("dl", dl);  

        return next;
    }
    
    
    private void Id_Check(String OFFI_ID)throws Exception{
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        ReportEntity bEntity     = null;
        ReportEntity hEntity     = null;
        
        String SQL = " SELECT COUNT(OFFI_ID) AS CNT FROM PT_MI_USER WHERE OFFI_ID = '"+OFFI_ID+"'";    	
        rEntity = rDAO.select(SQL);
        
        String type = "Y";
        
        if(rEntity != null){
        	if(rEntity.getRowCnt() > 0){
        		if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){
        			type = "N";
        		}else{
        			SQL = " SELECT COUNT(OFFI_ID) AS CNT FROM PT_MI_USER_BASIC WHERE OFFI_ID = '"+OFFI_ID+"'";    	
        			bEntity = rDAO.select(SQL);
        			if(bEntity != null){
        	        	if(bEntity.getRowCnt() > 0){
		        	        if(KJFUtil.str2int(bEntity.getValue(0,"CNT")) > 0){
		            			type = "N";
		            		}else{
		            			SQL = " SELECT COUNT(USER_ID) AS CNT FROM PT_HOM_USER WHERE USER_ID = '"+OFFI_ID+"'";    	
		            			hEntity = rDAO.select(SQL);
		            			if(hEntity != null){
		            	        	if(hEntity.getRowCnt() > 0){
		    		        	        if(KJFUtil.str2int(hEntity.getValue(0,"CNT")) > 0){
		    		            			type = "N";
		    		        	        }
		            	        	}
		            			}
		            		}
        	        	}
        			}
        		}
        	} 
        }
        
        Dataset ds = new Dataset("output");
		
		ds.addColumn("CHKYN",ColumnInfo.CY_COLINFO_STRING, 20);
		
		int row = ds.appendRow();
		ds.setColumn(row, "CHKYN", type);

		/********* 생성된 Dataset을 DatasetList에 추가 ************/
		dl.addDataset(ds);
    	
    }
    
    private void Search(String OFFI_ID, String scNM, String scSIDO)throws Exception{
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        StringBuilder sQuery = new StringBuilder();
        StringBuilder sWhere = new StringBuilder();
        
        sQuery.append(" SELECT '0' AS CHECKER, A.OFFI_ID, A.NM, A.TEL ,A.SIDO_CODE, A.SIGUNGU_CODE, A.E_MAIL, A.MOBILE, ");
        sQuery.append(" A.PART, A.POS, A.GROUP_CODE, A.PASS AS PASS, A.PASS AS PASS2, A.HOME_GROUP, ");
        sQuery.append(" B.SIDO_NM AS SIDO_NM, C.SIGUNGU_NM AS SIGUNGU_NM, A.PHOTO ");
        sQuery.append(" FROM PT_MI_USER A LEFT JOIN PT_SIDO_CODE B ON A.SIDO_CODE = B.AREA_CODE ");
        sQuery.append(" LEFT JOIN PT_SIDO_CODE C ON A.SIGUNGU_CODE = C.AREA_CODE ");
        sWhere.append(" WHERE 1 = 1 ");
        if(!KJFUtil.isEmpty(scSIDO))
        	sWhere.append(" AND A.SIDO_CODE = '" + scSIDO + "' ");
        if(!KJFUtil.isEmpty(scNM))
        	sWhere.append(" AND A.NM LIKE '%" + scNM + "%' ");
        sWhere.append(" ORDER BY A.NM ASC ");
                
        rEntity = rDAO.select(sQuery.toString() + sWhere.toString());
        
        //  데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"output");
        
    }

}