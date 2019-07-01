/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import lk.ijse.cinema.business.custom.TicketBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.TicketDAO;
import lk.ijse.cinema.entity.Ticket;
import lk.ijse.cinema.model.TicketDTO;

/**
 *
 * @author User
 */
public class TicketBOImpl implements TicketBO {
    
    private TicketDAO ticketDAO;
    
    public TicketBOImpl(){
        this.ticketDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TICKET);
    }
    
    
    
    public boolean addTicket(TicketDTO ticket) throws Exception {
         return  ticketDAO.save(new Ticket(ticket.getTicket_no(),ticket.getIssued_date(),ticket.getPrice(),ticket.getDid(),ticket.getDiscount(),ticket.getStid(),ticket.getRid(),ticket.getPid(),ticket.getType()));
    }
    
}
