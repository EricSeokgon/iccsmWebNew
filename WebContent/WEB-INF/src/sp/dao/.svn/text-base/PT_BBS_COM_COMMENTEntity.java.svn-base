

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_COM_COMMENT
*  테이블 설명 :
*  테이블 PK   :  
*               COMMENT_SEQ
*  테이블 컬럼 :  
*               COMMENT_SEQ:NUMBER(10):  
*               CT_ID:VARCHAR2(30):  
*               BOARD_SEQ:VARCHAR2(10):  
*               PASS:VARCHAR2(10):  
*               WRT_NM:NVARCHAR2(100):  
*               WRT_ID:VARCHAR2(20):  
*               COMMET:NVARCHAR2(4000):  
*               UPD_DT:VARCHAR2(23):  
*               INS_DT:VARCHAR2(23):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_BBS_COM_COMMENTEntity extends ValueObject{

  
     private String COMMENT_SEQ;
  
     private String CT_ID;
  
     private String BOARD_SEQ;
  
     private String PASS;
  
     private String WRT_NM;
  
     private String WRT_ID;
  
     private String COMMET;
  
     private String UPD_DT;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_BBS_COM_COMMENTEntity(){
    }
    
    
    public PT_BBS_COM_COMMENTEntity(String COMMENT_SEQ ){
       this.setCOMMENT_SEQ(COMMENT_SEQ);
       
    }
      
    public PT_BBS_COM_COMMENTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("COMMENT_SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("COMMENT_SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.COMMENT_SEQ =request.getParameter("COMMENT_SEQ");
		this.CT_ID =request.getParameter("CT_ID");
		this.BOARD_SEQ =request.getParameter("BOARD_SEQ");
		this.PASS =request.getParameter("PASS");
		this.WRT_NM =request.getParameter("WRT_NM");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.COMMET =request.getParameter("COMMET");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.COMMENT_SEQ =KJFMi.dsGet(ds, arg_row, "COMMENT_SEQ");
		this.CT_ID =KJFMi.dsGet(ds, arg_row, "CT_ID");
		this.BOARD_SEQ =KJFMi.dsGet(ds, arg_row, "BOARD_SEQ");
		this.PASS =KJFMi.dsGet(ds, arg_row, "PASS");
		this.WRT_NM =KJFMi.dsGet(ds, arg_row, "WRT_NM");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.COMMET =KJFMi.dsGet(ds, arg_row, "COMMET");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCOMMENT_SEQ(){
             return COMMENT_SEQ;
     };
  
     public String getCT_ID(){
             return CT_ID;
     };
  
     public String getBOARD_SEQ(){
             return BOARD_SEQ;
     };
  
     public String getPASS(){
             return PASS;
     };
  
     public String getWRT_NM(){
             return WRT_NM;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getCOMMET(){
             return COMMET;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  

//Setter 함수를 만든다
  
     public void setCOMMENT_SEQ(String COMMENT_SEQ){
            this.COMMENT_SEQ=COMMENT_SEQ;
     };
  
     public void setCT_ID(String CT_ID){
            this.CT_ID=CT_ID;
     };
  
     public void setBOARD_SEQ(String BOARD_SEQ){
            this.BOARD_SEQ=BOARD_SEQ;
     };
  
     public void setPASS(String PASS){
            this.PASS=PASS;
     };
  
     public void setWRT_NM(String WRT_NM){
            this.WRT_NM=WRT_NM;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setCOMMET(String COMMET){
            this.COMMET=COMMET;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("COMMENT_SEQ:"+ this.getCOMMENT_SEQ()+"\n");
      
      strB.append("CT_ID:"+ this.getCT_ID()+"\n");
      
      strB.append("BOARD_SEQ:"+ this.getBOARD_SEQ()+"\n");
      
      strB.append("PASS:"+ this.getPASS()+"\n");
      
      strB.append("WRT_NM:"+ this.getWRT_NM()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("COMMET:"+ this.getCOMMET()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_BBS_COM_COMMENTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_BBS_COM_COMMENTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_BBS_COM_COMMENTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_BBS_COM_COMMENTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_BBS_COM_COMMENTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getCOMMENT_SEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_BBS_COM_COMMENTEntity();
  }

  public ValueObject getClone(){
         PT_BBS_COM_COMMENTEntity newEnt = new PT_BBS_COM_COMMENTEntity();
	 
          newEnt.setCOMMENT_SEQ(this.getCOMMENT_SEQ());
         
          newEnt.setCT_ID(this.getCT_ID());
         
          newEnt.setBOARD_SEQ(this.getBOARD_SEQ());
         
          newEnt.setPASS(this.getPASS());
         
          newEnt.setWRT_NM(this.getWRT_NM());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setCOMMET(this.getCOMMET());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_BBS_COM_COMMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCOMMENT_SEQ();
        
             case 2 :
                 return  this.getCT_ID();
        
             case 3 :
                 return  this.getBOARD_SEQ();
        
             case 4 :
                 return  this.getPASS();
        
             case 5 :
                 return  this.getWRT_NM();
        
             case 6 :
                 return  this.getWRT_ID();
        
             case 7 :
                 return  this.getCOMMET();
        
             case 8 :
                 return  this.getUPD_DT();
        
             case 9 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_BBS_COM_COMMENTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCOMMENT_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setCT_ID((String)value);
	            return;  
        
             case 3 :
                    this.setBOARD_SEQ((String)value);
	            return;  
        
             case 4 :
                    this.setPASS((String)value);
	            return;  
        
             case 5 :
                    this.setWRT_NM((String)value);
	            return;  
        
             case 6 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 7 :
                    this.setCOMMET((String)value);
	            return;  
        
             case 8 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 9 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_BBS_COM_COMMENTHelper.toXML(this);
  }
  
}
