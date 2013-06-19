package sp.ub.cmd;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.util.KJFDate;
import kjf.util.KJFExcel;
import kjf.util.KJFFile;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.MsgException;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

import sp.ub.UbParam;

public class BeforeExcelWCmd implements KJFCommand{
    
	private String next;	
    private static DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
	public BeforeExcelWCmd(){}

	public BeforeExcelWCmd(String next_url) {
    	next = next_url;
    }

	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
				
        return next;
	}
	public String execute(HttpServletRequest request) throws Exception {
		

        return next;
	}
	private UbParam checkPm(ActionForm form)throws Exception{
		UbParam pm = (UbParam)form;
		
        /*페이징 라인*/
        if (KJFUtil.isEmpty(pm.getRowPerPage())){
        	pm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
        
		return pm;
		
	}
	
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request,UbParam pm)throws Exception{
		        
    }//end loadCondition
	
	private void loadList(HttpServletRequest request, UbParam pm)throws Exception{

	
	}

}
