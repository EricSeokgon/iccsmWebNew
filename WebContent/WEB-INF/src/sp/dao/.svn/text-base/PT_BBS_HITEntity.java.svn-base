

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_BBS_HIT
*  테이블 설명 :
*  테이블 PK   :
*  테이블 컬럼 :  
*               CT_ID:VARCHAR2(16):  
*               BOARD_SEQ:NUMBER(22):  
*               IPADDR:VARCHAR2(100):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_BBS_HITEntity extends ValueObject{

  
     private String CT_ID;
  
     private String BOARD_SEQ;
  
     private String IPADDR;
  

//생성자를 만든다
    public PT_BBS_HITEntity(){
    }
    
      
    public PT_BBS_HITEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.CT_ID =request.getParameter("CT_ID");
		this.BOARD_SEQ =request.getParameter("BOARD_SEQ");
		this.IPADDR =request.getParameter("IPADDR");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.CT_ID =KJFMi.dsGet(ds, arg_row, "CT_ID");
		this.BOARD_SEQ =KJFMi.dsGet(ds, arg_row, "BOARD_SEQ");
		this.IPADDR =KJFMi.dsGet(ds, arg_row, "IPADDR");
				
    }    
    
//Getter 함수를 만든다
  
     public String getCT_ID(){
             return CT_ID;
     };
  
     public String getBOARD_SEQ(){
             return BOARD_SEQ;
     };
  
     public String getIPADDR(){
             return IPADDR;
     };
  

//Setter 함수를 만든다
  
     public void setCT_ID(String CT_ID){
            this.CT_ID=CT_ID;
     };
  
     public void setBOARD_SEQ(String BOARD_SEQ){
            this.BOARD_SEQ=BOARD_SEQ;
     };
  
     public void setIPADDR(String IPADDR){
            this.IPADDR=IPADDR;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("CT_ID:"+ this.getCT_ID()+"\n");
      
      strB.append("BOARD_SEQ:"+ this.getBOARD_SEQ()+"\n");
      
      strB.append("IPADDR:"+ this.getIPADDR()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_BBS_HITHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_BBS_HITHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_BBS_HITHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_BBS_HITHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_BBS_HITHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[0];
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_BBS_HITEntity();
  }

  public ValueObject getClone(){
         PT_BBS_HITEntity newEnt = new PT_BBS_HITEntity();
	 
          newEnt.setCT_ID(this.getCT_ID());
         
          newEnt.setBOARD_SEQ(this.getBOARD_SEQ());
         
          newEnt.setIPADDR(this.getIPADDR());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_BBS_HITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getCT_ID();
        
             case 2 :
                 return  this.getBOARD_SEQ();
        
             case 3 :
                 return  this.getIPADDR();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_BBS_HITHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setCT_ID((String)value);
	            return;  
        
             case 2 :
                    this.setBOARD_SEQ((String)value);
	            return;  
        
             case 3 :
                    this.setIPADDR((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_BBS_HITHelper.toXML(this);
  }
  
}
