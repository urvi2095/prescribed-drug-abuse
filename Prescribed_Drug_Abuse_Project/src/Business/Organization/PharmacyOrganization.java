/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.DrugCatalog;
import Business.Role.PharmacyManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author urvi
 */
public class PharmacyOrganization extends Organization{
     
    public PharmacyOrganization() {
        super(Organization.Type.Pharmacy.getValue());
        
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacyManager());
        return roles;
    }
}
