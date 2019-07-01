/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import lk.ijse.cinema.business.custom.ReservationBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.ReservationDAO;
import lk.ijse.cinema.entity.Reservation;
import lk.ijse.cinema.model.ReservationDTO;

/**
 *
 * @author User
 */
public class ReservationBOImpl implements ReservationBO {
    private ReservationDAO reservationDAO;
    
    public ReservationBOImpl(){
        this.reservationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
    }
    
    public boolean addReservation(ReservationDTO reservation) throws Exception {
        return reservationDAO.save(new Reservation(reservation.getRid(),reservation.getReserved_date(),reservation.getCid(),reservation.getMid(),reservation.getSeat_id(),reservation.getReserved_time()));
    }
    
}
