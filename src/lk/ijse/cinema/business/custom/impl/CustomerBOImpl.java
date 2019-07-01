/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.cinema.business.custom.CustomerBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.CustomerDAO;
import lk.ijse.cinema.entity.Customer;
import lk.ijse.cinema.model.CustomerDTO;

/**
 *
 * @author User
 */
public class CustomerBOImpl implements CustomerBO {
    
     private CustomerDAO customerDAO;
    
    public CustomerBOImpl(){
        this.customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.save(new Customer(customer.getId(), customer.getName(), customer.getContactNo()));
    }

    
    public CustomerDTO searchCustomer(String customerId) throws Exception {
        Customer customer = customerDAO.search(customerId);
        if(customer==null){
            return null;
            
        }
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getContactNo());
    }
    
    public ArrayList<Integer> getCustomerAge(String id){
        ArrayList<Integer> we=new ArrayList<>();
        we.add(0, 1);
        we.add(1, 2);
        we.add(2, 3);
        we.add(3, 4); 
        
        return we;
    }
    
}
