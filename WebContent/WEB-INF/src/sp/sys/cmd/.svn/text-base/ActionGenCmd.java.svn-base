/**
 * 파일명   : ActionGenCmd.java 
 * 설명     : 리스트 cmd  
 * 이력사항
 * CH00     :2006/04/19 김경덕 최초작성 
 */

package sp.sys.cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.util.KJFFile;
import kjf.util.MsgException;

import org.apache.struts.action.ActionForm;

public class ActionGenCmd implements KJFCommand {


	private String next;
	
    public ActionGenCmd() {
    }
    
    public ActionGenCmd(String next_url) {
    	next = next_url; 
    }



    public String execute(HttpServletRequest request, ActionForm form) throws Exception {
    	
    	String folderNm =request.getParameter("folderNm");
    	

        
        if(folderNm == null){        	
        	return next;
        }
        
        
  
        

        String PACKAGENAME=Config.props.get("PACKAGENAME");
        String PROJECT_ROOT=Config.props.get("PROJECT_ROOT");
        String Gen_dir = PROJECT_ROOT+"WEB-INF"+KJFFile.FILE_S+"src"+KJFFile.FILE_S+PACKAGENAME+KJFFile.FILE_S+folderNm;
        
        String cmd_dir = Gen_dir+KJFFile.FILE_S+"cmd";
        String templet_dir = PROJECT_ROOT+"WEB-INF"+KJFFile.FILE_S+"templet"+KJFFile.FILE_S;
        

        
		File file=new File(Gen_dir);
		
		if(file.exists()) {
			throw new MsgException("이미 폴더가 존재 합니다.");
		} else{
			file.mkdir();
		}
		
		KJFFile.dirMake(cmd_dir);
		
		
		
		
		String modul= folderNm.substring(0,1).toUpperCase() + folderNm.substring(1);
		String subPkg = folderNm.toLowerCase();
		
		
		////////////////////////////Action///////////////////////////
		
		String Action_templet = templet_dir+ "Action";
		
		FileInputStream Action_fis= new FileInputStream(Action_templet);
		
		String act_type = request.getParameter("MiChk");
		String kjfAct = "KJFAction";
		if("Y".equals(act_type)){
			kjfAct = "KJFMiAction";
		}
		
		
		
		byte[] Action_b = null;
		int Action_i=0;
		while((Action_i=Action_fis.available())>0){
			Action_b = new byte[Action_i];
			if(Action_fis.read(Action_b) == -1) break;
		}
		
		Action_fis.close();
		
		String s_Action = new String(Action_b).replaceAll("-modul-",modul).replaceAll("-subPkg-",subPkg).replaceAll("-kjfAct-",kjfAct);
		
		String Action_java =Gen_dir+KJFFile.FILE_S+modul+"Action.java";
		
		PrintWriter Action_Writer= null;
		
		if(!new File(Action_java).exists())	new FileOutputStream(Action_java);				
		Action_Writer = new PrintWriter(new FileWriter(Action_java, true), true);
		
		Action_Writer.print(s_Action);
		
		Action_Writer.close();
		
		
		
		
		
		////////////////////////////Param///////////////////////////
		
		String Param_templet = templet_dir+ "Param";
		
		FileInputStream Param_fis= new FileInputStream(Param_templet);
		
		byte[] Param_b = null;
		int Param_i=0;
		while((Param_i=Param_fis.available())>0){
			Param_b = new byte[Param_i];
			if(Param_fis.read(Param_b) == -1) break;
		}
		
		Param_fis.close();
		
		String s_Param = new String(Param_b).replaceAll("-modul-",modul).replaceAll("-subPkg-",subPkg);
		
		String Param_java =Gen_dir+KJFFile.FILE_S+modul+"Param.java";
		
		PrintWriter Param_Writer= null;
		
		if(!new File(Param_java).exists())	new FileOutputStream(Param_java);				
		Param_Writer = new PrintWriter(new FileWriter(Param_java, true), true);
		
		Param_Writer.print(s_Param);
		
		Param_Writer.close();
		
		
		
		
		
		////////////////////////////Worker///////////////////////////
		
		String Worker_templet = templet_dir+ "Worker";
		
		FileInputStream Worker_fis= new FileInputStream(Worker_templet);
		
		byte[] Worker_b = null;
		int Worker_i=0;
		while((Worker_i=Worker_fis.available())>0){
			Worker_b = new byte[Worker_i];
			if(Worker_fis.read(Worker_b) == -1) break;
		}
		
		Worker_fis.close();
		
		String s_Worker = new String(Worker_b).replaceAll("-modul-",modul).replaceAll("-subPkg-",subPkg);
		
		String Worker_java =Gen_dir+KJFFile.FILE_S+modul+"Worker.java";
		
		PrintWriter Worker_Writer= null;
		
		if(!new File(Worker_java).exists())	new FileOutputStream(Worker_java);				
		Worker_Writer = new PrintWriter(new FileWriter(Worker_java, true), true);
		
		Worker_Writer.print(s_Worker);
		
		Worker_Writer.close();
		
		
		
		
		////////////////////////////Jsp///////////////////////////
		String Jsp_templet = templet_dir+ "Jsp";
		
		FileInputStream Jsp_fis= new FileInputStream(Jsp_templet);
		
		byte[] Jsp_b = null;
		int Jsp_i=0;
		while((Jsp_i=Jsp_fis.available())>0){
			Jsp_b = new byte[Jsp_i];
			if(Jsp_fis.read(Jsp_b) == -1) break;
		}
		
		Jsp_fis.close();
		
		String s_Jsp = new String(Jsp_b).replaceAll("-modul-",modul).replaceAll("-subPkg-",subPkg);
		
		String Jsp_java =Gen_dir+KJFFile.FILE_S+modul+"Jsp.java";
		
		PrintWriter Jsp_Writer= null;
		
		if(!new File(Jsp_java).exists())	new FileOutputStream(Jsp_java);				
		Jsp_Writer = new PrintWriter(new FileWriter(Jsp_java, true), true);
		
		Jsp_Writer.print(s_Jsp);
		
		Jsp_Writer.close();
		
		
		
        
        String result= Gen_dir+" 에 \n 정상적으로 Action, Worker, Param, Jsp 파일이 만들어 졌습니다.";
        

        
        

        request.setAttribute("result", result);
              
        
        return next;
    }
    
    
    

}

