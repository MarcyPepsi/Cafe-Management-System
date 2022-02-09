/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Client;
import model.Order;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class SalesViewController implements Initializable {

    @FXML
    private JFXTextField clientName;
    @FXML
    private JFXTextField clientPhone;
    @FXML
    private JFXTextField orderID;
    @FXML
    private TableView<Order> tableOfOrders;
    @FXML
    private TableColumn<Order, String> itemNameCol;
    @FXML
    private TableColumn<Order, Integer> unitpriceCol;
    @FXML
    private TableColumn<Order, Integer> quantityCol;
    @FXML
    private TableColumn<Order, Integer> priceCol;
    @FXML
    private JFXTextField total;
      @FXML
    private JFXTextField date;
    Order order;
    Client client;
    

    /**
     * Initializes the controller class.
     */
    public SalesViewController()
    {
        
    }
     public SalesViewController(Client client)
    {
      
      this.client = client;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //orderID.setText(String.valueOf(client.getOrderID()));
        date.setText(client.getDate().toString());
        
        clientName.setText(client.getClientName());
        clientPhone.setText(String.valueOf(client.getClientPhoneNumber()));
//        ArrayList< Order> orders = new ArrayList<>();
//        orders = client.getClientOrders();
        total.setText(String.valueOf(client.getBillTotal()));
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        unitpriceCol.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        
        
         tableOfOrders.setItems(FXCollections.observableArrayList(client.getClientOrders()));
    }    

    public static String displayDate(LocalDate date){
         String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String newDate = simpleDateFormat.format(date);
        return newDate;
     }
    
}
