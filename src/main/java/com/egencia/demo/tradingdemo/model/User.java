package com.egencia.demo.tradingdemo.model;

import com.egencia.demo.tradingdemo.service.FluxStockSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import reactor.core.publisher.Flux;

import java.util.List;

public class User {

    String id;
    String name;
    String bankName;
//    @JsonSerialize(using = FluxStockSerializer.class)
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

//    public Flux<User> updateStock(Stock updatedStock) {
//        User updatedUser = new User(this.id, this.name, this.bankName, Flux.concat(this.stocks, Flux.just(updatedStock)));
//        return Flux.just(updatedUser);
//    }

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
