/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Drug;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Addicted;
import Business.Patient.AddictedDrugList;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentWorkRequest;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import userinterface.HospitalAdmin.Lab.LabAssistantWorkAreaJPanel;
import userinterface.HospitalAdmin.Patient.PatientWorkAreaJPanel;

/**
 *
 * @author urvi
 */
public class PatientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PatientWorkAreaJPanel(userProcessContainer, account, organization,enterprise, business);
    }
    
    private String fname;
    private String lname;
    private Date dob;
    private String state;
    private String address;
    private String phone;
    private String city;
    private String gender;
    private String rehab;
    private String previousAddictedDrug;
    private AddictedDrugList addictedDrugListObject;
    private Drug addictedDrug;
    private String addicted;
    private int patientPoints;
    private String patientTag;
    //private ArrayList<Addicted> listOfAddicted;
    
    public PatientRole(){
        //listOfAddicted = new ArrayList<>();
    }

    public Drug getDrug() {
        return addictedDrug;
    }

    public void setDrug(Drug drug) {
        this.addictedDrug = drug;
    }
    
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRehab() {
        return rehab;
    }

    public void setRehab(String rehab) {
        this.rehab = rehab;
    }

    public String getAddicted() {
        return addicted;
    }

    public void setAddicted(String addicted) {
        this.addicted = addicted;
    }

    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public int getPatientPoints() {
        return patientPoints;
    }

    public void setPatientPoints(int patientPoints) {
        this.patientPoints = patientPoints;
    }

    public String getPreviousAddictedDrug() {
        return previousAddictedDrug;
    }

    public void setPreviousAddictedDrug(String previousAddictedDrug) {
        this.previousAddictedDrug = previousAddictedDrug;
    }
   
    public Drug getAddictedDrug() {
        return addictedDrug;
    }

    public void setAddictedDrug(Drug addictedDrug) {
        this.addictedDrug = addictedDrug;
    }

    public AddictedDrugList getAddictedDrugListObject() {
        if(addictedDrugListObject == null){
            addictedDrugListObject = new AddictedDrugList();
        }
        return addictedDrugListObject;
    }

    public void setAddictedDrugListObject(AddictedDrugList addictedDrugListObject) {
        this.addictedDrugListObject = addictedDrugListObject;
    }

    public String getPatientTag() {
        return patientTag;
    }

    public void setPatientTag(String patientTag) {
        this.patientTag = patientTag;
    }
    
     @Override
    public String toString(){
        return RoleType.Patient.getValue();
    }
    
    
    
}
