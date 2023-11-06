public class employeeEntityTest {
    // Main Method for testing purposes
    public static void main(String arg[])
    {
        boolean accountCreated = false;
 
        createAccountController createAC = new createAccountController();
        User testUser = new User(0, "staff1", 10000, "12/10/2023", 4, "Cashier", "cafestaff1", "cafestaff1");
        accountCreated = createAC.createUserRecord(testUser);
        System.out.println(accountCreated);
        User testUser2 = new User(0, "staff2", 10000, "12/10/2023", 4, "Chef", "cafestaff2", "cafestaff2");
        accountCreated = createAC.createUserRecord(testUser2);
        System.out.println(accountCreated);

        loginController loginController = new loginController();
        User currentUser = loginController.loginUser("testUsername", "testPassword");
        System.out.println("Current user: " + currentUser);

        User.displayEmpRecord();
    }
}
