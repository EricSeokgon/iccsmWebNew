

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_COM_CT
*  테이블 설명 :
*  테이블 PK   :  
*               CT_ID
*  테이블 컬럼 :  
*               CT_ID:VARCHAR2(30):  
*               BOARD_NAME:VARCHAR2(50):  
*               BOARD_URL:VARCHAR2(128):  
*               BOARD_CATEGORY:VARCHAR2(128):  
*               BOARD_TYPE:VARCHAR2(64):  
*               BOARD_SKIN:VARCHAR2(64):  
*               BOARD_WIDTH:VARCHAR2(10):  
*               BOARD_ALIGN:VARCHAR2(20):  
*               BBS_OWNER:VARCHAR2(16):  
*               BBS_GROUP:VARCHAR2(32):  
*               BBS_DEPTH:NUMBER(5):  
*               CUT_TITLE:NUMBER(5):  
*               ROWPERPAGE:NUMBER(5):  
*               NEW_DAY:NUMBER(5):  
*               TITLE_WRT_YN:VARCHAR2(1):  
*               TITLE_DATE_YN:VARCHAR2(1):  
*               TITLE_HIT_YN:VARCHAR2(1):  
*               TITLE_IP_YN:VARCHAR2(1):  
*               HEADER_HTML:CLOB:  
*               MAIN_HTML:CLOB:  
*               BOTTOM_HTML:CLOB:  
*               LIST_LEVEL:VARCHAR2(36):  
*               READ_LEVEL:VARCHAR2(36):  
*               WRITE_LEVEL:VARCHAR2(36):  
*               ATTACH_YN:VARCHAR2(1):  
*               FILE_SIZE:NUMBER(5):  
*               ATT_NUM:NUMBER(5):  
*               REPLY_YN:VARCHAR2(1):  
*               ONE_LINE_YN:VARCHAR2(1):  
*               SECRET_YN:VARCHAR2(1):  
*               USE_YN:VARCHAR2(1):  
*               DIV_USE_YN:VARCHAR2(1):  
*               SD_DIV_YN:VARCHAR2(1):  
*               SGG_DIV_YN:VARCHAR2(1):  
*               VIEW_LIST_YN:VARCHAR2(1):  
*               ONE_ONE_YN:VARCHAR2(1):  
*               FILTER:VARCHAR2(50):  
*               TABLE_ONE_YN:VARCHAR2(1):  
*               SUBJ_1:VARCHAR2(50):  
*               SUBJ_2:VARCHAR2(50):  
*               SUBJ_3:VARCHAR2(50):  
*               SUBJ_4:VARCHAR2(50):  
*               SUBJ_5:VARCHAR2(50):  
*               SUBJ_6:VARCHAR2(50):  
*               SUBJ_7:VARCHAR2(50):  
*               SUBJ_8:VARCHAR2(50):  
*               SUBJ_9:VARCHAR2(50):  
*               SUBJ_10:VARCHAR2(50):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(24):  
*               INS_DT:VARCHAR2(24):  
*               PUBLIC_DIV_YN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_BBS_COM_CTEntity extends ValueObject{

  
     private String CT_ID;
  
     private String BOARD_NAME;
  
     private String BOARD_URL;
  
     private String BOARD_CATEGORY;
  
     private String BOARD_TYPE;
  
     private String BOARD_SKIN;
  
     private String BOARD_WIDTH;
  
     private String BOARD_ALIGN;
  
     private String BBS_OWNER;
  
     private String BBS_GROUP;
  
     private String BBS_DEPTH;
  
     private String CUT_TITLE;
  
     private String ROWPERPAGE;
  
     private String NEW_DAY;
  
     private String TITLE_WRT_YN;
  
     private String TITLE_DATE_YN;
  
     private String TITLE_HIT_YN;
  
     private String TITLE_IP_YN;
  
     private String HEADER_HTML;
  
     private String MAIN_HTML;
  
     private String BOTTOM_HTML;
  
     private String LIST_LEVEL;
  
     private String READ_LEVEL;
  
     private String WRITE_LEVEL;
  
     private String ATTACH_YN;
  
     private String FILE_SIZE;
  
     private String ATT_NUM;
  
     private String REPLY_YN;
  
     private String ONE_LINE_YN;
  
     private String SECRET_YN;
  
     private String USE_YN;
  
     private String DIV_USE_YN;
  
     private String SD_DIV_YN;
  
     private String SGG_DIV_YN;
  
     private String VIEW_LIST_YN;
  
     private String ONE_ONE_YN;
  
     private String FILTER;
  
     private String TABLE_ONE_YN;
  
     private String SUBJ_1;
  
     private String SUBJ_2;
  
     private String SUBJ_3;
  
     private String SUBJ_4;
  
     private String SUBJ_5;
  
     private String SUBJ_6;
  
     private String SUBJ_7;
  
     private String SUBJ_8;
  
     private String SUBJ_9;
  
     private String SUBJ_10;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String INS_DT;
  
     private String PUBLIC_DIV_YN;
  

//생성자를 만든다
    public PT_BBS_COM_CTEntity(){
    }
    
    
    public PT_BBS_COM_CTEntity(String CT_ID ){
       this.setCT_ID(CT_ID);
       
    }
      
    public PT_BBS_COM_CTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("CT_ID");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("CT_ID",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CT_ID =request.getParameter("CT_ID");
		this.BOARD_NAME =request.getParameter("BOARD_NAME");
		this.BOARD_URL =request.getParameter("BOARD_URL");
		this.BOARD_CATEGORY =request.getParameter("BOARD_CATEGORY");
		this.BOARD_TYPE =request.getParameter("BOARD_TYPE");
		this.BOARD_SKIN =request.getParameter("BOARD_SKIN");
		this.BOARD_WIDTH =request.getParameter("BOARD_WIDTH");
		this.BOARD_ALIGN =request.getParameter("BOARD_ALIGN");
		this.BBS_OWNER =request.getParameter("BBS_OWNER");
		this.BBS_GROUP =request.getParameter("BBS_GROUP");
		this.BBS_DEPTH =request.getParameter("BBS_DEPTH");
		this.CUT_TITLE =request.getParameter("CUT_TITLE");
		this.ROWPERPAGE =request.getParameter("ROWPERPAGE");
		this.NEW_DAY =request.getParameter("NEW_DAY");
		this.TITLE_WRT_YN =request.getParameter("TITLE_WRT_YN");
		this.TITLE_DATE_YN =request.getParameter("TITLE_DATE_YN");
		this.TITLE_HIT_YN =request.getParameter("TITLE_HIT_YN");
		this.TITLE_IP_YN =request.getParameter("TITLE_IP_YN");
		this.HEADER_HTML =request.getParameter("HEADER_HTML");
		this.MAIN_HTML =request.getParameter("MAIN_HTML");
		this.BOTTOM_HTML =request.getParameter("BOTTOM_HTML");
		this.LIST_LEVEL =request.getParameter("LIST_LEVEL");
		this.READ_LEVEL =request.getParameter("READ_LEVEL");
		this.WRITE_LEVEL =request.getParameter("WRITE_LEVEL");
		this.ATTACH_YN =request.getParameter("ATTACH_YN");
		this.FILE_SIZE =request.getParameter("FILE_SIZE");
		this.ATT_NUM =request.getParameter("ATT_NUM");
		this.REPLY_YN =request.getParameter("REPLY_YN");
		this.ONE_LINE_YN =request.getParameter("ONE_LINE_YN");
		this.SECRET_YN =request.getParameter("SECRET_YN");
		this.USE_YN =request.getParameter("USE_YN");
		this.DIV_USE_YN =request.getParameter("DIV_USE_YN");
		this.SD_DIV_YN =request.getParameter("SD_DIV_YN");
		this.SGG_DIV_YN =request.getParameter("SGG_DIV_YN");
		this.VIEW_LIST_YN =request.getParameter("VIEW_LIST_YN");
		this.ONE_ONE_YN =request.getParameter("ONE_ONE_YN");
		this.FILTER =request.getParameter("FILTER");
		this.TABLE_ONE_YN =request.getParameter("TABLE_ONE_YN");
		this.SUBJ_1 =request.getParameter("SUBJ_1");
		this.SUBJ_2 =request.getParameter("SUBJ_2");
		this.SUBJ_3 =request.getParameter("SUBJ_3");
		this.SUBJ_4 =request.getParameter("SUBJ_4");
		this.SUBJ_5 =request.getParameter("SUBJ_5");
		this.SUBJ_6 =request.getParameter("SUBJ_6");
		this.SUBJ_7 =request.getParameter("SUBJ_7");
		this.SUBJ_8 =request.getParameter("SUBJ_8");
		this.SUBJ_9 =request.getParameter("SUBJ_9");
		this.SUBJ_10 =request.getParameter("SUBJ_10");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.INS_DT =request.getParameter("INS_DT");
		this.PUBLIC_DIV_YN =request.getParameter("PUBLIC_DIV_YN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CT_ID =KJFMi.dsGet(ds, arg_row, "CT_ID");
		this.BOARD_NAME =KJFMi.dsGet(ds, arg_row, "BOARD_NAME");
		this.BOARD_URL =KJFMi.dsGet(ds, arg_row, "BOARD_URL");
		this.BOARD_CATEGORY =KJFMi.dsGet(ds, arg_row, "BOARD_CATEGORY");
		this.BOARD_TYPE =KJFMi.dsGet(ds, arg_row, "BOARD_TYPE");
		this.BOARD_SKIN =KJFMi.dsGet(ds, arg_row, "BOARD_SKIN");
		this.BOARD_WIDTH =KJFMi.dsGet(ds, arg_row, "BOARD_WIDTH");
		this.BOARD_ALIGN =KJFMi.dsGet(ds, arg_row, "BOARD_ALIGN");
		this.BBS_OWNER =KJFMi.dsGet(ds, arg_row, "BBS_OWNER");
		this.BBS_GROUP =KJFMi.dsGet(ds, arg_row, "BBS_GROUP");
		this.BBS_DEPTH =KJFMi.dsGet(ds, arg_row, "BBS_DEPTH");
		this.CUT_TITLE =KJFMi.dsGet(ds, arg_row, "CUT_TITLE");
		this.ROWPERPAGE =KJFMi.dsGet(ds, arg_row, "ROWPERPAGE");
		this.NEW_DAY =KJFMi.dsGet(ds, arg_row, "NEW_DAY");
		this.TITLE_WRT_YN =KJFMi.dsGet(ds, arg_row, "TITLE_WRT_YN");
		this.TITLE_DATE_YN =KJFMi.dsGet(ds, arg_row, "TITLE_DATE_YN");
		this.TITLE_HIT_YN =KJFMi.dsGet(ds, arg_row, "TITLE_HIT_YN");
		this.TITLE_IP_YN =KJFMi.dsGet(ds, arg_row, "TITLE_IP_YN");
		this.HEADER_HTML =KJFMi.dsGet(ds, arg_row, "HEADER_HTML");
		this.MAIN_HTML =KJFMi.dsGet(ds, arg_row, "MAIN_HTML");
		this.BOTTOM_HTML =KJFMi.dsGet(ds, arg_row, "BOTTOM_HTML");
		this.LIST_LEVEL =KJFMi.dsGet(ds, arg_row, "LIST_LEVEL");
		this.READ_LEVEL =KJFMi.dsGet(ds, arg_row, "READ_LEVEL");
		this.WRITE_LEVEL =KJFMi.dsGet(ds, arg_row, "WRITE_LEVEL");
		this.ATTACH_YN =KJFMi.dsGet(ds, arg_row, "ATTACH_YN");
		this.FILE_SIZE =KJFMi.dsGet(ds, arg_row, "FILE_SIZE");
		this.ATT_NUM =KJFMi.dsGet(ds, arg_row, "ATT_NUM");
		this.REPLY_YN =KJFMi.dsGet(ds, arg_row, "REPLY_YN");
		this.ONE_LINE_YN =KJFMi.dsGet(ds, arg_row, "ONE_LINE_YN");
		this.SECRET_YN =KJFMi.dsGet(ds, arg_row, "SECRET_YN");
		this.USE_YN =KJFMi.dsGet(ds, arg_row, "USE_YN");
		this.DIV_USE_YN =KJFMi.dsGet(ds, arg_row, "DIV_USE_YN");
		this.SD_DIV_YN =KJFMi.dsGet(ds, arg_row, "SD_DIV_YN");
		this.SGG_DIV_YN =KJFMi.dsGet(ds, arg_row, "SGG_DIV_YN");
		this.VIEW_LIST_YN =KJFMi.dsGet(ds, arg_row, "VIEW_LIST_YN");
		this.ONE_ONE_YN =KJFMi.dsGet(ds, arg_row, "ONE_ONE_YN");
		this.FILTER =KJFMi.dsGet(ds, arg_row, "FILTER");
		this.TABLE_ONE_YN =KJFMi.dsGet(ds, arg_row, "TABLE_ONE_YN");
		this.SUBJ_1 =KJFMi.dsGet(ds, arg_row, "SUBJ_1");
		this.SUBJ_2 =KJFMi.dsGet(ds, arg_row, "SUBJ_2");
		this.SUBJ_3 =KJFMi.dsGet(ds, arg_row, "SUBJ_3");
		this.SUBJ_4 =KJFMi.dsGet(ds, arg_row, "SUBJ_4");
		this.SUBJ_5 =KJFMi.dsGet(ds, arg_row, "SUBJ_5");
		this.SUBJ_6 =KJFMi.dsGet(ds, arg_row, "SUBJ_6");
		this.SUBJ_7 =KJFMi.dsGet(ds, arg_row, "SUBJ_7");
		this.SUBJ_8 =KJFMi.dsGet(ds, arg_row, "SUBJ_8");
		this.SUBJ_9 =KJFMi.dsGet(ds, arg_row, "SUBJ_9");
		this.SUBJ_10 =KJFMi.dsGet(ds, arg_row, "SUBJ_10");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.PUBLIC_DIV_YN =KJFMi.dsGet(ds, arg_row, "PUBLIC_DIV_YN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCT_ID(){
             return CT_ID;
     };
  
     public String getBOARD_NAME(){
             return BOARD_NAME;
     };
  
     public String getBOARD_URL(){
             return BOARD_URL;
     };
  
     public String getBOARD_CATEGORY(){
             return BOARD_CATEGORY;
     };
  
     public String getBOARD_TYPE(){
             return BOARD_TYPE;
     };
  
     public String getBOARD_SKIN(){
             return BOARD_SKIN;
     };
  
     public String getBOARD_WIDTH(){
             return BOARD_WIDTH;
     };
  
     public String getBOARD_ALIGN(){
             return BOARD_ALIGN;
     };
  
     public String getBBS_OWNER(){
             return BBS_OWNER;
     };
  
     public String getBBS_GROUP(){
             return BBS_GROUP;
     };
  
     public String getBBS_DEPTH(){
             return BBS_DEPTH;
     };
  
     public String getCUT_TITLE(){
             return CUT_TITLE;
     };
  
     public String getROWPERPAGE(){
             return ROWPERPAGE;
     };
  
     public String getNEW_DAY(){
             return NEW_DAY;
     };
  
     public String getTITLE_WRT_YN(){
             return TITLE_WRT_YN;
     };
  
     public String getTITLE_DATE_YN(){
             return TITLE_DATE_YN;
     };
  
     public String getTITLE_HIT_YN(){
             return TITLE_HIT_YN;
     };
  
     public String getTITLE_IP_YN(){
             return TITLE_IP_YN;
     };
  
     public String getHEADER_HTML(){
             return HEADER_HTML;
     };
  
     public String getMAIN_HTML(){
             return MAIN_HTML;
     };
  
     public String getBOTTOM_HTML(){
             return BOTTOM_HTML;
     };
  
     public String getLIST_LEVEL(){
             return LIST_LEVEL;
     };
  
     public String getREAD_LEVEL(){
             return READ_LEVEL;
     };
  
     public String getWRITE_LEVEL(){
             return WRITE_LEVEL;
     };
  
     public String getATTACH_YN(){
             return ATTACH_YN;
     };
  
     public String getFILE_SIZE(){
             return FILE_SIZE;
     };
  
     public String getATT_NUM(){
             return ATT_NUM;
     };
  
     public String getREPLY_YN(){
             return REPLY_YN;
     };
  
     public String getONE_LINE_YN(){
             return ONE_LINE_YN;
     };
  
     public String getSECRET_YN(){
             return SECRET_YN;
     };
  
     public String getUSE_YN(){
             return USE_YN;
     };
  
     public String getDIV_USE_YN(){
             return DIV_USE_YN;
     };
  
     public String getSD_DIV_YN(){
             return SD_DIV_YN;
     };
  
     public String getSGG_DIV_YN(){
             return SGG_DIV_YN;
     };
  
     public String getVIEW_LIST_YN(){
             return VIEW_LIST_YN;
     };
  
     public String getONE_ONE_YN(){
             return ONE_ONE_YN;
     };
  
     public String getFILTER(){
             return FILTER;
     };
  
     public String getTABLE_ONE_YN(){
             return TABLE_ONE_YN;
     };
  
     public String getSUBJ_1(){
             return SUBJ_1;
     };
  
     public String getSUBJ_2(){
             return SUBJ_2;
     };
  
     public String getSUBJ_3(){
             return SUBJ_3;
     };
  
     public String getSUBJ_4(){
             return SUBJ_4;
     };
  
     public String getSUBJ_5(){
             return SUBJ_5;
     };
  
     public String getSUBJ_6(){
             return SUBJ_6;
     };
  
     public String getSUBJ_7(){
             return SUBJ_7;
     };
  
     public String getSUBJ_8(){
             return SUBJ_8;
     };
  
     public String getSUBJ_9(){
             return SUBJ_9;
     };
  
     public String getSUBJ_10(){
             return SUBJ_10;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getPUBLIC_DIV_YN(){
             return PUBLIC_DIV_YN;
     };
  

//Setter 함수를 만든다
  
     public void setCT_ID(String CT_ID){
            this.CT_ID=CT_ID;
     };
  
     public void setBOARD_NAME(String BOARD_NAME){
            this.BOARD_NAME=BOARD_NAME;
     };
  
     public void setBOARD_URL(String BOARD_URL){
            this.BOARD_URL=BOARD_URL;
     };
  
     public void setBOARD_CATEGORY(String BOARD_CATEGORY){
            this.BOARD_CATEGORY=BOARD_CATEGORY;
     };
  
     public void setBOARD_TYPE(String BOARD_TYPE){
            this.BOARD_TYPE=BOARD_TYPE;
     };
  
     public void setBOARD_SKIN(String BOARD_SKIN){
            this.BOARD_SKIN=BOARD_SKIN;
     };
  
     public void setBOARD_WIDTH(String BOARD_WIDTH){
            this.BOARD_WIDTH=BOARD_WIDTH;
     };
  
     public void setBOARD_ALIGN(String BOARD_ALIGN){
            this.BOARD_ALIGN=BOARD_ALIGN;
     };
  
     public void setBBS_OWNER(String BBS_OWNER){
            this.BBS_OWNER=BBS_OWNER;
     };
  
     public void setBBS_GROUP(String BBS_GROUP){
            this.BBS_GROUP=BBS_GROUP;
     };
  
     public void setBBS_DEPTH(String BBS_DEPTH){
            this.BBS_DEPTH=BBS_DEPTH;
     };
  
     public void setCUT_TITLE(String CUT_TITLE){
            this.CUT_TITLE=CUT_TITLE;
     };
  
     public void setROWPERPAGE(String ROWPERPAGE){
            this.ROWPERPAGE=ROWPERPAGE;
     };
  
     public void setNEW_DAY(String NEW_DAY){
            this.NEW_DAY=NEW_DAY;
     };
  
     public void setTITLE_WRT_YN(String TITLE_WRT_YN){
            this.TITLE_WRT_YN=TITLE_WRT_YN;
     };
  
     public void setTITLE_DATE_YN(String TITLE_DATE_YN){
            this.TITLE_DATE_YN=TITLE_DATE_YN;
     };
  
     public void setTITLE_HIT_YN(String TITLE_HIT_YN){
            this.TITLE_HIT_YN=TITLE_HIT_YN;
     };
  
     public void setTITLE_IP_YN(String TITLE_IP_YN){
            this.TITLE_IP_YN=TITLE_IP_YN;
     };
  
     public void setHEADER_HTML(String HEADER_HTML){
            this.HEADER_HTML=HEADER_HTML;
     };
  
     public void setMAIN_HTML(String MAIN_HTML){
            this.MAIN_HTML=MAIN_HTML;
     };
  
     public void setBOTTOM_HTML(String BOTTOM_HTML){
            this.BOTTOM_HTML=BOTTOM_HTML;
     };
  
     public void setLIST_LEVEL(String LIST_LEVEL){
            this.LIST_LEVEL=LIST_LEVEL;
     };
  
     public void setREAD_LEVEL(String READ_LEVEL){
            this.READ_LEVEL=READ_LEVEL;
     };
  
     public void setWRITE_LEVEL(String WRITE_LEVEL){
            this.WRITE_LEVEL=WRITE_LEVEL;
     };
  
     public void setATTACH_YN(String ATTACH_YN){
            this.ATTACH_YN=ATTACH_YN;
     };
  
     public void setFILE_SIZE(String FILE_SIZE){
            this.FILE_SIZE=FILE_SIZE;
     };
  
     public void setATT_NUM(String ATT_NUM){
            this.ATT_NUM=ATT_NUM;
     };
  
     public void setREPLY_YN(String REPLY_YN){
            this.REPLY_YN=REPLY_YN;
     };
  
     public void setONE_LINE_YN(String ONE_LINE_YN){
            this.ONE_LINE_YN=ONE_LINE_YN;
     };
  
     public void setSECRET_YN(String SECRET_YN){
            this.SECRET_YN=SECRET_YN;
     };
  
     public void setUSE_YN(String USE_YN){
            this.USE_YN=USE_YN;
     };
  
     public void setDIV_USE_YN(String DIV_USE_YN){
            this.DIV_USE_YN=DIV_USE_YN;
     };
  
     public void setSD_DIV_YN(String SD_DIV_YN){
            this.SD_DIV_YN=SD_DIV_YN;
     };
  
     public void setSGG_DIV_YN(String SGG_DIV_YN){
            this.SGG_DIV_YN=SGG_DIV_YN;
     };
  
     public void setVIEW_LIST_YN(String VIEW_LIST_YN){
            this.VIEW_LIST_YN=VIEW_LIST_YN;
     };
  
     public void setONE_ONE_YN(String ONE_ONE_YN){
            this.ONE_ONE_YN=ONE_ONE_YN;
     };
  
     public void setFILTER(String FILTER){
            this.FILTER=FILTER;
     };
  
     public void setTABLE_ONE_YN(String TABLE_ONE_YN){
            this.TABLE_ONE_YN=TABLE_ONE_YN;
     };
  
     public void setSUBJ_1(String SUBJ_1){
            this.SUBJ_1=SUBJ_1;
     };
  
     public void setSUBJ_2(String SUBJ_2){
            this.SUBJ_2=SUBJ_2;
     };
  
     public void setSUBJ_3(String SUBJ_3){
            this.SUBJ_3=SUBJ_3;
     };
  
     public void setSUBJ_4(String SUBJ_4){
            this.SUBJ_4=SUBJ_4;
     };
  
     public void setSUBJ_5(String SUBJ_5){
            this.SUBJ_5=SUBJ_5;
     };
  
     public void setSUBJ_6(String SUBJ_6){
            this.SUBJ_6=SUBJ_6;
     };
  
     public void setSUBJ_7(String SUBJ_7){
            this.SUBJ_7=SUBJ_7;
     };
  
     public void setSUBJ_8(String SUBJ_8){
            this.SUBJ_8=SUBJ_8;
     };
  
     public void setSUBJ_9(String SUBJ_9){
            this.SUBJ_9=SUBJ_9;
     };
  
     public void setSUBJ_10(String SUBJ_10){
            this.SUBJ_10=SUBJ_10;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setPUBLIC_DIV_YN(String PUBLIC_DIV_YN){
            this.PUBLIC_DIV_YN=PUBLIC_DIV_YN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CT_ID:"+ this.getCT_ID()+"\n");
      
      strB.append("BOARD_NAME:"+ this.getBOARD_NAME()+"\n");
      
      strB.append("BOARD_URL:"+ this.getBOARD_URL()+"\n");
      
      strB.append("BOARD_CATEGORY:"+ this.getBOARD_CATEGORY()+"\n");
      
      strB.append("BOARD_TYPE:"+ this.getBOARD_TYPE()+"\n");
      
      strB.append("BOARD_SKIN:"+ this.getBOARD_SKIN()+"\n");
      
      strB.append("BOARD_WIDTH:"+ this.getBOARD_WIDTH()+"\n");
      
      strB.append("BOARD_ALIGN:"+ this.getBOARD_ALIGN()+"\n");
      
      strB.append("BBS_OWNER:"+ this.getBBS_OWNER()+"\n");
      
      strB.append("BBS_GROUP:"+ this.getBBS_GROUP()+"\n");
      
      strB.append("BBS_DEPTH:"+ this.getBBS_DEPTH()+"\n");
      
      strB.append("CUT_TITLE:"+ this.getCUT_TITLE()+"\n");
      
      strB.append("ROWPERPAGE:"+ this.getROWPERPAGE()+"\n");
      
      strB.append("NEW_DAY:"+ this.getNEW_DAY()+"\n");
      
      strB.append("TITLE_WRT_YN:"+ this.getTITLE_WRT_YN()+"\n");
      
      strB.append("TITLE_DATE_YN:"+ this.getTITLE_DATE_YN()+"\n");
      
      strB.append("TITLE_HIT_YN:"+ this.getTITLE_HIT_YN()+"\n");
      
      strB.append("TITLE_IP_YN:"+ this.getTITLE_IP_YN()+"\n");
      
      strB.append("HEADER_HTML:"+ this.getHEADER_HTML()+"\n");
      
      strB.append("MAIN_HTML:"+ this.getMAIN_HTML()+"\n");
      
      strB.append("BOTTOM_HTML:"+ this.getBOTTOM_HTML()+"\n");
      
      strB.append("LIST_LEVEL:"+ this.getLIST_LEVEL()+"\n");
      
      strB.append("READ_LEVEL:"+ this.getREAD_LEVEL()+"\n");
      
      strB.append("WRITE_LEVEL:"+ this.getWRITE_LEVEL()+"\n");
      
      strB.append("ATTACH_YN:"+ this.getATTACH_YN()+"\n");
      
      strB.append("FILE_SIZE:"+ this.getFILE_SIZE()+"\n");
      
      strB.append("ATT_NUM:"+ this.getATT_NUM()+"\n");
      
      strB.append("REPLY_YN:"+ this.getREPLY_YN()+"\n");
      
      strB.append("ONE_LINE_YN:"+ this.getONE_LINE_YN()+"\n");
      
      strB.append("SECRET_YN:"+ this.getSECRET_YN()+"\n");
      
      strB.append("USE_YN:"+ this.getUSE_YN()+"\n");
      
      strB.append("DIV_USE_YN:"+ this.getDIV_USE_YN()+"\n");
      
      strB.append("SD_DIV_YN:"+ this.getSD_DIV_YN()+"\n");
      
      strB.append("SGG_DIV_YN:"+ this.getSGG_DIV_YN()+"\n");
      
      strB.append("VIEW_LIST_YN:"+ this.getVIEW_LIST_YN()+"\n");
      
      strB.append("ONE_ONE_YN:"+ this.getONE_ONE_YN()+"\n");
      
      strB.append("FILTER:"+ this.getFILTER()+"\n");
      
      strB.append("TABLE_ONE_YN:"+ this.getTABLE_ONE_YN()+"\n");
      
      strB.append("SUBJ_1:"+ this.getSUBJ_1()+"\n");
      
      strB.append("SUBJ_2:"+ this.getSUBJ_2()+"\n");
      
      strB.append("SUBJ_3:"+ this.getSUBJ_3()+"\n");
      
      strB.append("SUBJ_4:"+ this.getSUBJ_4()+"\n");
      
      strB.append("SUBJ_5:"+ this.getSUBJ_5()+"\n");
      
      strB.append("SUBJ_6:"+ this.getSUBJ_6()+"\n");
      
      strB.append("SUBJ_7:"+ this.getSUBJ_7()+"\n");
      
      strB.append("SUBJ_8:"+ this.getSUBJ_8()+"\n");
      
      strB.append("SUBJ_9:"+ this.getSUBJ_9()+"\n");
      
      strB.append("SUBJ_10:"+ this.getSUBJ_10()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("PUBLIC_DIV_YN:"+ this.getPUBLIC_DIV_YN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_BBS_COM_CTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_BBS_COM_CTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_BBS_COM_CTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_BBS_COM_CTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_BBS_COM_CTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getCT_ID();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_BBS_COM_CTEntity();
  }

  public ValueObject getClone(){
         PT_BBS_COM_CTEntity newEnt = new PT_BBS_COM_CTEntity();
	 
          newEnt.setCT_ID(this.getCT_ID());
         
          newEnt.setBOARD_NAME(this.getBOARD_NAME());
         
          newEnt.setBOARD_URL(this.getBOARD_URL());
         
          newEnt.setBOARD_CATEGORY(this.getBOARD_CATEGORY());
         
          newEnt.setBOARD_TYPE(this.getBOARD_TYPE());
         
          newEnt.setBOARD_SKIN(this.getBOARD_SKIN());
         
          newEnt.setBOARD_WIDTH(this.getBOARD_WIDTH());
         
          newEnt.setBOARD_ALIGN(this.getBOARD_ALIGN());
         
          newEnt.setBBS_OWNER(this.getBBS_OWNER());
         
          newEnt.setBBS_GROUP(this.getBBS_GROUP());
         
          newEnt.setBBS_DEPTH(this.getBBS_DEPTH());
         
          newEnt.setCUT_TITLE(this.getCUT_TITLE());
         
          newEnt.setROWPERPAGE(this.getROWPERPAGE());
         
          newEnt.setNEW_DAY(this.getNEW_DAY());
         
          newEnt.setTITLE_WRT_YN(this.getTITLE_WRT_YN());
         
          newEnt.setTITLE_DATE_YN(this.getTITLE_DATE_YN());
         
          newEnt.setTITLE_HIT_YN(this.getTITLE_HIT_YN());
         
          newEnt.setTITLE_IP_YN(this.getTITLE_IP_YN());
         
          newEnt.setHEADER_HTML(this.getHEADER_HTML());
         
          newEnt.setMAIN_HTML(this.getMAIN_HTML());
         
          newEnt.setBOTTOM_HTML(this.getBOTTOM_HTML());
         
          newEnt.setLIST_LEVEL(this.getLIST_LEVEL());
         
          newEnt.setREAD_LEVEL(this.getREAD_LEVEL());
         
          newEnt.setWRITE_LEVEL(this.getWRITE_LEVEL());
         
          newEnt.setATTACH_YN(this.getATTACH_YN());
         
          newEnt.setFILE_SIZE(this.getFILE_SIZE());
         
          newEnt.setATT_NUM(this.getATT_NUM());
         
          newEnt.setREPLY_YN(this.getREPLY_YN());
         
          newEnt.setONE_LINE_YN(this.getONE_LINE_YN());
         
          newEnt.setSECRET_YN(this.getSECRET_YN());
         
          newEnt.setUSE_YN(this.getUSE_YN());
         
          newEnt.setDIV_USE_YN(this.getDIV_USE_YN());
         
          newEnt.setSD_DIV_YN(this.getSD_DIV_YN());
         
          newEnt.setSGG_DIV_YN(this.getSGG_DIV_YN());
         
          newEnt.setVIEW_LIST_YN(this.getVIEW_LIST_YN());
         
          newEnt.setONE_ONE_YN(this.getONE_ONE_YN());
         
          newEnt.setFILTER(this.getFILTER());
         
          newEnt.setTABLE_ONE_YN(this.getTABLE_ONE_YN());
         
          newEnt.setSUBJ_1(this.getSUBJ_1());
         
          newEnt.setSUBJ_2(this.getSUBJ_2());
         
          newEnt.setSUBJ_3(this.getSUBJ_3());
         
          newEnt.setSUBJ_4(this.getSUBJ_4());
         
          newEnt.setSUBJ_5(this.getSUBJ_5());
         
          newEnt.setSUBJ_6(this.getSUBJ_6());
         
          newEnt.setSUBJ_7(this.getSUBJ_7());
         
          newEnt.setSUBJ_8(this.getSUBJ_8());
         
          newEnt.setSUBJ_9(this.getSUBJ_9());
         
          newEnt.setSUBJ_10(this.getSUBJ_10());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setPUBLIC_DIV_YN(this.getPUBLIC_DIV_YN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_BBS_COM_CTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCT_ID();
        
             case 2 :
                 return  this.getBOARD_NAME();
        
             case 3 :
                 return  this.getBOARD_URL();
        
             case 4 :
                 return  this.getBOARD_CATEGORY();
        
             case 5 :
                 return  this.getBOARD_TYPE();
        
             case 6 :
                 return  this.getBOARD_SKIN();
        
             case 7 :
                 return  this.getBOARD_WIDTH();
        
             case 8 :
                 return  this.getBOARD_ALIGN();
        
             case 9 :
                 return  this.getBBS_OWNER();
        
             case 10 :
                 return  this.getBBS_GROUP();
        
             case 11 :
                 return  this.getBBS_DEPTH();
        
             case 12 :
                 return  this.getCUT_TITLE();
        
             case 13 :
                 return  this.getROWPERPAGE();
        
             case 14 :
                 return  this.getNEW_DAY();
        
             case 15 :
                 return  this.getTITLE_WRT_YN();
        
             case 16 :
                 return  this.getTITLE_DATE_YN();
        
             case 17 :
                 return  this.getTITLE_HIT_YN();
        
             case 18 :
                 return  this.getTITLE_IP_YN();
        
             case 19 :
                 return  this.getHEADER_HTML();
        
             case 20 :
                 return  this.getMAIN_HTML();
        
             case 21 :
                 return  this.getBOTTOM_HTML();
        
             case 22 :
                 return  this.getLIST_LEVEL();
        
             case 23 :
                 return  this.getREAD_LEVEL();
        
             case 24 :
                 return  this.getWRITE_LEVEL();
        
             case 25 :
                 return  this.getATTACH_YN();
        
             case 26 :
                 return  this.getFILE_SIZE();
        
             case 27 :
                 return  this.getATT_NUM();
        
             case 28 :
                 return  this.getREPLY_YN();
        
             case 29 :
                 return  this.getONE_LINE_YN();
        
             case 30 :
                 return  this.getSECRET_YN();
        
             case 31 :
                 return  this.getUSE_YN();
        
             case 32 :
                 return  this.getDIV_USE_YN();
        
             case 33 :
                 return  this.getSD_DIV_YN();
        
             case 34 :
                 return  this.getSGG_DIV_YN();
        
             case 35 :
                 return  this.getVIEW_LIST_YN();
        
             case 36 :
                 return  this.getONE_ONE_YN();
        
             case 37 :
                 return  this.getFILTER();
        
             case 38 :
                 return  this.getTABLE_ONE_YN();
        
             case 39 :
                 return  this.getSUBJ_1();
        
             case 40 :
                 return  this.getSUBJ_2();
        
             case 41 :
                 return  this.getSUBJ_3();
        
             case 42 :
                 return  this.getSUBJ_4();
        
             case 43 :
                 return  this.getSUBJ_5();
        
             case 44 :
                 return  this.getSUBJ_6();
        
             case 45 :
                 return  this.getSUBJ_7();
        
             case 46 :
                 return  this.getSUBJ_8();
        
             case 47 :
                 return  this.getSUBJ_9();
        
             case 48 :
                 return  this.getSUBJ_10();
        
             case 49 :
                 return  this.getUPD_DT();
        
             case 50 :
                 return  this.getWRT_ID();
        
             case 51 :
                 return  this.getINS_DT();
        
             case 52 :
                 return  this.getPUBLIC_DIV_YN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_BBS_COM_CTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCT_ID((String)value);
	            return;  
        
             case 2 :
                    this.setBOARD_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setBOARD_URL((String)value);
	            return;  
        
             case 4 :
                    this.setBOARD_CATEGORY((String)value);
	            return;  
        
             case 5 :
                    this.setBOARD_TYPE((String)value);
	            return;  
        
             case 6 :
                    this.setBOARD_SKIN((String)value);
	            return;  
        
             case 7 :
                    this.setBOARD_WIDTH((String)value);
	            return;  
        
             case 8 :
                    this.setBOARD_ALIGN((String)value);
	            return;  
        
             case 9 :
                    this.setBBS_OWNER((String)value);
	            return;  
        
             case 10 :
                    this.setBBS_GROUP((String)value);
	            return;  
        
             case 11 :
                    this.setBBS_DEPTH((String)value);
	            return;  
        
             case 12 :
                    this.setCUT_TITLE((String)value);
	            return;  
        
             case 13 :
                    this.setROWPERPAGE((String)value);
	            return;  
        
             case 14 :
                    this.setNEW_DAY((String)value);
	            return;  
        
             case 15 :
                    this.setTITLE_WRT_YN((String)value);
	            return;  
        
             case 16 :
                    this.setTITLE_DATE_YN((String)value);
	            return;  
        
             case 17 :
                    this.setTITLE_HIT_YN((String)value);
	            return;  
        
             case 18 :
                    this.setTITLE_IP_YN((String)value);
	            return;  
        
             case 19 :
                    this.setHEADER_HTML((String)value);
	            return;  
        
             case 20 :
                    this.setMAIN_HTML((String)value);
	            return;  
        
             case 21 :
                    this.setBOTTOM_HTML((String)value);
	            return;  
        
             case 22 :
                    this.setLIST_LEVEL((String)value);
	            return;  
        
             case 23 :
                    this.setREAD_LEVEL((String)value);
	            return;  
        
             case 24 :
                    this.setWRITE_LEVEL((String)value);
	            return;  
        
             case 25 :
                    this.setATTACH_YN((String)value);
	            return;  
        
             case 26 :
                    this.setFILE_SIZE((String)value);
	            return;  
        
             case 27 :
                    this.setATT_NUM((String)value);
	            return;  
        
             case 28 :
                    this.setREPLY_YN((String)value);
	            return;  
        
             case 29 :
                    this.setONE_LINE_YN((String)value);
	            return;  
        
             case 30 :
                    this.setSECRET_YN((String)value);
	            return;  
        
             case 31 :
                    this.setUSE_YN((String)value);
	            return;  
        
             case 32 :
                    this.setDIV_USE_YN((String)value);
	            return;  
        
             case 33 :
                    this.setSD_DIV_YN((String)value);
	            return;  
        
             case 34 :
                    this.setSGG_DIV_YN((String)value);
	            return;  
        
             case 35 :
                    this.setVIEW_LIST_YN((String)value);
	            return;  
        
             case 36 :
                    this.setONE_ONE_YN((String)value);
	            return;  
        
             case 37 :
                    this.setFILTER((String)value);
	            return;  
        
             case 38 :
                    this.setTABLE_ONE_YN((String)value);
	            return;  
        
             case 39 :
                    this.setSUBJ_1((String)value);
	            return;  
        
             case 40 :
                    this.setSUBJ_2((String)value);
	            return;  
        
             case 41 :
                    this.setSUBJ_3((String)value);
	            return;  
        
             case 42 :
                    this.setSUBJ_4((String)value);
	            return;  
        
             case 43 :
                    this.setSUBJ_5((String)value);
	            return;  
        
             case 44 :
                    this.setSUBJ_6((String)value);
	            return;  
        
             case 45 :
                    this.setSUBJ_7((String)value);
	            return;  
        
             case 46 :
                    this.setSUBJ_8((String)value);
	            return;  
        
             case 47 :
                    this.setSUBJ_9((String)value);
	            return;  
        
             case 48 :
                    this.setSUBJ_10((String)value);
	            return;  
        
             case 49 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 50 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 51 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 52 :
                    this.setPUBLIC_DIV_YN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_BBS_COM_CTHelper.toXML(this);
  }
  
}
