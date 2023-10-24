public class employeeEntityTest {
    // Main Method for testing purposes
    public static void main(String arg[])
    {
        boolean accountCreated = false;
 
        accountCreated = createAccountController.createUserRecord("myEmp", "10000", "12/10/2023", 4, "Cashier", "testUsername", "testPassword");
        System.out.println(accountCreated);
        accountCreated = createAccountController.createUserRecord("myEmp3", "20000", "13/10/2023", 4, "Chef", "testUsername3", "testPassword3");
        System.out.println(accountCreated);

        User currentUser = loginController.loginUser("testUsername", "testPassword");
        System.out.println("Current user: " + currentUser);

        User.displayEmpRecord();
    }
}
