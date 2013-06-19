package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_AUTH_PGDAO;
import sp.dao.PT_AUTH_PGEntity;

public class AuthPgMgrCUDCmd implements KJFCommand {
	PT_AUTH_PGEntity PT_AUTH_PGent = new PT_AUTH_PGEntity();
	PT_AUTH_PGDAO    PT_AUTH_PGdao = new PT_AUTH_PGDAO();

	private String next;
	
    public AuthPgMgrCUDCmd() {
    }
    
    public AuthPgMgrCUDCmd(String next_url) {
    	next = next_url; 
    }
	
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	String mode = request.getParameter("mode");

    	PT_AUTH_PGent.setRequestOnlyString(request); // request ���� �ڵ� ����
    	PT_AUTH_PGent.setUPD_DT(KJFDate.datetimeOnly(KJFDate.getCurTime()));//���� �ð�.    	
    	KJFLog.debug(PT_AUTH_PGent.toString()); //���õ� ���� Ȯ��
    	
    	if(mode.equals("C")) { //�Է�
    		insertExe(request);
    	} else if (mode.equals("GC")) { //�׷� ��ü �Է� 
    		insertAllExe(request);
    	} else if (mode.equals("D")) { //����
    		deleteExe(request);
    	}else if (mode.equals("GD")) { //�׷� ��ü ����
    		deleteAllExe(request);
    	}
              
        return next;
    }

    /**
     * �Է�
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{        
        try{
        	PT_AUTH_PGdao.insert(PT_AUTH_PGent);
	    } catch(Exception e){
	       	throw new MsgException("�̹� ���� �� ���α׷�  �Դϴ�.");
	    }    	
    } 

    /**
     * �׷� ��ü �Է� 
     * @param HttpServletRequest
     * @return
     */
    private void insertAllExe(HttpServletRequest request)throws Exception{
    	
        String sql      = "";
        ReportDAO    rDAO        = new ReportDAO();
        
    	String GR_ADN_PG_IDS=request.getParameter("GR_ADN_PG_IDS");
    	String gr_and_pd_id[] =KJFUtil.str2strs(GR_ADN_PG_IDS,",");
    	if(gr_and_pd_id != null && gr_and_pd_id.length >0){
    		for(int i=0;i<gr_and_pd_id.length;i++){
    			String PG_GROUP_ID = KJFUtil.str2strs(gr_and_pd_id[i],"|")[0];
    			String PG_ID = KJFUtil.str2strs(gr_and_pd_id[i],"|")[1];
    			sql      =
	    			"   INSERT INTO PT_AUTH_PG(	\n" +
	    			"       AUTH_GROUP_CODE, 		\n" +
	    			"       PG_ID,           		\n" +
	    			"       PG_GROUP_ID,     		\n" +
	    			"       UPD_DT       )			\n" +
	    			"   VALUES (?,?,?,TO_DATE(SYSDATE,'YYYY-MM-DD PMHH:MI:SS'))			\n" ;   	

                int j=0;
                rDAO.setValue(++j,PT_AUTH_PGent.getAUTH_GROUP_CODE());
                rDAO.setValue(++j,PG_ID);
                rDAO.setValue(++j,PG_GROUP_ID);
                rDAO.execute(sql);
    			
    		}
    	}
    	       
    } 
    
    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{
    	PT_AUTH_PGdao.delete(PT_AUTH_PGent);

    } 
    
    
    /**
     * �׷� ��ü ���� 
     * @param HttpServletRequest
     * @return
     */
    private void deleteAllExe(HttpServletRequest request)throws Exception{
    	
        String sql      = "";
        ReportDAO    rDAO        = new ReportDAO();
        
    	String GR_ADN_PG_IDS=request.getParameter("GR_ADN_PG_IDS");
    	String gr_and_pd_id[] =KJFUtil.str2strs(GR_ADN_PG_IDS,",");
    	if(gr_and_pd_id != null && gr_and_pd_id.length >0){
    		for(int i=0;i<gr_and_pd_id.length;i++){
    			String PG_GROUP_ID = KJFUtil.str2strs(gr_and_pd_id[i],"|")[0];
    			String PG_ID = KJFUtil.str2strs(gr_and_pd_id[i],"|")[1];
    			sql      =
    	            "\n     DELETE FROM  PT_AUTH_PG           "+
    	            "\n     WHERE	AUTH_GROUP_CODE='"+PT_AUTH_PGent.getAUTH_GROUP_CODE()+"' 	"+
    	            "\n     AND     PG_ID='"+PG_ID+"'       "+ 
    	            "\n     AND     PG_GROUP_ID='"+PG_GROUP_ID+"'       	"; 	



                try{      
                	rDAO.execute(sql);
        	    } catch(Exception e){
        	    }                    
    			
    		}
    	}
    	       
    }     
}
