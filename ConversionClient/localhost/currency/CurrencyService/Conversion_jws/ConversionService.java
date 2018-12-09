/**
 * ConversionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Conversion_jws;

public interface ConversionService extends javax.xml.rpc.Service {
    public String getConversionAddress();

    public Conversion getConversion() throws javax.xml.rpc.ServiceException;

    public Conversion getConversion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
