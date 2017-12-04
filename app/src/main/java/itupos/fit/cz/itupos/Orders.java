package itupos.fit.cz.itupos;

import java.util.ArrayList;

public class Orders{
    private ArrayList<Order> orders;

    private int totalCost;

    public int getTotalCostToBePaid() {
        return totalCostToBePaid;
    }

    public void setTotalCostToBePaid(int totalCostToBePaid) {
        this.totalCostToBePaid = totalCostToBePaid;
    }

    private int totalCostToBePaid;

    public int getTotalCost() {
        return totalCost;
    }

    public Orders() {
        this.orders = new ArrayList<Order>(); this.totalCost = 0; this.totalCostToBePaid = 0;
    }

    public Integer getOrdersCount(){
        return orders.size();
    }

    // if there is already order with the same name then sum amounts but do not create new one
    public void setOrder(String name, Integer amount){
        if(amount <= 0){
            return;
        }
        if(this.getOrder(name) == null) {
            orders.add(new Order(name, amount));
            this.totalCost += this.getOrder(name).getTotalPrice();
        }else{
            this.changeOrderAmount(name, this.getOrder(name).getAmount() + amount);
        }
        if(!VariableSingleton.currentMyTable.isTaken())
            VariableSingleton.currentMyTable.setTaken(); // pridal Edo
    }

    public void removeOrder(String name){
        Order order = null;
        for(Order o : orders){
            if(o.getName().equals(name)){
                this.totalCost -= this.getOrder(name).getTotalPrice();
                order = o;
                break;
            }
        }
        if(order != null){
            orders.remove(order);
            if(orders.isEmpty()){
                VariableSingleton.currentMyTable.setFree(); // pridal Edo
            }
        }
    }

    // change amount to exact number
    public void changeOrderAmount(String name, Integer amount){
        for(Order o : orders){
            if(o.getName().equals(name)){
                if(amount == -1){
                    this.totalCost -= this.getOrder(name).getTotalPrice();
                    o.setAmount(amount);
                    return;
                }
                if(amount <= 0){
                    orders.remove(o);
                    if(orders.isEmpty()){
                        VariableSingleton.currentMyTable.setFree(); // pridal Edo
                    }
                } else {
                    // substract original price
                    this.totalCost -= this.getOrder(name).getTotalPrice();
                    o.setAmount(amount);
                    // add new total price
                    this.totalCost += this.getOrder(name).getTotalPrice();
                }
            }
        }
        if(orders.isEmpty()){
            VariableSingleton.currentMyTable.setFree(); // pridal Edo
        }
    }

    public ArrayList<Order> getAllOrders(){
        return orders;
    }

    public Order getOrder(String name){
        for(Order o : orders){
            if(o.getName().equals(name)){
                return o;
            }
        }
        return null;
    }
}
