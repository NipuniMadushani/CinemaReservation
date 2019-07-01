/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.CustomerDTO;
import lk.ijse.cinema.model.TicketDTO;

/**
 *
 * @author User
 */
public interface TicketBO extends SuperBO {
    
    public boolean addTicket(TicketDTO ticket) throws Exception;
    
    
}
