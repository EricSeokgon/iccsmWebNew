/**
 * ���ϸ�   : SysWorker.java
 * ����	    : sys����� ���� �Լ��� ����
 * �̷»���
 * CH00     :2006/046/01 ���� �����ۼ� 
 */

package sp.sys;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFUtil;
import sp.dao.PT_SM_PROGRAM_LOGDAO;
import sp.dao.PT_SM_PROGRAM_LOGEntity;
import sp.uent.MenuEnt;
import sp.uent.UserEnt;


public class SysWorker {
	
	
	
	private  String QueryMode      = new String("");

	private  String CAPITAL 		   = new String("");
	private  String USER_ID 		   = new String("");
	
	
	/**
	 * ����� ���α׷� ��� �α� ���� KJFAction���� ȣ��
	 * @param request
	 * @throws Exception
	 */
	public static void userActionLog(HttpServletRequest request)throws Exception{
		
		UserEnt user = (UserEnt)request.getSession().getAttribute("user");
    	
    	if(user!=null){
    		if(!user.getUSER_ID().equals(Config.props.get("SYS_ID"))){
	    		PT_SM_PROGRAM_LOGDAO    PT_SM_PROGRAM_LOGdao = new PT_SM_PROGRAM_LOGDAO();
	    		PT_SM_PROGRAM_LOGEntity PT_SM_PROGRAM_LOGent = new PT_SM_PROGRAM_LOGEntity();
	    		
	        	ReportDAO rDAO 	= new ReportDAO();
	        	
		    	String sql     	= "SELECT IFNULL( MAX( LOG_NUM )+0, 0 ) + 1   MAXSEQ FROM PT_SM_PROGRAM_LOG  \n";
		    	String SEQ     	= rDAO.select(sql).getValue(0,"MAXSEQ");    	
		    	
		    	String sql1     	= "SELECT USER_CODE FROM PT_USER WHERE USER_ID='" + KJFUtil.print(user.getUSER_ID()) + "'  \n";
		    	String user_code    = rDAO.select(sql1).getValue(0,"USER_CODE");
		    	
		    	
		    	String date    	= KJFDate.datetimeOnly(KJFDate.getCurTime());
		    	String pgID		= request.getParameter("titPgId");
		    	String cmd		= KJFUtil.print(request.getParameter("cmd"));
		    	String mode		= KJFUtil.print(request.getParameter("mode"));
		    	String reqURI	= request.getRequestURI() + "?" + request.getQueryString();
		    	String userData	= KJFUtil.reportParameters(request) ;   	
		    	String cud = "";
		    	
		    	
		    	
		    	if(cmd.endsWith("CUD")){
		    		cud = mode;
		    	}else if(!"M".equals(mode) && (cmd.endsWith("C") || cmd.endsWith("W") || cmd.endsWith("U") || cmd.endsWith("D"))){
		    		cud = cmd.substring(cmd.length()-1);
		    	}
		    	
		    	if(!"".equals(cud)){ // �Է�,����,�����ÿ��� �α� ����
			    	PT_SM_PROGRAM_LOGent.setLOG_NUM(SEQ);
			    	PT_SM_PROGRAM_LOGent.setUSER_CODE(user_code);
			    	PT_SM_PROGRAM_LOGent.setACCESS_TIME(date);	// ���� �ð�.
			    	PT_SM_PROGRAM_LOGent.setPROGRAM_ID(KJFUtil.print(pgID));
			    	PT_SM_PROGRAM_LOGent.setUSER_ACTION(cud);	// ���� IP.
			    	PT_SM_PROGRAM_LOGent.setREQ_URI(reqURI);
			    	PT_SM_PROGRAM_LOGent.setUSER_DATA(KJFUtil.getTitleLimit(userData.replaceAll("\n","|").replaceAll("[ ]+", ""),1450));
			
			    	PT_SM_PROGRAM_LOGdao.insert(PT_SM_PROGRAM_LOGent);
		    	}
	    	}
    	}
    	
    }
	
	
	/** 
    * �޴��׷� ����Ʈ����  Vector�� �����´�.
    * ���α׷� �׷� ���� ��� ���̰� ���� �޴��� ���� ���� �ʴ´�.
    * PG_GROUP_ID �� 0 �ϰ�쿡�� ������ �ǹ̰� ������ 
    * Ʈ���� �߰� ���� �˾ƾ� �ϴ� ��쿡�� �Ѱ� �޴� arg ��  ���� ������ �˾ƾ� �ϱ� ������ �ڽ��� ������ ������ ���� �´�. 
    * param   String PG_GROUP_ID, String root_name
    * return   Vector
    */	

	public  Vector getMenuGrEntList(String PG_GROUP_ID ) throws  Exception{
        this.CAPITAL="S";	        
        MenuEnt menuEnt = new MenuEnt(); 
        
	    String sql =
        	"SELECT PG_GROUP_ID, 		\n"+ 
        	"        P_PG_GROUP_ID,  	\n"+
        	"        GROUP_NAME,     	\n"+
        	"        PG_GROUP_URL,   	\n"+
        	"        USE_YN,            \n"+
        	"        ORDER_SEQ         	\n"+
        	"FROM   PT_PG_GROUP  		\n"+
        	"WHERE  PG_GROUP_ID='"+PG_GROUP_ID+"'";
	    
        sql += "ORDER BY ORDER_SEQ DESC                                \n"; 	    
	    
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;
	
	    rEntity = rDAO.select(sql);	        
        
	    menuEnt.setPG_GROUP_ID( PG_GROUP_ID);
	    
		if(rEntity != null && rEntity.getRowCnt() >0 ){
			menuEnt.setGROUP_NAME(rEntity.getValue(0,"GROUP_NAME"));
			menuEnt.setP_PG_GROUP_ID(rEntity.getValue(0,"P_PG_GROUP_ID"));
			menuEnt.setPG_GROUP_URL(rEntity.getValue(0,"PG_GROUP_URL"));
			menuEnt.setUSE_YN(rEntity.getValue(0,"USE_YN"));
			menuEnt.setORDER_SEQ(rEntity.getValue(0,"ORDER_SEQ"));
		}
					    
	    
        menuEnt =getMenuEnt(menuEnt,0, "N","N");
        Vector v_menuEntList = new Vector();
        v_menuEntList = getMenuEntList(v_menuEntList,menuEnt);		
		
	    return v_menuEntList;
	
	}	
	

	/** 
    * �޴�����Ʈ ��ü(�׷� ���� )�� �����´�.
    * param   String PG_GROUP_ID
    * return   Vector
    */		
				
	public  Vector getMenuEntList(String PG_GROUP_ID) throws  Exception{
        
        SysWorker worker = new SysWorker(); 	        
        MenuEnt menuEnt = new MenuEnt(); 
        
	    String sql =
        	"SELECT PG_GROUP_ID, 		\n"+ 
        	"        P_PG_GROUP_ID,  	\n"+
        	"        GROUP_NAME,     	\n"+
        	"        PG_GROUP_URL,   	\n"+
        	"        USE_YN,            \n"+
        	"        ORDER_SEQ         	\n"+
        	"FROM   PT_PG_GROUP  		\n"+
        	"WHERE  PG_GROUP_ID='"+PG_GROUP_ID+"' \n"+
        	"  AND  USE_YN='Y'	";
        sql += "ORDER BY ORDER_SEQ DESC                                \n"; 	    
	    
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;
	
	    rEntity = rDAO.select(sql);
	    
	    menuEnt.setPG_GROUP_ID( PG_GROUP_ID);
	    
		if(rEntity != null && rEntity.getRowCnt() >0 ){
			menuEnt.setGROUP_NAME(rEntity.getValue(0,"GROUP_NAME"));
			menuEnt.setP_PG_GROUP_ID(rEntity.getValue(0,"P_PG_GROUP_ID"));
			menuEnt.setPG_GROUP_URL(rEntity.getValue(0,"PG_GROUP_URL"));
			menuEnt.setUSE_YN(rEntity.getValue(0,"USE_YN"));
			menuEnt.setORDER_SEQ(rEntity.getValue(0,"ORDER_SEQ"));
		}
		
        menuEnt = getMenuEnt(menuEnt,0, "Y", "Y");
        Vector v_menuEntList = new Vector();
        v_menuEntList = getMenuEntList(v_menuEntList,menuEnt);		
		
	    return v_menuEntList;	
	}
	
	/** 
    * �޴� ��ü���� ���� �´�.
    * param   String PG_GROUP_ID
    * return   menuEnt
    */		
				
	public   MenuEnt getMenuEnt(MenuEnt menuEnt , int DEPTH, String Full_flag, String use_flag) throws  Exception{

		menuEnt.setDEPTH(DEPTH);
		
	    String sql =
        	"SELECT PG_GROUP_ID, 		\n"+ 
        	"        P_PG_GROUP_ID,  	\n"+
        	"        GROUP_NAME,     	\n"+
        	"        PG_GROUP_URL,   	\n"+
        	"        USE_YN,            \n"+
        	"        ORDER_SEQ         	\n"+
        	"FROM   PT_PG_GROUP  		\n"+
        	"WHERE  P_PG_GROUP_ID='"+menuEnt.getPG_GROUP_ID()+"'  \n";
	    
        if(use_flag.equals("Y")){//����ϴ� ���α׷� �׷츸  
            sql += " AND USE_YN = 'Y' \n";
        }     
        
        if(!CAPITAL.equals("S")){//�ý��� ������ �ϰ�츸 �ý��� �޴��� �����ش�. 
            sql += 
			    "  AND      P_PG_GROUP_ID != '"+Config.props.get("SYS_CODE")+"'             \n";  	        	
        }  

        sql += "ORDER BY ORDER_SEQ DESC                                \n"; 
        
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;
	    
	    rEntity = rDAO.select(sql);
	    
	    String low_menu_cds ="";//�����׷� �ڵ��  
	    String pg_low_cds ="";//���� ���α׷� �ڵ�� 
	    String gr_and_pg_low_cds ="";//���� �׷� �ڵ� | ���α׷� �ڵ��
	    String first_pg_url ="";//���� �޴�  ���α׷� �� ù��° �޴��� URL
	    String first_pg_cd ="";//���� �޴�  ���α׷� �� ù��° �޴��� �ڵ�

	    if (rEntity.getRowCnt()> 0) {
	    	Vector v_subMenuEnt =new Vector();
			 for (int i=0;i< rEntity.getRowCnt();i++ ){	    		 
				MenuEnt subMenuEnt = new MenuEnt();
				
				subMenuEnt.setPG_GROUP_ID(rEntity.getValue(i,"PG_GROUP_ID"));
				subMenuEnt.setGROUP_NAME(rEntity.getValue(i,"GROUP_NAME"));
				subMenuEnt.setP_PG_GROUP_ID(rEntity.getValue(i,"P_PG_GROUP_ID"));
				subMenuEnt.setPG_GROUP_URL(rEntity.getValue(i,"PG_GROUP_URL"));
				subMenuEnt.setUSE_YN(rEntity.getValue(i,"USE_YN"));
				subMenuEnt.setORDER_SEQ(rEntity.getValue(i,"ORDER_SEQ"));
				
				subMenuEnt = getMenuEnt(subMenuEnt , DEPTH+1, Full_flag, use_flag);
				v_subMenuEnt.add(i,subMenuEnt);
				
				//���� ���α׷� �ڵ��
				if(!KJFUtil.isEmpty(subMenuEnt.getPG_LOW_IDS())){
					pg_low_cds+=","+subMenuEnt.getPG_LOW_IDS();
					gr_and_pg_low_cds+=","+subMenuEnt.getGR_AND_PG_LOW_IDS();
					first_pg_url = subMenuEnt.getFIRST_PG_URL();
					first_pg_cd = subMenuEnt.getFIRST_PG_CD();
				}
				if(pg_low_cds.indexOf(",")==0){
					pg_low_cds =pg_low_cds.substring(1);
				}
				if(gr_and_pg_low_cds.indexOf(",")==0){
					gr_and_pg_low_cds =gr_and_pg_low_cds.substring(1);
				}				
				
				//�����׷� �ڵ� 
				low_menu_cds += rEntity.getValue(i,"PG_GROUP_ID");
				if(i+1 < rEntity.getRowCnt()) low_menu_cds += ",";
				 
			 }
	    	 	
	    	 menuEnt.setSubMenuEnt(v_subMenuEnt);
	    }
	    
	    menuEnt.setLOW_IDS(low_menu_cds);
	    
	    if(Full_flag.equals("Y")){
	    	
		    sql =
		    	"SELECT PG_ID,                                              \n"+ 
		    	"        PG_NAME,                                           \n"+
		    	"        PG_URL,                                            \n"+
		    	"        USE_YN,                                            \n"+
		    	"        ORDER_SEQ,                                         \n"+
		    	"        PG_GROUP_ID,                                        \n"+
		    	"        'N' AS READ_FLAG,                                        \n"+
		    	"        'N' AS PG_READ_FLAG                                        \n"+
		    	"FROM   PT_PG A                                               \n"+ 
		    	"WHERE PG_GROUP_ID  ='"+menuEnt.getPG_GROUP_ID()+"'         \n"+
		    	"    AND USE_YN='Y'                                         \n";
		    
	        if(QueryMode.equals("group_auth_pg")){//�׷캰 ���� ���� �׷� 
	            sql += 
				    "  AND      PG_ID IN (                                      \n"+
					"               SELECT DISTINCT(PG_ID) PG_ID                \n"+
					"               FROM   PT_AUTH_PG                           \n"+
					"               WHERE  AUTH_GROUP_CODE='"+CAPITAL+"'       \n"+
			        "           )                               \n";             	
	        } 
	        
	        if(QueryMode.equals("user_auth_pg")){//����ں� ����  ���� �׷� 
	            sql += 
				    "  AND      PG_ID IN (                                      \n"+
					"               SELECT DISTINCT(PG_ID) PG_ID                \n"+
					"               FROM   PT_AUTH_USER                         \n"+
					"               WHERE  USER_ID='"+USER_ID+"'       			\n"+
			        "           )                               \n";             	
	        }   	        
	        
	        
	        if(!CAPITAL.equals("S")&& QueryMode.equals("user_group_auth_pg")){//�α��ν� ���� ���� �׷� 
	            sql += 
                    " AND     (                                                                                              \n"+
                    "         PG_ID IN (SELECT DISTINCT(PG_ID) PG_ID FROM PT_AUTH_PG WHERE  AUTH_GROUP_CODE='"+CAPITAL+"') \n"+
                    "         OR                                                                                             \n"+
                    "         PG_ID IN (SELECT DISTINCT(PG_ID) PG_ID FROM PT_AUTH_USER WHERE  USER_ID='"+USER_ID+"')       \n"+
                    "         )                                                                            \n";	        	
	        }
	        	        
	        
	        sql += "ORDER BY ORDER_SEQ ASC                                \n";  
			
		    rEntity = rDAO.select(sql);

		    menuEnt.setPT_PGEnt(rEntity);
		    
		    //���� ���α׷� �ڵ�鼼�� 
		    for(int i=0;i< rEntity.getRowCnt();i++){
		    	if(i==0){
		    		first_pg_url =rEntity.getValue(i,"PG_URL");
		    		first_pg_cd =rEntity.getValue(i,"PG_ID");
		    	}
				pg_low_cds += ","+rEntity.getValue(i,"PG_ID");
				gr_and_pg_low_cds += ","+rEntity.getValue(i,"PG_GROUP_ID")+"|"+rEntity.getValue(i,"PG_ID");
		    }
			if(pg_low_cds.indexOf(",")==0){
				pg_low_cds =pg_low_cds.substring(1);
			}
			if(gr_and_pg_low_cds.indexOf(",")==0){
				gr_and_pg_low_cds =gr_and_pg_low_cds.substring(1);
			}
	    }// end if(Full_flag.equals("Y")){
	    
	    menuEnt.setFIRST_PG_URL(first_pg_url);
	    menuEnt.setFIRST_PG_CD(first_pg_cd);
	    menuEnt.setPG_LOW_IDS(pg_low_cds);
	    menuEnt.setGR_AND_PG_LOW_IDS(gr_and_pg_low_cds);
	    return menuEnt;
	}

	public static Vector getMenuEntList(Vector v_menuEntList, MenuEnt menuEnt ) throws  Exception{
		Vector v_subMenuEnt =menuEnt.getSubMenuEnt();
		
		if(!KJFUtil.isEmpty(v_subMenuEnt) ){
			for(int i=0; i < v_subMenuEnt.size();i++ ){
				v_menuEntList =getMenuEntList(v_menuEntList ,(MenuEnt)v_subMenuEnt.get(i));
			}
		}		
		v_menuEntList.add(menuEnt);
		
	    return v_menuEntList;
	}

	

	/** 
    * ���� ����� �޴�����Ʈ ���Ѻ���  �����´�.
    * param   String USER_ID, String CAPITAL
    * return   Vector
    */		
	
	public  Vector getUserMenuEntList(String USER_ID , String CAPITAL) throws  Exception{
        
		this.CAPITAL = CAPITAL;
		this.USER_ID = USER_ID;
		this.QueryMode="user_group_auth_pg";
		return getMenuEntList("0");
	
	}

	/** 
    * ���Ѻ� ���α׷��� �����´�.
    * param   String USER_ID, String CAPITAL
    * return   Vector
    */		
	
	public  Vector getAuthPgMenuEntList(String AUTH_GROUP_CODE ) throws  Exception{
        this.CAPITAL= AUTH_GROUP_CODE;
        this.QueryMode="group_auth_pg";
        
        
		return getMenuEntList("0");
	
	}	
	
	/** 
    * ���Ѻ� ���α׷��� �����´�.
    * param   String USER_ID, String CAPITAL
    * return   Vector
    */		
	
	public  Vector getAuthUserMenuEntList(String USER_ID ) throws  Exception{
        this.USER_ID= USER_ID;
        this.QueryMode="user_auth_pg";
        
        
		return getMenuEntList("0");
	
	}	
	
    /** 
    * ���� �׺���̼ǵ���  PG_ID�� ���� �´�.
    * param   String PG_GROUP_ID
    * return   Vector
    */	
	
	public String getPGName(String PG_ID ) throws  Exception{
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;       

	    String sql =	"SELECT PG_NAME             \n"+
				    	"FROM   PT_PG               \n"+ 
				    	"WHERE  PG_ID = '"+PG_ID+"' \n";
        
	    rEntity = rDAO.select(sql);                    	         
		
	    return rEntity.getValue(0,"PG_NAME");
	}
	
    /** 
    * ���� �׺���̼ǵ���  PG_GROUP_ID�� ���� �´�.
    * param   String PG_GROUP_ID
    * return   Vector
    */		
	public  String getPGGroupName( String PG_GROUP_ID) throws  Exception{
				
	    String sql =
        	"SELECT 					\n"+ 
        	"        GROUP_NAME     	\n"+
        	"FROM   PT_PG_GROUP  		\n"+
        	"WHERE  PG_GROUP_ID='"+PG_GROUP_ID+"'  \n";
	    
	    
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;
	
	    rEntity = rDAO.select(sql);
	 	    		 
	
	    return rEntity.getValue(0,"GROUP_NAME");
	
	}	
	
    /** 
    * ���� �׺���̼ǵ���  PG_ID�� ���� �´�.
    * param   String PG_GROUP_ID
    * return   Vector
    */	
	
	public String getNavisFromPgID(String PG_ID ) throws  Exception{
        
        String sql =
	    	"SELECT  PG_ID,                  \n"+ 
	    	"        PG_NAME,                \n"+
	    	"        PG_URL,                 \n"+
	    	"        USE_YN,                 \n"+
	    	"        ORDER_SEQ,              \n"+
	    	"        PG_GROUP_ID             \n"+
	    	"FROM   PT_PG                    \n"+ 
	    	"WHERE PG_ID  ='"+PG_ID+"'       \n";
        
        
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;       
        
	    rEntity = rDAO.select(sql);                    	         
        
        String totalNavis = " &gt; <a href='../"+rEntity.getValue(0,"PG_URL")+"&titPgId="+rEntity.getValue(0,"PG_ID")+"'>"+rEntity.getValue(0,"PG_NAME")+"</a>";
        totalNavis =getNavisFromPgGrID(totalNavis, rEntity.getValue(0,"PG_GROUP_ID") );	
		
	    return totalNavis;
	}
	
	
    /** 
    * ���� �׺���̼ǵ���  PG_GROUP_ID�� ���� �´�.
    * param   String PG_GROUP_ID
    * return   Vector
    */		
	public  String getNavisFromPgGrID(  String totalNavis,  String PG_GROUP_ID) throws  Exception{
				
	    String sql =
        	"SELECT PG_GROUP_ID, 		\n"+ 
        	"        P_PG_GROUP_ID,  	\n"+
        	"        GROUP_NAME,     	\n"+
        	"        PG_GROUP_URL,   	\n"+
        	"        USE_YN,            \n"+
        	"        ORDER_SEQ         	\n"+
        	"FROM   PT_PG_GROUP  		\n"+
        	"WHERE  PG_GROUP_ID='"+PG_GROUP_ID+"'  \n";
	    
	    
	    ReportDAO    rDAO        = new ReportDAO();
	    ReportEntity rEntity     = null;
	
	    rEntity = rDAO.select(sql);
	

	    if(rEntity.getRowCnt()>0){
	    	
	    	if(KJFUtil.isEmpty(rEntity.getValue(0,"PG_GROUP_URL"))){
	    		totalNavis =  " &gt; "+rEntity.getValue(0,"GROUP_NAME")  + totalNavis;
	    	} else{
	    		totalNavis =  " &gt; <a href='../"+rEntity.getValue(0,"PG_GROUP_URL")+"&titPgGrId="+rEntity.getValue(0,"PG_GROUP_ID")+"'>"+rEntity.getValue(0,"GROUP_NAME")+"</a>"  +totalNavis;
	    	}
			totalNavis = getNavisFromPgGrID(totalNavis ,rEntity.getValue(0,"P_PG_GROUP_ID"));
	    }	 	    		 
	
	    return totalNavis;
	
	}
	
	/** 
	    * PG_ID�� ���� ���α׷��� ������ Ȯ���Ѵ�.
	    * param   String PG_ID
	    * return  String
	    */	
		
		public String getPGAuth(HttpServletRequest request, String PG_ID ) throws  Exception{
		    String read_flag = "";
		    
			ReportDAO    rDAO        = new ReportDAO();
		    ReportEntity rEntity     = null;       
		    
		    UserEnt user = (UserEnt)request.getSession().getAttribute("user");
	    	
	    	if(user!=null){
	    		if(!user.getUSER_ID().equals(Config.props.get("SYS_ID"))){
	    			String sql =	"	SELECT 						\n	" +
                    "           CASE                \n  " +
                    "               WHEN AU_READ_FLAG='Y' AND (AP_READ_FLAG='N' OR AP_READ_FLAG IS NULL) THEN 'Y'   \n  " +
                    "               WHEN AU_READ_FLAG='Y' AND AP_READ_FLAG='Y' THEN 'Y' \n  " +
                    "               WHEN AU_READ_FLAG IS NULL AND AP_READ_FLAG='Y' THEN 'Y' \n  " +
                    "           ELSE 'N'    \n  " +
                    "           END READ_FLAG   \n  " +
                    "   FROM    \n  " +
                    "   (   \n  " +
                    "       SELECT          \n  " +
                    "              (SELECT READ_FLAG FROM PT_AUTH_USER WHERE USER_ID='"+user.getUSER_ID()+"' AND PG_ID=A.PG_ID) AU_READ_FLAG,   \n  " +
                    "              (SELECT READ_FLAG FROM PT_AUTH_PG WHERE AUTH_GROUP_CODE='"+user.getCAPITAL()+"' AND PG_ID=A.PG_ID) AP_READ_FLAG      \n  " +
                    "       FROM   PT_PG A  \n  " +
                    "       WHERE  PG_ID IN ((SELECT DISTINCT(PG_ID) PG_ID FROM PT_AUTH_PG WHERE  AUTH_GROUP_CODE='"+user.getCAPITAL()+ "' AND PG_ID='"+PG_ID+"'))  \n  " +
                    "           OR  \n  " +
                    "              PG_ID IN ((SELECT DISTINCT(PG_ID) PG_ID FROM PT_AUTH_USER WHERE  USER_ID='"+user.getUSER_ID()+"' AND PG_ID='"+PG_ID+"')) \n  " +
                    "   )            \n";
		
	    			rEntity = rDAO.select(sql);
	    			read_flag = rEntity.getValue(0,"READ_FLAG");
	    		}else{
	    			read_flag = "N";
	    		}
	    	}

		    return read_flag;
		}
	
    public static  void setTitleNavi(HttpServletRequest request) throws  Exception{
    	
    	String titleNavi	="";
    	String menuTitle	="";
    	String menuAUTH		="";
    	
    	String PG_ID= KJFUtil.print(request.getParameter("titPgId"));
    	String PG_GROUP_ID= KJFUtil.print(request.getParameter("titPgGrId"));
    	
    	SysWorker worker =new SysWorker();
    	
    	if(!KJFUtil.isEmpty(PG_ID)){   		
    		titleNavi = worker.getNavisFromPgID(PG_ID);
    		menuTitle = worker.getPGName(PG_ID);
    		menuAUTH = worker.getPGAuth(request,PG_ID);
    	}

    	if(!KJFUtil.isEmpty(PG_GROUP_ID)){   		
    		titleNavi = worker.getNavisFromPgGrID("", PG_GROUP_ID);
    		menuTitle = worker.getPGGroupName(PG_GROUP_ID);
    	}    	
    	
    	request.setAttribute("titleNavi",titleNavi);
    	request.setAttribute("menuTitle",menuTitle);
    	request.setAttribute("menuAUTH",menuAUTH);
        
        return;
    }   	
    
//    public static void setAuthUserTemp(){
//    	
//    }
//    
//    public static void setAuthPgTemp(){
//    	
//    }

//    /**
//     * ���Ѻ� ���α׷� �� ����ڰ��� �ӽ����̺� ������ �ε�
//     * @param HttpServletRequest
//     * @return
//     */
//        
//	public  int setTempTable(String menu) throws  Exception{
//		
//		int result = 0;
//	    String sql = null;
//	    ReportDAO    rDAO        = new ReportDAO();
//	    
//		if(menu.equals("group_auth_pg")){
//			sql = "DELETE FROM PT_AUTH_PG_TEMP";
//		} else if(menu.equals("user_auth_pg")){
//			sql = "DELETE FROM PT_AUTH_USER_TEMP";
//		}
//		
//	    result = rDAO.execute(sql);
//	 	    		 
//		
//		if(menu.equals("group_auth_pg")){
//			sql = "INSERT INTO PT_AUTH_PG_TEMP VALUE(SELECT * FROM PT_AUTH_PG)";
//		} else if(menu.equals("user_auth_pg")){
//			sql = "INSERT INTO PT_AUTH_USER_TEMP VALUE(SELECT * FROM PT_AUTH_USER)";
//		}
//	    
//		result = rDAO.execute(sql);
//	
//	    return result;
//	
//	} 

}
