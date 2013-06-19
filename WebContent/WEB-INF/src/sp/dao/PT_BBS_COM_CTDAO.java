


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

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_BBS_COM_CTDAO  extends SuperToDB{

  private String default_fields[]={ "CT_ID" , "BOARD_NAME" , "BOARD_URL" , "BOARD_CATEGORY" , "BOARD_TYPE" , "BOARD_SKIN" , "BOARD_WIDTH" , "BOARD_ALIGN" , "BBS_OWNER" , "BBS_GROUP" , "BBS_DEPTH" , "CUT_TITLE" , "ROWPERPAGE" , "NEW_DAY" , "TITLE_WRT_YN" , "TITLE_DATE_YN" , "TITLE_HIT_YN" , "TITLE_IP_YN" , "HEADER_HTML" , "MAIN_HTML" , "BOTTOM_HTML" , "LIST_LEVEL" , "READ_LEVEL" , "WRITE_LEVEL" , "ATTACH_YN" , "FILE_SIZE" , "ATT_NUM" , "REPLY_YN" , "ONE_LINE_YN" , "SECRET_YN" , "USE_YN" , "DIV_USE_YN" , "SD_DIV_YN" , "SGG_DIV_YN" , "VIEW_LIST_YN" , "ONE_ONE_YN" , "FILTER" , "TABLE_ONE_YN" , "SUBJ_1" , "SUBJ_2" , "SUBJ_3" , "SUBJ_4" , "SUBJ_5" , "SUBJ_6" , "SUBJ_7" , "SUBJ_8" , "SUBJ_9" , "SUBJ_10" , "UPD_DT" , "WRT_ID" , "INS_DT" , "PUBLIC_DIV_YN" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : insert() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_BBS_COM_CT ")
    .append(" ( CT_ID,BOARD_NAME,BOARD_URL,BOARD_CATEGORY,BOARD_TYPE,BOARD_SKIN,BOARD_WIDTH,BOARD_ALIGN,BBS_OWNER,BBS_GROUP,BBS_DEPTH,CUT_TITLE,ROWPERPAGE,NEW_DAY,TITLE_WRT_YN,TITLE_DATE_YN,TITLE_HIT_YN,TITLE_IP_YN,HEADER_HTML,MAIN_HTML,BOTTOM_HTML,LIST_LEVEL,READ_LEVEL,WRITE_LEVEL,ATTACH_YN,FILE_SIZE,ATT_NUM,REPLY_YN,ONE_LINE_YN,SECRET_YN,USE_YN,DIV_USE_YN,SD_DIV_YN,SGG_DIV_YN,VIEW_LIST_YN,ONE_ONE_YN,FILTER,TABLE_ONE_YN,SUBJ_1,SUBJ_2,SUBJ_3,SUBJ_4,SUBJ_5,SUBJ_6,SUBJ_7,SUBJ_8,SUBJ_9,SUBJ_10,UPD_DT,WRT_ID,INS_DT,PUBLIC_DIV_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCT_ID()))
			.append(",")
           .append(toDB(entity.getBOARD_NAME()))
			.append(",")
           .append(toDB(entity.getBOARD_URL()))
			.append(",")
           .append(toDB(entity.getBOARD_CATEGORY()))
			.append(",")
           .append(toDB(entity.getBOARD_TYPE()))
			.append(",")
           .append(toDB(entity.getBOARD_SKIN()))
			.append(",")
           .append(toDB(entity.getBOARD_WIDTH()))
			.append(",")
           .append(toDB(entity.getBOARD_ALIGN()))
			.append(",")
           .append(toDB(entity.getBBS_OWNER()))
			.append(",")
           .append(toDB(entity.getBBS_GROUP()))
			.append(",")
           .append(toDB(entity.getBBS_DEPTH()))
			.append(",")
           .append(toDB(entity.getCUT_TITLE()))
			.append(",")
           .append(toDB(entity.getROWPERPAGE()))
			.append(",")
           .append(toDB(entity.getNEW_DAY()))
			.append(",")
           .append(toDB(entity.getTITLE_WRT_YN()))
			.append(",")
           .append(toDB(entity.getTITLE_DATE_YN()))
			.append(",")
           .append(toDB(entity.getTITLE_HIT_YN()))
			.append(",")
           .append(toDB(entity.getTITLE_IP_YN()))
			.append(",")
		   .append("?")
			.append(",")
		   .append("?")
			.append(",")
		   .append("?")
			.append(",")
           .append(toDB(entity.getLIST_LEVEL()))
			.append(",")
           .append(toDB(entity.getREAD_LEVEL()))
			.append(",")
           .append(toDB(entity.getWRITE_LEVEL()))
			.append(",")
           .append(toDB(entity.getATTACH_YN()))
			.append(",")
           .append(toDB(entity.getFILE_SIZE()))
			.append(",")
           .append(toDB(entity.getATT_NUM()))
			.append(",")
           .append(toDB(entity.getREPLY_YN()))
			.append(",")
           .append(toDB(entity.getONE_LINE_YN()))
			.append(",")
           .append(toDB(entity.getSECRET_YN()))
			.append(",")
           .append(toDB(entity.getUSE_YN()))
			.append(",")
           .append(toDB(entity.getDIV_USE_YN()))
			.append(",")
           .append(toDB(entity.getSD_DIV_YN()))
			.append(",")
           .append(toDB(entity.getSGG_DIV_YN()))
			.append(",")
           .append(toDB(entity.getVIEW_LIST_YN()))
			.append(",")
           .append(toDB(entity.getONE_ONE_YN()))
			.append(",")
           .append(toDB(entity.getFILTER()))
			.append(",")
           .append(toDB(entity.getTABLE_ONE_YN()))
			.append(",")
           .append(toDB(entity.getSUBJ_1()))
			.append(",")
           .append(toDB(entity.getSUBJ_2()))
			.append(",")
           .append(toDB(entity.getSUBJ_3()))
			.append(",")
           .append(toDB(entity.getSUBJ_4()))
			.append(",")
           .append(toDB(entity.getSUBJ_5()))
			.append(",")
           .append(toDB(entity.getSUBJ_6()))
			.append(",")
           .append(toDB(entity.getSUBJ_7()))
			.append(",")
           .append(toDB(entity.getSUBJ_8()))
			.append(",")
           .append(toDB(entity.getSUBJ_9()))
			.append(",")
           .append(toDB(entity.getSUBJ_10()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getPUBLIC_DIV_YN()))
			
    .append(" ) ");

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    int i=1;
	
	
	ps.setString(i++,entity.getHEADER_HTML());
		
	
	ps.setString(i++,entity.getMAIN_HTML());
		
	
	ps.setString(i++,entity.getBOTTOM_HTML());
		
    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;

   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }
    return result ;
  }



  public String insertSql( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : insert() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_BBS_COM_CT ")
    .append(" ( CT_ID,BOARD_NAME,BOARD_URL,BOARD_CATEGORY,BOARD_TYPE,BOARD_SKIN,BOARD_WIDTH,BOARD_ALIGN,BBS_OWNER,BBS_GROUP,BBS_DEPTH,CUT_TITLE,ROWPERPAGE,NEW_DAY,TITLE_WRT_YN,TITLE_DATE_YN,TITLE_HIT_YN,TITLE_IP_YN,HEADER_HTML,MAIN_HTML,BOTTOM_HTML,LIST_LEVEL,READ_LEVEL,WRITE_LEVEL,ATTACH_YN,FILE_SIZE,ATT_NUM,REPLY_YN,ONE_LINE_YN,SECRET_YN,USE_YN,DIV_USE_YN,SD_DIV_YN,SGG_DIV_YN,VIEW_LIST_YN,ONE_ONE_YN,FILTER,TABLE_ONE_YN,SUBJ_1,SUBJ_2,SUBJ_3,SUBJ_4,SUBJ_5,SUBJ_6,SUBJ_7,SUBJ_8,SUBJ_9,SUBJ_10,UPD_DT,WRT_ID,INS_DT,PUBLIC_DIV_YN ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getCT_ID()))
			.append(",")
           .append(toDB(entity.getBOARD_NAME()))
			.append(",")
           .append(toDB(entity.getBOARD_URL()))
			.append(",")
           .append(toDB(entity.getBOARD_CATEGORY()))
			.append(",")
           .append(toDB(entity.getBOARD_TYPE()))
			.append(",")
           .append(toDB(entity.getBOARD_SKIN()))
			.append(",")
           .append(toDB(entity.getBOARD_WIDTH()))
			.append(",")
           .append(toDB(entity.getBOARD_ALIGN()))
			.append(",")
           .append(toDB(entity.getBBS_OWNER()))
			.append(",")
           .append(toDB(entity.getBBS_GROUP()))
			.append(",")
           .append(toDB(entity.getBBS_DEPTH()))
			.append(",")
           .append(toDB(entity.getCUT_TITLE()))
			.append(",")
           .append(toDB(entity.getROWPERPAGE()))
			.append(",")
           .append(toDB(entity.getNEW_DAY()))
			.append(",")
           .append(toDB(entity.getTITLE_WRT_YN()))
			.append(",")
           .append(toDB(entity.getTITLE_DATE_YN()))
			.append(",")
           .append(toDB(entity.getTITLE_HIT_YN()))
			.append(",")
           .append(toDB(entity.getTITLE_IP_YN()))
			.append(",")
		   .append("?")
			.append(",")
		   .append("?")
			.append(",")
		   .append("?")
			.append(",")
           .append(toDB(entity.getLIST_LEVEL()))
			.append(",")
           .append(toDB(entity.getREAD_LEVEL()))
			.append(",")
           .append(toDB(entity.getWRITE_LEVEL()))
			.append(",")
           .append(toDB(entity.getATTACH_YN()))
			.append(",")
           .append(toDB(entity.getFILE_SIZE()))
			.append(",")
           .append(toDB(entity.getATT_NUM()))
			.append(",")
           .append(toDB(entity.getREPLY_YN()))
			.append(",")
           .append(toDB(entity.getONE_LINE_YN()))
			.append(",")
           .append(toDB(entity.getSECRET_YN()))
			.append(",")
           .append(toDB(entity.getUSE_YN()))
			.append(",")
           .append(toDB(entity.getDIV_USE_YN()))
			.append(",")
           .append(toDB(entity.getSD_DIV_YN()))
			.append(",")
           .append(toDB(entity.getSGG_DIV_YN()))
			.append(",")
           .append(toDB(entity.getVIEW_LIST_YN()))
			.append(",")
           .append(toDB(entity.getONE_ONE_YN()))
			.append(",")
           .append(toDB(entity.getFILTER()))
			.append(",")
           .append(toDB(entity.getTABLE_ONE_YN()))
			.append(",")
           .append(toDB(entity.getSUBJ_1()))
			.append(",")
           .append(toDB(entity.getSUBJ_2()))
			.append(",")
           .append(toDB(entity.getSUBJ_3()))
			.append(",")
           .append(toDB(entity.getSUBJ_4()))
			.append(",")
           .append(toDB(entity.getSUBJ_5()))
			.append(",")
           .append(toDB(entity.getSUBJ_6()))
			.append(",")
           .append(toDB(entity.getSUBJ_7()))
			.append(",")
           .append(toDB(entity.getSUBJ_8()))
			.append(",")
           .append(toDB(entity.getSUBJ_9()))
			.append(",")
           .append(toDB(entity.getSUBJ_10()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getPUBLIC_DIV_YN()))
			
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : update() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_CT  set ")
       
        .append("BOARD_NAME = ")
        .append(toDB(entity.getBOARD_NAME())).append(",")
        .append("BOARD_URL = ")
        .append(toDB(entity.getBOARD_URL())).append(",")
        .append("BOARD_CATEGORY = ")
        .append(toDB(entity.getBOARD_CATEGORY())).append(",")
        .append("BOARD_TYPE = ")
        .append(toDB(entity.getBOARD_TYPE())).append(",")
        .append("BOARD_SKIN = ")
        .append(toDB(entity.getBOARD_SKIN())).append(",")
        .append("BOARD_WIDTH = ")
        .append(toDB(entity.getBOARD_WIDTH())).append(",")
        .append("BOARD_ALIGN = ")
        .append(toDB(entity.getBOARD_ALIGN())).append(",")
        .append("BBS_OWNER = ")
        .append(toDB(entity.getBBS_OWNER())).append(",")
        .append("BBS_GROUP = ")
        .append(toDB(entity.getBBS_GROUP())).append(",")
        .append("BBS_DEPTH = ")
        .append(toDB(entity.getBBS_DEPTH())).append(",")
        .append("CUT_TITLE = ")
        .append(toDB(entity.getCUT_TITLE())).append(",")
        .append("ROWPERPAGE = ")
        .append(toDB(entity.getROWPERPAGE())).append(",")
        .append("NEW_DAY = ")
        .append(toDB(entity.getNEW_DAY())).append(",")
        .append("TITLE_WRT_YN = ")
        .append(toDB(entity.getTITLE_WRT_YN())).append(",")
        .append("TITLE_DATE_YN = ")
        .append(toDB(entity.getTITLE_DATE_YN())).append(",")
        .append("TITLE_HIT_YN = ")
        .append(toDB(entity.getTITLE_HIT_YN())).append(",")
        .append("TITLE_IP_YN = ")
        .append(toDB(entity.getTITLE_IP_YN())).append(",")
        .append("HEADER_HTML = ")
        .append("?").append(",")
        .append("MAIN_HTML = ")
        .append("?").append(",")
        .append("BOTTOM_HTML = ")
        .append("?").append(",")
        .append("LIST_LEVEL = ")
        .append(toDB(entity.getLIST_LEVEL())).append(",")
        .append("READ_LEVEL = ")
        .append(toDB(entity.getREAD_LEVEL())).append(",")
        .append("WRITE_LEVEL = ")
        .append(toDB(entity.getWRITE_LEVEL())).append(",")
        .append("ATTACH_YN = ")
        .append(toDB(entity.getATTACH_YN())).append(",")
        .append("FILE_SIZE = ")
        .append(toDB(entity.getFILE_SIZE())).append(",")
        .append("ATT_NUM = ")
        .append(toDB(entity.getATT_NUM())).append(",")
        .append("REPLY_YN = ")
        .append(toDB(entity.getREPLY_YN())).append(",")
        .append("ONE_LINE_YN = ")
        .append(toDB(entity.getONE_LINE_YN())).append(",")
        .append("SECRET_YN = ")
        .append(toDB(entity.getSECRET_YN())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN())).append(",")
        .append("DIV_USE_YN = ")
        .append(toDB(entity.getDIV_USE_YN())).append(",")
        .append("SD_DIV_YN = ")
        .append(toDB(entity.getSD_DIV_YN())).append(",")
        .append("SGG_DIV_YN = ")
        .append(toDB(entity.getSGG_DIV_YN())).append(",")
        .append("VIEW_LIST_YN = ")
        .append(toDB(entity.getVIEW_LIST_YN())).append(",")
        .append("ONE_ONE_YN = ")
        .append(toDB(entity.getONE_ONE_YN())).append(",")
        .append("FILTER = ")
        .append(toDB(entity.getFILTER())).append(",")
        .append("TABLE_ONE_YN = ")
        .append(toDB(entity.getTABLE_ONE_YN())).append(",")
        .append("SUBJ_1 = ")
        .append(toDB(entity.getSUBJ_1())).append(",")
        .append("SUBJ_2 = ")
        .append(toDB(entity.getSUBJ_2())).append(",")
        .append("SUBJ_3 = ")
        .append(toDB(entity.getSUBJ_3())).append(",")
        .append("SUBJ_4 = ")
        .append(toDB(entity.getSUBJ_4())).append(",")
        .append("SUBJ_5 = ")
        .append(toDB(entity.getSUBJ_5())).append(",")
        .append("SUBJ_6 = ")
        .append(toDB(entity.getSUBJ_6())).append(",")
        .append("SUBJ_7 = ")
        .append(toDB(entity.getSUBJ_7())).append(",")
        .append("SUBJ_8 = ")
        .append(toDB(entity.getSUBJ_8())).append(",")
        .append("SUBJ_9 = ")
        .append(toDB(entity.getSUBJ_9())).append(",")
        .append("SUBJ_10 = ")
        .append(toDB(entity.getSUBJ_10())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("PUBLIC_DIV_YN = ")
        .append(toDB(entity.getPUBLIC_DIV_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and CT_ID = ").append( toDB(entity.getCT_ID()));
         

   KJFLog.sql(sb.toString());

   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int i=1;
	
	
	ps.setString(i++,entity.getHEADER_HTML());
		
	
	ps.setString(i++,entity.getMAIN_HTML());
		
	
	ps.setString(i++,entity.getBOTTOM_HTML());
		
    result =ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

    return result ;
  }


  public String  updateSql( ValueObject obj) throws SQLException{


    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : update() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_CT  set ")
       
        .append("BOARD_NAME = ")
        .append(toDB(entity.getBOARD_NAME())).append(",")
        .append("BOARD_URL = ")
        .append(toDB(entity.getBOARD_URL())).append(",")
        .append("BOARD_CATEGORY = ")
        .append(toDB(entity.getBOARD_CATEGORY())).append(",")
        .append("BOARD_TYPE = ")
        .append(toDB(entity.getBOARD_TYPE())).append(",")
        .append("BOARD_SKIN = ")
        .append(toDB(entity.getBOARD_SKIN())).append(",")
        .append("BOARD_WIDTH = ")
        .append(toDB(entity.getBOARD_WIDTH())).append(",")
        .append("BOARD_ALIGN = ")
        .append(toDB(entity.getBOARD_ALIGN())).append(",")
        .append("BBS_OWNER = ")
        .append(toDB(entity.getBBS_OWNER())).append(",")
        .append("BBS_GROUP = ")
        .append(toDB(entity.getBBS_GROUP())).append(",")
        .append("BBS_DEPTH = ")
        .append(toDB(entity.getBBS_DEPTH())).append(",")
        .append("CUT_TITLE = ")
        .append(toDB(entity.getCUT_TITLE())).append(",")
        .append("ROWPERPAGE = ")
        .append(toDB(entity.getROWPERPAGE())).append(",")
        .append("NEW_DAY = ")
        .append(toDB(entity.getNEW_DAY())).append(",")
        .append("TITLE_WRT_YN = ")
        .append(toDB(entity.getTITLE_WRT_YN())).append(",")
        .append("TITLE_DATE_YN = ")
        .append(toDB(entity.getTITLE_DATE_YN())).append(",")
        .append("TITLE_HIT_YN = ")
        .append(toDB(entity.getTITLE_HIT_YN())).append(",")
        .append("TITLE_IP_YN = ")
        .append(toDB(entity.getTITLE_IP_YN())).append(",")
        .append("HEADER_HTML = ")
        .append("?").append(",")
        .append("MAIN_HTML = ")
        .append("?").append(",")
        .append("BOTTOM_HTML = ")
        .append("?").append(",")
        .append("LIST_LEVEL = ")
        .append(toDB(entity.getLIST_LEVEL())).append(",")
        .append("READ_LEVEL = ")
        .append(toDB(entity.getREAD_LEVEL())).append(",")
        .append("WRITE_LEVEL = ")
        .append(toDB(entity.getWRITE_LEVEL())).append(",")
        .append("ATTACH_YN = ")
        .append(toDB(entity.getATTACH_YN())).append(",")
        .append("FILE_SIZE = ")
        .append(toDB(entity.getFILE_SIZE())).append(",")
        .append("ATT_NUM = ")
        .append(toDB(entity.getATT_NUM())).append(",")
        .append("REPLY_YN = ")
        .append(toDB(entity.getREPLY_YN())).append(",")
        .append("ONE_LINE_YN = ")
        .append(toDB(entity.getONE_LINE_YN())).append(",")
        .append("SECRET_YN = ")
        .append(toDB(entity.getSECRET_YN())).append(",")
        .append("USE_YN = ")
        .append(toDB(entity.getUSE_YN())).append(",")
        .append("DIV_USE_YN = ")
        .append(toDB(entity.getDIV_USE_YN())).append(",")
        .append("SD_DIV_YN = ")
        .append(toDB(entity.getSD_DIV_YN())).append(",")
        .append("SGG_DIV_YN = ")
        .append(toDB(entity.getSGG_DIV_YN())).append(",")
        .append("VIEW_LIST_YN = ")
        .append(toDB(entity.getVIEW_LIST_YN())).append(",")
        .append("ONE_ONE_YN = ")
        .append(toDB(entity.getONE_ONE_YN())).append(",")
        .append("FILTER = ")
        .append(toDB(entity.getFILTER())).append(",")
        .append("TABLE_ONE_YN = ")
        .append(toDB(entity.getTABLE_ONE_YN())).append(",")
        .append("SUBJ_1 = ")
        .append(toDB(entity.getSUBJ_1())).append(",")
        .append("SUBJ_2 = ")
        .append(toDB(entity.getSUBJ_2())).append(",")
        .append("SUBJ_3 = ")
        .append(toDB(entity.getSUBJ_3())).append(",")
        .append("SUBJ_4 = ")
        .append(toDB(entity.getSUBJ_4())).append(",")
        .append("SUBJ_5 = ")
        .append(toDB(entity.getSUBJ_5())).append(",")
        .append("SUBJ_6 = ")
        .append(toDB(entity.getSUBJ_6())).append(",")
        .append("SUBJ_7 = ")
        .append(toDB(entity.getSUBJ_7())).append(",")
        .append("SUBJ_8 = ")
        .append(toDB(entity.getSUBJ_8())).append(",")
        .append("SUBJ_9 = ")
        .append(toDB(entity.getSUBJ_9())).append(",")
        .append("SUBJ_10 = ")
        .append(toDB(entity.getSUBJ_10())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("PUBLIC_DIV_YN = ")
        .append(toDB(entity.getPUBLIC_DIV_YN()))
        .append(" where  1=1 ");
       
         sb.append(" and CT_ID = ").append( toDB(entity.getCT_ID()));
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : updateModifiedOnly() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;

	HashMap clobs = new HashMap();
	clobs.put("HEADER_HTML","1");clobs.put("MAIN_HTML","1");clobs.put("BOTTOM_HTML","1");

	Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_CT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CT_ID = ").append(toDB(entity.getCT_ID()));
     

   KJFLog.sql( sb.toString());

    try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int k=1;
    for(int i=0 ; i < fields.length ; i++){
       if(clobs.containsKey(fields[i])){
    	   
    	   ps.setString(k++,(entity.getByName(fields[i])).toString() );
       }
    }

    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

	return result ;
  }




  public String updateModifiedOnlySql(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : updateModifiedOnly() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;


	HashMap clobs = new HashMap();
	clobs.put("HEADER_HTML","1");clobs.put("MAIN_HTML","1");clobs.put("BOTTOM_HTML","1");

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_CT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CT_ID = ").append(toDB(entity.getCT_ID()));
     

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : updateModifiedOnly() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;

	HashMap clobs = new HashMap();
	clobs.put("HEADER_HTML","1");clobs.put("MAIN_HTML","1");clobs.put("BOTTOM_HTML","1");

	Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_CT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CT_ID = ").append(toDB(entity.getCT_ID()));
     

   KJFLog.sql( sb.toString());

    try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int k=1;
    for(int i=0 ; i < fields.length ; i++){
       if(clobs.containsKey(fields[i])){
    	   
    	   ps.setString(k++,(entity.getByName(fields[i])).toString() );
       }
    }

    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

	return result ;
  }
  
  
   public String updateExcludeOnlySql(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : updateModifiedOnly() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;


	HashMap clobs = new HashMap();
	clobs.put("HEADER_HTML","1");clobs.put("MAIN_HTML","1");clobs.put("BOTTOM_HTML","1");


    if(fields==null)
	         throw new  SQLException("Field Name can not be Null");

    StringBuffer setString = new StringBuffer();
    boolean flag = false;
    for(int i=0 ; i < fields.length ; i++){
        if(fields[i] == null) throw new  SQLException("Field Name can not be Null");
        if(default_update_field.containsKey(fields[i]) == false){
           if(flag)
               setString.append(",");
           flag = true;
           if(clobs.containsKey(fields[i])){
        	   setString.append(fields[i]).append("=?") ;
           }else{
        	   setString.append(fields[i]).append("=").append(toDB(entity.getByName(fields[i]))) ;
           }
        }
    }
    if(flag = false)
       throw new  SQLException("Nothing to update");

    

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_BBS_COM_CT  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and CT_ID = ").append(toDB(entity.getCT_ID()));
     
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : delete() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_BBS_COM_CT  where  1=1")
      
	  .append(" and CT_ID = ").append(toDB(entity.getCT_ID()))
       ;

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    result = ps.executeUpdate();

   } catch (SQLException e) {
           throw e;
   } finally {
     if(ps!=null)
        ps.close();
     this.release(conn);
   }

   return result;
  }

  public String deleteSql(ValueObject obj) throws SQLException{

    if((obj instanceof PT_BBS_COM_CTEntity) == false){
        throw new  SQLException("DAO 에러(1): PT_BBS_COM_CT : delete() ");
    }
    PT_BBS_COM_CTEntity entity = (PT_BBS_COM_CTEntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_BBS_COM_CT  where  1=1")
      
	  .append(" and CT_ID = ").append(toDB(entity.getCT_ID()))
       ;


   return sb.toString();
  }


}//Class End
