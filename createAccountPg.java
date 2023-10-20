import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccountPg extends JFrame implements ActionListener {

    private JTextField nameField, salaryField, dateJoinedField, usernameField;
    private JPasswordField passwordField;
    private JButton submitButton, clearButton;
    private JComboBox<String> roleField, positionField;

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);

    public createAccountPg() {

        FlatDarkLaf.setup();

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Create New Account"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        GridBagConstraints c;
        
        // Set name Label
        JLabel nameLabel = new JLabel("Name: ");
        c = createGbc(0,1);
        panel.add(nameLabel, c);

        // Set name
        nameField = new JTextField();
        c = createGbc(1,1);
        panel.add(nameField, c);

        // Set Salary label
        JLabel salaryLabel = new JLabel("Salary: ");
        c = createGbc(0,2);
        panel.add(salaryLabel, c);

        // Set salary
        salaryField = new JTextField();
        c = createGbc(1,2);
        panel.add(salaryField, c);

        // Set Date Joined label
        JLabel dateJoinedLabel = new JLabel("Date Joined: ");
        c = createGbc(0,3);
        panel.add(dateJoinedLabel, c);

        // Set Date Joined
        dateJoinedField = new JTextField();
        c = createGbc(1,3);
        panel.add(dateJoinedField, c);

        // Set Role Label
        JLabel roleLabel = new JLabel("Role: ");
        c = createGbc(0,4);
        panel.add(roleLabel, c);

        // Set Role
        String[] roleChoices = {" ", "System Admin", "Cafe Owner","Cafe Manager", "Cafe Staff"};
        roleField = new JComboBox<String>(roleChoices);
        roleField.setVisible(true);
        roleField.setSelectedIndex(0);
        roleField.addActionListener(this);
        c = createGbc(1,4);
        panel.add(roleField,c);

        // Set Position Label
        JLabel positionLabel = new JLabel("Position: ");
        c = createGbc(0,5);
        panel.add(positionLabel, c);
        
        // Set Position if Role = Cafe Staff
        String[] positionChoices = {" ", "Cashier","Chef", "Waiter"};
        positionField = new JComboBox<String>(positionChoices);
        positionField.setVisible(false);
        positionField.setSelectedIndex(0);
        c = createGbc(1,5);
        panel.add(positionField, c);

        // Set username label
        JLabel usernameLabel = new JLabel("Username: ");
        c = createGbc(0,6);
        panel.add(usernameLabel, c);

        // Set username
        usernameField = new JTextField();
        c = createGbc(1,6);
        panel.add(usernameField, c);

        // Set password label
        JLabel passwordLabel = new JLabel("Password: ");
        c = createGbc(0,7);
        panel.add(passwordLabel, c);

        // Set password
        passwordField = new JPasswordField();
        c = createGbc(1,7);
        panel.add(passwordField, c);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        final JFrame frame = new JFrame("Create New Account");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Submit details to create employee record
        if (e.getSource() == submitButton) {
            // Retrieve details from form
            String name = nameField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            String dateJoined = dateJoinedField.getText();
            int role = roleField.getSelectedIndex();
            String position = positionField.getSelectedItem().toString();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // set null field if applicable
            if (position == " ")
            {
                position = "NULL";
            }

            // Create employee
            boolean createEmployee = createAccountController.createEmpRecord(name, salary, dateJoined, role, position, username, password);
            if (createEmployee)
            {
                System.out.println("Success");
            }
            else
            {
                System.out.println("Failure");
            }
        }

        // Clear fields
        if (e.getSource() == clearButton)
        {
            nameField.setText("");
            salaryField.setText("");
            dateJoinedField.setText("");
            roleField.setSelectedIndex(0);
            positionField.setSelectedIndex(0);
            usernameField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == roleField)
        {
            if (roleField.getSelectedItem().toString() == "Cafe Staff")
            {
                positionField.setVisible(true);
                positionField.setSelectedIndex(0);
            }
            else
            {
                positionField.setVisible(false);
                positionField.setSelectedIndex(0);
            }
        }
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
  
        gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = (x == 0) ? GridBagConstraints.BOTH
              : GridBagConstraints.HORIZONTAL;
  
        gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        gbc.weightx = (x == 0) ? 0.1 : 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    public static void main(String[] args) {        
        new createAccountPg();
    }
}

