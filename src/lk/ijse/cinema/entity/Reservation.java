/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.entity;

/**
 *
 * @author User
 */
public class Reservation {

    private String rid;
    private String reserved_date;
    private String reserved_time;
    private String cid;
    private String mid;
    private String seat_id;

    public Reservation() {
    }

    public Reservation(String rid, String date, String cid, String mid, String seat_id, String time) {
        this.rid = rid;
        this.reserved_date = date;
        this.reserved_time = time;
        this.cid = cid;
        this.mid = mid;
        this.seat_id = seat_id;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * @return the reserved_date
     */
    public String getReserved_date() {
        return reserved_date;
    }

    /**
     * @param reserved_date the reserved_date to set
     */
    public void setReserved_date(String reserved_date) {
        this.reserved_date = reserved_date;
    }

    /**
     * @return the reserved_time
     */
    public String getReserved_time() {
        return reserved_time;
    }

    /**
     * @param reserved_time the reserved_time to set
     */
    public void setReserved_time(String reserved_time) {
        this.reserved_time = reserved_time;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the mid
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
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

    @Override
    public String toString() {
        return "Reservation{" + "rid=" + rid + ", reserved_date=" + reserved_date + ", reserved_time=" + reserved_time + ", cid=" + cid + ", mid=" + mid + ", seat_id=" + seat_id + '}';
    }

}
