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

        // form type이 multipart/form-data 면 true 그렇지 않으면 false를 반환
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            try {

            	FileUploader fileUploader = new FileUploader(request, upload_dir, 1024*1024*Config.props.getLogn("MAX_UPLOAD_SIZE_M"));

            	Map paramMap1 = fileUploader.getParamMap();

            	System.out.println(paramMap1.get("filePath"));


            // 설정한 업로드 사이즈 초과시 exception 처리
            } catch (SizeLimitExceededException e) {
                e.printStackTrace();

            // 업로드시 io등 이상 exception 처리
            } catch (FileUploadException e) {
                e.printStackTrace();

            // 기타 exception 처리
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

