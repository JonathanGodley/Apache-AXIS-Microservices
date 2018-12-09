/**
 * ConversionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Conversion_jws;

public class ConversionServiceLocator extends org.apache.axis.client.Service implements localhost.currency.CurrencyService.Conversion_jws.ConversionService {

    public ConversionServiceLocator() {
    }


    public ConversionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConversionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Conversion
    private java.lang.String Conversion_address = "http://localhost:8080/currency/CurrencyService/Conversion.jws";

    public java.lang.String getConversionAddress() {
        return Conversion_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConversionWSDDServiceName = "Conversion";

    public java.lang.String getConversionWSDDServiceName() {
        return ConversionWSDDServiceName;
    }

    public void setConversionWSDDServiceName(java.lang.String name) {
        ConversionWSDDServiceName = name;
    }

    public localhost.currency.CurrencyService.Conversion_jws.Conversion getConversion() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Conversion_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConversion(endpoint);
    }

    public localhost.currency.CurrencyService.Conversion_jws.Conversion getConversion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.currency.CurrencyService.Conversion_jws.ConversionSoapBindingStub _stub = new localhost.currency.CurrencyService.Conversion_jws.ConversionSoapBindingStub(portAddress, this);
            _stub.setPortName(getConversionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConversionEndpointAddress(java.lang.String address) {
        Conversion_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.currency.CurrencyService.Conversion_jws.Conversion.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.currency.CurrencyService.Conversion_jws.ConversionSoapBindingStub _stub = new localhost.currency.CurrencyService.Conversion_jws.ConversionSoapBindingStub(new java.net.URL(Conversion_address), this);
                _stub.setPortName(getConversionWSDDServiceName());
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
        if ("Conversion".equals(inputPortName)) {
            return getConversion();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/currency/CurrencyService/Conversion.jws", "ConversionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/currency/CurrencyService/Conversion.jws", "Conversion"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Conversion".equals(portName)) {
            setConversionEndpointAddress(address);
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
