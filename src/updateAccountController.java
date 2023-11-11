public class updateAccountController {
      // Empty constructor
    public updateAccountController() {}

    public boolean updateUserRecord(User newUser)
    {
        boolean updateAccount = newUser.updateUserRecord(newUser);

        return updateAccount;
    }
}
