/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DistributorAdmin.Supplier.SupplierAdminWorkAreaJPanel;
import userinterface.HospitalAdmin.Pharmacy.PharmaManagerWorkAreaJPanel;

/**
 *
 * @author hetashavi
 */
public class SupplierRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SupplierAdminWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    private String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     @Override
    public String toString(){
        return RoleType.Supplier.getValue();
    }
    
    
}
