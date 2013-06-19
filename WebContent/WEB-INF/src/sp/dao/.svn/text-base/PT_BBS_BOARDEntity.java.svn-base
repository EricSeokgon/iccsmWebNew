

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_BOARD
*  테이블 설명 :
*  테이블 PK   :  
*               INDEX1  
*               INDEX2
*  테이블 컬럼 :  
*               CT_ID:VARCHAR2(16):  
*               BOARD_SEQ:NUMBER(22):  
*               INDEX1:NUMBER(22):  
*               INDEX2:NUMBER(22):  
*               DEPTH:NUMBER(22):  
*               SD_CD:VARCHAR2(4):  
*               SGG_CD:VARCHAR2(4):  
*               USER_ID:VARCHAR2(16):  
*               USER_NAME:VARCHAR2(50):  
*               USER_EMAIL:VARCHAR2(100):  
*               USER_PASS:VARCHAR2(16):  
*               USER_IP:VARCHAR2(18):  
*               USER_TEL:VARCHAR2(14):  
*               USER_HOMEPAGE:VARCHAR2(255):  
*               SUBJECT:VARCHAR2(200):  
*               CONTENT:CLOB:  
*               REPLIED_YN:VARCHAR2(1):  
*               SECRET_YN:VARCHAR2(1):  
*               NOTICE_YN:VARCHAR2(1):  
*               READ_NUM:NUMBER(22):  
*               UPD_DT:VARCHAR2(23):  
*               INS_DT:VARCHAR2(23):  
*               WRT_ID:VARCHAR2(16):  
*               ETC_1:VARCHAR2(255):  
*               ETC_2:VARCHAR2(255):  
*               ETC_3:VARCHAR2(255):  
*               ETC_4:VARCHAR2(255):  
*               ETC_5:VARCHAR2(255):  
*               ETC_6:VARCHAR2(255):  
*               ETC_7:VARCHAR2(255):  
*               ETC_8:VARCHAR2(255):  
*               ETC_9:VARCHAR2(255):  
*               ETC_10:VARCHAR2(255):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_BBS_BOARDEntity extends ValueObject{

  
     private String CT_ID;
  
     private String BOARD_SEQ;
  
     private String INDEX1;
  
     private String INDEX2;
  
     private String DEPTH;
  
     private String SD_CD;
  
     private String SGG_CD;
  
     private String USER_ID;
  
     private String USER_NAME;
  
     private String USER_EMAIL;
  
     private String USER_PASS;
  
     private String USER_IP;
  
     private String USER_TEL;
  
     private String USER_HOMEPAGE;
  
     private String SUBJECT;
  
     private String CONTENT;
  
     private String REPLIED_YN;
  
     private String SECRET_YN;
  
     private String NOTICE_YN;
  
     private String READ_NUM;
  
     private String UPD_DT;
  
     private String INS_DT;
  
     private String WRT_ID;
  
     private String ETC_1;
  
     private String ETC_2;
  
     private String ETC_3;
  
     private String ETC_4;
  
     private String ETC_5;
  
     private String ETC_6;
  
     private String ETC_7;
  
     private String ETC_8;
  
     private String ETC_9;
  
     private String ETC_10;
  

//생성자를 만든다
    public PT_BBS_BOARDEntity(){
    }
    
    
    public PT_BBS_BOARDEntity(String INDEX1,String INDEX2 ){
       this.setINDEX1(INDEX1);
       this.setINDEX2(INDEX2);
       
    }
      
    public PT_BBS_BOARDEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("INDEX1");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("INDEX1",value);
       
       value = ent.getByName("INDEX2");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("INDEX2",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CT_ID =request.getParameter("CT_ID");
		this.BOARD_SEQ =request.getParameter("BOARD_SEQ");
		this.INDEX1 =request.getParameter("INDEX1");
		this.INDEX2 =request.getParameter("INDEX2");
		this.DEPTH =request.getParameter("DEPTH");
		this.SD_CD =request.getParameter("SD_CD");
		this.SGG_CD =request.getParameter("SGG_CD");
		this.USER_ID =request.getParameter("USER_ID");
		this.USER_NAME =request.getParameter("USER_NAME");
		this.USER_EMAIL =request.getParameter("USER_EMAIL");
		this.USER_PASS =request.getParameter("USER_PASS");
		this.USER_IP =request.getParameter("USER_IP");
		this.USER_TEL =request.getParameter("USER_TEL");
		this.USER_HOMEPAGE =request.getParameter("USER_HOMEPAGE");
		this.SUBJECT =request.getParameter("SUBJECT");
		this.CONTENT =request.getParameter("CONTENT");
		this.REPLIED_YN =request.getParameter("REPLIED_YN");
		this.SECRET_YN =request.getParameter("SECRET_YN");
		this.NOTICE_YN =request.getParameter("NOTICE_YN");
		this.READ_NUM =request.getParameter("READ_NUM");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.ETC_1 =request.getParameter("ETC_1");
		this.ETC_2 =request.getParameter("ETC_2");
		this.ETC_3 =request.getParameter("ETC_3");
		this.ETC_4 =request.getParameter("ETC_4");
		this.ETC_5 =request.getParameter("ETC_5");
		this.ETC_6 =request.getParameter("ETC_6");
		this.ETC_7 =request.getParameter("ETC_7");
		this.ETC_8 =request.getParameter("ETC_8");
		this.ETC_9 =request.getParameter("ETC_9");
		this.ETC_10 =request.getParameter("ETC_10");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CT_ID =KJFMi.dsGet(ds, arg_row, "CT_ID");
		this.BOARD_SEQ =KJFMi.dsGet(ds, arg_row, "BOARD_SEQ");
		this.INDEX1 =KJFMi.dsGet(ds, arg_row, "INDEX1");
		this.INDEX2 =KJFMi.dsGet(ds, arg_row, "INDEX2");
		this.DEPTH =KJFMi.dsGet(ds, arg_row, "DEPTH");
		this.SD_CD =KJFMi.dsGet(ds, arg_row, "SD_CD");
		this.SGG_CD =KJFMi.dsGet(ds, arg_row, "SGG_CD");
		this.USER_ID =KJFMi.dsGet(ds, arg_row, "USER_ID");
		this.USER_NAME =KJFMi.dsGet(ds, arg_row, "USER_NAME");
		this.USER_EMAIL =KJFMi.dsGet(ds, arg_row, "USER_EMAIL");
		this.USER_PASS =KJFMi.dsGet(ds, arg_row, "USER_PASS");
		this.USER_IP =KJFMi.dsGet(ds, arg_row, "USER_IP");
		this.USER_TEL =KJFMi.dsGet(ds, arg_row, "USER_TEL");
		this.USER_HOMEPAGE =KJFMi.dsGet(ds, arg_row, "USER_HOMEPAGE");
		this.SUBJECT =KJFMi.dsGet(ds, arg_row, "SUBJECT");
		this.CONTENT =KJFMi.dsGet(ds, arg_row, "CONTENT");
		this.REPLIED_YN =KJFMi.dsGet(ds, arg_row, "REPLIED_YN");
		this.SECRET_YN =KJFMi.dsGet(ds, arg_row, "SECRET_YN");
		this.NOTICE_YN =KJFMi.dsGet(ds, arg_row, "NOTICE_YN");
		this.READ_NUM =KJFMi.dsGet(ds, arg_row, "READ_NUM");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.ETC_1 =KJFMi.dsGet(ds, arg_row, "ETC_1");
		this.ETC_2 =KJFMi.dsGet(ds, arg_row, "ETC_2");
		this.ETC_3 =KJFMi.dsGet(ds, arg_row, "ETC_3");
		this.ETC_4 =KJFMi.dsGet(ds, arg_row, "ETC_4");
		this.ETC_5 =KJFMi.dsGet(ds, arg_row, "ETC_5");
		this.ETC_6 =KJFMi.dsGet(ds, arg_row, "ETC_6");
		this.ETC_7 =KJFMi.dsGet(ds, arg_row, "ETC_7");
		this.ETC_8 =KJFMi.dsGet(ds, arg_row, "ETC_8");
		this.ETC_9 =KJFMi.dsGet(ds, arg_row, "ETC_9");
		this.ETC_10 =KJFMi.dsGet(ds, arg_row, "ETC_10");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCT_ID(){
             return CT_ID;
     };
  
     public String getBOARD_SEQ(){
             return BOARD_SEQ;
     };
  
     public String getINDEX1(){
             return INDEX1;
     };
  
     public String getINDEX2(){
             return INDEX2;
     };
  
     public String getDEPTH(){
             return DEPTH;
     };
  
     public String getSD_CD(){
             return SD_CD;
     };
  
     public String getSGG_CD(){
             return SGG_CD;
     };
  
     public String getUSER_ID(){
             return USER_ID;
     };
  
     public String getUSER_NAME(){
             return USER_NAME;
     };
  
     public String getUSER_EMAIL(){
             return USER_EMAIL;
     };
  
     public String getUSER_PASS(){
             return USER_PASS;
     };
  
     public String getUSER_IP(){
             return USER_IP;
     };
  
     public String getUSER_TEL(){
             return USER_TEL;
     };
  
     public String getUSER_HOMEPAGE(){
             return USER_HOMEPAGE;
     };
  
     public String getSUBJECT(){
             return SUBJECT;
     };
  
     public String getCONTENT(){
             return CONTENT;
     };
  
     public String getREPLIED_YN(){
             return REPLIED_YN;
     };
  
     public String getSECRET_YN(){
             return SECRET_YN;
     };
  
     public String getNOTICE_YN(){
             return NOTICE_YN;
     };
  
     public String getREAD_NUM(){
             return READ_NUM;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getETC_1(){
             return ETC_1;
     };
  
     public String getETC_2(){
             return ETC_2;
     };
  
     public String getETC_3(){
             return ETC_3;
     };
  
     public String getETC_4(){
             return ETC_4;
     };
  
     public String getETC_5(){
             return ETC_5;
     };
  
     public String getETC_6(){
             return ETC_6;
     };
  
     public String getETC_7(){
             return ETC_7;
     };
  
     public String getETC_8(){
             return ETC_8;
     };
  
     public String getETC_9(){
             return ETC_9;
     };
  
     public String getETC_10(){
             return ETC_10;
     };
  

//Setter 함수를 만든다
  
     public void setCT_ID(String CT_ID){
            this.CT_ID=CT_ID;
     };
  
     public void setBOARD_SEQ(String BOARD_SEQ){
            this.BOARD_SEQ=BOARD_SEQ;
     };
  
     public void setINDEX1(String INDEX1){
            this.INDEX1=INDEX1;
     };
  
     public void setINDEX2(String INDEX2){
            this.INDEX2=INDEX2;
     };
  
     public void setDEPTH(String DEPTH){
            this.DEPTH=DEPTH;
     };
  
     public void setSD_CD(String SD_CD){
            this.SD_CD=SD_CD;
     };
  
     public void setSGG_CD(String SGG_CD){
            this.SGG_CD=SGG_CD;
     };
  
     public void setUSER_ID(String USER_ID){
            this.USER_ID=USER_ID;
     };
  
     public void setUSER_NAME(String USER_NAME){
            this.USER_NAME=USER_NAME;
     };
  
     public void setUSER_EMAIL(String USER_EMAIL){
            this.USER_EMAIL=USER_EMAIL;
     };
  
     public void setUSER_PASS(String USER_PASS){
            this.USER_PASS=USER_PASS;
     };
  
     public void setUSER_IP(String USER_IP){
            this.USER_IP=USER_IP;
     };
  
     public void setUSER_TEL(String USER_TEL){
            this.USER_TEL=USER_TEL;
     };
  
     public void setUSER_HOMEPAGE(String USER_HOMEPAGE){
            this.USER_HOMEPAGE=USER_HOMEPAGE;
     };
  
     public void setSUBJECT(String SUBJECT){
            this.SUBJECT=SUBJECT;
     };
  
     public void setCONTENT(String CONTENT){
            this.CONTENT=CONTENT;
     };
  
     public void setREPLIED_YN(String REPLIED_YN){
            this.REPLIED_YN=REPLIED_YN;
     };
  
     public void setSECRET_YN(String SECRET_YN){
            this.SECRET_YN=SECRET_YN;
     };
  
     public void setNOTICE_YN(String NOTICE_YN){
            this.NOTICE_YN=NOTICE_YN;
     };
  
     public void setREAD_NUM(String READ_NUM){
            this.READ_NUM=READ_NUM;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setETC_1(String ETC_1){
            this.ETC_1=ETC_1;
     };
  
     public void setETC_2(String ETC_2){
            this.ETC_2=ETC_2;
     };
  
     public void setETC_3(String ETC_3){
            this.ETC_3=ETC_3;
     };
  
     public void setETC_4(String ETC_4){
            this.ETC_4=ETC_4;
     };
  
     public void setETC_5(String ETC_5){
            this.ETC_5=ETC_5;
     };
  
     public void setETC_6(String ETC_6){
            this.ETC_6=ETC_6;
     };
  
     public void setETC_7(String ETC_7){
            this.ETC_7=ETC_7;
     };
  
     public void setETC_8(String ETC_8){
            this.ETC_8=ETC_8;
     };
  
     public void setETC_9(String ETC_9){
            this.ETC_9=ETC_9;
     };
  
     public void setETC_10(String ETC_10){
            this.ETC_10=ETC_10;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CT_ID:"+ this.getCT_ID()+"\n");
      
      strB.append("BOARD_SEQ:"+ this.getBOARD_SEQ()+"\n");
      
      strB.append("INDEX1:"+ this.getINDEX1()+"\n");
      
      strB.append("INDEX2:"+ this.getINDEX2()+"\n");
      
      strB.append("DEPTH:"+ this.getDEPTH()+"\n");
      
      strB.append("SD_CD:"+ this.getSD_CD()+"\n");
      
      strB.append("SGG_CD:"+ this.getSGG_CD()+"\n");
      
      strB.append("USER_ID:"+ this.getUSER_ID()+"\n");
      
      strB.append("USER_NAME:"+ this.getUSER_NAME()+"\n");
      
      strB.append("USER_EMAIL:"+ this.getUSER_EMAIL()+"\n");
      
      strB.append("USER_PASS:"+ this.getUSER_PASS()+"\n");
      
      strB.append("USER_IP:"+ this.getUSER_IP()+"\n");
      
      strB.append("USER_TEL:"+ this.getUSER_TEL()+"\n");
      
      strB.append("USER_HOMEPAGE:"+ this.getUSER_HOMEPAGE()+"\n");
      
      strB.append("SUBJECT:"+ this.getSUBJECT()+"\n");
      
      strB.append("CONTENT:"+ this.getCONTENT()+"\n");
      
      strB.append("REPLIED_YN:"+ this.getREPLIED_YN()+"\n");
      
      strB.append("SECRET_YN:"+ this.getSECRET_YN()+"\n");
      
      strB.append("NOTICE_YN:"+ this.getNOTICE_YN()+"\n");
      
      strB.append("READ_NUM:"+ this.getREAD_NUM()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("ETC_1:"+ this.getETC_1()+"\n");
      
      strB.append("ETC_2:"+ this.getETC_2()+"\n");
      
      strB.append("ETC_3:"+ this.getETC_3()+"\n");
      
      strB.append("ETC_4:"+ this.getETC_4()+"\n");
      
      strB.append("ETC_5:"+ this.getETC_5()+"\n");
      
      strB.append("ETC_6:"+ this.getETC_6()+"\n");
      
      strB.append("ETC_7:"+ this.getETC_7()+"\n");
      
      strB.append("ETC_8:"+ this.getETC_8()+"\n");
      
      strB.append("ETC_9:"+ this.getETC_9()+"\n");
      
      strB.append("ETC_10:"+ this.getETC_10()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_BBS_BOARDHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_BBS_BOARDHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_BBS_BOARDHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_BBS_BOARDHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_BBS_BOARDHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getINDEX1();
       values[1]= this.getINDEX2();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_BBS_BOARDEntity();
  }

  public ValueObject getClone(){
         PT_BBS_BOARDEntity newEnt = new PT_BBS_BOARDEntity();
	 
          newEnt.setCT_ID(this.getCT_ID());
         
          newEnt.setBOARD_SEQ(this.getBOARD_SEQ());
         
          newEnt.setINDEX1(this.getINDEX1());
         
          newEnt.setINDEX2(this.getINDEX2());
         
          newEnt.setDEPTH(this.getDEPTH());
         
          newEnt.setSD_CD(this.getSD_CD());
         
          newEnt.setSGG_CD(this.getSGG_CD());
         
          newEnt.setUSER_ID(this.getUSER_ID());
         
          newEnt.setUSER_NAME(this.getUSER_NAME());
         
          newEnt.setUSER_EMAIL(this.getUSER_EMAIL());
         
          newEnt.setUSER_PASS(this.getUSER_PASS());
         
          newEnt.setUSER_IP(this.getUSER_IP());
         
          newEnt.setUSER_TEL(this.getUSER_TEL());
         
          newEnt.setUSER_HOMEPAGE(this.getUSER_HOMEPAGE());
         
          newEnt.setSUBJECT(this.getSUBJECT());
         
          newEnt.setCONTENT(this.getCONTENT());
         
          newEnt.setREPLIED_YN(this.getREPLIED_YN());
         
          newEnt.setSECRET_YN(this.getSECRET_YN());
         
          newEnt.setNOTICE_YN(this.getNOTICE_YN());
         
          newEnt.setREAD_NUM(this.getREAD_NUM());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setETC_1(this.getETC_1());
         
          newEnt.setETC_2(this.getETC_2());
         
          newEnt.setETC_3(this.getETC_3());
         
          newEnt.setETC_4(this.getETC_4());
         
          newEnt.setETC_5(this.getETC_5());
         
          newEnt.setETC_6(this.getETC_6());
         
          newEnt.setETC_7(this.getETC_7());
         
          newEnt.setETC_8(this.getETC_8());
         
          newEnt.setETC_9(this.getETC_9());
         
          newEnt.setETC_10(this.getETC_10());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_BBS_BOARDHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCT_ID();
        
             case 2 :
                 return  this.getBOARD_SEQ();
        
             case 3 :
                 return  this.getINDEX1();
        
             case 4 :
                 return  this.getINDEX2();
        
             case 5 :
                 return  this.getDEPTH();
        
             case 6 :
                 return  this.getSD_CD();
        
             case 7 :
                 return  this.getSGG_CD();
        
             case 8 :
                 return  this.getUSER_ID();
        
             case 9 :
                 return  this.getUSER_NAME();
        
             case 10 :
                 return  this.getUSER_EMAIL();
        
             case 11 :
                 return  this.getUSER_PASS();
        
             case 12 :
                 return  this.getUSER_IP();
        
             case 13 :
                 return  this.getUSER_TEL();
        
             case 14 :
                 return  this.getUSER_HOMEPAGE();
        
             case 15 :
                 return  this.getSUBJECT();
        
             case 16 :
                 return  this.getCONTENT();
        
             case 17 :
                 return  this.getREPLIED_YN();
        
             case 18 :
                 return  this.getSECRET_YN();
        
             case 19 :
                 return  this.getNOTICE_YN();
        
             case 20 :
                 return  this.getREAD_NUM();
        
             case 21 :
                 return  this.getUPD_DT();
        
             case 22 :
                 return  this.getINS_DT();
        
             case 23 :
                 return  this.getWRT_ID();
        
             case 24 :
                 return  this.getETC_1();
        
             case 25 :
                 return  this.getETC_2();
        
             case 26 :
                 return  this.getETC_3();
        
             case 27 :
                 return  this.getETC_4();
        
             case 28 :
                 return  this.getETC_5();
        
             case 29 :
                 return  this.getETC_6();
        
             case 30 :
                 return  this.getETC_7();
        
             case 31 :
                 return  this.getETC_8();
        
             case 32 :
                 return  this.getETC_9();
        
             case 33 :
                 return  this.getETC_10();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_BBS_BOARDHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCT_ID((String)value);
	            return;  
        
             case 2 :
                    this.setBOARD_SEQ((String)value);
	            return;  
        
             case 3 :
                    this.setINDEX1((String)value);
	            return;  
        
             case 4 :
                    this.setINDEX2((String)value);
	            return;  
        
             case 5 :
                    this.setDEPTH((String)value);
	            return;  
        
             case 6 :
                    this.setSD_CD((String)value);
	            return;  
        
             case 7 :
                    this.setSGG_CD((String)value);
	            return;  
        
             case 8 :
                    this.setUSER_ID((String)value);
	            return;  
        
             case 9 :
                    this.setUSER_NAME((String)value);
	            return;  
        
             case 10 :
                    this.setUSER_EMAIL((String)value);
	            return;  
        
             case 11 :
                    this.setUSER_PASS((String)value);
	            return;  
        
             case 12 :
                    this.setUSER_IP((String)value);
	            return;  
        
             case 13 :
                    this.setUSER_TEL((String)value);
	            return;  
        
             case 14 :
                    this.setUSER_HOMEPAGE((String)value);
	            return;  
        
             case 15 :
                    this.setSUBJECT((String)value);
	            return;  
        
             case 16 :
                    this.setCONTENT((String)value);
	            return;  
        
             case 17 :
                    this.setREPLIED_YN((String)value);
	            return;  
        
             case 18 :
                    this.setSECRET_YN((String)value);
	            return;  
        
             case 19 :
                    this.setNOTICE_YN((String)value);
	            return;  
        
             case 20 :
                    this.setREAD_NUM((String)value);
	            return;  
        
             case 21 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 22 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 23 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 24 :
                    this.setETC_1((String)value);
	            return;  
        
             case 25 :
                    this.setETC_2((String)value);
	            return;  
        
             case 26 :
                    this.setETC_3((String)value);
	            return;  
        
             case 27 :
                    this.setETC_4((String)value);
	            return;  
        
             case 28 :
                    this.setETC_5((String)value);
	            return;  
        
             case 29 :
                    this.setETC_6((String)value);
	            return;  
        
             case 30 :
                    this.setETC_7((String)value);
	            return;  
        
             case 31 :
                    this.setETC_8((String)value);
	            return;  
        
             case 32 :
                    this.setETC_9((String)value);
	            return;  
        
             case 33 :
                    this.setETC_10((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_BBS_BOARDHelper.toXML(this);
  }
  
}
