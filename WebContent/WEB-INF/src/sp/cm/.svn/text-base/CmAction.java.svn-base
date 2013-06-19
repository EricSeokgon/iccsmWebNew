/**
 * 파일명    : CmAction.java 
 * 설명      : Cm 메인관리 Action 
 * 이력사항
 *
 */

package sp.cm; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFMiAction;
import sp.cm.cmd.ChgMgrCCUDCmd;
import sp.cm.cmd.ChgMgrCCmd;
import sp.cm.cmd.ChgMgrCmd;
import sp.cm.cmd.ChgReceiptMgrCCUDCmd;
import sp.cm.cmd.ChgReceiptMgrCCmd;
import sp.cm.cmd.ChgReceiptMgrCmd;
import sp.cm.cmd.CloseMgrCmd;
import sp.cm.cmd.CloseReceiptMgrCCUDCmd;
import sp.cm.cmd.CloseReceiptMgrCCmd;
import sp.cm.cmd.CloseReceiptMgrCmd;
import sp.cm.cmd.CorpChgStatusCmd;
import sp.cm.cmd.CorpCloseProcCmd;
import sp.cm.cmd.EngListMgrCmd;
import sp.cm.cmd.RefferListMgrCUDCmd;
import sp.cm.cmd.RefferListMgrCmd;
import sp.cm.cmd.RegChangeMgrCCUDCmd;
import sp.cm.cmd.RegChangeMgrCCmd;
import sp.cm.cmd.RegChangeMgrCmd;
import sp.cm.cmd.RegListCloseMgrCmd;
import sp.cm.cmd.RegListMgrCCmd;
import sp.cm.cmd.RegListMgrCmd;
import sp.cm.cmd.RegListOpenMgrCmd;
import sp.cm.cmd.RegMgrCCUDCmd;
import sp.cm.cmd.RegMgrCCUDNCmd;
import sp.cm.cmd.RegMgrCCmd;
import sp.cm.cmd.RegMgrCNCmd;
import sp.cm.cmd.RegMgrCmd;
import sp.cm.cmd.RegMgrCodeCCmd;
import sp.cm.cmd.RegRePublishListMgrCmd;
import sp.cm.cmd.RegRePublishMgrCCUDCmd;
import sp.cm.cmd.RegRePublishMgrCCmd;
import sp.cm.cmd.RegRePublishMgrCmd;
import sp.cm.cmd.RegRePublishMgrPCmd;
import sp.cm.cmd.RegReceiptMgrCCUDCmd;
import sp.cm.cmd.RegReceiptMgrCCUDNCmd;
import sp.cm.cmd.RegReceiptMgrCCmd;
import sp.cm.cmd.RegReceiptMgrCNCmd;
import sp.cm.cmd.RegReceiptMgrCmd;
import sp.cm.cmd.RegReceiptMgrCodeCCmd;
import sp.cm.cmd.RegReceiptMgrNCmd;
import sp.cm.cmd.RegReportMgrPCmd;
import sp.cm.cmd.RegWrtNumCCmd;
import sp.cm.cmd.StdMgrCCUDCmd;
import sp.cm.cmd.StdMgrCCUDNCmd;
import sp.cm.cmd.StdMgrCCmd;
import sp.cm.cmd.StdMgrCNCmd;
import sp.cm.cmd.StdMgrCmd;
import sp.cm.cmd.StdNearStCmd;
import sp.cm.cmd.StdReceiptMgrCCUDCmd;
import sp.cm.cmd.StdReceiptMgrCCUDNCmd;
import sp.cm.cmd.StdReceiptMgrCCmd;
import sp.cm.cmd.StdReceiptMgrCNCmd;
import sp.cm.cmd.StdReceiptMgrCmd;
import sp.cm.cmd.StdReceiptMgrNCmd;
import sp.cm.cmd.StdShfStCmd;
import sp.cm.cmd.TransMgrCCUDCmd;
import sp.cm.cmd.TransMgrCCUDNCmd;
import sp.cm.cmd.TransMgrCCmd;
import sp.cm.cmd.TransMgrCNCmd;
import sp.cm.cmd.TransMgrCmd;
import sp.cm.cmd.TransMgrNCmd;
import sp.cm.cmd.TransReceiptMgrCCUDCmd;
import sp.cm.cmd.TransReceiptMgrCCmd;
import sp.cm.cmd.TransReceiptMgrCmd;
import sp.cm.cmd.UnionMgrCCUDCmd;
import sp.cm.cmd.UnionMgrCCUDNCmd;
import sp.cm.cmd.UnionMgrCCmd;
import sp.cm.cmd.UnionMgrCNCmd;
import sp.cm.cmd.UnionMgrCmd;
import sp.cm.cmd.UnionMgrNCmd;
import sp.cm.cmd.UnionReceiptMgrCCUDCmd;
import sp.cm.cmd.UnionReceiptMgrCCmd;
import sp.cm.cmd.UnionReceiptMgrCmd;

public class CmAction extends KJFMiAction{

    private HashMap commands; //명령패턴 class들
        	
    /**
     * 개별Command들을 실행한다.
     * @param ActionMapping mapping,
     *         ActionForm form,
     *         HttpServletRequest request,
     *         HttpServletResponse response
     * @return  ActionForward    
     */

	public String executeAction(ActionMapping mapping,
							            ActionForm form,
							            HttpServletRequest request,
							            HttpServletResponse response) throws Exception{
		
			initCommands();		
            KJFCommand cmd = lookupCommand(request.getParameter("cmd"));         
	
	        return cmd.execute(request, form) ; 
	} 
	
	
    /** 
     * Command들을 등록한다.
     * @param 
     * @return       
     */
    private void initCommands(){

        commands = new HashMap();
      
        // 신규개발
        //공사업 등록관리
        commands.put("RegReceiptMgrN", new RegReceiptMgrNCmd("dtsList"));
        commands.put("RegReceiptMgrCN", new RegReceiptMgrCNCmd("dtsList"));
        commands.put("RegReceiptMgrCCUDN", new RegReceiptMgrCCUDNCmd("dtsList"));
        commands.put("RegMgrCN", new RegMgrCNCmd("dtsList"));
        commands.put("RegMgrCCUDN", new RegMgrCCUDNCmd("dtsList"));
        
        //기준신고관리
        commands.put("StdReceiptMgrN", new StdReceiptMgrNCmd("dtsList"));
        commands.put("StdReceiptMgrCN", new StdReceiptMgrCNCmd("dtsList"));
        commands.put("StdReceiptMgrCCUDN", new StdReceiptMgrCCUDNCmd("dtsList"));
        commands.put("StdMgrCN", new StdMgrCNCmd("dtsList"));
        commands.put("StdMgrCCUDN", new StdMgrCCUDNCmd("dtsList"));
        
        
        //양도양수관리
        commands.put("TransMgrCN", new TransMgrCNCmd("dtsList"));
        commands.put("TransMgrN", new TransMgrNCmd("dtsList"));
        commands.put("TransMgrCCUDN", new TransMgrCCUDNCmd("dtsList"));
        
        //합병관리
        commands.put("UnionMgrCN", new UnionMgrCNCmd("dtsList"));
        commands.put("UnionMgrN", new UnionMgrNCmd("dtsList"));
        commands.put("UnionMgrCCUDN", new UnionMgrCCUDNCmd("dtsList"));
        
        //개별 cmd를 여기에 등록한다.
        //공사업등록접수관리
        commands.put("RegReceiptMgr", new RegReceiptMgrCmd("dtsList"));
        commands.put("RegReceiptMgrC", new RegReceiptMgrCCmd("dtsList"));
        commands.put("RegReceiptMgrCCUD", new RegReceiptMgrCCUDCmd("dtsList"));
        
        //문서번호관리
        commands.put("RegMgrCodeC", new RegMgrCodeCCmd("dtsList"));

        //공사업등록관리
        commands.put("RegMgr", new RegMgrCmd("dtsList"));
        commands.put("RegMgrC", new RegMgrCCmd("dtsList"));
        commands.put("RegMgrCCUD", new RegMgrCCUDCmd("dtsList"));
        
        commands.put( "RegReportMgrP", new RegReportMgrPCmd("dtsList") );
        
        //공사업변경신고관리
        commands.put("RegChangeMgr", new RegChangeMgrCmd("dtsList"));
        commands.put("RegChangeMgrC", new RegChangeMgrCCmd("dtsList"));
        commands.put("RegChangeMgrCCUD", new RegChangeMgrCCUDCmd("dtsList"));
        
        //공사업 등록증,등록수첩 재교부 관리
        commands.put("RegRePublishMgr", new RegRePublishMgrCmd("dtsList"));
        commands.put("RegRePublishMgrC", new RegRePublishMgrCCmd("dtsList"));
        commands.put("RegRePublishMgrCCUD", new RegRePublishMgrCCUDCmd("dtsList"));
        commands.put("RegRePublishMgrP", new RegRePublishMgrPCmd("dtsList"));
         
        commands.put("UnionReceiptMgrC", new UnionReceiptMgrCCmd("dtsList"));
        commands.put("UnionReceiptMgrCCUD", new UnionReceiptMgrCCUDCmd("dtsList"));
        commands.put("UnionReceiptMgr", new UnionReceiptMgrCmd("dtsList"));
         
        
        //공사업폐업접수관리
        commands.put("CloseReceiptMgr", new CloseReceiptMgrCmd("dtsList"));
        commands.put("CloseReceiptMgrC", new CloseReceiptMgrCCmd("dtsList"));
        commands.put("CloseReceiptMgrCCUD", new CloseReceiptMgrCCUDCmd("dtsList"));
        commands.put("CorpCloseProc", new CorpCloseProcCmd("dtsList"));
        
        //공사업 폐업관리
        commands.put("CloseMgr", new CloseMgrCmd("dtsList"));
        
        //양도양수관리
        commands.put("TransReceiptMgr", new TransReceiptMgrCmd("dtsList"));
        commands.put("TransReceiptMgrCCUD", new TransReceiptMgrCCUDCmd("dtsList"));
        commands.put("TransReceiptMgrC", new TransReceiptMgrCCmd("dtsList"));
        
        commands.put("TransMgrC", new TransMgrCCmd("dtsList"));
        commands.put("TransMgr", new TransMgrCmd("dtsList"));
        commands.put("TransMgrCCUD", new TransMgrCCUDCmd("dtsList"));
        
        //기준신고접수관리
        commands.put("StdReceiptMgr", new StdReceiptMgrCmd("dtsList"));
        commands.put("StdReceiptMgrC", new StdReceiptMgrCCmd("dtsList"));
        commands.put("StdReceiptMgrCCUD", new StdReceiptMgrCCUDCmd("dtsList"));
        
        //기준신고관리
        commands.put("StdMgrC", new StdMgrCCmd("dtsList"));
        commands.put("StdMgr", new StdMgrCmd("dtsList"));
        commands.put("StdMgrCCUD", new StdMgrCCUDCmd("dtsList"));
        
        //법인전환접수관리
        commands.put("ChgReceiptMgr", new ChgReceiptMgrCmd("dtsList"));
        commands.put("ChgReceiptMgrC", new ChgReceiptMgrCCmd("dtsList"));
        commands.put("ChgReceiptMgrCCUD", new ChgReceiptMgrCCUDCmd("dtsList"));
        
        //법인전환관리
        commands.put("ChgMgrC", new ChgMgrCCmd("dtsList"));
        commands.put("ChgMgr", new ChgMgrCmd("dtsList"));
        commands.put("ChgMgrCCUD", new ChgMgrCCUDCmd("dtsList"));
        
        //합병관리
        commands.put("UnionMgrC", new UnionMgrCCmd("dtsList"));
        commands.put("UnionMgr", new UnionMgrCmd("dtsList"));
        commands.put("UnionMgrCCUD", new UnionMgrCCUDCmd("dtsList"));
        
        //폐업처리
        commands.put("CorpCloseProc", new CorpCloseProcCmd("dtsList"));
        
        //공사업체 현황조회
        commands.put("RegListMgr", new RegListMgrCmd("dtsList"));
        commands.put("RegListMgrC", new RegListMgrCCmd("dtsList"));
        
        
        //공사업체 현등록자조회
        commands.put("RegListOpenMgr", new RegListOpenMgrCmd("dtsList"));
        
        //공사업체  폐업자조회
        commands.put("RegListCloseMgr", new RegListCloseMgrCmd("dtsList"));
        //기술자 조회
        commands.put("EngListMgr", new EngListMgrCmd("dtsList"));
        
        //기준신고대상기업조회
        commands.put("StdNearSt", new StdNearStCmd("dtsList"));
        //기준신고 미달기업 조회
        commands.put("StdShfSt", new StdShfStCmd("dtsList"));
        
        //기준신고대상기업조회
        commands.put("RegWrtNumC", new RegWrtNumCCmd("dtsList"));
        
        //신원조회대상자조회
        commands.put("RefferListMgr", new RefferListMgrCmd("dtsList"));
        commands.put("RefferListMgrCUD", new RefferListMgrCUDCmd("dtsList"));
        
        
        // 양도양수, 합병 등 공사업체 변경관련
        commands.put("CorpChgStatusProc", new CorpChgStatusCmd("dtsList"));
        
        // 접수번호 생성
        commands.put("RegReceiptMgrCodeC", new RegReceiptMgrCodeCCmd("dtsList"));
       
        //정보통신공사업등록증
        //commands.put("RegReportListMgr", new RegReportListMgrCmd("dtsList"));
        
        //공사업등록업무 처리현황
        commands.put("RegRePublishListMgr", new RegRePublishListMgrCmd());
    }




    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
     * @return Command class instance
     */
    private KJFCommand lookupCommand(String cmd) throws Exception{
        if (commands.containsKey(cmd)) {
            return (KJFCommand)commands.get(cmd);
        }else{
            throw new Exception("Invalid Command Identifier");
        }
    }//end lookupCommand

		
}
