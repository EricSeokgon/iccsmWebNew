/**
 * 파일명   : GroupWareMgrCmd.java
 * 설명     : 전자결재 연동 cmd
 * 이력사항
 * CH00     : 2009/09/01 오두식 최초작성
 */

package sp.ub.cmd;

import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;
import sp.webservice.UBAgentPortTypeProxy;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATAMessageBodyList;
//import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.xsd.ResponseTypeDATAMessageBodyList;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import kjf.cfg.Config;


public class SeAllDataMgrCmd implements KJFCommand {
	
    private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    private String FILE_PATH = null;
    //private String FILE_PATH = Config.props.get("EBMS_FILE_DIR");
    
    public SeAllDataMgrCmd() {
    }

    public SeAllDataMgrCmd(String next_url) {
    	next = next_url;
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	UbParam pm = (UbParam)form;
    	
        /****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    
        String scRECV_NUM 		= vl.getValueAsString("admNum");
        String scSIDO_CODE 		= vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE 	= vl.getValueAsString("scSIGUNGU_CODE");
        
        String sendSysID		= vl.getValueAsString("sendSysID");
        String sendUserID		= vl.getValueAsString("sendUserID");
        String sendUserEmail	= vl.getValueAsString("sendUserEmail");
        String sendOrgName		= vl.getValueAsString("sendOrgName");
        String recvSysID		= vl.getValueAsString("recvSysID");
        String recvUserID		= vl.getValueAsString("recvUserID");
        String serverAddr		= vl.getValueAsString("scServerAddr");
        KJFLog.log("server addr : " + serverAddr);
        String scServerAddr		= KJFUtil.print(serverAddr);	//시군구 서버 정보
     
        
        /*
        String scRECV_NUM 		= "";
        String scSIDO_CODE 		= "bsbs";
        String scSIGUNGU_CODE 	= "bsgs";
        
        String sendSysID		= "test1234";
        String sendUserID		= "test1234";
        String sendUserEmail	= "";
        String sendOrgName		= "";
        String recvSysID		= "";
        String recvUserID		= "";
        String serverAddr		= "http://99.13.8.25";
        KJFLog.log("server addr : " + serverAddr);
        String scServerAddr		= KJFUtil.print(serverAddr);	//시군구 서버 정보
        */

        
        
        /*  전자결재 문서  작업 */
        TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
    	TimeZone.setDefault(tz);
    	
        String ubID = ""+new Date().getTime();	//본 작업 수행시 고유번호 생성
        
        String curDate			= KJFDate.getCurDatetime();
    	String curDateNoFormate = KJFDate.getChangDatePattern(curDate,"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
    	
    	
    	pm.setSendSysID(sendSysID);
    	pm.setSendSysName("정보통신사용전검사연계시스템");
    	pm.setSendUserID(sendUserID);
    	pm.setSendUserEmail(sendUserEmail);
    	pm.setSendOrgName(sendOrgName);
    	pm.setSendDate(curDate);
    	pm.setSendDateNoFomate(curDateNoFormate);
    	pm.setRecvSysID(recvSysID);
    	pm.setRecvUserID(recvUserID);
    	pm.setScServerAddr(scServerAddr);
    	pm.setAdmNum(scRECV_NUM);
    	
    	pm.setScSIDO_CODE(scSIDO_CODE);
    	pm.setScSIGUNGU_CODE(scSIGUNGU_CODE);
    	pm.setUbID(ubID);

    	boolean result = seallCall(pm);
        /*  전자결재 문서 호출 작업 끝 */
    	
//        request.setAttribute("TO_DATE", ubID);  
//        request.setAttribute("SIGUNGU_CODE", scSIGUNGU_CODE);
//        request.setAttribute("SERVER_ADDR", SERVER_ADDR);        
//        request.setAttribute("dl", dl);  

        return next;
    }
    
    
    /**
     * 전자문서 연동 메인 함수(이것만 호출하면 됨
     * @param pm
     * @throws Exception
     */
    public boolean seallCall(UbParam pm ) throws Exception { 
    	    	
    	boolean flag = false;
    	
		String key= KJFSec.encode(pm.getScSIGUNGU_CODE());
		
		String END_POINT = pm.getScServerAddr() + "/iccsWs/services/UBAgent";
		
		KJFLog.log("connet to : " + END_POINT);
    	UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(END_POINT);
    	
		//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://localhost/iccsWs/services/UBAgent");
		
		int addDate = -14;
//		System.out.println(key);
//		System.out.println(ub.checkKey(key));
		// null 데이터 처리 2010-03-22 wbjeon
		if ( ub.getSeAllData(key, addDate) != null ){
			ResponseTypeDATAMessageBodyList[] resMSGLists = ub.getSeAllData(key, addDate);
			//받은 새올 데이터를 디비에 저장 
			if(seallDataSave(resMSGLists, pm)) flag = true;
			
		} else if(ub.getSeAllData(key, addDate) == null && ub.checkKey(key)){
			System.out.println("getSeAllData null");
			flag = true;
		}
		
		return flag;    	

    }
    
    /**
     * 새올 데이터를 저장한다.(PT_UB_USEBEFORE)
     * @param resMSGLists
     * @return
     * @throws Exception
     */
    public boolean seallDataSave(ResponseTypeDATAMessageBodyList[] resMSGLists ,UbParam pm) throws Exception { 
    	boolean flag = false;
    	
    	ReportDAO    rDAO        = new ReportDAO();
    	ReportDAO    sDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        
        /*
         * 수정 : kdh
         * 시군구 코드가 4자리 이상일경우 해당 코드 자리 +1 로 자리수를 구하기 위해서... max_num 값 세팅
         * */
        
        String max_num = "5";
    	if(4 < pm.getScSIGUNGU_CODE().length()) {
    		max_num = Integer.toString(pm.getScSIGUNGU_CODE().length()+2);
    	}
        
	    	if(resMSGLists.length > 0){
				flag = true;
				KJFLog.log("-----Se all data recieving OK-------- cnt:" + resMSGLists.length );
				for (ResponseTypeDATAMessageBodyList resMSGList : resMSGLists) {
					
					//처리일에서 14일 후 구하기
					String recv_dt = resMSGList.getTake_ymd();
					//String proc_dt = KJFDate.getDateInitAdd(recv_dt, 14,"yyyyMMdd");
					String proc_dt = KJFDate.getDateInitAdd(recv_dt, 15,"yyyyMMdd");
					
					
					System.out.println("------------------------------");
					System.out.println("민원접수번호    :" + resMSGList.getMw_take_no());
					System.out.println("접수일자         :" + resMSGList.getTake_ymd());
					System.out.println("접수시간        :" + resMSGList.getTake_tm());
					System.out.println("접수자성명      :" + resMSGList.getUser_name());
					System.out.println("민원서류수령사용자ID:" + resMSGList.getMw_pps_getr_id());
					System.out.println("민원서류수령사용자명:" + resMSGList.getOutvars());
					System.out.println("민원사무약명    :" + resMSGList.getMw_afr_shtnm());
					System.out.println("민원구분        :" + resMSGList.getMw_se());
					System.out.println("민원신청인명    :" + resMSGList.getMw_aplct_nm());
					System.out.println("민원신청인주소  :" + resMSGList.getMw_aplct_addr());
					System.out.println("민원구분명      :" + resMSGList.getMw_code_cn());
					System.out.println("수납수수료      :" + resMSGList.getRecpt_fee());
					System.out.println("접수확인코드    :" + resMSGList.getTake_confrm_code());
					System.out.println("처리구분        :" + resMSGList.getDeal_se());
					System.out.println("처리구분명      :" + resMSGList.getDeal_code_cn());
					System.out.println("접수구분        :" + resMSGList.getTake_se());
					System.out.println("접수구분코드명  :" + resMSGList.getTake_code_cn());
					System.out.println("실제처리일자    :" + resMSGList.getReal_deal_ymd());
					System.out.println("처리예정일      :" + resMSGList.getDeal_plan_ymd());
					System.out.println("처리기한일      :" + proc_dt);
					System.out.println("민원사무분류번호:" + resMSGList.getCgg_mw_afr_cl_no());
					System.out.println("민원목록총갯수  :" + resMSGList.getCnt());
				
					if(resMSGList.getRecpt_fee().equals("0")){
						
						String sql =" MERGE INTO PT_UB_USEBEFORE A \n" +
						" USING ( SELECT LPAD(NVL(MAX(SUBSTR(RECV_NUM,"+max_num+",10)),0)+1,"+max_num+",0) AS MAXVAL \n" +
						"		  FROM PT_UB_USEBEFORE \n" +
						"		  WHERE SIDO_CODE=? AND SIGUNGU_CODE=? AND RECV_DT LIKE TO_CHAR(SYSDATE,'YYYY')||'%' ) B \n" +
						" ON ( A.SIDO_CODE=? AND A.SIGUNGU_CODE=? AND A.MW_TAKE_NO=? ) \n";
				
				int cnt=1;
				
				//USDING 
				rDAO.setValue(cnt++, pm.getScSIDO_CODE());
				rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
				
				//ON WHERE절
				rDAO.setValue(cnt++, pm.getScSIDO_CODE());
				rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
				rDAO.setValue(cnt++, resMSGList.getMw_take_no());
				
				
				//WHEN MATCHED THEN UPDATE SET 부분
				sql +=" WHEN MATCHED THEN \n" +
				"    UPDATE SET \n" +
				"       RECV_DT=?, TAKE_TM=?, USER_NAME=?, MW_PPS_GETR_ID=?, OUTVARS=?, \n" +
				"  		MW_AFR_SHTNM=?, MW_SE=?, APPLPER_NM=?, APPLPER_ADDR=?, MW_CODE_CN=?, \n" +
				"  		TAKE_CONFRM_CODE=?, DEAL_SE=?, DEAL_CODE_CN=?, TAKE_SE=?, \n" +
				//"  		INSP_FEE=?, TAKE_CONFRM_CODE=?, DEAL_SE=?, DEAL_CODE_CN=?, TAKE_SE=?, \n" +
				"  		TAKE_CODE_CN=?, REAL_DEAL_YMD=? \n" +
				"  	  WHERE A.SIDO_CODE=? AND A.SIGUNGU_CODE=? AND A.MW_TAKE_NO=? \n";
				
				rDAO.setValue(cnt++, resMSGList.getTake_ymd());
                rDAO.setValue(cnt++, resMSGList.getTake_tm());
                rDAO.setValue(cnt++, resMSGList.getUser_name());
                rDAO.setValue(cnt++, resMSGList.getMw_pps_getr_id());                
                rDAO.setValue(cnt++, resMSGList.getOutvars());
                
                rDAO.setValue(cnt++, resMSGList.getMw_afr_shtnm());
                rDAO.setValue(cnt++, resMSGList.getMw_se());
                rDAO.setValue(cnt++, resMSGList.getMw_aplct_nm());
                rDAO.setValue(cnt++, resMSGList.getMw_aplct_addr());                
                rDAO.setValue(cnt++, resMSGList.getMw_code_cn());
                
                //rDAO.setValue(cnt++, resMSGList.getRecpt_fee());
                rDAO.setValue(cnt++, resMSGList.getTake_confrm_code());
                rDAO.setValue(cnt++, resMSGList.getDeal_se());
                rDAO.setValue(cnt++, resMSGList.getDeal_code_cn());                
                rDAO.setValue(cnt++, resMSGList.getTake_se());
                
                rDAO.setValue(cnt++, resMSGList.getTake_code_cn());
                rDAO.setValue(cnt++, resMSGList.getReal_deal_ymd());
                
                rDAO.setValue(cnt++, pm.getScSIDO_CODE());
				rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
				rDAO.setValue(cnt++, resMSGList.getMw_take_no());
				
				
				
                //WHEN NOT MATCHED THEN INSER 구문
                sql +="	WHEN NOT MATCHED THEN \n" +
				"	  INSERT (" +
				"			MW_TAKE_NO, RECV_DT, TAKE_TM, USER_NAME, MW_PPS_GETR_ID, \n " +
				"	        OUTVARS, MW_AFR_SHTNM, MW_SE, APPLPER_NM, APPLPER_ADDR, \n " +
				"			MW_CODE_CN, TAKE_CONFRM_CODE, DEAL_SE, DEAL_CODE_CN, \n " +
				//"			MW_CODE_CN, INSP_FEE, TAKE_CONFRM_CODE, DEAL_SE, DEAL_CODE_CN, \n " +
				"			TAKE_SE, TAKE_CODE_CN, REAL_DEAL_YMD, SIDO_CODE, SIGUNGU_CODE, \n " +
				"			RECV_NUM, PROC_STE, CIV_RECV_NUM, WRT_ID, PROC_LIM" +
				"			 ) \n " +
				//"	  VALUES( ?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  " +
				"	  VALUES( ?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?  ,?,?,?,?,?  " +
				"			,?,?,?,?,?) \n";                
				
                
				rDAO.setValue(cnt++, resMSGList.getMw_take_no());
                rDAO.setValue(cnt++, resMSGList.getTake_ymd());
                rDAO.setValue(cnt++, resMSGList.getTake_tm());
                rDAO.setValue(cnt++, resMSGList.getUser_name());
                rDAO.setValue(cnt++, resMSGList.getMw_pps_getr_id());
                
                rDAO.setValue(cnt++, resMSGList.getOutvars());
                rDAO.setValue(cnt++, resMSGList.getMw_afr_shtnm());
                rDAO.setValue(cnt++, resMSGList.getMw_se());
                rDAO.setValue(cnt++, resMSGList.getMw_aplct_nm());
                rDAO.setValue(cnt++, resMSGList.getMw_aplct_addr());
                
                rDAO.setValue(cnt++, resMSGList.getMw_code_cn());
                //rDAO.setValue(cnt++, resMSGList.getRecpt_fee());
                rDAO.setValue(cnt++, resMSGList.getTake_confrm_code());
                rDAO.setValue(cnt++, resMSGList.getDeal_se());
                rDAO.setValue(cnt++, resMSGList.getDeal_code_cn());
                
                rDAO.setValue(cnt++, resMSGList.getTake_se());
                rDAO.setValue(cnt++, resMSGList.getTake_code_cn());
                rDAO.setValue(cnt++, resMSGList.getReal_deal_ymd());                
                rDAO.setValue(cnt++, pm.getScSIDO_CODE());
				rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
				
				
				//rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
				//rDAO.setValue(cnt++, KJFUtil.rplc(resMSGList.getMw_take_no(),"33600000","") );
				
				rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE() + resMSGList.getMw_take_no() );
                rDAO.setValue(cnt++, 1);
                rDAO.setValue(cnt++, resMSGList.getMw_take_no());                
                rDAO.setValue(cnt++, pm.getSendUserID());
                rDAO.setValue(cnt++, proc_dt);
                
                rDAO.execute(sql);
					}else{
						
					String sql =" MERGE INTO PT_UB_USEBEFORE A \n" +
							" USING ( SELECT LPAD(NVL(MAX(SUBSTR(RECV_NUM,"+max_num+",10)),0)+1,"+max_num+",0) AS MAXVAL \n" +
							"		  FROM PT_UB_USEBEFORE \n" +
							"		  WHERE SIDO_CODE=? AND SIGUNGU_CODE=? AND RECV_DT LIKE TO_CHAR(SYSDATE,'YYYY')||'%' ) B \n" +
							" ON ( A.SIDO_CODE=? AND A.SIGUNGU_CODE=? AND A.MW_TAKE_NO=? ) \n";
					
					int cnt=1;
					
					//USDING 
					rDAO.setValue(cnt++, pm.getScSIDO_CODE());
					rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
					
					//ON WHERE절
					rDAO.setValue(cnt++, pm.getScSIDO_CODE());
					rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
					rDAO.setValue(cnt++, resMSGList.getMw_take_no());
					
					
					//WHEN MATCHED THEN UPDATE SET 부분
					sql +=" WHEN MATCHED THEN \n" +
					"    UPDATE SET \n" +
					"       RECV_DT=?, TAKE_TM=?, USER_NAME=?, MW_PPS_GETR_ID=?, OUTVARS=?, \n" +
					"  		MW_AFR_SHTNM=?, MW_SE=?, APPLPER_NM=?, APPLPER_ADDR=?, MW_CODE_CN=?, \n" +
					//"  		INSP_FEE=?, TAKE_CONFRM_CODE=?, DEAL_SE=?, DEAL_CODE_CN=?, TAKE_SE=?, \n" +
					"  		TAKE_CONFRM_CODE=?, DEAL_SE=?, DEAL_CODE_CN=?, TAKE_SE=?, \n" +
					"  		TAKE_CODE_CN=?, REAL_DEAL_YMD=? \n" +
					"  	  WHERE A.SIDO_CODE=? AND A.SIGUNGU_CODE=? AND A.MW_TAKE_NO=? \n";
					
					rDAO.setValue(cnt++, resMSGList.getTake_ymd());
	                rDAO.setValue(cnt++, resMSGList.getTake_tm());
	                rDAO.setValue(cnt++, resMSGList.getUser_name());
	                rDAO.setValue(cnt++, resMSGList.getMw_pps_getr_id());                
	                rDAO.setValue(cnt++, resMSGList.getOutvars());
	                
	                rDAO.setValue(cnt++, resMSGList.getMw_afr_shtnm());
	                rDAO.setValue(cnt++, resMSGList.getMw_se());
	                rDAO.setValue(cnt++, resMSGList.getMw_aplct_nm());
	                rDAO.setValue(cnt++, resMSGList.getMw_aplct_addr());                
	                rDAO.setValue(cnt++, resMSGList.getMw_code_cn());
	                
	                //rDAO.setValue(cnt++, resMSGList.getRecpt_fee());
	                rDAO.setValue(cnt++, resMSGList.getTake_confrm_code());
	                rDAO.setValue(cnt++, resMSGList.getDeal_se());
	                rDAO.setValue(cnt++, resMSGList.getDeal_code_cn());                
	                rDAO.setValue(cnt++, resMSGList.getTake_se());
	                
	                rDAO.setValue(cnt++, resMSGList.getTake_code_cn());
	                rDAO.setValue(cnt++, resMSGList.getReal_deal_ymd());
	                
	                rDAO.setValue(cnt++, pm.getScSIDO_CODE());
					rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
					rDAO.setValue(cnt++, resMSGList.getMw_take_no());
					
					
					
	                //WHEN NOT MATCHED THEN INSER 구문
	                sql +="	WHEN NOT MATCHED THEN \n" +
					"	  INSERT (" +
					"			MW_TAKE_NO, RECV_DT, TAKE_TM, USER_NAME, MW_PPS_GETR_ID, \n " +
					"	        OUTVARS, MW_AFR_SHTNM, MW_SE, APPLPER_NM, APPLPER_ADDR, \n " +
					//"			MW_CODE_CN, INSP_FEE, TAKE_CONFRM_CODE, DEAL_SE, DEAL_CODE_CN, \n " +
					"			MW_CODE_CN, TAKE_CONFRM_CODE, DEAL_SE, DEAL_CODE_CN, \n " +
					"			TAKE_SE, TAKE_CODE_CN, REAL_DEAL_YMD, SIDO_CODE, SIGUNGU_CODE, \n " +
					"			RECV_NUM, PROC_STE, CIV_RECV_NUM, WRT_ID, PROC_LIM" +
					"			 ) \n " +
					//"	  VALUES( ?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  " +
					"	  VALUES( ?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?  ,?,?,?,?,?  " +
					"			,?,?,?,?,?) \n";                
					
	                
					rDAO.setValue(cnt++, resMSGList.getMw_take_no());
	                rDAO.setValue(cnt++, resMSGList.getTake_ymd());
	                rDAO.setValue(cnt++, resMSGList.getTake_tm());
	                rDAO.setValue(cnt++, resMSGList.getUser_name());
	                rDAO.setValue(cnt++, resMSGList.getMw_pps_getr_id());
	                
	                rDAO.setValue(cnt++, resMSGList.getOutvars());
	                rDAO.setValue(cnt++, resMSGList.getMw_afr_shtnm());
	                rDAO.setValue(cnt++, resMSGList.getMw_se());
	                rDAO.setValue(cnt++, resMSGList.getMw_aplct_nm());
	                rDAO.setValue(cnt++, resMSGList.getMw_aplct_addr());
	                
	                rDAO.setValue(cnt++, resMSGList.getMw_code_cn());
	                //rDAO.setValue(cnt++, resMSGList.getRecpt_fee());
	                rDAO.setValue(cnt++, resMSGList.getTake_confrm_code());
	                rDAO.setValue(cnt++, resMSGList.getDeal_se());
	                rDAO.setValue(cnt++, resMSGList.getDeal_code_cn());
	                
	                rDAO.setValue(cnt++, resMSGList.getTake_se());
	                rDAO.setValue(cnt++, resMSGList.getTake_code_cn());
	                rDAO.setValue(cnt++, resMSGList.getReal_deal_ymd());                
	                rDAO.setValue(cnt++, pm.getScSIDO_CODE());
					rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
					
					
					//rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE());
					//rDAO.setValue(cnt++, KJFUtil.rplc(resMSGList.getMw_take_no(),"33600000","") );
					
					rDAO.setValue(cnt++, pm.getScSIGUNGU_CODE() + resMSGList.getMw_take_no() );
	                rDAO.setValue(cnt++, 1);
	                rDAO.setValue(cnt++, resMSGList.getMw_take_no());                
	                rDAO.setValue(cnt++, pm.getSendUserID());
	                rDAO.setValue(cnt++, proc_dt);
	                
	                rDAO.execute(sql);
					}
					
				}
				
				flag = true;
			}
	    	
    	return flag;
    }
    
    
}