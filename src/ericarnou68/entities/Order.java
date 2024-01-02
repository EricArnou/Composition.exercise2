package ericarnou68.entities;

import ericarnou68.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate moment;
    private OrderStatus status;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    public Order(LocalDate moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public Double total(){
        double totalValue = 0;

        for(OrderItem item: orderItems){
            totalValue+= item.subTotal();
        }
        return totalValue;
    }
    @Override
    public String toString(){
        return ("ORDER SUMMARY" +
                "\nOrder moment: " + getMoment() +
                "\nOrder status: " + getStatus() +
                "\nClient: " + client +
                "\nOrder Items: " + orderItems +
                "\nTotal price: " + total());
    }
}
