/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom;

import java.util.ArrayList;
import lk.ijse.cinema.business.SuperBO;
import lk.ijse.cinema.model.DiscountDTO;
import lk.ijse.cinema.model.MovieDTO;

/**
 *
 * @author User
 */
public interface MovieBO extends SuperBO {
    
    public boolean addMovie(MovieDTO movie) throws Exception;
    
    public MovieDTO searchMovie(String movieId) throws Exception;
    
    public boolean deleteMovie(String movieId) throws Exception;
    
    public boolean updateMovie(MovieDTO movie) throws Exception;

    public ArrayList<MovieDTO> getAllMovies() throws Exception;
    
    public ArrayList<MovieDTO> getLatest() throws Exception;
}
