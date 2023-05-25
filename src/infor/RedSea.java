package infor;
import test.Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RedSea extends JFrame {
     private JFrame frame = new JFrame();
     private JPanel panel = new JPanel(new GridLayout(1, 6));
     private JPanel panel2 = new JPanel(new GridLayout(6, 1));
      private JPanel panel3= new JPanel(new GridLayout(1, 6));
    public RedSea(){

     frame.setSize(800, 800);
     frame.setTitle("Red Sea");
     frame.setLocationRelativeTo(null);
    
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     panel2.setBackground(Color.WHITE);
      JButton button = new JButton("Reservation");
        panel3.add(button);
        add(panel3);
         button.addActionListener(new ActionListener() {
              
         public void actionPerformed(ActionEvent e) {
            // create an instance of the Res class
            Res res = new Res();
            res.setVisible(true);
         }
      });
     images();
     JsonFile();
     frame.add(panel3, BorderLayout.SOUTH); 
     frame.add(panel, BorderLayout.NORTH);
     frame.add(panel2, BorderLayout.CENTER);
     frame.getContentPane().add(panel2);
     frame.setResizable(false);
     frame.setVisible(true);

}
    private void images(){
        
        
                    ImageIcon image1 = new ImageIcon(getClass().getResource("/icon/REDSEA1.jpg"));
                                  Image image = image1.getImage();
                    Image newImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon newImageIcon = new ImageIcon(newImage);
                    JLabel label1 = new JLabel(newImageIcon);
                    panel.add(label1);
                   
                    label1.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         
                         JFrame frame = new JFrame("Red Sea");
                         frame.setSize(500, 500);

                 
                         JLabel fullImage = new JLabel(image1);
                         frame.add(fullImage);

                        
                         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        
                         frame.setLocationRelativeTo(null);
                    
                      
                         frame.setVisible(true);

                    }
                      });
                   ImageIcon image22 = new ImageIcon(getClass().getResource("/icon/redsea2.jpg"));
                                  Image image2 = image22.getImage();
                    Image newImage2 = image2.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// طھط¹ظٹظٹظ† ط­ط¬ظ… ط§ظ„طµظˆط±ط©
                    ImageIcon newImageIcon2 = new ImageIcon(newImage2);
                    JLabel label2 = new JLabel(newImageIcon2);
                    panel.add(label2);
                    // ط¥ط¶ط§ظپط© ط­ط¯ط« ط§ظ„ظ†ظ‚ط± ط¹ظ„ظ‰ ط§ظ„ظپط£ط±ط© ظ„ظ„طµظˆط±ط© ط§ظ„ط£ظˆظ„ظ‰
                    label2.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // ط¥ظ†ط´ط§ط، JFrame ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JFrame frame = new JFrame("Red Sea");
                    frame.setSize(500, 500);

                    // ط¥ظ†ط´ط§ط، JLabel ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JLabel fullImage = new JLabel(image22);
                    frame.add(fullImage);

                    // طھط­ط¯ظٹط¯ ط¥ط¬ط±ط§ط، ط§ظ„ظ†ط§ظپط°ط© ط¹ظ†ط¯ ط§ظ„ط¶ط؛ط· ط¹ظ„ظ‰ ط²ط± ط§ظ„ط¥ط؛ظ„ط§ظ‚
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    
                    frame.setLocationRelativeTo(null);
                    
                
                    frame.setVisible(true);
                    }
                      });
                     ImageIcon image3= new ImageIcon(getClass().getResource("/icon/redsea3.jpg"));
                                  Image image33 = image3.getImage();
                    Image newImage3 = image33.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// طھط¹ظٹظٹظ† ط­ط¬ظ… ط§ظ„طµظˆط±ط©
                    ImageIcon newImageIcon3 = new ImageIcon(newImage3);
                    JLabel label3 = new JLabel(newImageIcon3);
                    panel.add(label3);
                   
                    label3.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // ط¥ظ†ط´ط§ط، JFrame ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JFrame frame = new JFrame("Red Sea");
                    frame.setSize(500, 500);

                    // ط¥ظ†ط´ط§ط، JLabel ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JLabel fullImage = new JLabel(image3);
                    frame.add(fullImage);

                    // طھط­ط¯ظٹط¯ ط¥ط¬ط±ط§ط، ط§ظ„ظ†ط§ظپط°ط© ط¹ظ†ط¯ ط§ظ„ط¶ط؛ط· ط¹ظ„ظ‰ ط²ط± ط§ظ„ط¥ط؛ظ„ط§ظ‚
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // ظٹط¹ط±ط¶ ظپظٹ ط§ظ„ظ…ظ†طھطµظپ
                    frame.setLocationRelativeTo(null);
                    
                    // ط¹ط±ط¶ ط§ظ„ظ†ط§ظپط°ط©
                    frame.setVisible(true);
                    }
                      });
                    ImageIcon image5 = new ImageIcon(getClass().getResource("/icon/redsea4.jpg"));
                                  Image image55 = image5.getImage();
                    Image newImage4 = image55.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// طھط¹ظٹظٹظ† ط­ط¬ظ… ط§ظ„طµظˆط±ط©
                    ImageIcon newImageIcon4 = new ImageIcon(newImage4);
                    JLabel label4 = new JLabel(newImageIcon4);
                    panel.add(label4);
                    // ط¥ط¶ط§ظپط© ط­ط¯ط« ط§ظ„ظ†ظ‚ط± ط¹ظ„ظ‰ ط§ظ„ظپط£ط±ط© ظ„ظ„طµظˆط±ط© ط§ظ„ط£ظˆظ„ظ‰
                    label4.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // ط¥ظ†ط´ط§ط، JFrame ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JFrame frame = new JFrame("Red Sea");
                    frame.setSize(500, 500);

                    // ط¥ظ†ط´ط§ط، JLabel ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JLabel fullImage = new JLabel(image5);
                    frame.add(fullImage);

                    // طھط­ط¯ظٹط¯ ط¥ط¬ط±ط§ط، ط§ظ„ظ†ط§ظپط°ط© ط¹ظ†ط¯ ط§ظ„ط¶ط؛ط· ط¹ظ„ظ‰ ط²ط± ط§ظ„ط¥ط؛ظ„ط§ظ‚
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // ظٹط¹ط±ط¶ ظپظٹ ط§ظ„ظ…ظ†طھطµظپ
                    frame.setLocationRelativeTo(null);
                    
                    // ط¹ط±ط¶ ط§ظ„ظ†ط§ظپط°ط©
                    frame.setVisible(true);
                    }
                      });
                    ImageIcon image4 = new ImageIcon(getClass().getResource("/icon/redsea5.jpg"));
                                  Image image44 = image4.getImage();
                    Image newImage5 = image44.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon newImageIcon5 = new ImageIcon(newImage5);
                    JLabel label5 = new JLabel(newImageIcon5);
                    panel.add(label5);
               
                    label5.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                
                    JFrame frame = new JFrame("Red Sea");
                    frame.setSize(500, 500);

                   
                    JLabel fullImage = new JLabel(image4);
                    frame.add(fullImage);

                    // طھط­ط¯ظٹط¯ ط¥ط¬ط±ط§ط، ط§ظ„ظ†ط§ظپط°ط© ط¹ظ†ط¯ ط§ظ„ط¶ط؛ط· ط¹ظ„ظ‰ ط²ط± ط§ظ„ط¥ط؛ظ„ط§ظ‚
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    
                    // ظٹط¹ط±ط¶ ظپظٹ ط§ظ„ظ…ظ†طھطµظپ
                    frame.setLocationRelativeTo(null);
                 
                    frame.setVisible(true);
                    }
                      });
                     ImageIcon image6 = new ImageIcon(getClass().getResource("/icon/redsea6.jpg"));
                                  Image image66 = image6.getImage();
                    Image newImage6 = image66.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// طھط¹ظٹظٹظ† ط­ط¬ظ… ط§ظ„طµظˆط±ط©
                    ImageIcon newImageIcon6 = new ImageIcon(newImage6);
                    JLabel label6 = new JLabel(newImageIcon6);
                    panel.add(label6);
                    // ط¥ط¶ط§ظپط© ط­ط¯ط« ط§ظ„ظ†ظ‚ط± ط¹ظ„ظ‰ ط§ظ„ظپط£ط±ط© ظ„ظ„طµظˆط±ط© ط§ظ„ط£ظˆظ„ظ‰
                    label6.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // ط¥ظ†ط´ط§ط، JFrame ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JFrame frame = new JFrame("Red Sea");
                    frame.setSize(500, 500);

                    // ط¥ظ†ط´ط§ط، JLabel ط¬ط¯ظٹط¯ط© ظ„ط¹ط±ط¶ ط§ظ„طµظˆط±ط© ط¨ط­ط¬ظ… ظƒط§ظ…ظ„
                    JLabel fullImage = new JLabel(image6);
                    frame.add(fullImage);

                    // طھط­ط¯ظٹط¯ ط¥ط¬ط±ط§ط، ط§ظ„ظ†ط§ظپط°ط© ط¹ظ†ط¯ ط§ظ„ط¶ط؛ط· ط¹ظ„ظ‰ ط²ط± ط§ظ„ط¥ط؛ظ„ط§ظ‚
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // ظٹط¹ط±ط¶ ظپظٹ ط§ظ„ظ…ظ†طھطµظپ
                    frame.setLocationRelativeTo(null);
                    // ط¹ط±ط¶ ط§ظ„ظ†ط§ظپط°ط©
                    frame.setVisible(true);
                    }
                      });
    }
    private void JsonFile(){
        JSONArray data = null;
                    try {
                    FileReader reader = new FileReader("Data5.json");
                    JSONParser parser = new JSONParser();
                    data = (JSONArray) parser.parse(reader);
                    reader.close();
                    } catch (Exception e) {
                     e.printStackTrace();
                    }
                    JSONObject employeeObject = (JSONObject) data.get(1);
                    JSONObject employeeDetails = (JSONObject) employeeObject.get("place");
                    String name = (String) employeeDetails.get("name");
                    String description = (String) employeeDetails.get("description");
                    String date = (String) employeeDetails.get("date");
                    String location = (String) employeeDetails.get("location");

                    // Create and display GUI
                    // الخط
                    Font newFont = new Font("Arial", Font.BOLD, 16);
                    // ياخذ من الفايل الاسم
                    JLabel labelname = new JLabel("name: " + name);
                    // الخط
                    labelname.setFont(newFont);
                    // ياخذ من الفايل 
                    JLabel labellocation = new JLabel("location: " + location);
                    labellocation.setFont(newFont);
                    JTextArea textArea = new JTextArea("description: " + description);
                    textArea.setLineWrap(true);
                    textArea.setBorder(null);
                    textArea.setEditable(false);
                    textArea.setFont(newFont);
                    JLabel labelwebsite = new JLabel("date: " + date);
                    labelwebsite.setFont(newFont);
                    panel2.add(labelname);
                    panel2.add(labellocation);
                    panel2.add(textArea);
                    panel2.add(labelwebsite);
                    

                      JButton res = new JButton("Reservation");
                        panel2.add(res);
                        res.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                           // create an instance of the Res class
                           Res res = new Res();
                           res.setVisible(true);
                        }
                     });

    
    
    }
    public static void main(String[] agrs){
        new RedSea();
    }

    
}
