/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.io.IOException;
import java.net.URL;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import lk.ijse.cinema.db.DBConnection;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TicketBookingController2 implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private ComboBox<String> adultCombo;
    @FXML
    private ComboBox<String> halfCombo;
    @FXML
    private Label lblTotal;
    @FXML
    private Label se26;
    @FXML
    private Label se24;
    @FXML
    private Label se23;
    @FXML
    private Label se25;
    @FXML
    private Label se27;
    @FXML
    private Label se32;
    @FXML
    private Label se30;
    @FXML
    private Label se31;
    @FXML
    private Label se34;
    @FXML
    private Label se33;
    @FXML
    private Label se35;
    @FXML
    private Label se28;
    @FXML
    private Label se29;
    @FXML
    private Label se09;
    @FXML
    private Label se17;
    @FXML
    private Label se18;
    @FXML
    private Label se19;
    @FXML
    private Label se20;
    @FXML
    private Label se21;
    @FXML
    private Label se22;
    @FXML
    private Label se16;
    @FXML
    private Label se10;
    @FXML
    private Label se11;
    @FXML
    private Label se12;
    @FXML
    private Label se13;
    @FXML
    private Label se14;
    @FXML
    private Label se15;
    @FXML
    private Label se01;
    @FXML
    private Label se08;
    @FXML
    private Label se02;
    @FXML
    private Label se04;
    @FXML
    private Label se05;
    @FXML
    private Label se06;
    @FXML
    private Label se07;
    @FXML
    private Label se48;
    @FXML
    private Label se49;
    @FXML
    private Label se42;
    @FXML
    private Label se43;
    @FXML
    private Label se44;
    @FXML
    private Label se36;
    @FXML
    private Label se37;
    @FXML
    private Label se38;
    @FXML
    private Label se50;
    @FXML
    private Label se51;
    @FXML
    private Label se47;
    @FXML
    private Label se45;
    @FXML
    private Label se46;
    @FXML
    private Label se41;
    @FXML
    private Label se39;
    @FXML
    private Label se40;
    @FXML
    private Label se60;
    @FXML
    private Label se58;
    @FXML
    private Label se59;
    @FXML
    private Label se54;
    @FXML
    private Label se52;
    @FXML
    private Label se53;
    @FXML
    private Label se63;
    @FXML
    private Label se61;
    @FXML
    private Label se62;
    @FXML
    private Label se57;
    @FXML
    private Label se55;
    @FXML
    private Label se56;
    @FXML
    private Label se66;
    @FXML
    private Label se64;
    @FXML
    private Label se65;
    @FXML
    private Label se69;
    @FXML
    private Label se67;
    @FXML
    private Label se68;
    @FXML
    private Label se71;
    @FXML
    private Label se70;
    @FXML
    private Label se72;
    @FXML
    private Label se73;
    @FXML
    private Label show;
    @FXML
    private Label movieName;
    @FXML
    private Label reservedDate;
    @FXML
    private Label se03;
    @FXML
    private Button btnContinue;
    static ArrayList<String> data;

    /**
     * Initializes the controller class.
     */
    //ArrayList<Label> lbl=new ArrayList<se01.getText(),se02.getText(),se03.getText(),se04.getText(),se05.getText(),se06.getText(),se07.getText(),se08.getText(),se09.getText(),se10.getText(),se11.getText(),se12.getText(),se13.getText(),se14.getText(),se15.getText(),se16.getText(),se17.getText(),se18.getText(),se19.getText(),se20.getText(),se21.getText(),se22.getText(),se23.getText(),se24.getText(),se25.getText(),se26.getText(),se27.getText(),se28,se29,se30,se31,se32,se33,se34,se35,se36,se37,se38,se39,se40,se41,se42,se43,se44,se45,se46,se47,se48,se49,se50,se51,se52,se53,se54,se55,se56,se57,se58,se59,se60,se61,se62,se63,se64,se65,se66,se67,se68,se69,se70,se71,se72,se73>();
    private List<Label> lbl;
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         lbl=new ArrayList<Label>(Arrays.asList(se01,se02,se03,se04,se05,se06,se07,se08,se09,se10,
                                                            se11,se12,se13,se14,se15,se16,se17,se18,se19,se20,
                                                            se21,se22,se23,se24,se25,se26,se27,se28,se29,se30,
                                                            se31,se32,se33,se34,se35,se36,se37,se38,se39,se40,
                                                            se41,se42,se43,se44,se45,se46,se47,se48,se49,se50,
                                                            se51,se52,se53,se54,se55,se56,se57,se58,se59,se60,
                                                            se61,se62,se63,se64,se65,se66,se67,se68,se69,se70,
                                                            se71,se72,se73));

        // TODO
         
         ArrayList<String> rids; 
         System.out.println(reservedDate.getText() + movieName.getText() + show.getText());
        
         
        
        data = new ArrayList<>();
        adultCombo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        halfCombo.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        adultCombo.setValue("1");
        halfCombo.setValue("0");
        String adult = adultCombo.getSelectionModel().getSelectedItem();
        String half = halfCombo.getSelectionModel().getSelectedItem();
        int total = Integer.parseInt(adult) + Integer.parseInt(half);
        lblTotal.setText(Integer.toString(total));
        adultCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String adult = adultCombo.getSelectionModel().getSelectedItem();
                String half = halfCombo.getSelectionModel().getSelectedItem();
                int total = Integer.parseInt(adult) + Integer.parseInt(half);
                lblTotal.setText(Integer.toString(total));
            }

        });

        halfCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String adult = adultCombo.getSelectionModel().getSelectedItem();
                String half = halfCombo.getSelectionModel().getSelectedItem();
                int total = Integer.parseInt(adult) + Integer.parseInt(half);
                lblTotal.setText(Integer.toString(total));
            }

        });
        
        
    }

    @FXML
    private void selectLabel(MouseEvent event) {
        String seatNum = ((Label) (event.getSource())).getText();
        if (data.indexOf(seatNum)==-1) {
            ((Label) (event.getSource())).setStyle("-fx-background-color:green");
            data.add(seatNum);
        } else {
            ((Label) (event.getSource())).setStyle("-fx-background-color:white; -fx-border-color:black");
            data.remove(seatNum);
        }
        
        int total=Integer.parseInt(lblTotal.getText());
        if(data.size()==total){
            btnContinue.setDisable(false);
        }else{
            btnContinue.setDisable(true);
        }
    }

    @FXML
    private void viewPayment(ActionEvent event) {
         try {

            FXMLLoader loader= new FXMLLoader(getClass().getResource("/lk/ijse/cinema/view/ticketBooking3.fxml"));
            Parent p=loader.load();
            TicketBookingController3 controller=loader.<TicketBookingController3>getController();
            String adult = adultCombo.getSelectionModel().getSelectedItem();
            String half = halfCombo.getSelectionModel().getSelectedItem();
            controller.initVariable(movieName.getText(),reservedDate.getText(),show.getText(),adult,half,data);
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void previousPage(ActionEvent event) {
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/ticketBooking1.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void initVariable(String movieName, String reservedDate, String show) {
        this.show.setText(show);
        this.movieName.setText(movieName);
        this.reservedDate.setText(reservedDate);
        
    }    
}
