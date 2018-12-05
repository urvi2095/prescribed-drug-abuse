/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author urvi
 */
public class OrderMedicinesWorkRequest extends WorkRequest{
    private String drugName;
    private int orderedQuantity;
    private PrescriptionWorkRequest prescriptionWorkRequest;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public PrescriptionWorkRequest getPrescriptionWorkRequest() {
        return prescriptionWorkRequest;
    }

    public void setPrescriptionWorkRequest(PrescriptionWorkRequest prescriptionWorkRequest) {
        this.prescriptionWorkRequest = prescriptionWorkRequest;
    }
    
    
 
    @Override
    public String toString(){
        return drugName;
    }
}
