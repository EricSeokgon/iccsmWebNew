


/*
*  Automatic generated  source
*  작  성  자 : 김경덕
*
*  테이블 명   :PT_M_MASTER
*  테이블 설명 :
*  테이블 PK   :
*               TMP_WRT_NUM
*               TMP_WRT_NUM
*               WRT_NUM
*               WRT_NUM
*  테이블 컬럼 :
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               WRT_DT:VARCHAR2(8):
*               REGR:VARCHAR2(16):
*               VIOL_CONT_CODE:VARCHAR2(50):
*               VIOL_DT:VARCHAR2(8):
*               D_PER_CODE:VARCHAR2(6):
*               DISPO_CONT:VARCHAR2(6):
*               DISPO_CAUSE:VARCHAR2(512):
*               DISPO_DT:VARCHAR2(8):
*               MOT_STE:VARCHAR2(6):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(30):
*               SIDO_CODE:VARCHAR2(4):
*               REMARK:VARCHAR2(256):
*               LEG_BAS:VARCHAR2(256):
*               SND_STE:VARCHAR2(1):
*               SND_DT:VARCHAR2(8):
*               HOME_NOTE:VARCHAR2(8):
*               NOTE_GUID_DT:VARCHAR2(8):
*               OFFI_REPORT_DT:VARCHAR2(8):
*               ASSO_GUILD_DT:VARCHAR2(8):
*               RECV_NUM:VARCHAR2(24):
*               DISPO_CONT2:VARCHAR2(50):
*               BUSISUSP_START_DT:VARCHAR2(8):
*               BUSISUSP_END_DT:VARCHAR2(8):
*               DOC_CODE:VARCHAR2(50):
*               PUNISHMENT_AGENCY:VARCHAR2(30):
*               DISPO_CONT_NM:VARCHAR2(50):
*               AT_RECV_NUM:VARCHAR2(12):
*               MAST_PROC:VARCHAR2(8):
*               COI_WRT_NUM:VARCHAR2(12):
*               TMP_WRT_NUM:VARCHAR2(12):
*               WRT_NUM:VARCHAR2(12):
*               WRT_DT:VARCHAR2(8):
*               REGR:VARCHAR2(16):
*               VIOL_CONT_CODE:VARCHAR2(50):
*               VIOL_DT:VARCHAR2(8):
*               D_PER_CODE:VARCHAR2(6):
*               DISPO_CONT:VARCHAR2(6):
*               DISPO_CAUSE:VARCHAR2(512):
*               DISPO_DT:VARCHAR2(8):
*               MOT_STE:VARCHAR2(6):
*               INS_DT:VARCHAR2(24):
*               UPD_DT:VARCHAR2(24):
*               WRT_ID:VARCHAR2(16):
*               SIDO_CODE:VARCHAR2(4):
*               REMARK:VARCHAR2(256):
*               LEG_BAS:VARCHAR2(256):
*               SND_STE:VARCHAR2(1):
*               SND_DT:VARCHAR2(8):
*               HOME_NOTE:VARCHAR2(8):
*               NOTE_GUID_DT:VARCHAR2(8):
*               OFFI_REPORT_DT:VARCHAR2(8):
*               ASSO_GUILD_DT:VARCHAR2(8):
*               RECV_NUM:VARCHAR2(24):
*               DISPO_CONT2:VARCHAR2(6):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_M_MASTERDAO  extends SuperToDB{

  private String default_fields[]={ "TMP_WRT_NUM" , "WRT_NUM" , "WRT_DT" , "REGR" , "VIOL_CONT_CODE" , "VIOL_DT" , "D_PER_CODE" , "DISPO_CONT" , "DISPO_CAUSE" , "DISPO_DT" , "MOT_STE" , "INS_DT" , "UPD_DT" , "WRT_ID" , "SIDO_CODE" , "REMARK" , "LEG_BAS" , "SND_STE" , "SND_DT" , "HOME_NOTE" , "NOTE_GUID_DT" , "OFFI_REPORT_DT" , "ASSO_GUILD_DT" , "RECV_NUM" , "DISPO_CONT2" , "BUSISUSP_START_DT" , "BUSISUSP_END_DT" , "DOC_CODE" , "PUNISHMENT_AGENCY" , "DISPO_CONT_NM" , "AT_RECV_NUM" , "MAST_PROC" , "COI_WRT_NUM"  };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : insert() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_MASTER ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,WRT_DT,REGR,VIOL_CONT_CODE,VIOL_DT,D_PER_CODE,DISPO_CONT,DISPO_CAUSE,DISPO_DT,MOT_STE,INS_DT,UPD_DT,WRT_ID,SIDO_CODE,REMARK,LEG_BAS,SND_STE,SND_DT,HOME_NOTE,NOTE_GUID_DT,OFFI_REPORT_DT,ASSO_GUILD_DT,RECV_NUM,DISPO_CONT2,BUSISUSP_START_DT,BUSISUSP_END_DT,DOC_CODE,PUNISHMENT_AGENCY,DISPO_CONT_NM,AT_RECV_NUM,MAST_PROC,COI_WRT_NUM ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			.append(",")
           .append(toDB(entity.getREGR()))
			.append(",")
           .append(toDB(entity.getVIOL_CONT_CODE()))
			.append(",")
           .append(toDB(entity.getVIOL_DT()))
			.append(",")
           .append(toDB(entity.getD_PER_CODE()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT()))
			.append(",")
           .append(toDB(entity.getDISPO_CAUSE()))
			.append(",")
           .append(toDB(entity.getDISPO_DT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getLEG_BAS()))
			.append(",")
           .append(toDB(entity.getSND_STE()))
			.append(",")
           .append(toDB(entity.getSND_DT()))
			.append(",")
           .append(toDB(entity.getHOME_NOTE()))
			.append(",")
           .append(toDB(entity.getNOTE_GUID_DT()))
			.append(",")
           .append(toDB(entity.getOFFI_REPORT_DT()))
			.append(",")
           .append(toDB(entity.getASSO_GUILD_DT()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT2()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_START_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_END_DT()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getPUNISHMENT_AGENCY()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT_NM()))
			.append(",")
           .append(toDB(entity.getAT_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getMAST_PROC()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
			           
			
    .append(" ) ");

   KJFLog.sql(sb.toString());


   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

    int i=1;
	
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

    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : insert() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;


  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_M_MASTER ")
    .append(" ( TMP_WRT_NUM,WRT_NUM,WRT_DT,REGR,VIOL_CONT_CODE,VIOL_DT,D_PER_CODE,DISPO_CONT,DISPO_CAUSE,DISPO_DT,MOT_STE,INS_DT,UPD_DT,WRT_ID,SIDO_CODE,REMARK,LEG_BAS,SND_STE,SND_DT,HOME_NOTE,NOTE_GUID_DT,OFFI_REPORT_DT,ASSO_GUILD_DT,RECV_NUM,DISPO_CONT2,BUSISUSP_START_DT,BUSISUSP_END_DT,DOC_CODE,PUNISHMENT_AGENCY,DISPO_CONT_NM,AT_RECV_NUM,MAST_PROC,COI_WRT_NUM ) ")
    .append(" values ( ")
      
           .append(toDB(entity.getTMP_WRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_NUM()))
			.append(",")
           .append(toDB(entity.getWRT_DT()))
			.append(",")
           .append(toDB(entity.getREGR()))
			.append(",")
           .append(toDB(entity.getVIOL_CONT_CODE()))
			.append(",")
           .append(toDB(entity.getVIOL_DT()))
			.append(",")
           .append(toDB(entity.getD_PER_CODE()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT()))
			.append(",")
           .append(toDB(entity.getDISPO_CAUSE()))
			.append(",")
           .append(toDB(entity.getDISPO_DT()))
			.append(",")
           .append(toDB(entity.getMOT_STE()))
			.append(",")
           .append(toDB(entity.getINS_DT()))
			.append(",")
           .append(toDB(entity.getUPD_DT()))
			.append(",")
           .append(toDB(entity.getWRT_ID()))
			.append(",")
           .append(toDB(entity.getSIDO_CODE()))
			.append(",")
           .append(toDB(entity.getREMARK()))
			.append(",")
           .append(toDB(entity.getLEG_BAS()))
			.append(",")
           .append(toDB(entity.getSND_STE()))
			.append(",")
           .append(toDB(entity.getSND_DT()))
			.append(",")
           .append(toDB(entity.getHOME_NOTE()))
			.append(",")
           .append(toDB(entity.getNOTE_GUID_DT()))
			.append(",")
           .append(toDB(entity.getOFFI_REPORT_DT()))
			.append(",")
           .append(toDB(entity.getASSO_GUILD_DT()))
			.append(",")
           .append(toDB(entity.getRECV_NUM()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT2()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_START_DT()))
			.append(",")
           .append(toDB(entity.getBUSISUSP_END_DT()))
			.append(",")
           .append(toDB(entity.getDOC_CODE()))
			.append(",")
           .append(toDB(entity.getPUNISHMENT_AGENCY()))
			.append(",")
           .append(toDB(entity.getDISPO_CONT_NM()))
			.append(",")
           .append(toDB(entity.getAT_RECV_NUM()))
			.append(",")
           .append(toDB(entity.getMAST_PROC()))
			.append(",")
           .append(toDB(entity.getCOI_WRT_NUM()))
						
    .append(" ) ");



    return sb.toString() ;
  }
  
  public int  update( ValueObject obj) throws SQLException{


    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : update() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_MASTER  set ")
       
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
        .append("REGR = ")
        .append(toDB(entity.getREGR())).append(",")
        .append("VIOL_CONT_CODE = ")
        .append(toDB(entity.getVIOL_CONT_CODE())).append(",")
        .append("VIOL_DT = ")
        .append(toDB(entity.getVIOL_DT())).append(",")
        .append("D_PER_CODE = ")
        .append(toDB(entity.getD_PER_CODE())).append(",")
        .append("DISPO_CONT = ")
        .append(toDB(entity.getDISPO_CONT())).append(",")
        .append("DISPO_CAUSE = ")
        .append(toDB(entity.getDISPO_CAUSE())).append(",")
        .append("DISPO_DT = ")
        .append(toDB(entity.getDISPO_DT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("LEG_BAS = ")
        .append(toDB(entity.getLEG_BAS())).append(",")
        .append("SND_STE = ")
        .append(toDB(entity.getSND_STE())).append(",")
        .append("SND_DT = ")
        .append(toDB(entity.getSND_DT())).append(",")
        .append("HOME_NOTE = ")
        .append(toDB(entity.getHOME_NOTE())).append(",")
        .append("NOTE_GUID_DT = ")
        .append(toDB(entity.getNOTE_GUID_DT())).append(",")
        .append("OFFI_REPORT_DT = ")
        .append(toDB(entity.getOFFI_REPORT_DT())).append(",")
        .append("ASSO_GUILD_DT = ")
        .append(toDB(entity.getASSO_GUILD_DT())).append(",")
        .append("RECV_NUM = ")
        .append(toDB(entity.getRECV_NUM())).append(",")
        .append("DISPO_CONT2 = ")
        .append(toDB(entity.getDISPO_CONT2())).append(",")
        .append("BUSISUSP_START_DT = ")
        .append(toDB(entity.getBUSISUSP_START_DT())).append(",")
        .append("BUSISUSP_END_DT = ")
        .append(toDB(entity.getBUSISUSP_END_DT())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("PUNISHMENT_AGENCY = ")
        .append(toDB(entity.getPUNISHMENT_AGENCY())).append(",")
        .append("DISPO_CONT_NM = ")
        .append(toDB(entity.getDISPO_CONT_NM())).append(",")
        .append("AT_RECV_NUM = ")
        .append(toDB(entity.getAT_RECV_NUM())).append(",")
        .append("MAST_PROC = ")
        .append(toDB(entity.getMAST_PROC())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         
        

   KJFLog.sql(sb.toString());

   try {

    conn = this.getConnection();
    ps = conn.prepareStatement(sb.toString());

	int i=1;
	
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


    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : update() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("update PT_M_MASTER  set ")
       
        .append("WRT_DT = ")
        .append(toDB(entity.getWRT_DT())).append(",")
        .append("REGR = ")
        .append(toDB(entity.getREGR())).append(",")
        .append("VIOL_CONT_CODE = ")
        .append(toDB(entity.getVIOL_CONT_CODE())).append(",")
        .append("VIOL_DT = ")
        .append(toDB(entity.getVIOL_DT())).append(",")
        .append("D_PER_CODE = ")
        .append(toDB(entity.getD_PER_CODE())).append(",")
        .append("DISPO_CONT = ")
        .append(toDB(entity.getDISPO_CONT())).append(",")
        .append("DISPO_CAUSE = ")
        .append(toDB(entity.getDISPO_CAUSE())).append(",")
        .append("DISPO_DT = ")
        .append(toDB(entity.getDISPO_DT())).append(",")
        .append("MOT_STE = ")
        .append(toDB(entity.getMOT_STE())).append(",")
        .append("INS_DT = ")
        .append(toDB(entity.getINS_DT())).append(",")
        .append("UPD_DT = ")
        .append(toDB(entity.getUPD_DT())).append(",")
        .append("WRT_ID = ")
        .append(toDB(entity.getWRT_ID())).append(",")
        .append("SIDO_CODE = ")
        .append(toDB(entity.getSIDO_CODE())).append(",")
        .append("REMARK = ")
        .append(toDB(entity.getREMARK())).append(",")
        .append("LEG_BAS = ")
        .append(toDB(entity.getLEG_BAS())).append(",")
        .append("SND_STE = ")
        .append(toDB(entity.getSND_STE())).append(",")
        .append("SND_DT = ")
        .append(toDB(entity.getSND_DT())).append(",")
        .append("HOME_NOTE = ")
        .append(toDB(entity.getHOME_NOTE())).append(",")
        .append("NOTE_GUID_DT = ")
        .append(toDB(entity.getNOTE_GUID_DT())).append(",")
        .append("OFFI_REPORT_DT = ")
        .append(toDB(entity.getOFFI_REPORT_DT())).append(",")
        .append("ASSO_GUILD_DT = ")
        .append(toDB(entity.getASSO_GUILD_DT())).append(",")
        .append("RECV_NUM = ")
        .append(toDB(entity.getRECV_NUM())).append(",")
        .append("DISPO_CONT2 = ")
        .append(toDB(entity.getDISPO_CONT2())).append(",")
        .append("BUSISUSP_START_DT = ")
        .append(toDB(entity.getBUSISUSP_START_DT())).append(",")
        .append("BUSISUSP_END_DT = ")
        .append(toDB(entity.getBUSISUSP_END_DT())).append(",")
        .append("DOC_CODE = ")
        .append(toDB(entity.getDOC_CODE())).append(",")
        .append("PUNISHMENT_AGENCY = ")
        .append(toDB(entity.getPUNISHMENT_AGENCY())).append(",")
        .append("DISPO_CONT_NM = ")
        .append(toDB(entity.getDISPO_CONT_NM())).append(",")
        .append("AT_RECV_NUM = ")
        .append(toDB(entity.getAT_RECV_NUM())).append(",")
        .append("MAST_PROC = ")
        .append(toDB(entity.getMAST_PROC())).append(",")
        .append("COI_WRT_NUM = ")
        .append(toDB(entity.getCOI_WRT_NUM()))
        .append(" where  1=1 ");
       
         sb.append(" and TMP_WRT_NUM = ").append( toDB(entity.getTMP_WRT_NUM()));
         
         sb.append(" and WRT_NUM = ").append( toDB(entity.getWRT_NUM()));
         
         

    return sb.toString() ;
  }
  
  
  public static HashMap default_update_field= new HashMap(0);
  static{
     
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //지정된 필드만을 수정한다.
  public int updateModifiedOnly(ValueObject obj, String[] fields) throws SQLException{



    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : updateModifiedOnly() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;

	HashMap clobs = new HashMap();
	

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
    sb.append("update PT_M_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	

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



    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : updateModifiedOnly() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;


	HashMap clobs = new HashMap();
	

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
    sb.append("update PT_M_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
  

	return sb.toString() ;
  }


  ///////////////////////////////////////////////////////////////////////////////////
  //특정필드를 제외한 전체 필드를 수정한다.
  public int updateExcludeOnly(ValueObject obj, String[] fields) throws SQLException{

	fields= KJFUtil.getDifferenceOfSets(default_fields, fields);

    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : updateModifiedOnly() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;

	HashMap clobs = new HashMap();
	

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
    sb.append("update PT_M_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	 

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

    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : updateModifiedOnly() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;


	HashMap clobs = new HashMap();
	


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
    sb.append("update PT_M_MASTER  set " )
      .append( setString.toString() ).append( " where  1=1 ");
     
	  sb.append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()));
     
	  sb.append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()));
     
	
     
     
	return sb.toString() ;
  }
  
  
  
  public int delete(ValueObject obj) throws SQLException{

    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : delete() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_MASTER  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
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

    if((obj instanceof PT_M_MASTEREntity) == false){
        throw new  SQLException("DAO 에러(1): PT_M_MASTER : delete() ");
    }
    PT_M_MASTEREntity entity = (PT_M_MASTEREntity)obj;


    StringBuffer sb = new StringBuffer();
    sb.append("delete from PT_M_MASTER  where  1=1")
      
	  .append(" and TMP_WRT_NUM = ").append(toDB(entity.getTMP_WRT_NUM()))
      
	  .append(" and WRT_NUM = ").append(toDB(entity.getWRT_NUM()))
       ;


   return sb.toString();
  }


}//Class End
