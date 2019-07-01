/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.CustomerDAO;
import lk.ijse.cinema.dao.custom.TicketDAO;
import lk.ijse.cinema.entity.Ticket;

/**
 *
 * @author User
 */
public class TicketDAOImpl implements TicketDAO {

    @Override
    public boolean save(Ticket ticket) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Ticket VALUES (?,?,?,?,?,?,?,?,?)",ticket.getTicket_no(),ticket.getIssued_date(),ticket.getPrice(),ticket.getDid(),ticket.getDiscount(),ticket.getStid(),ticket.getRid(),ticket.getPid(),ticket.getType()) > 0;
    }

    @Override
    public boolean update(Ticket entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ticket search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ticket> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public ArrayList<Ticket> getLatest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
