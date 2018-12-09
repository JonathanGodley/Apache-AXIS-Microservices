/**
 * AdminServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Admin_jws;

public class AdminServiceLocator extends org.apache.axis.client.Service implements localhost.currency.CurrencyService.Admin_jws.AdminService {

    public AdminServiceLocator() {
    }


    public AdminServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AdminServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Admin
    private java.lang.String Admin_address = "http://localhost:8080/currency/CurrencyService/Admin.jws";

    public java.lang.String getAdminAddress() {
        return Admin_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AdminWSDDServiceName = "Admin";

    public java.lang.String getAdminWSDDServiceName() {
        return AdminWSDDServiceName;
    }

    public void setAdminWSDDServiceName(java.lang.String name) {
        AdminWSDDServiceName = name;
    }

    public localhost.currency.CurrencyService.Admin_jws.Admin getAdmin() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Admin_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAdmin(endpoint);
    }

    public localhost.currency.CurrencyService.Admin_jws.Admin getAdmin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.currency.CurrencyService.Admin_jws.AdminSoapBindingStub _stub = new localhost.currency.CurrencyService.Admin_jws.AdminSoapBindingStub(portAddress, this);
            _stub.setPortName(getAdminWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAdminEndpointAddress(java.lang.String address) {
        Admin_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.currency.CurrencyService.Admin_jws.Admin.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.currency.CurrencyService.Admin_jws.AdminSoapBindingStub _stub = new localhost.currency.CurrencyService.Admin_jws.AdminSoapBindingStub(new java.net.URL(Admin_address), this);
                _stub.setPortName(getAdminWSDDServiceName());
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
        if ("Admin".equals(inputPortName)) {
            return getAdmin();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/currency/CurrencyService/Admin.jws", "AdminService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/currency/CurrencyService/Admin.jws", "Admin"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Admin".equals(portName)) {
            setAdminEndpointAddress(address);
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
