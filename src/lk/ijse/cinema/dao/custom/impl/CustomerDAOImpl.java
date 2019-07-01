/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.CustomerDAO;
import lk.ijse.cinema.entity.Customer;

/**
 *
 * @author User
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?)", customer.getId(), customer.getName(), customer.getContactNo()) > 0;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Customer where cid=?", id);
        if (rst.next()) {
            return new Customer(rst.getString("cid"), rst.getString("name"), rst.getString("contact_no"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customer> getLatest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
