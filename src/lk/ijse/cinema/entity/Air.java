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
public class Air {
    private Air_PK airpk;
    
    public Air(){}
    
    public Air(Air_PK airpk){
        this.airpk=airpk;
    }
    
    public Air(String mid,String sid){
        this.airpk = new Air_PK(mid, sid);
        
    }

    /**
     * @return the airpk
     */
    public Air_PK getAirpk() {
        return airpk;
    }

    /**
     * @param airpk the airpk to set
     */
    public void setAirpk(Air_PK airpk) {
        this.airpk = airpk;
    }
    
}
