/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import las.views.user_account_guis.LoginForm;

/**
 *
 * @author Gimhani
 */
public class StartSplash extends javax.swing.JFrame {

    /**
     * Creates new form StartSplash
     */
    public StartSplash() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(400, 300);
        setResizable(false);
        setTitle("Welcome to LandBranch Management System");
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/las/icons/logo-LAS.jpg"));
        setIconImage(icon1.getImage());
        
         progressbar.setForeground(Color.DARK_GRAY);

        Timer timer = new Timer(200, new ActionListener() {

            int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                value +=2;
                progressbar.setValue(value);

                if (value < 10) {
                    textLabel.setText("Connecting to database....");
                } else if (value < 30) {
                    textLabel.setText("Verifying DataBase...");
                } else if (value < 40) {
                    textLabel.setText("Loading ...");
                } else if (value < 60) {
                    textLabel.setText("Loading Modules...");
                } else if (value < 70) {
                    textLabel.setText("Intializing ..");
                } else if (value < 85) {
                    textLabel.setText("Starting ..");
                } else if (value ==100) {
                    dispose();
                    new LoginForm().setVisible(true);

                }
            }
        });
        timer.start();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        progressbar = new javax.swing.JProgressBar();
        textLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        jPanel1.add(progressbar);
        progressbar.setBounds(20, 50, 350, 30);

        textLabel.setBackground(new java.awt.Color(102, 0, 0));
        textLabel.setFont(new java.awt.Font("SansSerif", 3, 36)); // NOI18N
        textLabel.setForeground(new java.awt.Color(255, 255, 255));
        textLabel.setOpaque(true);
        jPanel1.add(textLabel);
        textLabel.setBounds(20, 120, 350, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/las/icons/logback.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(4, 4, 390, 290);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
}
