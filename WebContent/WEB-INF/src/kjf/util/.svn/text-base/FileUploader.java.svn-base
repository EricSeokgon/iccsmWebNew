package kjf.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kjf.cfg.Config;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * <p>Title         : 파일업로드 유틸함수 </p>
 * <p>Description   : 파일업로드 유틸함수를 구현하여 제공. </p>
 * ex)
 * FileUploader fileUploader = new FileUploader(request, "C:\\", 1024*1024*3);
 * Map fileMap = fileUploader.getParamAfterUpload();
 * 
 * @author 오두식
 * @version 1.0
 */
public class FileUploader {

    private HttpServletRequest request = null;
    private File uploadDir = null;
    private List items = null;
    private Map paramMap = null;
    private long requestLimit = Config.props.getLogn("MAX_UPLOAD_SIZE_M")*1024*1024; //한번에 업로드 용량은 기본 100메가
    private long fileLimit = Config.props.getLogn("MAX_FILE_UPLOAD_SIZE_M")*1024*1024;  //업로드 가능한 파일의 용량은 기본 20메가

    public FileUploader(HttpServletRequest request, String uploadDir) throws Exception {
        this.request = request;
        this.uploadDir = new File(uploadDir);
    
        init();
    }

    public FileUploader(HttpServletRequest request, File uploadDir) throws Exception{
        this.request = request;
        this.uploadDir = uploadDir;

        init();
    }

    public FileUploader(HttpServletRequest request, String uploadDir, long fileLimit) throws Exception{
        this.request = request;
        this.uploadDir = new File(uploadDir);
        this.fileLimit = fileLimit;
        init();
    }

    public FileUploader(HttpServletRequest request, File uploadDir, long fileLimit) throws Exception{
        this.request = request;
        this.uploadDir = uploadDir;
        this.fileLimit = fileLimit;
        init();
    }

    
    /**
     * 초기화 함수
     * 
     * @throws Exception
     */
    private void init() throws Exception{

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            throw new Exception("form의 enctype을 multipart/form-data로 하세요...");
        }

        //임시저장공간 생성
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024);  //메모리에 저장할 최대 size
        factory.setRepository(uploadDir); //임시 저장할 위치

        //업로드 핸들러 생성
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(requestLimit);  //Set overall request size constraint

        items = upload.parseRequest(request); //Parse the request

        //파람값들을 맵에 셋팅
        processFormField(items);

    }

    /**
     * 폼의 필드값을 map에 저장한다.
     * 
     * @param items
     * @throws Exception
     */
    private void processFormField(List items) throws Exception{
        paramMap = new HashMap();
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();

            if (item.isFormField()) {
                paramMap.put(item.getFieldName(), item.getString());
            }
        }
    }

    /**
     * 하나의 파일사이즈를 체크한다.
     * @throws Exception
     */
    private void chkFileLimit() throws Exception{
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) {
                String fileName = new File(item.getName()).getName();
                long fileSize = item.getSize();
                if(fileName != null && !"".equals(fileName)){
                    if(fileLimit<fileSize){
                        throw new Exception(fileName+" 파일이 " + fileLimit/1024/1024 + "M를 초과하였습니다.\n");
                    }
                }
            }
        }
    }

    /**
     * request상의 모든파일을 업로드한다.<br>
     * 파일명의 중복을 피하기 위해 중복될경우 파일명 뒤에 '0'을 붙여 업로드한다.<br>
     * 업로드후 변경된 파일명과 param들을 map으로 리턴받아 처리한다.
     * @return Map
     * @throws Exception
     */
    public Map getParamAfterUpload() throws Exception {

        boolean writeToFile = true; //파일에 쓸것인지 구분 플래그
        Iterator iter = items.iterator();

        chkFileLimit(); //파일들의 사이즈 체크

        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            
            //Process a file upload
            if (!item.isFormField()) {
                String filePath = item.getName();
                File file = new File(filePath);
                String fileName = file.getName();

                if(fileName != null && !"".equals(fileName)){
                    //파일업로드시...
                    if (writeToFile) {
                        String updFilePath = uploadDir+fileName;
                        String newFilePath = getNewFilePath(updFilePath); //동일한 파일명으로 업로드 될수 있기때문에 파일명이 같을경우 파일명 뒤에 '0'을 붙여 업로드한다.
                        File newFile = new File(newFilePath);
                        paramMap.put(item.getFieldName(), newFile.getName()); //새로운 파일명을 리턴헤주기 위해 맵에 담는다.
                        item.write(newFile);        //파일을 쓴다.
                    }

                    //파일업로드가 아닌  다른출력방식을 사용하고 싶을때...
                    /*
                    else {
                         InputStream uploadedStream = item.getInputStream();
                         uploadedStream.close();
                    }
                    */
                }
            }
        }
        return paramMap;
    }

    /**
     * 새로운 파일명을 생성한다. 
     * @param filePath
     * @return String
     */
    private String getNewFilePath(String filePath) {

        File file = new File(filePath);
        String sDir = file.getParent();
        File dir = new File(sDir);
        File[] files = dir.listFiles();

        for(int i=0; i<files.length; i++){
            String alreadyPath = files[i].getPath();
            if (filePath.equals(alreadyPath)) {
                filePath = filePath + "0";
            }
        }

        return filePath;
    }

    /**
     * request상의 param들을 map으로 반환한다.
     * @return Map
     */
    public Map getParamMap() {
        return paramMap;
    }

}




