/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author hetashavi
 */
public class SupplierWorkRequest extends WorkRequest{
    
private String drugName;
private int orderedQuantity;
private boolean add;
private UserAccount supp;

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

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public UserAccount getSupp() {
        return supp;
    }

    public void setSupp(UserAccount supp) {
        this.supp = supp;
    }
  
    
    @Override
    public String toString(){
        return drugName;
    }
}
