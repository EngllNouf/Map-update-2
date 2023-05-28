package LoadingScreen;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class YourLoadingScreenPanel extends JPanel {
    
    public YourLoadingScreenPanel() {
        setPreferredSize(new Dimension(400, 300));
        setLayout(new BorderLayout());
        
        JLabel loadingLabel = new JLabel("Loading...");
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);
        add(loadingLabel, BorderLayout.CENTER);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        add(progressBar, BorderLayout.SOUTH);
    }

    

public class Main {
    
    public static void main(String[] args) {
        LoadingScreen.showLoadingScreen();
        
       
        
        LoadingScreen.dispose();
    }
}
}