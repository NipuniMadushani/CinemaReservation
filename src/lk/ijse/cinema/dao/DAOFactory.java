/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao;

import lk.ijse.cinema.dao.custom.impl.AirDAOImpl;
import lk.ijse.cinema.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.cinema.dao.custom.impl.DiscountDAOImpl;
import lk.ijse.cinema.dao.custom.impl.MovieDAOImpl;
import lk.ijse.cinema.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.cinema.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.cinema.dao.custom.impl.TicketDAOImpl;
import lk.ijse.cinema.dao.custom.impl.UserDAOImpl;

/**
 *
 * @author User
 */
public class DAOFactory {
    public enum DAOTypes{
        CUSTOMER, DISCOUNT, MOVIE, PAYMENT,RESERVATION,TICKET,AIR,USER;
    }
    
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case DISCOUNT:
                return (T) new DiscountDAOImpl();
            case MOVIE:
                return (T) new MovieDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case RESERVATION:
                return (T) new ReservationDAOImpl();
            case TICKET:
                return (T) new TicketDAOImpl();
            case AIR:
                return (T) new AirDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            default:
                return null;
        }
    }
}
