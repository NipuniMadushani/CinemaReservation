/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.UserDAO;
import lk.ijse.cinema.entity.User;

/**
 *
 * @author User
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User user) throws Exception {
        return CrudUtil.executeUpdate("Insert into User values(?,?)",user.getUsername(),user.getPassword())>0;
    }

    @Override
    public boolean update(User entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User search(String id) throws Exception {
       ResultSet rst=CrudUtil.executeQuery("Select * from User where username=?", id);
       if(rst.next()){
           return new User(rst.getString("username"),rst.getString("password"));
       }
       return null;
       
    }

    @Override
    public ArrayList<User> getLatest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
