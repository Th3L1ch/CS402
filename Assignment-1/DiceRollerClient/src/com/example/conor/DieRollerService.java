/**
 * DieRollerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.conor;

public interface DieRollerService extends javax.xml.rpc.Service {
    public java.lang.String getDieRollerAddress();

    public com.example.conor.DieRoller getDieRoller() throws javax.xml.rpc.ServiceException;

    public com.example.conor.DieRoller getDieRoller(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
