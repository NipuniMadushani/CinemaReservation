/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.model;

/**
 *
 * @author User
 */
public class AirDTO {
    private String mid;
    private String sid;

    /**
     * @return the mid
     */
    
    public AirDTO(){}
    
    public AirDTO(String mid,String sid){
        this.mid=mid;
        this.sid=sid;
        
    }
    public String getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "AirDTO{" + "mid=" + mid + ", sid=" + sid + '}';
    }
    
    
}
