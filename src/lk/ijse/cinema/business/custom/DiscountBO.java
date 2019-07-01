/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import java.util.ArrayList;
import java.util.Dictionary;
import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.CustomerDTO;
import lk.ijse.cinema.model.DiscountDTO;

/**
 *
 * @author User
 */
public interface DiscountBO extends SuperBO {
    
    public boolean addDiscount(DiscountDTO discoount) throws Exception;
    
    public DiscountDTO searchDiscount(String discountId) throws Exception;
    
    public boolean updateDiscount(DiscountDTO discount) throws Exception;

    public ArrayList<DiscountDTO> getAllDiscounts() throws Exception;
    
    public ArrayList<DiscountDTO> getLatest() throws Exception;
    
}