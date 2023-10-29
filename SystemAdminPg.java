import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemAdminPg extends JFrame implements ActionListener
{
    private JFrame frame;
    private JButton createAccButton;

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);

    public SystemAdminPg()
    {
        // Setup for UI LAF
        FlatDarkLaf.setup();

        // Create Panel
        JPanel SAPanel = new JPanel(new GridBagLayout());

        // Set System Admin Panel
        SAPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("System Admin | Home"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        GridBagConstraints c;

        // Set title
        JLabel headerLabel = new JLabel("What do you want to do today?");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        c = createGbc(0,0);
        c.gridwidth = 2;
        SAPanel.add(headerLabel, c);

        // Set createAccount
        createAccButton = new JButton("Create an Account");
        createAccButton.addActionListener(this);
        c = createGbc(0,2);
        SAPanel.add(createAccButton, c);

        frame = new JFrame("System Admin Homepage");
        frame.setLayout(new GridBagLayout());

        frame.add(SAPanel, c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createAccButton){
            new createAccountPg();
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
        new SystemAdminPg();
    }

}
