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
public class SeatDTO {
    private String seat_id;
    private int seat_no;
    private String seat_type;

    public SeatDTO() {
    }

    public SeatDTO(String seat_id, int seat_no, String seat_type) {
        this.seat_id = seat_id;
        this.seat_no = seat_no;
        this.seat_type = seat_type;
    }

    /**
     * @return the seat_id
     */
    public String getSeat_id() {
        return seat_id;
    }

    /**
     * @param seat_id the seat_id to set
     */
    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    /**
     * @return the seat_no
     */
    public int getSeat_no() {
        return seat_no;
    }

    /**
     * @param seat_no the seat_no to set
     */
    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    /**
     * @return the seat_type
     */
    public String getSeat_type() {
        return seat_type;
    }

    /**
     * @param seat_type the seat_type to set
     */
    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    @Override
    public String toString() {
        return "SeatDTO{" + "seat_id=" + seat_id + ", seat_no=" + seat_no + ", seat_type=" + seat_type + '}';
    }
    
    
}
