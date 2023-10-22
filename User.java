import java.sql.*;

/* Employee Entity Class

    Information in Employee database:
    empID, Name, Salary, DateJoined, RoleID, PositionID, Username, Password
*/

class User
{
    // Declaration of variables in Employee
    private int empID, roleID;
    private String name, username, password, dateJoined, position;
    private double salary;

    // Constructor for Employee Class
    public User (int empID, String name, double salary, String dateJoined, 
                        int roleID, String position, String username, String password)
    {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
        this.dateJoined = dateJoined;
        this.roleID = roleID;
        this.position = position;
        this.username = username;
        this.password = password;
    }

    /* Method to create new user record in database
     * EmpID is automatically set by database
     */
    public static boolean createEmpRecord(User myEmp)
    {
        boolean success = false; 
        
        // Prepare query
        String myQuery = "INSERT INTO EMPLOYEE (EMP_NAME, EMP_SALARY, EMP_DATEJOINED, "
                            + "EMP_ROLEID, EMP_POSITION, EMP_USERNAME, EMP_PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        try 
        {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cafems",
                "root", "Just@GroupProj3ctPW");
 
            // Prepare statement
            PreparedStatement myStatement = connection.prepareStatement(myQuery);

            // Set parameters for statement
            myStatement.setString(1, myEmp.name);
            myStatement.setDouble(2, myEmp.salary);
            myStatement.setString(3, myEmp.dateJoined); // Possible swap to SQL Date?
            myStatement.setInt(4, myEmp.roleID);
            if (myEmp.position == "NULL")
            {
                myStatement.setNull(5, Types.VARCHAR);
            }
            else
            {
                myStatement.setString(5, myEmp.position);
            }
            myStatement.setString(6, myEmp.username);
            myStatement.setString(7, myEmp.password);

            int i = myStatement.executeUpdate();
            if (i > 0) {
                System.out.println("EMPLOYEE RECORD INSERTED");
                success = true;
            } else {
                System.out.println("EMPLOYEE RECORD NOT INSERTED");
            }
            myStatement.close();
            connection.close();
        }
        catch (Exception exception) 
        {
            System.out.println(exception);
        }

        return success;
    }

    // Check against database if username is unique
    public static boolean isUniqueUsername(String username)
    {
        boolean uniqueUsername = false;

        // Prepare query
        String myQuery = "SELECT * FROM EMPLOYEE WHERE EMP_USERNAME = (?)";

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cafems",
                "root", "Just@GroupProj3ctPW");
 
            // Prepare statement
            PreparedStatement myStatement = connection.prepareStatement(myQuery);

            // Set parameters for statement
            myStatement.setString(1, username);

            ResultSet resultSet;
            resultSet = myStatement.executeQuery();

            // if resultSet gets a record, username is not unique
            if (resultSet.next()) {
                uniqueUsername = false;
            } else {
                uniqueUsername = true;
            }

            myStatement.close();
            connection.close();
        }
        catch (Exception exception) 
        {
            System.out.println(exception);
        }

        return uniqueUsername;
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
            String empName, dateJoined, position, username, password; 
            double salary; 

            while (resultSet.next()) {
                empID = resultSet.getInt("EMP_ID");
                empName = resultSet.getString("EMP_NAME").trim();
                salary = resultSet.getDouble("EMP_SALARY");
                dateJoined = resultSet.getString("EMP_DATEJOINED").trim();
                roleID = resultSet.getInt("EMP_ROLEID");
                position = resultSet.getString("EMP_POSITION");
                username = resultSet.getString("EMP_USERNAME").trim();
                password = resultSet.getString("EMP_PASSWORD").trim();
        
                // Output records
                System.out.println("\nEMP_ID : " + empID
                                   + "\nEMP_NAME : " + empName
                                   + "\nEMP_SALARY : " + salary
                                   + "\nEMP_DATEJOINED : " + dateJoined
                                   + "\nEMP_ROLEID : " + roleID
                                   + "\nEMP_POSITION : " + position 
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

    // Maybe set a method that allows for connection to prevent code reiteration

    // Method that authenticates username and password and logs in the user
    public static boolean authenAccount(String username, String password)
    {
        boolean authenUser = false;

        // Prepare query
        String myQuery = "SELECT * FROM EMPLOYEE WHERE EMP_USERNAME = (?) AND EMP_PASSWORD = (?)";

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cafems",
                "root", "Just@GroupProj3ctPW");
 
            // Prepare statement
            PreparedStatement myStatement = connection.prepareStatement(myQuery);

            // Set parameters for statement
            myStatement.setString(1, username);
            myStatement.setString(2, password);

            ResultSet resultSet;
            resultSet = myStatement.executeQuery();

            // if resultSet gets a record, username and password matches
            if (resultSet.next()) {
                authenUser = true;
            } else {
                authenUser = false;
            }

            myStatement.close();
            connection.close();
        }
        catch (Exception exception) 
        {
            System.out.println(exception);
        }

        return authenUser;
    }

}
