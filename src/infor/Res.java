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
    private JLabel resultLabel, groupSizeLabel,neighborhoodlabel;
    private JRadioButton aloneRadioButton, groupRadioButton;
    private JTextField groupSizeField;
    private JCheckBox randomGroupCheckbox;
    private JComboBox<String> neighborhoodBox,genderComboBox;
    private JPanel infoPanel, jsonPanel, groupPanel,genderPanel,subPanel,
            neighborhoodsPanel,labelPanel,comboPanel,radioPanel1,radioPanel2;
    private JTextArea output_txtArea;
    String name,age,gender,phone,email;
    

    public Res() {
        // Set the layout of the frame to GridLayout
        setLayout(new GridLayout(5,1));
        setBackground(Color.WHITE);
        

        radioButton();
        add(radioPanel1);
        InfoUser();
        add(infoPanel);
        
        

        
        infoGroup();
        add(radioPanel2);
        add(groupPanel);

        CheckButton();
        add(subPanel);
        
        // Set other properties of the frame
        setTitle("Reservation");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    private void radioButton(){
        // Add the radio buttons to a button group
        ButtonGroup buttonGroup = new ButtonGroup();
        aloneRadioButton = new JRadioButton("Going alone");
        groupRadioButton = new JRadioButton("Going with a group");
        buttonGroup.add(aloneRadioButton);
        buttonGroup.add(groupRadioButton);
        aloneRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(true);
            submitButton.setEnabled(true);
            randomGroupCheckbox.setEnabled(false);
            inviteFriendButton.setEnabled(false);
            neighborhoodBox.setEnabled(false);
        });
        groupRadioButton.addActionListener(e -> {
            groupSizeField.setEnabled(true);
            submitButton.setEnabled(true);
            randomGroupCheckbox.setEnabled(true);
            inviteFriendButton.setEnabled(true);
            neighborhoodBox.setEnabled(true);
        });
        
        radioPanel1 = new JPanel(new GridLayout(1, 1));
        radioPanel2 = new JPanel(new GridLayout(1, 1));
        radioPanel1.add(aloneRadioButton);
        radioPanel2.add(groupRadioButton);
    }
    
    
        private void infoGroup(){
        // Create the group panel and add the components to it
        groupPanel = new JPanel(new GridLayout(2, 2));
        groupPanel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Group Information"),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        groupSizeLabel = new JLabel("Group size:");
        groupSizeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        groupSizeField = new JTextField(4);
        groupSizeField.setEnabled(false);
        
        neighborhoodsPanel = new JPanel(new GridLayout(1,1));
        comboPanel = new JPanel();
        randomGroupCheckbox = new JCheckBox("Random group");
        String[] neighborhoods = {"Choose an option","Al Zahra", "Al Rawabi", "Al Safa", "Al Naseem", "Al Shatiea"};
        neighborhoodBox = new JComboBox<>(neighborhoods);
        neighborhoodBox.setSelectedIndex(0);
        neighborhoodBox.setPrototypeDisplayValue("Choose an option");
        neighborhoodBox.setEnabled(false);
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        resultLabel.setForeground(Color.BLUE);
        neighborhoodlabel = new JLabel("Choose the neighborhood closest to you");

        
        // Add neighborhood links
        neighborhoodBox.addActionListener(e -> {
        JComboBox<String> combo = (JComboBox<String>) e.getSource();
        String selectedNeighborhood = (String) combo.getSelectedItem();
        if (selectedNeighborhood != null) {
        switch (selectedNeighborhood) {
            case "Al Zahra":
                // Add link for Al Zahra neighborhood
                resultLabel.setText("<html><u>ultro cafe</u></html>");
                resultLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resultLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        try {
                            //ultro cafe
                            Desktop.getDesktop().browse(new URI("https://goo.gl/maps/4Ao1uiDseWS55MCH6"));
                            //JOptionPane.showMessageDialog(infoPanel, "Link opened in browser.");
                            
                        } catch (IOException | URISyntaxException ex) {
                            // Handle the exception
                        }
                    }
                });
                break;
            case "Al Rawabi":
                // Add link for Al Rawabi neighborhood
                resultLabel.setText("<html><u>Jewaar Cafe</u></html>");
                resultLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resultLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        try {
                            //Jewaar Cafe
                            Desktop.getDesktop().browse(new URI("https://goo.gl/maps/AP7kqzrxcKrt21q38"));
                            //JOptionPane.showMessageDialog(infoPanel, "Link opened in browser.");
                        } catch (IOException | URISyntaxException ex) {
                            // Handle the exception
                        }
                    }
                });
                break;
            case "Al Safa":
                // Add link for Al Safa neighborhood
                resultLabel.setText("<html><u>Bella Rosa</u></html>");
                resultLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resultLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        try {
                            //Bella Rosa
                            Desktop.getDesktop().browse(new URI("https://goo.gl/maps/dhin2q2VbTWTYsPX9"));
                            //JOptionPane.showMessageDialog(infoPanel, "Link opened in browser.");
                        } catch (IOException | URISyntaxException ex) {
                            // Handle the exception
                        }
                    }
                });
                break;
            case "Al Naseem":
                // Add link for Al Naseem neighborhood
                resultLabel.setText("<html><u>Kawphy Cafe</u></html>");
                resultLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resultLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        try {
                            // Kawphy Cafe
                            Desktop.getDesktop().browse(new URI("https://goo.gl/maps/13dGLBrpcxN19m9F7"));
                            //JOptionPane.showMessageDialog(infoPanel, "Link opened in browser.");
                        } catch (IOException | URISyntaxException ex) {
                            // Handle the exception
                        }
                    }
                });
                break;
            case "Al Shatiea":
                // Add link for Al Shatiea neighborhood
                resultLabel.setText("<html><u>ARC Specialty Coffee</u></html>");
                resultLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                resultLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        try {
                            // ARC Specialty Coffee
                            Desktop.getDesktop().browse(new URI("https://goo.gl/maps/928HozjbsreZvqYZ9"));
                            //JOptionPane.showMessageDialog(infoPanel, "Link opened in browser.");
                        } catch (IOException | URISyntaxException ex) {
                            // Handle the exception
                        }
                    }
                });
                break;
            default:
                JOptionPane.showMessageDialog(groupPanel, "Unknown selection.");
                break;
        }
    }//
});
        //groupPanel.add(groupSizeLabel);
        //groupPanel.add(groupSizeField);
        comboPanel.add(neighborhoodBox);
        groupPanel.add(neighborhoodlabel);
        //groupPanel.add(randomGroupCheckbox);
        neighborhoodsPanel.add(comboPanel);
        neighborhoodsPanel.add(resultLabel);
        groupPanel.add(neighborhoodsPanel);
        }
    
    
    
    
    
    // Method for Information User....
    private void InfoUser(){
        // Create the information panel and add the components to it
        infoPanel = new JPanel(new GridLayout(5,2));
        String[] genderBox = {"Choose an option","Female", "Male"};
        genderComboBox = new JComboBox<>(genderBox);
        genderComboBox.setSelectedIndex(0);
        genderComboBox.setPrototypeDisplayValue("Choose an option");
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Information"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Font newFont = new Font("Arial", Font.PLAIN, 12);
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(newFont);
        nameField = new JTextField();
        AgeLabel = new JLabel("Age:");
        AgeLabel.setFont(newFont);
        AgeField = new JTextField();
        genderPanel = new JPanel(new GridLayout(1,2));
        //genderPanel.setBackground(Color.WHITE);
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(newFont);
        genderField = new JTextField();
        genderField.setEditable(false);
        // Add an item listener to the JComboBox to detect changes in its selected item
        genderComboBox.addItemListener(new ItemListener() {
             public void itemStateChanged(ItemEvent e) {
                 // Check if an item has been selected
                 if (e.getStateChange() == ItemEvent.SELECTED) {
                     // Get the index of the selected item
                     int selectedOptionIndex = genderComboBox.getSelectedIndex();
                     // If the selected item is not the first one (the title), set the text of the JTextField to the selected item
                     if (selectedOptionIndex != 0) {
                     String selectedOption = (String) genderComboBox.getSelectedItem();
                     genderField.setText(selectedOption);
                     genderField.setEnabled(false);
            }
        }
}});
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
        genderPanel.add(genderLabel);
        genderPanel.add(genderComboBox);
        infoPanel.add(genderPanel);
        infoPanel.add(genderField);
        infoPanel.add(phoneLabel);
        infoPanel.add(phoneField);
        infoPanel.add(emailLabel);
        infoPanel.add(EmailField);
        //infoPanel.setBackground(Color.WHITE); // Set background color 
        

  }
    
    
public void saveUserInfo(String name, String age, String gender, String phone, String email) {
    // Create a JSON object
    JSONObject user = new JSONObject();
    user.put("name", name);
    user.put("age", age);
    user.put("gender", gender);
    user.put("phone", phone);
    user.put("email", email);

    // Convert the JSON object to a JSON string
    String jsonString = user.toJSONString();

    // Write the JSON string to a file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.json", true))) {
        writer.write(jsonString);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    
    // Method for submit Button and Invite Friend Button....
    private void CheckButton(){
    subPanel = new JPanel();
    inviteFriendButton = new JButton("Invite a Friend");
    inviteFriendButton.setEnabled(false);
    inviteFriendButton.addActionListener(e -> {
    JTextField emailField = new JTextField();
    JOptionPane pane = new JOptionPane(emailField, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    JDialog dialog = pane.createDialog("Enter your friend's email");
    dialog.setVisible(true);

    if (pane.getValue() != null && pane.getValue().equals(JOptionPane.OK_OPTION)) {
        String email = emailField.getText();
        if (!email.isEmpty()) {
            // Code to invite a team with the email entered
            JOptionPane.showMessageDialog(this, "Inviting friend " + email + "...");
        }
    }
    });
    
        submitButton = new JButton("Submit");
        submitButton.setEnabled(false);
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
            // Get the phone number from the JTextField
            String phoneNumber = phoneField.getText();

            // Create a regular expression pattern for a phone number starting with "05" and containing only digits
            String phoneRegex = "^05\\d{8}$";

            // Check if the phone number matches the regular expression pattern
            if (!phoneNumber.matches(phoneRegex)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number starting with '05' and containing only digits.");
            return;
}
            // Get the email address from the JTextField
            String email = EmailField.getText();

            // Create a regular expression pattern for a valid email address
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            // Check if the email address matches the regular expression pattern
            if (!email.matches(emailRegex)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
            return;
            }if (e.getSource() == submitButton) {
                 name = nameField.getText();
                 age = AgeField.getText();
                 gender = genderField.getText();
                 phone = phoneField.getText();
                 email = EmailField.getText();
                 saveUserInfo(name,age,gender,phone, email); // Call the function to save data
            }
            
        });
        subPanel.add(submitButton);
        subPanel.add(inviteFriendButton);    
    }
    
    public static void main(String[] args) {
        new Res();
    }
}
