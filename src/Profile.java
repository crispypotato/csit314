import java.sql.*;
import java.util.ArrayList;

public class Profile {
    private int id;
    private String name;

    public Profile()
    {
        this.id = 0;
        this.name = "default";
    }

    public Profile(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getID()
    { return (this.id); }

    public String getName()
    { return (this.name); }

    public void setID(int id)
    { this.id = id; }

    public void setName(String name)
    { this.name = name; }

    // retrieve profile from database and return as arraylist
    public ArrayList<String> profileRecordArray()
    {
        ArrayList<String> arr = new ArrayList<String>();
        String myQuery = "SELECT PROFILE_NAME FROM PROFILE";

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

            String profile;

            while (resultSet.next()) {
                profile = resultSet.getString("PROFILE_NAME");
                arr.add(profile);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }

        return arr;
    }

    // add new profile into database
    public boolean createProfileRecord(String name)
    {
        boolean success = false; 
        
        // Prepare query
        String myQuery = "INSERT INTO PROFILE (PROFILE_NAME) VALUES (?)";

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
            myStatement.setString(1, name);

            int i = myStatement.executeUpdate();
            if (i > 0) {
                System.out.println("PROFILE RECORD INSERTED");
                success = true;
            } else {
                System.out.println("PROFILE RECORD NOT INSERTED");
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
}
