package kjf.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kjf.cfg.Config;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.CommonsMultipartRequestHandler;
import org.apache.struts.upload.FormFile;


/**
 * <p>Subsystem		:  </p>
 * <p>Title			: 기본적인 파일 유틸함수 </p>
 * <p>Description	: 기본적인 파일 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE		: </p>
 * @author 김경덕
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFFile {

	public  static String FILE_S	= File.separator;


	/**
    * 파일이 존재하는지 확인한다.<p>
    *@ param path 파일패스<p>
    *@ param filename 파일이름<p>
    *@ return true:파일존재,false:파일없음<p>
    */
    public static boolean existFile(String path, String filename)
    {
        boolean i =false;

        try
        {
            File f = new File(path, filename);
            i = f.exists();
        }
        catch(Exception e)
        {
            i = false;
        }
        return i;
    }

	 /**
     * 금지 파일 체크
     *
     * @param strFileName   파일명.
     * @return              파일명
     */
	public static  void checkNotFile(String strFileName ) throws  Exception {

		String notFileList[] = KJFUtil.str2strs(Config.props.get("NOT_FILE_LIST"),"/");
		
		if(notFileList !=null){
			for(int i=0 ; i < notFileList.length ; i++){
				if(getFileExt(strFileName).equalsIgnoreCase(notFileList[i].trim())){
					throw new MsgException("파일의 확장자가 "+notFileList[i]+"인 파일은 업로드가 금지됩니다.");
				}
			}
		}
    }

	/**
     * 파일 저장
     *
     * @param strFileName   파일명.
     * @return              파일명
    */
	public static  void saveFile(String filPath, String fileName,  InputStream in ) throws  Exception {

		//디렉토리 없을 시 생성.
		dirMake(filPath);

		File file= new File(filPath + fileName);
		OutputStream os = new BufferedOutputStream(new FileOutputStream(file));

		int i;
		byte[] buffer = new byte[1024*4];

		while((i=in.read(buffer)) > -1){
			os.write(buffer, 0, i);
		}

		os.close();
		in.close();
    }

	 /**
     * 파일 삭제
     *
     * @param String filPath, String fileNames[]
     * @return              파일명
     */
	public static  void deleteFile(String filPath, String fileNames[] ) throws  Exception {

        //file delete
        if(fileNames!= null){
            File delFile= null;
            //파일지우기
            for(int i=0;i<fileNames.length;i++){
                delFile= new File(filPath+fileNames[i]);
                delFile.delete();
            }
        }//end if(fileNames!= null)

    }


	 /**
     * 파일 삭제
     *
     * @param String filPath, String fileName
     * @return              파일명
     */
	public static  void deleteFile(String filPath, String fileName ) throws  Exception {

        if (!KJFUtil.isEmpty(fileName)) {
            File delFile= null;
            //파일지우기
            delFile= new File(filPath+fileName);
            delFile.delete();

        }
    }


	 /**
     * 파일 삭제
     *
     * @param String fullPathWithFileName
     * @return              파일명
     */
	public static  void deleteFile( String  fullPathWithFileName ) throws  Exception{

        //file delete
        if(!KJFUtil.isEmpty(fullPathWithFileName)){
            File delFile= null;
            //파일지우기
            delFile= new File(fullPathWithFileName);
            delFile.delete();

        }//end if(fileNames!= null)

    }
	
	/**
	 * 파일사이즈
	 * @param filesize long
	 * @return String
	 * @throws Exception
	 */
	public  static String fileSize(long filesize) throws  Exception{
      DecimalFormat df = new DecimalFormat(".##");
	  String fSize="";
      try{
		if ((filesize > 1024) && (filesize < 1024 * 1024)) {
			fSize = df.format((float)filesize/1024).toString() + " KB" ;
		} else if (filesize >= 1024 * 1024) {
			fSize = df.format((float)filesize/(1024*1024)).toString() + " MB" ;
		} else {
			fSize = Long.toString(filesize) + " B" ;
		}
	  }catch(Exception e){
          System.out.println(e);
	  }
      return fSize;
	}


	/**
	 * 파일 이동
	 * @param from File
	 * @param to File
	 * @throws Exception
	 */
	public static void moveFile(File from, File to) throws  Exception {

		int fileSize= new Long(from.length()).intValue(); //bytes
		FileInputStream fis= new FileInputStream(from);
		FileOutputStream fos= new FileOutputStream(to);

		int a=0, j = 0;
		byte[] b= new byte[1024];
		
		while(j < fileSize) {
			a= fis.read(b);
			fos.write(b,0,a);
			j+=a;
		}

		fos.close();
		fis.close();
		from.delete();
	}


	/**
	 * 파일 복사
	 * @param from File
	 * @param to File
	 * @throws Exception
	 */
	public static void copyFile(File from, File to) throws  Exception{

		int fileSize= new Long(from.length()).intValue(); //bytes
		FileInputStream fis= new FileInputStream(from);
		FileOutputStream fos= new FileOutputStream(to);

		int a=0, j=0;
		byte[] b= new byte[1024];
		while(j<fileSize){
			a= fis.read(b);
			fos.write(b,0,a);
			j+=a;
		}

		fos.close();
		fis.close();



	}


	/**
	 * 디렉토리 체크
	 * @param strpath String
	 * @throws Exception
	 */
	public static void dirMake(String strpath) throws  Exception {
		File file=new File(strpath);
		if(!file.exists()) file.mkdir();
	}


	/**
	 * 디렉토리 만들기
	 * @param strpath String
	 * @throws Exception
	 */
	public static void fullDirMake(String strpath) throws  Exception{
		System.out.println("strpath:"+strpath);
		if(new File(strpath).exists()) return;

		String dir[]=KJFUtil.str2strs(strpath, FILE_S);
        String ls_makeDir="";
        if (dir!=null && dir.length > 0){
            for (int i=0;i< dir.length ; i++ ){
                if (i==0){
                    ls_makeDir =dir[i]+FILE_S;
                    continue;
                }

                ls_makeDir += dir[i]+FILE_S;
                dirMake(ls_makeDir);
            }
        }
	}



    /**
     * 파일명을 인수로 받아서 파일의 확장자를 리턴한다.
     *
     * @param strFileName   파일명.
     * @return              파일의 확장자
     */
    public static  String getFileExt(String strFileName) throws  Exception{
        int index = strFileName.lastIndexOf(".");
        if(index == -1) return "";

        return strFileName.substring(index+1);
    }


	 /**
     * 파일명의 유효성 검사하여 replace
     *
     * @param strFileName   파일명.
     * @return              파일명
     */
    public static  String getFileNameRep(String strFileName)  throws  Exception{
        int index = strFileName.lastIndexOf(".");
        String tmpFileName = "";
        String tmpExtName = "";
        System.out.println(strFileName);
        if(index == -1){
        	tmpFileName = strFileName;
        	tmpExtName = "";

        }else{
        	tmpFileName = strFileName.substring(0,index);
        	tmpExtName = strFileName.substring(index);
        }

        String result = tmpFileName.replaceAll(":","_");
        result = result.replaceAll(";","_");
        result = result.replaceAll("/","_");
        result = result.replaceAll("`","_");
        result = result.replaceAll("\\?","_");
        result = result.replaceAll("<","_");
        result = result.replaceAll(">","_");
        result = result.replaceAll("\\.","_");

        result = result+tmpExtName;

        return result;
    }

    
    /**
     * 파일 업로드
     * @param request  HttpServletRequest
     * @param form     ActionForm
     * @param fileSize int
     * @param path     String
     * @return Vector
     * @throws Exception
     */
    public static Vector FileLoad(HttpServletRequest request, ActionForm form, int fileSize, String path)throws Exception{

		KJFLog.log("============파일 업로드 시작 ================");

		Vector vfiles = new Vector();
		int size_Of_Files = 0;
		String FILE_REAL_NAME="";
		String FILE_SYS_NAME="";
		long currentUID = 0;
		long baseUID = System.currentTimeMillis();
		UploadFile FILES_VALUE = null;

		CommonsMultipartRequestHandler parser = (CommonsMultipartRequestHandler)form.getMultipartRequestHandler();

		java.util.Hashtable file_elements = parser.getFileElements();
		java.util.Enumeration keys = file_elements.keys();

		while(keys.hasMoreElements()){

			String key = (String)keys.nextElement();
			FormFile file = (FormFile)file_elements.get(key);

			if(!KJFUtil.isEmpty(file.getFileName())){

				//파일이 여러게 올라갈시... 파일이름 중복 방지
				synchronized ("kjf.util.KJFFile"){
					currentUID = baseUID++;
				}

				FILE_REAL_NAME=file.getFileName();
				FILE_SYS_NAME=currentUID+FILE_REAL_NAME.substring(FILE_REAL_NAME.lastIndexOf("."), FILE_REAL_NAME.length());

				if(file != null  && !KJFUtil.isEmpty(FILE_SYS_NAME)){
					size_Of_Files += file.getFileSize();
					//금지파일 검사
					KJFFile.checkNotFile(FILE_SYS_NAME);
				}

				if( size_Of_Files  > 1024 * 1024 * fileSize){
					throw new MsgException("파일 용량이 "+fileSize+"M 를 초과 하였습니다.");
				}

				if ( file != null  && !KJFUtil.isEmpty(FILE_SYS_NAME) ){

					//디렉토리 생성
					//if(new File(path).exists()){new File(path).mkdir();}
					dirMake(path);

					FILES_VALUE = new UploadFile();

					//실제 파일 저장
					KJFFile.saveFile(path+KJFFile.FILE_S  , FILE_SYS_NAME,  file.getInputStream() );
					FILES_VALUE.setSYS_FILE_NAME(FILE_SYS_NAME);
					FILES_VALUE.setFILE_REAL_NAME(FILE_REAL_NAME);
					FILES_VALUE.setFilesize(file.getFileSize());

					vfiles.add(FILES_VALUE);
					KJFLog.log(path+FILE_SYS_NAME);
				}
			}
		}

		KJFLog.log("============파일 업로드 종료 ================");

		return vfiles;
	}
    
    
    /**
     * 다운로드파일명을 인수로 받아서 파일의 확장자를 리턴한다.
     *
     * @param strFileName   파일명.
     * @return              파일의 확장자
     */
    public static  String getDownFileExt(String strFileName) throws  Exception{
        int index = strFileName.lastIndexOf(".");
        if(index == -1) return "";
        
        String ext = strFileName.substring(index+1);
        
        if (ext.equals("zip") || ext.equals("ZIP")) { return "zip"; }
        else if (ext.equals("mp3") || ext.equals("MP3")) { return "mp3"; }
        else if (ext.equals("doc") || ext.equals("DOC")) { return "doc"; }
        else if (ext.equals("htm") || ext.equals("HTM")) { return "htm"; }
        else if (ext.equals("rar") || ext.equals("RAR")) { return "RAR"; }
        else if (ext.equals("exe") || ext.equals("EXE")) { return "exe"; }
        else if (ext.equals("hwp") || ext.equals("HWP")) { return "hwp"; }
        else if (ext.equals("txt") || ext.equals("TXT")) { return "txt"; }
        else if (ext.equals("jpg") || ext.equals("JPG")) { return "jpg"; }
        else if (ext.equals("gif") || ext.equals("GIF")) { return "gif"; }
        else if (ext.equals("bmp") || ext.equals("BMP")) { return "bmp"; }
        else if (ext.equals("xls") || ext.equals("XLS")) { return "xls"; }
        else if (ext.equals("ppt") || ext.equals("PPT")) { return "ppt"; }
        else if (ext.equals("asf") || ext.equals("ASF")) { return "asf"; }
        else if (ext.equals("alz") || ext.equals("ALZ")) { return "alz"; }
        else if (ext.equals("ai") || ext.equals("AI"))  { return "ai"; }
        else if (ext.equals("asp") || ext.equals("ASP")) { return "asp"; }
        else if (ext.equals("cgi") || ext.equals("CGI")) { return "cgi"; }
        else if (ext.equals("eml") || ext.equals("EML")) { return "eml"; }
        else if (ext.equals("hlp") || ext.equals("HLP")) { return "hlp"; }
        else if (ext.equals("js") || ext.equals("JS"))  { return "js"; }
        else if (ext.equals("mid") || ext.equals("MID")) { return "mid"; }
        else if (ext.equals("mpeg") || ext.equals("MPEG")){ return "mpeg"; }
        else if (ext.equals("pcx") || ext.equals("PCX")) { return "pcx"; }
        else if (ext.equals("pdf") || ext.equals("PDF")) { return "pdf"; }
        else if (ext.equals("php3") || ext.equals("PHP3")){ return "php3"; }
        else if (ext.equals("png") || ext.equals("PNG")) { return "png"; }
        else if (ext.equals("psd") || ext.equals("PSD")) { return "psd"; }
        else if (ext.equals("reg") || ext.equals("REG")) { return "reg"; }
        else if (ext.equals("swf") || ext.equals("SWF")) { return "swf"; }
        else if (ext.equals("tif") || ext.equals("TIF")) { return "tif"; }
        else if (ext.equals("fla") || ext.equals("FLA")) { return "fla"; }
        else if (ext.equals("wsz") || ext.equals("WSZ")) { return "wsz"; }
        else if (ext.equals("ttf") || ext.equals("TTF")) { return "ttf"; }
        else if (ext.equals("fon") || ext.equals("FON")) { return "fon"; }
        else if (ext.equals("wmv") || ext.equals("WMV")) { return "wmv"; }
        else if (ext.equals("avi") || ext.equals("AVI")) { return "avi"; }
        else return "txt";
    }
    
    /**
     * File 을  byte[]로 변환
     *
     * @param File lFile   
     * @return  byte[]
     */    
    public static byte[] readFromFile(File lFile){
        byte[] lDataBytes = null;
        try{
             FileInputStream lFileInputStream = new FileInputStream(lFile);
             lDataBytes = readFromStream(lFileInputStream);
             lFileInputStream.close();
        }catch (Throwable e){
             e.printStackTrace(System.out);
        }
        return lDataBytes;
    }

    /**
     * InputStream 을  byte[]로 변환
     *
     * @param InputStream pInputStream   
     * @return  byte[]
     */     
    private static byte[] readFromStream(InputStream pInputStream) {
        if (pInputStream == null) {
            return null;
        }

        int lBufferSize = 1024;
        byte[] lByteBuffer = new byte[lBufferSize];

        int lBytesRead = 0;
        int lTotbytesRead = 0;
        int lCount = 0;

        ByteArrayOutputStream lByteArrayOutputStream = new ByteArrayOutputStream(lBufferSize * 2);

        try {
            while ((lBytesRead = pInputStream.read(lByteBuffer)) != -1) {
                lTotbytesRead += lBytesRead;
                lCount++;

                lByteArrayOutputStream.write(lByteBuffer, 0, lBytesRead);
            }
        } catch (Throwable e) {
            e.printStackTrace(System.out);
        }

        byte[] lDataBytes = lByteArrayOutputStream.toByteArray();

        return lDataBytes;
    }

    
    
}
