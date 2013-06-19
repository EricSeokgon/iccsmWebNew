

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_MODIFY_REQ
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ
*  테이블 컬럼 :  
*               SEQ:VARCHAR2(6):  
*               RECV_NAME:VARCHAR2(20):  
*               RECV_PART_SIDO:VARCHAR2(20):  
*               RECV_PART_SIGUNGU:VARCHAR2(30):  
*               RECV_POS:VARCHAR2(20):  
*               CONSULT_NAME:VARCHAR2(20):  
*               CONSULT_PART_SIDO:VARCHAR2(20):  
*               CONSULT_PART_SIGUNGU:VARCHAR2(30):  
*               CONSULT_POS:VARCHAR2(20):  
*               RECV_DT:VARCHAR2(8):  
*               RECV_METHOD:VARCHAR2(30):  
*               DEMAND_CONTENTS:VARCHAR2(500):  
*               REMARK:VARCHAR2(256):  
*               PROC_OUT:VARCHAR2(20):  
*               PROC_DT:VARCHAR2(8):  
*               PROC_TIME:VARCHAR2(6):  
*               RECV_AREA:VARCHAR2(4):  
*               CONSULT_AREA:VARCHAR2(4):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_MODIFY_REQEntity extends ValueObject{

  
     private String SEQ;
  
     private String RECV_NAME;
  
     private String RECV_PART_SIDO;
  
     private String RECV_PART_SIGUNGU;
  
     private String RECV_POS;
  
     private String CONSULT_NAME;
  
     private String CONSULT_PART_SIDO;
  
     private String CONSULT_PART_SIGUNGU;
  
     private String CONSULT_POS;
  
     private String RECV_DT;
  
     private String RECV_METHOD;
  
     private String DEMAND_CONTENTS;
  
     private String REMARK;
  
     private String PROC_OUT;
  
     private String PROC_DT;
  
     private String PROC_TIME;
  
     private String RECV_AREA;
  
     private String CONSULT_AREA;
  

//생성자를 만든다
    public PT_MODIFY_REQEntity(){
    }
    
    
    public PT_MODIFY_REQEntity(String SEQ ){
       this.setSEQ(SEQ);
       
    }
      
    public PT_MODIFY_REQEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.RECV_NAME =request.getParameter("RECV_NAME");
		this.RECV_PART_SIDO =request.getParameter("RECV_PART_SIDO");
		this.RECV_PART_SIGUNGU =request.getParameter("RECV_PART_SIGUNGU");
		this.RECV_POS =request.getParameter("RECV_POS");
		this.CONSULT_NAME =request.getParameter("CONSULT_NAME");
		this.CONSULT_PART_SIDO =request.getParameter("CONSULT_PART_SIDO");
		this.CONSULT_PART_SIGUNGU =request.getParameter("CONSULT_PART_SIGUNGU");
		this.CONSULT_POS =request.getParameter("CONSULT_POS");
		this.RECV_DT =request.getParameter("RECV_DT");
		this.RECV_METHOD =request.getParameter("RECV_METHOD");
		this.DEMAND_CONTENTS =request.getParameter("DEMAND_CONTENTS");
		this.REMARK =request.getParameter("REMARK");
		this.PROC_OUT =request.getParameter("PROC_OUT");
		this.PROC_DT =request.getParameter("PROC_DT");
		this.PROC_TIME =request.getParameter("PROC_TIME");
		this.RECV_AREA =request.getParameter("RECV_AREA");
		this.CONSULT_AREA =request.getParameter("CONSULT_AREA");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.RECV_NAME =KJFMi.dsGet(ds, arg_row, "RECV_NAME");
		this.RECV_PART_SIDO =KJFMi.dsGet(ds, arg_row, "RECV_PART_SIDO");
		this.RECV_PART_SIGUNGU =KJFMi.dsGet(ds, arg_row, "RECV_PART_SIGUNGU");
		this.RECV_POS =KJFMi.dsGet(ds, arg_row, "RECV_POS");
		this.CONSULT_NAME =KJFMi.dsGet(ds, arg_row, "CONSULT_NAME");
		this.CONSULT_PART_SIDO =KJFMi.dsGet(ds, arg_row, "CONSULT_PART_SIDO");
		this.CONSULT_PART_SIGUNGU =KJFMi.dsGet(ds, arg_row, "CONSULT_PART_SIGUNGU");
		this.CONSULT_POS =KJFMi.dsGet(ds, arg_row, "CONSULT_POS");
		this.RECV_DT =KJFMi.dsGet(ds, arg_row, "RECV_DT");
		this.RECV_METHOD =KJFMi.dsGet(ds, arg_row, "RECV_METHOD");
		this.DEMAND_CONTENTS =KJFMi.dsGet(ds, arg_row, "DEMAND_CONTENTS");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.PROC_OUT =KJFMi.dsGet(ds, arg_row, "PROC_OUT");
		this.PROC_DT =KJFMi.dsGet(ds, arg_row, "PROC_DT");
		this.PROC_TIME =KJFMi.dsGet(ds, arg_row, "PROC_TIME");
		this.RECV_AREA =KJFMi.dsGet(ds, arg_row, "RECV_AREA");
		this.CONSULT_AREA =KJFMi.dsGet(ds, arg_row, "CONSULT_AREA");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getRECV_NAME(){
             return RECV_NAME;
     };
  
     public String getRECV_PART_SIDO(){
             return RECV_PART_SIDO;
     };
  
     public String getRECV_PART_SIGUNGU(){
             return RECV_PART_SIGUNGU;
     };
  
     public String getRECV_POS(){
             return RECV_POS;
     };
  
     public String getCONSULT_NAME(){
             return CONSULT_NAME;
     };
  
     public String getCONSULT_PART_SIDO(){
             return CONSULT_PART_SIDO;
     };
  
     public String getCONSULT_PART_SIGUNGU(){
             return CONSULT_PART_SIGUNGU;
     };
  
     public String getCONSULT_POS(){
             return CONSULT_POS;
     };
  
     public String getRECV_DT(){
             return RECV_DT;
     };
  
     public String getRECV_METHOD(){
             return RECV_METHOD;
     };
  
     public String getDEMAND_CONTENTS(){
             return DEMAND_CONTENTS;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getPROC_OUT(){
             return PROC_OUT;
     };
  
     public String getPROC_DT(){
             return PROC_DT;
     };
  
     public String getPROC_TIME(){
             return PROC_TIME;
     };
  
     public String getRECV_AREA(){
             return RECV_AREA;
     };
  
     public String getCONSULT_AREA(){
             return CONSULT_AREA;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setRECV_NAME(String RECV_NAME){
            this.RECV_NAME=RECV_NAME;
     };
  
     public void setRECV_PART_SIDO(String RECV_PART_SIDO){
            this.RECV_PART_SIDO=RECV_PART_SIDO;
     };
  
     public void setRECV_PART_SIGUNGU(String RECV_PART_SIGUNGU){
            this.RECV_PART_SIGUNGU=RECV_PART_SIGUNGU;
     };
  
     public void setRECV_POS(String RECV_POS){
            this.RECV_POS=RECV_POS;
     };
  
     public void setCONSULT_NAME(String CONSULT_NAME){
            this.CONSULT_NAME=CONSULT_NAME;
     };
  
     public void setCONSULT_PART_SIDO(String CONSULT_PART_SIDO){
            this.CONSULT_PART_SIDO=CONSULT_PART_SIDO;
     };
  
     public void setCONSULT_PART_SIGUNGU(String CONSULT_PART_SIGUNGU){
            this.CONSULT_PART_SIGUNGU=CONSULT_PART_SIGUNGU;
     };
  
     public void setCONSULT_POS(String CONSULT_POS){
            this.CONSULT_POS=CONSULT_POS;
     };
  
     public void setRECV_DT(String RECV_DT){
            this.RECV_DT=RECV_DT;
     };
  
     public void setRECV_METHOD(String RECV_METHOD){
            this.RECV_METHOD=RECV_METHOD;
     };
  
     public void setDEMAND_CONTENTS(String DEMAND_CONTENTS){
            this.DEMAND_CONTENTS=DEMAND_CONTENTS;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setPROC_OUT(String PROC_OUT){
            this.PROC_OUT=PROC_OUT;
     };
  
     public void setPROC_DT(String PROC_DT){
            this.PROC_DT=PROC_DT;
     };
  
     public void setPROC_TIME(String PROC_TIME){
            this.PROC_TIME=PROC_TIME;
     };
  
     public void setRECV_AREA(String RECV_AREA){
            this.RECV_AREA=RECV_AREA;
     };
  
     public void setCONSULT_AREA(String CONSULT_AREA){
            this.CONSULT_AREA=CONSULT_AREA;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("RECV_NAME:"+ this.getRECV_NAME()+"\n");
      
      strB.append("RECV_PART_SIDO:"+ this.getRECV_PART_SIDO()+"\n");
      
      strB.append("RECV_PART_SIGUNGU:"+ this.getRECV_PART_SIGUNGU()+"\n");
      
      strB.append("RECV_POS:"+ this.getRECV_POS()+"\n");
      
      strB.append("CONSULT_NAME:"+ this.getCONSULT_NAME()+"\n");
      
      strB.append("CONSULT_PART_SIDO:"+ this.getCONSULT_PART_SIDO()+"\n");
      
      strB.append("CONSULT_PART_SIGUNGU:"+ this.getCONSULT_PART_SIGUNGU()+"\n");
      
      strB.append("CONSULT_POS:"+ this.getCONSULT_POS()+"\n");
      
      strB.append("RECV_DT:"+ this.getRECV_DT()+"\n");
      
      strB.append("RECV_METHOD:"+ this.getRECV_METHOD()+"\n");
      
      strB.append("DEMAND_CONTENTS:"+ this.getDEMAND_CONTENTS()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("PROC_OUT:"+ this.getPROC_OUT()+"\n");
      
      strB.append("PROC_DT:"+ this.getPROC_DT()+"\n");
      
      strB.append("PROC_TIME:"+ this.getPROC_TIME()+"\n");
      
      strB.append("RECV_AREA:"+ this.getRECV_AREA()+"\n");
      
      strB.append("CONSULT_AREA:"+ this.getCONSULT_AREA()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_MODIFY_REQHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_MODIFY_REQHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_MODIFY_REQHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_MODIFY_REQHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_MODIFY_REQHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[1];
       values[0]= this.getSEQ();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_MODIFY_REQEntity();
  }

  public ValueObject getClone(){
         PT_MODIFY_REQEntity newEnt = new PT_MODIFY_REQEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setRECV_NAME(this.getRECV_NAME());
         
          newEnt.setRECV_PART_SIDO(this.getRECV_PART_SIDO());
         
          newEnt.setRECV_PART_SIGUNGU(this.getRECV_PART_SIGUNGU());
         
          newEnt.setRECV_POS(this.getRECV_POS());
         
          newEnt.setCONSULT_NAME(this.getCONSULT_NAME());
         
          newEnt.setCONSULT_PART_SIDO(this.getCONSULT_PART_SIDO());
         
          newEnt.setCONSULT_PART_SIGUNGU(this.getCONSULT_PART_SIGUNGU());
         
          newEnt.setCONSULT_POS(this.getCONSULT_POS());
         
          newEnt.setRECV_DT(this.getRECV_DT());
         
          newEnt.setRECV_METHOD(this.getRECV_METHOD());
         
          newEnt.setDEMAND_CONTENTS(this.getDEMAND_CONTENTS());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setPROC_OUT(this.getPROC_OUT());
         
          newEnt.setPROC_DT(this.getPROC_DT());
         
          newEnt.setPROC_TIME(this.getPROC_TIME());
         
          newEnt.setRECV_AREA(this.getRECV_AREA());
         
          newEnt.setCONSULT_AREA(this.getCONSULT_AREA());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_MODIFY_REQHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getRECV_NAME();
        
             case 3 :
                 return  this.getRECV_PART_SIDO();
        
             case 4 :
                 return  this.getRECV_PART_SIGUNGU();
        
             case 5 :
                 return  this.getRECV_POS();
        
             case 6 :
                 return  this.getCONSULT_NAME();
        
             case 7 :
                 return  this.getCONSULT_PART_SIDO();
        
             case 8 :
                 return  this.getCONSULT_PART_SIGUNGU();
        
             case 9 :
                 return  this.getCONSULT_POS();
        
             case 10 :
                 return  this.getRECV_DT();
        
             case 11 :
                 return  this.getRECV_METHOD();
        
             case 12 :
                 return  this.getDEMAND_CONTENTS();
        
             case 13 :
                 return  this.getREMARK();
        
             case 14 :
                 return  this.getPROC_OUT();
        
             case 15 :
                 return  this.getPROC_DT();
        
             case 16 :
                 return  this.getPROC_TIME();
        
             case 17 :
                 return  this.getRECV_AREA();
        
             case 18 :
                 return  this.getCONSULT_AREA();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_MODIFY_REQHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setRECV_NAME((String)value);
	            return;  
        
             case 3 :
                    this.setRECV_PART_SIDO((String)value);
	            return;  
        
             case 4 :
                    this.setRECV_PART_SIGUNGU((String)value);
	            return;  
        
             case 5 :
                    this.setRECV_POS((String)value);
	            return;  
        
             case 6 :
                    this.setCONSULT_NAME((String)value);
	            return;  
        
             case 7 :
                    this.setCONSULT_PART_SIDO((String)value);
	            return;  
        
             case 8 :
                    this.setCONSULT_PART_SIGUNGU((String)value);
	            return;  
        
             case 9 :
                    this.setCONSULT_POS((String)value);
	            return;  
        
             case 10 :
                    this.setRECV_DT((String)value);
	            return;  
        
             case 11 :
                    this.setRECV_METHOD((String)value);
	            return;  
        
             case 12 :
                    this.setDEMAND_CONTENTS((String)value);
	            return;  
        
             case 13 :
                    this.setREMARK((String)value);
	            return;  
        
             case 14 :
                    this.setPROC_OUT((String)value);
	            return;  
        
             case 15 :
                    this.setPROC_DT((String)value);
	            return;  
        
             case 16 :
                    this.setPROC_TIME((String)value);
	            return;  
        
             case 17 :
                    this.setRECV_AREA((String)value);
	            return;  
        
             case 18 :
                    this.setCONSULT_AREA((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_MODIFY_REQHelper.toXML(this);
  }
  
}
