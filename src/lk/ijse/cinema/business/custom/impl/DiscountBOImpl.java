/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.cinema.business.custom.DiscountBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.DiscountDAO;
import lk.ijse.cinema.entity.Customer;
import lk.ijse.cinema.entity.Discount;
import lk.ijse.cinema.model.CustomerDTO;
import lk.ijse.cinema.model.DiscountDTO;

/**
 *
 * @author User
 */
public class DiscountBOImpl implements DiscountBO {
    
    private DiscountDAO discountDAO;
    
    public DiscountBOImpl(){
        this.discountDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DISCOUNT);
    }

    
    public boolean addDiscount(DiscountDTO discount) throws Exception {
        return discountDAO.save(new Discount(discount.getDid(), discount.getPercentage(), discount.getDate()));
    }

    
    public DiscountDTO searchDiscount(String discountId) throws Exception {
       Discount discount = discountDAO.search(discountId);
       if(discount!=null){
        return new DiscountDTO(discount.getDid(), discount.getPercentage(), discount.getDate());
       }
       return null;
    }

    
    public boolean updateDiscount(DiscountDTO discount) throws Exception {
       return discountDAO.update(new Discount(discount.getDid(), discount.getPercentage(), discount.getDate()));
    }

    
    public ArrayList<DiscountDTO> getAllDiscounts() throws Exception {
        ArrayList<Discount> discount = discountDAO.getAll();
        ArrayList<DiscountDTO> dtos = new ArrayList<>();
        for (Discount e : discount) {
            dtos.add(new DiscountDTO(e.getDid(), e.getPercentage(), e.getDate()));
            
        }
        return dtos;
    }
    

    
    public ArrayList<DiscountDTO> getLatest() throws Exception {
       ArrayList<Discount> discount=discountDAO.getLatest();
        ArrayList<DiscountDTO> dtos = new ArrayList<>();
        for (Discount e : discount) {
            dtos.add(new DiscountDTO(e.getDid(), e.getPercentage(), e.getDate()));
        }
        return dtos;
    }

   

    
    
}
