package sp.util.keng;

import kjf.cfg.Config;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;
import sp.webservice.UBAgentPortTypeProxy;

public class KengWorker {
	
	//private String url = "http://211.34.100.185:8080/iccsWs/services/UBAgent";
	//private String url = "http://118.37.186.201/iccsWs/services/UBAgent";
	private String url = Config.props.get("KICA_ENDPOINT");
	
	public  Kengineer[] getKengs(String[] sSSN) throws Exception{		
		
		Kengineer kengs[]= null;
		String key= KJFSec.encode("kica");
		
		UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(url);
		String tmpSSn="";
		
		
        if(KJFUtil.isEmpty(sSSN)){
        	throw new Exception("조회할 주민번호가 없습니다.");
        }
         
        for(int i=0; i< sSSN.length;i++ ){
        	tmpSSn += "'"+sSSN[i]+"',";
        }
        
        tmpSSn = tmpSSn.substring(0, tmpSSn.length()-1);
	    String sql =
	    	"SELECT	SNM_KOR,     \n"+ 
	    	"	SSSN,        \n"+
	    	"	SGRADE,      \n"+
	    	"	STMP_GRADE,  \n"+
	    	"	SBOOK_NUM,   \n"+
	    	"	SDEU_DT,     \n"+
	    	"	SS_DT,       \n"+
	    	"	SE_DT,       \n"+ 
	    	"	SCORP,'' as temp  \n"+
	    	"FROM Cengineer_Return   \n"+
	    	"WHERE SSSN in ("+tmpSSn+")        \n";
        
	   /* 이름                            Null?    유형
	    		------------------------------- -------- ----
	    		SNM_KOR                                  CHAR(10)
	    		SSSN                            NOT NULL CHAR(13)
	    		SGRADE                                   CHAR(4)
	    		STMP_GRADE                               VARCHAR2(40)
	    		SBOOK_NUM                                CHAR(15)
	    		SDEU_DT                                  DATE
	    		SS_DT                                    DATE
	    		SE_DT                                    VARCHAR2(0)
	    		SCORP                                    VARCHAR2(6)
	    		*/
	    
	    String s_result[]=ub.select(key, sql);
    	String resultFlag=s_result[0];
    	String kica_data=s_result[1];
    	
    	if(resultFlag.equals("0") && KJFUtil.isEmpty(kica_data)){
    		return null;
    	}
    	
    	String rows[] =KJFUtil.str2strs(kica_data, "!#$");

    	// 2010.01.15. 모두 잘못된 주민번호라면 결과가 널 일 수 있다.
    	if( rows == null )
    		return null;
    	
    	kengs = new Kengineer[rows.length];
    	
    	for(int i=0;i < rows.length ;i++ ){
    		String attrs[] =rows[i].split("\t",9);
    		Kengineer keng = new Kengineer();
    		keng.setNM_KOR(attrs[0]);    		
    		keng.setSSN(attrs[1]);
    		keng.setGRADE(attrs[2]);
    		keng.setTMP_GRADE(attrs[3]);
    		keng.setBOOK_NUM(attrs[4]);
    		keng.setEDU_DT(attrs[5]);
    		keng.setS_DT(attrs[6]);
    		keng.setE_DT(attrs[7]);
    		keng.setCORP(attrs[8]);    		
    		kengs[i]=keng;
    	}   	    	
	    
		
		
    	return kengs;	
	}

	public  Kengineer[] getKengsName(String[] sNM_KOR) throws Exception{
		
		Kengineer kengs[]= null;
		String key= KJFSec.encode("kica"); 
		
		UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(url);
		String tmpNM_KOR="";
		
		
        if(KJFUtil.isEmpty(sNM_KOR)){
        	throw new Exception("조회할 성명이(가) 없습니다.");
        }
        
        for(int i=0; i< sNM_KOR.length;i++ ){
        	tmpNM_KOR += "'"+sNM_KOR[i]+"',";
        }
        
        tmpNM_KOR = tmpNM_KOR.substring(0, tmpNM_KOR.length()-1);
        
	    String sql =
	    	"SELECT	SNM_KOR,     \n"+ 
	    	"	SSSN,        \n"+
	    	"	SGRADE,      \n"+
	    	"	STMP_GRADE,  \n"+
	    	"	SBOOK_NUM,   \n"+
	    	"	SDEU_DT,     \n"+
	    	"	SS_DT,       \n"+
	    	"	SE_DT,       \n"+ 
	    	"	SCORP,'' as temp  \n"+
	    	"FROM Cengineer_Return   \n"+
	    	"WHERE SNM_KOR in ("+tmpNM_KOR+")        \n";
        
	   /* 이름                            Null?    유형
	    		------------------------------- -------- ----
	    		SNM_KOR                                  CHAR(10)
	    		SSSN                            NOT NULL CHAR(13)
	    		SGRADE                                   CHAR(4)
	    		STMP_GRADE                               VARCHAR2(40)
	    		SBOOK_NUM                                CHAR(15)
	    		SDEU_DT                                  DATE
	    		SS_DT                                    DATE
	    		SE_DT                                    VARCHAR2(0)
	    		SCORP                                    VARCHAR2(6)
	    		*/
	    
	    String s_result[]=ub.select(key, sql);
    	String resultFlag=s_result[0];
    	String kica_data=s_result[1];
    	
    	if(resultFlag.equals("0") && KJFUtil.isEmpty(kica_data)){
    		return null;
    	}
    	
    	String rows[] =KJFUtil.str2strs(kica_data, "!#$");

    	if( rows == null )
    		return null;
    	
    	kengs = new Kengineer[rows.length];
    	
    	for(int i=0;i < rows.length ;i++ ){
    		String attrs[] =rows[i].split("\t",9);
    		Kengineer keng = new Kengineer();
    		keng.setNM_KOR(attrs[0]);    		
    		keng.setSSN(attrs[1]);
    		keng.setGRADE(attrs[2]);
    		keng.setTMP_GRADE(attrs[3]);
    		keng.setBOOK_NUM(attrs[4]);
    		keng.setEDU_DT(attrs[5]);
    		keng.setS_DT(attrs[6]);
    		keng.setE_DT(attrs[7]);
    		keng.setCORP(attrs[8]);    		
    		kengs[i]=keng;
    	}   	    	
	    
		
		
    	return kengs;	
	}
	
}
