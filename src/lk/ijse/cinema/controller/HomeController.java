/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.cinema.business.custom.MovieBO;
import lk.ijse.cinema.business.custom.impl.DiscountBOImpl;
import lk.ijse.cinema.business.custom.impl.MovieBOImpl;
import static lk.ijse.cinema.controller.TicketBookingController1.getShowTimes;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.model.DiscountDTO;
import lk.ijse.cinema.model.MovieDTO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private Button btnLogout;
     @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> timeCombo;
    @FXML
    private Button btnBook;
     @FXML
    private Label lblName;
    @FXML
    private ImageView movieImage;
    private static MovieBO movieBO=new MovieBOImpl();
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
    private void viewTicketBooking2(ActionEvent event) {
        String movieName=lblName.getText();
        String reservedDate=datePicker.getValue().toString();
        String show=timeCombo.getSelectionModel().getSelectedItem();
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
    private void viewManageMovie(ActionEvent event) {
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/manageMovie.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void viewTicketBooking(ActionEvent event) {
        
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/ticketBooking1.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewSearch(ActionEvent event) {
        
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/Search.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewSpecialOffers(ActionEvent event) {
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/specialOffers.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewReports(ActionEvent event) {
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/reports.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewSettings(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws Exception {
       try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/login.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
