/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.TicketDTO;
import lk.ijse.cinema.model.UserDTO;

/**
 *
 * @author User
 */
public interface UserBO extends SuperBO{
    
     public UserDTO searchUser(String username) throws Exception;
     
     public boolean addUser(UserDTO user) throws Exception;
}
