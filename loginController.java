public class loginController {

    // Prevent instantiation of class object
    private loginController() {}

    public boolean authenAccount(String username, String password)
    {
        // Ensure username and password is alphanumeric
        if (!(isAlphaNumeric(username)) || !(isAlphaNumeric(password)))
        {
            return false;
        }

        boolean authenAccount = User.authenAccount(username, password);
        return authenAccount;
    }

    public User loginUser(String username, String password)
    {
        User currentUser = User.loginUser(username, password);
        return currentUser;
    }

    // Check if string is strictly alpha-numeric
    private static boolean isAlphaNumeric(String s){
        String pattern= "^[a-zA-Z0-9]*$";
        return s.matches(pattern);
    }
}
