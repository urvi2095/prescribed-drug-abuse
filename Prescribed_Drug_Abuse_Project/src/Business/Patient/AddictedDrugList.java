/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author hetashavi
 */
public class AddictedDrugList {
    
    private ArrayList<Addicted> listOfAddictedDrugs;
    
    public AddictedDrugList(){
        listOfAddictedDrugs = new ArrayList<>();
    }

    public ArrayList<Addicted> getListOfAddictedDrugs() {
        if(listOfAddictedDrugs == null){
            listOfAddictedDrugs = new ArrayList<>();
        }
        return listOfAddictedDrugs;
    }

    public void setListOfAddictedDrugs(ArrayList<Addicted> listOfAddictedDrugs) {
        this.listOfAddictedDrugs = listOfAddictedDrugs;
    }
    
    public Addicted addAddictedDrug(){
        Addicted addict = new Addicted();
        listOfAddictedDrugs.add(addict);
        return addict;
    }
    
}
