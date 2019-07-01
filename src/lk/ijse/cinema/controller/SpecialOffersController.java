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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lk.ijse.cinema.business.custom.DiscountBO;
import lk.ijse.cinema.business.custom.MovieBO;
import lk.ijse.cinema.business.custom.impl.DiscountBOImpl;
import lk.ijse.cinema.business.custom.impl.MovieBOImpl;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.model.DiscountDTO;
import lk.ijse.cinema.model.MovieDTO;
import lk.ijse.cinema.validaion.Validation;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SpecialOffersController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lblDid;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblPercentage;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField txtDid;
    @FXML
    private TextField txtPercentage;
    @FXML
    private Button saveDiscount;
    @FXML
    private Button renewDiscount;
    @FXML
    private TableView<Object> discountTable;
    @FXML
    private ImageView viewHome;

    private static DiscountBO discountBO = new DiscountBOImpl();
    private int count = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            discountTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("did"));
            discountTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("percentage"));
            discountTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("availableDate"));
            saveDiscount.setDisable(true);
            
            getAllDiscount();
            getLatestDiscount();
        } catch (Exception ex) {
            Logger.getLogger(SpecialOffersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void saveDiscount(ActionEvent event) {
        String did = lblDid.getText();
        String date = datePicker.getValue().toString();
        int percentage = Integer.parseInt(txtPercentage.getText());
        DiscountDTO discount = new DiscountDTO(did, percentage, date);
        try {
            boolean isAdded = discountBO.addDiscount(discount);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Added Successfully");
                discountTable.getItems().add(discount);
            }
        } catch (Exception ex) {
            Logger.getLogger(SpecialOffersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void renewDiscount(ActionEvent event) {
        String did = txtDid.getText();
        int percentage = Integer.parseInt(txtPercentage.getText());
        String date = datePicker.getValue().toString();

        DiscountDTO discountDTO = new DiscountDTO(did, percentage, date);
        try {
            boolean isUpdated = discountBO.updateDiscount(discountDTO);

            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                discountTable.getItems().add(discountDTO);
            } else {
                JOptionPane.showMessageDialog(null, "Process failed");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void searchDiscount(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            DiscountDTO movie = discountBO.searchDiscount(txtDid.getText());
            if (movie != null) {
                txtPercentage.setText(Integer.toString(movie.getPercentage()));
                datePicker.setValue(LocalDate.parse(movie.getDate(), dtf));
            } else {
                JOptionPane.showMessageDialog(null, "No such discount");
                boolean isValidate = Validation.validDiscountID(txtDid.getText());
                if (isValidate) {
                    datePicker.requestFocus();
                } else {
                    txtDid.setText("");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(SpecialOffersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void focusPercentage(ActionEvent event) {
        txtPercentage.requestFocus();
    }

    @FXML
    private void activateSave(ActionEvent event) {
        count = ++count;

        boolean isValidate = Validation.validPercentage(txtPercentage.getText());
        if (isValidate) {

            if (txtDid.getText() != null && datePicker.getValue() != null && txtPercentage.getText() != null && count % 2 != 0) {
                saveDiscount.setDisable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Check whether every field is filled");
            }
        } else {
            txtPercentage.setText("");
        }
    }

    @FXML
    private void viewHome(MouseEvent event) {
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/home2.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllDiscount() {
        try {
            ArrayList<DiscountDTO> allDiscount = discountBO.getAllDiscounts();
            discountTable.setItems(FXCollections.observableArrayList(allDiscount));
        } catch (Exception ex) {
            Logger.getLogger(SpecialOffersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getLatestDiscount() {
        try {
            ArrayList<DiscountDTO> allDiscount = discountBO.getLatest();
            lblDid.setText(allDiscount.get(0).getDid());
            lblPercentage.setText(Integer.toString(allDiscount.get(0).getPercentage()));
            lblDate.setText(allDiscount.get(0).getDate());
        } catch (Exception ex) {
            Logger.getLogger(SpecialOffersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
