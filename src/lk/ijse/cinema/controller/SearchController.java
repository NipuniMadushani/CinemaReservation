/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.model.DetailDTO;
import lk.ijse.cinema.validaion.Validation;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtSearch;
    @FXML
    private ComboBox<String> category;
    @FXML
    private TableView<Object> searchTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        category.getItems().addAll("Movie", "Director", "Show-time");
        searchTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        searchTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("start_time"));
        searchTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("director"));
        searchTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("duration"));
        searchTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("end_date"));
    }    

    @FXML
    private void viewData(KeyEvent event) {
            
            
            try {
                
                viewdetails(txtSearch.getText());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
     private void viewdetails(String name) throws SQLException,ClassNotFoundException{
         String SQL="";
         if(category.getSelectionModel().getSelectedItem().equals("Movie")){
            SQL="select name,director,start_time, duration,end_date from movie m,air a,shows s where m.mid=a.mid && a.sid=s.sid && name like '"+name+"%'";
         }else if(category.getSelectionModel().getSelectedItem().equals("Director")){
                SQL="select name,director,start_time, duration,end_date from movie m,air a,shows s where m.mid=a.mid && a.sid=s.sid && director like '"+name+"%'";
         }else{
                 SQL="select name,director,start_time, duration,end_date from movie m,air a,shows s where m.mid=a.mid && a.sid=s.sid && start_time like '"+name+"%'";
  
         }
            Connection conn=DBConnection.getInstance().getConnection();
            Statement stm=conn.createStatement();
            ResultSet rst=stm.executeQuery(SQL);
       
        ArrayList<Object> data=new ArrayList<>();
       
       while(rst.next()){
                    String Mname=rst.getString("name");
                    String time=rst.getTime("start_time").toString();
                    String director=rst.getString("director");
                    Double duration=rst.getDouble("duration");
                    String date=rst.getDate("end_date").toString();
                    DetailDTO dto = new DetailDTO(Mname, time, director, duration,date);
                    data.add(dto);   
        }
       
       searchTable.setItems(FXCollections.observableArrayList(data));
       
       }    
    
}
