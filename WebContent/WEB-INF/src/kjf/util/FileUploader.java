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
 * <p>Title         : ���Ͼ��ε� ��ƿ�Լ� </p>
 * <p>Description   : ���Ͼ��ε� ��ƿ�Լ��� �����Ͽ� ����. </p>
 * ex)
 * FileUploader fileUploader = new FileUploader(request, "C:\\", 1024*1024*3);
 * Map fileMap = fileUploader.getParamAfterUpload();
 * 
 * @author ���ν�
 * @version 1.0
 */
public class FileUploader {

    private HttpServletRequest request = null;
    private File uploadDir = null;
    private List items = null;
    private Map paramMap = null;
    private long requestLimit = Config.props.getLogn("MAX_UPLOAD_SIZE_M")*1024*1024; //�ѹ��� ���ε� �뷮�� �⺻ 100�ް�
    private long fileLimit = Config.props.getLogn("MAX_FILE_UPLOAD_SIZE_M")*1024*1024;  //���ε� ������ ������ �뷮�� �⺻ 20�ް�

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
     * �ʱ�ȭ �Լ�
     * 
     * @throws Exception
     */
    private void init() throws Exception{

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            throw new Exception("form�� enctype�� multipart/form-data�� �ϼ���...");
        }

        //�ӽ�������� ����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024);  //�޸𸮿� ������ �ִ� size
        factory.setRepository(uploadDir); //�ӽ� ������ ��ġ

        //���ε� �ڵ鷯 ����
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(requestLimit);  //Set overall request size constraint

        items = upload.parseRequest(request); //Parse the request

        //�Ķ������� �ʿ� ����
        processFormField(items);

    }

    /**
     * ���� �ʵ尪�� map�� �����Ѵ�.
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
     * �ϳ��� ���ϻ���� üũ�Ѵ�.
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
                        throw new Exception(fileName+" ������ " + fileLimit/1024/1024 + "M�� �ʰ��Ͽ����ϴ�.\n");
                    }
                }
            }
        }
    }

    /**
     * request���� ��������� ���ε��Ѵ�.<br>
     * ���ϸ��� �ߺ��� ���ϱ� ���� �ߺ��ɰ�� ���ϸ� �ڿ� '0'�� �ٿ� ���ε��Ѵ�.<br>
     * ���ε��� ����� ���ϸ�� param���� map���� ���Ϲ޾� ó���Ѵ�.
     * @return Map
     * @throws Exception
     */
    public Map getParamAfterUpload() throws Exception {

        boolean writeToFile = true; //���Ͽ� �������� ���� �÷���
        Iterator iter = items.iterator();

        chkFileLimit(); //���ϵ��� ������ üũ

        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            
            //Process a file upload
            if (!item.isFormField()) {
                String filePath = item.getName();
                File file = new File(filePath);
                String fileName = file.getName();

                if(fileName != null && !"".equals(fileName)){
                    //���Ͼ��ε��...
                    if (writeToFile) {
                        String updFilePath = uploadDir+fileName;
                        String newFilePath = getNewFilePath(updFilePath); //������ ���ϸ����� ���ε� �ɼ� �ֱ⶧���� ���ϸ��� ������� ���ϸ� �ڿ� '0'�� �ٿ� ���ε��Ѵ�.
                        File newFile = new File(newFilePath);
                        paramMap.put(item.getFieldName(), newFile.getName()); //���ο� ���ϸ��� �������ֱ� ���� �ʿ� ��´�.
                        item.write(newFile);        //������ ����.
                    }

                    //���Ͼ��ε尡 �ƴ�  �ٸ���¹���� ����ϰ� ������...
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
     * ���ο� ���ϸ��� �����Ѵ�. 
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
     * request���� param���� map���� ��ȯ�Ѵ�.
     * @return Map
     */
    public Map getParamMap() {
        return paramMap;
    }

}




