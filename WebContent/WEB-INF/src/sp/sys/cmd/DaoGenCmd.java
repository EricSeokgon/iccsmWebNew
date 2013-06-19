/**
 * 파일명   : DaoGenCmd.java 
 * 설명     : 리스트 cmd  
 * 이력사항
 * CH00     :2006/04/19 김경덕 최초작성 
 */

package sp.sys.cmd;

import java.io.FileReader;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.tools.ocr.xgen.DBToXML;
import kjf.util.KJFFile;
import kjf.util.KJFSelectOPS;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

public class DaoGenCmd implements KJFCommand {


	private String next;
	
    public DaoGenCmd() {
    }
    
    public DaoGenCmd(String next_url) {
    	next = next_url; 
    }
 


    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String TABLE_CD =request.getParameter("TABLE_CD");
    	
	
        //검색조건 및 초기데이타 로드
        //loadCondition(request);
        
        if(TABLE_CD == null){        	
        	return next;
        }
        
        
        new DBToXML().excute(TABLE_CD);
        


        String JAVA_HOME=Config.props.get("JAVA_HOME");

        String LIBDIR=Config.props.get("PROJECT_ROOT")+"WEB-INF"+KJFFile.FILE_S+"lib"+KJFFile.FILE_S+"daoGen_lib"+KJFFile.FILE_S;
        String XMLDIR = Config.props.get("PROJECT_ROOT")+"WEB-INF"+KJFFile.FILE_S+"src"+KJFFile.FILE_S+"sp"+KJFFile.FILE_S+"dao"+KJFFile.FILE_S+"xml"+KJFFile.FILE_S;
        String BUILDXML=XMLDIR+"build.xml";
        String LOGFILE=XMLDIR+"build.log";
        String LOCALCLASSPATH=LIBDIR+"tools.jar;"+LIBDIR+"servlet-api.jar;"+LIBDIR+"ant.jar;"+LIBDIR+"ant-launcher.jar;"+LIBDIR+"xerces-1.2.3.jar;"+LIBDIR+"xalan-2.0.0.jar;"+LIBDIR+"kjf-Xslt.jar";



        String cmdline = JAVA_HOME+"bin"+KJFFile.FILE_S+"java  " +
        		"-D -classpath "+LOCALCLASSPATH+
        		";"+LOCALCLASSPATH+
        		" org.apache.tools.ant.Main  -buildfile "+BUILDXML+" -logfile "+LOGFILE ;
        
        
        
       // KJFFile.deleteFile(LOGFILE);

        Runtime runtime = Runtime.getRuntime();
        Process process = null; 
        process = runtime.exec(cmdline);
        

        process.waitFor();
        
        FileReader in =new FileReader(LOGFILE);
        
        String result= "";
        
        int c;
        while ((c=in.read())!=-1)
        	 result=result+(char) c;
  
        in.close();
        
        

        request.setAttribute("result", result);       
              
        
        return next;
    }
    
    
    
    /**
     * 검색조건 및 초기데이타 로드
     * @param HttpServletRequest
     * @return
     */
    private void loadCondition(HttpServletRequest request)throws Exception{
    	
    	String sql="select TNAME CODE, TNAME   from tab   where length(TNAME)  < 30 ";

		Vector v_TABLE 	= new Vector();
		
		v_TABLE = KJFSelectOPS.getSel(sql, "ALL","ALL");
		request.setAttribute("v_TABLE", v_TABLE);   
		
         
       
    }//end loadCondition


 
    
    


}