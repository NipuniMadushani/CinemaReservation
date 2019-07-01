/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PaymentDTO {

    private String pid;
    private String payment_date;
    private double amount;
    private ArrayList<ReservationDTO> reservationDetails;
    private ArrayList<TicketDTO> ticketDetails;

    public PaymentDTO() {
    }
    

    public PaymentDTO(String pid, String payment_date, double amount) {
        this.pid = pid;
        this.payment_date = payment_date;
        this.amount = amount;
    }
    
    public PaymentDTO(String pid, String payment_date, double amount,ArrayList<ReservationDTO> rst,ArrayList<TicketDTO> tct) {
        this.pid = pid;
        this.payment_date = payment_date;
        this.amount = amount;
        this.reservationDetails=rst;
        this.ticketDetails=tct;
        
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
     * @return the payment_date
     */
    public String getPayment_date() {
        return payment_date;
    }

    /**
     * @param payment_date the payment_date to set
     */
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "pid=" + pid + ", payment_date=" + payment_date + ", amount=" + amount + '}';
    }

    /**
     * @return the reservationDetails
     */
    public ArrayList<ReservationDTO> getReservationDetails() {
        return reservationDetails;
    }

    /**
     * @param reservationDetails the reservationDetails to set
     */
    public void setReservationDetails(ArrayList<ReservationDTO> reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    /**
     * @return the ticketDetails
     */
    public ArrayList<TicketDTO> getTicketDetails() {
        return ticketDetails;
    }

    /**
     * @param ticketDetails the ticketDetails to set
     */
    public void setTicketDetails(ArrayList<TicketDTO> ticketDetails) {
        this.ticketDetails = ticketDetails;
    }
    
}
