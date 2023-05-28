package LoadingScreen;


import LoadingScreen.YourLoadingScreenPanel;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
public class LoadingScreen extends JFrame {
    
    public static void showLoadingScreen() {
        JFrame loadingFrame = new JFrame();
        loadingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        loadingFrame.setUndecorated(true);
        loadingFrame.getContentPane().add(new YourLoadingScreenPanel());
        loadingFrame.pack();
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setVisible(true);
    }
    

}

