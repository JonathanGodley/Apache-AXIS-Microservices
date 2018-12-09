/*
IdentityService.java
Controller Class for Identity Application using Singleton Design Pattern

The identity service provides user authorisation.
It will expose two endpoints. It should be deployed to the context path ‘identity’.

Jonathan Godley
c3188072

 */

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public final class IdentityService
{

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Part of the Singleton Design Pattern to prevent multiple instances of the class
     */
    private static volatile IdentityService instance = null;

    /**
     * Hides the constructor of the class, part of the Singleton Design Pattern
     */
    private IdentityService()
    {
    }

    /**
     * Implementation of the Singleton Design Pattern to ensure that the class is only instantiated once
     *
     * @return returns the sole instance of the class.
     */
    public static IdentityService getInstance()
    {
        if (instance == null)
        {
            synchronized (IdentityService.class)
            {
                if (instance == null)
                {
                    instance = new IdentityService();
                }
            }
        }
        return instance;
    }

    // contains our valid session keys
    Map keys = new HashMap();

    /**
     * Logs a user in by confirming their username and password and returning a session ID or error message
     * <p>
     * Users:
     * U: hayden, P: 1234
     * U: josh, P: 4321
     *
     * @param username String username for login authentication
     * @param password String password associated with username
     * @return 5 character session key String used to identify user if valid, else "INVALID"
     */
    public String login(String username, String password)
    {
        try
        {
            if (username.equals("hayden") && password.equals("1234"))
            {
                System.out.println("DEBUG: Login request from "+username+" successful");
                return keygen(username);
            }
            else if (username.equals("josh") && password.equals("4321"))
            {
                System.out.println("DEBUG: Login request from "+username+" successful");
                return keygen(username);
            }
            else
            {
                System.out.println("DEBUG: Login request from "+username+" failed");
                return "INVALID";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "INVALID";
        }
    }

    /**
     * Checks if a session key is in the valid keys list, and removes it if it is.
     *
     * @param key String session key to invalidate.
     * @return boolean true returned if there was a valid session that is now logged out, otherwise false.
     */
    public Boolean logout(String key)
    {
        try
        {
            if (keys.containsValue(key))
            {
                keys.values().remove(key);
                System.out.println("DEBUG: Logout request for session "+key+" successful");
                return true;
            }
            else
            {
                System.out.println("DEBUG: Logout request for session "+key+" failed, session ID invalid");
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks if a key is contained in active keys list
     *
     * @param key 5 char Session ID string used to validate users
     * @return Boolean true if key is valid, else false
     */
    public Boolean authorise(String key)
    {
        try
        {
            if (keys.containsValue(key))
            {
                System.out.println("DEBUG: Session Verification request for session "+key+" successful");
                return true;
            }
            else
            {
                System.out.println("DEBUG: Session Verification request for session "+key+" failed, session ID invalid");
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Randomly generates a unique session key when called
     *
     * @return random unique 5-character session key which will be used to identify the user.
     */
    private String keygen(String username)
    {

        try
        {
            // we already know it's a successful username/password, so we can straight away remove the old session key
            if (keys.containsKey(username))
            {
                keys.remove(username);
                System.out.println("DEBUG: "+username+"'s session has been terminated");
            }


            for (int i = 0; i < 5; i++) // 5 attempts to find unused key
            {
                
				StringBuilder builder = new StringBuilder();
				int count = 5;
				String newKey = "ERROR";
				while (count-- != 0)
				{
					int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
					builder.append(ALPHA_NUMERIC_STRING.charAt(character));
					newKey = builder.toString();
				}
				
                if (!keys.containsValue(newKey))
                {

                    System.out.println("DEBUG: "+username+"'s session has been created with ID: "+newKey);
                    keys.put(username, newKey);
                    return newKey;
                }
            }

            System.out.println("DEBUG: "+username+"'s session has not been created - something went wrong");
            return "ERROR";

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("DEBUG: "+username+"'s session has not been created - something went wrong");
            return "ERROR";
        }
    }
}
