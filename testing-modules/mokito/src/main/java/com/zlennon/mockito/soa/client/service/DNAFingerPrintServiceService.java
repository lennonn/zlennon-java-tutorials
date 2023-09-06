/**
 * DNAFingerPrintServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zlennon.mockito.soa.client.service;


import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface DNAFingerPrintServiceService extends Service {
    public String getDNAFingerPrintServiceAddress();

    public DNAFingerPrintService getDNAFingerPrintService() throws ServiceException;

    public DNAFingerPrintService getDNAFingerPrintService(java.net.URL portAddress) throws ServiceException;
}
