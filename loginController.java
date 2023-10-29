/* Controller class for login
 * Method available for all users
 */

final class loginController {

    // Empty constructor
    public loginController() {}

    public User loginUser(String username, String password)
    {
        User currentUser;

        if ((isAlphaNumeric(username)) || (isAlphaNumeric(password)))
        {
            currentUser = User.authenAccount(username, password);
        }
        else
        {
            currentUser = new User();
        }
            return currentUser;
    }

    // Check if string is strictly alpha-numeric
    private static boolean isAlphaNumeric(String s){
        String pattern= "^[a-zA-Z0-9]*$";
        return s.matches(pattern);
    }
}
