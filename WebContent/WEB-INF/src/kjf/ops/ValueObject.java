package kjf.ops;

import java.util.*;
import java.io.*;


/**
 * ValueObject
 * 
 * @author �輺�� sjokim@lgeds.lg.co.kr 
 * @version 1.0 2001
 */
abstract public class ValueObject implements Serializable, Cloneable {

    /**
    * AlternateKey Instance�� �����Ѵ�. Key List�� �Է� �޾� 
    * ��List�� ��� �´�. �� �� ����Ʈ�� �̿��Ͽ� AlternateKey Instance�� 
    * �����Ѵ�.
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
    * getClone()�� ��ü�� ���纻�� �����Ѵ�. Deep Clone�� ���� �Ͽ��� �Ѵ�.
    * Deep Clone�� �ڵ�ȭ �� �� ������ �ӵ��� ������ �־� �� ValueObject�� ����������
    * �����ؾ� �Ѵ�.�� Clone�� Extensible Field�� �������� �ʴ´�.
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
    * getTemp()�� ��ü�� ������ �����Ѵ�. �ڱ� �ڽſ� ���� Factory�� �����Ѵ�.
    * <pre>
    *  public ValueObject getTemp(){
    *         return  new BANKEntity();
    *  }
    * </pre> 
    */
    abstract public ValueObject getTemp();
    
    /**
    * �� ValueObject �ڽ��� ����ũ Ű�� ���µ� �� ������ Array�� �����Ѵ�.
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
    * �� ValueObject �ڽ��� ����ũ Ű�� ���µ� �� �ʵ���� Array�� �����Ѵ�.
    * �׷��� ���� ���� �ڽ��� Helper.PRIMARYKEY_LIST�� static���� �����Ѵ�.
    * <pre>
    *  public String[] getPrimaryKeyList(){
    *       return BANKHelper.PRIMARYKEY_LIST;
    *      }
    * </pre> 
    */
    abstract public String[] getPrimaryKeyList();  
    
    /**
    * �� ValueObject �ڽ��� ��� �ʵ���� Array�� �����Ѵ�.
    * �׷��� ���� ���� �ڽ��� Helper.FIELD_LIST static���� �����Ѵ�.
    * <pre>
    *  public String[] getFieldList(){
    *       return BANKHelper.FIELD_LIST;
    *      }
    * </pre> 
    */
    abstract public String[] getFieldList();     
    
    /**
    * �� ValueObject �ڽ��� ��� �ʵ���� Set���� �����Ѵ�.
    * �׷��� ���� ���� �ڽ��� Helper�� static���� �����Ѵ�.
    * <pre>
    *  public Set getFieldSet(){
    *       return BANKHelper.fieldMap.keySet();
    *      }
    * </pre> 
    */
    //abstract public Set getFieldSet();                    
    
    /**
    * �Էµ� name�� �ڽ��� �ʵ������� �˻��Ѵ�.
    */
    abstract public boolean isField(String key);                    
    
    /**
    * �̸��� ���� ���� ���� �޴´�.
    */
    abstract public Object getByName(String key);                 
    
    /**
    * �̸��� ���� ���� Setting�Ѵ�.
    */
    abstract public void   setByName(String key, Object value);                       
    
    /**
    * ValueObject�� XML�� ��ȯ�Ѵ�.
    */
    private Map  ex_property = null;
    
    /**
    * Ȯ�� �ʵ��� �̸� ���ո� �����Ѵ�.(Extensible)
    */
    final public Set getExFields() {
        if (ex_property == null)
            return null;
    
        return ex_property.keySet();
    }   
    
    /**
    * �Էµ� �̸��� Ȯ�� �ʵ������� �˻��Ѵ�.(Extensible)
    */
    final public boolean isExField(String key) {
        if (ex_property == null || key == null || "".equals(key))
            return false;
    
        return ex_property.containsKey(key);
    }   
    
    /**
    * �ϳ��� Ȯ�� �ʵ带 �߰��Ѵ�.(Extensible)
    */
    final public void addExField(String key) {
    
        if(key==null || "".equals(key))
            return;
        initExtensible();
    
        ex_property.put(key,null);
    }   
    
    /**
    * Ȯ�� �ʵ尪�� �����Ѵ�.(Extensible)
    */
    final public Object getExValue(String key) {
        if (key==null || ex_property == null || "".equals(key))
            return null;
    
        return ex_property.get(key);
    }
    
    /**
    * Ȯ�� �ʵ尪�� Setting�Ѵ�.(Extensible)
    */
    final public void setExValue(String key, Object value) {
        if(value == null)
            return;
        if(isExField(key) == true)
            ex_property.put(key, value);
    }
    
    /**
    * Ȯ���ʵ� �������� �ʱ�ȭ�Ѵ�.(Extensible)
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
    * ���ε� ValueObject�� �̸� ���ո� �����Ѵ�.(Joinable)
    */
    final public Set getJoinNames() {
        if (join_property == null)
            return null;
    
        return join_property.keySet();
    }   
    
    /**
    * ���ε� ��ü�� �����Ѵ�.(Joinable)
    */
    final public ValueObject getJoinObject(String key) {
        if (join_property == null)
            return null;
    
        return (ValueObject)join_property.get(key);
    }   
    
    /**
    * ���ε� ��ü�� ����Ѵ�.(Joinable)
    */
    final public void setJoinObject(String key, ValueObject value) {
        initJoinable();
        join_property.put(key, value);
    }   
    
    /**
    * ���� ����� �ʱ�ȭ�Ѵ�.(Joinable)
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
    * Listable ����� �ʱ�ȭ�Ѵ�.(Listable)
    */
    final private void initListable() {
        try {
            this.initJoinable();
            this.initExtensible();
            Object o = this.clone();
            list_property = new ArrayList();
            list_property.add(o);
        } catch (CloneNotSupportedException e) {
            //���� �̰��� �ü� ����..	 
        }
    }
    
    /**
    * ���� Ÿ���� ValueObject�� �߰��Ѵ�.(Listable)
    */
    final public void append(ValueObject newEntity) {
        if (list_property == null)
            initListable();
    
        list_property.add(newEntity);
    }
    
    /**
    * Listing��  ValueObject�� ������ �����Ѵ�.(Listable)
    */
    final public int size() {
        if(list_property == null)   {
            return 1;   
        }  else {
            return list_property.size();
        }    
    }
    
    /**
    * ValueObject List�� Iterator�� �����Ѵ�.(Listable)
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
    * index�� �̿��Ͽ� ValueObject ����Ʈ�� �����Ѵ�.(Listable)
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
    * Last appended ValueObject�� �����Ѵ�.(Listable)
    */
    final public ValueObject getLast(){
        if(list_property == null) return this;
        else return (ValueObject)list_property.get(list_property.size() - 1);  
    }
    
    /**
    * First ValueObject�� �����Ѵ�.(Listable)
    */
    final public ValueObject getFirst() {
        if(list_property == null) return this;
        else return (ValueObject)list_property.get(0);  
    }
    
    /**
    * �ڽ��� ����Ʈ�� ������ �ִ����� �����Ѵ�.(Listable)
    */
    final public boolean isList() {
        if (list_property != null) return true;
        else return false;
    }      
    
    /**
    * ó���� �����ϰ� ��� ����Ʈ�� ������.(Listable)
    */
    final public void removeTail() {
        list_property = null;
    }

}

