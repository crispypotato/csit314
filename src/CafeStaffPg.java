import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeStaffPg extends JFrame implements ActionListener
{
    private JFrame frame;
    private JButton createAccButton, logoutButton;

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);

    public CafeStaffPg()
    {
        // Setup for UI LAF
        FlatDarkLaf.setup();

        // Create Panel
        JPanel CSPanel = new JPanel(new GridBagLayout());

        // Set System Admin Panel
        CSPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Cafe Staff | Home"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        GridBagConstraints c;

        // Set title
        JLabel headerLabel = new JLabel("What do you want to do today?");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        c = createGbc(0,0);
        c.gridwidth = 2;
        CSPanel.add(headerLabel, c);

        // Set createAccount
        createAccButton = new JButton("");
        createAccButton.addActionListener(this);
        c = createGbc(0,2);
        CSPanel.add(createAccButton, c);

        // Set logout
        logoutButton = new JButton("Log out");
        logoutButton.addActionListener(this);
        c = createGbc(5,0);
        CSPanel.add(logoutButton, c);

        frame = new JFrame("Cafe Staff Homepage");
        frame.setLayout(new GridBagLayout());

        frame.add(CSPanel, c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logoutButton){
            JOptionPane.showMessageDialog(null, "Logging out. You will now be redirected back to the login page.", "Logout success", JOptionPane.PLAIN_MESSAGE);
            frame.dispose();
            new loginPg();
        }
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;

        gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        gbc.weightx = (x == 0) ? 0.1 : 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    public static void main(String[] args) {
        new CafeStaffPg();
    }
}