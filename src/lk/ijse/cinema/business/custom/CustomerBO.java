/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.CustomerDTO;

/**
 *
 * @author User
 */
public interface CustomerBO extends SuperBO {
    
    public boolean addCustomer(CustomerDTO customer) throws Exception;
    
    public CustomerDTO searchCustomer(String customerId) throws Exception;
    
}
