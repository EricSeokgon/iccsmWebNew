package sp.index.cmd;

import java.util.Calendar;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFSelect;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.bbs.BbsParam;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class MainIndexCmd implements KJFCommand {
	
	private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
	public String execute(HttpServletRequest request, ActionForm form)
	throws Exception {
		 
		String cmd = KJFUtil.print(request.getParameter("cmd"));
		
		String scCAPITAL = KJFUtil.print(request.getParameter("scCAPITAL"));
		
		if("C".equals(scCAPITAL) || "E".equals(scCAPITAL) || "F".equals(scCAPITAL) ){
			cmd="/index/mainUb.jsp";
			ubLoad(request);
			
		} else{
			
			String sdate = KJFUtil.print(KJFDate.dateOnly(KJFDate.getCurTime()).substring(0,4)+"0101");	//sdate 당해년도 시작 날짜  format: yyyyMMdd
			String edate =  KJFDate.dateOnly(KJFDate.getCurTime());  //edate 오늘 날짜 
			
			if(!"MainAjaxSearch".equals(cmd)) {
				
				edate = edate.replace("-","");	// format: yyyyMMdd
				
				completionLoad(request,sdate,edate);  	//공사업등록 업무 처리 완료 현황
				ongoingLoad(request,sdate,edate);  		//공사업등록 업무 처리 진행중 현황
				registrationCntLoad(request,sdate,edate);  		//공사업등록 업무 처리 진행중 현황
				
			} else {
				sdate = KJFUtil.print(request.getParameter("SDATE"),sdate);
				edate = KJFUtil.print(request.getParameter("EDATE"),edate);
				
				sdate = sdate.replace("-","");	// format: yyyyMMdd
				edate = edate.replace("-","");	// format: yyyyMMdd
				
				completionLoad(request,sdate,edate);  	//공사업등록 업무 처리 완료 현황
				ongoingLoad(request,sdate,edate);  		//공사업등록 업무 처리 진행중 현황
				
				return cmd;
			}
			
			/* 시작일 , 종료일 반환 */
			request.setAttribute("sdate", KJFDate.getDateForm(sdate));
			request.setAttribute("edate", KJFDate.getDateForm(edate));
		}
		
		mainUser(request);  //유저 시도코드
		
		loadList(request);
		loadListEtc(request);
		
		request.setAttribute("p_user_id", KJFUtil.print(request.getParameter("scUSER_ID")));
		request.setAttribute("p_user_pw", KJFUtil.print(request.getParameter("scUSER_PW")));
		
		
		return cmd;
	}
	/*
	 * 유저 시도코드
	 */
	private void mainUser(HttpServletRequest request) throws Exception {

        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity sidoEntity     = null;
        
        String scCAPITAL = KJFUtil.print(request.getParameter("scCAPITAL"));
        
        String area_code=KJFUtil.print(request.getParameter("scSD_CD"));
        
        if(scCAPITAL.equals("C")){
        	area_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        }
        
        String cmd = request.getParameter("cmd");
        
        
        
        //tmp_wrt_num
        
        //SELECT 항목 SQL...
        String selectSQL =
			" SELECT      \n"+ 
			" 	SIDO_NM , SIGUNGU_NM   \n";	
        String fromSQL=
        	" 	FROM   \n"+
        	" 	PT_SIDO_CODE PT_C   \n";
		     	
        String whereSQL = 
        	" 	WHERE 1=1 \n"+
        	" 	AND AREA_CODE= '"+area_code+"'   \n";
      
        sidoEntity = rDAO.select(selectSQL + fromSQL + whereSQL);
        
        request.setAttribute("sidoEntity", sidoEntity);
	}
	
	
	/*
	 * 처리완료
	 */
	private void completionLoad(HttpServletRequest request, String sdate, String edate) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity completionEntity     = null;
        
        String scCAPITAL = KJFUtil.print(request.getParameter("scCAPITAL"));
        
        String area_code=KJFUtil.print(request.getParameter("scSD_CD"));
        
        if(scCAPITAL.equals("C")){
        	area_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        }
        
        //SELECT 항목 SQL...
        String selectSQL =
/*
        	" select *							                                  \n"+
        	"    from					                                			\n"+
        	"        (							                                    \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R01      \n"+
        	"            from 					                                  	\n"+
        	"               pt_r_basic_change_history 	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and chg_dt between '"+sdate+"' and '"+edate+"'		\n"+
        	"            and sido_code='"+area_code+"'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"            group by sido_code					\n"+
        	"        ) 							\n"+
        	"        ,(							\n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R02\n"+
        	"            from 						\n"+
        	"              pt_r_basic_change_history				\n"+
        	"            where  1=1						\n"+
        	"            and STA_CHG_CLASS_CODE ='R00002' -- 기준신고			\n"+
        	"            and chg_dt between '"+sdate+"' and '"+edate+"'		\n"+
        	"            and sido_code='"+area_code+"'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"            group by sido_code	                                \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R04		\n"+
        	"           from 														\n"+
        	"               pt_r_basic_change_history								\n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE ='R00004' --양도양수					\n"+
        	"           and chg_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R11 \n"+
        	"           from 												  \n"+
        	"               pt_r_basic_change_history  						  \n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE ='R00011' --법인전환							\n"+
        	"           and chg_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+	
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R05		\n"+
        	"           from 														\n"+
        	"              pt_r_basic_change_history  								\n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE ='R00005' --분할				\n"+
        	"           and chg_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R06 \n"+
        	"            from                                                 \n"+
        	"                pt_r_basic_change_history                         \n"+
        	"            where  1=1                                           \n"+
        	"            and STA_CHG_CLASS_CODE ='R00006' --합병                                          \n"+
        	"            and chg_dt between '"+sdate+"' and '"+edate+"'         \n"+
        	"            and sido_code='"+area_code+"'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R03\n"+
        	"            from                                                 \n"+
        	"                 pt_r_basic_change_history                         \n"+
        	"            where  1=1                                           \n"+
        	"            and STA_CHG_CLASS_CODE ='R00003' --폐업            \n"+
        	"            and chg_dt between '"+sdate+"' and '"+edate+"'        \n"+
	     	"            and sido_code='"+area_code+"'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                        \n";			
*/

        	" select *							                                  \n"+
        	"    from					                                			\n"+
        	"        (							                                    \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R01      \n"+
        	"            from 					                                  	\n"+
        	"               pt_r_basic_change_history 	              		    	\n"+
        	"            where  1=1					                          	    \n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                               	\n"+
        	"            and chg_dt between '"+sdate+"' and '"+edate+"'		        \n"+
        	"            and sido_code='"+area_code+"'                               \n"+
        	"            and mot_ste='STD003'					                       \n"+
        	"            group by sido_code				                            	\n"+
        	"        ) 							                                        \n"+
        	"        ,(							                                         \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R02            \n"+
        	"            from 						                                      \n"+
        	"              pt_r_basic_change_history			                          	\n"+
        	"            where  1=1						                                    \n"+
        	"            and STA_CHG_CLASS_CODE ='R00002' -- 기준신고		            	\n"+
        	"            and chg_dt between '"+sdate+"' and '"+edate+"'		              \n"+
        	"            and sido_code='"+area_code+"'                                 \n"+
        	"            and mot_ste='STD003'					                       \n"+
        	"            group by sido_code	                                       \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R04		\n"+
        	"           from 														\n"+
        	"               pt_r_basic_change_history								\n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE in('R00004','R00005','R00011') --양도양수		\n"+
        	"           and chg_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R06 \n"+
        	"           from 												  \n"+
        	"               pt_r_basic_change_history  						  \n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE ='R00006' --합병						\n"+
        	"           and chg_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+	
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	//"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R13		\n"+
        	"           select  nvl(sum(count( coi_wrt_num)),0) R13		\n"+
        	"           from 														\n"+
        	"              PT_R_RE_DERIVERY_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and recv_dt between '"+sdate+"' and '"+edate+"'	--재교부		\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
            "            select  count(*) R03 \n"+
            "            from                                                 \n"+
            "                 pt_r_close_statement pc                        \n"+
            "            left join pt_com_code CC                              \n"+
            "            on pc.mot_ste=cc.code --폐업                                                                     \n"+
            "            where 1=1 and cc.p_code='REGPROC'                     \n"+
            "            and (substr(recv_dt,0,8) between '"+sdate+"' and '"+edate+"')  \n"+
            "            and sido_code='"+area_code+"'                       \n"+  
            "        )                                                        \n"+ 
        	"        ,(                                                        \n"+
        	"            SELECT  nvl(sum(count( PT_M.coi_wrt_num)),0) R12     \n"+
        	"            from                                                 \n"+
        	"            (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)  \n"+
        	"            where  1=1                                           \n"+
        	"            AND PT_M.PUNISHMENT_AGENCY !='TEST시도'           \n"+
        	"            and PT_M.DISPO_DT between '"+sdate+"' and '"+edate+"'  --행정처분      \n"+
	     	"            and PT_M.SIDO_CODE='"+area_code+"'                                 \n"+   //세종시청 행정처분 경기도청꺼 같이 나와서 수정
        	"            and mot_ste='C00002'                                 \n"+
        	"             group by PT_M.sido_code                                  \n"+
        	"        )                                                        \n";		
        completionEntity = rDAO.select(selectSQL);
        
        request.setAttribute("completionEntity", completionEntity);
	}
	
	/*
	 * 진행중
	 */
	
	private void ongoingLoad(HttpServletRequest request, String sdate, String edate) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity ongoingEntity     = null;
        
        String scCAPITAL = KJFUtil.print(request.getParameter("scCAPITAL"));
        
        String area_code=KJFUtil.print(request.getParameter("scSD_CD"));
        
        if(scCAPITAL.equals("C")){
        	area_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        }
        
        //SELECT 항목 SQL...
        String selectSQL =
       /*
        	"   select *															\n"+
        	"   from																\n"+
        	"       (																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R01		\n"+
        	"           from 														\n"+
        	"              PT_R_REGIST_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"           --and STA_CHG_CLASS_CODE ='R00001'  --신규등록				\n"+
        	"         --  and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       ) 																\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R02		\n"+
        	"           from 														\n"+
        	"              PT_R_BASIC_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE ='R00002' -- 기준신고					\n"+
        	"          -- and recv_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )																\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT 								\n"+
        	"           where  1=1													\n"+
        	"           --and STA_CHG_CLASS_CODE ='R00004' --양도양수					\n"+
        	"           and assi_ste ='1' --양도양수								\n"+
        	"          -- and recv_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )																\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R11		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT 								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='2' --법인전환								\n"+
        	"          -- and recv_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+	
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT 								\n"+
        	"           where  1=1													\n"+
        	"           --and STA_CHG_CLASS_CODE ='R00005' --분할					\n"+
        	"           and assi_ste ='3' -- 분할								\n"+
        	"          -- and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R06		\n"+
        	"           from 														\n"+
        	"              PT_R_M_UNION_STATEMENT									\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00006' --합병					\n"+
        	"           --and chg_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )         														\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R03		\n"+
        	"           from 														\n"+
        	"              PT_R_CLOSE_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --폐업					\n"+
        	"           --and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n"+
        	"           ,(															\n"+
        	"           select  nvl(sum(count( distinct(wrt_num))),0) R012			\n"+
        	"           from 														\n"+
        	"             PT_M_MASTER 												\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --행정처분					\n"+
        	"           --and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='C00001'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n";	
*/

        	"   select *															\n"+
        	"   from																\n"+
        	"       (																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R01		\n"+
        	"           from 														\n"+
        	"              PT_R_REGIST_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"           --and STA_CHG_CLASS_CODE ='R00001'  --신규등록				\n"+
        	"         --  and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       ) 																\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R02		\n"+
        	"           from 														\n"+
        	"              PT_R_BASIC_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"           and STA_CHG_CLASS_CODE ='R00002' -- 기준신고					\n"+
        	"          -- and recv_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )																\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT 								\n"+
        	"           where  1=1													\n"+
        	"           --and STA_CHG_CLASS_CODE ='R00004' --양도양수					\n"+
        	"           and assi_ste in('1','2','3') --양도양수								\n"+
        	"          -- and recv_dt between '"+sdate+"' and '"+edate+"'				\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )																\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R06		\n"+
        	"           from 														\n"+
        	"              PT_R_M_UNION_STATEMENT									\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00006' --합병					\n"+
        	"           --and chg_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )         														\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R13		\n"+
        	"           from 														\n"+
        	"              PT_R_RE_DERIVERY_STATEMENT 								\n"+
        	"           where  1=1													\n"+
        	"           and sido_code='"+area_code+"'	--재교부						\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R03		\n"+
        	"           from 														\n"+
        	"              PT_R_CLOSE_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --폐업					\n"+
        	"           --and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n"+
        	"           ,(															\n"+
        	"           select  nvl(sum(count( distinct(wrt_num))),0) R012			\n"+
        	"           from 														\n"+
        	"             PT_M_MASTER 												\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --행정처분					\n"+
        	"           --and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='C00001'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n";	

        ongoingEntity = rDAO.select(selectSQL);
        
        request.setAttribute("ongoingEntity", ongoingEntity);
	}
	
	 
	/*
	 * 정보통신공사업 등록현황
	 */
	private void registrationCntLoad(HttpServletRequest request, String sdate, String edate) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity regCntEntity     = null;
        
        //SELECT 항목 SQL...
        String selectSQL =
			" 	SELECT      \n"+ 
			" 		COM.SIDO_NM, M.SIDO_CODE AS SIDO_CODE, COUNT(M.SIDO_CODE) AS CNT    \n"+
        	" 	FROM PT_R_COMPANY_MASTER M, PT_SIDO_CODE COM      	\n"+
        	" 		WHERE M.SIDO_CODE IS NOT NULL    \n"+	
	        " 			AND M.SIDO_CODE = COM.AREA_CODE(+)  \n"+	
	        " 			AND M.SIDO_CODE != 'tete'     \n"+
	        " 			AND (M.TRANS_UNION_PROC IS NULL AND M.TRANS_UNION_PARENT IS NULL) AND C_COM_DT IS NULL    \n"+
	        " 		GROUP BY COM.SIDO_NM,SIDO_CODE     \n"+
	        " 	ORDER BY COM.SIDO_NM ASC       \n";

        regCntEntity = rDAO.select(selectSQL);
        
        request.setAttribute("regCntEntity", regCntEntity);
	}
	
	
	/*
	 * 착공전
	 */
	private void ubLoad(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity CrEntity     = null;
        ReportEntity UrEntity     = null;
        ReportEntity SrEntity     = null;
        
        // 검색 년도
        Vector<KJFSelect> v_scYear = getYear(11);
        
        String scYear	= KJFUtil.print(request.getParameter("scYear"));
        
        if(KJFUtil.isEmpty(scYear)){
        	scYear  = KJFDate.getCurTime("yyyy");
        }
        
        String sigungu_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        
        //SELECT 항목 SQL...
        String selectSQL =
        	"    SELECT                                                                                            	\n"+ 
        	"        '착공전설계검토' AS GUBUN,                                                   	\n"+ 
        	"        SUBSTR(RECV_DT,0,4) AS GB_YEAR,                                 	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 3  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 6  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 9  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER,  	\n"+ 
        	"     NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOAL_COUNT         	\n"+
        	"    FROM PT_UB_CONSTRUCTION                                               	\n"+ 
        	"    WHERE RECV_DT is not null                                                      	\n"+ 
        	"    AND SIGUNGU_CODE = '"+sigungu_code+"'                                                  	\n"+ 
        	"    AND SUBSTR(RECV_DT,0,4) = '"+scYear+"' 	\n"+ 
        	"    GROUP BY SUBSTR(RECV_DT,0,4)                                         	\n";
        
        	CrEntity = rDAO.select(selectSQL);
        	request.setAttribute("CrEntity", CrEntity);
        
        	selectSQL =                                                                                            	 
        	"    SELECT                                                                                            	\n"+ 
        	"        '사용전검사' AS GUBUN,                                                           	\n"+ 
        	"        SUBSTR(RECV_DT,0,4) AS GB_YEAR,                                 	\n"+
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 3  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 3 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 6  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 6 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 9  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 9 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER,  	\n"+ 
        	"     NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(RECV_DT,5,2)) > 0 AND TO_NUMBER(SUBSTR(RECV_DT,5,2)) <= 12  AND PROC_STE  = '3' THEN 1 ELSE 0 END),'0') AS  TOAL_COUNT         	\n"+ 
        	"    FROM PT_UB_USEBEFORE                                                       	\n"+ 
        	"    WHERE RECV_DT is not null                                                      	\n"+ 
        	"    AND SIGUNGU_CODE = '"+sigungu_code+"'                                                  	\n"+ 
        	"    AND SUBSTR(RECV_DT,0,4) = '"+scYear+"' 	\n"+
        	"    GROUP BY SUBSTR(RECV_DT,0,4)                                         	\n";
        	
        	UrEntity = rDAO.select(selectSQL);
        	request.setAttribute("UrEntity", UrEntity);   
        	
        	selectSQL =                                                                 
        	"    SELECT                                                                                            	\n"+ 
        	"        '감리결과보고서접수' AS GUBUN,                                           	\n"+ 
        	"        SUBSTR(upd_dt_old,0,4) AS GB_YEAR,                                     	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(upd_dt_old,5,2)) > 0 AND TO_NUMBER(SUBSTR(upd_dt_old,5,2)) <= 3   THEN 1 ELSE 0 END),'0') AS  ONE_QUARTER,                                                    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(upd_dt_old,5,2)) > 3 AND TO_NUMBER(SUBSTR(upd_dt_old,5,2)) <= 6   THEN 1 ELSE 0 END),'0') AS  TOW_QUARTER,                                                    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(upd_dt_old,5,2)) > 6 AND TO_NUMBER(SUBSTR(upd_dt_old,5,2)) <= 9   THEN 1 ELSE 0 END),'0') AS  TUR_QUARTER,                                                    	\n"+ 
        	"        NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(upd_dt_old,5,2)) > 9 AND TO_NUMBER(SUBSTR(upd_dt_old,5,2)) <= 12   THEN 1 ELSE 0 END),'0') AS  FOR_QUARTER,                                                  	\n"+
        	"     NVL(sum(CASE WHEN TO_NUMBER(SUBSTR(upd_dt_old,5,2)) > 0 AND TO_NUMBER(SUBSTR(upd_dt_old,5,2)) <= 12   THEN 1 ELSE 0 END),'0') AS  TOAL_COUNT                                                         	\n"+ 
        	"    FROM PT_UB_SUVSPOT                                                             	\n"+ 
        	"    WHERE INS_DT is not null                                                          	\n"+ 
        	"    AND SIGUNGU_CODE = '"+sigungu_code+"'                                                  	\n"+ 
        	"    AND SUBSTR(upd_dt_old,0,4) = '"+scYear+"'     	\n"+ 
        	"    GROUP BY SUBSTR(upd_dt_old,0,4)                                              	\n";				

        	SrEntity = rDAO.select(selectSQL);
        	request.setAttribute("SrEntity", SrEntity);   
        	request.setAttribute("scYear", scYear); 
        	request.setAttribute("v_scYear", v_scYear);
        
       
	}	
	
	
	
    /**
     * 검색 년도를 구한다
     * 
     * @param yearTerm
     * @return
     * @throws Exception
     */
    private Vector<KJFSelect> getYear(int yearTerm)  throws Exception {
        
        Vector<KJFSelect> result = new Vector<KJFSelect>();
        
        Calendar cal = Calendar.getInstance();
        
        KJFSelect sel = new KJFSelect();                 
        
        for (int i = cal.get(Calendar.YEAR); i > (cal.get(Calendar.YEAR) - yearTerm); i--) {
            
            sel= new KJFSelect();               
            sel.setCode(Integer.toString(i));                  
            sel.setCode_nm(Integer.toString(i) + " 년");                 
            result.add(sel);            
        }
        
        return result;
    }
    
    
    
    /**
     * 게시판 List Load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    private void loadList(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;
        
        String SummarySQL = "SELECT * FROM(SELECT * FROM (";
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_NEW_CEN_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_NOTICE_CEN_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_FREE_CEN_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_REGIONALISM_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_TONGSIN_ORG_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_USE_TONGSIN_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_DISIGN_TONGSIN_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_PDA_CEN_PUB","1");
        SummarySQL = SummarySQL + " ) ORDER BY INS_DT DESC) WHERE ROWNUM <= 6 ";
        rEntity = rDAO.select(SummarySQL);

         
        /****** 검색조건 초기값 ***********/

        request.setAttribute("ListEntity", rEntity);
    }    
    
    /**
     * 게시판 List Load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    private void loadListEtc(HttpServletRequest request) throws Exception {

        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;
        
        String SummarySQL = "SELECT * FROM(SELECT * FROM (";
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_LAW_RECHANGE_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_WORKLOAD_CEN_PUB","0");
        SummarySQL = SummarySQL + loadSubBbsLoad(request,"PT_BBS_FAQ_CEN_PUB","1");
        SummarySQL = SummarySQL + " ) ORDER BY INS_DT DESC) WHERE ROWNUM <= 6 ";
                
        rEntity = rDAO.select(SummarySQL);

         
        /****** 검색조건 초기값 ***********/

        request.setAttribute("ListEtcEntity", rEntity);
    }    
    
    /**
     * 게시판 List Load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    public String loadSubBbsLoad(HttpServletRequest request,  String Tables, String sw) throws Exception {
        String SummarySQL    = "";        

        String header = "";
        
        if ("PT_BBS_NEW_CEN_PUB".equals(Tables)){header = "'새소식' as TITLE_HEADER, ";}
        else if ("PT_BBS_NOTICE_CEN_PUB".equals(Tables)){header = "'공지사항' as TITLE_HEADER, ";}
        else if ("PT_BBS_FREE_CEN_PUB".equals(Tables)){header = "'자유게시판' as TITLE_HEADER, ";}
        else if ("PT_BBS_REGIONALISM_PUB".equals(Tables)){header = "'지방분권' as TITLE_HEADER, ";}
        else if ("PT_BBS_TONGSIN_ORG_PUB".equals(Tables)){header = "'정보통신공사업' as TITLE_HEADER, ";}
        else if ("PT_BBS_USE_TONGSIN_PUB".equals(Tables)){header = "'사용전검사' as TITLE_HEADER, ";}
        else if ("PT_BBS_DISIGN_TONGSIN_PUB".equals(Tables)){header = "'착공전설계도확인' as TITLE_HEADER, ";}
        else if ("PT_BBS_PDA_CEN_PUB".equals(Tables)){header = "'자료실' as TITLE_HEADER, ";}
        else if ("PT_BBS_LAW_RECHANGE_PUB".equals(Tables)){header = "'법령·제개정' as TITLE_HEADER, ";}
        else if ("PT_BBS_WORKLOAD_CEN_PUB".equals(Tables)){header = "'업무편람' as TITLE_HEADER, ";}
        else if ("PT_BBS_FAQ_CEN_PUB".equals(Tables)){header = "'질의회신' as TITLE_HEADER, ";}
        
        // Select Query
        StringBuffer sbSelectSQL = new StringBuffer();        
        sbSelectSQL.append(" SELECT "+header+" CT_ID, BOARD_SEQ, SUBJECT,USER_NAME,INS_DT  ");
       
        // From Query
        StringBuffer sbFromSQL = new StringBuffer();
        sbFromSQL.append("  FROM ( SELECT CT_ID, BOARD_SEQ, SUBJECT,USER_NAME,INS_DT FROM "+Tables+" \n");
        sbFromSQL.append("  ORDER BY INS_DT DESC, BOARD_SEQ DESC) \n");
        
        // Where Query
        StringBuffer sbWhereSQL = new StringBuffer();        
        sbWhereSQL.append(" WHERE ROWNUM <= 6              \n");   
        
//        sbWhereSQL.append(" AND SUBSTR(INS_DT,0,10) BETWEEN TO_CHAR(SYSDATE-3,'YYYY-MM-DD') AND TO_CHAR(SYSDATE,'YYYY-MM-DD') \n");
                    
        String UnionSQL = " UNION ALL \n";
        
        if ("1".equals(sw)){
        	SummarySQL = sbSelectSQL.toString() + sbFromSQL.toString() + sbWhereSQL.toString() ;
        } else {
        	SummarySQL = sbSelectSQL.toString() + sbFromSQL.toString() + sbWhereSQL.toString() + UnionSQL;
        }
        
        return SummarySQL.toString();
       
    }        
	
	
}
