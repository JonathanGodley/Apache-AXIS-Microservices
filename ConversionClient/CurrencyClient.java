/*
CurrencyClient.java

Client for micro-service Conversion System
Command line application which allows a user to calculate currency conversions.

Jonathan Godley
c3188072

 */

import localhost.currency.CurrencyService.Conversion_jws.*;
import localhost.currency.CurrencyService.Conversion_jws.Conversion;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CurrencyClient
{
    public static void main(String[] args)
    {
        try
        {
            Scanner in = new Scanner(System.in);

            boolean  quit = false;
            String   input;
            String[] parsedInput;

            System.out.println("Currency Conversion Client");
            System.out.println("1. convert <fromCurrency> <toCurrency> <amount>");
            System.out.println("2. rateOf <fromCurrency> <toCurrency>");
            System.out.println("3. listRates ");
            System.out.println("4. exit");

            do
            {

                System.out.print("\nEnter Command: ");

                input = in.nextLine();

                if (input.equals("exit") || input.equals("4"))
                {
                    quit = true;
                }
                else if (input.startsWith("convert"))
                {
                    parsedInput = input.split(" ");

                    if (parsedInput.length == 4)
                    {
                        try
                        {
                            ConversionService cs = new ConversionServiceLocator();
                            Conversion        c  = cs.getConversion();

                            System.out.println(String.format("%.4f", c.convert(parsedInput[1], parsedInput[2],
                                                                               (Double.parseDouble(parsedInput[3])))));
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
                else if (input.startsWith("rateOf"))
                {
                    parsedInput = input.split(" ");

                    if (parsedInput.length == 3)
                    {
                        try
                        {
                            ConversionService cs = new ConversionServiceLocator();
                            Conversion        c  = cs.getConversion();

                            System.out.println(c.rateOf(parsedInput[1], parsedInput[2]));
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
                else if (input.startsWith("listRates"))
                {
                    try
                    {
                        ConversionService cs = new ConversionServiceLocator();
                        Conversion        c  = cs.getConversion();

                        String[] tmp = c.listRates();

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
        catch (Exception e)
        {
            System.out.println("An unexpected error has occurred");
        }

    }
}