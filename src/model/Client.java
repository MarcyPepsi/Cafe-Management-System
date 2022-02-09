/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marcy GADEU
 */
public class Client implements Serializable {

    private int clientID;

    private String clientName;
    private int clientPhoneNumber;
    private ArrayList<Order> clientOrders = new ArrayList<>();
    private int billTotal;
    private LocalDate date;

    public Client() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getClientID() {
        return clientID;
    }

    public int getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(int billTotal) {
        this.billTotal = billTotal;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(int clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public ArrayList<Order> getClientOrders() {
        return clientOrders;
    }

    public void setClientOrders(ArrayList<Order> clientOrders) {
        this.clientOrders = clientOrders;
    }

}
