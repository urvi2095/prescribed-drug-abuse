/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author urvi
 */
public class DrugCatalog {
    private String drug_name;
    private int availability;
    private Date expiryDate;
    private int price;
    private String diseaseCured;
    
    private ArrayList<Drug> listOfDrugs;

    public DrugCatalog() {
        listOfDrugs = new ArrayList<>();
    }

    public ArrayList<Drug> getListOfDrugs() {
        return listOfDrugs;
    }
   
    public Drug addDrug(){
        Drug drug = new Drug();
        listOfDrugs.add(drug);
        return drug;
    }
    
}
