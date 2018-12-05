/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hetashavi
 */
public class AppointmentWorkRequest extends WorkRequest{
    
    private Date appointmentDate;
    private String appointmentTime;
    //private ArrayList<AppointmentWorkRequest> listofAppointments;
    
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
//    public AppointmentWorkRequest addApt(){
//        AppointmentWorkRequest apt = new AppointmentWorkRequest();
//        listofAppointments.add(apt);
//        return apt;
//    }
     
    

}
