/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
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
        
        
        //코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
    	String selectSQL=
    		" SELECT   P_CODE CODE, CODE_NAME " +
				   " FROM     PT_COM_CODE     " +
				   " WHERE    CODE = '000'  " +
				   " ORDER BY P_CODE            ";
    	
    	rEntity    = rDAO.select(selectSQL);    	
    	//DB에서 가져오는 데이타 외 추가적으로 1개의 ROW만 추가하여 사용할 경우  ReEnt2CodeDs
    	//를 사용한다.
    	
        KJFMi.ReEnt2CodeDs(dl,rEntity,"ds_sc_code_group", "all","전체"); //접두어 _sc_ 검색조건절 약자
        
        KJFMi.ReEnt2CodeDs(dl,rEntity,"ds_code_group", "000","그룹 코드"); 

        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        //KJFMi.ReEnt2Ds(dl,rEntity,"ds_code_group_sample");
        
        
        request.setAttribute("dl", dl);  

        return next;
    }


}