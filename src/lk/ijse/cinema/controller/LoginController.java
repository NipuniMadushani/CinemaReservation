/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.awt.Event;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lk.ijse.cinema.business.custom.UserBO;
import lk.ijse.cinema.business.custom.impl.UserBOImpl;
import lk.ijse.cinema.model.MovieDTO;
import lk.ijse.cinema.model.UserDTO;
import lk.ijse.cinema.validaion.Validation;

/**
 *
 * @author User
 */
public class LoginController implements Initializable {
    
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane subroot;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label register;
    @FXML
    private Label lbllogin;
    
    private static UserBO userBO=new UserBOImpl();
    
    @FXML
    void viewRegForm(MouseEvent event) {
        try {

            /*Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/register.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.subroot.getScene().getWindow();
            stage.setScene(s);*/
           
            
            AnchorPane newLoadedPane =FXMLLoader.load(getClass().getResource("/lk/ijse/cinema/view/register2.fxml"));
            subroot.getChildren().add(newLoadedPane); 
            lbllogin.setText("Register");


        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       login.setDisable(true);

    }
    
    @FXML 
    private void validateUsername(ActionEvent event){
        boolean isValid=Validation.validUserName(username.getText());
        if(isValid){
            password.requestFocus();
        }else{
            username.setText("");
        }
    }
    @FXML 
    private void validatePassword(ActionEvent event){
        try {
            /*boolean isValid=Validation.validPassword(password.getText());
            if(isValid){
            if(username.getText().equals(password.getText())){
            login.requestFocus();
            }else{
            JOptionPane.showMessageDialog(null, "Username-Password mismatch");
            username.setText("");
            password.setText("");
            username.requestFocus();
            }
            }else{
            password.setText("");
            
            }*/
            // UserDTO user=userBO.
            UserDTO user=userBO.searchUser(username.getText());
            if(user!=null){
                if(user.getPassword().equals(password.getText())){
                    login.setDisable(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Username,Password mis-match");
                    password.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null,"No such user.Register now");
                
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
