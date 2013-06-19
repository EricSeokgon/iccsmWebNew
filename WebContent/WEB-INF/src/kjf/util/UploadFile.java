package kjf.util;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * <p>system        : 기본적인 업로드 유틸함수</p>
 * <p>Description   : 기본적인 업로드 유틸함수를 구현하여 제공. </p>
 * @author 김경덕
 * @version 1.0 2003.05.29 <br/>
 */
public class UploadFile extends ActionForm {

	String SYS_FILE_NAME;
	String FILE_REAL_NAME;
	long filesize;
	private FormFile[] FILE =new FormFile[10] ;
	
	public String getFILE_REAL_NAME() {
		return FILE_REAL_NAME;
	}
	public void setFILE_REAL_NAME(String file_real_name) {
		FILE_REAL_NAME = file_real_name;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getSYS_FILE_NAME() {
		return SYS_FILE_NAME;
	}
	public void setSYS_FILE_NAME(String sys_file_name) {
		SYS_FILE_NAME = sys_file_name;
	}
	public FormFile[] getFILE() {
		return FILE;
	}
	public void setFILE(FormFile[] file) {
		FILE = file;
	}	
}