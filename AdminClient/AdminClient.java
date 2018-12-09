/*
AdminClient.java

The Admin Client is a command line application which allows an administrator to manage the Conversion Service.

Jonathan Godley
c3188072

 */

import localhost.currency.CurrencyService.Admin_jws.Admin;
import localhost.currency.CurrencyService.Admin_jws.*;
import localhost.identity.IdentityService.Login_jws.*;
import localhost.identity.IdentityService.Login_jws.Login;

import javax.xml.rpc.ServiceException;
import java.io.Console;
import java.rmi.RemoteException;
import java.util.Scanner;

public class AdminClient
{
    public static void main(String[] args)
    {

        if (args.length != 1)
        {
            System.err.println("Invalid Username Passed");
            System.exit(1);
        }
        else
        {
            try
            {
                Scanner in         = new Scanner(System.in);
                String  sessionKey = "INVALID";
                String  username   = args[0];

                Console console = System.console();
                if (console == null)
                {
                    System.out.println("Couldn't get Console instance");
                    System.exit(1);
                }

                char passwordArray[] = console.readPassword("Enter Password: ");

                try
                {
                    LoginService ls = new LoginServiceLocator();
                    Login        l  = ls.getLogin();


                    String response = (l.login(username, new String(passwordArray)));

                    if (response.equals("INVALID"))
                    {

                        System.out.println("invalid attempt, 2 attempts remaining");
                        System.out.print("Enter Username: ");
                        username = in.nextLine();
                        passwordArray = console.readPassword("Enter Password: ");
                        response = (l.login(username, new String(passwordArray)));


                        if (response.equals("INVALID"))
                        {

                            System.out.println("invalid attempt, 1 attempts remaining");
                            System.out.print("Enter Username: ");
                            username = in.nextLine();
                            passwordArray = console.readPassword("Enter Password: ");
                            response = (l.login(username, new String(passwordArray)));


                            if (response.equals("INVALID"))
                            {

                                System.out.println("invalid attempt, 0 attempts remaining");
                                System.out.println("exceeded attempts, exiting");
                                System.exit(1);
                            }
                            else
                            {
                                sessionKey = response;
                            }
                        }
                        else
                        {
                            sessionKey = response;
                        }
                    }
                    else
                    {
                        sessionKey = response;
                    }

                }
                catch (ServiceException | RemoteException e)
                {
                    System.out.println("A networking error has occurred, now exiting...");
                    System.exit(1);
                }
                catch (Exception e)
                {
                    System.out.println("An unexpected error has occurred");
                }

                if (sessionKey.equals("INVALID"))
                {
                    System.out.println("invalid session key detected, exiting");
                    System.exit(1);
                }
                if (sessionKey.equals("ERROR"))
                {
                    System.out.println("Server Error - Exiting");
                    System.exit(1);
                }
                else
                {

                    boolean  quit = false;
                    String   input;
                    String[] parsedInput;

                    System.out.println("Welcome, " + username);
                    System.out.println("Currency Conversion Client");
                    System.out.println("1. addCurrency <currencyCode>");
                    System.out.println("2. removeCurrency <currencyCode>");
                    System.out.println("3. listCurrencies");
                    System.out.println("4. conversionsFor <currencyCode>");
                    System.out.println("5. addRate <fromCurrency> <toCurrency> <rate>");
                    System.out.println("6. updateRate <fromCurrency> <toCurrency> <rate>");
                    System.out.println("7. removeRate <fromCurrency> <toCurrency>");
                    System.out.println("8. listRates");
                    System.out.println("9. logout");

                    do
                    {

                        System.out.print("\nEnter Command: ");

                        input = in.nextLine();


                        if (input.equals("logout") || input.equals("9"))
                        {
                            try
                            {
                                LoginService ls = new LoginServiceLocator();
                                Login        l  = ls.getLogin();

                                Boolean success = l.logout(sessionKey);

                                if (success)
                                {
                                    System.out.println("Logout Succeeded!");
                                }
                                else
                                {
                                    System.out.println("Logout Failed!");
                                }

                            }
                            catch (ServiceException | RemoteException e)
                            {
                                System.out.println("A networking error has occurred, now exiting...");
                                System.exit(1);
                            }
                            catch (Exception e)
                            {
                                System.out.println("An unexpected error has occurred");
                            }

                            quit = true;
                        }
                        else if (input.startsWith(("addCurrency")))
                        {
                            parsedInput = input.split(" ");

                            if (parsedInput.length == 2)
                            {
                                try
                                {
                                    AdminService as = new AdminServiceLocator();
                                    Admin        a  = as.getAdmin();

                                    Boolean success = a.addCurrency(sessionKey, parsedInput[1]);

                                    if (success)
                                    {
                                        System.out.println(parsedInput[1] + " added successfully!");
                                    }
                                    else
                                    {
                                        System.out.println("Something went wrong!");
                                    }


                                }
                                catch (ServiceException | RemoteException e)
                                {
                                    System.out.println("A networking error has occurred, now exiting...");
                                    System.exit(1);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("An unexpected error has occurred");
                                }
                            }
                            else
                            {
                                System.err.println("Invalid command syntax detected!");
                            }
                        }
                        else if (input.startsWith(("removeCurrency")))
                        {
                            parsedInput = input.split(" ");

                            if (parsedInput.length == 2)
                            {
                                try
                                {
                                    AdminService as = new AdminServiceLocator();
                                    Admin        a  = as.getAdmin();

                                    Boolean success = a.removeCurrency(sessionKey, parsedInput[1]);

                                    if (success)
                                    {
                                        System.out.println(parsedInput[1] + " removed successfully!");
                                    }
                                    else
                                    {
                                        System.out.println("Something went wrong!");
                                    }


                                }
                                catch (ServiceException | RemoteException e)
                                {
                                    System.out.println("A networking error has occurred, now exiting...");
                                    System.exit(1);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("An unexpected error has occurred");
                                }
                            }
                            else
                            {
                                System.err.println("Invalid command syntax detected!");
                            }
                        }
                        else if (input.startsWith(("listCurrencies")))
                        {
                            try
                            {
                                AdminService as = new AdminServiceLocator();
                                Admin        a  = as.getAdmin();

                                String[] tmp = a.listCurrencies(sessionKey);

                                for (String s : tmp)
                                {
                                    System.out.println(s);
                                }
                            }
                            catch (ServiceException | RemoteException e)
                            {
                                System.out.println("A networking error has occurred, now exiting...");
                                System.exit(1);
                            }
                            catch (Exception e)
                            {
                                System.out.println("An unexpected error has occurred");
                            }
                        }
                        else if (input.startsWith(("conversionsFor")))
                        {
                            parsedInput = input.split(" ");

                            if (parsedInput.length == 2)
                            {
                                try
                                {
                                    AdminService as = new AdminServiceLocator();
                                    Admin        a  = as.getAdmin();

                                    String[] tmp = a.conversionsFor(sessionKey, parsedInput[1]);

                                    for (String s : tmp)
                                    {
                                        System.out.println(s);
                                    }


                                }
                                catch (ServiceException | RemoteException e)
                                {
                                    System.out.println("A networking error has occurred, now exiting...");
                                    System.exit(1);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("An unexpected error has occurred");
                                }
                            }
                            else
                            {
                                System.err.println("Invalid command syntax detected!");
                            }
                        }
                        else if (input.startsWith(("addRate")))
                        {
                            parsedInput = input.split(" ");

                            if (parsedInput.length == 4)
                            {
                                try
                                {
                                    AdminService as = new AdminServiceLocator();
                                    Admin        a  = as.getAdmin();

                                    Boolean success = a.addRate(sessionKey, parsedInput[1], parsedInput[2],
                                                                Double.parseDouble(parsedInput[3]));

                                    if (success)
                                    {
                                        System.out.println("rate added successfully!");
                                    }
                                    else
                                    {
                                        System.out.println("Something went wrong!");
                                    }


                                }
                                catch (ServiceException | RemoteException e)
                                {
                                    System.out.println("A networking error has occurred, now exiting...");
                                    System.exit(1);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("An unexpected error has occurred");
                                }
                            }
                            else
                            {
                                System.err.println("Invalid command syntax detected!");
                            }
                        }
                        else if (input.startsWith(("updateRate")))
                        {
                            parsedInput = input.split(" ");

                            if (parsedInput.length == 4)
                            {
                                try
                                {
                                    AdminService as = new AdminServiceLocator();
                                    Admin        a  = as.getAdmin();

                                    Boolean success = a.updateRate(sessionKey, parsedInput[1], parsedInput[2],
                                                                   Double.parseDouble(parsedInput[3]));

                                    if (success)
                                    {
                                        System.out.println("rate updated successfully!");
                                    }
                                    else
                                    {
                                        System.out.println("Something went wrong!");
                                    }


                                }
                                catch (ServiceException | RemoteException e)
                                {
                                    System.out.println("A networking error has occurred, now exiting...");
                                    System.exit(1);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("An unexpected error has occurred");
                                }
                            }
                            else
                            {
                                System.err.println("Invalid command syntax detected!");
                            }
                        }
                        else if (input.startsWith(("removeRate")))
                        {
                            parsedInput = input.split(" ");

                            if (parsedInput.length == 3)
                            {
                                try
                                {
                                    AdminService as = new AdminServiceLocator();
                                    Admin        a  = as.getAdmin();

                                    Boolean success = a.removeRate(sessionKey, parsedInput[1], parsedInput[2]);

                                    if (success)
                                    {
                                        System.out.println("rate removed successfully!");
                                    }
                                    else
                                    {
                                        System.out.println("Something went wrong!");
                                    }


                                }
                                catch (ServiceException | RemoteException e)
                                {
                                    System.out.println("A networking error has occurred, now exiting...");
                                    System.exit(1);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("An unexpected error has occurred");
                                }
                            }
                            else
                            {
                                System.err.println("Invalid command syntax detected!");
                            }
                        }
                        else if (input.startsWith(("listRates")))
                        {
                            try
                            {
                                AdminService as = new AdminServiceLocator();
                                Admin        a  = as.getAdmin();

                                String[] tmp = a.listRates(sessionKey);

                                for (String s : tmp)
                                {
                                    System.out.println(s);
                                }
                            }
                            catch (ServiceException | RemoteException e)
                            {
                                System.out.println("A networking error has occurred, now exiting...");
                                System.exit(1);
                            }
                            catch (Exception e)
                            {
                                System.out.println("An unexpected error has occurred");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid choice.");
                        }
                    }
                    while (!quit);

                    System.out.println("Exiting...");
                    System.exit(0);
                }
            }
            catch (Exception e)
            {
                System.out.println("An unexpected error has occurred");
            }
        }

    }

}