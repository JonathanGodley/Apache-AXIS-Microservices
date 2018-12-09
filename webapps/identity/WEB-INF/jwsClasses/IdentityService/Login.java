/*
Login.java
Passes Login-related requests to the Identity Service

Jonathan Godley
c3188072

 */

public class Login
{

    // stores our instance of the Identity Service
    private final IdentityService identityService;

    /**
     * a class constructor that gets an instance of the Identity Service
     */
    public Login()
    {
        this.identityService = IdentityService.getInstance();
    }

    /**
     * Login method that returns a session key if successful
     *
     * @param username String username for login authentication
     * @param password String password associated with username
     * @return 5 character session key String if valid, else "INVALID"
     */
    public String login(String username, String password)
    {
        return identityService.login(username, password);
    }

    /**
     * Logs a user out by invalidating their session key
     *
     * @param key String session key to invalidate.
     * @return boolean true returned if there was a valid session that is now logged out, otherwise false.
     */
    public Boolean logout(String key)
    {
        return identityService.logout(key);
    }
}
