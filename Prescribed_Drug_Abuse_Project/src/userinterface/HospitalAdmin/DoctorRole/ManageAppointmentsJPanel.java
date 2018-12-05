/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Role.DoctorRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.security.auth.login.AccountException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageAppointmentsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    public Date date;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public ManageAppointmentsJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization,Enterprise enterprise, EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
       this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;
        valueLabel.setText(enterprise.getName());
        populateRequestTable();
        populatePendingAppointments();
    }

   public void populatePendingAppointments(){
       DefaultTableModel model = (DefaultTableModel) tblPendingApt.getModel();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            if(request instanceof AppointmentWorkRequest){
                if(!request.getStatus().equals("Diagnosed")){
                    Object[] row = new Object[5];
                    row[0] = request;
                    row[1] = request.getReceiver();
                    row[2] = request.getSender();
                    String input = df.format(((AppointmentWorkRequest) request).getAppointmentDate());
                    date = ((AppointmentWorkRequest) request).getAppointmentDate();
                    row[3] = input == null ? "Waiting" : input;
                    row[4]=((AppointmentWorkRequest) request).getAppointmentTime();
                    model.addRow(row);
                
                }
            }
        }
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            if(request instanceof LabTestWorkRequest){
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getSender();
            String result = ((LabTestWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            row[4] = ((LabTestWorkRequest) request).getTestPatient();
            
            model.addRow(row);
            }
        }
    }
    
    public void populateUpcomingSchedule(){
       DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
       String viewAptDate =  df.format(dateChooseApt.getDate());
       
        DefaultTableModel model = (DefaultTableModel) tblUpcomming.getModel();
        model.setRowCount(0);
        DoctorRole role = (DoctorRole) userAccount.getRole();
           for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
               if (request instanceof AppointmentWorkRequest) {
                   if(!request.getStatus().equals("Diagnosed")){
                    date = ((AppointmentWorkRequest) request).getAppointmentDate();
                        String aptd = df.format(date);
                        if(viewAptDate.equals(aptd))
                        {
                        Object[] row = new Object[2];
                        row[0] = request.getSender();
                        String date = df.format(((AppointmentWorkRequest) request).getAppointmentDate());
                        row[1] = date;
                       //row[1] = aptd == null ? "Waiting" : aptd;

                       model.addRow(row);
                  // }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPendingApt = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnbook = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUpcomming = new javax.swing.JTable();
        diagnose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dateChooseApt = new com.toedter.calendar.JDateChooser();
        btnUpcomin = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result", "Patient "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 480, 120));

        refreshTestJButton.setBackground(new java.awt.Color(102, 204, 255));
        refreshTestJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 170, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 127, 30));

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 158, 26));

        tblPendingApt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Status", "Doctor", "Patient", "Apt Date", "Apt Time"
            }
        ));
        jScrollPane3.setViewportView(tblPendingApt);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 480, 120));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Pending Appointments List ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        btnbook.setBackground(new java.awt.Color(102, 204, 255));
        btnbook.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnbook.setText("Book Appointment");
        btnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbookActionPerformed(evt);
            }
        });
        add(btnbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 162, 170, -1));

        tblUpcomming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Pateint Name", "Date"
            }
        ));
        jScrollPane4.setViewportView(tblUpcomming);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 480, 110));

        diagnose.setBackground(new java.awt.Color(102, 204, 255));
        diagnose.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        diagnose.setText("Diagnose>>");
        diagnose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnoseActionPerformed(evt);
            }
        });
        add(diagnose, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 343, 170, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Lab Test Rquests>>");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));
        add(dateChooseApt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 176, -1));

        btnUpcomin.setBackground(new java.awt.Color(102, 204, 255));
        btnUpcomin.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnUpcomin.setText("Click to see Upcomming Schedule");
        btnUpcomin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpcominActionPerformed(evt);
            }
        });
        add(btnUpcomin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        btnback.setText("<<Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void diagnoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnoseActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblUpcomming.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a patient to diagnose from Upcoming Appointments List");
            return;
        }
        else{
        

        UserAccount act= (UserAccount) tblUpcomming.getValueAt(selectedRow,0);
        DiagnosePatientsJPanel diagnosePatientsJPanel = new DiagnosePatientsJPanel(userProcessContainer,act,userAccount,organization,enterprise,business);
        userProcessContainer.add("diagnosePatientsJPanel", diagnosePatientsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
        }
    }//GEN-LAST:event_diagnoseActionPerformed

    private void btnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbookActionPerformed
        // TODO add your handling code here:
        //request.setTestResult(resultJTextField.getText());
        int selectedRow = tblPendingApt.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        AppointmentWorkRequest request = (AppointmentWorkRequest) tblPendingApt.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Booked");
        populatePendingAppointments();
    }//GEN-LAST:event_btnbookActionPerformed

    private void btnUpcominActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpcominActionPerformed
        // TODO add your handling code here:
        if(dateChooseApt.getDate() == null){
            JOptionPane.showMessageDialog(null,"Please select a Date to view Upcoming Appointments");
        }
        else{
           populateUpcomingSchedule(); 
        }
        
    }//GEN-LAST:event_btnUpcominActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpcomin;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnbook;
    private com.toedter.calendar.JDateChooser dateChooseApt;
    private javax.swing.JButton diagnose;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JTable tblPendingApt;
    private javax.swing.JTable tblUpcomming;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
