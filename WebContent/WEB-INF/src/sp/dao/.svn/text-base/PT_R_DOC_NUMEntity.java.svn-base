

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_R_DOC_NUM
*  테이블 설명 :
*  테이블 PK   :  
*               DOC_CLASS  
*               SD_CODE
*  테이블 컬럼 :  
*               DOC_CLASS:VARCHAR2(20):  
*               SD_CODE:VARCHAR2(3):  
*               SGG_CODE:VARCHAR2(4):  
*               DOC_NUM1:VARCHAR2(4):  
*               DOC_NUM2:VARCHAR2(4):  
*               DOC_NUM3:VARCHAR2(4):  
*               DOC_NUM4:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_R_DOC_NUMEntity extends ValueObject{

  
     private String DOC_CLASS;
  
     private String SD_CODE;
  
     private String SGG_CODE;
  
     private String DOC_NUM1;
  
     private String DOC_NUM2;
  
     private String DOC_NUM3;
  
     private String DOC_NUM4;
  

//생성자를 만든다
    public PT_R_DOC_NUMEntity(){
    }
    
    
    public PT_R_DOC_NUMEntity(String DOC_CLASS,String SD_CODE ){
       this.setDOC_CLASS(DOC_CLASS);
       this.setSD_CODE(SD_CODE);
       
    }
      
    public PT_R_DOC_NUMEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("DOC_CLASS");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("DOC_CLASS",value);
       
       value = ent.getByName("SD_CODE");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SD_CODE",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.DOC_CLASS =request.getParameter("DOC_CLASS");
		this.SD_CODE =request.getParameter("SD_CODE");
		this.SGG_CODE =request.getParameter("SGG_CODE");
		this.DOC_NUM1 =request.getParameter("DOC_NUM1");
		this.DOC_NUM2 =request.getParameter("DOC_NUM2");
		this.DOC_NUM3 =request.getParameter("DOC_NUM3");
		this.DOC_NUM4 =request.getParameter("DOC_NUM4");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.DOC_CLASS =KJFMi.dsGet(ds, arg_row, "DOC_CLASS");
		this.SD_CODE =KJFMi.dsGet(ds, arg_row, "SD_CODE");
		this.SGG_CODE =KJFMi.dsGet(ds, arg_row, "SGG_CODE");
		this.DOC_NUM1 =KJFMi.dsGet(ds, arg_row, "DOC_NUM1");
		this.DOC_NUM2 =KJFMi.dsGet(ds, arg_row, "DOC_NUM2");
		this.DOC_NUM3 =KJFMi.dsGet(ds, arg_row, "DOC_NUM3");
		this.DOC_NUM4 =KJFMi.dsGet(ds, arg_row, "DOC_NUM4");
				
    }    
    
//Getter 함수를 만든다
  
     public String getDOC_CLASS(){
             return DOC_CLASS;
     };
  
     public String getSD_CODE(){
             return SD_CODE;
     };
  
     public String getSGG_CODE(){
             return SGG_CODE;
     };
  
     public String getDOC_NUM1(){
             return DOC_NUM1;
     };
  
     public String getDOC_NUM2(){
             return DOC_NUM2;
     };
  
     public String getDOC_NUM3(){
             return DOC_NUM3;
     };
  
     public String getDOC_NUM4(){
             return DOC_NUM4;
     };
  

//Setter 함수를 만든다
  
     public void setDOC_CLASS(String DOC_CLASS){
            this.DOC_CLASS=DOC_CLASS;
     };
  
     public void setSD_CODE(String SD_CODE){
            this.SD_CODE=SD_CODE;
     };
  
     public void setSGG_CODE(String SGG_CODE){
            this.SGG_CODE=SGG_CODE;
     };
  
     public void setDOC_NUM1(String DOC_NUM1){
            this.DOC_NUM1=DOC_NUM1;
     };
  
     public void setDOC_NUM2(String DOC_NUM2){
            this.DOC_NUM2=DOC_NUM2;
     };
  
     public void setDOC_NUM3(String DOC_NUM3){
            this.DOC_NUM3=DOC_NUM3;
     };
  
     public void setDOC_NUM4(String DOC_NUM4){
            this.DOC_NUM4=DOC_NUM4;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("DOC_CLASS:"+ this.getDOC_CLASS()+"\n");
      
      strB.append("SD_CODE:"+ this.getSD_CODE()+"\n");
      
      strB.append("SGG_CODE:"+ this.getSGG_CODE()+"\n");
      
      strB.append("DOC_NUM1:"+ this.getDOC_NUM1()+"\n");
      
      strB.append("DOC_NUM2:"+ this.getDOC_NUM2()+"\n");
      
      strB.append("DOC_NUM3:"+ this.getDOC_NUM3()+"\n");
      
      strB.append("DOC_NUM4:"+ this.getDOC_NUM4()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_R_DOC_NUMHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_R_DOC_NUMHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_R_DOC_NUMHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_R_DOC_NUMHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_R_DOC_NUMHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[2];
       values[0]= this.getDOC_CLASS();
       values[1]= this.getSD_CODE();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_R_DOC_NUMEntity();
  }

  public ValueObject getClone(){
         PT_R_DOC_NUMEntity newEnt = new PT_R_DOC_NUMEntity();
	 
          newEnt.setDOC_CLASS(this.getDOC_CLASS());
         
          newEnt.setSD_CODE(this.getSD_CODE());
         
          newEnt.setSGG_CODE(this.getSGG_CODE());
         
          newEnt.setDOC_NUM1(this.getDOC_NUM1());
         
          newEnt.setDOC_NUM2(this.getDOC_NUM2());
         
          newEnt.setDOC_NUM3(this.getDOC_NUM3());
         
          newEnt.setDOC_NUM4(this.getDOC_NUM4());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_R_DOC_NUMHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getDOC_CLASS();
        
             case 2 :
                 return  this.getSD_CODE();
        
             case 3 :
                 return  this.getSGG_CODE();
        
             case 4 :
                 return  this.getDOC_NUM1();
        
             case 5 :
                 return  this.getDOC_NUM2();
        
             case 6 :
                 return  this.getDOC_NUM3();
        
             case 7 :
                 return  this.getDOC_NUM4();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_R_DOC_NUMHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setDOC_CLASS((String)value);
	            return;  
        
             case 2 :
                    this.setSD_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setSGG_CODE((String)value);
	            return;  
        
             case 4 :
                    this.setDOC_NUM1((String)value);
	            return;  
        
             case 5 :
                    this.setDOC_NUM2((String)value);
	            return;  
        
             case 6 :
                    this.setDOC_NUM3((String)value);
	            return;  
        
             case 7 :
                    this.setDOC_NUM4((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_R_DOC_NUMHelper.toXML(this);
  }
  
}
