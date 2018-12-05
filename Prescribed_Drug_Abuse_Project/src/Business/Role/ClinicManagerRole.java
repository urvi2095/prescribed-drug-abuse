/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JPanel;
import userinterface.HospitalAdmin.ClinicStaff.ClinicManagerWorkAreaJPanel;
import userinterface.HospitalAdmin.DoctorRole.ManageAppointmentsJPanel;

/**
 *
 * @author urvi
 */
public class ClinicManagerRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ClinicManagerWorkAreaJPanel(userProcessContainer, account, (ClinicOrganization)organization, enterprise,business);
    }
    
    private String fname;
    private String lname;
    private int age;
    private Date dob;
    private String address;
    private String phone;
    private String city;
    private String gender;
    private String state;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
     @Override
    public String toString(){
        return RoleType.Clinic.getValue();
    }
    
    
    
}
