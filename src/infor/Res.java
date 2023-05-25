/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infor;

/**
 *
 * @author alhar
 */

import java.awt.GridLayout;
import javax.swing.*;

public class Res extends JFrame {
    private JLabel nameLabel,AgeLabel,emailLabel;
    private JTextField nameField,AgeField,EmailField;
    private JRadioButton aloneRadioButton;
    private JRadioButton groupRadioButton;
    private JLabel groupSizeLabel;
    private JTextField groupSizeField;
    private JCheckBox randomGroupCheckbox;
    
    private JButton inviteTeamButton;
    private JButton submitButton;
 
    private JPanel panel = new JPanel(new GridLayout(1, 6));
    private JPanel panel2 = new JPanel(new GridLayout(6, 1));
    private JPanel panel3 = new JPanel(new GridLayout(1, 6));
    
    public Res() {
        
        // Set the layout of the frame to GridLayout
        setLayout(new GridLayout(5, 1));
        
        // Create the name label and text field components
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        AgeLabel = new JLabel("Age:");
        AgeField = new JTextField();
        emailLabel = new JLabel("Email:");
        EmailField = new JTextField();
        
        panel.add(nameLabel);
        panel.add( nameField);
        panel.add(AgeLabel);
        panel.add(AgeField);
        panel.add(emailLabel);
        panel.add(EmailField);
        // Create the radio button components
        aloneRadioButton = new JRadioButton("Going alone");
        groupRadioButton = new JRadioButton("Going with a group");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(aloneRadioButton);
        buttonGroup.add(groupRadioButton);

        // Create the group size label and text field components
        groupSizeLabel = new JLabel("Group size:");
        groupSizeField = new JTextField(4);
        groupSizeField.setEnabled(false);

        // Create the random group checkbox and invite team button components
        randomGroupCheckbox = new JCheckBox("Random group");
        inviteTeamButton = new JButton("Invite team");
        inviteTeamButton.setEnabled(false);
       
        // Create the submit button component
        submitButton = new JButton("Submit");

        // Create the group panel and add the components to it
            panel2 = new JPanel();
             panel2.add(groupSizeLabel);
          panel2.add(groupSizeField);
             panel2.add(randomGroupCheckbox);
            panel2.add(inviteTeamButton);

        // Add the components to the frame
        
        add(aloneRadioButton);
        add(groupRadioButton);
        add(panel);
        add(panel2);
       
        // Add an action listener to the group radio button to enable/disable the group size field and other components
        groupRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(true);
            randomGroupCheckbox.setEnabled(true);
            inviteTeamButton.setEnabled(true);
        });
        aloneRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(false);
            randomGroupCheckbox.setEnabled(false);
            inviteTeamButton.setEnabled(false);
        });

        // Add an action listener to the invite team button to handle inviting a team
        inviteTeamButton.addActionListener(e -> {
            // Code to invite a team
            JOptionPane.showMessageDialog(this, "Inviting team...");
        });

        // Add an action listener to the submit button to handle the reservation submission
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            boolean goingAlone = aloneRadioButton.isSelected();
            int groupSize = 0;
            boolean randomGroup = false;
            if (!goingAlone) {
                try {
                    groupSize = Integer.parseInt(groupSizeField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid group size.");
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
            JOptionPane.showMessageDialog(this, "Reservation submitted successfully.");
        });

        // Set other properties of the frame
        setTitle("Reservation");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Res();
    }
}