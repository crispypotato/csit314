public class employeeEntityTest {
    // Main Method for testing purposes
    public static void main(String arg[])
    {
        boolean myBool;
        Employee myEmp1 = new Employee("myEmp", 10000, "12/10/2023", 0, "testUsername", "testPassword");
        Employee myEmp2 = new Employee("myEmp2", 20000, "13/10/2023", 0, "testUsername2", "testPassword2");
        myBool = Employee.createEmpRecord(myEmp1);
        myBool = Employee.createEmpRecord(myEmp2);
        System.out.println(myBool);

        Employee.displayEmpRecord();
    }
}
