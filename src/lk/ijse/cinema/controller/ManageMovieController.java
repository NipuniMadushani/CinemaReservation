/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.awt.image.BufferedImage;
import java.io.File;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;
import lk.ijse.cinema.business.custom.MovieBO;
import lk.ijse.cinema.business.custom.impl.MovieBOImpl;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.model.AirDTO;
import lk.ijse.cinema.model.MovieDTO;
import lk.ijse.cinema.validaion.Validation;

/**
 *
 * @author User
 */
   

   
public class ManageMovieController implements Initializable {
     @FXML
    private DatePicker datePicker;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtMovieId;

    @FXML
    private TextField txtMovieName;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtDirector;

    @FXML
    private Label lblAddMovie;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<MovieDTO> movieTable;

    @FXML
    private DatePicker datePicker1;


    @FXML
    private TextField txtDuration;

    @FXML
    private ImageView home;
    @FXML
    private AnchorPane root;
    @FXML
    private RadioButton show1;

    @FXML
    private RadioButton show3;

    @FXML
    private RadioButton show2;

    @FXML
    private RadioButton show4;
    
    private int count=0;
    
    private static  MovieBO movieBO = new MovieBOImpl();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         try {
            movieTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            movieTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            movieTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("genre"));
            movieTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("director"));
            movieTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("releasedDate"));
            movieTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("endDate"));
            movieTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("duration"));
            loadAllMovies();
            btnSave.setDisable(true);
            
        } catch (Exception ex) {
            Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      @FXML
    void saveMovie(ActionEvent event) {
       String id=txtMovieId.getText();
        ArrayList<AirDTO> airdto=new ArrayList<>();
        if(show1.isSelected()){
            AirDTO air=new AirDTO(id,"s01");
            airdto.add(air);
        }
        if(show2.isSelected()){
            AirDTO air=new AirDTO(id,"s02");
            airdto.add(air);
        }
        if(show3.isSelected()){
            AirDTO air=new AirDTO(id,"s03");
            airdto.add(air);
        }
        if(show4.isSelected()){
            AirDTO air=new AirDTO(id,"s04");
            airdto.add(air);
        }
        String name=txtMovieName.getText();
        String genre=txtGenre.getText();
        String director=txtDirector.getText();
        String releasedDate=datePicker.getValue().toString();
        String endDate=datePicker1.getValue().toString();
        double duration=Double.parseDouble(txtDuration.getText());
        MovieDTO movieDTO=new MovieDTO(id,name,genre,director,releasedDate,endDate,duration,airdto);
        try{
            boolean isAdded=movieBO.addMovie(movieDTO);
            
            if(isAdded){
                JOptionPane.showMessageDialog(null,"Added Successfully");
                movieTable.getItems().add(movieDTO);
            }else{
                JOptionPane.showMessageDialog(null,"Process failed");
               
            }
        }catch(Exception ex){
            Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    }

    @FXML
    void clearFields(MouseEvent event) {
        clear();
    }
    public void clear(){
        txtMovieId.setText(null);
        txtMovieName.setText(null);
        txtGenre.setText(null);
        txtDirector.setText(null);
        datePicker.setValue(null);
        datePicker1.setValue(null);
        txtDuration.setText(null);
    }

    @FXML
    void deleteMovie(ActionEvent event) {
        String id=txtMovieId.getText();
        
         try {
             boolean isDeleted=movieBO.deleteMovie(id);
             
             if(isDeleted){
                 JOptionPane.showMessageDialog(null,"Deleted");
                 clear();
             }
         } catch (Exception ex) {
             Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        

    }
    

    @FXML
    void updateMovie(ActionEvent event) {
        String id=txtMovieId.getText();
        String name=txtMovieName.getText();
        String genre=txtGenre.getText();
        String director=txtDirector.getText();
        String releasedDate=datePicker.getValue().toString();
        String endDate=datePicker1.getValue().toString();
        double duration=Double.parseDouble(txtDuration.getText());
        MovieDTO movieDTO=new MovieDTO(id,name,genre,director,releasedDate,endDate,duration);
        try{
            boolean isUpdated=movieBO.updateMovie(movieDTO);
            
            if(isUpdated){
                JOptionPane.showMessageDialog(null,"Updated Successfully");
                movieTable.getItems().add(movieDTO);
            }else{
                JOptionPane.showMessageDialog(null,"Process failed");
            }
        }catch(Exception ex){
            Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    @FXML
    void viewHome(MouseEvent event) {
        try {

            Parent p = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cinema/view/home2.fxml"));
            Scene s = new Scene(p);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(s);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
              
    
           

    private void loadAllMovies()  {
       
        try {
            ArrayList<MovieDTO> allMovies =movieBO.getAllMovies();

            movieTable.setItems(FXCollections.observableArrayList(allMovies));

        } catch (Exception ex) {
            Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void validateGenre(ActionEvent event) {
        boolean isValidate=Validation.validName(txtGenre.getText());
        if(isValidate){
            txtDirector.requestFocus();
        }else{
            txtGenre.setText("");
        }
    }

    @FXML
    void validateMovieID(ActionEvent event) {
        boolean isValidate=Validation.validMovieID(txtMovieId.getText());
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                MovieDTO movie=movieBO.searchMovie(txtMovieId.getText());
                if(movie==null){
                    JOptionPane.showMessageDialog(null, "No such movie");
                    if(isValidate){   
                        txtMovieName.requestFocus();
                    }else{
                        txtMovieId.setText("");
                    }
                }else{
                    txtMovieName.setText(movie.getName());
                    txtGenre.setText(movie.getGenre());
                    txtDirector.setText(movie.getDirector());
                    datePicker.setValue(LocalDate.parse(movie.getReleasedDate(),dtf));
                    datePicker1.setValue(LocalDate.parse(movie.getEndDate(),dtf));
                    txtDuration.setText(Double.toString(movie.getDuration()));
                    ArrayList<String> sids=searchAir(txtMovieId.getText());
                    for(String sid:sids){
                        
                        if(sid.equals("s01")){
                            show1.setSelected(true);   
                        }
                        if(sid.equals("s02")){
                            show2.setSelected(true);   
                        }
                        if(sid.equals("s03")){
                            show3.setSelected(true);   
                        }
                        if(sid.equals("s04")){
                            show4.setSelected(true);   
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageMovieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }

    @FXML
    void validateMovieName(ActionEvent event) {
        boolean isValidate=Validation.validMovieName(txtMovieName.getText());
        if(isValidate){
            txtGenre.requestFocus();
        }else{
            txtMovieName.setText("");
        }
    }

    @FXML
    void validatePersonName(ActionEvent event) {
        boolean isValidate=Validation.validDirector(txtDirector.getText());
        if(isValidate){
            datePicker.requestFocus();
        }else{
            txtDirector.setText("");
        }
    }
     @FXML
    
    void validateDuration(ActionEvent event) {
        count=++count;
        boolean isValidate=Validation.validDuration(txtDuration.getText());
        if(isValidate ){
            if(txtMovieId.getText()!=null && txtMovieName.getText()!=null && txtGenre.getText()!=null && txtDirector.getText()!=null && txtDuration.getText()!=null && count%2!=0){
                btnSave.setDisable(false);
            }else{
                JOptionPane.showMessageDialog(null,"Every information should be filled");
            }
        
        }else{
            txtDuration.setText("");
        }
    }
    @FXML
    private void validateRDate(ActionEvent event){
        datePicker1.requestFocus();
        
        
    }
    @FXML
    private void validateEDate(ActionEvent event){
        txtDuration.requestFocus();
        
    }
    public ArrayList<String> searchAir(String mid) throws ClassNotFoundException,SQLException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select sid from air where mid='"+mid+"'");
        ArrayList<String> sids=new ArrayList<>();
        while(rst.next()){
            sids.add(rst.getString("sid"));
        }
        return sids;
    }
    
}
