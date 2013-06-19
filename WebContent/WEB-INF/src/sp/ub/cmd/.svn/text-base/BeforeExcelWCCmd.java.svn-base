/**
 * 파일명   : StudExcelWCCmd
 * 설명     : 리스트 cmd  
 * 이력사항
 * CH00     :2006/11/15 정용규 
 */

package sp.ub.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;

public class BeforeExcelWCCmd implements KJFCommand {
	
	private static final char[] SEQ = null;
	ReportDAO    rDAO        = new ReportDAO();
	ReportEntity rEntity     = null;


	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
		
		UbParam pm = checkFrm(form);
		//entity.setRequestOnlyString(request);
		String cmd = request.getParameter("cmd");
//		
//		/*신규등록*/
//		int maxSeq = getMaxSeq();
//
//		String[] DATA1 = request.getParameterValues("DATA_1");
//		String[] DATA2 = request.getParameterValues("DATA_2");
//		String[] DATA3 = request.getParameterValues("DATA_3");
//		String[] DATA4 = request.getParameterValues("DATA_4");
//		String[] DATA5 = request.getParameterValues("DATA_5");
//		String[] DATA6 = request.getParameterValues("DATA_6");
//		String[] DATA7 = request.getParameterValues("DATA_7");
//		String[] DATA8 = request.getParameterValues("DATA_8");
//		String[] DATA9 = request.getParameterValues("DATA_9");
//		String[] DATA10 = request.getParameterValues("DATA_10");
//		String[] DATA11 = request.getParameterValues("DATA_11");
//		String[] DATA12 = request.getParameterValues("DATA_12");
//
//	//int cnt = maxSeq;
//
//		if(DATA1 != null){
//
//		for(int i=0;i<DATA1.length;i++){
//
//			//System.out.println("DATA1="+DATA1[i]);
//			
//			//entity.setSEQ(Integer.toString(cnt));
//			entity.setSEQ(""+(maxSeq+i));
//			entity.setDATA1(DATA1[i]);
//			entity.setDATA2(DATA2[i]);
//			entity.setDATA3(DATA3[i]);
//			entity.setDATA4(DATA4[i]);
//			entity.setDATA5(DATA5[i]);
//			entity.setDATA6(DATA6[i]);
//			entity.setDATA7(DATA7[i]);
//			entity.setDATA8(DATA8[i]);
//			entity.setDATA9(DATA9[i]);
//			entity.setDATA10(DATA10[i]);
//			entity.setDATA11(DATA11[i]);
//			entity.setDATA12(DATA12[i]);
//			System.out.println("DATA1="+DATA11[i]);
//			System.out.println("DATA1="+DATA12[i]);
//			System.out.println("SEQ="+(maxSeq+i));
//			//cnt = cnt + 1;
//			insertExe(request);
	
//			}
//		}
		
		return cmd;
	
		}
	
    /**
     * 신규등록
     * @param HttpServletRequest
     * @return
     */
    private void insertExe(HttpServletRequest request)throws Exception{
   // 	dao.insert(entity);
  	
    }
   
    private int getMaxSeq()throws Exception{
		rEntity = rDAO.select("SELECT NVL(MAX(to_number(SEQ))+1,1) MAX_SEQ FROM PT_EXCEL");
		return Integer.parseInt(rEntity.getValue(0,"MAX_SEQ"));
    }
    private UbParam checkFrm(ActionForm form)throws Exception{
		
    	UbParam frm = (UbParam)form;

        /*페이징 라인*/
        if (KJFUtil.isEmpty(frm.getRowPerPage())){
        	frm.setRowPerPage(Config.props.get("ROW_PER_PAGE"));
        }
        
		return frm;
		
	}
    
}
