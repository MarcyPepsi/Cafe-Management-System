/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import dao.Database;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Item;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class WelcomeViewController implements Initializable {

    @FXML
    private StackPane containPane;
    @FXML
    private Label labelNberOfPurchases;
    @FXML
    private Label labelNberOfDrinks;
    @FXML
    private Label labelNberOfFood;
    @FXML
    private Label labelCanteen;
    @FXML
    private Label labelBakery;
    @FXML
    private Label labelFinance;
    @FXML
    private Label labelNberOfDrinks1;
    private StackPane contentStackPane;
    @FXML
    private JFXButton placeOrderBut;
    @FXML
    private JFXButton addItemsButton;
    @FXML
    private JFXButton updateItemBut;
    @FXML
    private JFXButton deleteItemBut;
    @FXML
    private JFXButton logoutBut;
    @FXML
    private JFXButton salesBut;
    ArrayList<String> listOfDrinks = new ArrayList<>();
    ArrayList<String> listOfFoods = new ArrayList<>();
    ArrayList<String> listOfBakery = new ArrayList<>();
    ArrayList<String> listOfCanten = new ArrayList<>();
     int drink;
     int food;
     int bakery;
     int canteen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contentStackPane = containPane;
       
        
        
      /*  for(Item item : Database.listOfItem)
        {
            if(item.getCategory().equals("Drinks")){
                listOfDrinks.add(item.getItemName());}
            else  if(item.getCategory().equals("Food")){
                listOfFoods.add(item.getItemName());
            }
            else  if(item.getCategory().equals("Canteen")){
                listOfCanten.add(item.getItemName());
            }
            else  if(item.getCategory().equals("Bakery")){
                listOfBakery.add(item.getItemName());
            }
        }*/
       /* labelNberOfDrinks.setText(String.valueOf(listOfDrinks.size()));
        labelNberOfFood.setText(String.valueOf(listOfFoods.size()));
        labelCanteen.setText(String.valueOf(listOfCanten.size()));
        labelBakery.setText(String.valueOf(listOfBakery.size()));
        labelFinance.setText(String.valueOf(Database.finance));
        
        labelNberOfPurchases.setText(String.valueOf(Database.numberOfClients));*/
        
    }

    @FXML
    private void placeOrder(ActionEvent event) throws IOException {
        contentStackPane.getChildren().clear();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("PlaceOrder.fxml"));
        Node node = fXMLLoader.load();
        contentStackPane.getChildren().add(node);
    }

    @FXML
    private void addItems(ActionEvent event) throws IOException {

        contentStackPane.getChildren().clear();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("AddANewItem.fxml"));
        Node node = fXMLLoader.load();
        contentStackPane.getChildren().add(node);
    }

    @FXML
    private void updateItems(ActionEvent event) throws IOException {
        contentStackPane.getChildren().clear();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("UpdateItems.fxml"));
        Node node = fXMLLoader.load();
        contentStackPane.getChildren().add(node);
    }

    @FXML
    private void deleteItems(ActionEvent event) throws IOException {
        contentStackPane.getChildren().clear();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("DeleteItems.fxml"));
        Node node = fXMLLoader.load();
        contentStackPane.getChildren().add(node);
    }

    @FXML
    private void logout(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("Sure to logout?");
        a.setContentText("Are you sure you wish to logout ?");
        a.resultProperty().addListener(new ChangeListener<ButtonType>() {
            @Override
            public void changed(ObservableValue<? extends ButtonType> observable, ButtonType oldValue, ButtonType newValue) {
                if (newValue == ButtonType.OK) {
                    try {
                        Parent tView = FXMLLoader.load(getClass().getResource("Login.fxml"));
                        Scene scene = new Scene(tView);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(scene);
                        window.centerOnScreen();
                        window.setResizable(false);
                        window.show();
                    } catch (IOException ex) {
                        Logger.getLogger(WelcomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });
        
        a.showAndWait();
    }

    @FXML
    private void changeColor(MouseEvent event) {
        if (event.getSource() == placeOrderBut) {
            placeOrderBut.setStyle("-fx-background-color: #33CC00; ");
            addItemsButton.setStyle("-fx-background-color: #ffa500; ");
            updateItemBut.setStyle("-fx-background-color:#ffa500 ; ");
            deleteItemBut.setStyle("-fx-background-color: #ffa500; ");
            logoutBut.setStyle("-fx-background-color: #ffa500; ");
            salesBut.setStyle("-fx-background-color: #ffa500; ");
            

        } else if (event.getSource() == addItemsButton) {
            addItemsButton.setStyle("-fx-background-color: #33CC00; ");
            placeOrderBut.setStyle("-fx-background-color: #ffa500; ");          
            updateItemBut.setStyle("-fx-background-color:#ffa500 ; ");
            deleteItemBut.setStyle("-fx-background-color: #ffa500; ");
            logoutBut.setStyle("-fx-background-color: #ffa500; ");
            salesBut.setStyle("-fx-background-color: #ffa500; ");

        } else if (event.getSource() == updateItemBut) {
            updateItemBut.setStyle("-fx-background-color: #33CC00; ");
            addItemsButton.setStyle("-fx-background-color: #;ffa500 ");
            placeOrderBut.setStyle("-fx-background-color: #ffa500; ");
           
           // updateItemBut.setStyle("-fx-background-color:#ffa500 ; ");
            deleteItemBut.setStyle("-fx-background-color: #ffa500; ");
            logoutBut.setStyle("-fx-background-color: #ffa500; ");
            salesBut.setStyle("-fx-background-color: #ffa500; ");
            

        } else if (event.getSource() == deleteItemBut) {
            deleteItemBut.setStyle("-fx-background-color: #33CC00; ");
            addItemsButton.setStyle("-fx-background-color: #ffa500; ");
            placeOrderBut.setStyle("-fx-background-color: #ffa500; ");          
            updateItemBut.setStyle("-fx-background-color:#ffa500 ; ");
            //deleteItemBut.setStyle("-fx-background-color: #ffa500; ");
            logoutBut.setStyle("-fx-background-color: #ffa500; ");
            salesBut.setStyle("-fx-background-color: #ffa500; ");

        } else if (event.getSource() == logoutBut) {
            logoutBut.setStyle("-fx-background-color: #33CC00; ");
            placeOrderBut.setStyle("-fx-background-color: #ffa500; ");
            addItemsButton.setStyle("-fx-background-color: #ffa500; ");
            updateItemBut.setStyle("-fx-background-color:#ffa500 ; ");
            deleteItemBut.setStyle("-fx-background-color: #ffa500; ");
            salesBut.setStyle("-fx-background-color: #ffa500; ");
            //logoutBut.setStyle("-fx-background-color: #ffa500; ");

        }
        else if(event.getSource() == salesBut)
        {
           salesBut.setStyle("-fx-background-color: #33CC00; ");
            placeOrderBut.setStyle("-fx-background-color: #ffa500; ");
            addItemsButton.setStyle("-fx-background-color: #ffa500; ");
            updateItemBut.setStyle("-fx-background-color:#ffa500 ; ");
            deleteItemBut.setStyle("-fx-background-color: #ffa500; ");
            logoutBut.setStyle("-fx-background-color: #ffa500; "); 
        }
    }

    @FXML
    private void seeSales(ActionEvent event) throws IOException {
        contentStackPane.getChildren().clear();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("ShowSalesView.fxml"));
        Node node = fXMLLoader.load();
        contentStackPane.getChildren().add(node);
    }

}
