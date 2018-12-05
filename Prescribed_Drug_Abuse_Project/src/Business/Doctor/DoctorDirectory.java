/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import java.util.ArrayList;

/**
 *
 * @author hetashavi
 */
public class DoctorDirectory {
    
    private ArrayList<Doctor> doctorList;

    public DoctorDirectory() {
        doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getdoctorList() {
        return doctorList;
    }
    
    public Doctor createDoctor(String name, String spec){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSpecialization(spec);
        doctorList.add(doctor);
        return doctor;
    }
}
