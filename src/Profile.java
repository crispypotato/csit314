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

    // retrieve profile from database and return as arraylist
    public static ArrayList<String> profileRecordArray()
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

    public static void main(String[] args)
    {
        ArrayList<String> myarr = new ArrayList<String>();
        myarr = profileRecordArray();
        for (String profile : myarr)
        {
            System.out.println(profile);
        }
    }
}
