/**
 * 파일명   : MemMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     :2006/07/15 오두식  최초작성
 */
package sp.mem.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import java.util.*;
import java.util.Date;
import org.apache.struts.action.ActionForm;

import sp.dao.PT_HOM_USERDAO;
import sp.dao.PT_HOM_USEREntity;
import sp.mem.MemParam;

public class MemAdminMgrCUDCmd implements KJFCommand {

	private PT_HOM_USERDAO  		PT_HOM_USERdao 		= new PT_HOM_USERDAO();
	private PT_HOM_USEREntity  		PT_HOM_USERent 		= new PT_HOM_USEREntity();
	
	private String next;

    public MemAdminMgrCUDCmd() {
    }
    
    public MemAdminMgrCUDCmd(String next_url) {
    	next = next_url; 
    }


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {

    	MemParam pm = checkFrm(form);
    	String cmd = request.getParameter("cmd");
    	PT_HOM_USERent.setRequestOnlyString(request); // request 값들 자동 세팅
    	KJFLog.debug(PT_HOM_USERent.toString()); //세팅된 값들 확인

    	if(cmd.equals("MemAdminMgrC")) { //입력
    		insertExe(request,pm);
    	} else if (cmd.equals("MemAdminMgrU")) { //수정
    		updateExe(request,pm);
    	} else if (cmd.equals("MemAdminMgrD")) { //삭제
    		deleteExe(request);
    	}


        return next;
    }



    /**
     * 입력
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request,MemParam pm)throws Exception{

    	//PT_HOM_USERent.setMUM_GUBUN(pm.getScMemGubun());
    	
    	
     		//PT_HOM_USERent.setJOIN_DATE(KJFDate.getCurTime());
       		PT_HOM_USERdao.insert(PT_HOM_USERent);
    	
    }


    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request,MemParam pm)throws Exception{
        
        //PT_HOM_USERent.setUPDATE_CD(KJFDate.getCurTime().toString());//수정 시간.
        String[] fields ={"PASSWORD","CONAME","DEPTNM","ADDR","TEL_INT","TEL_AREA","TEL_NUM","TEL_EXT","FAX_INT","FAX_AREA","FAX_NUM","MOBILE_NO","EMAIL_ADDR","CITY_CODE","STATE_CODE","CONTRY_CODE","PTNR_CODE","PTNR_TYPE","BRNUM","RRNUM","USER_NOTY"};
        PT_HOM_USERdao.updateModifiedOnly(PT_HOM_USERent,fields);
      }


    /**
     * 회원을 접근 금지 시킨다.
     * @param HttpServletRequest
     * @return
     */
//    private void deleteExe(HttpServletRequest request)throws Exception{
//  	String id = request.getParameter("USER_ID"); 
//    	String mode = request.getParameter("mode"); 
//    	PT_HOM_USERent.setSTAFF_CD(id);
//        PT_HOM_USERent.setUPDATE_CD(KJFDate.getCurTime().toString());//수정 시간.
//    	if(mode!=null && mode.equals("release")) //접근금지 해제
//    		PT_HOM_USERent.setUSE_YN("y");
//    	else //접근금지
//    		PT_HOM_USERent.setUSE_YN("n");//수정 시간.
//    	String[] fields ={"USE_YN", "USER_UPD_DT"};
//    	PT_HOM_USERdao.updateModifiedOnly(PT_HOM_USERent,fields);
//    }

    /**
     * 삭제
     * @param HttpServletRequest
     * @return
     * */
    private void deleteExe(HttpServletRequest request)throws Exception{
    	String id = request.getParameter("USER_ID"); 
    	PT_HOM_USERent.setUSER_ID(id);
    	PT_HOM_USERdao.delete(PT_HOM_USERent);
    }
 

    private MemParam checkFrm(ActionForm form)throws Exception{

	  MemParam frm = (MemParam)form;

        /*페이징 라인*/
        if (KJFUtil.isEmpty(frm.getRowPerPage())){
        	frm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }

		return frm;

	}

}