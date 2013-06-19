package sp.webservice;

public class UBAgentPortTypeProxy implements sp.webservice.UBAgentPortType {
  private String _endpoint = null;
  private sp.webservice.UBAgentPortType uBAgentPortType = null;
  
  public UBAgentPortTypeProxy() {
    _initUBAgentPortTypeProxy();
  }
  
  public UBAgentPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initUBAgentPortTypeProxy();
  }
  
  private void _initUBAgentPortTypeProxy() {
    try {
      uBAgentPortType = (new sp.webservice.UBAgentLocator()).getUBAgentSOAP11port_http();
      if (uBAgentPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uBAgentPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uBAgentPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uBAgentPortType != null)
      ((javax.xml.rpc.Stub)uBAgentPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sp.webservice.UBAgentPortType getUBAgentPortType() {
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType;
  }
  
  public java.lang.String excute(java.lang.String key, java.lang.String s) throws java.rmi.RemoteException{
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType.excute(key, s);
  }
  
  public byte[] getFile(java.lang.String key, java.lang.String folder, java.lang.String fileName) throws java.rmi.RemoteException{
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType.getFile(key, folder, fileName);
  }
  
  public java.lang.Boolean checkKey(java.lang.String encodeKey) throws java.rmi.RemoteException{
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType.checkKey(encodeKey);
  }
  
  public java.lang.Integer setFile(java.lang.String key, byte[] dh, java.lang.String folder, java.lang.String fileName) throws java.rmi.RemoteException{
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType.setFile(key, dh, folder, fileName);
  }
  
  public java.lang.Integer setEbmsFile(java.lang.String key, byte[] dh, java.lang.String folder, java.lang.String fileName) throws java.rmi.RemoteException{
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType.setEbmsFile(key, dh, folder, fileName);
  }
  
  public java.lang.String[] select(java.lang.String key, java.lang.String s) throws java.rmi.RemoteException{
    if (uBAgentPortType == null)
      _initUBAgentPortTypeProxy();
    return uBAgentPortType.select(key, s);
  }
  
  
}