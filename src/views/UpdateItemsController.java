/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.Database;
import dao.FileManagement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Item;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class UpdateItemsController implements Initializable {

    @FXML
    private JFXTextField searchBar;
    @FXML
    private JFXComboBox<String> comboxBoxCategory;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField itemName;
    @FXML
    private TableView<Item> tableOfItems;
   @FXML
    private TableColumn<Item, Integer> ItemIDCol;
    @FXML
    private TableColumn<Item, String> categoryCol;
    @FXML
    private TableColumn<Item, String> itemNameCol;
    @FXML
    private TableColumn<Item, Integer> priceCol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboxBoxCategory.getItems().addAll("Drinks","Food","Canteen","Bakery");
        ItemIDCol.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableOfItems.setStyle("-fx-background-color: #33CC00; ");
        
         tableOfItems.setItems(FXCollections.observableArrayList(Database.listOfItem));
    }    

    @FXML
    private void UpdateItem(ActionEvent event) throws ClassNotFoundException, IOException {
        Item item = tableOfItems.getSelectionModel().getSelectedItem();
        Item newItem = new Item();
        newItem.setItemID(item.getItemID());
        Database.listOfItem.remove(item);
        
        newItem.setCategory(comboxBoxCategory.getSelectionModel().getSelectedItem());
        newItem.setItemName(itemName.getText());
        newItem.setPrice(Integer.parseInt(price.getText()));
       // newItem.setItemID(Database.itemID);
        
        Database.listOfItem.add(newItem);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Update Item");
        alert.setContentText("Item successfully updated");
        alert.showAndWait();
        
        FileManagement.saveItems();
        tableOfItems.setItems(FXCollections.observableArrayList(Database.listOfItem));
        
    }


    @FXML
    private void clickOnTable(MouseEvent event) {
         Item item = tableOfItems.getSelectionModel().getSelectedItem();
        comboxBoxCategory.setPromptText(item.getCategory());
        itemName.setText(item.getItemName());
        price.setText(String.valueOf(item.getPrice())); 
    }
    
}
