/**
 * 파일명   : UbParam.java
 * 설명      : Parameter Bean 
 * 이력사항
 * 
 */
package sp.ub;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import kjf.util.*;


public class UbParam extends ActionForm{    


    /*페이징 관련*/
    private String nowPage;
    private String totalCount;
    private String rowPerPage; 

    	
    /*검색 조건-접두사 sc (serch condition) */
    
    private String sendSysID;		//송신시스템 ID
    private String sendSysName;		//송신시스템명
    private String sendOrgName;		//송신시스템의 기관명
    private String sendUserID;		//송신자 ID
    private String sendUserEmail;	//송신자 이메일
    private String sendDate;		//송신일자 yyyy-MM-dd hh:MM:ss type
    private String sendDateNoFomate;//송신일자 yyyyMMddhhMMss + 난수(5자리) type
   	private String recvSysID;		//수신시스템 ID
    private String recvUserID;		//수신자 ID
    private String admNum;			//행정시스템의 고유식별 코드
    private String scSIDO_CODE;		//시도 코드
    private String scSIGUNGU_CODE;	//시군구 코드
    private String scServerAddr;	//시군구 서버 정보
    private String ubID;				//이작업을 위한 호출당 고유번호(시간코드)

    private String scCIV_RECV_NUM;	// 접수번호
    private String scINSP_SPOT_NM; 	//현장명칭
    private String scAPPLPER_NM;	//건축주
    private String scOPE_NAME;		//상호
    private String scNAPPL_YN;		//적합 및 비적합
    
    private String scINS_DT; //등록일자
    private String scSW_DT;//착공일자
    private String scEW_DT;//완공일자
    /*첨부 파일*/
//    private FormFile formFile;
//    
//    public FormFile getFormFile() {
//		return formFile;
//	}
//
//
//	public void setFormFile(FormFile formFile) {
//		this.formFile = formFile;
//	}


	public String getScServerAddr() {
		return scServerAddr;
	}


	public void setScServerAddr(String scServerAddr) {
		this.scServerAddr = scServerAddr;
	}


	public String getSendDateNoFomate() {
		return sendDateNoFomate;
	}


    public void setSendDateNoFomate(String sendDateNoFomate) {
		this.sendDateNoFomate = sendDateNoFomate;
	}
	
	
    public String getUbID() {
		return ubID;
	}




	public void setUbID(String ubID) {
		this.ubID = ubID;
	}




	public String getScSIDO_CODE() {
		return scSIDO_CODE;
	}




	public void setScSIDO_CODE(String scSIDO_CODE) {
		this.scSIDO_CODE = scSIDO_CODE;
	}




	public String getScSIGUNGU_CODE() {
		return scSIGUNGU_CODE;
	}




	public void setScSIGUNGU_CODE(String scSIGUNGU_CODE) {
		this.scSIGUNGU_CODE = scSIGUNGU_CODE;
	}




	public String getSendSysID() {
		return sendSysID;
	}




	public void setSendSysID(String sendSysID) {
		this.sendSysID = sendSysID;
	}




	public String getSendSysName() {
		return sendSysName;
	}




	public void setSendSysName(String sendSysName) {
		this.sendSysName = sendSysName;
	}




	public String getSendOrgName() {
		return sendOrgName;
	}




	public void setSendOrgName(String sendOrgName) {
		this.sendOrgName = sendOrgName;
	}




	public String getSendUserID() {
		return sendUserID;
	}




	public void setSendUserID(String sendUserID) {
		this.sendUserID = sendUserID;
	}




	public String getSendUserEmail() {
		return sendUserEmail;
	}




	public void setSendUserEmail(String sendUserEmail) {
		this.sendUserEmail = sendUserEmail;
	}




	public String getSendDate() {
		return sendDate;
	}




	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}




	public String getRecvSysID() {
		return recvSysID;
	}




	public void setRecvSysID(String recvSysID) {
		this.recvSysID = recvSysID;
	}




	public String getRecvUserID() {
		return recvUserID;
	}




	public void setRecvUserID(String recvUserID) {
		this.recvUserID = recvUserID;
	}




	public String getAdmNum() {
		return admNum;
	}




	public void setAdmNum(String admNum) {
		this.admNum = admNum;
	}




	public UbParam() {
    }


 

    /**
    *	request로 부터 parameter의 해당 value를 얻어
    *	paramName : value
    *	형식으로 출력
    */
    public String toString(HttpServletRequest request){
        return KJFUtil.reportParameters(request) ;
    }


    public String getNowPage() {
        return nowPage;
    }
    
    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }
    
    public String getRowPerPage() {
        return rowPerPage;
    }
    
    public void setRowPerPage(String rowPerPage) {
        this.rowPerPage = rowPerPage;
    }
        
    public String getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }


	public String getScCIV_RECV_NUM() {
		return scCIV_RECV_NUM;
	}


	public void setScCIV_RECV_NUM(String scCIV_RECV_NUM) {
		this.scCIV_RECV_NUM = scCIV_RECV_NUM;
	}


	public String getScINSP_SPOT_NM() {
		return scINSP_SPOT_NM;
	}


	public void setScINSP_SPOT_NM(String scINSP_SPOT_NM) {
		this.scINSP_SPOT_NM = scINSP_SPOT_NM;
	}


	public String getScAPPLPER_NM() {
		return scAPPLPER_NM;
	}


	public void setScAPPLPER_NM(String scAPPLPER_NM) {
		this.scAPPLPER_NM = scAPPLPER_NM;
	}


	public String getScOPE_NAME() {
		return scOPE_NAME;
	}


	public void setScOPE_NAME(String scOPE_NAME) {
		this.scOPE_NAME = scOPE_NAME;
	}


	public String getScNAPPL_YN() {
		return scNAPPL_YN;
	}


	public void setScNAPPL_YN(String scNAPPL_YN) {
		this.scNAPPL_YN = scNAPPL_YN;
	}

	public String getINS_DT() {
		return scINS_DT;
	}

	public void setINS_DT(String INS_DT) {
		this.sendDate = INS_DT;
	}

	public String getSW_DT() {
		return scSW_DT;
	}

	public void setSW_DT(String SW_DT) {
		this.sendDate = SW_DT;
	}


	public String getEW_DT() {
		return scEW_DT;
	}

	public void setEW_DT(String EW_DT) {
		this.sendDate = EW_DT;
	}
}//end class


