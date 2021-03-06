/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdmin.Lab;

import Business.Validator;
import userinterface.HospitalAdmin.Lab.LabAssistantWorkAreaJPanel;
import Business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    LabTestWorkRequest request;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessWorkRequestJPanel(JPanel userProcessContainer, LabTestWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 169, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Result");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 85, -1, -1));

        resultJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resultJTextFieldKeyPressed(evt);
            }
        });
        add(resultJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 85, 88, -1));

        backJButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 481, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Lab Test Result ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 31, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabAssistantWorkAreaJPanel dwjp = (LabAssistantWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        try{
        if(resultJTextField.getText().isEmpty() ) 
        JOptionPane.showMessageDialog(null,"Please fill all the data");
     else
     {
        request.setTestResult(resultJTextField.getText());
        request.setStatus("Completed");
        JOptionPane.showMessageDialog(null, "Lab Test Result Submitted successfully");
         }
        }
    
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Please enter correect fotmat of input");
        }
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void resultJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resultJTextFieldKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, resultJTextField);
    }//GEN-LAST:event_resultJTextFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
