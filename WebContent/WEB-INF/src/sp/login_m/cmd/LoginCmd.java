/**
 * ���ϸ�   : LoginCmd.java 
 * ����     : �α��� ���μ���  
 * �̷»���
 * CH00     :2006/04/19 ���� �����ۼ� 
 */

package sp.login_m.cmd;

import java.util.Vector;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
 * <p>Description : �α��� ó���� �ϴ� Ŭ����</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 *
 * NOTE : �α��� ó���� �Ѵ�.
 *
 * @version
 * @author YYS
 ***************************************************************************/
public class LoginCmd implements KJFCommand {
	
	private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
	
	private String next;
	private static Vector menuEntList; //����� �޴�
	private static Vector v_menuEntList;
	
    public LoginCmd() {
    }
    
    public LoginCmd(String next_url) {
    	next = next_url; 
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
       	loginprocess(request,"admin");
    	
        return next;
    }
    
    public void loginprocess(HttpServletRequest request, String isWhere) throws  Exception{
    	
    	KJFLog.log("�α��� ����");
    	
    	/****** Service API �ʱ�ȭ ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server���� XML���� �� Parsing **/
    	pReq.receiveData(); 	
    	/** ���� ȹ�� **/
    	vl = pReq.getVariableList();
    	
        String scUSER_ID = vl.getValueAsString("scUSER_ID");
        String scUSER_PW = vl.getValueAsString("scUSER_PW");
        
    	String selectSQL =

    	"     \n"+
       	 "SELECT OFFI_ID AS USER_ID,   	\n"+	
       	 "	     NM AS USER_NAME,       \n"+	
       	 "		 E_MAIL AS USER_EMAIL,  \n"+
       	 "		 PASS AS USER_PASSWD,   \n" +
       	 "	     PART ,	 POS ,          \n" +
       	" 		 SIDO_FULL_NM,  \n"+
       	 " 		 SIDO_NM,  \n"+
       	 " 		 SIGUNGU_NM,  \n"+
       	 "	     SIDO_CODE AS SD_CD,    \n"+	
       	 "		 SIGUNGU_CODE AS  SGG_CD, \n"+	
       	 "	     HOME_GROUP AS H_CAPITAL,  \n"+	
       	 "	     GROUP_CODE AS CAPITAL,	  \n"+	
		 "		 MU.TEL,        	  		\n"+ 
		 "       SC.SIGUNGU_NM || ' ' || MU.PART AS PARTPLUS, RECV_DIV \n"+
       	 "FROM PT_MI_USER MU ,PT_SIDO_CODE SC  	\n"+	
       	 //"WHERE MU.SIDO_CODE = SC.AREA_CODE   \n" + 2010-07-02 WBJEON ����
       	"WHERE MU.SIGUNGU_CODE = SC.AREA_CODE   \n" +
       	 "  AND OFFI_ID =?          \n";
    		// 2010.02.04. �н����尡 Ʋ�� ��� �н����尡 Ʋ���ٰ� �ȳ��ϱ� ����.
       	 //"  AND PASS = ?     \n";	

        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        int cnt=1;
        rDAO.setValue(cnt++, scUSER_ID);
        //rDAO.setValue(cnt++, scUSER_PW);
        
        String User_id = "";
        String User_le = "";
        String User_co = "";
        
        
        if((scUSER_ID.equals(Config.props.get("SYS_ID"))&&scUSER_PW.equals(Config.props.get("SYS_PASS")))){
        	User_id = Config.props.get("SYS_ID");
        	User_le = "S";
        	User_co = "S";
        	ReSysAdmin(dl,"ds_login");
        }else{
        	rEntity = rDAO.select(selectSQL);
        	User_id = rEntity.getValue(0,"USER_ID");
        	User_le = rEntity.getValue(0,"CAPITAL");
        	User_co = rEntity.getValue(0,"CAPITAL");
        	KJFMi.ReEnt2Ds(dl,rEntity,"ds_login");
        }
        
        request.setAttribute("dl", dl);  
        
    }
    
    public  static void ReSysAdmin(DatasetList dl, String ds_id){
		
		Dataset ds = new Dataset(ds_id);
		
		ds.addColumn("USER_ID",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("USER_NAME",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("USER_EMAIL",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("USER_PASSWD",ColumnInfo.CY_COLINFO_STRING, 20);
		ds.addColumn("CAPITAL",ColumnInfo.CY_COLINFO_STRING, 20);
		
		int row = ds.appendRow();
		ds.setColumn(row, "USER_ID", Config.props.get("SYS_ID"));
		ds.setColumn(row, "USER_NAME", "�ý��۰�����");
		ds.setColumn(row, "USER_EMAIL", "");
		ds.setColumn(row, "USER_PASSWD", Config.props.get("SYS_PASS"));
		ds.setColumn(row, "CAPITAL", "S");	

		/********* ������ Dataset�� DatasetList�� �߰� ************/
		dl.addDataset(ds);
	 }
    
    	
}