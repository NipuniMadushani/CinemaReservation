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
import lk.ijse.cinema.dao.custom.DiscountDAO;
import lk.ijse.cinema.entity.Discount;

/**
 *
 * @author User
 */
public class DiscountDAOImpl implements DiscountDAO {
   @Override
   public boolean save(Discount discount) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO Discount VALUES (?,?,?)", discount.getDid(), discount.getPercentage(), discount.getDate()) > 0;
   }
   @Override
   public boolean update(Discount discount) throws Exception {
       return CrudUtil.executeUpdate("UPDATE Discount SET percentage=?, availableDate=? WHERE did=?", discount.getPercentage(), discount.getDate(), discount.getDid()) > 0;
   }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Discount search(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("Select * From Discount where did=?", id);
        if (rst.next()) {
            return new Discount(rst.getString("did"), rst.getInt("percentage"), rst.getString("availableDate"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Discount> getAll() throws Exception {
       ArrayList<Discount> allDiscount = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Discount");
        while (rst.next()) {
            allDiscount.add(new Discount(rst.getString(1),
                    rst.getInt(2),
                    rst.getString(3)));
        }
        return allDiscount;
    }

    @Override
    public ArrayList<Discount> getLatest() throws Exception {
        
        ArrayList<Discount> latestDiscount = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from discount order by availableDate desc limit 1;");
        while (rst.next()) {
            latestDiscount.add(new Discount(rst.getString(1),
                    rst.getInt(2),
                    rst.getString(3)));
        }
            return latestDiscount;
        
    }

    
}
