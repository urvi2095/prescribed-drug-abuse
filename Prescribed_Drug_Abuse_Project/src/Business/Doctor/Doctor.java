/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

/**
 *
 * @author hetashavi
 */
public class Doctor {
    
    private String name;
    private String specialization;
    private int doctorId;
    private static int count;

    public Doctor() {
        count++;
        doctorId = count;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    
    @Override
    public String toString() {
        return name;
}
}
