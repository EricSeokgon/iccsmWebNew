package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import sp.sys.SysParam;
import sp.sys.SysWorker;
import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

public class AuthPgMgrUserLCmd implements KJFCommand {
	
	private String next;
	
    public AuthPgMgrUserLCmd() {
    }
    
    public AuthPgMgrUserLCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        //�˻����� ������ üũ
        SysParam pm = checkPm(request, form);
        
        //����Ʈ �ε�
        loadList(request, pm);
        
        return next;
    }
    
    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private SysParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	SysParam pm = (SysParam)form;

        //�Ķ���� �����
        KJFLog.debug(pm.toString(request));

        return pm;
    }//end checkPm
    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, SYSParam
     * @return
     */
    private void loadList(HttpServletRequest request, SysParam pm)throws Exception{
     
        ReportDAO rDAO = new ReportDAO();
        
        ReportEntity rEntity = null;

        //SELECT �׸� SQL...
        String selectSQL =
            "SELECT                            \n" +
            "       PT_B.USER_NAME,     \n" +
            "       PT_A.READ_FLAG,           \n" +
            "       PT_A.WRITE_FLAG      \n";            
        
        String fromSQL =
            " FROM  PT_AUTH_USER PT_A,  PT_USER PT_B  \n";

        /* ******����¡ ���� cnt SQL...******* */
        String cntSQL =
            " SELECT COUNT(*)  CNT  \n";
            
       /* ******����¡ ���� cnt SQL... ��******* */

        String whereSQL =
            //"  WHERE 1=1  AND PT_A.USER_ID = PT_B.USER_ID AND PT_A.PG_ID ='77' \n";            
            "  WHERE 1=1  AND PT_A.USER_ID = PT_B.USER_ID AND PT_A.PG_ID ='" + pm.getScPG_ID() + "' \n";

        String orderSQL =
            " ORDER BY USER_NAME ASC    \n";
        
        /* ***************************** ����¡ ���� *****************************/
        
        String totalCount = ""; // ��ü ��� ��
        
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage()); // �������� ��� ��        
        int nowPage    = 1;     // ���� ������ ��ȣ
        
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL + fromSQL + whereSQL);
        
        totalCount=rEntity.getValue(0,"CNT");

        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);

        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /* **************************** ����¡ ���� �� **************************/

        rEntity = rDAO.select(selectSQL + fromSQL + whereSQL + orderSQL ,nowPage, rowPerPage);

        System.out.println(rEntity);
        /****** �˻����� �ʱⰪ ***********/
        request.setAttribute("pm", pm);
        request.setAttribute("v_PgUserList", rEntity );        
    }      

}
