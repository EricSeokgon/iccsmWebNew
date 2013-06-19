package sp.webservice;

public class EchoPortTypeProxy implements sp.webservice.EchoPortType {
  private String _endpoint = null;
  private sp.webservice.EchoPortType echoPortType = null;
  
  public EchoPortTypeProxy() {
    _initEchoPortTypeProxy();
  }
  
  public EchoPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initEchoPortTypeProxy();
  }
  
  private void _initEchoPortTypeProxy() {
    try {
      echoPortType = (new sp.webservice.EchoLocator()).getEchoSOAP11port_http();
      if (echoPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)echoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)echoPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (echoPortType != null)
      ((javax.xml.rpc.Stub)echoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sp.webservice.EchoPortType getEchoPortType() {
    if (echoPortType == null)
      _initEchoPortTypeProxy();
    return echoPortType;
  }
  
  public java.lang.String getWecome(java.lang.String msg) throws java.rmi.RemoteException{
    if (echoPortType == null)
      _initEchoPortTypeProxy();
    return echoPortType.getWecome(msg);
  }
  
  
}