/**
 * HWServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package example.conor.kiernan;

public class HWServiceLocator extends org.apache.axis.client.Service implements example.conor.kiernan.HWService {

    public HWServiceLocator() {
    }


    public HWServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HWServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HW
    private java.lang.String HW_address = "http://localhost:8080/Assignment1/services/HW";

    public java.lang.String getHWAddress() {
        return HW_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HWWSDDServiceName = "HW";

    public java.lang.String getHWWSDDServiceName() {
        return HWWSDDServiceName;
    }

    public void setHWWSDDServiceName(java.lang.String name) {
        HWWSDDServiceName = name;
    }

    public example.conor.kiernan.HW getHW() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HW_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHW(endpoint);
    }

    public example.conor.kiernan.HW getHW(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            example.conor.kiernan.HWSoapBindingStub _stub = new example.conor.kiernan.HWSoapBindingStub(portAddress, this);
            _stub.setPortName(getHWWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHWEndpointAddress(java.lang.String address) {
        HW_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (example.conor.kiernan.HW.class.isAssignableFrom(serviceEndpointInterface)) {
                example.conor.kiernan.HWSoapBindingStub _stub = new example.conor.kiernan.HWSoapBindingStub(new java.net.URL(HW_address), this);
                _stub.setPortName(getHWWSDDServiceName());
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
        if ("HW".equals(inputPortName)) {
            return getHW();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://kiernan.conor.example", "HWService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://kiernan.conor.example", "HW"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HW".equals(portName)) {
            setHWEndpointAddress(address);
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
