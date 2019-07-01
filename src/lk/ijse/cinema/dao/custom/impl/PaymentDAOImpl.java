/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.CustomerDAO;
import lk.ijse.cinema.dao.custom.PaymentDAO;
import lk.ijse.cinema.entity.Payment;

/**
 *
 * @author User
 */
public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment payment) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO Payment VALUES (?,?,?)", payment.getPid(), payment.getPayment_date(), payment.getAmount()) > 0;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public ArrayList<Payment> getLatest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
