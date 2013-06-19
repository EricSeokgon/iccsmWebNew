package kjf.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjf.cfg.Config;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	private String upload_dir = null;
    private String saveDir = null;
    private Map paramMap = null;


    public void init(ServletConfig config) throws ServletException {
          super.init(config);
          upload_dir = config.getServletContext().getRealPath("/download/");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");

        // form type�� multipart/form-data �� true �׷��� ������ false�� ��ȯ
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            try {

            	FileUploader fileUploader = new FileUploader(request, upload_dir, 1024*1024*Config.props.getLogn("MAX_UPLOAD_SIZE_M"));

            	Map paramMap1 = fileUploader.getParamMap();

            	System.out.println(paramMap1.get("filePath"));


            // ������ ���ε� ������ �ʰ��� exception ó��
            } catch (SizeLimitExceededException e) {
                e.printStackTrace();

            // ���ε�� io�� �̻� exception ó��
            } catch (FileUploadException e) {
                e.printStackTrace();

            // ��Ÿ exception ó��
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

