package com.egencia.demo.tradingdemo.model;

import java.util.List;

public class User {

    String id;
    String name;
    String bankName;
    List<Stock> stocks;

    public User(String id, String name, String bankName, List<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.bankName = bankName;
        this.stocks = stocks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", stocks=" + stocks +
                '}';
    }
}
