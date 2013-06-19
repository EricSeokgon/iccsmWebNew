/**
 * 파일명   : LoginCmd.java 
 * 설명     : 로그인 프로세스  
 * 이력사항
 * CH00     :2006/04/19 김경덕 최초작성 
 */

package sp.left.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysWorker;
import sp.uent.MenuEnt;
import sp.uent.UserEnt;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

/****************************************************************************
 * <p>Title       : LoginCmd Class</p>
 * <p>Description : 로그인 처리를 하는 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 *
 * NOTE : 로그인 처리를 한다.
 *
 * @version
 * @author YYS
 ***************************************************************************/
public class LeftCmd implements KJFCommand {
	
	private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
	
	private String next;
	private static Vector menuEntList; //사용자 메뉴
	private static Vector v_menuEntList;
	
    public LeftCmd() {
    }
    
    public LeftCmd(String next_url) {
    	next = next_url; 
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
       	loginprocess(request,"admin");
    	
        return next;
    }
    
    public void loginprocess(HttpServletRequest request, String isWhere) throws  Exception{
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
    	
    	Dataset ds = new Dataset("gds_menulist");
    	
    	
    	ds.addColumn("frmid",ColumnInfo.CY_COLINFO_STRING, 250);
    	ds.addColumn("frmtxt",ColumnInfo.CY_COLINFO_STRING, 250);
    	ds.addColumn("frmurl",ColumnInfo.CY_COLINFO_STRING, 250);
    	ds.addColumn("lvl",ColumnInfo.CY_COLINFO_STRING, 250);
    	ds.addColumn("image",ColumnInfo.CY_COLINFO_STRING, 250);
    	ds.addColumn("type",ColumnInfo.CY_COLINFO_STRING, 250);
    	
        String scUSER_ID = vl.getValueAsString("scUSER_ID");
        String scCAPITAL = vl.getValueAsString("scCAPITAL");
        String scLIFT 	 = vl.getValueAsString("scLIFT");
    	
    	
        StringBuilder selectSQL = new StringBuilder();

        selectSQL.append("SELECT TO_NUMBER(P_PG_GROUP_ID) AS PG_ID, GROUP_NAME AS PG_NAME, '' AS PG_URL FROM  PT_PG_GROUP WHERE PG_GROUP_ID =  ?  		\n");	
      	selectSQL.append("UNION ALL          		\n");	
      	selectSQL.append("SELECT PG_ID, PG_NAME, PG_URL FROM (  			\n");
      	selectSQL.append("		SELECT PG_ID, PG_NAME, PG_URL FROM   PT_PG PP    \n");
      	selectSQL.append("WHERE PG_GROUP_ID  =?  \n");
      	selectSQL.append("  AND USE_YN='Y' 		 \n");
    	if(!"S".equals(scCAPITAL)){
    		selectSQL.append("  AND (  			 \n");
    		selectSQL.append("       PG_ID IN (SELECT DISTINCT(PG_ID) PG_ID FROM PT_AUTH_PG WHERE  AUTH_GROUP_CODE=?)   \n");
    		selectSQL.append("	     OR	  \n");
    		selectSQL.append("	     PG_ID IN (SELECT DISTINCT(PG_ID) PG_ID FROM PT_AUTH_USER WHERE  USER_ID=?) 	\n" );
    		selectSQL.append("      )     \n");
    	}
    	selectSQL.append("ORDER BY ORDER_SEQ ASC  \n");
    	selectSQL.append(")");

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        int cnt=1;
        rDAO.setValue(cnt++, scLIFT);
        if(!"S".equals(scCAPITAL)){
	        rDAO.setValue(cnt++, scLIFT);
	        rDAO.setValue(cnt++, scCAPITAL);
	        rDAO.setValue(cnt++, scUSER_ID);
        }

        
        rEntity = rDAO.select(selectSQL.toString());
        
       
        for(int i=0; i< rEntity.getRowCnt();i++){
        	
        	String type = "";
        	
        	int row = ds.appendRow();
	        ds.setColumn(row, "frmid", rEntity.getValue(i,"PG_ID"));
	        ds.setColumn(row, "frmtxt", rEntity.getValue(i,"PG_NAME"));
	        ds.setColumn(row, "frmurl",rEntity.getValue(i,"PG_URL"));
	        ds.setColumn(row, "lvl","1");
	        ds.setColumn(row, "image","left_menu_bg_0"+(i+1));
	        ds.setColumn(row, "type",type);

        }

		/********* 생성된 Dataset을 DatasetList에 추가 ************/
		dl.addDataset(ds);        
        
        request.setAttribute("dl", dl);  
        
    }
    	
}