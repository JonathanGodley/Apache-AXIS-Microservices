/**
 * Login.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.identity.IdentityService.Login_jws;

public interface Login extends java.rmi.Remote {
    public boolean logout(String key) throws java.rmi.RemoteException;
    public String login(String username, String password) throws java.rmi.RemoteException;
}
