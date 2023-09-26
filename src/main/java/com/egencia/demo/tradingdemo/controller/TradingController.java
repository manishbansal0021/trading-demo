package com.egencia.demo.tradingdemo.controller;

import com.egencia.demo.tradingdemo.model.Stock;
import com.egencia.demo.tradingdemo.model.User;
import com.egencia.demo.tradingdemo.service.ReactiveSources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TradingController {

    private final ReactiveSources reactiveSources;

    TradingController(ReactiveSources reactiveSources){
        this.reactiveSources = reactiveSources;
    }

    @GetMapping("/getStocks")
    public Flux<Stock> getStocks(){

        return reactiveSources.getStocks();

    }

    @GetMapping("/user/{userId}")
    public Mono<User> getUser(@PathVariable String userId){

        return reactiveSources.getUser(userId);

    }

    @GetMapping("/stockPrice/{stockId}")
    public Flux<Stock> getStockPricesEverySecond(@PathVariable String stockId){
        return reactiveSources.getStockPricesEverySecond(stockId);
    }

    @GetMapping("/userStockPrices/{userId}")
    public Flux<User> getUserDataWithStockPricesEverySecond(@PathVariable String userId) {
        return reactiveSources.getUserStockPriceUpdates(userId);
    }

}
