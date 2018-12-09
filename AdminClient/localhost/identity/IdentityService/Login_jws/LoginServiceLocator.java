/**
 * LoginServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.identity.IdentityService.Login_jws;

public class LoginServiceLocator extends org.apache.axis.client.Service implements LoginService {

    public LoginServiceLocator() {
    }


    public LoginServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoginServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Login
    private String Login_address = "http://localhost:8080/identity/IdentityService/Login.jws";

    public String getLoginAddress() {
        return Login_address;
    }

    // The WSDD service name defaults to the port name.
    private String LoginWSDDServiceName = "Login";

    public String getLoginWSDDServiceName() {
        return LoginWSDDServiceName;
    }

    public void setLoginWSDDServiceName(String name) {
        LoginWSDDServiceName = name;
    }

    public Login getLogin() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Login_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLogin(endpoint);
    }

    public Login getLogin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            LoginSoapBindingStub _stub = new LoginSoapBindingStub(portAddress, this);
            _stub.setPortName(getLoginWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoginEndpointAddress(String address) {
        Login_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Login.class.isAssignableFrom(serviceEndpointInterface)) {
                LoginSoapBindingStub _stub = new LoginSoapBindingStub(new java.net.URL(Login_address), this);
                _stub.setPortName(getLoginWSDDServiceName());
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
        if ("Login".equals(inputPortName)) {
            return getLogin();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/identity/IdentityService/Login.jws", "LoginService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/identity/IdentityService/Login.jws", "Login"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("Login".equals(portName)) {
            setLoginEndpointAddress(address);
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
