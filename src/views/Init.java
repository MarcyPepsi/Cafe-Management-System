/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.FileManagement;
import java.io.IOException;

/**
 *
 * @author Marcy GADEU
 */
public class Init {
    public static void init() {
     try {
            FileManagement.getItems();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
     try {
            FileManagement.getItemID();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
    
     try {
            FileManagement.getClientID();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
      try {
            FileManagement.saveOrderID();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
      try {
            FileManagement.getOrders();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
    try {
            FileManagement.getClients();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
    try {
            FileManagement.getNumberOfClients();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
    try {
            FileManagement.getFinance();
        } catch (ClassNotFoundException | IOException ex) {
            

        }
    }
    
}
