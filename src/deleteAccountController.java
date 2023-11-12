public class deleteAccountController {
    // Empty constructor
    public deleteAccountController() {}

    public boolean deleteUserRecord(int id)
    {
        User u = new User();
        boolean deleteAccount = u.deleteUserRecord(id);

        return deleteAccount;
    }
}
