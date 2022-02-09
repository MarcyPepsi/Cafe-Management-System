/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Client;
import model.Item;
import model.Order;

/**
 *
 * @author Marcy GADEU
 */
public class Database {
    public static ArrayList<Item> listOfItem = new ArrayList<Item>();
    public static ArrayList<Order> listOfOrders = new ArrayList<Order>();
    public static ArrayList<Client> listOfClients= new ArrayList<Client>();
    public static int itemID = 1;
    public static int orderID = 1;
    public static int clientID = 1;
    public static int numberOfClients = 0;
    public static int finance = 0;
    
}
