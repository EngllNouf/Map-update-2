/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author alhar
 */

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

public class Res extends JFrame {
    private JLabel nameLabel,AgeLabel,emailLabel;
    private JTextField nameField,AgeField,EmailField;
    private JButton checkButton;
    private JLabel resultLabel;
    private JRadioButton aloneRadioButton;
    private JRadioButton groupRadioButton;
    private JLabel groupSizeLabel;
    private JTextField groupSizeField;
    private JCheckBox randomGroupCheckbox;
    private JComboBox neighborhood;
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
        EmailField = new JTextField(20);
        
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
        // ذا حق المناطق انا خليت المناطق في كومبو بوكس في حال اختار اليوزر 
        // Create the random group checkbox and invite team button components
        randomGroupCheckbox = new JCheckBox("Random group");
        inviteTeamButton = new JButton("Invite team");
        inviteTeamButton.setEnabled(false);
        // ذا حق المناطق انا خليت المناطق في كومبو بوكس في حال اختار اليوزر الحي حقه يطلع له لنك باقرب منطقة 
             JLabel neighborhoodLabel = new JLabel("Neighborhood:");
            String[] neighborhoods = {"Al Zahra", "C", "D", "R", "p"};
            JComboBox<String> neighborhood = new JComboBox<>(neighborhoods);
            neighborhood.setEnabled(false);

   // هنا قلنا انه اذا اختارخلاص سويتش لكل منطقة عشان يطلع له الرابط يمكن نقدر نسويها بفايل االله واعلم
   neighborhood.addActionListener(e -> {
    JComboBox<String> combo = (JComboBox<String>) e.getSource();
    String selectedNeighborhood = (String) combo.getSelectedItem();
    if (selectedNeighborhood != null) {
        switch (selectedNeighborhood) {
            case "Al Zahra":
                // الكود ذا حق االلنك عشان يشغله 
  
            JLabel linkLabel = new JLabel("link");
            linkLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            linkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://goo.gl/maps/VxXXL1KPTEFbMN9S8"));
                        JOptionPane.showMessageDialog(panel, "Link opened in browser.");
                    } catch (IOException | URISyntaxException ex) {
                        // handle exception
                    }
                }
            });

panel.add(linkLabel);

      
            // باقي الاحياء هنا
                break;
            case "C":
                JOptionPane.showMessageDialog(this, "You selected C.");
                break;
            case "D":
                JOptionPane.showMessageDialog(this, "You selected D.");
                break;
            case "R":
                JOptionPane.showMessageDialog(this, "You selected R.");
                break;
            case "p":
                JOptionPane.showMessageDialog(this, "You selected p.");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown selection.");
                break;
        }
    }
});


        // Create the submit button component
        submitButton = new JButton("Submit");

        // Create the group panel and add the components to it
           panel2 = new JPanel();
           panel2.add(groupSizeLabel);
           panel2.add(groupSizeField);
           panel2.add(randomGroupCheckbox);
           panel2.add(inviteTeamButton);

        checkButton = new JButton("Check");
        resultLabel = new JLabel();
        
        // هذا عشان يتاكد من صيغة الايميل الميثود حقته تحت 
        checkButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String email = EmailField.getText();
                if (isValidEmail(email)) {
                    resultLabel.setText("Valid email syntax.");
                    resultLabel.setForeground(Color.GREEN);
                } else {
                    resultLabel.setText("Invalid email syntax.");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });
     

        panel.add(neighborhoodLabel);
        panel.add(neighborhood);
        panel.add(checkButton);
        panel.add(resultLabel);
        add(aloneRadioButton);
        add(groupRadioButton);
        add(panel);
        add(panel2);
         
        
        // هنا عشان اذا اليوزر اختار يبغى يروح لوحده او مع قروب في خيارات ما تطلع اذا راح لوحده هنا نخفي الي ما نبغاها يختارو
        // Add an action listener to the group radio button to enable/disable the group size field and other components
        groupRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(true);
            randomGroupCheckbox.setEnabled(true);
            inviteTeamButton.setEnabled(true);
            neighborhood.setEnabled(true);
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
            boolean randomGroup = true;
            if (!goingAlone) {
                try {
                    groupSize = Integer.parseInt(groupSizeField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid group size.");
                    return;
                }
            if(randomGroup)   
                randomGroup = randomGroupCheckbox.isSelected();
                
            }
            // Do something with the reservation information, such as store it in a database
            if (goingAlone) {
                System.out.println("Reservation: " + name + ", going alone.");
            } else {
                String groupType = randomGroup ? "random group" : "invited team";
                System.out.println("Reservation: " + name + ", going with a group of " + groupSize + " (type: " + groupType + ")");
                 
            }
            ;
        });

        // Set other properties of the frame
        setTitle("Reservation");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

// حق الايميل 
     public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
       return email.matches(regex);
    }
    public static void main(String[] args) {
        new Res();
    }
}