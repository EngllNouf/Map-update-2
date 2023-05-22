package test;

import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint.EventWaypoint;
import waypoint.MyWaypoint;
import waypoint.WaypointRender;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main extends javax.swing.JFrame {

    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(21.4488312,39.8706231);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(12);

        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
        event = getEvent();
    }

    private void addWaypoint(MyWaypoint waypoint) {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.add(waypoint);
        initWaypoint();
        
        
        
        
        
        
        
        
    }

    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(wp);
        for (MyWaypoint d : waypoints) {
            jXMapViewer.add(d.getButton());
        }
    }

    private void clearWaypoint() {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }

    
    private EventWaypoint getEvent() {
    return new EventWaypoint() {
        public void selected(MyWaypoint waypoint) {
            
            

                        JSONArray data = null;
                   try {
                       FileReader reader = new FileReader("Data5.json");
                       JSONParser parser = new JSONParser();
                       data = (JSONArray) parser.parse(reader);
                       reader.close();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
            switch(waypoint.getName()) {
                
                case "City Walk":
                    
                     // Access specific values
        JSONObject employeeObject = (JSONObject) data.get(0);
        JSONObject employeeDetails = (JSONObject) employeeObject.get("City walk ");
        String name = (String) employeeDetails.get("name ");
        String description = (String) employeeDetails.get("description");

        // Create and display GUI
        JLabel nameLabel = new JLabel("name: " +name);
        JLabel desLabel = new JLabel("description: " + description);
        JFrame frame1 = new JFrame();
        frame1.add(nameLabel);
        frame1.add(desLabel);
        
                   
                    frame1.setSize(420,420);
                    frame1.setVisible(true);
                    break;
                case "Red sea":
                    String message2 = "The Red Sea is a seawater inlet of the Indian Ocean, lying between Africa and Asia.";
                    JOptionPane.showMessageDialog(null, message2, "Red Sea Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Boulevard":
                    String message3 = "The Boulevard is a popular leisure destination in Jeddah, with many restaurants and cafes.";
                    JFrame frame = new JFrame();
                    frame.setSize(420,420);
                    frame.setVisible(true);
                    //JOptionPane.showMessageDialog(null, message3, "Boulevard Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Roshn Waterfront":
                    String message4 = "Roshn Waterfront is a mixed-use development project in Jeddah, featuring residential, commercial, and recreational facilities.";
                    JOptionPane.showMessageDialog(null, message4, "Roshn Waterfront Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Historical JeddahAl-Balad":
                    String message5 = "Historical Jeddah Al-Balad is a UNESCO World Heritage Site, known for its traditional architecture and historical significance.";
                    JOptionPane.showMessageDialog(null, message5, "Historical Jeddah Al-Balad Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
              case "Alhodaif Museum":
                    String message6 = "Alhodaif Museum is a private museum in Jeddah, showcasing the history and culture of Saudi Arabia.";
                    JOptionPane.showMessageDialog(null, message6, "Alhodaif Museum Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Islamic Arts Biennale":
                    String message7 = "Islamic Arts Biennale is an international art exhibition held in Jeddah, featuring contemporary Islamic art from around the world.";
                    JOptionPane.showMessageDialog(null, message7, "Islamic Arts Biennale Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    String messageDefault = "No information available for this point";
                    JOptionPane.showMessageDialog(null, messageDefault, "Point Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    };
}
         
        

        
  
             
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        comboMapType = new javax.swing.JComboBox<>();
        cmdAdd = new javax.swing.JButton();
        cmdClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboMapType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open Stree", "Virtual Earth", "Hybrid", "Satellite" }));
        comboMapType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapTypeActionPerformed(evt);
            }
        });

        cmdAdd.setText("Show places");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdClear.setText("Clear Waypoint");
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cmdAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 761, Short.MAX_VALUE)
                .addComponent(comboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAdd)
                    .addComponent(cmdClear))
                .addContainerGap(610, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboMapTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapTypeActionPerformed
        TileFactoryInfo info;
        int index = comboMapType.getSelectedIndex();
        if (index == 0) {
            info = new OSMTileFactoryInfo();
        } else if (index == 1) {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        } else if (index == 2) {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
        } else {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
        }
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
    }//GEN-LAST:event_comboMapTypeActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
          //بنات هنا نحدد الاماكن من الاحداثيات الي عندها اماكن تضيف في تست 5 و6 و7و 8
                     
         addWaypoint(new MyWaypoint("City Walk", event, new GeoPosition(21.6350249753013, 39.10690119614673)));//City Walk
          addWaypoint(new MyWaypoint("Red sea", event, new GeoPosition(21.627675282916634, 39.111098696146655)));
          addWaypoint(new MyWaypoint("Boulevard", event, new GeoPosition(21.569792875340134, 39.1252796384737)));
          addWaypoint(new MyWaypoint("Roshn Waterfront", event, new GeoPosition(21.603081811036954, 39.107458953817606)));
           addWaypoint(new MyWaypoint("Historical Jeddah Al-Balad", event, new GeoPosition(21.4887593,39.185687)));
          addWaypoint(new MyWaypoint("Alhodaif Museum", event, new GeoPosition(21.4881056,39.1870934)));
          addWaypoint(new MyWaypoint("Islamic Arts Biennale", event, new GeoPosition(21.7014627, 39.1365453)));
         
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        clearWaypoint();
    }//GEN-LAST:event_cmdClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
         //JSON parser object to parse read file
      JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Data5.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
         
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClear;
    private javax.swing.JComboBox<String> comboMapType;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    // End of variables declaration//GEN-END:variables
}
