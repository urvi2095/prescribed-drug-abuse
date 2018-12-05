/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author hetashavi
 */
public class PrescriptionWorkRequest extends WorkRequest{
    private String prescribedDrug;
    private int prescribedDrugQuantity;

    public String getPrescribedDrug() {
        return prescribedDrug;
    }

    public void setPrescribedDrug(String prescribedDrug) {
        this.prescribedDrug = prescribedDrug;
    }
    
    public int getPrescribedDrugQuantity() {
        return prescribedDrugQuantity;
    }

    public void setPrescribedDrugQuantity(int prescribedDrugQuantity) {
        this.prescribedDrugQuantity = prescribedDrugQuantity;
    }
    
    public String toString(){
        return prescribedDrug;
    }
}
