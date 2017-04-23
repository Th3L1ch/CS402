package example.conor.kiernan;

public class HWProxy implements example.conor.kiernan.HW {
  private String _endpoint = null;
  private example.conor.kiernan.HW hW = null;
  
  public HWProxy() {
    _initHWProxy();
  }
  
  public HWProxy(String endpoint) {
    _endpoint = endpoint;
    _initHWProxy();
  }
  
  private void _initHWProxy() {
    try {
      hW = (new example.conor.kiernan.HWServiceLocator()).getHW();
      if (hW != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hW)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hW)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hW != null)
      ((javax.xml.rpc.Stub)hW)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public example.conor.kiernan.HW getHW() {
    if (hW == null)
      _initHWProxy();
    return hW;
  }
  
  public java.lang.String sayHelloWorld(java.lang.String name) throws java.rmi.RemoteException{
    if (hW == null)
      _initHWProxy();
    return hW.sayHelloWorld(name);
  }
  
  
}