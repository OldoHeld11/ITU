package itupos.fit.cz.itupos;

import java.util.ArrayList;

public class Orders{
    private ArrayList<Order> orders;

    public Orders() {
        this.orders = new ArrayList<Order>();
    }

    public Integer getOrdersCount(){
        return orders.size();
    }

    // if there is already order with the same name then sum amounts but do not create new one
    public void setOrder(String name, Integer amount){
        if(this.getOrder(name) == null) {
            orders.add(new Order(name, amount));
        }else{
            this.changeOrderAmount(name, this.getOrder(name).getAmount() + amount);
        }
    }

    public void removeOrder(String name){
        for(Order o : orders){
            if(o.getName().equals(name)){
                orders.remove(o);
            }
        }
    }

    // change amount to exact number
    public void changeOrderAmount(String name, Integer amount){
        for(Order o : orders){
            if(o.getName().equals(name)){
                if(amount <= 0){
                    orders.remove(o);
                }else{
                    o.setAmount(amount);
                }
            }
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
