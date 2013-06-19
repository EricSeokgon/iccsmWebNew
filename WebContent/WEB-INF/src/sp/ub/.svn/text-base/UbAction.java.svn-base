/**
 * 파일명    : UbAction.java 
 * 설명      : Ub 메인관리 Action 
 * 이력사항
 *
 */

package sp.ub; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFMiAction;
import sp.ub.cmd.BeforCheckKeyMgrCmd;
import sp.ub.cmd.BeforeDataMgrCmd;
import sp.ub.cmd.BeforeExcelWCmd;
import sp.ub.cmd.BeforeInvestResultStMgrCmd;
import sp.ub.cmd.BeforeMgrCCmd;
import sp.ub.cmd.BeforeMgrCUDCmd;
import sp.ub.cmd.BeforeMgrCmd;
import sp.ub.cmd.BeforeMgrPCmd;
import sp.ub.cmd.BeforeSchMgrCmd;
import sp.ub.cmd.BeforeViewMgrCmd;
import sp.ub.cmd.CheckKeyMgrCmd;
import sp.ub.cmd.DeliNumMgr2Cmd;
import sp.ub.cmd.DeliNumMgrCmd;
import sp.ub.cmd.DeliNumViewMgrCmd;
import sp.ub.cmd.GroupWareMgrCmd;
import sp.ub.cmd.InvestPublishMgrCmd;
import sp.ub.cmd.ProcCaMgrCmd;
import sp.ub.cmd.ProcMaMgrCmd;
import sp.ub.cmd.ProcPlanMgrCmd;
import sp.ub.cmd.ProcSchMgrCmd;
import sp.ub.cmd.ProcSmaMgrCmd;
import sp.ub.cmd.ReportBeforInvestResultExCUDCmd;
import sp.ub.cmd.ReportBeforeInvestResultStMgrCmd;
import sp.ub.cmd.ReportUBReceiptMgrCmd;
import sp.ub.cmd.SeAllDataMgrCmd;
import sp.ub.cmd.SpuCheckKeyMgrCmd;
import sp.ub.cmd.SupervisionSpotMgrCCmd;
import sp.ub.cmd.SupervisionSpotMgrCUDCmd;
import sp.ub.cmd.SupervisionSpotMgrCmd;
import sp.ub.cmd.SuvspotMgrCCmd;
import sp.ub.cmd.SuvspotMgrCUDCmd;
import sp.ub.cmd.SuvspotMgrCmd;
import sp.ub.cmd.UBEquipmentMgrCmd;
import sp.ub.cmd.UBEquipmentResultExCmd;
import sp.ub.cmd.UBIConfirmMgrCmd;
import sp.ub.cmd.UBInvestMgrCCmd;
import sp.ub.cmd.UBInvestMgrCUDCmd;
import sp.ub.cmd.UBInvestMgrCmd;
import sp.ub.cmd.UBInvestMgrPCmd;
import sp.ub.cmd.UBInvestResultFailStMgrCmd;
import sp.ub.cmd.UBInvestResultStMgrCmd;
import sp.ub.cmd.UBIssueListMgrCmd;
import sp.ub.cmd.UBItemMgrCUDCmd;
import sp.ub.cmd.UBItemMgrCmd;
import sp.ub.cmd.UBMasterCodeMgrCmd;
import sp.ub.cmd.UBPrintListMgrCmd;
import sp.ub.cmd.UBReceiptMgrCCmd;
import sp.ub.cmd.UBReceiptMgrCUDCmd;
import sp.ub.cmd.UBReceiptMgrCmd;
import sp.ub.cmd.UBReceiptMgrExCUDCmd;
import sp.ub.cmd.UBReceiptSysMgrCmd;
import sp.ub.cmd.UBSupervisionResultExCmd;
import sp.ub.cmd.UBSupervisionSpotMgrCmd;
import sp.ub.cmd.UsebeforeFlSchMgrCmd;
import sp.ub.cmd.UsebeforeMgrCmd;
import sp.ub.cmd.UsebeforeNapplViewMgrCmd;
import sp.ub.cmd.UsebeforeSchMgrCmd;
import sp.ub.cmd.UsebeforeViewMgrCmd;



public class UbAction extends KJFMiAction{

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
      
        //개별 cmd를 여기에 등록한다.
        
        commands.put("BeforCheckKeyMgr",    new BeforCheckKeyMgrCmd("dtsList"));// 착공전설계도  접수 번호 중복 체크 
        
        commands.put("BeforeMgr",    new BeforeMgrCmd("dtsList"));// 착공전 설계도 현황
        commands.put("BeforeMgrC",    new BeforeMgrCCmd("dtsList"));// 착공전 설계도 현황
        commands.put("BeforeMgrCUD",    new BeforeMgrCUDCmd("dtsList"));// 착공전 설계도 현황 CUD
        commands.put("BeforeMgrP",    new BeforeMgrPCmd("dtsList"));// 착공전 설계도 대장
        
        commands.put("BeforeInvestResultStMgr",    new BeforeInvestResultStMgrCmd("dtsList"));// 발급대상자 현황        
        
        commands.put("InvestPublishMgr",    new InvestPublishMgrCmd("dtsList"));// 발급대상자 현황
        
        commands.put("UBItemMgr",    new UBItemMgrCmd("dtsList"));// 세부 사항 입력
        commands.put("UBItemMgrCUD",    new UBItemMgrCUDCmd("dtsList"));// 세부사항 CUD
        
        commands.put("UBMasterCodeMgr",    new UBMasterCodeMgrCmd("dtsList"));// 공사업 등록 업체 검색
        
        commands.put("CheckKeyMgr",    new CheckKeyMgrCmd("dtsList"));// 접수 번호 중복 체크    
        
        commands.put("UBReceiptMgr",    new UBReceiptMgrCmd("dtsList"));// 사용전 검사 현황
        commands.put("UBReceiptMgrC",    new UBReceiptMgrCCmd("dtsList"));// 사용전 검사 현황
        commands.put("UBReceiptMgrCUD",    new UBReceiptMgrCUDCmd("dtsList"));// 사용전 검사 신규입력 CUD
        
        commands.put("UBIssueListMgr",    new UBIssueListMgrCmd("dtsList"));// 사용전검사 교부대장
        commands.put("UBPrintListMgr",    new UBPrintListMgrCmd("dtsList"));// 사용전검사 발급대장 로그
        
        commands.put("UsebeforeNapplViewMgr",    new UsebeforeNapplViewMgrCmd("dtsList"));//부적합 리스트
        commands.put("UsebeforeFl]SchMgr",    new UsebeforeFlSchMgrCmd("dtsList"));// 사용전검사 검색
        
        commands.put("UBInvestMgr",    new UBInvestMgrCmd("dtsList"));// 사용전 검사 대상 현황
        commands.put("UBInvestMgrC",    new UBInvestMgrCCmd("dtsList"));// 사용전 검사 대상 현황
        commands.put("UBInvestMgrCUD",    new UBInvestMgrCUDCmd("dtsList"));// 사용전 검사 추가 입력 CUD
        commands.put("UBInvestMgrP",    new UBInvestMgrPCmd("dtsList"));// 사용전 검사 대장
        
        commands.put("BeforeSchMgr",    new BeforeSchMgrCmd("dtsList"));// 착공전설계 검색
        commands.put("BeforeViewMgr",    new BeforeViewMgrCmd("dtsList"));// 착공전설계 상세내용
        commands.put("BeforeDataMgr",    new BeforeDataMgrCmd("dtsList"));// 착공전설계 건축 데이터
        
        commands.put("UsebeforeSchMgr",    new UsebeforeSchMgrCmd("dtsList"));// 사용전검사 검색
        commands.put("UsebeforeFlSchMgr",    new UsebeforeFlSchMgrCmd("dtsList"));// 사용전검사 검색
        commands.put("UsebeforeViewMgr",    new UsebeforeViewMgrCmd("dtsList"));// 사용전검사 상세내용
        commands.put("UsebeforeMgr",    new UsebeforeMgrCmd("dtsList"));// 사용전검사 내용 데이터
        
        
        commands.put("UBInvestResultStMgr",    new UBInvestResultStMgrCmd("dtsList"));// 사용전검사 현황
        commands.put("UBInvestResultFailStMgr",    new UBInvestResultFailStMgrCmd("dtsList"));// 사용전검사 현황
        
        
        commands.put("SupervisionSpotMgr",    new SupervisionSpotMgrCmd("dtsList"));// 감리 현장 현황
        commands.put("SupervisionSpotMgrC",    new SupervisionSpotMgrCCmd("dtsList"));// 김리 현장 관리
        commands.put("SupervisionSpotMgrCUD",    new SupervisionSpotMgrCUDCmd("dtsList"));// 감리 결과 CUD
        
        commands.put("SuvspotMgr",    new SuvspotMgrCmd("dtsList"));// 김리 업체 현황
        commands.put("SpuCheckKeyMgr",    new SpuCheckKeyMgrCmd("dtsList"));// 김리 시스템 키생성
        commands.put("SuvspotMgrC",    new SuvspotMgrCCmd("dtsList"));// 김리 업체관리
        commands.put("SuvspotMgrCUD",    new SuvspotMgrCUDCmd("dtsList"));// 감리 업체관리 CUD
        
        commands.put("DeliNumMgr",    new DeliNumMgrCmd("dtsList"));// 교부 번호 부여
        commands.put("DeliNumMgr2",    new DeliNumMgr2Cmd("dtsList"));// 교부 번호 감소
        commands.put("ProcSchMgr",    new ProcSchMgrCmd("dtsList"));// 담당자 검색
        
        commands.put("GroupWareMgr",    new GroupWareMgrCmd("/groupware/groupware.jsp"));// 전자 결제 연동
        commands.put("UBIConfirmMgr",    new UBIConfirmMgrCmd("dtsList"));	//결재정보 수신(서버에서-->마이플레폼)
        commands.put("SeAllDataMgr",    	new SeAllDataMgrCmd("dtsList"));	//새올 데이터 수신
        commands.put("UBReceiptSysMgr",    new UBReceiptSysMgrCmd("dtsList"));	//프로퍼티 값 가져오기
        
        commands.put("UBEquipmentMgr",    new UBEquipmentMgrCmd("dtsList"));// 디지털전환관련 기자재 설치현황 관리 
        commands.put("UBSupervisionSpotMgr",    new UBSupervisionSpotMgrCmd("dtsList"));// 감리결과보고서 접수 처리목록 (세부내역 감리결과)
        commands.put("ReportBeforeInvestResultStMgr",    new ReportBeforeInvestResultStMgrCmd("dtsList"));//착공전 설계검토 처리목록
        commands.put("ReportUBReceiptMgr",    new ReportUBReceiptMgrCmd("dtsList"));// 사용전검사 처리목록

        commands.put("ProcPlanMgr",    new ProcPlanMgrCmd("dtsList"));// 착공전설계관리 설계자 검색
        
        commands.put("BeforeExcelW",    new BeforeExcelWCmd("dtsList"));// 착공전설계관리 엑셀처리
        
        commands.put("DeliNumViewMgr",    new DeliNumViewMgrCmd("dtsList"));// 착공전설계관리 엑셀처리
        
        commands.put("ProcCaMgr",    new ProcCaMgrCmd("dtsList"));// 기자제
        commands.put("ProcMaMgr",    new ProcMaMgrCmd("dtsList"));// 기자제
        commands.put("ProcSmaMgr",    new ProcSmaMgrCmd("dtsList"));// 기자제
        
        commands.put("ReportBeforInvestResultExCUD",    new ReportBeforInvestResultExCUDCmd("dtsList"));// 착공전설계  일괄입력처 리
        commands.put("UBReceiptMgrExCUD",    new UBReceiptMgrExCUDCmd("dtsList"));// 사용전검사 처리  일괄입력처 리
        commands.put("UBSupervisionResultEx",    new UBSupervisionResultExCmd("dtsList"));// 감리결과보고서 일괄입력처 리
        commands.put("UBEquipmentResultEx",    new UBEquipmentResultExCmd("dtsList"));// 디지털전환관련지자재 일괄입력처 리
 
     
        //commands.put("StopResultStMgr", new StopResultStMgrCmd("dtsList"));

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
