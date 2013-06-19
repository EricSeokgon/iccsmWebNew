/**
 * EchoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public class EchoLocator extends org.apache.axis.client.Service implements sp.webservice.Echo {

    public EchoLocator() {
    }


    public EchoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EchoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EchoSOAP11port_http
    private java.lang.String EchoSOAP11port_http_address = "http://localhost:80/iccsWs/services/Echo";

    public java.lang.String getEchoSOAP11port_httpAddress() {
        return EchoSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EchoSOAP11port_httpWSDDServiceName = "EchoSOAP11port_http";

    public java.lang.String getEchoSOAP11port_httpWSDDServiceName() {
        return EchoSOAP11port_httpWSDDServiceName;
    }

    public void setEchoSOAP11port_httpWSDDServiceName(java.lang.String name) {
        EchoSOAP11port_httpWSDDServiceName = name;
    }

    public sp.webservice.EchoPortType getEchoSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EchoSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEchoSOAP11port_http(endpoint);
    }

    public sp.webservice.EchoPortType getEchoSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sp.webservice.EchoSOAP11BindingStub _stub = new sp.webservice.EchoSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getEchoSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEchoSOAP11port_httpEndpointAddress(java.lang.String address) {
        EchoSOAP11port_http_address = address;
    }


    // Use to get a proxy class for EchoSOAP12port_http
    private java.lang.String EchoSOAP12port_http_address = "http://localhost:80/iccsWs/services/Echo";

    public java.lang.String getEchoSOAP12port_httpAddress() {
        return EchoSOAP12port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EchoSOAP12port_httpWSDDServiceName = "EchoSOAP12port_http";

    public java.lang.String getEchoSOAP12port_httpWSDDServiceName() {
        return EchoSOAP12port_httpWSDDServiceName;
    }

    public void setEchoSOAP12port_httpWSDDServiceName(java.lang.String name) {
        EchoSOAP12port_httpWSDDServiceName = name;
    }

    public sp.webservice.EchoPortType getEchoSOAP12port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EchoSOAP12port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEchoSOAP12port_http(endpoint);
    }

    public sp.webservice.EchoPortType getEchoSOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sp.webservice.EchoSOAP12BindingStub _stub = new sp.webservice.EchoSOAP12BindingStub(portAddress, this);
            _stub.setPortName(getEchoSOAP12port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEchoSOAP12port_httpEndpointAddress(java.lang.String address) {
        EchoSOAP12port_http_address = address;
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
            if (sp.webservice.EchoPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sp.webservice.EchoSOAP11BindingStub _stub = new sp.webservice.EchoSOAP11BindingStub(new java.net.URL(EchoSOAP11port_http_address), this);
                _stub.setPortName(getEchoSOAP11port_httpWSDDServiceName());
                return _stub;
            }
            if (sp.webservice.EchoPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sp.webservice.EchoSOAP12BindingStub _stub = new sp.webservice.EchoSOAP12BindingStub(new java.net.URL(EchoSOAP12port_http_address), this);
                _stub.setPortName(getEchoSOAP12port_httpWSDDServiceName());
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
        if ("EchoSOAP11port_http".equals(inputPortName)) {
            return getEchoSOAP11port_http();
        }
        else if ("EchoSOAP12port_http".equals(inputPortName)) {
            return getEchoSOAP12port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.sp", "Echo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.sp", "EchoSOAP11port_http"));
            ports.add(new javax.xml.namespace.QName("http://webservice.sp", "EchoSOAP12port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EchoSOAP11port_http".equals(portName)) {
            setEchoSOAP11port_httpEndpointAddress(address);
        }
        else 
if ("EchoSOAP12port_http".equals(portName)) {
            setEchoSOAP12port_httpEndpointAddress(address);
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
