/**
 * AdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Admin_jws;

public interface AdminService extends javax.xml.rpc.Service {
    public String getAdminAddress();

    public Admin getAdmin() throws javax.xml.rpc.ServiceException;

    public Admin getAdmin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
