/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.dao.custom.impl;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import lk.ijse.cinema.dao.CrudUtil;
import lk.ijse.cinema.dao.custom.CustomerDAO;
import lk.ijse.cinema.dao.custom.MovieDAO;
import lk.ijse.cinema.entity.Discount;
import lk.ijse.cinema.entity.Movie;

/**
 *
 * @author User
 */
public class MovieDAOImpl implements MovieDAO {

    @Override
    public boolean save(Movie movie) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Movie VALUES (?,?,?,?,?,?,?)",movie.getId(),movie.getName(),movie.getGenre(),movie.getDirector(),movie.getReleasedDate(),movie.getEndDate(),movie.getDuration()) > 0;
    }

    @Override
    public boolean update(Movie movie) throws Exception {
       return CrudUtil.executeUpdate("UPDATE Movie SET name=?, genre=?, director=?,released_date=?,end_date=?,duration=? WHERE mid=?", movie.getName(), movie.getGenre(),movie.getDirector(),movie.getReleasedDate(),movie.getEndDate(),movie.getDuration(),movie.getId()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Movie where mid=?", id) > 0;

    }

    @Override
    public Movie search(String id) throws Exception {
        //DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
        ResultSet rst = CrudUtil.executeQuery("Select * From Movie where mid=?", id);
        if (rst.next()) {
            return new Movie(rst.getString("mid"), rst.getString("name"), rst.getString("genre"), rst.getString("director"),rst.getString("released_date"),rst.getString("end_date"),rst.getDouble("duration"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Movie> getAll() throws Exception {
        ArrayList<Movie> allMovies = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Movie");
        while (rst.next()) {
            allMovies.add(new Movie(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7)));
        }
        return allMovies;
    }

    

    @Override
    public ArrayList<Movie> getLatest() throws Exception {
       ArrayList<Movie> latestMovie = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from movie where end_date>=curdate() order by mid desc limit 1;");
        while (rst.next()) {
            latestMovie.add(new Movie(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7)));
        }
            return latestMovie;
    }
    
}
