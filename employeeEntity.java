import java.sql.*;

/* Entity Utility Class to access employee database

    Information in User database:
    ID, Name, Salary, DateJoined, RoleID, Username, Password
*/

public final class employeeEntity 
{
    private static int empCount = 0;
    // Private Constructor to prevent userEntity from being instantiated
    private employeeEntity() {}

    // Method to create new user record in database
    public static boolean createEmpRecord(String empName, double salary, String dateJoined, 
                                            int roleID, String username, String password)
    {
        // Increase id to create new unique ID
        int empID = empCount;
        empCount++;
        boolean success = false; 
        
        String myQuery = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_SALARY, EMP_DATEJOINED, "
                            + "EMP_ROLEID, EMP_USERNAME, EMP_PASSWORD) VALUES(" 
                            + String.valueOf(empID) 
                            + ", \"" + empName + "\", " 
                            + String.valueOf(salary) 
                            + ", \"" + dateJoined + "\", " 
                            + String.valueOf(roleID) 
                            + ", \"" + username + "\"" 
                            + ", \"" + password + "\")";

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cafems",
                "root", "Just@GroupProj3ctPW");
 
            Statement statement;
            statement = connection.createStatement();
            int i = statement.executeUpdate(myQuery);
            if (i > 0) {
                System.out.println("EMPLOYEE RECORD INSERTED");
                success = true;
            } else {
                System.out.println("EMPLOYEE RECORD NOT INSERTED");
            }
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }

        return success;
    }

    // Method to display employee record => To be discarded upon test finish
    public static void displayEmpRecord()
    {
        String myQuery = "SELECT * FROM EMPLOYEE";

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cafems",
                "root", "Just@GroupProj3ctPW");
 
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(myQuery);

            // Declare values for output
            int empID, roleID;
            String empName, dateJoined, username, password; 
            double salary; 

            while (resultSet.next()) {
                empID = resultSet.getInt("EMP_ID");
                empName = resultSet.getString("EMP_NAME").trim();
                salary = resultSet.getDouble("EMP_SALARY");
                dateJoined = resultSet.getString("EMP_DATEJOINED").trim();
                roleID = resultSet.getInt("EMP_ROLEID");
                username = resultSet.getString("EMP_USERNAME").trim();
                password = resultSet.getString("EMP_PASSWORD").trim();
        
                // Output records
                System.out.println("\nEMP_ID : " + empID
                                   + "\nEMP_NAME : " + empName
                                   + "\nEMP_SALARY : " + salary
                                   + "\nEMP_DATEJOINED : " + dateJoined
                                   + "\nEMP_ROLEID : " + roleID
                                   + "\nEMP_USERNAME : " + username
                                   + "\nEMP_PASSWORD : " + password
                                   + "\n==============================");
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
