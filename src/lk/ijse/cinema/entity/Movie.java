/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.entity;

import java.util.ArrayList;
import lk.ijse.cinema.model.AirDTO;

/**
 *
 * @author User
 */
public class Movie {
    private String id;
    private String name;
    private String director;
    private String genre;
    private String releasedDate;
    private String endDate;
    private double duration;
   
   // private Image picture;

    /**
     * @return the movieID
     */
    public Movie(){}
            
   
    public Movie(String id,String name,String genre,String director,String releasedDate,String endDate,double duration){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.director=director;
        this.releasedDate=releasedDate;
        this.endDate=endDate;
        this.duration=duration;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the releasedDate
     */
    public String getReleasedDate() {
        return releasedDate;
    }

    /**
     * @param releasedDate the releasedDate to set
     */
    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", director=" + director + ", genre=" + genre + ", releasedDate=" + releasedDate + ", endDate=" + endDate + ", duration=" + duration + '}';
    }
    
}
