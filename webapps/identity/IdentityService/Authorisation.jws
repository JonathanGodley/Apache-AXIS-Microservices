/*
Authorisation.java
Passes authorisation requests to the Identity Service

Jonathan Godley
c3188072

 */

public class Authorisation
{

    // stores our instance of the Identity Service
    private final IdentityService identityService;

    /**
     * a class constructor that gets an instance of the Identity Service
     */
    public Authorisation()
    {
        this.identityService = IdentityService.getInstance();
    }


    /**
     * validates the passed key by checking if the key is currently associated with a user, (i.e. the user has logged in) it will return true. Otherwise, false.
     *
     * @param key 5 Character String used to identify user session
     * @return Boolean true if valid session key, else false
     */
    public Boolean authorise(String key)
    {
        return identityService.authorise(key);
    }
}
