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
public class Air_PK {
    private String mid;
    private String sid;
    
    public Air_PK(){}
    
    public Air_PK(String mid,String sid){
        this.mid=mid;
        this.sid=sid;
    }

    /**
     * @return the mid
     */
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
        return "Air_PK{" + "mid=" + mid + ", sid=" + sid + '}';
    }
    
}
