/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.CustomerDAO;
import lk.ijse.cinema.dao.custom.ReservationDAO;
import lk.ijse.cinema.entity.Reservation;

/**
 *
 * @author User
 */
public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public boolean save(Reservation reservation) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Reservation VALUES (?,?,?,?,?,?)",reservation.getRid(),reservation.getReserved_date(),reservation.getCid(),reservation.getMid(),reservation.getSeat_id(),reservation.getReserved_time()) > 0;
    }

    @Override
    public boolean update(Reservation entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Reservation> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public ArrayList<Reservation> getLatest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
