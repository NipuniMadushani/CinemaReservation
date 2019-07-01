/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.entity;

/**
 *
 * @author User
 */
public class Discount {
    private String did;
    private int percentage;
    private String date;
    
    public Discount(){}
    
    public Discount(String did,int percentage,String date){
        this.did=did;
        this.percentage=percentage;
        this.date=date;
    }

    /**
     * @return the did
     */
    public String getDid() {
        return did;
    }

    /**
     * @param did the did to set
     */
    public void setDid(String did) {
        this.did = did;
    }

    /**
     * @return the percentage
     */
    public int getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Discount{" + "did=" + did + ", percentage=" + percentage + ", date=" + date + '}';
    }
    
}
