/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.AirDAO;
import lk.ijse.cinema.entity.Air;
import lk.ijse.cinema.entity.Air_PK;

/**
 *
 * @author User
 */
public class AirDAOImpl implements AirDAO{

    @Override
    public boolean save(Air air) throws Exception {
        return CrudUtil.executeUpdate("Insert into Air Values(?,?)", air.getAirpk().getMid(),air.getAirpk().getSid() ) > 0;
    }

    @Override
    public boolean update(Air air) throws Exception {
        return CrudUtil.executeUpdate("UPDATE air SET sid=? WHERE mid=?", air.getAirpk().getSid(), air.getAirpk().getMid()) > 0;
    }

    @Override
    public boolean delete(Air_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Air search(Air_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Air> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public ArrayList<Air> getLatest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
