/**
 * UBAgent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public interface UBAgent extends javax.xml.rpc.Service {
    public java.lang.String getUBAgentSOAP11port_httpAddress();

    public sp.webservice.UBAgentPortType getUBAgentSOAP11port_http() throws javax.xml.rpc.ServiceException;

    public sp.webservice.UBAgentPortType getUBAgentSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getUBAgentSOAP12port_httpAddress();

    public sp.webservice.UBAgentPortType getUBAgentSOAP12port_http() throws javax.xml.rpc.ServiceException;

    public sp.webservice.UBAgentPortType getUBAgentSOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
