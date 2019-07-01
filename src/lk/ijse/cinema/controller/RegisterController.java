/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lk.ijse.cinema.validaion.Validation;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RegisterController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private Button register;
    @FXML
    private ImageView closeWindow;
    @FXML
    private CheckBox confirm;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        register.setDisable(true);
    }    

    @FXML
    private void validateUserName(ActionEvent event) {
        boolean isValid=Validation.validUserName(username.getText());
        if(isValid){
            password.requestFocus();
        }else{
            username.setText("");
        }
    }

    @FXML
    private void validatePassword(ActionEvent event) {
        
        boolean isValid=Validation.validPassword(password.getText());
            if(isValid){
                confirmpassword.requestFocus();
            }else{
                 password.setText("");
            }
    }
    @FXML
    private void checkPassword(ActionEvent event) {
       if(confirmpassword.getText().equals(password.getText())){
           confirm.setSelected(true);
           register.setDisable(false);
       }else{
           JOptionPane.showMessageDialog(null,"Verify the password again");
           confirmpassword.setText("");
       }
       
    }

    @FXML
    private void viewHome(ActionEvent event) {
         try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/home2.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showLogin(MouseEvent event) {
    }
    
}
