/**
 * DNAFingerPrintService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zlennon.mockito.soa.client.service;

import com.zlennon.mockito.soa.dto.DNAProfile;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DNAFingerPrintService extends Remote {
    public String findMatch(DNAProfile dnaProfile) throws RemoteException;
}
