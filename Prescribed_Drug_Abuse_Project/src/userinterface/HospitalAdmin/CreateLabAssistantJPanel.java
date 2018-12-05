/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Role.DoctorRole;
import Business.Role.LabAssistantRole;
import Business.UserAccount.UserAccount;
import Business.Validator;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author urvi
 */
public class CreateLabAssistantJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateLabAssistantJPanel
     */
    private Enterprise enterprise;
    private JPanel userProcessContainer;
    private UserAccount account;
    private LabOrganization organization;
    private EcoSystem business;
    private String filename;
    public CreateLabAssistantJPanel(JPanel userProcessContainer, UserAccount account, LabOrganization organization, EcoSystem business) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = (LabOrganization)organization;
        populateDetails();
        ButtonGroup group = new ButtonGroup();
            group.add(radioFemale);
            group.add(radioMale);
    }
    
    
    public void populateDetails(){
       // txtFName.setText(person.getfName());
       // txtLName.setText(person.getlName());
       LabAssistantRole dr = (LabAssistantRole) account.getRole();
       
       txtFname.setText(dr.getFname());
       txtLname.setText(dr.getLname());
       txtState.setText(dr.getState());
       dateDOB.setDate(dr.getDob());
       txtAddress.setText(dr.getAddress());
       txtCity.setText(dr.getCity());
       txtPhone.setText(dr.getPhone());
       String  gender=dr.getGender();
       if(gender!=null)
       {
       if(gender.equals("FEMALE"))
       {
           radioFemale.setSelected(true);
       }
       else
       {
           radioMale.setSelected(true);
       }
       }
       String path = dr.getImagePath();
       ImageIcon Image = new ImageIcon(path);
        lblPhoto.setIcon(Image);
    }
    
    public ImageIcon ResizeImage(String path){
    ImageIcon myImage=new ImageIcon(path);
    Image img=myImage.getImage();
    Image newImg=img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image=new ImageIcon(newImg);
    return image;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        radioFemale = new javax.swing.JRadioButton();
        radioMale = new javax.swing.JRadioButton();
        txtPhone = new javax.swing.JTextField();
        lblPhoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dateDOB = new com.toedter.calendar.JDateChooser();
        btnUpload = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Create Lab Assistant Record");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/urvi/Desktop/labassistant.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 120));

        jLabel3.setText("First Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel4.setText("Last Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel5.setText("Address:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel6.setText("City:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel7.setText("State:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jLabel8.setText("Gender:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, -1, -1));

        jLabel9.setText("Date of Birth:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 398, -1, -1));
        jPanel1.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 153, -1, -1));

        jLabel11.setText("Phone Number:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 347, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 444, 266, 22));

        jLabel14.setText("PERSONAL DETAILS");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 202, 708, 10));

        txtFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFnameKeyPressed(evt);
            }
        });
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 239, 243, -1));

        txtLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLnameKeyPressed(evt);
            }
        });
        jPanel1.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 286, 241, -1));

        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
        });
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 342, 241, -1));

        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCityKeyPressed(evt);
            }
        });
        jPanel1.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 393, 241, -1));

        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStateKeyPressed(evt);
            }
        });
        jPanel1.add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 239, 204, -1));

        radioFemale.setText("FEMALE");
        jPanel1.add(radioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 287, 94, -1));

        radioMale.setText("MALE");
        jPanel1.add(radioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 287, 84, -1));

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
        });
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 342, 197, -1));

        lblPhoto.setText("UPLOAD PHOTO");
        lblPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 23, 127, 130));

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setText("CREATE LAB ASSISTANT RECORD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setText("<<Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));
        jPanel1.add(dateDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 190, 30));

        btnUpload.setText("Upload Photo");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
     try
     {
     if (txtFname.getText().isEmpty() || txtLname.getText().isEmpty() || txtAddress.getText().isEmpty() || txtCity.getText().isEmpty() || txtState.getText().isEmpty() || txtPhone.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please fill all the data");
     else
     {
     
     LabAssistantRole lr = (LabAssistantRole) account.getRole();
     lr.setFname(txtFname.getText());
     lr.setLname(txtLname.getText());
     lr.setAddress(txtAddress.getText());
     lr.setCity(txtCity.getText());
     lr.setDob(dateDOB.getDate());
     lr.setState(txtState.getText());
     lr.setPhone(txtPhone.getText());
     if(filename!=null)
     lr.setImagePath(filename);
     
//     if (account.getRole().valPhone(txtPhone.getText())) {
//            lr.setPhone(txtPhone.getText());
//        } else {
//            JOptionPane.showMessageDialog(null, "Please enter a valid Phone Number");
//            txtPhone.setText("");
//            return;
//        }
     
     if (radioFemale.isSelected() || radioMale.isSelected()) {
            if (radioFemale.isSelected()) {
                lr.setGender(radioFemale.getText());
            } else if (radioMale.isSelected()) {
                lr.setGender(radioMale.getText());
            }
        } 
     
     else {
            JOptionPane.showMessageDialog(null, "Please select Gender");
        }
     
//     if(account.getEmployee().getFname().equals(fname.getText())){
//         
//     
//         Type.Doctor.getValue();
//     }   
//      DoctorDirectory dd = doctorOrganization.getDoctorDirectory();
//      Doctor dr = dd.createDoctor(fname.getText()); 
//      dr.setSpecialization((String)boxSpc.getSelectedItem());
       JOptionPane.showMessageDialog(null, "your profile is updated");
     }
    }
     
     catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Please enter correect fotmat of input");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        file.showOpenDialog(null);
        File f=file.getSelectedFile();
        filename = f.getAbsolutePath();
        //pathTextField.setText(filename);
        lblPhoto.setIcon(ResizeImage(filename));
    }//GEN-LAST:event_btnUploadActionPerformed

    private void txtFnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFnameKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, txtFname);
    }//GEN-LAST:event_txtFnameKeyPressed

    private void txtLnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLnameKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, txtLname);
    }//GEN-LAST:event_txtLnameKeyPressed

    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, txtAddress);
    }//GEN-LAST:event_txtAddressKeyPressed

    private void txtCityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, txtCity);
    }//GEN-LAST:event_txtCityKeyPressed

    private void txtStateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStateKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, txtState);
    }//GEN-LAST:event_txtStateKeyPressed

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, txtPhone);
    }//GEN-LAST:event_txtPhoneKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpload;
    private com.toedter.calendar.JDateChooser dateDOB;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}