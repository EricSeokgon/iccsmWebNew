


/*
*  Automatic generated  source
*  ��  ��  �� : ����
*
*  ���̺� ��   :PT_TEMPLET
*  ���̺� ���� :
*  ���̺� PK   :
*  ���̺� �÷� :
*               USERID:VARCHAR2(50):
*               FORMID:VARCHAR2(50):
*               SAMPLENAME:VARCHAR2(50):
*               XML:VARCHAR2(256):
*/
package sp.dao;

import kjf.util.*;
import kjf.ops.*;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


public class PT_TEMPLETDAO  extends SuperToDB{

  private String default_fields[]={ "USERID" , "FORMID" , "SAMPLENAME" };	

  public int insert( ValueObject  obj) throws SQLException{

    if((obj instanceof PT_TEMPLETEntity) == false){
        throw new  SQLException("DAO ����(1): PT_TEMPLET : insert() ");
    }
    PT_TEMPLETEntity entity = (PT_TEMPLETEntity)obj;

    Connection conn = null;
    PreparedStatement  ps  =null;
    int result = 0;

  StringBuffer sb = new StringBuffer();
  sb.append("insert into PT_TEMPLET ")
    .append(" ( USERID,FORMID,SAMPLENAME) ")
    .append(" values ( ")
      
           .append(toDB(entity.getUSERID()))
			.append(",")
           .append(toDB(entity.getFORMID()))
			.append(",")
           .append(toDB(entity.getSAMPLENAME()))
			
			
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

  
  }

  ///////////////////////////////////////////////////////////////////////////////////
  //������ �ʵ常�� �����Ѵ�.
  

//Class End
