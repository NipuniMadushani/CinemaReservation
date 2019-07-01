/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.cinema.business.custom.MovieBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.AirDAO;
import lk.ijse.cinema.dao.custom.MovieDAO;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.entity.Air;
import lk.ijse.cinema.entity.Discount;
import lk.ijse.cinema.entity.Movie;
import lk.ijse.cinema.model.AirDTO;
import lk.ijse.cinema.model.DiscountDTO;
import lk.ijse.cinema.model.MovieDTO;

/**
 *
 * @author User
 */
public class MovieBOImpl implements MovieBO {

   private MovieDAO movieDAO;
   private AirDAO airDAO;
    
    public MovieBOImpl(){
        this.movieDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MOVIE);
        this.airDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.AIR);
    }
    
    public boolean addMovie(MovieDTO movie) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{
            boolean result= movieDAO.save(new Movie(movie.getId(), movie.getName(), movie.getGenre(), movie.getDirector(),movie.getReleasedDate(),movie.getEndDate(),movie.getDuration()));
            if(!result){
                return false;
            }
            for (AirDTO airDTO : movie.getAirDetail()) {

                result = airDAO.save(new Air(airDTO.getMid(),airDTO.getSid()));

                if (!result) {
                    connection.rollback();
                    return false;
                }
            }
            connection.commit();
            return true;

        } finally {
            connection.setAutoCommit(true);
        }
    }
    
    public MovieDTO searchMovie(String movieId) throws Exception {
         Movie movie = movieDAO.search(movieId);
         if(movie!=null){
            return new MovieDTO(movie.getId(), movie.getName(), movie.getGenre(), movie.getDirector(),movie.getReleasedDate(),movie.getEndDate(),movie.getDuration());
         }
            return null;
    }
    
    public boolean updateMovie(MovieDTO movie) throws Exception {
        return movieDAO.update(new Movie(movie.getId(), movie.getName(), movie.getGenre(), movie.getDirector(),movie.getReleasedDate(),movie.getEndDate(),movie.getDuration()));
    }

    
    public ArrayList<MovieDTO> getAllMovies() throws Exception {
        ArrayList<Movie> movies = movieDAO.getAll();
        ArrayList<MovieDTO> dtos = new ArrayList<>();
        for (Movie e : movies) {
            dtos.add(new MovieDTO(e.getId(), e.getName(), e.getGenre(), e.getDirector(),e.getReleasedDate(),e.getEndDate(),e.getDuration()));
        }
        return dtos;
    }
    public ArrayList<String> getAllMovieNames() throws Exception {
        ArrayList<Movie> allMovies = movieDAO.getAll();
        ArrayList<String> names = new ArrayList<>();
        for (Movie movie : allMovies) {
            names.add(movie.getName());
        }
        return names;
    }

    
    public boolean deleteMovie(String movieId) throws Exception {
        return movieDAO.delete(movieId);
    }

    
    public ArrayList<MovieDTO> getLatest() throws Exception {
        
        ArrayList<Movie> movie=movieDAO.getLatest();
        ArrayList<MovieDTO> dtos = new ArrayList<>();
        for (Movie e : movie) {
            dtos.add(new MovieDTO(e.getId(), e.getName(), e.getGenre(),e.getDirector(),e.getReleasedDate(),e.getEndDate(),e.getDuration()));
        }
        return dtos;
    }

    
    
    
}
