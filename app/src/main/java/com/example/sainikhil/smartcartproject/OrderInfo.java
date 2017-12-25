package com.example.sainikhil.smartcartproject;

/**
 * Created by SaiNikhil on 10/15/2017.
 */

public class OrderInfo {
    String uid;
    String item_name;
    String item_price;

    public OrderInfo() {
    }

    public OrderInfo(String uid, String item_name, String item_price) {
        this.uid = uid;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public String getuid() {
        return uid;
    }

    public void setuid(String uid) {
        this.uid = uid;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }
}
