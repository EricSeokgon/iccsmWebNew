package sp.bas.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class BasPostStDCmd implements KJFCommand  {
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public BasPostStDCmd() {
    }
         
    public BasPostStDCmd(String next_url) {
    	next = next_url;
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	/****** Service API 초기화 ******/
    	PlatformRequest pReq = new PlatformRequest(request, Config.props.get("ENCODING"));
    	/** Web Server에서 XML수신 및 Parsing **/
    	pReq.receiveData(); 	
    	/** 변수 획득 **/
    	vl = pReq.getVariableList();
    	
        String scDong = vl.getValueAsString("scDong");
        String AREA_CODE = vl.getValueAsString("AREA_CODE");
        String SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
        String SIDO_NM_CUT = vl.getValueAsString("SIDO_NM_CUT");
        
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null; 
        StringBuilder Squery =	new StringBuilder();
        
        // 주소 검색 다이얼로그에서 넘길때 ADDRESS2를 넘긴다.
         Squery.append( "SELECT " );
        Squery.append( "SEQ, " );
         Squery.append( "ZIPCODE, " );
        Squery.append("sido||' '||gugun||' '||dong||' '||bunji  ");
         Squery.append( " AS ADDRESS, ");
         //Squery.append( "SIDO||' '||GUGUN||' '||DONG||' '||RI||''||DONG  AS ADDRESS, "); 	 
         Squery.append( "SIDO||' '||GUGUN||' '||DONG  AS ADDRESS2 "); 	
         Squery.append( " FROM   PT_COM_ZIPCODE  \n");
         //Squery.append( " FROM   PT_COM_ZIPCODE_NEW  \n");	          	 	
       	/* if(!KJFUtil.isEmpty(AREA_CODE=("sjsj")))
         {
       		AREA_CODE = vl.getValueAsString("AREA_CODE");
       		SIDO_NM_CUT = vl.getValueAsString("SIDO_NM_CUT");
       		SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
       		System.out.println("SIGUNGU_NM  "+SIGUNGU_NM);
       		
       		 // Squery.append("WHERE SIDO like '%"+ AREA_CODE+"%'");
       		
       		  Squery.append( "where sido = '"+SIDO_NM_CUT+"'");
       		  Squery.append( "and DONG like '%"+ scDong+"%'");

         }else if(!KJFUtil.isEmpty(SIGUNGU_NM="")){
        	 
        	AREA_CODE = vl.getValueAsString("AREA_CODE");
        	SIDO_NM_CUT = vl.getValueAsString("SIDO_NM_CUT");
        	SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
        	System.out.println("SIGUNGU_NM  "+SIGUNGU_NM);

         	Squery.append( "where sido = '"+SIDO_NM_CUT+"'");
         	Squery.append( "and DONG like '%"+ scDong+"%'");
         	
         
         }else 	if(!KJFUtil.isEmpty(SIGUNGU_NM!="")){
      		AREA_CODE = vl.getValueAsString("AREA_CODE");
        	SIDO_NM_CUT = vl.getValueAsString("SIDO_NM_CUT");
        	SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
        	System.out.println("SIGUNGU_NM  "+SIGUNGU_NM);
        	
        	Squery.append( "where sido = '"+SIDO_NM_CUT+"'");
        	Squery.append("and GUGUN = '"+SIGUNGU_NM+"'");
         	Squery.append( "and DONG like '%"+ scDong+"%'");
        	
     	}*/
         if(!KJFUtil.isEmpty(SIGUNGU_NM)){
        	 
         	AREA_CODE = vl.getValueAsString("AREA_CODE");
         	SIDO_NM_CUT = vl.getValueAsString("SIDO_NM_CUT");
         	SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
         	System.out.println("SIGUNGU_NM  "+SIGUNGU_NM);

          	Squery.append( "where sido = '"+SIDO_NM_CUT+"'");
          	Squery.append("and GUGUN = '"+SIGUNGU_NM+"'");
          	Squery.append( "and DONG like '%"+ scDong+"%'");
          	
          
          }else{
       		AREA_CODE = vl.getValueAsString("AREA_CODE");
         	SIDO_NM_CUT = vl.getValueAsString("SIDO_NM_CUT");
         	SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
         	System.out.println("SIGUNGU_NM  "+SIGUNGU_NM);
         	
         	Squery.append( "where sido = '"+SIDO_NM_CUT+"'");
          	Squery.append( "and DONG like '%"+ scDong+"%'");
         	
      	}
       	 
           rEntity = rDAO.select(Squery.toString());
           
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_COM_ZIPCODE");     
        request.setAttribute("dl", dl);  

        return next;
    }

}
