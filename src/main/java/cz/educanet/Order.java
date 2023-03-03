package cz.educanet;

import java.time.LocalDateTime;

public class Order {
    private int order_id;
    private int order_direction;
    private int amount;
    private int price;
    private int stock_market_id;
    private LocalDateTime created_at;


    public Order(int order_id, int order_direction, int amount, int price, int stock_market_id, LocalDateTime created_at) {
        this.order_id = order_id;
        this.order_direction = order_direction;
        this.amount = amount;
        this.price = price;
        this.stock_market_id = stock_market_id;
        this.created_at = created_at;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_direction() {
        return order_direction;
    }

    public void setOrder_direction(int order_direction) {
        this.order_direction = order_direction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock_market_id() {
        return stock_market_id;
    }

    public void setStock_market_id(int stock_market_id) {
        this.stock_market_id = stock_market_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
