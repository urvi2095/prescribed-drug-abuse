/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author urvi
 */
public class DiseaseCatalog {
    
    private ArrayList<Disease> listOfDisease;

    public DiseaseCatalog() {
        listOfDisease = new ArrayList<>();
    }

    public ArrayList<Disease> getListOfDisease() {
        return listOfDisease;
    }
    
    public Disease addDisease(){
        Disease disease = new Disease();
        listOfDisease.add(disease);
        return disease;
    }
    
}
