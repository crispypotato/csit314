// Controller class to update a profile object
public class updateProfileController {
    // Empty constructor
    public updateProfileController() {}

    public boolean updateProfileRecord(Profile newProfile){
        boolean updateProfile = newProfile.updateProfileRecord(newProfile);

        return updateProfile;
    }
}
