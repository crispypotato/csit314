public class employeeEntityTest {
    // Main Method for testing purposes
    public static void main(String arg[])
    {
        boolean myBool;
        myBool = employeeEntity.createEmpRecord("myEmp", 10000, "12/10/2023", 0, "testUsername", "testPassword");
        myBool = employeeEntity.createEmpRecord("myEmp2", 20000, "13/10/2023", 0, "testUsername2", "testPassword2");
        System.out.println(myBool);

        employeeEntity.displayEmpRecord();
    }
}
