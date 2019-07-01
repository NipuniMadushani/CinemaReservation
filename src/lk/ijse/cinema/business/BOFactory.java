/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business;


import lk.ijse.cinema.business.custom.impl.CustomerBOImpl;
import lk.ijse.cinema.business.custom.impl.DiscountBOImpl;
import lk.ijse.cinema.business.custom.impl.MovieBOImpl;
import lk.ijse.cinema.business.custom.impl.PaymentBOImpl;
import lk.ijse.cinema.business.custom.impl.ReservationBOImpl;
import lk.ijse.cinema.business.custom.impl.TicketBOImpl;
import lk.ijse.cinema.business.custom.impl.UserBOImpl;

/**
 *
 * @author User
 */
public class BOFactory {
    public enum BOTypes{
        CUSTOMER, MOVIE, DISCOUNT,PAYMENT,RESERVATION,SEAT,TICKET,USER;
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch(boType){
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case MOVIE:
                return (T) new MovieBOImpl();
            case DISCOUNT:
                return (T) new DiscountBOImpl();
            case PAYMENT:
                return (T) new PaymentBOImpl();
            case RESERVATION:
                return (T) new ReservationBOImpl();
            case USER:
                return (T) new UserBOImpl();
            case TICKET:
                return (T) new TicketBOImpl();
            default:
                return null;
        }
    }
}
