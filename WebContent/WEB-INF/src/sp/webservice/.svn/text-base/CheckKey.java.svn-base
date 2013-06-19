/**
 * CheckKey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public class CheckKey  implements java.io.Serializable {
    private java.lang.String encodeKey;

    public CheckKey() {
    }

    public CheckKey(
           java.lang.String encodeKey) {
           this.encodeKey = encodeKey;
    }


    /**
     * Gets the encodeKey value for this CheckKey.
     * 
     * @return encodeKey
     */
    public java.lang.String getEncodeKey() {
        return encodeKey;
    }


    /**
     * Sets the encodeKey value for this CheckKey.
     * 
     * @param encodeKey
     */
    public void setEncodeKey(java.lang.String encodeKey) {
        this.encodeKey = encodeKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckKey)) return false;
        CheckKey other = (CheckKey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.encodeKey==null && other.getEncodeKey()==null) || 
             (this.encodeKey!=null &&
              this.encodeKey.equals(other.getEncodeKey())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEncodeKey() != null) {
            _hashCode += getEncodeKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckKey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.sp", ">checkKey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encodeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.sp", "encodeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
