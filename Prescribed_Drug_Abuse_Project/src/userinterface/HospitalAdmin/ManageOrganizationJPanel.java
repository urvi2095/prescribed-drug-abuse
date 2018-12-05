/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author urvi
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganizationJPanel
     */
    
    
    private Enterprise enterprise;
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private EcoSystem business;
    public String spec;
    private static int count = 1;
    private int id;
    
    public ManageOrganizationJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.business = business;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        populateCombo();
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization;
            
            model.addRow(row);
        }
    }
    
    public void populateCombo(){
        organizationJComboBox.removeAllItems();
        
//        for (Organization organ : enterprise.getOrganizationDirectory().getOrganizationList()){
//            organizationJComboBox.addItem(organ);
//        }
        
        for (Type type : Organization.Type.values()) {
            
            if (Enterprise.EnterpriseType.Hospital.equals(enterprise.getEnterpriseType())) {
                
                if (!type.getValue().equals(Type.Admin.getValue()) && !type.getValue().equals(Type.Supplier.getValue()) && !type.getValue().equals(Type.Rehab.getValue())) {
                    organizationJComboBox.addItem(type);
                }
            }
            else if (Enterprise.EnterpriseType.Distributor.equals(enterprise.getEnterpriseType())) {
                if (!type.getValue().equals(Type.Admin.getValue()) && !type.getValue().equals(Type.Rehab.getValue()) && !type.getValue().equals(Type.Clinic.getValue()) && !type.getValue().equals(Type.Doctor.getValue()) && !type.getValue().equals(Type.Lab.getValue()) && !type.getValue().equals(Type.Patient.getValue()) && !type.getValue().equals(Type.Pharmacy.getValue())){
                  
                    organizationJComboBox.addItem(type);
                }
            }
            else if (Enterprise.EnterpriseType.CityWelfare.equals(enterprise.getEnterpriseType())) {
                if (!type.getValue().equals(Type.Admin.getValue()) && !type.getValue().equals(Type.Supplier.getValue()) && !type.getValue().equals(Type.Clinic.getValue()) && !type.getValue().equals(Type.Doctor.getValue()) && !type.getValue().equals(Type.Lab.getValue()) && !type.getValue().equals(Type.Patient.getValue()) && !type.getValue().equals(Type.Pharmacy.getValue())){
                    
                    organizationJComboBox.addItem(type);
                }
            }
        }
    }
    
//    public void populateCombo(){
//        organizationJComboBox.removeAllItems();
//        for (Type type : Organization.Type.values()) {
//            if (Enterprise.EnterpriseType.Hospital.equals(enterprise.getEnterpriseType())) {
//                if (!type.getValue().equals(Type.Admin.getValue())) {
//                    organizationJComboBox.addItem(type);
//                }
//            }
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 52, 500, 130));

        addJButton.setBackground(new java.awt.Color(102, 204, 255));
        addJButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 150, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Organization Type ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        backJButton.setBackground(new java.awt.Color(102, 204, 255));
        backJButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        OrganizationDirectory directory = enterprise.getOrganizationDirectory();
        Type type = (Type) organizationJComboBox.getSelectedItem();
        Organization org = directory.createOrganization(type);
//        if(directory.checkIfOrgIsUnique(org)){
//            directory.getOrganizationList().add(org);
            populateTable();
            JOptionPane.showMessageDialog(null, "Organization created successfully");
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "org exists");
//        }
        
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}