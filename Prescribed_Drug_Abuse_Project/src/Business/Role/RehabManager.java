/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import userinterface.CityWelfare.RehabManagerWorkAreaJPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HospitalAdmin.Pharmacy.PharmaManagerWorkAreaJPanel;

/**
 *
 * @author hetashavi
 */
public class RehabManager extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new RehabManagerWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    
    private String fname;
    private String lname;

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
    
     @Override
    public String toString(){
        return RoleType.RehabManager.getValue();
    }
    
    
}
