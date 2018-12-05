/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentWorkRequest;
import java.util.ArrayList;
import java.util.Date;
import userinterface.HospitalAdmin.DoctorRole.ManageAppointmentsJPanel;
import javax.swing.JPanel;
import userinterface.HospitalAdmin.DoctorRole.DoctorWorkAreaJPanel;

/**
 *
 * @author urvi
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DoctorWorkAreaJPanel(userProcessContainer, account, (DoctorOrganization)organization,enterprise, business);
    }
    private String specialization;
    private String fname;
    private String lname;
    private int age;
    private String bloodGroup;
    private String maritalStatus;
    private Date dob;
    private String address;
    private String phone;
    private String city;
    private String gender;
    
  
    public String getFname() {
        return fname;
    }

    public String getSpecialization() {
        return specialization;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
//    @Override
//    public String toString(){
//        return fname;
//    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

     @Override
    public String toString(){
        return RoleType.Doctor.getValue();
    }
    
    

    
    
}
