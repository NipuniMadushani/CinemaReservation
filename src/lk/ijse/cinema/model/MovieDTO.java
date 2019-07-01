/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.model;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class MovieDTO {
    private String id;
    private String name;
    private String director;
    private String genre;
    private String releasedDate;
    private String endDate;
    private double duration;
    private ArrayList<AirDTO> airDetail ;
   // private Image picture;

    /**
     * @return the movieID
     */
    public MovieDTO(){}
            
    public MovieDTO(String id,String name,String genre,String director,String releasedDate,String endDate,double duration,ArrayList<AirDTO> airDetail){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.director=director;
        this.releasedDate=releasedDate;
        this.endDate=endDate;
        this.duration=duration;
        this.airDetail=airDetail;
    
    }
    public MovieDTO(String id,String name,String genre,String director,String releasedDate,String endDate,double duration){
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
     * @return the releaseDate
     */
    public String getReleasedDate() {
        return releasedDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    /**
     * @return the EndDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(String EndDate) {
        this.endDate = EndDate;
    }

    public double getDuration() {
        return duration;
        
    }

    /**
     * @return the airDetail
     */
    public ArrayList<AirDTO> getAirDetail() {
        return airDetail;
    }

    /**
     * @param airDetail the airDetail to set
     */
    public void setAirDetail(ArrayList<AirDTO> airDetail) {
        this.airDetail = airDetail;
    }

    @Override
    public String toString() {
        return "MovieDTO{" + "id=" + id + ", name=" + name + ", director=" + director + ", genre=" + genre + ", releasedDate=" + releasedDate + ", endDate=" + endDate + ", duration=" + duration + ", airDetail=" + airDetail + '}';
    }
        
    

    /**
     * @return the picture
     */
    /*public Image getPicture() {
        return picture;
    }*/

    /**
     * @param picture the picture to set
     */
    /*public void setPicture(URL pictureURL) {
        ImageIcon imageIcon=new ImageIcon(pictureURL);
        this.picture=imageIcon.getImage();
        
    }*/

    
    
}
