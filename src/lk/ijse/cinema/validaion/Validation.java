/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.validaion;

/**
 *
 * @author User
 */
public class Validation {
    public static boolean validUserName(String text){
        if(text.matches("[a-zA-Z][a-zA-Z0-9]+")){
            return true;
            
        }
        return false;
    }
    public static boolean validPassword(String text){
        if(text.matches("[^: \\&\\.\\~]*[a-z0-9]+[^:\\&\\.\\~]+")){
            return true;
        }
        return false;
    }
    public static boolean validMovieID(String text){
        if(text.matches("[M|m][0-9]+")){
            return true;
        }
        return false;
    }
    public static boolean validCustID(String text){
        if(text.matches("[C|c][0-9]+")){
            return true;
        }
        return false;
    }
    public static boolean validDiscountID(String text){
        if(text.matches("[D|d][0-9]+")){
            return true;
        }
        return false;
    }
    public static boolean validMovieName(String text){
        if(text.matches("([A-Za-z]+)|[( -)|A-Za-z]+")){
            return true;
        }
        return false;
    }
    public static boolean validName(String text){
        if(text.matches("[A-Za-z]+")){
            return true;
        }
        return false;
    }
    public static boolean validDuration(String text){
        if(text.matches("[0-9][.][0-9]{2}")){
            return true;
        }
        return false;
    }
    public static boolean validDirector(String text){
        if(text.matches("[A-Za-z]+[ -][A-Za-z]+")){
            return true;
        }
        return false;
    }
    public static boolean validContactNo(String text){
        if(text.matches("[0-9]{10}")){
            return true;
        }
        return false;
    }
    public static boolean validPercentage(String text){
        if(text.matches("[0-9]+")){
            return true;
        }
        return false;
    }
            
    
    
}
