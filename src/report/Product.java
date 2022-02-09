/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Order;

/**
 *
 * @author Marcy GADEU
 */
public class Product {
   
     private String pname;
     private int price;
     private int qty;
     private int amount;
 private LocalDate date;

    public Product(String pname, int price, int qty, int amount) {
        this.pname = pname;
        this.price = price;
        this.qty = qty;
        this.amount = amount;
        
    }
 
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String LocalDate) {
        this.date = date;
    }

   
     
    
}
