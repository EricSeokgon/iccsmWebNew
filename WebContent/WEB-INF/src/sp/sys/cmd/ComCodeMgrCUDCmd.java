/**
 * ���ϸ�   : ComCodeMgrCUDCmd.java
 * ����     : CUD cmd
 * �̷»���
 * CH00     : 2006/09/26 �缮ȯ �����ۼ�
 */

package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDBUtil;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_COM_CODEDAO;
import sp.dao.PT_COM_CODEEntity;


public class ComCodeMgrCUDCmd implements KJFCommand {

    PT_COM_CODEDAO    PT_COM_CODEdao = new PT_COM_CODEDAO();
    PT_COM_CODEEntity PT_COM_CODEent = new PT_COM_CODEEntity();

	private String next;
	
    public ComCodeMgrCUDCmd() {
    }
    
    public ComCodeMgrCUDCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

        String mode = request.getParameter("mode");
        PT_COM_CODEent.setRequestOnlyString(request);   // request ���� �ڵ� ����
        KJFLog.debug(PT_COM_CODEent.toString());        // ���õ� ���� Ȯ��

        if(mode.equals("C")) {          // �Է�
            insertExe(request);
        } else if (mode.equals("U")) { // ����
            updateExe(request);
        } else if (mode.equals("D")) { // ����
            deleteExe(request);
        }

        return next;
    }

    /**
     * �Է�
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{

        String P_CODE  = PT_COM_CODEent.getP_CODE();
        if("000".equals(P_CODE)){
            PT_COM_CODEent.setP_CODE(PT_COM_CODEent.getCODE());
            PT_COM_CODEent.setCODE("000");
        }

        ReportDAO rDAO = new ReportDAO();
        String sql = 
            "SELECT SEQ FROM PT_COM_CODE WHERE CODE='"+PT_COM_CODEent.getCODE()+"' AND P_CODE='"+PT_COM_CODEent.getP_CODE()+"'";
        ReportEntity rEntity = rDAO.select(sql);
        if(rEntity.getRowCnt()==0){
        
            String SEQ     = KJFDBUtil.getMaxID("SEQ", "PT_COM_CODE");
            String date    = KJFDate.datetimeOnly(KJFDate.getCurTime());
           
            PT_COM_CODEent.setSEQ(SEQ);
            PT_COM_CODEent.setREG_DATE(date);   // ���� �ð�.
            PT_COM_CODEent.setMOD_DATE(date);   // ���� �ð�.
    
            PT_COM_CODEdao.insert(PT_COM_CODEent);
        }else{
            throw new MsgException("�ڵ尡 �ߺ� �Ǿ����ϴ�.");
        }

    }

    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
        String P_CODE  = PT_COM_CODEent.getP_CODE();
        String date    = KJFDate.datetimeOnly(KJFDate.getCurTime());

        PT_COM_CODEent.setMOD_DATE(date);   // ���� �ð�.

        if("000".equals(P_CODE)){
            PT_COM_CODEent.setP_CODE(PT_COM_CODEent.getCODE());
            PT_COM_CODEent.setCODE("000");
        }
        PT_COM_CODEdao.update(PT_COM_CODEent);

    }

    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{

        String[] str    = request.getParameterValues("chk");
        String[] value  = null;

        for(int i = 0; i < str.length; i++){
            value = str[i].split(",");
            PT_COM_CODEent.setSEQ(value[0]);
            PT_COM_CODEent.setCODE(value[1]);
            PT_COM_CODEent.setP_CODE(value[2]);
            PT_COM_CODEdao.delete(PT_COM_CODEent);
        }
    }

}