package kjf.ops;

import java.util.*;
import java.io.*;


/**
 * ValueObject
 * 
 * @author 김성조 sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
abstract public class ValueObject implements Serializable, Cloneable {

    /**
    * AlternateKey Instance를 리턴한다. Key List를 입력 받아 
    * 값List을 얻어 온다. 이 값 리스트를 이용하여 AlternateKey Instance를 
    * 생성한다.
    */
    public  AlternateKey getAlternateKey(String[] keys) {
    
        if(keys == null) 
            return null;
    
        Object[] values = new Object[keys.length];
    
        for(int i=0;i < keys.length;i++){
            values[i] = this.getByName(keys[i]);
        }
    
        return new AlternateKey(values);
    }              
    
    /**
    * getClone()는 객체의 복사본을 리턴한다. Deep Clone을 구현 하여야 한다.
    * Deep Clone를 자동화 할 수 있으나 속도의 문제가 있어 각 ValueObject는 개별적으로
    * 구현해야 한다.단 Clone는 Extensible Field는 복사하지 않는다.
    * <pre>
    *  public ValueObject getClone(){
    *         BANKEntity newEnt = new BANKEntity();
    *         newEnt.setBANK_ID(this.getBANK_ID());
    *         newEnt.setBANK_NAME(this.getBANK_NAME());
    *         return newEnt;
    *  }
    * </pre> 
    */
    abstract public ValueObject getClone();   
    
    /**
    * getTemp()는 객체의 원형을 리턴한다. 자기 자신에 대한 Factory를 구현한다.
    * <pre>
    *  public ValueObject getTemp(){
    *         return  new BANKEntity();
    *  }
    * </pre> 
    */
    abstract public ValueObject getTemp();
    
    /**
    * 각 ValueObject 자신의 유니크 키를 갖는데 이 값들의 Array를 리턴한다.
    * <pre>
    *  public Object[] getPrimaryKeyValues(){
    *       Object values[] = new Object[1];
    *       values[0]= this.getBANK_ID();
    *       return values;
    *      }
    * </pre> 
    */
    abstract public Object[] getPrimaryKeyValues();                 
    
    /**
    * 각 ValueObject 자신의 유니크 키를 갖는데 이 필드명을 Array를 리턴한다.
    * 그러나 실제 값은 자신의 Helper.PRIMARYKEY_LIST에 static으로 존재한다.
    * <pre>
    *  public String[] getPrimaryKeyList(){
    *       return BANKHelper.PRIMARYKEY_LIST;
    *      }
    * </pre> 
    */
    abstract public String[] getPrimaryKeyList();  
    
    /**
    * 각 ValueObject 자신의 모든 필드명을 Array를 리턴한다.
    * 그러나 실제 값은 자신의 Helper.FIELD_LIST static으로 존재한다.
    * <pre>
    *  public String[] getFieldList(){
    *       return BANKHelper.FIELD_LIST;
    *      }
    * </pre> 
    */
    abstract public String[] getFieldList();     
    
    /**
    * 각 ValueObject 자신의 모든 필드명을 Set으로 리턴한다.
    * 그러나 실제 값은 자신의 Helper에 static으로 존재한다.
    * <pre>
    *  public Set getFieldSet(){
    *       return BANKHelper.fieldMap.keySet();
    *      }
    * </pre> 
    */
    //abstract public Set getFieldSet();                    
    
    /**
    * 입력된 name이 자신의 필드인지를 검사한다.
    */
    abstract public boolean isField(String key);                    
    
    /**
    * 이름에 의해 값을 리턴 받는다.
    */
    abstract public Object getByName(String key);                 
    
    /**
    * 이름에 의해 값을 Setting한다.
    */
    abstract public void   setByName(String key, Object value);                       
    
    /**
    * ValueObject를 XML로 변환한다.
    */
    private Map  ex_property = null;
    
    /**
    * 확장 필드의 이름 집합를 리턴한다.(Extensible)
    */
    final public Set getExFields() {
        if (ex_property == null)
            return null;
    
        return ex_property.keySet();
    }   
    
    /**
    * 입력된 이름이 확장 필드인지를 검사한다.(Extensible)
    */
    final public boolean isExField(String key) {
        if (ex_property == null || key == null || "".equals(key))
            return false;
    
        return ex_property.containsKey(key);
    }   
    
    /**
    * 하나의 확장 필드를 추가한다.(Extensible)
    */
    final public void addExField(String key) {
    
        if(key==null || "".equals(key))
            return;
        initExtensible();
    
        ex_property.put(key,null);
    }   
    
    /**
    * 확장 필드값을 리턴한다.(Extensible)
    */
    final public Object getExValue(String key) {
        if (key==null || ex_property == null || "".equals(key))
            return null;
    
        return ex_property.get(key);
    }
    
    /**
    * 확장 필드값을 Setting한다.(Extensible)
    */
    final public void setExValue(String key, Object value) {
        if(value == null)
            return;
        if(isExField(key) == true)
            ex_property.put(key, value);
    }
    
    /**
    * 확장필드 저장기능을 초기화한다.(Extensible)
    */
    final private void initExtensible(){
        if(ex_property == null)
            ex_property = new HashMap();
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //JoinableEntity Attribute
    //
    private Map  join_property = null;
    
    /**
    * 조인된 ValueObject의 이름 집합를 리턴한다.(Joinable)
    */
    final public Set getJoinNames() {
        if (join_property == null)
            return null;
    
        return join_property.keySet();
    }   
    
    /**
    * 조인된 객체를 리턴한다.(Joinable)
    */
    final public ValueObject getJoinObject(String key) {
        if (join_property == null)
            return null;
    
        return (ValueObject)join_property.get(key);
    }   
    
    /**
    * 조인된 객체를 등록한다.(Joinable)
    */
    final public void setJoinObject(String key, ValueObject value) {
        initJoinable();
        join_property.put(key, value);
    }   
    
    /**
    * 조인 기능을 초기화한다.(Joinable)
    */
    final private void initJoinable(){
        if(join_property == null)
            join_property = new HashMap();
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //ListableEntity Attribute
    //    
    private List list_property = null;
    
    /**
    * Listable 기능을 초기화한다.(Listable)
    */
    final private void initListable() {
        try {
            this.initJoinable();
            this.initExtensible();
            Object o = this.clone();
            list_property = new ArrayList();
            list_property.add(o);
        } catch (CloneNotSupportedException e) {
            //절대 이곳에 올수 없다..	 
        }
    }
    
    /**
    * 동일 타입의 ValueObject를 추가한다.(Listable)
    */
    final public void append(ValueObject newEntity) {
        if (list_property == null)
            initListable();
    
        list_property.add(newEntity);
    }
    
    /**
    * Listing된  ValueObject의 갯수를 리턴한다.(Listable)
    */
    final public int size() {
        if(list_property == null)   {
            return 1;   
        }  else {
            return list_property.size();
        }    
    }
    
    /**
    * ValueObject List를 Iterator로 리턴한다.(Listable)
    */
    final public Iterator iterator() {
        if (isList() == true)
            return list_property.iterator();
        else {
            Vector tmp = new Vector();
            tmp.addElement(this);
            return tmp.iterator();
        }
    }      
    
    /**
    * index를 이용하여 ValueObject 리스트에 접근한다.(Listable)
    */
    final public ValueObject get(int idx) throws Exception {
        if(list_property == null) {
            if(idx == 0) return this;
            else throw new Exception("Invalid index");
        } else {
            return (ValueObject)list_property.get(idx);  
        }
    }
    
    /**
    * Last appended ValueObject를 리턴한다.(Listable)
    */
    final public ValueObject getLast(){
        if(list_property == null) return this;
        else return (ValueObject)list_property.get(list_property.size() - 1);  
    }
    
    /**
    * First ValueObject를 리턴한다.(Listable)
    */
    final public ValueObject getFirst() {
        if(list_property == null) return this;
        else return (ValueObject)list_property.get(0);  
    }
    
    /**
    * 자신이 리스트를 가지고 있는지를 리턴한다.(Listable)
    */
    final public boolean isList() {
        if (list_property != null) return true;
        else return false;
    }      
    
    /**
    * 처음을 제외하고 모든 리스트를 버린다.(Listable)
    */
    final public void removeTail() {
        list_property = null;
    }

}

