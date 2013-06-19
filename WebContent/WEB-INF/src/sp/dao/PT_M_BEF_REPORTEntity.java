

/*
*  Automatic generated  source
*  작  성  자 : 김경덕 
*
*  테이블 명   :PT_M_BEF_REPORT
*  테이블 설명 :
*  테이블 PK   :  
*               SEQ  
*               TMP_WRT_NUM  
*               WRT_NUM
*  테이블 컬럼 :  
*               SEQ:NUMBER(4):  
*               NOTE_CLASS_CODE:VARCHAR2(6):  
*               SEND_DT:VARCHAR2(8):  
*               S_PER:VARCHAR2(16):  
*               PROC_LIM:VARCHAR2(8):  
*               RECV_YN:VARCHAR2(1):  
*               REMARK:VARCHAR2(256):  
*               INS_DT:VARCHAR2(24):  
*               UPD_DT:VARCHAR2(24):  
*               WRT_ID:VARCHAR2(16):  
*               TMP_WRT_NUM:VARCHAR2(12):  
*               WRT_NUM:VARCHAR2(12):  
*               RECV_LOC:VARCHAR2(100):  
*               NOTE_METHOD_CLASS:VARCHAR2(6):  
*               GUBUN:VARCHAR2(1):
*/
package sp.dao;

import kjf.ops.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import kjf.util.KJFMi;
import com.tobesoft.platform.data.Dataset;

public class PT_M_BEF_REPORTEntity extends ValueObject{

  
     private String SEQ;
  
     private String NOTE_CLASS_CODE;
  
     private String SEND_DT;
  
     private String S_PER;
  
     private String PROC_LIM;
  
     private String RECV_YN;
  
     private String REMARK;
  
     private String INS_DT;
  
     private String UPD_DT;
  
     private String WRT_ID;
  
     private String TMP_WRT_NUM;
  
     private String WRT_NUM;
  
     private String RECV_LOC;
  
     private String NOTE_METHOD_CLASS;
  
     private String GUBUN;
  

//생성자를 만든다
    public PT_M_BEF_REPORTEntity(){
    }
    
    
    public PT_M_BEF_REPORTEntity(String SEQ,String TMP_WRT_NUM,String WRT_NUM ){
       this.setSEQ(SEQ);
       this.setTMP_WRT_NUM(TMP_WRT_NUM);
       this.setWRT_NUM(WRT_NUM);
       
    }
      
    public PT_M_BEF_REPORTEntity(ValueObject ent) throws Exception{
       Object value = null; 
       
       value = ent.getByName("SEQ");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("SEQ",value);
       
       value = ent.getByName("TMP_WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("TMP_WRT_NUM",value);
       
       value = ent.getByName("WRT_NUM");
       if(value == null) 
          throw new Exception("생성자의 PK에러 : null");
       this.setByName("WRT_NUM",value);
       
    }
    
    public void setRequestOnlyString(HttpServletRequest request) throws Exception{
		this.SEQ =request.getParameter("SEQ");
		this.NOTE_CLASS_CODE =request.getParameter("NOTE_CLASS_CODE");
		this.SEND_DT =request.getParameter("SEND_DT");
		this.S_PER =request.getParameter("S_PER");
		this.PROC_LIM =request.getParameter("PROC_LIM");
		this.RECV_YN =request.getParameter("RECV_YN");
		this.REMARK =request.getParameter("REMARK");
		this.INS_DT =request.getParameter("INS_DT");
		this.UPD_DT =request.getParameter("UPD_DT");
		this.WRT_ID =request.getParameter("WRT_ID");
		this.TMP_WRT_NUM =request.getParameter("TMP_WRT_NUM");
		this.WRT_NUM =request.getParameter("WRT_NUM");
		this.RECV_LOC =request.getParameter("RECV_LOC");
		this.NOTE_METHOD_CLASS =request.getParameter("NOTE_METHOD_CLASS");
		this.GUBUN =request.getParameter("GUBUN");
		
    }  
    
    public void setDsOnlyString(Dataset ds, int arg_row) throws Exception{  
		this.SEQ =KJFMi.dsGet(ds, arg_row, "SEQ");
		this.NOTE_CLASS_CODE =KJFMi.dsGet(ds, arg_row, "NOTE_CLASS_CODE");
		this.SEND_DT =KJFMi.dsGet(ds, arg_row, "SEND_DT");
		this.S_PER =KJFMi.dsGet(ds, arg_row, "S_PER");
		this.PROC_LIM =KJFMi.dsGet(ds, arg_row, "PROC_LIM");
		this.RECV_YN =KJFMi.dsGet(ds, arg_row, "RECV_YN");
		this.REMARK =KJFMi.dsGet(ds, arg_row, "REMARK");
		this.INS_DT =KJFMi.dsGet(ds, arg_row, "INS_DT");
		this.UPD_DT =KJFMi.dsGet(ds, arg_row, "UPD_DT");
		this.WRT_ID =KJFMi.dsGet(ds, arg_row, "WRT_ID");
		this.TMP_WRT_NUM =KJFMi.dsGet(ds, arg_row, "TMP_WRT_NUM");
		this.WRT_NUM =KJFMi.dsGet(ds, arg_row, "WRT_NUM");
		this.RECV_LOC =KJFMi.dsGet(ds, arg_row, "RECV_LOC");
		this.NOTE_METHOD_CLASS =KJFMi.dsGet(ds, arg_row, "NOTE_METHOD_CLASS");
		this.GUBUN =KJFMi.dsGet(ds, arg_row, "GUBUN");
				
    }    
    
//Getter 함수를 만든다
  
     public String getSEQ(){
             return SEQ;
     };
  
     public String getNOTE_CLASS_CODE(){
             return NOTE_CLASS_CODE;
     };
  
     public String getSEND_DT(){
             return SEND_DT;
     };
  
     public String getS_PER(){
             return S_PER;
     };
  
     public String getPROC_LIM(){
             return PROC_LIM;
     };
  
     public String getRECV_YN(){
             return RECV_YN;
     };
  
     public String getREMARK(){
             return REMARK;
     };
  
     public String getINS_DT(){
             return INS_DT;
     };
  
     public String getUPD_DT(){
             return UPD_DT;
     };
  
     public String getWRT_ID(){
             return WRT_ID;
     };
  
     public String getTMP_WRT_NUM(){
             return TMP_WRT_NUM;
     };
  
     public String getWRT_NUM(){
             return WRT_NUM;
     };
  
     public String getRECV_LOC(){
             return RECV_LOC;
     };
  
     public String getNOTE_METHOD_CLASS(){
             return NOTE_METHOD_CLASS;
     };
  
     public String getGUBUN(){
             return GUBUN;
     };
  

//Setter 함수를 만든다
  
     public void setSEQ(String SEQ){
            this.SEQ=SEQ;
     };
  
     public void setNOTE_CLASS_CODE(String NOTE_CLASS_CODE){
            this.NOTE_CLASS_CODE=NOTE_CLASS_CODE;
     };
  
     public void setSEND_DT(String SEND_DT){
            this.SEND_DT=SEND_DT;
     };
  
     public void setS_PER(String S_PER){
            this.S_PER=S_PER;
     };
  
     public void setPROC_LIM(String PROC_LIM){
            this.PROC_LIM=PROC_LIM;
     };
  
     public void setRECV_YN(String RECV_YN){
            this.RECV_YN=RECV_YN;
     };
  
     public void setREMARK(String REMARK){
            this.REMARK=REMARK;
     };
  
     public void setINS_DT(String INS_DT){
            this.INS_DT=INS_DT;
     };
  
     public void setUPD_DT(String UPD_DT){
            this.UPD_DT=UPD_DT;
     };
  
     public void setWRT_ID(String WRT_ID){
            this.WRT_ID=WRT_ID;
     };
  
     public void setTMP_WRT_NUM(String TMP_WRT_NUM){
            this.TMP_WRT_NUM=TMP_WRT_NUM;
     };
  
     public void setWRT_NUM(String WRT_NUM){
            this.WRT_NUM=WRT_NUM;
     };
  
     public void setRECV_LOC(String RECV_LOC){
            this.RECV_LOC=RECV_LOC;
     };
  
     public void setNOTE_METHOD_CLASS(String NOTE_METHOD_CLASS){
            this.NOTE_METHOD_CLASS=NOTE_METHOD_CLASS;
     };
  
     public void setGUBUN(String GUBUN){
            this.GUBUN=GUBUN;
     };
  
  

  public String toString(){
      StringBuffer strB = new StringBuffer();
      
      strB.append("SEQ:"+ this.getSEQ()+"\n");
      
      strB.append("NOTE_CLASS_CODE:"+ this.getNOTE_CLASS_CODE()+"\n");
      
      strB.append("SEND_DT:"+ this.getSEND_DT()+"\n");
      
      strB.append("S_PER:"+ this.getS_PER()+"\n");
      
      strB.append("PROC_LIM:"+ this.getPROC_LIM()+"\n");
      
      strB.append("RECV_YN:"+ this.getRECV_YN()+"\n");
      
      strB.append("REMARK:"+ this.getREMARK()+"\n");
      
      strB.append("INS_DT:"+ this.getINS_DT()+"\n");
      
      strB.append("UPD_DT:"+ this.getUPD_DT()+"\n");
      
      strB.append("WRT_ID:"+ this.getWRT_ID()+"\n");
      
      strB.append("TMP_WRT_NUM:"+ this.getTMP_WRT_NUM()+"\n");
      
      strB.append("WRT_NUM:"+ this.getWRT_NUM()+"\n");
      
      strB.append("RECV_LOC:"+ this.getRECV_LOC()+"\n");
      
      strB.append("NOTE_METHOD_CLASS:"+ this.getNOTE_METHOD_CLASS()+"\n");
      
      strB.append("GUBUN:"+ this.getGUBUN()+"\n");
      
      return strB.toString();      
  }
  
  //For ValueObject
  public String getPrefix(){
    return PT_M_BEF_REPORTHelper.PREFIX;
  }
  
  public String[] getPrimaryKeyList(){
       return PT_M_BEF_REPORTHelper.PRIMARYKEY_LIST;
      }
  public String[] getFieldList(){
       return PT_M_BEF_REPORTHelper.FIELD_LIST;
      }
  public Set getFieldSet(){
       return PT_M_BEF_REPORTHelper.fieldMap.keySet();
      }
  public boolean isField(String key){
     return PT_M_BEF_REPORTHelper.fieldMap.containsKey(key);
  };      

  public Object[] getPrimaryKeyValues(){
       Object values[] = new Object[3];
       values[0]= this.getSEQ();
       values[1]= this.getTMP_WRT_NUM();
       values[2]= this.getWRT_NUM();
       
       return values;
      }
  public ValueObject getTemp(){
          return new PT_M_BEF_REPORTEntity();
  }

  public ValueObject getClone(){
         PT_M_BEF_REPORTEntity newEnt = new PT_M_BEF_REPORTEntity();
	 
          newEnt.setSEQ(this.getSEQ());
         
          newEnt.setNOTE_CLASS_CODE(this.getNOTE_CLASS_CODE());
         
          newEnt.setSEND_DT(this.getSEND_DT());
         
          newEnt.setS_PER(this.getS_PER());
         
          newEnt.setPROC_LIM(this.getPROC_LIM());
         
          newEnt.setRECV_YN(this.getRECV_YN());
         
          newEnt.setREMARK(this.getREMARK());
         
          newEnt.setINS_DT(this.getINS_DT());
         
          newEnt.setUPD_DT(this.getUPD_DT());
         
          newEnt.setWRT_ID(this.getWRT_ID());
         
          newEnt.setTMP_WRT_NUM(this.getTMP_WRT_NUM());
         
          newEnt.setWRT_NUM(this.getWRT_NUM());
         
          newEnt.setRECV_LOC(this.getRECV_LOC());
         
          newEnt.setNOTE_METHOD_CLASS(this.getNOTE_METHOD_CLASS());
         
          newEnt.setGUBUN(this.getGUBUN());
         
	 return newEnt;
  }

  public Object getByName(String key){
         Integer idx = (Integer)PT_M_BEF_REPORTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                 return  this.getSEQ();
        
             case 2 :
                 return  this.getNOTE_CLASS_CODE();
        
             case 3 :
                 return  this.getSEND_DT();
        
             case 4 :
                 return  this.getS_PER();
        
             case 5 :
                 return  this.getPROC_LIM();
        
             case 6 :
                 return  this.getRECV_YN();
        
             case 7 :
                 return  this.getREMARK();
        
             case 8 :
                 return  this.getINS_DT();
        
             case 9 :
                 return  this.getUPD_DT();
        
             case 10 :
                 return  this.getWRT_ID();
        
             case 11 :
                 return  this.getTMP_WRT_NUM();
        
             case 12 :
                 return  this.getWRT_NUM();
        
             case 13 :
                 return  this.getRECV_LOC();
        
             case 14 :
                 return  this.getNOTE_METHOD_CLASS();
        
             case 15 :
                 return  this.getGUBUN();
        
	    }

	if(this.isExField(key)==true)
	      return getExValue(key);

	return null;
  }
  public void   setByName(String key, Object value){
         Integer idx = (Integer)PT_M_BEF_REPORTHelper.fieldMap.get(key);
	 if(idx !=null)
	    switch(idx.intValue()){
        
             case 1 :
                    this.setSEQ((String)value);
	            return;  
        
             case 2 :
                    this.setNOTE_CLASS_CODE((String)value);
	            return;  
        
             case 3 :
                    this.setSEND_DT((String)value);
	            return;  
        
             case 4 :
                    this.setS_PER((String)value);
	            return;  
        
             case 5 :
                    this.setPROC_LIM((String)value);
	            return;  
        
             case 6 :
                    this.setRECV_YN((String)value);
	            return;  
        
             case 7 :
                    this.setREMARK((String)value);
	            return;  
        
             case 8 :
                    this.setINS_DT((String)value);
	            return;  
        
             case 9 :
                    this.setUPD_DT((String)value);
	            return;  
        
             case 10 :
                    this.setWRT_ID((String)value);
	            return;  
        
             case 11 :
                    this.setTMP_WRT_NUM((String)value);
	            return;  
        
             case 12 :
                    this.setWRT_NUM((String)value);
	            return;  
        
             case 13 :
                    this.setRECV_LOC((String)value);
	            return;  
        
             case 14 :
                    this.setNOTE_METHOD_CLASS((String)value);
	            return;  
        
             case 15 :
                    this.setGUBUN((String)value);
	            return;  
        
         }
	if(this.isExField(key)==true)
	      setExValue(key, value);
  
  }
  
  public String toXML(){
         return PT_M_BEF_REPORTHelper.toXML(this);
  }
  
}
