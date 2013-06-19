/**
 * UBAgentLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public class UBAgentLocator extends org.apache.axis.client.Service implements sp.webservice.UBAgent {

    public UBAgentLocator() {
    }


    public UBAgentLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UBAgentLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UBAgentSOAP11port_http
    private java.lang.String UBAgentSOAP11port_http_address = "http://localhost:80/iccsWs/services/UBAgent";

    public java.lang.String getUBAgentSOAP11port_httpAddress() {
        return UBAgentSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UBAgentSOAP11port_httpWSDDServiceName = "UBAgentSOAP11port_http";

    public java.lang.String getUBAgentSOAP11port_httpWSDDServiceName() {
        return UBAgentSOAP11port_httpWSDDServiceName;
    }

    public void setUBAgentSOAP11port_httpWSDDServiceName(java.lang.String name) {
        UBAgentSOAP11port_httpWSDDServiceName = name;
    }

    public sp.webservice.UBAgentPortType getUBAgentSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UBAgentSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUBAgentSOAP11port_http(endpoint);
    }

    public sp.webservice.UBAgentPortType getUBAgentSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sp.webservice.UBAgentSOAP11BindingStub _stub = new sp.webservice.UBAgentSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getUBAgentSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUBAgentSOAP11port_httpEndpointAddress(java.lang.String address) {
        UBAgentSOAP11port_http_address = address;
    }


    // Use to get a proxy class for UBAgentSOAP12port_http
    private java.lang.String UBAgentSOAP12port_http_address = "http://localhost:80/iccsWs/services/UBAgent";

    public java.lang.String getUBAgentSOAP12port_httpAddress() {
        return UBAgentSOAP12port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UBAgentSOAP12port_httpWSDDServiceName = "UBAgentSOAP12port_http";

    public java.lang.String getUBAgentSOAP12port_httpWSDDServiceName() {
        return UBAgentSOAP12port_httpWSDDServiceName;
    }

    public void setUBAgentSOAP12port_httpWSDDServiceName(java.lang.String name) {
        UBAgentSOAP12port_httpWSDDServiceName = name;
    }

    public sp.webservice.UBAgentPortType getUBAgentSOAP12port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UBAgentSOAP12port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUBAgentSOAP12port_http(endpoint);
    }

    public sp.webservice.UBAgentPortType getUBAgentSOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sp.webservice.UBAgentSOAP12BindingStub _stub = new sp.webservice.UBAgentSOAP12BindingStub(portAddress, this);
            _stub.setPortName(getUBAgentSOAP12port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUBAgentSOAP12port_httpEndpointAddress(java.lang.String address) {
        UBAgentSOAP12port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sp.webservice.UBAgentPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sp.webservice.UBAgentSOAP11BindingStub _stub = new sp.webservice.UBAgentSOAP11BindingStub(new java.net.URL(UBAgentSOAP11port_http_address), this);
                _stub.setPortName(getUBAgentSOAP11port_httpWSDDServiceName());
                return _stub;
            }
            if (sp.webservice.UBAgentPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sp.webservice.UBAgentSOAP12BindingStub _stub = new sp.webservice.UBAgentSOAP12BindingStub(new java.net.URL(UBAgentSOAP12port_http_address), this);
                _stub.setPortName(getUBAgentSOAP12port_httpWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UBAgentSOAP11port_http".equals(inputPortName)) {
            return getUBAgentSOAP11port_http();
        }
        else if ("UBAgentSOAP12port_http".equals(inputPortName)) {
            return getUBAgentSOAP12port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.sp", "UBAgent");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.sp", "UBAgentSOAP11port_http"));
            ports.add(new javax.xml.namespace.QName("http://webservice.sp", "UBAgentSOAP12port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UBAgentSOAP11port_http".equals(portName)) {
            setUBAgentSOAP11port_httpEndpointAddress(address);
        }
        else 
if ("UBAgentSOAP12port_http".equals(portName)) {
            setUBAgentSOAP12port_httpEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
