/**
 * ���ϸ�   : BbsControlCmd.java 
 * ����     : ������� cmd  
 * �̷»���
 * CH00     :2006/07/4 ���ν� �����ۼ� 
 */
package sp.mem.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFSelect;
import kjf.util.KJFUtil;
import kjf.util.MsgException;
import sp.mem.MemParam;


public class MemIDCheckCmd implements KJFCommand {


	private String next;
	
    public MemIDCheckCmd() {
    }
    
    public MemIDCheckCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	if(request.getParameter("type")==null||request.getParameter("type").equals("id")){
    		//���̵� �ߺ� �˻�
    		
    		//�˻����� ������ üũ
    		MemParam pm = checkPm(request, form);
    		
    		//����Ʈ �ε�
    		if(isUserID(request, pm)){
    			request.setAttribute("isUserID","Y");
    		}else{
    			request.setAttribute("isUserID","N");
    		}
    		
    		request.setAttribute("pm", pm);
    	}else{
    		//���� �ߺ� �˻�
    		if(existUserNickname(request)){
    			request.setAttribute("isUserID","Y");
    		}else{
    			request.setAttribute("isUserID","N");
    		}
    	}
	    
        return next;
    }
    


    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MemParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	MemParam pm = (MemParam)form;
    	
    	pm.setScSTAFF_CD(request.getParameter("STAFF_CD"));


        //�Ķ���� �����
        KJFLog.debug(pm.toString(request));

       
        return pm;

    }//end checkPm


    
    
    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, MemParam
     * @return
     */
    private boolean isUserID(HttpServletRequest request, MemParam pm)throws Exception{
        
    	 ReportDAO    rDAO        = new ReportDAO();
         ReportEntity rEntity     = null;
         String orderSQL 		 = "";
         boolean isRegistered		 = false; 				

         //SELECT �׸� SQL...
         String selectSQL =
 			"SELECT                     									\n"+ 
         	"			count(*) as CNT      								\n";
  


         String fromSQL=
             "FROM                          									\n"+
             "    PT_HOM_USER							                  	\n";


         String whereSQL = "";

         
         if (KJFUtil.isEmpty(pm.getScUSER_ID()) ) {
             throw new MsgException("�˻��� ���̵� �Է��� �ֽʽÿ�.");
         }
         else{
         	whereSQL +=
         		"  WHERE USER_ID=LOWER('" + pm.getScUSER_ID() + "')" +
         		" OR USER_ID=UPPER('" + pm.getScUSER_ID() + "') \n";
         }
         

         rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL);
         
         if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0){        	 
         	isRegistered = true;
         }

         return isRegistered;
    }//end loadList   
    

    private boolean existUserNickname(HttpServletRequest request)throws Exception{
        
//        ReportDAO    rDAO        = new ReportDAO();
//        ReportEntity rEntity     = null;
//       // String orderSQL 		 = "";
        boolean isRegistered		 = false; 		
//        String nickname =  request.getParameter("USER_NICKNAME");
//        //String nickname = new String(request.getParameter("USER_NICKNAME").getBytes("8859_1"), "EUC-KR");
//
//        //SELECT �׸� SQL...
//        String selectSQL =
//			"SELECT                     									\n"+ 
//        	"			count(*) as CNT      								\n";
// 
//
//
//        String fromSQL=
//            "FROM                          									\n"+
//            "    WEB_IP_USER							                  	\n";
//
//
//        String whereSQL = "";
//
//
//    	whereSQL +=
//    		"  WHERE USER_NICKNAME='"+nickname+"' \n";
//    
//        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);
//        
//        if(KJFUtil.str2int(rEntity.getValue(0,"CNT")) > 0)
//        	isRegistered = true;
//
        return isRegistered;
    }//end loadList   
    
}