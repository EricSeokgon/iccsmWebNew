/**
 * 파일명    : StaticsAction.java 
 * 설명      : Statics 메인관리 Action 
 * 이력사항
 *
 */

package sp.statics; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFMiAction;
import sp.c_res.cmd.ResSystemMgrCmd;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.statics.cmd.*;



public class StaticsAction extends KJFMiAction{

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
        //공사업 등록 통계
        commands.put("RegStaticsMgr", new RegStaticsMgrCmd("dtsList")); //등록누적현황 (완)      
        commands.put("RegYearStaticsMgr", new RegYearStaticsMgrCmd("dtsList"));  //연간누적현황(완)        
        commands.put("RegComStaticsMgr", new RegComStaticsMgrCmd("dtsList")); //사업자유형별통계(완)
        
        commands.put("RegEgradeStaticsMgr", new RegEgradeStaticsMgrCmd("dtsList")); //기술자등급별통계
        commands.put("RegEposesStaticsMgr", new RegEposesStaticsMgrCmd("dtsList")); //기술자보유별통계
        commands.put("RegCcapiStaticsMgr", new RegCcapiStaticsMgrCmd("dtsList")); //자본금규모별통계
        commands.put("RegCcontiStaticsMgr", new RegCcontiStaticsMgrCmd("dtsList")); //사업자존속기간별통계
        commands.put("RegCsubsiStaticsMgr", new RegCsubsiStaticsMgrCmd("dtsList")); //사업자겸업현황통계
        
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업등록처리 월간현황(완)
        
        commands.put("RegCchgYearStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업변경처리 연간현황
        commands.put("RegCchgMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업변경처리 월간현황
        
        commands.put("RegCbasicMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업기준신고처리 월간현황
        commands.put("RegCtransMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업양도양수처리 월간현황
        commands.put("RegCunionMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업합병처리 월간현황
        commands.put("RegCcloseMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업폐업처리 월간현황
        commands.put("RegCreMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //공사업재교부처리 월간현황
        
        //위법업체
        commands.put("MeaMcomStaticsMgr", new MeaMcomStaticsMgrCmd("dtsList")); //위법업체처분 연간현황
        commands.put("MeaM2StaticsMgr", new MeaM2StaticsMgrCmd("dtsList")); //영업정지처분 연간현황
        commands.put("MeaM1StaticsMgr", new MeaM1StaticsMgrCmd("dtsList")); //등록취소처분 연간현황
        commands.put("MeaM3StaticsMgr", new MeaM3StaticsMgrCmd("dtsList")); //과태료부과처분 연간현황
        commands.put("MeaM6StaticsMgr", new MeaM6StaticsMgrCmd("dtsList")); //경고조치처분 연간현황
        commands.put("MeaM4StaticsMgr", new MeaM4StaticsMgrCmd("dtsList")); //시정명령처분 연간현황
        commands.put("MeaM5StaticsMgr", new MeaM5StaticsMgrCmd("dtsList")); //형사고발처분 연간현황

        //착공전설계
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //착공전설계도검토현황
        
        //사용전검사
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //사용전검사 결과별 월간통계
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //사용전검사 필증발급유형별 월간통계
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //사용전검사 건축물용도별 월간통계
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //사용전검사 예정일 현황
        commands.put("RegMonStaticsMgr", new RegMonStaticsMgrCmd("dtsList")); //감리대상 건축물현황
        
        
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
