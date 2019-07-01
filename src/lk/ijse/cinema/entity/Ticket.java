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
public class Ticket {
    private String ticket_no;
    private String issued_date;
    private double price;
    private String did;
    private double discount;
    private String stid;
    private String rid;
    private String pid;
    private String type;

    public Ticket() {
    }

    public Ticket(String ticket_no, String issued_date, double price, String did, double discount, String stid, String rid,String pid, String type) {
        this.ticket_no = ticket_no;
        this.issued_date = issued_date;
        this.price = price;
        this.did = did;
        this.discount = discount;
        this.stid = stid;
        this.rid = rid;
        this.pid=pid;
        this.type = type;
    }

    /**
     * @return the ticket_no
     */
    public String getTicket_no() {
        return ticket_no;
    }

    /**
     * @param ticket_no the ticket_no to set
     */
    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }

    /**
     * @return the issued_date
     */
    public String getIssued_date() {
        return issued_date;
    }

    /**
     * @param issued_date the issued_date to set
     */
    public void setIssued_date(String issued_date) {
        this.issued_date = issued_date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the stid
     */
    public String getStid() {
        return stid;
    }

    /**
     * @param stid the stid to set
     */
    public void setStid(String stid) {
        this.stid = stid;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticket_no=" + ticket_no + ", issued_date=" + issued_date + ", price=" + price + ", did=" + did + ", discount=" + discount + ", stid=" + stid + ", rid=" + rid + ", pid=" + pid + ", type=" + type + '}';
    }
    
    
}
