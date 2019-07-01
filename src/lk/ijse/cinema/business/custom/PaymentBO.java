/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.CustomerDTO;
import lk.ijse.cinema.model.PaymentDTO;

/**
 *
 * @author User
 */
public interface PaymentBO extends SuperBO {
    
    public boolean addPayment(PaymentDTO payment) throws Exception;
}
