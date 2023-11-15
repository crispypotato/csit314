// Controller class for searching user profile
public class searchProfileController {
    // Empty Constructor
    public searchProfileController() {}

    public Profile searchProfile(String name)
    {
        Profile myProfile = new Profile();
        myProfile = myProfile.searchProfile(name);

        return myProfile;
    }
}
