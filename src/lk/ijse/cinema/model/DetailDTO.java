/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.model;

/**
 *
 * @author User
 */
public class DetailDTO {
    private String name;
    private String start_time;
    private String director;
    private double duration;
    private String end_date;
    
    public DetailDTO(){}
    
    public DetailDTO(String name,String start_time,String director,double duration,String end_date){
        this.name=name;
        this.start_time=start_time;
        this.director=director;
        this.duration=duration;
        this.end_date=end_date;
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
     * @return the start_time
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time;
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

    /**
     * @return the end_date
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the end_date to set
     */
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "DetailDTO{" + "name=" + name + ", start_time=" + start_time + ", director=" + director + ", duration=" + duration + ", end_date=" + end_date + '}';
    }
    
    
}
