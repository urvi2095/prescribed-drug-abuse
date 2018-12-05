/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Doctor.DoctorDirectory;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author urvi
 */
public class DoctorOrganization extends Organization{
    
private DoctorDirectory doctorDirectory;  

    public DoctorOrganization() {
        super(Organization.Type.Doctor.getValue());
        doctorDirectory = new DoctorDirectory();
    }

    public DoctorDirectory getDoctorDirectory() {
        return doctorDirectory;
    }
    
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DoctorRole());
        return roles;
    }
}
