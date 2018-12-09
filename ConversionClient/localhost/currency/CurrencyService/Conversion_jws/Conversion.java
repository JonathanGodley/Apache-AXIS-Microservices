/**
 * Conversion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Conversion_jws;

public interface Conversion extends java.rmi.Remote {
    public double convert(String fromCurrencyCode, String toCurrencyCode, double amount) throws java.rmi.RemoteException;
    public String[] listRates() throws java.rmi.RemoteException;
    public double rateOf(String fromCurrencyCode, String toCurrencyCode) throws java.rmi.RemoteException;
}
