/* Controller class for createEmpRecord
 * Method only available for System Admin role
 */

final class createAccountController {

    // Empty constructor - private constructor better?
    public createAccountController() {}

    /* Method to check variables to create Employee account
     * True = Account created || False = Account not created
    */
    public boolean createUserRecord(String name, String salaryStr, String dateJoined, 
                                   int roleID, String position, String username, String password)
    {
        boolean validAccount = false;
        boolean createAccount = false;
        double salary;

        // Check if name is alpha-numeric
        if (!(isAlphaNumeric(name)) || name == "")
        {return validAccount;}

        // Check if salary is numeric
        if (isNumeric(salaryStr))
        {
            salary = Double.parseDouble(salaryStr);
        }
        else{
            return validAccount;
        }
        
        // Check if salary is within 0 to 100000
        if (salary < 0 || salary > 100000)
        {return validAccount;}

        // Check if roleID is within 0 to 100
        if (roleID < 0 || roleID > 100)
        {return validAccount;}

        if (!(isAlphaNumeric(position)))
        {return validAccount;}

        // Check if username is alphanumeric
        if (!(isAlphaNumeric(username)))
        {return validAccount;}

        // Prevent injections by ensuring username is alphanumeric FIRST
        if (!(User.isUniqueUsername(username)))
        {return validAccount;}

        // Check if password is alphanumeric
        if (!(isAlphaNumeric(password)))
        {return validAccount;}
        
        // Pass all checks - create account
        validAccount = true;
        User newUser = new User(0, name, salary, dateJoined, roleID, position, username, password);
        createAccount = newUser.createUserRecord(newUser);

        return createAccount;
    }

    // Check if string is strictly alpha-numeric
    private boolean isAlphaNumeric(String s){
        String pattern= "^[a-zA-Z0-9]*$";
        return s.matches(pattern);
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

