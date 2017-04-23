/**
 * HWService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package example.conor.kiernan;

public interface HWService extends javax.xml.rpc.Service {
    public java.lang.String getHWAddress();

    public example.conor.kiernan.HW getHW() throws javax.xml.rpc.ServiceException;

    public example.conor.kiernan.HW getHW(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
