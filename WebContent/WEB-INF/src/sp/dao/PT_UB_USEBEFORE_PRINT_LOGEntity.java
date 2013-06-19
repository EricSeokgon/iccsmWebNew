

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_UB_USEBEFORE_PRINT_LOG
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               UB_LOG_SEQ:NUMBER(22):  
*               USER_NAME:VARCHAR2(200):  
*               CIV_RECV_NUM:VARCHAR2(100):  
*               USER_NAT_NUM:VARCHAR2(32):  
*               SIGUNGU_CODE:VARCHAR2(4):  
*               USER_IP:VARCHAR2(18):  
*               INSP_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_UB_USEBEFORE_PRINT_LOGEntity extends ValueObject{

  
     private String UB_LOG_SEQ;
  
     private String USER_NAME;
  
     private String CIV_RECV_NUM;
  
     private String USER_NAT_NUM;
  
     private String SIGUNGU_CODE;
  
     private String USER_IP;
  
     private String INSP_DT;
  

//생성자를 만든다
    public PT_UB_USEBEFORE_PRINT_LOGEntity(){
    }
    
      
    public PT_UB_USEBEFORE_PRINT_LOGEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.UB_LOG_SEQ =request.getParameter("UB_LOG_SEQ");
		this.USER_NAME =request.getParameter("USER_NAME");
		this.CIV_RECV_NUM =request.getParameter("CIV_RECV_NUM");
		this.USER_NAT_NUM =request.getParameter("USER_NAT_NUM");
		this.SIGUNGU_CODE =request.getParameter("SIGUNGU_CODE");
		this.USER_IP =request.getParameter("USER_IP");
		this.INSP_DT =request.getParameter("INSP_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.UB_LOG_SEQ =KJFMi.dsGet(ds, arg_row, "UB_LOG_SEQ");
		this.USER_NAME =KJFMi.dsGet(ds, arg_row, "USER_NAME");
		this.CIV_RECV_NUM =KJFMi.dsGet(ds, arg_row, "CIV_RECV_NUM");
		this.USER_NAT_NUM =KJFMi.dsGet(ds, arg_row, "USER_NAT_NUM");
		this.SIGUNGU_CODE =KJFMi.dsGet(ds, arg_row, "SIGUNGU_CODE");
		this.USER_IP =KJFMi.dsGet(ds, arg_row, "USER_IP");
		this.INSP_DT =KJFMi.dsGet(ds, arg_row, "INSP_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getUB_LOG_SEQ(){
             return UB_LOG_SEQ;
     };
  
     public String getUSER_NAME(){
             return USER_NAME;
     };
  
     public String getCIV_RECV_NUM(){
             return CIV_RECV_NUM;
     };
  
     public String getUSER_NAT_NUM(){
             return USER_NAT_NUM;
     };
  
     public String getSIGUNGU_CODE(){
             return SIGUNGU_CODE;
     };
  
     public String getUSER_IP(){
             return USER_IP;
     };
  
     public String getINSP_DT(){
             return INSP_DT;
     };
  

//Setter 함수를 만든다
  
     public void setUB_LOG_SEQ(String UB_LOG_SEQ){
            this.UB_LOG_SEQ=UB_LOG_SEQ;
     };
  
     public void setUSER_NAME(String USER_NAME){
            this.USER_NAME=USER_NAME;
     };
  
     public void setCIV_RECV_NUM(String CIV_RECV_NUM){
            this.CIV_RECV_NUM=CIV_RECV_NUM;
     };
  
     public void setUSER_NAT_NUM(String USER_NAT_NUM){
            this.USER_NAT_NUM=USER_NAT_NUM;
     };
  
     public void setSIGUNGU_CODE(String SIGUNGU_CODE){
            this.SIGUNGU_CODE=SIGUNGU_CODE;
     };
  
     public void setUSER_IP(String USER_IP){
            this.USER_IP=USER_IP;
     };
  
     public void setINSP_DT(String INSP_DT){
            this.INSP_DT=INSP_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("UB_LOG_SEQ:"+ this.getUB_LOG_SEQ()+"\n");
      
      strB.append("USER_NAME:"+ this.getUSER_NAME()+"\n");
      
      strB.append("CIV_RECV_NUM:"+ this.getCIV_RECV_NUM()+"\n");
      
      strB.append("USER_NAT_NUM:"+ this.getUSER_NAT_NUM()+"\n");
      
      strB.append("SIGUNGU_CODE:"+ this.getSIGUNGU_CODE()+"\n");
      
      strB.append("USER_IP:"+ this.getUSER_IP()+"\n");
      
      strB.append("INSP_DT:"+ this.getINSP_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_UB_USEBEFORE_PRINT_LOGHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_UB_USEBEFORE_PRINT_LOGHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_UB_USEBEFORE_PRINT_LOGHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_UB_USEBEFORE_PRINT_LOGHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_UB_USEBEFORE_PRINT_LOGHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_UB_USEBEFORE_PRINT_LOGEntity();
  }

  public ValueObject getClone(){
         PT_UB_USEBEFORE_PRINT_LOGEntity newEnt = new PT_UB_USEBEFORE_PRINT_LOGEntity();
	 
          newEnt.setUB_LOG_SEQ(this.getUB_LOG_SEQ());
         
          newEnt.setUSER_NAME(this.getUSER_NAME());
         
          newEnt.setCIV_RECV_NUM(this.getCIV_RECV_NUM());
         
          newEnt.setUSER_NAT_NUM(this.getUSER_NAT_NUM());
         
          newEnt.setSIGUNGU_CODE(this.getSIGUNGU_CODE());
         
          newEnt.setUSER_IP(this.getUSER_IP());
         
          newEnt.setINSP_DT(this.getINSP_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_UB_USEBEFORE_PRINT_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getUB_LOG_SEQ();
        
             case 2 :
                 return  this.getUSER_NAME();
        
             case 3 :
                 return  this.getCIV_RECV_NUM();
        
             case 4 :
                 return  this.getUSER_NAT_NUM();
        
             case 5 :
                 return  this.getSIGUNGU_CODE();
        
             case 6 :
                 return  this.getUSER_IP();
        
             case 7 :
                 return  this.getINSP_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_UB_USEBEFORE_PRINT_LOGHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setUB_LOG_SEQ((String)value);
	            return;  
        
             case 2 :
                    this.setUSER_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setCIV_RECV_NUM((String)value);
	            return;  
        
             case 4 :
                    this.setUSER_NAT_NUM((String)value);
	            return;  
        
             case 5 :
                    this.setSIGUNGU_CODE((String)value);
	            return;  
        
             case 6 :
                    this.setUSER_IP((String)value);
	            return;  
        
             case 7 :
                    this.setINSP_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_UB_USEBEFORE_PRINT_LOGHelper.toXML(this);
  }
  
}
