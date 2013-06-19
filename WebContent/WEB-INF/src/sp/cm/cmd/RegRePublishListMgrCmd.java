package sp.cm.cmd;



import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegRePublishListMgrCmd implements KJFCommand {
	
	private String next;
	private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public RegRePublishListMgrCmd() {
    }

    public  RegRePublishListMgrCmd(String next_url) {
    	next = next_url;
    }
    
    
	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		 
	 /*
	  * 처리완료
	  */

		PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData();
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
    
        
    	String scDATE1 = vl.getValueAsString( "scDATE1" );
		String scDATE2 = vl.getValueAsString( "scDATE2" );
      
        //SELECT 항목 SQL...
        String selectSQL =
        
        	" select *							                                  \n"+
        	"    from					                                			\n"+
        	"        (							                                    \n"+
        	"            select  count( distinct(recv_num)) RS01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT                  			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='susu'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select  count( distinct(recv_num)) RB01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='bsbs'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select  count( distinct(recv_num)) RU01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='usus'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select count( distinct(recv_num)) RGN01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='gngn'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select  count( distinct(recv_num)) RI01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='icic'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select  count( distinct(recv_num)) RG01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='gggg'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select  count( distinct(recv_num)) RD01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='dgdg'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"            select  count( distinct(recv_num)) RGB01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='gbgb'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+"            " +
        	"           select  count( distinct(recv_num)) RGJ01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='gjgj'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+"            " +
        	"          select  count( distinct(recv_num)) RJN01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT     	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='jnjn'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+"            " +
        	"          select  count( distinct(recv_num)) RDJ01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='djdj'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"          select  count( distinct(recv_num)) RCN01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='cncn'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"            group by sido_code					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"          select  count( distinct(recv_num)) RJB01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='jbjb'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"          select  count( distinct(recv_num)) RGW01      \n"+
        	"            from 					                                  	\n"+
        	"              PT_R_REGIST_STATEMENT     	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='gwgw'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"          select  count( distinct(recv_num)) RCB01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='cbcb'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
        	" ,(							\n"+
        	"          select  count( distinct(recv_num)) RJJ01      \n"+
        	"            from 					                                  	\n"+
        	"               PT_R_REGIST_STATEMENT    	              			\n"+
        	"            where  1=1					                          	\n"+
        	"            and STA_CHG_CLASS_CODE ='R00001'  --신규등록                     	\n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'		\n"+
        	"            and sido_code='jjjj'                                 \n"+
        	"            and mot_ste='STD003'					\n"+
        	"        ) 							\n"+
            "   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RS11 \n"+
    	    "           from 												  \n"+
	    	"               PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='susu'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+ 
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RB11 \n"+
    	    "           from 												  \n"+
	    	"              PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='bsbs'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  "   " +
	    	",(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RU11 \n"+
    	    "           from 												  \n"+
	    	"                PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='usus'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  "  " +
	       " ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGN11 \n"+
    	    "           from 												  \n"+
	    	"               PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='gngn'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  "   " +
	    	" ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RI11 \n"+
    	    "           from 												  \n"+
	    	"               PT_R_ASSI_TRANS_STATEMENT  						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='icic'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RG11 \n"+
    	    "           from 												  \n"+
	    	"               PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='gggg'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
	    	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RD11 \n"+
    	    "           from 												  \n"+
	    	"               PT_R_ASSI_TRANS_STATEMENT  						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='dgdg'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGB11 \n"+
    	    "           from 												  \n"+
	    	"               PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='gbgb'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGJ11 \n"+
    	    "           from 												  \n"+
	    	"                PT_R_ASSI_TRANS_STATEMENT  						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='gjgj'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+ 
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJN11 \n"+
    	    "           from 												  \n"+
	    	"                PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='jnjn'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RDJ11 \n"+
    	    "           from 												  \n"+
	    	"              PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='djdj'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RCN11 \n"+
    	    "           from 												  \n"+
	    	"              PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='cncn'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJB11 \n"+
    	    "           from 												  \n"+
	    	"              PT_R_ASSI_TRANS_STATEMENT    						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='jbjb'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGW11 \n"+
    	    "           from 												  \n"+
	    	"              PT_R_ASSI_TRANS_STATEMENT  					  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='gwgw'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RCB11 \n"+
    	    "           from 												  \n"+
	    	"              PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='cbcb'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+  
	    	"   ,(                                                       \n"+
    	    "           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJJ11 \n"+
    	    "           from 												  \n"+
	    	"                PT_R_ASSI_TRANS_STATEMENT   						  \n"+
	    	"           where  1=1													\n"+
	    	"           and assi_ste ='2' --법인전환							\n"+
	    	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
	    	"           and sido_code='jjjj'										\n"+	
	    	"           and mot_ste='STD003'										\n"+
	    	"           group by sido_code											\n"+
	    	"        )                                                        \n"+
	    	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RS04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='susu'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RB04		\n"+
        	"           from 														\n"+
        	"                PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='bsbs'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RU04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='usus'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGN04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1'--양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='gngn'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RI04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='icic'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RG04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='gggg'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RD04		\n"+
        	"           from 														\n"+
        	"             PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='dgdg'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGB04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='gbgb'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGJ04		\n"+
        	"           from 														\n"+
        	"                PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='gjgj'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJN04		\n"+
        	"           from 														\n"+
        	"                PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='jnjn'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RDJ04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='djdj'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RCN04		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='cncn'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJB04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1'--양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='jbjb'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGW04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='gwgw'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RCB04		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='cbcb'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJJ04		\n"+
        	"           from 														\n"+
        	"                PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='1' --양도양수					\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'				\n"+
        	"           and sido_code='jjjj'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RS06 \n"+
        	"            from                                                 \n"+
        	"                PT_R_M_UNION_STATEMENT                            \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='susu'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RB06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                             \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='bsbs'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RU06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                           \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='usus'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGN06 \n"+
        	"            from                                                 \n"+
        	"              PT_R_M_UNION_STATEMENT                        \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='gngn'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RI06 \n"+
        	"            from                                                 \n"+
        	"                PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='icic'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RG06 \n"+
        	"            from                                                 \n"+
        	"              PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='gggg'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RD06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='dgdg'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGB06 \n"+
        	"            from                                                 \n"+
        	"                PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='gbgb'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGJ06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='gjgj'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RJN06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='jnjn'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RDJ06 \n"+
        	"            from                                                 \n"+
        	"              PT_R_M_UNION_STATEMENT                        \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='djdj'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RCN06 \n"+
        	"            from                                                 \n"+
        	"              PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='cncn'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RJB06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                           \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='jbjb'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGW06 \n"+
        	"            from                                                 \n"+
        	"              PT_R_M_UNION_STATEMENT                           \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='gwgw'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RCB06 \n"+
        	"            from                                                 \n"+
        	"               PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='cbcb'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RJJ06 \n"+
        	"            from                                                 \n"+
        	"              PT_R_M_UNION_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'         \n"+
        	"            and sido_code='jjjj'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"            group by sido_code                                   \n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RS05		\n"+
        	"           from 														\n"+
        	"             PT_R_ASSI_TRANS_STATEMENT  									\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='susu'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RB05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3'  --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='bsbs'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RU05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT   								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3'  --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='usus'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGN05		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT   								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='gngn'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RI05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='icic'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RG05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT  						\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='gggg'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RD05		\n"+
        	"           from 														\n"+
        	"               PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='dgdg'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGB05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT   								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='gbgb'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGJ05		\n"+
        	"           from 														\n"+
        	"             PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='gjgj'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJN05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT   								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='jnjn'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RDJ05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='djdj'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RCN05		\n"+
        	"           from 														\n"+
        	"             PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='cncn'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJB05		\n"+
        	"           from 														\n"+
        	"             PT_R_ASSI_TRANS_STATEMENT   								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='jbjb'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RGW05		\n"+
        	"           from 														\n"+
        	"             PT_R_ASSI_TRANS_STATEMENT  								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='gwgw'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RCB05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT  							\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='cbcb'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"           select  nvl(sum(count( distinct(coi_wrt_num))),0) RJJ05		\n"+
        	"           from 														\n"+
        	"              PT_R_ASSI_TRANS_STATEMENT   								\n"+
        	"           where  1=1													\n"+
        	"           and assi_ste ='3' --분할				\n"+
        	"           and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'			\n"+
        	"           and sido_code='jjjj'										\n"+
        	"           and mot_ste='STD003'										\n"+
        	"           group by sido_code											\n"+
        	"        )                                                        \n"+
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RS03\n"+
        	"            from                                                 \n"+
        	"                 PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='susu'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RB03\n"+
        	"            from                                                 \n"+
        	"              PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='bsbs'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RU03\n"+
        	"            from                                                 \n"+
        	"                   PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='usus'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGN03\n"+
        	"            from                                                 \n"+
        	"                  PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='gngn'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RI03\n"+
        	"            from                                                 \n"+
        	"                  PT_R_CLOSE_STATEMENT                          \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='icic'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RG03\n"+
        	"            from                                                 \n"+
        	"                 PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='gggg'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RD03\n"+
        	"            from                                                 \n"+
        	"                PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='dgdg'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGB03\n"+
        	"            from                                                 \n"+
        	"                   PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='gbgb'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGJ03\n"+
        	"            from                                                 \n"+
        	"                  PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='gjgj'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RJN03\n"+
        	"            from                                                 \n"+
        	"                   PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='jnjn'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RDJ03\n"+
        	"            from                                                 \n"+
        	"                   PT_R_CLOSE_STATEMENT                        \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='djdj'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RCN03\n"+
        	"            from                                                 \n"+
        	"                  PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='cncn'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RJB03\n"+
        	"            from                                                 \n"+
        	"                  PT_R_CLOSE_STATEMENT                        \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='jbjb'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RGW03\n"+
        	"            from                                                 \n"+
        	"                   PT_R_CLOSE_STATEMENT                         \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='gwgw'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RCB03\n"+
        	"            from                                                 \n"+
        	"                  PT_R_CLOSE_STATEMENT                        \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='cbcb'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n"+		
        	"        ,(                                                       \n"+
        	"            select  nvl(sum(count( distinct(coi_wrt_num))),0) RJJ03\n"+
        	"            from                                                 \n"+
        	"                 PT_R_CLOSE_STATEMENT                            \n"+
        	"            where  1=1                                           \n"+
        	"            and recv_dt between '"+scDATE1+"' and '"+scDATE2+"'        \n"+
	     	"            and sido_code='jjjj'                                 \n"+
        	"            and mot_ste='STD003'                                 \n"+
        	"             group by sido_code                                  \n"+
        	"        )                                                \n";	

        	
        	next = "dtsList";
        	rEntity    = rDAO.select(selectSQL);    	
	 	    KJFMi.ReEnt2Ds(dl,rEntity,"output");
            request.setAttribute("dl", dl);
            return next;
	}
}
        	
	
	
	
    /**
     * 검색 년도를 구한다
     * 
     * @param yearTerm
     * @return
     * @throws Exception
     */
    /*private Vector<KJFSelect> getYear(int yearTerm)  throws Exception {
        
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
    }*/
	

