/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.cinema.db.DBConnection;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TicketBookingController1 implements Initializable {
    @FXML
    private  ComboBox<String> movieCombo;
    @FXML
    private  DatePicker showDate;
    @FXML
    private  ComboBox<String> showCombo;
    @FXML
    private AnchorPane root;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        ArrayList <String>name=getAllMovieName();
        movieCombo.getItems().addAll(name);
        movieCombo.setValue(name.get(0));
        ArrayList<String> time=getShowTimes(movieCombo.getSelectionModel().getSelectedItem());
        showCombo.getItems().addAll(time);
       
        
        }catch(SQLException|ClassNotFoundException ex){
            Logger.getLogger(TicketBookingController1.class.getName()).log(Level.SEVERE,null,ex);
        }
        showDate.setDayCellFactory(picker -> new DateCell() {
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            LocalDate today = LocalDate.now();

            setDisable(empty || date.compareTo(today) < 0 );
        }
    });
    }    

    @FXML
    private void loadMovieName(ActionEvent event) {
        try {
            ArrayList<String> time=getShowTimes(movieCombo.getSelectionModel().getSelectedItem());
            showCombo.getItems().addAll(time);
        } catch (SQLException ex) {
            Logger.getLogger(TicketBookingController1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBookingController1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void viewNext(ActionEvent event) {
        String movieName=movieCombo.getSelectionModel().getSelectedItem();
        String reservedDate=showDate.getValue().toString();
        String show=showCombo.getSelectionModel().getSelectedItem();
        System.out.println(movieName + reservedDate+ show);
        
        try {

            FXMLLoader loader= new FXMLLoader(getClass().getResource("/lk/ijse/cinema/view/ticketBooking2.fxml"));
            Parent p=loader.load();
            TicketBookingController2 controller=loader.<TicketBookingController2>getController();
            controller.initVariable(movieName,reservedDate,show);
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewHome(ActionEvent event) {
        try{
            Parent p=FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/home2.fxml"));
            Scene s=new Scene(p);
            Stage stage=(Stage) this.root.getScene().getWindow();
            stage.setScene(s);
        }catch (IOException ex) {
            Logger.getLogger(TicketBookingController1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<String> getAllMovieName() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select name from movie order by mid desc");
        ArrayList<String> code = new ArrayList<>();
        while (rst.next()) {
            code.add(rst.getString("name"));
        }
        return code;
    }
    public static ArrayList<String> getShowTimes(String name) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(" select start_time from shows s,air a, movie m where a.mid=m.mid && s.sid=a.sid && name='"+name+"'");
        ArrayList<String> code = new ArrayList<>();
        while (rst.next()) {
            code.add(rst.getString("start_time"));
        }
        return code;
    }
    
    
    
    
}
