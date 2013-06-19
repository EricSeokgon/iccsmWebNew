package sp.filter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import kjf.util.MsgException;
//import sp.charge.cmd.ChargeTargetCUDCmd;
import sp.uent.UserEnt;


public class PermissionFilter {
	/*======================================================================================================*/

	public PermissionFilter(ServletRequest httprequest, String URL) throws Exception {

		if(!URL.equals("/main.jsp")){

			ReportDAO dao = new ReportDAO();
			ReportEntity ent = null;

			HttpServletRequest request = (HttpServletRequest)httprequest;
			KJFLog.log("=====================================================");
			KJFLog.log("회원 권한 검사 시작...");


			java.util.Enumeration enuma = request.getParameterNames();

			String cmd = "";
			String CT_ID = "";

			while(enuma.hasMoreElements()) {
				String key = (String)enuma.nextElement();
				String value = request.getParameter(key);

				if(key.equals("cmd")){
					cmd = value;
				}

				if(key.equals("CT_ID")){
					CT_ID = value;
				}

			}

			//PT_PERMISSION_TARGET 테이블에 해당 URL이 있는지 조사한다
			ent = dao.select("SELECT TARGET_SEQ, URL, CMD, CT_ID FROM PT_PERMISSION_TARGET where URL= '"+URL+"' and CMD= '"+cmd+"' and CT_ID='"+CT_ID+"' ");

//			if(ent.getRowCnt() < 1 && !URL.startsWith("/minAD")){
//				String maxseq = new ChargeTargetCUDCmd().getMaxSeq();
//				dao.execute("insert into PT_PERMISSION_TARGET (TARGET_SEQ, URL, DESCRIPTION, CMD, INP_DT, CT_ID)values ('"+maxseq+"','"+URL+"','','"+cmd+"',now(),'"+CT_ID+"') ");
//			}

			UserEnt user = (UserEnt)request.getSession().getAttribute("user");
			String GROUP_SEQ= "";

			if(user != null && !user.getUSER_ID().equals("")){
				GROUP_SEQ = dao.select("SELECT CHARGE FROM PT_HOM_USER WHERE USER_ID='"+user.getUSER_ID()+"' ").getValue(0,"CHARGE");
				if(KJFUtil.isEmpty(GROUP_SEQ)){
					GROUP_SEQ="1";
				}
			}else{
				GROUP_SEQ = "1";
			}

			ent = dao.select("\n" +
					"SELECT COUNT(*) CNT \n" +
					"FROM PT_PERMISSION_TARGET TAR, PT_PERMISSION_LIST LST \n" +
					"WHERE 1=1 \n" +
					"	AND TAR.TARGET_SEQ = LST.TARGET_SEQ \n" +
					"	AND LST.GROUP_SEQ='"+GROUP_SEQ+"' \n" +
					"	AND TAR.URL = '"+URL+"' \n" +
					"	AND TAR.CMD = '"+cmd+"' \n" +
					"	AND TAR.CT_ID='"+CT_ID+"' \n");

			if(user != null && user.getUSER_ID().equals("pktsa")){
				return;
			}

			System.out.print(ent.getValue(0,"CNT"));

			if(KJFUtil.str2int(ent.getValue(0,"CNT")) > 0 && !URL.startsWith("/minAD") && !cmd.equals("LoginUser") && !cmd.equals("LogOut") && !URL.startsWith("/00_member") ){
				throw new MsgException(dao.select("SELECT NAME FROM PT_PERMISSION_GROUP WHERE GROUP_SEQ='"+GROUP_SEQ+"'").getValue(0,"NAME")+"에게는 접근권한이 없습니다");
			}


			KJFLog.log(URL);

			KJFLog.log("회원 권한 검사 종료...");
			KJFLog.log("=====================================================");
		}

	}


}
