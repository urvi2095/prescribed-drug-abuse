/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package userinterface.DistributorAdmin.Supplier;

import Business.Drug;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.Organization.SupplierOrganization;
import Business.Role.Role;
import Business.Role.SupplierRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SupplierWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hetashavi
 */
public class SupplierAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private SupplierOrganization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private SupplierRole s;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SupplierAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,EcoSystem business, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = (SupplierOrganization)organization;
        populateWorkQueueTable();
        populateAvailable();
    }

    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();

        model.setRowCount(0);

        for (WorkRequest work : account.getWorkQueue().getWorkRequestList()) {
            if (work instanceof SupplierWorkRequest) {
                Object[] row = new Object[5];
                row[0] = ((SupplierWorkRequest) work).getDrugName();
                row[1] = ((SupplierWorkRequest) work).getOrderedQuantity();
                row[2] = work;
                row[3] = work.getReceiver();
                row[4] = work.getSender();
                model.addRow(row);
            }
        }
    }

    public void populateAvailable() {
        DefaultTableModel model = (DefaultTableModel) availableTable.getModel();

        model.setRowCount(0);

        for (Drug drug : business.getDrugCatalog().getListOfDrugs()) {

            Object[] row = new Object[4];
            row[0] = drug.getDrug_name();
            row[1] = drug.getAvailability();
            model.addRow(row);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        btnComplete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        btnComplete1 = new javax.swing.JButton();
        reqBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Supplier Work Area -Adminstrative Role");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 20));

        btnComplete.setBackground(new java.awt.Color(102, 204, 255));
        btnComplete.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Supplier Work Area -Adminstrative Role");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));
        add(valueLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 20));

        btnComplete1.setText("Complete");
        btnComplete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComplete1ActionPerformed(evt);
            }
        });
        add(btnComplete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 140, -1));

        reqBtn.setBackground(new java.awt.Color(102, 204, 255));
        reqBtn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        reqBtn.setText("Assign To Me");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 150, -1));

        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(availableTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 500, 90));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Vaccines Requested");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 170, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Vaccines Available");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 150, 30));

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Quantity", "Status", "Receiver", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 500, 90));

        backJButton.setBackground(new java.awt.Color(102, 204, 255));
        backJButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        backJButton.setText("Refresh");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        btnDelete.setBackground(new java.awt.Color(102, 204, 255));
        btnDelete.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnDelete.setText("Delete request");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SupplierWorkRequest p = (SupplierWorkRequest) requestTable.getValueAt(selectedRow, 2);
            int temp = 0;
            if (p.getReceiver() != null) {
                if (p.getStatus().equals("Pending")) {
                    UserAccount a = p.getSender();
                    if (business.getDrugCatalog().getListOfDrugs().size() <= 0) {
                        JOptionPane.showMessageDialog(null, "No Stock available in system.");
                        return;
                    }
                    for (Drug drug : business.getDrugCatalog().getListOfDrugs()) {
                        if (drug.getDrug_name().equals(p.getDrugName())) {
                            if (drug.getAvailability() - p.getOrderedQuantity() < 0) {
                                JOptionPane.showMessageDialog(null, "No enough Vaccines for supply. Wait for sometime");
                                return;
                            }
                            temp = 1;
                            drug.setAvailability(drug.getAvailability() - p.getOrderedQuantity());
                            break;
                        }

                    }
                    if (temp == 0) {
                        JOptionPane.showMessageDialog(null, "No Stock available. Request from Supplier.");
                        return;
                    }

                    p.setStatus("Complete");
                    JOptionPane.showMessageDialog(null, "You have successfully completed the request");
                    populateWorkQueueTable();
                    populateAvailable();
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please assign first");
            }

        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SupplierWorkRequest p = (SupplierWorkRequest) requestTable.getValueAt(selectedRow, 2);

            p.setStatus("Pending");
            p.setReceiver(account);

            populateWorkQueueTable();

        }
//        SupplierWorkRequest request= new SupplierWorkRequest();
//        request.setVaccine((Vaccine)comboVaccine.getSelectedItem());
//        request.setQuantity(Integer.parseInt(txtquant.getText()));
//        request.setStatus("Requested");
//        request.setSender(account);
//        //organization.getWorkQueue().getWorkRequestList().add(request);
//        s.getWorkQueue().getWorkRequestList().add(request);
//        populateWorkQueueTable();

    }//GEN-LAST:event_reqBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        new SupplierAdminWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SupplierWorkRequest p = (SupplierWorkRequest) requestTable.getValueAt(selectedRow, 2);

            //s.getWorkQueue().getWorkRequestList().remove(p);
            business.getWorkQueue().getWorkRequestList().remove(p);

            JOptionPane.showMessageDialog(null, "You have successfully deleted the request");
            populateWorkQueueTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnComplete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComplete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComplete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnComplete1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reqBtn;
    private javax.swing.JTable requestTable;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JLabel valueLabel1;
    // End of variables declaration//GEN-END:variables

}
