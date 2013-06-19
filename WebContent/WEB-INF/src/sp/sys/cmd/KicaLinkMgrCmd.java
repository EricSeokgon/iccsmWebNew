/**
 * ���ϸ�   : KicaLinkMgrCmd.java 
 * ����     : ����Ʈ cmd  
 * �̷»���
 * CH00     :2006/04/19 ���� �����ۼ� 
 */

package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.util.kica.KicaAgent;
import sp.util.kica.KicaTask;

public class KicaLinkMgrCmd implements KJFCommand {


	private String next;
	
    public KicaLinkMgrCmd() {
    }
    
    public KicaLinkMgrCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	System.out.println("#####kicalinkmgrCmd.java#######");
        //�˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request);

        //�˻����� ������ üũ
        SysParam pm = checkPm(request, form);

        //����Ʈ �ε�
       // loadList(request, pm);

      //  runExe(request);
        
        return next;
    }
    
    /***************************************************************************
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void loadCondition(HttpServletRequest request)throws Exception{

    }  
    
    /***************************************************************************
     * �˻����� �ʱⰪ ������ üũ
     * 
     * @param request
     * @param form
     * @return
     * @throws Exception
     **************************************************************************/
    private SysParam checkPm(HttpServletRequest request, ActionForm form) throws Exception {

    	SysParam pm = (SysParam)form;
        
        // �Ķ���� �����
        KJFLog.debug(pm.toString(request));

        // ����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())) {
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
        

        return pm;
    } 
    
    
    /***************************************************************************
     * ���ǿ� ���� list�� load
     * 
     * @param request
     * @param pm
     * @throws Exception
     **************************************************************************/
    private void loadList(HttpServletRequest request, SysParam pm) throws Exception {

        ReportDAO    rDAO    = new ReportDAO();
        ReportEntity rEntity = null;

        //SELECT �׸� SQL...
        String selectSQL =
        	" SELECT			     	\n" +
        	"		 SEQ,                \n" +
        	"		 U_D_FLAG,           \n" +
        	"		 TABLE_NAME,         \n" +
        	"		 LOG,                \n" +
        	"		 ERR_YN,             \n" +
        	"		 UPD_DT,             \n" +
        	"		 INS_DT              \n" ;

        String fromSQL=
            "   FROM PT_KICA_TRANS_LOG     \n";


        /*******����¡ ���� cnt SQL...********/
        String cntSQL =
            " SELECT COUNT(*)  CNT      \n"+
            fromSQL ;
       /*******����¡ ���� cnt SQL... ��********/

        String whereSQL =
        	"  WHERE 1=1				\n";

        if (!KJFUtil.isEmpty(pm.getScERR_YN())) {
        	whereSQL +=
        	"    AND ERR_YN = '" + pm.getScERR_YN() + "' 	\n";
        }
        
        if (!KJFUtil.isEmpty(pm.getScTABLE_NAME())) {
        	whereSQL +=
        	"    AND TABLE_NAME LIKE '%" + pm.getScTABLE_NAME() + "%' \n";
        }
        

        String orderSQL =
        	" ORDER BY  INS_DT desc  , U_D_FLAG desc                 \n";


        /* *************************** ����¡ ���� *******************************/
        // ��ü ��� ��
        String totalCount="";

        // �������� ��� ��
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        // ���� ������ ��ȣ
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL+whereSQL);
        totalCount=rEntity.getValue(0, "CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* *************************** ����¡ ���� �� *****************************/

        rEntity = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL ,nowPage, rowPerPage);

        // �˻����� �ʱⰪ
        request.setAttribute("pm", pm);
        request.setAttribute("rEntity", rEntity);
    }
    
    
    
    
    
    
    
    
    
    
    public String runExe(HttpServletRequest request) throws Exception {
    	
    	String mode = KJFUtil.print(request.getParameter("mode"));
    	System.out.println("#######################"+mode.toString());
    	String bt="bt_start";
    	System.out.println("#######################"+bt.toString());

//    	
//    	KicaTask  task= new KicaTask(); 
//    	task.getKicaDB();
//    	//task.setKicaDB();
//    	
//        if(KicaAgent.kscheduler==null){
//        	
//
//        	bt ="bt_start";
//        	if(mode.equals("run")) {
//        		System.out.print("==============KicaAgent run===============");
//        		KicaAgent.start();
//        		bt ="bt_stop";
//        	}
//        	
//        }else{
//        	System.out.println("===========KicaAgent not null =========");
//        	bt ="bt_stop";
//        	if(mode.equals("run")) {
//            	
//            	KicaAgent.kscheduler.shutdown();
//            	System.out.println("KicaAgent.isShutdown(): "+KicaAgent.kscheduler.isShutdown());
//            	KicaAgent.kscheduler=null;
//            	bt ="bt_start";
//        	}
//        	
//        	
//        }


        request.setAttribute("bt", bt);       
              
        
        return next;
    }
    
    
    
    
    
    


 
    
    


}