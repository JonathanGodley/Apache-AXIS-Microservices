/**
 * LoginService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.identity.IdentityService.Login_jws;

public interface LoginService extends javax.xml.rpc.Service {
    public String getLoginAddress();

    public Login getLogin() throws javax.xml.rpc.ServiceException;

    public Login getLogin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
