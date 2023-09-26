package com.egencia.demo.tradingdemo.service;

import com.egencia.demo.tradingdemo.model.Stock;
import com.egencia.demo.tradingdemo.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReactiveSources {

    public static Map<String, User> userMap = new HashMap<>();
    public static Map<String, Stock> stockMap = new HashMap<>();


    public ReactiveSources() {

        Stock stock1 = new Stock("1", "Stock A", "$100");
        stockMap.put(stock1.getId(), stock1);

        Stock stock2 = new Stock("2", "Stock B", "$200");
        stockMap.put(stock2.getId(), stock2);

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        User user = new User("1", "John", "Bank X", stocks);

        userMap.put(user.getId(), user);

    }


    public Mono<User> getUser(String userId){

        return Mono.just(userMap.get(userId));

    }

    public Flux<Stock> getStocks(){

        return Flux.fromStream(stockMap.values().stream()).delayElements(Duration.ofSeconds(1));
    }

    public Flux<Stock> getStockPricesEverySecond(String stockId){

        Stock stock = stockMap.get(stockId);

        return Flux.interval(Duration.ofSeconds(1))
                .flatMap( tick -> this.updateStockPrice(stock));

    }


    public Flux<User> getUserStockPriceUpdates(String userId) {

        User user = userMap.get(userId);

        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> {
                    List<Stock> updatedPortfolio = user.getStocks()
                            .stream()
                            .map(this::updateStockPrice)
                            .map(Mono::block)
                            .collect(Collectors.toList());

                    user.setStocks(updatedPortfolio);
                    return user;
                });

    }

    private Mono<Stock> updateStockPrice(Stock stock) {

        Random rand = new Random();
        int newPrice = rand.nextInt((1000 - 100) + 1) + 100;
        stock.setPrice("$"+newPrice);
        return Mono.just(stock);
    }

}
