/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lk.ijse.cinema.business.custom.CustomerBO;
import lk.ijse.cinema.business.custom.DiscountBO;
import lk.ijse.cinema.business.custom.MovieBO;
import lk.ijse.cinema.business.custom.PaymentBO;
import lk.ijse.cinema.business.custom.impl.CustomerBOImpl;
import lk.ijse.cinema.business.custom.impl.DiscountBOImpl;
import lk.ijse.cinema.business.custom.impl.MovieBOImpl;
import lk.ijse.cinema.business.custom.impl.PaymentBOImpl;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.model.CustomerDTO;
import lk.ijse.cinema.model.DiscountDTO;
import lk.ijse.cinema.model.MovieDTO;
import lk.ijse.cinema.model.PaymentDTO;
import lk.ijse.cinema.model.ReservationDTO;
import lk.ijse.cinema.model.SeatDTO;
import lk.ijse.cinema.model.TicketDTO;
import lk.ijse.cinema.validaion.Validation;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TicketBookingController3 implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField custId;
    @FXML
    private Label amount;
    @FXML
    private TextField custContactNo;
    @FXML
    private Label pid;
    @FXML
    private TextField custName;
    @FXML
    private Label full;
    @FXML
    private Label half;
    @FXML
    private Label totalPrice;
    @FXML
    private Label discount;
    @FXML
    private Label netTotal;
    @FXML
    private Label name;
    @FXML
    private Label show;
    @FXML
    private Label date;
    @FXML
    private Label seat;
    @FXML
    private Label pDate;
    @FXML
    private Button btnSave;
    @FXML
    private RadioButton rbtnOffer;
    DiscountDTO discountDTO;
    private int percentage;
    private int did;
    private int mid;
    private static CustomerBO customerBO = new CustomerBOImpl();
    private static DiscountBO discountBO = new DiscountBOImpl();
    private static PaymentBO paymentBO = new PaymentBOImpl();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSave.setDisable(true);
        try {
            custId.setText(getNewCid());
        } catch (Exception ex) {
            Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void saveCustomer(ActionEvent event) {
        String id = custId.getText();
        String name = custName.getText();
        String contactNo = custContactNo.getText();
        CustomerDTO customer = new CustomerDTO(id, name, contactNo);
        try {
            boolean isAdded = customerBO.addCustomer(customer);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Added Successfully");
            }
        } catch (Exception ex) {
            Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void checkID(ActionEvent event) {
        String id = custId.getText();
        boolean isValidate = Validation.validCustID(id);
        if (isValidate) {
            try {
                CustomerDTO customer = customerBO.searchCustomer(id);
                if (customer != null) {
                    custName.setText(customer.getName());
                    custContactNo.setText(customer.getContactNo());
                } else {
                    custName.requestFocus();
                }
            } catch (Exception ex) {
                Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            custId.setText("");
        }

    }

    @FXML
    private void checkName(ActionEvent event) {
        boolean isValidate = Validation.validName(custName.getText());
        if (isValidate) {
            custContactNo.requestFocus();
        } else {
            custName.setText(null);
        }
    }

    @FXML
    private void checkContactNo(ActionEvent event) {
        boolean isValidate = Validation.validContactNo(custContactNo.getText());
        if (isValidate) {
            if (custId.getText() != null && custName.getText() != null && custContactNo.getText() != null) {
                btnSave.setDisable(false);
            }
        } else {
            custContactNo.setText(null);
        }
    }

    @FXML
    private void addReservation(ActionEvent event) {
        ArrayList<ReservationDTO> rst = new ArrayList<>();
        ArrayList<TicketDTO> tct = new ArrayList<>();
        try {
            DiscountDTO discountData = discountBO.searchDiscount(date.getText());
            if (discountData == null) {
                discountData = new DiscountDTO();
                discountData.setDid(null);
                discountData.setPercentage(0);
            }

            CustomerDTO customer = new CustomerDTO(custName.getText(), custId.getText(), custContactNo.getText());
            String rid = "";
            String tid = "";
            String[] seats = seat.getText().split(" ");

            int fullTickets = Integer.parseInt(full.getText());
            boolean rsvStatus = true;

            rid = getNewRid();
            tid = getNewTid();

            for (int i = 0; i < seats.length; i++) {
                rid = rid.split("r")[1];
                rid = String.format("%03d", Integer.parseInt(rid) + i);
                rid = "r" + rid;
                ReservationDTO reservation = new ReservationDTO(rid, date.getText(), custId.getText(), searchMovie(name.getText()).getId(), searchSeat(Integer.parseInt(seats[i])).getSeat_id(), show.getText());
                rst.add(reservation);

                tid = tid.split("t")[1];
                tid = String.format("%04d", Integer.parseInt(tid) + i);
                tid = "t" + tid;
                double ticketPrice = 0;
                String type = "";
                if (i < fullTickets) {
                    ticketPrice = getSeatPrice(seats[i], "Full");
                    type = "Full";
                } else {
                    ticketPrice = getSeatPrice(seats[i], "Half");
                    type = "Half";
                }

                TicketDTO ticket = new TicketDTO(tid, date.getText(), ticketPrice, discountData.getDid(), discountData.getPercentage(), searchSeat(Integer.parseInt(seats[i])).getSeat_type(), rid, pid.getText(), type);
                tct.add(ticket);
            }

            PaymentDTO payment = new PaymentDTO(pid.getText(), date.getText(), Double.parseDouble(netTotal.getText()), rst, tct);
            boolean isAdded = paymentBO.addPayment(payment);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Reservations are done succesfully");
            }

        } catch (Exception ex) {
            Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewHome();

    }

    @FXML
    private void viewPrevious(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/ticketBooking2.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);
        } catch (IOException ex) {
            Logger.getLogger(TicketBookingController1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void initVariable(String movieName, String reservedDate, String show, String adult, String half, ArrayList<String> data) {
        try {
            this.name.setText(movieName);
            this.date.setText(reservedDate);
            this.show.setText(show);
            this.full.setText(adult);
            this.half.setText(half);
            String seatN = "";
            double adultFee;
            double halfFee;
            String firstSeat = data.get(0);
            int tot = 0;

            if (Integer.parseInt(firstSeat) <= 22) {
                /*adultFee = 245.00;
                 halfFee = 185.00;*/
                tot += Integer.parseInt(adult) * 245 + Integer.parseInt(half) * 185;
            } else if (Integer.parseInt(firstSeat) > 22 && Integer.parseInt(firstSeat) <= 35) {
                //adultFee = halfFee = 700.00;
                tot += Integer.parseInt(adult) * 700 + Integer.parseInt(half) * 700;
            } else {
                /*adultFee = 215.00;
                 halfFee = 165.00;*/
                tot += Integer.parseInt(adult) * 215 + Integer.parseInt(half) * 165;
            }

            totalPrice.setText(Integer.toString(tot));

            for (String d : data) {
                seatN += d + " ";
            }
            this.seat.setText(seatN);

            try {
                discountDTO =searchDiscount(date.getText());
                if (discountDTO == null) {
                    discountDTO = new DiscountDTO();
                    discountDTO.setPercentage(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
            }

            rbtnOffer.setSelected(true);
            int percentage = discountDTO.getPercentage();
            double dis = Integer.parseInt(totalPrice.getText()) * percentage * 0.01;
            discount.setText(Double.toString(dis));
            double net = Double.parseDouble(totalPrice.getText())- dis;
            netTotal.setText(Double.toString(net));
            amount.setText(Double.toString(net));
            setPaymentDate();
            pid.setText(getNewPid());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketBookingController3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static MovieDTO searchMovie(String name) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select * from movie where name='" + name + "'");
        if (rst.next()) {
            String mid = rst.getString("mid");
            String movie_name = rst.getString("name");
            String genre = rst.getString("genre");
            String director = rst.getString("director");
            String releasedDate = df.format(rst.getDate("released_date"));
            String endDate = df.format(rst.getDate("end_date"));
            double duration = rst.getDouble("duration");
            MovieDTO movie = new MovieDTO(mid, movie_name, genre, director, releasedDate, endDate, duration);
            return movie;
        } else {
            return null;
        }
    }

    public static SeatDTO searchSeat(int seatNo) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select * from seat where seat_no='" + seatNo + "'");
        if (rst.next()) {
            String seat_id = rst.getString("seat_id");
            int seat_no = rst.getInt("seat_no");
            String seat_type = rst.getString("st_id");
            SeatDTO seat = new SeatDTO(seat_id, seat_no, seat_type);
            return seat;
        } else {
            return null;
        }
    }

    private String getNewRid() throws ClassNotFoundException, SQLException {
        String rid = "";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select rid from reservation order by rid desc limit 1");
        if (rst.next()) {
            rid = rst.getString("rid");
            rid = rid.split("r")[1];
            rid = String.format("%03d", Integer.parseInt(rid) + 1);
            rid = "r" + rid;
        } else {
            rid = "r001";
        }
        System.out.println("Rid : " + rid);

        return rid;

    }

    private String getNewTid() throws ClassNotFoundException, SQLException {
        String tid = "";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select ticket_no from ticket order by ticket_no desc limit 1");
        if (rst.next()) {
            tid = rst.getString("ticket_no");
            tid = tid.split("t")[1];
            tid = String.format("%04d", Integer.parseInt(tid) + 1);
            tid = "t" + tid;
        } else {
            tid = "t001";
        }

        System.out.println("Tid : " + tid);
        return tid;
    }

    private String getNewCid() throws ClassNotFoundException, SQLException {
        String cid = "";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select cid from customer order by cid desc limit 1");
        if (rst.next()) {
            cid = rst.getString("cid");
            cid = cid.split("c")[1];
            cid = String.format("%03d", Integer.parseInt(cid) + 1);
            cid = "c" + cid;
        } else {
            cid = "C001";
        }
        System.out.println("Cid : " + cid);

        return cid;

    }

    private String getNewPid() throws ClassNotFoundException, SQLException {
        String pid = "";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select pid from payment order by pid desc limit 1");
        if (rst.next()) {
            pid = rst.getString("pid");
            pid = pid.split("p")[1];
            pid = String.format("%04d", Integer.parseInt(pid) + 1);
            pid = "p" + pid;
        } else {
            pid = "p0001";
        }

        System.out.println("Pid : " + pid);
        return pid;
    }

    private double getSeatPrice(String seat, String type) {

        if (Integer.parseInt(seat) <= 22) {
            if (type == "Full") {
                return 245;
            } else {
                return 185;
            }
        } else if (Integer.parseInt(seat) > 22 && Integer.parseInt(seat) <= 35) {
            if (type == "Full") {
                return 700;
            } else {
                return 700;
            }
        } else {
            if (type == "Full") {
                return 215;
            } else {
                return 165;
            }
        }

    }

    private void setPaymentDate() {
        LocalDate date = LocalDate.now();
        String ODate = date.toString();
        pDate.setText(ODate);

    }

    private void viewHome() {
        try {
            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/home2.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);
        } catch (IOException ex) {
            Logger.getLogger(TicketBookingController1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DiscountDTO searchDiscount(String date) throws ClassNotFoundException, SQLException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select * from discount where availableDate='" + date + "'");
        if (rst.next()) {
            String did = rst.getString("did");
            int percentage = rst.getInt("percentage");
            String availableDate = df.format(rst.getDate("availableDate"));
            DiscountDTO discountDTO = new DiscountDTO(did, percentage, availableDate);
            return discountDTO;
        } else {
            return null;
        }
    }
}
