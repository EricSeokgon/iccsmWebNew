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
			
			String sdate = KJFUtil.print(KJFDate.dateOnly(KJFDate.getCurTime()).substring(0,4)+"0101");	//sdate ���س⵵ ���� ��¥  format: yyyyMMdd
			String edate =  KJFDate.dateOnly(KJFDate.getCurTime());  //edate ���� ��¥ 
			
			if(!"MainAjaxSearch".equals(cmd)) {
				
				edate = edate.replace("-","");	// format: yyyyMMdd
				
				completionLoad(request,sdate,edate);  	//�������� ���� ó�� �Ϸ� ��Ȳ
				ongoingLoad(request,sdate,edate);  		//�������� ���� ó�� ������ ��Ȳ
				registrationCntLoad(request,sdate,edate);  		//�������� ���� ó�� ������ ��Ȳ
				
			} else {
				sdate = KJFUtil.print(request.getParameter("SDATE"),sdate);
				edate = KJFUtil.print(request.getParameter("EDATE"),edate);
				
				sdate = sdate.replace("-","");	// format: yyyyMMdd
				edate = edate.replace("-","");	// format: yyyyMMdd
				
				completionLoad(request,sdate,edate);  	//�������� ���� ó�� �Ϸ� ��Ȳ
				ongoingLoad(request,sdate,edate);  		//�������� ���� ó�� ������ ��Ȳ
				
				return cmd;
			}
			
			/* ������ , ������ ��ȯ */
			request.setAttribute("sdate", KJFDate.getDateForm(sdate));
			request.setAttribute("edate", KJFDate.getDateForm(edate));
		}
		
		mainUser(request);  //���� �õ��ڵ�
		
		loadList(request);
		loadListEtc(request);
		
		request.setAttribute("p_user_id", KJFUtil.print(request.getParameter("scUSER_ID")));
		request.setAttribute("p_user_pw", KJFUtil.print(request.getParameter("scUSER_PW")));
		
		
		return cmd;
	}
	/*
	 * ���� �õ��ڵ�
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
        
        //SELECT �׸� SQL...
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
	 * ó���Ϸ�
	 */
	private void completionLoad(HttpServletRequest request, String sdate, String edate) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity completionEntity     = null;
        
        String scCAPITAL = KJFUtil.print(request.getParameter("scCAPITAL"));
        
        String area_code=KJFUtil.print(request.getParameter("scSD_CD"));
        
        if(scCAPITAL.equals("C")){
        	area_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        }
        
        //SELECT �׸� SQL...
        String selectSQL =
/*
        	" select *							                                  \n"+
        	"    from					                                			\n"+
        	"        (							                                    \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) R01      \n"+
        	"            from 					                                  	\n"+
        	"               pt_r_basic_change_history 	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --�űԵ��                     	\n"+
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
        	"            and STA_CHG_CLASS_CODE ='R00002' -- ���ؽŰ�			\n"+
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
        	"           and STA_CHG_CLASS_CODE ='R00004' --�絵���					\n"+
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
        	"           and STA_CHG_CLASS_CODE ='R00011' --������ȯ							\n"+
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
        	"           and STA_CHG_CLASS_CODE ='R00005' --����				\n"+
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
        	"            and STA_CHG_CLASS_CODE ='R00006' --�պ�                                          \n"+
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
        	"            and STA_CHG_CLASS_CODE ='R00003' --���            \n"+
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
        	"            and STA_CHG_CLASS_CODE ='R00001'  --�űԵ��                               	\n"+
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
        	"            and STA_CHG_CLASS_CODE ='R00002' -- ���ؽŰ�		            	\n"+
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
        	"           and STA_CHG_CLASS_CODE in('R00004','R00005','R00011') --�絵���		\n"+
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
        	"           and STA_CHG_CLASS_CODE ='R00006' --�պ�						\n"+
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
        	"           and recv_dt between '"+sdate+"' and '"+edate+"'	--�米��		\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
            "            select  count(*) R03 \n"+
            "            from                                                 \n"+
            "                 pt_r_close_statement pc                        \n"+
            "            left join pt_com_code CC                              \n"+
            "            on pc.mot_ste=cc.code --���                                                                     \n"+
            "            where 1=1 and cc.p_code='REGPROC'                     \n"+
            "            and (substr(recv_dt,0,8) between '"+sdate+"' and '"+edate+"')  \n"+
            "            and sido_code='"+area_code+"'                       \n"+  
            "        )                                                        \n"+ 
        	"        ,(                                                        \n"+
        	"            SELECT  nvl(sum(count( PT_M.coi_wrt_num)),0) R12     \n"+
        	"            from                                                 \n"+
        	"            (PT_R_COMPANY_MASTER PT_C INNER JOIN PT_M_MASTER PT_M  ON RTRIM(PT_C.TMP_WRT_NUM) = PT_M.TMP_WRT_NUM)  \n"+
        	"            where  1=1                                           \n"+
        	"            AND PT_M.PUNISHMENT_AGENCY !='TEST�õ�'           \n"+
        	"            and PT_M.DISPO_DT between '"+sdate+"' and '"+edate+"'  --����ó��      \n"+
	     	"            and PT_M.SIDO_CODE='"+area_code+"'                                 \n"+   //������û ����ó�� ��⵵û�� ���� ���ͼ� ����
        	"            and mot_ste='C00002'                                 \n"+
        	"             group by PT_M.sido_code                                  \n"+
        	"        )                                                        \n";		
        completionEntity = rDAO.select(selectSQL);
        
        request.setAttribute("completionEntity", completionEntity);
	}
	
	/*
	 * ������
	 */
	
	private void ongoingLoad(HttpServletRequest request, String sdate, String edate) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity ongoingEntity     = null;
        
        String scCAPITAL = KJFUtil.print(request.getParameter("scCAPITAL"));
        
        String area_code=KJFUtil.print(request.getParameter("scSD_CD"));
        
        if(scCAPITAL.equals("C")){
        	area_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        }
        
        //SELECT �׸� SQL...
        String selectSQL =
       /*
        	"   select *															\n"+
        	"   from																\n"+
        	"       (																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R01		\n"+
        	"           from 														\n"+
        	"              PT_R_REGIST_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"           --and STA_CHG_CLASS_CODE ='R00001'  --�űԵ��				\n"+
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
        	"           and STA_CHG_CLASS_CODE ='R00002' -- ���ؽŰ�					\n"+
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
        	"           --and STA_CHG_CLASS_CODE ='R00004' --�絵���					\n"+
        	"           and assi_ste ='1' --�絵���								\n"+
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
        	"           and assi_ste ='2' --������ȯ								\n"+
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
        	"           --and STA_CHG_CLASS_CODE ='R00005' --����					\n"+
        	"           and assi_ste ='3' -- ����								\n"+
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
        	"          -- and STA_CHG_CLASS_CODE ='R00006' --�պ�					\n"+
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
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --���					\n"+
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
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --����ó��					\n"+
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
        	"           --and STA_CHG_CLASS_CODE ='R00001'  --�űԵ��				\n"+
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
        	"           and STA_CHG_CLASS_CODE ='R00002' -- ���ؽŰ�					\n"+
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
        	"           --and STA_CHG_CLASS_CODE ='R00004' --�絵���					\n"+
        	"           and assi_ste in('1','2','3') --�絵���								\n"+
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
        	"          -- and STA_CHG_CLASS_CODE ='R00006' --�պ�					\n"+
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
        	"           and sido_code='"+area_code+"'	--�米��						\n"+
        	"           and mot_ste='STD002'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n"+
        	"       ,(																\n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) R03		\n"+
        	"           from 														\n"+
        	"              PT_R_CLOSE_STATEMENT 									\n"+
        	"           where  1=1													\n"+
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --���					\n"+
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
        	"          -- and STA_CHG_CLASS_CODE ='R00003' --����ó��					\n"+
        	"           --and recv_dt between '"+sdate+"' and '"+edate+"'			\n"+
        	"           and sido_code='"+area_code+"'										\n"+
        	"           and mot_ste='C00001'										\n"+
        	"           group by sido_code											\n"+
        	"       )    															\n";	

        ongoingEntity = rDAO.select(selectSQL);
        
        request.setAttribute("ongoingEntity", ongoingEntity);
	}
	
	 
	/*
	 * ������Ű���� �����Ȳ
	 */
	private void registrationCntLoad(HttpServletRequest request, String sdate, String edate) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity regCntEntity     = null;
        
        //SELECT �׸� SQL...
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
	 * ������
	 */
	private void ubLoad(HttpServletRequest request) throws Exception {
		
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity CrEntity     = null;
        ReportEntity UrEntity     = null;
        ReportEntity SrEntity     = null;
        
        // �˻� �⵵
        Vector<KJFSelect> v_scYear = getYear(11);
        
        String scYear	= KJFUtil.print(request.getParameter("scYear"));
        
        if(KJFUtil.isEmpty(scYear)){
        	scYear  = KJFDate.getCurTime("yyyy");
        }
        
        String sigungu_code=KJFUtil.print(request.getParameter("scSGG_CD"));
        
        //SELECT �׸� SQL...
        String selectSQL =
        	"    SELECT                                                                                            	\n"+ 
        	"        '�������������' AS GUBUN,                                                   	\n"+ 
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
        	"        '������˻�' AS GUBUN,                                                           	\n"+ 
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
        	"        '���������������' AS GUBUN,                                           	\n"+ 
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
     * �˻� �⵵�� ���Ѵ�
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
            sel.setCode_nm(Integer.toString(i) + " ��");                 
            result.add(sel);            
        }
        
        return result;
    }
    
    
    
    /**
     * �Խ��� List Load
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

         
        /****** �˻����� �ʱⰪ ***********/

        request.setAttribute("ListEntity", rEntity);
    }    
    
    /**
     * �Խ��� List Load
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

         
        /****** �˻����� �ʱⰪ ***********/

        request.setAttribute("ListEtcEntity", rEntity);
    }    
    
    /**
     * �Խ��� List Load
     * 
     * @param request
     * @param pm
     * @throws Exception
     */
    public String loadSubBbsLoad(HttpServletRequest request,  String Tables, String sw) throws Exception {
        String SummarySQL    = "";        

        String header = "";
        
        if ("PT_BBS_NEW_CEN_PUB".equals(Tables)){header = "'���ҽ�' as TITLE_HEADER, ";}
        else if ("PT_BBS_NOTICE_CEN_PUB".equals(Tables)){header = "'��������' as TITLE_HEADER, ";}
        else if ("PT_BBS_FREE_CEN_PUB".equals(Tables)){header = "'�����Խ���' as TITLE_HEADER, ";}
        else if ("PT_BBS_REGIONALISM_PUB".equals(Tables)){header = "'����б�' as TITLE_HEADER, ";}
        else if ("PT_BBS_TONGSIN_ORG_PUB".equals(Tables)){header = "'������Ű����' as TITLE_HEADER, ";}
        else if ("PT_BBS_USE_TONGSIN_PUB".equals(Tables)){header = "'������˻�' as TITLE_HEADER, ";}
        else if ("PT_BBS_DISIGN_TONGSIN_PUB".equals(Tables)){header = "'���������赵Ȯ��' as TITLE_HEADER, ";}
        else if ("PT_BBS_PDA_CEN_PUB".equals(Tables)){header = "'�ڷ��' as TITLE_HEADER, ";}
        else if ("PT_BBS_LAW_RECHANGE_PUB".equals(Tables)){header = "'���ɡ�������' as TITLE_HEADER, ";}
        else if ("PT_BBS_WORKLOAD_CEN_PUB".equals(Tables)){header = "'�������' as TITLE_HEADER, ";}
        else if ("PT_BBS_FAQ_CEN_PUB".equals(Tables)){header = "'����ȸ��' as TITLE_HEADER, ";}
        
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
