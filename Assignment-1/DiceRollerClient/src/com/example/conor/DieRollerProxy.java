package com.example.conor;

public class DieRollerProxy implements com.example.conor.DieRoller {
  private String _endpoint = null;
  private com.example.conor.DieRoller dieRoller = null;
  
  public DieRollerProxy() {
    _initDieRollerProxy();
  }
  
  public DieRollerProxy(String endpoint) {
    _endpoint = endpoint;
    _initDieRollerProxy();
  }
  
  private void _initDieRollerProxy() {
    try {
      dieRoller = (new com.example.conor.DieRollerServiceLocator()).getDieRoller();
      if (dieRoller != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dieRoller)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dieRoller)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dieRoller != null)
      ((javax.xml.rpc.Stub)dieRoller)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.example.conor.DieRoller getDieRoller() {
    if (dieRoller == null)
      _initDieRollerProxy();
    return dieRoller;
  }
  
  public java.lang.String rollDice(int n) throws java.rmi.RemoteException{
    if (dieRoller == null)
      _initDieRollerProxy();
    return dieRoller.rollDice(n);
  }
  
  
}