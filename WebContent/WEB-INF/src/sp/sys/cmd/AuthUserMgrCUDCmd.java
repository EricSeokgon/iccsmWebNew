package sp.sys.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_AUTH_USERDAO;
import sp.dao.PT_AUTH_USEREntity;
import sp.sys.SysParam;

public class AuthUserMgrCUDCmd implements KJFCommand {
	
	PT_AUTH_USEREntity PT_AUTH_USERent = new PT_AUTH_USEREntity();
	PT_AUTH_USERDAO    PT_AUTH_USERdao = new PT_AUTH_USERDAO();

	private String next;
	
    public AuthUserMgrCUDCmd() {
    }
    
    public AuthUserMgrCUDCmd(String next_url) {
    	next = next_url; 
    }
	
    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	String mode = request.getParameter("mode");
    	
    	SysParam pm = (SysParam) form;
    	
    	PT_AUTH_USERent.setRequestOnlyString(request); // request ���� �ڵ� ����
    	PT_AUTH_USERent.setUPD_DT(KJFDate.getCurTime());//���� �ð�.    	
    	KJFLog.debug(PT_AUTH_USERent.toString()); //���õ� ���� Ȯ��
    	
    	if(mode.equals("C")) { //�Է�
    		insertExe(request);
    	} else if (mode.equals("GC")) { //�׷� ��ü �Է� 
    		insertAllExe(request);
    	} else if (mode.equals("U")) { //����
    		updateExe(request,pm);
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
        	PT_AUTH_USERent.setREAD_FLAG("N");
        	PT_AUTH_USERent.setWRITE_FLAG("Y");
        	PT_AUTH_USERdao.insert(PT_AUTH_USERent);
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
	    			"   INSERT INTO PT_AUTH_USER(	\n" +
	    			"       USER_ID, 		\n" +
	    			"       PG_ID,           		\n" +
	    			"       PG_GROUP_ID,     		\n" +
	    			"       UPD_DT,READ_FLAG,WRITE_FLAG       )			\n" +
	    			"   VALUES (?,?,?,sysdate,'N','Y')			\n" ;   	

                int j=0;
                rDAO.setValue(++j,PT_AUTH_USERent.getUSER_ID());
                rDAO.setValue(++j,PG_ID);
                rDAO.setValue(++j,PG_GROUP_ID);

                try{      
                	rDAO.execute(sql);
        	    } catch(Exception e){
        	    }                    
    			
    		}
    	}
    	       
    } 
    
    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request,SysParam pm)throws Exception{

    	String str	= request.getParameter("chk");
    	String[] field  = {"READ_FLAG","WRITE_FLAG"};
    	
    	String sql      = "UPDATE PT_AUTH_USER SET READ_FLAG='N',WRITE_FLAG='Y' WHERE USER_ID='"+pm.getUSER_ID()+"'";
        ReportDAO    rDAO        = new ReportDAO();
        rDAO.execute(sql);
        
        String pd_id[] =KJFUtil.str2strs(str,",");
    	if(pd_id != null && pd_id.length >0){
    		for(int i=0;i<pd_id.length;i++){
        	
	    		PT_AUTH_USERent.setPG_ID(pd_id[i]);
	    		PT_AUTH_USERent.setREAD_FLAG("Y");
	    		PT_AUTH_USERent.setWRITE_FLAG("N");
	    		   		
	    		PT_AUTH_USERdao.updateModifiedOnly(PT_AUTH_USERent,field);
    		}
    	}
    } 
    
    
    /**
     * ����
     * @param HttpServletRequest
     * @return
     */
    private void deleteExe(HttpServletRequest request)throws Exception{
    	PT_AUTH_USERdao.delete(PT_AUTH_USERent);

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
    	            "\n     DELETE FROM  PT_AUTH_USER           "+
    	            "\n     WHERE	USER_ID='"+PT_AUTH_USERent.getUSER_ID()+"' 	"+
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
