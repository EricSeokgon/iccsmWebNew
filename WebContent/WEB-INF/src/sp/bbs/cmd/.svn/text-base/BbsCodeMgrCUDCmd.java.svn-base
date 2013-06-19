package sp.bbs.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.util.KJFLog;

import org.apache.struts.action.ActionForm;

import sp.dao.PT_BBS_COM_CODEDAO;
import sp.dao.PT_BBS_COM_CODEEntity;

/***************************************************************************
 * <p>Title       : BbsCodeMgrCUDCmd Class</p>
 * <p>Description : 게시판공통코드 등록,수정 처리 클래스</p>
 * <p>Copyright   : Copyright(c) 2007 PKT. All rights reserved.</p>
 * 
 * NOTE :  게시판공통코드 등록,수정 처리를 한다.
 * 
 * @version 1.0
 * @author  PKT
 **************************************************************************/
public class BbsCodeMgrCUDCmd implements KJFCommand {
	
	private String next;
	
	PT_BBS_COM_CODEDAO  	PT_BBS_COM_CODEdao 	= new PT_BBS_COM_CODEDAO();
	PT_BBS_COM_CODEEntity  	PT_BBS_COM_CODEent 	= new PT_BBS_COM_CODEEntity();	

    public BbsCodeMgrCUDCmd() {
    }
    
    public BbsCodeMgrCUDCmd(String next_url) {
    	next = next_url; 
    }

    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String mode = request.getParameter("mode");
    	
    	// request 값들 자동 세팅
        PT_BBS_COM_CODEent.setRequestOnlyString(request);
        
        // 세팅된 값들 확인
    	KJFLog.debug(PT_BBS_COM_CODEent.toString());       
    	
    	if (mode.equals("C")) {        // 입력
    		insertExe(request);
    		
    	} else if (mode.equals("U")) { // 수정
    		updateExe(request);
    		
    	} else if (mode.equals("D")) { // 삭제
    		deleteExe(request);
    	}    	
              
        return next;
    }    
    

    /***************************************************************************
     * 공통코드 등록 
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void insertExe(HttpServletRequest request) throws Exception {
        
    	String codeGroup = PT_BBS_COM_CODEent.getCODE_GROUP();
    	
    	if ("0".equals(codeGroup)) {
    		PT_BBS_COM_CODEent.setCODE_GROUP(PT_BBS_COM_CODEent.getCODE());
    		PT_BBS_COM_CODEent.setCODE("000");
    	}
        
    	PT_BBS_COM_CODEdao.insert(PT_BBS_COM_CODEent);       
    } 
    

    /***************************************************************************
     * 공통코드 수정 
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void updateExe(HttpServletRequest request) throws Exception {    	
    	PT_BBS_COM_CODEdao.update(PT_BBS_COM_CODEent);               
    } 
    
    
    /***************************************************************************
     * 공통코드 삭제 
     * 
     * @param request
     * @throws Exception
     **************************************************************************/
    private void deleteExe(HttpServletRequest request) throws Exception {    	
    	PT_BBS_COM_CODEdao.delete(PT_BBS_COM_CODEent);    	
    }     
}