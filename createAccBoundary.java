import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccBoundary extends JFrame implements ActionListener {

    private JTextField nameField, salaryField, dateJoinedField, usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JComboBox<String> roleField, positionField;

    public createAccBoundary() {

        FlatDarkLaf.setup();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Set Header
        JLabel headerLabel = new JLabel("Create New Account");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        panel.add(headerLabel, c);
        
        // Set name Label
        JLabel nameLabel = new JLabel("Name: ");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(nameLabel, c);

        // Set name
        nameField = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        panel.add(nameField, c);

        // Set Salary label
        JLabel salaryLabel = new JLabel("Salary: ");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(salaryLabel, c);

        // Set salary
        salaryField = new JTextField();
        c.gridx = 1;
        c.gridy = 2;
        panel.add(salaryField, c);

        // Set Date Joined label
        JLabel dateJoinedLabel = new JLabel("Date Joined: ");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(dateJoinedLabel, c);

        // Set Date Joined
        dateJoinedField = new JTextField();
        c.gridx = 1;
        c.gridy = 3;
        panel.add(dateJoinedField, c);

        // Set Role Label
        JLabel roleLabel = new JLabel("Role: ");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(roleLabel, c);

        // Set Role
        String[] roleChoices = {" ", "Cafe Owner","Cafe Manager", "Cafe Staff"};
        roleField = new JComboBox<String>(roleChoices);
        roleField.setVisible(true);
        roleField.setSelectedIndex(0);
        roleField.addActionListener(this);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(roleField,c);

        // Set Position Label
        JLabel positionLabel = new JLabel("Position: ");
        c.gridx = 0;
        c.gridy = 5;
        panel.add(positionLabel, c);
        
        // Set Position if Role = Cafe Staff
        String[] positionChoices = {" ", "Cashier","Chef", "Waiter"};
        positionField = new JComboBox<String>(positionChoices);
        positionField.setVisible(true);
        positionField.setSelectedIndex(0);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(positionField, c);

        // Set username label
        JLabel usernameLabel = new JLabel("Username: ");
        c.gridx = 0;
        c.gridy = 6;
        panel.add(usernameLabel, c);

        // Set username
        usernameField = new JTextField();
        c.gridx = 1;
        c.gridy = 6;
        panel.add(usernameField, c);

        // Set password label
        JLabel passwordLabel = new JLabel("Password: ");
        c.gridx = 0;
        c.gridy = 7;
        panel.add(passwordLabel, c);

        // Set password
        passwordField = new JPasswordField();
        c.gridx = 1;
        c.gridy = 7;
        panel.add(passwordField, c);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        c.gridx = 1;
        c.gridy = 8;
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        panel.add(submitButton, c);

        final JFrame frame = new JFrame("FlatDarkLaf test.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String salary = salaryField.getText();
            String dateJoined = dateJoinedField.getText();
            String role = roleField.getSelectedItem().toString();
            String position = positionField.getSelectedItem().toString();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            System.out.println("Name: "+ name);
            System.out.println("Salary: " + salary);
            System.out.println("Date Joined: " + dateJoined);
            System.out.println("Role: " + role);
            System.out.println("Position: " + position);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            // You can perform any additional operations with the values here

            nameField.setText("");
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {        
        new createAccBoundary();
    }
}

