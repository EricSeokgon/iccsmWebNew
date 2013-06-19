/**
 * ���ϸ�   : BbsControlCmd.java 
 * ����     : ������� cmd  
 * �̷»���
 * CH00     :2006/07/4 ���ν� �����ۼ� 
 */
package sp.user.cmd;

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
import sp.user.UserParam;


public class UserMgrCmd implements KJFCommand {

	private String next;
	
    public UserMgrCmd() {
    }
    
    public UserMgrCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	
        //�˻����� �� �ʱⵥ��Ÿ �ε�
        loadCondition(request);
        
        //�˻����� ������ üũ
        UserParam pm = checkPm(request, form);
        
        //����Ʈ �ε�
        loadList(request, pm);
        
        
        return next;
    }
    
    
    
    /**
     * �˻����� �� �ʱⵥ��Ÿ �ε�
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	    	
    	/*********** ȸ�� �˻�  Ÿ���߰�       ���� ***************/		
    	String[][] selField = {{"000","�˻�����"},{"USER_NAME","����"},{"USER_ID","���̵�"},{"USER_TEL","��ȭ��ȣ"},{"USER_MOBILE","�ڵ���"},{"USER_EMAIL","�̸���"}}; // �Խ��� Ÿ��
    	String[][] selCondition = {{"like","����˻�"},{"=","�ܾ���ġ"}}; //��� ����
    	String[][] selOrder = {{"desc","�������� ����"},{"asc","�������� ����"}}; //��� ����
		String sql=" SELECT   CODE, CODE_NAME " +
				   " FROM     PT_COM_CODE     " +
				   " WHERE    P_CODE = '0027' AND USE_YN='Y' AND CODE!='000'" +
				   " ORDER BY CODE            ";
		
		Vector v_sc_field 	= KJFUtil.makeSelect(selField);
		request.setAttribute("v_sc_field", v_sc_field);   
		
		Vector v_sc_condition 	= KJFUtil.makeSelect(selCondition);
		request.setAttribute("v_sc_condition", v_sc_condition);
		
		Vector v_sc_order 	= KJFUtil.makeSelect(selOrder);
		request.setAttribute("v_sc_order", v_sc_order);
		
		Vector v_sc_position 	= KJFSelectOPS.getSel(sql,"","�μ�");
		request.setAttribute("v_sc_position", v_sc_position);
		/*********** ȸ�� �˻� Ÿ���߰�  ��************************/      
       
    }//end loadCondition


    /**
     * �˻����� �ʱⰪ ������ üũ
     * @param HttpServletRequest
     * @return SYSParam
     */
    private UserParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	UserParam pm = (UserParam)form;



        //�Ķ���� �����
        KJFLog.debug(pm.toString(request));

        /********************����¡ ����*****************************/
        //����¡ ����
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
        	
            pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
       
        return pm;

    }//end checkPm


    
    
    
    /**
     * ���ǿ� ���� list�� load
     * @param HttpServletRequest, UserParam
     * @return
     */
    private void loadList(HttpServletRequest request, UserParam pm)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        String orderSQL 		 = "";


        //SELECT �׸� SQL...
        String selectSQL =
			"SELECT                     									\n"+ 
          	"  USER_CODE, USER_NAME, USER_ID, USER_PASSWD, USER_EMAIL, USER_TEL,  \n"+ 
        	"  USER_MOBILE, USER_NAT_NUM, ORGANIZATION," +
        	"(SELECT CODE_NAME FROM PT_COM_CODE WHERE P_CODE = '0027' AND CODE =  POSITION) POSITION, POST, STAFF_SYSTEM,  \n"+ 
        	"  STAFF_LEVEL, EMAIL, (SELECT AUTH_GROUP_NAME FROM PT_AUTH_GROUP WHERE AUTH_GROUP_CODE = CAPITAL) CAPITAL, \n" +
        	"  USER_AUTH, USE_YN, REG_DATE, MOD_DATE, LAST_CONN \n" +
        	"  \n";


        String fromSQL=
            "FROM                          									\n"+
            "    PT_USER							                  	\n";




        
            
        /*******����¡ ���� cnt SQL...********/
        String cntSQL =
            "SELECT             \n"+
            "    COUNT(*)  CNT  \n"+
            fromSQL ;
       /*******����¡ ���� cnt SQL... ��********/


        String whereSQL = 
        	"WHERE	1=1				\n";
        
        if(!KJFUtil.isEmpty(pm.getScPOSITION())){
        	whereSQL +=
        		"	AND POSITION = '" + pm.getScPOSITION() + "'    \n";
        }
        		
        if(!KJFUtil.isEmpty(pm.getScTEXT()) && !"000".equals(pm.getScFIELD())){
        	if(pm.getScCONDITION().equals("like")){
        		whereSQL +=
                	"  AND	"+pm.getScFIELD()+" like '%"+pm.getScTEXT()+"%' 	\n";
        	}else{
        		whereSQL +=
                	"  AND	"+pm.getScFIELD()+" = '"+pm.getScTEXT()+"' 	\n";
        	}
        	
        }
        
        
        if(!KJFUtil.isEmpty(pm.getScORDER()) && !"000".equals(pm.getScFIELD())){
        	orderSQL =
            	"ORDER BY  "+pm.getScFIELD()+" "+pm.getScORDER()+"      \n";
        }else{
        	orderSQL =
            	"ORDER BY  USER_NAME ASC      \n";
        	
        	pm.setScORDER("asc");        	
        }

        	

        
        /********************����¡ ����***********************************************************************/
        //��ü ��� ��
        String totalCount="";

        //�������� ��� ��
        int rowPerPage = KJFUtil.str2int(pm.getRowPerPage());

        //���� ������ ��ȣ
        int nowPage = 1;
        nowPage = KJFUtil.isEmpty(pm.getNowPage()) ? 1 : Integer.parseInt(pm.getNowPage());

        rEntity = rDAO.select(cntSQL+whereSQL);
        totalCount=rEntity.getValue(0,"CNT");
        
        if (rowPerPage == 0) rowPerPage = Integer.parseInt(totalCount);
        
        if ((rowPerPage*nowPage) - Integer.parseInt(totalCount) > rowPerPage) nowPage = 1;

        pm.setTotalCount(totalCount);
        pm.setNowPage(String.valueOf(nowPage));
        /********************����¡ ���� ��********************************************************************/

 
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL+orderSQL ,nowPage, rowPerPage);
        
        /****** �˻����� �ʱⰪ ***********/
        request.setAttribute("pm", pm);       
        request.setAttribute("rEntity", rEntity);



    }//end loadList  
    
    
    
    


}