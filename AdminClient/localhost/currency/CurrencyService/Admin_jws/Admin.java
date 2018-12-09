/**
 * Admin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.currency.CurrencyService.Admin_jws;

public interface Admin extends java.rmi.Remote {
    public String[] listCurrencies(String sessionKey) throws java.rmi.RemoteException;
    public String[] conversionsFor(String sessionKey, String currencyCode) throws java.rmi.RemoteException;
    public boolean removeCurrency(String sessionKey, String currencyCode) throws java.rmi.RemoteException;
    public boolean addCurrency(String sessionKey, String currencyCode) throws java.rmi.RemoteException;
    public boolean addRate(String sessionKey, String fromCurrencyCode, String toCurrencyCode, double conversionRate) throws java.rmi.RemoteException;
    public boolean updateRate(String sessionKey, String fromCurrencyCode, String toCurrencyCode, double rate) throws java.rmi.RemoteException;
    public boolean removeRate(String sessionKey, String fromCurrencyCode, String toCurrencyCode) throws java.rmi.RemoteException;
    public String[] listRates(String sessionKey) throws java.rmi.RemoteException;
}
