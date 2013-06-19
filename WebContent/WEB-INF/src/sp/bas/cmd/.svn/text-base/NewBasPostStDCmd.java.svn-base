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

public class NewBasPostStDCmd implements KJFCommand  {
	private String next;	
    private DatasetList  dl = new DatasetList();
    private VariableList vl = new VariableList();
    
    public NewBasPostStDCmd() {
    }
         
    public NewBasPostStDCmd(String next_url) {
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
        
       
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null; 
        StringBuilder Squery =	new StringBuilder();
        
        // 주소 검색 다이얼로그에서 넘길때 ADDRESS2를 넘긴다.
         Squery.append( "SELECT " );
         //Squery.append( "SEQ, " );
         Squery.append( "ZIPCODE, " );
         Squery.append( "(sido||' '||gugun||' '||decode(ri, null,road_name||' '||decode(bldg_sun_num,'0',bldg_num||', ('||dong||')', bldg_num||'-'||bldg_sun_num||', ('||dong||')'), ri||' '||road_name||' '||decode(bldg_sun_num,'0',bldg_num, bldg_num||'-'||bldg_sun_num))) as address, "); 	 
         Squery.append( "(sido||' '||gugun||' '||decode(ri, null,road_name||' '||decode(bldg_sun_num,'0',bldg_num, bldg_num||'-'||bldg_sun_num), ri||' '||road_name||' '||decode(bldg_sun_num,'0',bldg_num, bldg_num||'-'||bldg_sun_num))) as address2,  "); 	
         Squery.append( "decode(ri, null, ', ('||dong||')', null) AS ADDRESS3 "); 
         Squery.append( " FROM   PT_COM_ZIPCODE_NEW_"+AREA_CODE+"  \n");	          	 	
         
         System.out.println("AREA_CODE  "+AREA_CODE);
         
       	 if(!KJFUtil.isEmpty(SIGUNGU_NM)){
        	 scDong = vl.getValueAsString("scDong");
      		SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
      		System.out.println("SIGUNGU_NM1  "+SIGUNGU_NM);
      		
      		Squery.append("WHERE GUGUN = '"+SIGUNGU_NM+"'");
 	       	  Squery.append( "and ROAD_NAME like '%"+ scDong+"%'");
 	       	Squery.append( "order by road_name, TO_NUMBER(bldg_num), TO_NUMBER(bldg_sun_num) asc");
       		/* if(!KJFUtil.isEmpty(scDong))
         {
       		 
              scDong = vl.getValueAsString("scDong");
             // AREA_CODE = vl.getValueAsString("AREA_CODE");
              SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
            
            // System.out.println("scDong  "+scDong);
             //System.out.println("SIDO_NM  "+SIDO_NM);
            // System.out.println("SIGUNGU_NM  "+SIGUNGU_NM);
             
	       	  //Squery.append("WHERE SIDO like '%"+ SIDO_NM+"%'");
	       	  Squery.append("WHERE GUGUN = '"+SIGUNGU_NM+"'");
	       	  Squery.append( "and ROAD_NAME like '%"+ scDong+"%'");
	       	  

         }*/
       	 }else{
       		 
       		 scDong = vl.getValueAsString("scDong");
       		SIGUNGU_NM = vl.getValueAsString("SIGUNGU_NM");
       		System.out.println("SIGUNGU_NM2  "+SIGUNGU_NM);
       		
	       	  Squery.append( "WHERE ROAD_NAME like '%"+ scDong+"%'");
	       	Squery.append( "order by road_name, TO_NUMBER(bldg_num), TO_NUMBER(bldg_sun_num) asc");
      }
           rEntity = rDAO.select(Squery.toString());
           
        
        //데이타 추가가 필요없는 경우 일반적인 ReEnt2Ds를 사용한다.
        KJFMi.ReEnt2Ds(dl,rEntity,"dsPT_COM_ZIPCODE_NEW");     
        request.setAttribute("dl", dl);  

        return next;
    }
    
}
