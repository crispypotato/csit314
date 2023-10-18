/* Controller class for createEmpRecord
 * Method only available for System Admin role
 */

final class createAccountController {

    // Private constructor to prevent instatiation of controller
    private createAccountController() {}

    /* Method to check variables to create Employee account
     * True = Account created || False = Account not created
    */
    public static boolean createEmpRecord(String name, double salary, String dateJoined, 
                                   int roleID, String username, String password)
    {
        boolean validAccount = false;
        boolean createAccount = false;

        // Check if name is alpha-numeric
        if (!(isAlphaNumeric(name)))
        {return validAccount;}

        // Check if salary is within 0 to 100000
        if (salary < 0 || salary > 100000)
        {return validAccount;}

        // Check if roleID is within 0 to 100
        if (roleID < 0 || roleID > 100)
        {return validAccount;}

        // Check if username is alphanumeric AND unique
        if (!(isAlphaNumeric(username)))
        {return validAccount;}

        // Prevent injections by ensuring username is alphanumeric FIRST
        if (!(Employee.isUniqueUsername(username)))
        {return validAccount;}

        // Check if password is alphanumeric
        if (!(isAlphaNumeric(password)))
        {return validAccount;}
        
        // Pass all checks - create account
        System.out.println("Should not reach here!");
        validAccount = true;
        Employee newEmployee = new Employee(0, name, salary, dateJoined, roleID, username, password);
        createAccount = Employee.createEmpRecord(newEmployee);

        return createAccount;
    }

    // Check if string is strictly alpha-numeric
    private static boolean isAlphaNumeric(String s){
        String pattern= "^[a-zA-Z0-9]*$";
        return s.matches(pattern);
    }
}

