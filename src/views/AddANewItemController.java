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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import model.Item;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class AddANewItemController implements Initializable {

    @FXML
    private JFXComboBox<String> comboxBoxCategory;
    @FXML
    private JFXTextField itemName;
    @FXML
    private JFXTextField price;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboxBoxCategory.getItems().addAll("Drinks","Food","Canteen","Bakery");
    }    

    @FXML
    private void AddANewItem(ActionEvent event) throws ClassNotFoundException, IOException {
        Item newItem = new Item();
        newItem.setCategory(comboxBoxCategory.getSelectionModel().getSelectedItem());
        newItem.setItemName(itemName.getText());
        newItem.setPrice(Integer.parseInt(price.getText()));
        newItem.setItemID(Database.itemID);
        Database.itemID++;
        Database.listOfItem.add(newItem);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Add Item");
        alert.setContentText("Item successfully added");
        alert.showAndWait();
        FileManagement.saveItemID();
        FileManagement.saveItems();
        //System.out.println("Added");
        
    }
    
}
