package kjf.ops;

import java.util.*;
import java.io.*;

import kjf.cfg.Config;
import kjf.util.*;

/**
 * ReportEntity 
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
public class ReportEntity implements Serializable {
	
	private Object obj ;
    private Map  fieldNameIdx = new HashMap();
	private List fieldName = new ArrayList();
	private List fieldType = new ArrayList();
	private List fieldValue = new ArrayList();
	
	private int db_type = KJFUtil.str2int(KJFUtil.print(Config.props.get("DB_TYPE"),"0"));

    public ReportEntity() {
    }
    
    public ReportEntity(Object o) {
        this.obj = o;
    }	
	
    public String toString(){
		StringBuffer buf = new StringBuffer();
		int cnt =fieldName.size();
		for(int i=0;i<cnt;i++){
			buf.append(getName(i));
			if(i+1 < cnt) buf.append(",");
		}
	    buf.append("\n\n");
		for(int j=0;j<fieldValue.size();j++){
          List value = getRow(j);  
		  cnt = value.size();
		  for(int k=0;k<cnt;k++){
			buf.append(value.get(k).toString());
			if(k+1 < cnt) buf.append(",");
		  }
		  buf.append("\n");
		}
		return buf.toString();
	}
	public void addName(String name){
		fieldNameIdx.put(name, new Integer(fieldName.size()));
		fieldName.add(name);
	}
	public void addType(String type){
		fieldType.add(type);
	}
	public void addRow(List value){
		fieldValue.add(value);
	}
	
    public List getFieldName(){
		return fieldName;
	}	
    
    public List getFieldValue(){
		return fieldValue;
	}	    
    public String getName(int idx){
		return (String)fieldName.get(idx);
	}
    public String getType(int idx){
		return (String)fieldType.get(idx);
	}
    public List getRow(int row){
		return (List)fieldValue.get(row);
	}
 
    public String toDB(Object in) {
   	 if(in instanceof String){
   	    return "'"+in.toString().replaceAll("'","''")+"'";
   	 }else if(in instanceof java.util.Date){
   		 if(db_type ==0 || db_type ==1){
   			 return "to_date('"+KJFDate.datetimeOnly((java.util.Date)in)+"','YYYY-MM-DD HH24:MI:SS')"; 
   		 } else{
   			 return "'"+KJFDate.datetimeOnly((java.util.Date)in)+"'";
   		 }
   	 }else{
   	    if(in==null)  return "null";
           else     	  return in.toString();
        }
     }
    
	
	public void setValue(int row, String name, Object value){
		if(row==0){
			addName(name);
			addType("");
		}
		List Lrow =getRow(row);
		Lrow.add(value);
		fieldValue.remove(row);
		fieldValue.add(row,Lrow);
	}
	
	
	public void remove(int row){

		fieldValue.remove(row);
	}	
	
	public String getValue(int row, int col){
        return KJFUtil.print((String)getRow(row).get(col));
	}
	
    public String getValue(int row, String name) throws  Exception{
    	
    	if(getRowCnt()==0){
    		return "";
    	}
         
    	Integer idx = null;
 
    	idx = (Integer)fieldNameIdx.get(name);

                   
        if(idx == null)
            throw new Exception("Invalid field:"+name);          

         return getValue(row,idx.intValue());         
         
	}
    
	public Object getObjValue(int row, int col){
        return getRow(row).get(col);
	}
	

    public Object getObjValue(int row, String name) throws  Exception{
    	
    	if(getRowCnt()==0){
    		return "";
    	}
         
    	Integer idx = null;
 
    	idx = (Integer)fieldNameIdx.get(name);

                   
        if(idx == null)
            throw new Exception("Invalid field:"+name);          

         return getObjValue(row,idx.intValue());         
         
	}
    

    public boolean equalToBefore(int row, int col){
		if(row <= 0)
			return false;
		return getValue(row,col).equals(getValue(row-1,col));
	}
	public boolean equalGroupToBefore(int row, int col){
		if(row <= 0)
			return false;
		for(int i=0 ; i <= col ;i++) 
		  if(getValue(row,i).equals(getValue(row-1,i)) ==false){
			return false;
		  }

        return true;
	}
    public boolean equalToBefore(int row, String name) throws Exception{
		if(row <= 0)
			return false;
		return getValue(row,name).equals(getValue(row-1,name));
	}



    public boolean equalToAfter(int row, int col){
		if(row >= getRowCnt() - 1)
			return false;

		return getValue(row,col).equals(getValue(row+1,col));
	}

	public boolean equalGroupToAfter(int row, int col){
		if(row >= getRowCnt() - 1)
			return false;
		for(int i=0 ; i <= col ;i++) 
		  if(getValue(row,i).equals(getValue(row+1,i)) ==false){
			return false;
		  }

        return true;
	}
    public boolean equalToAfter(int row, String name) throws Exception{
		if(row >= getRowCnt() - 1)
			return false;
		return getValue(row,name).equals(getValue(row+1,name));
	}


	public int getFieldCnt(){
		return this.fieldName.size();
	}
	public int getRowCnt(){
		int cnt=0;
		
    	try {  
    		cnt = this.fieldValue.size();
    	}catch(Exception e) {
        }		
			
		return cnt;
	}

	/**
	 * ReportEntity는 조인에 사용될 수 없다. 따라서 이러한 경우<br>
     * 임의의 ValueObject로 데이타를 이동시켜서 사용할 수 있다.
	 * @param vobj ValueObject
	 * @return
	 */
    public ValueObject toValueObject(ValueObject vobj){
        
        ValueObject obj = null;
        for(int i =0;i < getRowCnt() ; i++){
           ValueObject tmp = vobj.getTemp();
           for(int j=0; j< getFieldCnt();j++){
               String fieldName = getName(j);
               if( tmp.isField(fieldName) == false ){
                   tmp.addExField(fieldName);
                   tmp.setExValue(fieldName, this.getValue(i,j));
               }else{
                   tmp.setByName(fieldName, this.getValue(i,j));
               }
           }

           if(obj ==null)
               obj = tmp;
           else
               obj.append(tmp);

        }

        return obj;
    }
    
	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
