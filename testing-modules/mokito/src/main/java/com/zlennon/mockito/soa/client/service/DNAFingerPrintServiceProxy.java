package com.zlennon.mockito.soa.client.service;

import com.zlennon.mockito.soa.dto.DNAProfile;
import org.apache.axis.client.Stub;

import javax.xml.rpc.ServiceException;

public class DNAFingerPrintServiceProxy implements DNAFingerPrintService {
  private String _endpoint = null;
  private DNAFingerPrintService dNAFingerPrintService = null;
  
  public DNAFingerPrintServiceProxy() {
    _initDNAFingerPrintServiceProxy();
  }
  
  public DNAFingerPrintServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initDNAFingerPrintServiceProxy();
  }
  
  private void _initDNAFingerPrintServiceProxy() {
    try {
      dNAFingerPrintService = (new DNAFingerPrintServiceServiceLocator()).getDNAFingerPrintService();
      if (dNAFingerPrintService != null) {
        if (_endpoint != null)
          ((Stub)dNAFingerPrintService)._setProperty("service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((Stub)dNAFingerPrintService)._getProperty("service.endpoint.address");
      }
      
    }
    catch (ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dNAFingerPrintService != null)
      ((Stub)dNAFingerPrintService)._setProperty("service.endpoint.address", _endpoint);
    
  }
  
  public DNAFingerPrintService getDNAFingerPrintService() {
    if (dNAFingerPrintService == null)
      _initDNAFingerPrintServiceProxy();
    return dNAFingerPrintService;
  }
  
  public String findMatch(DNAProfile dnaProfile) throws java.rmi.RemoteException{
    if (dNAFingerPrintService == null)
      _initDNAFingerPrintServiceProxy();
    return dNAFingerPrintService.findMatch(dnaProfile);
  }
  
  
}