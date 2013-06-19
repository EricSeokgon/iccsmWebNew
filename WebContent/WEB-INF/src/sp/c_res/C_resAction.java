/**
 * 파일명    : C_resAction.java 
 * 설명      : C_res 메인관리 Action 
 * 이력사항
 *
 */

package sp.c_res; 

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sp.action.KJFMiAction;
import kjf.action.KJFCommand;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.c_res.cmd.*;



public class C_resAction extends KJFMiAction{

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
        // 시스템 자원관리
        commands.put("ResSystemMgr", new ResSystemMgrCmd("dtsList"));   //교환기 관리 전체 리스트        
        commands.put("ResSystemSwitMgr", new ResSystemSwitMgrCmd("dtsList"));   //교환기 관리 관리
        commands.put("ResSystemSwitMgrCUD", new ResSystemSwitMgrCUDCmd("dtsList"));   //교환기 관리 관리 CUD
        
        commands.put("RegMultipSysMgr", new RegMultipSysMgrCmd("dtsList"));   //다중화장비 관리 전체 리스트        
        commands.put("RegMultipMgr", new RegMultipMgrCmd("dtsList"));   //다중화장비 관리
        commands.put("RegMultipMgrCUD", new RegMultipMgrCUDCmd("dtsList"));   //다중화장비 관리 CUD
        
        commands.put("RegChargeSysMgr", new RegChargeSysMgrCmd("dtsList"));   //과금장치 관리 전체 리스트        
        commands.put("RegChargeMgr", new RegChargeMgrCmd("dtsList"));   //과금장치 관리
        commands.put("RegChargeMgrCUD", new RegChargeMgrCUDCmd("dtsList"));   //과금장치 관리 CUD
        
        commands.put("RegARSSysMgr", new RegARSSysMgrCmd("dtsList"));   //ARS 관리 전체 리스트        
        commands.put("RegARSMgr", new RegARSMgrCmd("dtsList"));   //ARS 관리
        commands.put("RegARSMgrCUD", new RegARSMgrCUDCmd("dtsList"));   //ARS 관리 CUD
        
        
        //IPT/영상 자원 관리        
        
        commands.put("ResIPTMgr", new ResIPTMgrCmd("dtsList"));   //IPT설치 관리 전체 리스트        
        commands.put("ResIPTIptMgr", new ResIPTIptMgrCmd("dtsList"));   //IPT설치 관리
        commands.put("ResIPTIptMgrCUD", new ResIPTMgrCUDCmd("dtsList"));   //IPT설치 관리 CUD
        
        commands.put("RegImageSysIptMgr", new RegImageSysIptMgrCmd("dtsList"));   //영상시스템 관리 전체 리스트        
        commands.put("RegImageSysMgr", new RegImageSysMgrCmd("dtsList"));   //영상시스템 관리
        commands.put("RegImageSysMgrCUD", new RegImageSysMgrCUDCmd("dtsList"));   //영상시스템 관리 CUD
        
        commands.put("RegImageTelIptMgr", new RegImageTelIptMgrCmd("dtsList"));   //영상전화 관리 전체 리스트        
        commands.put("RegImageTelMgr", new RegImageTelMgrCmd("dtsList"));   //영상전화 관리
        commands.put("RegImageTelMgrCUD", new RegImageTelMgrCUDCmd("dtsList"));   //영상전화 관리 CUD
        
        //통신단말기 자원관리
        
        commands.put("ResCommMgr", new ResCommMgrCmd("dtsList"));   //전송장비 관리 전체 리스트        
        commands.put("ResCommSandMgr", new ResCommSandMgrCmd("dtsList"));   //전송장비 관리 
        commands.put("ResCommSandMgrCUD", new ResCommSandMgrCUDCmd("dtsList"));   //전송장비 관리 CUD
        
        commands.put("RegFaxComMgr", new RegFaxComMgrCmd("dtsList"));   //팩시밀리 관리 전체 리스트        
        commands.put("RegFaxMgr", new RegFaxMgrCmd("dtsList"));   //팩시밀리 관리 
        commands.put("RegFaxMgrCUD", new RegFaxMgrCUDCmd("dtsList"));   //팩시밀리 관리 CUD
        
        commands.put("RegFaxBroadComMgr", new RegFaxBroadComMgrCmd("dtsList"));   //동보장치 관리 전체 리스트        
        commands.put("RegFaxBroadMgr", new RegFaxBroadMgrCmd("dtsList"));   //동보장치 관리 
        commands.put("RegFaxBroadMgrCUD", new RegFaxBroadMgrCUDCmd("dtsList"));   //동보장치 관리 CUD
        
        commands.put("RegSatellMobileComMgr", new RegSatellMobileComMgrCmd("dtsList"));   //위성전화 관리 전체 리스트        
        commands.put("RegSatellMobileMgr", new RegSatellMobileMgrCmd("dtsList"));   //위성전화 관리 
        commands.put("RegSatellMobileMgrCUD", new RegSatellMobileMgrCUDCmd("dtsList"));   //위성전화 관리 CUD
        
        commands.put("RegMobilePhoneComMgr", new RegMobilePhoneComMgrCmd("dtsList"));   //휴대폰 관리 전체 리스트        
        commands.put("RegMobilePhoneMgr", new RegMobilePhoneMgrCmd("dtsList"));   //휴대폰 관리 
        commands.put("RegMobilePhoneMgrCUD", new RegMobilePhoneMgrCUDCmd("dtsList"));   //휴대폰 관리 CUD
        
        commands.put("RegCarMobileComMgr", new RegCarMobileComMgrCmd("dtsList"));   //차량휴대용 관리 전체 리스트        
        commands.put("RegCarMobileMgr", new RegCarMobileMgrCmd("dtsList"));   //차량휴대용 관리 
        commands.put("RegCarMobileMgrCUD", new RegCarMobileMgrCUDCmd("dtsList"));   //차량휴대용 관리 CUD
        
        commands.put("RegPdaComMgr", new RegPdaComMgrCmd("dtsList"));   //PDA 관리 전체 리스트        
        commands.put("RegPdaMgr", new RegPdaMgrCmd("dtsList"));   //PDA 관리 
        commands.put("RegPdaMgrCUD", new RegPdaMgrCUDCmd("dtsList"));   //PDA 관리 CUD
        
        commands.put("RegMobilePrintComMgr", new RegMobilePrintComMgrCmd("dtsList"));   //모바일 프린트  관리 전체 리스트        
        commands.put("RegMobilePrintMgr", new RegMobilePrintMgrCmd("dtsList"));   //모바일 프린트 관리 
        commands.put("RegMobilePrintMgrCUD", new RegMobilePrintMgrCUDCmd("dtsList"));   //모바일 프린트 관리 CUD
        
        // 네트워크 자원관리
        
        commands.put("ResNetworkMgr", new ResNetworkMgrCmd("dtsList"));   //전용회선 관리  전체 리스트        
        commands.put("ResNetworkPrivateMgr", new ResNetworkPrivateMgrCmd("dtsList"));   //전용회선 관리 
        commands.put("ResNetworkPrivateMgrCUD", new ResNetworkPrivateMgrCUDCmd("dtsList"));   //전용회선 관리  CUD
        
        commands.put("RegNormalLineNetMgr", new RegNormalLineNetMgrCmd("dtsList"));   //일반회선 관리  전체 리스트        
        commands.put("RegNormalLineMgr", new RegNormalLineMgrCmd("dtsList"));   //일반회선 관리 
        commands.put("RegNormalLineMgrCUD", new RegNormalLineMgrCUDCmd("dtsList"));   //일반회선 관리  CUD
        
        commands.put("RegOnlyLineNetMgr", new RegOnlyLineNetMgrCmd("dtsList"));   //단일망 관리  전체 리스트        
        commands.put("RegOnlyLineMgr", new RegOnlyLineMgrCmd("dtsList"));   //단일망 관리 
        commands.put("RegOnlyLineMgrCUD", new RegOnlyLineMgrCUDCmd("dtsList"));   //단일망 관리  CUD
        
        commands.put("RegTrafficOutNetMgr", new RegTrafficOutNetMgrCmd("dtsList"));   //트래픽(시외) 관리  전체 리스트        
        commands.put("RegTrafficOutMgr", new RegTrafficOutMgrCmd("dtsList"));   //트래픽(시외) 관리 
        commands.put("RegTrafficOutMgrCUD", new RegTrafficOutMgrCUDCmd("dtsList"));   //트래픽(시외) 관리  CUD
        
        commands.put("RegTrafficadminNetMgr", new RegTrafficadminNetMgrCmd("dtsList"));   //트래픽(행정) 관리  전체 리스트        
        commands.put("RegTrafficadminMgr", new RegTrafficadminMgrCmd("dtsList"));   //트래픽(행정) 관리 
        commands.put("RegTrafficadminMgrCUD", new RegTrafficadminMgrCUDCmd("dtsList"));   //트래픽(행정) 관리  CUD
        
        // 기타자원관
        
        commands.put("RegFixingFlagEtcMgr", new RegFixingFlagEtcMgrCmd("dtsList"));   //고정국기지국관리  전체 리스트        
        commands.put("RegFixingFlagMgr", new RegFixingFlagMgrCmd("dtsList"));   //고정국기지국관리 
        commands.put("RegFixingFlagMgrCUD", new RegFixingFlagMgrCUDCmd("dtsList"));   //고정국기지국관리  CUD
        
        commands.put("RegCommLimitEtcMgr", new RegCommLimitEtcMgrCmd("dtsList"));   //통신정원관리  전체 리스트        
        commands.put("RegCommLimitMgr", new RegCommLimitMgrCmd("dtsList"));   //통신정원관리 
        commands.put("RegCommLimitMgrCUD", new RegCommLimitMgrCUDCmd("dtsList"));   //통신정원관리  CUD

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
