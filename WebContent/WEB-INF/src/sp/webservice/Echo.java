/**
 * Echo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public interface Echo extends javax.xml.rpc.Service {
    public java.lang.String getEchoSOAP11port_httpAddress();

    public sp.webservice.EchoPortType getEchoSOAP11port_http() throws javax.xml.rpc.ServiceException;

    public sp.webservice.EchoPortType getEchoSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getEchoSOAP12port_httpAddress();

    public sp.webservice.EchoPortType getEchoSOAP12port_http() throws javax.xml.rpc.ServiceException;

    public sp.webservice.EchoPortType getEchoSOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
