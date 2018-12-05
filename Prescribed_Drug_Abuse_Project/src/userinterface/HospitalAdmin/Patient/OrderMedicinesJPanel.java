/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin.Patient;

import Business.Drug;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.Role.PharmacyManager;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.Validator;
import javax.swing.JPanel;
import Business.WorkQueue.OrderMedicinesWorkRequest;
import Business.WorkQueue.PrescriptionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author urvi
 */
public class OrderMedicinesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderMedicinesJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private PrescriptionWorkRequest request;
    public static int billCount = 0;
    int total = 0;
    public static int revenue = 0;       
    public OrderMedicinesJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, PrescriptionWorkRequest request) {
        initComponents();
        this.enterprise = enterprise;
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.request = request;
        this.organization = organization;
        //populateDrugsComboBox();
        populateDrugOrders();
        populateDetails();
        populateComboOfPharmacy();
        billCount++;
        
        
    }

    
    public void processOrder(){
        OrderMedicinesWorkRequest orderWorkRequest = new OrderMedicinesWorkRequest();
         orderWorkRequest.setDrugName((request).getPrescribedDrug());
         orderWorkRequest.setOrderedQuantity(Integer.valueOf(txtOrderedQuantity.getText()));
         orderWorkRequest.setSender(account);
         orderWorkRequest.setStatus("Order Placed");
         orderWorkRequest.setPrescriptionWorkRequest(request);
         request.setStatus("order is placed");
         
         txtBillNo.setText(String.valueOf(billCount));
         
         //check if patient is ordering more, assign points to him for trying to get addicted!!
         
        UserAccount ua1=null;
        for(Network n:business.getNetworkList()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof HospitalEnterprise){
                    for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
                        if (organization instanceof PharmacyOrganization){
                            for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                                        if(boxPharmacy.getSelectedItem().toString().equals(ua.getUsername())){
                                            ua1 = ua; 
                                            System.out.println("Sent order to "+ua1.getUsername());
                                    }
                            }
                        }
                    }
                }
            }
        }  
        if (ua1!=null){
            ua1.getWorkQueue().getWorkRequestList().add(orderWorkRequest);
            account.getWorkQueue().getWorkRequestList().add(orderWorkRequest);
        }
        
        
        total += (Integer.valueOf(txtPrice.getText())* (Integer.valueOf(txtOrderedQuantity.getText())));
        populateDrugOrders();
        txtTotal.setText(String.valueOf(total));
        PharmacyManager role = (PharmacyManager) ua1.getRole();
        //if(request.getStatus().equals("Completed")){
                role.setRevenue(role.getRevenue() + total);
                System.out.println("Revenue is:"+role.getRevenue());
        //}

        
        JOptionPane.showMessageDialog(null, "Order Placed");
        //PharmacyManager role = (PharmacyManager) account.getRole();
               //((PharmacyOrganization) organization).setRevenue(revenue);
               //role.setRevenue(revenue);
    }
    public void populateDetails(){
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        
        for(Drug dc : business.getDrugCatalog().getListOfDrugs()){
            if((request).getPrescribedDrug().equals(String.valueOf(dc))){
                String date = df.format(dc.getExpiryDate());
                txtDrug.setText((request).getPrescribedDrug());
                txtExpiry.setText(date);
                txtPrice.setText(String.valueOf(dc.getPrice()));
                txtPrescibedQuantity.setText(String.valueOf(request.getPrescribedDrugQuantity()));
            }
        }
    }
    
    public void populateComboOfPharmacy(){
        boxPharmacy.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization instanceof PharmacyOrganization){
                for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                    Role role= ua.getRole();
                    if(role instanceof PharmacyManager){
                        //String tag = (String)((PharmacyManager) role).getTag();
                        boxPharmacy.addItem(ua);
                    }
                }
            }
        }
    }
    
    public void populateDrugOrders(){
        DefaultTableModel model = (DefaultTableModel) tblOrderedDrugs.getModel();
        
        model.setRowCount(0);
                DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                for (WorkRequest orderRequest : account.getWorkQueue().getWorkRequestList()){
                     if(orderRequest instanceof OrderMedicinesWorkRequest)
                        {
                            for(Drug drug : business.getDrugCatalog().getListOfDrugs()){
                                if((((OrderMedicinesWorkRequest) orderRequest).getDrugName().equals(drug.getDrug_name()))){
                                    System.out.println("inside if ");
                                    Object[] row = new Object[6];
                                    row[0] = ((OrderMedicinesWorkRequest) orderRequest).getDrugName();
                                    row[1] = ((OrderMedicinesWorkRequest) orderRequest).getOrderedQuantity();
                                    String date = df.format(drug.getExpiryDate());
                                    row[2] = date;
                                    row[3] = drug.getPrice();
                                    row[4] = orderRequest.getReceiver();
                                    row[5] = orderRequest.getStatus();
                                    model.addRow(row);
                    }
                }
            
        }
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

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOrderedQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtExpiry = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderedDrugs = new javax.swing.JTable();
        txtBillNo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtDrug = new javax.swing.JTextField();
        boxPharmacy = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtPrescibedQuantity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(102, 204, 255));
        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 574, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Drug  Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Quantity Prescribed");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 114, -1, -1));

        txtOrderedQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderedQuantityActionPerformed(evt);
            }
        });
        txtOrderedQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOrderedQuantityKeyPressed(evt);
            }
        });
        add(txtOrderedQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 120, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("Expiry Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 160, -1, -1));

        txtExpiry.setEnabled(false);
        add(txtExpiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 151, 117, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel5.setText("MRP.");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 120, -1, -1));

        txtPrice.setEnabled(false);
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 108, 120, -1));

        tblOrderedDrugs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Quantity Ordered", "Expiry Date", "Price", "Receiver", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrderedDrugs);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 331, 698, 153));

        txtBillNo.setEnabled(false);
        add(txtBillNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 26, 85, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Bill No:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 496, 129, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel8.setText("Total Amount:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 496, -1, -1));

        btnRemove.setBackground(new java.awt.Color(102, 204, 255));
        btnRemove.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnRemove.setText("Remove Item");
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 496, -1, -1));

        btnPlaceOrder.setBackground(new java.awt.Color(102, 204, 255));
        btnPlaceOrder.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });
        add(btnPlaceOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 228, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel9.setText("Ordered Medicines");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 302, -1, -1));
        add(txtDrug, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 120, -1));

        boxPharmacy.setSelectedItem(null);
        boxPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPharmacyActionPerformed(evt);
            }
        });
        add(boxPharmacy, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 161, 120, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setText("Select Pharmacy");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 164, -1, -1));

        txtPrescibedQuantity.setEnabled(false);
        add(txtPrescibedQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 117, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel10.setText("Enter the quantity you want to order");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 74, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        // TODO add your handling code here: 
        if((Integer.parseInt(txtOrderedQuantity.getText()))> request.getPrescribedDrugQuantity()){
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are attempting to order more quantity than prescribed,Do you still wish to place your Order?", "Close Message", JOptionPane.YES_NO_OPTION);
            if(showConfirmDialog == JOptionPane.YES_OPTION){
                processOrder();
            }
            if(showConfirmDialog == JOptionPane.NO_OPTION){
                userProcessContainer.remove(this);
            Component[] component1=userProcessContainer.getComponents();
            Component component=component1[component1.length - 1];
            PatientWorkAreaJPanel patientWorkAreaJPanel=(PatientWorkAreaJPanel)component;
            patientWorkAreaJPanel.populatePrescriptions();
            patientWorkAreaJPanel.populateAppointment();
            CardLayout cardLayout=(CardLayout)userProcessContainer.getLayout();
            cardLayout.previous(userProcessContainer);
            }
        }
        else{
            processOrder();
        }
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] component1=userProcessContainer.getComponents();
        Component component=component1[component1.length - 1];
        PatientWorkAreaJPanel patientWorkAreaJPanel=(PatientWorkAreaJPanel)component;
        patientWorkAreaJPanel.populatePrescriptions();
        patientWorkAreaJPanel.populateAppointment();
        CardLayout cardLayout=(CardLayout)userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void boxPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPharmacyActionPerformed
        // TODO add your handling code here:
//        if(boxPharmacy.getSelectedItem().equals("Select")){
//            JOptionPane.showMessageDialog(null, "Please select a pharmacy to send order");
//        }
//        else{
       try{
        if(txtOrderedQuantity.getText().isEmpty() ) 
        JOptionPane.showMessageDialog(null,"Please fill all the data");
     else
     {

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization instanceof PharmacyOrganization){
                for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                    Role role= ua.getRole();
                    if(role instanceof PharmacyManager){
                        UserAccount user = (UserAccount) boxPharmacy.getSelectedItem();
                        //System.out.println("User mila "+user.getUsername());
                        PharmacyManager roll = (PharmacyManager) user.getRole();
                        //System.out.println("role" +roll);
                        //String tag = (String)((PharmacyManager) role).getTag();
                        if(roll.getTag().toString().equals("Bad") && roll.getTag() != null){
                            boxPharmacy.setBackground(Color.red);
                        }
                        else if(roll.getTag().toString().equals("Good") && roll.getTag() != null){
                            boxPharmacy.setBackground(Color.green);
                        }
                        else if(roll.getTag() == null){
                            boxPharmacy.setBackground(Color.white);
                        }
                    }
                }
            }
        }
        //}
         }
        }
    
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Please enter correect fotmat of input");
        }
    }//GEN-LAST:event_boxPharmacyActionPerformed

    private void txtOrderedQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderedQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderedQuantityActionPerformed

    private void txtOrderedQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderedQuantityKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, txtOrderedQuantity);
    }//GEN-LAST:event_txtOrderedQuantityKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> boxPharmacy;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrderedDrugs;
    private javax.swing.JTextField txtBillNo;
    private javax.swing.JTextField txtDrug;
    private javax.swing.JTextField txtExpiry;
    private javax.swing.JTextField txtOrderedQuantity;
    private javax.swing.JTextField txtPrescibedQuantity;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
