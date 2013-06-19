package sp.hms.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_HMS_COM_CODEDAO;
import sp.dao.PT_HMS_COM_CODEEntity;

/***************************************************************************
 * <p>Title       : HmsCodeMgrCUDCmd Class</p>
 * <p>Description : HTML �����ڵ� ���,���� ó�� Ŭ����</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE :  HTML �����ڵ� ���,���� ó���� �Ѵ�.
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class HmsCodeMgrCUDCmd implements KJFCommand {
    
    PT_HMS_COM_CODEDAO      PT_HMS_COM_CODEdao  = new PT_HMS_COM_CODEDAO();
    PT_HMS_COM_CODEEntity   PT_HMS_COM_CODEent  = new PT_HMS_COM_CODEEntity();  
    
    private String next;
    
    public HmsCodeMgrCUDCmd() {
        
    }
    
    public HmsCodeMgrCUDCmd(String next_url) {
        next = next_url;
    }
    
    public String execute(HttpServletRequest request, ActionForm form) throws Exception { 
        
        String mode = request.getParameter("mode");
        
        // request ���� �ڵ� ����
        PT_HMS_COM_CODEent.setRequestOnlyString(request);
        
        // ���õ� ���� Ȯ��
        KJFLog.debug(PT_HMS_COM_CODEent.toString());       
        
        if (mode.equals("C")) {        // �Է�
            insertExe(request);
            
        } else if (mode.equals("U")) { // ����
            updateExe(request);
            
        } else if (mode.equals("D")) { // ����
            deleteExe(request);
        }
        
        return next;
    }
    
    /***************************************************************************
     * HTML �����ڵ� ��� 
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void insertExe(HttpServletRequest request) throws Exception {
        
        String codeGroup = PT_HMS_COM_CODEent.getCODE_GROUP();
        
        if ("0".equals(codeGroup)) {
            PT_HMS_COM_CODEent.setCODE_GROUP(PT_HMS_COM_CODEent.getCODE());
            PT_HMS_COM_CODEent.setCODE("000");
        }
        
        PT_HMS_COM_CODEdao.insert(PT_HMS_COM_CODEent);       
    } 
    

    /***************************************************************************
     * HTML �����ڵ� ���� 
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void updateExe(HttpServletRequest request) throws Exception {       
        PT_HMS_COM_CODEdao.update(PT_HMS_COM_CODEent);               
    } 
    
    
    /***************************************************************************
     * HTML �����ڵ� ���� 
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void deleteExe(HttpServletRequest request) throws Exception {       
        PT_HMS_COM_CODEdao.delete(PT_HMS_COM_CODEent);      
    }
}