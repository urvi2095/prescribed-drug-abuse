/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DrugCatalog;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HospitalAdmin.Lab.LabAssistantWorkAreaJPanel;
import userinterface.HospitalAdmin.Pharmacy.PharmaManagerWorkAreaJPanel;

/**
 *
 * @author urvi
 */
public class PharmacyManager extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PharmaManagerWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    
    private DrugCatalog pharmacyDrugList;
    public PharmacyManager() {
        pharmacyDrugList = new DrugCatalog();
    }
   
    private int revenue;
    private int profit;
    private String tag="Good";
    private int pharmacyPoints;

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public DrugCatalog getPharmacyDrugList() {
        if(pharmacyDrugList == null){
            pharmacyDrugList = new DrugCatalog();
        }
        return pharmacyDrugList;
    }

    public void setPharmacyDrugList(DrugCatalog pharmacyDrugList) {
        this.pharmacyDrugList = pharmacyDrugList;
    }

    public int getPharmacyPoints() {
        return pharmacyPoints;
    }

    public void setPharmacyPoints(int pharmacyPoints) {
        this.pharmacyPoints = pharmacyPoints;
    }
    
     @Override
    public String toString(){
        return RoleType.Pharmacy.getValue();
    }
}
