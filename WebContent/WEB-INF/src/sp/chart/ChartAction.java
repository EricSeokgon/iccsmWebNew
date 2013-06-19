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
    
    /** ������� class�� **/
    private HashMap<String, KJFCommandResp> commands; 

    /**
     * ����Command���� �����Ѵ�.
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
     * Command���� ����Ѵ�.
     * @param
     * @return
     */
    private void initCommands() {
        commands = new HashMap<String, KJFCommandResp>();      
        
        commands.put("ChartRegister",     new ChartRegisterCmd("/com/ChartResult.jsp"));    // ��ϴ�����Ȳ
        commands.put("ChartYear",         new ChartYearCmd("/com/ChartResult.jsp"));        // �Ⱓ ������Ȳ
        commands.put("ChartBusiness",     new ChartBusinessCmd("/com/ChartResult.jsp"));    // ����� ������ ���
        commands.put("ChartMonth",        new ChartMonthCmd("/com/ChartResult.jsp"));       // ���� ���        
        
        commands.put("ChartArea",     	  new ChartAreaCmd());  // ���� ��Ʈ 
        commands.put("ChartUb",        new ChartUbCmd("/com/ChartResult.jsp"));       // ������˻� ����
    }    


    /**
     * ��û���� ����� Command instance�� ���Ѵ�.
     * @param cmd ��ɸ�
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
