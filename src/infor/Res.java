package infor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Res extends JFrame {
    private JLabel nameLabel, AgeLabel,genderLabel,phoneLabel,emailLabel;
    private JTextField nameField, AgeField,genderField,phoneField ,EmailField;
    private JButton checkButton, inviteFriendButton, submitButton;
    private JLabel resultLabel, groupSizeLabel;
    private JRadioButton aloneRadioButton, groupRadioButton;
    private JTextField groupSizeField;
    private JCheckBox randomGroupCheckbox;
    private JComboBox<String> neighborhoodBox,genderComboBox;
    private JPanel infoPanel, jsonPanel, groupPanel;

    public Res() {
        // Set the layout of the frame to GridLayout
        setLayout(new GridLayout(4, 2));
        
        // Add the radio buttons to a button group
        ButtonGroup buttonGroup = new ButtonGroup();
        aloneRadioButton = new JRadioButton("Going alone");
        groupRadioButton = new JRadioButton("Going with a group");
        buttonGroup.add(aloneRadioButton);
        buttonGroup.add(groupRadioButton);
        groupRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(true);
            randomGroupCheckbox.setEnabled(true);
            inviteFriendButton.setEnabled(true);
            neighborhoodBox.setEnabled(true);
        });
        aloneRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(true);
            randomGroupCheckbox.setEnabled(false);
            inviteFriendButton.setEnabled(false);
            neighborhoodBox.setEnabled(false);
        });
        JPanel radioPanel = new JPanel(new GridLayout(2, 1));
        radioPanel.add(aloneRadioButton);
        radioPanel.add(groupRadioButton);
        add(radioPanel);
        
        // Create the information panel and add the components to it
        infoPanel = new JPanel(new GridLayout(5, 2));
        String[] genderBox = {"Female", "Male"};
        genderComboBox = new JComboBox<>(genderBox);
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Information"),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        Font newFont = new Font("Arial", Font.PLAIN, 12);
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(newFont);
        nameField = new JTextField();
        AgeLabel = new JLabel("Age:");
        AgeLabel.setFont(newFont);
        AgeField = new JTextField();
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(newFont);
        genderField = new JTextField();
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(newFont);
        phoneField = new JTextField(10);
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(newFont);
        EmailField = new JTextField(20);
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(AgeLabel);
        infoPanel.add(AgeField);
        infoPanel.add(genderLabel);
        infoPanel.add(genderComboBox);
        checkButton = new JButton("Check");
        //infoPanel.add(genderField);
        infoPanel.add(phoneLabel);
        infoPanel.add(phoneField);
        infoPanel.add(emailLabel);
        infoPanel.add(EmailField);
        infoPanel.setBackground(Color.WHITE); // Set background color
        
        add(infoPanel);
       
        
// Create the group panel and add the components to it
        groupPanel = new JPanel(new GridLayout(6, 2));
        groupPanel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Group Information"),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        groupSizeLabel = new JLabel("Group size:");
        groupSizeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        groupSizeField = new JTextField(4);
        groupSizeField.setEnabled(false);
        randomGroupCheckbox = new JCheckBox("Random group");
        inviteFriendButton = new JButton("Invite friend");
        inviteFriendButton.setEnabled(false);
        String[] neighborhoods = {"Al Zahra", "Al Rawabi", "Al Safa", "Al Naseem", "Al Shatiea"};
        neighborhoodBox = new JComboBox<>(neighborhoods);
        neighborhoodBox.setEnabled(false);
       
        resultLabel = new JLabel();
        JLabel linkLabel = new JLabel("link");
        
        // Add neighborhood links
        neighborhoodBox.addActionListener(e -> {
        JComboBox<String> combo = (JComboBox<String>) e.getSource();
        String selectedNeighborhood = (String) combo.getSelectedItem();
        if (selectedNeighborhood != null) {
        switch (selectedNeighborhood) {
            case "Al Zahra":
                // Add link for Al Zahra neighborhood
                linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                linkLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        try {
                            Desktop.getDesktop().browse(new URI("https://goo.gl/maps/VxXXL1KPTEFbMN9S8"));
                            JOptionPane.showMessageDialog(infoPanel, "Link opened in browser.");
                        } catch (IOException | URISyntaxException ex) {
                            // Handle the exception
                        }
                    }
                });
                break;
            case "Al Rawabi":
                // Add link for C neighborhood
                break;
            case "Al Safa":
                // Add link for D neighborhood
                break;
            case "Al Naseem":
                // Add link for R neighborhood
                break;
            case "Al Shatiea":
                // Add link for p neighborhood
                break;
            default:
                JOptionPane.showMessageDialog(groupPanel, "Unknown selection.");
                break;
        }
    }
});
        groupPanel.add(groupSizeLabel);
        groupPanel.add(groupSizeField);
        groupPanel.add(randomGroupCheckbox);
        groupPanel.add(inviteFriendButton);
        groupPanel.add(neighborhoodBox);
      
        groupPanel.add(linkLabel);
        groupPanel.add(resultLabel);
        add(groupPanel);

        // Add an action listener to the invite team button to handle inviting a team
        inviteFriendButton.addActionListener(e -> {
            // Code to invite a team
            JOptionPane.showMessageDialog(this, "Inviting friend...");
        });

        // Add an action listener to the submit button to handle the reservation submission
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            boolean goingAlone = aloneRadioButton.isSelected();
            int groupSize = 0;
            boolean randomGroup = true;
            if (!goingAlone) {
                try {
                    groupSize = Integer.parseInt(groupSizeField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a validgroup size.");
                    return;
                }
                randomGroup = randomGroupCheckbox.isSelected();
            }
            // Do something with the reservation information, such as store it in a database
            if (goingAlone) {
                System.out.println("Reservation: " + name + ", going alone.");
            } else {
                String groupType = randomGroup ? "random group" : "invited team";
                System.out.println("Reservation: " + name + ", going with a group of " + groupSize + " (type: " + groupType + ")");
            }
        });
        groupPanel.add(submitButton);

        // Set other properties of the frame
        setTitle("Reservation");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Res();
    }
}