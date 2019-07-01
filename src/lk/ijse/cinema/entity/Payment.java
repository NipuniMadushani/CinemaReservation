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
public class Payment {
    private String pid;
    private String payment_date;
    private double amount;

    public Payment() {
    }

    public Payment(String pid, String payment_date, double amount) {
        this.pid = pid;
        this.payment_date = payment_date;
        this.amount = amount;
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
        return "Payment{" + "pid=" + pid + ", payment_date=" + payment_date + ", amount=" + amount + '}';
    }
    
}
