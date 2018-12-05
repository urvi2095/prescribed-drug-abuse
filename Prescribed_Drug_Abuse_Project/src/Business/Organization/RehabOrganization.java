/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RehabManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hetashavi
 */
public class RehabOrganization extends Organization{
    
    public RehabOrganization() {
        super(Organization.Type.Rehab.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new RehabManager());
        return roles;
    }
    
}
