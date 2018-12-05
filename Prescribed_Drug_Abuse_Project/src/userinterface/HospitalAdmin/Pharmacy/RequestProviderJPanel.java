/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin.Pharmacy;

import Business.Drug;
import Business.EcoSystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.SupplierOrganization;
import Business.Role.PharmacyManager;
import Business.Role.Role;
import Business.Role.SupplierRole;
import Business.UserAccount.UserAccount;
import Business.Validator;
import Business.WorkQueue.OrderMedicinesWorkRequest;
import Business.WorkQueue.SupplierWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author urvi
 */
public class RequestProviderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestProviderJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount account;
    private PharmacyOrganization organization;
    public int temp;
    public RequestProviderJPanel(JPanel userProcessConatainer, Enterprise enterprise, EcoSystem business, UserAccount account, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessConatainer;
        this.enterprise = enterprise;
        this.business = business;
        this.account = account;
        this.organization = (PharmacyOrganization)organization;
        populateQuantity();
        populateVaccinesRequests();
        populateVaccinesComboBox();
        populateVaccinesAvailable();
        populateSuppCombo();
        
    }

    public void populateSuppCombo(){
        UserAccount us = null;
        for (Network net : business.getNetworkList()) {
            //System.out.println(net);
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                //System.out.println(ent);
                if (ent instanceof DistributorEnterprise) {
                    // System.out.println(ent);  
                    for (Organization organ : ent.getOrganizationDirectory().getOrganizationList()) {

                        if (organ instanceof SupplierOrganization) {
                            for (UserAccount user : organ.getUserAccountDirectory().getUserAccountList()) {
                                boxSupp.addItem(user);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void populateVaccinesComboBox(){
        for(Drug drug : business.getDrugCatalog().getListOfDrugs()){
            comboVaccine.addItem(drug);
        }
    }
    public void populateVaccinesAvailable(){
        DefaultTableModel model = (DefaultTableModel)availableTable.getModel();
        model.setRowCount(0);
         //System.out.println("pharmacy"+ p.getVaccine().getVaccineList().size());
        PharmacyManager role = (PharmacyManager)account.getRole();
        for (Drug drug : role.getPharmacyDrugList().getListOfDrugs()){
            Object[] row = new Object[2];
            row[0] = drug;
            row[1] = drug.getAvailability();
            model.addRow(row);
        }
    }
    
    public void populateVaccinesRequests(){
        DefaultTableModel model = (DefaultTableModel)requestTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            
            if(request instanceof SupplierWorkRequest)
            {
            Object[] row = new Object[4];
            row[0] = ((SupplierWorkRequest) request).getDrugName();
            row[1] = ((SupplierWorkRequest) request).getOrderedQuantity();
            row[3] = request.getReceiver();
            row[2] = request;
            
            model.addRow(row);
            }
        }
    }
    
    public void populateQuantity(){
        PharmacyManager role = (PharmacyManager) account.getRole();
        for (WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()) {
            //System.out.println("inside for1");
            int temp=0;
            // HashMap<WorkRequest,Integer> map = new HashMap<WorkRequest,Integer>();
            if (workRequest instanceof SupplierWorkRequest) {
                if (workRequest.getStatus().equals("Complete") && !((SupplierWorkRequest) workRequest).isAdd()) {
                    //System.out.println("inside if1");
                    String drug = ((SupplierWorkRequest) workRequest).getDrugName();//drug ordered name..
                    for(Drug d : role.getPharmacyDrugList().getListOfDrugs()) {
                        //System.out.println("inside for2");
                        if(drug.equals(d.getDrug_name())){
                            //System.out.println("inside if4");
                            temp = 1;
                            d.setAvailability(((SupplierWorkRequest) workRequest).getOrderedQuantity() + d.getAvailability());
                        }
                    }
                    if (temp == 0) {
                        //System.out.println("inside if2");
                        Drug dru = new Drug();
                        //System.out.println(role.getPharmacyDrugList().getListOfDrugs().size());
                        dru = role.getPharmacyDrugList().addDrug();
                        //System.out.println(role.getPharmacyDrugList());
                        
                       dru.setDrug_name(drug);
                       dru.setAvailability(((SupplierWorkRequest) workRequest).getOrderedQuantity());
                    }
                    
                    //}
                    ((SupplierWorkRequest) workRequest).setAdd(true);
                    //}
                }
            }
            populateVaccinesAvailable();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reqBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        comboVaccine = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        boxSupp = new javax.swing.JComboBox<>();
        txtquant = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reqBtn.setBackground(new java.awt.Color(102, 204, 255));
        reqBtn.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        reqBtn.setText("Request Vaccine");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, 170, -1));

        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(availableTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 500, 120));

        jLabel4.setFont(new java.awt.Font("Al Bayan", 1, 14)); // NOI18N
        jLabel4.setText("Vaccines Requested");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 170, 30));

        jLabel5.setFont(new java.awt.Font("Al Bayan", 1, 14)); // NOI18N
        jLabel5.setText("Vaccines Available");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 60));

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Quantity", "Status", "Receiver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 500, 120));

        add(comboVaccine, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 120, -1));

        jLabel2.setFont(new java.awt.Font("Al Bayan", 1, 14)); // NOI18N
        jLabel2.setText("Vaccine Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 110, 30));

        add(boxSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 110, -1));

        txtquant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtquantKeyPressed(evt);
            }
        });
        add(txtquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 90, -1));

        btnBack.setBackground(new java.awt.Color(102, 204, 255));
        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed
       
        try{
        if(txtquant.getText().isEmpty() ) 
        JOptionPane.showMessageDialog(null,"Please fill all the data");
     else
     {
        
        SupplierWorkRequest supplierWorkRequest = new SupplierWorkRequest();
        supplierWorkRequest.setDrugName(comboVaccine.getSelectedItem().toString());
        supplierWorkRequest.setOrderedQuantity(Integer.valueOf(txtquant.getText()));
        supplierWorkRequest.setSender(account);
        supplierWorkRequest.setStatus("Order Placed");
        supplierWorkRequest.setSupp((UserAccount)boxSupp.getSelectedItem());

        UserAccount us = null;
        for (Network net : business.getNetworkList()) {
            //System.out.println(net);
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                //System.out.println(ent);
                if (ent instanceof DistributorEnterprise) {
                    // System.out.println(ent);  
                    for (Organization organ : ent.getOrganizationDirectory().getOrganizationList()) {

                        if (organ instanceof SupplierOrganization) {
                            for (UserAccount user : organ.getUserAccountDirectory().getUserAccountList()) {
                                if(boxSupp.getSelectedItem()!=null){
                                if (user.equals(boxSupp.getSelectedItem())) {
                                    us = user;
                                }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (us != null) {
            us.getWorkQueue().getWorkRequestList().add(supplierWorkRequest);
            account.getWorkQueue().getWorkRequestList().add(supplierWorkRequest);
        }
        JOptionPane.showMessageDialog(null, "Drugs Requested from Supplier Successfully");
        txtquant.setText("");
        populateVaccinesRequests();
        //populateVaccinesComboBox();
        populateQuantity();
         }
        }
    
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Please enter correect fotmat of input");
        }
    }//GEN-LAST:event_reqBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout=(CardLayout)userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtquantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, txtquant);
    }//GEN-LAST:event_txtquantKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableTable;
    private javax.swing.JComboBox<Object> boxSupp;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox comboVaccine;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reqBtn;
    private javax.swing.JTable requestTable;
    private javax.swing.JTextField txtquant;
    // End of variables declaration//GEN-END:variables
}
