/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author hetashavi
 */
public class Addicted {
    
    private String addictedDrug;
    private int addictedQuantity;
    private int orderscore;
    private String drugName;

    public String getAddictedDrug() {
        return addictedDrug;
    }

    public void setAddictedDrug(String addictedDrug) {
        this.addictedDrug = addictedDrug;
    }

    public int getAddictedQuantity() {
        return addictedQuantity;
    }

    public void setAddictedQuantity(int addictedQuantity) {
        this.addictedQuantity = addictedQuantity;
    }

    public int getOrderscore() {
        return orderscore;
    }

    public void setOrderscore(int orderscore) {
        this.orderscore = orderscore;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
    
    
    
    @Override
    public String toString(){
        return addictedDrug;
    }
   
    
}
