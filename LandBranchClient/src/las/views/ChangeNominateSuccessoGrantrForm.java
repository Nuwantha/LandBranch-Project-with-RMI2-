/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.views;

import SeverConnector.Connector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import las.common_classes.GUIitemsValidator;
import las.common_classes.PatternChecker;
import las.controller.GrantController;
import las.controller.NominatedSuccessorController;
import las.models.Grant;
import las.models.NominatedSuccessor;
import las.models.Permit;

/**
 *
 * @author Gimhani
 */
public class ChangeNominateSuccessoGrantrForm extends javax.swing.JDialog {

    Grant grant;
    Permit permit;
    PermitForm parent_permit;
    GrantForm parent_grant;
    int type;
    GrantController GrantController;
    NominatedSuccessorController  NominatedSuccessorController;

    /**
     * Creates new form NominateSuccessorForm
     *
     * @param modal
     */
    public ChangeNominateSuccessoGrantrForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
          try {
            Connector sConnector = Connector.getSConnector();
            GrantController=sConnector.getGrantController();
            NominatedSuccessorController=sConnector.getnomiNominatedSuccessorController();
            
        } catch (RemoteException | SQLException | NotBoundException | MalformedURLException|ClassNotFoundException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        grant_number_combo.setEditable(true);
        ownerText.setEditable(false);
        currentSuccessorText.setEditable(false);
        nameinvalidlabel.setVisible(false);
        nicInvalidLabel.setVisible(false);
        grant_number_combo.requestFocus();
        cancel_button.setEnabled(false);
        change_button.setEnabled(false);
        JTextComponent editorGrant = (JTextComponent) grant_number_combo.getEditor().getEditorComponent();
        editorGrant.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) grant_number_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {

                    ArrayList<Grant> similarGrantNumbers = GrantController.getSimilarGrantNumbers(item);
                    for (int i = 0; i < similarGrantNumbers.size(); i++) {
                        list.add(similarGrantNumbers.get(i).getGrantNumber());
                    }
                    GUIitemsValidator.addItemToCombo(list, grant_number_combo);

                } catch (ClassNotFoundException | SQLException |RemoteException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        nicInvalidLabel.setVisible(false);
    }

    public ChangeNominateSuccessoGrantrForm(GrantForm parent, Permit choosenpermit) {
        this.permit = choosenpermit;
        this.parent_grant = parent;
        this.setTitle("Nominate a successor to Grant");
        this.type = 3;
        numberLabel.setText("Permit number:");
        ownerText.setText(permit.getClient().getClientName());
        NominatedSuccessor successor = permit.getNominatedSuccessor();
        if (successor != null) {
            currentSuccessorText.setText(successor.getName());
        } else {
            currentSuccessorText.setText("No Successor nomination yet!");
        }

    }

    //to view gui for grant successor nomination
    public ChangeNominateSuccessoGrantrForm(GrantForm parent, boolean modal, Grant grant) {
        //this(parent, modal);
        this.grant = grant;
        this.type = 2; //if grant .type=2
        this.setTitle("Nominate a successor to Grant");
        this.parent_grant = parent;
        numberLabel.setText("Grant number:");
        ownerText.setText(grant.getClient().getClientName());
        NominatedSuccessor successor = grant.getNominatedSuccessor();
        if (successor != null) {
            currentSuccessorText.setText(successor.getName());
        } else {
            currentSuccessorText.setText("No Successor nomination yet!");
        }
    }

    //to view gui for permit successor nomination
    public ChangeNominateSuccessoGrantrForm(PermitForm parent, boolean modal, Permit permit) {
        //this(parent, modal);
        this.permit = permit;
        this.type = 1; //if grant .type=2
        this.setTitle("Nominate a successor to Permit");
        this.parent_permit = parent;
        numberLabel.setText("Permit number:");
        ownerText.setText(permit.getClient().getClientName());
        NominatedSuccessor successor = permit.getNominatedSuccessor();
        if (successor != null) {
            currentSuccessorText.setText(successor.getName());
        } else {
            currentSuccessorText.setText("No Successor nomination yet!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        numberLabel = new javax.swing.JLabel();
        ownerlabel = new javax.swing.JLabel();
        ownerText = new javax.swing.JTextField();
        currentnominatedsucclabel = new javax.swing.JLabel();
        currentSuccessorText = new javax.swing.JTextField();
        grant_number_combo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        namelabel = new javax.swing.JLabel();
        niclabel = new javax.swing.JLabel();
        addresslabel = new javax.swing.JLabel();
        ns_name_text = new javax.swing.JTextField();
        nic_text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_text = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        cancel_button = new javax.swing.JButton();
        change_button = new javax.swing.JButton();
        nicInvalidLabel = new javax.swing.JLabel();
        nameinvalidlabel = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        numberLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        numberLabel.setText("Grant number:");

        ownerlabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ownerlabel.setText("Owner:");

        currentnominatedsucclabel.setText("Currently nominated successor:");

        grant_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                grant_number_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberLabel)
                            .addComponent(ownerlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ownerText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grant_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(currentnominatedsucclabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentSuccessorText, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLabel)
                    .addComponent(grant_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerlabel)
                    .addComponent(ownerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentSuccessorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentnominatedsucclabel))
                .addGap(26, 26, 26))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("New successor details"));

        namelabel.setText("Name:");

        niclabel.setText("NIC:");

        addresslabel.setText("Address:");

        ns_name_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ns_name_textKeyReleased(evt);
            }
        });

        nic_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nic_textKeyReleased(evt);
            }
        });

        address_text.setColumns(20);
        address_text.setRows(5);
        address_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_textKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(address_text);

        cancel_button.setText("Cancel");
        cancel_button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cancel_buttonKeyReleased(evt);
            }
        });

        change_button.setText("Add");
        change_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_buttonActionPerformed(evt);
            }
        });
        change_button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                change_buttonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(change_button, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel_button)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_button)
                    .addComponent(change_button)))
        );

        nicInvalidLabel.setForeground(new java.awt.Color(255, 0, 0));
        nicInvalidLabel.setText("NIC is invalid");

        nameinvalidlabel.setForeground(new java.awt.Color(255, 0, 0));
        nameinvalidlabel.setText("Invalid");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namelabel)
                            .addComponent(niclabel)
                            .addComponent(addresslabel))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nicInvalidLabel))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ns_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameinvalidlabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namelabel)
                    .addComponent(ns_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameinvalidlabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niclabel)
                    .addComponent(nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicInvalidLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addresslabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void change_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_buttonActionPerformed
        //  NominatedSuccessor successor=new NominatedSuccessor(nic_text.getText(), ns_name_text.getText(), address_text.getText());
        //add this to database
        try {
            NominatedSuccessor successor = new NominatedSuccessor(nic_text.getText(), ns_name_text.getText(), address_text.getText());
            Grant searchGrant = GrantController.searchGrant(String.valueOf(grant_number_combo.getSelectedItem()));
            if (searchGrant != null) {
                boolean changeNominatedSuccessorGrant = GrantController.changeNominatedSuccessorGrant(searchGrant, successor);
                if (changeNominatedSuccessorGrant) {
                    JOptionPane.showMessageDialog(this, "Nominate Successor Changed");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Nominanted Successor does not Changed");
                }
            }

        } catch (ClassNotFoundException | SQLException | RemoteException ex) {
            Logger.getLogger(ChangeNominateSuccessoOfPermitrForm.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }//GEN-LAST:event_change_buttonActionPerformed

    private void grant_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_grant_number_comboItemStateChanged
        try {
            Grant searchGrant = GrantController.searchGrant(String.valueOf(grant_number_combo.getSelectedItem()));
            if (searchGrant != null) {
                NominatedSuccessor nominatedSuccessor = searchGrant.getNominatedSuccessor();
                ownerText.setText(searchGrant.getClient().getClientName());
                if (nominatedSuccessor != null) {
                    currentSuccessorText.setText(nominatedSuccessor.getName());
                } else {
                    currentSuccessorText.setText("No Successor nomination yet!");
                }

            }
        } catch (ClassNotFoundException | SQLException |RemoteException ex) {
            Logger.getLogger(ChangeNominateSuccessoOfPermitrForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_grant_number_comboItemStateChanged

    private void change_buttonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_change_buttonKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_RIGHT){
             cancel_button.requestFocus();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_UP){
             address_text.requestFocus();
        }
    }//GEN-LAST:event_change_buttonKeyReleased

    private void cancel_buttonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancel_buttonKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode()==KeyEvent.VK_LEFT){
             change_button.requestFocus();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_UP){
             address_text.requestFocus();
        }
    }//GEN-LAST:event_cancel_buttonKeyReleased

    private void ns_name_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ns_name_textKeyReleased
        // TODO add your handling code here:
        EnabelChangeAndCancel();
         nameinvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(ns_name_text.getText());
        ns_name_text.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (PatternChecker.checkStringdirect(ns_name_text.getText())){
                nic_text.requestFocus();
            }
            else{
                nameinvalidlabel.setVisible(true);
            }
        }
        else if (evt.getKeyCode()==KeyEvent.VK_DOWN){
             nic_text.requestFocus();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_UP){
             grant_number_combo.requestFocus();
        }
    }//GEN-LAST:event_ns_name_textKeyReleased

    private void nic_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nic_textKeyReleased
        // TODO add your handling code here:
        EnabelChangeAndCancel();
         nicInvalidLabel.setVisible(false);
        String newtext=PatternChecker.checkNIC(nic_text.getText());
        nic_text.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (PatternChecker.checkNICdirect(nic_text.getText())){
                address_text.requestFocus();
            }
            else{
                nicInvalidLabel.setVisible(true);
            }
        }
        else if (evt.getKeyCode()==KeyEvent.VK_DOWN){
             address_text.requestFocus();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_UP){
             ns_name_text.requestFocus();
        }
    }//GEN-LAST:event_nic_textKeyReleased
public void EnabelChangeAndCancel(){
    if (ns_name_text.getText().trim().length()!=0 && nic_text.getText().trim().length()!=0 && address_text.getText().trim().length()!=0 && ownerText.getText().trim().length()!=0){
        change_button.setEnabled(true);
        cancel_button.setEnabled(true);
    }
    else{
        change_button.setEnabled(false);
    }
}
    private void address_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_textKeyReleased
        // TODO add your handling code here:
         EnabelChangeAndCancel();
        if (evt.getKeyCode()==KeyEvent.VK_DOWN){
             change_button.requestFocus();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_UP){
             nic_text.requestFocus();
        }
    }//GEN-LAST:event_address_textKeyReleased

    public String sendNIC_S() {
        return nic_text.getText();
    }

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
            java.util.logging.Logger.getLogger(ChangeNominateSuccessoGrantrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeNominateSuccessoGrantrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeNominateSuccessoGrantrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeNominateSuccessoGrantrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangeNominateSuccessoGrantrForm dialog = new ChangeNominateSuccessoGrantrForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address_text;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton change_button;
    private javax.swing.JTextField currentSuccessorText;
    private javax.swing.JLabel currentnominatedsucclabel;
    private javax.swing.JComboBox grant_number_combo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel nameinvalidlabel;
    private javax.swing.JLabel namelabel;
    private javax.swing.JLabel nicInvalidLabel;
    private javax.swing.JTextField nic_text;
    private javax.swing.JLabel niclabel;
    private javax.swing.JTextField ns_name_text;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField ownerText;
    private javax.swing.JLabel ownerlabel;
    // End of variables declaration//GEN-END:variables
}
