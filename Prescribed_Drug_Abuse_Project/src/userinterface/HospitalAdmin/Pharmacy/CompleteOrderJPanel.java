/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin.Pharmacy;

import Business.Drug;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.PharmacyOrganization;
import Business.Patient.Addicted;
import Business.Role.PatientRole;
import Business.Role.PharmacyManager;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderMedicinesWorkRequest;
import Business.WorkQueue.PrescriptionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.HospitalAdmin.Patient.PatientWorkAreaJPanel;

/**
 *
 * @author urvi
 */
public class CompleteOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CompleteOrderJPanel
     */
    private JPanel userProcessContainer;
    private OrderMedicinesWorkRequest request;
    private EcoSystem business;
    private PharmacyOrganization organization;
    private UserAccount account;
    //public static int patPoint = 0;
    public static int score = 0;
    public int startorderscore;
    public CompleteOrderJPanel(JPanel userProcessContainer,UserAccount account, OrderMedicinesWorkRequest request, EcoSystem business, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.request = request;
        this.account = account;
        this.organization = (PharmacyOrganization)organization;
         //    populatePrescription();
         populateSelectedPrescription();
        lblOrdered.setText(String.valueOf(request.getOrderedQuantity()));
        populateAddcited();
        //PharmacyManager role =(PharmacyManager) account.getRole();
    }
    
    public void populateAddcited(){
      DefaultTableModel model = (DefaultTableModel)tblDrugCheck.getModel();
      model.setRowCount(0);
      PatientRole p = (PatientRole) request.getSender().getRole();
      for(Addicted ad : p.getAddictedDrugListObject().getListOfAddictedDrugs()){
          Object row[] = new Object[5];
      row[0] = ad.getDrugName();
      row[1] = ad;
      row[2] = ad.getAddictedQuantity();
      row[3] = ad.getOrderscore();
      row[4] = p.getFname();
      model.addRow(row);
      }
      
    }
    public void populateSelectedPrescription(){
      DefaultTableModel model = (DefaultTableModel)tblPresc.getModel();
      model.setRowCount(0);
      Object row[] = new Object[4];
      row[0] = request.getPrescriptionWorkRequest();
      row[1] = request.getPrescriptionWorkRequest().getPrescribedDrugQuantity();
      row[2] = request.getPrescriptionWorkRequest().getSender();
      row[3] = request.getPrescriptionWorkRequest().getReceiver();
      model.addRow(row);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDiscard = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrugCheck = new javax.swing.JTable();
        lblOrdered = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPresc = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Prescription");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        btnDiscard.setBackground(new java.awt.Color(102, 204, 255));
        btnDiscard.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnDiscard.setText("Discard Order");
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });
        add(btnDiscard, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, -1, -1));

        btnComplete.setBackground(new java.awt.Color(102, 204, 255));
        btnComplete.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnComplete.setText("Complete Order");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, -1, -1));

        tblDrugCheck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug", "Addicted Drug", "Addcited Quantity", "Ordered Score", "Addcited Patient"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDrugCheck);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 707, 137));

        lblOrdered.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblOrdered.setText("Ordered Quantity");
        add(lblOrdered, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, 28));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Patient Ordered : ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 30, 170, 30));

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        tblPresc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescribed Drug", "Drug Quantity", "Doctor", "Patient "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPresc.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPresc);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 707, 137));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setText("List of Addicted Drugs of this Patient:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        // TODO add your handling code here:
                                
                                    JOptionPane.showMessageDialog(null, "Order Discarded successfully");
                                    userProcessContainer.remove(this);
                                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                                    layout.previous(userProcessContainer);

                 
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
                        int temp=0;
                           PharmacyManager role =(PharmacyManager) account.getRole();   
                            int prescribed = request.getPrescriptionWorkRequest().getPrescribedDrugQuantity();
                            int ordered = request.getOrderedQuantity();
                            if (prescribed >= ordered) {
                                    //((PharmacyOrganization) organization).setPharmacyPoints(pharmPoint++);

                                    //role.setPharmacyPoints(pharmPoint++);
                                    //OptionPane.showMessageDialog(null, "You are considered Good Pharmacy,Points added");
                                    //if (pharmPoint >= 5) {
                                        //((PharmacyOrganization) organization).setTag("Good");
                                        //role.setTag("Good");
                                        //JOptionPane.showMessageDialog(null, "You are tagged Good Pharmacy");
                                    //}
                                    for (Drug drug : role.getPharmacyDrugList().getListOfDrugs()) {
                                        String check = request.getDrugName();
                                        if ((drug.toString()).equals(check)) {
                                            int avail = drug.getAvailability();
                                            int orderedQuantity = request.getOrderedQuantity();
                                            avail = avail - orderedQuantity;
                                            drug.setAvailability(avail);
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, "Order Completed Successfully");
                                    request.setStatus("Completed");
                            } else if (prescribed < ordered) {
                                    int selected = JOptionPane.showConfirmDialog(null, "Your bad points will be added,Do you still wish to Complete Order?", "Close Message", JOptionPane.YES_NO_OPTION);
                                    if (selected == JOptionPane.YES_OPTION) {
                                       // ((PharmacyOrganization) organization).setPharmacyPoints(pharmPoint--);
                                        role.setPharmacyPoints((role.getPharmacyPoints())+(ordered-prescribed));
                                        System.out.println("Bad Points of Pharmacy "+role.getPharmacyPoints());
                                        JOptionPane.showMessageDialog(null, "You are considered Bad Pharmacy,Points added");
                                        if (role.getPharmacyPoints() >20) {
                                            //((PharmacyOrganization) organization).setTag("Bad");
                                            role.setTag("Bad");
                                            JOptionPane.showMessageDialog(null, "You are tagged a Bad Pharmacy since your points exceeded 20");
                                        }
                                        //add patient addiction points here...
                                        PatientRole patient = (PatientRole) request.getPrescriptionWorkRequest().getReceiver().getRole();
                                        patient.setPatientPoints(patient.getPatientPoints()+(ordered-prescribed));
                                        System.out.println("Addiction Points of Addicted drug of Patient "+patient.getPatientPoints());
                                        if((patient.getPatientPoints())>10)
                                        {
                                            patient.setPatientTag("Addicted");
                                        }
                                        System.out.println("Patient : " +patient+"Patient tag :"+patient.getPatientTag());
                                        //patient.setAddictionDrugScore(score+=1);
                                        //patient.setAddictedDrug(request);
                                        //patient.getDrug().setAddcitionScore(patPoint);
                                        //System.out.println("Addiction Points of Addicted drug of Patient "+patPoint);
                                        
                                        for(Drug drug : business.getDrugCatalog().getListOfDrugs()){
                                            if(drug.getDrug_name().equals(request.getDrugName())){
                                                System.out.println("inside if1");
                                                drug.setOrderedScore((drug.getOrderedScore()+(ordered-prescribed)));
                                                PatientRole pat = (PatientRole) request.getSender().getRole();
                                                for(Addicted add : pat.getAddictedDrugListObject().getListOfAddictedDrugs()){
                                                    System.out.println("for");
                                                    if(add.getDrugName().equals(drug.getDrug_name())){
                                                        temp =1;
                                                        System.out.println("inside if2");
                                                        add.setOrderscore(add.getOrderscore()+1);
                                                        add.setAddictedQuantity(add.getAddictedQuantity()+(ordered-prescribed));
                                                        if(add.getOrderscore()>2){
                                                            System.out.println("inside if3");
                                                            //a.setAddictedQuantity();
                                                            JOptionPane.showMessageDialog(null, "Patient is now addicted to this drug");
                                                            add.setAddictedDrug(request.getDrugName());
                                                           }
                                                    }
                                                    
                                                }
                                                if(temp == 0){
                                                        System.out.println("inside temp=0 if cause new drug name");
                                                        //PatientRole pat = (PatientRole) request.getSender().getRole();
                                                        Addicted a = pat.getAddictedDrugListObject().addAddictedDrug();
                                                        a.setDrugName(request.getDrugName());
                                                        a.setAddictedQuantity((ordered-prescribed));
                                                        a.setOrderscore(startorderscore+1);if(a.getOrderscore()>2) 
                                                        if(a.getOrderscore()>2){
                                                            //a.setAddictedQuantity();
                                                            JOptionPane.showMessageDialog(null, "Patient is now addicted to this drug");
                                                            a.setAddictedDrug(request.getDrugName());
                                                         }
                                            }
                                            }
                                            
                                            populateAddcited();
                                        }
//                                        if(patPoint>20){
//                                            //patient.setAddicted(true);
//                                            System.out.println("Patient is addicted now");
//                                        }
                                        for (Drug drug : role.getPharmacyDrugList().getListOfDrugs()) {
                                            String check = request.getDrugName();
                                            if ((drug.toString()).equals(check)) {
                                                int avail = drug.getAvailability();
                                                int orderedQuantity = request.getOrderedQuantity();
                                                avail = avail - orderedQuantity;
                                                drug.setAvailability(avail);
                                            }
                                        }
                                        JOptionPane.showMessageDialog(null, "Order Completed Successfully");
                                        request.setStatus("Completed");
                                    } else if (selected == JOptionPane.NO_OPTION) {
                                            JOptionPane.showMessageDialog(null, "Order Discarded successfully");
                                            userProcessContainer.remove(this);
                                            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                                            layout.previous(userProcessContainer);
                                        }
                                        //discard button code here
                                }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       userProcessContainer.remove(this);
        Component[] component1=userProcessContainer.getComponents();
        Component component=component1[component1.length - 1];
        CheckOrdersJPanel checkOrdersJPanel=(CheckOrdersJPanel)component;
        checkOrdersJPanel.populateOrders();
        CardLayout cardLayout=(CardLayout)userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblOrdered;
    private javax.swing.JTable tblDrugCheck;
    private javax.swing.JTable tblPresc;
    // End of variables declaration//GEN-END:variables
}
