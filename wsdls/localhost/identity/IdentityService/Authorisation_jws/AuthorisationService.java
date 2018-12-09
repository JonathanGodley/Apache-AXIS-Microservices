/**
 * AuthorisationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.identity.IdentityService.Authorisation_jws;

public interface AuthorisationService extends javax.xml.rpc.Service {
    public java.lang.String getAuthorisationAddress();

    public localhost.identity.IdentityService.Authorisation_jws.Authorisation getAuthorisation() throws javax.xml.rpc.ServiceException;

    public localhost.identity.IdentityService.Authorisation_jws.Authorisation getAuthorisation(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
