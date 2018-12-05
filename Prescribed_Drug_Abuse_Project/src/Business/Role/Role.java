/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author hetashavi
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        Clinic("Clinic Manager"),
        Pharmacy("Pharmacy Manager"),
        Patient("Patient"),
        HospitalAdmin("Hospital Admin"),
        DistributorAdmin("Distributor Admin"),
        CityWelfareAdmin("CityWelfareAdmin"),
        RehabManager("RehabManager"),
        Supplier("Supplier");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
           
    }
    
    public boolean valPhone(String in){
        return in.length() == 11 && in.matches("[0-9+]");
    }
    
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }  
    
}