package sp.chart;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.action.KJFCommandResp;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sp.action.KJFAction;
import sp.chart.cmd.ChartAreaCmd;
import sp.chart.cmd.ChartBusinessCmd;
import sp.chart.cmd.ChartMonthCmd;
import sp.chart.cmd.ChartRegisterCmd;
import sp.chart.cmd.ChartUbCmd;
import sp.chart.cmd.ChartYearCmd;

public class ChartAction extends KJFAction {
    
    /** 명령패턴 class들 **/
    private HashMap<String, KJFCommandResp> commands; 

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
                                HttpServletResponse response) throws Exception {

        initCommands();
        KJFCommandResp cmd = lookupCommand(request.getParameter("cmd"));         

        return  cmd.execute(request, response, form); 
    }


    /**
     * Command들을 등록한다.
     * @param
     * @return
     */
    private void initCommands() {
        commands = new HashMap<String, KJFCommandResp>();      
        
        commands.put("ChartRegister",     new ChartRegisterCmd("/com/ChartResult.jsp"));    // 등록누적현황
        commands.put("ChartYear",         new ChartYearCmd("/com/ChartResult.jsp"));        // 년간 누적현황
        commands.put("ChartBusiness",     new ChartBusinessCmd("/com/ChartResult.jsp"));    // 사업자 유형별 통계
        commands.put("ChartMonth",        new ChartMonthCmd("/com/ChartResult.jsp"));       // 월간 통계        
        
        commands.put("ChartArea",     	  new ChartAreaCmd());  // 지역 차트 
        commands.put("ChartUb",        new ChartUbCmd("/com/ChartResult.jsp"));       // 사용전검사 메인
    }    


    /**
     * 요청받은 명령의 Command instance를 구한다.
     * @param cmd 명령명
     * @return Command class instance
     */
    private KJFCommandResp lookupCommand(String cmd) throws Exception {
        
        if (commands.containsKey(cmd)) {
            return commands.get(cmd);
            
        } else {
            throw new Exception("Invalid Command Identifier:" + cmd );
        }
    }

}
