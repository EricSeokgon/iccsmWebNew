

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_SUVSPOT
*  테이블 설명 :
*  테이블 PK   :  
*               RECV_NUM  
*               RECV_NUM  
*               SIDO_CODE  
*               SIDO_CODE  
*               SIGUNGU_CODE  
*               SIGUNGU_CODE
*  테이블 컬럼 :  
*               RECV_NUM:VARCHAR2(30):  
*               SUV_NAME:VARCHAR2(100):  
*               SUV_STANUM:VARCHAR2(24):  
*               SUV_NM:VARCHAR2(26):  
*               SUV_TELNUM:VARCHAR2(24):  
*               SUV_POSTNUM:VARCHAR2(6):  
*               SUV_ADDR:VARCHAR2(64):  
*               SUV_DETAILADDR:VARCHAR2(128):  
*               SIWORK_NAME:VARCHAR2(100):  
*               SIWORK_REP:VARCHAR2(25):  
*               COI_WRT_NUM:VARCHAR2(26):  
*               SIWORK_POSTNUM:VARCHAR2(6):  
*               SIWORK_ADDR:VARCHAR2(64):  
*               SIWORK_DETAILADDR:VARCHAR2(128):  
*               SPOTNM:VARCHAR2(125):  
*               SPOT_POSTNUM:VARCHAR2(6):  
*               SPOT_ADDR:VARCHAR2(64):  
*               SPOT_DETAILADDR:VARCHAR2(128):  
*               WORK_ITEM:VARCHAR2(128):  
*               USE:VARCHAR2(128):  
*               STRU_AREA:VARCHAR2(250):  
*               AREA:VARCHAR2(12):  
*               SW_DT:VARCHAR2(24):  
*               EW_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(6):  
*               SUV_MOBILE:VARCHAR2(24):  
*               SIWORK_TELNUM:VARCHAR2(24):  
*               SIWORK_MOBILE:VARCHAR2(24):  
*               DOC_YN:VARCHAR2(5):  
*               PROC_LIM:VARCHAR2(24):  
*               ORPE_NM:VARCHAR2(50):  
*               WORK_ITEM_ETC:VARCHAR2(128):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               CIV_RECV_NUM:VARCHAR2(50):  
*               USE_ETC:VARCHAR2(256):  
*               RECV_NUM:VARCHAR2(30):  
*               SUV_NAME:VARCHAR2(100):  
*               SUV_STANUM:VARCHAR2(24):  
*               SUV_NM:VARCHAR2(26):  
*               SUV_TELNUM:VARCHAR2(24):  
*               SUV_POSTNUM:VARCHAR2(6):  
*               SUV_ADDR:VARCHAR2(64):  
*               SUV_DETAILADDR:VARCHAR2(128):  
*               SIWORK_NAME:VARCHAR2(100):  
*               SIWORK_REP:VARCHAR2(25):  
*               COI_WRT_NUM:VARCHAR2(26):  
*               SIWORK_POSTNUM:VARCHAR2(6):  
*               SIWORK_ADDR:VARCHAR2(64):  
*               SIWORK_DETAILADDR:VARCHAR2(128):  
*               SPOTNM:VARCHAR2(125):  
*               SPOT_POSTNUM:VARCHAR2(6):  
*               SPOT_ADDR:VARCHAR2(64):  
*               SPOT_DETAILADDR:VARCHAR2(128):  
*               WORK_ITEM:VARCHAR2(128):  
*               USE:VARCHAR2(128):  
*               STRU_AREA:VARCHAR2(250):  
*               AREA:VARCHAR2(12):  
*               SW_DT:VARCHAR2(24):  
*               EW_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               SIDO_CODE:VARCHAR2(4):  
*               SIGUNGU_CODE:VARCHAR2(6):  
*               SUV_MOBILE:VARCHAR2(24):  
*               SIWORK_TELNUM:VARCHAR2(24):  
*               SIWORK_MOBILE:VARCHAR2(24):  
*               DOC_YN:VARCHAR2(5):  
*               PROC_LIM:VARCHAR2(24):  
*               ORPE_NM:VARCHAR2(50):  
*               WORK_ITEM_ETC:VARCHAR2(128):  
*               UPD_DT_OLD:VARCHAR2(24):  
*               BACKUP_TRANS_DT:VARCHAR2(24):  
*               CIV_RECV_NUM:VARCHAR2(50):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_SUVSPOTEntity extends ValueObject{

  
     private String RECV_NUM;
  
     private String SUV_NAME;
  
     private String SUV_STANUM;
  
     private String SUV_NM;
  
     private String SUV_TELNUM;
  
     private String SUV_POSTNUM;
  
     private String SUV_ADDR;
  
     private String SUV_DETAILADDR;
  
     private String SIWORK_NAME;
  
     private String SIWORK_REP;
  
     private String COI_WRT_NUM;
  
     private String SIWORK_POSTNUM;
  
     private String SIWORK_ADDR;
  
     private String SIWORK_DETAILADDR;
  
     private String SPOTNM;
  
     private String SPOT_POSTNUM;
  
     private String SPOT_ADDR;
  
     private String SPOT_DETAILADDR;
  
     private String WORK_ITEM;
  
     private String USE;
  
     private String STRU_AREA;
  
     private String AREA;
  
     private String SW_DT;
  
     private String EW_DT;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String SIDO_CODE;
  
     private String SIGUNGU_CODE;
  
     private String SUV_MOBILE;
  
     private String SIWORK_TELNUM;
  
     private String SIWORK_MOBILE;
  
     private String DOC_YN;
  
     private String PROC_LIM;
  
     private String ORPE_NM;
  
     private String WORK_ITEM_ETC;
  
     private String UPD_DT_OLD;
  
     private String BACKUP_TRANS_DT;
  
     private String CIV_RECV_NUM;
  
     private String USE_ETC;
  
  

//생성자를 만든다
    public PT_UB_SUVSPOTEntity(){
    }
    
    
    public PT_UB_SUVSPOTEntity(String RECV_NUM,String SIDO_CODE,String SIGUNGU_CODE ){
       this.setRECV_NUM(RECV_NUM);
       this.setSIDO_CODE(SIDO_CODE);
       this.setSIGUNGU_CODE(SIGUNGU_CODE);
       
    }
      
    public PT_UB_SUVSPOTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("RECV_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("RECV_NUM",value);
      
       value = ent.getByName("SIDO_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIDO_CODE",value);
       
       value = ent.getByName("SIGUNGU_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SIGUNGU_CODE",value);
       
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.RECV_NUM =request.getParameter("RECV_NUM");
		this.SUV_NAME =request.getParameter("SUV_NAME");
		this.SUV_STANUM =request.getParameter("SUV_STANUM");
		this.SUV_NM =request.getParameter("SUV_NM");
		this.SUV_TELNUM =request.getParameter("SUV_TELNUM");
		this.SUV_POSTNUM =request.getParameter("SUV_POSTNUM");
		this.SUV_ADDR =request.getParameter("SUV_ADDR");
		this.SUV_DETAILADDR =request.getParameter("SUV_DETAILADDR");
		this.SIWORK_NAME =request.getParameter("SIWORK_NAME");
		this.SIWORK_REP =request.getParameter("SIWORK_REP");
		this.COI_WRT_NUM =request.getParameter("COI_WRT_NUM");
		this.SIWORK_POSTNUM =request.getParameter("SIWORK_POSTNUM");
		this.SIWORK_ADDR =request.getParameter("SIWORK_ADDR");
		this.SIWORK_DETAILADDR =request.getParameter("SIWORK_DETAILADDR");
		this.SPOTNM =request.getParameter("SPOTNM");
		this.SPOT_POSTNUM =request.getParameter("SPOT_POSTNUM");
		this.SPOT_ADDR =request.getParameter("SPOT_ADDR");
		this.SPOT_DETAILADDR =request.getParameter("SPOT_DETAILADDR");
		this.WORK_ITEM =request.getParameter("WORK_ITEM");
		this.USE =request.getParameter("USE");
		this.STRU_AREA =request.getParameter("STRU_AREA");
		this.AREA =request.getParameter("AREA");
		this.SW_DT =request.getParameter("SW_DT");
		this.EW_DT =request.getParameter("EW_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.SIDO_CODE =request.getParameter("SIDO_CODE");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.SUV_MOBILE =request.getParameter("SUV_MOBILE");
		this.SIWORK_TELNUM =request.getParameter("SIWORK_TELNUM");
		this.SIWORK_MOBILE =request.getParameter("SIWORK_MOBILE");
		this.DOC_YN =request.getParameter("DOC_YN");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.ORPE_NM =request.getParameter("ORPE_NM");
		this.WORK_ITEM_ETC =request.getParameter("WORK_ITEM_ETC");
		this.UPD_DT_OLD =request.getParameter("UPD_DT_OLD");
		this.BACKUP_TRANS_DT =request.getParameter("BACKUP_TRANS_DT");
		this.CIV_RECV_NUM =request.getParameter("CIV_RECV_NUM");
		this.USE_ETC =request.getParameter("USE_ETC");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.RECV_NUM =KJFMi.dsGet(ds, arg_row, "RECV_NUM");
		this.SUV_NAME =KJFMi.dsGet(ds, arg_row, "SUV_NAME");
		this.SUV_STANUM =KJFMi.dsGet(ds, arg_row, "SUV_STANUM");
		this.SUV_NM =KJFMi.dsGet(ds, arg_row, "SUV_NM");
		this.SUV_TELNUM =KJFMi.dsGet(ds, arg_row, "SUV_TELNUM");
		this.SUV_POSTNUM =KJFMi.dsGet(ds, arg_row, "SUV_POSTNUM");
		this.SUV_ADDR =KJFMi.dsGet(ds, arg_row, "SUV_ADDR");
		this.SUV_DETAILADDR =KJFMi.dsGet(ds, arg_row, "SUV_DETAILADDR");
		this.SIWORK_NAME =KJFMi.dsGet(ds, arg_row, "SIWORK_NAME");
		this.SIWORK_REP =KJFMi.dsGet(ds, arg_row, "SIWORK_REP");
		this.COI_WRT_NUM =KJFMi.dsGet(ds, arg_row, "COI_WRT_NUM");
		this.SIWORK_POSTNUM =KJFMi.dsGet(ds, arg_row, "SIWORK_POSTNUM");
		this.SIWORK_ADDR =KJFMi.dsGet(ds, arg_row, "SIWORK_ADDR");
		this.SIWORK_DETAILADDR =KJFMi.dsGet(ds, arg_row, "SIWORK_DETAILADDR");
		this.SPOTNM =KJFMi.dsGet(ds, arg_row, "SPOTNM");
		this.SPOT_POSTNUM =KJFMi.dsGet(ds, arg_row, "SPOT_POSTNUM");
		this.SPOT_ADDR =KJFMi.dsGet(ds, arg_row, "SPOT_ADDR");
		this.SPOT_DETAILADDR =KJFMi.dsGet(ds, arg_row, "SPOT_DETAILADDR");
		this.WORK_ITEM =KJFMi.dsGet(ds, arg_row, "WORK_ITEM");
		this.USE =KJFMi.dsGet(ds, arg_row, "USE");
		this.STRU_AREA =KJFMi.dsGet(ds, arg_row, "STRU_AREA");
		this.AREA =KJFMi.dsGet(ds, arg_row, "AREA");
		this.SW_DT =KJFMi.dsGet(ds, arg_row, "SW_DT");
		this.EW_DT =KJFMi.dsGet(ds, arg_row, "EW_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.SIDO_CODE =KJFMi.dsGet(ds, arg_row, "SIDO_CODE");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.SUV_MOBILE =KJFMi.dsGet(ds, arg_row, "SUV_MOBILE");
		this.SIWORK_TELNUM =KJFMi.dsGet(ds, arg_row, "SIWORK_TELNUM");
		this.SIWORK_MOBILE =KJFMi.dsGet(ds, arg_row, "SIWORK_MOBILE");
		this.DOC_YN =KJFMi.dsGet(ds, arg_row, "DOC_YN");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.ORPE_NM =KJFMi.dsGet(ds, arg_row, "ORPE_NM");
		this.WORK_ITEM_ETC =KJFMi.dsGet(ds, arg_row, "WORK_ITEM_ETC");
		this.UPD_DT_OLD =KJFMi.dsGet(ds, arg_row, "UPD_DT_OLD");
		this.BACKUP_TRANS_DT =KJFMi.dsGet(ds, arg_row, "BACKUP_TRANS_DT");
		this.CIV_RECV_NUM =KJFMi.dsGet(ds, arg_row, "CIV_RECV_NUM");
		this.USE_ETC =KJFMi.dsGet(ds, arg_row, "USE_ETC");
				
    }    
    
//Getter 함수를 만든다
  
     public String getRECV_NUM(){
             return RECV_NUM;
     };
  
     public String getSUV_NAME(){
             return SUV_NAME;
     };
  
     public String getSUV_STANUM(){
             return SUV_STANUM;
     };
  
     public String getSUV_NM(){
             return SUV_NM;
     };
  
     public String getSUV_TELNUM(){
             return SUV_TELNUM;
     };
  
     public String getSUV_POSTNUM(){
             return SUV_POSTNUM;
     };
  
     public String getSUV_ADDR(){
             return SUV_ADDR;
     };
  
     public String getSUV_DETAILADDR(){
             return SUV_DETAILADDR;
     };
  
     public String getSIWORK_NAME(){
             return SIWORK_NAME;
     };
  
     public String getSIWORK_REP(){
             return SIWORK_REP;
     };
  
     public String getCOI_WRT_NUM(){
             return COI_WRT_NUM;
     };
  
     public String getSIWORK_POSTNUM(){
             return SIWORK_POSTNUM;
     };
  
     public String getSIWORK_ADDR(){
             return SIWORK_ADDR;
     };
  
     public String getSIWORK_DETAILADDR(){
             return SIWORK_DETAILADDR;
     };
  
     public String getSPOTNM(){
             return SPOTNM;
     };
  
     public String getSPOT_POSTNUM(){
             return SPOT_POSTNUM;
     };
  
     public String getSPOT_ADDR(){
             return SPOT_ADDR;
     };
  
     public String getSPOT_DETAILADDR(){
             return SPOT_DETAILADDR;
     };
  
     public String getWORK_ITEM(){
             return WORK_ITEM;
     };
  
     public String getUSE(){
             return USE;
     };
  
     public String getSTRU_AREA(){
             return STRU_AREA;
     };
  
     public String getAREA(){
             return AREA;
     };
  
     public String getSW_DT(){
             return SW_DT;
     };
  
     public String getEW_DT(){
             return EW_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getSIDO_CODE(){
             return SIDO_CODE;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getSUV_MOBILE(){
             return SUV_MOBILE;
     };
  
     public String getSIWORK_TELNUM(){
             return SIWORK_TELNUM;
     };
  
     public String getSIWORK_MOBILE(){
             return SIWORK_MOBILE;
     };
  
     public String getDOC_YN(){
             return DOC_YN;
     };
  
     public String getPROC_LIM(){
             return PROC_LIM;
     };
  
     public String getORPE_NM(){
             return ORPE_NM;
     };
  
     public String getWORK_ITEM_ETC(){
             return WORK_ITEM_ETC;
     };
  
     public String getUPD_DT_OLD(){
             return UPD_DT_OLD;
     };
  
     public String getBACKUP_TRANS_DT(){
             return BACKUP_TRANS_DT;
     };
  
     public String getCIV_RECV_NUM(){
             return CIV_RECV_NUM;
     };
  
     public String getUSE_ETC(){
             return USE_ETC;
     };
  
     
  

//Setter 함수를 만든다
  
     public void setRECV_NUM(String RECV_NUM){
            this.RECV_NUM=RECV_NUM;
     };
  
     public void setSUV_NAME(String SUV_NAME){
            this.SUV_NAME=SUV_NAME;
     };
  
     public void setSUV_STANUM(String SUV_STANUM){
            this.SUV_STANUM=SUV_STANUM;
     };
  
     public void setSUV_NM(String SUV_NM){
            this.SUV_NM=SUV_NM;
     };
  
     public void setSUV_TELNUM(String SUV_TELNUM){
            this.SUV_TELNUM=SUV_TELNUM;
     };
  
     public void setSUV_POSTNUM(String SUV_POSTNUM){
            this.SUV_POSTNUM=SUV_POSTNUM;
     };
  
     public void setSUV_ADDR(String SUV_ADDR){
            this.SUV_ADDR=SUV_ADDR;
     };
  
     public void setSUV_DETAILADDR(String SUV_DETAILADDR){
            this.SUV_DETAILADDR=SUV_DETAILADDR;
     };
  
     public void setSIWORK_NAME(String SIWORK_NAME){
            this.SIWORK_NAME=SIWORK_NAME;
     };
  
     public void setSIWORK_REP(String SIWORK_REP){
            this.SIWORK_REP=SIWORK_REP;
     };
  
     public void setCOI_WRT_NUM(String COI_WRT_NUM){
            this.COI_WRT_NUM=COI_WRT_NUM;
     };
  
     public void setSIWORK_POSTNUM(String SIWORK_POSTNUM){
            this.SIWORK_POSTNUM=SIWORK_POSTNUM;
     };
  
     public void setSIWORK_ADDR(String SIWORK_ADDR){
            this.SIWORK_ADDR=SIWORK_ADDR;
     };
  
     public void setSIWORK_DETAILADDR(String SIWORK_DETAILADDR){
            this.SIWORK_DETAILADDR=SIWORK_DETAILADDR;
     };
  
     public void setSPOTNM(String SPOTNM){
            this.SPOTNM=SPOTNM;
     };
  
     public void setSPOT_POSTNUM(String SPOT_POSTNUM){
            this.SPOT_POSTNUM=SPOT_POSTNUM;
     };
  
     public void setSPOT_ADDR(String SPOT_ADDR){
            this.SPOT_ADDR=SPOT_ADDR;
     };
  
     public void setSPOT_DETAILADDR(String SPOT_DETAILADDR){
            this.SPOT_DETAILADDR=SPOT_DETAILADDR;
     };
  
     public void setWORK_ITEM(String WORK_ITEM){
            this.WORK_ITEM=WORK_ITEM;
     };
  
     public void setUSE(String USE){
            this.USE=USE;
     };
  
     public void setSTRU_AREA(String STRU_AREA){
            this.STRU_AREA=STRU_AREA;
     };
  
     public void setAREA(String AREA){
            this.AREA=AREA;
     };
  
     public void setSW_DT(String SW_DT){
            this.SW_DT=SW_DT;
     };
  
     public void setEW_DT(String EW_DT){
            this.EW_DT=EW_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setSIDO_CODE(String SIDO_CODE){
            this.SIDO_CODE=SIDO_CODE;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setSUV_MOBILE(String SUV_MOBILE){
            this.SUV_MOBILE=SUV_MOBILE;
     };
  
     public void setSIWORK_TELNUM(String SIWORK_TELNUM){
            this.SIWORK_TELNUM=SIWORK_TELNUM;
     };
  
     public void setSIWORK_MOBILE(String SIWORK_MOBILE){
            this.SIWORK_MOBILE=SIWORK_MOBILE;
     };
  
     public void setDOC_YN(String DOC_YN){
            this.DOC_YN=DOC_YN;
     };
  
     public void setPROC_LIM(String PROC_LIM){
            this.PROC_LIM=PROC_LIM;
     };
  
     public void setORPE_NM(String ORPE_NM){
            this.ORPE_NM=ORPE_NM;
     };
  
     public void setWORK_ITEM_ETC(String WORK_ITEM_ETC){
            this.WORK_ITEM_ETC=WORK_ITEM_ETC;
     };
  
     public void setUPD_DT_OLD(String UPD_DT_OLD){
            this.UPD_DT_OLD=UPD_DT_OLD;
     };
  
     public void setBACKUP_TRANS_DT(String BACKUP_TRANS_DT){
            this.BACKUP_TRANS_DT=BACKUP_TRANS_DT;
     };
  
     public void setCIV_RECV_NUM(String CIV_RECV_NUM){
            this.CIV_RECV_NUM=CIV_RECV_NUM;
     };
  
     public void setUSE_ETC(String USE_ETC){
            this.USE_ETC=USE_ETC;
     };
  
     
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("RECV_NUM:"+ this.getRECV_NUM()+"\n");
      
      strB.append("SUV_NAME:"+ this.getSUV_NAME()+"\n");
      
      strB.append("SUV_STANUM:"+ this.getSUV_STANUM()+"\n");
      
      strB.append("SUV_NM:"+ this.getSUV_NM()+"\n");
      
      strB.append("SUV_TELNUM:"+ this.getSUV_TELNUM()+"\n");
      
      strB.append("SUV_POSTNUM:"+ this.getSUV_POSTNUM()+"\n");
      
      strB.append("SUV_ADDR:"+ this.getSUV_ADDR()+"\n");
      
      strB.append("SUV_DETAILADDR:"+ this.getSUV_DETAILADDR()+"\n");
      
      strB.append("SIWORK_NAME:"+ this.getSIWORK_NAME()+"\n");
      
      strB.append("SIWORK_REP:"+ this.getSIWORK_REP()+"\n");
      
      strB.append("COI_WRT_NUM:"+ this.getCOI_WRT_NUM()+"\n");
      
      strB.append("SIWORK_POSTNUM:"+ this.getSIWORK_POSTNUM()+"\n");
      
      strB.append("SIWORK_ADDR:"+ this.getSIWORK_ADDR()+"\n");
      
      strB.append("SIWORK_DETAILADDR:"+ this.getSIWORK_DETAILADDR()+"\n");
      
      strB.append("SPOTNM:"+ this.getSPOTNM()+"\n");
      
      strB.append("SPOT_POSTNUM:"+ this.getSPOT_POSTNUM()+"\n");
      
      strB.append("SPOT_ADDR:"+ this.getSPOT_ADDR()+"\n");
      
      strB.append("SPOT_DETAILADDR:"+ this.getSPOT_DETAILADDR()+"\n");
      
      strB.append("WORK_ITEM:"+ this.getWORK_ITEM()+"\n");
      
      strB.append("USE:"+ this.getUSE()+"\n");
      
      strB.append("STRU_AREA:"+ this.getSTRU_AREA()+"\n");
      
      strB.append("AREA:"+ this.getAREA()+"\n");
      
      strB.append("SW_DT:"+ this.getSW_DT()+"\n");
      
      strB.append("EW_DT:"+ this.getEW_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("SIDO_CODE:"+ this.getSIDO_CODE()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("SUV_MOBILE:"+ this.getSUV_MOBILE()+"\n");
      
      strB.append("SIWORK_TELNUM:"+ this.getSIWORK_TELNUM()+"\n");
      
      strB.append("SIWORK_MOBILE:"+ this.getSIWORK_MOBILE()+"\n");
      
      strB.append("DOC_YN:"+ this.getDOC_YN()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("ORPE_NM:"+ this.getORPE_NM()+"\n");
      
      strB.append("WORK_ITEM_ETC:"+ this.getWORK_ITEM_ETC()+"\n");
      
      strB.append("UPD_DT_OLD:"+ this.getUPD_DT_OLD()+"\n");
      
      strB.append("BACKUP_TRANS_DT:"+ this.getBACKUP_TRANS_DT()+"\n");
      
      strB.append("CIV_RECV_NUM:"+ this.getCIV_RECV_NUM()+"\n");
      
      strB.append("USE_ETC:"+ this.getUSE_ETC()+"\n");
      
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_SUVSPOTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_SUVSPOTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_SUVSPOTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_SUVSPOTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_SUVSPOTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getRECV_NUM();
       values[1]= this.getSIDO_CODE();
       values[2]= this.getSIGUNGU_CODE();
       
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_SUVSPOTEntity();
  }

  public ValueObject getClone(){
         PT_UB_SUVSPOTEntity newEnt = new PT_UB_SUVSPOTEntity();
	 
          newEnt.setRECV_NUM(this.getRECV_NUM());
         
          newEnt.setSUV_NAME(this.getSUV_NAME());
         
          newEnt.setSUV_STANUM(this.getSUV_STANUM());
         
          newEnt.setSUV_NM(this.getSUV_NM());
         
          newEnt.setSUV_TELNUM(this.getSUV_TELNUM());
         
          newEnt.setSUV_POSTNUM(this.getSUV_POSTNUM());
         
          newEnt.setSUV_ADDR(this.getSUV_ADDR());
         
          newEnt.setSUV_DETAILADDR(this.getSUV_DETAILADDR());
         
          newEnt.setSIWORK_NAME(this.getSIWORK_NAME());
         
          newEnt.setSIWORK_REP(this.getSIWORK_REP());
         
          newEnt.setCOI_WRT_NUM(this.getCOI_WRT_NUM());
         
          newEnt.setSIWORK_POSTNUM(this.getSIWORK_POSTNUM());
         
          newEnt.setSIWORK_ADDR(this.getSIWORK_ADDR());
         
          newEnt.setSIWORK_DETAILADDR(this.getSIWORK_DETAILADDR());
         
          newEnt.setSPOTNM(this.getSPOTNM());
         
          newEnt.setSPOT_POSTNUM(this.getSPOT_POSTNUM());
         
          newEnt.setSPOT_ADDR(this.getSPOT_ADDR());
         
          newEnt.setSPOT_DETAILADDR(this.getSPOT_DETAILADDR());
         
          newEnt.setWORK_ITEM(this.getWORK_ITEM());
         
          newEnt.setUSE(this.getUSE());
         
          newEnt.setSTRU_AREA(this.getSTRU_AREA());
         
          newEnt.setAREA(this.getAREA());
         
          newEnt.setSW_DT(this.getSW_DT());
         
          newEnt.setEW_DT(this.getEW_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setSIDO_CODE(this.getSIDO_CODE());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setSUV_MOBILE(this.getSUV_MOBILE());
         
          newEnt.setSIWORK_TELNUM(this.getSIWORK_TELNUM());
         
          newEnt.setSIWORK_MOBILE(this.getSIWORK_MOBILE());
         
          newEnt.setDOC_YN(this.getDOC_YN());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setORPE_NM(this.getORPE_NM());
         
          newEnt.setWORK_ITEM_ETC(this.getWORK_ITEM_ETC());
         
          newEnt.setUPD_DT_OLD(this.getUPD_DT_OLD());
         
          newEnt.setBACKUP_TRANS_DT(this.getBACKUP_TRANS_DT());
         
          newEnt.setCIV_RECV_NUM(this.getCIV_RECV_NUM());
         
          newEnt.setUSE_ETC(this.getUSE_ETC());
         
          
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_SUVSPOTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getRECV_NUM();
        
             case 2 :
                 return  this.getSUV_NAME();
        
             case 3 :
                 return  this.getSUV_STANUM();
        
             case 4 :
                 return  this.getSUV_NM();
        
             case 5 :
                 return  this.getSUV_TELNUM();
        
             case 6 :
                 return  this.getSUV_POSTNUM();
        
             case 7 :
                 return  this.getSUV_ADDR();
        
             case 8 :
                 return  this.getSUV_DETAILADDR();
        
             case 9 :
                 return  this.getSIWORK_NAME();
        
             case 10 :
                 return  this.getSIWORK_REP();
        
             case 11 :
                 return  this.getCOI_WRT_NUM();
        
             case 12 :
                 return  this.getSIWORK_POSTNUM();
        
             case 13 :
                 return  this.getSIWORK_ADDR();
        
             case 14 :
                 return  this.getSIWORK_DETAILADDR();
        
             case 15 :
                 return  this.getSPOTNM();
        
             case 16 :
                 return  this.getSPOT_POSTNUM();
        
             case 17 :
                 return  this.getSPOT_ADDR();
        
             case 18 :
                 return  this.getSPOT_DETAILADDR();
        
             case 19 :
                 return  this.getWORK_ITEM();
        
             case 20 :
                 return  this.getUSE();
        
             case 21 :
                 return  this.getSTRU_AREA();
        
             case 22 :
                 return  this.getAREA();
        
             case 23 :
                 return  this.getSW_DT();
        
             case 24 :
                 return  this.getEW_DT();
        
             case 25 :
                 return  this.getWRT_ID();
        
             case 26 :
                 return  this.getINS_DT();
        
             case 27 :
                 return  this.getUPD_DT();
        
             case 28 :
                 return  this.getSIDO_CODE();
        
             case 29 :
                 return  this.getSIGUNGU_CODE();
        
             case 30 :
                 return  this.getSUV_MOBILE();
        
             case 31 :
                 return  this.getSIWORK_TELNUM();
        
             case 32 :
                 return  this.getSIWORK_MOBILE();
        
             case 33 :
                 return  this.getDOC_YN();
        
             case 34 :
                 return  this.getPROC_LIM();
        
             case 35 :
                 return  this.getORPE_NM();
        
             case 36 :
                 return  this.getWORK_ITEM_ETC();
        
             case 37 :
                 return  this.getUPD_DT_OLD();
        
             case 38 :
                 return  this.getBACKUP_TRANS_DT();
        
             case 39 :
                 return  this.getCIV_RECV_NUM();
        
             case 40 :
                 return  this.getUSE_ETC();
        
                     
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_SUVSPOTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setRECV_NUM((String)value);
	            return;  
        
             case 2 :
                    this.setSUV_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setSUV_STANUM((String)value);
	            return;  
        
             case 4 :
                    this.setSUV_NM((String)value);
	            return;  
        
             case 5 :
                    this.setSUV_TELNUM((String)value);
	            return;  
        
             case 6 :
                    this.setSUV_POSTNUM((String)value);
	            return;  
        
             case 7 :
                    this.setSUV_ADDR((String)value);
	            return;  
        
             case 8 :
                    this.setSUV_DETAILADDR((String)value);
	            return;  
        
             case 9 :
                    this.setSIWORK_NAME((String)value);
	            return;  
        
             case 10 :
                    this.setSIWORK_REP((String)value);
	            return;  
        
             case 11 :
                    this.setCOI_WRT_NUM((String)value);
	            return;  
        
             case 12 :
                    this.setSIWORK_POSTNUM((String)value);
	            return;  
        
             case 13 :
                    this.setSIWORK_ADDR((String)value);
	            return;  
        
             case 14 :
                    this.setSIWORK_DETAILADDR((String)value);
	            return;  
        
             case 15 :
                    this.setSPOTNM((String)value);
	            return;  
        
             case 16 :
                    this.setSPOT_POSTNUM((String)value);
	            return;  
        
             case 17 :
                    this.setSPOT_ADDR((String)value);
	            return;  
        
             case 18 :
                    this.setSPOT_DETAILADDR((String)value);
	            return;  
        
             case 19 :
                    this.setWORK_ITEM((String)value);
	            return;  
        
             case 20 :
                    this.setUSE((String)value);
	            return;  
        
             case 21 :
                    this.setSTRU_AREA((String)value);
	            return;  
        
             case 22 :
                    this.setAREA((String)value);
	            return;  
        
             case 23 :
                    this.setSW_DT((String)value);
	            return;  
        
             case 24 :
                    this.setEW_DT((String)value);
	            return;  
        
             case 25 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 26 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 27 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 28 :
                    this.setSIDO_CODE((String)value);
	            return;  
        
             case 29 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 30 :
                    this.setSUV_MOBILE((String)value);
	            return;  
        
             case 31 :
                    this.setSIWORK_TELNUM((String)value);
	            return;  
        
             case 32 :
                    this.setSIWORK_MOBILE((String)value);
	            return;  
        
             case 33 :
                    this.setDOC_YN((String)value);
	            return;  
        
             case 34 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 35 :
                    this.setORPE_NM((String)value);
	            return;  
        
             case 36 :
                    this.setWORK_ITEM_ETC((String)value);
	            return;  
        
             case 37 :
                    this.setUPD_DT_OLD((String)value);
	            return;  
        
             case 38 :
                    this.setBACKUP_TRANS_DT((String)value);
	            return;  
        
             case 39 :
                    this.setCIV_RECV_NUM((String)value);
	            return;  
        
             case 40 :
                    this.setUSE_ETC((String)value);
	            return;  
        
         
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_SUVSPOTHelper.toXML(this);
  }
  
}
