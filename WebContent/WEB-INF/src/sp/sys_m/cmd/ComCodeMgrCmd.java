/**
 * ���ϸ�   : ComCodeMgrCmd.java
 * ����     : �����ڵ���� cmd
 * �̷»���
 * CH00     : 2006/09/21 �缮ȯ �����ۼ�
 */

package sp.sys_m.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFLog;
import kjf.util.KJFMi;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.sys_m.Sys_mParam;

import com.tobesoft.platform.data.DatasetList;

public class ComCodeMgrCmd implements KJFCommand {
	
    private String next;	
    private DatasetList  dl = new DatasetList();
    
    public ComCodeMgrCmd() {
    }

    public ComCodeMgrCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
        
        //�ڵ强 ����Ÿ �� ��� �׻� �ʵ尡 2���� �����ؾ� ��
    	String selectSQL=
    		" SELECT   P_CODE CODE, CODE_NAME " +
				   " FROM     PT_COM_CODE     " +
				   " WHERE    CODE = '000'  " +
				   " ORDER BY P_CODE            ";
    	
    	rEntity    = rDAO.select(selectSQL);    	
    	//DB���� �������� ����Ÿ �� �߰������� 1���� ROW�� �߰��Ͽ� ����� ���  ReEnt2CodeDs
    	//�� ����Ѵ�.
    	
        KJFMi.ReEnt2CodeDs(dl,rEntity,"ds_sc_code_group", "all","��ü"); //���ξ� _sc_ �˻������� ����
        
        KJFMi.ReEnt2CodeDs(dl,rEntity,"ds_code_group", "000","�׷� �ڵ�"); 

        
        //����Ÿ �߰��� �ʿ���� ��� �Ϲ����� ReEnt2Ds�� ����Ѵ�.
        //KJFMi.ReEnt2Ds(dl,rEntity,"ds_code_group_sample");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }


}