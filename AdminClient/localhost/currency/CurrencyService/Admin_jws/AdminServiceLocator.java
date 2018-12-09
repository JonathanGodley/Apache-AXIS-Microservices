/**
 * AdminServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Admin_jws;

public class AdminServiceLocator extends org.apache.axis.client.Service implements AdminService {

    public AdminServiceLocator() {
    }


    public AdminServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AdminServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Admin
    private String Admin_address = "http://localhost:8080/currency/CurrencyService/Admin.jws";

    public String getAdminAddress() {
        return Admin_address;
    }

    // The WSDD service name defaults to the port name.
    private String AdminWSDDServiceName = "Admin";

    public String getAdminWSDDServiceName() {
        return AdminWSDDServiceName;
    }

    public void setAdminWSDDServiceName(String name) {
        AdminWSDDServiceName = name;
    }

    public Admin getAdmin() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Admin_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAdmin(endpoint);
    }

    public Admin getAdmin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            AdminSoapBindingStub _stub = new AdminSoapBindingStub(portAddress, this);
            _stub.setPortName(getAdminWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAdminEndpointAddress(String address) {
        Admin_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Admin.class.isAssignableFrom(serviceEndpointInterface)) {
                AdminSoapBindingStub _stub = new AdminSoapBindingStub(new java.net.URL(Admin_address), this);
                _stub.setPortName(getAdminWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
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
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
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
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
