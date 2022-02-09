/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.Database;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import model.Client;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class ShowSalesViewController implements Initializable {
int i = 0;
    @FXML
    private VBox displaySales;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            load();
        } catch (IOException ex) {
            Logger.getLogger(ShowSalesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            }
     public void load() throws IOException
     {
         
        for(Client cl: Database.listOfClients)
            {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SalesView.fxml"));
               SalesViewController controller = new SalesViewController(cl);
              loader.setController(controller);
            
                displaySales.getChildren().add(loader.load());
            i++; 
            }
            
     }
    }    
    

