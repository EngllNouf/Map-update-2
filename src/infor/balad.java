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

public class balad extends JFrame {
     private JFrame frame = new JFrame();
     private JPanel panel = new JPanel(new GridLayout(1, 6));
     private JPanel panel2 = new JPanel(new GridLayout(6, 1));
      
     public balad(){
  
     frame.setSize(800, 800);
     frame.setTitle("Al-Balad");
     frame.setLocationRelativeTo(null);
     
     images();
     JsonFile();
  
     frame.add(panel, BorderLayout.NORTH);
     frame.add(panel2, BorderLayout.CENTER);
     frame.getContentPane().add(panel2);
     frame.setResizable(false);
     frame.setVisible(true);

}
    private void images(){
                 
                    ImageIcon image1 = new ImageIcon(getClass().getResource("/icon/Al-BaladPic2.jpg"));
                    Image image = image1.getImage();
                    Image newImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon newImageIcon = new ImageIcon(newImage);
                    JLabel label1 = new JLabel(newImageIcon);
                    panel.add(label1);
                    // إضافة حدث النقر على الفأرة للصورة الأولى
                    label1.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                         // إنشاء JFrame جديدة لعرض الصورة بحجم كامل
                         JFrame frame = new JFrame("Balad");
                         frame.setSize(200, 200);

                         // إنشاء JLabel جديدة لعرض الصورة بحجم كامل
                         JLabel fullImage = new JLabel(image1);
                         frame.add(fullImage);

                         // تحديد إجراء النافذة عند الضغط على زر الإغلاق
                         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                         // يعرض في المنتصف
                         frame.setLocationRelativeTo(null);
                    
                         // عرض النافذة
                         frame.setVisible(true);

                    }
                      });
                 
                    ImageIcon image22 = new ImageIcon(getClass().getResource("/icon/Al-BaladPic4.jpg"));
                    Image image11= image22.getImage();
                    Image newImage2 = image11.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// تعيين حجم الصورة
                    ImageIcon newImageIcon2 = new ImageIcon(newImage2);
                    JLabel label2 = new JLabel(newImageIcon2);
                    panel.add(label2);
                    // إضافة حدث النقر على الفأرة للصورة الأولى
                    label2.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // إنشاء JFrame جديدة لعرض الصورة بحجم كامل
                    JFrame frame = new JFrame("Balad");
                    frame.setSize(200, 200);

                    // إنشاء JLabel جديدة لعرض الصورة بحجم كامل
                    JLabel fullImage = new JLabel(image22);
                    frame.add(fullImage);

                    // تحديد إجراء النافذة عند الضغط على زر الإغلاق
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // يعرض في المنتصف
                    frame.setLocationRelativeTo(null);
                    
                    // عرض النافذة
                    frame.setVisible(true);
                    }
                      });
                  
                    ImageIcon image3 = new ImageIcon(getClass().getResource("/icon/Al-BaladPic5.jpg"));
                                  Image image33 = image3.getImage();
                    Image newImage3 = image33.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// تعيين حجم الصورة
                    ImageIcon newImageIcon3 = new ImageIcon(newImage3);
                    JLabel label3 = new JLabel(newImageIcon3);
                    panel.add(label3);
                    // إضافة حدث النقر على الفأرة للصورة الأولى
                    label3.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // إنشاء JFrame جديدة لعرض الصورة بحجم كامل
                    JFrame frame = new JFrame("Balad");
                    frame.setSize(200, 200);

                    // إنشاء JLabel جديدة لعرض الصورة بحجم كامل
                    JLabel fullImage = new JLabel(image3);
                    frame.add(fullImage);

                    // تحديد إجراء النافذة عند الضغط على زر الإغلاق
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // يعرض في المنتصف
                    frame.setLocationRelativeTo(null);
                    
                    // عرض النافذة
                    frame.setVisible(true);
                    }
                      });
                      ImageIcon image4 = new ImageIcon(getClass().getResource("/icon/Al_Balad6.jpg"));
                                  Image image44 = image4.getImage();
                    Image newImage4 = image44.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// تعيين حجم الصورة
                    ImageIcon newImageIcon4 = new ImageIcon(newImage4);
                    JLabel label4 = new JLabel(newImageIcon4);
                    panel.add(label4);
                    // إضافة حدث النقر على الفأرة للصورة الأولى
                    label4.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // إنشاء JFrame جديدة لعرض الصورة بحجم كامل
                    JFrame frame = new JFrame("Balad");
                    frame.setSize(200, 200);

                    // إنشاء JLabel جديدة لعرض الصورة بحجم كامل
                    JLabel fullImage = new JLabel(image4);
                    frame.add(fullImage);

                    // تحديد إجراء النافذة عند الضغط على زر الإغلاق
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // يعرض في المنتصف
                    frame.setLocationRelativeTo(null);
                    
                    // عرض النافذة
                    frame.setVisible(true);
                    }
                      });
                       ImageIcon image5 = new ImageIcon(getClass().getResource("/icon/BaladPic.png"));
                                  Image image55 = image5.getImage();
                    Image newImage5 = image55.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// تعيين حجم الصورة
                    ImageIcon newImageIcon5 = new ImageIcon(newImage5);
                    JLabel label5 = new JLabel(newImageIcon5);
                    panel.add(label5);
                    // إضافة حدث النقر على الفأرة للصورة الأولى
                    label5.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // إنشاء JFrame جديدة لعرض الصورة بحجم كامل
                    JFrame frame = new JFrame("Balad");
                    frame.setSize(500, 500);

                    // إنشاء JLabel جديدة لعرض الصورة بحجم كامل
                    JLabel fullImage = new JLabel(image5);
                    frame.add(fullImage);

                    // تحديد إجراء النافذة عند الضغط على زر الإغلاق
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    
                    // يعرض في المنتصف
                    frame.setLocationRelativeTo(null);
                    // عرض النافذة
                    frame.setVisible(true);
                    }
                      });
                      ImageIcon image6 = new ImageIcon(getClass().getResource("/icon/b1.jpg"));
                                  Image image66 = image6.getImage();
                    Image newImage6 = image66.getScaledInstance(300, 300, Image.SCALE_SMOOTH);// تعيين حجم الصورة
                    ImageIcon newImageIcon6 = new ImageIcon(newImage6);
                    JLabel label6 = new JLabel(newImageIcon6);
                    panel.add(label6);
                    // إضافة حدث النقر على الفأرة للصورة الأولى
                    label6.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                    // إنشاء JFrame جديدة لعرض الصورة بحجم كامل
                    JFrame frame = new JFrame("Balad");
                    frame.setSize(500, 500);

                    // إنشاء JLabel جديدة لعرض الصورة بحجم كامل
                    JLabel fullImage = new JLabel(image6);
                    frame.add(fullImage);

                    // تحديد إجراء النافذة عند الضغط على زر الإغلاق
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // يعرض في المنتصف
                    frame.setLocationRelativeTo(null);
                    // عرض النافذة
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
                    // Access specific values
                    JSONObject employeeObject = (JSONObject) data.get(4);
                    JSONObject employeeDetails = (JSONObject) employeeObject.get("place");
                    String name = (String) employeeDetails.get("name");
                    String description = (String) employeeDetails.get("description");
                    String website = (String) employeeDetails.get("website");
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
                    JLabel labelwebsite = new JLabel("website: " + website);
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
        new balad();
    }
}