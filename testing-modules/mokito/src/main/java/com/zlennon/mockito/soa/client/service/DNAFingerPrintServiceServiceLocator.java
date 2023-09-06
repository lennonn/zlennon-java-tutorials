/**
 * DNAFingerPrintServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zlennon.mockito.soa.client.service;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

import javax.xml.rpc.ServiceException;

public class DNAFingerPrintServiceServiceLocator extends Service implements DNAFingerPrintServiceService {

    public DNAFingerPrintServiceServiceLocator() {
    }


    public DNAFingerPrintServiceServiceLocator(EngineConfiguration config) {
        super(config);
    }

    public DNAFingerPrintServiceServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DNAFingerPrintService
    private String DNAFingerPrintService_address = "http://localhost:8080/DNACheckWS/services/DNAFingerPrintService";

    public String getDNAFingerPrintServiceAddress() {
        return DNAFingerPrintService_address;
    }

    // The WSDD service name defaults to the port name.
    private String DNAFingerPrintServiceWSDDServiceName = "DNAFingerPrintService";

    public String getDNAFingerPrintServiceWSDDServiceName() {
        return DNAFingerPrintServiceWSDDServiceName;
    }

    public void setDNAFingerPrintServiceWSDDServiceName(String name) {
        DNAFingerPrintServiceWSDDServiceName = name;
    }

    public DNAFingerPrintService getDNAFingerPrintService() throws ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DNAFingerPrintService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new ServiceException(e);
        }
        return getDNAFingerPrintService(endpoint);
    }

    public DNAFingerPrintService getDNAFingerPrintService(java.net.URL portAddress) throws ServiceException {
        try {
           DNAFingerPrintServiceSoapBindingStub _stub = new DNAFingerPrintServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getDNAFingerPrintServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDNAFingerPrintServiceEndpointAddress(String address) {
        DNAFingerPrintService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (DNAFingerPrintService.class.isAssignableFrom(serviceEndpointInterface)) {
               DNAFingerPrintServiceSoapBindingStub _stub = new DNAFingerPrintServiceSoapBindingStub(new java.net.URL(DNAFingerPrintService_address), this);
                _stub.setPortName(getDNAFingerPrintServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new ServiceException(t);
        }
        throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("DNAFingerPrintService".equals(inputPortName)) {
            return getDNAFingerPrintService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.jaxws.webservice.packt.com", "DNAFingerPrintServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.jaxws.webservice.packt.com", "DNAFingerPrintService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws ServiceException {
        
if ("DNAFingerPrintService".equals(portName)) {
            setDNAFingerPrintServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
