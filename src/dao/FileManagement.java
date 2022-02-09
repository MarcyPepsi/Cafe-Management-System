/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.Client;
import model.Item;
import model.Order;

/**
 *
 * @author Marcy GADEU
 */
public class FileManagement {
     public static void saveItems() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\item.dat", false));) {
            // Write arrays to the object output stream
            output.writeObject(Database.listOfItem);
        }
    }

    public static void getItems() throws ClassNotFoundException, IOException {
     try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\item.dat"));) 
        {
            Database.listOfItem.clear();
            List<Item> list = (List<Item>) (input.readObject());
            if(list != null)
                Database.listOfItem.addAll(list);
        }
    }
    public static void saveItemID() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\itemID.dat", false));) {
            // Write arrays to the object output stream
            
            output.writeObject(Database.itemID);
        }
    }
    public static void getItemID() throws ClassNotFoundException, IOException {
      try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\itemID.dat"));) 
        {
           Database.itemID = (int)input.readObject();
        } 
    }
    public static void saveOrderID() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\orderID.dat", false));) {
            // Write arrays to the object output stream
            
            output.writeObject(Database.orderID);
        }
    }
    public static void getOrderID() throws ClassNotFoundException, IOException {
      try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\orderID.dat"));) 
        {
           Database.orderID = (int)input.readObject();
        } 
    }
    public static void saveClientID() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\clientID.dat", false));) {
            // Write arrays to the object output stream
            
            output.writeObject(Database.clientID);
        }
    }
    public static void getClientID() throws ClassNotFoundException, IOException {
      try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\clientID.dat"));) 
        {
           Database.clientID = (int)input.readObject();
        } 
    }
    public static void saveFinance() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\finance.dat", false));) {
            // Write arrays to the object output stream
            
            output.writeObject(Database.finance);
        }
    }
    public static void getFinance() throws ClassNotFoundException, IOException {
      try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\finance.dat"));) 
        {
           Database.finance = (int)input.readObject();
        } 
    }
    public static void saveNumberOfClients() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\clientNumber.dat", false));) {
            // Write arrays to the object output stream
            
            output.writeObject(Database.numberOfClients);
        }
    }
    public static void getNumberOfClients() throws ClassNotFoundException, IOException {
      try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\clientNumber.dat"));) 
        {
           Database.numberOfClients = (int)input.readObject();
        } 
    }
    public static void saveOrder() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\order.dat", false));) {
            // Write arrays to the object output stream
            output.writeObject(Database.listOfOrders);
        }
    }

    public static void getOrders() throws ClassNotFoundException, IOException {
     try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\order.dat"));) 
        {
            Database.listOfOrders.clear();
            List<Order> list = (List<Order>) (input.readObject());
            if(list != null)
                Database.listOfOrders.addAll(list);
        }
    }
    public static void saveClients() throws ClassNotFoundException, IOException {
        try ( // Create an output stream for file array.dat
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\dao\\client.dat", false));) {
            // Write arrays to the object output stream
            output.writeObject(Database.listOfClients);
        }
    }

    public static void getClients() throws ClassNotFoundException, IOException {
     try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("src\\dao\\client.dat"));) 
        {
            Database.listOfClients.clear();
            List<Client> list = (List<Client>) (input.readObject());
            if(list != null)
                Database.listOfClients.addAll(list);
        }
    }
    
}
