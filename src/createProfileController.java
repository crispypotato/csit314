// Controller class to handle new user profile creation
public class createProfileController {
    // Empty constructor
    public createProfileController() {}

    /* Method to check variables to create User account
     * True = Account created || False = Account not created
    */
    public boolean createProfileRecord(String name)
    {
        Profile pf = new Profile();
        boolean createProfile = pf.createProfileRecord(name);

        return createProfile;
    }
}
