

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_TMP_TRANS_KEY
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               WORK_CLASS_CODE:VARCHAR2(18):  
*               KEY1:VARCHAR2(20):  
*               KEY2:VARCHAR2(20):  
*               KEY3:VARCHAR2(20):  
*               KEY4:VARCHAR2(20):  
*               KEY5:VARCHAR2(20):  
*               CUD_FLAG:VARCHAR2(1):  
*               SEQ:VARCHAR2(18):  
*               INS_DT:VARCHAR2(24):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_TMP_TRANS_KEYEntity extends ValueObject{

  
     private String WORK_CLASS_CODE;
  
     private String KEY1;
  
     private String KEY2;
  
     private String KEY3;
  
     private String KEY4;
  
     private String KEY5;
  
     private String CUD_FLAG;
  
     private String SEQ;
  
     private String INS_DT;
  

//생성자를 만든다
    public PT_TMP_TRANS_KEYEntity(){
    }
    
    
    public PT_TMP_TRANS_KEYEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_TMP_TRANS_KEYEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.WORK_CLASS_CODE =request.getParameter("WORK_CLASS_CODE");
		this.KEY1 =request.getParameter("KEY1");
		this.KEY2 =request.getParameter("KEY2");
		this.KEY3 =request.getParameter("KEY3");
		this.KEY4 =request.getParameter("KEY4");
		this.KEY5 =request.getParameter("KEY5");
		this.CUD_FLAG =request.getParameter("CUD_FLAG");
		this.SEQ =request.getParameter("SEQ");
		this.INS_DT =request.getParameter("INS_DT");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.WORK_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "WORK_CLASS_CODE");
		this.KEY1 =KJFMi.dsGet(ds, arg_row, "KEY1");
		this.KEY2 =KJFMi.dsGet(ds, arg_row, "KEY2");
		this.KEY3 =KJFMi.dsGet(ds, arg_row, "KEY3");
		this.KEY4 =KJFMi.dsGet(ds, arg_row, "KEY4");
		this.KEY5 =KJFMi.dsGet(ds, arg_row, "KEY5");
		this.CUD_FLAG =KJFMi.dsGet(ds, arg_row, "CUD_FLAG");
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
				
    }    
    
//Getter 함수를 만든다
  
     public String getWORK_CLASS_CODE(){
             return WORK_CLASS_CODE;
     };
  
     public String getKEY1(){
             return KEY1;
     };
  
     public String getKEY2(){
             return KEY2;
     };
  
     public String getKEY3(){
             return KEY3;
     };
  
     public String getKEY4(){
             return KEY4;
     };
  
     public String getKEY5(){
             return KEY5;
     };
  
     public String getCUD_FLAG(){
             return CUD_FLAG;
     };
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  

//Setter 함수를 만든다
  
     public void setWORK_CLASS_CODE(String WORK_CLASS_CODE){
            this.WORK_CLASS_CODE=WORK_CLASS_CODE;
     };
  
     public void setKEY1(String KEY1){
            this.KEY1=KEY1;
     };
  
     public void setKEY2(String KEY2){
            this.KEY2=KEY2;
     };
  
     public void setKEY3(String KEY3){
            this.KEY3=KEY3;
     };
  
     public void setKEY4(String KEY4){
            this.KEY4=KEY4;
     };
  
     public void setKEY5(String KEY5){
            this.KEY5=KEY5;
     };
  
     public void setCUD_FLAG(String CUD_FLAG){
            this.CUD_FLAG=CUD_FLAG;
     };
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("WORK_CLASS_CODE:"+ this.getWORK_CLASS_CODE()+"\n");
      
      strB.append("KEY1:"+ this.getKEY1()+"\n");
      
      strB.append("KEY2:"+ this.getKEY2()+"\n");
      
      strB.append("KEY3:"+ this.getKEY3()+"\n");
      
      strB.append("KEY4:"+ this.getKEY4()+"\n");
      
      strB.append("KEY5:"+ this.getKEY5()+"\n");
      
      strB.append("CUD_FLAG:"+ this.getCUD_FLAG()+"\n");
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_TMP_TRANS_KEYHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_TMP_TRANS_KEYHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_TMP_TRANS_KEYHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_TMP_TRANS_KEYHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_TMP_TRANS_KEYHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_TMP_TRANS_KEYEntity();
  }

  public ValueObject getClone(){
         PT_TMP_TRANS_KEYEntity newEnt = new PT_TMP_TRANS_KEYEntity();
	 
          newEnt.setWORK_CLASS_CODE(this.getWORK_CLASS_CODE());
         
          newEnt.setKEY1(this.getKEY1());
         
          newEnt.setKEY2(this.getKEY2());
         
          newEnt.setKEY3(this.getKEY3());
         
          newEnt.setKEY4(this.getKEY4());
         
          newEnt.setKEY5(this.getKEY5());
         
          newEnt.setCUD_FLAG(this.getCUD_FLAG());
         
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setINS_DT(this.getINS_DT());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_TMP_TRANS_KEYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getWORK_CLASS_CODE();
        
             case 2 :
                 return  this.getKEY1();
        
             case 3 :
                 return  this.getKEY2();
        
             case 4 :
                 return  this.getKEY3();
        
             case 5 :
                 return  this.getKEY4();
        
             case 6 :
                 return  this.getKEY5();
        
             case 7 :
                 return  this.getCUD_FLAG();
        
             case 8 :
                 return  this.getSEQ();
        
             case 9 :
                 return  this.getINS_DT();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_TMP_TRANS_KEYHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setWORK_CLASS_CODE((String)value);
	            return;  
        
             case 2 :
                    this.setKEY1((String)value);
	            return;  
        
             case 3 :
                    this.setKEY2((String)value);
	            return;  
        
             case 4 :
                    this.setKEY3((String)value);
	            return;  
        
             case 5 :
                    this.setKEY4((String)value);
	            return;  
        
             case 6 :
                    this.setKEY5((String)value);
	            return;  
        
             case 7 :
                    this.setCUD_FLAG((String)value);
	            return;  
        
             case 8 :
                    this.setSEQ((String)value);
	            return;  
        
             case 9 :
                    this.setINS_DT((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_TMP_TRANS_KEYHelper.toXML(this);
  }
  
}
