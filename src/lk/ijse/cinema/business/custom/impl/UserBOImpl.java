/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import lk.ijse.cinema.business.custom.UserBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.UserDAO;
import lk.ijse.cinema.entity.User;
import lk.ijse.cinema.model.UserDTO;

/**
 *
 * @author User
 */
public class UserBOImpl implements UserBO {
    
    private UserDAO userDAO;

    public UserBOImpl() {
        this.userDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    }
    
    public boolean addUser(UserDTO user) throws Exception{
        return userDAO.save(new User(user.getUsername(),user.getPassword()));
    }
    
    public UserDTO searchUser(String username) throws Exception{
        User user=userDAO.search(username);
        if(user!=null){
            return new UserDTO(user.getUsername(),user.getPassword());
        }
        return null;
    }
    
    
}
