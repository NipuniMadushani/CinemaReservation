/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.CustomerDTO;
import lk.ijse.cinema.model.ReservationDTO;

/**
 *
 * @author User
 */
public interface ReservationBO extends SuperBO {
    
    public boolean addReservation(ReservationDTO reservation) throws Exception;
}
