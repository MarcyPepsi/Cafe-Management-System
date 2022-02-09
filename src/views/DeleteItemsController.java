/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.Database;
import dao.FileManagement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Item;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class DeleteItemsController implements Initializable {

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
    @FXML
    private TextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ItemIDCol.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        
         tableOfItems.setItems(FXCollections.observableArrayList(Database.listOfItem));
    }    

    @FXML
    private void deleteItems(ActionEvent event) {
        Item s = tableOfItems.getSelectionModel().getSelectedItem();
        if(s == null)
           {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setHeaderText("No item Selected");
               alert.setContentText("Please select an item before clicking on Delete");
               alert.showAndWait();
               return;
           }
        else{
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
               a.setHeaderText("Sure to delete?");
               a.setContentText("Are you sure you wish to delete the selected item?");
                a.resultProperty().addListener(new ChangeListener<ButtonType>(){
                @Override
                public void changed(ObservableValue<? extends ButtonType> observable, ButtonType oldValue, ButtonType newValue) {
                    if(newValue == ButtonType.OK)
                    {
                        tableOfItems.getItems().remove(s);
                        Database.listOfItem.remove(s);
                        try {
                            FileManagement.saveItems();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DeleteItemsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(DeleteItemsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
             
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Item Successfully delected");
               alert.setContentText("the iem has been successfully deleted");
               alert.showAndWait();

                        
                    }
                }
                    
                });
                a.showAndWait();
                       
                        
        }

    }
    

    @FXML
    private void searchAction(ActionEvent event) {
         performSearch(searchBar.getText());
    }
    private void performSearch(String searchKey)
    {
       
        ObservableList<Item> current = FXCollections.observableArrayList();
        Database.listOfItem.forEach(item ->{
            if(item.getItemName().toLowerCase().contains(searchKey.toLowerCase()))
                {
                    current.add(item);
                }
        });
        tableOfItems.setItems(current);
        tableOfItems.refresh();
                
    }
    @FXML
    private void keySearch(KeyEvent event) {
        performSearch(searchBar.getText());
    }
    
}
