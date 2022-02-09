/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jaspersoft.ireport.designer.compiler.JasperReportErrorHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import net.sf.jasperreports.engine.JasperCompileManager;
import dao.Database;
import dao.FileManagement;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Client;
import model.Item;
import model.Order;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import report.Product;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class PlaceOrderController implements Initializable {

    @FXML
    private Label labelNberOfDrinks1;
    @FXML
    private JFXComboBox<String> comboxBoxCategory;
    @FXML
    private JFXTextField itemName;
    @FXML
    private TableColumn<Order, String> itemNameCol;
    @FXML
    private TableColumn<Order, Integer> priceCol;
    @FXML
    private JFXTextField searchBar;
    @FXML
    private JFXTextField price;
    @FXML
    private Spinner<Integer> snipper;
    @FXML
    private JFXTextField total;
   
    @FXML
    private Label grandTotal;
    @FXML
    private JFXListView<String> listOfItems;
    @FXML
    private JFXTextField clientName;
    @FXML
    private JFXTextField clientPhone;
     private ArrayList<String> currentListOfItems = new ArrayList<>();
    @FXML
    private TableColumn<Order, Integer> unitpriceCol;
    @FXML
    private TableColumn<Order, Integer> quantityCol;
    @FXML
    private TableView<Order> tableOfOrders;
      @FXML
    private JFXButton btnPrint;
   // private ArrayList<Order> listOfOrders = new ArrayList<>();
     Client client = new Client();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final int initialValue = 0;
        grandTotal.setText(String.valueOf(0));
        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, initialValue);
 
        snipper.setValueFactory(valueFactory);
         comboxBoxCategory.getItems().addAll("Drinks","Food","Canteen","Bakery");
        
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        unitpriceCol.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        
        
         tableOfOrders.setItems(FXCollections.observableArrayList(client.getClientOrders()));
    }    

   

    @FXML
    private void snipperClicked(MouseEvent event) {
        int q = snipper.getValue();
        int pr = Integer.parseInt(price.getText());
        int tot = pr*q;
        total.setText(String.valueOf(tot));
        //grandTotal.setText();
    }

    @FXML
    private void addToCart(ActionEvent event) throws ClassNotFoundException, IOException {
        Order order = new Order();
        order.setItemName(itemName.getText());
        order.setQuantity(snipper.getValue());
        order.setUnitprice(Integer.parseInt(price.getText()));
        order.setTotal(Integer.parseInt(total.getText()));
        order.setOrderID(Database.orderID);
        Database.listOfOrders.add(order);
        client.getClientOrders().add(order);
        
                
        tableOfOrders.setItems(FXCollections.observableArrayList(client.getClientOrders()));
        int total1 =Integer.parseInt(grandTotal.getText());
        int total2 = order.getTotal();
        int gtotal = total1+total2;
        grandTotal.setText(String.valueOf(gtotal));
        Database.orderID++;
        FileManagement.saveOrder();
        FileManagement.saveOrderID();
                
    }

    @FXML
    private void removeOrder(ActionEvent event) {
        Order s = tableOfOrders.getSelectionModel().getSelectedItem();
        if(s == null)
           {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setHeaderText("No order Selected");
               alert.setContentText("Please select an order before clicking on Delete");
               alert.showAndWait();
               return;
           }
        else{
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
               a.setHeaderText("Sure to delete?");
               a.setContentText("Are you sure you wish to delete the selected order?");
                a.resultProperty().addListener(new ChangeListener<ButtonType>(){
                @Override
                public void changed(ObservableValue<? extends ButtonType> observable, ButtonType oldValue, ButtonType newValue) {
                    if(newValue == ButtonType.OK)
                    {
                        tableOfOrders.getItems().remove(s);
                        Database.listOfOrders.remove(s);
                        client.getClientOrders().remove(s);
                        int totalremove = Integer.parseInt(grandTotal.getText()) - s.getTotal();
                        grandTotal.setText(String.valueOf(totalremove));
                        try {
                            FileManagement.saveOrder();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
                        }
             
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Student Successfully delected");
               alert.setContentText("the student has been successfully deleted");
               alert.showAndWait();

                        
                    }
                }
                    
                });
                a.showAndWait();
                       
                        
        }
    }

    @FXML
    private void printOrder(ActionEvent event)throws ClassNotFoundException, JRException {
        priceInvoice();
    }

    @FXML
    private void itemSelected(MouseEvent event) {
        Item item = new Item();
        System.out.println(listOfItems.getSelectionModel().getSelectedItem());
        for(Item it : Database.listOfItem)
        {
          
            if(listOfItems.getSelectionModel().getSelectedItem().equals(it.getItemName()))
            {
                itemName.setText(it.getItemName());
                 price.setText(String.valueOf(it.getPrice()));
            }
        }
        
    }

    @FXML
    private void addListOfOrder(ActionEvent event) throws ClassNotFoundException, IOException {
       
       
        LocalDate date =LocalDate.now();
        client.setClientID(Database.clientID);
       client.setClientName(clientName.getText());
       client.setClientPhoneNumber(Integer.parseInt(clientPhone.getText()));
       client.setDate(date);
       client.setBillTotal(Integer.parseInt(grandTotal.getText()));
       Database.clientID++;
       Database.listOfClients.add(client);
       
       Database.numberOfClients++;
       Database.finance = Database.finance+Integer.parseInt(grandTotal.getText());
       FileManagement.saveClients();
       FileManagement.saveClientID();
       FileManagement.saveNumberOfClients();
       FileManagement.saveFinance();
       
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Order Successfully Added");
               alert.setContentText("You have successfuly register the clientOrder");
               alert.showAndWait();
               
               }
    @FXML
    private void searchAction(ActionEvent event) {
         performSearch(searchBar.getText());
    }
    private void performSearch(String searchKey)
    {
       
        ObservableList<String> current = FXCollections.observableArrayList();
        currentListOfItems.forEach(item ->{
            if(item.toLowerCase().contains(searchKey.toLowerCase()))
                {
                    current.add(item);
                }
        });
        listOfItems.setItems(current);
        listOfItems.refresh();
                
    }
    @FXML
    private void keySearch(KeyEvent event) {
        performSearch(searchBar.getText());
    }

    @FXML
    private void selectedCategory(ActionEvent event) {
       
        //String category = comboxBoxCategory.getSelectionModel().getSelectedItem();
          ArrayList<String> items = new ArrayList<>();
//        listOfItems.getItems().clear();
//        listOfItems.refresh();
        for(Item item : Database.listOfItem)
        {
            if( comboxBoxCategory.getSelectionModel().getSelectedItem().equals(item.getCategory()))
            {
                currentListOfItems.add(item.getItemName());
               listOfItems.getItems().clear();
                listOfItems.setItems(FXCollections.observableArrayList(currentListOfItems));
                listOfItems.refresh();
            }
        }
        currentListOfItems.clear();
    }
    private void priceInvoice()
    {
       
        try {
            JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Marcy GADEU\\Documents\\NetBeansProjects\\CafeManagementSystem\\src\\report\\invoices.jasper");
            //JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\Marcy GADEU\\Documents\\NetBeansProjects\\CafeManagementSystem\\src\\report\\invoices.jrxml");
            HashMap<String, Object> para = new HashMap<>();
            para.put("cashier", "marcy");
            ArrayList<Product> productList = new  ArrayList<Product>();
            for(Order od: client.getClientOrders())
            {
               productList.add(new Product(od.getItemName(), od.getUnitprice(), od.getQuantity(),od.getTotal()));
            }
            JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(productList);
            JasperPrint jp = JasperFillManager.fillReport(jr, para,jcs);
            JasperViewer.viewReport(jp);
            
            
            
        } catch (JRException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void printReceipt () throws JRException
{
    
    String source ="C:\\Users\\Marcy GADEU\\Documents\\NetBeansProjects\\CafeManagementSystem\\src\\report\\invoices.jrxml"; 
    JasperReport jr = JasperCompileManager.compileReport(source);
    JRDataSource jRDataSource = new JREmptyDataSource();
    JasperPrint jasperPrint = JasperFillManager.fillReport(jr,null,jRDataSource);
    JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Marcy GADEU\\Documents\\NetBeansProjects\\CafeManagementSystem\\src\\report\\invoices.pdf");
    
            
    
}
        
}
