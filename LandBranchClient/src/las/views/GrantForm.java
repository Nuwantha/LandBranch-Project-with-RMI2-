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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import las.common_classes.GUIitemsValidator;
import las.controller.ClientController;
import las.controller.GramaNiladariDivisionController;
import las.controller.GrantController;
import las.controller.LotController;
import las.controller.PermitController;
//import las.common_classes.ComboItemAdder;

import las.models.Client;
import las.models.GramaNiladariDivision;
import las.models.Grant;
import las.models.Land;
import las.models.Lot;
import las.models.NominatedSuccessor;
import las.models.Permit;

/**
 *
 * @author H.P. Asela
 */
public class GrantForm extends javax.swing.JInternalFrame {
    private Permit choosenPermit;
    private Grant choosenGrant;
    LotController LotController;
    GrantController GrantController;
    ClientController ClientController;
    PermitController PermitController;
    GramaNiladariDivisionController GramaNiladariDivisionController;
            
    
    
    
    /**
     * Creates new form GrantForm
     */
    public GrantForm() {
        initComponents();
        
        
        try {
            Connector sConnector = Connector.getSConnector();
            ClientController=sConnector.getClientController();
            GrantController=sConnector.getGrantController();
            PermitController=sConnector.getPermitController();
            GramaNiladariDivisionController=sConnector.getGramaNiladariDivisionController();
            LotController=sConnector.getlotController();
            
        } catch (RemoteException | SQLException | NotBoundException | MalformedURLException|ClassNotFoundException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        add_grant_ownernameText.setEditable(false);
        add_grant_owner_nic_text.setEditable(false);
        add_grantowner_telephoneText.setEditable(false);
        add_grantowner_addressText.setEditable(false);
        add_grantowner_DOB_test.setEditable(false);
        add_grant_owner_annualIncome.setEditable(false);
        add_grant_owner_no_of_children_test.setEditable(false);
        addgrant_S_name_test.setEditable(false);
        addgrant_S_relationText.setEditable(false);
        addgrant_S_nic_test.setEditable(false);
        addgrant_S_address_test.setEditable(false);
        addgrant_permit_issueDate.setEditable(false);
        add_grant_division_no_text.setEditable(false);
        add_grant_division_name_text.setEditable(false);
        add_grant_plan_no_text.setEditable(false);
        add_grant_landName_text.setEditable(false);
        add_grant_lotno_text.setEditable(false);
        add_grant_acres_text.setEditable(false);
       add_grant_perches_text.setEditable(false);
        add_grant_roods_text.setEditable(false);
        add_grant_button.setEnabled(false);
        //add grant
        
        this.Add_Grant_Grant_No.setEditable(true);
        this.add_grant_permit_no_combo.setEditable(true);
        JTextComponent editorSearchPemitPNCombo = (JTextComponent) add_grant_permit_no_combo.getEditor().getEditorComponent();
        editorSearchPemitPNCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) add_grant_permit_no_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {
                    ArrayList<Permit> simmilarPlanNumbers = PermitController.getSimilarPermitNumbers(item);
                    for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                        list.add(simmilarPlanNumbers.get(i).getPermitNumber());
                    }
                    GUIitemsValidator.addItemToCombo(list, add_grant_permit_no_combo);

                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        
        //search grant
        
        this.search_grant_grantnoCombo.setEditable(true);
        JTextComponent editorSearchGrantPNCombo = (JTextComponent) this.search_grant_grantnoCombo.getEditor().getEditorComponent();
        editorSearchPemitPNCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) search_grant_grantnoCombo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {
                    ArrayList<Grant> simmilarPlanNumbers = GrantController.getSimilarGrantNumbers(item);
                    for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                        list.add(simmilarPlanNumbers.get(i).getGrantNumber());
                    }
                    GUIitemsValidator.addItemToCombo(list,search_grant_grantnoCombo );

                } catch (ClassNotFoundException | SQLException|RemoteException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
                
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        grantnolabel = new javax.swing.JLabel();
        issuedatelabel = new javax.swing.JLabel();
        Add_Grant_Grant_No = new javax.swing.JTextField();
        addgrant_grant_issue_dateChooser = new org.freixas.jcalendar.JCalendarCombo();
        jPanel7 = new javax.swing.JPanel();
        permitnolabel = new javax.swing.JLabel();
        add_grant_issuedate_label = new javax.swing.JLabel();
        add_grant_permit_no_combo = new javax.swing.JComboBox();
        addgrant_permit_issueDate = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        add_grant_ownernameText = new javax.swing.JTextField();
        add_grantowner_telephoneText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        add_grantowner_addressText = new javax.swing.JTextArea();
        add_grant_owner_no_of_children_test = new javax.swing.JTextField();
        add_grant_owner_marriedStatusRButton = new javax.swing.JRadioButton();
        add_grant_owner_singleStatusRButton = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        add_grant_owner_annualIncome = new javax.swing.JTextField();
        add_grantowner_DOB_test = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        add_grant_changeOwner = new javax.swing.JButton();
        add_grant_owner_nic_text = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        add_grant_landName_text = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        add_grant_division_name_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        add_grant_acres_text = new javax.swing.JTextField();
        add_grant_perches_text = new javax.swing.JTextField();
        add_grant_roods_text = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        add_grant_division_no_text = new javax.swing.JTextField();
        add_grant_plan_no_text = new javax.swing.JTextField();
        add_grant_lotno_text = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        addgrant_S_name_test = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        addgrant_S_nic_test = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addgrant_S_address_test = new javax.swing.JTextArea();
        addgrant_S_relationText = new javax.swing.JTextField();
        nominateSuccessorButton = new javax.swing.JButton();
        add_grant_button = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        viewAll_table = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        viewAll_load_buttun = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        search_grantnolabel = new javax.swing.JLabel();
        search_grant_issuedatelabel = new javax.swing.JLabel();
        search_grant_issuedateText = new javax.swing.JTextField();
        search_grant_grantnoCombo = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        search_grant_ownernameText = new javax.swing.JTextField();
        search_grantowner_telephoneText = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        search_grantowner_addressText = new javax.swing.JTextArea();
        search_grant_owner_no_of_children_text = new javax.swing.JTextField();
        search_grant_owner_marriedStatusRButton = new javax.swing.JRadioButton();
        search_grant_owner_singleStatusRButton = new javax.swing.JRadioButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        search_grant_owner_annualIncome = new javax.swing.JTextField();
        search_grantowner_DOB_text = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        search_grant_owner_nic_text = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        searchgrant_S_name_text = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        searchgrant_S_nic_text = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchgrant_S_address_text = new javax.swing.JTextArea();
        searchgrant_S_relationText = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        search_grant_landName_text = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        search_grant_division_name_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        search_grant_acres_text = new javax.swing.JTextField();
        search_grant_perches_text = new javax.swing.JTextField();
        search_grant_roods_text = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        search_grant_division_no_text = new javax.swing.JTextField();
        search_grant_plan_no_text = new javax.swing.JTextField();
        search_grant_lotno_text = new javax.swing.JTextField();

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Successor Information"));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        setTitle("Grant");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Grant Information"));
        jPanel6.setPreferredSize(new java.awt.Dimension(581, 581));

        grantnolabel.setText("Grant No:");

        issuedatelabel.setText("Issue Date:");

        Add_Grant_Grant_No.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Add_Grant_Grant_NoKeyReleased(evt);
            }
        });

        addgrant_grant_issue_dateChooser.setEditable(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grantnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issuedatelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_Grant_Grant_No, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addgrant_grant_issue_dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grantnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Grant_Grant_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issuedatelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addgrant_grant_issue_dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Permit Information"));
        jPanel7.setPreferredSize(new java.awt.Dimension(581, 581));

        permitnolabel.setText("Permit No:");

        add_grant_issuedate_label.setText("Issue Date:");

        add_grant_permit_no_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                add_grant_permit_no_comboItemStateChanged(evt);
            }
        });

        addgrant_permit_issueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addgrant_permit_issueDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(permitnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_grant_issuedate_label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_grant_permit_no_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addgrant_permit_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(permitnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_grant_permit_no_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_grant_issuedate_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addgrant_permit_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Owner Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        add_grant_ownernameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                add_grant_ownernameTextKeyReleased(evt);
            }
        });

        add_grantowner_addressText.setColumns(20);
        add_grantowner_addressText.setRows(5);
        jScrollPane3.setViewportView(add_grantowner_addressText);

        add_grant_owner_no_of_children_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_grant_owner_no_of_children_testActionPerformed(evt);
            }
        });

        add_grant_owner_marriedStatusRButton.setText("Married");
        add_grant_owner_marriedStatusRButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                add_grant_owner_marriedStatusRButtonStateChanged(evt);
            }
        });

        add_grant_owner_singleStatusRButton.setText("Single");
        add_grant_owner_singleStatusRButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                add_grant_owner_singleStatusRButtonStateChanged(evt);
            }
        });
        add_grant_owner_singleStatusRButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                add_grant_owner_singleStatusRButtonKeyReleased(evt);
            }
        });

        jLabel35.setText("NIC :");

        jLabel20.setText("Name:");

        jLabel36.setText("Phone Number:");

        jLabel37.setText("Address:");

        jLabel38.setText("Birthday:");

        jLabel39.setText("Status:");

        jLabel40.setText("Annual Income:");

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("No. of married children:");

        add_grant_changeOwner.setText("Change Ownership");
        add_grant_changeOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_grant_changeOwnerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(add_grant_owner_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add_grant_changeOwner)
                                    .addComponent(add_grant_owner_no_of_children_test, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add_grant_ownernameText, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(add_grantowner_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(add_grant_owner_marriedStatusRButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(add_grant_owner_singleStatusRButton))
                                            .addComponent(add_grantowner_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add_grant_owner_nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_grant_owner_nic_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_grant_ownernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_grantowner_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_grantowner_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_grant_owner_marriedStatusRButton)
                            .addComponent(add_grant_owner_singleStatusRButton)
                            .addComponent(jLabel39))))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_grant_owner_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_grant_owner_no_of_children_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(add_grant_changeOwner)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Information"));

        jLabel22.setText("Plan Number:");

        jLabel23.setText("Land Name:");

        jLabel24.setText("Division Number:");

        jLabel25.setText("Division Name:");

        jLabel1.setText("Included Land");

        jLabel2.setText("Included Division");

        jLabel100.setText("Expected Extent:");

        add_grant_perches_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_grant_perches_textActionPerformed(evt);
            }
        });

        jLabel103.setText("Roods");

        jLabel102.setText("Perches");

        jLabel101.setText("Acre / Hectare");

        jLabel99.setText("Lot No:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99)
                    .addComponent(jLabel2)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_grant_division_no_text, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(add_grant_lotno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(add_grant_plan_no_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_grant_landName_text, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(add_grant_division_name_text)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_grant_roods_text, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(add_grant_perches_text, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(add_grant_acres_text))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103)
                            .addComponent(jLabel102)
                            .addComponent(jLabel101))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_grant_division_no_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_grant_division_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_grant_landName_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_grant_plan_no_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(add_grant_lotno_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(add_grant_acres_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_grant_perches_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_grant_roods_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nominated Successor Information"));

        jLabel26.setText("Name:");

        jLabel42.setText("NIC:");

        jLabel43.setText("Address:");

        jLabel44.setText("Relationship:");

        addgrant_S_address_test.setColumns(20);
        addgrant_S_address_test.setRows(5);
        jScrollPane1.setViewportView(addgrant_S_address_test);

        nominateSuccessorButton.setText("Nominate New Successor");
        nominateSuccessorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nominateSuccessorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel26))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nominateSuccessorButton)
                            .addComponent(addgrant_S_relationText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addgrant_S_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(addgrant_S_name_test))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addgrant_S_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(addgrant_S_relationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42)
                    .addComponent(addgrant_S_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(nominateSuccessorButton)
                        .addContainerGap())))
        );

        add_grant_button.setText("Add Grant");
        add_grant_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_grant_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(add_grant_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_grant_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Grant", jPanel2);

        viewAll_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GrantNumber", "IssueDate", "Clientname", "ClientNic", "DivisionalNumber", "PlanNumber", "LandName", "LotNumber", "NominateSuccesor", "OwnarshipPosition"
            }
        ));
        jScrollPane5.setViewportView(viewAll_table);

        viewAll_load_buttun.setText("Load");
        viewAll_load_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAll_load_buttunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(760, Short.MAX_VALUE)
                .addComponent(viewAll_load_buttun, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(viewAll_load_buttun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View All Grants", jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Grant Information"));
        jPanel10.setPreferredSize(new java.awt.Dimension(581, 581));

        search_grantnolabel.setText("Grant No:");

        search_grant_issuedatelabel.setText("Issue Date:");

        search_grant_issuedateText.setEditable(false);

        search_grant_grantnoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                search_grant_grantnoComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(search_grantnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(search_grant_issuedatelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_grant_grantnoCombo, 0, 118, Short.MAX_VALUE)
                    .addComponent(search_grant_issuedateText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grantnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_grantnoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grant_issuedateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_issuedatelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Owner Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        search_grant_ownernameText.setEditable(false);
        search_grant_ownernameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_grant_ownernameTextKeyReleased(evt);
            }
        });

        search_grantowner_telephoneText.setEditable(false);

        search_grantowner_addressText.setEditable(false);
        search_grantowner_addressText.setColumns(20);
        search_grantowner_addressText.setRows(5);
        jScrollPane4.setViewportView(search_grantowner_addressText);

        search_grant_owner_no_of_children_text.setEditable(false);
        search_grant_owner_no_of_children_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_grant_owner_no_of_children_textActionPerformed(evt);
            }
        });

        search_grant_owner_marriedStatusRButton.setText("Married");

        search_grant_owner_singleStatusRButton.setText("Single");

        jLabel45.setText("NIC :");

        jLabel21.setText("Name:");

        jLabel46.setText("Phone Number:");

        jLabel47.setText("Address:");

        jLabel48.setText("Birthday:");

        jLabel49.setText("Status:");

        jLabel50.setText("Annual Income:");

        search_grant_owner_annualIncome.setEditable(false);

        search_grantowner_DOB_text.setEditable(false);

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("No. of married children:");

        search_grant_owner_nic_text.setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_grant_owner_nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(search_grantowner_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_grant_owner_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(search_grant_owner_no_of_children_text, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(60, 60, 60)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_grantowner_DOB_text, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(search_grant_owner_marriedStatusRButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(search_grant_owner_singleStatusRButton))))
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(search_grant_ownernameText)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_owner_nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grant_ownernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grantowner_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(13, 13, 13)))
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(search_grantowner_DOB_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grant_owner_marriedStatusRButton)
                    .addComponent(search_grant_owner_singleStatusRButton)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_owner_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grant_owner_no_of_children_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nominated Successor Information"));

        jLabel27.setText("Name:");

        jLabel52.setText("NIC:");

        jLabel53.setText("Address:");

        searchgrant_S_name_text.setEditable(false);

        jLabel54.setText("Relationship:");

        searchgrant_S_nic_text.setEditable(false);

        searchgrant_S_address_text.setEditable(false);
        searchgrant_S_address_text.setColumns(20);
        searchgrant_S_address_text.setRows(5);
        jScrollPane2.setViewportView(searchgrant_S_address_text);

        searchgrant_S_relationText.setEditable(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel27))
                .addGap(29, 29, 29)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchgrant_S_relationText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchgrant_S_nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchgrant_S_name_text)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchgrant_S_nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchgrant_S_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(searchgrant_S_relationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel53)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Information"));

        jLabel28.setText("Plan Number:");

        jLabel29.setText("Land Name:");

        search_grant_landName_text.setEditable(false);

        jLabel30.setText("Division Number:");

        jLabel31.setText("Division Name:");

        search_grant_division_name_text.setEditable(false);

        jLabel3.setText("Included Land");

        jLabel4.setText("Included Division");

        jLabel104.setText("Expected Extent:");

        search_grant_acres_text.setEditable(false);

        search_grant_perches_text.setEditable(false);
        search_grant_perches_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_grant_perches_textActionPerformed(evt);
            }
        });

        search_grant_roods_text.setEditable(false);

        jLabel105.setText("Roods");

        jLabel106.setText("Perches");

        jLabel107.setText("Acre / Hectare");

        jLabel108.setText("Lot No:");

        search_grant_division_no_text.setEditable(false);

        search_grant_plan_no_text.setEditable(false);

        search_grant_lotno_text.setEditable(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel108)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search_grant_division_no_text, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(search_grant_lotno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(search_grant_plan_no_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_grant_landName_text, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(search_grant_division_name_text)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_grant_roods_text, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(search_grant_perches_text, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(search_grant_acres_text))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel105)
                            .addComponent(jLabel106)
                            .addComponent(jLabel107)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_division_no_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_division_name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_landName_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_grant_plan_no_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(search_grant_lotno_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(search_grant_acres_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grant_perches_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_grant_roods_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 551, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Search Grant", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void EnableAdd(){
    if(addgrant_permit_issueDate.getText().trim().length()!=0 && Add_Grant_Grant_No.getText().trim().length()!=0){
        add_grant_button.setEnabled(true);
    }
}
    public void UpdateOwner(){
        try {
            this.choosenPermit = PermitController.searchPermit(String.valueOf(add_grant_permit_no_combo.getSelectedItem()));
            if (choosenPermit != null) {
                Client client = choosenPermit.getClient();
                NominatedSuccessor nominatedSuccessor = choosenPermit.getNominatedSuccessor();
                Lot lot = choosenPermit.getLot();
                Land land = lot.getLand();
                String permitIssueDate = choosenPermit.getPermitIssueDate();
                this.addgrant_permit_issueDate.setText(permitIssueDate);//Permit issue date need to be added

                this.add_grant_division_no_text.setText(land.getDivisionNumber());
                GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND(land.getDivisionNumber());
                add_grant_division_name_text.setText(searchGND.getDivisionName());

                this.add_grant_landName_text.setText(land.getLandName());
                this.add_grant_plan_no_text.setText(land.getPlanNumber());

                this.add_grant_lotno_text.setText(lot.getLotNumber());
                this.add_grant_acres_text.setText(String.valueOf(lot.getNumberOfAcres()));
                this.add_grant_perches_text.setText(String.valueOf(lot.getNumberOfPerches()));
                this.add_grant_roods_text.setText(String.valueOf(lot.getNumberofRoods()));

                this.add_grant_owner_nic_text.setText(client.getNIC());
                this.add_grant_ownernameText.setText(client.getClientName());
                this.add_grantowner_telephoneText.setText(client.getTelephone());
                this.add_grantowner_DOB_test.setText(client.getBirthday());
                this.add_grantowner_addressText.setText(client.getAddress());
                this.add_grant_owner_annualIncome.setText(String.valueOf(client.getAnnualIncome()));
                this.add_grant_owner_no_of_children_test.setText(String.valueOf(client.getNumberOfMarriedSons() + client.getNumberOfUnmarriedSons()));
                if (client.isMarried() == 1) {
                    this.add_grant_owner_marriedStatusRButton.setSelected(true);
                } else {
                    this.add_grant_owner_singleStatusRButton.setSelected(true);
                }
                
                this.addgrant_S_nic_test.setText(nominatedSuccessor.getNIC_S());
                this.addgrant_S_name_test.setText(nominatedSuccessor.getName());
                this.addgrant_S_address_test.setText(nominatedSuccessor.getAddress());

               
            }
        } catch (ClassNotFoundException | SQLException|RemoteException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void UpdateSuccessor(NominatedSuccessor newSuccessor){
            this.addgrant_S_nic_test.setText(newSuccessor.getNIC_S());
            this.addgrant_S_name_test.setText(newSuccessor.getName());
            this.addgrant_S_address_test.setText(newSuccessor.getAddress());
    
    }
    
    public Permit getPermit(){
        return this.choosenPermit;
    }
    
    private void add_grant_perches_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_grant_perches_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_grant_perches_textActionPerformed

    private void add_grant_owner_no_of_children_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_grant_owner_no_of_children_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_grant_owner_no_of_children_testActionPerformed

    private void add_grant_ownernameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_grant_ownernameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add_grant_ownernameTextKeyReleased

    private void addgrant_permit_issueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addgrant_permit_issueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addgrant_permit_issueDateActionPerformed

    private void add_grant_permit_no_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_add_grant_permit_no_comboItemStateChanged
        this.UpdateOwner();
      
        /*   try {
            this.choosenPermit = PermitController.searchPermit(String.valueOf(add_grant_permit_no_combo.getSelectedItem()));
            if (choosenPermit != null) {
                Client client = choosenPermit.getClient();
                NominatedSuccessor nominatedSuccessor = choosenPermit.getNominatedSuccessor();
                Lot lot = choosenPermit.getLot();
                Land land = lot.getLand();
                String permitIssueDate = choosenPermit.getPermitIssueDate();
                this.add_grant_issuedate_label.setText(permitIssueDate);//Permit issue date need to be added

                this.add_grant_division_no_text.setText(land.getDivisionNumber());
                GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND(land.getDivisionNumber());
                add_grant_division_name_text.setText(searchGND.getDivisionName());

                this.add_grant_landName_text.setText(land.getLandName());
                this.add_grant_plan_no_text.setText(land.getPlanNumber());

                this.add_grant_lotno_text.setText(lot.getLotNumber());
                this.add_grant_acres_text.setText(String.valueOf(lot.getNumberOfAcres()));
                this.add_grant_perches_text.setText(String.valueOf(lot.getNumberOfPerches()));
                this.add_grant_roods_text.setText(String.valueOf(lot.getNumberofRoods()));

                this.add_grant_owner_nic_text.setText(client.getNIC());
                this.add_grant_ownernameText.setText(client.getClientName());
                this.add_grantowner_telephoneText.setText(client.getTelephone());
                this.add_grantowner_DOB_test.setText(client.getBirthday());
                this.add_grantowner_addressText.setText(client.getAddress());
                this.add_grant_owner_annualIncome.setText(String.valueOf(client.getAnnualIncome()));
                this.add_grant_owner_no_of_children_test.setText(String.valueOf(client.getNumberOfMarriedSons() + client.getNumberOfUnmarriedSons()));
                if (client.isMarried() == 1) {
                    this.add_grant_owner_marriedStatusRButton.setSelected(true);
                } else {
                    this.add_grant_owner_singleStatusRButton.setSelected(true);
                }
                
                this.addgrant_S_nic_test.setText(nominatedSuccessor.getNIC_S());
                this.addgrant_S_name_test.setText(nominatedSuccessor.getName());
                this.addgrant_S_address_test.setText(nominatedSuccessor.getAddress());

               
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }//GEN-LAST:event_add_grant_permit_no_comboItemStateChanged

    private void add_grant_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_grant_buttonActionPerformed
        try {
            this.choosenPermit = PermitController.searchPermit(String.valueOf(add_grant_permit_no_combo.getSelectedItem()));
            if (choosenPermit!=null){
                NominatedSuccessor nominatedSuccessor = new NominatedSuccessor(this.addgrant_S_nic_test.getText(), this.addgrant_S_name_test.getText(), this.addgrant_S_address_test.getText());
                Client searchClient = ClientController.searchClient(String.valueOf(this.add_grant_owner_nic_text.getText()));
                Lot searchLot = LotController.searchLot(String.valueOf(this.add_grant_lotno_text.getSelectedText()));
                Date date = this.addgrant_grant_issue_dateChooser.getDate();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String issueDate = simpleDateFormat.format(date);
            
                Grant grant = new Grant(this.Add_Grant_Grant_No.getText(), issueDate,choosenPermit, searchLot, searchClient, nominatedSuccessor);
                boolean addNewGrant = GrantController.addNewGrant(grant);
                if (addNewGrant) {
                    JOptionPane.showMessageDialog(this, "Grant Added successfully");
                    add_grant_ownernameText.setText(null);
                    add_grant_owner_nic_text.setText(null);
                    add_grantowner_telephoneText.setText(null);
                    add_grantowner_addressText.setText(null);
                    add_grantowner_DOB_test.setText(null);
                    add_grant_owner_annualIncome.setText(null);
                    add_grant_owner_no_of_children_test.setText(null);
                    addgrant_S_name_test.setText(null);
                    addgrant_S_relationText.setText(null);
                    addgrant_S_nic_test.setText(null);
                    addgrant_S_address_test.setText(null);
                    addgrant_permit_issueDate.setText(null);
                    add_grant_division_no_text.setText(null);
                    add_grant_division_name_text.setText(null);
                    add_grant_plan_no_text.setText(null);
                    add_grant_landName_text.setText(null);
                    add_grant_lotno_text.setText(null);
                    add_grant_acres_text.setText(null);
                    add_grant_perches_text.setText(null);
                    add_grant_roods_text.setText(null);
                    add_grant_owner_marriedStatusRButton.setSelected(false);
                    add_grant_owner_singleStatusRButton.setSelected(false);
                    Add_Grant_Grant_No.setText(null);
                    add_grant_permit_no_combo.setSelectedItem(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Grant does not added successfully");
                }
            
            }
        }
        
        catch (ClassNotFoundException | SQLException|RemoteException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_grant_buttonActionPerformed

    private void add_grant_changeOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_grant_changeOwnerActionPerformed
       ChangePermitOwnershipForm changeOwnForm = new ChangePermitOwnershipForm(this);
       changeOwnForm.setVisible(true);
           
    }//GEN-LAST:event_add_grant_changeOwnerActionPerformed

    private void nominateSuccessorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nominateSuccessorButtonActionPerformed
        ChangeNominateSuccessoGrantrForm newGrantSuccessor = new ChangeNominateSuccessoGrantrForm(this,this.choosenPermit);
        newGrantSuccessor.setVisible(true);
    }//GEN-LAST:event_nominateSuccessorButtonActionPerformed

    private void search_grant_ownernameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_grant_ownernameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search_grant_ownernameTextKeyReleased

    private void search_grant_owner_no_of_children_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_grant_owner_no_of_children_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_grant_owner_no_of_children_textActionPerformed

    private void search_grant_perches_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_grant_perches_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_grant_perches_textActionPerformed

    private void search_grant_grantnoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_search_grant_grantnoComboItemStateChanged

        try {
            this.choosenGrant = GrantController.searchGrant(String.valueOf(this.search_grant_grantnoCombo.getSelectedItem()));
            if (choosenGrant != null) {
                Client client = choosenGrant.getClient();
                NominatedSuccessor nominatedSuccessor = choosenGrant.getNominatedSuccessor();
                Lot lot = choosenGrant.getLot();
                Land land = lot.getLand();
                String grantIssueDate = choosenGrant.getGrantIssueDate();
                this.search_grant_issuedateText.setText(grantIssueDate);//Permit issue date need to be added

                this.search_grant_division_no_text.setText(land.getDivisionNumber());
                GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND(land.getDivisionNumber());
                search_grant_division_name_text.setText(searchGND.getDivisionName());

                this.search_grant_landName_text.setText(land.getLandName());
                this.search_grant_plan_no_text.setText(land.getPlanNumber());

                this.search_grant_lotno_text.setText(lot.getLotNumber());
                this.search_grant_acres_text.setText(String.valueOf(lot.getNumberOfAcres()));
                this.search_grant_perches_text.setText(String.valueOf(lot.getNumberOfPerches()));
                this.search_grant_roods_text.setText(String.valueOf(lot.getNumberofRoods()));

                this.search_grant_owner_nic_text.setText(client.getNIC());
                this.search_grant_ownernameText.setText(client.getClientName());
                this.search_grantowner_telephoneText.setText(client.getTelephone());
                this.search_grantowner_DOB_text.setText(client.getBirthday());
                this.search_grantowner_addressText.setText(client.getAddress());
                this.search_grant_owner_annualIncome.setText(String.valueOf(client.getAnnualIncome()));
                this.search_grant_owner_no_of_children_text.setText(String.valueOf(client.getNumberOfMarriedSons() + client.getNumberOfUnmarriedSons()));
                if (client.isMarried() == 1) {
                    this.search_grant_owner_marriedStatusRButton.setSelected(true);
                } else {
                    this.search_grant_owner_singleStatusRButton.setSelected(true);
                }
                
                this.searchgrant_S_nic_text.setText(nominatedSuccessor.getNIC_S());
                this.searchgrant_S_name_text.setText(nominatedSuccessor.getName());
                this.searchgrant_S_address_text.setText(nominatedSuccessor.getAddress());

               
            }
        } catch (ClassNotFoundException | SQLException |RemoteException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_search_grant_grantnoComboItemStateChanged

    private void viewAll_load_buttunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAll_load_buttunActionPerformed
        DefaultTableModel model = (DefaultTableModel) viewAll_table.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
       // try {
           // ArrayList<Permit> allGrant = GrantController.getAllGrant();  **Getallgrant method should be implemented in grant controller

        /*    for (Grant grant : allGrant) {
                Object[] rowdata = {grant.getGrantNumber(), grant.getGranttIssueDate(), grant.getClient().getClientName(), grant.getClient().getNIC(), grant.getLot().getLand().getDivisionNumber(), grant.getLot().getLand().getPlanNumber(), grant.getLot().getLand().getLandName(), grant.getLot().getLotNumber(), grant.getNominatedSuccessor().getName(), grant.getClient().getGrantOwnershipPosition()};
                model.addRow(rowdata);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }//GEN-LAST:event_viewAll_load_buttunActionPerformed

    private void Add_Grant_Grant_NoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Add_Grant_Grant_NoKeyReleased
        // TODO add your handling code here:
        EnableAdd();
    }//GEN-LAST:event_Add_Grant_Grant_NoKeyReleased

    private void add_grant_owner_marriedStatusRButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_add_grant_owner_marriedStatusRButtonStateChanged
        // TODO add your handling code here:
         EnableAdd();
    }//GEN-LAST:event_add_grant_owner_marriedStatusRButtonStateChanged

    private void add_grant_owner_singleStatusRButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_grant_owner_singleStatusRButtonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add_grant_owner_singleStatusRButtonKeyReleased

    private void add_grant_owner_singleStatusRButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_add_grant_owner_singleStatusRButtonStateChanged
        // TODO add your handling code here:
         EnableAdd();
    }//GEN-LAST:event_add_grant_owner_singleStatusRButtonStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Add_Grant_Grant_No;
    private javax.swing.JTextField add_grant_acres_text;
    private javax.swing.JButton add_grant_button;
    private javax.swing.JButton add_grant_changeOwner;
    private javax.swing.JTextField add_grant_division_name_text;
    private javax.swing.JTextField add_grant_division_no_text;
    private javax.swing.JLabel add_grant_issuedate_label;
    private javax.swing.JTextField add_grant_landName_text;
    private javax.swing.JTextField add_grant_lotno_text;
    private javax.swing.JTextField add_grant_owner_annualIncome;
    private javax.swing.JRadioButton add_grant_owner_marriedStatusRButton;
    private javax.swing.JTextField add_grant_owner_nic_text;
    private javax.swing.JTextField add_grant_owner_no_of_children_test;
    private javax.swing.JRadioButton add_grant_owner_singleStatusRButton;
    private javax.swing.JTextField add_grant_ownernameText;
    private javax.swing.JTextField add_grant_perches_text;
    private javax.swing.JComboBox add_grant_permit_no_combo;
    private javax.swing.JTextField add_grant_plan_no_text;
    private javax.swing.JTextField add_grant_roods_text;
    private javax.swing.JTextField add_grantowner_DOB_test;
    private javax.swing.JTextArea add_grantowner_addressText;
    private javax.swing.JTextField add_grantowner_telephoneText;
    private javax.swing.JTextArea addgrant_S_address_test;
    private javax.swing.JTextField addgrant_S_name_test;
    private javax.swing.JTextField addgrant_S_nic_test;
    private javax.swing.JTextField addgrant_S_relationText;
    private org.freixas.jcalendar.JCalendarCombo addgrant_grant_issue_dateChooser;
    private javax.swing.JTextField addgrant_permit_issueDate;
    private javax.swing.JLabel grantnolabel;
    private javax.swing.JLabel issuedatelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton nominateSuccessorButton;
    private javax.swing.JLabel permitnolabel;
    private javax.swing.JTextField search_grant_acres_text;
    private javax.swing.JTextField search_grant_division_name_text;
    private javax.swing.JTextField search_grant_division_no_text;
    private javax.swing.JComboBox search_grant_grantnoCombo;
    private javax.swing.JTextField search_grant_issuedateText;
    private javax.swing.JLabel search_grant_issuedatelabel;
    private javax.swing.JTextField search_grant_landName_text;
    private javax.swing.JTextField search_grant_lotno_text;
    private javax.swing.JTextField search_grant_owner_annualIncome;
    private javax.swing.JRadioButton search_grant_owner_marriedStatusRButton;
    private javax.swing.JTextField search_grant_owner_nic_text;
    private javax.swing.JTextField search_grant_owner_no_of_children_text;
    private javax.swing.JRadioButton search_grant_owner_singleStatusRButton;
    private javax.swing.JTextField search_grant_ownernameText;
    private javax.swing.JTextField search_grant_perches_text;
    private javax.swing.JTextField search_grant_plan_no_text;
    private javax.swing.JTextField search_grant_roods_text;
    private javax.swing.JLabel search_grantnolabel;
    private javax.swing.JTextField search_grantowner_DOB_text;
    private javax.swing.JTextArea search_grantowner_addressText;
    private javax.swing.JTextField search_grantowner_telephoneText;
    private javax.swing.JTextArea searchgrant_S_address_text;
    private javax.swing.JTextField searchgrant_S_name_text;
    private javax.swing.JTextField searchgrant_S_nic_text;
    private javax.swing.JTextField searchgrant_S_relationText;
    private javax.swing.JButton viewAll_load_buttun;
    private javax.swing.JTable viewAll_table;
    // End of variables declaration//GEN-END:variables
}
