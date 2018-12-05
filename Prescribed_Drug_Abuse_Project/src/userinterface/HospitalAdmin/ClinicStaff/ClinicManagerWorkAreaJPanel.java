/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin.ClinicStaff;

import Business.Drug;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.CityWelfareEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.RehabOrganization;
import Business.Patient.Addicted;
import Business.Role.DoctorRole;
import Business.Role.PatientRole;
import Business.Role.RehabManager;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.Validator;
import Business.WorkQueue.PrescriptionWorkRequest;
import Business.WorkQueue.RehabWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author urvi
 */
public class ClinicManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ClinicManagerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
private ClinicOrganization clinicOrganization;
private Enterprise enterprise;
private UserAccount userAccount;
private UserAccount account;
private  EcoSystem  business; 
    

    public ClinicManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ClinicOrganization clinicOrganization, Enterprise enterprise,EcoSystem  business) {
       initComponents();
       this.userProcessContainer = userProcessContainer;
        this.clinicOrganization = clinicOrganization;
        this.enterprise = enterprise;
        this.account = account;
        this.business=business;
        populateTableDoc();
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof PatientOrganization) {
                for (UserAccount us : org.getUserAccountDirectory().getUserAccountList()) {
                    if (us.getRole() instanceof PatientRole) {
                        PatientRole role = (PatientRole) us.getRole();
                        System.out.println(((PatientRole) role).getFname());
                        populateAddicted((PatientRole)role,us);
                    }
                }
            }
        }
        populateTablePat();
        jPanel3.setVisible(false);
        populateComboRehab();
        populateRequestTable();
        
    }
    
    public void populateAddicted(PatientRole p,UserAccount u){
      DefaultTableModel model = (DefaultTableModel)tblDrugCheck.getModel();
      //model.setRowCount(0);
      
      for(Addicted ad : p.getAddictedDrugListObject().getListOfAddictedDrugs()){
                  Object row[] = new Object[8];
                  row[0] = ad.getDrugName();
                  row[1] = ad;
                  row[2] = ad.getAddictedQuantity();
                  row[3] = ad.getOrderscore();
                  row[4] = p.getFname();
                  row[5] = p.getPatientPoints();
                  row[6] = u;
                  for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
                    if(request instanceof RehabWorkRequest){
                        //System.out.println(((RehabWorkRequest) request).getDrug());
                        //system.out.println(ad.getDrugName());
                        if(((RehabWorkRequest) request).getDrug()!=null){
                            //System.out.println(((RehabWorkRequest) request).getDrug());
                        if(((RehabWorkRequest)request).getDrug().equals(ad.getDrugName()) && (u.equals(request.getSender()))){
                            row[7]=((RehabWorkRequest)request).getStatus();
                        }
                        }
                    }
                  }
                  model.addRow(row);
            }
    }
    
    public void populateComboRehab(){
        rehabBox.removeAllItems();
        for(Network net : business.getNetworkList()){
            for(Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()){
                if(ent instanceof CityWelfareEnterprise){
                    for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                        if(organization instanceof RehabOrganization){
                            for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                                Role role= ua.getRole();
                                if(role instanceof RehabManager){
                                    rehabBox.addItem(ua);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void populateTableDoc(){
        DefaultTableModel model = (DefaultTableModel) tblDoctor.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization instanceof DoctorOrganization){
               // for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
                for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                    Role role = ua.getRole();
                    if(role instanceof DoctorRole){
                    Object[] row = new Object[3];
                    row[0] = ua.getEmployee().getId();
                    row[1] = ua.getEmployee().getFname();
                    row[2] = ((DoctorRole) role).getSpecialization();
                    model.addRow(row);
                }
            }
        }
    }
    }
    
    private void populateTablePat(){
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        
        model.setRowCount(0);
       // for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization instanceof PatientOrganization){
                for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                    Role role = ua.getRole();
                    if(role instanceof PatientRole){
                    Object[] row = new Object[4];
                    row[0] =ua.getEmployee().getFname();
                    row[1] = ((PatientRole)role).getPatientTag();
                    for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
                    if(request instanceof RehabWorkRequest){
                        if(ua.equals(request.getSender())){
                            row[2]=((RehabWorkRequest)request).getStatus();
                            row[3]=request.getReceiver();
                        }
                    }
                    }
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

        jScrollPane4 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rehabBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        RehabSendingTable = new javax.swing.JTable();
        rehab = new javax.swing.JButton();
        msgTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDrugCheck = new javax.swing.JTable();
        btnRehabVisible = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoctor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        BarChartPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("List of Affected Patients");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 40, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("Select Rehabilitation center");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 45, -1, -1));

        jPanel3.add(rehabBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 45, 405, -1));

        RehabSendingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Center Name", "Request Status", "Sender", "Receiver", "drug"
            }
        ));
        jScrollPane3.setViewportView(RehabSendingTable);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 157, 708, 98));

        rehab.setBackground(new java.awt.Color(102, 204, 255));
        rehab.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        rehab.setText("Send Patient Rehab Request");
        rehab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehabActionPerformed(evt);
            }
        });
        jPanel3.add(rehab, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 100, -1, -1));

        msgTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msgTextFieldKeyPressed(evt);
            }
        });
        jPanel3.add(msgTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 7, 92, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setText("Message: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 11, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 320, 740, 270));

        tblDrugCheck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug", "Addicted Drug", "Addcited Quantity", "Ordered Score", "Addcited Patient", "Patient Score", "User Name", "Treatment status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblDrugCheck);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 770, 160));

        btnRehabVisible.setBackground(new java.awt.Color(102, 204, 255));
        btnRehabVisible.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnRehabVisible.setText("Send to Rehab");
        btnRehabVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRehabVisibleActionPerformed(evt);
            }
        });
        jPanel1.add(btnRehabVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        jTabbedPane1.addTab("Addicted Patient List", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Doctor Name", "Specialization"
            }
        ));
        jScrollPane2.setViewportView(tblDoctor);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 138, 631, 99));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setText("List of Doctors in the Hospital >>");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, -1, -1));

        jTabbedPane1.addTab("Doctors", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient Name", "Patient Tag ", "Treatment Status", "Rehab Center"
            }
        ));
        jScrollPane6.setViewportView(patientTable);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 81, 712, 103));

        jButton1.setText("View Bar Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 210, -1, -1));

        BarChartPanel.setBackground(new java.awt.Color(102, 204, 255));
        BarChartPanel.setLayout(new java.awt.BorderLayout());
        jPanel4.add(BarChartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 266, 809, 354));

        jTabbedPane1.addTab("Patient", jPanel4);

        jScrollPane4.setViewportView(jTabbedPane1);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Clinic Staff Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rehabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehabActionPerformed
try{
        if(msgTextField.getText().isEmpty() ) 
        JOptionPane.showMessageDialog(null,"Please fill all the data");
     else
     {        // TODO add your handling code here:
        
        String msg = msgTextField.getText();
        int selectedRow = tblDrugCheck.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        

        UserAccount act= (UserAccount)tblDrugCheck.getValueAt(selectedRow,6);
        //System.out.println(act);
        //String status = (String) tblDrugCheck.getValueAt(selectedRow,7);
       
        UserAccount reahbacc =null;
        RehabWorkRequest request = new RehabWorkRequest();
        request.setPatientTag(msg);
        request.setSender(act);
        request.setStatus("send to rehab");
        Addicted add=(Addicted) tblDrugCheck.getValueAt(selectedRow,1);
        String ty=add.getAddictedDrug();
        System.out.println(add);
       PatientRole pr = (PatientRole) act.getRole();
       
       for(Addicted ad : pr.getAddictedDrugListObject().getListOfAddictedDrugs())
       {
           System.out.println(ad.getAddictedDrug());
           if(ty != null){
           if(ty.equals(ad.getAddictedDrug()))
           {
               request.setDrug(ad.getAddictedDrug());
           } 
           }
       }
        
        
        for(Network net : business.getNetworkList()){
            for(Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()){
                if(ent instanceof CityWelfareEnterprise){
                    for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                        if(organization instanceof RehabOrganization){
                            for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                                Role role= ua.getRole();
                                if(role instanceof RehabManager){
                                   ua= (UserAccount) rehabBox.getSelectedItem();
                                   reahbacc=ua;
                                }
                            }
                        }
                    }
                }
            }
        }
    
        
       
        if (reahbacc!=null){
            //System.out.println(org);
            request.setReceiver(reahbacc);
            reahbacc.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
                 JOptionPane.showMessageDialog(null, "Patient is send to Rehab");
                 populateRequestTable();
                 
               
                 
        }
        }
    
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Please enter correect fotmat of input");
        }
        
    }//GEN-LAST:event_rehabActionPerformed

    private void btnRehabVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRehabVisibleActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDrugCheck.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a patient to send to rehab");
            return;
        }else{
        String status = (String)tblDrugCheck.getValueAt(selectedRow,7);
        System.out.println(status);
        if(status!=null)
        {
        if(status.equals("send to rehab") || status.equals("Treated"))
        {
            JOptionPane.showMessageDialog(null, "Patient is already "+status);
        }
        }
        else 
        {
        jPanel3.setVisible(true);
        JOptionPane.showMessageDialog(null, "Choose rehab to send");
        }
        }
        
       
    }//GEN-LAST:event_btnRehabVisibleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        //        //barchartdata.setValue(WIDTH, WIDTH, PROPERTIES);
        //        barchartdata.setValue(20000,”Contribution Amount”,”JANUARY”);
        //        barchartdata.setValue(15000,”Contribution Amount”,”FEBRUARY”);
        //        barchartdata.setValue(30000,”Contribution Amount”,”MARCH”);
        //
        //        JFreeChart barChart = ChartFactory.createBarChart('Church Contributions', 'Monthly', 'Contribution Amount', barchartdata, PlotOrientation.HORIZONTAL, false, true, false);
        //        //JFreeChart barChart = ChartFactory.createBarChart(“Church Contributions”, “Monthly”, “Contribution Amount”,  barchartdata, PlotOrientation.VERTICAL,false, true, false);
        //        CategoryPlot barchrt = barChart.getCategoryPlot();
        //        barchrt.setRangeGridlinePaint(Color.orange);
        //
        //        ChartPanel barPanel = new ChartPanel(barChart);
        //        panelChart.removeAll();
        //        panelChart.add(barPanel,BorderLayout.CENTER);
        //        panelChart.validate();
//        BarChartPanel.setVisible(true);
//
//        for(Drug dr: business.getDrugCatalog().getListOfDrugs()){
//            int count = 0;
//            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
//                if (org instanceof PatientOrganization) {
//                    for (UserAccount us : org.getUserAccountDirectory().getUserAccountList()) {
//                        if (us.getRole() instanceof PatientRole) {
//                            PatientRole role = (PatientRole) us.getRole();
//                            for (Addicted ad : ((PatientRole) role).getAddictedDrugListObject().getListOfAddictedDrugs()) {
//                                if(ad.getAddictedDrug()!=null && dr.getDrug_name().equals(ad.getAddictedDrug())){
//                                    drug = dr.getDrug_name();
//                                    count++;
//                                    barchartdata.setValue(count, "No. of Patients Addicted", drug);
//                                    System.out.println("Count "+count+" Drug "+drug);
//                                }
//                            }
//
//                        }
//                    }
//                }
//            }//break;
//        }
//        JFreeChart chart = ChartFactory.createBarChart("Patients Addicted Drug Analysis","Drugs","No. of Patients Addicted", barchartdata, PlotOrientation.VERTICAL, false, false, false);
//        CategoryPlot catplot = chart.getCategoryPlot();
//        catplot.setRangeGridlinePaint(Color.ORANGE);
//        ChartPanel chartpanel = new ChartPanel(chart);
//        BarChartPanel.removeAll();
//        BarChartPanel.add(chartpanel, BorderLayout.CENTER);
//        BarChartPanel.validate();
            DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
            
//            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
//                if(organization instanceof PatientOrganization){
//                    for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
//                        if(request instanceof RehabWorkRequest){
//                        for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
//                                int count=0;
//                                String name = null;   
//                                if(request.getStatus().equals("Treated")){
//                                System.out.println("I am here");
//                                count++;
//                                name = request.getReceiver().getUsername(); 
//                                barchartdata.setValue(count, "No. of Patients Treated", name);
//                                System.out.println("Rehab : "+name+" ,Treated: "+count);
//                        
//                                }
//                    
//                    }
//                }
//            }
//        }
//           for(Network net : business.getNetworkList()){
//           for(Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()){
//           for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
//               if(org instanceof RehabOrganization){
//                   for(UserAccount us : org.getUserAccountDirectory().getUserAccountList()){
//                       if(us.getRole() instanceof RehabManager){
//                           int count=0;
//                           System.out.println(us);
//                            //RehabManager role = (RehabManager) us.getRole();
//                            for(WorkRequest req: us.getWorkQueue().getWorkRequestList()){
//                                if(req instanceof RehabWorkRequest){
//                                    if(req.getStatus().equals("Treated")){
//                                        count++;
//                                        barchartdata.setValue(count, "No. of Patients Treated", us.getUsername());
//                                        System.out.println("Rehab : "+us.getUsername()+" ,Treated: "+count);
//                                    }
//                                }
//                            }
//                       }
//                   }
//               }
//           }
//           }
//           }
           
           UserAccount user = null;
           for(Network net : business.getNetworkList()){
            for(Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()){
                if(ent instanceof CityWelfareEnterprise){
                    for(Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                        if(organization instanceof RehabOrganization){
                            for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()){
                               if(ua.getRole() instanceof RehabManager){
                                   user=ua;
                                   int count=0;
                                   for(WorkRequest req : user.getWorkQueue().getWorkRequestList()){
                                       if(req instanceof RehabWorkRequest){
                                        if(req.getStatus().equals("Treated")){
                                            count++;
                                            
                                        }
                                        System.out.println("Rehab : "+user+" ,Treated: "+count);
                                        barchartdata.setValue(count, "No. of Patients Treated",user.getUsername());
                                       
                                       } 
                                   }
                               }
                            }
                        }
                    }
                }
            }
        }
        JFreeChart chart = ChartFactory.createBarChart("Patients Treated Analysis","Rehab Centers","No. of Patients Treated", barchartdata, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catplot = chart.getCategoryPlot();
        catplot.setRangeGridlinePaint(Color.YELLOW);
        ChartPanel chartpanel = new ChartPanel(chart);
        BarChartPanel.removeAll();
        BarChartPanel.add(chartpanel, BorderLayout.CENTER);
        BarChartPanel.validate();
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void msgTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msgTextFieldKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, msgTextField);
    }//GEN-LAST:event_msgTextFieldKeyPressed

    public void populateRequestTable(){
        
        DefaultTableModel model = (DefaultTableModel)RehabSendingTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if(request instanceof RehabWorkRequest){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getSender();
            row[3] = ((RehabWorkRequest) request).getPatientTag();
            String result = ((RehabWorkRequest) request).getTestResult();
            row[4] = result == null ? "Waiting" : result;
            row[5] = ((RehabWorkRequest) request).getDrug();
            
            model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarChartPanel;
    private javax.swing.JTable RehabSendingTable;
    private javax.swing.JButton btnRehabVisible;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField msgTextField;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton rehab;
    private javax.swing.JComboBox<Object> rehabBox;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JTable tblDrugCheck;
    // End of variables declaration//GEN-END:variables
}
