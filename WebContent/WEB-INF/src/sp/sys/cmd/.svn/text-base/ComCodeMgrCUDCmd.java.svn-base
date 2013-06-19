/**
 * 파일명   : ComCodeMgrCUDCmd.java
 * 설명     : CUD cmd
 * 이력사항
 * CH00     : 2006/09/26 양석환 최초작성
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
        PT_COM_CODEent.setRequestOnlyString(request);   // request 값들 자동 세팅
        KJFLog.debug(PT_COM_CODEent.toString());        // 세팅된 값들 확인

        if(mode.equals("C")) {          // 입력
            insertExe(request);
        } else if (mode.equals("U")) { // 수정
            updateExe(request);
        } else if (mode.equals("D")) { // 삭제
            deleteExe(request);
        }

        return next;
    }

    /**
     * 입력
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
            PT_COM_CODEent.setREG_DATE(date);   // 현재 시간.
            PT_COM_CODEent.setMOD_DATE(date);   // 현재 시간.
    
            PT_COM_CODEdao.insert(PT_COM_CODEent);
        }else{
            throw new MsgException("코드가 중복 되었습니다.");
        }

    }

    /**
     * 수정
     * @param HttpServletRequest
     * @return
     */
    private void updateExe(HttpServletRequest request)throws Exception{
        String P_CODE  = PT_COM_CODEent.getP_CODE();
        String date    = KJFDate.datetimeOnly(KJFDate.getCurTime());

        PT_COM_CODEent.setMOD_DATE(date);   // 현재 시간.

        if("000".equals(P_CODE)){
            PT_COM_CODEent.setP_CODE(PT_COM_CODEent.getCODE());
            PT_COM_CODEent.setCODE("000");
        }
        PT_COM_CODEdao.update(PT_COM_CODEent);

    }

    /**
     * 삭제
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