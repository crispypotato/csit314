import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CafeStaffPg extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton browseWorkSlotsButton,  viewBidsButton, updateBidsButton,
            cancelBidsButton, searchBidsButton, viewAllocatedSlotsButton, setMaxSlotsButton,
            updateMaxSlotsButton, viewAccountButton, logoutButton;

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);

    public int employeeId;

    public CafeStaffPg(int employeeId) {
        // Setup for UI LAF
        FlatDarkLaf.setup();

        this.employeeId = employeeId;
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
        c = createGbc(0, 0);
        c.gridwidth = 3;
        CSPanel.add(headerLabel, c);

        // Set buttons for various functionalities
        browseWorkSlotsButton = new JButton("Browse Work Slots and Bids");
        browseWorkSlotsButton.addActionListener(this);
        c = createGbc(0, 2);
        CSPanel.add(browseWorkSlotsButton, c);


        viewBidsButton = new JButton("View/Update My Bids");
        viewBidsButton.addActionListener(this);
        c = createGbc(1, 2);
        CSPanel.add(viewBidsButton, c);




        viewAllocatedSlotsButton = new JButton("View Allocated Slots");
        viewAllocatedSlotsButton.addActionListener(this);
        c = createGbc(0, 3);
        CSPanel.add(viewAllocatedSlotsButton, c);

        setMaxSlotsButton = new JButton("Set Max Work Slots");
        setMaxSlotsButton.addActionListener(this);
        c = createGbc(1, 3);
        CSPanel.add(setMaxSlotsButton, c);

        updateMaxSlotsButton = new JButton("Update Max Work Slots");
        updateMaxSlotsButton.addActionListener(this);
        c = createGbc(1, 4);
        CSPanel.add(updateMaxSlotsButton, c);

        viewAccountButton = new JButton("View My Account");
        viewAccountButton.addActionListener(this);
        c = createGbc(0, 4);
        CSPanel.add(viewAccountButton, c);

        logoutButton = new JButton("Log out");
        logoutButton.addActionListener(this);
        c = createGbc(5, 0);
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
        if (e.getSource() == logoutButton) {
            JOptionPane.showMessageDialog(null, "Logging out. You will now be redirected back to the login page.", "Logout success", JOptionPane.PLAIN_MESSAGE);
            frame.dispose();
            new loginPg();

        } else if (e.getSource() == browseWorkSlotsButton) {
            // Implement browse work slots functionality
            new BrowserWorkSlotsPg(this.employeeId);

        } else if (e.getSource() == viewBidsButton) {
            // Implement view my bids functionality
            new ViewBidPg();

        } else if (e.getSource() == viewAllocatedSlotsButton) {
            ArrayList<WorkSlot> allocatedSlots = WorkSlot.getWorkSlotsByAssignedEmployeeId(this.employeeId);
            AllocatedSlots dialog = new AllocatedSlots(frame,allocatedSlots);
            dialog.setVisible(true);
            
        }
        else if (e.getSource() == viewAccountButton) {
            ViewAccountDialog dialog = new ViewAccountDialog(frame, User.getUserById(this.employeeId));
            dialog.setVisible(true);
        }
        // Add more else-if conditions for other buttons...
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
        new CafeStaffPg(10002);
    }
}
