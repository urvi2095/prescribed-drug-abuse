/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author urvi
 */
public class Drug {
    private String drug_name;
    private int availability;
    private Date expiryDate;
    private int price;
    private String diseaseCured;
    private int addcitionScore;
    private int orderedScore;

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDiseaseCured() {
        return diseaseCured;
    }

    public void setDiseaseCured(String diseaseCured) {
        this.diseaseCured = diseaseCured;
    }
    
    public String toString(){
        return drug_name;
    }

    public int getAddcitionScore() {
        return addcitionScore;
    }

    public void setAddcitionScore(int addcitionScore) {
        this.addcitionScore = addcitionScore;
    }

    public int getOrderedScore() {
        return orderedScore;
    }

    public void setOrderedScore(int orderedScore) {
        this.orderedScore = orderedScore;
    }
    
    
    
}

    